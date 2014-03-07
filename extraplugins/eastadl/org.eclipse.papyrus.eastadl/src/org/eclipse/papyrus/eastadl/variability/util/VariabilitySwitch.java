/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Sara TUCCI (CEA LIST) sara.tucci@cea.fr - Initial API and implementation
 *  Chokri MRAIDHA (CEA LIST) chokri.mraidha@cea.fr - Initial API and implementation
 *  David SERVAT (CEA LIST) david.servat@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.eastadl.variability.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.eclipse.papyrus.eastadl.infrastructure.elements.Context;
import org.eclipse.papyrus.eastadl.infrastructure.elements.EAElement;
import org.eclipse.papyrus.eastadl.infrastructure.elements.EAPackageableElement;
import org.eclipse.papyrus.eastadl.infrastructure.elements.TraceableSpecification;
import org.eclipse.papyrus.eastadl.variability.*;
import org.eclipse.papyrus.eastadl.variability.ConfigurableContainer;
import org.eclipse.papyrus.eastadl.variability.ConfigurationDecision;
import org.eclipse.papyrus.eastadl.variability.ConfigurationDecisionFolder;
import org.eclipse.papyrus.eastadl.variability.ConfigurationDecisionModel;
import org.eclipse.papyrus.eastadl.variability.ConfigurationDecisionModelEntry;
import org.eclipse.papyrus.eastadl.variability.ContainerConfiguration;
import org.eclipse.papyrus.eastadl.variability.FeatureConfiguration;
import org.eclipse.papyrus.eastadl.variability.InternalBinding;
import org.eclipse.papyrus.eastadl.variability.PrivateContent;
import org.eclipse.papyrus.eastadl.variability.ReuseMetaInformation;
import org.eclipse.papyrus.eastadl.variability.SelectionCriterion;
import org.eclipse.papyrus.eastadl.variability.Variability;
import org.eclipse.papyrus.eastadl.variability.VariabilityPackage;
import org.eclipse.papyrus.eastadl.variability.VariableElement;
import org.eclipse.papyrus.eastadl.variability.VariationGroup;
import org.eclipse.papyrus.eastadl.variability.VehicleLevelBinding;


/**
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance hierarchy. It supports the
 * call {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for
 * each class of the model, starting with the actual class of the object and proceeding up the
 * inheritance hierarchy until a non-null result is returned, which is the result of the switch.
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.papyrus.eastadl.variability.VariabilityPackage
 * @generated
 */
public class VariabilitySwitch<T> extends Switch<T> {

