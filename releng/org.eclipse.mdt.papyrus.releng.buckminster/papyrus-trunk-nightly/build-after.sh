########## publishing ##########

p2UpdateSiteDir=${WORKSPACE}/buildroot/result/output/org.eclipse.papyrus.build.feature_*-eclipse.feature/site.p2

promoteSignal=/opt/public/modeling/mdt/papyrus/papyrus-trunk-nightly/promoteSignal
promoteVersion=/opt/public/modeling/mdt/papyrus/papyrus-trunk-nightly/promoteVersion
promoteDirName=/opt/public/modeling/mdt/papyrus/papyrus-trunk-nightly/promoteDirName

FULL_BUILD_ID=$(cat $promoteDirName)

if [ -n "$BUILD_ALIAS" ]; then
  zipName=Papyrus-Update-${BUILD_ALIAS}.zip
else
  zipName=Papyrus-Update-${FULL_BUILD_ID}.zip
fi

rm -rf tmp
mkdir -p "tmp/$FULL_BUILD_ID"

# create the update site zip
(cd $p2UpdateSiteDir && zip -r $zipName *)
mv $p2UpdateSiteDir/$zipName "tmp/$FULL_BUILD_ID"

# copy the generated psf files to the tmp dir
cp buildroot/result/*.psf "tmp/$FULL_BUILD_ID"

mv revision.txt "tmp/$FULL_BUILD_ID"

# copy the build log into the result
wget --quiet --no-check-certificate ${HUDSON_URL}/job/${JOB_NAME}/${BUILD_NUMBER}/consoleText -O "${WORKSPACE}/tmp/$FULL_BUILD_ID/buildlog.txt"

(cd tmp && zip -r ${FULL_BUILD_ID}.zip *)
mv tmp/${FULL_BUILD_ID}.zip .

if [ "$BUILD_TYPE" == "N" ]; then
	echo ${FULL_BUILD_ID} > $promoteSignal
	echo $VERSION > $promoteVersion
fi
