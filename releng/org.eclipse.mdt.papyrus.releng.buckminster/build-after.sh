########## publishing ##########

p2UpdateSiteDir=${WORKSPACE}/buildroot/result/output/org.eclipse.papyrus.build.feature_*-eclipse.feature/site.p2

promoteSignal=/opt/public/modeling/mdt/papyrus/papyrusBuildPromoteSignalN
promoteVersion=/opt/public/modeling/mdt/papyrus/papyrusBuildPromoteVersionN
promoteDirName=/opt/public/modeling/mdt/papyrus/papyrusBuildPromoteDirNameN
lastBuildLogFile=/opt/public/modeling/mdt/papyrus/lastBuildLogN

FULL_BUILD_ID=$(cat /opt/public/modeling/mdt/papyrus/papyrusBuildPromoteDirNameN)

if [ -n "$BUILD_ALIAS" ]; then
  zipName=Papyrus-Update-${BUILD_ALIAS}.zip
else
  zipName=Papyrus-Update-${FULL_BUILD_ID}.zip
fi

rm -rf ${WORKSPACE}/tmp
mkdir -p "${WORKSPACE}/tmp/$FULL_BUILD_ID"

# create the update site zip
(cd $p2UpdateSiteDir && zip -r $zipName *)
mv "$p2UpdateSiteDir/$zipName" "${WORKSPACE}/tmp/$FULL_BUILD_ID"

# copy the generated psf files to the tmp dir
cp ${WORKSPACE}/buildroot/result/*.psf "${WORKSPACE}/tmp/$FULL_BUILD_ID"

# copy tests results
if [ -e ${WORKSPACE}/buildroot/result/testresults ]; then
  mkdir ${WORKSPACE}/tmp/$FULL_BUILD_ID/testresults
  cp -r ${WORKSPACE}/buildroot/result/testresults/ "${WORKSPACE}/tmp/$FULL_BUILD_ID"
fi

# copy the build log into the result
wget --quiet --no-check-certificate ${HUDSON_URL}/job/${JOB_NAME}/${BUILD_NUMBER}/consoleText -O "$lastBuildLogFile"

cp "$lastBuildLogFile" "${WORKSPACE}/tmp/$FULL_BUILD_ID/buildlog.txt"

(cd tmp && zip -r ${FULL_BUILD_ID}.zip *)
mv tmp/${FULL_BUILD_ID}.zip .

echo ${FULL_BUILD_ID} > $promoteSignal
echo $VERSION > $promoteVersion
