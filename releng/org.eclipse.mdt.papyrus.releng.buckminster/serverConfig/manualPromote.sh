#!/bin/bash

# Copyright (c) 2011-2012 Mia-Software
# All rights reserved. This program and the accompanying materials
# are made available under the terms of the Eclipse Public License v1.0
# which accompanies this distribution, and is available at
# http://www.eclipse.org/legal/epl-v10.html
#
# Contributors:
#   Nicolas Bros (Mia-Software)

set -o errexit
set -o nounset

DROPS_DIR=/home/data/httpd/download.eclipse.org/modeling/mdt/papyrus/downloads/drops
ARCHIVE_DIR=/home/data/httpd/archive.eclipse.org/modeling/mdt/papyrus/downloads/drops
ARCHIVE_INDEX=/home/data/httpd/archive.eclipse.org/modeling/mdt/papyrus/downloads/index.html
UPDATE_SITES_DIR=/home/data/httpd/download.eclipse.org/modeling/mdt/papyrus/updates
ZIP_PREFIX="Papyrus-Update-"
PROMOTE_FUNCTIONS_SH=/opt/public/modeling/mdt/papyrus/promoteFunctions.sh
ADD_TO_COMPOSITE_SH=/opt/public/modeling/mdt/papyrus/addToComposite.sh

SVN_DIRECTORIES_TO_TAG[0]="file:///svnroot/modeling/org.eclipse.mdt.papyrus"

# constants required by promoteFunctions.sh
export ADD_DOWNLOAD_STATS=/opt/public/modeling/mdt/papyrus/addDownloadStats.sh

# include promote functions
source "$PROMOTE_FUNCTIONS_SH"

echo "-------------------- user parameters --------------------"
zipName=""
version=""
jobName=""
updateSite=""
branchToTag=""
sure=""

echo "mainBuildNumber (the number of the \"papyrus-trunk-nightly\" Hudson build from which to publish the main Papyrus plug-ins): "
while [[ ! "$mainBuildNumber" =~ ^[0-9]+$ || "$mainBuildNumber" < 1 ]]; do
	echo -n "? "
	read mainBuildNumber
done

echo "extrasBuildNumber (the number of the \"papyrus-trunk-extra-nightly\" Hudson build from which to publish the extra Papyrus plug-ins, or 0 to not publish): "
while [[ ! "$extrasBuildNumber" =~ ^[0-9]+$ || "$extrasBuildNumber" < 0 ]]; do
	echo -n "? "
	read extrasBuildNumber
done

echo "testsBuildNumber (the number of the \"papyrus-trunk-nightly-tests\" Hudson build from which to publish the test results, or 0 to not publish): "
while [[ ! "$testsBuildNumber" =~ ^[0-9]+$ || "$testsBuildNumber" < 0 ]]; do
	echo -n "? "
	read testsBuildNumber
done

echo "version (e.g. \"0.9.0\"): "
while [[ ! "$version" =~ ^[0-9]+\.[0-9]+\.[0-9]+$ ]]; do
	echo -n "? "
	read version
done

echo "updateSite (e.g. \"nightly/juno/main\", \"milestones/0.9/M5\", \"releases/indigo\") : "
while [[ ! "$updateSite" =~ ^(nightly/(indigo|juno)/main|milestones/[0-9]+\.[0-9]+/(M[1-7]|RC[1-9]|SR[1-9]_RC[1-9]|[0-9]+\.[0-9]\.[0-9])|releases/[a-z]+)$ ]]; do
	echo -n "? "
	read updateSite
done

echo "branchToTag (e.g. \"trunk\", \"branches/0_1\", \"NA\"): "
while [[ ! "$branchToTag" =~ ^(trunk|branches/.+?|NA)$ ]]; do
	echo -n "? "
	read branchToTag
done

echo "Are you sure you want to publish with these parameters (yes|no)?"
while [[ ! "$sure" =~ ^(yes|no)$ ]]; do
	echo -n "? "
	read sure
done

if [ "$sure" != "yes" ]; then echo "Canceled."; exit 1; fi


dirBefore=$(pwd)
echo "[$DATE] creating working dir"
workingDir=$(mktemp -d)
cd "$workingDir"

if [[ "$mainBuildNumber" != "0" ]]; then
	nfsURL="/shared/jobs/papyrus-trunk-nightly/builds/$mainBuildNumber/archive/"
	hudsonURL="https://hudson.eclipse.org/hudson/job/papyrus-trunk-nightly/$mainBuildNumber/artifact/"
	zipName="Papyrus-Main.zip"
	getZip "$zipName" "$nfsURL" "$hudsonURL"
	
	buildsDir="$DROPS_DIR/$version"
	echo "publishing build (version='$version') to the builds directory '$buildsDir'..."
	unzip -o "$zipName" -d "$buildsDir"
	
	foldersInZip=$(unzip -t "$zipName" | egrep "testing: *[^/]*/ +OK" | sed 's%^ *testing: *\([^/]*\)/ *OK$%\1%')
	[ $(echo "$foldersInZip" | wc -l) == 1 ] || { echo "one directory expected in zip"; exit 1; }
	folderName="$foldersInZip"
fi

if [[ "$extrasBuildNumber" != "0" ]]; then
	nfsURL="/shared/jobs/papyrus-trunk-extra-nightly/builds/$extrasBuildNumber/archive/"
	hudsonURL="https://hudson.eclipse.org/hudson/job/papyrus-trunk-extra-nightly/$extrasBuildNumber/artifact/"
	getZip "Papyrus-Extra.zip" "$nfsURL" "$hudsonURL"
fi

if [[ "$testsBuildNumber" != "0" ]]; then
	nfsURL="/shared/jobs/papyrus-trunk-nightly-tests/builds/$testsBuildNumber/archive/"
	hudsonURL="https://hudson.eclipse.org/hudson/job/papyrus-trunk-nightly-tests/$testsBuildNumber/artifact/"
	getZip "Papyrus-TestResults.zip" "$nfsURL" "$hudsonURL"
fi





updateSiteDir="$UPDATE_SITES_DIR/$updateSite"
nfsURL="/shared/jobs/$jobName/lastSuccessful/archive"
hudsonURL="https://hudson.eclipse.org/hudson/job/$jobName/lastSuccessfulBuild/artifact"

echo "---------------------------------------------------------"
echo "zipName     = $zipName"
echo "version     = $version"
echo "jobName     = $jobName"
echo "updateSite  = $updateSite"
echo "branchToTag = $branchToTag"
echo "---"
echo "ZIP_PREFIX    = $ZIP_PREFIX"
echo "DROPS_DIR     = $DROPS_DIR"
echo "NFS zip       = $nfsURL/$zipName"
echo "Hudson zip    = $hudsonURL/$zipName"
echo "updateSiteDir = $updateSiteDir"
echo




echo "Publishing..."

promote "$zipName" "$version" "$nfsURL" "$hudsonURL" "$DROPS_DIR" "$ARCHIVE_DIR" "$ARCHIVE_INDEX" "$updateSiteDir" "$ZIP_PREFIX" "$branchToTag"

# if the new update site is under a composite, then add the child to the composite definition
parentDir=$(dirname $updateSiteDir)
if [ -f "$parentDir/compositeContent.xml" ]; then
	echo "composite detected: adding new child update site"
	"$ADD_TO_COMPOSITE_SH" "$parentDir" $(basename ${updateSiteDir})
fi

# TODO: promote extras and tests, to downloads, update site and archive
