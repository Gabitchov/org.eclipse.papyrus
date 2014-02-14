/**
 *  Copyright (c) 2011 Mia-Software.
 *  
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 * 	Gregoire Dupe (Mia-Software) - Design
 * 	Nicolas Guyomar (Mia-Software) - Implementation
 * 	Emmanuelle RouillÃ© (Mia-Software) - Bug 352618 - To be able to use non derived facet structural features and save them values. 
 * 	Nicolas Bros (Mia-Software) - Bug 361823 - [Restructuring] eFacet2 meta-model
 *  Gregoire Dupe (Mia-Software) - Bug 373078 - API Cleaning
 */
package org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.DerivedTypedElement;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.ExtensiblePackage;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.Query;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Query</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.impl.QueryImpl#isCanHaveSideEffects <em>Can Have Side Effects</em>}</li>
 *   <li>{@link org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.impl.QueryImpl#isCanBeCached <em>Can Be Cached</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class QueryImpl extends EObjectImpl implements Query {
	/**
	 * The default value of the '{@link #isCanHaveSideEffects() <em>Can Have Side Effects</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCanHaveSideEffects()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CAN_HAVE_SIDE_EFFECTS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isCanHaveSideEffects() <em>Can Have Side Effects</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCanHaveSideEffects()
	 * @generated
	 * @ordered
	 */
	protected boolean canHaveSideEffects = CAN_HAVE_SIDE_EFFECTS_EDEFAULT;

	/**
	 * The default value of the '{@link #isCanBeCached() <em>Can Be Cached</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCanBeCached()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CAN_BE_CACHED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isCanBeCached() <em>Can Be Cached</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCanBeCached()
	 * @generated
	 * @ordered
	 */
	protected boolean canBeCached = CAN_BE_CACHED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected QueryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExtensiblePackage.Literals.QUERY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public DerivedTypedElement basicGetOwningDerivedTypedElement() {
		EObject container = eContainer();
		if (container instanceof DerivedTypedElement) {
			return (DerivedTypedElement) container;
		}
		throw new IllegalStateException("Query must always be contained by a DerivedTypedElement");
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCanHaveSideEffects() {
		return canHaveSideEffects;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCanHaveSideEffects(boolean newCanHaveSideEffects) {
		boolean oldCanHaveSideEffects = canHaveSideEffects;
		canHaveSideEffects = newCanHaveSideEffects;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExtensiblePackage.QUERY__CAN_HAVE_SIDE_EFFECTS, oldCanHaveSideEffects, canHaveSideEffects));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCanBeCached() {
		return canBeCached;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCanBeCached(boolean newCanBeCached) {
		boolean oldCanBeCached = canBeCached;
		canBeCached = newCanBeCached;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExtensiblePackage.QUERY__CAN_BE_CACHED, oldCanBeCached, canBeCached));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ExtensiblePackage.QUERY__CAN_HAVE_SIDE_EFFECTS:
				return isCanHaveSideEffects();
			case ExtensiblePackage.QUERY__CAN_BE_CACHED:
				return isCanBeCached();
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
			case ExtensiblePackage.QUERY__CAN_HAVE_SIDE_EFFECTS:
				setCanHaveSideEffects((Boolean)newValue);
				return;
			case ExtensiblePackage.QUERY__CAN_BE_CACHED:
				setCanBeCached((Boolean)newValue);
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
			case ExtensiblePackage.QUERY__CAN_HAVE_SIDE_EFFECTS:
				setCanHaveSideEffects(CAN_HAVE_SIDE_EFFECTS_EDEFAULT);
				return;
			case ExtensiblePackage.QUERY__CAN_BE_CACHED:
				setCanBeCached(CAN_BE_CACHED_EDEFAULT);
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
			case ExtensiblePackage.QUERY__CAN_HAVE_SIDE_EFFECTS:
				return canHaveSideEffects != CAN_HAVE_SIDE_EFFECTS_EDEFAULT;
			case ExtensiblePackage.QUERY__CAN_BE_CACHED:
				return canBeCached != CAN_BE_CACHED_EDEFAULT;
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
		result.append(" (canHaveSideEffects: "); //$NON-NLS-1$
		result.append(canHaveSideEffects);
		result.append(", canBeCached: "); //$NON-NLS-1$
		result.append(canBeCached);
		result.append(')');
		return result.toString();
	}

} //QueryImpl
