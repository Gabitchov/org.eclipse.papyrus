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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.papyrus.RobotML.RobotMLPackage;
import org.eclipse.papyrus.infra.core.resource.NotFoundException;
import org.eclipse.papyrus.uml.tools.model.UmlModel;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.util.UMLUtil;

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

	public IStatus validate(IValidationContext ctx) {
		
		Property subsystem = (Property)ctx.getTarget();
		
		if (ConstraintsUtil.verifyRobotMLApplied(subsystem)){
		//System.err.println("\n\n Type: "+subsystem.getType() +"\n Owner: "+ subsystem.getOwner());
		if(subsystem.getType() == null) {
			return ctx.createFailureStatus("Property (subsystem or attribute) must have a Type " + subsystem.getQualifiedName());
		} else if(subsystem.getType().equals(subsystem.getOwner())) {
			return ctx.createFailureStatus("Problem of recursivity the subsystem " + subsystem.getQualifiedName() + " is typed by the same system that contains it)");
		}
		}
	
		return ctx.createSuccessStatus();
	}
	
	
	
	
}
