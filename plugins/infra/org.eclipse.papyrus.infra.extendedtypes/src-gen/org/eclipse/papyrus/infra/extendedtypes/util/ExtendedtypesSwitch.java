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
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.infra.extendedtypes.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.papyrus.infra.extendedtypes.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.papyrus.infra.extendedtypes.ExtendedtypesPackage
 * @generated
 */
public class ExtendedtypesSwitch<T> extends Switch<T> {

	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static ExtendedtypesPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ExtendedtypesSwitch() {
		if(modelPackage == null) {
			modelPackage = ExtendedtypesPackage.eINSTANCE;
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
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch(classifierID) {
		case ExtendedtypesPackage.EXTENDED_ELEMENT_TYPE_SET:
		{
			ExtendedElementTypeSet extendedElementTypeSet = (ExtendedElementTypeSet)theEObject;
			T result = caseExtendedElementTypeSet(extendedElementTypeSet);
			if(result == null)
				result = caseConfigurationElement(extendedElementTypeSet);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ExtendedtypesPackage.ELEMENT_TYPE_CONFIGURATION:
		{
			ElementTypeConfiguration elementTypeConfiguration = (ElementTypeConfiguration)theEObject;
			T result = caseElementTypeConfiguration(elementTypeConfiguration);
			if(result == null)
				result = caseConfigurationElement(elementTypeConfiguration);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ExtendedtypesPackage.ICON_ENTRY:
		{
			IconEntry iconEntry = (IconEntry)theEObject;
			T result = caseIconEntry(iconEntry);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ExtendedtypesPackage.CONFIGURATION_ELEMENT:
		{
			ConfigurationElement configurationElement = (ConfigurationElement)theEObject;
			T result = caseConfigurationElement(configurationElement);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ExtendedtypesPackage.MATCHER_CONFIGURATION:
		{
			MatcherConfiguration matcherConfiguration = (MatcherConfiguration)theEObject;
			T result = caseMatcherConfiguration(matcherConfiguration);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ExtendedtypesPackage.ACTION_CONFIGURATION:
		{
			ActionConfiguration actionConfiguration = (ActionConfiguration)theEObject;
			T result = caseActionConfiguration(actionConfiguration);
			if(result == null)
				result = caseConfigurationElement(actionConfiguration);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ExtendedtypesPackage.VIEW_ACTION_CONFIGURATION:
		{
			ViewActionConfiguration viewActionConfiguration = (ViewActionConfiguration)theEObject;
			T result = caseViewActionConfiguration(viewActionConfiguration);
			if(result == null)
				result = caseActionConfiguration(viewActionConfiguration);
			if(result == null)
				result = caseConfigurationElement(viewActionConfiguration);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ExtendedtypesPackage.SEMANTIC_ACTION_CONFIGURATION:
		{
			SemanticActionConfiguration semanticActionConfiguration = (SemanticActionConfiguration)theEObject;
			T result = caseSemanticActionConfiguration(semanticActionConfiguration);
			if(result == null)
				result = caseActionConfiguration(semanticActionConfiguration);
			if(result == null)
				result = caseConfigurationElement(semanticActionConfiguration);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ExtendedtypesPackage.SEMANTIC_TYPE_CONFIGURATION:
		{
			SemanticTypeConfiguration semanticTypeConfiguration = (SemanticTypeConfiguration)theEObject;
			T result = caseSemanticTypeConfiguration(semanticTypeConfiguration);
			if(result == null)
				result = caseElementTypeConfiguration(semanticTypeConfiguration);
			if(result == null)
				result = caseConfigurationElement(semanticTypeConfiguration);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ExtendedtypesPackage.VIEW_TYPE_CONFIGURATION:
		{
			ViewTypeConfiguration viewTypeConfiguration = (ViewTypeConfiguration)theEObject;
			T result = caseViewTypeConfiguration(viewTypeConfiguration);
			if(result == null)
				result = caseElementTypeConfiguration(viewTypeConfiguration);
			if(result == null)
				result = caseConfigurationElement(viewTypeConfiguration);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ExtendedtypesPackage.ELEMENT_TYPE_ADVICE_CONFIGURATION:
		{
			ElementTypeAdviceConfiguration elementTypeAdviceConfiguration = (ElementTypeAdviceConfiguration)theEObject;
			T result = caseElementTypeAdviceConfiguration(elementTypeAdviceConfiguration);
			if(result == null)
				result = caseConfigurationElement(elementTypeAdviceConfiguration);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ExtendedtypesPackage.ASPECT_SEMANTIC_TYPE_CONFIGURATION:
		{
			AspectSemanticTypeConfiguration aspectSemanticTypeConfiguration = (AspectSemanticTypeConfiguration)theEObject;
			T result = caseAspectSemanticTypeConfiguration(aspectSemanticTypeConfiguration);
			if(result == null)
				result = caseSemanticTypeConfiguration(aspectSemanticTypeConfiguration);
			if(result == null)
				result = caseElementTypeConfiguration(aspectSemanticTypeConfiguration);
			if(result == null)
				result = caseConfigurationElement(aspectSemanticTypeConfiguration);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ExtendedtypesPackage.ASPECT_VIEW_TYPE_CONFIGURATION:
		{
			AspectViewTypeConfiguration aspectViewTypeConfiguration = (AspectViewTypeConfiguration)theEObject;
			T result = caseAspectViewTypeConfiguration(aspectViewTypeConfiguration);
			if(result == null)
				result = caseViewTypeConfiguration(aspectViewTypeConfiguration);
			if(result == null)
				result = caseElementTypeConfiguration(aspectViewTypeConfiguration);
			if(result == null)
				result = caseConfigurationElement(aspectViewTypeConfiguration);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Extended Element Type Set</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Extended Element Type Set</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExtendedElementTypeSet(ExtendedElementTypeSet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element Type Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element Type Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseElementTypeConfiguration(ElementTypeConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Icon Entry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Icon Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIconEntry(IconEntry object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Configuration Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Configuration Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConfigurationElement(ConfigurationElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Matcher Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Matcher Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMatcherConfiguration(MatcherConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Action Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Action Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActionConfiguration(ActionConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>View Action Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>View Action Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseViewActionConfiguration(ViewActionConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Semantic Action Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Semantic Action Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSemanticActionConfiguration(SemanticActionConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Semantic Type Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Semantic Type Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSemanticTypeConfiguration(SemanticTypeConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>View Type Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>View Type Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseViewTypeConfiguration(ViewTypeConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element Type Advice Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element Type Advice Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseElementTypeAdviceConfiguration(ElementTypeAdviceConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Aspect Semantic Type Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Aspect Semantic Type Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAspectSemanticTypeConfiguration(AspectSemanticTypeConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Aspect View Type Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Aspect View Type Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAspectViewTypeConfiguration(AspectViewTypeConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
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
} //ExtendedtypesSwitch
