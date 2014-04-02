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
package org.eclipse.papyrus.team.collaborative.strategy.ui.actions;

import java.util.Collection;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.team.collaborative.core.ICollaborativeManager;
import org.eclipse.papyrus.team.collaborative.core.IExtendedURI;
import org.eclipse.papyrus.team.collaborative.core.participants.locker.ILocker;
import org.eclipse.papyrus.team.collaborative.core.participants.version.IUpdater;
import org.eclipse.papyrus.team.collaborative.core.reports.CollabStatus;
import org.eclipse.papyrus.team.collaborative.core.strategy.ILockingStrategy;
import org.eclipse.papyrus.team.collaborative.core.strategy.ILockingStrategy.Descriptor;
import org.eclipse.papyrus.team.collaborative.strategy.MatchingURIObject;
import org.eclipse.papyrus.team.collaborative.strategy.ui.ICollabColors;
import org.eclipse.papyrus.team.collaborative.strategy.ui.dialogs.PreviewDialog;
import org.eclipse.papyrus.team.collaborative.strategy.ui.providers.ExtensivePartitionNameLabelProvider;
import org.eclipse.papyrus.team.collaborative.strategy.utils.UIUtils;
import org.eclipse.swt.widgets.Display;


/**
 * The Class LockAction.
 */
public class LockAction extends Action {

	/** The strategy. */
	protected ILockingStrategy.Descriptor strategy;

	/**
	 * Instantiates a new lock action.
	 * 
	 * @param strategy
	 *        the strategy
	 */
	public LockAction(Descriptor strategy) {
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
		super.run();
		Collection<EObject> selection = UIUtils.getSelection();
		if(!selection.isEmpty()) {
			IStatus status = doLock(selection, strategy);
			if(!status.isOK()) {
				UIUtils.errorDialog(status, "Unable to lock");
			}
		}
		return;
	}


	/**
	 * Do lock action
	 * 
	 * @param selection
	 *        the selection
	 * @param strategy
	 *        the strategy the selected {@link ILockingStrategy.Descriptor}
	 * @return the i status
	 */
	public static IStatus doLock(Collection<EObject> selection, ILockingStrategy.Descriptor strategy) {
		EObject eObject = selection.iterator().next();
		ResourceSet resourceSet = eObject.eResource().getResourceSet();
		//Execute the strategy to define the functional object to lock
		Set<IExtendedURI> objectToLock = strategy.getStrategy().getBusinessObject(selection);
		return doSafeLock(resourceSet, objectToLock, true);
	}


	/**
	 * Do lock action
	 * 
	 * @param resourceSet
	 *        the resource set
	 * @param objectToLock
	 *        the {@link IExtendedURI} about to be locked
	 * @param usePreview
	 *        Set to true if the user has to be given preview
	 * @return the {@link IStatus} of the operation
	 */
	public static IStatus doSafeLock(ResourceSet resourceSet, Set<IExtendedURI> objectToLock, boolean usePreview) {
		//Check that everything is up to date
		IUpdater updater = ICollaborativeManager.INSTANCE.getUpdater(objectToLock, resourceSet);
		if(updater == null) {
			UIUtils.errorDialog(CollabStatus.createErrorStatus("Unable to find a updater"), "Unable to find a updater");
			return CollabStatus.createErrorStatus("Unable to find a updater");
		}
		if(!updater.getExtendedSet().isEmpty()) {
			if(MessageDialog.openConfirm(Display.getDefault().getActiveShell(), "Need update", "You need to update those elements in order to perform a lock")) {
				IStatus status = UpdateHandler.doUpdateFromUpdater(resourceSet, updater, true);
				if(!status.isOK()) {
					UIUtils.errorDialog(status, "Error");
				}
				resourceSet = UIUtils.getCurrentResourceSet();
			} else {
				return CollabStatus.CANCEL_STATUS;
			}
		}

		return doUnlock(resourceSet, objectToLock, usePreview);

	}

	protected static IStatus doUnlock(ResourceSet resourceSet, Set<IExtendedURI> objectToLock, boolean usePreview) {
		ILocker locker = ICollaborativeManager.INSTANCE.getLocker(objectToLock, resourceSet);
		if(locker == null) {
			UIUtils.errorDialog(CollabStatus.createErrorStatus("Unable to find a locker"), "Unable to lock");
			return CollabStatus.createErrorStatus("Unable to find a locker");
		}

		Set<IExtendedURI> needsLock = locker.getExtendedSet();
		if(usePreview) {
			//Check if the lock can be taken
			ExtensivePartitionNameLabelProvider labelProvider = new ExtensivePartitionNameLabelProvider(new MatchingURIObject(needsLock),UIUtils.getModelExplorerLavelProvider());
			labelProvider.setColor(ICollabColors.LOCK_COLLOR);
			PreviewDialog previewDialog = new PreviewDialog(Display.getDefault().getActiveShell(), labelProvider, "Lock Preview", "Element in orange will be locked");
			Collection<EObject> objectsToReveal = UIUtils.getLeafSemanticElement(needsLock, resourceSet);
			if(objectsToReveal != null && !objectsToReveal.isEmpty()) {
				previewDialog.setObjectsToReveal(objectsToReveal);
			}
			if(previewDialog.open() != PreviewDialog.OK) {
				return CollabStatus.CANCEL_STATUS;
			}
		}
		IStatus status = locker.lock();
		UIUtils.refreshModelExplorer(needsLock, resourceSet);
		return status;
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
