/*******************************************************************************
 * Copyright (c) 2008 Conselleria de Infraestructuras y Transporte,
 * Generalitat de la Comunitat Valenciana .
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Francisco Javier Cano MuÃ±oz (Prodevelop) - initial API implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.common.actions;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.ui.services.action.contributionitem.AbstractContributionItemProvider;
import org.eclipse.gmf.runtime.common.ui.util.IWorkbenchPartDescriptor;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.papyrus.diagram.common.util.MDTUtil;
import org.eclipse.ui.IWorkbenchPage;

/**
 * 
 * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano Muñoz</a>
 * 
 */
public class DeleteActionItemProvider extends AbstractContributionItemProvider {

	/** The Constant ACTION_OPEN_UPPER_DIAGRAM. */
	private static final String DELETE = "delete_from_model";

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.eclipse.gmf.runtime.common.ui.services.action.contributionitem.
	 * AbstractContributionItemProvider#createAction(java.lang.String,
	 * org.eclipse.gmf.runtime.common.ui.util.IWorkbenchPartDescriptor)
	 */
	@Override
	protected IAction createAction(String actionId, IWorkbenchPartDescriptor partDescriptor) {
		if (DELETE.equals(actionId) == false) {
			return super.createAction(actionId, partDescriptor);
		}
		IWorkbenchPage page = partDescriptor.getPartPage();
		ISelection selection = page.getSelection();
		EditingDomain domain = null;
		if (selection != null && selection.isEmpty() == false) {
			List<EObject> eObjects = MDTUtil.getEObjectsFromSelection(selection);
			if (eObjects != null && eObjects.size() > 0) {
				domain = TransactionUtil.getEditingDomain(eObjects.get(0));
			}
		}
		if (domain != null) {
			return new DeleteFromModelAction(page);
		}
		return super.createAction(actionId, partDescriptor);
	}

}
