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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.service.IProvider;
import org.eclipse.gmf.runtime.common.ui.services.action.contributionitem.AbstractContributionItemProvider;
import org.eclipse.gmf.runtime.common.ui.util.IWorkbenchPartDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.papyrus.diagram.common.part.CustomMessages;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;

// TODO: Auto-generated Javadoc
/**
 * The Class ApplicableStereotypesItemProvider.
 */
public class ApplicableStereotypesItemProvider extends AbstractContributionItemProvider implements IProvider {

	/** The Constant MENU_APPLY_STEREOTYPE. */
	public static final String MENU_APPLY_STEREOTYPE = "menu_apply_unapply_stereotype"; //$NON-NLS-1$

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.common.ui.services.action.contributionitem.AbstractContributionItemProvider#createMenuManager(java.lang.String,
	 * org.eclipse.gmf.runtime.common.ui.util.IWorkbenchPartDescriptor)
	 */
	@Override
	protected IMenuManager createMenuManager(String menuId, IWorkbenchPartDescriptor partDescriptor) {
		if (!MENU_APPLY_STEREOTYPE.equals(menuId)) {
			return super.createMenuManager(menuId, partDescriptor);
		}
		MenuManager menuManager = new MenuManager(CustomMessages.ApplicableStereotypesItemProvider_apply_stereotype_menu_label);
		MenuBuilder builder = new MenuBuilder(partDescriptor);
		// XXX: build initial content -- otherwise menu is never shown
		builder.buildMenu(menuManager);

		menuManager.addMenuListener(builder);
		return menuManager;
	}

	/**
	 * The Class MenuBuilder.
	 */
	private class MenuBuilder implements IMenuListener {

		/** The my workbench part. */
		private final IWorkbenchPartDescriptor myWorkbenchPart;

		/**
		 * Instantiates a new menu builder.
		 * 
		 * @param workbenchPart
		 *            the workbench part
		 */
		public MenuBuilder(IWorkbenchPartDescriptor workbenchPart) {
			myWorkbenchPart = workbenchPart;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.jface.action.IMenuListener#menuAboutToShow(org.eclipse.jface.action.IMenuManager)
		 */
		public void menuAboutToShow(IMenuManager manager) {
			buildMenu(manager);
		}

		/**
		 * Builds the menu.
		 * 
		 * @param manager
		 *            the manager
		 */
		public void buildMenu(IMenuManager manager) {
			manager.removeAll();
			IGraphicalEditPart selected = (IGraphicalEditPart) getSelectedObject(myWorkbenchPart);
			EObject selectedElement = selected.getNotationView().getElement();
			if (false == selectedElement instanceof Element) {
				return;
			}
			Element element = (Element) selectedElement;
			EList<Stereotype> stereotypes = element.getApplicableStereotypes();
			for (Stereotype stereotype : stereotypes) {
				ApplyStereotypeAction action = new ApplyStereotypeAction(getWorkbenchPage(), element, stereotype);
				action.init();
				manager.add(action);
			}
		}

		/**
		 * Gets the workbench page.
		 * 
		 * @return the workbench page
		 */
		private IWorkbenchPage getWorkbenchPage() {
			return myWorkbenchPart.getPartPage();
		}
	}

}
