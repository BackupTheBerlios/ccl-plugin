import de.fhg.isst.ComponentML.*;
import org.exolab.castor.xml.*;

import java.io.*;

/**
 * Erzeugen einer Java-Repraesentation einer Komponentenspezifikation,
 * anschliessend Schreiben nach ComponentML
 */
public class FromScratch {

    public static void main(String[] args) throws Exception {
        ComponentSpec cs = new ComponentSpec();

        GlobalSection gs = new GlobalSection();
        cs.setGlobalSection(gs);
        ComponentName cn = new ComponentName();
        cn.setName("MyComponent");
        cn.setNamespace("MyComponentNS");
        gs.setComponentName(cn);
        ComponentCategory cg = new ComponentCategory();
        cg.setServiceOriented(new ServiceOriented());
        gs.setComponentCategory(cg);

        Properties ps = new Properties();
        cs.setProperties(ps);
        Property p = new Property();
        ps.addProperty(p);
        p.setKey("age");
        p.addValue("42");

        ExportSection es = new ExportSection();
        cs.setExportSection(es);

        ExportSectionChoice esc = new ExportSectionChoice();
        es.setExportSectionChoice(esc);
        Facade f = new Facade();
        esc.addFacade(f);
        //es.addFacade(f);
        f.setFacadeName("mainFacade");
        BusinessExport be = new BusinessExport();
        f.addBusinessExport(be);
        Method m = new Method();
        be.addMethod(m);
        MethodName mn = new MethodName();
        mn.setContent("method1");
        m.setMethodName(mn);

        Marshaller marshaller = new Marshaller(new OutputStreamWriter(System.out));
        marshaller.marshal(cs);
    }

}
