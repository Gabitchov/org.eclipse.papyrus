/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.menu.actions.gmf;

import org.eclipse.gmf.runtime.common.ui.util.IWorkbenchPartDescriptor;
import org.eclipse.gmf.runtime.diagram.core.util.ViewType;
import org.eclipse.gmf.runtime.diagram.ui.l10n.SharedImages;
import org.eclipse.gmf.runtime.diagram.ui.providers.DiagramContributionItemProvider;
import org.eclipse.gmf.runtime.diagram.ui.providers.internal.l10n.DiagramUIProvidersMessages;
import org.eclipse.jface.action.IAction;
import org.eclipse.ui.IWorkbenchPage;

/**
 * This DiagramContributionItem provides a custom action to add a Note
 * 
 * 
 * 
 */
public class CustomContributionItemProvider extends DiagramContributionItemProvider {

	@Override
	protected IAction createAction(String actionId, IWorkbenchPartDescriptor partDescriptor) {
		IWorkbenchPage workbenchPage = partDescriptor.getPartPage();
		if(CustomCreateShapeViewAction.ActionId.equals(actionId)) {
			return new CustomCreateShapeViewAction(workbenchPage, actionId, ViewType.NOTE, DiagramUIProvidersMessages.Note_menuItem, SharedImages.DESC_NOTE);
		}
		return null;
	}
}
