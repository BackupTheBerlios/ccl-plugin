import org.python.util.*;
import org.python.core.*;
import java.io.*;
import java.util.*;
import java.lang.reflect.*;

public class JythonWrapper {

    public static void main(String[] args) throws Exception {
        Collection wrapperArgs = new ArrayList();
        Collection wrappedArgs = new ArrayList();
        int wrappedArgsCount = 0;

        boolean wrapper = true;
        for (int i=0; i<args.length; i++) {
            String arg = args[i];
            if (wrapper && "--".equals(arg)) {
                wrapper = false; continue;
            }

            if (wrapper) {
                wrapperArgs.add(arg);
            } else {
                wrappedArgs.add(arg);
                ++wrappedArgsCount;
            }
        }

        String wrappedMainClassName = null;
        String scriptFileName = null;
        String outputFileName = null;
        boolean doGUIConsole = true;
        String cacheDirName = null;

        boolean scriptFileNameAhead = false;
        boolean outputFileNameAhead = false;
        boolean cacheDirNameAhead = false;
        for (Iterator it = wrapperArgs.iterator(); it.hasNext();) {
            String arg = (String)it.next();

            if (scriptFileNameAhead) {
                scriptFileName = arg;
                scriptFileNameAhead = false;
            } else if (outputFileNameAhead) {
                outputFileName = arg;
                outputFileNameAhead = false;
            } else if (cacheDirNameAhead) {
                cacheDirName = arg;
                cacheDirNameAhead = false;
            } else if ("-i".equals(arg)) {
                scriptFileNameAhead = true;
            } else if ("-o".equals(arg)) {
                outputFileNameAhead = true;
            } else if ("-c".equals(arg)) {
                cacheDirNameAhead = true;
            } else {
                wrappedMainClassName = arg;
            }
        }

        if (wrappedMainClassName == null) {
            System.err.println("usage: java JythonWrapper WrappedClass [-i script -o output] [-- [wrapperArgs ...]]");
            System.err.println("");
            System.err.println("Start a Jython interpreter which either reads its commands from <script>");
            System.err.println("and writes results to <output>, or");
            System.err.println("(default) uses a GUI console. Then start <WrappedClass> in the same JVM,");
            System.err.println("passing it <wrapperArgs ...> on the command line.");
            System.exit(-1);
        }



        Reader in = null;
        Writer out = null;
        if (scriptFileName != null) {
            in = new BufferedReader(new InputStreamReader(new FileInputStream(scriptFileName)));
            out = new OutputStreamWriter(new FileOutputStream(outputFileName));
        }
        else {
            //TODO: GUI-Console...
            //in = ...
            //out = ...
            System.err.println("The GUI console is not yet implemented. Sorry!");
            System.exit(-1);
        }


        String[] wrappedArgsArr = new String[wrappedArgsCount];
        int i=0;
        for (Iterator it = wrappedArgs.iterator(); it.hasNext();) {
            wrappedArgsArr[i++] = (String)it.next();
        }

        Class wrappedMainClass = Class.forName(wrappedMainClassName);
        Method mainMethod = wrappedMainClass.getMethod("main",
                                                       new Class[]{(new String[0]).getClass()});

        if (cacheDirName != null) {
            Properties props = new Properties();
            props.put("python.cachedir",cacheDirName);
            PySystemState.initialize(System.getProperties(),
                                     props, null);
        } else {
            System.err.println("warning: No jython cache dir specified. Imports might not work, rendering jython quit useless...");
        }

        Thread interpThread = new Thread(new InterpreterRunner(in,out));
        interpThread.start();

        mainMethod.invoke(null, new Object[] {wrappedArgsArr});
    }

}


class InterpreterRunner implements Runnable {
    private Reader in;
    private Writer out;

    public InterpreterRunner(Reader in, Writer out) {
        this.in = in;
        this.out = out;
    }

    public void run() {
        try {
            BufferedReader inb = new BufferedReader(in);

            InteractiveConsole interp =
                new InteractiveConsole();
            interp.setOut(out);
            interp.setErr(out);

            String line;
            boolean more = false;
            while(true) {
                out.write(more?">> ":"> ");out.flush();
                line = inb.readLine();
                //System.err.println("JythonWrapper: read line: \""+line+"\", pushing it to the interpreter.");
                if (line == null || line.equals("quit")) { break; }
                more = interp.push(line);
            }

            out.write("Goodbye.\n");out.flush();
        }
        catch (IOException ioe) {
            System.err.println(">>>>>>>IOException in Jython Interpreter:");
            ioe.printStackTrace();
        }
        catch (Exception e) {
            try {
                out.write(">>>>>>>Exception in Interpreter:");
                PrintWriter pw = new PrintWriter(out);
                e.printStackTrace(pw);
                pw.flush();
                out.flush();
            }
            catch (IOException ioe) {
                System.err.println(">>>>>>>IOException in Jython Interpreter:");
                ioe.printStackTrace();
            }
        }
    }
}
