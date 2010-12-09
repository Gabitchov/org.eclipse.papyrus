/*******************************************************************************
 * Copyright (c) 2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *     Tristan Faure (Atos Origin) tristan.faure@atosorigin.com - add condition to the create command (task #296902)
 *******************************************************************************/
package org.eclipse.papyrus.modelexplorer.actionprovider;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.papyrus.core.extension.commands.CreationCommandDescriptor;
import org.eclipse.papyrus.core.extension.commands.CreationCommandRegistry;
import org.eclipse.papyrus.core.extension.commands.ICreationCommandRegistry;
import org.eclipse.papyrus.modelexplorer.actions.CreateDiagramAction;

/**
 * Provider used to create a new diagram actions
 * 
 * @deprecated
 */
public class CreateDiagramActionProvider extends AbstractSubmenuActionProvider {

	ICreationCommandRegistry creationCommandRegistry;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void fillContextMenu(IMenuManager menu) {
		Object selectedElement = resolveSemanticObject(getFirstSelectedElement());

		if(selectedElement != null && selectedElement instanceof EObject) {
			EObject eobject = (EObject)selectedElement;
			MenuManager newDiagramMenu = new MenuManager("New Diagram");
			menu.add(newDiagramMenu);
			for(CreationCommandDescriptor desc : getCreationCommandRegistry().getCommandDescriptors()) {
				if(desc.getCondition() == null || desc.getCondition().create(eobject)) {
					CreateDiagramAction createDiagramAction = new CreateDiagramAction(eobject, desc);
					newDiagramMenu.add(createDiagramAction);
				}
			}
		}
	}

	private ICreationCommandRegistry getCreationCommandRegistry() {
		if(creationCommandRegistry == null) {
			this.creationCommandRegistry = new CreationCommandRegistry(org.eclipse.papyrus.core.Activator.PLUGIN_ID);
		}
		return creationCommandRegistry;
	}

}
