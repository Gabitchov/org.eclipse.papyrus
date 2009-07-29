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
package org.eclipse.papyrus.diagram.common.links;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.diagram.common.preferences.UMLPreferencesConstants;

/*
 * This class is to get rid of litter Required Interface links. One RequiredInterface link can be shown on the diagram several times - the Genuine(original) 
 * going out of Classifier and Derived, which is got by Port#getRequireds(), going out of Port. 
 * We call links that are not RequiredInterface links Regular, they are untouched by our algorithm.   
 * This class allows user to manage such links. Either genuine, or derived, or both genuine and derived links can be hidden. 
 * Genuine links are hidden only if its derived exists on the diagram.    
 */
public class InterfaceLinkManager<T> {

	protected static boolean ourHideReferencedGenuine;

	protected static boolean ourHideDerived;

	protected final List<InterfaceLinkFilter<T>> myLinkManagers = new ArrayList<InterfaceLinkFilter<T>>(3);

	public InterfaceLinkManager(Collection<?> linkDescriptors, IPreferenceStore store) {
		refreshOptions(store);
		buildTable(linkDescriptors);
	}

	public Collection<T> getFilteredLinkDescriptors() {
		Collection<T> result = new ArrayList<T>();
		for (InterfaceLinkFilter<T> manager : myLinkManagers) {
			result.addAll(manager.getFilteredLinks());
		}
		return result;
	}

	protected void initFilters() {
		// myLinkManagers.add(new RequiredInterfaceLinkFilter(ourHideDerived,
		// ourHideReferencedGenuine));
		// myLinkManagers.add(new ProvidedInterfaceLinkFilter(ourHideDerived,
		// ourHideReferencedGenuine));
		// myLinkManagers.add(new RegularLinkFilter(ourHideDerived, ourHideReferencedGenuine));
	}

	private static void refreshOptions(IPreferenceStore store) {
		ourHideDerived = store.getBoolean(UMLPreferencesConstants.PREF_MANAGE_REQUIRED_LINKS_HIDE_DERIVED);
		ourHideReferencedGenuine = store.getBoolean(UMLPreferencesConstants.PREF_MANAGE_REQUIRED_LINKS_HIDE_GENUINE);
	}

	private void buildTable(Collection<?> linkDescriptors) {
		initFilters();
		for (Object next : linkDescriptors) {
			T linkDescriptor = (T) next;
			for (InterfaceLinkFilter<T> manager : myLinkManagers) {
				manager.visit(linkDescriptor);
			}
		}
	}

}
