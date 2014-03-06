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
import org.eclipse.papyrus.eastadl.infrastructure.elements.impl.EAElementImpl;
import org.eclipse.papyrus.eastadl.structure.vehiclefeaturemodeling.DeviationAttributeSet;
import org.eclipse.papyrus.eastadl.structure.vehiclefeaturemodeling.DeviationPermissionKind;
import org.eclipse.papyrus.eastadl.structure.vehiclefeaturemodeling.VehicleFeature;
import org.eclipse.papyrus.eastadl.structure.vehiclefeaturemodeling.VehiclefeaturemodelingPackage;
import org.eclipse.uml2.uml.DataType;


/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Deviation Attribute Set</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.vehiclefeaturemodeling.impl.DeviationAttributeSetImpl#getAllowChangeAttribute <em>Allow Change
 * Attribute</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.vehiclefeaturemodeling.impl.DeviationAttributeSetImpl#getAllowChangeCardinality <em>Allow Change
 * Cardinality</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.vehiclefeaturemodeling.impl.DeviationAttributeSetImpl#getAllowChangeDescription <em>Allow Change
 * Description</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.vehiclefeaturemodeling.impl.DeviationAttributeSetImpl#getAllowChangeName <em>Allow Change Name
 * </em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.vehiclefeaturemodeling.impl.DeviationAttributeSetImpl#getAllowMove <em>Allow Move</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.vehiclefeaturemodeling.impl.DeviationAttributeSetImpl#getAllowReduction <em>Allow Reduction</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.vehiclefeaturemodeling.impl.DeviationAttributeSetImpl#getAllowRefinement <em>Allow Refinement
 * </em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.vehiclefeaturemodeling.impl.DeviationAttributeSetImpl#getAllowRegrouping <em>Allow Regrouping
 * </em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.vehiclefeaturemodeling.impl.DeviationAttributeSetImpl#getAllowRemoval <em>Allow Removal</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.vehiclefeaturemodeling.impl.DeviationAttributeSetImpl#getBase_DataType <em>Base Data Type</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.vehiclefeaturemodeling.impl.DeviationAttributeSetImpl#getFeature <em>Feature</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class DeviationAttributeSetImpl extends EAElementImpl implements DeviationAttributeSet {

	/**
	 * The default value of the '{@link #getAllowChangeAttribute() <em>Allow Change Attribute</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getAllowChangeAttribute()
	 * @generated
	 * @ordered
	 */
	protected static final DeviationPermissionKind ALLOW_CHANGE_ATTRIBUTE_EDEFAULT = DeviationPermissionKind.YES;

	/**
	 * The cached value of the '{@link #getAllowChangeAttribute() <em>Allow Change Attribute</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getAllowChangeAttribute()
	 * @generated
	 * @ordered
	 */
	protected DeviationPermissionKind allowChangeAttribute = ALLOW_CHANGE_ATTRIBUTE_EDEFAULT;

	/**
	 * The default value of the '{@link #getAllowChangeCardinality() <em>Allow Change Cardinality</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getAllowChangeCardinality()
	 * @generated
	 * @ordered
	 */
	protected static final DeviationPermissionKind ALLOW_CHANGE_CARDINALITY_EDEFAULT = DeviationPermissionKind.YES;

	/**
	 * The cached value of the '{@link #getAllowChangeCardinality() <em>Allow Change Cardinality</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getAllowChangeCardinality()
	 * @generated
	 * @ordered
	 */
	protected DeviationPermissionKind allowChangeCardinality = ALLOW_CHANGE_CARDINALITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getAllowChangeDescription() <em>Allow Change Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getAllowChangeDescription()
	 * @generated
	 * @ordered
	 */
	protected static final DeviationPermissionKind ALLOW_CHANGE_DESCRIPTION_EDEFAULT = DeviationPermissionKind.YES;

	/**
	 * The cached value of the '{@link #getAllowChangeDescription() <em>Allow Change Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getAllowChangeDescription()
	 * @generated
	 * @ordered
	 */
	protected DeviationPermissionKind allowChangeDescription = ALLOW_CHANGE_DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getAllowChangeName() <em>Allow Change Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getAllowChangeName()
	 * @generated
	 * @ordered
	 */
	protected static final DeviationPermissionKind ALLOW_CHANGE_NAME_EDEFAULT = DeviationPermissionKind.YES;

	/**
	 * The cached value of the '{@link #getAllowChangeName() <em>Allow Change Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getAllowChangeName()
	 * @generated
	 * @ordered
	 */
	protected DeviationPermissionKind allowChangeName = ALLOW_CHANGE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getAllowMove() <em>Allow Move</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getAllowMove()
	 * @generated
	 * @ordered
	 */
	protected static final DeviationPermissionKind ALLOW_MOVE_EDEFAULT = DeviationPermissionKind.YES;

	/**
	 * The cached value of the '{@link #getAllowMove() <em>Allow Move</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getAllowMove()
	 * @generated
	 * @ordered
	 */
	protected DeviationPermissionKind allowMove = ALLOW_MOVE_EDEFAULT;

	/**
	 * The default value of the '{@link #getAllowReduction() <em>Allow Reduction</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getAllowReduction()
	 * @generated
	 * @ordered
	 */
	protected static final DeviationPermissionKind ALLOW_REDUCTION_EDEFAULT = DeviationPermissionKind.YES;

	/**
	 * The cached value of the '{@link #getAllowReduction() <em>Allow Reduction</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getAllowReduction()
	 * @generated
	 * @ordered
	 */
	protected DeviationPermissionKind allowReduction = ALLOW_REDUCTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getAllowRefinement() <em>Allow Refinement</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getAllowRefinement()
	 * @generated
	 * @ordered
	 */
	protected static final DeviationPermissionKind ALLOW_REFINEMENT_EDEFAULT = DeviationPermissionKind.YES;

	/**
	 * The cached value of the '{@link #getAllowRefinement() <em>Allow Refinement</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getAllowRefinement()
	 * @generated
	 * @ordered
	 */
	protected DeviationPermissionKind allowRefinement = ALLOW_REFINEMENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getAllowRegrouping() <em>Allow Regrouping</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getAllowRegrouping()
	 * @generated
	 * @ordered
	 */
	protected static final DeviationPermissionKind ALLOW_REGROUPING_EDEFAULT = DeviationPermissionKind.YES;

	/**
	 * The cached value of the '{@link #getAllowRegrouping() <em>Allow Regrouping</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getAllowRegrouping()
	 * @generated
	 * @ordered
	 */
	protected DeviationPermissionKind allowRegrouping = ALLOW_REGROUPING_EDEFAULT;

	/**
	 * The default value of the '{@link #getAllowRemoval() <em>Allow Removal</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getAllowRemoval()
	 * @generated
	 * @ordered
	 */
	protected static final DeviationPermissionKind ALLOW_REMOVAL_EDEFAULT = DeviationPermissionKind.YES;

	/**
	 * The cached value of the '{@link #getAllowRemoval() <em>Allow Removal</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getAllowRemoval()
	 * @generated
	 * @ordered
	 */
	protected DeviationPermissionKind allowRemoval = ALLOW_REMOVAL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBase_DataType() <em>Base Data Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getBase_DataType()
	 * @generated
	 * @ordered
	 */
	protected DataType base_DataType;

	/**
	 * The cached value of the '{@link #getFeature() <em>Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getFeature()
	 * @generated
	 * @ordered
	 */
	protected VehicleFeature feature;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected DeviationAttributeSetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public VehicleFeature basicGetFeature() {
		return feature;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetFeature(VehicleFeature newFeature, NotificationChain msgs) {
		VehicleFeature oldFeature = feature;
		feature = newFeature;
		if(eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VehiclefeaturemodelingPackage.DEVIATION_ATTRIBUTE_SET__FEATURE, oldFeature, newFeature);
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
		case VehiclefeaturemodelingPackage.DEVIATION_ATTRIBUTE_SET__ALLOW_CHANGE_ATTRIBUTE:
			return getAllowChangeAttribute();
		case VehiclefeaturemodelingPackage.DEVIATION_ATTRIBUTE_SET__ALLOW_CHANGE_CARDINALITY:
			return getAllowChangeCardinality();
		case VehiclefeaturemodelingPackage.DEVIATION_ATTRIBUTE_SET__ALLOW_CHANGE_DESCRIPTION:
			return getAllowChangeDescription();
		case VehiclefeaturemodelingPackage.DEVIATION_ATTRIBUTE_SET__ALLOW_CHANGE_NAME:
			return getAllowChangeName();
		case VehiclefeaturemodelingPackage.DEVIATION_ATTRIBUTE_SET__ALLOW_MOVE:
			return getAllowMove();
		case VehiclefeaturemodelingPackage.DEVIATION_ATTRIBUTE_SET__ALLOW_REDUCTION:
			return getAllowReduction();
		case VehiclefeaturemodelingPackage.DEVIATION_ATTRIBUTE_SET__ALLOW_REFINEMENT:
			return getAllowRefinement();
		case VehiclefeaturemodelingPackage.DEVIATION_ATTRIBUTE_SET__ALLOW_REGROUPING:
			return getAllowRegrouping();
		case VehiclefeaturemodelingPackage.DEVIATION_ATTRIBUTE_SET__ALLOW_REMOVAL:
			return getAllowRemoval();
		case VehiclefeaturemodelingPackage.DEVIATION_ATTRIBUTE_SET__BASE_DATA_TYPE:
			if(resolve)
				return getBase_DataType();
			return basicGetBase_DataType();
		case VehiclefeaturemodelingPackage.DEVIATION_ATTRIBUTE_SET__FEATURE:
			if(resolve)
				return getFeature();
			return basicGetFeature();
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
		case VehiclefeaturemodelingPackage.DEVIATION_ATTRIBUTE_SET__FEATURE:
			if(feature != null)
				msgs = ((InternalEObject)feature).eInverseRemove(this, VehiclefeaturemodelingPackage.VEHICLE_FEATURE__DEVIATION_ATTRIBUTE_SET, VehicleFeature.class, msgs);
			return basicSetFeature((VehicleFeature)otherEnd, msgs);
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
		case VehiclefeaturemodelingPackage.DEVIATION_ATTRIBUTE_SET__FEATURE:
			return basicSetFeature(null, msgs);
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
		case VehiclefeaturemodelingPackage.DEVIATION_ATTRIBUTE_SET__ALLOW_CHANGE_ATTRIBUTE:
			return allowChangeAttribute != ALLOW_CHANGE_ATTRIBUTE_EDEFAULT;
		case VehiclefeaturemodelingPackage.DEVIATION_ATTRIBUTE_SET__ALLOW_CHANGE_CARDINALITY:
			return allowChangeCardinality != ALLOW_CHANGE_CARDINALITY_EDEFAULT;
		case VehiclefeaturemodelingPackage.DEVIATION_ATTRIBUTE_SET__ALLOW_CHANGE_DESCRIPTION:
			return allowChangeDescription != ALLOW_CHANGE_DESCRIPTION_EDEFAULT;
		case VehiclefeaturemodelingPackage.DEVIATION_ATTRIBUTE_SET__ALLOW_CHANGE_NAME:
			return allowChangeName != ALLOW_CHANGE_NAME_EDEFAULT;
		case VehiclefeaturemodelingPackage.DEVIATION_ATTRIBUTE_SET__ALLOW_MOVE:
			return allowMove != ALLOW_MOVE_EDEFAULT;
		case VehiclefeaturemodelingPackage.DEVIATION_ATTRIBUTE_SET__ALLOW_REDUCTION:
			return allowReduction != ALLOW_REDUCTION_EDEFAULT;
		case VehiclefeaturemodelingPackage.DEVIATION_ATTRIBUTE_SET__ALLOW_REFINEMENT:
			return allowRefinement != ALLOW_REFINEMENT_EDEFAULT;
		case VehiclefeaturemodelingPackage.DEVIATION_ATTRIBUTE_SET__ALLOW_REGROUPING:
			return allowRegrouping != ALLOW_REGROUPING_EDEFAULT;
		case VehiclefeaturemodelingPackage.DEVIATION_ATTRIBUTE_SET__ALLOW_REMOVAL:
			return allowRemoval != ALLOW_REMOVAL_EDEFAULT;
		case VehiclefeaturemodelingPackage.DEVIATION_ATTRIBUTE_SET__BASE_DATA_TYPE:
			return base_DataType != null;
		case VehiclefeaturemodelingPackage.DEVIATION_ATTRIBUTE_SET__FEATURE:
			return feature != null;
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
		case VehiclefeaturemodelingPackage.DEVIATION_ATTRIBUTE_SET__ALLOW_CHANGE_ATTRIBUTE:
			setAllowChangeAttribute((DeviationPermissionKind)newValue);
			return;
		case VehiclefeaturemodelingPackage.DEVIATION_ATTRIBUTE_SET__ALLOW_CHANGE_CARDINALITY:
			setAllowChangeCardinality((DeviationPermissionKind)newValue);
			return;
		case VehiclefeaturemodelingPackage.DEVIATION_ATTRIBUTE_SET__ALLOW_CHANGE_DESCRIPTION:
			setAllowChangeDescription((DeviationPermissionKind)newValue);
			return;
		case VehiclefeaturemodelingPackage.DEVIATION_ATTRIBUTE_SET__ALLOW_CHANGE_NAME:
			setAllowChangeName((DeviationPermissionKind)newValue);
			return;
		case VehiclefeaturemodelingPackage.DEVIATION_ATTRIBUTE_SET__ALLOW_MOVE:
			setAllowMove((DeviationPermissionKind)newValue);
			return;
		case VehiclefeaturemodelingPackage.DEVIATION_ATTRIBUTE_SET__ALLOW_REDUCTION:
			setAllowReduction((DeviationPermissionKind)newValue);
			return;
		case VehiclefeaturemodelingPackage.DEVIATION_ATTRIBUTE_SET__ALLOW_REFINEMENT:
			setAllowRefinement((DeviationPermissionKind)newValue);
			return;
		case VehiclefeaturemodelingPackage.DEVIATION_ATTRIBUTE_SET__ALLOW_REGROUPING:
			setAllowRegrouping((DeviationPermissionKind)newValue);
			return;
		case VehiclefeaturemodelingPackage.DEVIATION_ATTRIBUTE_SET__ALLOW_REMOVAL:
			setAllowRemoval((DeviationPermissionKind)newValue);
			return;
		case VehiclefeaturemodelingPackage.DEVIATION_ATTRIBUTE_SET__BASE_DATA_TYPE:
			setBase_DataType((DataType)newValue);
			return;
		case VehiclefeaturemodelingPackage.DEVIATION_ATTRIBUTE_SET__FEATURE:
			setFeature((VehicleFeature)newValue);
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
		return VehiclefeaturemodelingPackage.Literals.DEVIATION_ATTRIBUTE_SET;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch(featureID) {
		case VehiclefeaturemodelingPackage.DEVIATION_ATTRIBUTE_SET__ALLOW_CHANGE_ATTRIBUTE:
			setAllowChangeAttribute(ALLOW_CHANGE_ATTRIBUTE_EDEFAULT);
			return;
		case VehiclefeaturemodelingPackage.DEVIATION_ATTRIBUTE_SET__ALLOW_CHANGE_CARDINALITY:
			setAllowChangeCardinality(ALLOW_CHANGE_CARDINALITY_EDEFAULT);
			return;
		case VehiclefeaturemodelingPackage.DEVIATION_ATTRIBUTE_SET__ALLOW_CHANGE_DESCRIPTION:
			setAllowChangeDescription(ALLOW_CHANGE_DESCRIPTION_EDEFAULT);
			return;
		case VehiclefeaturemodelingPackage.DEVIATION_ATTRIBUTE_SET__ALLOW_CHANGE_NAME:
			setAllowChangeName(ALLOW_CHANGE_NAME_EDEFAULT);
			return;
		case VehiclefeaturemodelingPackage.DEVIATION_ATTRIBUTE_SET__ALLOW_MOVE:
			setAllowMove(ALLOW_MOVE_EDEFAULT);
			return;
		case VehiclefeaturemodelingPackage.DEVIATION_ATTRIBUTE_SET__ALLOW_REDUCTION:
			setAllowReduction(ALLOW_REDUCTION_EDEFAULT);
			return;
		case VehiclefeaturemodelingPackage.DEVIATION_ATTRIBUTE_SET__ALLOW_REFINEMENT:
			setAllowRefinement(ALLOW_REFINEMENT_EDEFAULT);
			return;
		case VehiclefeaturemodelingPackage.DEVIATION_ATTRIBUTE_SET__ALLOW_REGROUPING:
			setAllowRegrouping(ALLOW_REGROUPING_EDEFAULT);
			return;
		case VehiclefeaturemodelingPackage.DEVIATION_ATTRIBUTE_SET__ALLOW_REMOVAL:
			setAllowRemoval(ALLOW_REMOVAL_EDEFAULT);
			return;
		case VehiclefeaturemodelingPackage.DEVIATION_ATTRIBUTE_SET__BASE_DATA_TYPE:
			setBase_DataType((DataType)null);
			return;
		case VehiclefeaturemodelingPackage.DEVIATION_ATTRIBUTE_SET__FEATURE:
			setFeature((VehicleFeature)null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DeviationPermissionKind getAllowChangeAttribute() {
		return allowChangeAttribute;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DeviationPermissionKind getAllowChangeCardinality() {
		return allowChangeCardinality;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DeviationPermissionKind getAllowChangeDescription() {
		return allowChangeDescription;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DeviationPermissionKind getAllowChangeName() {
		return allowChangeName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DeviationPermissionKind getAllowMove() {
		return allowMove;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DeviationPermissionKind getAllowReduction() {
		return allowReduction;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DeviationPermissionKind getAllowRefinement() {
		return allowRefinement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DeviationPermissionKind getAllowRegrouping() {
		return allowRegrouping;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DeviationPermissionKind getAllowRemoval() {
		return allowRemoval;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public VehicleFeature getFeature() {
		if(feature != null && feature.eIsProxy()) {
			InternalEObject oldFeature = (InternalEObject)feature;
			feature = (VehicleFeature)eResolveProxy(oldFeature);
			if(feature != oldFeature) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, VehiclefeaturemodelingPackage.DEVIATION_ATTRIBUTE_SET__FEATURE, oldFeature, feature));
			}
		}
		return feature;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setAllowChangeAttribute(DeviationPermissionKind newAllowChangeAttribute) {
		DeviationPermissionKind oldAllowChangeAttribute = allowChangeAttribute;
		allowChangeAttribute = newAllowChangeAttribute == null ? ALLOW_CHANGE_ATTRIBUTE_EDEFAULT : newAllowChangeAttribute;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VehiclefeaturemodelingPackage.DEVIATION_ATTRIBUTE_SET__ALLOW_CHANGE_ATTRIBUTE, oldAllowChangeAttribute, allowChangeAttribute));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setAllowChangeCardinality(DeviationPermissionKind newAllowChangeCardinality) {
		DeviationPermissionKind oldAllowChangeCardinality = allowChangeCardinality;
		allowChangeCardinality = newAllowChangeCardinality == null ? ALLOW_CHANGE_CARDINALITY_EDEFAULT : newAllowChangeCardinality;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VehiclefeaturemodelingPackage.DEVIATION_ATTRIBUTE_SET__ALLOW_CHANGE_CARDINALITY, oldAllowChangeCardinality, allowChangeCardinality));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setAllowChangeDescription(DeviationPermissionKind newAllowChangeDescription) {
		DeviationPermissionKind oldAllowChangeDescription = allowChangeDescription;
		allowChangeDescription = newAllowChangeDescription == null ? ALLOW_CHANGE_DESCRIPTION_EDEFAULT : newAllowChangeDescription;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VehiclefeaturemodelingPackage.DEVIATION_ATTRIBUTE_SET__ALLOW_CHANGE_DESCRIPTION, oldAllowChangeDescription, allowChangeDescription));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setAllowChangeName(DeviationPermissionKind newAllowChangeName) {
		DeviationPermissionKind oldAllowChangeName = allowChangeName;
		allowChangeName = newAllowChangeName == null ? ALLOW_CHANGE_NAME_EDEFAULT : newAllowChangeName;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VehiclefeaturemodelingPackage.DEVIATION_ATTRIBUTE_SET__ALLOW_CHANGE_NAME, oldAllowChangeName, allowChangeName));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setAllowMove(DeviationPermissionKind newAllowMove) {
		DeviationPermissionKind oldAllowMove = allowMove;
		allowMove = newAllowMove == null ? ALLOW_MOVE_EDEFAULT : newAllowMove;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VehiclefeaturemodelingPackage.DEVIATION_ATTRIBUTE_SET__ALLOW_MOVE, oldAllowMove, allowMove));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setAllowReduction(DeviationPermissionKind newAllowReduction) {
		DeviationPermissionKind oldAllowReduction = allowReduction;
		allowReduction = newAllowReduction == null ? ALLOW_REDUCTION_EDEFAULT : newAllowReduction;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VehiclefeaturemodelingPackage.DEVIATION_ATTRIBUTE_SET__ALLOW_REDUCTION, oldAllowReduction, allowReduction));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setAllowRefinement(DeviationPermissionKind newAllowRefinement) {
		DeviationPermissionKind oldAllowRefinement = allowRefinement;
		allowRefinement = newAllowRefinement == null ? ALLOW_REFINEMENT_EDEFAULT : newAllowRefinement;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VehiclefeaturemodelingPackage.DEVIATION_ATTRIBUTE_SET__ALLOW_REFINEMENT, oldAllowRefinement, allowRefinement));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setAllowRegrouping(DeviationPermissionKind newAllowRegrouping) {
		DeviationPermissionKind oldAllowRegrouping = allowRegrouping;
		allowRegrouping = newAllowRegrouping == null ? ALLOW_REGROUPING_EDEFAULT : newAllowRegrouping;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VehiclefeaturemodelingPackage.DEVIATION_ATTRIBUTE_SET__ALLOW_REGROUPING, oldAllowRegrouping, allowRegrouping));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setAllowRemoval(DeviationPermissionKind newAllowRemoval) {
		DeviationPermissionKind oldAllowRemoval = allowRemoval;
		allowRemoval = newAllowRemoval == null ? ALLOW_REMOVAL_EDEFAULT : newAllowRemoval;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VehiclefeaturemodelingPackage.DEVIATION_ATTRIBUTE_SET__ALLOW_REMOVAL, oldAllowRemoval, allowRemoval));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DataType getBase_DataType() {
		if(base_DataType != null && base_DataType.eIsProxy()) {
			InternalEObject oldBase_DataType = (InternalEObject)base_DataType;
			base_DataType = (DataType)eResolveProxy(oldBase_DataType);
			if(base_DataType != oldBase_DataType) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, VehiclefeaturemodelingPackage.DEVIATION_ATTRIBUTE_SET__BASE_DATA_TYPE, oldBase_DataType, base_DataType));
			}
		}
		return base_DataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DataType basicGetBase_DataType() {
		return base_DataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setBase_DataType(DataType newBase_DataType) {
		DataType oldBase_DataType = base_DataType;
		base_DataType = newBase_DataType;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VehiclefeaturemodelingPackage.DEVIATION_ATTRIBUTE_SET__BASE_DATA_TYPE, oldBase_DataType, base_DataType));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setFeature(VehicleFeature newFeature) {
		if(newFeature != feature) {
			NotificationChain msgs = null;
			if(feature != null)
				msgs = ((InternalEObject)feature).eInverseRemove(this, VehiclefeaturemodelingPackage.VEHICLE_FEATURE__DEVIATION_ATTRIBUTE_SET, VehicleFeature.class, msgs);
			if(newFeature != null)
				msgs = ((InternalEObject)newFeature).eInverseAdd(this, VehiclefeaturemodelingPackage.VEHICLE_FEATURE__DEVIATION_ATTRIBUTE_SET, VehicleFeature.class, msgs);
			msgs = basicSetFeature(newFeature, msgs);
			if(msgs != null)
				msgs.dispatch();
		} else if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VehiclefeaturemodelingPackage.DEVIATION_ATTRIBUTE_SET__FEATURE, newFeature, newFeature));
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
		result.append(" (allowChangeAttribute: ");
		result.append(allowChangeAttribute);
		result.append(", allowChangeCardinality: ");
		result.append(allowChangeCardinality);
		result.append(", allowChangeDescription: ");
		result.append(allowChangeDescription);
		result.append(", allowChangeName: ");
		result.append(allowChangeName);
		result.append(", allowMove: ");
		result.append(allowMove);
		result.append(", allowReduction: ");
		result.append(allowReduction);
		result.append(", allowRefinement: ");
		result.append(allowRefinement);
		result.append(", allowRegrouping: ");
		result.append(allowRegrouping);
		result.append(", allowRemoval: ");
		result.append(allowRemoval);
		result.append(')');
		return result.toString();
	}

} // DeviationAttributeSetImpl
