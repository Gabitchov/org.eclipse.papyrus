/**
 *  Copyright (c) 2011 Mia-Software.
 *  
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *  	Gregoire Dupe (Mia-Software) - Bug 361794 - [Restructuring] New customization meta-model
 *       Gregoire Dupe (Mia-Software) - Bug 369987 - [Restructuring][Table] Switch to the new customization and facet framework
 *       Gregoire Dupe (Mia-Software) - Bug 373078 - API Cleaning 
 */
package org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.impl.FacetImpl;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.CustomPackage;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.FacetCustomization;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Facet Customization</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.impl.FacetCustomizationImpl#getCustomizedFacet <em>Customized Facet</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FacetCustomizationImpl extends FacetImpl implements FacetCustomization {
	/**
	 * The cached value of the '{@link #getCustomizedFacet() <em>Customized Facet</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCustomizedFacet()
	 * @generated
	 * @ordered
	 */
	protected Facet customizedFacet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FacetCustomizationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CustomPackage.Literals.FACET_CUSTOMIZATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Facet getCustomizedFacet() {
		if (customizedFacet != null && customizedFacet.eIsProxy()) {
			InternalEObject oldCustomizedFacet = (InternalEObject)customizedFacet;
			customizedFacet = (Facet)eResolveProxy(oldCustomizedFacet);
			if (customizedFacet != oldCustomizedFacet) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CustomPackage.FACET_CUSTOMIZATION__CUSTOMIZED_FACET, oldCustomizedFacet, customizedFacet));
			}
		}
		return customizedFacet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Facet basicGetCustomizedFacet() {
		return customizedFacet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCustomizedFacet(Facet newCustomizedFacet) {
		Facet oldCustomizedFacet = customizedFacet;
		customizedFacet = newCustomizedFacet;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CustomPackage.FACET_CUSTOMIZATION__CUSTOMIZED_FACET, oldCustomizedFacet, customizedFacet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CustomPackage.FACET_CUSTOMIZATION__CUSTOMIZED_FACET:
				if (resolve) return getCustomizedFacet();
				return basicGetCustomizedFacet();
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
			case CustomPackage.FACET_CUSTOMIZATION__CUSTOMIZED_FACET:
				setCustomizedFacet((Facet)newValue);
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
			case CustomPackage.FACET_CUSTOMIZATION__CUSTOMIZED_FACET:
				setCustomizedFacet((Facet)null);
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
			case CustomPackage.FACET_CUSTOMIZATION__CUSTOMIZED_FACET:
				return customizedFacet != null;
		}
		return super.eIsSet(featureID);
	}

} //FacetCustomizationImpl
