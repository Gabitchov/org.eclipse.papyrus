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
import org.eclipse.papyrus.eastadl.infrastructure.elements.impl.TraceableSpecificationImpl;
import org.eclipse.papyrus.eastadl.variability.ReuseMetaInformation;
import org.eclipse.papyrus.eastadl.variability.VariabilityPackage;


/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Reuse Meta Information</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.variability.impl.ReuseMetaInformationImpl#getInformation <em>Information</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.variability.impl.ReuseMetaInformationImpl#isIsReusable <em>Is Reusable</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.variability.impl.ReuseMetaInformationImpl#getBase_Class <em>Base Class</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ReuseMetaInformationImpl extends TraceableSpecificationImpl implements ReuseMetaInformation {

	/**
	 * The default value of the '{@link #getInformation() <em>Information</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getInformation()
	 * @generated
	 * @ordered
	 */
	protected static final String INFORMATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInformation() <em>Information</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getInformation()
	 * @generated
	 * @ordered
	 */
	protected String information = INFORMATION_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsReusable() <em>Is Reusable</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isIsReusable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_REUSABLE_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isIsReusable() <em>Is Reusable</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isIsReusable()
	 * @generated
	 * @ordered
	 */
	protected boolean isReusable = IS_REUSABLE_EDEFAULT;

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
	protected ReuseMetaInformationImpl() {
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
		case VariabilityPackage.REUSE_META_INFORMATION__INFORMATION:
			return getInformation();
		case VariabilityPackage.REUSE_META_INFORMATION__IS_REUSABLE:
			return isIsReusable();
		case VariabilityPackage.REUSE_META_INFORMATION__BASE_CLASS:
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
		case VariabilityPackage.REUSE_META_INFORMATION__INFORMATION:
			return INFORMATION_EDEFAULT == null ? information != null : !INFORMATION_EDEFAULT.equals(information);
		case VariabilityPackage.REUSE_META_INFORMATION__IS_REUSABLE:
			return isReusable != IS_REUSABLE_EDEFAULT;
		case VariabilityPackage.REUSE_META_INFORMATION__BASE_CLASS:
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
		case VariabilityPackage.REUSE_META_INFORMATION__INFORMATION:
			setInformation((String)newValue);
			return;
		case VariabilityPackage.REUSE_META_INFORMATION__IS_REUSABLE:
			setIsReusable((Boolean)newValue);
			return;
		case VariabilityPackage.REUSE_META_INFORMATION__BASE_CLASS:
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
		return VariabilityPackage.Literals.REUSE_META_INFORMATION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch(featureID) {
		case VariabilityPackage.REUSE_META_INFORMATION__INFORMATION:
			setInformation(INFORMATION_EDEFAULT);
			return;
		case VariabilityPackage.REUSE_META_INFORMATION__IS_REUSABLE:
			setIsReusable(IS_REUSABLE_EDEFAULT);
			return;
		case VariabilityPackage.REUSE_META_INFORMATION__BASE_CLASS:
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
	public String getInformation() {
		return information;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isIsReusable() {
		return isReusable;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setInformation(String newInformation) {
		String oldInformation = information;
		information = newInformation;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VariabilityPackage.REUSE_META_INFORMATION__INFORMATION, oldInformation, information));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setIsReusable(boolean newIsReusable) {
		boolean oldIsReusable = isReusable;
		isReusable = newIsReusable;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VariabilityPackage.REUSE_META_INFORMATION__IS_REUSABLE, oldIsReusable, isReusable));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, VariabilityPackage.REUSE_META_INFORMATION__BASE_CLASS, oldBase_Class, base_Class));
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
			eNotify(new ENotificationImpl(this, Notification.SET, VariabilityPackage.REUSE_META_INFORMATION__BASE_CLASS, oldBase_Class, base_Class));
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
		result.append(" (information: ");
		result.append(information);
		result.append(", isReusable: ");
		result.append(isReusable);
		result.append(')');
		return result.toString();
	}

} // ReuseMetaInformationImpl
