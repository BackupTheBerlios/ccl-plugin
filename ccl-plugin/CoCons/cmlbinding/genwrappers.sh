#!/bin/sh

# aus in ./ComponentML.xsd spezifiziertem XML-Schema
# Java-Klassen erzeugen und nach mapping/ schreiben
# (Package de.fhg.isst.ComponentML)

. ./env.sh

mkdir mapping

java -classpath $CASTOR_JAR:$XERCES_JAR org.exolab.castor.builder.SourceGenerator -i ComponentML.xsd -package de.fhg.isst.ComponentML -dest mapping &&

(cd mapping; javac -classpath $CASTOR_JAR:$XERCES_JAR `find . -name '*.java'`)
