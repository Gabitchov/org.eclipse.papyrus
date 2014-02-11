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
package org.eclipse.papyrus.team.collaborative.integration.papyrus.ui.actions;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.papyrus.team.collaborative.ExtendedURI;
import org.eclipse.papyrus.team.collaborative.ICollaborativeManager;
import org.eclipse.papyrus.team.collaborative.IExtendedURI;
import org.eclipse.papyrus.team.collaborative.integration.papyrus.MatchingURIObject;
import org.eclipse.papyrus.team.collaborative.integration.papyrus.ui.ICollabColors;
import org.eclipse.papyrus.team.collaborative.integration.papyrus.ui.dialogs.CommitDialog;
import org.eclipse.papyrus.team.collaborative.integration.papyrus.ui.dialogs.PreviewDialog;
import org.eclipse.papyrus.team.collaborative.integration.papyrus.ui.providers.ExtensivePartitionNameLabelProvider;
import org.eclipse.papyrus.team.collaborative.integration.papyrus.utils.UIUtils;
import org.eclipse.papyrus.team.collaborative.participants.version.ICommitter;
import org.eclipse.papyrus.team.collaborative.reports.CollabStatus;
import org.eclipse.swt.widgets.Display;


/**
 * Handler use to deal with Commit action
 * The commit action will be performed on all the current model
 * 
 * @author adaussy
 */
public class CommitHandler extends AbstractCollabHandler {


	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		//Check that everything is commit
		if(!UIUtils.saveAllDirtyEditor().isOK()) {
			return null;
		}
		ResourceSet resourceSet = getResourceSet();
		if(resourceSet == null) {
			UIUtils.errorDialog(CollabStatus.createErrorStatus("unable to retreive the resource set"), "Collaboratibe error");
			return null;
		}
		Set<IExtendedURI> uris = new HashSet<IExtendedURI>();
		for(Resource r : resourceSet.getResources()) {
			IFile file = WorkspaceSynchronizer.getFile(r);
			if(file != null && file.exists()) {
				uris.add(new ExtendedURI(r.getURI()));
			}
		}
		IStatus status = doCommit(uris, resourceSet, true, null);
		if(!status.isOK() && status.getCode() == Status.ERROR) {
			UIUtils.errorDialog(status, "Error");
		}
		return null;


	}

	/**
	 * Do commit action
	 * 
	 * @param uris
	 *        the uris to commit
	 * @param resourceSet
	 *        the resource set
	 * @param isPreview
	 *        Set to true if the used to be given preview
	 * @param message
	 *        the message used for the commit operation
	 * @return the {@link IStatus} of the operation
	 */
	public static IStatus doCommit(Set<IExtendedURI> uris, ResourceSet resourceSet, boolean isPreview, String message) {
		ICommitter committer = ICollaborativeManager.INSTANCE.getCommitter(uris, resourceSet);
		if(committer == null) {
			return CollabStatus.createErrorStatus("Unable to get a ICommitter for uris\n" + uris);
		}
		Set<IExtendedURI> toBeCommitted = committer.getExtendedSet();
		IStatus status = doCommitFromBuilder(resourceSet, committer, toBeCommitted, isPreview, message);
		if(!status.isOK()) {
			return status;
		}
		return Status.OK_STATUS;

	}

	/**
	 * Do commit from builder using a already created {@link ICommitter}
	 * 
	 * @param resourceSet
	 *        the resource set
	 * @param committer
	 *        the {@link ICommitter} to use
	 * @param toBeCommitted
	 *        {@link IExtendedURI} of what is about to be committed
	 * @param isPreview
	 *        Set to true if the user has to be given preview
	 * @param message
	 *        the message
	 * @return the i status
	 * @throws CollabException
	 *         the collab exception
	 */
	public static IStatus doCommitFromBuilder(ResourceSet resourceSet, ICommitter committer, Set<IExtendedURI> toBeCommitted, boolean isPreview, String message) {
		if(isPreview || message == null) {
			ExtensivePartitionNameLabelProvider labelProvider = new ExtensivePartitionNameLabelProvider(new MatchingURIObject(toBeCommitted),UIUtils.getModelExplorerLavelProvider());
			labelProvider.setColor(ICollabColors.COMMIT_COLLOR);
			CommitDialog commitDialog = new CommitDialog(Display.getDefault().getActiveShell(), labelProvider, "Commit Dialog", "Element in red will be committed");
			Collection<EObject> objectsToReveal = UIUtils.getLeafSemanticElement(toBeCommitted, resourceSet);
			if(objectsToReveal != null && !objectsToReveal.isEmpty()) {
				commitDialog.setObjectsToReveal(objectsToReveal);
			}
			if(commitDialog.open() == PreviewDialog.OK) {
				message = commitDialog.getCommitMessage();
			} else {
				return Status.CANCEL_STATUS;
			}
		}

		//Keep lock force to true. This shall be improve later
		IStatus commitStatus = committer.commit(message, true);
		UIUtils.refreshModelExplorer(toBeCommitted, resourceSet);
		if(!commitStatus.isOK()) {
			return commitStatus;
		}
		return Status.OK_STATUS;
	}





}
