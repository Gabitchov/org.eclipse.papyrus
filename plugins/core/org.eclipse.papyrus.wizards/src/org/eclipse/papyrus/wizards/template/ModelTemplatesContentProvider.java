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
package org.eclipse.papyrus.wizards.template;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;

/**
 * The Class ModelTemplatesContentProvider.
 */
public class ModelTemplatesContentProvider implements IStructuredContentProvider {

	/** The Constant EXTENSION_POINT_ID. */
	private static final String EXTENSION_POINT_ID = "org.eclipse.papyrus.wizards.templates";

	/** The Constant ATTRIBUTE_NAME. */
	private static final String ATTRIBUTE_NAME = "name";

	/** The Constant ATTRIBUTE_FILE. */
	private static final String ATTRIBUTE_FILE = "file";

	/** The Constant ATTRIBUTE_LANGUAGE. */
	private static final String ATTRIBUTE_LANGUAGE = "language";
	
	private ModelTemplateDescription[] myTemplateDescriptions;

	/**
	 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
	 *
	 */
	public void dispose() {
		// TODO Auto-generated method stub

	}

	/**
	 * Gets the templates description.
	 *
	 * @return the templates description
	 */
	private ModelTemplateDescription[] getTemplatesDescription() {
		if (myTemplateDescriptions == null) {
			List<ModelTemplateDescription> templates = new ArrayList<ModelTemplateDescription>();

			IExtensionRegistry registry = Platform.getExtensionRegistry();
			IExtension[] extensions = registry.getExtensionPoint(EXTENSION_POINT_ID).getExtensions();

			for(IExtension extension : extensions) {
				templates.addAll(processExtension(extension));
			}

			myTemplateDescriptions = templates.toArray(new ModelTemplateDescription[templates.size()]);
		}
		return myTemplateDescriptions;
	}

	/**
	 * Process extension.
	 *
	 * @param extension the extension
	 * @return the collection
	 */
	private Collection<ModelTemplateDescription> processExtension(IExtension extension) {
		List<ModelTemplateDescription> templates = new ArrayList<ModelTemplateDescription>();
		for(IConfigurationElement configElement : extension.getConfigurationElements()) {
			ModelTemplateDescription template = new ModelTemplateDescription(configElement.getAttribute(ATTRIBUTE_NAME), extension.getContributor().getName(), configElement.getAttribute(ATTRIBUTE_FILE));
			template.setLanguage(configElement.getAttribute(ATTRIBUTE_LANGUAGE));
			templates.add(template);
		}
		return templates;
	}

	/**
	 * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
	 *
	 * @param inputElement
	 */
	public Object[] getElements(Object inputElement) {
		if(inputElement instanceof String) {
			List<ModelTemplateDescription> result = new ArrayList<ModelTemplateDescription>();
			String diagramCategory = (String)inputElement;
			for(ModelTemplateDescription template : getTemplatesDescription()) {
				if(diagramCategory == null || diagramCategory.equals(template.getLanguage())) {
					result.add(template);
				}
			}
			return result.toArray();
		}
		return new Object[0];
	}

	/**
	 * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
	 *
	 * @param viewer
	 * @param oldInput
	 * @param newInput
	 */
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		if(viewer instanceof TableViewer) {
			((TableViewer)viewer).add(getElements(null));
		}
	}

}