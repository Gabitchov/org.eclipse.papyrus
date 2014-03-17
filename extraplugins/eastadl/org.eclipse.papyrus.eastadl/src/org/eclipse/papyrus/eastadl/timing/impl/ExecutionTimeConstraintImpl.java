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
package org.eclipse.papyrus.eastadl.timing.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.DesignFunctionPrototype;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.DesignFunctionType;
import org.eclipse.papyrus.eastadl.timing.ExecutionTimeConstraint;
import org.eclipse.papyrus.eastadl.timing.TimeDuration;
import org.eclipse.papyrus.eastadl.timing.TimingPackage;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Execution Time Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.timing.impl.ExecutionTimeConstraintImpl#getVariation <em>Variation</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.timing.impl.ExecutionTimeConstraintImpl#getTargetDesignFunctionType <em>Target Design Function Type</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.timing.impl.ExecutionTimeConstraintImpl#getTargetDesignFunction <em>Target Design Function</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.timing.impl.ExecutionTimeConstraintImpl#getTargetDesignFunctionPrototype <em>Target Design Function
 * Prototype</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ExecutionTimeConstraintImpl extends TimingConstraintImpl implements ExecutionTimeConstraint {

	/**
	 * The cached value of the '{@link #getVariation() <em>Variation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getVariation()
	 * @generated
	 * @ordered
	 */
	protected TimeDuration variation;

	/**
	 * The cached value of the '{@link #getTargetDesignFunctionType() <em>Target Design Function Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getTargetDesignFunctionType()
	 * @generated
	 * @ordered
	 */
	protected DesignFunctionType targetDesignFunctionType;

	/**
	 * The cached value of the '{@link #getTargetDesignFunction() <em>Target Design Function</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getTargetDesignFunction()
	 * @generated
	 * @ordered
	 */
	protected DesignFunctionType targetDesignFunction;

	/**
	 * The cached value of the '{@link #getTargetDesignFunctionPrototype() <em>Target Design Function Prototype</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getTargetDesignFunctionPrototype()
	 * @generated
	 * @ordered
	 */
	protected DesignFunctionPrototype targetDesignFunctionPrototype;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ExecutionTimeConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DesignFunctionType basicGetTargetDesignFunctionType() {
		return targetDesignFunctionType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public TimeDuration basicGetVariation() {
		return variation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch(featureID) {
		case TimingPackage.EXECUTION_TIME_CONSTRAINT__VARIATION:
			if(resolve)
				return getVariation();
			return basicGetVariation();
		case TimingPackage.EXECUTION_TIME_CONSTRAINT__TARGET_DESIGN_FUNCTION_TYPE:
			if(resolve)
				return getTargetDesignFunctionType();
			return basicGetTargetDesignFunctionType();
		case TimingPackage.EXECUTION_TIME_CONSTRAINT__TARGET_DESIGN_FUNCTION:
			if(resolve)
				return getTargetDesignFunction();
			return basicGetTargetDesignFunction();
		case TimingPackage.EXECUTION_TIME_CONSTRAINT__TARGET_DESIGN_FUNCTION_PROTOTYPE:
			if(resolve)
				return getTargetDesignFunctionPrototype();
			return basicGetTargetDesignFunctionPrototype();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch(featureID) {
		case TimingPackage.EXECUTION_TIME_CONSTRAINT__VARIATION:
			return variation != null;
		case TimingPackage.EXECUTION_TIME_CONSTRAINT__TARGET_DESIGN_FUNCTION_TYPE:
			return targetDesignFunctionType != null;
		case TimingPackage.EXECUTION_TIME_CONSTRAINT__TARGET_DESIGN_FUNCTION:
			return targetDesignFunction != null;
		case TimingPackage.EXECUTION_TIME_CONSTRAINT__TARGET_DESIGN_FUNCTION_PROTOTYPE:
			return targetDesignFunctionPrototype != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch(featureID) {
		case TimingPackage.EXECUTION_TIME_CONSTRAINT__VARIATION:
			setVariation((TimeDuration)newValue);
			return;
		case TimingPackage.EXECUTION_TIME_CONSTRAINT__TARGET_DESIGN_FUNCTION_TYPE:
			setTargetDesignFunctionType((DesignFunctionType)newValue);
			return;
		case TimingPackage.EXECUTION_TIME_CONSTRAINT__TARGET_DESIGN_FUNCTION:
			setTargetDesignFunction((DesignFunctionType)newValue);
			return;
		case TimingPackage.EXECUTION_TIME_CONSTRAINT__TARGET_DESIGN_FUNCTION_PROTOTYPE:
			setTargetDesignFunctionPrototype((DesignFunctionPrototype)newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TimingPackage.Literals.EXECUTION_TIME_CONSTRAINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch(featureID) {
		case TimingPackage.EXECUTION_TIME_CONSTRAINT__VARIATION:
			setVariation((TimeDuration)null);
			return;
		case TimingPackage.EXECUTION_TIME_CONSTRAINT__TARGET_DESIGN_FUNCTION_TYPE:
			setTargetDesignFunctionType((DesignFunctionType)null);
			return;
		case TimingPackage.EXECUTION_TIME_CONSTRAINT__TARGET_DESIGN_FUNCTION:
			setTargetDesignFunction((DesignFunctionType)null);
			return;
		case TimingPackage.EXECUTION_TIME_CONSTRAINT__TARGET_DESIGN_FUNCTION_PROTOTYPE:
			setTargetDesignFunctionPrototype((DesignFunctionPrototype)null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DesignFunctionType getTargetDesignFunctionType() {
		if(targetDesignFunctionType != null && targetDesignFunctionType.eIsProxy()) {
			InternalEObject oldTargetDesignFunctionType = (InternalEObject)targetDesignFunctionType;
			targetDesignFunctionType = (DesignFunctionType)eResolveProxy(oldTargetDesignFunctionType);
			if(targetDesignFunctionType != oldTargetDesignFunctionType) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TimingPackage.EXECUTION_TIME_CONSTRAINT__TARGET_DESIGN_FUNCTION_TYPE, oldTargetDesignFunctionType, targetDesignFunctionType));
			}
		}
		return targetDesignFunctionType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public TimeDuration getVariation() {
		if(variation != null && variation.eIsProxy()) {
			InternalEObject oldVariation = (InternalEObject)variation;
			variation = (TimeDuration)eResolveProxy(oldVariation);
			if(variation != oldVariation) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TimingPackage.EXECUTION_TIME_CONSTRAINT__VARIATION, oldVariation, variation));
			}
		}
		return variation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setTargetDesignFunctionType(DesignFunctionType newTargetDesignFunctionType) {
		DesignFunctionType oldTargetDesignFunctionType = targetDesignFunctionType;
		targetDesignFunctionType = newTargetDesignFunctionType;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TimingPackage.EXECUTION_TIME_CONSTRAINT__TARGET_DESIGN_FUNCTION_TYPE, oldTargetDesignFunctionType, targetDesignFunctionType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DesignFunctionType getTargetDesignFunction() {
		if(targetDesignFunction != null && targetDesignFunction.eIsProxy()) {
			InternalEObject oldTargetDesignFunction = (InternalEObject)targetDesignFunction;
			targetDesignFunction = (DesignFunctionType)eResolveProxy(oldTargetDesignFunction);
			if(targetDesignFunction != oldTargetDesignFunction) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TimingPackage.EXECUTION_TIME_CONSTRAINT__TARGET_DESIGN_FUNCTION, oldTargetDesignFunction, targetDesignFunction));
			}
		}
		return targetDesignFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DesignFunctionType basicGetTargetDesignFunction() {
		return targetDesignFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setTargetDesignFunction(DesignFunctionType newTargetDesignFunction) {
		DesignFunctionType oldTargetDesignFunction = targetDesignFunction;
		targetDesignFunction = newTargetDesignFunction;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TimingPackage.EXECUTION_TIME_CONSTRAINT__TARGET_DESIGN_FUNCTION, oldTargetDesignFunction, targetDesignFunction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DesignFunctionPrototype getTargetDesignFunctionPrototype() {
		if(targetDesignFunctionPrototype != null && targetDesignFunctionPrototype.eIsProxy()) {
			InternalEObject oldTargetDesignFunctionPrototype = (InternalEObject)targetDesignFunctionPrototype;
			targetDesignFunctionPrototype = (DesignFunctionPrototype)eResolveProxy(oldTargetDesignFunctionPrototype);
			if(targetDesignFunctionPrototype != oldTargetDesignFunctionPrototype) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TimingPackage.EXECUTION_TIME_CONSTRAINT__TARGET_DESIGN_FUNCTION_PROTOTYPE, oldTargetDesignFunctionPrototype, targetDesignFunctionPrototype));
			}
		}
		return targetDesignFunctionPrototype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DesignFunctionPrototype basicGetTargetDesignFunctionPrototype() {
		return targetDesignFunctionPrototype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setTargetDesignFunctionPrototype(DesignFunctionPrototype newTargetDesignFunctionPrototype) {
		DesignFunctionPrototype oldTargetDesignFunctionPrototype = targetDesignFunctionPrototype;
		targetDesignFunctionPrototype = newTargetDesignFunctionPrototype;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TimingPackage.EXECUTION_TIME_CONSTRAINT__TARGET_DESIGN_FUNCTION_PROTOTYPE, oldTargetDesignFunctionPrototype, targetDesignFunctionPrototype));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setVariation(TimeDuration newVariation) {
		TimeDuration oldVariation = variation;
		variation = newVariation;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TimingPackage.EXECUTION_TIME_CONSTRAINT__VARIATION, oldVariation, variation));
	}

} //ExecutionTimeConstraintImpl
