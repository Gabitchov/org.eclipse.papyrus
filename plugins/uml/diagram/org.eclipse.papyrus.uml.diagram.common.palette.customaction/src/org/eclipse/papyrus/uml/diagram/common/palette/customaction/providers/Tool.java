/*****************************************************************************
 * Copyright (c) 2011 AtoS.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan FAURE (AtoS) tristan.faure@atos.net - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.palette.customaction.providers;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.uml.diagram.common.service.palette.IPaletteEntryProxy;

/**
 * Representation of data contained Extension Point
 *
 */
public class Tool {

	private String id;
	private String name;
	private ICreator creator  ;
	private String description;
	
	public String getDescription() {
		return description;
	}

	public void setCreator(ICreator wizard)
	{
		this.creator = wizard;
	}
	
	public String getName()
	{
		return name ;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public ICreator getCreator ()
	{
		return creator ;
	}
	
	public String toString ()
	{
		return getName();
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public boolean isEnabled(IPaletteEntryProxy entryProxy)
	{
		return creator.isEnabled(entryProxy);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public EStructuralFeature[] getAllImpactedFeatures() {
		return creator.getAllImpactedFeatures();
	}

}
