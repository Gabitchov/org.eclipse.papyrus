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
package org.eclipse.papyrus.team.collaborative.core.reports;

import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.papyrus.team.collaborative.core.Activator;


/**
 * The Class LogHelper.
 * This class intend to help the user to log stuff
 */
public class LogHelper {

	/**
	 * The Class SingletonHolder.
	 */
	private static class SingletonHolder {

		/** The Constant INSTANCE. */
		private static final LogHelper INSTANCE = new LogHelper();
	}

	/**
	 * Gets the single instance of LogHelper.
	 * 
	 * @return single instance of LogHelper
	 */
	public static LogHelper getInstance() {
		return SingletonHolder.INSTANCE;
	}

	/**
	 * Log info.
	 * 
	 * @param message
	 *        the message
	 * @param bundleId
	 *        the bundle id
	 */
	public void logInfo(String message, String bundleId) {
		getLogger().log(createWarningStatus(bundleId, message));
	}

	/**
	 * Creates the warning status.
	 * 
	 * @param bundleId
	 *        the bundle id
	 * @param message
	 *        the message
	 * @return the i status
	 */
	protected IStatus createWarningStatus(String bundleId, String message) {
		return createStatus(Status.WARNING, bundleId, message);
	}

	/**
	 * Log error.
	 * 
	 * @param message
	 *        the message
	 * @param bundleId
	 *        the bundle id
	 * @param e
	 *        the e
	 */
	public void logError(String message, String bundleId, Throwable e) {
		getLogger().log(createErrorStatus(bundleId, message, e));
	}

	/**
	 * Log error.
	 * 
	 * @param message
	 *        the message
	 * @param bundleId
	 *        the bundle id
	 */
	public void logError(String message, String bundleId) {
		getLogger().log(createErrorStatus(bundleId, message));
	}

	/**
	 * Gets the logger.
	 * 
	 * @return the logger
	 */
	protected ILog getLogger() {
		return Activator.getDefault().getLog();
	}

	/**
	 * Creates the error status.
	 * 
	 * @param pluginId
	 *        the plugin id
	 * @param message
	 *        the message
	 * @return the i status
	 */
	protected IStatus createErrorStatus(String pluginId, String message) {
		return createStatus(Status.ERROR, pluginId, message);
	}

	/**
	 * Creates the error status.
	 * 
	 * @param pluginId
	 *        the plugin id
	 * @param message
	 *        the message
	 * @param e
	 *        the e
	 * @return the i status
	 */
	protected IStatus createErrorStatus(String pluginId, String message, Throwable e) {
		return createStatus(Status.ERROR, pluginId, message, e);
	}

	/**
	 * Creates the status.
	 * 
	 * @param severity
	 *        the severity
	 * @param pluginId
	 *        the plugin id
	 * @param message
	 *        the message
	 * @param e
	 *        the e
	 * @return the i status
	 */
	protected IStatus createStatus(int severity, String pluginId, String message, Throwable e) {
		return new Status(severity, pluginId, message, e);
	}

	/**
	 * Creates the status.
	 * 
	 * @param severity
	 *        the severity
	 * @param pluginId
	 *        the plugin id
	 * @param message
	 *        the message
	 * @return the i status
	 */
	protected IStatus createStatus(int severity, String pluginId, String message) {
		return new Status(severity, pluginId, message);
	}
}
