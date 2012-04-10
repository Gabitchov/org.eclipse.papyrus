/*******************************************************************************
 * Copyright (c) 2006, 2010 Soyatec (http://www.soyatec.com) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Soyatec - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.xwt.metadata;

/**
 * This class is used to indicate when the property can be
 * initialized during the XML Loading.
 * 
 * @author yyang <yves.yang@soyatec.com>
 */
public enum IValueLoading {
	/**
	 * Set property just after Widget creation. It is the default value.
	 */
	Normal,

	/**
	 * Set property just after the complete initialization before the creation
	 * of children
	 */
	PostInitialization,

	/**
	 * Set property just after the creation of children
	 */
	PostChildren;
}
