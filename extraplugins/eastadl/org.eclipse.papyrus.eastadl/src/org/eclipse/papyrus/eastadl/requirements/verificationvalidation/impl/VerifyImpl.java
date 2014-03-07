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
package org.eclipse.papyrus.eastadl.requirements.verificationvalidation.impl;

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
import org.eclipse.papyrus.eastadl.requirements.impl.RequirementsRelationshipImpl;
import org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVCase;
import org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVProcedure;
import org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VerificationvalidationPackage;
import org.eclipse.papyrus.eastadl.requirements.verificationvalidation.Verify;
import org.eclipse.uml2.uml.Abstraction;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.profile.standard.StandardPackage;
import org.eclipse.uml2.uml.util.UMLUtil;


/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Verify</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.impl.VerifyImpl#getBase_Abstraction <em>Base Abstraction</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.impl.VerifyImpl#getVerifiedByProcedure <em>Verified By Procedure</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.impl.VerifyImpl#getVerifiedByCase <em>Verified By Case</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.impl.VerifyImpl#getVerifiedRequirement <em>Verified Requirement</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class VerifyImpl extends RequirementsRelationshipImpl implements Verify {

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
	 * The cached value of the '{@link #getVerifiedByProcedure() <em>Verified By Procedure</em>}' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getVerifiedByProcedure()
	 * @generated
	 * @ordered
	 */
	protected EList<VVProcedure> verifiedByProcedure;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected VerifyImpl() {
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
			case VerificationvalidationPackage.VERIFY__BASE_ABSTRACTION:
				return StandardPackage.TRACE__BASE_ABSTRACTION;
			default:
				return -1;
			}
		}
		if(baseClass == org.eclipse.papyrus.sysml.requirements.Verify.class) {
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
				return VerificationvalidationPackage.VERIFY__BASE_ABSTRACTION;
			default:
				return -1;
			}
		}
		if(baseClass == org.eclipse.papyrus.sysml.requirements.Verify.class) {
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
		case VerificationvalidationPackage.VERIFY__BASE_ABSTRACTION:
			if(resolve)
				return getBase_Abstraction();
			return basicGetBase_Abstraction();
		case VerificationvalidationPackage.VERIFY__VERIFIED_BY_PROCEDURE:
			return getVerifiedByProcedure();
		case VerificationvalidationPackage.VERIFY__VERIFIED_BY_CASE:
			return getVerifiedByCase();
		case VerificationvalidationPackage.VERIFY__VERIFIED_REQUIREMENT:
			return getVerifiedRequirement();
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
		case VerificationvalidationPackage.VERIFY__BASE_ABSTRACTION:
			return base_Abstraction != null;
		case VerificationvalidationPackage.VERIFY__VERIFIED_BY_PROCEDURE:
			return verifiedByProcedure != null && !verifiedByProcedure.isEmpty();
		case VerificationvalidationPackage.VERIFY__VERIFIED_BY_CASE:
			return !getVerifiedByCase().isEmpty();
		case VerificationvalidationPackage.VERIFY__VERIFIED_REQUIREMENT:
			return !getVerifiedRequirement().isEmpty();
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
		case VerificationvalidationPackage.VERIFY__BASE_ABSTRACTION:
			setBase_Abstraction((Abstraction)newValue);
			return;
		case VerificationvalidationPackage.VERIFY__VERIFIED_BY_PROCEDURE:
			getVerifiedByProcedure().clear();
			getVerifiedByProcedure().addAll((Collection<? extends VVProcedure>)newValue);
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
		return VerificationvalidationPackage.Literals.VERIFY;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch(featureID) {
		case VerificationvalidationPackage.VERIFY__BASE_ABSTRACTION:
			setBase_Abstraction((Abstraction)null);
			return;
		case VerificationvalidationPackage.VERIFY__VERIFIED_BY_PROCEDURE:
			getVerifiedByProcedure().clear();
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, VerificationvalidationPackage.VERIFY__BASE_ABSTRACTION, oldBase_Abstraction, base_Abstraction));
			}
		}
		return base_Abstraction;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<VVCase> getVerifiedByCase() {
		EList<VVCase> results = new BasicEList<VVCase>();
		VVCase vvcase;

		if(getBase_Abstraction() != null) {
			// Parse owned Properties
			Iterator<Element> it = getBase_Abstraction().getSources().iterator();
			while(it.hasNext()) {
				Element current = it.next();

				// Test if currentProperty is stereotyped AbstractVVCase
				vvcase = (VVCase)UMLUtil.getStereotypeApplication(current, VVCase.class);

				if(vvcase != null) {
					results.add(vvcase);
				}
			}
		}

		// Convert to InternalEList<?>
		return new BasicInternalEList<VVCase>(VVCase.class, results.size(), results.toArray());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<VVProcedure> getVerifiedByProcedure() {
		if(verifiedByProcedure == null) {
			verifiedByProcedure = new EObjectResolvingEList<VVProcedure>(VVProcedure.class, this, VerificationvalidationPackage.VERIFY__VERIFIED_BY_PROCEDURE);
		}
		return verifiedByProcedure;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<Requirement> getVerifiedRequirement() {
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
			eNotify(new ENotificationImpl(this, Notification.SET, VerificationvalidationPackage.VERIFY__BASE_ABSTRACTION, oldBase_Abstraction, base_Abstraction));
	}

} // VerifyImpl
