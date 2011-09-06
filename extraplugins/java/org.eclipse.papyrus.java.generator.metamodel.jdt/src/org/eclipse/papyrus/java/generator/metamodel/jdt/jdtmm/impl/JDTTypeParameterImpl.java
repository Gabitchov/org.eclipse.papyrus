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

import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTMember;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTTypeParameter;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JdtmmPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>JDT Type Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTTypeParameterImpl#getDeclaringMember <em>Declaring Member</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class JDTTypeParameterImpl extends JDTJavaElementImpl implements JDTTypeParameter {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected JDTTypeParameterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JdtmmPackage.Literals.JDT_TYPE_PARAMETER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public JDTMember getDeclaringMember() {
		if(eContainerFeatureID() != JdtmmPackage.JDT_TYPE_PARAMETER__DECLARING_MEMBER)
			return null;
		return (JDTMember)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetDeclaringMember(JDTMember newDeclaringMember, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newDeclaringMember, JdtmmPackage.JDT_TYPE_PARAMETER__DECLARING_MEMBER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setDeclaringMember(JDTMember newDeclaringMember) {
		if(newDeclaringMember != eInternalContainer() || (eContainerFeatureID() != JdtmmPackage.JDT_TYPE_PARAMETER__DECLARING_MEMBER && newDeclaringMember != null)) {
			if(EcoreUtil.isAncestor(this, newDeclaringMember))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if(eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if(newDeclaringMember != null)
				msgs = ((InternalEObject)newDeclaringMember).eInverseAdd(this, JdtmmPackage.JDT_MEMBER__TYPE_PARAMETERS, JDTMember.class, msgs);
			msgs = basicSetDeclaringMember(newDeclaringMember, msgs);
			if(msgs != null)
				msgs.dispatch();
		}
		else if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JdtmmPackage.JDT_TYPE_PARAMETER__DECLARING_MEMBER, newDeclaringMember, newDeclaringMember));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch(featureID) {
		case JdtmmPackage.JDT_TYPE_PARAMETER__DECLARING_MEMBER:
			if(eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetDeclaringMember((JDTMember)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch(featureID) {
		case JdtmmPackage.JDT_TYPE_PARAMETER__DECLARING_MEMBER:
			return basicSetDeclaringMember(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch(eContainerFeatureID()) {
		case JdtmmPackage.JDT_TYPE_PARAMETER__DECLARING_MEMBER:
			return eInternalContainer().eInverseRemove(this, JdtmmPackage.JDT_MEMBER__TYPE_PARAMETERS, JDTMember.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
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
		case JdtmmPackage.JDT_TYPE_PARAMETER__DECLARING_MEMBER:
			return getDeclaringMember();
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
	public void eSet(int featureID, Object newValue) {
		switch(featureID) {
		case JdtmmPackage.JDT_TYPE_PARAMETER__DECLARING_MEMBER:
			setDeclaringMember((JDTMember)newValue);
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
	public void eUnset(int featureID) {
		switch(featureID) {
		case JdtmmPackage.JDT_TYPE_PARAMETER__DECLARING_MEMBER:
			setDeclaringMember((JDTMember)null);
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
	@Override
	public boolean eIsSet(int featureID) {
		switch(featureID) {
		case JdtmmPackage.JDT_TYPE_PARAMETER__DECLARING_MEMBER:
			return getDeclaringMember() != null;
		}
		return super.eIsSet(featureID);
	}

} //JDTTypeParameterImpl
