/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.uml.diagram.clazz.custom.policies;

import java.util.List;

import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Property;

/**
 * this a listener to refresh the target role of the instance specification
 * 
 */
public class ISRoleTargetDisplayEditPolicy extends InstanceSpecificationRoleDisplayEditPolicy {

	@Override
	public InstanceSpecification getEnd() {
		return (InstanceSpecification) ((GraphicalEditPart) ((ConnectionEditPart) getHost().getParent()).getSource()).resolveSemanticElement();
	}

	@Override
	protected Property getprefvalue(List<Property> array) {
		return array.get(1);
	}
}
