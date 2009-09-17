/*******************************************************************************
 * Copyright (c) 2008 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.diagram.clazz.custom.providers;

import org.eclipse.gmf.runtime.common.ui.services.action.contributionitem.AbstractContributionItemProvider;
import org.eclipse.gmf.runtime.common.ui.util.IWorkbenchPartDescriptor;
import org.eclipse.jface.action.IAction;
import org.eclipse.papyrus.diagram.clazz.custom.edit.actions.InitializeDiagramAction;
import org.eclipse.papyrus.diagram.clazz.custom.edit.actions.RestoreRelatedLinksAction;

/**
 * This class used to contrib item for specific actions.
 * 
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class ClassDiagramContributionItemProvider extends AbstractContributionItemProvider {

	/**
	 * @see org.eclipse.gmf.runtime.common.ui.services.action.contributionitem.AbstractContributionItemProvider#createAction(java.lang.String,
	 *      org.eclipse.gmf.runtime.common.ui.util.IWorkbenchPartDescriptor)
	 */
	@Override
	protected IAction createAction(String actionId, IWorkbenchPartDescriptor partDescriptor) {
		if (actionId.equals(RestoreRelatedLinksAction.ID)) {
			return new RestoreRelatedLinksAction();
		}
		if (actionId.equals(InitializeDiagramAction.ID)) {
			return new InitializeDiagramAction();
		}
		return super.createAction(actionId, partDescriptor);
	}
}
