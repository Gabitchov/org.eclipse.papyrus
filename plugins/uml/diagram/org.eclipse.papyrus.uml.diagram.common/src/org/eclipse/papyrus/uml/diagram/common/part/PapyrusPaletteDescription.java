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

package org.eclipse.papyrus.uml.diagram.common.part;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.gmf.runtime.common.core.service.ProviderPriority;
import org.eclipse.papyrus.uml.diagram.common.service.IPapyrusPaletteConstant;
import org.eclipse.ui.IMemento;

/**
 * Class that defines a profile for a palette.
 */
public class PapyrusPaletteDescription implements IPaletteDescription {

	/** name of the palette */
	private String name;

	/** id of the editor to contribute */
	private String contributionEditorID;

	/** contribution of this palette */
	private Object contributions;

	/** id of the palette */
	private String paletteID;

	/** priority of the palette */
	private ProviderPriority priority;

	/** properties of the palette */
	private Map<String, String> properties;

	/**
	 * Creates a new PapyrusPaletteDescription.
	 */
	public PapyrusPaletteDescription() {
	}

	/**
	 * Create a new Palette description using a preference memento
	 * 
	 * @param memento
	 *        the memento from which to read the description
	 * @return the content of the palette
	 */
	public static IPaletteDescription create(IMemento memento) {
		final PapyrusPaletteDescription description = new PapyrusPaletteDescription();
		description.setName(memento.getString(IPapyrusPaletteConstant.NAME));
		description.setPaletteID(memento.getString(IPapyrusPaletteConstant.ID));
		description.setContributionEditorID(memento.getString(IPapyrusPaletteConstant.EDITOR_ID));
		description.setContributions(memento.getString(IPapyrusPaletteConstant.PATH));
		description.setPriority(ProviderPriority.parse(memento.getString(IPapyrusPaletteConstant.PRIORITY)));

		// retrieve the map of properties
		IMemento propertiesMemento = memento.getChild(IPapyrusPaletteConstant.PALETTE_DESCRIPTION_PROPERTIES);
		Map<String, String> properties = new HashMap<String, String>();
		if(propertiesMemento != null) {
			// retrieve the child name/value tuple for each children
			for(String key : propertiesMemento.getAttributeKeys()) {
				properties.put(key, propertiesMemento.getString(key));
			}
		}
		description.setProperties(properties);
		// contributions: do not read the file before it is necessary...
		return description;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getContributionEditorID() {
		return contributionEditorID;
	}

	/**
	 * {@inheritDoc}
	 */
	public Object getContributions() {
		return contributions;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the palette description
	 * 
	 * @param name
	 *        the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Sets the id of the editor to contribute
	 * 
	 * @param contributionEditorID
	 *        the contributionEditorID to set
	 */
	public void setContributionEditorID(String contributionEditorID) {
		this.contributionEditorID = contributionEditorID;
	}

	/**
	 * Sets the contributions of this palette
	 * 
	 * @param contributions
	 *        the contributions to set
	 */
	public void setContributions(Object contributions) {
		this.contributions = contributions;
	}

	/**
	 * Sets the id of this palette
	 * 
	 * @param paletteID
	 *        the paletteID to set
	 */
	public void setPaletteID(String paletteID) {
		this.paletteID = paletteID;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getPaletteID() {
		return paletteID;
	}

	/**
	 * {@inheritDoc}
	 */
	public ProviderPriority getPriority() {
		return priority;
	}

	/**
	 * Sets the priority for this palette
	 * 
	 * @param priority
	 *        the priority to set
	 */
	public void setPriority(ProviderPriority priority) {
		this.priority = priority;
	}

	/**
	 * {@inheritDoc}
	 */
	public Map<String, String> getProperties() {
		return properties;
	}

	/**
	 * Sets the properties for this palette description
	 * 
	 * @param properties
	 *        the properties to set
	 */
	public void setProperties(Map<String, String> properties) {
		this.properties = properties;
	}

}
