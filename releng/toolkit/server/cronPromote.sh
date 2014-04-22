#!/bin/bash -x

#--------------------------------------------------------------------------------
# Copyright (c) 2012 CEA LIST.
#
#    
# All rights reserved. This program and the accompanying materials
# are made available under the terms of the Eclipse Public License v1.0
# which accompanies this distribution, and is available at
# http://www.eclipse.org/legal/epl-v10.html
#
# Contributors:
#    Nicolas Bros (Mia-Software)
#--------------------------------------------------------------------------------

# This script compares the date of a signal file touched by the hudson build
# with the date of a reference file touched at the end of each promote.
# It then promotes the result of the build. The promote is not done from
# Hudson because it does not have the necessary rights.

# exit on error
set -o errexit
# error when using an unset variable
set -o nounset

### TRUNK ###

LAST_PROMOTE_FILE_TRUNK_NIGHTLY=/opt/public/modeling/mdt/papyrus/papyrus-trunk-nightly/lastPromoteRef
PROMOTE_SIGNAL_TRUNK_NIGHTLY=/opt/public/modeling/mdt/papyrus/papyrus-trunk-nightly/promoteSignal
PROMOTE_VERSION_TRUNK_NIGHTLY=/opt/public/modeling/mdt/papyrus/papyrus-trunk-nightly/promoteVersion

LAST_PROMOTE_FILE_TRUNK_EXTRA_NIGHTLY=/opt/public/modeling/mdt/papyrus/papyrus-trunk-extra-nightly/lastPromoteRef
PROMOTE_SIGNAL_TRUNK_EXTRA_NIGHTLY=/opt/public/modeling/mdt/papyrus/papyrus-trunk-extra-nightly/promoteSignal
PROMOTE_VERSION_TRUNK_EXTRA_NIGHTLY=/opt/public/modeling/mdt/papyrus/papyrus-trunk-extra-nightly/promoteVersion

LAST_PROMOTE_FILE_TRUNK_NIGHTLY_TESTS=/opt/public/modeling/mdt/papyrus/papyrus-trunk-nightly-tests/lastPromoteRef
PROMOTE_SIGNAL_TRUNK_NIGHTLY_TESTS=/opt/public/modeling/mdt/papyrus/papyrus-trunk-nightly-tests/promoteSignal
PROMOTE_VERSION_TRUNK_NIGHTLY_TESTS=/opt/public/modeling/mdt/papyrus/papyrus-trunk-nightly-tests/promoteVersion

### MAINTENANCE 0.10 ###

LAST_PROMOTE_FILE_0_10_MAINTENANCE_NIGHTLY=/opt/public/modeling/mdt/papyrus/papyrus-0.10-maintenance-nightly/lastPromoteRef
PROMOTE_SIGNAL_0_10_MAINTENANCE_NIGHTLY=/opt/public/modeling/mdt/papyrus/papyrus-0.10-maintenance-nightly/promoteSignal
PROMOTE_VERSION_0_10_MAINTENANCE_NIGHTLY=/opt/public/modeling/mdt/papyrus/papyrus-0.10-maintenance-nightly/promoteVersion

LAST_PROMOTE_FILE_0_10_MAINTENANCE_EXTRA_NIGHTLY=/opt/public/modeling/mdt/papyrus/papyrus-0.10-maintenance-extra-nightly/lastPromoteRef
PROMOTE_SIGNAL_0_10_MAINTENANCE_EXTRA_NIGHTLY=/opt/public/modeling/mdt/papyrus/papyrus-0.10-maintenance-extra-nightly/promoteSignal
PROMOTE_VERSION_0_10_MAINTENANCE_EXTRA_NIGHTLY=/opt/public/modeling/mdt/papyrus/papyrus-0.10-maintenance-extra-nightly/promoteVersion

LAST_PROMOTE_FILE_0_10_MAINTENANCE_NIGHTLY_TESTS=/opt/public/modeling/mdt/papyrus/papyrus-0.10-maintenance-nightly-tests/lastPromoteRef
PROMOTE_SIGNAL_0_10_MAINTENANCE_NIGHTLY_TESTS=/opt/public/modeling/mdt/papyrus/papyrus-0.10-maintenance-nightly-tests/promoteSignal
PROMOTE_VERSION_0_10_MAINTENANCE_NIGHTLY_TESTS=/opt/public/modeling/mdt/papyrus/papyrus-0.10-maintenance-nightly-tests/promoteVersion

