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
import org.eclipse.uml2.uml.Property;

// TODO: Auto-generated Javadoc
/**
 * The Class DetectRecursivity permits to detect if a property is typed by the same system in which it is contained
 */
public class DetectRecursivity extends AbstractModelConstraint {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.validation.AbstractModelConstraint#validate(org.eclipse.emf.validation.IValidationContext)
	 */
	@Override
	public IStatus validate(IValidationContext ctx) {
		Property subsystem = (Property)ctx.getTarget();
		//System.err.println("\n\n Type: "+subsystem.getType() +"\n Owner: "+ subsystem.getOwner());
		if(subsystem.getType() == null) {
			return ctx.createFailureStatus("Property (subsystem or attribute) must have a Type " + subsystem.getQualifiedName());
		} else if(subsystem.getType().equals(subsystem.getOwner())) {
			return ctx.createFailureStatus("Problem of recursivity the subsystem " + subsystem.getQualifiedName() + " is typed by the same system that contains it)");
		}
		// TODO Auto-generated method stub
		return ctx.createSuccessStatus();
	}

}
