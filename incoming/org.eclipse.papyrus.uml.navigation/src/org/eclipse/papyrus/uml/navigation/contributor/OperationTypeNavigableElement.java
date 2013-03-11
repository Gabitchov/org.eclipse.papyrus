/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.navigation.contributor;

import org.eclipse.uml2.uml.Operation;

/**
 * Navigates from an Operation to it's return type declaration
 * 
 * @author CL228098
 * 
 */
public class OperationTypeNavigableElement extends TypedNavigableElement {

	public OperationTypeNavigableElement(Operation operation) {
		super(operation.getType());
	}

	@Override
	public String getLabel() {
		return "Go to return Type" + getTypeLabel();
	}

	@Override
	public String getDescription() {
		return "Go to the return type declaration of this Operation" + getTypeLabel();
	}
}
