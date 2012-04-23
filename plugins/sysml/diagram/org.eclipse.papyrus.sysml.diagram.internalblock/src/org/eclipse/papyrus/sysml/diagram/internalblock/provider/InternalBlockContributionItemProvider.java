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
 *   Atos Origin - Initial API and implementation
 *	 Arthur Daussy - arthur.daussy@atos.net - Bug 374809 - [SysML Internal Block Diagram] Provide "refresh block" - "restore connection" feature to ease IBD creation from existing model
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.internalblock.provider;

import org.eclipse.gmf.runtime.common.ui.services.action.contributionitem.AbstractContributionItemProvider;
import org.eclipse.gmf.runtime.common.ui.util.IWorkbenchPartDescriptor;
import org.eclipse.jface.action.IAction;
import org.eclipse.papyrus.sysml.diagram.internalblock.edit.actions.ArrangePortsAction;
import org.eclipse.papyrus.sysml.diagram.internalblock.edit.actions.RestoreRelatedLinksAction;

/**
 * Class to define action for the internal block diagram
 */
public class InternalBlockContributionItemProvider extends AbstractContributionItemProvider {

	/**
	 * @see org.eclipse.gmf.runtime.common.ui.services.action.contributionitem.AbstractContributionItemProvider#createAction(java.lang.String,
	 *      org.eclipse.gmf.runtime.common.ui.util.IWorkbenchPartDescriptor)
	 */
	@Override
	protected IAction createAction(String actionId, IWorkbenchPartDescriptor partDescriptor) {
		if(actionId.equals(RestoreRelatedLinksAction.ID)) {
			return new RestoreRelatedLinksAction();
		} else if(actionId.equals(ArrangePortsAction.ID)) {
			return new ArrangePortsAction();
		}
		return super.createAction(actionId, partDescriptor);
	}
}
