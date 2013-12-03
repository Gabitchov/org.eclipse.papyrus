/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.facade.virtualmetamodel.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.papyrus.facade.virtualmetamodel.VirtualElement;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualmetamodelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Virtual Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.facade.virtualmetamodel.impl.VirtualElementImpl#getAliasName <em>Alias Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.facade.virtualmetamodel.impl.VirtualElementImpl#isKept <em>Kept</em>}</li>
 *   <li>{@link org.eclipse.papyrus.facade.virtualmetamodel.impl.VirtualElementImpl#getRepresentedElement <em>Represented Element</em>}</li>
 *   <li>{@link org.eclipse.papyrus.facade.virtualmetamodel.impl.VirtualElementImpl#isUseRepresented <em>Use Represented</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class VirtualElementImpl extends MinimalEObjectImpl.Container implements VirtualElement {
	/**
	 * The default value of the '{@link #getAliasName() <em>Alias Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAliasName()
	 * @generated
	 * @ordered
	 */
	protected static final String ALIAS_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAliasName() <em>Alias Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAliasName()
	 * @generated
	 * @ordered
	 */
	protected String aliasName = ALIAS_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #isKept() <em>Kept</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isKept()
	 * @generated
	 * @ordered
	 */
	protected static final boolean KEPT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isKept() <em>Kept</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isKept()
	 * @generated
	 * @ordered
	 */
	protected boolean kept = KEPT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRepresentedElement() <em>Represented Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepresentedElement()
	 * @generated
	 * @ordered
	 */
	protected EObject representedElement;

	/**
	 * The default value of the '{@link #isUseRepresented() <em>Use Represented</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUseRepresented()
	 * @generated
	 * @ordered
	 */
	protected static final boolean USE_REPRESENTED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isUseRepresented() <em>Use Represented</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUseRepresented()
	 * @generated
	 * @ordered
	 */
	protected boolean useRepresented = USE_REPRESENTED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VirtualElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VirtualmetamodelPackage.Literals.VIRTUAL_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAliasName() {
		return aliasName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAliasName(String newAliasName) {
		String oldAliasName = aliasName;
		aliasName = newAliasName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VirtualmetamodelPackage.VIRTUAL_ELEMENT__ALIAS_NAME, oldAliasName, aliasName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isKept() {
		return kept;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKept(boolean newKept) {
		boolean oldKept = kept;
		kept = newKept;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VirtualmetamodelPackage.VIRTUAL_ELEMENT__KEPT, oldKept, kept));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getRepresentedElement() {
		if (representedElement != null && representedElement.eIsProxy()) {
			InternalEObject oldRepresentedElement = (InternalEObject)representedElement;
			representedElement = eResolveProxy(oldRepresentedElement);
			if (representedElement != oldRepresentedElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, VirtualmetamodelPackage.VIRTUAL_ELEMENT__REPRESENTED_ELEMENT, oldRepresentedElement, representedElement));
			}
		}
		return representedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetRepresentedElement() {
		return representedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRepresentedElement(EObject newRepresentedElement) {
		EObject oldRepresentedElement = representedElement;
		representedElement = newRepresentedElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VirtualmetamodelPackage.VIRTUAL_ELEMENT__REPRESENTED_ELEMENT, oldRepresentedElement, representedElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isUseRepresented() {
		return useRepresented;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUseRepresented(boolean newUseRepresented) {
		boolean oldUseRepresented = useRepresented;
		useRepresented = newUseRepresented;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VirtualmetamodelPackage.VIRTUAL_ELEMENT__USE_REPRESENTED, oldUseRepresented, useRepresented));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case VirtualmetamodelPackage.VIRTUAL_ELEMENT__ALIAS_NAME:
				return getAliasName();
			case VirtualmetamodelPackage.VIRTUAL_ELEMENT__KEPT:
				return isKept();
			case VirtualmetamodelPackage.VIRTUAL_ELEMENT__REPRESENTED_ELEMENT:
				if (resolve) return getRepresentedElement();
				return basicGetRepresentedElement();
			case VirtualmetamodelPackage.VIRTUAL_ELEMENT__USE_REPRESENTED:
				return isUseRepresented();
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
			case VirtualmetamodelPackage.VIRTUAL_ELEMENT__ALIAS_NAME:
				setAliasName((String)newValue);
				return;
			case VirtualmetamodelPackage.VIRTUAL_ELEMENT__KEPT:
				setKept((Boolean)newValue);
				return;
			case VirtualmetamodelPackage.VIRTUAL_ELEMENT__REPRESENTED_ELEMENT:
				setRepresentedElement((EObject)newValue);
				return;
			case VirtualmetamodelPackage.VIRTUAL_ELEMENT__USE_REPRESENTED:
				setUseRepresented((Boolean)newValue);
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
			case VirtualmetamodelPackage.VIRTUAL_ELEMENT__ALIAS_NAME:
				setAliasName(ALIAS_NAME_EDEFAULT);
				return;
			case VirtualmetamodelPackage.VIRTUAL_ELEMENT__KEPT:
				setKept(KEPT_EDEFAULT);
				return;
			case VirtualmetamodelPackage.VIRTUAL_ELEMENT__REPRESENTED_ELEMENT:
				setRepresentedElement((EObject)null);
				return;
			case VirtualmetamodelPackage.VIRTUAL_ELEMENT__USE_REPRESENTED:
				setUseRepresented(USE_REPRESENTED_EDEFAULT);
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
			case VirtualmetamodelPackage.VIRTUAL_ELEMENT__ALIAS_NAME:
				return ALIAS_NAME_EDEFAULT == null ? aliasName != null : !ALIAS_NAME_EDEFAULT.equals(aliasName);
			case VirtualmetamodelPackage.VIRTUAL_ELEMENT__KEPT:
				return kept != KEPT_EDEFAULT;
			case VirtualmetamodelPackage.VIRTUAL_ELEMENT__REPRESENTED_ELEMENT:
				return representedElement != null;
			case VirtualmetamodelPackage.VIRTUAL_ELEMENT__USE_REPRESENTED:
				return useRepresented != USE_REPRESENTED_EDEFAULT;
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
		result.append(" (aliasName: ");
		result.append(aliasName);
		result.append(", kept: ");
		result.append(kept);
		result.append(", useRepresented: ");
		result.append(useRepresented);
		result.append(')');
		return result.toString();
	}

} //VirtualElementImpl
