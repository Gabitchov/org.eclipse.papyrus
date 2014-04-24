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

import org.eclipse.epf.richtext.IRichText;
import org.eclipse.epf.richtext.actions.FindReplaceAction;

/**
 * The interface for a rich text editor.
 * <p>
 * A rich text editor is a composite user interface object that includes a tool
 * bar, a tab folder for entering the rich text content, and a tab folder for
 * viewing and modifying the rich text content in a markup language.
 * 
 * @author Nguyen
 *
 */
public abstract interface IRichTextEditor extends IRichText
{
	/**
	 * Fills the tool bar with rich text action items.
	 * 
	 * @param toolBar
	 *            a rich text editor tool bar
	 */	
	  public abstract void fillToolBar(IRichTextToolBar paramIRichTextToolBar);
	  
	  /**
		 * Selects the rich text or the markup language tab.
		 * 
		 * @param index
		 *            <code>0</code> for the rich text tab, <code>1</code> for
		 *            the markup language tab
	  */
	  public abstract void setSelection(int paramInt);
	  
	  /**
		 * Sets the FindReplaceAction to use
		 * @param findReplaceAction
	  */
	  public abstract void setFindReplaceAction(FindReplaceAction paramFindReplaceAction);
}