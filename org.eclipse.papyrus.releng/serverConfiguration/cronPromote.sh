#!/bin/bash

# This script compares the date of a signal file touched by the hudson build
# with the date of a reference file touched at the end of each promote.
# It then promotes the result of the build. The promote is not done from
# Hudson because it does not have the necessary rights.

lastPromoteFileN=/opt/public/modeling/mdt/papyrus/lastPromoteRefN
lastPromoteFileI=/opt/public/modeling/mdt/papyrus/lastPromoteRefI
promoteSignalN=/opt/public/modeling/mdt/papyrus/modiscoBuildPromoteSignalN
promoteSignalI=/opt/public/modeling/mdt/papyrus/modiscoBuildPromoteSignalI
logFile=/opt/public/modeling/mdt/papyrus/log-cronPromote

ANT=/opt/public/common/apache-ant-1.7.1/bin/ant
RELENG_DIR=/opt/users/hudsonbuild/.hudson/jobs/cbi-modisco-nightly/workspace/build/org.eclipse.modisco.releng
PROMO_LOGS_DIR=/opt/public/modeling/mdt/papyrus/promo_logs
BUILDS_DIR=/home/data/httpd/download.eclipse.org/modeling/mdt/papyrus/downloads/drops/0.7.0

DATE=`date +%Y%m%d-%H%M`

# trim the log : keep about last 10 days of log
function trimLog {
        tail -n 3000 $logFile > ${logFile}Trimmed && mv ${logFile}Trimmed $logFile
}


function prune() {
        # prefix: N for nightlies, I for integration, ...
        kind=$1
        filesPath=$2
        nBuildsToKeep=$3
        
        allFiles=$(ls -trd $filesPath/N20*)
        nFiles=$(ls -1d $filesPath/N20* | wc -l)
        nToDelete=$((nFiles-nBuildsToKeep))

        if [ $nToDelete -gt 0 ]; then
                for file in $allFiles; do
                        echo "$DATE: deleting $file" >> $logFile 
                        rm -rf $file
                        nToDelete=$((nToDelete-1))
                        if [ $nToDelete -le 0 ]; then break; fi
                done
        fi
}



if [ ! -e $lastPromoteFileN ]; then touch $lastPromoteFileN; fi
if [ ! -e $lastPromoteFileI ]; then touch $lastPromoteFileI; fi
if [ ! -e $promoteSignalN ]; then echo "$DATE: ERROR: $promoteSignalN not found" >> $logFile; exit 1; fi
if [ ! -e $promoteSignalI ]; then echo "$DATE: ERROR: $promoteSignalI not found" >> $logFile; exit 1; fi

signalDateN=`stat --format=%Y $promoteSignalN`
signalDateI=`stat --format=%Y $promoteSignalI`
lastPromoteDateN=`stat --format=%Y $lastPromoteFileN`
lastPromoteDateI=`stat --format=%Y $lastPromoteFileI`

if [ $signalDateN -gt $lastPromoteDateN ]; then 
        echo "$DATE: removing old nightlies" >> $logFile
        prune N $BUILDS_DIR 4   
        echo "$DATE: publishing nightly build ..." >> $logFile
        mkdir -p $PROMO_LOGS_DIR
        $ANT -f $RELENG_DIR/promote.xml -Dpromote.properties=$RELENG_DIR/promote-N.properties 2>/dev/null 1> $PROMO_LOGS_DIR/cbi-papyrus-nightly-promo-${DATE}.txt 
        touch $lastPromoteFileN
        echo "$DATE: done" >> $logFile
        trimLog
fi


if [ $signalDateI -gt $lastPromoteDateI ]; then 
        echo "$DATE: removing old integration builds" >> $logFile
        prune I $BUILDS_DIR 4   
        echo "$DATE: publishing integration build ..." >> $logFile
        mkdir -p $PROMO_LOGS_DIR
        $ANT -f $RELENG_DIR/promote.xml -Dpromote.properties=$RELENG_DIR/promote-I.properties 2>/dev/null 1> $PROMO_LOGS_DIR/cbi-papyrus-integration-promo-${DATE}.txt 
        touch $lastPromoteFileI
        echo "$DATE: done" >> $logFile
        trimLog
fi

