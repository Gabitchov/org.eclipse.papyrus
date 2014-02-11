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
package org.eclipse.papyrus.team.collaborative.connector.svn.locker;

import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.papyrus.team.collaborative.IExtendedURI;
import org.eclipse.papyrus.team.collaborative.connector.svn.AbstractExtendedURIBuilderForFile;
import org.eclipse.papyrus.team.collaborative.participants.ICollabParticipant;
import org.eclipse.papyrus.team.collaborative.reports.CollabStatus;
import org.eclipse.team.svn.core.resource.ILocalResource;
import org.eclipse.team.svn.core.svnstorage.SVNRemoteStorage;


/**
 * The Class AbstractSVNCollab.
 * Abstract class used for {@link ICollabParticipant} for SVN
 */
public abstract class AbstractSVNCollab extends AbstractExtendedURIBuilderForFile {

	public AbstractSVNCollab(Set<IExtendedURI> uris, ResourceSet resourceSet) {
		super(uris, resourceSet);
	}

	/** The Constant NOT_LOCK_STATUS. */
	public static final CollabStatus NOT_LOCK_STATUS = CollabStatus.createErrorStatus("Not locked");

	/**
	 * Checks if is locked.
	 * 
	 * @param uri
	 *        the uri
	 * @return the i status
	 */
	public IStatus isLocked(IExtendedURI uri) {
		Resource resourceToLock = getResourceSet().getResource(uri.getUri(), false);
		IFile iResourcesToLock = WorkspaceSynchronizer.getFile(resourceToLock);
		if(iResourcesToLock != null) {
			if(iResourcesToLock.exists()) {
				ILocalResource local = SVNRemoteStorage.instance().asLocalResource(iResourcesToLock);
				if(local.isLocked()) {
					return Status.OK_STATUS;
				} else {
					return NOT_LOCK_STATUS;
				}
			}
		}
		return Status.OK_STATUS;
	}



}
