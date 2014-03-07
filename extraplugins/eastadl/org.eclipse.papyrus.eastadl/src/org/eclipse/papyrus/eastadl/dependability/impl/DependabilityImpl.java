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
import org.eclipse.papyrus.eastadl.dependability.Dependability;
import org.eclipse.papyrus.eastadl.dependability.DependabilityPackage;
import org.eclipse.papyrus.eastadl.dependability.FeatureFlaw;
import org.eclipse.papyrus.eastadl.dependability.HazardousEvent;
import org.eclipse.papyrus.eastadl.dependability.Item;
import org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorModelType;
import org.eclipse.papyrus.eastadl.dependability.safetycase.SafetyCase;
import org.eclipse.papyrus.eastadl.dependability.safetyconstraints.FaultFailure;
import org.eclipse.papyrus.eastadl.dependability.safetyconstraints.QuantitativeSafetyConstraint;
import org.eclipse.papyrus.eastadl.dependability.safetyconstraints.SafetyConstraint;
import org.eclipse.papyrus.eastadl.dependability.safetyrequirement.FunctionalSafetyConcept;
import org.eclipse.papyrus.eastadl.dependability.safetyrequirement.SafetyGoal;
import org.eclipse.papyrus.eastadl.dependability.safetyrequirement.TechnicalSafetyConcept;
import org.eclipse.papyrus.eastadl.infrastructure.datatypes.EADatatype;
import org.eclipse.papyrus.eastadl.infrastructure.elements.impl.ContextImpl;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dependability</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.impl.DependabilityImpl#getBase_Class <em>Base Class</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.impl.DependabilityImpl#getBase_Package <em>Base Package</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.impl.DependabilityImpl#getFunctionalSafetyConcept <em>Functional Safety Concept</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.impl.DependabilityImpl#getSafetyGoal <em>Safety Goal</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.impl.DependabilityImpl#getTechnicalSafetyConcept <em>Technical Safety Concept</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.impl.DependabilityImpl#getHazardousEvent <em>Hazardous Event</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.impl.DependabilityImpl#getFeatureFlaw <em>Feature Flaw</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.impl.DependabilityImpl#getItem <em>Item</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.impl.DependabilityImpl#getEADatatype <em>EA Datatype</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.impl.DependabilityImpl#getFaultFailure <em>Fault Failure</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.impl.DependabilityImpl#getQuantitativeSafetyConstraint <em>Quantitative Safety Constraint
 * </em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.impl.DependabilityImpl#getSafetyConstraint <em>Safety Constraint</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.impl.DependabilityImpl#getSafetyCase <em>Safety Case</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.impl.DependabilityImpl#getErrorModelType <em>Error Model Type</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class DependabilityImpl extends ContextImpl implements Dependability {

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
	 * The cached value of the '{@link #getFunctionalSafetyConcept() <em>Functional Safety Concept</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getFunctionalSafetyConcept()
	 * @generated
	 * @ordered
	 */
	protected EList<FunctionalSafetyConcept> functionalSafetyConcept;

	/**
	 * The cached value of the '{@link #getSafetyGoal() <em>Safety Goal</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getSafetyGoal()
	 * @generated
	 * @ordered
	 */
	protected EList<SafetyGoal> safetyGoal;

	/**
	 * The cached value of the '{@link #getTechnicalSafetyConcept() <em>Technical Safety Concept</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getTechnicalSafetyConcept()
	 * @generated
	 * @ordered
	 */
	protected EList<TechnicalSafetyConcept> technicalSafetyConcept;

	/**
	 * The cached value of the '{@link #getHazardousEvent() <em>Hazardous Event</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getHazardousEvent()
	 * @generated
	 * @ordered
	 */
	protected EList<HazardousEvent> hazardousEvent;

	/**
	 * The cached value of the '{@link #getFeatureFlaw() <em>Feature Flaw</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getFeatureFlaw()
	 * @generated
	 * @ordered
	 */
	protected EList<FeatureFlaw> featureFlaw;

	/**
	 * The cached value of the '{@link #getItem() <em>Item</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getItem()
	 * @generated
	 * @ordered
	 */
	protected EList<Item> item;

	/**
	 * The cached value of the '{@link #getEADatatype() <em>EA Datatype</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getEADatatype()
	 * @generated
	 * @ordered
	 */
	protected EList<EADatatype> eADatatype;

	/**
	 * The cached value of the '{@link #getFaultFailure() <em>Fault Failure</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getFaultFailure()
	 * @generated
	 * @ordered
	 */
	protected EList<FaultFailure> faultFailure;

	/**
	 * The cached value of the '{@link #getQuantitativeSafetyConstraint() <em>Quantitative Safety Constraint</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getQuantitativeSafetyConstraint()
	 * @generated
	 * @ordered
	 */
	protected EList<QuantitativeSafetyConstraint> quantitativeSafetyConstraint;

	/**
	 * The cached value of the '{@link #getSafetyConstraint() <em>Safety Constraint</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getSafetyConstraint()
	 * @generated
	 * @ordered
	 */
	protected EList<SafetyConstraint> safetyConstraint;

	/**
	 * The cached value of the '{@link #getSafetyCase() <em>Safety Case</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getSafetyCase()
	 * @generated
	 * @ordered
	 */
	protected EList<SafetyCase> safetyCase;

	/**
	 * The cached value of the '{@link #getErrorModelType() <em>Error Model Type</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getErrorModelType()
	 * @generated
	 * @ordered
	 */
	protected EList<ErrorModelType> errorModelType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected DependabilityImpl() {
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
		case DependabilityPackage.DEPENDABILITY__BASE_CLASS:
			if(resolve)
				return getBase_Class();
			return basicGetBase_Class();
		case DependabilityPackage.DEPENDABILITY__BASE_PACKAGE:
			if(resolve)
				return getBase_Package();
			return basicGetBase_Package();
		case DependabilityPackage.DEPENDABILITY__FUNCTIONAL_SAFETY_CONCEPT:
			return getFunctionalSafetyConcept();
		case DependabilityPackage.DEPENDABILITY__SAFETY_GOAL:
			return getSafetyGoal();
		case DependabilityPackage.DEPENDABILITY__TECHNICAL_SAFETY_CONCEPT:
			return getTechnicalSafetyConcept();
		case DependabilityPackage.DEPENDABILITY__HAZARDOUS_EVENT:
			return getHazardousEvent();
		case DependabilityPackage.DEPENDABILITY__FEATURE_FLAW:
			return getFeatureFlaw();
		case DependabilityPackage.DEPENDABILITY__ITEM:
			return getItem();
		case DependabilityPackage.DEPENDABILITY__EA_DATATYPE:
			return getEADatatype();
		case DependabilityPackage.DEPENDABILITY__FAULT_FAILURE:
			return getFaultFailure();
		case DependabilityPackage.DEPENDABILITY__QUANTITATIVE_SAFETY_CONSTRAINT:
			return getQuantitativeSafetyConstraint();
		case DependabilityPackage.DEPENDABILITY__SAFETY_CONSTRAINT:
			return getSafetyConstraint();
		case DependabilityPackage.DEPENDABILITY__SAFETY_CASE:
			return getSafetyCase();
		case DependabilityPackage.DEPENDABILITY__ERROR_MODEL_TYPE:
			return getErrorModelType();
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
		case DependabilityPackage.DEPENDABILITY__BASE_CLASS:
			return base_Class != null;
		case DependabilityPackage.DEPENDABILITY__BASE_PACKAGE:
			return base_Package != null;
		case DependabilityPackage.DEPENDABILITY__FUNCTIONAL_SAFETY_CONCEPT:
			return functionalSafetyConcept != null && !functionalSafetyConcept.isEmpty();
		case DependabilityPackage.DEPENDABILITY__SAFETY_GOAL:
			return safetyGoal != null && !safetyGoal.isEmpty();
		case DependabilityPackage.DEPENDABILITY__TECHNICAL_SAFETY_CONCEPT:
			return technicalSafetyConcept != null && !technicalSafetyConcept.isEmpty();
		case DependabilityPackage.DEPENDABILITY__HAZARDOUS_EVENT:
			return hazardousEvent != null && !hazardousEvent.isEmpty();
		case DependabilityPackage.DEPENDABILITY__FEATURE_FLAW:
			return featureFlaw != null && !featureFlaw.isEmpty();
		case DependabilityPackage.DEPENDABILITY__ITEM:
			return item != null && !item.isEmpty();
		case DependabilityPackage.DEPENDABILITY__EA_DATATYPE:
			return eADatatype != null && !eADatatype.isEmpty();
		case DependabilityPackage.DEPENDABILITY__FAULT_FAILURE:
			return faultFailure != null && !faultFailure.isEmpty();
		case DependabilityPackage.DEPENDABILITY__QUANTITATIVE_SAFETY_CONSTRAINT:
			return quantitativeSafetyConstraint != null && !quantitativeSafetyConstraint.isEmpty();
		case DependabilityPackage.DEPENDABILITY__SAFETY_CONSTRAINT:
			return safetyConstraint != null && !safetyConstraint.isEmpty();
		case DependabilityPackage.DEPENDABILITY__SAFETY_CASE:
			return safetyCase != null && !safetyCase.isEmpty();
		case DependabilityPackage.DEPENDABILITY__ERROR_MODEL_TYPE:
			return errorModelType != null && !errorModelType.isEmpty();
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
		case DependabilityPackage.DEPENDABILITY__BASE_CLASS:
			setBase_Class((org.eclipse.uml2.uml.Class)newValue);
			return;
		case DependabilityPackage.DEPENDABILITY__BASE_PACKAGE:
			setBase_Package((org.eclipse.uml2.uml.Package)newValue);
			return;
		case DependabilityPackage.DEPENDABILITY__FUNCTIONAL_SAFETY_CONCEPT:
			getFunctionalSafetyConcept().clear();
			getFunctionalSafetyConcept().addAll((Collection<? extends FunctionalSafetyConcept>)newValue);
			return;
		case DependabilityPackage.DEPENDABILITY__SAFETY_GOAL:
			getSafetyGoal().clear();
			getSafetyGoal().addAll((Collection<? extends SafetyGoal>)newValue);
			return;
		case DependabilityPackage.DEPENDABILITY__TECHNICAL_SAFETY_CONCEPT:
			getTechnicalSafetyConcept().clear();
			getTechnicalSafetyConcept().addAll((Collection<? extends TechnicalSafetyConcept>)newValue);
			return;
		case DependabilityPackage.DEPENDABILITY__HAZARDOUS_EVENT:
			getHazardousEvent().clear();
			getHazardousEvent().addAll((Collection<? extends HazardousEvent>)newValue);
			return;
		case DependabilityPackage.DEPENDABILITY__FEATURE_FLAW:
			getFeatureFlaw().clear();
			getFeatureFlaw().addAll((Collection<? extends FeatureFlaw>)newValue);
			return;
		case DependabilityPackage.DEPENDABILITY__ITEM:
			getItem().clear();
			getItem().addAll((Collection<? extends Item>)newValue);
			return;
		case DependabilityPackage.DEPENDABILITY__EA_DATATYPE:
			getEADatatype().clear();
			getEADatatype().addAll((Collection<? extends EADatatype>)newValue);
			return;
		case DependabilityPackage.DEPENDABILITY__FAULT_FAILURE:
			getFaultFailure().clear();
			getFaultFailure().addAll((Collection<? extends FaultFailure>)newValue);
			return;
		case DependabilityPackage.DEPENDABILITY__QUANTITATIVE_SAFETY_CONSTRAINT:
			getQuantitativeSafetyConstraint().clear();
			getQuantitativeSafetyConstraint().addAll((Collection<? extends QuantitativeSafetyConstraint>)newValue);
			return;
		case DependabilityPackage.DEPENDABILITY__SAFETY_CONSTRAINT:
			getSafetyConstraint().clear();
			getSafetyConstraint().addAll((Collection<? extends SafetyConstraint>)newValue);
			return;
		case DependabilityPackage.DEPENDABILITY__SAFETY_CASE:
			getSafetyCase().clear();
			getSafetyCase().addAll((Collection<? extends SafetyCase>)newValue);
			return;
		case DependabilityPackage.DEPENDABILITY__ERROR_MODEL_TYPE:
			getErrorModelType().clear();
			getErrorModelType().addAll((Collection<? extends ErrorModelType>)newValue);
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
		return DependabilityPackage.Literals.DEPENDABILITY;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DependabilityPackage.DEPENDABILITY__BASE_CLASS, oldBase_Class, base_Class));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DependabilityPackage.DEPENDABILITY__BASE_CLASS, oldBase_Class, base_Class));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DependabilityPackage.DEPENDABILITY__BASE_PACKAGE, oldBase_Package, base_Package));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DependabilityPackage.DEPENDABILITY__BASE_PACKAGE, oldBase_Package, base_Package));
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
		case DependabilityPackage.DEPENDABILITY__BASE_CLASS:
			setBase_Class((org.eclipse.uml2.uml.Class)null);
			return;
		case DependabilityPackage.DEPENDABILITY__BASE_PACKAGE:
			setBase_Package((org.eclipse.uml2.uml.Package)null);
			return;
		case DependabilityPackage.DEPENDABILITY__FUNCTIONAL_SAFETY_CONCEPT:
			getFunctionalSafetyConcept().clear();
			return;
		case DependabilityPackage.DEPENDABILITY__SAFETY_GOAL:
			getSafetyGoal().clear();
			return;
		case DependabilityPackage.DEPENDABILITY__TECHNICAL_SAFETY_CONCEPT:
			getTechnicalSafetyConcept().clear();
			return;
		case DependabilityPackage.DEPENDABILITY__HAZARDOUS_EVENT:
			getHazardousEvent().clear();
			return;
		case DependabilityPackage.DEPENDABILITY__FEATURE_FLAW:
			getFeatureFlaw().clear();
			return;
		case DependabilityPackage.DEPENDABILITY__ITEM:
			getItem().clear();
			return;
		case DependabilityPackage.DEPENDABILITY__EA_DATATYPE:
			getEADatatype().clear();
			return;
		case DependabilityPackage.DEPENDABILITY__FAULT_FAILURE:
			getFaultFailure().clear();
			return;
		case DependabilityPackage.DEPENDABILITY__QUANTITATIVE_SAFETY_CONSTRAINT:
			getQuantitativeSafetyConstraint().clear();
			return;
		case DependabilityPackage.DEPENDABILITY__SAFETY_CONSTRAINT:
			getSafetyConstraint().clear();
			return;
		case DependabilityPackage.DEPENDABILITY__SAFETY_CASE:
			getSafetyCase().clear();
			return;
		case DependabilityPackage.DEPENDABILITY__ERROR_MODEL_TYPE:
			getErrorModelType().clear();
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
	public EList<ErrorModelType> getErrorModelType() {
		if(errorModelType == null) {
			errorModelType = new EObjectResolvingEList<ErrorModelType>(ErrorModelType.class, this, DependabilityPackage.DEPENDABILITY__ERROR_MODEL_TYPE);
		}
		return errorModelType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<FaultFailure> getFaultFailure() {
		if(faultFailure == null) {
			faultFailure = new EObjectResolvingEList<FaultFailure>(FaultFailure.class, this, DependabilityPackage.DEPENDABILITY__FAULT_FAILURE);
		}
		return faultFailure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<FeatureFlaw> getFeatureFlaw() {
		if(featureFlaw == null) {
			featureFlaw = new EObjectResolvingEList<FeatureFlaw>(FeatureFlaw.class, this, DependabilityPackage.DEPENDABILITY__FEATURE_FLAW);
		}
		return featureFlaw;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<FunctionalSafetyConcept> getFunctionalSafetyConcept() {
		if(functionalSafetyConcept == null) {
			functionalSafetyConcept = new EObjectResolvingEList<FunctionalSafetyConcept>(FunctionalSafetyConcept.class, this, DependabilityPackage.DEPENDABILITY__FUNCTIONAL_SAFETY_CONCEPT);
		}
		return functionalSafetyConcept;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<HazardousEvent> getHazardousEvent() {
		if(hazardousEvent == null) {
			hazardousEvent = new EObjectResolvingEList<HazardousEvent>(HazardousEvent.class, this, DependabilityPackage.DEPENDABILITY__HAZARDOUS_EVENT);
		}
		return hazardousEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<Item> getItem() {
		if(item == null) {
			item = new EObjectResolvingEList<Item>(Item.class, this, DependabilityPackage.DEPENDABILITY__ITEM);
		}
		return item;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<EADatatype> getEADatatype() {
		if(eADatatype == null) {
			eADatatype = new EObjectResolvingEList<EADatatype>(EADatatype.class, this, DependabilityPackage.DEPENDABILITY__EA_DATATYPE);
		}
		return eADatatype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<QuantitativeSafetyConstraint> getQuantitativeSafetyConstraint() {
		if(quantitativeSafetyConstraint == null) {
			quantitativeSafetyConstraint = new EObjectResolvingEList<QuantitativeSafetyConstraint>(QuantitativeSafetyConstraint.class, this, DependabilityPackage.DEPENDABILITY__QUANTITATIVE_SAFETY_CONSTRAINT);
		}
		return quantitativeSafetyConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<SafetyCase> getSafetyCase() {
		if(safetyCase == null) {
			safetyCase = new EObjectResolvingEList<SafetyCase>(SafetyCase.class, this, DependabilityPackage.DEPENDABILITY__SAFETY_CASE);
		}
		return safetyCase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<SafetyConstraint> getSafetyConstraint() {
		if(safetyConstraint == null) {
			safetyConstraint = new EObjectResolvingEList<SafetyConstraint>(SafetyConstraint.class, this, DependabilityPackage.DEPENDABILITY__SAFETY_CONSTRAINT);
		}
		return safetyConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<SafetyGoal> getSafetyGoal() {
		if(safetyGoal == null) {
			safetyGoal = new EObjectResolvingEList<SafetyGoal>(SafetyGoal.class, this, DependabilityPackage.DEPENDABILITY__SAFETY_GOAL);
		}
		return safetyGoal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<TechnicalSafetyConcept> getTechnicalSafetyConcept() {
		if(technicalSafetyConcept == null) {
			technicalSafetyConcept = new EObjectResolvingEList<TechnicalSafetyConcept>(TechnicalSafetyConcept.class, this, DependabilityPackage.DEPENDABILITY__TECHNICAL_SAFETY_CONCEPT);
		}
		return technicalSafetyConcept;
	}

} //DependabilityImpl
