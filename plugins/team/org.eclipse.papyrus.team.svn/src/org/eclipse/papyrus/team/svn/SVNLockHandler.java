/*****************************************************************************
 * Copyright (c) 2011, 2014 Atos Origin, CEA, and others.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Mathieu Velten (Atos Origin) mathieu.velten@atosorigin.com - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 429826
 *
 *****************************************************************************/
package org.eclipse.papyrus.team.svn;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.resources.team.FileModificationValidationContext;
import org.eclipse.core.resources.team.FileModificationValidator;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.core.resource.AbstractReadOnlyHandler;
import org.eclipse.papyrus.infra.core.resource.ReadOnlyAxis;
import org.eclipse.team.core.RepositoryProvider;
import org.eclipse.team.svn.core.IStateFilter;
import org.eclipse.team.svn.core.svnstorage.SVNRemoteStorage;
import org.eclipse.team.svn.core.utility.FileUtility;
import org.eclipse.team.svn.ui.SVNTeamModificationValidator;

import com.google.common.base.Optional;
import com.google.common.collect.Sets;

/**
 * The Subversion file read-only handler is permission-based.
 */
public class SVNLockHandler extends AbstractReadOnlyHandler {

	// This is defined by SVNTeamPlugin.NATURE_ID constant, but we don't want a dependency
	// on that class (although, technically, it should be compiled into this class's constant
	// pool, let's be explicit about it)
	private static final String SVN_NATURE_ID = "org.eclipse.team.svn.core.nature"; //$NON-NLS-1$
	
	FileModificationValidator validator = null;

	public SVNLockHandler(EditingDomain editingDomain) {
		super(editingDomain);
		try {
			validator = new SVNTeamModificationValidator();
		} catch (NoClassDefFoundError e) {
		}
	}

	public Optional<Boolean> anyReadOnly(Set<ReadOnlyAxis> axes, URI[] uris) {

		if ((validator != null) && axes.contains(ReadOnlyAxis.PERMISSION)) {
			IResource[] needsLockResources = FileUtility.filterResources(getIFiles(uris), IStateFilter.SF_NEEDS_LOCK, IResource.DEPTH_ZERO);
			for(IResource needsLockResource : needsLockResources) {
				if(!SVNRemoteStorage.instance().asLocalResource(needsLockResource).isLocked()) {
					return Optional.of(Boolean.TRUE);
				}
			}
		}

		return Optional.absent();
	}
	
	@Override
	public Optional<Boolean> canMakeWritable(Set<ReadOnlyAxis> axes, URI[] uris) {
		if((validator != null) && axes.contains(ReadOnlyAxis.PERMISSION)) {
			// get the unique set of projects to check for SVN team provider
			IFile[] files = getIFiles(uris);
			Set<IProject> projects = Sets.newHashSet();
			for(int i = 0; i < files.length; i++) {
				projects.add(files[i].getProject());
			}

			boolean result = false;
			for(Iterator<IProject> iter = projects.iterator(); !result && iter.hasNext();) {
				result = RepositoryProvider.getProvider(iter.next(), SVN_NATURE_ID) != null;
			}

			return Optional.of(result);
		}

		return Optional.absent();
	}

	public Optional<Boolean> makeWritable(Set<ReadOnlyAxis> axes, URI[] uris) {
		if ((validator != null) && axes.contains(ReadOnlyAxis.PERMISSION)) {
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
