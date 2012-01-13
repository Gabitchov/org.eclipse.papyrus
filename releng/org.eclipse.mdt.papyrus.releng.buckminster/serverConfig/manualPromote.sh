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

echo "zipName (e.g. \"N201112220427.zip\"): "
while [[ ! "$zipName" =~ ^[NIMSR]20[0-9]{10}\.zip$ ]]; do
	echo -n "? "
	read zipName
done

echo "version (e.g. \"0.9.0\"): "
while [[ ! "$version" =~ ^[0-9]+\.[0-9]+\.[0-9]+$ ]]; do
	echo -n "? "
	read version
done

echo "jobName (papyrus-trunk-nightly|papyrus-0.8-maintenance-nightly): "
while [[ ! "$jobName" =~ ^(papyrus-trunk-nightly|papyrus-0.8-maintenance-nightly)$ ]]; do
	echo -n "? "
	read jobName
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

echo "Are you sure you want to publish with these parameters (yes|no)?"
while [[ ! "$sure" =~ ^(yes|no)$ ]]; do
	echo -n "? "
	read sure
done

if [ "$sure" != "yes" ]; then echo "Canceled."; exit 1; fi

echo "Publishing..."

promote "$zipName" "$version" "$nfsURL" "$hudsonURL" "$DROPS_DIR" "$ARCHIVE_DIR" "$ARCHIVE_INDEX" "$updateSiteDir" "$ZIP_PREFIX" "$branchToTag"

# if the new update site is under a composite, then add the child to the composite definition
parentDir=$(dirname $updateSiteDir)
if [ -f "$parentDir/compositeContent.xml" ]; then
	echo "composite detected: adding new child update site"
	"$ADD_TO_COMPOSITE_SH" "$parentDir" $(basename ${updateSiteDir})
fi

# TODO: promote extras and tests, to downloads, update site and archive
