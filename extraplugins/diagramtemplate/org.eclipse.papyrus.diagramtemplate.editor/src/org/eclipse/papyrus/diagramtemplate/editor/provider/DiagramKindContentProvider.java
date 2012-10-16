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
 *  Florian Noyrit - florian.noyrit@cea.fr (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagramtemplate.editor.provider;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.commands.CreationCommandDescriptor;
import org.eclipse.papyrus.commands.CreationCommandRegistry;
import org.eclipse.papyrus.commands.ICreationCommandRegistry;

/**
 * 
 * Content provider for the diagram kinds
 * 
 */
public class DiagramKindContentProvider implements IStructuredContentProvider {

	/**
	 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
	 * 
	 */
	public void dispose() {
	}

	/**
	 * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
	 * 
	 * @param viewer
	 * @param oldInput
	 * @param newInput
	 */
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
	}

	/**
	 * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
	 * 
	 * @param inputElement
	 */
	public Object[] getElements(Object inputElement) {
		if(inputElement instanceof List) {
			List<String> categories = (List<String>)inputElement;

			List<CreationCommandDescriptor> result = new ArrayList<CreationCommandDescriptor>();
			for(CreationCommandDescriptor desc : getCreationCommandRegistry().getCommandDescriptors()) {
				for(String category : categories) {
					if(category.equalsIgnoreCase(desc.getLanguage())) {
						result.add(desc);
						break;
					}
				}
			}

			return result.toArray();
		}
		return null;
	}

	/**
	 * Gets the creation command registry.
	 * 
	 * @return the creation command registry
	 */
	private ICreationCommandRegistry getCreationCommandRegistry() {
		return CreationCommandRegistry.getInstance(org.eclipse.papyrus.infra.core.Activator.PLUGIN_ID);
	}
}
