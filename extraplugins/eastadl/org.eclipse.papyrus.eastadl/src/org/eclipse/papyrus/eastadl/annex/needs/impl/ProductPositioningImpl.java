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
package org.eclipse.papyrus.eastadl.annex.needs.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.papyrus.eastadl.annex.needs.NeedsPackage;
import org.eclipse.papyrus.eastadl.annex.needs.ProductPositioning;
import org.eclipse.papyrus.eastadl.infrastructure.elements.impl.TraceableSpecificationImpl;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Product Positioning</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.eastadl.annex.needs.impl.ProductPositioningImpl#getBase_Class <em>Base Class</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.annex.needs.impl.ProductPositioningImpl#getDrivingNeeds <em>Driving Needs</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.annex.needs.impl.ProductPositioningImpl#getKeyCapabilities <em>Key Capabilities</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.annex.needs.impl.ProductPositioningImpl#getPrimaryCompetitiveAlternative <em>Primary Competitive Alternative</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.annex.needs.impl.ProductPositioningImpl#getPrimaryDifferentiation <em>Primary Differentiation</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.annex.needs.impl.ProductPositioningImpl#getTargetCustomers <em>Target Customers</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProductPositioningImpl extends TraceableSpecificationImpl implements ProductPositioning {
	/**
	 * The cached value of the '{@link #getBase_Class() <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Class()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.uml2.uml.Class base_Class;

	/**
	 * The default value of the '{@link #getDrivingNeeds() <em>Driving Needs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDrivingNeeds()
	 * @generated
	 * @ordered
	 */
	protected static final String DRIVING_NEEDS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDrivingNeeds() <em>Driving Needs</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDrivingNeeds()
	 * @generated
	 * @ordered
	 */
	protected String drivingNeeds = DRIVING_NEEDS_EDEFAULT;

	/**
	 * The default value of the '{@link #getKeyCapabilities() <em>Key Capabilities</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKeyCapabilities()
	 * @generated
	 * @ordered
	 */
	protected static final String KEY_CAPABILITIES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getKeyCapabilities() <em>Key Capabilities</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKeyCapabilities()
	 * @generated
	 * @ordered
	 */
	protected String keyCapabilities = KEY_CAPABILITIES_EDEFAULT;

	/**
	 * The default value of the '{@link #getPrimaryCompetitiveAlternative() <em>Primary Competitive Alternative</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimaryCompetitiveAlternative()
	 * @generated
	 * @ordered
	 */
	protected static final String PRIMARY_COMPETITIVE_ALTERNATIVE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPrimaryCompetitiveAlternative() <em>Primary Competitive Alternative</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimaryCompetitiveAlternative()
	 * @generated
	 * @ordered
	 */
	protected String primaryCompetitiveAlternative = PRIMARY_COMPETITIVE_ALTERNATIVE_EDEFAULT;

	/**
	 * The default value of the '{@link #getPrimaryDifferentiation() <em>Primary Differentiation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimaryDifferentiation()
	 * @generated
	 * @ordered
	 */
	protected static final String PRIMARY_DIFFERENTIATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPrimaryDifferentiation() <em>Primary Differentiation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimaryDifferentiation()
	 * @generated
	 * @ordered
	 */
	protected String primaryDifferentiation = PRIMARY_DIFFERENTIATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getTargetCustomers() <em>Target Customers</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetCustomers()
	 * @generated
	 * @ordered
	 */
	protected static final String TARGET_CUSTOMERS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTargetCustomers() <em>Target Customers</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetCustomers()
	 * @generated
	 * @ordered
	 */
	protected String targetCustomers = TARGET_CUSTOMERS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProductPositioningImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case NeedsPackage.PRODUCT_POSITIONING__BASE_CLASS:
				if (resolve) return getBase_Class();
				return basicGetBase_Class();
			case NeedsPackage.PRODUCT_POSITIONING__DRIVING_NEEDS:
				return getDrivingNeeds();
			case NeedsPackage.PRODUCT_POSITIONING__KEY_CAPABILITIES:
				return getKeyCapabilities();
			case NeedsPackage.PRODUCT_POSITIONING__PRIMARY_COMPETITIVE_ALTERNATIVE:
				return getPrimaryCompetitiveAlternative();
			case NeedsPackage.PRODUCT_POSITIONING__PRIMARY_DIFFERENTIATION:
				return getPrimaryDifferentiation();
			case NeedsPackage.PRODUCT_POSITIONING__TARGET_CUSTOMERS:
				return getTargetCustomers();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case NeedsPackage.PRODUCT_POSITIONING__BASE_CLASS:
				return base_Class != null;
			case NeedsPackage.PRODUCT_POSITIONING__DRIVING_NEEDS:
				return DRIVING_NEEDS_EDEFAULT == null ? drivingNeeds != null : !DRIVING_NEEDS_EDEFAULT.equals(drivingNeeds);
			case NeedsPackage.PRODUCT_POSITIONING__KEY_CAPABILITIES:
				return KEY_CAPABILITIES_EDEFAULT == null ? keyCapabilities != null : !KEY_CAPABILITIES_EDEFAULT.equals(keyCapabilities);
			case NeedsPackage.PRODUCT_POSITIONING__PRIMARY_COMPETITIVE_ALTERNATIVE:
				return PRIMARY_COMPETITIVE_ALTERNATIVE_EDEFAULT == null ? primaryCompetitiveAlternative != null : !PRIMARY_COMPETITIVE_ALTERNATIVE_EDEFAULT.equals(primaryCompetitiveAlternative);
			case NeedsPackage.PRODUCT_POSITIONING__PRIMARY_DIFFERENTIATION:
				return PRIMARY_DIFFERENTIATION_EDEFAULT == null ? primaryDifferentiation != null : !PRIMARY_DIFFERENTIATION_EDEFAULT.equals(primaryDifferentiation);
			case NeedsPackage.PRODUCT_POSITIONING__TARGET_CUSTOMERS:
				return TARGET_CUSTOMERS_EDEFAULT == null ? targetCustomers != null : !TARGET_CUSTOMERS_EDEFAULT.equals(targetCustomers);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case NeedsPackage.PRODUCT_POSITIONING__BASE_CLASS:
				setBase_Class((org.eclipse.uml2.uml.Class)newValue);
				return;
			case NeedsPackage.PRODUCT_POSITIONING__DRIVING_NEEDS:
				setDrivingNeeds((String)newValue);
				return;
			case NeedsPackage.PRODUCT_POSITIONING__KEY_CAPABILITIES:
				setKeyCapabilities((String)newValue);
				return;
			case NeedsPackage.PRODUCT_POSITIONING__PRIMARY_COMPETITIVE_ALTERNATIVE:
				setPrimaryCompetitiveAlternative((String)newValue);
				return;
			case NeedsPackage.PRODUCT_POSITIONING__PRIMARY_DIFFERENTIATION:
				setPrimaryDifferentiation((String)newValue);
				return;
			case NeedsPackage.PRODUCT_POSITIONING__TARGET_CUSTOMERS:
				setTargetCustomers((String)newValue);
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
	protected EClass eStaticClass() {
		return NeedsPackage.Literals.PRODUCT_POSITIONING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Class getBase_Class() {
		if (base_Class != null && base_Class.eIsProxy()) {
			InternalEObject oldBase_Class = (InternalEObject)base_Class;
			base_Class = (org.eclipse.uml2.uml.Class)eResolveProxy(oldBase_Class);
			if (base_Class != oldBase_Class) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NeedsPackage.PRODUCT_POSITIONING__BASE_CLASS, oldBase_Class, base_Class));
			}
		}
		return base_Class;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Class basicGetBase_Class() {
		return base_Class;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Class(org.eclipse.uml2.uml.Class newBase_Class) {
		org.eclipse.uml2.uml.Class oldBase_Class = base_Class;
		base_Class = newBase_Class;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NeedsPackage.PRODUCT_POSITIONING__BASE_CLASS, oldBase_Class, base_Class));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case NeedsPackage.PRODUCT_POSITIONING__BASE_CLASS:
				setBase_Class((org.eclipse.uml2.uml.Class)null);
				return;
			case NeedsPackage.PRODUCT_POSITIONING__DRIVING_NEEDS:
				setDrivingNeeds(DRIVING_NEEDS_EDEFAULT);
				return;
			case NeedsPackage.PRODUCT_POSITIONING__KEY_CAPABILITIES:
				setKeyCapabilities(KEY_CAPABILITIES_EDEFAULT);
				return;
			case NeedsPackage.PRODUCT_POSITIONING__PRIMARY_COMPETITIVE_ALTERNATIVE:
				setPrimaryCompetitiveAlternative(PRIMARY_COMPETITIVE_ALTERNATIVE_EDEFAULT);
				return;
			case NeedsPackage.PRODUCT_POSITIONING__PRIMARY_DIFFERENTIATION:
				setPrimaryDifferentiation(PRIMARY_DIFFERENTIATION_EDEFAULT);
				return;
			case NeedsPackage.PRODUCT_POSITIONING__TARGET_CUSTOMERS:
				setTargetCustomers(TARGET_CUSTOMERS_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDrivingNeeds() {
		return drivingNeeds;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getKeyCapabilities() {
		return keyCapabilities;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPrimaryCompetitiveAlternative() {
		return primaryCompetitiveAlternative;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPrimaryDifferentiation() {
		return primaryDifferentiation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTargetCustomers() {
		return targetCustomers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDrivingNeeds(String newDrivingNeeds) {
		String oldDrivingNeeds = drivingNeeds;
		drivingNeeds = newDrivingNeeds;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NeedsPackage.PRODUCT_POSITIONING__DRIVING_NEEDS, oldDrivingNeeds, drivingNeeds));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKeyCapabilities(String newKeyCapabilities) {
		String oldKeyCapabilities = keyCapabilities;
		keyCapabilities = newKeyCapabilities;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NeedsPackage.PRODUCT_POSITIONING__KEY_CAPABILITIES, oldKeyCapabilities, keyCapabilities));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrimaryCompetitiveAlternative(String newPrimaryCompetitiveAlternative) {
		String oldPrimaryCompetitiveAlternative = primaryCompetitiveAlternative;
		primaryCompetitiveAlternative = newPrimaryCompetitiveAlternative;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NeedsPackage.PRODUCT_POSITIONING__PRIMARY_COMPETITIVE_ALTERNATIVE, oldPrimaryCompetitiveAlternative, primaryCompetitiveAlternative));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrimaryDifferentiation(String newPrimaryDifferentiation) {
		String oldPrimaryDifferentiation = primaryDifferentiation;
		primaryDifferentiation = newPrimaryDifferentiation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NeedsPackage.PRODUCT_POSITIONING__PRIMARY_DIFFERENTIATION, oldPrimaryDifferentiation, primaryDifferentiation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetCustomers(String newTargetCustomers) {
		String oldTargetCustomers = targetCustomers;
		targetCustomers = newTargetCustomers;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NeedsPackage.PRODUCT_POSITIONING__TARGET_CUSTOMERS, oldTargetCustomers, targetCustomers));
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
		result.append(" (drivingNeeds: ");
		result.append(drivingNeeds);
		result.append(", keyCapabilities: ");
		result.append(keyCapabilities);
		result.append(", primaryCompetitiveAlternative: ");
		result.append(primaryCompetitiveAlternative);
		result.append(", primaryDifferentiation: ");
		result.append(primaryDifferentiation);
		result.append(", targetCustomers: ");
		result.append(targetCustomers);
		result.append(')');
		return result.toString();
	}

} //ProductPositioningImpl
