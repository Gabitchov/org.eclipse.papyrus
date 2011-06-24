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

import org.eclipse.papyrus.sasheditor.Activator;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.ExpandBar;
import org.eclipse.swt.widgets.ExpandItem;


public class ExpandableItem {

	private ExpandItem item;

	private Object control;

	public ExpandableItem(Composite parent, int style) {
		if(parent instanceof ExpandBar) {
			item = new ExpandItem((ExpandBar)parent, style);
		} else {
			Activator.log.warn("ExpandableItem can only be used in an ExpandBar"); //$NON-NLS-1$
		}
	}

	public void setControl(Object control) {
		this.control = control;

		if(item != null) {
			if(control instanceof Control) {
				item.setControl((Control)control);
			} else if(control instanceof AbstractPropertyEditor) {
				item.setControl(((AbstractPropertyEditor)control).getControl());
			}
		}
	}

	public Object getControl() {
		return control;
	}
}
