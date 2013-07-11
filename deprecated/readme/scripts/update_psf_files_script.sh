#!/bin/sh
#
#All rights reserved. This program and the accompanying materials
#are made available under the terms of the Eclipse Public License v1.0
#which accompanies this distribution, and is available at
#http://www.eclipse.org/legal/epl-v10.html
# Vincent Lorenzo (CEA-LIST) vincent.lorenzo@cea.fr - Initial API and Implementation

#This script downlaod the last version of some scripts located in the readme project
#on the papyrus svn and replace the existing version on build.eclipse.org
path_on_svn="http://dev.eclipse.org/svnroot/modeling/org.eclipse.mdt.papyrus/trunk/readme/scripts/"
tmpFolder=$HOME/readme
dest="/opt/public/modeling/mdt/papyrus/"
echo "This script download the existing script ont the SVN in trunk/readme/scripts"
echo "do a chmod+x"
echo 'and move them in $dest'
mkdir $tmpFolder && cd $tmpFolder
#we download all the scripts
wget -N -r -nd -np $path_on_svn
for current in `find . -name "*.sh"`
  do
  chmod +x $current
  cp -f $current $dest
done
cd $HOME
rm -R -f $tmpFolder

