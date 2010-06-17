/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tatiana Fesenko (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.wizards.category;

import static org.eclipse.papyrus.wizards.Activator.log;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.Platform;
import org.eclipse.papyrus.core.extension.BadClassNameException;
import org.eclipse.papyrus.core.extension.ExtensionUtils;
import org.eclipse.papyrus.core.extension.commands.IModelCreationCommand;
import org.eclipse.ui.plugin.AbstractUIPlugin;


/**
 * The Class DiagramCategoryRegistry.
 */
public class DiagramCategoryRegistry extends ExtensionUtils{

	/** The Constant CATEGORY_EXTENSION_POINT_NAME. */
	private static final String CATEGORY_EXTENSION_POINT_NAME = "org.eclipse.papyrus.core.papyrusDiagram";

	/** ID of the editor extension (schema filename) */
	public static final String CATEGORY_ELEMENT_NAME = "diagramCategory";

	/** The Constant CATEGORY_ID. */
	private static final String CATEGORY_ID = "id";

	/** The Constant CATEGORY_LABEL. */
	private static final String CATEGORY_LABEL = "label";

	/** The Constant CATEGORY_DESCRIPTION. */
	private static final String CATEGORY_DESCRIPTION = "description";

	/** The Constant CATEGORY_ICON. */
	private static final String CATEGORY_ICON = "icon";

	/** The Constant CATEGORY_CLASS. */
	private static final String CATEGORY_CLASS = "class";
	
	private static final String CATEGORY_FILE_EXTENSION_PREFIX = "extensionPrefix";	

	/** The diagram categories. */
	private static List<DiagramCategoryDescriptor> diagramCategories;
	
	private static DiagramCategoryRegistry ourInstance;

	private DiagramCategoryRegistry() {}
	
	/**
	 * Gets the single instance of DiagramCategoryRegistry.
	 *
	 * @return single instance of DiagramCategoryRegistry
	 */
	public static DiagramCategoryRegistry getInstance() {
		if (ourInstance == null) {
			ourInstance = new DiagramCategoryRegistry();
		}
		return ourInstance;
	}

	/**
	 * Gets the diagram categories.
	 * 
	 * @return the diagram categories
	 */
	public List<DiagramCategoryDescriptor> getDiagramCategories() {
		if(diagramCategories == null) {
			diagramCategories = buildDiagramCategories();
		}
		return diagramCategories;
	}

	/**
	 * Builds the diagram categories.
	 * 
	 * @return the hash map
	 */
	private List<DiagramCategoryDescriptor> buildDiagramCategories() {
		List<DiagramCategoryDescriptor> result = new ArrayList<DiagramCategoryDescriptor>();

		IExtensionPoint extensionPoint = Platform.getExtensionRegistry().getExtensionPoint(CATEGORY_EXTENSION_POINT_NAME);
		for(IExtension extension : extensionPoint.getExtensions()) {
			for(IConfigurationElement ele : extension.getConfigurationElements()) {
				if(CATEGORY_ELEMENT_NAME.equals(ele.getName())) {
					Class<IModelCreationCommand> commandClazz;
					try {
						commandClazz = (Class<IModelCreationCommand>)parseClass(ele, CATEGORY_CLASS, CATEGORY_ELEMENT_NAME);
						DiagramCategoryDescriptor diagramCategoryDescriptor = new DiagramCategoryDescriptor(ele.getAttribute(CATEGORY_ID), ele.getAttribute(CATEGORY_LABEL), commandClazz);
						diagramCategoryDescriptor.setDescription(ele.getAttribute(CATEGORY_DESCRIPTION));
						diagramCategoryDescriptor.setExtensionPrefix(ele.getAttribute(CATEGORY_FILE_EXTENSION_PREFIX));
						String iconPath = ele.getAttribute(CATEGORY_ICON);
						if(iconPath != null) {
							diagramCategoryDescriptor.setIcon(AbstractUIPlugin.imageDescriptorFromPlugin(ele.getNamespaceIdentifier(), iconPath));
						}
						result.add(diagramCategoryDescriptor);
					} catch (BadClassNameException e) {
						log.error(e);
					}
				}
			}
		}
		return result;

	}

}
