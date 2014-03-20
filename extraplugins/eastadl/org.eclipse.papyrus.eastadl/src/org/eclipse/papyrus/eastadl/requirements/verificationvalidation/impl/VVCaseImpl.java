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
import org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVCase;
import org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVLog;
import org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVProcedure;
import org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVTarget;
import org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VerificationvalidationPackage;
import org.eclipse.uml2.uml.NamedElement;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>VV Case</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.impl.VVCaseImpl#getBase_Class <em>Base Class</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.impl.VVCaseImpl#getVvCase <em>Vv Case</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.impl.VVCaseImpl#getAbstractVVCase <em>Abstract VV Case</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.impl.VVCaseImpl#getVvTarget <em>Vv Target</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.impl.VVCaseImpl#getVvSubject <em>Vv Subject</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.impl.VVCaseImpl#getVvLog <em>Vv Log</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.impl.VVCaseImpl#getVvProcedure <em>Vv Procedure</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class VVCaseImpl extends TraceableSpecificationImpl implements VVCase {

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
	 * The cached value of the '{@link #getVvCase() <em>Vv Case</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getVvCase()
	 * @generated
	 * @ordered
	 */
	protected EList<VVCase> vvCase;

	/**
	 * The cached value of the '{@link #getAbstractVVCase() <em>Abstract VV Case</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getAbstractVVCase()
	 * @generated
	 * @ordered
	 */
	protected VVCase abstractVVCase;

	/**
	 * The cached value of the '{@link #getVvTarget() <em>Vv Target</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getVvTarget()
	 * @generated
	 * @ordered
	 */
	protected EList<VVTarget> vvTarget;

	/**
	 * The cached value of the '{@link #getVvSubject() <em>Vv Subject</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getVvSubject()
	 * @generated
	 * @ordered
	 */
	protected EList<NamedElement> vvSubject;

	/**
	 * The cached value of the '{@link #getVvLog() <em>Vv Log</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getVvLog()
	 * @generated
	 * @ordered
	 */
	protected EList<VVLog> vvLog;

	/**
	 * The cached value of the '{@link #getVvProcedure() <em>Vv Procedure</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getVvProcedure()
	 * @generated
	 * @ordered
	 */
	protected EList<VVProcedure> vvProcedure;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected VVCaseImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public VVCase basicGetAbstractVVCase() {
		return abstractVVCase;
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
		case VerificationvalidationPackage.VV_CASE__BASE_CLASS:
			if(resolve)
				return getBase_Class();
			return basicGetBase_Class();
		case VerificationvalidationPackage.VV_CASE__VV_CASE:
			return getVvCase();
		case VerificationvalidationPackage.VV_CASE__ABSTRACT_VV_CASE:
			if(resolve)
				return getAbstractVVCase();
			return basicGetAbstractVVCase();
		case VerificationvalidationPackage.VV_CASE__VV_TARGET:
			return getVvTarget();
		case VerificationvalidationPackage.VV_CASE__VV_SUBJECT:
			return getVvSubject();
		case VerificationvalidationPackage.VV_CASE__VV_LOG:
			return getVvLog();
		case VerificationvalidationPackage.VV_CASE__VV_PROCEDURE:
			return getVvProcedure();
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
		case VerificationvalidationPackage.VV_CASE__BASE_CLASS:
			return base_Class != null;
		case VerificationvalidationPackage.VV_CASE__VV_CASE:
			return vvCase != null && !vvCase.isEmpty();
		case VerificationvalidationPackage.VV_CASE__ABSTRACT_VV_CASE:
			return abstractVVCase != null;
		case VerificationvalidationPackage.VV_CASE__VV_TARGET:
			return vvTarget != null && !vvTarget.isEmpty();
		case VerificationvalidationPackage.VV_CASE__VV_SUBJECT:
			return vvSubject != null && !vvSubject.isEmpty();
		case VerificationvalidationPackage.VV_CASE__VV_LOG:
			return vvLog != null && !vvLog.isEmpty();
		case VerificationvalidationPackage.VV_CASE__VV_PROCEDURE:
			return vvProcedure != null && !vvProcedure.isEmpty();
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
		case VerificationvalidationPackage.VV_CASE__BASE_CLASS:
			setBase_Class((org.eclipse.uml2.uml.Class)newValue);
			return;
		case VerificationvalidationPackage.VV_CASE__VV_CASE:
			getVvCase().clear();
			getVvCase().addAll((Collection<? extends VVCase>)newValue);
			return;
		case VerificationvalidationPackage.VV_CASE__ABSTRACT_VV_CASE:
			setAbstractVVCase((VVCase)newValue);
			return;
		case VerificationvalidationPackage.VV_CASE__VV_TARGET:
			getVvTarget().clear();
			getVvTarget().addAll((Collection<? extends VVTarget>)newValue);
			return;
		case VerificationvalidationPackage.VV_CASE__VV_SUBJECT:
			getVvSubject().clear();
			getVvSubject().addAll((Collection<? extends NamedElement>)newValue);
			return;
		case VerificationvalidationPackage.VV_CASE__VV_LOG:
			getVvLog().clear();
			getVvLog().addAll((Collection<? extends VVLog>)newValue);
			return;
		case VerificationvalidationPackage.VV_CASE__VV_PROCEDURE:
			getVvProcedure().clear();
			getVvProcedure().addAll((Collection<? extends VVProcedure>)newValue);
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
		return VerificationvalidationPackage.Literals.VV_CASE;
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
		case VerificationvalidationPackage.VV_CASE__BASE_CLASS:
			setBase_Class((org.eclipse.uml2.uml.Class)null);
			return;
		case VerificationvalidationPackage.VV_CASE__VV_CASE:
			getVvCase().clear();
			return;
		case VerificationvalidationPackage.VV_CASE__ABSTRACT_VV_CASE:
			setAbstractVVCase((VVCase)null);
			return;
		case VerificationvalidationPackage.VV_CASE__VV_TARGET:
			getVvTarget().clear();
			return;
		case VerificationvalidationPackage.VV_CASE__VV_SUBJECT:
			getVvSubject().clear();
			return;
		case VerificationvalidationPackage.VV_CASE__VV_LOG:
			getVvLog().clear();
			return;
		case VerificationvalidationPackage.VV_CASE__VV_PROCEDURE:
			getVvProcedure().clear();
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
	public VVCase getAbstractVVCase() {
		if(abstractVVCase != null && abstractVVCase.eIsProxy()) {
			InternalEObject oldAbstractVVCase = (InternalEObject)abstractVVCase;
			abstractVVCase = (VVCase)eResolveProxy(oldAbstractVVCase);
			if(abstractVVCase != oldAbstractVVCase) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, VerificationvalidationPackage.VV_CASE__ABSTRACT_VV_CASE, oldAbstractVVCase, abstractVVCase));
			}
		}
		return abstractVVCase;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, VerificationvalidationPackage.VV_CASE__BASE_CLASS, oldBase_Class, base_Class));
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
	public EList<VVCase> getVvCase() {
		if(vvCase == null) {
			vvCase = new EObjectResolvingEList<VVCase>(VVCase.class, this, VerificationvalidationPackage.VV_CASE__VV_CASE);
		}
		return vvCase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<VVLog> getVvLog() {
		if(vvLog == null) {
			vvLog = new EObjectResolvingEList<VVLog>(VVLog.class, this, VerificationvalidationPackage.VV_CASE__VV_LOG);
		}
		return vvLog;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<VVProcedure> getVvProcedure() {
		if(vvProcedure == null) {
			vvProcedure = new EObjectResolvingEList<VVProcedure>(VVProcedure.class, this, VerificationvalidationPackage.VV_CASE__VV_PROCEDURE);
		}
		return vvProcedure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<NamedElement> getVvSubject() {
		if(vvSubject == null) {
			vvSubject = new EObjectResolvingEList<NamedElement>(NamedElement.class, this, VerificationvalidationPackage.VV_CASE__VV_SUBJECT);
		}
		return vvSubject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<VVTarget> getVvTarget() {
		if(vvTarget == null) {
			vvTarget = new EObjectResolvingEList<VVTarget>(VVTarget.class, this, VerificationvalidationPackage.VV_CASE__VV_TARGET);
		}
		return vvTarget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setAbstractVVCase(VVCase newAbstractVVCase) {
		VVCase oldAbstractVVCase = abstractVVCase;
		abstractVVCase = newAbstractVVCase;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VerificationvalidationPackage.VV_CASE__ABSTRACT_VV_CASE, oldAbstractVVCase, abstractVVCase));
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
			eNotify(new ENotificationImpl(this, Notification.SET, VerificationvalidationPackage.VV_CASE__BASE_CLASS, oldBase_Class, base_Class));
	}

} //VVCaseImpl
