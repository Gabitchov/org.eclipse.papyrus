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
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.papyrus.eastadl.dependability.safetycase.Claim;
import org.eclipse.papyrus.eastadl.dependability.safetycase.Ground;
import org.eclipse.papyrus.eastadl.dependability.safetycase.SafetycasePackage;
import org.eclipse.papyrus.eastadl.dependability.safetycase.Warrant;
import org.eclipse.papyrus.eastadl.infrastructure.elements.impl.TraceableSpecificationImpl;
import org.eclipse.uml2.uml.Comment;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Warrant</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.safetycase.impl.WarrantImpl#getDecomposedGoal <em>Decomposed Goal</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.safetycase.impl.WarrantImpl#getEvidence <em>Evidence</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.safetycase.impl.WarrantImpl#getBase_Class <em>Base Class</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.safetycase.impl.WarrantImpl#getJustification <em>Justification</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WarrantImpl extends TraceableSpecificationImpl implements Warrant {
	/**
	 * The cached value of the '{@link #getDecomposedGoal() <em>Decomposed Goal</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDecomposedGoal()
	 * @generated
	 * @ordered
	 */
	protected EList<Claim> decomposedGoal;

	/**
	 * The cached value of the '{@link #getEvidence() <em>Evidence</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEvidence()
	 * @generated
	 * @ordered
	 */
	protected EList<Ground> evidence;

	/**
	 * The cached value of the '{@link #getBase_Class() <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Class()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.uml2.uml.Class base_Class;

	/**
	 * The cached value of the '{@link #getJustification() <em>Justification</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJustification()
	 * @generated
	 * @ordered
	 */
	protected EList<Comment> justification;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WarrantImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SafetycasePackage.WARRANT__DECOMPOSED_GOAL:
				return getDecomposedGoal();
			case SafetycasePackage.WARRANT__EVIDENCE:
				return getEvidence();
			case SafetycasePackage.WARRANT__BASE_CLASS:
				if (resolve) return getBase_Class();
				return basicGetBase_Class();
			case SafetycasePackage.WARRANT__JUSTIFICATION:
				return getJustification();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SafetycasePackage.WARRANT__DECOMPOSED_GOAL:
				return decomposedGoal != null && !decomposedGoal.isEmpty();
			case SafetycasePackage.WARRANT__EVIDENCE:
				return evidence != null && !evidence.isEmpty();
			case SafetycasePackage.WARRANT__BASE_CLASS:
				return base_Class != null;
			case SafetycasePackage.WARRANT__JUSTIFICATION:
				return justification != null && !justification.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SafetycasePackage.WARRANT__DECOMPOSED_GOAL:
				getDecomposedGoal().clear();
				getDecomposedGoal().addAll((Collection<? extends Claim>)newValue);
				return;
			case SafetycasePackage.WARRANT__EVIDENCE:
				getEvidence().clear();
				getEvidence().addAll((Collection<? extends Ground>)newValue);
				return;
			case SafetycasePackage.WARRANT__BASE_CLASS:
				setBase_Class((org.eclipse.uml2.uml.Class)newValue);
				return;
			case SafetycasePackage.WARRANT__JUSTIFICATION:
				getJustification().clear();
				getJustification().addAll((Collection<? extends Comment>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SafetycasePackage.Literals.WARRANT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case SafetycasePackage.WARRANT__DECOMPOSED_GOAL:
				getDecomposedGoal().clear();
				return;
			case SafetycasePackage.WARRANT__EVIDENCE:
				getEvidence().clear();
				return;
			case SafetycasePackage.WARRANT__BASE_CLASS:
				setBase_Class((org.eclipse.uml2.uml.Class)null);
				return;
			case SafetycasePackage.WARRANT__JUSTIFICATION:
				getJustification().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Claim> getDecomposedGoal() {
		if (decomposedGoal == null) {
			decomposedGoal = new EObjectResolvingEList<Claim>(Claim.class, this, SafetycasePackage.WARRANT__DECOMPOSED_GOAL);
		}
		return decomposedGoal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Ground> getEvidence() {
		if (evidence == null) {
			evidence = new EObjectResolvingEList<Ground>(Ground.class, this, SafetycasePackage.WARRANT__EVIDENCE);
		}
		return evidence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Class getBase_Class() {
		if (base_Class != null && base_Class.eIsProxy()) {
			InternalEObject oldBase_Class = (InternalEObject)base_Class;
			base_Class = (org.eclipse.uml2.uml.Class)eResolveProxy(oldBase_Class);
			if (base_Class != oldBase_Class) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SafetycasePackage.WARRANT__BASE_CLASS, oldBase_Class, base_Class));
			}
		}
		return base_Class;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Class basicGetBase_Class() {
		return base_Class;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Class(org.eclipse.uml2.uml.Class newBase_Class) {
		org.eclipse.uml2.uml.Class oldBase_Class = base_Class;
		base_Class = newBase_Class;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SafetycasePackage.WARRANT__BASE_CLASS, oldBase_Class, base_Class));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Comment> getJustification() {
		if (justification == null) {
			justification = new EObjectResolvingEList<Comment>(Comment.class, this, SafetycasePackage.WARRANT__JUSTIFICATION);
		}
		return justification;
	}

} //WarrantImpl