### Update Sites ###

UPDATES_TRUNK_NIGHTLY=/home/data/httpd/download.eclipse.org/modeling/mdt/papyrus/updates/nightly/luna/main
UPDATES_TRUNK_EXTRA_NIGHTLY=/home/data/httpd/download.eclipse.org/modeling/mdt/papyrus/updates/nightly/luna/extra
UPDATES_0_10_MAINTENANCE_NIGHTLY=/home/data/httpd/download.eclipse.org/modeling/mdt/papyrus/updates/nightly/kepler/main
UPDATES_0_10_MAINTENANCE_EXTRA_NIGHTLY=/home/data/httpd/download.eclipse.org/modeling/mdt/papyrus/updates/nightly/kepler/extra

DROPS_DIR=/home/data/httpd/download.eclipse.org/modeling/mdt/papyrus/downloads/drops

ARCHIVE_DIR=/home/data/httpd/archive.eclipse.org/modeling/mdt/papyrus/downloads/drops
ARCHIVE_INDEX=/home/data/httpd/archive.eclipse.org/modeling/mdt/papyrus/downloads/index.html

# constants required by promoteFunctions.sh
# export ADD_DOWNLOAD_STATS=/opt/public/modeling/mdt/papyrus/addDownloadStats.sh

# wait for up to 15 minutes for Hudson to finish (archive the result)
JOB_FINISH_WAIT_TIMEOUT=900

# include promote functions
source $(dirname $0)/promoteFunctions.sh

DATE=$(date +%Y%m%d-%H%M)

echo "[$DATE] starting cronPromote.sh --------------------------------------------------"

### TRUNK ###

if [ ! -e $LAST_PROMOTE_FILE_TRUNK_NIGHTLY ]; then touch $LAST_PROMOTE_FILE_TRUNK_NIGHTLY; fi
if [ ! -e $LAST_PROMOTE_FILE_TRUNK_EXTRA_NIGHTLY ]; then touch $LAST_PROMOTE_FILE_TRUNK_EXTRA_NIGHTLY; fi
if [ ! -e $LAST_PROMOTE_FILE_TRUNK_NIGHTLY_TESTS ]; then touch $LAST_PROMOTE_FILE_TRUNK_NIGHTLY_TESTS; fi

### MAINTENANCE 0.10 ###

if [ ! -e $LAST_PROMOTE_FILE_0_10_MAINTENANCE_NIGHTLY ]; then touch $LAST_PROMOTE_FILE_0_10_MAINTENANCE_NIGHTLY; fi
if [ ! -e $LAST_PROMOTE_FILE_0_10_MAINTENANCE_EXTRA_NIGHTLY ]; then touch $LAST_PROMOTE_FILE_0_10_MAINTENANCE_EXTRA_NIGHTLY; fi
if [ ! -e $LAST_PROMOTE_FILE_0_10_MAINTENANCE_NIGHTLY_TESTS ]; then touch $LAST_PROMOTE_FILE_0_10_MAINTENANCE_NIGHTLY_TESTS; fi

###

if [ ! -e $PROMOTE_SIGNAL_TRUNK_NIGHTLY ]; then echo "$DATE: ERROR: $PROMOTE_SIGNAL_TRUNK_NIGHTLY not found"; exit 1; fi
if [ ! -e $PROMOTE_SIGNAL_TRUNK_EXTRA_NIGHTLY ]; then echo "$DATE: ERROR: $PROMOTE_SIGNAL_TRUNK_EXTRA_NIGHTLY not found"; exit 1; fi
if [ ! -e $PROMOTE_SIGNAL_TRUNK_NIGHTLY_TESTS ]; then echo "$DATE: ERROR: $PROMOTE_SIGNAL_TRUNK_NIGHTLY_TESTS not found"; exit 1; fi

if [ ! -e $PROMOTE_SIGNAL_0_10_MAINTENANCE_NIGHTLY ]; then echo "$DATE: ERROR: $PROMOTE_SIGNAL_0_10_MAINTENANCE_NIGHTLY not found"; exit 1; fi
if [ ! -e $PROMOTE_SIGNAL_0_10_MAINTENANCE_EXTRA_NIGHTLY ]; then echo "$DATE: ERROR: $PROMOTE_SIGNAL_0_10_MAINTENANCE_EXTRA_NIGHTLY not found"; exit 1; fi
if [ ! -e $PROMOTE_SIGNAL_0_10_MAINTENANCE_NIGHTLY_TESTS ]; then echo "$DATE: ERROR: $PROMOTE_SIGNAL_0_10_MAINTENANCE_NIGHTLY_TESTS not found"; exit 1; fi

