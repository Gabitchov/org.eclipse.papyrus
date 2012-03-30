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

import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTField;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTParent;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTType;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JdtmmPackage;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.TrueFalseDefault;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>JDT Field</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTFieldImpl#isAbstract <em>Abstract</em>}</li>
 *   <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTFieldImpl#isFinal <em>Final</em>}</li>
 *   <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTFieldImpl#isStatic <em>Static</em>}</li>
 *   <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTFieldImpl#isMultiValued <em>Is Multi Valued</em>}</li>
 *   <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTFieldImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTFieldImpl#getValue <em>Value</em>}</li>
 *   <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTFieldImpl#getGenerateGetter <em>Generate Getter</em>}</li>
 *   <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTFieldImpl#getGenerateSetter <em>Generate Setter</em>}</li>
 *   <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JDTFieldImpl#getOwner <em>Owner</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class JDTFieldImpl extends JDTMemberImpl implements JDTField {

	/**
	 * The default value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAbstract()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ABSTRACT_EDEFAULT = false;

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
	 * The default value of the '{@link #isStatic() <em>Static</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isStatic()
	 * @generated
	 * @ordered
	 */
	protected static final boolean STATIC_EDEFAULT = false;

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
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final String VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected String value = VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getGenerateGetter() <em>Generate Getter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGenerateGetter()
	 * @generated
	 * @ordered
	 */
	protected static final TrueFalseDefault GENERATE_GETTER_EDEFAULT = TrueFalseDefault.TRUE;

	/**
	 * The cached value of the '{@link #getGenerateGetter() <em>Generate Getter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGenerateGetter()
	 * @generated
	 * @ordered
	 */
	protected TrueFalseDefault generateGetter = GENERATE_GETTER_EDEFAULT;

	/**
	 * The default value of the '{@link #getGenerateSetter() <em>Generate Setter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGenerateSetter()
	 * @generated
	 * @ordered
	 */
	protected static final TrueFalseDefault GENERATE_SETTER_EDEFAULT = TrueFalseDefault.TRUE;

	/**
	 * The cached value of the '{@link #getGenerateSetter() <em>Generate Setter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGenerateSetter()
	 * @generated
	 * @ordered
	 */
	protected TrueFalseDefault generateSetter = GENERATE_SETTER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JDTFieldImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JdtmmPackage.Literals.JDT_FIELD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JDTType getOwner() {
		if (eContainerFeatureID() != JdtmmPackage.JDT_FIELD__OWNER) return null;
		return (JDTType)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwner(JDTType newOwner, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwner, JdtmmPackage.JDT_FIELD__OWNER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwner(JDTType newOwner) {
		if (newOwner != eInternalContainer() || (eContainerFeatureID() != JdtmmPackage.JDT_FIELD__OWNER && newOwner != null)) {
			if (EcoreUtil.isAncestor(this, newOwner))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwner != null)
				msgs = ((InternalEObject)newOwner).eInverseAdd(this, JdtmmPackage.JDT_TYPE__FIELDS, JDTType.class, msgs);
			msgs = basicSetOwner(newOwner, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JdtmmPackage.JDT_FIELD__OWNER, newOwner, newOwner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetOwner() {
		return getOwner() != null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAbstract() {
		// TODO: implement this method to return the 'Abstract' attribute
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
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
			eNotify(new ENotificationImpl(this, Notification.SET, JdtmmPackage.JDT_FIELD__IS_MULTI_VALUED, oldIsMultiValued, isMultiValued));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, JdtmmPackage.JDT_FIELD__TYPE, oldType, type));
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
			eNotify(new ENotificationImpl(this, Notification.SET, JdtmmPackage.JDT_FIELD__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(String newValue) {
		String oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JdtmmPackage.JDT_FIELD__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TrueFalseDefault getGenerateGetter() {
		return generateGetter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGenerateGetter(TrueFalseDefault newGenerateGetter) {
		TrueFalseDefault oldGenerateGetter = generateGetter;
		generateGetter = newGenerateGetter == null ? GENERATE_GETTER_EDEFAULT : newGenerateGetter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JdtmmPackage.JDT_FIELD__GENERATE_GETTER, oldGenerateGetter, generateGetter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TrueFalseDefault getGenerateSetter() {
		return generateSetter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGenerateSetter(TrueFalseDefault newGenerateSetter) {
		TrueFalseDefault oldGenerateSetter = generateSetter;
		generateSetter = newGenerateSetter == null ? GENERATE_SETTER_EDEFAULT : newGenerateSetter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JdtmmPackage.JDT_FIELD__GENERATE_SETTER, oldGenerateSetter, generateSetter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case JdtmmPackage.JDT_FIELD__OWNER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwner((JDTType)otherEnd, msgs);
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
			case JdtmmPackage.JDT_FIELD__OWNER:
				return basicSetOwner(null, msgs);
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
			case JdtmmPackage.JDT_FIELD__OWNER:
				return eInternalContainer().eInverseRemove(this, JdtmmPackage.JDT_TYPE__FIELDS, JDTType.class, msgs);
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
			case JdtmmPackage.JDT_FIELD__ABSTRACT:
				return isAbstract();
			case JdtmmPackage.JDT_FIELD__FINAL:
				return isFinal();
			case JdtmmPackage.JDT_FIELD__STATIC:
				return isStatic();
			case JdtmmPackage.JDT_FIELD__IS_MULTI_VALUED:
				return isMultiValued();
			case JdtmmPackage.JDT_FIELD__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case JdtmmPackage.JDT_FIELD__VALUE:
				return getValue();
			case JdtmmPackage.JDT_FIELD__GENERATE_GETTER:
				return getGenerateGetter();
			case JdtmmPackage.JDT_FIELD__GENERATE_SETTER:
				return getGenerateSetter();
			case JdtmmPackage.JDT_FIELD__OWNER:
				return getOwner();
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
			case JdtmmPackage.JDT_FIELD__ABSTRACT:
				setAbstract((Boolean)newValue);
				return;
			case JdtmmPackage.JDT_FIELD__FINAL:
				setFinal((Boolean)newValue);
				return;
			case JdtmmPackage.JDT_FIELD__STATIC:
				setStatic((Boolean)newValue);
				return;
			case JdtmmPackage.JDT_FIELD__IS_MULTI_VALUED:
				setIsMultiValued((Boolean)newValue);
				return;
			case JdtmmPackage.JDT_FIELD__TYPE:
				setType((JDTType)newValue);
				return;
			case JdtmmPackage.JDT_FIELD__VALUE:
				setValue((String)newValue);
				return;
			case JdtmmPackage.JDT_FIELD__GENERATE_GETTER:
				setGenerateGetter((TrueFalseDefault)newValue);
				return;
			case JdtmmPackage.JDT_FIELD__GENERATE_SETTER:
				setGenerateSetter((TrueFalseDefault)newValue);
				return;
			case JdtmmPackage.JDT_FIELD__OWNER:
				setOwner((JDTType)newValue);
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
			case JdtmmPackage.JDT_FIELD__ABSTRACT:
				setAbstract(ABSTRACT_EDEFAULT);
				return;
			case JdtmmPackage.JDT_FIELD__FINAL:
				setFinal(FINAL_EDEFAULT);
				return;
			case JdtmmPackage.JDT_FIELD__STATIC:
				setStatic(STATIC_EDEFAULT);
				return;
			case JdtmmPackage.JDT_FIELD__IS_MULTI_VALUED:
				setIsMultiValued(IS_MULTI_VALUED_EDEFAULT);
				return;
			case JdtmmPackage.JDT_FIELD__TYPE:
				setType((JDTType)null);
				return;
			case JdtmmPackage.JDT_FIELD__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
			case JdtmmPackage.JDT_FIELD__GENERATE_GETTER:
				setGenerateGetter(GENERATE_GETTER_EDEFAULT);
				return;
			case JdtmmPackage.JDT_FIELD__GENERATE_SETTER:
				setGenerateSetter(GENERATE_SETTER_EDEFAULT);
				return;
			case JdtmmPackage.JDT_FIELD__OWNER:
				setOwner((JDTType)null);
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
			case JdtmmPackage.JDT_FIELD__ABSTRACT:
				return isAbstract() != ABSTRACT_EDEFAULT;
			case JdtmmPackage.JDT_FIELD__FINAL:
				return isFinal() != FINAL_EDEFAULT;
			case JdtmmPackage.JDT_FIELD__STATIC:
				return isStatic() != STATIC_EDEFAULT;
			case JdtmmPackage.JDT_FIELD__IS_MULTI_VALUED:
				return isMultiValued != IS_MULTI_VALUED_EDEFAULT;
			case JdtmmPackage.JDT_FIELD__TYPE:
				return type != null;
			case JdtmmPackage.JDT_FIELD__VALUE:
				return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
			case JdtmmPackage.JDT_FIELD__GENERATE_GETTER:
				return generateGetter != GENERATE_GETTER_EDEFAULT;
			case JdtmmPackage.JDT_FIELD__GENERATE_SETTER:
				return generateSetter != GENERATE_SETTER_EDEFAULT;
			case JdtmmPackage.JDT_FIELD__OWNER:
				return isSetOwner();
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
		result.append(", value: ");
		result.append(value);
		result.append(", generateGetter: ");
		result.append(generateGetter);
		result.append(", generateSetter: ");
		result.append(generateSetter);
		result.append(')');
		return result.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public JDTParent getParent() {
		return getOwner();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public JDTParent basicGetParent() {
		return getOwner();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetParent() {
  		return false;
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
	public boolean isStatic() {
		return isFlagSet(Flags.AccStatic);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void setAbstract(boolean newAbstract) {
		// Ensure that you remove @generated or mark it @generated NOT
		setFlag(Flags.AccAbstract, newAbstract);
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

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void setStatic(boolean newStatic) {
		setFlag(Flags.AccStatic, newStatic);
	}

} //JDTFieldImpl
