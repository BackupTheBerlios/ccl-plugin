In diesem Verzeichnis befindet sich ein Tool, das es ermöglicht,
parallel zu einem laufenden ArgoUML (in derselben Java-VM) einen
interaktiven Interpreter laufen zu lassen. Dort kann man dann
statische Variablen der laufenden ArgoUML-Instanz (insb. aktuell
existierende Diagramme und deren Metamodelle) inspizieren und
manipulieren.

(Benutzer von Tools wie JBuilder können vermutlich mit dem dort
integrierten Debugger etwas ähnliches erreichen)

Diese Installationsbeschreibung und die Skripte sind im Mom. nur für
Unix-Systeme geschrieben.

Der Interpreter basiert auf Jython (http://www.jython.org). Das ist
ein in Java geschriebener Interpreter für die Skriptsprache "Python".

Vorgehen zur Installation:

1. Jython ziehen:

http://prdownloads.sourceforge.net/jython/jython-21.class

2. jython-21.class ausführen (ist ein graphisches
   Installationsprogramm)

3. In diesem Verzeichnis hier: "env.sh.sample" nach "env.sh" kopieren,
   anpassen

4. "compile-wrapper.sh" ausführen. Damit wird die spezielle
   Wrapperklasse "JythonWrapper" erzeugt.

5. Argo und den Interpreter in 2 Konsolen starten.

Beispiel-Session dazu:

(2 Konsolen öffnen)

(in Konsole 1)
[.../ccl-plugin/CoCons/jython-wrapper]$  ./run-wrapped-argo.sh
(nix passiert -- er wartet auf ./connect-to-wrapper.sh)


(in Konsole 2)
[.../ccl-plugin/CoCons/jython-wrapper]$ ./connect-to-wrapper.sh
(ArgoUML startet in Konsole 1)
> 1+1
2
> execfile("init.py")  # fuehrt die in "init.py" (siehe dort) stehenden Befehle so aus, als wären sie direkt eingeg. worden.
> prj
org.argouml.kernel.Project@29aa21

(in ArgoUML zusaetzlich zu den 2 bestehenden Diagrammen ein drittes
Diagramm (Klassendiagramm) anlegen, dessen Namen auf "mydiag"
setzen. In mydiag 3 Klassen "Car", "Cabriolet", "Engine"
anlegen. Assoziation zw. "Car" und "Engine" anlegen.)

> prj.getDiagrams()
[org.argouml.uml.diagram.static_structure.ui.UMLClassDiagram@17950e, org.argouml.uml.diagram.use_case.ui.UMLUseCaseDiagram@6a16ae, org.argouml.uml.diagram.static_structure.ui.UMLClassDiagram@6637fb]
> prj.getDiagrams()[0]
org.argouml.uml.diagram.static_structure.ui.UMLClassDiagram@17950e
> prj.getDiagrams()[0].getName()
'class diagram 1'
> prj.getDiagrams()[2].getName()
'mydiag'
> diag = prj.getDiagrams()[2]
> nodes = diag.getNodes()
> nodes
[Class: Car, Class: Cabriolet, Class: Engine]
> nodes[0]
Class: Car
> nodes[0].class
<jclass ru.novosoft.uml.foundation.core.MClassImpl at 2286919>
> nodes[0].getAssociationEnds()
[anon AssociationEnd]
> nodes[0].getAssociationEnds().getAssociation()
Traceback (innermost last):
  File "<console>", line 1, in ?
AttributeError: getAssociation
> nodes[0].getAssociationEnds()[0].getAssociation()
anon Association
> nodes[0].getAssociationEnds()[0].getAssociation().getName()
   (in ArgoUML den Namen der Assoziation zw. "Car" und "Engine" auf "contains" setzen)
> nodes[0].getAssociationEnds()[0].getAssociation().getName()
'contains'
> 
....
