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
package org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.util;

import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.*;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableNamedElement;

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
 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.NattableaxisproviderPackage
 * @generated
 */
public class NattableaxisproviderSwitch<T> extends Switch<T> {

	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static NattableaxisproviderPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NattableaxisproviderSwitch() {
		if(modelPackage == null) {
			modelPackage = NattableaxisproviderPackage.eINSTANCE;
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
		case NattableaxisproviderPackage.ABSTRACT_AXIS_PROVIDER:
		{
			AbstractAxisProvider abstractAxisProvider = (AbstractAxisProvider)theEObject;
			T result = caseAbstractAxisProvider(abstractAxisProvider);
			if(result == null)
				result = caseTableNamedElement(abstractAxisProvider);
			if(result == null)
				result = caseEModelElement(abstractAxisProvider);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case NattableaxisproviderPackage.IMASTER_AXIS_PROVIDER:
		{
			IMasterAxisProvider iMasterAxisProvider = (IMasterAxisProvider)theEObject;
			T result = caseIMasterAxisProvider(iMasterAxisProvider);
			if(result == null)
				result = caseAxisProvider(iMasterAxisProvider);
			if(result == null)
				result = caseAbstractAxisProvider(iMasterAxisProvider);
			if(result == null)
				result = caseTableNamedElement(iMasterAxisProvider);
			if(result == null)
				result = caseEModelElement(iMasterAxisProvider);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case NattableaxisproviderPackage.ISLAVE_AXIS_PROVIDER:
		{
			ISlaveAxisProvider iSlaveAxisProvider = (ISlaveAxisProvider)theEObject;
			T result = caseISlaveAxisProvider(iSlaveAxisProvider);
			if(result == null)
				result = caseAxisProvider(iSlaveAxisProvider);
			if(result == null)
				result = caseAbstractAxisProvider(iSlaveAxisProvider);
			if(result == null)
				result = caseTableNamedElement(iSlaveAxisProvider);
			if(result == null)
				result = caseEModelElement(iSlaveAxisProvider);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case NattableaxisproviderPackage.AXIS_PROVIDER:
		{
			AxisProvider axisProvider = (AxisProvider)theEObject;
			T result = caseAxisProvider(axisProvider);
			if(result == null)
				result = caseAbstractAxisProvider(axisProvider);
			if(result == null)
				result = caseTableNamedElement(axisProvider);
			if(result == null)
				result = caseEModelElement(axisProvider);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case NattableaxisproviderPackage.SLAVE_OBJECT_AXIS_PROVIDER:
		{
			SlaveObjectAxisProvider slaveObjectAxisProvider = (SlaveObjectAxisProvider)theEObject;
			T result = caseSlaveObjectAxisProvider(slaveObjectAxisProvider);
			if(result == null)
				result = caseISlaveAxisProvider(slaveObjectAxisProvider);
			if(result == null)
				result = caseAxisProvider(slaveObjectAxisProvider);
			if(result == null)
				result = caseAbstractAxisProvider(slaveObjectAxisProvider);
			if(result == null)
				result = caseTableNamedElement(slaveObjectAxisProvider);
			if(result == null)
				result = caseEModelElement(slaveObjectAxisProvider);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case NattableaxisproviderPackage.MASTER_OBJECT_AXIS_PROVIDER:
		{
			MasterObjectAxisProvider masterObjectAxisProvider = (MasterObjectAxisProvider)theEObject;
			T result = caseMasterObjectAxisProvider(masterObjectAxisProvider);
			if(result == null)
				result = caseIMasterAxisProvider(masterObjectAxisProvider);
			if(result == null)
				result = caseAxisProvider(masterObjectAxisProvider);
			if(result == null)
				result = caseAbstractAxisProvider(masterObjectAxisProvider);
			if(result == null)
				result = caseTableNamedElement(masterObjectAxisProvider);
			if(result == null)
				result = caseEModelElement(masterObjectAxisProvider);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Axis Provider</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Axis Provider</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractAxisProvider(AbstractAxisProvider object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IMaster Axis Provider</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IMaster Axis Provider</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIMasterAxisProvider(IMasterAxisProvider object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ISlave Axis Provider</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ISlave Axis Provider</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseISlaveAxisProvider(ISlaveAxisProvider object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Axis Provider</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Axis Provider</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAxisProvider(AxisProvider object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Slave Object Axis Provider</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Slave Object Axis Provider</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSlaveObjectAxisProvider(SlaveObjectAxisProvider object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Master Object Axis Provider</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Master Object Axis Provider</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMasterObjectAxisProvider(MasterObjectAxisProvider object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EModel Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EModel Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEModelElement(EModelElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Table Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Table Named Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTableNamedElement(TableNamedElement object) {
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

} //NattableaxisproviderSwitch
