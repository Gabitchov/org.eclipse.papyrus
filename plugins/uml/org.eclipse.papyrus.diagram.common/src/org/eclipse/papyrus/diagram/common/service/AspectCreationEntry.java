/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
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

package org.eclipse.papyrus.diagram.common.service;

import java.util.List;
import java.util.Map;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.CombinedTemplateCreationEntry;
import org.eclipse.jface.resource.ImageDescriptor;

/**
 * Entry that uses the functionality of another entry, but adds some actions to it
 */
public class AspectCreationEntry extends CombinedTemplateCreationEntry {

	/** overriden palette entry */
	protected CombinedTemplateCreationEntry entry;

	/** Tool object for this entry */
	protected Tool tool;

	/** properties for the tool */
	protected Map<?, ?> properties;

	/**
	 * Creates a new AspectCreationEntry
	 * 
	 * @param name
	 * @param desc
	 * @param id
	 * @param descriptor
	 * @param entry
	 * @param properties
	 */
	public AspectCreationEntry(String name, String desc, String id, ImageDescriptor descriptor, CombinedTemplateCreationEntry entry, Map<?, ?> properties) {
		super(name, desc, null, descriptor, descriptor);
		setId(id);
		this.entry = entry;
		this.properties = properties;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Tool createTool() {
		if(tool == null) {
			tool = entry.createTool();
			tool.setProperties(properties);
		}
		return tool;
	}

	/**
	 * Returns the referenced entry
	 * 
	 * @return the referenced entry
	 */
	public CombinedTemplateCreationEntry getReferencedEntry() {
		return entry;
	}

	/**
	 * Returns the list of stereotypes to apply post creation
	 * 
	 * @return the list of stereotypes to apply post creation
	 */
	@SuppressWarnings("unchecked")
	public List<String> getStereotypeList() {
		return (List<String>)properties.get(IPapyrusPaletteConstant.STEREOTYPES_TO_APPLY_KEY);
	}
}
