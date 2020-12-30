#!/bin/sh

ALL=0
FORCE=0
TMP=/tmp/.mp.threads.tmp.$$

trap "rm -f $TMP" EXIT

./getdebug.sh | grep 'Thread.*Smpp.*Operators' | sed 's/.*\[\([^,]*\),.*/\1/' | sort -t- -k2 > $TMP
./getdebug.sh | grep 'Thread.*Provider.*Operators' | sed 's/.*\[\([^,]*\),.*/\1-/' | sort -t- -k2 >> $TMP

OPS="$(cat $TMP | sed -e 's/^[^\-]*-\(.*\)-[^\-]*$/\1/' | sort -u)"

args=`getopt 'fahk:p:' $*` || exit
set -- $args

usage() {
    echo "$0 [ -p OP ] [ -k OP ] [-a] [-f]"
    echo "    -p OP: print threads for OP"
    echo "    -k OP: kill threads for OP"
    echo "    -a: show all threads"
}

kill_thread() {
    #./killThread.sh $THR
    echo "./killThread.sh $THR"
}

list() {
    TARGET=$1
    TABS="    " && [[ ! -z "$TARGET" ]] && TABS=""

	for OP in $OPS; do
        if [ -z "$TARGET" -o "$TARGET" == "$OP" ]; then
		    THRS=$(grep "^[^\-]*-$OP-[^\-]*$" $TMP | sed -e 's/^/    /')
            CNT=0 
		    for THR in $THRS; do
			    if [[ $THR == *"SmppTx"* ]]; then
                    CNT=$(($CNT + 1))
                fi
			    if [[ $THR == *"SmppTrx"* ]]; then
                    CNT=$(($CNT + 1))
                fi
		    done
            if [ $CNT -gt 1 -o $ALL -eq 1 ]; then
                if [ -z "$TARGET" ]; then
		            echo "$OP: $CNT"
                fi
		        for THR in $THRS; do
			        echo "$TABS$THR"
		        done
            fi
	    fi
    done
}

while true; do
    case $1 in
      (-a)   ALL=1; shift;;
      (-f)   FORCE=1; shift;;
      (-h)   usage; exit 0;;
      (-p)   POP=$2; shift 2;;
      (-k)   KOP=$2; shift 2;;
      (--)   shift; break;;
      (*)    exit 1;;           # error
    esac
done

if [ -z "$POP" -a -z "$KOP" ]; then
   list
elif [ ! -z "$POP" ]; then
   list $POP
elif [ ! -z "$KOP" ]; then
   THRS=$(list $KOP)
   for THR in $THRS; do
       if [ $FORCE -eq 1 ]; then
		   kill_thread $THR
       else
           while [ true ]; do
               read -p "Killing $THR [y/N]? " -n 1 -r
               if [[ $REPLY =~ ^[Nn]$ ]]; then
                   echo
                   break
               elif [[ $REPLY =~ ^[yY]$ ]]; then
                   echo
                   kill_thread $THR
                   break
               else
                   echo "Please answer yes or no."
               fi
           done
       fi
   done
fi
