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

set -o errexit
set -o nounset

XSLT_FILE=/opt/public/modeling/mdt/papyrus/addToComposite.xsl

[ $# -eq 2 ] || (echo "usage: $0 <compositeUpdateSite> <newChildName>"; exit 1)
_compositeUpdateSite=$1
_newChildName=$2

newTimeStamp=$(date +%s000)

[[ "$_compositeUpdateSite" =~ ^/home/data/httpd/download\.eclipse\.org/.*$ ]] || (echo "incorrect parameter: compositeUpdateSite"; exit 1)
[[ "$_newChildName" =~ ^M[1-7]|RC[1-9]|SR[1-9]_RC[1-9]|[0-9]+\.[0-9]\.[0-9]$ ]] || (echo "incorrect parameter: newChildName"; exit 1)

[ -d "$_compositeUpdateSite" ] || (echo "compositeUpdateSite is not a directory"; exit 1)
[ -f "$_compositeUpdateSite/compositeArtifacts.xml" ] || (echo "compositeArtifacts.xml not found"; exit 1)
[ -f "$_compositeUpdateSite/compositeContent.xml" ] || (echo "compositeContent.xml not found"; exit 1)

echo "Adding the new child '${_newChildName}' to the composite update site ${_compositeUpdateSite}"


cd "${_compositeUpdateSite}"
mv compositeArtifacts.xml compositeArtifacts.xml.bak
mv compositeContent.xml compositeContent.xml.bak

echo "Updating compositeContent.xml"
xsltproc --stringparam newChild "${_newChildName}" --stringparam newTimestamp ${newTimeStamp} -o compositeContent.xml ${XSLT_FILE} compositeContent.xml.bak
echo "Updating compositeArtifacts.xml"
xsltproc --stringparam newChild "${_newChildName}" --stringparam newTimestamp ${newTimeStamp} -o compositeArtifacts.xml ${XSLT_FILE} compositeArtifacts.xml.bak

echo "done."
