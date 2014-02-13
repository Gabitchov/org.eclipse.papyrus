/*
 * Copyright (c) 2013, 2014 CEA and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Vincent Lorenzo (CEA LIST) - Initial API and implementation
 *   Christian W. Damus (CEA) - bug 323802
 *
 */
package org.eclipse.papyrus.infra.gmfdiag.common.messages;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.infra.gmfdiag.common.messages.messages"; //$NON-NLS-1$

	public static String RollbackNotificationHistoryListener_exception;

	public static String RollbackNotificationHistoryListener_exceptionWithCause;

	public static String RollbackNotificationHistoryListener_readOnly;

	public static String RollbackNotificationHistoryListener_readOnlyWithCause;

	public static String RollbackNotificationHistoryListener_title;

	public static String RollbackNotificationHistoryListener_unknown;

	public static String RollbackNotificationHistoryListener_unknownWithCause;

	public static String UnitsUtils_Centimeters;

	public static String UnitsUtils_Inches;

	public static String UnitsUtils_Pixels;
	
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
