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
package org.eclipse.papyrus.eastadl.dependability.safetycase.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.papyrus.eastadl.dependability.safetycase.Claim;
import org.eclipse.papyrus.eastadl.dependability.safetycase.Ground;
import org.eclipse.papyrus.eastadl.dependability.safetycase.LifecycleStageKind;
import org.eclipse.papyrus.eastadl.dependability.safetycase.SafetyCase;
import org.eclipse.papyrus.eastadl.dependability.safetycase.SafetycasePackage;
import org.eclipse.papyrus.eastadl.dependability.safetycase.Warrant;
import org.eclipse.papyrus.eastadl.infrastructure.elements.impl.TraceableSpecificationImpl;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Safety Case</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.safetycase.impl.SafetyCaseImpl#getSafetyCase <em>Safety Case</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.safetycase.impl.SafetyCaseImpl#getStage <em>Stage</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.safetycase.impl.SafetyCaseImpl#getContext <em>Context</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.safetycase.impl.SafetyCaseImpl#getGround <em>Ground</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.safetycase.impl.SafetyCaseImpl#getWarrant <em>Warrant</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.safetycase.impl.SafetyCaseImpl#getClaim <em>Claim</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.dependability.safetycase.impl.SafetyCaseImpl#getBase_Class <em>Base Class</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class SafetyCaseImpl extends TraceableSpecificationImpl implements SafetyCase {

	/**
	 * The cached value of the '{@link #getSafetyCase() <em>Safety Case</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getSafetyCase()
	 * @generated
	 * @ordered
	 */
	protected EList<SafetyCase> safetyCase;

	/**
	 * The default value of the '{@link #getStage() <em>Stage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getStage()
	 * @generated
	 * @ordered
	 */
	protected static final LifecycleStageKind STAGE_EDEFAULT = LifecycleStageKind.PRELIMINARY_SAFETY_CASE;

	/**
	 * The cached value of the '{@link #getStage() <em>Stage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getStage()
	 * @generated
	 * @ordered
	 */
	protected LifecycleStageKind stage = STAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getContext() <em>Context</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getContext()
	 * @generated
	 * @ordered
	 */
	protected static final String CONTEXT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getContext() <em>Context</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getContext()
	 * @generated
	 * @ordered
	 */
	protected String context = CONTEXT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getGround() <em>Ground</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getGround()
	 * @generated
	 * @ordered
	 */
	protected EList<Ground> ground;

	/**
	 * The cached value of the '{@link #getWarrant() <em>Warrant</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getWarrant()
	 * @generated
	 * @ordered
	 */
	protected EList<Warrant> warrant;

	/**
	 * The cached value of the '{@link #getClaim() <em>Claim</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getClaim()
	 * @generated
	 * @ordered
	 */
	protected EList<Claim> claim;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected SafetyCaseImpl() {
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
		case SafetycasePackage.SAFETY_CASE__SAFETY_CASE:
			return getSafetyCase();
		case SafetycasePackage.SAFETY_CASE__STAGE:
			return getStage();
		case SafetycasePackage.SAFETY_CASE__CONTEXT:
			return getContext();
		case SafetycasePackage.SAFETY_CASE__GROUND:
			return getGround();
		case SafetycasePackage.SAFETY_CASE__WARRANT:
			return getWarrant();
		case SafetycasePackage.SAFETY_CASE__CLAIM:
			return getClaim();
		case SafetycasePackage.SAFETY_CASE__BASE_CLASS:
			if(resolve)
				return getBase_Class();
			return basicGetBase_Class();
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
		case SafetycasePackage.SAFETY_CASE__SAFETY_CASE:
			return safetyCase != null && !safetyCase.isEmpty();
		case SafetycasePackage.SAFETY_CASE__STAGE:
			return stage != STAGE_EDEFAULT;
		case SafetycasePackage.SAFETY_CASE__CONTEXT:
			return CONTEXT_EDEFAULT == null ? context != null : !CONTEXT_EDEFAULT.equals(context);
		case SafetycasePackage.SAFETY_CASE__GROUND:
			return ground != null && !ground.isEmpty();
		case SafetycasePackage.SAFETY_CASE__WARRANT:
			return warrant != null && !warrant.isEmpty();
		case SafetycasePackage.SAFETY_CASE__CLAIM:
			return claim != null && !claim.isEmpty();
		case SafetycasePackage.SAFETY_CASE__BASE_CLASS:
			return base_Class != null;
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
		case SafetycasePackage.SAFETY_CASE__SAFETY_CASE:
			getSafetyCase().clear();
			getSafetyCase().addAll((Collection<? extends SafetyCase>)newValue);
			return;
		case SafetycasePackage.SAFETY_CASE__STAGE:
			setStage((LifecycleStageKind)newValue);
			return;
		case SafetycasePackage.SAFETY_CASE__CONTEXT:
			setContext((String)newValue);
			return;
		case SafetycasePackage.SAFETY_CASE__GROUND:
			getGround().clear();
			getGround().addAll((Collection<? extends Ground>)newValue);
			return;
		case SafetycasePackage.SAFETY_CASE__WARRANT:
			getWarrant().clear();
			getWarrant().addAll((Collection<? extends Warrant>)newValue);
			return;
		case SafetycasePackage.SAFETY_CASE__CLAIM:
			getClaim().clear();
			getClaim().addAll((Collection<? extends Claim>)newValue);
			return;
		case SafetycasePackage.SAFETY_CASE__BASE_CLASS:
			setBase_Class((org.eclipse.uml2.uml.Class)newValue);
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
		return SafetycasePackage.Literals.SAFETY_CASE;
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
		case SafetycasePackage.SAFETY_CASE__SAFETY_CASE:
			getSafetyCase().clear();
			return;
		case SafetycasePackage.SAFETY_CASE__STAGE:
			setStage(STAGE_EDEFAULT);
			return;
		case SafetycasePackage.SAFETY_CASE__CONTEXT:
			setContext(CONTEXT_EDEFAULT);
			return;
		case SafetycasePackage.SAFETY_CASE__GROUND:
			getGround().clear();
			return;
		case SafetycasePackage.SAFETY_CASE__WARRANT:
			getWarrant().clear();
			return;
		case SafetycasePackage.SAFETY_CASE__CLAIM:
			getClaim().clear();
			return;
		case SafetycasePackage.SAFETY_CASE__BASE_CLASS:
			setBase_Class((org.eclipse.uml2.uml.Class)null);
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
	public EList<Claim> getClaim() {
		if(claim == null) {
			claim = new EObjectResolvingEList<Claim>(Claim.class, this, SafetycasePackage.SAFETY_CASE__CLAIM);
		}
		return claim;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SafetycasePackage.SAFETY_CASE__BASE_CLASS, oldBase_Class, base_Class));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SafetycasePackage.SAFETY_CASE__BASE_CLASS, oldBase_Class, base_Class));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch(featureID) {
		case SafetycasePackage.SAFETY_CASE__SAFETY_CASE:
			return ((InternalEList<?>)getSafetyCase()).basicRemove(otherEnd, msgs);
		case SafetycasePackage.SAFETY_CASE__GROUND:
			return ((InternalEList<?>)getGround()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getContext() {
		return context;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<Ground> getGround() {
		if(ground == null) {
			ground = new EObjectContainmentEList<Ground>(Ground.class, this, SafetycasePackage.SAFETY_CASE__GROUND);
		}
		return ground;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<SafetyCase> getSafetyCase() {
		if(safetyCase == null) {
			safetyCase = new EObjectContainmentEList<SafetyCase>(SafetyCase.class, this, SafetycasePackage.SAFETY_CASE__SAFETY_CASE);
		}
		return safetyCase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public LifecycleStageKind getStage() {
		return stage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<Warrant> getWarrant() {
		if(warrant == null) {
			warrant = new EObjectResolvingEList<Warrant>(Warrant.class, this, SafetycasePackage.SAFETY_CASE__WARRANT);
		}
		return warrant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setContext(String newContext) {
		String oldContext = context;
		context = newContext;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SafetycasePackage.SAFETY_CASE__CONTEXT, oldContext, context));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setStage(LifecycleStageKind newStage) {
		LifecycleStageKind oldStage = stage;
		stage = newStage == null ? STAGE_EDEFAULT : newStage;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SafetycasePackage.SAFETY_CASE__STAGE, oldStage, stage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if(eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (stage: ");
		result.append(stage);
		result.append(", context: ");
		result.append(context);
		result.append(')');
		return result.toString();
	}

} //SafetyCaseImpl
