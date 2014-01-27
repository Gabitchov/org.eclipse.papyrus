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
package org.eclipse.papyrus.team.collaborative.connector.svn.tracing;

import org.eclipse.core.runtime.Platform;
import org.eclipse.papyrus.team.collaborative.connector.svn.Activator;

/**
 * Constant use to trace.
 * 
 * @author adaussy
 */
public interface ITracingConstant {

	/** Trace everything related to commmit. */
	public static final boolean COMMIT_TRACING = Activator.getDefault().isDebugging() && "true".equalsIgnoreCase(Platform.getDebugOption("org.eclipse.papyrus.team.collaborative.connector.svn/debug/commit"));

	/** Trace everything related to lock. */
	public static final boolean LOCK_TRACING = Activator.getDefault().isDebugging() && "true".equalsIgnoreCase(Platform.getDebugOption("org.eclipse.papyrus.team.collaborative.connector.svn/debug/lock"));

	/** Trace everything related to unlock. */
	public static final boolean UNLOCK_TRACING = Activator.getDefault().isDebugging() && "true".equalsIgnoreCase(Platform.getDebugOption("org.eclipse.papyrus.team.collaborative.connector.svn/debug/unlock"));

	/** Trace everything related to Update. */
	public static final boolean UPDATE_TRACING = Activator.getDefault().isDebugging() && "true".equalsIgnoreCase(Platform.getDebugOption("org.eclipse.papyrus.team.collaborative.connector.svn/debug/update"));

	/** Trace everything related to Revert. */
	public static final boolean REVERT_TRACING = Activator.getDefault().isDebugging() && "true".equalsIgnoreCase(Platform.getDebugOption("org.eclipse.papyrus.team.collaborative.connector.svn/debug/revert"));


}
