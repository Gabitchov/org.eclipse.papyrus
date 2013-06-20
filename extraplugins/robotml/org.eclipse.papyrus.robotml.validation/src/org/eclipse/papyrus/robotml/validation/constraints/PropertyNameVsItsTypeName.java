/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Saadia Dhouib (CEA LIST) saadia.dhouib@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.robotml.validation.constraints;



import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;

public class PropertyNameVsItsTypeName extends AbstractModelConstraint {

	@Override
	public IStatus validate(IValidationContext ctx) {
		Property subsystem = (Property)ctx.getTarget();
		//System.err.println("\n\n Type: "+subsystem.getType() +"\n Owner: "+ subsystem.getOwner());

		//1. verify that a property has a type
		if(subsystem.getType() == null) {
			return ctx.createFailureStatus("Property (subsystem or attribute) should have a Type" + subsystem.getQualifiedName());
		}

		//2. verify that a property has a name different from ""
		String typeName = ((NamedElement)subsystem.getType()).getName();

		if(subsystem.getName().replaceAll(" ", "").compareToIgnoreCase("") == 0) {
			if(subsystem instanceof Port) {
				return ctx.createFailureStatus("Port  should have a name ");
			} else
				return ctx.createFailureStatus("Property (subsystem or attribute) should have a name " + subsystem.getQualifiedName());
		} else
		//3. verify that a property has a name different from its type name
		if(subsystem.getName().compareToIgnoreCase(typeName) == 0) {
			if(subsystem instanceof Port) {
				return ctx.createFailureStatus("Port  should have a name diffrent from its Type name" + subsystem.getQualifiedName());
			} else
				return ctx.createFailureStatus("Property (subsystem or attribute) should have a name diffrent from its Type name " + subsystem.getQualifiedName());
		}





		return ctx.createSuccessStatus();
	}



}
