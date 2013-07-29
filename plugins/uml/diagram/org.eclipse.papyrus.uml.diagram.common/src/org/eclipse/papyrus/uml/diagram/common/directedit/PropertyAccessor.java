/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.directedit;


/**
 * Default implementation for the interface IPropertyAccessor.
 */
public abstract class PropertyAccessor implements IPropertyAccessor {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cea.papyrus.core.common.directedit.IPropertyAccessor#getPropertyName
	 * ()
	 */
	/**
	 * 
	 * 
	 * @return
	 */
	public String getPropertyName() {
		return "";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cea.papyrus.core.common.directedit.IPropertyAccessor#getValue()
	 */
	/**
	 * 
	 * 
	 * @return
	 */
	public abstract String getValue();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cea.papyrus.core.common.directedit.IPropertyAccessor#setValue(java
	 * .lang.String)
	 */
	/**
	 * 
	 * 
	 * @param value
	 */
	public abstract void setValue(String value);
}
