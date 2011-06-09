/*******************************************************************************
 * Copyright (c) 2006 CEA List.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     CEA List - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.extensionpoints.uml2.metamodel;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.papyrus.extensionpoints.uml2.Activator;
import org.eclipse.papyrus.extensionpoints.uml2.standard.ExtensionIds;
import org.eclipse.papyrus.extensionpoints.uml2.standard.RegisteredElementExtensionPoint;

/**
 * Class that manages registered metamodel extension point
 */
public class RegisteredMetamodel extends RegisteredElementExtensionPoint {

	/** name of the extension point (main element name) in the DTD */
	private static final String TAG_METAMODEL = "metamodel";

	/** list of registered metamodels (Cache) */
	private static RegisteredMetamodel[] RegisteredMetamodels;

	/**
	 * Creates a new RegisteredMetamodel.
	 * 
	 * @param configElt
	 * @param ordinal
	 */
	public RegisteredMetamodel(IConfigurationElement configElt, int ordinal) {
		super(configElt, ordinal);
	}

	/**
	 * Returns the list of registered metamodels in the platform, using the Papyrus extension point.
	 * 
	 * @return the list of registered metamodels in the platform
	 */
	public static RegisteredMetamodel[] getRegisteredMetamodels() {
		// list was already computed, returns it.
		if(RegisteredMetamodels != null) {
			return RegisteredMetamodels;
		}
		List<RegisteredMetamodel> metamodels = new ArrayList<RegisteredMetamodel>();
		IConfigurationElement[] configElements = Platform.getExtensionRegistry().getConfigurationElementsFor(
				ExtensionIds.METAMODEL_EXTENSION_ID);

		// Read configuration elements for the current extension
		for(int j = 0; j < configElements.length; j++) {
			RegisteredMetamodel proxy = parseMetamodelExtension(configElements[j], metamodels.size());

			if(proxy != null) {
				metamodels.add(proxy);
			}
		} // end of configElements loop
		// // Default elements : UML, Ecore metamodels
		// RegisteredMetamodel UMLMetamodel
		// = new RegisteredMetamodel("uml", URI.createURI(UMLResource.UML_METAMODEL_URI));
		// metamodels.add(UMLMetamodel);
		// RegisteredMetamodel EcoreMetamodel
		// = new RegisteredMetamodel("ecore", URI.createURI(UMLResource.ECORE_METAMODEL_URI));
		// metamodels.add(EcoreMetamodel);

		RegisteredMetamodels = metamodels.toArray(new RegisteredMetamodel[metamodels.size()]);
		return RegisteredMetamodels;
	}

	/**
	 * Returns a registered metamodel using its name. If several mdetamodels are found, the first
	 * found is returned
	 * 
	 * @param name
	 *        the name of the metamodel to find
	 * @return the RegisteredMetamodel with given name or <code>null</code> if no metamodel was
	 *         found.
	 */
	public static RegisteredMetamodel getRegisteredMetamodel(String name) {
		return getRegisteredMetamodel(name, null);
	}

	/**
	 * Returns a registered metamodel using its name and a given path. If several metamodels are
	 * found, the first found is returned.
	 * 
	 * @param name
	 *        the name of the metamodel to find
	 * @param path
	 *        the path of the metamodel file
	 * @return the RegisteredMetamodel with given name or <code>null</code> if no metamodel was
	 *         found.
	 */
	public static RegisteredMetamodel getRegisteredMetamodel(String name, String path) {
		Assert.isNotNull(name);
		RegisteredMetamodel[] metamodels = getRegisteredMetamodels();
		for(int i = 0; i < metamodels.length; i++) {
			RegisteredMetamodel metamodel = metamodels[i];

			// name corresponds. is path equal?
			if(name.equals(metamodel.name)) {
				// no path indicated => first name that corresponds => profile returned
				if(path == null) {
					return metamodel;
				} else if(path.equals(metamodel.path)) {
					return metamodel;
				}
			}
		}
		return null;
	}

	/**
	 * Retrieve all information from the configuration element
	 * 
	 * @param ordinal
	 *        index in the set of registered profiles
	 * @param configElt
	 *        the configuration element from which to retrieve the registered profile
	 * @return the registered profile
	 */
	private static RegisteredMetamodel parseMetamodelExtension(IConfigurationElement configElt, int ordinal) {
		if(!TAG_METAMODEL.equals(configElt.getName())) {
			return null;
		}
		try {
			return new RegisteredMetamodel(configElt, ordinal);
		} catch (Exception e) {
			String name = configElt.getAttribute(ExtensionIds.ATT_NAME);
			if(name == null) {
				name = "[missing name attribute]";
			}
			String msg = "Failed to load metamodel named " + name + " in "
					+ configElt.getDeclaringExtension().getExtensionPointUniqueIdentifier();
			Activator.log(msg);
			return null;
		}
	}
}
