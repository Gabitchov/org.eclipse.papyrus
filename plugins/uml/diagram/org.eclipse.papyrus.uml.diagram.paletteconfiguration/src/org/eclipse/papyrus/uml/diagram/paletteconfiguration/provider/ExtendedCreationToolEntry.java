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
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.paletteconfiguration.provider;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gmf.runtime.diagram.ui.internal.services.palette.PaletteToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.services.palette.PaletteFactory;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.infra.extendedtypes.ExtendedTypesRegistry;
import org.eclipse.papyrus.uml.diagram.paletteconfiguration.ElementDescriptor;


/**
 * Extended version of the {@link CombinedTemplateCreationEntry}.
 */
public class ExtendedCreationToolEntry extends PaletteToolEntry implements IElementTypesBasedTool {

	/** list of element types created by this tool */
	final private List<IElementType> elementTypes = new ArrayList<IElementType>(); 
	
	/** List of Element Descriptors for this tool */
	private final List<ElementDescriptor> elementDescriptors; 
	
	/**
	 * Creates a new CreationToolEx.
	 *
	 * @param label the label of the tool
	 * @param factory the factory that creates the tool from this entry
	 * @param id  the unique identifier of the tool
	* @param elementDescriptors list of element descriptors created by the tool
	 */
	public ExtendedCreationToolEntry(String id, String label, PaletteFactory factory, List<ElementDescriptor> elementDescriptors) {
		super(id, label, factory);
		this.elementDescriptors = elementDescriptors;
		
		for(ElementDescriptor elementDescriptor : elementDescriptors) {
			elementTypes.add(ExtendedTypesRegistry.getInstance().getType(elementDescriptor.getElementTypeId()));
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public List<IElementType> getElementTypes() {
		return elementTypes;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public List<ElementDescriptor> getElementDescriptors() {
		return elementDescriptors;
	}
	
}
