#!/bin/bash

# This script compares the date of a signal file touched by the hudson build
# with the date of a reference file touched at the end of each promote.
# It then promotes the result of the build. The promote is not done from
# Hudson because it does not have the necessary rights.
# inspired from file taken from project gmt/Modisco


lastPromoteFileN=/opt/public/modeling/mdt/papyrus/lastPromoteRefN
# lastPromoteFileI=/opt/public/modeling/mdt/papyrus/lastPromoteRefI
promoteSignalN=/opt/public/modeling/mdt/papyrus/papyrusBuildPromoteSignalN
# promoteSignalI=/opt/public/modeling/mdt/papyrus/papyrusBuildPromoteSignalI
logFile=/opt/public/modeling/mdt/papyrus/log-cronPromote

drops_nightly=/home/data/httpd/download.eclipse.org/modeling/mdt/papyrus/downloads/drops/0.7.0/
# drops_integration=/home/data/httpd/download.eclipse.org/modeling/mdt/papyrus/downloads/drops/0.7.0/
updates_nightly=/home/data/httpd/download.eclipse.org/modeling/mdt/papyrus/updates/nightly/
# updates_integration=/home/data/httpd/download.eclipse.org/modeling/mdt/papyrus/updates/integration/


ANT=/opt/public/common/apache-ant-1.7.1/bin/ant
RELENG_DIR=/opt/users/hudsonbuild/.hudson/jobs/cbi-papyrus-0.7-nightly/workspace/build/org.eclipse.papyrus.releng
PROMO_LOGS_DIR=/opt/public/modeling/mdt/papyrus/promo_logs
BUILDS_DIR=/home/data/httpd/download.eclipse.org/modeling/mdt/papyrus/downloads/drops/0.7.0
BUILD_LOC_N=/opt/public/modeling/mdt/papyrus/lastSuccessfulBuildN
BUILD_LOC_I=/opt/public/modeling/mdt/papyrus/lastSuccessfulBuildI

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

        allFiles=$(ls -trd $filesPath/${kind}20*)
        nFiles=$(ls -1d $filesPath/${kind}20* | wc -l)
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
        touch $lastPromoteFileN
        echo "$DATE: removing old nightlies" >> $logFile
        prune N $BUILDS_DIR 4
        echo "$DATE: getting last successful build" >> $logFile
        mkdir -p $BUILD_LOC_N
        rm -f $BUILD_LOC_N/build.zip
        rm -rf $BUILD_LOC_N/build
        cd $BUILD_LOC_N
        # see http://wiki.hudson-ci.org/display/HUDSON/Remote+access+API
        wget --no-check-certificate "https://build.eclipse.org/hudson/job/cbi-papyrus-0.7-nightly/lastSuccessfulBuild/artifact/build/*zip*/build.zip"
        if [ ! -f build.zip ]; then echo "ERROR:build.zip (from Hudson) not found"; exit -2; fi
        unzip build.zip
        if [ -d build/N20* ]; then
                echo "$DATE: publishing nightly build ..." >> $logFile
                mkdir -p $PROMO_LOGS_DIR
                f=build/N20*
                if [ -d $f ]; then
                        /usr/bin/rsync -a --exclude=eclipse/ $f $drops_nightly
                        rm -rf $updates_nightly/*
                        unzip -o $f/*-Update-*.zip -d $updates_nightly
                        cp index.php $updates_nightly/
                        chmod -R 755 $drops_nightly
                        chmod -R 755 $updates_nightly
                fi
                #$ANT -f $RELENG_DIR/promote.xml -Dpromote.properties=$RELENG_DIR/promote-N.properties 2>/dev/null 1> $PROMO_LOGS_DIR/cbi-papyrus-0.7-nightly-promo-${DATE}.txt
        fi
        echo "$DATE: done" >> $logFile
        trimLog
fi


if [ $signalDateI -gt $lastPromoteDateI ]; then
        echo "$DATE: removing old integration builds" >> $logFile
        prune I $BUILDS_DIR 4
        echo "$DATE: getting last successful build" >> $logFile
        mkdir -p $BUILD_LOC_I
        rm -f $BUILD_LOC_I/build.zip
        rm -rf $BUILD_LOC_I/build
        cd $BUILD_LOC_I
        wget --no-check-certificate "https://build.eclipse.org/hudson/job/cbi-papyrus-0.7-integration/lastSuccessfulBuild/artifact/build/*zip*/build.zip"
        if [ ! -f build.zip ]; then echo "ERROR:build.zip (from Hudson) not found"; exit -2; fi
        unzip build.zip
        if [ -d build/I20* ]; then
                echo "$DATE: publishing integration build ..." >> $logFile
                mkdir -p $PROMO_LOGS_DIR
                f=build/I20*
                if [ -d $f ]; then
                        /usr/bin/rsync -a --exclude=eclipse/ $f $drops_integration
                        unzip -o $f/*-Update-*.zip -d $updates_integration
                        cp index.php $updates_integration/
                        chmod -R 755 $drops_integration
                        chmod -R 755 $updates_integration
                fi
                #$ANT -f $RELENG_DIR/promote.xml -Dpromote.properties=$RELENG_DIR/promote-I.properties 2>/dev/null 1> $PROMO_LOGS_DIR/cbi-papyrus-0.7-integration-promo-${DATE}.txt
                touch $lastPromoteFileI
        fi
        echo "$DATE: done" >> $logFile
        trimLog
fi

