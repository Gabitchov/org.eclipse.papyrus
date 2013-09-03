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

########## publishing ##########

p2UpdateSiteDir=${WORKSPACE}/buildroot/result/output/org.eclipse.papyrus.build.feature_*-eclipse.feature/site.p2
updateSite=/shared/jobs/${JOB_NAME}/updateSite

promoteSignal=/opt/public/modeling/mdt/papyrus/papyrus-trunk-nightly/promoteSignal
promoteVersion=/opt/public/modeling/mdt/papyrus/papyrus-trunk-nightly/promoteVersion
promoteDirName=/opt/public/modeling/mdt/papyrus/papyrus-trunk-nightly/promoteDirName

FULL_BUILD_ID=$(cat $promoteDirName)

if [ -n "$BUILD_ALIAS" ]; then
  updateZipName=Papyrus-Update-${BUILD_ALIAS}.zip
else
  updateZipName=Papyrus-Update-${FULL_BUILD_ID}.zip
fi
zipName="Papyrus-Main.zip"

rm -rf tmp
mkdir -p "tmp/$FULL_BUILD_ID"

rm -rf $updateSite
mv $p2UpdateSiteDir $updateSite

# create the update site zip
(cd $updateSite && zip -r $updateZipName *)
mv $updateSite/$updateZipName "tmp/$FULL_BUILD_ID"

# copy the generated psf files to the tmp dir
cp buildroot/result/*.psf "tmp/$FULL_BUILD_ID"

mv revision.txt "tmp/$FULL_BUILD_ID"

# copy the build log into the result
wget --no-check-certificate ${HUDSON_URL}/job/${JOB_NAME}/${BUILD_NUMBER}/consoleText -O "${WORKSPACE}/tmp/$FULL_BUILD_ID/buildlog.txt"

(cd tmp && zip -r $zipName *)
mv tmp/$zipName .

if [ "$BUILD_TYPE" == "N" ]; then
	echo ${FULL_BUILD_ID} > $promoteSignal
	echo $VERSION > $promoteVersion
fi
