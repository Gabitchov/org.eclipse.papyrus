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
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Made the dependency to SVN optional
 *
 *****************************************************************************/
package org.eclipse.papyrus.team.svn;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.team.FileModificationValidationContext;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.papyrus.infra.emf.readonly.IReadOnlyHandler;
import org.eclipse.team.svn.core.IStateFilter;
import org.eclipse.team.svn.core.svnstorage.SVNRemoteStorage;
import org.eclipse.team.svn.core.utility.FileUtility;
import org.eclipse.team.svn.ui.SVNTeamModificationValidator;

public class SVNLockHandler implements IReadOnlyHandler {

	SVNTeamModificationValidator validator;

	public SVNLockHandler() {
		try {
			validator = new SVNTeamModificationValidator();
		} catch (NoClassDefFoundError ex) {
			System.out.println("Ignore SVN");
			//If SVN is not installed, then the file is not locked, and can be written.
		}

	}

	public boolean isReadOnly(IFile[] files) {
		if(validator == null) {
			return false; //SVN is not installed
		}

		IResource[] needsLockResources = FileUtility.filterResources(files, IStateFilter.SF_NEEDS_LOCK, IResource.DEPTH_ZERO);
		for(IResource needsLockResource : needsLockResources) {
			if(!SVNRemoteStorage.instance().asLocalResource(needsLockResource).isLocked()) {
				return true;
			}
		}

		return false;
	}

	public boolean enableWrite(IFile[] files) {
		if(validator == null) {
			return true; //SVN is not installed
		}

		IStatus result = validator.validateEdit(files, FileModificationValidationContext.VALIDATE_PROMPT);

		return result.isOK();
	}
}