###

signalDateTrunkNightly=$(stat --format=%Y $PROMOTE_SIGNAL_TRUNK_NIGHTLY)
signalDateTrunkExtraNightly=$(stat --format=%Y $PROMOTE_SIGNAL_TRUNK_EXTRA_NIGHTLY)
signalDateTrunkNightlyTests=$(stat --format=%Y $PROMOTE_SIGNAL_TRUNK_NIGHTLY_TESTS)

signalDate10MaintenanceNightly=$(stat --format=%Y $PROMOTE_SIGNAL_0_10_MAINTENANCE_NIGHTLY)
signalDate10MaintenanceExtraNightly=$(stat --format=%Y $PROMOTE_SIGNAL_0_10_MAINTENANCE_EXTRA_NIGHTLY)
signalDate10MaintenanceNightlyTests=$(stat --format=%Y $PROMOTE_SIGNAL_0_10_MAINTENANCE_NIGHTLY_TESTS)

###

lastPromoteDateTrunkNightly=$(stat --format=%Y $LAST_PROMOTE_FILE_TRUNK_NIGHTLY)
lastPromoteDateTrunkExtraNightly=$(stat --format=%Y $LAST_PROMOTE_FILE_TRUNK_EXTRA_NIGHTLY)
lastPromoteDateTrunkNightlyTests=$(stat --format=%Y $LAST_PROMOTE_FILE_TRUNK_NIGHTLY_TESTS)

lastPromoteDate10MaintenanceNightly=$(stat --format=%Y $LAST_PROMOTE_FILE_0_10_MAINTENANCE_NIGHTLY)
lastPromoteDate10MaintenanceExtraNightly=$(stat --format=%Y $LAST_PROMOTE_FILE_0_10_MAINTENANCE_EXTRA_NIGHTLY)
lastPromoteDate10MaintenanceNightlyTests=$(stat --format=%Y $LAST_PROMOTE_FILE_0_10_MAINTENANCE_NIGHTLY_TESTS)

########## trunk main nightly ##########
if [ $signalDateTrunkNightly -gt $lastPromoteDateTrunkNightly ]; then
	# mark the promote as done
	touch "$LAST_PROMOTE_FILE_TRUNK_NIGHTLY"
	
	waitUntilJobIsFinished "papyrus-trunk-nightly" "$JOB_FINISH_WAIT_TIMEOUT"
	
	# the Hudson job wrote these build name and version to publish
	buildName=$(cat "$PROMOTE_SIGNAL_TRUNK_NIGHTLY")
	version=$(cat "$PROMOTE_VERSION_TRUNK_NIGHTLY")
	zipName="Papyrus-Main.zip"
	
	echo "[$DATE] deleting previous nightly update site"
	rm -rf "$UPDATES_TRUNK_NIGHTLY"
	
	buildsDir="$DROPS_DIR/$version"
	echo "[$DATE] pruning old builds"
	prune N "$buildsDir" 2

	nfsURL="/shared/jobs/papyrus-trunk-nightly/lastSuccessful/archive/"
	hudsonURL="https://hudson.eclipse.org/hudson/job/papyrus-trunk-nightly/lastSuccessfulBuild/artifact/"
	export SVN_DIRECTORIES_TO_TAG=( )
	promote "$zipName" "$version" "$nfsURL" "$hudsonURL" "$DROPS_DIR" "$ARCHIVE_DIR" "$ARCHIVE_INDEX" "$UPDATES_TRUNK_NIGHTLY" "Papyrus-Update-incubation-" "NA"

	echo "[$DATE] promote done"
	
	# trigger the tests and extras builds by using the Hudson Rest API
	# see http://wiki.hudson-ci.org/display/HUDSON/Remote+access+API
	
	echo "[$DATE] triggering Hudson tests build"
	json='{"parameter": [
		{"name": "BUCKMINSTER_LOGLEVEL", "value": "DEBUG"},
		{"name": "CLEAN_TP", "value": "true"},
		{"name": "CLEAN_WORKSPACE", "value": "true"},
		{"name": "CLEAN_OUTPUT", "value": "true"},
		{"name": "CLEAN_TOOLS", "value": "false"},
		{"name": "BUILD_TARGET", "value": "test"},
		{"name": "BUILD_TYPE", "value": "N"}
	], "": ""}'
	curl -X POST https://hudson.eclipse.org/hudson/job/papyrus-trunk-nightly-tests/build -d token=token --data-urlencode json="$json" | grep --ignore-case error && exit -1

	echo "[$DATE] triggering Hudson extras build"
	json='{"parameter": [
		{"name": "BUCKMINSTER_LOGLEVEL", "value": "DEBUG"},
		{"name": "CLEAN_TP", "value": "true"},
		{"name": "CLEAN_WORKSPACE", "value": "true"},
		{"name": "CLEAN_OUTPUT", "value": "true"},
		{"name": "CLEAN_TOOLS", "value": "false"},
		{"name": "BUILD_TYPE", "value": "N"},
		{"name": "SITE_PACK200", "value": "true"},
		{"name": "BUILD_TARGET", "value": "site.p2"},
		{"name": "JAVA_HOME", "value": "/shared/common/sun-jdk1.6.0_21_x64"},
		{"name": "SIGN_UPDATE_SITE", "value": "false"}
	], "": ""}'
	curl -X POST https://hudson.eclipse.org/hudson/job/papyrus-trunk-extra-nightly/build -d token=token --data-urlencode json="$json" | grep --ignore-case error && exit -1
