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
package org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.util;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.NattableconfigurationPackage
 * @generated
 */
public class NattableconfigurationValidator extends EObjectValidator {

	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final NattableconfigurationValidator INSTANCE = new NattableconfigurationValidator();

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
	public static final String DIAGNOSTIC_SOURCE = "org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration"; //$NON-NLS-1$

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
	public NattableconfigurationValidator() {
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
		return NattableconfigurationPackage.eINSTANCE;
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
		case NattableconfigurationPackage.TABLE_NAMED_ELEMENT:
			return validateTableNamedElement((TableNamedElement)value, diagnostics, context);
		case NattableconfigurationPackage.TABLE_CONFIGURATION:
			return validateTableConfiguration((TableConfiguration)value, diagnostics, context);
		case NattableconfigurationPackage.CELL_EDITOR_DECLARATION:
			return validateCellEditorDeclaration((CellEditorDeclaration)value, diagnostics, context);
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
	public boolean validateTableNamedElement(TableNamedElement tableNamedElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(tableNamedElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateTableConfiguration(TableConfiguration tableConfiguration, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if(!validate_NoCircularContainment(tableConfiguration, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(tableConfiguration, diagnostics, context);
		if(result || diagnostics != null)
			result &= validate_EveryDataValueConforms(tableConfiguration, diagnostics, context);
		if(result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(tableConfiguration, diagnostics, context);
		if(result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(tableConfiguration, diagnostics, context);
		if(result || diagnostics != null)
			result &= validate_EveryProxyResolves(tableConfiguration, diagnostics, context);
		if(result || diagnostics != null)
			result &= validate_UniqueID(tableConfiguration, diagnostics, context);
		if(result || diagnostics != null)
			result &= validate_EveryKeyUnique(tableConfiguration, diagnostics, context);
		if(result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(tableConfiguration, diagnostics, context);
		if(result || diagnostics != null)
			result &= validateTableConfiguration_defaultRowAxisProviderExistsInCollection(tableConfiguration, diagnostics, context);
		if(result || diagnostics != null)
			result &= validateTableConfiguration_defaultColumnAxisProviderExistsInCollection(tableConfiguration, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the defaultRowAxisProviderExistsInCollection constraint of '<em>Table Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static final String TABLE_CONFIGURATION__DEFAULT_ROW_AXIS_PROVIDER_EXISTS_IN_COLLECTION__EEXPRESSION = "rowAxisProviders->includes(defaultRowAxisProvider)"; //$NON-NLS-1$

	/**
	 * Validates the defaultRowAxisProviderExistsInCollection constraint of '<em>Table Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateTableConfiguration_defaultRowAxisProviderExistsInCollection(TableConfiguration tableConfiguration, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate(NattableconfigurationPackage.Literals.TABLE_CONFIGURATION, tableConfiguration, diagnostics, context, "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot", //$NON-NLS-1$
			"defaultRowAxisProviderExistsInCollection", //$NON-NLS-1$
			TABLE_CONFIGURATION__DEFAULT_ROW_AXIS_PROVIDER_EXISTS_IN_COLLECTION__EEXPRESSION, Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0);
	}

	/**
	 * The cached validation expression for the defaultColumnAxisProviderExistsInCollection constraint of '<em>Table Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static final String TABLE_CONFIGURATION__DEFAULT_COLUMN_AXIS_PROVIDER_EXISTS_IN_COLLECTION__EEXPRESSION = "columnAxisProviders->includes(defaultColumnAxisProvider)"; //$NON-NLS-1$

	/**
	 * Validates the defaultColumnAxisProviderExistsInCollection constraint of '<em>Table Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateTableConfiguration_defaultColumnAxisProviderExistsInCollection(TableConfiguration tableConfiguration, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate(NattableconfigurationPackage.Literals.TABLE_CONFIGURATION, tableConfiguration, diagnostics, context, "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot", //$NON-NLS-1$
			"defaultColumnAxisProviderExistsInCollection", //$NON-NLS-1$
			TABLE_CONFIGURATION__DEFAULT_COLUMN_AXIS_PROVIDER_EXISTS_IN_COLLECTION__EEXPRESSION, Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateCellEditorDeclaration(CellEditorDeclaration cellEditorDeclaration, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
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

} //NattableconfigurationValidator
