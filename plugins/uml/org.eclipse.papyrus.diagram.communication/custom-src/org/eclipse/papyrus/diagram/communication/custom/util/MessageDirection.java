/*****************************************************************************
 * Copyright (c) 2010 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *  Saadia DHOUIB (CEA LIST) saadia.dhouib@cea.fr - adapted from sequence diagram
 *****************************************************************************/
package org.eclipse.papyrus.diagram.communication.custom.util;

/**
 * Enum for message direction (in or out)
 */
public enum MessageDirection {
	/**
	 * in direction
	 */
	IN("in"), /**
	 * out direction
	 */
	OUT("out"); //$NON-NLS-1$ //$NON-NLS-2$

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
