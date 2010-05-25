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
package org.eclipse.papyrus.ui.toolbox.notification.dialogs;

import org.eclipse.papyrus.ui.toolbox.notification.INotification;

/**
 * The INotification corresponding to the async builder
 * 
 * @author tfaure
 * 
 */
public class AsyncNotification implements INotification {

	private final PapyrusAsyncNotificationPopup popup;

	public AsyncNotification(PapyrusAsyncNotificationPopup popup) {
		this.popup = popup;
	}

	public void delete() {
		// no effect
	}

}
