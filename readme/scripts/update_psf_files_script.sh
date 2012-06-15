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
cd /opt/public/modeling/mdt/papyrus/

wget -r -nd -np $path_on_svn/create_psf_file.sh
chmod +x create_psf_file.sh
wget -r -nd -np $path_on_svn/update_psf_files_script.sh
chmod +x update_psf_files_script.sh
