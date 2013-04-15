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
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.ui.presentation;

import org.eclipse.swt.graphics.Image;

/**
 * This interface shall be implemented by specific IStrackFrame, IVariable and IValue,
 * in order to return some specific presentation information, which are automatically
 * used by the debug framework.
 *
 */
public interface IPresentation {

	/**
	 * Returns the label for this element.
	 * This is effective for the following kind of element:
	 * - IStackFrame
	 * 
	 * @return The label for this element
	 */
	public String getLabel() ;
	
	/**
	 * Returns the details corresponding to this element.
	 * Details are displayed in the Variable panel of the Debug perspective.
	 * This is effective for the following kind of element:
	 * - IValue
	 * 
	 * @return Returns the details corresponding to this element.
	 */
	public String getDetails() ;
	
	/**
	 * Returns the image for this element.
	 * This is effective for the following kind of element:
	 * - IStackFrame
	 * - IVariable
	 * 
	 * @return The image for this element.
	 */
	public Image getImage() ;
	
}
