/*****************************************************************************
 * Copyright (c) 2009 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.util;

/**
 * Enum for message direction (in or out)
 */
public enum MessageDirection {

	IN("in"), OUT("out");

	private String name;

	private MessageDirection(String name) {
		this.name = name;
	}

	/**
	 * Return the name of message direction
	 * 
	 * @return The name
	 */
	public String getName() {
		return name;
	}
}
