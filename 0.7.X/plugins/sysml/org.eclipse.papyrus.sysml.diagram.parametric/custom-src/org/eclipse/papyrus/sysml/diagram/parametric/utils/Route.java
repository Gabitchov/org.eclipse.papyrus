/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Thibault Landre (Atos Origin) thibault.landre@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.parametric.utils;

import java.util.LinkedList;

import org.eclipse.uml2.uml.Property;

/**
 * A class to described a route to access a property from a classifier. This class contains an
 * ordered list of the property contained in the route and a string representing the name of the
 * route.
 */
public class Route {

	/** The properties list. */
	private LinkedList<Property> propertyList;

	/** The name of the route */
	private String name;

	/**
	 * Instantiates a new route.
	 */
	public Route() {
		this(new LinkedList<Property>());
	}

	/**
	 * Instantiates a new route.
	 * 
	 * @param propertyList
	 */
	public Route(LinkedList<Property> propertyList) {
		assert propertyList != null;
		this.propertyList = propertyList;
		this.name = "";
	}

	/**
	 * Adds a property to the list
	 * 
	 * @param property
	 */
	protected void addSegment(Property property) {
		propertyList.add(property);
	}

	/**
	 * Calculate the name of the route. The name is composed of the name of each property which
	 * makes up the route separated by coma.
	 */
	private void calculateName() {
		name = "";
		for (Property property : propertyList) {
			if (name.length() == 0) {
				name = property.getName();
			} else {
				name = name + "." + property.getName();
			}
		}
	}

	/**
	 * Gets the name.
	 * 
	 * @return the name
	 */
	public String getName() {
		calculateName();
		return name;
	}

	/**
	 * Gets the properties.
	 * 
	 * @return the properties
	 */
	public LinkedList<Property> getProperties() {
		return propertyList;
	}
	
	/**
	 * Gets the route depth.
	 * 
	 * @return the route depth
	 */
	public int getRouteDepth () {
		return propertyList.size();
	}
}
