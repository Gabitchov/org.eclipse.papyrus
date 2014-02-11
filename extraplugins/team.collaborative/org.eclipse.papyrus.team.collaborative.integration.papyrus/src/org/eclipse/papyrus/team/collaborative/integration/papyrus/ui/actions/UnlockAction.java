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
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.papyrus.team.collaborative.ICollaborativeManager;
import org.eclipse.papyrus.team.collaborative.IExtendedURI;
import org.eclipse.papyrus.team.collaborative.integration.papyrus.MatchingURIObject;
import org.eclipse.papyrus.team.collaborative.integration.papyrus.ui.ICollabColors;
import org.eclipse.papyrus.team.collaborative.integration.papyrus.ui.dialogs.PreviewDialog;
import org.eclipse.papyrus.team.collaborative.integration.papyrus.ui.providers.ExtensivePartitionNameLabelProvider;
import org.eclipse.papyrus.team.collaborative.integration.papyrus.utils.UIUtils;
import org.eclipse.papyrus.team.collaborative.participants.locker.IUnlocker;
import org.eclipse.papyrus.team.collaborative.participants.version.ICommitter;
import org.eclipse.papyrus.team.collaborative.reports.CollabStatus;
import org.eclipse.papyrus.team.collaborative.strategy.ILockingStrategy;
import org.eclipse.papyrus.team.collaborative.strategy.ILockingStrategy.Descriptor;
import org.eclipse.swt.widgets.Display;


/**
 * Handler for the Unlock action in Papyrus
 */
public class UnlockAction extends Action {

	/** The strategy. */
	protected ILockingStrategy.Descriptor strategy;

	/**
	 * Instantiates a new unlock action.
	 * 
	 * @param strategy
	 *        the strategy
	 */
	public UnlockAction(Descriptor strategy) {
		super();
		this.strategy = strategy;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run() {
		if(!UIUtils.saveAllDirtyEditor().isOK()) {
			return;
		}
		Collection<EObject> selection = UIUtils.getSelection();
		if(!selection.isEmpty()) {
			IStatus status = doSafeUnlock(selection, strategy);
			if(!status.isOK()) {
				UIUtils.errorDialog(status, "Error during Unlock");
			}
		}
		super.run();
	}

	/**
	 * Do unlock.
	 * 
	 * @param selection
	 *        The {@link EObject} selected by the user
	 * @param strategy
	 *        the strategy use to compute the business object set to unlock
	 * @throws CollabException
	 *         the collab exception
	 */
	public static IStatus doSafeUnlock(Collection<EObject> selection, ILockingStrategy.Descriptor strategy) {
		EObject firstSelectedObject = selection.iterator().next();
		ResourceSet resourceSet = firstSelectedObject.eResource().getResourceSet();

		//Execute the strategy to define the functional object to lock
		Set<IExtendedURI> objectToLock = strategy.getStrategy().getBusinessObject(selection);
		//First check there no modification uncommitted
		ICommitter committer = ICollaborativeManager.INSTANCE.getCommitter(objectToLock, resourceSet);
		if(committer == null) {
			return CollabStatus.createErrorStatus("Unable to find an Committer");
		}

		IStatus preventUnlockingWithUntrackedModification = preventUnlockingWithUntrackedModification(resourceSet, objectToLock, committer, firstSelectedObject);
		if(!preventUnlockingWithUntrackedModification.isOK()) {
			return preventUnlockingWithUntrackedModification;
		}
		//Reset the resourceSet because the editor may have been reloaded
		resourceSet = UIUtils.getCurrentResourceSet();

		IUnlocker unlocker = ICollaborativeManager.INSTANCE.getUnlocker(objectToLock, resourceSet);
		if(unlocker == null) {
			return CollabStatus.createErrorStatus("Unable to find a unlocker for:\n " + objectToLock);
		}
		return doUnlock(resourceSet, unlocker);
	}

	protected static IStatus doUnlock(ResourceSet resourceSet, IUnlocker unlocker) {
		Set<IExtendedURI> needUnlock = unlocker.getExtendedSet();
		//Check if the lock can be taken
		ExtensivePartitionNameLabelProvider labelProvider = new ExtensivePartitionNameLabelProvider(new MatchingURIObject(needUnlock),UIUtils.getModelExplorerLavelProvider());
		labelProvider.setColor(ICollabColors.UNLOCK_COLLOR);
		PreviewDialog unlockPreviewDialog = new PreviewDialog(Display.getDefault().getActiveShell(), labelProvider, "Unlock Preview", "Element in green will be unlocked");
		Collection<EObject> objectsToReveal = UIUtils.getLeafSemanticElement(needUnlock, resourceSet);
		if(objectsToReveal != null && !objectsToReveal.isEmpty()) {
			unlockPreviewDialog.setObjectsToReveal(objectsToReveal);
		}
		if(unlockPreviewDialog.open() == PreviewDialog.OK) {
			IStatus lockResult = unlocker.unlock();
			UIUtils.refreshModelExplorer(needUnlock, resourceSet);
			return lockResult;
		} else {
			return CollabStatus.CANCEL_STATUS;
		}
	}


	/**
	 * Prevent unlocking with untracked modification.
	 * 
	 * @param resourceSet
	 *        the resource set
	 * @param objectToLock
	 *        the object to lock
	 * @param committer
	 *        the committer
	 * @param selected
	 *        the selected
	 * @return the i status
	 */
	private static IStatus preventUnlockingWithUntrackedModification(ResourceSet resourceSet, Set<IExtendedURI> objectToLock, ICommitter committer, EObject selected) {
		Set<IExtendedURI> committableResource = committer.getExtendedSet();
		if(!committableResource.isEmpty()) {
			//The user shall either commit or revert it's changes
			MessageDialog dialog = new MessageDialog(Display.getCurrent().getActiveShell(), "Modification in progess", null, "You have untrackted modification. You either have to commit it or revert it(Everything will be lost) to release the lock", MessageDialog.WARNING, new String[]{ "Commit", "Revert" }, 0);
			int dialogResult = dialog.open();
			if(dialogResult == 0) {
				//then commit
				return CommitHandler.doCommitFromBuilder(resourceSet, committer, committableResource, true, null);
			} else if(dialogResult == 1) {
				//then revert
				return RevertHandler.doRevert(committableResource, resourceSet);
			} else {
				//cancel
				return Status.CANCEL_STATUS;
			}
		}
		return Status.OK_STATUS;
	}



	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.action.Action#getText()
	 */
	@Override
	public String getText() {
		return strategy.getName();
	}



}
