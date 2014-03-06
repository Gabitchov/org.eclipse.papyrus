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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.papyrus.eastadl.infrastructure.elements.impl.TraceableSpecificationImpl;
import org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVIntendedOutcome;
import org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVProcedure;
import org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVStimuli;
import org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VerificationvalidationPackage;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>VV Procedure</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.impl.VVProcedureImpl#getBase_Class <em>Base Class</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.impl.VVProcedureImpl#getAbstractVVProcedure <em>Abstract VV Procedure
 * </em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.impl.VVProcedureImpl#getConcreteVVProcedure <em>Concrete VV Procedure
 * </em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.impl.VVProcedureImpl#getVvIntendedOutcome <em>Vv Intended Outcome</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.impl.VVProcedureImpl#getVvStimuli <em>Vv Stimuli</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class VVProcedureImpl extends TraceableSpecificationImpl implements VVProcedure {

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
	 * The cached value of the '{@link #getAbstractVVProcedure() <em>Abstract VV Procedure</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getAbstractVVProcedure()
	 * @generated
	 * @ordered
	 */
	protected VVProcedure abstractVVProcedure;

	/**
	 * The cached value of the '{@link #getConcreteVVProcedure() <em>Concrete VV Procedure</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getConcreteVVProcedure()
	 * @generated
	 * @ordered
	 */
	protected EList<VVProcedure> concreteVVProcedure;

	/**
	 * The cached value of the '{@link #getVvIntendedOutcome() <em>Vv Intended Outcome</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getVvIntendedOutcome()
	 * @generated
	 * @ordered
	 */
	protected EList<VVIntendedOutcome> vvIntendedOutcome;

	/**
	 * The cached value of the '{@link #getVvStimuli() <em>Vv Stimuli</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getVvStimuli()
	 * @generated
	 * @ordered
	 */
	protected EList<VVStimuli> vvStimuli;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected VVProcedureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public VVProcedure basicGetAbstractVVProcedure() {
		return abstractVVProcedure;
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
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch(featureID) {
		case VerificationvalidationPackage.VV_PROCEDURE__BASE_CLASS:
			if(resolve)
				return getBase_Class();
			return basicGetBase_Class();
		case VerificationvalidationPackage.VV_PROCEDURE__ABSTRACT_VV_PROCEDURE:
			if(resolve)
				return getAbstractVVProcedure();
			return basicGetAbstractVVProcedure();
		case VerificationvalidationPackage.VV_PROCEDURE__CONCRETE_VV_PROCEDURE:
			return getConcreteVVProcedure();
		case VerificationvalidationPackage.VV_PROCEDURE__VV_INTENDED_OUTCOME:
			return getVvIntendedOutcome();
		case VerificationvalidationPackage.VV_PROCEDURE__VV_STIMULI:
			return getVvStimuli();
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
		case VerificationvalidationPackage.VV_PROCEDURE__BASE_CLASS:
			return base_Class != null;
		case VerificationvalidationPackage.VV_PROCEDURE__ABSTRACT_VV_PROCEDURE:
			return abstractVVProcedure != null;
		case VerificationvalidationPackage.VV_PROCEDURE__CONCRETE_VV_PROCEDURE:
			return concreteVVProcedure != null && !concreteVVProcedure.isEmpty();
		case VerificationvalidationPackage.VV_PROCEDURE__VV_INTENDED_OUTCOME:
			return vvIntendedOutcome != null && !vvIntendedOutcome.isEmpty();
		case VerificationvalidationPackage.VV_PROCEDURE__VV_STIMULI:
			return vvStimuli != null && !vvStimuli.isEmpty();
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
		case VerificationvalidationPackage.VV_PROCEDURE__BASE_CLASS:
			setBase_Class((org.eclipse.uml2.uml.Class)newValue);
			return;
		case VerificationvalidationPackage.VV_PROCEDURE__ABSTRACT_VV_PROCEDURE:
			setAbstractVVProcedure((VVProcedure)newValue);
			return;
		case VerificationvalidationPackage.VV_PROCEDURE__CONCRETE_VV_PROCEDURE:
			getConcreteVVProcedure().clear();
			getConcreteVVProcedure().addAll((Collection<? extends VVProcedure>)newValue);
			return;
		case VerificationvalidationPackage.VV_PROCEDURE__VV_INTENDED_OUTCOME:
			getVvIntendedOutcome().clear();
			getVvIntendedOutcome().addAll((Collection<? extends VVIntendedOutcome>)newValue);
			return;
		case VerificationvalidationPackage.VV_PROCEDURE__VV_STIMULI:
			getVvStimuli().clear();
			getVvStimuli().addAll((Collection<? extends VVStimuli>)newValue);
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
		return VerificationvalidationPackage.Literals.VV_PROCEDURE;
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
		case VerificationvalidationPackage.VV_PROCEDURE__BASE_CLASS:
			setBase_Class((org.eclipse.uml2.uml.Class)null);
			return;
		case VerificationvalidationPackage.VV_PROCEDURE__ABSTRACT_VV_PROCEDURE:
			setAbstractVVProcedure((VVProcedure)null);
			return;
		case VerificationvalidationPackage.VV_PROCEDURE__CONCRETE_VV_PROCEDURE:
			getConcreteVVProcedure().clear();
			return;
		case VerificationvalidationPackage.VV_PROCEDURE__VV_INTENDED_OUTCOME:
			getVvIntendedOutcome().clear();
			return;
		case VerificationvalidationPackage.VV_PROCEDURE__VV_STIMULI:
			getVvStimuli().clear();
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
	public VVProcedure getAbstractVVProcedure() {
		if(abstractVVProcedure != null && abstractVVProcedure.eIsProxy()) {
			InternalEObject oldAbstractVVProcedure = (InternalEObject)abstractVVProcedure;
			abstractVVProcedure = (VVProcedure)eResolveProxy(oldAbstractVVProcedure);
			if(abstractVVProcedure != oldAbstractVVProcedure) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, VerificationvalidationPackage.VV_PROCEDURE__ABSTRACT_VV_PROCEDURE, oldAbstractVVProcedure, abstractVVProcedure));
			}
		}
		return abstractVVProcedure;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, VerificationvalidationPackage.VV_PROCEDURE__BASE_CLASS, oldBase_Class, base_Class));
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
	public EList<VVProcedure> getConcreteVVProcedure() {
		if(concreteVVProcedure == null) {
			concreteVVProcedure = new EObjectResolvingEList<VVProcedure>(VVProcedure.class, this, VerificationvalidationPackage.VV_PROCEDURE__CONCRETE_VV_PROCEDURE);
		}
		return concreteVVProcedure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<VVIntendedOutcome> getVvIntendedOutcome() {
		if(vvIntendedOutcome == null) {
			vvIntendedOutcome = new EObjectResolvingEList<VVIntendedOutcome>(VVIntendedOutcome.class, this, VerificationvalidationPackage.VV_PROCEDURE__VV_INTENDED_OUTCOME);
		}
		return vvIntendedOutcome;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<VVStimuli> getVvStimuli() {
		if(vvStimuli == null) {
			vvStimuli = new EObjectResolvingEList<VVStimuli>(VVStimuli.class, this, VerificationvalidationPackage.VV_PROCEDURE__VV_STIMULI);
		}
		return vvStimuli;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setAbstractVVProcedure(VVProcedure newAbstractVVProcedure) {
		VVProcedure oldAbstractVVProcedure = abstractVVProcedure;
		abstractVVProcedure = newAbstractVVProcedure;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VerificationvalidationPackage.VV_PROCEDURE__ABSTRACT_VV_PROCEDURE, oldAbstractVVProcedure, abstractVVProcedure));
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
			eNotify(new ENotificationImpl(this, Notification.SET, VerificationvalidationPackage.VV_PROCEDURE__BASE_CLASS, oldBase_Class, base_Class));
	}

} //VVProcedureImpl
