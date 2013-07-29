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
package org.eclipse.papyrus.uml.diagram.common.editparts;

import org.eclipse.uml2.uml.Element;

/**
 * this uml edit part can give the UML Element associated to this editpart
 * 
 */
public interface IUMLEditPart {

	/**
	 * Constant for filters of the {@link DiagramEventBroker} that listen to
	 * stereotype application/unapplication
	 */
	public final String STEREOTYPED_ELEMENT = "StereotypedElement";

	/**
	 * Constant for filters of the {@link DiagramEventBroker} that listen to
	 * applied stereotype modifications (property changes, etc.)
	 */
	public final String STEREOTYPABLE_ELEMENT = "StereotypableElement";

	/**
	 * Gets the UML element.
	 * 
	 * @return the UML element
	 */
	public Element getUMLElement();

}
