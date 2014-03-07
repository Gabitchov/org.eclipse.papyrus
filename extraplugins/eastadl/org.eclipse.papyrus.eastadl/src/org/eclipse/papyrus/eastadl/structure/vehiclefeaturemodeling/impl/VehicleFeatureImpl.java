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
package org.eclipse.papyrus.eastadl.structure.vehiclefeaturemodeling.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.papyrus.eastadl.structure.featuremodeling.impl.FeatureImpl;
import org.eclipse.papyrus.eastadl.structure.vehiclefeaturemodeling.DeviationAttributeSet;
import org.eclipse.papyrus.eastadl.structure.vehiclefeaturemodeling.VehicleFeature;
import org.eclipse.papyrus.eastadl.structure.vehiclefeaturemodeling.VehiclefeaturemodelingPackage;


/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Vehicle Feature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.vehiclefeaturemodeling.impl.VehicleFeatureImpl#isIsDesignVariabilityRationale <em>Is Design
 * Variability Rationale</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.vehiclefeaturemodeling.impl.VehicleFeatureImpl#isIsCustomerVisible <em>Is Customer Visible</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.vehiclefeaturemodeling.impl.VehicleFeatureImpl#isIsRemoved <em>Is Removed</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.vehiclefeaturemodeling.impl.VehicleFeatureImpl#getDeviationAttributeSet <em>Deviation Attribute
 * Set</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class VehicleFeatureImpl extends FeatureImpl implements VehicleFeature {

	/**
	 * The default value of the '{@link #isIsDesignVariabilityRationale() <em>Is Design Variability Rationale</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #isIsDesignVariabilityRationale()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_DESIGN_VARIABILITY_RATIONALE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsDesignVariabilityRationale() <em>Is Design Variability Rationale</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #isIsDesignVariabilityRationale()
	 * @generated
	 * @ordered
	 */
	protected boolean isDesignVariabilityRationale = IS_DESIGN_VARIABILITY_RATIONALE_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsCustomerVisible() <em>Is Customer Visible</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isIsCustomerVisible()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_CUSTOMER_VISIBLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsCustomerVisible() <em>Is Customer Visible</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isIsCustomerVisible()
	 * @generated
	 * @ordered
	 */
	protected boolean isCustomerVisible = IS_CUSTOMER_VISIBLE_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsRemoved() <em>Is Removed</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isIsRemoved()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_REMOVED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsRemoved() <em>Is Removed</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isIsRemoved()
	 * @generated
	 * @ordered
	 */
	protected boolean isRemoved = IS_REMOVED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDeviationAttributeSet() <em>Deviation Attribute Set</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDeviationAttributeSet()
	 * @generated
	 * @ordered
	 */
	protected DeviationAttributeSet deviationAttributeSet;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected VehicleFeatureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DeviationAttributeSet basicGetDeviationAttributeSet() {
		return deviationAttributeSet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetDeviationAttributeSet(DeviationAttributeSet newDeviationAttributeSet, NotificationChain msgs) {
		DeviationAttributeSet oldDeviationAttributeSet = deviationAttributeSet;
		deviationAttributeSet = newDeviationAttributeSet;
		if(eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VehiclefeaturemodelingPackage.VEHICLE_FEATURE__DEVIATION_ATTRIBUTE_SET, oldDeviationAttributeSet, newDeviationAttributeSet);
			if(msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch(featureID) {
		case VehiclefeaturemodelingPackage.VEHICLE_FEATURE__IS_DESIGN_VARIABILITY_RATIONALE:
			return isIsDesignVariabilityRationale();
		case VehiclefeaturemodelingPackage.VEHICLE_FEATURE__IS_CUSTOMER_VISIBLE:
			return isIsCustomerVisible();
		case VehiclefeaturemodelingPackage.VEHICLE_FEATURE__IS_REMOVED:
			return isIsRemoved();
		case VehiclefeaturemodelingPackage.VEHICLE_FEATURE__DEVIATION_ATTRIBUTE_SET:
			if(resolve)
				return getDeviationAttributeSet();
			return basicGetDeviationAttributeSet();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch(featureID) {
		case VehiclefeaturemodelingPackage.VEHICLE_FEATURE__DEVIATION_ATTRIBUTE_SET:
			if(deviationAttributeSet != null)
				msgs = ((InternalEObject)deviationAttributeSet).eInverseRemove(this, VehiclefeaturemodelingPackage.DEVIATION_ATTRIBUTE_SET__FEATURE, DeviationAttributeSet.class, msgs);
			return basicSetDeviationAttributeSet((DeviationAttributeSet)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch(featureID) {
		case VehiclefeaturemodelingPackage.VEHICLE_FEATURE__DEVIATION_ATTRIBUTE_SET:
			return basicSetDeviationAttributeSet(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch(featureID) {
		case VehiclefeaturemodelingPackage.VEHICLE_FEATURE__IS_DESIGN_VARIABILITY_RATIONALE:
			return isDesignVariabilityRationale != IS_DESIGN_VARIABILITY_RATIONALE_EDEFAULT;
		case VehiclefeaturemodelingPackage.VEHICLE_FEATURE__IS_CUSTOMER_VISIBLE:
			return isCustomerVisible != IS_CUSTOMER_VISIBLE_EDEFAULT;
		case VehiclefeaturemodelingPackage.VEHICLE_FEATURE__IS_REMOVED:
			return isRemoved != IS_REMOVED_EDEFAULT;
		case VehiclefeaturemodelingPackage.VEHICLE_FEATURE__DEVIATION_ATTRIBUTE_SET:
			return deviationAttributeSet != null;
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
		case VehiclefeaturemodelingPackage.VEHICLE_FEATURE__IS_DESIGN_VARIABILITY_RATIONALE:
			setIsDesignVariabilityRationale((Boolean)newValue);
			return;
		case VehiclefeaturemodelingPackage.VEHICLE_FEATURE__IS_CUSTOMER_VISIBLE:
			setIsCustomerVisible((Boolean)newValue);
			return;
		case VehiclefeaturemodelingPackage.VEHICLE_FEATURE__IS_REMOVED:
			setIsRemoved((Boolean)newValue);
			return;
		case VehiclefeaturemodelingPackage.VEHICLE_FEATURE__DEVIATION_ATTRIBUTE_SET:
			setDeviationAttributeSet((DeviationAttributeSet)newValue);
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
		return VehiclefeaturemodelingPackage.Literals.VEHICLE_FEATURE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch(featureID) {
		case VehiclefeaturemodelingPackage.VEHICLE_FEATURE__IS_DESIGN_VARIABILITY_RATIONALE:
			setIsDesignVariabilityRationale(IS_DESIGN_VARIABILITY_RATIONALE_EDEFAULT);
			return;
		case VehiclefeaturemodelingPackage.VEHICLE_FEATURE__IS_CUSTOMER_VISIBLE:
			setIsCustomerVisible(IS_CUSTOMER_VISIBLE_EDEFAULT);
			return;
		case VehiclefeaturemodelingPackage.VEHICLE_FEATURE__IS_REMOVED:
			setIsRemoved(IS_REMOVED_EDEFAULT);
			return;
		case VehiclefeaturemodelingPackage.VEHICLE_FEATURE__DEVIATION_ATTRIBUTE_SET:
			setDeviationAttributeSet((DeviationAttributeSet)null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DeviationAttributeSet getDeviationAttributeSet() {
		if(deviationAttributeSet != null && deviationAttributeSet.eIsProxy()) {
			InternalEObject oldDeviationAttributeSet = (InternalEObject)deviationAttributeSet;
			deviationAttributeSet = (DeviationAttributeSet)eResolveProxy(oldDeviationAttributeSet);
			if(deviationAttributeSet != oldDeviationAttributeSet) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, VehiclefeaturemodelingPackage.VEHICLE_FEATURE__DEVIATION_ATTRIBUTE_SET, oldDeviationAttributeSet, deviationAttributeSet));
			}
		}
		return deviationAttributeSet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isIsCustomerVisible() {
		return isCustomerVisible;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isIsDesignVariabilityRationale() {
		return isDesignVariabilityRationale;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isIsRemoved() {
		return isRemoved;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setDeviationAttributeSet(DeviationAttributeSet newDeviationAttributeSet) {
		if(newDeviationAttributeSet != deviationAttributeSet) {
			NotificationChain msgs = null;
			if(deviationAttributeSet != null)
				msgs = ((InternalEObject)deviationAttributeSet).eInverseRemove(this, VehiclefeaturemodelingPackage.DEVIATION_ATTRIBUTE_SET__FEATURE, DeviationAttributeSet.class, msgs);
			if(newDeviationAttributeSet != null)
				msgs = ((InternalEObject)newDeviationAttributeSet).eInverseAdd(this, VehiclefeaturemodelingPackage.DEVIATION_ATTRIBUTE_SET__FEATURE, DeviationAttributeSet.class, msgs);
			msgs = basicSetDeviationAttributeSet(newDeviationAttributeSet, msgs);
			if(msgs != null)
				msgs.dispatch();
		} else if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VehiclefeaturemodelingPackage.VEHICLE_FEATURE__DEVIATION_ATTRIBUTE_SET, newDeviationAttributeSet, newDeviationAttributeSet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setIsCustomerVisible(boolean newIsCustomerVisible) {
		boolean oldIsCustomerVisible = isCustomerVisible;
		isCustomerVisible = newIsCustomerVisible;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VehiclefeaturemodelingPackage.VEHICLE_FEATURE__IS_CUSTOMER_VISIBLE, oldIsCustomerVisible, isCustomerVisible));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setIsDesignVariabilityRationale(boolean newIsDesignVariabilityRationale) {
		boolean oldIsDesignVariabilityRationale = isDesignVariabilityRationale;
		isDesignVariabilityRationale = newIsDesignVariabilityRationale;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VehiclefeaturemodelingPackage.VEHICLE_FEATURE__IS_DESIGN_VARIABILITY_RATIONALE, oldIsDesignVariabilityRationale, isDesignVariabilityRationale));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setIsRemoved(boolean newIsRemoved) {
		boolean oldIsRemoved = isRemoved;
		isRemoved = newIsRemoved;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VehiclefeaturemodelingPackage.VEHICLE_FEATURE__IS_REMOVED, oldIsRemoved, isRemoved));
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
		result.append(" (isDesignVariabilityRationale: ");
		result.append(isDesignVariabilityRationale);
		result.append(", isCustomerVisible: ");
		result.append(isCustomerVisible);
		result.append(", isRemoved: ");
		result.append(isRemoved);
		result.append(')');
		return result.toString();
	}

} // VehicleFeatureImpl
