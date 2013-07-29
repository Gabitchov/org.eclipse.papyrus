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

package org.eclipse.papyrus.uml.diagram.common.service;

import java.util.List;
import java.util.Map;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.CombinedTemplateCreationEntry;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.uml.diagram.common.Activator;

/**
 * Entry that uses the functionality of another entry, but adds some actions to
 * it
 */
public class AspectCreationEntry extends CombinedTemplateCreationEntry implements Cloneable {

	/** overriden palette entry */
	protected CombinedTemplateCreationEntry entry;

	/** Tool object for this entry */
	protected Tool tool;

	/** properties for the tool */
	protected Map<?, ?> properties;

	/** specific icon path */
	private String iconPath;

	/** saves the image descriptor used by this entry */
	private ImageDescriptor descriptor;

	private final static String URL_IMAGE_DESCRIPTOR_BEGIN = "URLImageDescriptor(";

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
		// computes the icon path
		// due to visibility problems on URL image descriptor, use the
		// toString() method...
		computeIconPathFromImageDescriptor(descriptor);
		this.entry = entry;
		this.properties = properties;
		this.descriptor = descriptor;
	}

	/**
	 * Computes the icon path for the URL image descriptor
	 */
	protected void computeIconPathFromImageDescriptor(ImageDescriptor desc) {
		String value = desc.toString();
		if(value.startsWith("URLImageDescriptor(")) {
			String url = value.substring(URL_IMAGE_DESCRIPTOR_BEGIN.length(), value.length() - 1);
			setIconPath(url);
		}
	}

	/**
	 * Creates a new AspectCreationEntry
	 * 
	 * @param name
	 * @param desc
	 * @param id
	 * @param iconPath
	 * @param entry
	 * @param properties
	 */
	public AspectCreationEntry(String name, String desc, String id, String iconPath, CombinedTemplateCreationEntry entry, Map<?, ?> properties) {
		super(name, desc, null, Activator.getImageDescriptor(iconPath), Activator.getImageDescriptor(iconPath));
		setId(id);
		this.setIconPath(iconPath);
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
	 * Returns the specific properties for aspect actions
	 * 
	 * @param key
	 *        the key of the properties
	 * @return the specific properties for aspect actions
	 */
	public Object getAspectProperties(String key) {
		return properties.get(key);
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

	/**
	 * @param path
	 *        the iconPath to set
	 */
	public void setIconPath(String path) {
		iconPath = path;
	}

	/**
	 * @return the iconPath
	 */
	public String getIconPath() {
		return iconPath;
	}

	/**
	 * @{inheritDoc
	 */
	@Override
	public AspectCreationEntry clone() {
		if(getIconPath() != null) {
			return new AspectCreationEntry(this.getLabel(), this.getDescription(), entry.getId() + "_" + System.currentTimeMillis(), this.getIconPath(), this.entry, this.properties);
		}
		return new AspectCreationEntry(this.getLabel(), this.getDescription(), entry.getId() + "_" + System.currentTimeMillis(), this.descriptor, this.entry, this.properties);
	}
}
