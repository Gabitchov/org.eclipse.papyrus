/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
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

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.ExpandBar;

public class ExpandItem extends org.eclipse.swt.widgets.ExpandItem {

	public ExpandItem(ExpandBar parent, int style) {
		super(parent, style);
	}

	public ExpandItem(ExpandBar parent, int style, int index) {
		super(parent, style, index);
	}

	@Override
	public void setControl(Control control) {
		super.setControl(control);
		setHeight(control.computeSize(SWT.DEFAULT, SWT.DEFAULT).y);
		getParent().layout();
		setExpanded(true);
	}
}
