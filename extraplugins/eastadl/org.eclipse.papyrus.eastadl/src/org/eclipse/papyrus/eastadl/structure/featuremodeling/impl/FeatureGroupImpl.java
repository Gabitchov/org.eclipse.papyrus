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
package org.eclipse.papyrus.eastadl.structure.featuremodeling.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.papyrus.eastadl.structure.featuremodeling.Feature;
import org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureGroup;
import org.eclipse.papyrus.eastadl.structure.featuremodeling.FeaturemodelingPackage;


/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Feature Group</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.impl.FeatureGroupImpl#getBase_Class <em>Base Class</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.impl.FeatureGroupImpl#getCardinality <em>Cardinality</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.impl.FeatureGroupImpl#getChildFeature <em>Child Feature</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class FeatureGroupImpl extends FeatureTreeNodeImpl implements FeatureGroup {

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
	 * The default value of the '{@link #getCardinality() <em>Cardinality</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getCardinality()
	 * @generated
	 * @ordered
	 */
	protected static final String CARDINALITY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCardinality() <em>Cardinality</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getCardinality()
	 * @generated
	 * @ordered
	 */
	protected String cardinality = CARDINALITY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getChildFeature() <em>Child Feature</em>}' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getChildFeature()
	 * @generated
	 * @ordered
	 */
	protected EList<Feature> childFeature;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected FeatureGroupImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch(featureID) {
		case FeaturemodelingPackage.FEATURE_GROUP__BASE_CLASS:
			if(resolve)
				return getBase_Class();
			return basicGetBase_Class();
		case FeaturemodelingPackage.FEATURE_GROUP__CARDINALITY:
			return getCardinality();
		case FeaturemodelingPackage.FEATURE_GROUP__CHILD_FEATURE:
			return getChildFeature();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch(featureID) {
		case FeaturemodelingPackage.FEATURE_GROUP__BASE_CLASS:
			return base_Class != null;
		case FeaturemodelingPackage.FEATURE_GROUP__CARDINALITY:
			return CARDINALITY_EDEFAULT == null ? cardinality != null : !CARDINALITY_EDEFAULT.equals(cardinality);
		case FeaturemodelingPackage.FEATURE_GROUP__CHILD_FEATURE:
			return childFeature != null && !childFeature.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch(featureID) {
		case FeaturemodelingPackage.FEATURE_GROUP__BASE_CLASS:
			setBase_Class((org.eclipse.uml2.uml.Class)newValue);
			return;
		case FeaturemodelingPackage.FEATURE_GROUP__CARDINALITY:
			setCardinality((String)newValue);
			return;
		case FeaturemodelingPackage.FEATURE_GROUP__CHILD_FEATURE:
			getChildFeature().clear();
			getChildFeature().addAll((Collection<? extends Feature>)newValue);
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
		return FeaturemodelingPackage.Literals.FEATURE_GROUP;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FeaturemodelingPackage.FEATURE_GROUP__BASE_CLASS, oldBase_Class, base_Class));
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
			eNotify(new ENotificationImpl(this, Notification.SET, FeaturemodelingPackage.FEATURE_GROUP__BASE_CLASS, oldBase_Class, base_Class));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch(featureID) {
		case FeaturemodelingPackage.FEATURE_GROUP__BASE_CLASS:
			setBase_Class((org.eclipse.uml2.uml.Class)null);
			return;
		case FeaturemodelingPackage.FEATURE_GROUP__CARDINALITY:
			setCardinality(CARDINALITY_EDEFAULT);
			return;
		case FeaturemodelingPackage.FEATURE_GROUP__CHILD_FEATURE:
			getChildFeature().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getCardinality() {
		return cardinality;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<Feature> getChildFeature() {
		if(childFeature == null) {
			childFeature = new EObjectResolvingEList<Feature>(Feature.class, this, FeaturemodelingPackage.FEATURE_GROUP__CHILD_FEATURE);
		}
		return childFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setCardinality(String newCardinality) {
		String oldCardinality = cardinality;
		cardinality = newCardinality;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FeaturemodelingPackage.FEATURE_GROUP__CARDINALITY, oldCardinality, cardinality));
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
		result.append(" (cardinality: ");
		result.append(cardinality);
		result.append(')');
		return result.toString();
	}

} // FeatureGroupImpl
