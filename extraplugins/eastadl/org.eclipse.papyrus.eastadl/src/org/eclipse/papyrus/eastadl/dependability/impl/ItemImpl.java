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
package org.eclipse.papyrus.eastadl.dependability.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.papyrus.eastadl.dependability.DependabilityPackage;
import org.eclipse.papyrus.eastadl.dependability.DevelopmentCategoryKind;
import org.eclipse.papyrus.eastadl.dependability.Item;
import org.eclipse.papyrus.eastadl.infrastructure.elements.impl.EAElementImpl;
import org.eclipse.papyrus.eastadl.structure.vehiclefeaturemodeling.VehicleFeature;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.impl.ItemImpl#getBase_Class <em>Base Class</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.impl.ItemImpl#getDevelopmentCategory <em>Development Category</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.impl.ItemImpl#getVehicleFeature <em>Vehicle Feature</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ItemImpl extends EAElementImpl implements Item {

	/**
	 * The cached value of the '{@link #getBase_Class() <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getBase_Class()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.uml2.uml.Class base_Class;

	/**
	 * The default value of the '{@link #getDevelopmentCategory() <em>Development Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getDevelopmentCategory()
	 * @generated
	 * @ordered
	 */
	protected static final DevelopmentCategoryKind DEVELOPMENT_CATEGORY_EDEFAULT = DevelopmentCategoryKind.MODIFICATION_OF_EXISTING_ITEM;

	/**
	 * The cached value of the '{@link #getDevelopmentCategory() <em>Development Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getDevelopmentCategory()
	 * @generated
	 * @ordered
	 */
	protected DevelopmentCategoryKind developmentCategory = DEVELOPMENT_CATEGORY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getVehicleFeature() <em>Vehicle Feature</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getVehicleFeature()
	 * @generated
	 * @ordered
	 */
	protected EList<VehicleFeature> vehicleFeature;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ItemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch(featureID) {
		case DependabilityPackage.ITEM__BASE_CLASS:
			if(resolve)
				return getBase_Class();
			return basicGetBase_Class();
		case DependabilityPackage.ITEM__DEVELOPMENT_CATEGORY:
			return getDevelopmentCategory();
		case DependabilityPackage.ITEM__VEHICLE_FEATURE:
			return getVehicleFeature();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch(featureID) {
		case DependabilityPackage.ITEM__BASE_CLASS:
			return base_Class != null;
		case DependabilityPackage.ITEM__DEVELOPMENT_CATEGORY:
			return developmentCategory != DEVELOPMENT_CATEGORY_EDEFAULT;
		case DependabilityPackage.ITEM__VEHICLE_FEATURE:
			return vehicleFeature != null && !vehicleFeature.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch(featureID) {
		case DependabilityPackage.ITEM__BASE_CLASS:
			setBase_Class((org.eclipse.uml2.uml.Class)newValue);
			return;
		case DependabilityPackage.ITEM__DEVELOPMENT_CATEGORY:
			setDevelopmentCategory((DevelopmentCategoryKind)newValue);
			return;
		case DependabilityPackage.ITEM__VEHICLE_FEATURE:
			getVehicleFeature().clear();
			getVehicleFeature().addAll((Collection<? extends VehicleFeature>)newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DependabilityPackage.Literals.ITEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public org.eclipse.uml2.uml.Class getBase_Class() {
		if(base_Class != null && base_Class.eIsProxy()) {
			InternalEObject oldBase_Class = (InternalEObject)base_Class;
			base_Class = (org.eclipse.uml2.uml.Class)eResolveProxy(oldBase_Class);
			if(base_Class != oldBase_Class) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DependabilityPackage.ITEM__BASE_CLASS, oldBase_Class, base_Class));
			}
		}
		return base_Class;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public org.eclipse.uml2.uml.Class basicGetBase_Class() {
		return base_Class;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setBase_Class(org.eclipse.uml2.uml.Class newBase_Class) {
		org.eclipse.uml2.uml.Class oldBase_Class = base_Class;
		base_Class = newBase_Class;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DependabilityPackage.ITEM__BASE_CLASS, oldBase_Class, base_Class));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch(featureID) {
		case DependabilityPackage.ITEM__BASE_CLASS:
			setBase_Class((org.eclipse.uml2.uml.Class)null);
			return;
		case DependabilityPackage.ITEM__DEVELOPMENT_CATEGORY:
			setDevelopmentCategory(DEVELOPMENT_CATEGORY_EDEFAULT);
			return;
		case DependabilityPackage.ITEM__VEHICLE_FEATURE:
			getVehicleFeature().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DevelopmentCategoryKind getDevelopmentCategory() {
		return developmentCategory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<VehicleFeature> getVehicleFeature() {
		if(vehicleFeature == null) {
			vehicleFeature = new EObjectResolvingEList<VehicleFeature>(VehicleFeature.class, this, DependabilityPackage.ITEM__VEHICLE_FEATURE);
		}
		return vehicleFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setDevelopmentCategory(DevelopmentCategoryKind newDevelopmentCategory) {
		DevelopmentCategoryKind oldDevelopmentCategory = developmentCategory;
		developmentCategory = newDevelopmentCategory == null ? DEVELOPMENT_CATEGORY_EDEFAULT : newDevelopmentCategory;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DependabilityPackage.ITEM__DEVELOPMENT_CATEGORY, oldDevelopmentCategory, developmentCategory));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if(eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (developmentCategory: ");
		result.append(developmentCategory);
		result.append(')');
		return result.toString();
	}

} //ItemImpl
