/*****************************************************************************
 * Copyright (c) 2005, 2013 IBM Corporation, CEA, and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   Christian W. Damus (CEA) - Target EObject must be the diagnostic's first data element
 *   
 *****************************************************************************/


package org.eclipse.papyrus.uml.service.validation;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.validation.model.IConstraintStatus;
import org.eclipse.ocl.examples.pivot.uml.UMLOCLEValidator;
import org.eclipse.papyrus.infra.services.validation.EValidatorAdapter;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.OpaqueAction;
import org.eclipse.uml2.uml.OpaqueBehavior;
import org.eclipse.uml2.uml.OpaqueExpression;


/**
 * An adapter that plugs the EMF Model Validation Service API into the
 * {@link org.eclipse.emf.ecore.EValidator} API.
 * <p>
 * <strong>NOTE</strong> that this class was copied from the EMF Validation
 * "Validation Adapter" example project as created by the EMF Validation SDK,
 * and modified only to ensure that the {@link Diagnostic} created from an
 * {@link IConstraintStatus} has the original validation target element as the
 * first element of the {@linkplain Diagnostic#getData() data list} because the
 * {@linkplain IConstraintStatus#getResultLocus() result locus} of a constraint
 * status is an unordered set.
 * </p>
 * 
 * bug 405160 - avoid "false" errors by using the UMLValidator instead of EObjectValidator as base class 
 */
public class OCLEValidatorAdapter
	extends EValidatorAdapter {
	
	@Override
	public boolean validateInstanceSpecification(InstanceSpecification instanceSpecification,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!super.validateInstanceSpecification(instanceSpecification, diagnostics, context)) {
			return false;
		}
		return UMLOCLEValidator.INSTANCE.validateInstanceSpecification(instanceSpecification, diagnostics, context);
	}

	@Override
	public boolean validateOpaqueAction(OpaqueAction opaqueAction,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!super.validateOpaqueAction(opaqueAction, diagnostics, context)) {
			return false;
		}
		return UMLOCLEValidator.INSTANCE.validateOpaqueAction(opaqueAction, diagnostics, context);
	}

	@Override
	public boolean validateOpaqueBehavior(OpaqueBehavior opaqueBehavior,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!super.validateOpaqueBehavior(opaqueBehavior, diagnostics, context)) {
			return false;
		}
		return UMLOCLEValidator.INSTANCE.validateOpaqueBehavior(opaqueBehavior, diagnostics, context);
	}
	
	@Override
	public boolean validateOpaqueExpression(OpaqueExpression opaqueExpression,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!super.validateOpaqueExpression(opaqueExpression, diagnostics, context)) {
			return false;
		}
		return UMLOCLEValidator.INSTANCE.validateOpaqueExpression(opaqueExpression, diagnostics, context);
	}
}
