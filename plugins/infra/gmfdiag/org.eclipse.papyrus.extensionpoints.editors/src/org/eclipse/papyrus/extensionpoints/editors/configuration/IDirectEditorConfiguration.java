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
package org.eclipse.papyrus.extensionpoints.editors.configuration;

import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;

/**
 * Interface that should be implemented by direct editors for Papyrus.
 */
public interface IDirectEditorConfiguration {

	/**
	 * Returns the style for the source viewer widget
	 * 
	 * @return the style for the source viewer widget
	 * @see SWT
	 */
	// @unused
	public int getStyle();

	/**
	 * Returns the preferred size for the dialog window
	 * 
	 * @return the preferred size for the dialog window
	 */
	// @unused
	public Point getPreferedSize();

	/**
	 * Returns the source viewer configuration for the editor
	 * 
	 * @return the source viewer configuration for the editor
	 */
	public SourceViewerConfiguration getSourceViewerConfiguration();

	/**
	 * Returns the text to edit
	 * 
	 * @return the text to edit
	 */
	public String getTextToEdit(Object editedObject);

	/**
	 * Action executed before opening editor dialog window
	 * 
	 * @return the result of this action
	 */
	public Object preEditAction(Object editedObject);

	/**
	 * Action executed before closing editor dialog window
	 * 
	 * @param newText
	 *            the text to save
	 * @return the result of this action
	 */
	public Object postEditAction(Object editedObject, String newText);

	/**
	 * Returns the extended Area for the dialog window
	 * 
	 * @param parent
	 *            the parent of the returned composite
	 * @return the extended Area for the dialog window or <code>null</code> if no extension is
	 *         required
	 */
	public Composite createExtendedDialogArea(Composite parent);

	/**
	 * Returns the language of the edited body
	 * 
	 * @return the language of the edited body
	 */
	public String getLanguage();

	/**
	 * Sets the language of the edited body
	 * 
	 * @param language
	 *            the language of the edited body
	 */
	public void setLanguage(String language);

	/**
	 * Returns the input validator, ie indicates if the text is correct
	 */
	public IInputValidator getInputValidator();

	/**
	 * Sets the input validator, ie the element that indicates if the text is correct
	 */
	// @unused
	public void setInputValidator(IInputValidator validator);

	/**
	 * Get the text selection for the viewer
	 * 
	 * @param value
	 * 
	 * @return a selection
	 */
	public Selection getTextSelection(String value, Object editedObject);

	/**
	 * Class that represents an area for text selection
	 */
	public static class Selection {

		private final int lentgh;

		private final int start;

		public Selection(int start, int lentgh) {
			this.start = start;
			this.lentgh = lentgh;
		}

		public int getLentgh() {
			return lentgh;
		}

		public int getStart() {
			return start;
		}

	}
}
