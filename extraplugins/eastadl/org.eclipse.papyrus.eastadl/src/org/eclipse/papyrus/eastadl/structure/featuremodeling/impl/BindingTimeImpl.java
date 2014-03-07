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
package org.eclipse.papyrus.eastadl.structure.featuremodeling.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.papyrus.eastadl.infrastructure.elements.impl.EAElementImpl;
import org.eclipse.papyrus.eastadl.structure.featuremodeling.BindingTime;
import org.eclipse.papyrus.eastadl.structure.featuremodeling.BindingTimeKind;
import org.eclipse.papyrus.eastadl.structure.featuremodeling.FeaturemodelingPackage;


/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Binding Time</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.impl.BindingTimeImpl#getKind <em>Kind</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.impl.BindingTimeImpl#getBase_Class <em>Base Class</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class BindingTimeImpl extends EAElementImpl implements BindingTime {

	/**
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final BindingTimeKind KIND_EDEFAULT = BindingTimeKind.SYSTEM_DESIGN_TIME;

	/**
	 * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected BindingTimeKind kind = KIND_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBase_Class() <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getBase_Class()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.uml2.uml.Class base_Class;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected BindingTimeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch(featureID) {
		case FeaturemodelingPackage.BINDING_TIME__KIND:
			return getKind();
		case FeaturemodelingPackage.BINDING_TIME__BASE_CLASS:
			if(resolve)
				return getBase_Class();
			return basicGetBase_Class();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch(featureID) {
		case FeaturemodelingPackage.BINDING_TIME__KIND:
			return kind != KIND_EDEFAULT;
		case FeaturemodelingPackage.BINDING_TIME__BASE_CLASS:
			return base_Class != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch(featureID) {
		case FeaturemodelingPackage.BINDING_TIME__KIND:
			setKind((BindingTimeKind)newValue);
			return;
		case FeaturemodelingPackage.BINDING_TIME__BASE_CLASS:
			setBase_Class((org.eclipse.uml2.uml.Class)newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FeaturemodelingPackage.Literals.BINDING_TIME;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch(featureID) {
		case FeaturemodelingPackage.BINDING_TIME__KIND:
			setKind(KIND_EDEFAULT);
			return;
		case FeaturemodelingPackage.BINDING_TIME__BASE_CLASS:
			setBase_Class((org.eclipse.uml2.uml.Class)null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public BindingTimeKind getKind() {
		return kind;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setKind(BindingTimeKind newKind) {
		BindingTimeKind oldKind = kind;
		kind = newKind == null ? KIND_EDEFAULT : newKind;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FeaturemodelingPackage.BINDING_TIME__KIND, oldKind, kind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public org.eclipse.uml2.uml.Class getBase_Class() {
		if(base_Class != null && base_Class.eIsProxy()) {
			InternalEObject oldBase_Class = (InternalEObject)base_Class;
			base_Class = (org.eclipse.uml2.uml.Class)eResolveProxy(oldBase_Class);
			if(base_Class != oldBase_Class) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FeaturemodelingPackage.BINDING_TIME__BASE_CLASS, oldBase_Class, base_Class));
			}
		}
		return base_Class;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public org.eclipse.uml2.uml.Class basicGetBase_Class() {
		return base_Class;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setBase_Class(org.eclipse.uml2.uml.Class newBase_Class) {
		org.eclipse.uml2.uml.Class oldBase_Class = base_Class;
		base_Class = newBase_Class;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FeaturemodelingPackage.BINDING_TIME__BASE_CLASS, oldBase_Class, base_Class));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if(eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (kind: ");
		result.append(kind);
		result.append(')');
		return result.toString();
	}

} // BindingTimeImpl
