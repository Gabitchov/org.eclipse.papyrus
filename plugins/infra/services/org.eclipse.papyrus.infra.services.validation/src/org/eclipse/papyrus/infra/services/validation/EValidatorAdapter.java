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


package org.eclipse.papyrus.infra.services.validation;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.validation.model.EvaluationMode;
import org.eclipse.emf.validation.model.IConstraintStatus;
import org.eclipse.emf.validation.service.IBatchValidator;
import org.eclipse.emf.validation.service.ModelValidationService;


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
 */
public class EValidatorAdapter
	extends EObjectValidator {

	/**
	 * Model Validation Service interface for batch validation of EMF elements.
	 */
	private final IBatchValidator batchValidator;
	
	/**
	 * Initializes me.
	 */
	public EValidatorAdapter() {
		super();
		
		batchValidator = ModelValidationService.getInstance().newValidator(
				EvaluationMode.BATCH);
		batchValidator.setIncludeLiveConstraints(true);
		batchValidator.setReportSuccesses(false);
	}

	@Override
	public boolean validate(EObject eObject, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate(eObject.eClass(), eObject, diagnostics, context);
	}

	/**
	 * Implements validation by delegation to the EMF validation framework.
	 */
	@Override
	public boolean validate(EClass eClass, EObject eObject,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		// first, do whatever the basic EcoreValidator does
		super.validate(eClass, eObject, diagnostics, context);
		
		IStatus status = Status.OK_STATUS;
		
		// no point in validating if we can't report results
		if (diagnostics != null) {
			// if EMF Mode Validation Service already covered the sub-tree,
			//    which it does for efficient computation and error reporting,
			//    then don't repeat (the Diagnostician does the recursion
			//    externally).  If there is no context map, then we can't
			//    help it
			if (!hasProcessed(eObject, context)) {
				status = batchValidator.validate(
					eObject,
					new NullProgressMonitor());
				
				processed(eObject, context, status);
				
				appendDiagnostics(status, diagnostics);
			}
		}
		
		return status.isOK();
	}

	/**
	 * Direct validation of {@link EDataType}s is not supported by the EMF
	 * validation framework; they are validated indirectly via the
	 * {@link EObject}s that hold their values.
	 */
	@Override
	public boolean validate(EDataType eDataType, Object value,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return super.validate(eDataType, value, diagnostics, context);
	}
	
	/**
	 * If we have a context map, record this object's <code>status</code> in it
	 * so that we will know later that we have processed it and its sub-tree.
	 * 
	 * @param eObject an element that we have validated
	 * @param context the context (may be <code>null</code>)
	 * @param status the element's validation status
	 */
	private void processed(EObject eObject, Map<Object, Object> context, IStatus status) {
		if (context != null) {
			context.put(eObject, status);
		}
	}
	
	/**
	 * Determines whether we have processed this <code>eObject</code> before,
	 * by automatic recursion of the EMF Model Validation Service.  This is
	 * only possible if we do, indeed, have a context.
	 * 
	 * @param eObject an element to be validated (we hope not)
	 * @param context the context (may be <code>null</code>)
	 * @return <code>true</code> if the context is not <code>null</code> and
	 *     the <code>eObject</code> or one of its containers has already been
	 *     validated;  <code>false</code>, otherwise
	 */
	private boolean hasProcessed(EObject eObject, Map<Object, Object> context) {
		boolean result = false;
		
		if (context != null) {
			// this is O(NlogN) but there's no helping it
			while (eObject != null) {
				if (context.containsKey(eObject)) {
					result = true;
					eObject = null;
				} else {
					eObject = eObject.eContainer();
				}
			}
		}
		
		return result;
	}
	
	/**
	 * Converts a status result from the EMF validation service to diagnostics.
	 * 
	 * @param status the EMF validation service's status result
	 * @param diagnostics a diagnostic chain to accumulate results on
	 */
	private void appendDiagnostics(IStatus status, DiagnosticChain diagnostics) {
		if (status.isMultiStatus()) {
			IStatus[] children = status.getChildren();
			
			for (IStatus element : children) {
				appendDiagnostics(element, diagnostics);
			}
		} else if (status instanceof IConstraintStatus) {
			IConstraintStatus constraintStatus = (IConstraintStatus) status;
			diagnostics.add(new BasicDiagnostic(
				status.getSeverity(),
				status.getPlugin(),
				status.getCode(),
				status.getMessage(),
				toArray(constraintStatus.getResultLocus(), constraintStatus.getTarget())));
		}
	}

	/**
	 * Converts a possibly unordered collection to a list that has a designated
	 * {@code first} element.
	 * 
	 * @param elements
	 *            a possibly unordered collection of elements
	 * @param first
	 *            the element that is required to be first in the array. It will
	 *            be added if not already in the {@code element}; otherwise it
	 *            will not be repeated
	 * 
	 * @return the array of {@code elements} with the {@code first} element
	 *         first
	 */
	private Object[] toArray(Collection<?> elements, Object first) {
		Object[] result;
		
		if (!elements.contains(first)) {
			result = new Object[elements.size() + 1];
			result[0] = first;
			System.arraycopy(elements.toArray(), 0, result, 1, elements.size());
		} else {
			Iterator<?> iter = elements.iterator();
			Object actualFirst = iter.next();
			if (actualFirst == first) {
				// already the correct order.  Don't make it complicated
				result = elements.toArray();
			} else {
				// we have at least two elements if the collection contains
				// 'first' and some other element is the actual first element
				result = new Object[elements.size()];
				result[0] = first;
				result[1] = actualFirst;
				boolean skipped = false;
				for (int i = 2; iter.hasNext(); i++) {
					Object next = iter.next();
					if ((next == first) && !skipped) {
						skipped = true;
						i--;
					} else {
						result[i] = next;
					}
				}
			}
		}
		
		return result;
	}
}
