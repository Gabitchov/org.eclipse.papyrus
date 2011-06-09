/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) Remi.Schnekenburger@cea.fr - Initial API and implementation
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - customization for Parameter
 *
 *****************************************************************************/
package org.eclipse.papyrus.parsers.texteditor.parameterlabel;

/**
 * 
 */
public abstract interface IContext {

	/**
	 * 
	 */
	public static final int DEFAULT = 0;

	/**
	 * 
	 */
	public static final int VISIBILITY = 1;

	/**
	 * 
	 */
	public static final int DIRECTION = 2;

	/**
	 * 
	 */
	public static final int NAME = 3;

	/**
	 * 
	 */
	public static final int AFTER_COLON = 4;

	/**
	 * 
	 */
	public static final int PARAMETER_TYPE = 5;

	/**
	 * 
	 */
	public static final int MULTIPLICITY = 6;

	/**
	 * 
	 */
	public static final int DEFAULT_VALUE = 7;

	/**
	 * 
	 */
	public static final int PARAMETER_MODIFIERS = 8;

	/**
	 * 
	 */
	public static final int PARAMETER_MODIFIER = 9;

	/**
	 * 
	 */
	public static final int IN_MULTIPLICITY = 10;

	/**
	 * 
	 */
	public static final int AFTER_MULTIPLICITY = 11;
}
