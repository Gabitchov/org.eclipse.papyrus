#!/bin/bash

# Copyright (c) 2011 Mia-Software
# All rights reserved. This program and the accompanying materials
# are made available under the terms of the Eclipse Public License v1.0
# which accompanies this distribution, and is available at
# http://www.eclipse.org/legal/epl-v10.html
#
# Contributors:
#   Nicolas Bros (Mia-Software)

set -o errexit
set -o nounset

DROPS_DIR=/home/data/httpd/download.eclipse.org/facet/downloads/drops
ARCHIVE_DIR=/home/data/httpd/archive.eclipse.org/facet/downloads/drops
ARCHIVE_INDEX=/home/data/httpd/archive.eclipse.org/facet/downloads/index.html
UPDATE_SITES_DIR=/home/data/httpd/download.eclipse.org/facet/updates
ZIP_PREFIX="EMFFacet-Update-"
PROMOTE_FUNCTIONS_SH=/opt/public/modeling/emft/facet/promoteFunctions.sh
ADD_TO_COMPOSITE_SH=/opt/public/modeling/emft/facet/addToComposite.sh

SVN_DIRECTORIES_TO_TAG[0]="file:///svnroot/modeling/org.eclipse.emft.facet"

# constants required by promoteFunctions.sh
export INDEX_PHP=/opt/public/modeling/emft/facet/index.php
export ADD_DOWNLOAD_STATS=/opt/public/modeling/emft/facet/addDownloadStats.sh

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

echo "version (e.g. \"0.2.0\"): "
while [[ ! "$version" =~ ^[0-9]+\.[0-9]+\.[0-9]+$ ]]; do
	echo -n "? "
	read version
done

echo "jobName (emffacet-nightly|emffacet-nightly-maintenance|emffacet-integration): "
while [[ ! "$jobName" =~ ^(emffacet-nightly|emffacet-nightly-maintenance|emffacet-integration)$ ]]; do
	echo -n "? "
	read jobName
done

echo "updateSite (e.g. \"nightly\", \"nightly-maintenance\", \"milestones/0.2/M3\","
echo "    \"milestones/0.2/RC3\", \"milestones/0.2/SR1_RC2\", \"releases/0.2.0\") : "
while [[ ! "$updateSite" =~ ^(nightly|nightly-maintenance|milestones/[0-9]+\.[0-9]+/(M[1-7]|RC[1-9]|SR[1-9]_RC[1-9]|[0-9]+\.[0-9]\.[0-9]))$ ]]; do
	echo -n "? "
	read updateSite
done

echo "branchToTag (e.g. \"trunk\", \"branches/0_1\", \"NA\"): "
while [[ ! "$branchToTag" =~ ^(trunk|branches/[0-9]+_[0-9]+|NA)$ ]]; do
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

