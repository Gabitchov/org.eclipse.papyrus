/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.utils;

/**
 * Literals used to describe the paste mode
 * 
 * @author VL222926
 * 
 */
public enum PasteModeEnumeration {

	/**
	 * the user want paste rows
	 */
	PASTE_EOBJECT_ROW,
	/**
	 * the user wants paste columns
	 */
	PASTE_EOBJECT_COLUMN,
	/**
	 * the system can't decide if the user want paste rows or columns
	 */
	PASTE_EOBJECT_ROW_OR_COLUMN,
	/**
	 * paste is not possible
	 */
	CANT_PASTE;



}
