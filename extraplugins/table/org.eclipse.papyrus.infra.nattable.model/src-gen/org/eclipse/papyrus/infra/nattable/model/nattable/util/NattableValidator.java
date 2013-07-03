/**
 * Copyright (c) 2013 CEA LIST.
 * 
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.infra.nattable.model.nattable.util;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

import org.eclipse.papyrus.infra.nattable.model.nattable.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.papyrus.infra.nattable.model.nattable.NattablePackage
 * @generated
 */
public class NattableValidator extends EObjectValidator {

	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final NattableValidator INSTANCE = new NattableValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic
	 * {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "org.eclipse.papyrus.infra.nattable.model.nattable"; //$NON-NLS-1$

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NattableValidator() {
		super();
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
		return NattablePackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch(classifierID) {
		case NattablePackage.TABLE:
			return validateTable((Table)value, diagnostics, context);
		default:
			return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateTable(Table table, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if(!validate_NoCircularContainment(table, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(table, diagnostics, context);
		if(result || diagnostics != null)
			result &= validate_EveryDataValueConforms(table, diagnostics, context);
		if(result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(table, diagnostics, context);
		if(result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(table, diagnostics, context);
		if(result || diagnostics != null)
			result &= validate_EveryProxyResolves(table, diagnostics, context);
		if(result || diagnostics != null)
			result &= validate_UniqueID(table, diagnostics, context);
		if(result || diagnostics != null)
			result &= validate_EveryKeyUnique(table, diagnostics, context);
		if(result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(table, diagnostics, context);
		if(result || diagnostics != null)
			result &= validateTable_currentRowAxisInHistory(table, diagnostics, context);
		if(result || diagnostics != null)
			result &= validateTable_currentColumnAxisInHistory(table, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the currentRowAxisInHistory constraint of '<em>Table</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static final String TABLE__CURRENT_ROW_AXIS_IN_HISTORY__EEXPRESSION = "rowAxisProvidersHistory->includes(currentRowAxisProvider)"; //$NON-NLS-1$

	/**
	 * Validates the currentRowAxisInHistory constraint of '<em>Table</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateTable_currentRowAxisInHistory(Table table, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate(NattablePackage.Literals.TABLE, table, diagnostics, context, "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot", //$NON-NLS-1$
			"currentRowAxisInHistory", //$NON-NLS-1$
			TABLE__CURRENT_ROW_AXIS_IN_HISTORY__EEXPRESSION, Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0);
	}

	/**
	 * The cached validation expression for the currentColumnAxisInHistory constraint of '<em>Table</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static final String TABLE__CURRENT_COLUMN_AXIS_IN_HISTORY__EEXPRESSION = "columnAxisProvidersHistory->includes(currentColumnAxisProvider)"; //$NON-NLS-1$

	/**
	 * Validates the currentColumnAxisInHistory constraint of '<em>Table</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateTable_currentColumnAxisInHistory(Table table, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate(NattablePackage.Literals.TABLE, table, diagnostics, context, "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot", //$NON-NLS-1$
			"currentColumnAxisInHistory", //$NON-NLS-1$
			TABLE__CURRENT_COLUMN_AXIS_IN_HISTORY__EEXPRESSION, Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0);
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} //NattableValidator
