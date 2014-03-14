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

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.team.collaborative.core.IExtendedURI;
import org.eclipse.papyrus.team.collaborative.core.participants.version.ICommitter;
import org.eclipse.papyrus.team.collaborative.core.utils.ResourceUtils;
import org.eclipse.papyrus.team.collaborative.svn.CollabResourceSelector;
import org.eclipse.papyrus.team.collaborative.svn.tracing.ITracingConstant;
import org.eclipse.papyrus.team.collaborative.svn.tracing.Tracer;
import org.eclipse.papyrus.team.collaborative.svn.utils.CommitActionUtilityWithProperties;
import org.eclipse.swt.widgets.Display;
import org.eclipse.team.svn.core.operation.CompositeOperation;
import org.eclipse.team.svn.core.operation.IActionOperation;
import org.eclipse.team.svn.ui.utility.ICancellableOperationWrapper;
import org.eclipse.team.svn.ui.utility.UIMonitorUtility;
import org.eclipse.ui.PlatformUI;

import com.google.common.collect.Lists;


/**
 * SVN implementation for {@link ICommitter}.
 * 
 * @author adaussy
 */
public class SVNCommitter extends SVNWorkOnModifiedFile implements ICommitter {


	/**
	 * Instantiates a new SVN committer.
	 * 
	 * @param uris
	 *        the uris
	 * @param resourceSet
	 *        the resource set
	 */
	public SVNCommitter(Set<IExtendedURI> uris, ResourceSet resourceSet) {
		super(uris, resourceSet);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.team.collaborative.core.participants.version.ICommitter#commit(java.lang.String, boolean)
	 */
	public IStatus commit(String message, boolean keepLock) {
		IStatus status = doCommit(message, keepLock, getTargetResources());
		return status;
	}

	/**
	 * Do commit.
	 * 
	 * @param message
	 *        the message for the commit action
	 * @param keepLock
	 *        the keep lock set to true if the lock has to be kept
	 * @param resourceToCommit
	 *        the resource to commit
	 * @return the i status
	 */
	public static IStatus doCommit(String message, boolean keepLock, Set<Resource> resourceToCommit) {
		if(resourceToCommit != null && !resourceToCommit.isEmpty()) {
			List<IFile> targetIFileList = Lists.newArrayList(getTargetFiles(resourceToCommit));
			return doCommit(message, keepLock, ResourceUtils.getListAncestors(targetIFileList));
		}
		return Status.OK_STATUS;
	}

	/**
	 * Do commit.
	 * 
	 * @param message
	 *        the message for the commit action
	 * @param keepLock
	 *        the keep lock set to true if the lock has to be kept
	 * @param filesToCommit
	 *        the files to commit
	 * @return the i status
	 */
	public static IStatus doCommit(String message, boolean keepLock, Collection<? extends IResource> filesToCommit) {
		CommitActionUtilityWithProperties tt = new CommitActionUtilityWithProperties(new CollabResourceSelector(filesToCommit.toArray(new IResource[filesToCommit.size()]), Display.getDefault().getActiveShell()));
		IResource[] allResources = tt.getAllResources();
		if(ITracingConstant.COMMIT_TRACING) {
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("Committing ").append(message).append("\n");
			for(IResource r : allResources) {
				stringBuilder.append(r).append("\n");
			}
			Tracer.logInfo(stringBuilder.toString());
		}
		CompositeOperation mainOp = tt.getCompositeCommitOperation(allResources, new IResource[0], message, keepLock, Display.getDefault().getActiveShell(), PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActivePart(), true);
		ICancellableOperationWrapper runnable = UIMonitorUtility.doTaskNowDefault(mainOp, false);
		IActionOperation resultStatus = runnable.getOperation();
		return resultStatus.getStatus();
	}



}
