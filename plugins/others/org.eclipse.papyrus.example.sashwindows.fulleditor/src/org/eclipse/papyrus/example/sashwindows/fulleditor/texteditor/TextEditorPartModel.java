/*****************************************************************************
 * Copyright (c) 2009 CEA LIST & LIFL 
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
  *****************************************************************************/
package org.eclipse.papyrus.example.sashwindows.fulleditor.texteditor;

import org.eclipse.papyrus.sasheditor.contentprovider.IEditorModel;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorActionBarContributor;

/**
 * Description of the first page
 * 
 * @author dumoulin
 */

public class TextEditorPartModel implements IEditorModel {

	/** The text editor used in page 0. */
	private TabTextEditor editor;

	private String title;

	static private int count = 0;

	/**
	 * @param title
	 */
	public TextEditorPartModel(String title) {
		this.title = title;
	}

	/**
		 * 
		 */
	public TextEditorPartModel() {
		title = "newText" + count++;
	}

	@Override
	public IEditorPart createIEditorPart() throws PartInitException {
		editor = new TabTextEditor();
		if (title == null)
			title = "newText" + count++;
		return editor;
	}

	@Override
	public Image getTabIcon() {
		return null;
	}

	@Override
	public String getTabTitle() {
		return title;
	}

	/**
	 * Return this. In this implementation, the rawModel and the IEditorModel are the same.
	 * 
	 */
	@Override
	public Object getRawModel() {
		return this;
	}

	/**
	 * Return the ActionBarContributor dedicated to the created editor.
	 * Can return null if no particular ActionBarContributor is required.;
	 */
	@Override
	public EditorActionBarContributor getActionBarContributor() {
		return null;
	}
}
