/*******************************************************************************
 * Copyright (c) 2013 Atos.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Arthur Daussy <a href="mailto:arthur.daussy@atos.net"> - initial API and implementation
 ******************************************************************************/
package org.eclipse.papyrus.team.collaborative.connector.svn.tracing;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.papyrus.team.collaborative.connector.svn.Activator;

/**
 * Utils class used to trace element
 * 
 * @author adaussy
 * 
 */
public final class Tracer {

	private Tracer() {
	}

	/**
	 * Return true if the plugin is debugging
	 * 
	 * @return
	 */
	public static boolean isDebuging() {
		return Activator.getDefault().isDebugging();
	}

	/**
	 * Log info if the plugin is tracing
	 * 
	 * @param info
	 *        Info you want to log
	 * @param raisedException
	 *        if true the the trace raise an exception
	 */
	public static void logInfo(String info, boolean raisedException) {
		log(Status.OK, info, raisedException);
	}

	/**
	 * Log an info
	 * 
	 * @param info
	 *        Info you want to log
	 */
	public static void logInfo(String info) {
		logInfo(info, false);
	}

	//	/**
	//	 * Log an error
	//	 * @param error Message you want to log
	//	 * @param raisedException if true the the trace raise an exception
	//	 */
	//	public static void logError(String error, boolean raisedException) {
	//		log(Status.ERROR, error, raisedException);
	//	}

	/**
	 * Log something
	 * 
	 * @param severity
	 *        Severity of what is going to be logged see {@link IStatus} constants
	 * @param message
	 *        Message to log
	 * @param raisedException
	 *        if true raise an exception
	 */
	public static void log(int severity, String message, boolean raisedException) {
		if(Activator.getDefault() != null) {
			if(raisedException) {
				Activator.getDefault().getLog().log(new Status(severity, Activator.PLUGIN_ID, message, new Exception()));
			} else {
				Activator.getDefault().getLog().log(new Status(severity, Activator.PLUGIN_ID, message));
			}
		}
	}

	//	/**
	//	 * Log an error
	//	 * @param message Message you want to log
	//	 * @param raisedException the exception to raise
	//	 */
	//	public static void logExceptionError(String message, Exception raisedException) {
	//		Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, message, raisedException));
	//	}

	/**
	 * Log warning
	 * 
	 * @param message
	 *        Message you want to log
	 * @param raisedException
	 *        the exception to raise
	 */
	public static void logExceptionWarning(String message, Exception raisedException) {
		Activator.getDefault().getLog().log(new Status(IStatus.WARNING, Activator.PLUGIN_ID, message, raisedException));
	}
}
