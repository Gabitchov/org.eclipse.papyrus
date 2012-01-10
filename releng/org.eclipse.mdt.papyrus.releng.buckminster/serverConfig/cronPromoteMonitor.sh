#!/bin/bash -x

# Copyright (c) 2011 Mia-Software
# All rights reserved. This program and the accompanying materials
# are made available under the terms of the Eclipse Public License v1.0
# which accompanies this distribution, and is available at
# http://www.eclipse.org/legal/epl-v10.html
#
# Contributors:
#   Nicolas Bros (Mia-Software)

cronPromoteScript=/opt/public/modeling/mdt/papyrus/cronPromote.sh
logFile=/opt/public/modeling/mdt/papyrus/log-lastCronPromote

bash -x "$cronPromoteScript" 2>&1 | tee "$logFile"
if [ ${PIPESTATUS[0]} != 0 ]; then
	echo "promote failed : sending mail"
	cat $logFile | mail -s "[Papyrus build promotion] build promotion failed" "nbros.mia@gmail.com"
fi
