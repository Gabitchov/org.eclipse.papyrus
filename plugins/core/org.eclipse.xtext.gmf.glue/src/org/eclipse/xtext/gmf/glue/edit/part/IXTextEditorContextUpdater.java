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
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.xtext.gmf.glue.edit.part;

import org.eclipse.xtext.ui.editor.XtextEditor;

/**
 * @author CEA LIST - Initial contribution and API
 * This interface is used for updating the currently selected popup xtext editor 
 * (i.e., when multiple editors are opened).
 */
public interface IXTextEditorContextUpdater {

	/**
	 * This method is called when a popup xtext editor gets the focus
	 * @param currentEditor The newly selected editor
	 */
	void updateCurrentEditor(XtextEditor currentEditor) ;
	
}
