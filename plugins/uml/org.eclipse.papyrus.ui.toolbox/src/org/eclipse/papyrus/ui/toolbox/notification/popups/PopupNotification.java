/*****************************************************************************
 * Copyright (c) 2010 ATOS ORIGIN.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan Faure (ATOS ORIGIN INTEGRATION) tristan.faure@atosorigin.com - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.ui.toolbox.notification.popups;

import org.eclipse.papyrus.ui.toolbox.notification.INotification;
import org.eclipse.papyrus.ui.toolbox.notification.dialogs.PapyrusPopup;
import org.eclipse.swt.SWT;

/**
 * The INotification corresponding to the popup builder
 * 
 * @author tfaure
 * 
 */
public class PopupNotification implements INotification {

	private final PapyrusPopup popup;

	private int popupResult = SWT.NONE;

	public PopupNotification(PapyrusPopup popup) {
		this.popup = popup;
	}

	public void delete() {
		// no effect
	}

	/**
	 * Whether the popup has been closed
	 * 
	 * @see org.eclipse.papyrus.ui.toolbox.notification.INotification#isDeleted()
	 * 
	 * @return true
	 */
	public boolean isDeleted() {
		// the object is created once the popup is closed
		return true;
	}

	public void setResult(int popupResult) {
		this.popupResult = popupResult;
	}

	/**
	 * Returns the result of the popup
	 * 
	 * @return
	 */
	public int getResult() {
		return popupResult;
	}

}
