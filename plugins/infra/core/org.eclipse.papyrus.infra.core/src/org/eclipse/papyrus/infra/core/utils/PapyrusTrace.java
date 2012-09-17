/*******************************************************************************
 * Copyright (c) 2008 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.infra.core.utils;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.papyrus.infra.core.Activator;

/**
 * Utility class to log errors or debug information either in the plugin'log or
 * in the console.
 * <p>
 * A set of channels is used to separate different traces for different aspects. A short list is displayed at the end of the file to give an example of channels
 * 
 * @deprecated Use {@link LogHelper} instead
 **/
@Deprecated
public class PapyrusTrace implements IDebugChannel {

	public static final String PAPYRUS_CORE = "org.eclipse.papyrus.infra.core/debug";

	/**
	 * Display a debug trace.
	 * 
	 * @param element
	 *        that provides the trace
	 * @param text
	 *        message to display
	 * @param traceOption
	 *        channel of the trace (see {@link IDebugChannel})
	 */
	public static void trace(String traceOption, Object element, String text) {
		if(!Platform.inDebugMode()) {
			return;
		}
		String globalTraceValue = Platform.getDebugOption(PAPYRUS_CORE);
		String value = Platform.getDebugOption(traceOption);
		if(null != globalTraceValue && globalTraceValue.equals("true") && null != value && value.equals("true")) {
			if(element != null) {
				log(IStatus.INFO, "[" + traceOption + "]: " + element.getClass() + " --> " + text);
			} else {
				log(IStatus.INFO, "[" + traceOption + "] --> " + text);
			}
		}
	}

	/**
	 * display error.
	 * 
	 * @param element
	 *        that provides the trace
	 * @param text
	 *        to display
	 * @param traceOption
	 *        channel of the trace
	 */
	public static void error(String traceOption, Object element, String text) {
		if(!Platform.inDebugMode()) {
			return;
		}
		String globalTraceValue = Platform.getDebugOption(PAPYRUS_CORE);
		String value = Platform.getDebugOption(traceOption);
		if(null != globalTraceValue && globalTraceValue.equals("true") && null != value && value.equals("true")) {
			if(element != null) {
				log(IStatus.ERROR, "[" + traceOption + "]: " + element.getClass() + " --> " + text);
			} else {
				log(IStatus.ERROR, "[" + traceOption + "] --> " + text);
			}
		}
	}

	/**
	 * Log an exception into the plugin log.
	 * 
	 * @param exception
	 *        the exception to log.
	 * @param e
	 *        the message to log
	 */
	public static void log(Exception e) {
		final IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, IStatus.OK, e.getMessage(), e);
		Activator.getDefault().getLog().log(status);
	}

	/**
	 * Log a message into the plugin log.
	 * 
	 * @param message
	 *        the message to log
	 * @param severity
	 *        the severity : one of <code>OK</code>, <code>ERROR</code>, <code>INFO</code>, <code>WARNING</code>, or <code>CANCEL</code>
	 */
	public static void log(int severity, String message) {
		final IStatus status = new Status(severity, Activator.PLUGIN_ID, IStatus.OK, message, null);
		Activator.getDefault().getLog().log(status);
	}
}
