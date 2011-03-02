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
package org.eclipse.papyrus.properties.widgets;

import org.eclipse.papyrus.properties.Activator;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;


public class BooleanToggle extends AbstractPropertyEditor {

	private org.eclipse.papyrus.widgets.editors.BooleanToggle toggle;

	private String imagePath;

	private String text;

	public BooleanToggle(Composite parent, int style) {
		toggle = new org.eclipse.papyrus.widgets.editors.BooleanToggle(parent, style);
		setEditor(toggle);
	}

	public void setText(String text) {
		toggle.setText(this.text = text);
	}

	public String getText() {
		return text;
	}

	public void setImage(String imagePath) {
		this.imagePath = imagePath;
		Image image = Activator.getDefault().getImageFromPlugin(imagePath);
		toggle.setImage(image);
	}

	public String getImage() {
		return imagePath;
	}
}
