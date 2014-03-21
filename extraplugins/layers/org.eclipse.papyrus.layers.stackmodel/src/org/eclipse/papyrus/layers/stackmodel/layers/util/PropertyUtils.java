/*******************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cedric Dumoulin - cedric.dumoulin@lifl.fr
 ******************************************************************************/
package org.eclipse.papyrus.layers.stackmodel.layers.util;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersFactory;
import org.eclipse.papyrus.layers.stackmodel.layers.Property;
import org.eclipse.papyrus.layers.stackmodel.layers.Type;


/**
 * Utility for {@link Property}
 * @author cedric dumoulin
 *
 */
public class PropertyUtils {

	protected static final PropertyUtils INSTANCE;
	
	/**
	 * Initialize the instance
	 */
	static {
		INSTANCE = new PropertyUtils();
	}
	
	/**
	 * Get an instance of the class.
	 * @return
	 */
	public static PropertyUtils getInstance() {
		return INSTANCE;
	}
	
	/**
	 * Create a property with the specified name and type.
	 * @param name
	 * @param typeClass
	 * @return
	 */
	public Property createProperty( String name, EClass typeClass) {
		
		Property property = LayersFactory.eINSTANCE.createProperty();
		property.setName(name);
		Type type = (Type)LayersFactory.eINSTANCE.create(typeClass);
		property.setType(type);
		return property;
	}
}
