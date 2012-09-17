/*******************************************************************************
 * Copyright (c) 2009 Atos Origin.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Atos Origin - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.infra.core.log;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;

/**
 * A Log Helper.
 * 
 * @author tszadel
 * 
 */
public class LogHelper {

	/** The plugin Id. */
	private String pluginId;

	/** The plugin related to that helper. */
	private Plugin activator;

	
	
	/**
	 * Default Constructor.
	 * The associated plugin can be set later.
	 * If no plugin is set, use java log.
	 */
	public LogHelper() {
	}
	
	/**
	 * Constructor.
	 * 
	 * @param activator
	 *        The activator.
	 */
	public LogHelper(Plugin activator) {
		setPlugin(activator);
	}

	/**
	 * Set the associated plugin.
	 * This plugin log will be used as log.
	 * @param activator
	 */
	public void setPlugin( Plugin activator ) {
		this.pluginId = activator.getBundle().getSymbolicName();
		this.activator = activator;		
	}
	
	/**
	 * Log an informative message into the Eclipse log file
	 * 
	 * @param message
	 *        the message to log
	 */
	public void info(String message) {
		log(message, IStatus.INFO);
	}

	/**
	 * Log a debug message into the Eclipse log file
	 * 
	 * @param message
	 *        the message to log
	 */
	public void debug(String message) {
		if(isDebugEnabled()) {
			log("[DEBUG] " + message, IStatus.INFO);
		}
	}

	/**
	 * Test if the platform is in debug mode.
	 * 
	 * @return True if the platform is in debug mode.
	 */
	public boolean isDebugEnabled() {
		if( activator != null)
		  return Platform.inDebugMode();
		
		return false;
	}

	/**
	 * Log a message with given level into the Eclipse log file
	 * 
	 * @param message
	 *        the message to log
	 * @param level
	 *        the message priority
	 */
	private void log(String message, int level) {
		log( new Status(level, pluginId, message ));
	}

	/**
	 * 
	 * @param status
	 */
	private void log( IStatus status ) {
		
		if( activator == null) {
			// TODO Do log with java ?
		}
		else {
			activator.getLog().log(status );
		}
	}
	
	/**
	 * Log a warning message.
	 * 
	 * @param e
	 *        the exception to log
	 */
	public void warn(String message) {
		log(message, IStatus.WARNING);
	}


	/**
	 * Log an exception into the Eclipse log file
	 * 
	 * @param e
	 *        the exception to log
	 */
	public void error(Throwable e) {
		error("Unexpected Error", e);
	}

	/**
	 * Log an exception into the Eclipse log file
	 * 
	 * @param message
	 *        the message
	 * @param e
	 *        the exception to log
	 */
	public void error(String message, Throwable e) {

		Throwable t = e;
		if(e instanceof InvocationTargetException) {
			t = ((InvocationTargetException)e).getTargetException();
		}

		IStatus status;
		if(t instanceof CoreException) {
			status = ((CoreException)t).getStatus();
		} else {
			status = new Status(IStatus.ERROR, pluginId, message, e);
		}

		log(status);
	}
}