fi

########## trunk main nightly tests ##########
if [ $signalDateTrunkNightlyTests -gt $lastPromoteDateTrunkNightlyTests ]; then
	# mark the promote as done
	touch "$LAST_PROMOTE_FILE_TRUNK_NIGHTLY_TESTS"

	waitUntilJobIsFinished "papyrus-trunk-nightly-tests" "$JOB_FINISH_WAIT_TIMEOUT"

	dirBefore=$(pwd)
	echo "[$DATE] creating working dir"
	workingDir=$(mktemp -d)
	cd "$workingDir"

	# for the tests build, the build name and version are taken from the last main build since the artifacts 
	# must go to the same folder, and we want to be able to start several extra jobs after one single main job

	buildName=$(cat "$PROMOTE_SIGNAL_TRUNK_NIGHTLY")
	version=$(cat "$PROMOTE_VERSION_TRUNK_NIGHTLY")
	zipName="Papyrus-TestResults.zip"
	nfsURL="/shared/jobs/papyrus-trunk-nightly-tests/lastSuccessful/archive/"
	hudsonURL="https://hudson.eclipse.org/hudson/job/papyrus-trunk-nightly-tests/lastSuccessfulBuild/artifact/"

	cp "$nfsURL/${zipName}" . || wget --no-check-certificate "$hudsonURL/${zipName}"
	if [ ! -f "$zipName" ]; then echo "ERROR: $zipName (from Hudson) not found"; exit -2; fi
	echo "[$DATE] Testing zip integrity"
	unzip -t "$zipName"
	buildsDir="$DROPS_DIR/$version/$buildName"
	echo "[$DATE] publishing build (version='$version') to the builds directory '$buildsDir'..."
	unzip -o "$zipName" -d "$buildsDir"
	echo "[$DATE] setting access rights"
	setAccessRights "$buildsDir"

	echo "[$DATE] promote done"

	cd ${dirBefore}
	echo "[$DATE] deleting working dir"
	rm -rf "$workingDir"
	
	# TODO: re-enable when the job is implemented
	# echo "[$DATE] triggering Hudson tests build"
	# curl https://hudson.eclipse.org/hudson/job/papyrus-trunk-extra-nightly-tests/buildWithParameters?token=token
fi

