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

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.papyrus.commands.CreationCommandDescriptor;
import org.eclipse.papyrus.commands.CreationCommandRegistry;
import org.eclipse.papyrus.commands.ICreationCommandRegistry;
import org.eclipse.papyrus.diagramtemplate.DiagramDefinition;
import org.eclipse.swt.graphics.Image;

/**
 * 
 * Label provider for the diagram definition
 * 
 */
public class DiagramDefinitionLabelProvider implements ILabelProvider {

	/**
	 * {@inheritDoc}
	 */
	public void addListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub

	}

	/**
	 * {@inheritDoc}
	 */
	public void dispose() {
		// TODO Auto-generated method stub

	}

	/**
	 * {@inheritDoc}
	 */
	public boolean isLabelProperty(Object element, String property) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	public void removeListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub

	}

	/**
	 * {@inheritDoc}
	 */
	public Image getImage(Object element) {
		if(element instanceof DiagramDefinition) {
			DiagramDefinition diagramDefinition = (DiagramDefinition)element;

			for(CreationCommandDescriptor desc : getCreationCommandRegistry().getCommandDescriptors()) {
				if(diagramDefinition != null && diagramDefinition.getDiagramKind().equalsIgnoreCase(desc.getCommandId())) {
					return desc.getIcon().createImage();
				}
			}
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getText(Object element) {
		if(element instanceof DiagramDefinition) {
			return ((DiagramDefinition)element).getName();
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
