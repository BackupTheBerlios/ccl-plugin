#! /bin/sh

tail -f outfile &
TAILPID=$?
cat >pipe

kill $TAILPID
