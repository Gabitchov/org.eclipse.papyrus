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
package org.eclipse.papyrus.eastadl.variability.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.papyrus.eastadl.infrastructure.elements.impl.EAElementImpl;
import org.eclipse.papyrus.eastadl.structure.featuremodeling.BindingTime;
import org.eclipse.papyrus.eastadl.variability.ReuseMetaInformation;
import org.eclipse.papyrus.eastadl.variability.VariabilityPackage;
import org.eclipse.papyrus.eastadl.variability.VariableElement;
import org.eclipse.uml2.uml.NamedElement;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variable Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.eastadl.variability.impl.VariableElementImpl#getRequiredBindingTime <em>Required Binding Time</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.variability.impl.VariableElementImpl#getActualBindingTime <em>Actual Binding Time</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.variability.impl.VariableElementImpl#getReuseMetaInformation <em>Reuse Meta Information</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.variability.impl.VariableElementImpl#getOptionalElement <em>Optional Element</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.variability.impl.VariableElementImpl#getBase_Class <em>Base Class</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VariableElementImpl extends EAElementImpl implements VariableElement {
	/**
	 * The cached value of the '{@link #getRequiredBindingTime() <em>Required Binding Time</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequiredBindingTime()
	 * @generated
	 * @ordered
	 */
	protected BindingTime requiredBindingTime;

	/**
	 * The cached value of the '{@link #getActualBindingTime() <em>Actual Binding Time</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActualBindingTime()
	 * @generated
	 * @ordered
	 */
	protected BindingTime actualBindingTime;

	/**
	 * The cached value of the '{@link #getReuseMetaInformation() <em>Reuse Meta Information</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReuseMetaInformation()
	 * @generated
	 * @ordered
	 */
	protected ReuseMetaInformation reuseMetaInformation;

	/**
	 * The cached value of the '{@link #getOptionalElement() <em>Optional Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOptionalElement()
	 * @generated
	 * @ordered
	 */
	protected NamedElement optionalElement;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VariableElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BindingTime basicGetActualBindingTime() {
		return actualBindingTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedElement basicGetOptionalElement() {
		return optionalElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BindingTime basicGetRequiredBindingTime() {
		return requiredBindingTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReuseMetaInformation basicGetReuseMetaInformation() {
		return reuseMetaInformation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case VariabilityPackage.VARIABLE_ELEMENT__REQUIRED_BINDING_TIME:
				if (resolve) return getRequiredBindingTime();
				return basicGetRequiredBindingTime();
			case VariabilityPackage.VARIABLE_ELEMENT__ACTUAL_BINDING_TIME:
				if (resolve) return getActualBindingTime();
				return basicGetActualBindingTime();
			case VariabilityPackage.VARIABLE_ELEMENT__REUSE_META_INFORMATION:
				if (resolve) return getReuseMetaInformation();
				return basicGetReuseMetaInformation();
			case VariabilityPackage.VARIABLE_ELEMENT__OPTIONAL_ELEMENT:
				if (resolve) return getOptionalElement();
				return basicGetOptionalElement();
			case VariabilityPackage.VARIABLE_ELEMENT__BASE_CLASS:
				if (resolve) return getBase_Class();
				return basicGetBase_Class();
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
			case VariabilityPackage.VARIABLE_ELEMENT__REQUIRED_BINDING_TIME:
				return requiredBindingTime != null;
			case VariabilityPackage.VARIABLE_ELEMENT__ACTUAL_BINDING_TIME:
				return actualBindingTime != null;
			case VariabilityPackage.VARIABLE_ELEMENT__REUSE_META_INFORMATION:
				return reuseMetaInformation != null;
			case VariabilityPackage.VARIABLE_ELEMENT__OPTIONAL_ELEMENT:
				return optionalElement != null;
			case VariabilityPackage.VARIABLE_ELEMENT__BASE_CLASS:
				return base_Class != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case VariabilityPackage.VARIABLE_ELEMENT__REQUIRED_BINDING_TIME:
				setRequiredBindingTime((BindingTime)newValue);
				return;
			case VariabilityPackage.VARIABLE_ELEMENT__ACTUAL_BINDING_TIME:
				setActualBindingTime((BindingTime)newValue);
				return;
			case VariabilityPackage.VARIABLE_ELEMENT__REUSE_META_INFORMATION:
				setReuseMetaInformation((ReuseMetaInformation)newValue);
				return;
			case VariabilityPackage.VARIABLE_ELEMENT__OPTIONAL_ELEMENT:
				setOptionalElement((NamedElement)newValue);
				return;
			case VariabilityPackage.VARIABLE_ELEMENT__BASE_CLASS:
				setBase_Class((org.eclipse.uml2.uml.Class)newValue);
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
		return VariabilityPackage.Literals.VARIABLE_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case VariabilityPackage.VARIABLE_ELEMENT__REQUIRED_BINDING_TIME:
				setRequiredBindingTime((BindingTime)null);
				return;
			case VariabilityPackage.VARIABLE_ELEMENT__ACTUAL_BINDING_TIME:
				setActualBindingTime((BindingTime)null);
				return;
			case VariabilityPackage.VARIABLE_ELEMENT__REUSE_META_INFORMATION:
				setReuseMetaInformation((ReuseMetaInformation)null);
				return;
			case VariabilityPackage.VARIABLE_ELEMENT__OPTIONAL_ELEMENT:
				setOptionalElement((NamedElement)null);
				return;
			case VariabilityPackage.VARIABLE_ELEMENT__BASE_CLASS:
				setBase_Class((org.eclipse.uml2.uml.Class)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BindingTime getActualBindingTime() {
		if (actualBindingTime != null && actualBindingTime.eIsProxy()) {
			InternalEObject oldActualBindingTime = (InternalEObject)actualBindingTime;
			actualBindingTime = (BindingTime)eResolveProxy(oldActualBindingTime);
			if (actualBindingTime != oldActualBindingTime) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, VariabilityPackage.VARIABLE_ELEMENT__ACTUAL_BINDING_TIME, oldActualBindingTime, actualBindingTime));
			}
		}
		return actualBindingTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedElement getOptionalElement() {
		if (optionalElement != null && optionalElement.eIsProxy()) {
			InternalEObject oldOptionalElement = (InternalEObject)optionalElement;
			optionalElement = (NamedElement)eResolveProxy(oldOptionalElement);
			if (optionalElement != oldOptionalElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, VariabilityPackage.VARIABLE_ELEMENT__OPTIONAL_ELEMENT, oldOptionalElement, optionalElement));
			}
		}
		return optionalElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BindingTime getRequiredBindingTime() {
		if (requiredBindingTime != null && requiredBindingTime.eIsProxy()) {
			InternalEObject oldRequiredBindingTime = (InternalEObject)requiredBindingTime;
			requiredBindingTime = (BindingTime)eResolveProxy(oldRequiredBindingTime);
			if (requiredBindingTime != oldRequiredBindingTime) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, VariabilityPackage.VARIABLE_ELEMENT__REQUIRED_BINDING_TIME, oldRequiredBindingTime, requiredBindingTime));
			}
		}
		return requiredBindingTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReuseMetaInformation getReuseMetaInformation() {
		if (reuseMetaInformation != null && reuseMetaInformation.eIsProxy()) {
			InternalEObject oldReuseMetaInformation = (InternalEObject)reuseMetaInformation;
			reuseMetaInformation = (ReuseMetaInformation)eResolveProxy(oldReuseMetaInformation);
			if (reuseMetaInformation != oldReuseMetaInformation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, VariabilityPackage.VARIABLE_ELEMENT__REUSE_META_INFORMATION, oldReuseMetaInformation, reuseMetaInformation));
			}
		}
		return reuseMetaInformation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActualBindingTime(BindingTime newActualBindingTime) {
		BindingTime oldActualBindingTime = actualBindingTime;
		actualBindingTime = newActualBindingTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VariabilityPackage.VARIABLE_ELEMENT__ACTUAL_BINDING_TIME, oldActualBindingTime, actualBindingTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOptionalElement(NamedElement newOptionalElement) {
		NamedElement oldOptionalElement = optionalElement;
		optionalElement = newOptionalElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VariabilityPackage.VARIABLE_ELEMENT__OPTIONAL_ELEMENT, oldOptionalElement, optionalElement));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, VariabilityPackage.VARIABLE_ELEMENT__BASE_CLASS, oldBase_Class, base_Class));
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
			eNotify(new ENotificationImpl(this, Notification.SET, VariabilityPackage.VARIABLE_ELEMENT__BASE_CLASS, oldBase_Class, base_Class));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRequiredBindingTime(BindingTime newRequiredBindingTime) {
		BindingTime oldRequiredBindingTime = requiredBindingTime;
		requiredBindingTime = newRequiredBindingTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VariabilityPackage.VARIABLE_ELEMENT__REQUIRED_BINDING_TIME, oldRequiredBindingTime, requiredBindingTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReuseMetaInformation(ReuseMetaInformation newReuseMetaInformation) {
		ReuseMetaInformation oldReuseMetaInformation = reuseMetaInformation;
		reuseMetaInformation = newReuseMetaInformation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VariabilityPackage.VARIABLE_ELEMENT__REUSE_META_INFORMATION, oldReuseMetaInformation, reuseMetaInformation));
	}

} //VariableElementImpl
