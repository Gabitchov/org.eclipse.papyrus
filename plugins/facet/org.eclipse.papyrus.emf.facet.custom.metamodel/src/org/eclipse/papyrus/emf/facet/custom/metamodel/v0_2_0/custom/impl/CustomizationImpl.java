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
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.impl.FacetSetImpl;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.CustomPackage;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.Customization;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Customization</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.impl.CustomizationImpl#isMustBeLoadedByDefault <em>Must Be Loaded By Default</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CustomizationImpl extends FacetSetImpl implements Customization {
	/**
	 * The default value of the '{@link #isMustBeLoadedByDefault() <em>Must Be Loaded By Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMustBeLoadedByDefault()
	 * @generated
	 * @ordered
	 */
	protected static final boolean MUST_BE_LOADED_BY_DEFAULT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isMustBeLoadedByDefault() <em>Must Be Loaded By Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMustBeLoadedByDefault()
	 * @generated
	 * @ordered
	 */
	protected boolean mustBeLoadedByDefault = MUST_BE_LOADED_BY_DEFAULT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CustomizationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CustomPackage.Literals.CUSTOMIZATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isMustBeLoadedByDefault() {
		return mustBeLoadedByDefault;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMustBeLoadedByDefault(boolean newMustBeLoadedByDefault) {
		boolean oldMustBeLoadedByDefault = mustBeLoadedByDefault;
		mustBeLoadedByDefault = newMustBeLoadedByDefault;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CustomPackage.CUSTOMIZATION__MUST_BE_LOADED_BY_DEFAULT, oldMustBeLoadedByDefault, mustBeLoadedByDefault));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CustomPackage.CUSTOMIZATION__MUST_BE_LOADED_BY_DEFAULT:
				return isMustBeLoadedByDefault();
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
			case CustomPackage.CUSTOMIZATION__MUST_BE_LOADED_BY_DEFAULT:
				setMustBeLoadedByDefault((Boolean)newValue);
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
			case CustomPackage.CUSTOMIZATION__MUST_BE_LOADED_BY_DEFAULT:
				setMustBeLoadedByDefault(MUST_BE_LOADED_BY_DEFAULT_EDEFAULT);
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
			case CustomPackage.CUSTOMIZATION__MUST_BE_LOADED_BY_DEFAULT:
				return mustBeLoadedByDefault != MUST_BE_LOADED_BY_DEFAULT_EDEFAULT;
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
		result.append(" (mustBeLoadedByDefault: ");
		result.append(mustBeLoadedByDefault);
		result.append(')');
		return result.toString();
	}

} //CustomizationImpl
