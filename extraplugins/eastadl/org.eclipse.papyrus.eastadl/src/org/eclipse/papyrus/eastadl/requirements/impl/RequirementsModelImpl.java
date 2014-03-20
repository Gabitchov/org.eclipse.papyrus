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
package org.eclipse.papyrus.eastadl.requirements.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.papyrus.eastadl.infrastructure.elements.impl.ContextImpl;
import org.eclipse.papyrus.eastadl.requirements.OperationalSituation;
import org.eclipse.papyrus.eastadl.requirements.RequirementSpecificationObject;
import org.eclipse.papyrus.eastadl.requirements.RequirementsContainer;
import org.eclipse.papyrus.eastadl.requirements.RequirementsModel;
import org.eclipse.papyrus.eastadl.requirements.RequirementsPackage;
import org.eclipse.uml2.uml.UseCase;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.requirements.impl.RequirementsModelImpl#getUseCase <em>Use Case</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.requirements.impl.RequirementsModelImpl#getRequirement <em>Requirement</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.requirements.impl.RequirementsModelImpl#getRequirementContainer <em>Requirement Container</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.requirements.impl.RequirementsModelImpl#getOperationalSituation <em>Operational Situation</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.requirements.impl.RequirementsModelImpl#getBase_Package <em>Base Package</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class RequirementsModelImpl extends ContextImpl implements RequirementsModel {

	/**
	 * The cached value of the '{@link #getUseCase() <em>Use Case</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getUseCase()
	 * @generated
	 * @ordered
	 */
	protected EList<UseCase> useCase;

	/**
	 * The cached value of the '{@link #getRequirement() <em>Requirement</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getRequirement()
	 * @generated
	 * @ordered
	 */
	protected EList<RequirementSpecificationObject> requirement;

	/**
	 * The cached value of the '{@link #getRequirementContainer() <em>Requirement Container</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getRequirementContainer()
	 * @generated
	 * @ordered
	 */
	protected EList<RequirementsContainer> requirementContainer;

	/**
	 * The cached value of the '{@link #getOperationalSituation() <em>Operational Situation</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getOperationalSituation()
	 * @generated
	 * @ordered
	 */
	protected EList<OperationalSituation> operationalSituation;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected RequirementsModelImpl() {
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
		case RequirementsPackage.REQUIREMENTS_MODEL__USE_CASE:
			return getUseCase();
		case RequirementsPackage.REQUIREMENTS_MODEL__REQUIREMENT:
			return getRequirement();
		case RequirementsPackage.REQUIREMENTS_MODEL__REQUIREMENT_CONTAINER:
			return getRequirementContainer();
		case RequirementsPackage.REQUIREMENTS_MODEL__OPERATIONAL_SITUATION:
			return getOperationalSituation();
		case RequirementsPackage.REQUIREMENTS_MODEL__BASE_PACKAGE:
			if(resolve)
				return getBase_Package();
			return basicGetBase_Package();
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
		case RequirementsPackage.REQUIREMENTS_MODEL__USE_CASE:
			return useCase != null && !useCase.isEmpty();
		case RequirementsPackage.REQUIREMENTS_MODEL__REQUIREMENT:
			return requirement != null && !requirement.isEmpty();
		case RequirementsPackage.REQUIREMENTS_MODEL__REQUIREMENT_CONTAINER:
			return requirementContainer != null && !requirementContainer.isEmpty();
		case RequirementsPackage.REQUIREMENTS_MODEL__OPERATIONAL_SITUATION:
			return operationalSituation != null && !operationalSituation.isEmpty();
		case RequirementsPackage.REQUIREMENTS_MODEL__BASE_PACKAGE:
			return base_Package != null;
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
		case RequirementsPackage.REQUIREMENTS_MODEL__USE_CASE:
			getUseCase().clear();
			getUseCase().addAll((Collection<? extends UseCase>)newValue);
			return;
		case RequirementsPackage.REQUIREMENTS_MODEL__REQUIREMENT:
			getRequirement().clear();
			getRequirement().addAll((Collection<? extends RequirementSpecificationObject>)newValue);
			return;
		case RequirementsPackage.REQUIREMENTS_MODEL__REQUIREMENT_CONTAINER:
			getRequirementContainer().clear();
			getRequirementContainer().addAll((Collection<? extends RequirementsContainer>)newValue);
			return;
		case RequirementsPackage.REQUIREMENTS_MODEL__OPERATIONAL_SITUATION:
			getOperationalSituation().clear();
			getOperationalSituation().addAll((Collection<? extends OperationalSituation>)newValue);
			return;
		case RequirementsPackage.REQUIREMENTS_MODEL__BASE_PACKAGE:
			setBase_Package((org.eclipse.uml2.uml.Package)newValue);
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
		return RequirementsPackage.Literals.REQUIREMENTS_MODEL;
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
		case RequirementsPackage.REQUIREMENTS_MODEL__USE_CASE:
			getUseCase().clear();
			return;
		case RequirementsPackage.REQUIREMENTS_MODEL__REQUIREMENT:
			getRequirement().clear();
			return;
		case RequirementsPackage.REQUIREMENTS_MODEL__REQUIREMENT_CONTAINER:
			getRequirementContainer().clear();
			return;
		case RequirementsPackage.REQUIREMENTS_MODEL__OPERATIONAL_SITUATION:
			getOperationalSituation().clear();
			return;
		case RequirementsPackage.REQUIREMENTS_MODEL__BASE_PACKAGE:
			setBase_Package((org.eclipse.uml2.uml.Package)null);
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
	public EList<OperationalSituation> getOperationalSituation() {
		if(operationalSituation == null) {
			operationalSituation = new EObjectResolvingEList<OperationalSituation>(OperationalSituation.class, this, RequirementsPackage.REQUIREMENTS_MODEL__OPERATIONAL_SITUATION);
		}
		return operationalSituation;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RequirementsPackage.REQUIREMENTS_MODEL__BASE_PACKAGE, oldBase_Package, base_Package));
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
			eNotify(new ENotificationImpl(this, Notification.SET, RequirementsPackage.REQUIREMENTS_MODEL__BASE_PACKAGE, oldBase_Package, base_Package));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<RequirementSpecificationObject> getRequirement() {
		if(requirement == null) {
			requirement = new EObjectResolvingEList<RequirementSpecificationObject>(RequirementSpecificationObject.class, this, RequirementsPackage.REQUIREMENTS_MODEL__REQUIREMENT);
		}
		return requirement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<RequirementsContainer> getRequirementContainer() {
		if(requirementContainer == null) {
			requirementContainer = new EObjectResolvingEList<RequirementsContainer>(RequirementsContainer.class, this, RequirementsPackage.REQUIREMENTS_MODEL__REQUIREMENT_CONTAINER);
		}
		return requirementContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<UseCase> getUseCase() {
		if(useCase == null) {
			useCase = new EObjectResolvingEList<UseCase>(UseCase.class, this, RequirementsPackage.REQUIREMENTS_MODEL__USE_CASE);
		}
		return useCase;
	}

} //RequirementsModelImpl
