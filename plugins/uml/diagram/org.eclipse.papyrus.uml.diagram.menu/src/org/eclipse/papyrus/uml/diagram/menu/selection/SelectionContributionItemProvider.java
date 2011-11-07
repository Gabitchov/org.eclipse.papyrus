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
 *  Barthelemy HABA (Atos Origin) barthelemy.haba@atosorigin.com - 
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.menu.selection;

import org.eclipse.gmf.runtime.common.core.service.IProvider;
import org.eclipse.gmf.runtime.common.ui.services.action.contributionitem.AbstractContributionItemProvider;
import org.eclipse.gmf.runtime.common.ui.util.IWorkbenchPartDescriptor;
import org.eclipse.jface.action.IAction;

/**
 * This class used to contribute items for specific actions.
 */
public class SelectionContributionItemProvider extends AbstractContributionItemProvider implements IProvider {

	/**
	 * @see org.eclipse.gmf.runtime.common.ui.services.action.contributionitem.AbstractContributionItemProvider#createAction(java.lang.String,
	 *      org.eclipse.gmf.runtime.common.ui.util.IWorkbenchPartDescriptor)
	 */

	@Override
	protected IAction createAction(String actionId, IWorkbenchPartDescriptor partDescriptor) {
		if((actionId != null) && (actionId.equals(SelectTypeAction.ID))) {
			return new SelectTypeAction();
		}
		return super.createAction(actionId, partDescriptor);
	}
}
