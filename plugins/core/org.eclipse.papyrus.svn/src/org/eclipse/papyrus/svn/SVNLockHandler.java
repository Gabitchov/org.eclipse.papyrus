package org.eclipse.papyrus.svn;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.team.FileModificationValidationContext;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.papyrus.readonly.IReadOnlyHandler;
import org.eclipse.team.svn.core.IStateFilter;
import org.eclipse.team.svn.core.svnstorage.SVNRemoteStorage;
import org.eclipse.team.svn.core.utility.FileUtility;
import org.eclipse.team.svn.ui.SVNTeamModificationValidator;

public class SVNLockHandler implements IReadOnlyHandler {

	SVNTeamModificationValidator validator = new SVNTeamModificationValidator();

	public boolean isReadOnly(IFile[] files) {

		IResource[] needsLockResources = FileUtility.filterResources(files, IStateFilter.SF_NEEDS_LOCK, IResource.DEPTH_ZERO);
		for(IResource needsLockResource : needsLockResources) {
			if(!SVNRemoteStorage.instance().asLocalResource(needsLockResource).isLocked()) {
				return true;
			}
		}

		return false;
	}

	public boolean enableWrite(IFile[] files) {

		IStatus result = validator.validateEdit(files, FileModificationValidationContext.VALIDATE_PROMPT);

		return result.isOK();
	}
}
