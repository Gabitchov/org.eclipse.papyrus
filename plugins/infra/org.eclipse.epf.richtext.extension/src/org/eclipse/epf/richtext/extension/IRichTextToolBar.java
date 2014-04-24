/*****************************************************************************
* Copyright (c) 2013 CEA
*
*    
 * All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*   Soyatec - Initial API and implementation
*
*****************************************************************************/
package org.eclipse.epf.richtext.extension;

import org.eclipse.epf.richtext.extension.actions.RichTextButtonAction;
import org.eclipse.epf.richtext.actions.RichTextComboAction;
import org.eclipse.swt.widgets.Button;

/**
 * The interface for a rich text editor toolbar.
 * 
 * @author Nguyen Viet Hoa
 *
 */
public interface IRichTextToolBar extends org.eclipse.epf.richtext.IRichTextToolBar{

	
	/**
	 * Adds a button to the tool bar.
	 * 
	 * @param button
	 *            the button to add
	 */
	public  void addButton(Button button);
	
	/**
	 * Adds a button action to the tool bar.
	 * 
	 * @param action
	 *            the button action to add
	 */
	public void addAction(RichTextButtonAction item);
	
	/**
	 * Adds a combo action to the tool bar.
	 * 
	 * @param action
	 *            the combo action to add
	 */
	public void addAction(RichTextComboAction item);

	/**
	 * Adds a combo action to the tool bar.
	 * 
	 * @param action
	 *            the combo action to add
	 */
	public void addAction(org.eclipse.epf.richtext.extension.actions.RichTextComboAction item);

}
