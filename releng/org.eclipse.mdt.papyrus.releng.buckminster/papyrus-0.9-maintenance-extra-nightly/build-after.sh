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

p2UpdateSiteDir=${WORKSPACE}/buildroot/result/output/org.eclipse.papyrus.extra.build.feature_*-eclipse.feature/site.p2

promoteSignal=/opt/public/modeling/mdt/papyrus/papyrus-0.9-maintenance-extra-nightly/promoteSignal
promoteDirName=/opt/public/modeling/mdt/papyrus/papyrus-0.9-maintenance-extra-nightly/promoteDirName
# note: the version and build id used by the cronPromote.sh are taken from papyrus-0.9-maintenance-nightly

#FULL_BUILD_ID=$(cat $promoteDirName)
updateZipName=Papyrus-Extra-Update.zip
zipName=Papyrus-Extra.zip

rm -rf tmp
mkdir -p "tmp/extra"

# create the update site zip
(cd $p2UpdateSiteDir && zip -r $updateZipName *)
mv $p2UpdateSiteDir/$updateZipName "tmp/extra"

rm -rf updateSite
mv $p2UpdateSiteDir updateSite

mv revision.txt "tmp/extra"

# copy the build log into the result
wget --quiet --no-check-certificate ${HUDSON_URL}/job/${JOB_NAME}/${BUILD_NUMBER}/consoleText -O "${WORKSPACE}/tmp/extra/buildlog.txt"

(cd tmp && zip -r $zipName *)
mv tmp/$zipName .

if [ "$BUILD_TYPE" == "N" ]; then
	touch $promoteSignal
fi
