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
package org.eclipse.papyrus.extensionpoints.uml2.library;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.papyrus.extensionpoints.uml2.Activator;
import org.eclipse.papyrus.extensionpoints.uml2.standard.ExtensionIds;
import org.eclipse.papyrus.extensionpoints.uml2.standard.RegisteredElementExtensionPoint;

/**
 * Class that manages registered library extension point
 */
public class RegisteredLibrary extends RegisteredElementExtensionPoint {

	/** name of the extension point (main element name) in the DTD */
	private static final String TAG_LIBRARY = "library";

	/** attribute that acts as a cache for the list of registered libraries */
	private static RegisteredLibrary[] RegisteredLibraries;

	/**
	 * Main constructor.
	 * 
	 * @param configElt
	 *        the configuration element that defines the given library
	 * @param ordinal
	 *        the place in the list of registered libraries
	 */
	public RegisteredLibrary(IConfigurationElement configElt, int ordinal) {
		super(configElt, ordinal);
	}

	/**
	 * Returns the list of registered libraries in the platform, using the Papyrus extension point.
	 * 
	 * @return the list of registered libraries in the platform
	 */
	public static RegisteredLibrary[] getRegisteredLibraries() {

		// if the list was already computed, returns it (like a cache)
		if(RegisteredLibraries != null) {
			return RegisteredLibraries;
		}

		// the list of libraries was not already computed. Read configuration elements
		List<RegisteredLibrary> libraries = new ArrayList<RegisteredLibrary>();

		// // Default elements : UML, Ecore, Java, XML PrimitiveTypes model library
		// RegisteredLibrary UmlPrimitiveTypes
		// = new RegisteredLibrary("UMLPrimitiveTypes",
		// URI.createURI(UMLResource.UML_PRIMITIVE_TYPES_LIBRARY_URI));
		// libraries.add(UmlPrimitiveTypes);
		// RegisteredLibrary EcorePrimitiveTypes
		// = new RegisteredLibrary("EcorePrimitiveTypes",
		// URI.createURI(UMLResource.ECORE_PRIMITIVE_TYPES_LIBRARY_URI));
		// libraries.add(EcorePrimitiveTypes);
		// RegisteredLibrary JavaPrimitiveTypes
		// = new RegisteredLibrary("JavaPrimitiveTypes",
		// URI.createURI(UMLResource.JAVA_PRIMITIVE_TYPES_LIBRARY_URI));
		// libraries.add(JavaPrimitiveTypes);
		// RegisteredLibrary XMLPrimitiveTypes
		// = new RegisteredLibrary("XMLPrimitiveTypes",
		// URI.createURI(UMLResource.XML_PRIMITIVE_TYPES_LIBRARY_URI));
		// libraries.add(XMLPrimitiveTypes);

		// Look for the rest in plugins
		IConfigurationElement[] configElements = Platform.getExtensionRegistry().getConfigurationElementsFor(
				ExtensionIds.LIBRARY_EXTENSION_ID);

		// Read configuration elements for the current extension
		for(int j = 0; j < configElements.length; j++) {
			RegisteredLibrary proxy = parseLibraryExtension(configElements[j], libraries.size());

			if(proxy != null) {
				libraries.add(proxy);
			}
		} // end of configElements loop

		RegisteredLibraries = libraries.toArray(new RegisteredLibrary[libraries.size()]);
		return RegisteredLibraries;
	}

	/**
	 * Parse data from extensions.
	 * 
	 * @param ordinal
	 * @param configElt
	 * @return
	 */
	private static RegisteredLibrary parseLibraryExtension(IConfigurationElement configElt, int ordinal) {
		if(!TAG_LIBRARY.equals(configElt.getName())) {
			return null;
		}
		try {
			return new RegisteredLibrary(configElt, ordinal);
		} catch (Exception e) {

			String name = configElt.getAttribute(ExtensionIds.ATT_NAME);
			if(name == null) {
				name = "[missing name attribute]";
			}
			String msg = "Failed to load library named " + name + " in "
					+ configElt.getDeclaringExtension().getExtensionPointUniqueIdentifier();
			Activator.log(msg);
			return null;
		}
	}
}
