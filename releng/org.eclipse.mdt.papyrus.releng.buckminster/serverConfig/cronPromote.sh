#!/bin/bash -x

# This script compares the date of a signal file touched by the hudson build
# with the date of a reference file touched at the end of each promote.
# It then promotes the result of the build. The promote is not done from
# Hudson because it does not have the necessary rights.

set -o errexit
set -o nounset

LAST_PROMOTE_FILE_TRUNK_NIGHTLY=/opt/public/modeling/mdt/papyrus/papyrus-trunk-nightly/lastPromoteRef
PROMOTE_SIGNAL_TRUNK_NIGHTLY=/opt/public/modeling/mdt/papyrus/papyrus-trunk-nightly/promoteSignal
PROMOTE_VERSION_TRUNK_NIGHTLY=/opt/public/modeling/mdt/papyrus/papyrus-trunk-nightly/promoteVersion

LAST_PROMOTE_FILE_TRUNK_EXTRA_NIGHTLY=/opt/public/modeling/mdt/papyrus/papyrus-trunk-extra-nightly/lastPromoteRef
PROMOTE_SIGNAL_TRUNK_EXTRA_NIGHTLY=/opt/public/modeling/mdt/papyrus/papyrus-trunk-extra-nightly/promoteSignal
PROMOTE_VERSION_TRUNK_EXTRA_NIGHTLY=/opt/public/modeling/mdt/papyrus/papyrus-trunk-extra-nightly/promoteVersion

LAST_PROMOTE_FILE_TRUNK_NIGHTLY_TESTS=/opt/public/modeling/mdt/papyrus/papyrus-trunk-nightly-tests/lastPromoteRef
PROMOTE_SIGNAL_TRUNK_NIGHTLY_TESTS=/opt/public/modeling/mdt/papyrus/papyrus-trunk-nightly-tests/promoteSignal
PROMOTE_VERSION_TRUNK_NIGHTLY_TESTS=/opt/public/modeling/mdt/papyrus/papyrus-trunk-nightly-tests/promoteVersion

LAST_PROMOTE_FILE_MAINTENANCE_NIGHTLY=/opt/public/modeling/mdt/papyrus/papyrus-0.8-maintenance-nightly/lastPromoteRef
PROMOTE_SIGNAL_MAINTENANCE_NIGHTLY=/opt/public/modeling/mdt/papyrus/papyrus-0.8-maintenance-nightly/promoteSignal
PROMOTE_VERSION_MAINTENANCE_NIGHTLY=/opt/public/modeling/mdt/papyrus/papyrus-0.8-maintenance-nightly/promoteVersion

LAST_PROMOTE_FILE_MAINTENANCE_EXTRA_NIGHTLY=/opt/public/modeling/mdt/papyrus/papyrus-0.8-maintenance-extra-nightly/lastPromoteRef
PROMOTE_SIGNAL_MAINTENANCE_EXTRA_NIGHTLY=/opt/public/modeling/mdt/papyrus/papyrus-0.8-maintenance-extra-nightly/promoteSignal
PROMOTE_VERSION_MAINTENANCE_EXTRA_NIGHTLY=/opt/public/modeling/mdt/papyrus/papyrus-0.8-maintenance-extra-nightly/promoteVersion

UPDATES_TRUNK_NIGHTLY=/home/data/httpd/download.eclipse.org/modeling/mdt/papyrus/updates/nightly/juno/main
UPDATES_TRUNK_EXTRA_NIGHTLY=/home/data/httpd/download.eclipse.org/modeling/mdt/papyrus/updates/nightly/juno/extra
UPDATES_MAINTENANCE_NIGHTLY=/home/data/httpd/download.eclipse.org/modeling/mdt/papyrus/updates/nightly/indigo/main
UPDATES_MAINTENANCE_EXTRA_NIGHTLY=/home/data/httpd/download.eclipse.org/modeling/mdt/papyrus/updates/nightly/indigo/extra

DROPS_DIR=/home/data/httpd/download.eclipse.org/modeling/mdt/papyrus/downloads/drops

ARCHIVE_DIR=/home/data/httpd/archive.eclipse.org/modeling/mdt/papyrus/downloads/drops
ARCHIVE_INDEX=/home/data/httpd/archive.eclipse.org/modeling/mdt/papyrus/downloads/index.html

# constants required by promoteFunctions.sh
export ADD_DOWNLOAD_STATS=/opt/public/modeling/mdt/papyrus/addDownloadStats.sh

