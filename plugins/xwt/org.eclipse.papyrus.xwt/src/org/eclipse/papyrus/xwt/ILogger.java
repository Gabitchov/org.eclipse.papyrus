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
package org.eclipse.papyrus.xwt;

import java.util.Set;

/**
 * Looger interface
 * 
 * @author yyang
 */
public interface ILogger {

	void error(Throwable e);

	void error(Throwable e, String message);

	void warning(String message);

	void message(String message);

	// print messages into console view
	void printInfo(String message, Tracking tracking, Set<Tracking> trackType);

	// add messages
	void addMessage(String message, Tracking tracking);

	void removeMessage(Tracking tracking);
}
