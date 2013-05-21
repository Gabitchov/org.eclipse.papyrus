/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.widgets.editors;

import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Shell;

/**
 * The developper can define the location of this input dialog
 * 
 * @author vl222926
 * 
 */
public class InputDialogWithLocation extends InputDialog {

	/**
	 * the location wanted to display the dialog
	 */
	private Point location;

	/**
	 * 
	 * Constructor.
	 * 
	 * @see InputDialog#InputDialog(Shell, String, String, String, IInputValidator)
	 * @param parentShell
	 * @param title
	 * @param label
	 * @param initialValue
	 * @param validator
	 * @param dialogLocation
	 *        the location to use for the dialog
	 */
	public InputDialogWithLocation(Shell parentShell, String title, String label, String initialValue, IInputValidator validator, final Point dialogLocation) {
		super(parentShell, title, label, initialValue, validator);
		this.location = dialogLocation;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.widgets.editors.InputDialog#create()
	 * 
	 */
	@Override
	public void create() {
		super.create();
		//adapted code from AbstractStyleEditorDialog in nattable plugin
		if(location != null) {
			if(location.x < getParentShell().getDisplay().getBounds().x) {
				location.x = getParentShell().getDisplay().getBounds().x;
			} else if(location.x + getShell().getBounds().width > getParentShell().getDisplay().getBounds().x + getParentShell().getDisplay().getBounds().width) {
				location.x = getParentShell().getDisplay().getBounds().x + getParentShell().getDisplay().getBounds().width - getShell().getBounds().width;
			}
			if(location.y + getShell().getBounds().height > getParentShell().getDisplay().getBounds().y + getParentShell().getDisplay().getBounds().height) {
				location.y = getParentShell().getDisplay().getBounds().y + getParentShell().getDisplay().getBounds().height - getShell().getBounds().height;
			}
		}
		getShell().setLocation(location);
	}
}
