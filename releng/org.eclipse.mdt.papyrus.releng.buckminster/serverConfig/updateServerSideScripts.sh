#!/bin/bash

# Copyright (c) 2011-2012 Mia-Software
# All rights reserved. This program and the accompanying materials
# are made available under the terms of the Eclipse Public License v1.0
# which accompanies this distribution, and is available at
# http://www.eclipse.org/legal/epl-v10.html
#
# Contributors:
#   Nicolas Bros (Mia-Software)

SCRIPTS_LOC=/opt/public/modeling/mdt/papyrus
SVN_LOC="file:///svnroot/modeling/org.eclipse.mdt.papyrus/trunk/releng/org.eclipse.mdt.papyrus.releng.buckminster/serverConfiguration"

cd "$SCRIPTS_LOC"

for i in addDownloadStats.sh addDownloadStats.xsl cronPromote.sh cronPromoteMonitor.sh manualPromote.sh promoteFunctions.sh addToComposite.sh addToComposite.xsl; do
	svn export "$SVN_LOC/$i"
	chmod +x "$i"
done
