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
 *  Chokri MRAIDHA (CEA LIST) chokri.mraidha@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.GRMPackage;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.GrService;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Resource;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.BehavioralFeature;
import org.eclipse.uml2.uml.Collaboration;
import org.eclipse.uml2.uml.CollaborationUse;
import org.eclipse.uml2.uml.ExecutionSpecification;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gr Service</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.GrServiceImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.GrServiceImpl#getBase_ExecutionSpecification <em>Base Execution Specification</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.GrServiceImpl#getBase_BehavioralFeature <em>Base Behavioral Feature</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.GrServiceImpl#getBase_Behavior <em>Base Behavior</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.GrServiceImpl#getBase_Collaboration <em>Base Collaboration</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.GrServiceImpl#getBase_CollaborationUse <em>Base Collaboration Use</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GrServiceImpl extends EObjectImpl implements GrService {
	/**
	 * The cached value of the '{@link #getOwner() <em>Owner</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwner()
	 * @generated
	 * @ordered
	 */
	protected Resource owner;

	/**
	 * The cached value of the '{@link #getBase_ExecutionSpecification() <em>Base Execution Specification</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_ExecutionSpecification()
	 * @generated
	 * @ordered
	 */
	protected ExecutionSpecification base_ExecutionSpecification;

	/**
	 * The cached value of the '{@link #getBase_BehavioralFeature() <em>Base Behavioral Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_BehavioralFeature()
	 * @generated
	 * @ordered
	 */
	protected BehavioralFeature base_BehavioralFeature;

	/**
	 * The cached value of the '{@link #getBase_Behavior() <em>Base Behavior</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Behavior()
	 * @generated
	 * @ordered
	 */
	protected Behavior base_Behavior;

	/**
	 * The cached value of the '{@link #getBase_Collaboration() <em>Base Collaboration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Collaboration()
	 * @generated
	 * @ordered
	 */
	protected Collaboration base_Collaboration;

	/**
	 * The cached value of the '{@link #getBase_CollaborationUse() <em>Base Collaboration Use</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_CollaborationUse()
	 * @generated
	 * @ordered
	 */
	protected CollaborationUse base_CollaborationUse;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GrServiceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GRMPackage.Literals.GR_SERVICE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Resource getOwner() {
		if (owner != null && owner.eIsProxy()) {
			InternalEObject oldOwner = (InternalEObject)owner;
			owner = (Resource)eResolveProxy(oldOwner);
			if (owner != oldOwner) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GRMPackage.GR_SERVICE__OWNER, oldOwner, owner));
			}
		}
		return owner;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Resource basicGetOwner() {
		return owner;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwner(Resource newOwner) {
		Resource oldOwner = owner;
		owner = newOwner;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GRMPackage.GR_SERVICE__OWNER, oldOwner, owner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionSpecification getBase_ExecutionSpecification() {
		if (base_ExecutionSpecification != null && base_ExecutionSpecification.eIsProxy()) {
			InternalEObject oldBase_ExecutionSpecification = (InternalEObject)base_ExecutionSpecification;
			base_ExecutionSpecification = (ExecutionSpecification)eResolveProxy(oldBase_ExecutionSpecification);
			if (base_ExecutionSpecification != oldBase_ExecutionSpecification) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GRMPackage.GR_SERVICE__BASE_EXECUTION_SPECIFICATION, oldBase_ExecutionSpecification, base_ExecutionSpecification));
			}
		}
		return base_ExecutionSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionSpecification basicGetBase_ExecutionSpecification() {
		return base_ExecutionSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_ExecutionSpecification(ExecutionSpecification newBase_ExecutionSpecification) {
		ExecutionSpecification oldBase_ExecutionSpecification = base_ExecutionSpecification;
		base_ExecutionSpecification = newBase_ExecutionSpecification;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GRMPackage.GR_SERVICE__BASE_EXECUTION_SPECIFICATION, oldBase_ExecutionSpecification, base_ExecutionSpecification));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BehavioralFeature getBase_BehavioralFeature() {
		if (base_BehavioralFeature != null && base_BehavioralFeature.eIsProxy()) {
			InternalEObject oldBase_BehavioralFeature = (InternalEObject)base_BehavioralFeature;
			base_BehavioralFeature = (BehavioralFeature)eResolveProxy(oldBase_BehavioralFeature);
			if (base_BehavioralFeature != oldBase_BehavioralFeature) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GRMPackage.GR_SERVICE__BASE_BEHAVIORAL_FEATURE, oldBase_BehavioralFeature, base_BehavioralFeature));
			}
		}
		return base_BehavioralFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BehavioralFeature basicGetBase_BehavioralFeature() {
		return base_BehavioralFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_BehavioralFeature(BehavioralFeature newBase_BehavioralFeature) {
		BehavioralFeature oldBase_BehavioralFeature = base_BehavioralFeature;
		base_BehavioralFeature = newBase_BehavioralFeature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GRMPackage.GR_SERVICE__BASE_BEHAVIORAL_FEATURE, oldBase_BehavioralFeature, base_BehavioralFeature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Behavior getBase_Behavior() {
		if (base_Behavior != null && base_Behavior.eIsProxy()) {
			InternalEObject oldBase_Behavior = (InternalEObject)base_Behavior;
			base_Behavior = (Behavior)eResolveProxy(oldBase_Behavior);
			if (base_Behavior != oldBase_Behavior) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GRMPackage.GR_SERVICE__BASE_BEHAVIOR, oldBase_Behavior, base_Behavior));
			}
		}
		return base_Behavior;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Behavior basicGetBase_Behavior() {
		return base_Behavior;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Behavior(Behavior newBase_Behavior) {
		Behavior oldBase_Behavior = base_Behavior;
		base_Behavior = newBase_Behavior;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GRMPackage.GR_SERVICE__BASE_BEHAVIOR, oldBase_Behavior, base_Behavior));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Collaboration getBase_Collaboration() {
		if (base_Collaboration != null && base_Collaboration.eIsProxy()) {
			InternalEObject oldBase_Collaboration = (InternalEObject)base_Collaboration;
			base_Collaboration = (Collaboration)eResolveProxy(oldBase_Collaboration);
			if (base_Collaboration != oldBase_Collaboration) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GRMPackage.GR_SERVICE__BASE_COLLABORATION, oldBase_Collaboration, base_Collaboration));
			}
		}
		return base_Collaboration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Collaboration basicGetBase_Collaboration() {
		return base_Collaboration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Collaboration(Collaboration newBase_Collaboration) {
		Collaboration oldBase_Collaboration = base_Collaboration;
		base_Collaboration = newBase_Collaboration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GRMPackage.GR_SERVICE__BASE_COLLABORATION, oldBase_Collaboration, base_Collaboration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CollaborationUse getBase_CollaborationUse() {
		if (base_CollaborationUse != null && base_CollaborationUse.eIsProxy()) {
			InternalEObject oldBase_CollaborationUse = (InternalEObject)base_CollaborationUse;
			base_CollaborationUse = (CollaborationUse)eResolveProxy(oldBase_CollaborationUse);
			if (base_CollaborationUse != oldBase_CollaborationUse) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GRMPackage.GR_SERVICE__BASE_COLLABORATION_USE, oldBase_CollaborationUse, base_CollaborationUse));
			}
		}
		return base_CollaborationUse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CollaborationUse basicGetBase_CollaborationUse() {
		return base_CollaborationUse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_CollaborationUse(CollaborationUse newBase_CollaborationUse) {
		CollaborationUse oldBase_CollaborationUse = base_CollaborationUse;
		base_CollaborationUse = newBase_CollaborationUse;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GRMPackage.GR_SERVICE__BASE_COLLABORATION_USE, oldBase_CollaborationUse, base_CollaborationUse));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GRMPackage.GR_SERVICE__OWNER:
				if (resolve) return getOwner();
				return basicGetOwner();
			case GRMPackage.GR_SERVICE__BASE_EXECUTION_SPECIFICATION:
				if (resolve) return getBase_ExecutionSpecification();
				return basicGetBase_ExecutionSpecification();
			case GRMPackage.GR_SERVICE__BASE_BEHAVIORAL_FEATURE:
				if (resolve) return getBase_BehavioralFeature();
				return basicGetBase_BehavioralFeature();
			case GRMPackage.GR_SERVICE__BASE_BEHAVIOR:
				if (resolve) return getBase_Behavior();
				return basicGetBase_Behavior();
			case GRMPackage.GR_SERVICE__BASE_COLLABORATION:
				if (resolve) return getBase_Collaboration();
				return basicGetBase_Collaboration();
			case GRMPackage.GR_SERVICE__BASE_COLLABORATION_USE:
				if (resolve) return getBase_CollaborationUse();
				return basicGetBase_CollaborationUse();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GRMPackage.GR_SERVICE__OWNER:
				setOwner((Resource)newValue);
				return;
			case GRMPackage.GR_SERVICE__BASE_EXECUTION_SPECIFICATION:
				setBase_ExecutionSpecification((ExecutionSpecification)newValue);
				return;
			case GRMPackage.GR_SERVICE__BASE_BEHAVIORAL_FEATURE:
				setBase_BehavioralFeature((BehavioralFeature)newValue);
				return;
			case GRMPackage.GR_SERVICE__BASE_BEHAVIOR:
				setBase_Behavior((Behavior)newValue);
				return;
			case GRMPackage.GR_SERVICE__BASE_COLLABORATION:
				setBase_Collaboration((Collaboration)newValue);
				return;
			case GRMPackage.GR_SERVICE__BASE_COLLABORATION_USE:
				setBase_CollaborationUse((CollaborationUse)newValue);
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
	public void eUnset(int featureID) {
		switch (featureID) {
			case GRMPackage.GR_SERVICE__OWNER:
				setOwner((Resource)null);
				return;
			case GRMPackage.GR_SERVICE__BASE_EXECUTION_SPECIFICATION:
				setBase_ExecutionSpecification((ExecutionSpecification)null);
				return;
			case GRMPackage.GR_SERVICE__BASE_BEHAVIORAL_FEATURE:
				setBase_BehavioralFeature((BehavioralFeature)null);
				return;
			case GRMPackage.GR_SERVICE__BASE_BEHAVIOR:
				setBase_Behavior((Behavior)null);
				return;
			case GRMPackage.GR_SERVICE__BASE_COLLABORATION:
				setBase_Collaboration((Collaboration)null);
				return;
			case GRMPackage.GR_SERVICE__BASE_COLLABORATION_USE:
				setBase_CollaborationUse((CollaborationUse)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case GRMPackage.GR_SERVICE__OWNER:
				return owner != null;
			case GRMPackage.GR_SERVICE__BASE_EXECUTION_SPECIFICATION:
				return base_ExecutionSpecification != null;
			case GRMPackage.GR_SERVICE__BASE_BEHAVIORAL_FEATURE:
				return base_BehavioralFeature != null;
			case GRMPackage.GR_SERVICE__BASE_BEHAVIOR:
				return base_Behavior != null;
			case GRMPackage.GR_SERVICE__BASE_COLLABORATION:
				return base_Collaboration != null;
			case GRMPackage.GR_SERVICE__BASE_COLLABORATION_USE:
				return base_CollaborationUse != null;
		}
		return super.eIsSet(featureID);
	}

} //GrServiceImpl
