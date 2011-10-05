/*****************************************************************************
 * Copyright (c) 2010 LIFL & CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin (LIFL) cedric.dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.core.ui.pagebookview;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.Page;


/**
 * A default page to show when the active part can't be rendered by {@link MultiViewPageBookView}.
 * @author cedric dumoulin
 *
 */
public class DefaultPage extends Page {

	/**
	 * The default ui
	 */
	private Text text;
	/**
	 * @see org.eclipse.ui.part.Page#createControl(org.eclipse.swt.widgets.Composite)
	 *
	 * @param parent
	 */
	@Override
	public void createControl(Composite parent) {
		text = new Text(parent, SWT.CENTER);

		text.setMessage("No Model Available");
	}

	/**
	 * @see org.eclipse.ui.part.Page#getControl()
	 *
	 * @return
	 */
	@Override
	public Control getControl() {
		return text;
	}

	/**
	 * @see org.eclipse.ui.part.Page#setFocus()
	 *
	 */
	@Override
	public void setFocus() {

	}

}