########## trunk extras nightly ##########
if [ $signalDateTrunkExtraNightly -gt $lastPromoteDateTrunkExtraNightly ]; then
	# mark the promote as done
	touch "$LAST_PROMOTE_FILE_TRUNK_EXTRA_NIGHTLY"
	
	waitUntilJobIsFinished "papyrus-trunk-extra-nightly" "$JOB_FINISH_WAIT_TIMEOUT"

	dirBefore=$(pwd)
	echo "[$DATE] creating working dir"
	workingDir=$(mktemp -d)
	cd "$workingDir"
	
	# for the extra build, the build name and version are taken from the last main build since the artifacts 
	# must go to the same folder, and we want to be able to start several extra jobs after one single main job
	
	buildName=$(cat "$PROMOTE_SIGNAL_TRUNK_NIGHTLY")
	version=$(cat "$PROMOTE_VERSION_TRUNK_NIGHTLY")
	zipName="Papyrus-Extra.zip"
	updateZipName="Papyrus-Extra-Update.zip"
	nfsURL="/shared/jobs/papyrus-trunk-extra-nightly/lastSuccessful/archive/"
	hudsonURL="https://hudson.eclipse.org/hudson/job/papyrus-trunk-extra-nightly/lastSuccessfulBuild/artifact/"
	
	# publish to existing drops folder
	cp "$nfsURL/${zipName}" . || wget --no-check-certificate "$hudsonURL/${zipName}"
	if [ ! -f "$zipName" ]; then echo "ERROR: $zipName (from Hudson) not found"; exit -2; fi
	echo "[$DATE] Testing zip integrity"
	unzip -t "$zipName"
	buildsDir="$DROPS_DIR/$version/$buildName"
	echo "[$DATE] publishing build (version='$version') to the builds directory '$buildsDir'..."
	unzip -o "$zipName" -d "$buildsDir"

	# publish to composite update site
	tmpDrop=$(mktemp -d)
	unzip "$zipName" -d "$tmpDrop"
	dirNameInZip=$(ls -1 "$tmpDrop")
	[ $(echo "$dirNameInZip" | wc -l) == 1 ] || { echo "one directory expected in zip"; exit 1; }
	rm -rf "$UPDATES_TRUNK_EXTRA_NIGHTLY"
	unzip -o "$tmpDrop/$dirNameInZip/${updateZipName}" -d "$UPDATES_TRUNK_EXTRA_NIGHTLY"
	
	echo "[$DATE] setting access rights"
	setAccessRights "$buildsDir"
	setAccessRights "$UPDATES_TRUNK_EXTRA_NIGHTLY"
	
	echo "[$DATE] promote done"
	
	cd ${dirBefore}
	echo "[$DATE] deleting working dir"
	rm -rf "$workingDir"
	rm -rf "$tmpDrop"
	
	# trigger the extras tests build by using the Hudson Rest API
	# see http://wiki.hudson-ci.org/display/HUDSON/Remote+access+API
	
	echo "[$DATE] triggering Hudson extras tests build"
	json='{"parameter": [
		{"name": "BUCKMINSTER_LOGLEVEL", "value": "DEBUG"},
		{"name": "CLEAN_TP", "value": "true"},
		{"name": "CLEAN_WORKSPACE", "value": "true"},
		{"name": "CLEAN_OUTPUT", "value": "true"},
		{"name": "CLEAN_TOOLS", "value": "false"},
		{"name": "BUILD_TYPE", "value": "N"},
		{"name": "BUILD_TARGET", "value": "test"}
	], "": ""}'
	curl -X POST https://hudson.eclipse.org/hudson/job/papyrus-trunk-extra-nightly-tests/build -d token=token --data-urlencode json="$json" | grep --ignore-case error && exit -1
fi

