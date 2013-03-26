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

import java.util.HashSet;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.resources.team.FileModificationValidationContext;
import org.eclipse.core.resources.team.FileModificationValidator;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.emf.readonly.AbstractReadOnlyHandler;
import org.eclipse.team.svn.core.IStateFilter;
import org.eclipse.team.svn.core.svnstorage.SVNRemoteStorage;
import org.eclipse.team.svn.core.utility.FileUtility;
import org.eclipse.team.svn.ui.SVNTeamModificationValidator;

import com.google.common.base.Optional;

public class SVNLockHandler extends AbstractReadOnlyHandler {

	FileModificationValidator validator = null;

	public SVNLockHandler(EditingDomain editingDomain) {
		super(editingDomain);
		try {
			validator = new SVNTeamModificationValidator();
		} catch (NoClassDefFoundError e) {
		}
	}

	public Optional<Boolean> anyReadOnly(URI[] uris) {

		if (validator != null) {
			IResource[] needsLockResources = FileUtility.filterResources(getIFiles(uris), IStateFilter.SF_NEEDS_LOCK, IResource.DEPTH_ZERO);
			for(IResource needsLockResource : needsLockResources) {
				if(!SVNRemoteStorage.instance().asLocalResource(needsLockResource).isLocked()) {
					return Optional.of(Boolean.TRUE);
				}
			}
		}

		return Optional.absent();
	}

	public Optional<Boolean> makeWritable(URI[] uris) {
		if (validator != null) {
			IStatus result = validator.validateEdit(getIFiles(uris), FileModificationValidationContext.VALIDATE_PROMPT);
			return Optional.of(result.isOK());
		}
		return Optional.absent();
	}

	private IFile[] getIFiles(URI[] uris) {
		HashSet<IFile> iFilesSet = new HashSet<IFile>();
		for(URI uri : uris) {
			IFile iFile = getFile(uri);
			if (iFile != null) {
				iFilesSet.add(iFile);
			}
		}
		return iFilesSet.toArray(new IFile[iFilesSet.size()]);
	}

	private static IFile getFile(URI uri) {
		if(uri.isPlatform()) {
			return ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(uri.toPlatformString(true)));
		}
		return null;
	}
}
