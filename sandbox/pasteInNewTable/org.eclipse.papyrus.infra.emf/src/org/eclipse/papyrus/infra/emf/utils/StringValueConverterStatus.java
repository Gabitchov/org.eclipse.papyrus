/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.utils;

import java.util.Collection;

import org.eclipse.core.runtime.Status;

/**
 * This status is used y the String Value solvers
 * 
 * @author vl222926
 * 
 */
public class StringValueConverterStatus extends Status {

	/**
	 * the list of the uresolved strings
	 */
	private Collection<String> unresolvedString;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param severity
	 *        the severity of the status
	 * @param pluginId
	 *        the plugin id providing this status
	 * @param message
	 *        the message for this status
	 * @param unresolvedString
	 *        the list of the unresolved string
	 */
	public StringValueConverterStatus(int severity, String pluginId, String message, Collection<String> unresolvedString) {
		super(severity, pluginId, message);
		this.unresolvedString = unresolvedString;
	}


	/**
	 * 
	 * @return
	 *         the list of the unresolved string
	 */
	public final Collection<String> getUnresolvedString() {
		return unresolvedString;
	}
}
