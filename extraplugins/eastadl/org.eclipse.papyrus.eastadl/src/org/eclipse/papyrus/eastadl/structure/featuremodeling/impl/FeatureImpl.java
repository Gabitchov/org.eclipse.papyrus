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
import org.eclipse.papyrus.eastadl.infrastructure.datatypes.EADatatypePrototype;
import org.eclipse.papyrus.eastadl.structure.featuremodeling.BindingTime;
import org.eclipse.papyrus.eastadl.structure.featuremodeling.Feature;
import org.eclipse.papyrus.eastadl.structure.featuremodeling.FeatureTreeNode;
import org.eclipse.papyrus.eastadl.structure.featuremodeling.FeaturemodelingPackage;


/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Feature</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.impl.FeatureImpl#getBase_Class <em>Base Class</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.impl.FeatureImpl#getCardinality <em>Cardinality</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.impl.FeatureImpl#getRequiredBindingTime <em>Required Binding Time</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.impl.FeatureImpl#getActualBindingTime <em>Actual Binding Time</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.impl.FeatureImpl#getFeatureParameter <em>Feature Parameter</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.featuremodeling.impl.FeatureImpl#getChildNode <em>Child Node</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class FeatureImpl extends FeatureTreeNodeImpl implements Feature {

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
	 * The default value of the '{@link #getCardinality() <em>Cardinality</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
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
	 * The cached value of the '{@link #getRequiredBindingTime() <em>Required Binding Time</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getRequiredBindingTime()
	 * @generated
	 * @ordered
	 */
	protected BindingTime requiredBindingTime;

	/**
	 * The cached value of the '{@link #getActualBindingTime() <em>Actual Binding Time</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getActualBindingTime()
	 * @generated
	 * @ordered
	 */
	protected BindingTime actualBindingTime;

	/**
	 * The cached value of the '{@link #getFeatureParameter() <em>Feature Parameter</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getFeatureParameter()
	 * @generated
	 * @ordered
	 */
	protected EADatatypePrototype featureParameter;

	/**
	 * The cached value of the '{@link #getChildNode() <em>Child Node</em>}' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getChildNode()
	 * @generated
	 * @ordered
	 */
	protected EList<FeatureTreeNode> childNode;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected FeatureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public BindingTime basicGetActualBindingTime() {
		return actualBindingTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EADatatypePrototype basicGetFeatureParameter() {
		return featureParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setFeatureParameter(EADatatypePrototype newFeatureParameter) {
		EADatatypePrototype oldFeatureParameter = featureParameter;
		featureParameter = newFeatureParameter;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FeaturemodelingPackage.FEATURE__FEATURE_PARAMETER, oldFeatureParameter, featureParameter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public BindingTime basicGetRequiredBindingTime() {
		return requiredBindingTime;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch(featureID) {
		case FeaturemodelingPackage.FEATURE__BASE_CLASS:
			if(resolve)
				return getBase_Class();
			return basicGetBase_Class();
		case FeaturemodelingPackage.FEATURE__CARDINALITY:
			return getCardinality();
		case FeaturemodelingPackage.FEATURE__REQUIRED_BINDING_TIME:
			if(resolve)
				return getRequiredBindingTime();
			return basicGetRequiredBindingTime();
		case FeaturemodelingPackage.FEATURE__ACTUAL_BINDING_TIME:
			if(resolve)
				return getActualBindingTime();
			return basicGetActualBindingTime();
		case FeaturemodelingPackage.FEATURE__FEATURE_PARAMETER:
			if(resolve)
				return getFeatureParameter();
			return basicGetFeatureParameter();
		case FeaturemodelingPackage.FEATURE__CHILD_NODE:
			return getChildNode();
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
		case FeaturemodelingPackage.FEATURE__BASE_CLASS:
			return base_Class != null;
		case FeaturemodelingPackage.FEATURE__CARDINALITY:
			return CARDINALITY_EDEFAULT == null ? cardinality != null : !CARDINALITY_EDEFAULT.equals(cardinality);
		case FeaturemodelingPackage.FEATURE__REQUIRED_BINDING_TIME:
			return requiredBindingTime != null;
		case FeaturemodelingPackage.FEATURE__ACTUAL_BINDING_TIME:
			return actualBindingTime != null;
		case FeaturemodelingPackage.FEATURE__FEATURE_PARAMETER:
			return featureParameter != null;
		case FeaturemodelingPackage.FEATURE__CHILD_NODE:
			return childNode != null && !childNode.isEmpty();
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
		case FeaturemodelingPackage.FEATURE__BASE_CLASS:
			setBase_Class((org.eclipse.uml2.uml.Class)newValue);
			return;
		case FeaturemodelingPackage.FEATURE__CARDINALITY:
			setCardinality((String)newValue);
			return;
		case FeaturemodelingPackage.FEATURE__REQUIRED_BINDING_TIME:
			setRequiredBindingTime((BindingTime)newValue);
			return;
		case FeaturemodelingPackage.FEATURE__ACTUAL_BINDING_TIME:
			setActualBindingTime((BindingTime)newValue);
			return;
		case FeaturemodelingPackage.FEATURE__FEATURE_PARAMETER:
			setFeatureParameter((EADatatypePrototype)newValue);
			return;
		case FeaturemodelingPackage.FEATURE__CHILD_NODE:
			getChildNode().clear();
			getChildNode().addAll((Collection<? extends FeatureTreeNode>)newValue);
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
		return FeaturemodelingPackage.Literals.FEATURE;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FeaturemodelingPackage.FEATURE__BASE_CLASS, oldBase_Class, base_Class));
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
			eNotify(new ENotificationImpl(this, Notification.SET, FeaturemodelingPackage.FEATURE__BASE_CLASS, oldBase_Class, base_Class));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch(featureID) {
		case FeaturemodelingPackage.FEATURE__BASE_CLASS:
			setBase_Class((org.eclipse.uml2.uml.Class)null);
			return;
		case FeaturemodelingPackage.FEATURE__CARDINALITY:
			setCardinality(CARDINALITY_EDEFAULT);
			return;
		case FeaturemodelingPackage.FEATURE__REQUIRED_BINDING_TIME:
			setRequiredBindingTime((BindingTime)null);
			return;
		case FeaturemodelingPackage.FEATURE__ACTUAL_BINDING_TIME:
			setActualBindingTime((BindingTime)null);
			return;
		case FeaturemodelingPackage.FEATURE__FEATURE_PARAMETER:
			setFeatureParameter((EADatatypePrototype)null);
			return;
		case FeaturemodelingPackage.FEATURE__CHILD_NODE:
			getChildNode().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public BindingTime getActualBindingTime() {
		if(actualBindingTime != null && actualBindingTime.eIsProxy()) {
			InternalEObject oldActualBindingTime = (InternalEObject)actualBindingTime;
			actualBindingTime = (BindingTime)eResolveProxy(oldActualBindingTime);
			if(actualBindingTime != oldActualBindingTime) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FeaturemodelingPackage.FEATURE__ACTUAL_BINDING_TIME, oldActualBindingTime, actualBindingTime));
			}
		}
		return actualBindingTime;
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
	public EList<FeatureTreeNode> getChildNode() {
		if(childNode == null) {
			childNode = new EObjectResolvingEList<FeatureTreeNode>(FeatureTreeNode.class, this, FeaturemodelingPackage.FEATURE__CHILD_NODE);
		}
		return childNode;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EADatatypePrototype getFeatureParameter() {
		if(featureParameter != null && featureParameter.eIsProxy()) {
			InternalEObject oldFeatureParameter = (InternalEObject)featureParameter;
			featureParameter = (EADatatypePrototype)eResolveProxy(oldFeatureParameter);
			if(featureParameter != oldFeatureParameter) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FeaturemodelingPackage.FEATURE__FEATURE_PARAMETER, oldFeatureParameter, featureParameter));
			}
		}
		return featureParameter;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public BindingTime getRequiredBindingTime() {
		if(requiredBindingTime != null && requiredBindingTime.eIsProxy()) {
			InternalEObject oldRequiredBindingTime = (InternalEObject)requiredBindingTime;
			requiredBindingTime = (BindingTime)eResolveProxy(oldRequiredBindingTime);
			if(requiredBindingTime != oldRequiredBindingTime) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FeaturemodelingPackage.FEATURE__REQUIRED_BINDING_TIME, oldRequiredBindingTime, requiredBindingTime));
			}
		}
		return requiredBindingTime;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setActualBindingTime(BindingTime newActualBindingTime) {
		BindingTime oldActualBindingTime = actualBindingTime;
		actualBindingTime = newActualBindingTime;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FeaturemodelingPackage.FEATURE__ACTUAL_BINDING_TIME, oldActualBindingTime, actualBindingTime));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setCardinality(String newCardinality) {
		String oldCardinality = cardinality;
		cardinality = newCardinality;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FeaturemodelingPackage.FEATURE__CARDINALITY, oldCardinality, cardinality));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setRequiredBindingTime(BindingTime newRequiredBindingTime) {
		BindingTime oldRequiredBindingTime = requiredBindingTime;
		requiredBindingTime = newRequiredBindingTime;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FeaturemodelingPackage.FEATURE__REQUIRED_BINDING_TIME, oldRequiredBindingTime, requiredBindingTime));
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
		result.append(" (cardinality: ");
		result.append(cardinality);
		result.append(')');
		return result.toString();
	}

} // FeatureImpl
