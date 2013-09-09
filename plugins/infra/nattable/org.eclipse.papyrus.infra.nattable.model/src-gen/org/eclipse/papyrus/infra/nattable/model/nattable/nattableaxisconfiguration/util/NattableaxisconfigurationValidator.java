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
package org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.util;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.NattableaxisconfigurationPackage
 * @generated
 */
public class NattableaxisconfigurationValidator extends EObjectValidator {

	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final NattableaxisconfigurationValidator INSTANCE = new NattableaxisconfigurationValidator();

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
	public static final String DIAGNOSTIC_SOURCE = "org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration"; //$NON-NLS-1$

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
	public NattableaxisconfigurationValidator() {
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
		return NattableaxisconfigurationPackage.eINSTANCE;
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
		case NattableaxisconfigurationPackage.ABSTRACT_HEADER_AXIS_CONFIGURATION:
			return validateAbstractHeaderAxisConfiguration((AbstractHeaderAxisConfiguration)value, diagnostics, context);
		case NattableaxisconfigurationPackage.AXIS_MANAGER_REPRESENTATION:
			return validateAxisManagerRepresentation((AxisManagerRepresentation)value, diagnostics, context);
		case NattableaxisconfigurationPackage.AXIS_MANAGER_CONFIGURATION:
			return validateAxisManagerConfiguration((AxisManagerConfiguration)value, diagnostics, context);
		case NattableaxisconfigurationPackage.TABLE_HEADER_AXIS_CONFIGURATION:
			return validateTableHeaderAxisConfiguration((TableHeaderAxisConfiguration)value, diagnostics, context);
		case NattableaxisconfigurationPackage.LOCAL_TABLE_HEADER_AXIS_CONFIGURATION:
			return validateLocalTableHeaderAxisConfiguration((LocalTableHeaderAxisConfiguration)value, diagnostics, context);
		case NattableaxisconfigurationPackage.IAXIS_CONFIGURATION:
			return validateIAxisConfiguration((IAxisConfiguration)value, diagnostics, context);
		case NattableaxisconfigurationPackage.FEATURE_AXIS_CONFIGURATION:
			return validateFeatureAxisConfiguration((FeatureAxisConfiguration)value, diagnostics, context);
		case NattableaxisconfigurationPackage.IFILLING_CONFIGURATION:
			return validateIFillingConfiguration((IFillingConfiguration)value, diagnostics, context);
		case NattableaxisconfigurationPackage.ESTRUCTURAL_FEATURE_VALUE_FILLING_CONFIGURATION:
			return validateEStructuralFeatureValueFillingConfiguration((EStructuralFeatureValueFillingConfiguration)value, diagnostics, context);
		case NattableaxisconfigurationPackage.IPASTE_CONFIGURATION:
			return validateIPasteConfiguration((IPasteConfiguration)value, diagnostics, context);
		case NattableaxisconfigurationPackage.PASTE_EOBJECT_CONFIGURATION:
			return validatePasteEObjectConfiguration((PasteEObjectConfiguration)value, diagnostics, context);
		case NattableaxisconfigurationPackage.AXIS_INDEX_STYLE:
			return validateAxisIndexStyle((AxisIndexStyle)value, diagnostics, context);
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
	public boolean validateAbstractHeaderAxisConfiguration(AbstractHeaderAxisConfiguration abstractHeaderAxisConfiguration, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if(!validate_NoCircularContainment(abstractHeaderAxisConfiguration, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(abstractHeaderAxisConfiguration, diagnostics, context);
		if(result || diagnostics != null)
			result &= validate_EveryDataValueConforms(abstractHeaderAxisConfiguration, diagnostics, context);
		if(result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(abstractHeaderAxisConfiguration, diagnostics, context);
		if(result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(abstractHeaderAxisConfiguration, diagnostics, context);
		if(result || diagnostics != null)
			result &= validate_EveryProxyResolves(abstractHeaderAxisConfiguration, diagnostics, context);
		if(result || diagnostics != null)
			result &= validate_UniqueID(abstractHeaderAxisConfiguration, diagnostics, context);
		if(result || diagnostics != null)
			result &= validate_EveryKeyUnique(abstractHeaderAxisConfiguration, diagnostics, context);
		if(result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(abstractHeaderAxisConfiguration, diagnostics, context);
		if(result || diagnostics != null)
			result &= validateAbstractHeaderAxisConfiguration_oneObjectLabelConfigurationTypes(abstractHeaderAxisConfiguration, diagnostics, context);
		if(result || diagnostics != null)
			result &= validateAbstractHeaderAxisConfiguration_oneFeatureLabelConfigurationTypes(abstractHeaderAxisConfiguration, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the oneObjectLabelConfigurationTypes constraint of '<em>Abstract Header Axis Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static final String ABSTRACT_HEADER_AXIS_CONFIGURATION__ONE_OBJECT_LABEL_CONFIGURATION_TYPES__EEXPRESSION = "ownedLabelConfigurations->collect(ilc : nattable::nattablelabelprovider::ILabelProviderConfiguration | ilc.oclAsType(nattable::nattablelabelprovider::ObjectLabelProviderConfiguration))->size() <= 1"; //$NON-NLS-1$

	/**
	 * Validates the oneObjectLabelConfigurationTypes constraint of '<em>Abstract Header Axis Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateAbstractHeaderAxisConfiguration_oneObjectLabelConfigurationTypes(AbstractHeaderAxisConfiguration abstractHeaderAxisConfiguration, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate(NattableaxisconfigurationPackage.Literals.ABSTRACT_HEADER_AXIS_CONFIGURATION, abstractHeaderAxisConfiguration, diagnostics, context, "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot", //$NON-NLS-1$
			"oneObjectLabelConfigurationTypes", //$NON-NLS-1$
			ABSTRACT_HEADER_AXIS_CONFIGURATION__ONE_OBJECT_LABEL_CONFIGURATION_TYPES__EEXPRESSION, Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0);
	}

	/**
	 * The cached validation expression for the oneFeatureLabelConfigurationTypes constraint of '<em>Abstract Header Axis Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static final String ABSTRACT_HEADER_AXIS_CONFIGURATION__ONE_FEATURE_LABEL_CONFIGURATION_TYPES__EEXPRESSION = "ownedLabelConfigurations->collect(ilc : nattable::nattablelabelprovider::ILabelProviderConfiguration | ilc.oclAsType(nattable::nattablelabelprovider::FeatureLabelProviderConfiguration))->size() <= 1"; //$NON-NLS-1$

	/**
	 * Validates the oneFeatureLabelConfigurationTypes constraint of '<em>Abstract Header Axis Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateAbstractHeaderAxisConfiguration_oneFeatureLabelConfigurationTypes(AbstractHeaderAxisConfiguration abstractHeaderAxisConfiguration, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate(NattableaxisconfigurationPackage.Literals.ABSTRACT_HEADER_AXIS_CONFIGURATION, abstractHeaderAxisConfiguration, diagnostics, context, "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot", //$NON-NLS-1$
			"oneFeatureLabelConfigurationTypes", //$NON-NLS-1$
			ABSTRACT_HEADER_AXIS_CONFIGURATION__ONE_FEATURE_LABEL_CONFIGURATION_TYPES__EEXPRESSION, Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateAxisManagerRepresentation(AxisManagerRepresentation axisManagerRepresentation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(axisManagerRepresentation, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateAxisManagerConfiguration(AxisManagerConfiguration axisManagerConfiguration, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(axisManagerConfiguration, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateTableHeaderAxisConfiguration(TableHeaderAxisConfiguration tableHeaderAxisConfiguration, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if(!validate_NoCircularContainment(tableHeaderAxisConfiguration, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(tableHeaderAxisConfiguration, diagnostics, context);
		if(result || diagnostics != null)
			result &= validate_EveryDataValueConforms(tableHeaderAxisConfiguration, diagnostics, context);
		if(result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(tableHeaderAxisConfiguration, diagnostics, context);
		if(result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(tableHeaderAxisConfiguration, diagnostics, context);
		if(result || diagnostics != null)
			result &= validate_EveryProxyResolves(tableHeaderAxisConfiguration, diagnostics, context);
		if(result || diagnostics != null)
			result &= validate_UniqueID(tableHeaderAxisConfiguration, diagnostics, context);
		if(result || diagnostics != null)
			result &= validate_EveryKeyUnique(tableHeaderAxisConfiguration, diagnostics, context);
		if(result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(tableHeaderAxisConfiguration, diagnostics, context);
		if(result || diagnostics != null)
			result &= validateAbstractHeaderAxisConfiguration_oneObjectLabelConfigurationTypes(tableHeaderAxisConfiguration, diagnostics, context);
		if(result || diagnostics != null)
			result &= validateAbstractHeaderAxisConfiguration_oneFeatureLabelConfigurationTypes(tableHeaderAxisConfiguration, diagnostics, context);
		if(result || diagnostics != null)
			result &= validateTableHeaderAxisConfiguration_axisManagersIdUnique(tableHeaderAxisConfiguration, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the axisManagersIdUnique constraint of '<em>Table Header Axis Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static final String TABLE_HEADER_AXIS_CONFIGURATION__AXIS_MANAGERS_ID_UNIQUE__EEXPRESSION = "axisManagers->forAll(am1 : AxisManagerRepresentation, am2 : AxisManagerRepresentation | am1.axisManagerId <> am2.axisManagerId)"; //$NON-NLS-1$

	/**
	 * Validates the axisManagersIdUnique constraint of '<em>Table Header Axis Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateTableHeaderAxisConfiguration_axisManagersIdUnique(TableHeaderAxisConfiguration tableHeaderAxisConfiguration, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate(NattableaxisconfigurationPackage.Literals.TABLE_HEADER_AXIS_CONFIGURATION, tableHeaderAxisConfiguration, diagnostics, context, "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot", //$NON-NLS-1$
			"axisManagersIdUnique", //$NON-NLS-1$
			TABLE_HEADER_AXIS_CONFIGURATION__AXIS_MANAGERS_ID_UNIQUE__EEXPRESSION, Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateLocalTableHeaderAxisConfiguration(LocalTableHeaderAxisConfiguration localTableHeaderAxisConfiguration, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if(!validate_NoCircularContainment(localTableHeaderAxisConfiguration, diagnostics, context))
			return false;
		boolean result = validate_EveryMultiplicityConforms(localTableHeaderAxisConfiguration, diagnostics, context);
		if(result || diagnostics != null)
			result &= validate_EveryDataValueConforms(localTableHeaderAxisConfiguration, diagnostics, context);
		if(result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(localTableHeaderAxisConfiguration, diagnostics, context);
		if(result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(localTableHeaderAxisConfiguration, diagnostics, context);
		if(result || diagnostics != null)
			result &= validate_EveryProxyResolves(localTableHeaderAxisConfiguration, diagnostics, context);
		if(result || diagnostics != null)
			result &= validate_UniqueID(localTableHeaderAxisConfiguration, diagnostics, context);
		if(result || diagnostics != null)
			result &= validate_EveryKeyUnique(localTableHeaderAxisConfiguration, diagnostics, context);
		if(result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(localTableHeaderAxisConfiguration, diagnostics, context);
		if(result || diagnostics != null)
			result &= validateAbstractHeaderAxisConfiguration_oneObjectLabelConfigurationTypes(localTableHeaderAxisConfiguration, diagnostics, context);
		if(result || diagnostics != null)
			result &= validateAbstractHeaderAxisConfiguration_oneFeatureLabelConfigurationTypes(localTableHeaderAxisConfiguration, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateIAxisConfiguration(IAxisConfiguration iAxisConfiguration, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(iAxisConfiguration, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateFeatureAxisConfiguration(FeatureAxisConfiguration featureAxisConfiguration, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(featureAxisConfiguration, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateIFillingConfiguration(IFillingConfiguration iFillingConfiguration, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(iFillingConfiguration, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateEStructuralFeatureValueFillingConfiguration(EStructuralFeatureValueFillingConfiguration eStructuralFeatureValueFillingConfiguration, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(eStructuralFeatureValueFillingConfiguration, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateIPasteConfiguration(IPasteConfiguration iPasteConfiguration, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(iPasteConfiguration, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validatePasteEObjectConfiguration(PasteEObjectConfiguration pasteEObjectConfiguration, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(pasteEObjectConfiguration, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateAxisIndexStyle(AxisIndexStyle axisIndexStyle, DiagnosticChain diagnostics, Map<Object, Object> context) {
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

} //NattableaxisconfigurationValidator
