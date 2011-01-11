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
package org.eclipse.papyrus.wizards.kind;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.core.extension.commands.CreationCommandDescriptor;
import org.eclipse.papyrus.core.extension.commands.CreationCommandRegistry;
import org.eclipse.papyrus.core.extension.commands.ICreationCommandRegistry;

/**
 * The Class DiagramCategoryTableContentProvider.
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
		if(inputElement instanceof String) {
			String diagramCategory = (String)inputElement;
			List<CreationCommandDescriptor> result = new ArrayList<CreationCommandDescriptor>();
			for(CreationCommandDescriptor desc : getCreationCommandRegistry().getCommandDescriptors()) {
				if(diagramCategory != null && diagramCategory.equals(desc.getLanguage())) {
					result.add(desc);
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
	private static ICreationCommandRegistry getCreationCommandRegistry() {
		return CreationCommandRegistry.getInstance(org.eclipse.papyrus.core.Activator.PLUGIN_ID);
	}
}