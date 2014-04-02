/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.newchild.runtime;

import java.io.IOException;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.emf.newchild.Activator;
import org.eclipse.papyrus.infra.emf.newchild.MenuRoot;
import org.eclipse.papyrus.infra.emf.newchild.NewchildConfiguration;
import org.eclipse.papyrus.infra.emf.newchild.menu.FillElement;
import org.eclipse.papyrus.infra.emf.newchild.menu.FillerFactory;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;

/**
 * A singleton manager for customizable "New child" menu.
 * 
 * The custom menus are defined via {@link NewchildConfiguration}, which
 * may be registered either with an extension point, programatically, or
 * locally (In the preferences).
 * 
 * Once set up, the manager simply takes a IMenuManager and a ISelection,
 * and fills the menu according to the available {@link NewchildConfiguration}.
 * 
 * USAGE : NewchildManager.instance.fillMenu(IMenuManager, IStructuredSelection)
 * 
 * See the org.eclipse.papyrus.infra.emf.newchild.configuration extension point.
 * 
 * @author Camille Letavernier
 * 
 */
public class NewchildManager {

	/**
	 * The ID of the menu's top element.
	 */
	public static final String TOP = "top"; //$NON-NLS-1$

	/**
	 * The singleton NewchildManager instance
	 */
	public static NewchildManager instance = new NewchildManager();

	/**
	 * The default {@link #ConstraintEngine} for this manager
	 */
	public MenuConstraintEngine constraintEngine;

	private NewchildManager() {
	}

	/**
	 * Fills the menuManager with a custom menu
	 * 
	 * The menu will be retrieved via registered {@link NewchildConfiguration}s,
	 * depending on the given selection.
	 * 
	 * The menu manager should have an IContributionItem with the {@link #TOP} id ;
	 * otherwise, the absolute position "top" won't work properly.
	 * 
	 * @param menuManager
	 * @param selection
	 */
	public void fillMenu(IMenuManager menuManager, IStructuredSelection selection) {
		constraintEngine = new MenuConstraintEngine();
		try {
			//TODO : Load that from extension point
			NewchildConfiguration configuration = (NewchildConfiguration)EMFHelper.loadEMFModel(null, URI.createPlatformPluginURI("/org.eclipse.papyrus.emf.facet.editor/newChild/NewchildConfiguration.xmi", true));
			constraintEngine.addConfiguration(configuration);
		} catch (IOException ex) {
			Activator.log.error(ex);
		}

		Set<MenuRoot> roots = findRootsFor(selection);
		if(roots.isEmpty()) {
			return;
		}

		for(MenuRoot root : roots) {
			Object selectedObject = selection.getFirstElement();
			FillElement filler = FillerFactory.instance.getFiller(root, selectedObject);
			filler.fill(menuManager);
		}
	}

	private Set<MenuRoot> findRootsFor(IStructuredSelection selection) {
		Set<MenuRoot> roots = constraintEngine.getDisplayUnits(selection);
		return roots;
	}
}
