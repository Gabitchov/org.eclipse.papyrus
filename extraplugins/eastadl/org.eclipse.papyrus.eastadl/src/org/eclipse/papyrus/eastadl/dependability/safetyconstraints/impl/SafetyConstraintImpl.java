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
package org.eclipse.papyrus.eastadl.dependability.safetyconstraints.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.papyrus.eastadl.dependability.safetyconstraints.ASILKind;
import org.eclipse.papyrus.eastadl.dependability.safetyconstraints.FaultFailure;
import org.eclipse.papyrus.eastadl.dependability.safetyconstraints.SafetyConstraint;
import org.eclipse.papyrus.eastadl.dependability.safetyconstraints.SafetyconstraintsPackage;
import org.eclipse.papyrus.eastadl.infrastructure.elements.impl.TraceableSpecificationImpl;
import org.eclipse.uml2.uml.Constraint;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Safety Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.safetyconstraints.impl.SafetyConstraintImpl#getAsilValue <em>Asil Value</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.safetyconstraints.impl.SafetyConstraintImpl#getConstrainedFaultFailure <em>Constrained Fault Failure</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.safetyconstraints.impl.SafetyConstraintImpl#getBase_Class <em>Base Class</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.safetyconstraints.impl.SafetyConstraintImpl#getBase_Constraint <em>Base Constraint</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SafetyConstraintImpl extends TraceableSpecificationImpl implements SafetyConstraint {
	/**
	 * The default value of the '{@link #getAsilValue() <em>Asil Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAsilValue()
	 * @generated
	 * @ordered
	 */
	protected static final ASILKind ASIL_VALUE_EDEFAULT = ASILKind.ASIL_A;

	/**
	 * The cached value of the '{@link #getAsilValue() <em>Asil Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAsilValue()
	 * @generated
	 * @ordered
	 */
	protected ASILKind asilValue = ASIL_VALUE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getConstrainedFaultFailure() <em>Constrained Fault Failure</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstrainedFaultFailure()
	 * @generated
	 * @ordered
	 */
	protected EList<FaultFailure> constrainedFaultFailure;

	/**
	 * The cached value of the '{@link #getBase_Class() <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Class()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.uml2.uml.Class base_Class;

	/**
	 * The cached value of the '{@link #getBase_Constraint() <em>Base Constraint</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Constraint()
	 * @generated
	 * @ordered
	 */
	protected Constraint base_Constraint;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SafetyConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SafetyconstraintsPackage.SAFETY_CONSTRAINT__ASIL_VALUE:
				return getAsilValue();
			case SafetyconstraintsPackage.SAFETY_CONSTRAINT__CONSTRAINED_FAULT_FAILURE:
				return getConstrainedFaultFailure();
			case SafetyconstraintsPackage.SAFETY_CONSTRAINT__BASE_CLASS:
				if (resolve) return getBase_Class();
				return basicGetBase_Class();
			case SafetyconstraintsPackage.SAFETY_CONSTRAINT__BASE_CONSTRAINT:
				if (resolve) return getBase_Constraint();
				return basicGetBase_Constraint();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SafetyconstraintsPackage.SAFETY_CONSTRAINT__ASIL_VALUE:
				return asilValue != ASIL_VALUE_EDEFAULT;
			case SafetyconstraintsPackage.SAFETY_CONSTRAINT__CONSTRAINED_FAULT_FAILURE:
				return constrainedFaultFailure != null && !constrainedFaultFailure.isEmpty();
			case SafetyconstraintsPackage.SAFETY_CONSTRAINT__BASE_CLASS:
				return base_Class != null;
			case SafetyconstraintsPackage.SAFETY_CONSTRAINT__BASE_CONSTRAINT:
				return base_Constraint != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SafetyconstraintsPackage.SAFETY_CONSTRAINT__ASIL_VALUE:
				setAsilValue((ASILKind)newValue);
				return;
			case SafetyconstraintsPackage.SAFETY_CONSTRAINT__CONSTRAINED_FAULT_FAILURE:
				getConstrainedFaultFailure().clear();
				getConstrainedFaultFailure().addAll((Collection<? extends FaultFailure>)newValue);
				return;
			case SafetyconstraintsPackage.SAFETY_CONSTRAINT__BASE_CLASS:
				setBase_Class((org.eclipse.uml2.uml.Class)newValue);
				return;
			case SafetyconstraintsPackage.SAFETY_CONSTRAINT__BASE_CONSTRAINT:
				setBase_Constraint((Constraint)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SafetyconstraintsPackage.Literals.SAFETY_CONSTRAINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case SafetyconstraintsPackage.SAFETY_CONSTRAINT__ASIL_VALUE:
				setAsilValue(ASIL_VALUE_EDEFAULT);
				return;
			case SafetyconstraintsPackage.SAFETY_CONSTRAINT__CONSTRAINED_FAULT_FAILURE:
				getConstrainedFaultFailure().clear();
				return;
			case SafetyconstraintsPackage.SAFETY_CONSTRAINT__BASE_CLASS:
				setBase_Class((org.eclipse.uml2.uml.Class)null);
				return;
			case SafetyconstraintsPackage.SAFETY_CONSTRAINT__BASE_CONSTRAINT:
				setBase_Constraint((Constraint)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ASILKind getAsilValue() {
		return asilValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAsilValue(ASILKind newAsilValue) {
		ASILKind oldAsilValue = asilValue;
		asilValue = newAsilValue == null ? ASIL_VALUE_EDEFAULT : newAsilValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SafetyconstraintsPackage.SAFETY_CONSTRAINT__ASIL_VALUE, oldAsilValue, asilValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FaultFailure> getConstrainedFaultFailure() {
		if (constrainedFaultFailure == null) {
			constrainedFaultFailure = new EObjectResolvingEList<FaultFailure>(FaultFailure.class, this, SafetyconstraintsPackage.SAFETY_CONSTRAINT__CONSTRAINED_FAULT_FAILURE);
		}
		return constrainedFaultFailure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Class getBase_Class() {
		if (base_Class != null && base_Class.eIsProxy()) {
			InternalEObject oldBase_Class = (InternalEObject)base_Class;
			base_Class = (org.eclipse.uml2.uml.Class)eResolveProxy(oldBase_Class);
			if (base_Class != oldBase_Class) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SafetyconstraintsPackage.SAFETY_CONSTRAINT__BASE_CLASS, oldBase_Class, base_Class));
			}
		}
		return base_Class;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Class basicGetBase_Class() {
		return base_Class;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Class(org.eclipse.uml2.uml.Class newBase_Class) {
		org.eclipse.uml2.uml.Class oldBase_Class = base_Class;
		base_Class = newBase_Class;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SafetyconstraintsPackage.SAFETY_CONSTRAINT__BASE_CLASS, oldBase_Class, base_Class));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Constraint getBase_Constraint() {
		if (base_Constraint != null && base_Constraint.eIsProxy()) {
			InternalEObject oldBase_Constraint = (InternalEObject)base_Constraint;
			base_Constraint = (Constraint)eResolveProxy(oldBase_Constraint);
			if (base_Constraint != oldBase_Constraint) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SafetyconstraintsPackage.SAFETY_CONSTRAINT__BASE_CONSTRAINT, oldBase_Constraint, base_Constraint));
			}
		}
		return base_Constraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Constraint basicGetBase_Constraint() {
		return base_Constraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Constraint(Constraint newBase_Constraint) {
		Constraint oldBase_Constraint = base_Constraint;
		base_Constraint = newBase_Constraint;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SafetyconstraintsPackage.SAFETY_CONSTRAINT__BASE_CONSTRAINT, oldBase_Constraint, base_Constraint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (asilValue: ");
		result.append(asilValue);
		result.append(')');
		return result.toString();
	}

} //SafetyConstraintImpl
