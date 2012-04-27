/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.css.theme;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.swt.graphics.Image;

/**
 * A CSS Theme descriptor
 * 
 * @author Camille Letavernier
 */
public class Theme {

	private String label;

	private Image icon;

	private final String id;

	private final List<URL> styleSheets;

	public Theme(String id) {
		this.id = id;
		this.styleSheets = new LinkedList<URL>();
	}

	public String getLabel() {
		return label == null || "".equals(label) ? id : label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Image getIcon() {
		return icon;
	}

	public void setIcon(Image icon) {
		this.icon = icon;
	}

	public String getId() {
		return id;
	}

	public void addStyleSheet(URL url) {
		styleSheets.add(url);
	}

	public List<URL> getStyleSheets() {
		return styleSheets;
	}
}
