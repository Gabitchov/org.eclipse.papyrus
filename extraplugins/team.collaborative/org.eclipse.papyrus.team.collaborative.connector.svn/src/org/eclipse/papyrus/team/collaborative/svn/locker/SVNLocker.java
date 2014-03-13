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
package org.eclipse.papyrus.team.collaborative.svn.locker;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.team.collaborative.core.IExtendedURI;
import org.eclipse.papyrus.team.collaborative.core.participants.locker.ILocker;
import org.eclipse.papyrus.team.collaborative.core.reports.CollabStatus;
import org.eclipse.papyrus.team.collaborative.svn.tracing.ITracingConstant;
import org.eclipse.papyrus.team.collaborative.svn.tracing.Tracer;
import org.eclipse.papyrus.team.collaborative.svn.utils.SVNUtils;
import org.eclipse.team.svn.core.operation.CompositeOperation;
import org.eclipse.team.svn.core.operation.IActionOperation;
import org.eclipse.team.svn.core.operation.local.LockOperation;
import org.eclipse.team.svn.core.operation.local.RefreshResourcesOperation;
import org.eclipse.team.svn.ui.utility.ICancellableOperationWrapper;
import org.eclipse.team.svn.ui.utility.UIMonitorUtility;


/**
 * SVN implementation of {@link ILocker}
 * 
 * @author adaussy
 * 
 */
public class SVNLocker extends AbstractSVNCollab implements ILocker {


	public SVNLocker(Set<IExtendedURI> uris, ResourceSet resourceSet) {
		super(uris, resourceSet);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.team.collaborative.core.participants.locker.ILocker#lock()
	 */
	public IStatus lock() {
		IResource[] resourcesToProcess = getTargetFiles(getTargetResources());
		//Check that every file is on repository
		List<IResource> fileToAddToRepo = new ArrayList<IResource>();
		for(int i = 0; i < resourcesToProcess.length; i++) {
			IResource currentResource = resourcesToProcess[i];
			if(!SVNUtils.isAddedToRepository(currentResource)) {
				return CollabStatus.createErrorStatus(currentResource.getFullPath() + "is not in the repository");
			}
		}
		//Add resource to repository
		IStatus addStatus = SVNUtils.addToRepository("Adding new resource to repository", fileToAddToRepo);
		if(!addStatus.isOK()) {
			return addStatus;
		}
		if(ITracingConstant.LOCK_TRACING) {
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("Locking: ").append("\n");
			for(IResource r : resourcesToProcess) {
				stringBuilder.append(r.getFullPath()).append("\n");
			}
			Tracer.logInfo(stringBuilder.toString());
		}
		//Lock operation
		LockOperation mainOp = new LockOperation(resourcesToProcess, "Lock taken", false);
		CompositeOperation op = new CompositeOperation(mainOp.getId(), mainOp.getMessagesClass());
		op.add(mainOp);
		op.add(new RefreshResourcesOperation(resourcesToProcess));
		ICancellableOperationWrapper runnable = UIMonitorUtility.doTaskNowDefault(op, false);
		IActionOperation resultStatus = runnable.getOperation();
		return resultStatus.getStatus();
	}



	@Override
	protected Set<IExtendedURI> doBuild() {
		for(IExtendedURI extendedURI : getUris()) {
			IExtendedURI resourceURI = getResourceURI(extendedURI);
			if(resourceURI != null) {
				if(!isLocked(resourceURI).isOK()) {
					getExtendedSet().add(resourceURI);
				}
			}
		}
		return getExtendedSet();
	}





}
