import de.fhg.isst.ComponentML.*;
import java.io.*;

/**
 * ComponentML von der Standardeingabe lesen, einen Methodennamen aendern,
 * geaendertes ComponentML auf Standardausgabe ausgeben.
 */
public class T1 {

    public static void main(String[] args) throws Exception {
        Reader reader = new InputStreamReader(System.in);
        ComponentSpec cs = ComponentSpec.unmarshal(reader);

        Method m =
            cs.getExportSection().getLifecycleExport().getMethod(0);

        m.getMethodName().setContent("newMethodName");

        cs.marshal(new OutputStreamWriter(System.out));
    }

}
