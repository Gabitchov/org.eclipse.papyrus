#SVN=/usr/local/bin/svn
promoteDirName=/opt/public/modeling/mdt/papyrus/papyrusBuildPromoteDirNameN
RELENG_PROJECT="sourceTree/releng/org.eclipse.mdt.papyrus.releng.buckminster"

echo "building in " $WORKSPACE

echo "cleaning previous results"
rm -f ?20*.zip

echo "displaying java version"
java -version
#ls -al /shared/common/jdk-1.5.0-22.x86_64/jre/bin

COMPACT_BUILD_ID="${BUILD_ID//[-_]}"
COMPACT_BUILD_ID="${COMPACT_BUILD_ID:0:12}"
FULL_BUILD_ID=${BUILD_TYPE}${COMPACT_BUILD_ID}
echo $FULL_BUILD_ID > $promoteDirName
