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
 *   Atos - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity.helper.datastructure;

import org.eclipse.uml2.uml.CallAction;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Pin;
import org.eclipse.uml2.uml.TypedElement;

/**
 * Data structure to store link between a Pin and a Parameter in an {@link CallAction}.
 * UML do not provide this link. This link is define by constraints. In MDT Papyrus we have decided to save this link in order to be able to
 * synchronized call Action and their Structural Behaviors.
 * 
 * @author arthur daussy
 * 
 */
public class LinkPinToParameter implements ILinkPinToTarget {

	/**
	 * When error occur
	 */
	public static LinkPinToParameter NO_LINK_AVAILABLE = new LinkPinToParameter(null, null);

	/**
	 * {@link Pin}
	 */
	private Pin pin;

	/**
	 * {@link Parameter} which is referenced by the pin of the {@link CallAction}
	 */
	private TypedElement parameter;

	public LinkPinToParameter() {
	}

	/**
	 * Constructor
	 * 
	 * @param pin
	 *        {@link Pin}
	 * @param parameter
	 *        {@link Parameter} which is referenced by the pin of the {@link CallAction} element
	 */
	public LinkPinToParameter(Pin pin, TypedElement parameter) {
		super();
		this.pin = pin;
		this.parameter = parameter;
	}

	public Pin getPin() {
		return pin;
	}

	public void setPin(Pin pin) {
		this.pin = pin;
	}

	public TypedElement getParameter() {
		return parameter;
	}

	public void setParameter(TypedElement parameter) {
		this.parameter = parameter;
	}

	public Element getTarget() {
		return parameter;
	}
}
