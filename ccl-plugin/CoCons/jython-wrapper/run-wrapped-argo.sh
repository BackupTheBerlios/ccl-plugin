#! /bin/sh

. ./env.sh &&

(mknod pipe p 2>/dev/null; true) &&

# outfile auch als Pipe anzulegen funktioniert
# aus unerfindlichen Gruenden nicht
# (Linux 2.4.16, glibc 2.1.3, GNU bash 2.03)
touch outfile &&
echo >outfile &&
cp -rf $ARGO_PLUGINDIR . &&

java -classpath $JYTHON_CLASSES:$ARGO_CLASSES:. JythonWrapper org.argouml.application.Main -i pipe -o outfile -c $JYTHON_CACHEDIR -- "$@"

