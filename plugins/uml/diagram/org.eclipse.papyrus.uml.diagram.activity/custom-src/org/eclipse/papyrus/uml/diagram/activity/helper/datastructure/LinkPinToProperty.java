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

import org.eclipse.core.runtime.Assert;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Pin;
import org.eclipse.uml2.uml.Property;

/**
 * Link a pin a to a property
 * 
 * @author arthur daussy
 */
public class LinkPinToProperty implements ILinkPinToTarget {

	private Pin pin;

	private Property property;

	public LinkPinToProperty(Pin pin, Property property) {
		super();
		Assert.isNotNull(pin);
		this.pin = pin;
		Assert.isNotNull(property);
		this.property = property;
	}

	public Pin getPin() {
		return pin;
	}

	public Element getTarget() {
		return property;
	}
}
