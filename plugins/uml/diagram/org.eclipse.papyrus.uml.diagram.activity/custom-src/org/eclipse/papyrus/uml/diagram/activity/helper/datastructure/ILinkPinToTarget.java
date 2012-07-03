/*****************************************************************************
 * Copyright (c) 2011 Atos.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Arthur Daussy (Atos) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity.helper.datastructure;

import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Pin;

/**
 * Representation of a link between a pin and a element which it represent (parameter)
 * 
 * @author adaussy
 * 
 */
public interface ILinkPinToTarget {

	/**
	 * Return the {@link Pin} object
	 * 
	 * @return
	 */
	public Pin getPin();

	/**
	 * Return the element pointed by the link
	 * 
	 * @return
	 */
	public Element getTarget();
}
