/**
 * Copyright (c) 2009 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Frederic MADIOT (Mia-Software) - meta-model design
 *     Gregoire DUPE (Mia-Software) - design and implementation
 * 
 *
 * $Id$
 */
package org.eclipse.emf.facet.infra.facet.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EReferenceImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.facet.infra.facet.FacetPackage;
import org.eclipse.emf.facet.infra.facet.Shortcut;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Shortcut</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.facet.infra.facet.impl.ShortcutImpl#getPath <em>Path</em>}</li>
 *   <li>{@link org.eclipse.emf.facet.infra.facet.impl.ShortcutImpl#getOppositeReference <em>Opposite Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ShortcutImpl extends EReferenceImpl implements Shortcut {
	/**
	 * The cached value of the '{@link #getPath() <em>Path</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPath()
	 * @generated
	 * @ordered
	 */
	protected EList<EReference> path;

	/**
	 * The cached value of the '{@link #getOppositeReference() <em>Opposite Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOppositeReference()
	 * @generated
	 * @ordered
	 */
	protected EReference oppositeReference;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ShortcutImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FacetPackage.Literals.SHORTCUT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EReference> getPath() {
		if (path == null) {
			path = new EObjectResolvingEList<EReference>(EReference.class, this, FacetPackage.SHORTCUT__PATH);
		}
		return path;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOppositeReference() {
		if (oppositeReference != null && oppositeReference.eIsProxy()) {
			InternalEObject oldOppositeReference = (InternalEObject)oppositeReference;
			oppositeReference = (EReference)eResolveProxy(oldOppositeReference);
			if (oppositeReference != oldOppositeReference) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FacetPackage.SHORTCUT__OPPOSITE_REFERENCE, oldOppositeReference, oppositeReference));
			}
		}
		return oppositeReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference basicGetOppositeReference() {
		return oppositeReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOppositeReference(EReference newOppositeReference) {
		EReference oldOppositeReference = oppositeReference;
		oppositeReference = newOppositeReference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FacetPackage.SHORTCUT__OPPOSITE_REFERENCE, oldOppositeReference, oppositeReference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FacetPackage.SHORTCUT__PATH:
				return getPath();
			case FacetPackage.SHORTCUT__OPPOSITE_REFERENCE:
				if (resolve) return getOppositeReference();
				return basicGetOppositeReference();
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
			case FacetPackage.SHORTCUT__PATH:
				getPath().clear();
				getPath().addAll((Collection<? extends EReference>)newValue);
				return;
			case FacetPackage.SHORTCUT__OPPOSITE_REFERENCE:
				setOppositeReference((EReference)newValue);
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
			case FacetPackage.SHORTCUT__PATH:
				getPath().clear();
				return;
			case FacetPackage.SHORTCUT__OPPOSITE_REFERENCE:
				setOppositeReference((EReference)null);
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
			case FacetPackage.SHORTCUT__PATH:
				return path != null && !path.isEmpty();
			case FacetPackage.SHORTCUT__OPPOSITE_REFERENCE:
				return oppositeReference != null;
		}
		return super.eIsSet(featureID);
	}

} //ShortcutImpl
