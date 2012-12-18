/*****************************************************************************
 * Copyright (c) 2011 LIFL & CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin (LIFL) cedric.dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.table.defaultt;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	/** The plug-in ID */
	public static final String ID = "org.eclipse.papyrus.uml.table.default"; //$NON-NLS-1$

	/** The shared instance */
	private static Activator plugin;

	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static Activator getInstance() {
		return plugin;
	}



	/**
	 * 
	 * @param error
	 */
	public void logError(String error) {
		logError(error, null);
	}

	/**
	 * @param error
	 *        the error
	 * @param throwable
	 *        actual error or null could be passed
	 * 
	 */
	public void logError(String error, Throwable throwable) {
		if(error == null && throwable != null) {
			error = throwable.getMessage();
		}
		getLog().log(new Status(IStatus.ERROR, Activator.ID, IStatus.OK, error, throwable));
		debug(error, throwable);
	}

	/**
	 * 
	 * @param message
	 */
	public void logInfo(String message) {
		logInfo(message, null);
	}

	/**
	 * @param message
	 *        the message
	 * @param throwable
	 *        actual error or null could be passed
	 * @generated
	 */
	public void logInfo(String message, Throwable throwable) {
		if(message == null && throwable != null) {
			message = throwable.getMessage();
		}
		getLog().log(new Status(IStatus.INFO, Activator.ID, IStatus.OK, message, throwable));
		debug(message, throwable);
	}

	/**
	 * 
	 * @param message
	 * @param throwable
	 */
	private void debug(String message, Throwable throwable) {
		if(!isDebugging()) {
			return;
		}
		if(message != null) {
			System.err.println(message);
		}
		if(throwable != null) {
			throwable.printStackTrace();
		}
	}

}
