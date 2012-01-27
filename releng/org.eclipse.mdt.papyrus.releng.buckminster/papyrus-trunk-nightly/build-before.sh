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

SVN=/usr/local/bin/svn
promoteDirName=/opt/public/modeling/mdt/papyrus/papyrus-trunk-nightly/promoteDirName
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


revision=$($SVN info svn://dev.eclipse.org/svnroot/modeling/org.eclipse.mdt.papyrus | grep '^Revision:' | awk '{print $2}')
echo "$revision" > "$WORKSPACE/revision.txt"
