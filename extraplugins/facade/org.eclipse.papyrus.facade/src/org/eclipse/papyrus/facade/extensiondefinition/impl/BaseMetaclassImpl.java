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
package org.eclipse.papyrus.facade.extensiondefinition.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.facade.extensiondefinition.BaseMetaclass;
import org.eclipse.papyrus.facade.extensiondefinition.Combination;
import org.eclipse.papyrus.facade.extensiondefinition.ExtensionDefinition;
import org.eclipse.papyrus.facade.extensiondefinition.ExtensiondefinitionPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Base Metaclass</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.facade.extensiondefinition.impl.BaseMetaclassImpl#getIncompatibleStereotypes <em>Incompatible Stereotypes</em>}</li>
 *   <li>{@link org.eclipse.papyrus.facade.extensiondefinition.impl.BaseMetaclassImpl#getBase <em>Base</em>}</li>
 *   <li>{@link org.eclipse.papyrus.facade.extensiondefinition.impl.BaseMetaclassImpl#getExtensionDefinition <em>Extension Definition</em>}</li>
 *   <li>{@link org.eclipse.papyrus.facade.extensiondefinition.impl.BaseMetaclassImpl#getCompatibleStereotypes <em>Compatible Stereotypes</em>}</li>
 *   <li>{@link org.eclipse.papyrus.facade.extensiondefinition.impl.BaseMetaclassImpl#isPossible <em>Possible</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BaseMetaclassImpl extends MinimalEObjectImpl.Container implements BaseMetaclass {
	/**
	 * The cached value of the '{@link #getIncompatibleStereotypes() <em>Incompatible Stereotypes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncompatibleStereotypes()
	 * @generated
	 * @ordered
	 */
	protected EList<Combination> incompatibleStereotypes;

	/**
	 * The cached value of the '{@link #getBase() <em>Base</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase()
	 * @generated
	 * @ordered
	 */
	protected EObject base;

	/**
	 * The cached value of the '{@link #getCompatibleStereotypes() <em>Compatible Stereotypes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompatibleStereotypes()
	 * @generated
	 * @ordered
	 */
	protected EList<Combination> compatibleStereotypes;

	/**
	 * The default value of the '{@link #isPossible() <em>Possible</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPossible()
	 * @generated
	 * @ordered
	 */
	protected static final boolean POSSIBLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isPossible() <em>Possible</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPossible()
	 * @generated
	 * @ordered
	 */
	protected boolean possible = POSSIBLE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BaseMetaclassImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExtensiondefinitionPackage.Literals.BASE_METACLASS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Combination> getIncompatibleStereotypes() {
		if (incompatibleStereotypes == null) {
			incompatibleStereotypes = new EObjectContainmentEList<Combination>(Combination.class, this, ExtensiondefinitionPackage.BASE_METACLASS__INCOMPATIBLE_STEREOTYPES);
		}
		return incompatibleStereotypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getBase() {
		if (base != null && base.eIsProxy()) {
			InternalEObject oldBase = (InternalEObject)base;
			base = eResolveProxy(oldBase);
			if (base != oldBase) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExtensiondefinitionPackage.BASE_METACLASS__BASE, oldBase, base));
			}
		}
		return base;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetBase() {
		return base;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase(EObject newBase) {
		EObject oldBase = base;
		base = newBase;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExtensiondefinitionPackage.BASE_METACLASS__BASE, oldBase, base));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtensionDefinition getExtensionDefinition() {
		if (eContainerFeatureID() != ExtensiondefinitionPackage.BASE_METACLASS__EXTENSION_DEFINITION) return null;
		return (ExtensionDefinition)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExtensionDefinition(ExtensionDefinition newExtensionDefinition, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newExtensionDefinition, ExtensiondefinitionPackage.BASE_METACLASS__EXTENSION_DEFINITION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExtensionDefinition(ExtensionDefinition newExtensionDefinition) {
		if (newExtensionDefinition != eInternalContainer() || (eContainerFeatureID() != ExtensiondefinitionPackage.BASE_METACLASS__EXTENSION_DEFINITION && newExtensionDefinition != null)) {
			if (EcoreUtil.isAncestor(this, newExtensionDefinition))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newExtensionDefinition != null)
				msgs = ((InternalEObject)newExtensionDefinition).eInverseAdd(this, ExtensiondefinitionPackage.EXTENSION_DEFINITION__BASE_METACLASSES, ExtensionDefinition.class, msgs);
			msgs = basicSetExtensionDefinition(newExtensionDefinition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExtensiondefinitionPackage.BASE_METACLASS__EXTENSION_DEFINITION, newExtensionDefinition, newExtensionDefinition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Combination> getCompatibleStereotypes() {
		if (compatibleStereotypes == null) {
			compatibleStereotypes = new EObjectContainmentEList<Combination>(Combination.class, this, ExtensiondefinitionPackage.BASE_METACLASS__COMPATIBLE_STEREOTYPES);
		}
		return compatibleStereotypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isPossible() {
		return possible;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPossible(boolean newPossible) {
		boolean oldPossible = possible;
		possible = newPossible;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExtensiondefinitionPackage.BASE_METACLASS__POSSIBLE, oldPossible, possible));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ExtensiondefinitionPackage.BASE_METACLASS__EXTENSION_DEFINITION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetExtensionDefinition((ExtensionDefinition)otherEnd, msgs);
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
			case ExtensiondefinitionPackage.BASE_METACLASS__INCOMPATIBLE_STEREOTYPES:
				return ((InternalEList<?>)getIncompatibleStereotypes()).basicRemove(otherEnd, msgs);
			case ExtensiondefinitionPackage.BASE_METACLASS__EXTENSION_DEFINITION:
				return basicSetExtensionDefinition(null, msgs);
			case ExtensiondefinitionPackage.BASE_METACLASS__COMPATIBLE_STEREOTYPES:
				return ((InternalEList<?>)getCompatibleStereotypes()).basicRemove(otherEnd, msgs);
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
			case ExtensiondefinitionPackage.BASE_METACLASS__EXTENSION_DEFINITION:
				return eInternalContainer().eInverseRemove(this, ExtensiondefinitionPackage.EXTENSION_DEFINITION__BASE_METACLASSES, ExtensionDefinition.class, msgs);
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
			case ExtensiondefinitionPackage.BASE_METACLASS__INCOMPATIBLE_STEREOTYPES:
				return getIncompatibleStereotypes();
			case ExtensiondefinitionPackage.BASE_METACLASS__BASE:
				if (resolve) return getBase();
				return basicGetBase();
			case ExtensiondefinitionPackage.BASE_METACLASS__EXTENSION_DEFINITION:
				return getExtensionDefinition();
			case ExtensiondefinitionPackage.BASE_METACLASS__COMPATIBLE_STEREOTYPES:
				return getCompatibleStereotypes();
			case ExtensiondefinitionPackage.BASE_METACLASS__POSSIBLE:
				return isPossible();
		}
		return super.eGet(featureID, resolve, coreType);
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
			case ExtensiondefinitionPackage.BASE_METACLASS__INCOMPATIBLE_STEREOTYPES:
				getIncompatibleStereotypes().clear();
				getIncompatibleStereotypes().addAll((Collection<? extends Combination>)newValue);
				return;
			case ExtensiondefinitionPackage.BASE_METACLASS__BASE:
				setBase((EObject)newValue);
				return;
			case ExtensiondefinitionPackage.BASE_METACLASS__EXTENSION_DEFINITION:
				setExtensionDefinition((ExtensionDefinition)newValue);
				return;
			case ExtensiondefinitionPackage.BASE_METACLASS__COMPATIBLE_STEREOTYPES:
				getCompatibleStereotypes().clear();
				getCompatibleStereotypes().addAll((Collection<? extends Combination>)newValue);
				return;
			case ExtensiondefinitionPackage.BASE_METACLASS__POSSIBLE:
				setPossible((Boolean)newValue);
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
			case ExtensiondefinitionPackage.BASE_METACLASS__INCOMPATIBLE_STEREOTYPES:
				getIncompatibleStereotypes().clear();
				return;
			case ExtensiondefinitionPackage.BASE_METACLASS__BASE:
				setBase((EObject)null);
				return;
			case ExtensiondefinitionPackage.BASE_METACLASS__EXTENSION_DEFINITION:
				setExtensionDefinition((ExtensionDefinition)null);
				return;
			case ExtensiondefinitionPackage.BASE_METACLASS__COMPATIBLE_STEREOTYPES:
				getCompatibleStereotypes().clear();
				return;
			case ExtensiondefinitionPackage.BASE_METACLASS__POSSIBLE:
				setPossible(POSSIBLE_EDEFAULT);
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
			case ExtensiondefinitionPackage.BASE_METACLASS__INCOMPATIBLE_STEREOTYPES:
				return incompatibleStereotypes != null && !incompatibleStereotypes.isEmpty();
			case ExtensiondefinitionPackage.BASE_METACLASS__BASE:
				return base != null;
			case ExtensiondefinitionPackage.BASE_METACLASS__EXTENSION_DEFINITION:
				return getExtensionDefinition() != null;
			case ExtensiondefinitionPackage.BASE_METACLASS__COMPATIBLE_STEREOTYPES:
				return compatibleStereotypes != null && !compatibleStereotypes.isEmpty();
			case ExtensiondefinitionPackage.BASE_METACLASS__POSSIBLE:
				return possible != POSSIBLE_EDEFAULT;
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
		result.append(" (possible: ");
		result.append(possible);
		result.append(')');
		return result.toString();
	}

} //BaseMetaclassImpl
