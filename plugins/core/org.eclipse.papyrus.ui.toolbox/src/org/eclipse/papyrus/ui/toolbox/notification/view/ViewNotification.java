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
package org.eclipse.papyrus.ui.toolbox.notification.view;

import org.eclipse.papyrus.ui.toolbox.notification.INotification;

/**
 * The INotification corresponding to the view builder
 * 
 * @author tfaure
 * 
 */
public class ViewNotification implements INotification {

	private final AbstractInsideComposite viewCompo;

	public ViewNotification(AbstractInsideComposite viewCompo) {
		this.viewCompo = viewCompo;
	}

	public void delete() {
		viewCompo.close();
	}

	/**
	 * 
	 * whether the current notification is deleted
	 * 
	 * @see org.eclipse.papyrus.ui.toolbox.notification.INotification#isDeleted()
	 * @return true if notification is deleted
	 */
	public boolean isDeleted() {
		return viewCompo.isDisposed();
	}
}
