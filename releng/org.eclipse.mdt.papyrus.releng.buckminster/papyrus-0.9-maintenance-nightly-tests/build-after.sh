promoteSignal=/opt/public/modeling/mdt/papyrus/papyrus-0.9-maintenance-nightly-tests/promoteSignal
promoteDirName=/opt/public/modeling/mdt/papyrus/papyrus-0.9-maintenance-nightly-tests/promoteDirName
# note: the version and build id used by the cronPromote.sh are taken from papyrus-0.9-maintenance-nightly

zipName="Papyrus-TestResults.zip"

rm -rf tmp
mkdir -p tmp
cp -r buildroot/result/testresults tmp

# copy the build log into the result
wget --quiet --no-check-certificate ${HUDSON_URL}/job/${JOB_NAME}/${BUILD_NUMBER}/consoleText -O "${WORKSPACE}/tmp/testresults/buildlog.txt"

# create the test results zip
(cd tmp && zip -r "$zipName" *)
mv "tmp/$zipName" .

if [ "$BUILD_TYPE" == "N" ]; then
	touch $promoteSignal
fi
