#!/bin/bash

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

set -o errexit
set -o nounset

DROPS_DIR=/home/data/httpd/download.eclipse.org/modeling/mdt/papyrus/downloads/drops
ARCHIVE_DIR=/home/data/httpd/archive.eclipse.org/modeling/mdt/papyrus/downloads/drops
ARCHIVE_INDEX=/home/data/httpd/archive.eclipse.org/modeling/mdt/papyrus/downloads/index.html
UPDATE_SITES_DIR=/home/data/httpd/download.eclipse.org/modeling/mdt/papyrus/updates
ZIP_PREFIX="Papyrus-Update-incubation"
PROMOTE_FUNCTIONS_SH=/opt/public/modeling/mdt/papyrus/promoteFunctions.sh
ADD_TO_COMPOSITE_SH=/opt/public/modeling/mdt/papyrus/addToComposite.sh

SVN_DIRECTORIES_TO_TAG[0]="file:///svnroot/modeling/org.eclipse.mdt.papyrus"

# constants required by promoteFunctions.sh
export ADD_DOWNLOAD_STATS=/opt/public/modeling/mdt/papyrus/addDownloadStats.sh

# include promote functions
source "$PROMOTE_FUNCTIONS_SH"

# ============================== USER PARAMETERS ==============================

echo "-------------------- user parameters --------------------"
mainBuildNumber=""
extrasBuildNumber=""
testsBuildNumber=""
version=""
updateSite=""
sure=""

echo "mainBuildNumber (the number of the \"papyrus-0.10-maintenance-nightly\" Hudson build from which to publish the main Papyrus plug-ins): "
while [[ ! "$mainBuildNumber" =~ ^[0-9]+$ || "$mainBuildNumber" < 1 ]]; do
	echo -n "? "
	read mainBuildNumber
done

echo "extrasBuildNumber (the number of the \"papyrus-0.10-maintenance-extra-nightly\" Hudson build from which to publish the extra Papyrus plug-ins, or 0 to not publish): "
while [[ ! "$extrasBuildNumber" =~ ^[0-9]+$ || "$extrasBuildNumber" < 0 ]]; do
	echo -n "? "
	read extrasBuildNumber
done

echo "testsBuildNumber (the number of the \"papyrus-0.10-maintenance-nightly-tests\" Hudson build from which to publish the test results, or 0 to not publish): "
while [[ ! "$testsBuildNumber" =~ ^[0-9]+$ || "$testsBuildNumber" < 0 ]]; do
	echo -n "? "
	read testsBuildNumber
done

echo "version (e.g. \"0.10.0\"): "
while [[ ! "$version" =~ ^[0-9]+\.[0-9]+\.[0-9]+$ ]]; do
	echo -n "? "
	read version
done

echo "updateSite (e.g. \"nightly/kepler\", \"milestones/0.10/M5\", \"releases/kepler/0.10.1\") : "
while [[ ! "$updateSite" =~ ^(tmpTest|releases/(indigo|juno|kepler|luna)/[0-9]+\.[0-9]\.[0-9]|milestones/[0-9]+\.[0-9]+/(M[1-7]|RC[1-9]|SR[1-9]_RC[1-9])|nightly/(indigo|juno|kepler|luna))$ ]]; do
	echo -n "? "
	read updateSite
done

updateSiteDir="$UPDATE_SITES_DIR/$updateSite"

deleteUpdateSite=""
if [ -e "$updateSiteDir" ]; then
	echo "The update site already exists: $updateSiteDir"
	echo "Do you want to delete it (yes|no)?"
	while [[ ! "$deleteUpdateSite" =~ ^(yes|no)$ ]]; do
		echo -n "? "
		read deleteUpdateSite
	done
	if [ "$deleteUpdateSite" != "yes" ]; then echo "Canceled."; exit 1; fi
	rm -rf "$updateSiteDir"
fi


echo "Are you sure you want to publish with these parameters (yes|no)?"
while [[ ! "$sure" =~ ^(yes|no)$ ]]; do
	echo -n "? "
	read sure
done

if [ "$sure" != "yes" ]; then echo "Canceled."; exit 1; fi

# from now on, display executed commands
set -x

