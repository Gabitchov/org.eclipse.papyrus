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
package org.eclipse.papyrus.newchild.runtime;

import org.eclipse.jface.action.ContributionItem;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;


public class DisabledContributionItem extends ContributionItem {

	protected String text;

	protected ImageDescriptor image;

	protected boolean menuStyle = false;

	public DisabledContributionItem(String text, ImageDescriptor image, String id) {
		this.text = text;
		this.image = image;
		setId(id);
	}

	public void setMenuStyle(boolean menuStyle) {
		this.menuStyle = menuStyle;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public void fill(Menu parent, int index) {
		MenuItem item = new MenuItem(parent, SWT.CASCADE, index);
		item.setText(text);
		item.setEnabled(false);

		if(image != null) {
			item.setImage(image.createImage());
		}

		if(menuStyle) {
			item.setMenu(new Menu(item));
		}
	}
}
