/**
 * Copyright (c) 2012 Mia-Software.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  	Alban Ménager (Soft-Maint) - Bug 387470 - [EFacet][Custom] Editors
 *  	Grégoire Dupé (Mia-Software) - Bug 387470 - [EFacet][Custom] Editors
 */
package org.eclipse.emf.facet.util.ui.utils;

/**
 * Generic class representing all the properties like:
 * <ol>
 * <li>facetName</li>
 * <li>upperBound</li>
 * <li>unique</li>
 * <li>...</li>
 * </ol>
 * 
 * @since 0.3
 */
public class PropertyElement {

	// TODO This class must not be exposed.

	private final String name;
	private final Class<?> type;
	private boolean changeable;
	private Object value;

	/**
	 * Constructor
	 * 
	 * @param name
	 *            the name of the property.
	 * @param type
	 *            the type of the property.
	 * @param changeable
	 *            if the property can be changed (edited) or not.
	 */
	public PropertyElement(final String name, final Class<?> type,
			final boolean changeable) {
		this(name, type, changeable, null);
	}

	/**
	 * Constructor
	 * 
	 * @param name
	 *            the name of the property.
	 * @param type
	 *            the type of the property.
	 * @param changeable
	 *            if the property can be changed (edited) or not.
	 * @param value
	 *            the initial value of the property.
	 */
	public PropertyElement(final String name, final Class<?> type,
			final boolean changeable, final Object value) {
		super();
		this.name = name;
		this.type = type;
		this.changeable = changeable;
		this.value = value;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @return the changeable
	 */
	public boolean isChangeable() {
		return this.changeable;
	}

	/**
	 * @return the type
	 */
	public Class<?> getType() {
		return this.type;
	}

	/**
	 * @return the value
	 */
	public Object getValue() {
		return this.value;
	}

	/**
	 * set the value.
	 */
	public void setValue(final Object value) {
		this.value = value;
	}

	/**
	 * @param changeable
	 *            the changeable to set
	 */
	public void setChangeable(final boolean changeable) {
		this.changeable = changeable;
	}
}
