/*******************************************************************************
 * Copyright (c) 2013 Atos
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Arthur Daussy - initial implementation
 *******************************************************************************/
package org.eclipse.papyrus.team.collaborative.svn.versioncontroller;

/*******************************************************************************
 * Copyright (c) 2013 Atos.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Arthur Daussy <a href="mailto:arthur.daussy@atos.net"> - initial API and implementation
 ******************************************************************************/
import java.io.File;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.team.collaborative.core.IExtendedURI;
import org.eclipse.papyrus.team.collaborative.core.participants.version.IReverter;
import org.eclipse.papyrus.team.collaborative.svn.tracing.ITracingConstant;
import org.eclipse.papyrus.team.collaborative.svn.tracing.Tracer;
import org.eclipse.team.svn.core.operation.CompositeOperation;
import org.eclipse.team.svn.core.operation.IActionOperation;
import org.eclipse.team.svn.core.operation.file.RevertOperation;
import org.eclipse.team.svn.core.operation.local.RefreshResourcesOperation;
import org.eclipse.team.svn.ui.utility.ICancellableOperationWrapper;
import org.eclipse.team.svn.ui.utility.UIMonitorUtility;


/**
 * SVN Implementation for {@link IReverter}
 * 
 * @author adaussy
 * 
 */
public class SVNReverter extends SVNWorkOnModifiedFile implements IReverter {


	public SVNReverter(Set<IExtendedURI> uris, ResourceSet resourceSet) {
		super(uris, resourceSet);
	}

	public IStatus revert() {
		File[] modifiedFiles = getModifiedFile(getTargetResources());
		if(ITracingConstant.REVERT_TRACING) {
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("Reverting: ").append("\n");
			for(File f : modifiedFiles) {
				stringBuilder.append(f).append("\n");
			}
			Tracer.logInfo(stringBuilder.toString());
		}
		//Revert operation
		RevertOperation mainOp = new RevertOperation(modifiedFiles, true);
		CompositeOperation op = new CompositeOperation(mainOp.getId(), mainOp.getMessagesClass());
		op.add(mainOp);
		op.add(new RefreshResourcesOperation(getTargetFiles(getTargetResources())));
		ICancellableOperationWrapper runnable = UIMonitorUtility.doTaskNowDefault(op, false);
		IActionOperation resultStatus = runnable.getOperation();

		return resultStatus.getStatus();
	}


}
