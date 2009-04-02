/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.common.editparts;

import org.eclipse.uml2.uml.Element;

/**
 * this uml edit part can give the UML Element associated to this editpart
 * 
 */
public interface IUMLEditPart {

	/**
	 * Gets the UML element.
	 * 
	 * @return the UML element
	 */
	public Element getUMLElement();

}
