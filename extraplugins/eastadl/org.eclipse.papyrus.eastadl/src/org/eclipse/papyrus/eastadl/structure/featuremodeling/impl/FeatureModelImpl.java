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
import org.eclipse.papyrus.eastadl.infrastructure.elements.impl.ContextImpl;
import org.eclipse.papyrus.eastadl.structure.featuremodeling.Feature;
import org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureConstraint;
import org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureLink;
import org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureModel;
import org.eclipse.papyrus.eastadl.structure.featuremodeling.FeaturemodelingPackage;


/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Feature Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.impl.FeatureModelImpl#getBase_Package <em>Base Package</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.impl.FeatureModelImpl#getBase_Class <em>Base Class</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.impl.FeatureModelImpl#getRootFeature <em>Root Feature</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.impl.FeatureModelImpl#getFeatureLink <em>Feature Link</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.impl.FeatureModelImpl#getFeatureConstraint <em>Feature Constraint</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class FeatureModelImpl extends ContextImpl implements FeatureModel {

	/**
	 * The cached value of the '{@link #getBase_Package() <em>Base Package</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getBase_Package()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.uml2.uml.Package base_Package;

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
	 * The cached value of the '{@link #getRootFeature() <em>Root Feature</em>}' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getRootFeature()
	 * @generated
	 * @ordered
	 */
	protected EList<Feature> rootFeature;

	/**
	 * The cached value of the '{@link #getFeatureLink() <em>Feature Link</em>}' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getFeatureLink()
	 * @generated
	 * @ordered
	 */
	protected EList<FeatureLink> featureLink;

	/**
	 * The cached value of the '{@link #getFeatureConstraint() <em>Feature Constraint</em>}' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getFeatureConstraint()
	 * @generated
	 * @ordered
	 */
	protected EList<FeatureConstraint> featureConstraint;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected FeatureModelImpl() {
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
		case FeaturemodelingPackage.FEATURE_MODEL__BASE_PACKAGE:
			if(resolve)
				return getBase_Package();
			return basicGetBase_Package();
		case FeaturemodelingPackage.FEATURE_MODEL__BASE_CLASS:
			if(resolve)
				return getBase_Class();
			return basicGetBase_Class();
		case FeaturemodelingPackage.FEATURE_MODEL__ROOT_FEATURE:
			return getRootFeature();
		case FeaturemodelingPackage.FEATURE_MODEL__FEATURE_LINK:
			return getFeatureLink();
		case FeaturemodelingPackage.FEATURE_MODEL__FEATURE_CONSTRAINT:
			return getFeatureConstraint();
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
		case FeaturemodelingPackage.FEATURE_MODEL__BASE_PACKAGE:
			return base_Package != null;
		case FeaturemodelingPackage.FEATURE_MODEL__BASE_CLASS:
			return base_Class != null;
		case FeaturemodelingPackage.FEATURE_MODEL__ROOT_FEATURE:
			return rootFeature != null && !rootFeature.isEmpty();
		case FeaturemodelingPackage.FEATURE_MODEL__FEATURE_LINK:
			return featureLink != null && !featureLink.isEmpty();
		case FeaturemodelingPackage.FEATURE_MODEL__FEATURE_CONSTRAINT:
			return featureConstraint != null && !featureConstraint.isEmpty();
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
		case FeaturemodelingPackage.FEATURE_MODEL__BASE_PACKAGE:
			setBase_Package((org.eclipse.uml2.uml.Package)newValue);
			return;
		case FeaturemodelingPackage.FEATURE_MODEL__BASE_CLASS:
			setBase_Class((org.eclipse.uml2.uml.Class)newValue);
			return;
		case FeaturemodelingPackage.FEATURE_MODEL__ROOT_FEATURE:
			getRootFeature().clear();
			getRootFeature().addAll((Collection<? extends Feature>)newValue);
			return;
		case FeaturemodelingPackage.FEATURE_MODEL__FEATURE_LINK:
			getFeatureLink().clear();
			getFeatureLink().addAll((Collection<? extends FeatureLink>)newValue);
			return;
		case FeaturemodelingPackage.FEATURE_MODEL__FEATURE_CONSTRAINT:
			getFeatureConstraint().clear();
			getFeatureConstraint().addAll((Collection<? extends FeatureConstraint>)newValue);
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
		return FeaturemodelingPackage.Literals.FEATURE_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public org.eclipse.uml2.uml.Package getBase_Package() {
		if(base_Package != null && base_Package.eIsProxy()) {
			InternalEObject oldBase_Package = (InternalEObject)base_Package;
			base_Package = (org.eclipse.uml2.uml.Package)eResolveProxy(oldBase_Package);
			if(base_Package != oldBase_Package) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FeaturemodelingPackage.FEATURE_MODEL__BASE_PACKAGE, oldBase_Package, base_Package));
			}
		}
		return base_Package;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public org.eclipse.uml2.uml.Package basicGetBase_Package() {
		return base_Package;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setBase_Package(org.eclipse.uml2.uml.Package newBase_Package) {
		org.eclipse.uml2.uml.Package oldBase_Package = base_Package;
		base_Package = newBase_Package;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FeaturemodelingPackage.FEATURE_MODEL__BASE_PACKAGE, oldBase_Package, base_Package));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FeaturemodelingPackage.FEATURE_MODEL__BASE_CLASS, oldBase_Class, base_Class));
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
			eNotify(new ENotificationImpl(this, Notification.SET, FeaturemodelingPackage.FEATURE_MODEL__BASE_CLASS, oldBase_Class, base_Class));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch(featureID) {
		case FeaturemodelingPackage.FEATURE_MODEL__BASE_PACKAGE:
			setBase_Package((org.eclipse.uml2.uml.Package)null);
			return;
		case FeaturemodelingPackage.FEATURE_MODEL__BASE_CLASS:
			setBase_Class((org.eclipse.uml2.uml.Class)null);
			return;
		case FeaturemodelingPackage.FEATURE_MODEL__ROOT_FEATURE:
			getRootFeature().clear();
			return;
		case FeaturemodelingPackage.FEATURE_MODEL__FEATURE_LINK:
			getFeatureLink().clear();
			return;
		case FeaturemodelingPackage.FEATURE_MODEL__FEATURE_CONSTRAINT:
			getFeatureConstraint().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<FeatureConstraint> getFeatureConstraint() {
		if(featureConstraint == null) {
			featureConstraint = new EObjectResolvingEList<FeatureConstraint>(FeatureConstraint.class, this, FeaturemodelingPackage.FEATURE_MODEL__FEATURE_CONSTRAINT);
		}
		return featureConstraint;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<FeatureLink> getFeatureLink() {
		if(featureLink == null) {
			featureLink = new EObjectResolvingEList<FeatureLink>(FeatureLink.class, this, FeaturemodelingPackage.FEATURE_MODEL__FEATURE_LINK);
		}
		return featureLink;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<Feature> getRootFeature() {
		if(rootFeature == null) {
			rootFeature = new EObjectResolvingEList<Feature>(Feature.class, this, FeaturemodelingPackage.FEATURE_MODEL__ROOT_FEATURE);
		}
		return rootFeature;
	}

} // FeatureModelImpl