# include promote functions
source $(dirname $0)/promoteFunctions.sh

DATE=$(date +%Y%m%d-%H%M)

echo "[$DATE] starting cronPromote.sh --------------------------------------------------"

if [ ! -e $LAST_PROMOTE_FILE_TRUNK_NIGHTLY ]; then touch $LAST_PROMOTE_FILE_TRUNK_NIGHTLY; fi
if [ ! -e $LAST_PROMOTE_FILE_TRUNK_EXTRA_NIGHTLY ]; then touch $LAST_PROMOTE_FILE_TRUNK_EXTRA_NIGHTLY; fi
if [ ! -e $LAST_PROMOTE_FILE_TRUNK_NIGHTLY_TESTS ]; then touch $LAST_PROMOTE_FILE_TRUNK_NIGHTLY_TESTS; fi
if [ ! -e $LAST_PROMOTE_FILE_MAINTENANCE_NIGHTLY ]; then touch $LAST_PROMOTE_FILE_MAINTENANCE_NIGHTLY; fi
if [ ! -e $LAST_PROMOTE_FILE_MAINTENANCE_EXTRA_NIGHTLY ]; then touch $LAST_PROMOTE_FILE_MAINTENANCE_EXTRA_NIGHTLY; fi

if [ ! -e $PROMOTE_SIGNAL_TRUNK_NIGHTLY ]; then echo "$DATE: ERROR: $PROMOTE_SIGNAL_TRUNK_NIGHTLY not found"; exit 1; fi
if [ ! -e $PROMOTE_SIGNAL_TRUNK_EXTRA_NIGHTLY ]; then echo "$DATE: ERROR: $PROMOTE_SIGNAL_TRUNK_EXTRA_NIGHTLY not found"; exit 1; fi
if [ ! -e $PROMOTE_SIGNAL_TRUNK_NIGHTLY_TESTS ]; then echo "$DATE: ERROR: $PROMOTE_SIGNAL_TRUNK_NIGHTLY_TESTS not found"; exit 1; fi
if [ ! -e $PROMOTE_SIGNAL_MAINTENANCE_NIGHTLY ]; then echo "$DATE: ERROR: $PROMOTE_SIGNAL_MAINTENANCE_NIGHTLY not found"; exit 1; fi
if [ ! -e $PROMOTE_SIGNAL_MAINTENANCE_EXTRA_NIGHTLY ]; then echo "$DATE: ERROR: $PROMOTE_SIGNAL_MAINTENANCE_EXTRA_NIGHTLY not found"; exit 1; fi

signalDateTrunkNightly=$(stat --format=%Y $PROMOTE_SIGNAL_TRUNK_NIGHTLY)
signalDateTrunkExtraNightly=$(stat --format=%Y $PROMOTE_SIGNAL_TRUNK_EXTRA_NIGHTLY)
signalDateTrunkNightlyTests=$(stat --format=%Y $PROMOTE_SIGNAL_TRUNK_NIGHTLY_TESTS)
signalDateMaintenanceNightly=$(stat --format=%Y $PROMOTE_SIGNAL_MAINTENANCE_NIGHTLY)
signalDateMaintenanceExtraNightly=$(stat --format=%Y $PROMOTE_SIGNAL_MAINTENANCE_EXTRA_NIGHTLY)

lastPromoteDateTrunkNightly=$(stat --format=%Y $LAST_PROMOTE_FILE_TRUNK_NIGHTLY)
lastPromoteDateTrunkExtraNightly=$(stat --format=%Y $LAST_PROMOTE_FILE_TRUNK_EXTRA_NIGHTLY)
lastPromoteDateTrunkNightlyTests=$(stat --format=%Y $LAST_PROMOTE_FILE_TRUNK_NIGHTLY_TESTS)
lastPromoteDateMaintenanceNightly=$(stat --format=%Y $LAST_PROMOTE_FILE_MAINTENANCE_NIGHTLY)
lastPromoteDateMaintenanceExtraNightly=$(stat --format=%Y $LAST_PROMOTE_FILE_MAINTENANCE_EXTRA_NIGHTLY)

