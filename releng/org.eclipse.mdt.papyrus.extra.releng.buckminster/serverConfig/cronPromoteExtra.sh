#!/bin/bash -x

# This script compares the date of a signal file touched by the hudson build
# with the date of a reference file touched at the end of each promote.
# It then promotes the result of the build. The promote is not done from
# Hudson because it does not have the necessary rights.

lastPromoteFileN=/opt/public/modeling/mdt/papyrus/extra/lastPromoteExtraRefN
lastPromoteFileI=/opt/public/modeling/mdt/papyrus/extra/lastPromoteExtraRefI
promoteSignalN=/opt/public/modeling/mdt/papyrus/extra/papyrusExtraBuildPromoteSignalN
promoteSignalI=/opt/public/modeling/mdt/papyrus/extra/papyrusExtraBuildPromoteSignalI
promoteVersionN=/opt/public/modeling/mdt/papyrus/extra/papyrusExtraBuildPromoteVersionN
promoteVersionI=/opt/public/modeling/mdt/papyrus/extra/papyrusExtraBuildPromoteVersionI
promoteDirNameN=/opt/public/modeling/mdt/papyrus/extra/papyrusExtraBuildPromoteDirNameN
promoteDirNameI=/opt/public/modeling/mdt/papyrus/extra/papyrusExtraBuildPromoteDirNameI
logFile=/opt/public/modeling/mdt/papyrus/extra/log-cronPromoteExtra
integrationTags=/opt/public/modeling/mdt/papyrus/extra/integrationTags

updates_nightly=/home/data/httpd/download.eclipse.org/modeling/mdt/papyrus/extra/updates/nightly/helios/
updates_integration=/home/data/httpd/download.eclipse.org/modeling/mdt/papyrus/extra/updates/integration/

#HUDSON_METRICS=/opt/users/hudsonbuild/workspace/papyrus-nightly/metrics.html
#DOWNLOAD_METRICS=/home/data/httpd/download.eclipse.org/modeling/mdt/papyrus/metrics.html
DOWNLOAD_ITAGS=/home/data/httpd/download.eclipse.org/modeling/mdt/papyrus/extra/integrationTags
PROMO_LOGS_DIR=/opt/public/modeling/mdt/papyrus/extra/promo_logs
DROPS_DIR=/home/data/httpd/download.eclipse.org/modeling/mdt/papyrus/extra/downloads/drops
BUILD_LOC_N=/opt/public/modeling/mdt/papyrus/extra/lastSuccessfulBuildExtraN
BUILD_LOC_I=/opt/public/modeling/mdt/papyrus/extra/lastSuccessfulBuildExtraI

ADD_DOWNLOAD_STATS=/opt/public/modeling/mdt/papyrus/addDownloadStats.sh

DATE=`date +%Y%m%d-%H%M`

# trim the log : keep about last 10 days of log
function trimLog() {
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
        echo "$DATE: NIGHTLY: getting last successful build" >> $logFile
        mkdir -p $BUILD_LOC_N
        #rm -f $BUILD_LOC_N/build.zip
        #rm -rf $BUILD_LOC_N/build
        cd $BUILD_LOC_N
        zipName=$(cat $promoteSignalN).zip
        # see http://wiki.hudson-ci.org/display/HUDSON/Remote+access+API
        wget --no-check-certificate "https://hudson.eclipse.org/hudson/job/cbi-papyrus-extra-nightly/lastSuccessfulBuild/artifact/${zipName}"
        if [ ! -f $zipName ]; then echo "$DATE: NIGHTLY [ERROR] $zipName (from Hudson) not found"; exit -2; fi
        VERSION=$(cat $promoteVersionN)
        if [ -z "$VERSION" ]; then echo "$DATE: NIGHTLY [ERROR] version not found"; exit -2; fi
        BUILDS_DIR=$DROPS_DIR/$VERSION
        prune N $BUILDS_DIR 4
        echo "$DATE: NIGHLTY publishing nightly build (on $VERSION) to $BUILDS_DIR..." >> $logFile
        unzip -o $zipName -d $BUILDS_DIR
        rm -rf $updates_nightly/*
        # extract the zip in which there is the update site zip to a tmp dir
        tmpDrop=$(mktemp -d)
        unzip $zipName -d $tmpDrop
        unzip -o $tmpDrop/?20*/PapyrusExtra-Update-*.zip -d $updates_nightly
        # add download stats to the update repository
        $ADD_DOWNLOAD_STATS $updates_nightly
        chmod -R 755 $BUILDS_DIR
        chmod -R 755 $updates_nightly
        echo "$DATE: NIGHLTY done" >> $logFile
	cp -f $tmpDrop/?20*/*.psf $DROPS_DIR/../../psf/ 
        trimLog
fi


if [ $signalDateI -gt $lastPromoteDateI ]; then
        touch $lastPromoteFileI
        echo "$DATE: INTEGRATION getting last successful build" >> $logFile
        mkdir -p $BUILD_LOC_I
        cd $BUILD_LOC_I
        zipName=$(cat $promoteSignalI).zip
        # see http://wiki.hudson-ci.org/display/HUDSON/Remote+access+API
        wget --no-check-certificate "https://hudson.eclipse.org/hudson/job/cbi-papyrus-extra-nightly/lastSuccessfulBuild/artifact/${zipName}"
        if [ ! -f $zipName ]; then echo "$DATE: INTEGRATION [ERROR] $zipName (from Hudson) not found"; exit -2; fi
        VERSION=$(cat $promoteVersionI)
        if [ -z "$VERSION" ]; then echo "$DATE: INTEGRATION [ERROR] version not found"; exit -2; fi
        BUILDS_DIR=$DROPS_DIR/$VERSION
        prune I $BUILDS_DIR 4
        echo "$DATE: INTEGRATION publishing integration build (on $VERSION) to $BUILDS_DIR..." >> $logFile
        unzip -o $zipName -d $BUILDS_DIR
        mkdir -p $updates_integration/$VERSION
        rm -rf $updates_integration/$VERSION/*
        # extract the zip in which there is the update site zip to a tmp dir
        tmpDrop=$(mktemp -d)
        unzip $zipName -d $tmpDrop
        unzip -o $tmpDrop/?20*/PapyrusExtra-Update-*.zip -d $updates_integration/$VERSION
        cp index.php $updates_integration/$VERSION
        $ADD_DOWNLOAD_STATS $updates_integration/$VERSION
        chmod -R 755 $BUILDS_DIR
        chmod -R 755 $updates_integration/$VERSION
        cp $integrationTags $DOWNLOAD_ITAGS
        echo "$DATE: INTEGRATION done" >> $logF le
        trimLog
fi

