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

import java.util.Set;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.team.collaborative.core.IExtendedURI;
import org.eclipse.papyrus.team.collaborative.core.participants.locker.IUnlocker;
import org.eclipse.papyrus.team.collaborative.core.reports.CollabStatus;
import org.eclipse.papyrus.team.collaborative.svn.tracing.ITracingConstant;
import org.eclipse.papyrus.team.collaborative.svn.tracing.Tracer;
import org.eclipse.team.svn.core.operation.CompositeOperation;
import org.eclipse.team.svn.core.operation.IActionOperation;
import org.eclipse.team.svn.core.operation.local.RefreshResourcesOperation;
import org.eclipse.team.svn.core.operation.local.UnlockOperation;
import org.eclipse.team.svn.ui.utility.ICancellableOperationWrapper;
import org.eclipse.team.svn.ui.utility.UIMonitorUtility;


// TODO: Auto-generated Javadoc
/**
 * SVN implementation of {@link IUnlocker}.
 * 
 * @author adaussy
 */
public class SVNUnlocker extends AbstractSVNCollab implements IUnlocker {

	/**
	 * Instantiates a new SVN unlocker.
	 * 
	 * @param uris
	 *        the uris
	 * @param resourceSet
	 *        the resource set
	 */
	public SVNUnlocker(Set<IExtendedURI> uris, ResourceSet resourceSet) {
		super(uris, resourceSet);
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.team.collaborative.core.participants.locker.IUnlocker#unlock()
	 */
	public IStatus unlock() {
		IResource[] resourcesToProcess = getTargetFiles(getTargetResources());
		if(ITracingConstant.UNLOCK_TRACING) {
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("Unlocking: ").append("\n");
			for(IResource r : resourcesToProcess) {
				stringBuilder.append(r.getFullPath()).append("\n");
			}
			Tracer.logInfo(stringBuilder.toString());
		}
		//Unlock operation
		UnlockOperation mainOp = new UnlockOperation(resourcesToProcess);
		CompositeOperation op = new CompositeOperation(mainOp.getId(), mainOp.getMessagesClass());
		op.add(mainOp);
		op.add(new RefreshResourcesOperation(resourcesToProcess));
		ICancellableOperationWrapper runnable = UIMonitorUtility.doTaskNowDefault(op, false);
		IActionOperation resultStatus = runnable.getOperation();

		IStatus status = resultStatus.getStatus();
		if(status.isOK()) {
			return Status.OK_STATUS;
		}
		return CollabStatus.createErrorStatus(status.getMessage(), status.getException());
	}



	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.team.collaborative.core.participants.AbstractExtendedURIBuilder#doBuild()
	 */
	@Override
	protected Set<IExtendedURI> doBuild() {
		for(IExtendedURI extendedURI : getUris()) {
			IExtendedURI resourceURI = getResourceURI(extendedURI);
			if(resourceURI != null) {
				if(isLocked(resourceURI).isOK()) {
					getExtendedSet().add(resourceURI);
				}
			}
		}
		return getExtendedSet();
	}





}