########## maintenance main 0.10 nightly ##########
if [ $signalDate10MaintenanceNightly -gt $lastPromoteDate10MaintenanceNightly ]; then
	# mark the promote as done
	touch "$LAST_PROMOTE_FILE_0_10_MAINTENANCE_NIGHTLY"
	
	waitUntilJobIsFinished "papyrus-0.10-maintenance-nightly" "$JOB_FINISH_WAIT_TIMEOUT"
	
	# the Hudson job wrote these build name and version to publish
	buildName=$(cat "$PROMOTE_SIGNAL_0_10_MAINTENANCE_NIGHTLY")
	version=$(cat "$PROMOTE_VERSION_0_10_MAINTENANCE_NIGHTLY")
	zipName="Papyrus-Main.zip"
	
	echo "[$DATE] deleting previous nightly update site"
	rm -rf "$UPDATES_0_10_MAINTENANCE_NIGHTLY"
	
	buildsDir="$DROPS_DIR/$version"
	echo "[$DATE] pruning old builds"
	prune N "$buildsDir" 2

	nfsURL="/shared/jobs/papyrus-0.10-maintenance-nightly/lastSuccessful/archive/"
	hudsonURL="https://hudson.eclipse.org/hudson/job/papyrus-0.10-maintenance-nightly/lastSuccessfulBuild/artifact/"
	export SVN_DIRECTORIES_TO_TAG=( )
	promote "$zipName" "$version" "$nfsURL" "$hudsonURL" "$DROPS_DIR" "$ARCHIVE_DIR" "$ARCHIVE_INDEX" "$UPDATES_0_10_MAINTENANCE_NIGHTLY" "Papyrus-Update-incubation-" "NA"

	echo "[$DATE] promote done"
	
	# trigger the tests and extras builds by using the Hudson Rest API
	# see http://wiki.hudson-ci.org/display/HUDSON/Remote+access+API
	
	echo "[$DATE] triggering Hudson tests build"
	json='{"parameter": [
		{"name": "BUCKMINSTER_LOGLEVEL", "value": "DEBUG"},
		{"name": "CLEAN_TP", "value": "true"},
		{"name": "CLEAN_WORKSPACE", "value": "true"},
		{"name": "CLEAN_OUTPUT", "value": "true"},
		{"name": "CLEAN_TOOLS", "value": "false"},
		{"name": "BUILD_TARGET", "value": "test"},
		{"name": "BUILD_TYPE", "value": "N"}
	], "": ""}'
	curl -X POST https://hudson.eclipse.org/hudson/job/papyrus-0.10-maintenance-nightly-tests/build -d token=token --data-urlencode json="$json" | grep --ignore-case error && exit -1

	echo "[$DATE] triggering Hudson extras build"
	json='{"parameter": [
		{"name": "BUCKMINSTER_LOGLEVEL", "value": "DEBUG"},
		{"name": "CLEAN_TP", "value": "true"},
		{"name": "CLEAN_WORKSPACE", "value": "true"},
		{"name": "CLEAN_OUTPUT", "value": "true"},
		{"name": "CLEAN_TOOLS", "value": "false"},
		{"name": "BUILD_TYPE", "value": "N"},
		{"name": "SITE_PACK200", "value": "true"},
		{"name": "BUILD_TARGET", "value": "site.p2"},
		{"name": "JAVA_HOME", "value": "/shared/common/sun-jdk1.6.0_21_x64"},
		{"name": "SIGN_UPDATE_SITE", "value": "false"}
	], "": ""}'
	curl -X POST https://hudson.eclipse.org/hudson/job/papyrus-0.10-maintenance-extra-nightly/build -d token=token --data-urlencode json="$json" | grep --ignore-case error && exit -1
fi

########## maintenance 0.10 main nightly tests ##########
if [ $signalDate10MaintenanceNightlyTests -gt $lastPromoteDate10MaintenanceNightlyTests ]; then
	# mark the promote as done
	touch "$LAST_PROMOTE_FILE_0_10_MAINTENANCE_NIGHTLY_TESTS"

	waitUntilJobIsFinished "papyrus-0.10-maintenance-nightly-tests" "$JOB_FINISH_WAIT_TIMEOUT"

	dirBefore=$(pwd)
	echo "[$DATE] creating working dir"
	workingDir=$(mktemp -d)
	cd "$workingDir"

	# for the tests build, the build name and version are taken from the last main build since the artifacts 
	# must go to the same folder, and we want to be able to start several extra jobs after one single main job

	buildName=$(cat "$PROMOTE_SIGNAL_0_10_MAINTENANCE_NIGHTLY")
	version=$(cat "$PROMOTE_VERSION_0_10_MAINTENANCE_NIGHTLY")
	zipName="Papyrus-TestResults.zip"
	nfsURL="/shared/jobs/papyrus-0.10-maintenance-nightly-tests/lastSuccessful/archive/"
	hudsonURL="https://hudson.eclipse.org/hudson/job/papyrus-0.10-maintenance-nightly-tests/lastSuccessfulBuild/artifact/"

	cp "$nfsURL/${zipName}" . || wget --no-check-certificate "$hudsonURL/${zipName}"
	if [ ! -f "$zipName" ]; then echo "ERROR: $zipName (from Hudson) not found"; exit -2; fi
	echo "[$DATE] Testing zip integrity"
	unzip -t "$zipName"
	buildsDir="$DROPS_DIR/$version/$buildName"
	echo "[$DATE] publishing build (version='$version') to the builds directory '$buildsDir'..."
	unzip -o "$zipName" -d "$buildsDir"
	echo "[$DATE] setting access rights"
	setAccessRights "$buildsDir"

	echo "[$DATE] promote done"

	cd ${dirBefore}
	echo "[$DATE] deleting working dir"
	rm -rf "$workingDir"
	
	# TODO: re-enable when the job is implemented
	# echo "[$DATE] triggering Hudson tests build"
	# curl https://hudson.eclipse.org/hudson/job/papyrus-0.10-maintenance-extra-nightly-tests/buildWithParameters?token=token