	/**
	 * The cached model package
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static VariabilityPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public VariabilitySwitch() {
		if(modelPackage == null) {
			modelPackage = VariabilityPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Configurable Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Configurable Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConfigurableContainer(ConfigurableContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Configuration Decision</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Configuration Decision</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConfigurationDecision(ConfigurationDecision object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Configuration Decision Folder</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Configuration Decision Folder</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConfigurationDecisionFolder(ConfigurationDecisionFolder object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Configuration Decision Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Configuration Decision Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConfigurationDecisionModel(ConfigurationDecisionModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Configuration Decision Model Entry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Configuration Decision Model Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConfigurationDecisionModelEntry(ConfigurationDecisionModelEntry object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Container Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Container Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContainerConfiguration(ContainerConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Context</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Context</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContext(Context object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Feature Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Feature Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFeatureConfiguration(FeatureConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Vehicle Level Binding</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Vehicle Level Binding</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVehicleLevelBinding(VehicleLevelBinding object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Internal Binding</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Internal Binding</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInternalBinding(InternalBinding object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Private Content</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Private Content</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrivateContent(PrivateContent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EA Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EA Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEAElement(EAElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EA Packageable Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EA Packageable Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEAPackageableElement(EAPackageableElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reuse Meta Information</em>'.
	 * <!-- begin-user-doc --> This implementation returns null;
	 * returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reuse Meta Information</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReuseMetaInformation(ReuseMetaInformation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Selection Criterion</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Selection Criterion</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSelectionCriterion(SelectionCriterion object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Traceable Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Traceable Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTraceableSpecification(TraceableSpecification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variability</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variability</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariability(Variability object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariableElement(VariableElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variation Group</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variation Group</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariationGroup(VariationGroup object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch, but this is the last case anyway. <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch(classifierID) {
		case VariabilityPackage.VARIATION_GROUP:
		{
			VariationGroup variationGroup = (VariationGroup)theEObject;
			T result = caseVariationGroup(variationGroup);
			if(result == null)
				result = caseEAElement(variationGroup);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case VariabilityPackage.VARIABLE_ELEMENT:
		{
			VariableElement variableElement = (VariableElement)theEObject;
			T result = caseVariableElement(variableElement);
			if(result == null)
				result = caseEAElement(variableElement);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case VariabilityPackage.REUSE_META_INFORMATION:
		{
			ReuseMetaInformation reuseMetaInformation = (ReuseMetaInformation)theEObject;
			T result = caseReuseMetaInformation(reuseMetaInformation);
			if(result == null)
				result = caseTraceableSpecification(reuseMetaInformation);
			if(result == null)
				result = caseEAPackageableElement(reuseMetaInformation);
			if(result == null)
				result = caseEAElement(reuseMetaInformation);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case VariabilityPackage.CONFIGURABLE_CONTAINER:
		{
			ConfigurableContainer configurableContainer = (ConfigurableContainer)theEObject;
			T result = caseConfigurableContainer(configurableContainer);
			if(result == null)
				result = caseEAElement(configurableContainer);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case VariabilityPackage.INTERNAL_BINDING:
		{
			InternalBinding internalBinding = (InternalBinding)theEObject;
			T result = caseInternalBinding(internalBinding);
			if(result == null)
				result = caseConfigurationDecisionModel(internalBinding);
			if(result == null)
				result = caseEAElement(internalBinding);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case VariabilityPackage.CONFIGURATION_DECISION_MODEL:
		{
			ConfigurationDecisionModel configurationDecisionModel = (ConfigurationDecisionModel)theEObject;
			T result = caseConfigurationDecisionModel(configurationDecisionModel);
			if(result == null)
				result = caseEAElement(configurationDecisionModel);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case VariabilityPackage.CONFIGURATION_DECISION_MODEL_ENTRY:
		{
			ConfigurationDecisionModelEntry configurationDecisionModelEntry = (ConfigurationDecisionModelEntry)theEObject;
			T result = caseConfigurationDecisionModelEntry(configurationDecisionModelEntry);
			if(result == null)
				result = caseEAElement(configurationDecisionModelEntry);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case VariabilityPackage.VARIABILITY:
		{
			Variability variability = (Variability)theEObject;
			T result = caseVariability(variability);
			if(result == null)
				result = caseContext(variability);
			if(result == null)
				result = caseEAElement(variability);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case VariabilityPackage.FEATURE_CONFIGURATION:
		{
			FeatureConfiguration featureConfiguration = (FeatureConfiguration)theEObject;
			T result = caseFeatureConfiguration(featureConfiguration);
			if(result == null)
				result = caseConfigurationDecisionModel(featureConfiguration);
			if(result == null)
				result = caseEAElement(featureConfiguration);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case VariabilityPackage.VEHICLE_LEVEL_BINDING:
		{
			VehicleLevelBinding vehicleLevelBinding = (VehicleLevelBinding)theEObject;
			T result = caseVehicleLevelBinding(vehicleLevelBinding);
			if(result == null)
				result = caseConfigurationDecisionModel(vehicleLevelBinding);
			if(result == null)
				result = caseEAElement(vehicleLevelBinding);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case VariabilityPackage.CONFIGURATION_DECISION:
		{
			ConfigurationDecision configurationDecision = (ConfigurationDecision)theEObject;
			T result = caseConfigurationDecision(configurationDecision);
			if(result == null)
				result = caseConfigurationDecisionModelEntry(configurationDecision);
			if(result == null)
				result = caseEAElement(configurationDecision);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case VariabilityPackage.SELECTION_CRITERION:
		{
			SelectionCriterion selectionCriterion = (SelectionCriterion)theEObject;
			T result = caseSelectionCriterion(selectionCriterion);
			if(result == null)
				result = caseEAElement(selectionCriterion);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case VariabilityPackage.CONFIGURATION_DECISION_FOLDER:
		{
			ConfigurationDecisionFolder configurationDecisionFolder = (ConfigurationDecisionFolder)theEObject;
			T result = caseConfigurationDecisionFolder(configurationDecisionFolder);
			if(result == null)
				result = caseConfigurationDecisionModelEntry(configurationDecisionFolder);
			if(result == null)
				result = caseEAElement(configurationDecisionFolder);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case VariabilityPackage.CONTAINER_CONFIGURATION:
		{
			ContainerConfiguration containerConfiguration = (ContainerConfiguration)theEObject;
			T result = caseContainerConfiguration(containerConfiguration);
			if(result == null)
				result = caseConfigurationDecisionModel(containerConfiguration);
			if(result == null)
				result = caseEAElement(containerConfiguration);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case VariabilityPackage.PRIVATE_CONTENT:
		{
			PrivateContent privateContent = (PrivateContent)theEObject;
			T result = casePrivateContent(privateContent);
			if(result == null)
				result = caseEAElement(privateContent);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

} // VariabilitySwitch
