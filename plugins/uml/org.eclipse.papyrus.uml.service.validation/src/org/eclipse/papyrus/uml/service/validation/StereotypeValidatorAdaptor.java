/*****************************************************************************
 * Copyright (c) 2010, 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Ansgar Radermacher (CEA LIST) ansgar.radermacher@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.service.validation;

import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.services.validation.EValidatorAdapter;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * This validator adaptor replace the target in case of validating a stereotype application. The target is
 * replaced with the base model element
 * This resolves the bugs
 *   410119 - [Validation] markers related to stereotype applications are not updated in diagrams 
 *   410059 - [Validation] delete subtree does not remove markers associated with stereotypes
 */		
public class StereotypeValidatorAdaptor extends EValidatorAdapter {
	
	@Override
	protected BasicDiagnostic createDiagnostic(int severity, String source, int code, String messageKey, Object[] messageSubstitutions, Object[] data, Map<Object, Object> context)
	{
		Object target = data[0];
		// If the target is a stereotype application, replace target with base model element
		if (validateStereotype && target instanceof EObject) {
			EObject base = UMLUtil.getBaseElement((EObject) target);
			if (base != null) {
				data[0] = base;
			}
		}
	    return super.createDiagnostic(severity, source, code, messageKey, messageSubstitutions, data, context);
	  }

	boolean validateStereotype;
}
