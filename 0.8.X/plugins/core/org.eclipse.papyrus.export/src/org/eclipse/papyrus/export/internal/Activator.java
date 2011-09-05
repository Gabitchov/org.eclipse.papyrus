/*******************************************************************************
 * Copyright (c) 2005 Anyware Technologies
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Sciamma (Anyware Technologies) - initial API and implementation
 *******************************************************************************/

package org.eclipse.papyrus.export.internal;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipse.papyrus.export"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;

	/**
	 * The constructor
	 */
	public Activator() {
		plugin = this;
	}

	/**
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
	}

	/**
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	/**
	 * Log an IStatus
	 * 
	 * @param status
	 *        Status of an operation
	 */
	public static void log(IStatus status) {
		getDefault().getLog().log(status);
	}

	/**
	 * Log a message with given level into the Eclipse log file
	 * 
	 * @param message
	 *        the message to log
	 * @param level
	 *        the message priority
	 */
	public static void log(String message, int level) {
		IStatus status = null;
		status = new Status(level, PLUGIN_ID, IStatus.OK, message, null);
		log(status);
	}

	/**
	 * Log a message with given level into the Eclipse log file
	 * 
	 * @param message
	 *        the message to log
	 * @param level
	 *        the message priority
	 */
	public static void log(String message, int level, Throwable t) {
		IStatus status = null;
		status = new Status(level, PLUGIN_ID, IStatus.OK, message, t);
		log(status);
	}

	/**
	 * Log an exception into the Eclipse log file
	 * 
	 * @param e
	 *        the exception to log
	 */
	public static void log(Throwable e) {
		Throwable loggedThrowable = e;
		if(loggedThrowable instanceof InvocationTargetException) {
			loggedThrowable = ((InvocationTargetException)loggedThrowable).getTargetException();
		}

		IStatus status = null;
		if(loggedThrowable instanceof CoreException) {
			status = ((CoreException)loggedThrowable).getStatus();
		} else {
			status = new Status(IStatus.ERROR, PLUGIN_ID, IStatus.OK, "Error", loggedThrowable);
		}
		log(status);
	}

	/**
	 * Returns the active workbench shell
	 * 
	 * @return the active workbench shell
	 */
	public static Shell getActiveWorkbenchShell() {
		IWorkbenchWindow workBenchWindow = getActiveWorkbenchWindow();
		if(workBenchWindow == null) {
			return null;
		}
		return workBenchWindow.getShell();
	}

	/**
	 * Returns the active workbench page or <code>null</code> if none.
	 * 
	 * @return the active workbench page
	 */
	public static IWorkbenchPage getActivePage() {
		IWorkbenchWindow window = getActiveWorkbenchWindow();
		if(window != null) {
			return window.getActivePage();
		}
		return null;
	}

	/**
	 * Returns the active workbench window
	 * 
	 * @return the active workbench window
	 */
	public static IWorkbenchWindow getActiveWorkbenchWindow() {
		if(getDefault() == null) {
			return null;
		}
		IWorkbench workBench = getDefault().getWorkbench();
		if(workBench == null) {
			return null;
		}
		return workBench.getActiveWorkbenchWindow();
	}

	/**
	 * Display a dialog box with the specified level
	 * 
	 * @param title
	 *        title dialog box
	 * @param message
	 *        message displayed
	 * @param level
	 *        message level
	 */
	public static void displayDialog(final String title, final String message, final int level) {
		if(level == IStatus.INFO) {
			Display.getDefault().asyncExec(new Runnable() {

				public void run() {
					MessageDialog.openInformation(getActiveWorkbenchShell(), (title == null) ? "Information" : title, (message == null) ? "" : message);
				}
			});
		} else if(level == IStatus.WARNING) {
			Display.getDefault().asyncExec(new Runnable() {

				public void run() {
					MessageDialog.openWarning(getActiveWorkbenchShell(), (title == null) ? "Warning" : title, (message == null) ? "" : message);
				}
			});
		} else if(level == IStatus.ERROR) {
			Display.getDefault().asyncExec(new Runnable() {

				public void run() {
					MessageDialog.openError(getActiveWorkbenchShell(), (title == null) ? "Error" : title, (message == null) ? "" : message);
				}
			});
		}
	}
}
