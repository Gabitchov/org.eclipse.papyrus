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
if [ ! -e $LAST_PROMOTE_FILE_MAINTENANCE_NIGHTLY ]; then touch $LAST_PROMOTE_FILE_MAINTENANCE_NIGHTLY; fi
if [ ! -e $LAST_PROMOTE_FILE_MAINTENANCE_EXTRA_NIGHTLY ]; then touch $LAST_PROMOTE_FILE_MAINTENANCE_EXTRA_NIGHTLY; fi

if [ ! -e $PROMOTE_SIGNAL_TRUNK_NIGHTLY ]; then echo "$DATE: ERROR: $PROMOTE_SIGNAL_TRUNK_NIGHTLY not found"; exit 1; fi
if [ ! -e $PROMOTE_SIGNAL_TRUNK_EXTRA_NIGHTLY ]; then echo "$DATE: ERROR: $PROMOTE_SIGNAL_TRUNK_EXTRA_NIGHTLY not found"; exit 1; fi
if [ ! -e $PROMOTE_SIGNAL_MAINTENANCE_NIGHTLY ]; then echo "$DATE: ERROR: $PROMOTE_SIGNAL_MAINTENANCE_NIGHTLY not found"; exit 1; fi
if [ ! -e $PROMOTE_SIGNAL_MAINTENANCE_EXTRA_NIGHTLY ]; then echo "$DATE: ERROR: $PROMOTE_SIGNAL_MAINTENANCE_EXTRA_NIGHTLY not found"; exit 1; fi

signalDateTrunkNightly=$(stat --format=%Y $PROMOTE_SIGNAL_TRUNK_NIGHTLY)
signalDateTrunkExtraNightly=$(stat --format=%Y $PROMOTE_SIGNAL_TRUNK_EXTRA_NIGHTLY)
signalDateMaintenanceNightly=$(stat --format=%Y $PROMOTE_SIGNAL_MAINTENANCE_NIGHTLY)
signalDateMaintenanceExtraNightly=$(stat --format=%Y $PROMOTE_SIGNAL_MAINTENANCE_EXTRA_NIGHTLY)

lastPromoteDateTrunkNightly=$(stat --format=%Y $LAST_PROMOTE_FILE_TRUNK_NIGHTLY)
lastPromoteDateTrunkExtraNightly=$(stat --format=%Y $LAST_PROMOTE_FILE_TRUNK_EXTRA_NIGHTLY)
lastPromoteDateMaintenanceNightly=$(stat --format=%Y $LAST_PROMOTE_FILE_MAINTENANCE_NIGHTLY)
lastPromoteDateMaintenanceExtraNightly=$(stat --format=%Y $LAST_PROMOTE_FILE_MAINTENANCE_EXTRA_NIGHTLY)

if [ $signalDateTrunkNightly -gt $lastPromoteDateTrunkNightly ]; then
	# mark the promote as done
	touch "$LAST_PROMOTE_FILE_TRUNK_NIGHTLY"
	zipName=$(cat "$PROMOTE_SIGNAL_TRUNK_NIGHTLY").zip
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

	echo "[$DATE] done"
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
