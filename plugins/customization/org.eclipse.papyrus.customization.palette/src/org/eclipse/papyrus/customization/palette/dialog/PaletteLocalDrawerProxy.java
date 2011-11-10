/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.customization.palette.dialog;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.swt.graphics.Image;

/**
 * Proxy class for container entries
 */
public class PaletteLocalDrawerProxy extends PaletteContainerProxy {

	/** label of the drawer */
	protected String label;

	/** id of the drawer */
	protected String id;

	/** icon of the drawer */
	protected String imagePath;

	/** description of the drawer */
	private String description;


	/** PropertyChangeSupport */
	protected PropertyChangeSupport drawerListener = new PropertyChangeSupport(this);

	/**
	 * Creates a new PaletteContainer
	 * 
	 * @param drawer
	 *        the drawer to cache
	 */
	public PaletteLocalDrawerProxy(String name, String id, String imagePath, String description) {
		super(null);
		this.label = name;
		this.id = id;
		this.setDescription(description);
		this.imagePath = imagePath;
	}

	/**
	 * A listener can only be added once. Adding it more than once will do nothing.
	 * 
	 * @param listener
	 *        the PropertyChangeListener that is to be notified of changes
	 * @see java.beans.PropertyChangeSupport#addPropertyChangeListener(java.beans.PropertyChangeListener)
	 */
	@Override
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		drawerListener.removePropertyChangeListener(listener);
		drawerListener.addPropertyChangeListener(listener);
		super.addPropertyChangeListener(listener);
	}

	/**
	 * @param listener
	 *        the PropertyChangeListener that is not to be notified anymore
	 * @see java.beans.PropertyChangeSupport#removePropertyChangeListener(java.beans.PropertyChangeListener)
	 */
	@Override
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		drawerListener.removePropertyChangeListener(listener);
		super.removePropertyChangeListener(listener);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PaletteContainer getEntry() {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getLabel() {
		return label;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getId() {
		return id;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Image getImage() {
		return Activator.getPluginIconImage(Activator.ID, imagePath);
	}

	/**
	 * Returns the image path
	 * 
	 * @return the image path
	 */
	@Override
	public String getImagePath() {
		return imagePath;
	}

	/**
	 * Sets the label of the drawer
	 * 
	 * @param label
	 *        the label to set
	 */
	@Override
	public void setLabel(String label) {
		String oldValue = this.label;
		this.label = label;
		drawerListener.firePropertyChange(PROPERTY_ICON_PATH, oldValue, label);
	}

	/**
	 * @{inheritDoc
	 */
	@Override
	public void addChild(PaletteEntryProxy entry) {
		super.addChild(entry);
	}

	/**
	 * Sets the id of the drawer
	 * 
	 * @param id
	 *        the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Sets the image path of the drawer
	 * 
	 * @param imagePath
	 *        the imagePath to set
	 */
	public void setImagePath(String imagePath) {
		String oldValue = this.imagePath;
		this.imagePath = imagePath;
		drawerListener.firePropertyChange(PROPERTY_ICON_PATH, oldValue, imagePath);
	}

	/**
	 * Sets the description of the drawer
	 * 
	 * @param description
	 *        the description to set
	 */
	@Override
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Returns the description of the drawer
	 * 
	 * @return the description of the drawer
	 */
	@Override
	public String getDescription() {
		return description;
	}

}
