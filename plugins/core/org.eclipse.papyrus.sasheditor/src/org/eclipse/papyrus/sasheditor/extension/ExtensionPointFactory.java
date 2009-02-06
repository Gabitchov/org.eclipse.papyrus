/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
  *****************************************************************************/
package org.eclipse.papyrus.sasheditor.extension;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.InvalidRegistryObjectException;
import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;

/**
 * A factory used to create descriptor object from Eclipse extensions points elements.
 * 
 * TODO Rename to EditorDescriptorExtensionFactory
 */
public class ExtensionPointFactory {

	/** singleton instance of this class */
	public final static ExtensionPointFactory eINSTANCE = new ExtensionPointFactory();

	/**
	 * Returns the singleton instance of this factory
	 * 
	 * @return the singleton instance of this factory
	 */
	public static ExtensionPointFactory getInstance() {
		return eINSTANCE;
	}

	/**
	 * Creates a new Extension Point Factory
	 * <p>
	 * private visibility for the singleton pattern
	 * </p>
	 */
	private ExtensionPointFactory() {

	}

	/**
	 * Create a descriptor instance corresponding to the ConfigurationElement.
	 * 
	 * @param element
	 *            extension point being parsed
	 * @return the nested editor descriptor created
	 * @throws BadNameExtensionException
	 *             an attribute is not correctly defined in the extension
	 */
	public NestedEditorDescriptor createNestedEditorDescriptor(IConfigurationElement element) throws ExtensionException {
		NestedEditorDescriptor res;
		String tagName = "editor";

		checkTagName(element, tagName);

		res = new NestedEditorDescriptor();
		res.setEditorFactoryClass(parseClass(element, "factoryClass"));

		for (IConfigurationElement ele : element.getChildren()) {
			ActionBarButtonDescriptor button = createActionBarButtonDescriptor(ele);
			res.setCreateButtonDescriptor(button);
		}
		return res;
	}

	/**
	 * Create a descriptor instance corresponding to the ConfigurationElement.
	 * 
	 * @param element
	 *            the configuration element that defines the ActionBarButtonDescriptor
	 * @return the newly ActionBarButtonDescriptor created
	 */
	public ActionBarButtonDescriptor createActionBarButtonDescriptor(IConfigurationElement element) throws ExtensionException {
		ActionBarButtonDescriptor res;
		String tagName = "createEditorButton";
		checkTagName(element, tagName);

		res = new ActionBarButtonDescriptor();
		res.setPluginID(element.getDeclaringExtension().getNamespaceIdentifier());
		res.setCreateEditorActionClass(parseClass(element, "action"));
		res.setActionID(element.getAttribute("actionId"));
		res.setCreateDiagramLabel(element.getAttribute("label"));
		res.setCreateDiagramTooltip(element.getAttribute("tooltip"));

		res.setCreateDiagramImage(element.getAttribute("image"));
		res.setCreateDiagramDisableImage(element.getAttribute("disabledImage"));
		return res;
	}

	/**
	 * @param element
	 * @param tagName
	 * @throws InvalidRegistryObjectException
	 * @throws BadNameExtensionException
	 */
	private void checkTagName(IConfigurationElement element, String tagName) throws BadNameExtensionException {
		String name = element.getName();
		if (!tagName.equals(name))
			throw new BadNameExtensionException("Expected '" + tagName + "', found '" + name + "'.");
	}

	/**
	 * Retrieves the value of a specific attribute in a configuration element
	 * 
	 * @param element
	 *            the configuration element to parse
	 * @param attributeName
	 *            the name of the attribute to read
	 * @return the class, result of the parsing
	 * @throws InvalidRegistryObjectException
	 * @throws BadClassNameException
	 */
	private Class<?> parseClass(IConfigurationElement element, String attributeName) throws BadClassNameException {
		String className = element.getAttribute(attributeName);
		Class<?> factoryClass;
		try {
			factoryClass = Class.forName(className);
		} catch (ClassNotFoundException e) {
			// try another way
			try {
				String declaringID = element.getContributor().getName();
				Bundle bundle = Platform.getBundle(declaringID);
				factoryClass = bundle.loadClass(className);
			} catch (ClassNotFoundException e1) {
				throw new BadClassNameException(element, attributeName, e1);
			}
		}
		return factoryClass;
	}
}
