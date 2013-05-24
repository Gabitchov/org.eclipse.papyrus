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

import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.NattableaxisconfigurationPackage
 * @generated
 */
public class NattableaxisconfigurationSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static NattableaxisconfigurationPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NattableaxisconfigurationSwitch() {
		if (modelPackage == null) {
			modelPackage = NattableaxisconfigurationPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case NattableaxisconfigurationPackage.ABSTRACT_HEADER_AXIS_CONFIGURATION: {
				AbstractHeaderAxisConfiguration abstractHeaderAxisConfiguration = (AbstractHeaderAxisConfiguration)theEObject;
				T result = caseAbstractHeaderAxisConfiguration(abstractHeaderAxisConfiguration);
				if (result == null) result = caseEModelElement(abstractHeaderAxisConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NattableaxisconfigurationPackage.AXIS_MANAGER_REPRESENTATION: {
				AxisManagerRepresentation axisManagerRepresentation = (AxisManagerRepresentation)theEObject;
				T result = caseAxisManagerRepresentation(axisManagerRepresentation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NattableaxisconfigurationPackage.AXIS_MANAGER_CONFIGURATION: {
				AxisManagerConfiguration axisManagerConfiguration = (AxisManagerConfiguration)theEObject;
				T result = caseAxisManagerConfiguration(axisManagerConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NattableaxisconfigurationPackage.TABLE_HEADER_AXIS_CONFIGURATION: {
				TableHeaderAxisConfiguration tableHeaderAxisConfiguration = (TableHeaderAxisConfiguration)theEObject;
				T result = caseTableHeaderAxisConfiguration(tableHeaderAxisConfiguration);
				if (result == null) result = caseAbstractHeaderAxisConfiguration(tableHeaderAxisConfiguration);
				if (result == null) result = caseEModelElement(tableHeaderAxisConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NattableaxisconfigurationPackage.LOCAL_TABLE_HEADER_AXIS_CONFIGURATION: {
				LocalTableHeaderAxisConfiguration localTableHeaderAxisConfiguration = (LocalTableHeaderAxisConfiguration)theEObject;
				T result = caseLocalTableHeaderAxisConfiguration(localTableHeaderAxisConfiguration);
				if (result == null) result = caseAbstractHeaderAxisConfiguration(localTableHeaderAxisConfiguration);
				if (result == null) result = caseEModelElement(localTableHeaderAxisConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NattableaxisconfigurationPackage.IAXIS_CONFIGURATION: {
				IAxisConfiguration iAxisConfiguration = (IAxisConfiguration)theEObject;
				T result = caseIAxisConfiguration(iAxisConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NattableaxisconfigurationPackage.FEATURE_AXIS_CONFIGURATION: {
				FeatureAxisConfiguration featureAxisConfiguration = (FeatureAxisConfiguration)theEObject;
				T result = caseFeatureAxisConfiguration(featureAxisConfiguration);
				if (result == null) result = caseIAxisConfiguration(featureAxisConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NattableaxisconfigurationPackage.IFILLING_CONFIGURATION: {
				IFillingConfiguration iFillingConfiguration = (IFillingConfiguration)theEObject;
				T result = caseIFillingConfiguration(iFillingConfiguration);
				if (result == null) result = caseIAxisConfiguration(iFillingConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NattableaxisconfigurationPackage.ESTRUCTURAL_FEATURE_VALUE_FILLING_CONFIGURATION: {
				EStructuralFeatureValueFillingConfiguration eStructuralFeatureValueFillingConfiguration = (EStructuralFeatureValueFillingConfiguration)theEObject;
				T result = caseEStructuralFeatureValueFillingConfiguration(eStructuralFeatureValueFillingConfiguration);
				if (result == null) result = caseIFillingConfiguration(eStructuralFeatureValueFillingConfiguration);
				if (result == null) result = caseIAxisConfiguration(eStructuralFeatureValueFillingConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NattableaxisconfigurationPackage.IPASTE_CONFIGURATION: {
				IPasteConfiguration iPasteConfiguration = (IPasteConfiguration)theEObject;
				T result = caseIPasteConfiguration(iPasteConfiguration);
				if (result == null) result = caseIAxisConfiguration(iPasteConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NattableaxisconfigurationPackage.PASTE_EOBJECT_CONFIGURATION: {
				PasteEObjectConfiguration pasteEObjectConfiguration = (PasteEObjectConfiguration)theEObject;
				T result = casePasteEObjectConfiguration(pasteEObjectConfiguration);
				if (result == null) result = caseIPasteConfiguration(pasteEObjectConfiguration);
				if (result == null) result = caseIAxisConfiguration(pasteEObjectConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Header Axis Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Header Axis Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractHeaderAxisConfiguration(AbstractHeaderAxisConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Axis Manager Representation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Axis Manager Representation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAxisManagerRepresentation(AxisManagerRepresentation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Axis Manager Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Axis Manager Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAxisManagerConfiguration(AxisManagerConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Table Header Axis Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Table Header Axis Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTableHeaderAxisConfiguration(TableHeaderAxisConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Local Table Header Axis Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Local Table Header Axis Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLocalTableHeaderAxisConfiguration(LocalTableHeaderAxisConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IAxis Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IAxis Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIAxisConfiguration(IAxisConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Feature Axis Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Feature Axis Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFeatureAxisConfiguration(FeatureAxisConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IFilling Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IFilling Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIFillingConfiguration(IFillingConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EStructural Feature Value Filling Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EStructural Feature Value Filling Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEStructuralFeatureValueFillingConfiguration(EStructuralFeatureValueFillingConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IPaste Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IPaste Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIPasteConfiguration(IPasteConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Paste EObject Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Paste EObject Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePasteEObjectConfiguration(PasteEObjectConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EModel Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EModel Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEModelElement(EModelElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //NattableaxisconfigurationSwitch
