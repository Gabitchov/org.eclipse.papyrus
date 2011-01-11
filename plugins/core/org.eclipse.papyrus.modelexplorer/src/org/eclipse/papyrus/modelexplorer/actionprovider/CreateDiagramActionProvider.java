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

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.papyrus.core.extension.commands.CreationCommandDescriptor;
import org.eclipse.papyrus.core.extension.commands.CreationCommandRegistry;
import org.eclipse.papyrus.core.extension.commands.ICreationCommandRegistry;
import org.eclipse.papyrus.core.navigation.ExistingNavigableElement;
import org.eclipse.papyrus.core.navigation.NavigableElement;
import org.eclipse.papyrus.core.navigation.NavigationHelper;
import org.eclipse.papyrus.modelexplorer.actions.CreateDiagramAction;

/**
 * Provider used to create a new diagram actions
 * 
 */
public class CreateDiagramActionProvider extends AbstractSubmenuActionProvider {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void fillContextMenu(IMenuManager menu) {
		Object selectedElement = resolveSemanticObject(getFirstSelectedElement());

		if(selectedElement instanceof EObject) {
			EObject eobject = (EObject)selectedElement;
			MenuManager newDiagramMenu = new MenuManager("New Diagram");
			menu.insertAfter("additions", newDiagramMenu);

			List<NavigableElement> navElements =  NavigationHelper.getInstance().getAllNavigableElements(eobject);
			// this will sort by depth so existing elements come first
			Collections.sort(navElements);

			// this set keeps track of already used creation commands so that only one entry for each diagram can appears
			HashSet<CreationCommandDescriptor> alreadyUsedCommandDescs = new HashSet<CreationCommandDescriptor>();

			for (final NavigableElement navElement : navElements) {
				final EObject element = navElement.getElement();
				// if it is not a creation of element only authorize the current element as existing element
				if (!(navElement instanceof ExistingNavigableElement && !eobject.equals(element))) {
					for(final CreationCommandDescriptor desc : getCreationCommandRegistry().getCommandDescriptors()) {
						if (!alreadyUsedCommandDescs.contains(desc)) {
							if(desc.getCondition() == null || desc.getCondition().create(element)) {
								CreateDiagramAction createDiagramAction = new CreateDiagramAction(navElement, desc);
								newDiagramMenu.add(createDiagramAction);
								alreadyUsedCommandDescs.add(desc);
							}
						}
					}
				}
			}
		}
	}

	private static ICreationCommandRegistry getCreationCommandRegistry() {
		return CreationCommandRegistry.getInstance(org.eclipse.papyrus.core.Activator.PLUGIN_ID);
	}

}
