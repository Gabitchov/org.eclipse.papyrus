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
 *  Chokri MRAIDHA (CEA LIST) chokri.mraidha@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.AllocPackage;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.Allocate;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.AllocationKind;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.AllocationNature;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.NfpConstraint;
import org.eclipse.uml2.uml.Abstraction;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Allocate</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.impl.AllocateImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.impl.AllocateImpl#getNature <em>Nature</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.impl.AllocateImpl#getBase_Abstraction <em>Base Abstraction</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.impl.AllocateImpl#getImpliedConstraint <em>Implied Constraint</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AllocateImpl extends EObjectImpl implements Allocate {
	/**
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final AllocationKind KIND_EDEFAULT = AllocationKind.STRUCTURAL;

	/**
	 * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected AllocationKind kind = KIND_EDEFAULT;

	/**
	 * The default value of the '{@link #getNature() <em>Nature</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNature()
	 * @generated
	 * @ordered
	 */
	protected static final AllocationNature NATURE_EDEFAULT = AllocationNature.SPATIAL_DISTRIBUTION;

	/**
	 * The cached value of the '{@link #getNature() <em>Nature</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNature()
	 * @generated
	 * @ordered
	 */
	protected AllocationNature nature = NATURE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBase_Abstraction() <em>Base Abstraction</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Abstraction()
	 * @generated
	 * @ordered
	 */
	protected Abstraction base_Abstraction;

	/**
	 * The cached value of the '{@link #getImpliedConstraint() <em>Implied Constraint</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImpliedConstraint()
	 * @generated
	 * @ordered
	 */
	protected EList<NfpConstraint> impliedConstraint;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AllocateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AllocPackage.Literals.ALLOCATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AllocationKind getKind() {
		return kind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKind(AllocationKind newKind) {
		AllocationKind oldKind = kind;
		kind = newKind == null ? KIND_EDEFAULT : newKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AllocPackage.ALLOCATE__KIND, oldKind, kind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AllocationNature getNature() {
		return nature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNature(AllocationNature newNature) {
		AllocationNature oldNature = nature;
		nature = newNature == null ? NATURE_EDEFAULT : newNature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AllocPackage.ALLOCATE__NATURE, oldNature, nature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Abstraction getBase_Abstraction() {
		if (base_Abstraction != null && base_Abstraction.eIsProxy()) {
			InternalEObject oldBase_Abstraction = (InternalEObject)base_Abstraction;
			base_Abstraction = (Abstraction)eResolveProxy(oldBase_Abstraction);
			if (base_Abstraction != oldBase_Abstraction) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AllocPackage.ALLOCATE__BASE_ABSTRACTION, oldBase_Abstraction, base_Abstraction));
			}
		}
		return base_Abstraction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Abstraction basicGetBase_Abstraction() {
		return base_Abstraction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Abstraction(Abstraction newBase_Abstraction) {
		Abstraction oldBase_Abstraction = base_Abstraction;
		base_Abstraction = newBase_Abstraction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AllocPackage.ALLOCATE__BASE_ABSTRACTION, oldBase_Abstraction, base_Abstraction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NfpConstraint> getImpliedConstraint() {
		if (impliedConstraint == null) {
			impliedConstraint = new EObjectResolvingEList<NfpConstraint>(NfpConstraint.class, this, AllocPackage.ALLOCATE__IMPLIED_CONSTRAINT);
		}
		return impliedConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AllocPackage.ALLOCATE__KIND:
				return getKind();
			case AllocPackage.ALLOCATE__NATURE:
				return getNature();
			case AllocPackage.ALLOCATE__BASE_ABSTRACTION:
				if (resolve) return getBase_Abstraction();
				return basicGetBase_Abstraction();
			case AllocPackage.ALLOCATE__IMPLIED_CONSTRAINT:
				return getImpliedConstraint();
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
			case AllocPackage.ALLOCATE__KIND:
				setKind((AllocationKind)newValue);
				return;
			case AllocPackage.ALLOCATE__NATURE:
				setNature((AllocationNature)newValue);
				return;
			case AllocPackage.ALLOCATE__BASE_ABSTRACTION:
				setBase_Abstraction((Abstraction)newValue);
				return;
			case AllocPackage.ALLOCATE__IMPLIED_CONSTRAINT:
				getImpliedConstraint().clear();
				getImpliedConstraint().addAll((Collection<? extends NfpConstraint>)newValue);
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
			case AllocPackage.ALLOCATE__KIND:
				setKind(KIND_EDEFAULT);
				return;
			case AllocPackage.ALLOCATE__NATURE:
				setNature(NATURE_EDEFAULT);
				return;
			case AllocPackage.ALLOCATE__BASE_ABSTRACTION:
				setBase_Abstraction((Abstraction)null);
				return;
			case AllocPackage.ALLOCATE__IMPLIED_CONSTRAINT:
				getImpliedConstraint().clear();
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
			case AllocPackage.ALLOCATE__KIND:
				return kind != KIND_EDEFAULT;
			case AllocPackage.ALLOCATE__NATURE:
				return nature != NATURE_EDEFAULT;
			case AllocPackage.ALLOCATE__BASE_ABSTRACTION:
				return base_Abstraction != null;
			case AllocPackage.ALLOCATE__IMPLIED_CONSTRAINT:
				return impliedConstraint != null && !impliedConstraint.isEmpty();
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
		result.append(" (kind: ");
		result.append(kind);
		result.append(", nature: ");
		result.append(nature);
		result.append(')');
		return result.toString();
	}

} //AllocateImpl
