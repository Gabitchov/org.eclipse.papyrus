/*****************************************************************************
 * Copyright (c) 2011 Nicolas Deblock & Cedric Dumoulin & Manuel Giles.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	Nicolas Deblock  nico.deblock@gmail.com  - Meta-model conception
 * 	Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Meta-model conception 
 * 	Manuel Giles	 giles.manu@live.fr		 - Meta-model conception
 *
 *****************************************************************************/

/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.core.Flags;
import org.eclipse.jdt.core.Signature;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTMethod;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTParameter;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTType;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JdtmmPackage;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.util.JdtmmPreference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>JDT Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTParameterImpl#getParameterOwner <em>Parameter Owner</em>}</li>
 *   <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTParameterImpl#isFinal <em>Final</em>}</li>
 *   <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTParameterImpl#isMultiValued <em>Is Multi Valued</em>}</li>
 *   <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTParameterImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTParameterImpl#getReturnOwner <em>Return Owner</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class JDTParameterImpl extends JDTMemberImpl implements JDTParameter {

	/**
	 * The default value of the '{@link #isFinal() <em>Final</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFinal()
	 * @generated
	 * @ordered
	 */
	protected static final boolean FINAL_EDEFAULT = false;

	/**
	 * The default value of the '{@link #isMultiValued() <em>Is Multi Valued</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMultiValued()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_MULTI_VALUED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isMultiValued() <em>Is Multi Valued</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMultiValued()
	 * @generated
	 * @ordered
	 */
	protected boolean isMultiValued = IS_MULTI_VALUED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected JDTType type;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JDTParameterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JdtmmPackage.Literals.JDT_PARAMETER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JDTMethod getParameterOwner() {
		if (eContainerFeatureID() != JdtmmPackage.JDT_PARAMETER__PARAMETER_OWNER) return null;
		return (JDTMethod)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParameterOwner(JDTMethod newParameterOwner, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParameterOwner, JdtmmPackage.JDT_PARAMETER__PARAMETER_OWNER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParameterOwner(JDTMethod newParameterOwner) {
		if (newParameterOwner != eInternalContainer() || (eContainerFeatureID() != JdtmmPackage.JDT_PARAMETER__PARAMETER_OWNER && newParameterOwner != null)) {
			if (EcoreUtil.isAncestor(this, newParameterOwner))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParameterOwner != null)
				msgs = ((InternalEObject)newParameterOwner).eInverseAdd(this, JdtmmPackage.JDT_METHOD__PARAMETERS, JDTMethod.class, msgs);
			msgs = basicSetParameterOwner(newParameterOwner, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JdtmmPackage.JDT_PARAMETER__PARAMETER_OWNER, newParameterOwner, newParameterOwner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isMultiValued() {
		return isMultiValued;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsMultiValued(boolean newIsMultiValued) {
		boolean oldIsMultiValued = isMultiValued;
		isMultiValued = newIsMultiValued;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JdtmmPackage.JDT_PARAMETER__IS_MULTI_VALUED, oldIsMultiValued, isMultiValued));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JDTType getType() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject)type;
			type = (JDTType)eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, JdtmmPackage.JDT_PARAMETER__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JDTType basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(JDTType newType) {
		JDTType oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JdtmmPackage.JDT_PARAMETER__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JDTMethod getReturnOwner() {
		if (eContainerFeatureID() != JdtmmPackage.JDT_PARAMETER__RETURN_OWNER) return null;
		return (JDTMethod)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetReturnOwner(JDTMethod newReturnOwner, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newReturnOwner, JdtmmPackage.JDT_PARAMETER__RETURN_OWNER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReturnOwner(JDTMethod newReturnOwner) {
		if (newReturnOwner != eInternalContainer() || (eContainerFeatureID() != JdtmmPackage.JDT_PARAMETER__RETURN_OWNER && newReturnOwner != null)) {
			if (EcoreUtil.isAncestor(this, newReturnOwner))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newReturnOwner != null)
				msgs = ((InternalEObject)newReturnOwner).eInverseAdd(this, JdtmmPackage.JDT_METHOD__RETURN_TYPE, JDTMethod.class, msgs);
			msgs = basicSetReturnOwner(newReturnOwner, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JdtmmPackage.JDT_PARAMETER__RETURN_OWNER, newReturnOwner, newReturnOwner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case JdtmmPackage.JDT_PARAMETER__PARAMETER_OWNER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParameterOwner((JDTMethod)otherEnd, msgs);
			case JdtmmPackage.JDT_PARAMETER__RETURN_OWNER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetReturnOwner((JDTMethod)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case JdtmmPackage.JDT_PARAMETER__PARAMETER_OWNER:
				return basicSetParameterOwner(null, msgs);
			case JdtmmPackage.JDT_PARAMETER__RETURN_OWNER:
				return basicSetReturnOwner(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case JdtmmPackage.JDT_PARAMETER__PARAMETER_OWNER:
				return eInternalContainer().eInverseRemove(this, JdtmmPackage.JDT_METHOD__PARAMETERS, JDTMethod.class, msgs);
			case JdtmmPackage.JDT_PARAMETER__RETURN_OWNER:
				return eInternalContainer().eInverseRemove(this, JdtmmPackage.JDT_METHOD__RETURN_TYPE, JDTMethod.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case JdtmmPackage.JDT_PARAMETER__PARAMETER_OWNER:
				return getParameterOwner();
			case JdtmmPackage.JDT_PARAMETER__FINAL:
				return isFinal();
			case JdtmmPackage.JDT_PARAMETER__IS_MULTI_VALUED:
				return isMultiValued();
			case JdtmmPackage.JDT_PARAMETER__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case JdtmmPackage.JDT_PARAMETER__RETURN_OWNER:
				return getReturnOwner();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case JdtmmPackage.JDT_PARAMETER__PARAMETER_OWNER:
				setParameterOwner((JDTMethod)newValue);
				return;
			case JdtmmPackage.JDT_PARAMETER__FINAL:
				setFinal((Boolean)newValue);
				return;
			case JdtmmPackage.JDT_PARAMETER__IS_MULTI_VALUED:
				setIsMultiValued((Boolean)newValue);
				return;
			case JdtmmPackage.JDT_PARAMETER__TYPE:
				setType((JDTType)newValue);
				return;
			case JdtmmPackage.JDT_PARAMETER__RETURN_OWNER:
				setReturnOwner((JDTMethod)newValue);
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
	public void eUnset(int featureID) {
		switch (featureID) {
			case JdtmmPackage.JDT_PARAMETER__PARAMETER_OWNER:
				setParameterOwner((JDTMethod)null);
				return;
			case JdtmmPackage.JDT_PARAMETER__FINAL:
				setFinal(FINAL_EDEFAULT);
				return;
			case JdtmmPackage.JDT_PARAMETER__IS_MULTI_VALUED:
				setIsMultiValued(IS_MULTI_VALUED_EDEFAULT);
				return;
			case JdtmmPackage.JDT_PARAMETER__TYPE:
				setType((JDTType)null);
				return;
			case JdtmmPackage.JDT_PARAMETER__RETURN_OWNER:
				setReturnOwner((JDTMethod)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case JdtmmPackage.JDT_PARAMETER__PARAMETER_OWNER:
				return getParameterOwner() != null;
			case JdtmmPackage.JDT_PARAMETER__FINAL:
				return isFinal() != FINAL_EDEFAULT;
			case JdtmmPackage.JDT_PARAMETER__IS_MULTI_VALUED:
				return isMultiValued != IS_MULTI_VALUED_EDEFAULT;
			case JdtmmPackage.JDT_PARAMETER__TYPE:
				return type != null;
			case JdtmmPackage.JDT_PARAMETER__RETURN_OWNER:
				return getReturnOwner() != null;
		}
		return super.eIsSet(featureID);
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
		result.append(" (isMultiValued: ");
		result.append(isMultiValued);
		result.append(')');
		return result.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean isFinal() {
		// TODO: implement this method to return the 'Final' attribute
		// Ensure that you remove @generated or mark it @generated NOT
		return isFlagSet(Flags.AccFinal);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void setFinal(boolean newFinal) {

		setFlag(Flags.AccFinal, newFinal);
	}

	@Override
	public String getJDTSignature() {
		if(this.isMultiValued()) {
			return Signature.createTypeSignature(JdtmmPreference.getMultiValued(type.getElementName()), false);
		}
		return type.getJDTSignature();
	}
} //JDTParameterImpl
