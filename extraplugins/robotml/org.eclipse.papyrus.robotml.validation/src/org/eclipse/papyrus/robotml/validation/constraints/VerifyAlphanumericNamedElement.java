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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Property;

public class VerifyAlphanumericNamedElement extends AbstractModelConstraint {

	public static Pattern ALPHANUMERIC = Pattern.compile("[A-Za-z][A-Za-z0-9_]*");

	public boolean checkAlphaNumeric(String s) {
		if(s == null) {
			return false;
		} else {
			Matcher m = ALPHANUMERIC.matcher(s);
			return m.matches();
		}
	}

	@Override
	public IStatus validate(IValidationContext ctx) {
		// TODO Auto-generated method stub
		NamedElement element = (NamedElement)ctx.getTarget();
		 	if (ConstraintsUtil.verifyRobotMLApplied(element)){
		//4. verify that a property has an alphanumeric name that can also contain underscore
		if(((element instanceof Classifier) || (element instanceof Property) || (element instanceof DataType)) && !checkAlphaNumeric(element.getName())) {
			return ctx.createFailureStatus("Element should have an alphanumeric name beginning by a letter" + element.getQualifiedName());
		}
		 	}
		return ctx.createSuccessStatus();
	}

}
