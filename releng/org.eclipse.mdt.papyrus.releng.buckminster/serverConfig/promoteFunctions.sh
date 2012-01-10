#!/bin/bash -x

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

DATE=$(date +%Y%m%d-%H%M)

function prune() {
	NARGS=3
	if [ $# -ne $NARGS ]; then echo "$NARGS arguments expected"; exit 1; fi
	_kind=$1 # prefix: N for nightlies, I for integration, ...
	_filesPath=$2
	_nBuildsToKeep=$3

	ls -1 $_filesPath | grep "${_kind}20*" || return 0
	allFiles=$(ls -trd $_filesPath/${_kind}20*)
	nFiles=$(ls -1d $_filesPath/${_kind}20* | wc -l)
	nToDelete=$((nFiles-_nBuildsToKeep))

	if [ $nToDelete -gt 0 ]; then
		for file in $allFiles; do
			rm -rf $file
			nToDelete=$((nToDelete-1))
			if [ $nToDelete -le 0 ]; then break; fi
		done
	fi
}

function promote() {
	NARGS=10
	if [ $# -ne $NARGS ]; then echo "promote expects exactly $NARGS arguments"; exit 1; fi
	_zipName=$1
	_version=$2
	_nfsBaseDir=$3
	_hudsonBaseURL=$4
	_dropsDir=$5
	_archiveDir=$6
	_archiveIndex=$7
	_updateSite=$8
	_updateZipPrefix=$9
	_branchToTag=${10}
	
	dirBefore=$(pwd)
	
	[[ "$_zipName" =~ ^[NIMSR]20[0-9]{10}\.zip$ ]] || { echo "incorrect parameter: zipName"; exit 1; }
	[[ "$_version" =~ ^[0-9]+\.[0-9]+\.[0-9]+$ ]] || { echo "incorrect parameter: version"; exit 1; }
	[[ "$_nfsBaseDir" =~ ^/shared/jobs/.*$ ]] || { echo "incorrect parameter: nfsBaseDir"; exit 1; }
	[[ "$_hudsonBaseURL" =~ ^https://hudson\.eclipse\.org/hudson/job/.*$ ]] || { echo "incorrect parameter: hudsonBaseURL"; exit 1; }
	[[ "$_dropsDir" =~ ^/home/data/httpd/download\.eclipse\.org/.*$ ]] || { echo "incorrect parameter: dropsDir"; exit 1; }
	[[ "$_archiveDir" =~ ^/home/data/httpd/archive\.eclipse\.org/.*$ ]] || { echo "incorrect parameter: archiveDir"; exit 1; }
	[[ "$_archiveIndex" =~ ^/home/data/httpd/archive\.eclipse\.org/.*?/index\.html$ ]] || { echo "incorrect parameter: archiveIndex"; exit 1; }
	[[ "$_updateSite" =~ ^/home/data/httpd/download\.eclipse\.org/.*$ ]] || { echo "incorrect parameter: updateSite"; exit 1; }
	[ -n "$_updateZipPrefix" ] || { echo "empty parameter: updateZipPrefix"; exit 1; }
	[[ "$_branchToTag" =~ ^trunk|branches/[0-9]+_[0-9]+|NA$ ]] || { echo "incorrect parameter: branchToTag"; exit 1; }
	for (( i = 0 ; i < ${#SVN_DIRECTORIES_TO_TAG[*]} ; i++ )); do
		[[ "${SVN_DIRECTORIES_TO_TAG[$i]}" =~ ^/svnroot/.*$ ]] || { echo "incorrect variable: SVN_DIRECTORIES_TO_TAG"; exit 1; }
	done
		
	echo "[$DATE] creating working dir"
	workingDir=$(mktemp -d)
	cd "$workingDir"
	
	echo "[$DATE] getting last successful build"
	# try with NFS access first, and if that fails, use the Hudson REST API
	# see http://wiki.hudson-ci.org/display/HUDSON/Remote+access+API
	cp "$_nfsBaseDir/${_zipName}" . || wget --no-check-certificate "$_hudsonBaseURL/${_zipName}"
	if [ ! -f "$_zipName" ]; then echo "ERROR: $_zipName (from Hudson) not found"; exit -2; fi
	echo "[$DATE] Testing zip integrity"
	unzip -t "$_zipName"
	buildsDir="$_dropsDir/$_version"
	echo "[$DATE] publishing build (version='$_version') to the builds directory '$buildsDir'..."
	unzip -o "$_zipName" -d "$buildsDir"
	echo "[$DATE] publishing build (version='$_version') to the update site '$_updateSite'..."
	[ -d "$_updateSite" ] && { echo "Error: update site directory already exists"; exit 1; }
	# extract the zip in which there is the update site zip to a tmp dir
	tmpDrop=$(mktemp -d)
	unzip "$_zipName" -d "$tmpDrop"
	dirNameInZip=$(ls -1 "$tmpDrop")
	[ $(echo "$dirNameInZip" | wc -l) == 1 ] || { echo "one directory expected in zip"; exit 1; }
	updateSiteZipName=$(basename $(ls -1 "$tmpDrop/$dirNameInZip/${_updateZipPrefix}"*.zip))
	unzip -o "$tmpDrop/$dirNameInZip/${updateSiteZipName}" -d "$_updateSite"
	#echo "[$DATE] adding index.php"
	#cp $INDEX_PHP "$_updateSite/"
	echo "[$DATE] enabling download statistics"
	$ADD_DOWNLOAD_STATS "$_updateSite"
	echo "[$DATE] setting access rights"
	chmod -R 755 "$buildsDir"
	chmod -R 755 "$_updateSite"
	
	# copy milestone and release builds to the archive, and tag the build
	if [[ "$_zipName" =~ ^[MSR].*$ && "${_branchToTag}" != "NA" ]]; then
		echo "copying the build to the archive"
		unzip "$_zipName" -d "${_archiveDir}/${_version}"
		cp "${_archiveIndex}" "${_archiveIndex}.bak"
		# Papyrus-Update-0.9.0M4.zip -> 0.9.0M4
		buildAlias=$(echo $updateSiteZipName | sed 's/^.*-\(.*\)\.zip/\1/g')
		# <li><a href="drops/0.9.0/S201112130437/Papyrus-Update-0.9.0M4.zip">0.9.0M4</a>
		echo "adding reference to ${buildAlias} in the archive's index.html"
		sed 's%<!--$$$_INSERT_HERE_$$$-->%<li><a href="drops/'${_version}'/'${dirNameInZip}'/'${updateSiteZipName}'">'${buildAlias}'<\/a>\n<!--$$$_INSERT_HERE_$$$-->%' "${_archiveIndex}.bak" > "${_archiveIndex}"

		echo "tagging the build"
		# "S201112140456.zip" and "0.9.0M4" => S0_9_0M4
		tagName=$(echo "${_zipName}" | sed 's/^\([MSR]\).*$/\1/g')$(echo "$buildAlias" | sed 's/\./_/g')
		revisionToTag=$(cat "$tmpDrop/$dirNameInZip/revision.txt")
		
		for (( i = 0 ; i < ${#SVN_DIRECTORIES_TO_TAG[*]} ; i++ )); do
			fromSvnDir="${SVN_DIRECTORIES_TO_TAG[$i]}/${_branchToTag}"
			toSvnDir="${SVN_DIRECTORIES_TO_TAG[$i]}/tags/$tagName"
			echo "tagging: copying revision '$revisionToTag' from ${_branchToTag} of '$fromSvnDir' to '$toSvnDir'"
			svn copy -r "$revisionToTag" "$fromSvnDir" "$toSvnDir" -m "tagging $tagName with revision $revisionToTag from ${_branchToTag}"
		done
	fi

	cd ${dirBefore}
	echo "[$DATE] deleting working dir"
	rm -rf "$workingDir"
	rm -rf "$tmpDrop"
}