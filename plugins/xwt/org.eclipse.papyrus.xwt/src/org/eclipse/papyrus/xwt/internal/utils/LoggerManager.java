/*******************************************************************************
 * Copyright (c) 2006, 2010 Soyatec (http://www.soyatec.com) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Soyatec - initial API and implementation
 *******************************************************************************/

package org.eclipse.papyrus.xwt.internal.utils;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Logger Manager.
 * 
 * @author jliu
 */
public class LoggerManager {

	private static Logger logger = Logger.getLogger("org.eclipse.papyrus.xwt.utils.LoggerManager");

	private LoggerManager() {
	}

	public static void log(Throwable e, String message) {
		logger.log(Level.SEVERE, message, e);
	}

	public static void log(Throwable e) {
		log(e, null);
	}

	public static void log(String message) {
		log(null, message);
	}
}
