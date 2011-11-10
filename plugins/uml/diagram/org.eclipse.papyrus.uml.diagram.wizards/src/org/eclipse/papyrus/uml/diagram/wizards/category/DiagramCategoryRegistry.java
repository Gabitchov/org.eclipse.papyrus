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
package org.eclipse.papyrus.uml.diagram.wizards.category;

import static org.eclipse.papyrus.uml.diagram.wizards.Activator.log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.Platform;
import org.eclipse.papyrus.infra.core.extension.BadClassNameException;
import org.eclipse.papyrus.infra.core.extension.ExtensionUtils;
import org.eclipse.papyrus.infra.core.extension.commands.IModelCreationCommand;
import org.eclipse.papyrus.uml.diagram.wizards.Messages;
import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 * The Class DiagramCategoryRegistry reads available DiagramCategories from plugin descriptors.
 */
public class DiagramCategoryRegistry extends ExtensionUtils {

	/** The Constant CATEGORY_EXTENSION_POINT_NAME. */
	private static final String CATEGORY_EXTENSION_POINT_NAME = "org.eclipse.papyrus.infra.core.papyrusDiagram"; //$NON-NLS-1$

	/** ID of the editor extension (schema filename). */
	public static final String CATEGORY_ELEMENT_NAME = "diagramCategory"; //$NON-NLS-1$

	/** The Constant CATEGORY_ID. */
	private static final String CATEGORY_ID = "id"; //$NON-NLS-1$

	/** The Constant CATEGORY_LABEL. */
	private static final String CATEGORY_LABEL = "label"; //$NON-NLS-1$

	/** The Constant CATEGORY_DESCRIPTION. */
	private static final String CATEGORY_DESCRIPTION = "description"; //$NON-NLS-1$

	/** The Constant CATEGORY_ICON. */
	private static final String CATEGORY_ICON = "icon"; //$NON-NLS-1$

	/** The Constant CATEGORY_CLASS. */
	private static final String CATEGORY_CLASS = "class"; //$NON-NLS-1$

	/** The Constant CATEGORY_FILE_EXTENSION_PREFIX. */
	private static final String CATEGORY_FILE_EXTENSION_PREFIX = "extensionPrefix"; //$NON-NLS-1$

	/** The diagram categories. */
	private static Map<String, DiagramCategoryDescriptor> diagramCategories;

	/** The our instance. */
	private static DiagramCategoryRegistry ourInstance;

	/**
	 * Instantiates a new diagram category registry.
	 */
	private DiagramCategoryRegistry() {
	}

	/**
	 * Gets the single instance of DiagramCategoryRegistry.
	 * 
	 * @return single instance of DiagramCategoryRegistry
	 */
	public static DiagramCategoryRegistry getInstance() {
		if(ourInstance == null) {
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
		return new ArrayList<DiagramCategoryDescriptor>(diagramCategories.values());
	}

	/**
	 * Gets the diagram category map.
	 *
	 * @return the diagram category map
	 */
	public Map<String, DiagramCategoryDescriptor> getDiagramCategoryMap() {
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
	public Map<String, DiagramCategoryDescriptor> buildDiagramCategories() {
		Map<String, DiagramCategoryDescriptor> result = new HashMap<String, DiagramCategoryDescriptor>();

		IExtensionPoint extensionPoint = Platform.getExtensionRegistry().getExtensionPoint(CATEGORY_EXTENSION_POINT_NAME);
		for(IExtension extension : extensionPoint.getExtensions()) {
			for(IConfigurationElement confElement : extension.getConfigurationElements()) {
				if(CATEGORY_ELEMENT_NAME.equals(confElement.getName())) {
					DiagramCategoryDescriptor diagramCategoryDescriptor;
					try {
						diagramCategoryDescriptor = buildCategoryDescriptor(confElement);
						result.put(diagramCategoryDescriptor.getId(), diagramCategoryDescriptor);
					} catch (BadClassNameException e) {
						log.error(Messages.DiagramCategoryRegistry_bad_class_name_of_category, e);
					}
				}
			}
		}
		return result;
	}

	/**
	 * Builds the category descriptor.
	 *
	 * @param confElement the conf element
	 * @return the diagram category descriptor
	 * @throws BadClassNameException the bad class name exception
	 */
	protected DiagramCategoryDescriptor buildCategoryDescriptor(IConfigurationElement confElement) throws BadClassNameException {
		Class<IModelCreationCommand> commandClazz = (Class<IModelCreationCommand>)parseClass(confElement, CATEGORY_CLASS, CATEGORY_ELEMENT_NAME);
		DiagramCategoryDescriptor diagramCategoryDescriptor = new DiagramCategoryDescriptor(confElement.getAttribute(CATEGORY_ID), confElement.getAttribute(CATEGORY_LABEL), commandClazz);
		diagramCategoryDescriptor.setDescription(confElement.getAttribute(CATEGORY_DESCRIPTION));
		diagramCategoryDescriptor.setExtensionPrefix(confElement.getAttribute(CATEGORY_FILE_EXTENSION_PREFIX));
		String iconPath = confElement.getAttribute(CATEGORY_ICON);
		if(iconPath != null) {
			diagramCategoryDescriptor.setIcon(AbstractUIPlugin.imageDescriptorFromPlugin(confElement.getNamespaceIdentifier(), iconPath));
		}
		return diagramCategoryDescriptor;
	}

}
