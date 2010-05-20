/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan Faure (ATOS ORIGIN INTEGRATION) tristan.faure@atosorigin.com - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.ui.toolbox.notification;

import org.eclipse.papyrus.ui.toolbox.notification.builders.IContext;

/**
 * a runnable
 * 
 */
public interface NotificationRunnable {

	/**
	 * Run the runnable
	 * 
	 * @param context
	 *        , used to fill properties, can contain data
	 */
	void run(IContext context);

	/**
	 * The label of the runnable
	 * 
	 * @return the label
	 */
	String getLabel();
}