dirBefore=$(pwd)
echo "[$DATE] creating working dir"
workingDir=$(mktemp -d)
cd "$workingDir"

# ============================== PUBLISH MAIN ==============================
nfsURL="/shared/jobs/papyrus-0.10-maintenance-nightly/builds/$mainBuildNumber/archive/"
hudsonURL="https://hudson.eclipse.org/hudson/job/papyrus-0.10-maintenance-nightly/$mainBuildNumber/artifact/"
zipName="Papyrus-Main.zip"
updateZipPrefix="Papyrus-Update-incubation"
getZip "$zipName" "$nfsURL" "$hudsonURL"

mkdir -p "$updateSiteDir"

buildsDir="$DROPS_DIR/$version"
echo "publishing build (version='$version') to the builds directory '$buildsDir'..."
unzip -o "$zipName" -d "$buildsDir"

foldersInZip=$(unzip -t "$zipName" | egrep "testing: *[^/]*/ +OK" | sed 's%^ *testing: *\([^/]*\)/ *OK$%\1%')
[ $(echo "$foldersInZip" | wc -l) == 1 ] || { echo "one directory expected in zip"; exit 1; }
folderName="$foldersInZip"

updateSiteZipName=$(basename $(ls -1 "$buildsDir/$folderName/${updateZipPrefix}"*.zip))
unzip -o "$buildsDir/$folderName/${updateSiteZipName}" -d "$updateSiteDir/main"

# create the composite update site
cat > "$updateSiteDir/compositeArtifacts.xml" <<EOF
<?xml version="1.0" encoding="UTF-8"?>
<repository name="Papyrus" type="org.eclipse.equinox.internal.p2.artifact.repository.CompositeArtifactRepository" version="1.0.0">
  <properties size="1">
    <property name="p2.timestamp" value="$(date +%s000)"/>
  </properties>
  <children size="2">
    <child location="main"/>
    <child location="extra"/>
  </children>
</repository>
EOF

cat > "$updateSiteDir/compositeContent.xml" <<EOF
<?xml version="1.0" encoding="UTF-8"?>
<repository name="Papyrus" type="org.eclipse.equinox.internal.p2.metadata.repository.CompositeMetadataRepository" version="1.0.0">
  <properties size="1">
    <property name="p2.timestamp" value="$(date +%s000)"/>
  </properties>
  <children size="2">
    <child location="main"/>
    <child location="extra"/>
  </children>
</repository>
EOF

$ADD_DOWNLOAD_STATS "$updateSiteDir/main" "main"

# ============================== PUBLISH EXTRAS ==============================
if [[ "$extrasBuildNumber" != "0" ]]; then
	nfsURL="/shared/jobs/papyrus-0.10-maintenance-extra-nightly/builds/$extrasBuildNumber/archive/"
	hudsonURL="https://hudson.eclipse.org/hudson/job/papyrus-0.10-maintenance-extra-nightly/$extrasBuildNumber/artifact/"
	zipName="Papyrus-Extra.zip"
	updateZipName="Papyrus-Extra-Update.zip"
	getZip "$zipName" "$nfsURL" "$hudsonURL"
	# unzips under an "extra" folder under the main build's folder
	unzip -o "$zipName" -d "$buildsDir/$folderName"
	unzip -o "$buildsDir/$folderName/extra/$updateZipName" -d "$updateSiteDir/extra"
	
	$ADD_DOWNLOAD_STATS "$updateSiteDir/extra" "extra"
fi

# ============================== PUBLISH TESTS ==============================
if [[ "$testsBuildNumber" != "0" ]]; then
	nfsURL="/shared/jobs/papyrus-0.10-maintenance-nightly-tests/builds/$testsBuildNumber/archive/"
	hudsonURL="https://hudson.eclipse.org/hudson/job/papyrus-0.10-maintenance-nightly-tests/$testsBuildNumber/artifact/"
	zipName="Papyrus-TestResults.zip"
	getZip "$zipName" "$nfsURL" "$hudsonURL"
	# unzips under a "testresults" folder under the main build's folder 
	unzip -o "$zipName" -d "$buildsDir/$folderName"
fi


setAccessRights "$buildsDir/$folderName"
setAccessRights "$updateSiteDir"

echo "publishing done."
