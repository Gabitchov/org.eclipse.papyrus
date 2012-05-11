/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.views.properties.widgets;

import org.eclipse.papyrus.views.properties.Activator;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;


/**
 * A Widget for editing Booleans. The widget is a button with two states.
 * The button can have either an image or a text
 * 
 * @author Camille Letavernier
 */
public class BooleanToggle extends AbstractPropertyEditor {

	private org.eclipse.papyrus.infra.widgets.editors.BooleanToggle toggle;

	private String imagePath;

	private String text;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param parent
	 *        The parent in which the widget will be created
	 * @param style
	 */
	public BooleanToggle(Composite parent, int style) {
		toggle = createBooleanToggle(parent, style);
		setEditor(toggle);
	}

	/**
	 * Creates the boolean toggle.
	 * 
	 * @param parent
	 *        The composite in which the widget will be displayed
	 * @param style
	 *        The style for the widget
	 * @return the boolean toggle.
	 */
	protected org.eclipse.papyrus.infra.widgets.editors.BooleanToggle createBooleanToggle(Composite parent, int style) {
		return new org.eclipse.papyrus.infra.widgets.editors.BooleanToggle(parent, style);
	}

	/**
	 * Sets this button's text
	 * 
	 * @param text
	 */
	public void setText(String text) {
		toggle.setText(this.text = text);
	}

	/**
	 * Return this button's text
	 * 
	 * @return this button's text
	 */
	public String getText() {
		return text;
	}

	/**
	 * Sets this button's image
	 * 
	 * @param imagePath
	 *        The path to the image, in the form /<plug-in>/<path>
	 */
	public void setImage(String imagePath) {
		this.imagePath = imagePath;
		Image image = Activator.getDefault().getImageFromPlugin(imagePath);
		toggle.setImage(image);
	}

	/**
	 * Returns the path to this editor's image
	 * 
	 * @return
	 *         The path to this editor's image
	 */
	public String getImage() {
		return imagePath;
	}
}
