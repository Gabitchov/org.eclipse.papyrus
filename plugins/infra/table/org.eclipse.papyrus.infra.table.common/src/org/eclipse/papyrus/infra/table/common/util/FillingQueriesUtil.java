/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
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
package org.eclipse.papyrus.infra.table.common.util;

import org.eclipse.emf.common.notify.Notification;

public class FillingQueriesUtil {

	/**
	 * The constructor for this class
	 */
	private FillingQueriesUtil(){
		//nothing to do
	}
	/** the value for the event which opens the table*/
	public static final int OPEN_TABLE = Notification.EVENT_TYPE_COUNT + 1;
	
}