if [ $signalDateTrunkNightly -gt $lastPromoteDateTrunkNightly ]; then
	# mark the promote as done
	touch "$LAST_PROMOTE_FILE_TRUNK_NIGHTLY"
	buildName=$(cat "$PROMOTE_SIGNAL_TRUNK_NIGHTLY")
	zipName=${buildName}.zip
	version=$(cat "$PROMOTE_VERSION_TRUNK_NIGHTLY")
	
	echo "[$DATE] deleting previous nightly update site"
	rm -rf "$UPDATES_TRUNK_NIGHTLY"
	
	buildsDir="$DROPS_DIR/$version"
	echo "[$DATE] pruning old builds"
	prune N "$buildsDir" 4

	nfsURL="/shared/jobs/papyrus-trunk-nightly/lastSuccessful/archive/"
	hudsonURL="https://hudson.eclipse.org/hudson/job/papyrus-trunk-nightly/lastSuccessfulBuild/artifact/"
	export SVN_DIRECTORIES_TO_TAG=( )
	promote "$zipName" "$version" "$nfsURL" "$hudsonURL" "$DROPS_DIR" "$ARCHIVE_DIR" "$ARCHIVE_INDEX" "$UPDATES_TRUNK_NIGHTLY" "Papyrus-Update-" "NA"

	echo "[$DATE] promote done"
	
	echo "[$DATE] triggering Hudson tests build"
	json='{"parameter": [
		{"name": "BUILD_ID", "value": "'${buildName}'"},
		{"name": "BUILD_VERSION", "value": "'${version}'"},
		{"name": "BUCKMINSTER_LOGLEVEL", "value": "DEBUG"},
		{"name": "CLEAN_TP", "value": "true"},
		{"name": "CLEAN_WORKSPACE", "value": "true"},
		{"name": "CLEAN_OUTPUT", "value": "true"},
		{"name": "CLEAN_TOOLS", "value": "false"},
		{"name": "BUILD_TARGET", "value": "test"}
	], "": ""}'
	curl -X POST https://hudson.eclipse.org/hudson/job/papyrus-trunk-nightly-tests/build -d token=token --data-urlencode json="$json"

	echo "[$DATE] triggering Hudson extras build"
	json='{"parameter": [
		{"name": "BUILD_ID", "value": "'${buildName}'"},
		{"name": "BUILD_VERSION", "value": "'${version}'"},
		{"name": "BUCKMINSTER_LOGLEVEL", "value": "DEBUG"},
		{"name": "CLEAN_TP", "value": "true"},
		{"name": "CLEAN_WORKSPACE", "value": "true"},
		{"name": "CLEAN_OUTPUT", "value": "true"},
		{"name": "CLEAN_TOOLS", "value": "false"},
		{"name": "BUILD_TARGET", "value": "test"}
	], "": ""}'
	curl -X POST https://hudson.eclipse.org/hudson/job/papyrus-trunk-extra-nightly/build -d token=token --data-urlencode json="$json"

	echo "[$DATE] triggering Hudson 3.8 tests build"
	json='{"parameter": [
		{"name": "BUCKMINSTER_LOGLEVEL", "value": "DEBUG"},
		{"name": "CLEAN_TP", "value": "true"},
		{"name": "CLEAN_WORKSPACE", "value": "true"},
		{"name": "CLEAN_OUTPUT", "value": "true"},
		{"name": "CLEAN_TOOLS", "value": "false"},
		{"name": "BUILD_TARGET", "value": "test"}
	], "": ""}'
	curl -X POST https://hudson.eclipse.org/hudson/job/papyrus-trunk-nightly-3.8-tests/build -d token=token --data-urlencode json="$json"
fi

if [ $signalDateTrunkNightlyTests -gt $lastPromoteDateTrunkNightlyTests ]; then
	# mark the promote as done
	touch "$LAST_PROMOTE_FILE_TRUNK_NIGHTLY_TESTS"
	buildName=$(cat "$PROMOTE_SIGNAL_TRUNK_NIGHTLY_TESTS")
	zipName=Papyrus-TestResults-${buildName}.zip
	version=$(cat "$PROMOTE_VERSION_TRUNK_NIGHTLY_TESTS")
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
	chmod -R 775 "$buildsDir"
	chgrp -hR modeling.mdt.papyrus "$buildsDir"

	echo "[$DATE] promote done"
	
	# TODO: re-enable when the job is implemented
	# echo "[$DATE] triggering Hudson tests build"
	# curl https://hudson.eclipse.org/hudson/job/papyrus-trunk-extra-nightly-tests/buildWithParameters?token=token
fi

