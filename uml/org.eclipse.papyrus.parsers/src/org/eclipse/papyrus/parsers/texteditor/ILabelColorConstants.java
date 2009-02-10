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
 *  Remi Schnekenburger (CEA LIST) Remi.Schnekenburger@cea.fr - Initial API and implementation
 *
  *****************************************************************************/
package org.eclipse.papyrus.parsers.texteditor;

import org.eclipse.swt.graphics.RGB;

/**
 * 
 */
public interface ILabelColorConstants {
    
	/**
	 * 
	 */
	public final String DEFAULT = "default";
	
	/**
	 * 
	 */
	public final String KEYWORD = "keyword";
	
	/**
	 * 
	 */
	public final String STRING = "string";
	
	/**
	 * 
	 */
	public final String SYMBOL = "symbol";
    
    /**
     * 
     */
    public final RGB RGB_DEFAULT = new RGB(0,0,0);
    
    /**
     * 
     */
    public final RGB RGB_CONSTANT = new RGB(120,120,120);
    
    /**
     * 
     */
    public final RGB RGB_BACKGROUND = new RGB(255,255,255);
    
    /**
     * 
     */
    public final RGB RGB_KEYWORD = new RGB(127,0,85);
    
    /**
     * 
     */
    public final RGB RGB_STRING = new RGB(85,200,85);
    
    /**
     * 
     */
    public final RGB RGB_SYMBOL = new RGB(42,0,255);
}
