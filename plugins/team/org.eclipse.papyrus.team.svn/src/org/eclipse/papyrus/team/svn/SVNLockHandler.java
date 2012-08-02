/*****************************************************************************
 * Copyright (c) 2011 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Mathieu Velten (Atos Origin) mathieu.velten@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.team.svn;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.resources.team.FileModificationValidationContext;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.emf.readonly.IReadOnlyHandler;
import org.eclipse.team.svn.core.IStateFilter;
import org.eclipse.team.svn.core.svnstorage.SVNRemoteStorage;
import org.eclipse.team.svn.core.utility.FileUtility;
import org.eclipse.team.svn.ui.SVNTeamModificationValidator;

public class SVNLockHandler implements IReadOnlyHandler {

	SVNTeamModificationValidator validator = new SVNTeamModificationValidator();

	public boolean isReadOnly(URI[] uris, EditingDomain editingDomain) {

		IResource[] needsLockResources = FileUtility.filterResources(getIFiles(uris), IStateFilter.SF_NEEDS_LOCK, IResource.DEPTH_ZERO);
		for(IResource needsLockResource : needsLockResources) {
			if(!SVNRemoteStorage.instance().asLocalResource(needsLockResource).isLocked()) {
				return true;
			}
		}

		return false;
	}

	private IFile[] getIFiles(URI[] uris) {
		IFile[] iFiles = new IFile[uris.length];
		int i = 0;
		for(URI uri : uris) {
			iFiles[i++] = getFile(uri);
		}
		return iFiles;
	}

	private static IFile getFile(URI uri) {
		if(uri.isPlatform()) {
			return ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(uri.toPlatformString(true)));
		}
		return null;
	}

	public boolean enableWrite(URI[] uris, EditingDomain editingDomain) {

		IStatus result = validator.validateEdit(getIFiles(uris), FileModificationValidationContext.VALIDATE_PROMPT);

		return result.isOK();
	}
}
