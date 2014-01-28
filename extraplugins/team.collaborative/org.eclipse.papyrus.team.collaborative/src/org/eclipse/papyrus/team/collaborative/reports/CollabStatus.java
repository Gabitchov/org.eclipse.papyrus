/*******************************************************************************
 * Copyright (c) 2013 Atos
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Arthur Daussy - initial implementation
 *******************************************************************************/
package org.eclipse.papyrus.team.collaborative.reports;

import org.eclipse.core.runtime.Status;

/**
 * The Class CollabStatus.
 */
public class CollabStatus extends Status {

	/**
	 * Instantiates a new collab status.
	 * 
	 * @param severity
	 *        the severity
	 * @param pluginId
	 *        the plugin id
	 * @param code
	 *        the code
	 * @param message
	 *        the message
	 * @param exception
	 *        the exception
	 */
	public CollabStatus(int severity, String pluginId, int code, String message, Throwable exception) {
		super(severity, pluginId, code, message, exception);
	}

	/**
	 * Instantiates a new collab status.
	 * 
	 * @param severity
	 *        the severity
	 * @param pluginId
	 *        the plugin id
	 * @param message
	 *        the message
	 * @param exception
	 *        the exception
	 */
	public CollabStatus(int severity, String pluginId, String message, Throwable exception) {
		super(severity, pluginId, message, exception);
	}

	/**
	 * Instantiates a new collab status.
	 * 
	 * @param severity
	 *        the severity
	 * @param pluginId
	 *        the plugin id
	 * @param message
	 *        the message
	 */
	public CollabStatus(int severity, String pluginId, String message) {
		super(severity, pluginId, message);
	}

	/**
	 * Creates the error status.
	 * 
	 * @param message
	 *        the message
	 * @return the collab status
	 */
	public static CollabStatus createErrorStatus(String message) {
		return new CollabStatus(ERROR, org.eclipse.papyrus.team.collaborative.Activator.PLUGIN_ID, message);
	}

	/**
	 * Creates the error status.
	 * 
	 * @param message
	 *        the message
	 * @param e
	 *        the e
	 * @return the collab status
	 */
	public static CollabStatus createErrorStatus(String message, Throwable e) {
		return new CollabStatus(ERROR, org.eclipse.papyrus.team.collaborative.Activator.PLUGIN_ID, message, e);
	}



}
