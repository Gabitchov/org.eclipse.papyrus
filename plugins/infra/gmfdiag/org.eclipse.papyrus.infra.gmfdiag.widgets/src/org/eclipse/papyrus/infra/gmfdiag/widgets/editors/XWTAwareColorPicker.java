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
package org.eclipse.papyrus.infra.gmfdiag.widgets.editors;

import org.eclipse.papyrus.infra.gmfdiag.widgets.Activator;
import org.eclipse.papyrus.views.properties.widgets.AbstractPropertyEditor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;

/**
 * A widget to edit Colors represented by an Integer (RGB) value
 * The editor is a Button with a color-picker popup.
 * 
 * @author Camille Letavernier
 * 
 */
public class XWTAwareColorPicker extends AbstractPropertyEditor {

	private ColorPickerEditor editor;

	private String imagePath;

	private int x = -1, y = -1, width = -1, height = -1;

	public XWTAwareColorPicker(Composite parent, int style) {
		editor = new ColorPickerEditor(parent, style);
		setEditor(editor);
	}

	public void setImage(String imagePath) {
		this.imagePath = imagePath;
		Image image = Activator.getDefault().getImageFromPlugin(imagePath);
		if(image != null) {
			editor.setImage(image);
		}
	}

	@Override
	protected void doBinding() {
		super.doBinding();
		Object defaultValue = input.getDefaultValue(propertyPath);
		if(defaultValue instanceof Integer) {
			editor.setDefaultColor((Integer)defaultValue);
		}
	}

	public String getImage() {
		return imagePath;
	}

	protected void checkBounds() {
		if(x > -1 && y > -1 && width > -1 && height > -1) {
			editor.setColorBounds(new Rectangle(x, y, width, height));
		}
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
}
