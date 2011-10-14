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
package org.eclipse.papyrus.eclipse.project.editors.interfaces;

import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * 
 * Editor for the file plugin.xml
 * 
 */
public interface IPluginProjectEditor extends IProjectEditor, IFileEditor {

	/** the node extension */
	public static final String EXTENSION = "extension"; //$NON-NLS-1$

	/** the attribute point */
	public static final String POINT = "point"; //$NON-NLS-1$

	/** the name of the file plugin.xml */
	public static final String PLUGIN_XML_FILE = "plugin.xml"; //$NON-NLS-1$

	/** the plugin nature */
	public static final String PLUGIN_NATURE = "org.eclipse.pde.PluginNature"; //$NON-NLS-1$

	/** the plugin build command */
	public static final String PLUGIN_BUILD_COMMAND = "org.eclipse.pde.SchemaBuilder"; //$NON-NLS-1$

	/** the method to add an extension to the plugin */
	public Element addExtension(final String extensionPoint);

	/** the method to get all the extensions of the type extensionPoint */
	public List<Node> getExtensions(final String extensionPoint);

	/** the method to set an attribute to an element */
	public void setAttribute(final Element element, final String attributeName, final String attributeValue);

	/** the method to add a child to an element */
	public Element addChild(final Element element, final String childName);

	/** the method to retrieve the plugin.xml XML Document associated to this project */
	public Document getDocument();
}
