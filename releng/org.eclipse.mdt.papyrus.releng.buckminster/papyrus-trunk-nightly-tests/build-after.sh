promoteSignal=/opt/public/modeling/mdt/papyrus/papyrus-trunk-nightly-tests/promoteSignal
promoteVersion=/opt/public/modeling/mdt/papyrus/papyrus-trunk-nightly-tests/promoteVersion
promoteDirName=/opt/public/modeling/mdt/papyrus/papyrus-trunk-nightly-tests/promoteDirName

if [[ ( -n "$BUILD_ID" ) && ( -n "$BUILD_VERSION" ) ]]; then
	zipName="Papyrus-TestResults-${BUILD_ID}.zip"
fi

rm -rf tmp
mkdir -p tmp
cp -r buildroot/result/testresults tmp

# copy the build log into the result
wget --quiet --no-check-certificate ${HUDSON_URL}/job/${JOB_NAME}/${BUILD_NUMBER}/consoleText -O "${WORKSPACE}/tmp/testresults/buildlog.txt"

# create the test results zip
(cd tmp && zip -r "$zipName" *)
mv "tmp/$zipName" .

if [ "$BUILD_TYPE" == "N" ]; then
	echo ${BUILD_ID} > $promoteSignal
	echo ${BUILD_VERSION} > $promoteVersion
fi
