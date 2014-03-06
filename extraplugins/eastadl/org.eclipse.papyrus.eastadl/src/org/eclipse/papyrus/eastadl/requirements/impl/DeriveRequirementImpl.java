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

import java.util.Iterator;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.BasicInternalEList;
import org.eclipse.papyrus.eastadl.requirements.DeriveRequirement;
import org.eclipse.papyrus.eastadl.requirements.Requirement;
import org.eclipse.papyrus.eastadl.requirements.RequirementsPackage;
import org.eclipse.papyrus.sysml.requirements.DeriveReqt;
import org.eclipse.uml2.uml.Abstraction;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.profile.standard.StandardPackage;
import org.eclipse.uml2.uml.util.UMLUtil;


/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Derive Requirement</b></em> '. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.requirements.impl.DeriveRequirementImpl#getBase_Abstraction <em>Base Abstraction</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.requirements.impl.DeriveRequirementImpl#getDerived <em>Derived</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.requirements.impl.DeriveRequirementImpl#getDerivedFrom <em>Derived From</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class DeriveRequirementImpl extends RequirementsRelationshipImpl implements DeriveRequirement {

	/**
	 * The cached value of the '{@link #getBase_Abstraction() <em>Base Abstraction</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getBase_Abstraction()
	 * @generated
	 * @ordered
	 */
	protected Abstraction base_Abstraction;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected DeriveRequirementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Abstraction basicGetBase_Abstraction() {
		return base_Abstraction;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if(baseClass == org.eclipse.uml2.uml.profile.standard.Trace.class) {
			switch(derivedFeatureID) {
			case RequirementsPackage.DERIVE_REQUIREMENT__BASE_ABSTRACTION:
				return StandardPackage.TRACE__BASE_ABSTRACTION;
			default:
				return -1;
			}
		}
		if(baseClass == DeriveReqt.class) {
			switch(derivedFeatureID) {
			default:
				return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if(baseClass == org.eclipse.uml2.uml.profile.standard.Trace.class) {
			switch(baseFeatureID) {
			case StandardPackage.TRACE__BASE_ABSTRACTION:
				return RequirementsPackage.DERIVE_REQUIREMENT__BASE_ABSTRACTION;
			default:
				return -1;
			}
		}
		if(baseClass == DeriveReqt.class) {
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
		case RequirementsPackage.DERIVE_REQUIREMENT__BASE_ABSTRACTION:
			if(resolve)
				return getBase_Abstraction();
			return basicGetBase_Abstraction();
		case RequirementsPackage.DERIVE_REQUIREMENT__DERIVED:
			return getDerived();
		case RequirementsPackage.DERIVE_REQUIREMENT__DERIVED_FROM:
			return getDerivedFrom();
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
		case RequirementsPackage.DERIVE_REQUIREMENT__BASE_ABSTRACTION:
			return base_Abstraction != null;
		case RequirementsPackage.DERIVE_REQUIREMENT__DERIVED:
			return !getDerived().isEmpty();
		case RequirementsPackage.DERIVE_REQUIREMENT__DERIVED_FROM:
			return !getDerivedFrom().isEmpty();
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
		case RequirementsPackage.DERIVE_REQUIREMENT__BASE_ABSTRACTION:
			setBase_Abstraction((Abstraction)newValue);
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
		return RequirementsPackage.Literals.DERIVE_REQUIREMENT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch(featureID) {
		case RequirementsPackage.DERIVE_REQUIREMENT__BASE_ABSTRACTION:
			setBase_Abstraction((Abstraction)null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Abstraction getBase_Abstraction() {
		if(base_Abstraction != null && base_Abstraction.eIsProxy()) {
			InternalEObject oldBase_Abstraction = (InternalEObject)base_Abstraction;
			base_Abstraction = (Abstraction)eResolveProxy(oldBase_Abstraction);
			if(base_Abstraction != oldBase_Abstraction) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RequirementsPackage.DERIVE_REQUIREMENT__BASE_ABSTRACTION, oldBase_Abstraction, base_Abstraction));
			}
		}
		return base_Abstraction;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<Requirement> getDerived() {

		EList<Requirement> results = new BasicEList<Requirement>();
		Requirement requirement;

		if(getBase_Abstraction() != null) {
			// Parse owned Properties
			Iterator<Element> it = getBase_Abstraction().getSources().iterator();
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
	 * @generated NOT
	 */
	public EList<Requirement> getDerivedFrom() {

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
	public void setBase_Abstraction(Abstraction newBase_Abstraction) {
		Abstraction oldBase_Abstraction = base_Abstraction;
		base_Abstraction = newBase_Abstraction;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequirementsPackage.DERIVE_REQUIREMENT__BASE_ABSTRACTION, oldBase_Abstraction, base_Abstraction));
	}

} // DeriveRequirementImpl
