#!/bin/bash -x

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

cronPromoteScript=/opt/public/modeling/mdt/papyrus/cronPromote.sh
logFile=/opt/public/modeling/mdt/papyrus/log-lastCronPromote
mailRecipients="nbros.mia@gmail.com camille.letavernier@cea.fr patrick.tessier@cea.fr vincent.lorenzo@cea.fr Remi.SCHNEKENBURGER@cea.fr"

bash -x "$cronPromoteScript" 2>&1 | tee "$logFile"
if [ ${PIPESTATUS[0]} != 0 ]; then
	echo "promote failed : sending mail"
	(echo "This is an automatically generated message sent because the build promotion script 'cronPromote.sh' running on build.eclipse.org failed." && 
	echo &&
	echo "Run these commands on build.eclipse.org to retry publishing:" && 
	echo "--------------------------------------------------------------------------------" && 
	echo "cd /opt/public/modeling/mdt/papyrus/" && 
	echo "touch papyrus-trunk-nightly/promoteSignal && ./cronPromote.sh # (replace papyrus-trunk-nightly by the job you want to publish)" && 
	echo "--------------------------------------------------------------------------------" && 
	echo && 
	echo && 
	echo && 
	echo && 
	echo && 
	cat $logFile) | mail -s "[Papyrus build promotion] build promotion failed" $mailRecipients
fi