fi

########## maintenance 0.10 extras nightly ##########
if [ $signalDate10MaintenanceExtraNightly -gt $lastPromoteDate10MaintenanceExtraNightly ]; then
	# mark the promote as done
	touch "$LAST_PROMOTE_FILE_0_10_MAINTENANCE_EXTRA_NIGHTLY"
	
	waitUntilJobIsFinished "papyrus-0.10-maintenance-extra-nightly" "$JOB_FINISH_WAIT_TIMEOUT"

	dirBefore=$(pwd)
	echo "[$DATE] creating working dir"
	workingDir=$(mktemp -d)
	cd "$workingDir"
	
	# for the extra build, the build name and version are taken from the last main build since the artifacts 
	# must go to the same folder, and we want to be able to start several extra jobs after one single main job
	
	buildName=$(cat "$PROMOTE_SIGNAL_0_10_MAINTENANCE_NIGHTLY")
	version=$(cat "$PROMOTE_VERSION_0_10_MAINTENANCE_NIGHTLY")
	zipName="Papyrus-Extra.zip"
	updateZipName="Papyrus-Extra-Update.zip"
	nfsURL="/shared/jobs/papyrus-0.10-maintenance-extra-nightly/lastSuccessful/archive/"
	hudsonURL="https://hudson.eclipse.org/hudson/job/papyrus-0.10-maintenance-extra-nightly/lastSuccessfulBuild/artifact/"
	
	# publish to existing drops folder
	cp "$nfsURL/${zipName}" . || wget --no-check-certificate "$hudsonURL/${zipName}"
	if [ ! -f "$zipName" ]; then echo "ERROR: $zipName (from Hudson) not found"; exit -2; fi
	echo "[$DATE] Testing zip integrity"
	unzip -t "$zipName"
	buildsDir="$DROPS_DIR/$version/$buildName"
	echo "[$DATE] publishing build (version='$version') to the builds directory '$buildsDir'..."
	unzip -o "$zipName" -d "$buildsDir"

	# publish to composite update site
	tmpDrop=$(mktemp -d)
	unzip "$zipName" -d "$tmpDrop"
	dirNameInZip=$(ls -1 "$tmpDrop")
	[ $(echo "$dirNameInZip" | wc -l) == 1 ] || { echo "one directory expected in zip"; exit 1; }
	rm -rf "$UPDATES_0_10_MAINTENANCE_EXTRA_NIGHTLY"
	unzip -o "$tmpDrop/$dirNameInZip/${updateZipName}" -d "$UPDATES_0_10_MAINTENANCE_EXTRA_NIGHTLY"
	
	echo "[$DATE] setting access rights"
	setAccessRights "$buildsDir"
	setAccessRights "$UPDATES_0_10_MAINTENANCE_EXTRA_NIGHTLY"
	
	echo "[$DATE] promote done"
	
	cd ${dirBefore}
	echo "[$DATE] deleting working dir"
	rm -rf "$workingDir"
	rm -rf "$tmpDrop"
	
	# trigger the extras tests build by using the Hudson Rest API
	# see http://wiki.hudson-ci.org/display/HUDSON/Remote+access+API
	
	echo "[$DATE] triggering Hudson extras tests build"
	json='{"parameter": [
		{"name": "BUCKMINSTER_LOGLEVEL", "value": "DEBUG"},
		{"name": "CLEAN_TP", "value": "true"},
		{"name": "CLEAN_WORKSPACE", "value": "true"},
		{"name": "CLEAN_OUTPUT", "value": "true"},
		{"name": "CLEAN_TOOLS", "value": "false"},
		{"name": "BUILD_TYPE", "value": "N"},
		{"name": "BUILD_TARGET", "value": "test"}
	], "": ""}'
	curl -X POST https://hudson.eclipse.org/hudson/job/papyrus-0.10-maintenance-extra-nightly-tests/build -d token=token --data-urlencode json="$json" | grep --ignore-case error && exit -1
fi
