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
package org.eclipse.papyrus.uml.diagram.wizards.kind;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.commands.CreationCommandDescriptor;
import org.eclipse.papyrus.commands.ICreationCommandRegistry;

/**
 * The ContentProvider for DiagramCategory table.
 * Returns available diagram kinds for the giben diagram category(ies).
 */
public class DiagramKindContentProvider implements IStructuredContentProvider {

	/** The creation command registry. */
	private final ICreationCommandRegistry creationCommandRegistry;
	
	
	/**
	 * Instantiates a new diagram kind content provider.
	 *
	 * @param creationCommandRegistry the creation command registry
	 */
	public DiagramKindContentProvider(ICreationCommandRegistry creationCommandRegistry) {
		this.creationCommandRegistry = creationCommandRegistry;
	}


	/**
	 * Dispose.
	 *
	 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
	 */
	public void dispose() {
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
			List<CreationCommandDescriptor> result = new ArrayList<CreationCommandDescriptor>();
			for (Object next: (Object[])inputElement) {
				if (next instanceof String) {
					String diagramCategory = (String)next;
					result.addAll(getCreationCommands(diagramCategory));
				}
			}
			Collections.sort(result, new Comparator<CreationCommandDescriptor>() {

				public int compare(CreationCommandDescriptor o1, CreationCommandDescriptor o2) {
					return o1.getLabel().compareTo(o2.getLabel());
				}
			});
			return result.toArray(new Object[result.size()]);
		}
		if(inputElement instanceof String) {
			String diagramCategory = (String)inputElement;
			List<CreationCommandDescriptor> result = getCreationCommands(diagramCategory);
			return result.toArray(new Object[result.size()]);
		}
		return null;
	}

	/**
	 * Gets the creation commands.
	 *
	 * @param diagramCategory the diagram category
	 * @return the creation commands
	 */
	protected List<CreationCommandDescriptor> getCreationCommands(String diagramCategory) {
		List<CreationCommandDescriptor> result = new ArrayList<CreationCommandDescriptor>();
		for(CreationCommandDescriptor desc : getCreationCommandRegistry().getCommandDescriptors()) {
			if(diagramCategory != null && diagramCategory.equals(desc.getLanguage())) {
				result.add(desc);
			}
		}
		return result;
	}
	
	/**
	 * Gets the creation command registry.
	 * 
	 * @return the creation command registry
	 */
	private ICreationCommandRegistry getCreationCommandRegistry() {
		return creationCommandRegistry;
	}
}