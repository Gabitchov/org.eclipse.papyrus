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
import java.util.Iterator;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.BasicInternalEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.papyrus.eastadl.requirements.Requirement;
import org.eclipse.papyrus.eastadl.requirements.RequirementsPackage;
import org.eclipse.papyrus.eastadl.requirements.Satisfy;
import org.eclipse.papyrus.eastadl.requirements.UseCase;
import org.eclipse.uml2.uml.Abstraction;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.profile.standard.StandardPackage;
import org.eclipse.uml2.uml.util.UMLUtil;


/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Satisfy</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.requirements.impl.SatisfyImpl#getBase_Abstraction <em>Base Abstraction</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.requirements.impl.SatisfyImpl#getSatisfiedRequirement <em>Satisfied Requirement</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.requirements.impl.SatisfyImpl#getSatisfiedBy <em>Satisfied By</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.requirements.impl.SatisfyImpl#getSatisfiedBy_path <em>Satisfied By path</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.requirements.impl.SatisfyImpl#getSatisfiedUseCase <em>Satisfied Use Case</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class SatisfyImpl extends RequirementsRelationshipImpl implements Satisfy {

	/**
	 * The cached value of the '{@link #getBase_Abstraction() <em>Base Abstraction</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getBase_Abstraction()
	 * @generated
	 * @ordered
	 */
	protected Abstraction base_Abstraction;

	/**
	 * The cached value of the '{@link #getSatisfiedBy_path() <em>Satisfied By path</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getSatisfiedBy_path()
	 * @generated
	 * @ordered
	 */
	protected EList<NamedElement> satisfiedBy_path;

	/**
	 * The cached value of the '{@link #getSatisfiedUseCase() <em>Satisfied Use Case</em>}' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getSatisfiedUseCase()
	 * @generated
	 * @ordered
	 */
	protected EList<UseCase> satisfiedUseCase;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected SatisfyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Abstraction basicGetBase_Abstraction() {
		return base_Abstraction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if(baseClass == org.eclipse.uml2.uml.profile.standard.Trace.class) {
			switch(derivedFeatureID) {
			case RequirementsPackage.SATISFY__BASE_ABSTRACTION:
				return StandardPackage.TRACE__BASE_ABSTRACTION;
			default:
				return -1;
			}
		}
		if(baseClass == org.eclipse.papyrus.sysml.requirements.Satisfy.class) {
			switch(derivedFeatureID) {
			default:
				return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if(baseClass == org.eclipse.uml2.uml.profile.standard.Trace.class) {
			switch(baseFeatureID) {
			case StandardPackage.TRACE__BASE_ABSTRACTION:
				return RequirementsPackage.SATISFY__BASE_ABSTRACTION;
			default:
				return -1;
			}
		}
		if(baseClass == org.eclipse.papyrus.sysml.requirements.Satisfy.class) {
			switch(baseFeatureID) {
			default:
				return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch(featureID) {
		case RequirementsPackage.SATISFY__BASE_ABSTRACTION:
			if(resolve)
				return getBase_Abstraction();
			return basicGetBase_Abstraction();
		case RequirementsPackage.SATISFY__SATISFIED_REQUIREMENT:
			return getSatisfiedRequirement();
		case RequirementsPackage.SATISFY__SATISFIED_BY:
			return getSatisfiedBy();
		case RequirementsPackage.SATISFY__SATISFIED_BY_PATH:
			return getSatisfiedBy_path();
		case RequirementsPackage.SATISFY__SATISFIED_USE_CASE:
			return getSatisfiedUseCase();
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
		case RequirementsPackage.SATISFY__BASE_ABSTRACTION:
			return base_Abstraction != null;
		case RequirementsPackage.SATISFY__SATISFIED_REQUIREMENT:
			return !getSatisfiedRequirement().isEmpty();
		case RequirementsPackage.SATISFY__SATISFIED_BY:
			return !getSatisfiedBy().isEmpty();
		case RequirementsPackage.SATISFY__SATISFIED_BY_PATH:
			return satisfiedBy_path != null && !satisfiedBy_path.isEmpty();
		case RequirementsPackage.SATISFY__SATISFIED_USE_CASE:
			return satisfiedUseCase != null && !satisfiedUseCase.isEmpty();
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
		case RequirementsPackage.SATISFY__BASE_ABSTRACTION:
			setBase_Abstraction((Abstraction)newValue);
			return;
		case RequirementsPackage.SATISFY__SATISFIED_BY_PATH:
			getSatisfiedBy_path().clear();
			getSatisfiedBy_path().addAll((Collection<? extends NamedElement>)newValue);
			return;
		case RequirementsPackage.SATISFY__SATISFIED_USE_CASE:
			getSatisfiedUseCase().clear();
			getSatisfiedUseCase().addAll((Collection<? extends UseCase>)newValue);
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
		return RequirementsPackage.Literals.SATISFY;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch(featureID) {
		case RequirementsPackage.SATISFY__BASE_ABSTRACTION:
			setBase_Abstraction((Abstraction)null);
			return;
		case RequirementsPackage.SATISFY__SATISFIED_BY_PATH:
			getSatisfiedBy_path().clear();
			return;
		case RequirementsPackage.SATISFY__SATISFIED_USE_CASE:
			getSatisfiedUseCase().clear();
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
	public Abstraction getBase_Abstraction() {
		if(base_Abstraction != null && base_Abstraction.eIsProxy()) {
			InternalEObject oldBase_Abstraction = (InternalEObject)base_Abstraction;
			base_Abstraction = (Abstraction)eResolveProxy(oldBase_Abstraction);
			if(base_Abstraction != oldBase_Abstraction) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RequirementsPackage.SATISFY__BASE_ABSTRACTION, oldBase_Abstraction, base_Abstraction));
			}
		}
		return base_Abstraction;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<NamedElement> getSatisfiedBy() {
		EList<NamedElement> results = new BasicEList<NamedElement>();

		if(getBase_Abstraction() != null) {
			// Parse owned Properties
			Iterator<NamedElement> it = getBase_Abstraction().getClients().iterator();
			while(it.hasNext()) {
				NamedElement current = it.next();
				results.add(current);
			}
		}

		// Convert to InternalEList<?>
		return new BasicInternalEList<NamedElement>(NamedElement.class, results.size(), results.toArray());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<NamedElement> getSatisfiedBy_path() {
		if(satisfiedBy_path == null) {
			satisfiedBy_path = new EObjectResolvingEList<NamedElement>(NamedElement.class, this, RequirementsPackage.SATISFY__SATISFIED_BY_PATH);
		}
		return satisfiedBy_path;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<Requirement> getSatisfiedRequirement() {
		EList<Requirement> results = new BasicEList<Requirement>();
		Requirement requirement;

		if(getBase_Abstraction() != null) {
			// Parse owned Properties
			Iterator<Element> it = getBase_Abstraction().getTargets().iterator();
			while(it.hasNext()) {
				Element current = it.next();

				// Test if currentProperty is stereotyped ADLRequirement
				requirement = (Requirement)UMLUtil.getStereotypeApplication(current, Requirement.class);

				if(requirement != null) {
					results.add(requirement);
				}
			}
		}

		// Convert to InternalEList<?>
		return new BasicInternalEList<Requirement>(Requirement.class, results.size(), results.toArray());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<UseCase> getSatisfiedUseCase() {
		if(satisfiedUseCase == null) {
			satisfiedUseCase = new EObjectResolvingEList<UseCase>(UseCase.class, this, RequirementsPackage.SATISFY__SATISFIED_USE_CASE);
		}
		return satisfiedUseCase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setBase_Abstraction(Abstraction newBase_Abstraction) {
		Abstraction oldBase_Abstraction = base_Abstraction;
		base_Abstraction = newBase_Abstraction;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequirementsPackage.SATISFY__BASE_ABSTRACTION, oldBase_Abstraction, base_Abstraction));
	}

} // SatisfyImpl
