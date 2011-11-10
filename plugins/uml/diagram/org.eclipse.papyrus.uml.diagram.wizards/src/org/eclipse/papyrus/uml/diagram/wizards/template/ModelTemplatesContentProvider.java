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
 *	Saadia Dhouib (CEA LIST) - Implementation of loading diagrams from template files  (.uml, .di , .notation)
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.wizards.template;

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
	private static final String EXTENSION_POINT_ID = "org.eclipse.papyrus.uml.diagram.wizards.templates"; //$NON-NLS-1$

	/** The Constant ATTRIBUTE_NAME. */
	private static final String ATTRIBUTE_NAME = "name"; //$NON-NLS-1$

	/** The Constant ATTRIBUTE_FILE. */
	private static final String ATTRIBUTE_UML_FILE = "file"; //$NON-NLS-1$
	
	/** The Constant ATTRIBUTE_NOTATION_FILE. */
	private static final String ATTRIBUTE_NOTATION_FILE = "notation_file"; //$NON-NLS-1$
	
	/** The Constant ATTRIBUTE_DI_FILE. */
	private static final String ATTRIBUTE_DI_FILE = "di_file"; //$NON-NLS-1$

	/** The Constant ATTRIBUTE_LANGUAGE. */
	private static final String ATTRIBUTE_LANGUAGE = "language"; //$NON-NLS-1$
	
	/** The my template descriptions. */
	private ModelTemplateDescription[] myTemplateDescriptions;

	/**
	 * Dispose.
	 *
	 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
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
			ModelTemplateDescription template = new ModelTemplateDescription(configElement.getAttribute(ATTRIBUTE_NAME), extension.getContributor().getName(), configElement.getAttribute(ATTRIBUTE_UML_FILE),configElement.getAttribute(ATTRIBUTE_NOTATION_FILE),configElement.getAttribute(ATTRIBUTE_DI_FILE));
			template.setLanguage(configElement.getAttribute(ATTRIBUTE_LANGUAGE));
			templates.add(template);
		}
		return templates;
	}

	/**
	 * Gets the elements.
	 *
	 * @param inputElement the input element
	 * @return the elements
	 * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
	 */
	public Object[] getElements(Object inputElement) {
		
		if(inputElement instanceof Object[]) {		
			List<ModelTemplateDescription> result = new ArrayList<ModelTemplateDescription>();			
			
			for (Object next: (Object[])inputElement) {
				if (next instanceof String) {
					String diagramCategory = (String)next;
					for(ModelTemplateDescription template : getTemplatesDescription()) {						
						if(diagramCategory == null || diagramCategory.equals(template.getLanguage())) {
							result.add(template);
						}
					}
				}
			}
			return result.toArray();
		}
		
		return new Object[0];
	}

	/**
	 * Input changed.
	 *
	 * @param viewer the viewer
	 * @param oldInput the old input
	 * @param newInput the new input
	 * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
	 */
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		if(viewer instanceof TableViewer) {
			((TableViewer)viewer).add(getElements(null));
		}
	}

}