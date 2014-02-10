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
 *     Gregoire DUPE (Mia-Software) - Bug 339880 - To be able to edit derived facet attributes and derived facet references
 *
 * $Id$
 */
package org.eclipse.emf.facet.infra.facet.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.util.EcoreEList;
import org.eclipse.emf.facet.infra.facet.Facet;
import org.eclipse.emf.facet.infra.facet.FacetPackage;
import org.eclipse.emf.facet.infra.facet.FacetSet;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Set</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.facet.infra.facet.impl.FacetSetImpl#getExtendedPackage <em>Extended Package</em>}</li>
 *   <li>{@link org.eclipse.emf.facet.infra.facet.impl.FacetSetImpl#getFacets <em>Facets</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FacetSetImpl extends EPackageImpl implements FacetSet {
	/**
	 * The cached value of the '{@link #getExtendedPackage() <em>Extended Package</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtendedPackage()
	 * @generated
	 * @ordered
	 */
	protected EPackage extendedPackage;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FacetSetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FacetPackage.Literals.FACET_SET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EPackage getExtendedPackage() {
		if (extendedPackage != null && extendedPackage.eIsProxy()) {
			InternalEObject oldExtendedPackage = (InternalEObject)extendedPackage;
			extendedPackage = (EPackage)eResolveProxy(oldExtendedPackage);
			if (extendedPackage != oldExtendedPackage) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FacetPackage.FACET_SET__EXTENDED_PACKAGE, oldExtendedPackage, extendedPackage));
			}
		}
		return extendedPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EPackage basicGetExtendedPackage() {
		return extendedPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExtendedPackage(EPackage newExtendedPackage) {
		EPackage oldExtendedPackage = extendedPackage;
		extendedPackage = newExtendedPackage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FacetPackage.FACET_SET__EXTENDED_PACKAGE, oldExtendedPackage, extendedPackage));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<Facet> getFacets() {
		// DONE: implement this method to return the 'Facets' reference list
		// Ensure that you remove @generated or mark it @generated NOT
		// The list is expected to implement org.eclipse.emf.ecore.util.InternalEList and org.eclipse.emf.ecore.EStructuralFeature.Setting
		// so it's likely that an appropriate subclass of org.eclipse.emf.ecore.util.EcoreEList should be used.
		// throw new UnsupportedOperationException();
		List<Facet> facets = new ArrayList<Facet>();
		for (EClassifier eClassifier : getEClassifiers()) {
			if (eClassifier instanceof Facet) {
				facets.add((Facet) eClassifier);
			}
		}
		return new EcoreEList.UnmodifiableEList<Facet>(this,
				FacetPackage.eINSTANCE.getFacetSet_Facets(), facets.size(), facets.toArray()) {
			private static final long serialVersionUID = 1L;

			@Override
			public void addUnique(final int index, final Facet object) {
				// FIXME hack: FacetSets saved with an older version of the
				// metamodel have a non-derived facets reference.
				// So, overload this method to not throw an exception in order
				// to let the XMI parser create the model anyway
			}
		};
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean isSetFacets() {
		// TODO: implement this method to return whether the 'Facets' reference
		// list is set
		// Ensure that you remove @generated or mark it @generated NOT
		// throw new UnsupportedOperationException();
		return getEClassifiers() != null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public Facet getFacet(final String name) {
		EClassifier eClassifier = getEClassifier(name);
		if (eClassifier instanceof Facet) {
			return (Facet) eClassifier;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FacetPackage.FACET_SET__EXTENDED_PACKAGE:
				if (resolve) return getExtendedPackage();
				return basicGetExtendedPackage();
			case FacetPackage.FACET_SET__FACETS:
				return getFacets();
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
			case FacetPackage.FACET_SET__EXTENDED_PACKAGE:
				setExtendedPackage((EPackage)newValue);
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
			case FacetPackage.FACET_SET__EXTENDED_PACKAGE:
				setExtendedPackage((EPackage)null);
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
			case FacetPackage.FACET_SET__EXTENDED_PACKAGE:
				return extendedPackage != null;
			case FacetPackage.FACET_SET__FACETS:
				return !getFacets().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //FacetSetImpl
