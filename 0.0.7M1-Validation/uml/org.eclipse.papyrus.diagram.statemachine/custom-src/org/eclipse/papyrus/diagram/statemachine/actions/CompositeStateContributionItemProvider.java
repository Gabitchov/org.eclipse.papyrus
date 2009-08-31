/*******************************************************************************
 * Copyright (c) 2007 Conselleria de Infraestructuras y Transporte, Generalitat 
 * de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  Francisco Javier Cano Mu�oz (Prodevelop) - Initial API 
 *  implementation.
 *  Marc Gil Sendra (Prodevelop)
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.statemachine.actions;

import org.eclipse.gmf.runtime.common.ui.services.action.contributionitem.AbstractContributionItemProvider;
import org.eclipse.gmf.runtime.common.ui.util.IWorkbenchPartDescriptor;
import org.eclipse.jface.action.IAction;
import org.eclipse.ui.IWorkbenchPage;

// TODO: Auto-generated Javadoc
/**
 * The Class CompositeStateContributionItemProvider.
 */
public class CompositeStateContributionItemProvider extends
		AbstractContributionItemProvider {

	/** The Constant COMPOSITE_STATE_NOTATION. */
	public static final String COMPOSITE_STATE_NOTATION = "change_composite_state_notation"; //$NON-NLS-1$
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.common.ui.services.action.contributionitem.AbstractContributionItemProvider#createAction(java.lang.String, org.eclipse.gmf.runtime.common.ui.util.IWorkbenchPartDescriptor)
	 */
	@Override
	protected IAction createAction(String actionId,
			IWorkbenchPartDescriptor partDescriptor) {
		IWorkbenchPage workbenchPage = partDescriptor.getPartPage();
		if (COMPOSITE_STATE_NOTATION.equals(actionId)) {
			return new SetCompositeStateNotation(workbenchPage, actionId);
		}
		return super.createAction(actionId, partDescriptor);
	}
	
}
