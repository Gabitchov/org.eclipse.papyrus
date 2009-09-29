/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.core.adaptor.gmf;

import org.eclipse.gmf.runtime.common.core.util.Trace;
import org.eclipse.gmf.runtime.common.ui.services.action.contributionitem.ContributionItemService;
import org.eclipse.gmf.runtime.common.ui.util.IWorkbenchPartDescriptor;
import org.eclipse.gmf.runtime.common.ui.util.WorkbenchPartDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.internal.DiagramUIDebugOptions;
import org.eclipse.gmf.runtime.diagram.ui.internal.DiagramUIPlugin;
import org.eclipse.papyrus.sasheditor.extension.MultiDiagramActionBarContributor;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.activities.ActivityManagerEvent;
import org.eclipse.ui.activities.IActivityManagerListener;

/**
 * GMF based multi diagram action bar contributor. GMF based multi diagram editors should subclass
 * this action bar contributor. This class is based on
 * {@link org.eclipse.gmf.runtime.diagram.ui.parts.DiagramActionBarContributor}
 * 
 * @author dumoulin and original authors from gmf.
 * 
 */
public abstract class GmfMultiPagesActionBarContributor extends MultiDiagramActionBarContributor {

	/**
	 * Listens for activity/capability events.
	 * 
	 */
	class ActivityManagerListener implements IActivityManagerListener {

		public void activityManagerChanged(ActivityManagerEvent activityManagerEvent) {
			if (activityManagerEvent.haveEnabledActivityIdsChanged()) {
				updateActionBars();
			}
		}
	}

	/**
	 * The activity listener.
	 */
	private ActivityManagerListener activityManagerListener;

	private IWorkbenchPartDescriptor descriptor;

	/**
	 * @see org.eclipse.ui.part.EditorActionBarContributor#init(org.eclipse.ui.IActionBars)
	 */
	public void init(final IActionBars bars) {
		super.init(bars);

		descriptor = new WorkbenchPartDescriptor(getEditorId(), getEditorClass(), getPage());

		try {
			// getEditingDomain().runExclusive(new Runnable() {
			//
			// public void run() {
			ContributionItemService.getInstance().contributeToActionBars(bars, descriptor);
			// }
			// });
		} catch (Exception e) {
			Trace.catching(DiagramUIPlugin.getInstance(), DiagramUIDebugOptions.EXCEPTIONS_CATCHING, getClass(),
					"init()", //$NON-NLS-1$
					e);
		}

		bars.updateActionBars();

		activityManagerListener = new ActivityManagerListener();
		PlatformUI.getWorkbench().getActivitySupport().getActivityManager().addActivityManagerListener(
				activityManagerListener);
	}

	/**
	 * @see org.eclipse.ui.IEditorActionBarContributor#dispose()
	 */
	public void dispose() {
		ContributionItemService.getInstance().disposeContributions(descriptor);
		descriptor = null;

		if (activityManagerListener != null) {
			PlatformUI.getWorkbench().getActivitySupport().getActivityManager().removeActivityManagerListener(
					activityManagerListener);
		}
		activityManagerListener = null;

		super.dispose();
	}

	/**
	 * @see org.eclipse.gef.ui.actions.ActionBarContributor#declareGlobalActionKeys()
	 */
	protected void declareGlobalActionKeys() {
		// empty impl
	}

	/**
	 * Returns the id of the editor configured with this contributor
	 * 
	 * @return The editor's id configured with this contribution
	 */
	protected abstract String getEditorId();

	/**
	 * Returns the class of the editor configured with this contributor
	 * 
	 * @return The editor's class configured with this contribution
	 */
	protected abstract Class getEditorClass();

	// protected abstract TransactionalEditingDomain getEditingDomain();

	/**
	 * Updates the actionbars to show/hide contribution items as applicable.
	 */
	private void updateActionBars() {

		// get the new contributions
		ContributionItemService.getInstance().updateActionBars(getActionBars(), descriptor);

		// refresh the UI
		getActionBars().updateActionBars();
	}

	/**
	 * Connect the actions registered in the globalActionKeys.
	 */
	protected void connectActions() {
		super.connectActions();
		updateActionBars();
	}

}