if [ $signalDateTrunkExtraNightly -gt $lastPromoteDateTrunkExtraNightly ]; then
	# mark the promote as done
	touch "$LAST_PROMOTE_FILE_TRUNK_EXTRA_NIGHTLY"
	zipName=$(cat "$PROMOTE_SIGNAL_TRUNK_EXTRA_NIGHTLY").zip
	version=$(cat "$PROMOTE_VERSION_TRUNK_EXTRA_NIGHTLY")
	
	echo "[$DATE] deleting previous nightly update site"
	rm -rf "$UPDATES_TRUNK_EXTRA_NIGHTLY"
	
	buildsDir="$DROPS_DIR/$version"
	echo "[$DATE] pruning old builds"
	prune N "$buildsDir" 4

	nfsURL="/shared/jobs/papyrus-trunk-extra-nightly/lastSuccessful/archive/"
	hudsonURL="https://hudson.eclipse.org/hudson/job/papyrus-trunk-extra-nightly/lastSuccessfulBuild/artifact/"
	export SVN_DIRECTORIES_TO_TAG=( )
	promote "$zipName" "$version" "$nfsURL" "$hudsonURL" "$DROPS_DIR" "$ARCHIVE_DIR" "$ARCHIVE_INDEX" "$UPDATES_TRUNK_EXTRA_NIGHTLY" "Papyrus-Extra-" "NA"

	echo "[$DATE] promote done"
	
	# TODO: re-enable when the job is implemented
	# echo "[$DATE] triggering Hudson tests build"
	# curl https://hudson.eclipse.org/hudson/job/papyrus-trunk-extra-nightly-tests/buildWithParameters?token=token
fi

if [ $signalDateMaintenanceNightly -gt $lastPromoteDateMaintenanceNightly ]; then
	# mark the promote as done
	touch "$LAST_PROMOTE_FILE_MAINTENANCE_NIGHTLY"
	zipName=$(cat "$PROMOTE_SIGNAL_MAINTENANCE_NIGHTLY").zip
	version=$(cat "$PROMOTE_VERSION_MAINTENANCE_NIGHTLY")
	
	echo "[$DATE] deleting previous nightly update site"
	rm -rf "$UPDATES_MAINTENANCE_NIGHTLY"
	
	buildsDir="$DROPS_DIR/$version"
	echo "[$DATE] pruning old builds"
	prune N "$buildsDir" 4

	nfsURL="/shared/jobs/papyrus-0.8-maintenance-nightly/lastSuccessful/archive/"
	hudsonURL="https://hudson.eclipse.org/hudson/job/papyrus-0.8-maintenance-nightly/lastSuccessfulBuild/artifact/"
	export SVN_DIRECTORIES_TO_TAG=( )
	promote "$zipName" "$version" "$nfsURL" "$hudsonURL" "$DROPS_DIR" "$ARCHIVE_DIR" "$ARCHIVE_INDEX" "$UPDATES_MAINTENANCE_NIGHTLY" "Papyrus-Update-" "NA"

	echo "[$DATE] done"
fi

if [ $signalDateMaintenanceExtraNightly -gt $lastPromoteDateMaintenanceExtraNightly ]; then
	# mark the promote as done
	touch "$LAST_PROMOTE_FILE_MAINTENANCE_EXTRA_NIGHTLY"
	zipName=$(cat "$PROMOTE_SIGNAL_MAINTENANCE_EXTRA_NIGHTLY").zip
	version=$(cat "$PROMOTE_VERSION_MAINTENANCE_EXTRA_NIGHTLY")
	
	echo "[$DATE] deleting previous nightly update site"
	rm -rf "$UPDATES_MAINTENANCE_EXTRA_NIGHTLY"
	
	buildsDir="$DROPS_DIR/$version"
	echo "[$DATE] pruning old builds"
	prune N "$buildsDir" 4

	nfsURL="/shared/jobs/papyrus-0.8-maintenance-extra-nightly/lastSuccessful/archive/"
	hudsonURL="https://hudson.eclipse.org/hudson/job/papyrus-0.8-maintenance-extra-nightly/lastSuccessfulBuild/artifact/"
	export SVN_DIRECTORIES_TO_TAG=( )
	promote "$zipName" "$version" "$nfsURL" "$hudsonURL" "$DROPS_DIR" "$ARCHIVE_DIR" "$ARCHIVE_INDEX" "$UPDATES_MAINTENANCE_EXTRA_NIGHTLY" "PapyrusExtra-Update-" "NA"

	echo "[$DATE] done"
fi
