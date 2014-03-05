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
package org.eclipse.papyrus.team.collaborative.connector.svn.versioncontroller;

import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.team.collaborative.IExtendedURI;
import org.eclipse.papyrus.team.collaborative.connector.svn.AbstractExtendedURIBuilderForFile;
import org.eclipse.papyrus.team.collaborative.connector.svn.utils.SVNUtils;
import org.eclipse.papyrus.team.collaborative.participants.version.IWorkOnModifiedElementParticipant;
import org.eclipse.papyrus.team.collaborative.reports.CollabStatus;
import org.eclipse.team.svn.core.connector.SVNChangeStatus;
import org.eclipse.team.svn.core.connector.SVNEntryStatus;


// TODO: Auto-generated Javadoc
/**
 * Abstract class for action with version control (update, commit, revert etc..) on SVN.
 * 
 * @author adaussy
 * 
 */
public abstract class AbstractSVNVersionController extends AbstractExtendedURIBuilderForFile implements IWorkOnModifiedElementParticipant {

	/**
	 * Instantiates a new abstract SVN version controller.
	 * 
	 * @param uris
	 *        the uris
	 * @param resourceSet
	 *        the resource set
	 */
	public AbstractSVNVersionController(Set<IExtendedURI> uris, ResourceSet resourceSet) {
		super(uris, resourceSet);
	}

	/**
	 * Check if the element pointed by the URI is modified.
	 * 
	 * @param uri
	 *        the uri
	 * @return the i status
	 * @throws CollabException
	 *         the collab exception
	 */
	public IStatus isModified(IExtendedURI uri) {
		IExtendedURI resourceEURI = getResourceURI(uri);
		if(resourceEURI == null) {
			return Status.OK_STATUS;
		}
		URI resourceURI = resourceEURI.getUri();
		Resource resource = toResource(resourceURI);
		if(resource == null) {
			return CollabStatus.createErrorStatus(resourceURI + " is not a URI pointing to a resource");
		}
		IFile file = toIFile(resource);
		if(file == null || !file.exists()) {
			return CollabStatus.createErrorStatus(resourceURI + " is not a URI pointing to a existing file");
		}
		SVNChangeStatus svnInfo = SVNUtils.getSVNInfo(file);
		if(svnInfo == null) {
			return CollabStatus.createErrorStatus("Can not retreive SVN info for " + resourceURI);
		}
		if(svnInfo.repositoryPropStatus == SVNEntryStatus.Kind.MODIFIED) {
			return MODIFIED_STATUS;
		}
		return Status.OK_STATUS;
	}



}
