#!/bin/bash

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

SCRIPTS_LOC=/opt/public/modeling/mdt/papyrus
SVN_LOC="file:///svnroot/modeling/org.eclipse.mdt.papyrus/trunk/releng/org.eclipse.mdt.papyrus.releng.buckminster/serverConfig"

cd "$SCRIPTS_LOC"

scripts="
addDownloadStats-extra.xsl
addDownloadStats-main.xsl
addDownloadStats.sh
addToComposite.sh
addToComposite.xsl
cronPromote.sh
cronPromoteMonitor.sh
manualPromote.sh
promoteFunctions.sh
"

for i in $scripts; do
	svn export "$SVN_LOC/$i"
	chmod +x "$i"
done
