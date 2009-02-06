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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.gmf.runtime.common.core.service.IProvider;
import org.eclipse.gmf.runtime.common.ui.services.action.contributionitem.AbstractContributionItemProvider;
import org.eclipse.gmf.runtime.common.ui.util.IWorkbenchPartDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.emf.core.internal.resources.PathmapManager;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.papyrus.diagram.common.part.CustomMessages;
import org.eclipse.papyrus.diagram.common.pathmap.PathMapService;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.resource.UMLResource;
import org.eclipse.uml2.uml.util.UMLSwitch;

// TODO: Auto-generated Javadoc
/**
 * The Class ApplicableProfilesItemProvider.
 */
public class ApplicableProfilesItemProvider extends AbstractContributionItemProvider implements IProvider {

	/** The Constant MENU_APPLY_PROFILE. */
	public static final String MENU_APPLY_PROFILE = "menu_apply_unapply_profile"; //$NON-NLS-1$

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.common.ui.services.action.contributionitem.AbstractContributionItemProvider#createMenuManager(java.lang.String,
	 * org.eclipse.gmf.runtime.common.ui.util.IWorkbenchPartDescriptor)
	 */
	@Override
	protected IMenuManager createMenuManager(String menuId, IWorkbenchPartDescriptor partDescriptor) {
		if (!MENU_APPLY_PROFILE.equals(menuId)) {
			return super.createMenuManager(menuId, partDescriptor);
		}
		MenuManager menuManager = new MenuManager(CustomMessages.ApplicableProfilesItemProvider_apply_profile_menu);
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
			GraphicalEditPart selected = (GraphicalEditPart) getSelectedObject(myWorkbenchPart);
			org.eclipse.uml2.uml.Package package_ = (org.eclipse.uml2.uml.Package) selected.getNotationView().getElement();
			List<Profile> profiles = getProfiles(package_);
			for (Profile profile : profiles) {
				// no much sense to cache dynamic target specific actions
				ApplyProfileAction action = new ApplyProfileAction(getWorkbenchPage(), package_, profile);
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

	/**
	 * Gets the profiles.
	 * 
	 * @param package_
	 *            the package_
	 * 
	 * @return the profiles
	 */
	private List<Profile> getProfiles(final org.eclipse.uml2.uml.Package package_) {
		// copy of code from
		// org.eclipse.uml2.uml.editor.actions.ApplyProfileAction
		final List<Profile> choiceOfValues = new ArrayList<Profile>();

		ResourceSet resourceSet = package_.eResource().getResourceSet();

		// addStandardProfileResources(resourceSet);
		// addResourcesFromPathMap(resourceSet);

		for (Resource resource : resourceSet.getResources()) {
			TreeIterator<EObject> allContents = resource.getAllContents();

			while (allContents.hasNext()) {

				new UMLSwitch<Object>() {

					@Override
					public Object caseProfile(Profile profile) {
						if (profile.isDefined()) {
							choiceOfValues.add(profile);
						}
						return profile;
					}
				}.doSwitch(allContents.next());
			}
		}
		return choiceOfValues;

	}

	/**
	 * Adds the standard profile resources.
	 * 
	 * @param resourceSet
	 *            the resource set
	 */
	private void addStandardProfileResources(ResourceSet resourceSet) {
		try {
			loadResource(resourceSet, UMLResource.STANDARD_PROFILE_URI);
			loadResource(resourceSet, UMLResource.ECORE_PROFILE_URI);
		} catch (Exception e) {
			// ignore
		}
	}

	/**
	 * Adds the resources from path map.
	 * 
	 * @param resourceSet
	 *            the resource set
	 */
	private void addResourcesFromPathMap(ResourceSet resourceSet) {
		try {
			Set<?> pathVariables = PathmapManager.getAllPathVariables();
			for (Object currVariable : pathVariables) {
				String varName = (String) currVariable;
				String varValue = PathmapManager.getRegisteredValue(varName);
				Collection<String> profiles = PathMapService.getInstance().getProfiles(varName, varValue);
				for (String pathmap : profiles) {
					loadResource(resourceSet, pathmap);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Load resource.
	 * 
	 * @param resourceSet
	 *            the resource set
	 * @param pathmap
	 *            the pathmap
	 * 
	 * @return the resource
	 */
	private Resource loadResource(ResourceSet resourceSet, String pathmap) {
		URI profileURI = URI.createURI(pathmap);
		return resourceSet.getResource(profileURI, true);
	}

}
