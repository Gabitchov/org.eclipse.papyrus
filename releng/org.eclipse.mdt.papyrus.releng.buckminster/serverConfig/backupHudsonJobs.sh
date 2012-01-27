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

loc=$(dirname "$0")
cd "$loc"

jobs=$(ssh vlorenzo@build.eclipse.org ls -1 /opt/public/jobs | grep papyrus)

for job in $jobs; do
  scp vlorenzo@build.eclipse.org:/opt/public/jobs/${job}/config.xml hudsonJobs/${job}.xml
done
