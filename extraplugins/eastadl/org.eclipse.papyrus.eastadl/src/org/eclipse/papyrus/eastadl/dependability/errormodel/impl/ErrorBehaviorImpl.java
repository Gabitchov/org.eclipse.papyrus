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
package org.eclipse.papyrus.eastadl.dependability.errormodel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorBehavior;
import org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorBehaviorKind;
import org.eclipse.papyrus.eastadl.dependability.errormodel.ErrorModelType;
import org.eclipse.papyrus.eastadl.dependability.errormodel.ErrormodelPackage;
import org.eclipse.papyrus.eastadl.dependability.errormodel.FailureOutPort;
import org.eclipse.papyrus.eastadl.dependability.errormodel.FaultInPort;
import org.eclipse.papyrus.eastadl.dependability.errormodel.InternalFaultPrototype;
import org.eclipse.papyrus.eastadl.dependability.errormodel.ProcessFaultPrototype;
import org.eclipse.papyrus.eastadl.infrastructure.elements.impl.EAElementImpl;
import org.eclipse.uml2.uml.Behavior;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Error Behavior</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.errormodel.impl.ErrorBehaviorImpl#getBase_Behavior <em>Base Behavior</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.errormodel.impl.ErrorBehaviorImpl#getFailureLogic <em>Failure Logic</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.errormodel.impl.ErrorBehaviorImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.errormodel.impl.ErrorBehaviorImpl#getInternalFault <em>Internal Fault</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.errormodel.impl.ErrorBehaviorImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.errormodel.impl.ErrorBehaviorImpl#getExternalFailure <em>External Failure</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.errormodel.impl.ErrorBehaviorImpl#getExternalFault <em>External Fault</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.dependability.errormodel.impl.ErrorBehaviorImpl#getProcessFault <em>Process Fault</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ErrorBehaviorImpl extends EAElementImpl implements ErrorBehavior {
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
	 * The default value of the '{@link #getFailureLogic() <em>Failure Logic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFailureLogic()
	 * @generated
	 * @ordered
	 */
	protected static final String FAILURE_LOGIC_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFailureLogic() <em>Failure Logic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFailureLogic()
	 * @generated
	 * @ordered
	 */
	protected String failureLogic = FAILURE_LOGIC_EDEFAULT;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final ErrorBehaviorKind TYPE_EDEFAULT = ErrorBehaviorKind.HIP_HOPS;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected ErrorBehaviorKind type = TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getInternalFault() <em>Internal Fault</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInternalFault()
	 * @generated
	 * @ordered
	 */
	protected EList<InternalFaultPrototype> internalFault;

	/**
	 * The cached value of the '{@link #getOwner() <em>Owner</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwner()
	 * @generated
	 * @ordered
	 */
	protected ErrorModelType owner;

	/**
	 * The cached value of the '{@link #getExternalFailure() <em>External Failure</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExternalFailure()
	 * @generated
	 * @ordered
	 */
	protected EList<FailureOutPort> externalFailure;

	/**
	 * The cached value of the '{@link #getExternalFault() <em>External Fault</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExternalFault()
	 * @generated
	 * @ordered
	 */
	protected EList<FaultInPort> externalFault;

	/**
	 * The cached value of the '{@link #getProcessFault() <em>Process Fault</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcessFault()
	 * @generated
	 * @ordered
	 */
	protected EList<ProcessFaultPrototype> processFault;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ErrorBehaviorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ErrorModelType basicGetOwner() {
		return owner;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwner(ErrorModelType newOwner, NotificationChain msgs) {
		ErrorModelType oldOwner = owner;
		owner = newOwner;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ErrormodelPackage.ERROR_BEHAVIOR__OWNER, oldOwner, newOwner);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ErrormodelPackage.ERROR_BEHAVIOR__BASE_BEHAVIOR:
				if (resolve) return getBase_Behavior();
				return basicGetBase_Behavior();
			case ErrormodelPackage.ERROR_BEHAVIOR__FAILURE_LOGIC:
				return getFailureLogic();
			case ErrormodelPackage.ERROR_BEHAVIOR__TYPE:
				return getType();
			case ErrormodelPackage.ERROR_BEHAVIOR__INTERNAL_FAULT:
				return getInternalFault();
			case ErrormodelPackage.ERROR_BEHAVIOR__OWNER:
				if (resolve) return getOwner();
				return basicGetOwner();
			case ErrormodelPackage.ERROR_BEHAVIOR__EXTERNAL_FAILURE:
				return getExternalFailure();
			case ErrormodelPackage.ERROR_BEHAVIOR__EXTERNAL_FAULT:
				return getExternalFault();
			case ErrormodelPackage.ERROR_BEHAVIOR__PROCESS_FAULT:
				return getProcessFault();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ErrormodelPackage.ERROR_BEHAVIOR__OWNER:
				if (owner != null)
					msgs = ((InternalEObject)owner).eInverseRemove(this, ErrormodelPackage.ERROR_MODEL_TYPE__ERROR_BEHAVIOR_DESCRIPTION, ErrorModelType.class, msgs);
				return basicSetOwner((ErrorModelType)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ErrormodelPackage.ERROR_BEHAVIOR__OWNER:
				return basicSetOwner(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ErrormodelPackage.ERROR_BEHAVIOR__BASE_BEHAVIOR:
				return base_Behavior != null;
			case ErrormodelPackage.ERROR_BEHAVIOR__FAILURE_LOGIC:
				return FAILURE_LOGIC_EDEFAULT == null ? failureLogic != null : !FAILURE_LOGIC_EDEFAULT.equals(failureLogic);
			case ErrormodelPackage.ERROR_BEHAVIOR__TYPE:
				return type != TYPE_EDEFAULT;
			case ErrormodelPackage.ERROR_BEHAVIOR__INTERNAL_FAULT:
				return internalFault != null && !internalFault.isEmpty();
			case ErrormodelPackage.ERROR_BEHAVIOR__OWNER:
				return owner != null;
			case ErrormodelPackage.ERROR_BEHAVIOR__EXTERNAL_FAILURE:
				return externalFailure != null && !externalFailure.isEmpty();
			case ErrormodelPackage.ERROR_BEHAVIOR__EXTERNAL_FAULT:
				return externalFault != null && !externalFault.isEmpty();
			case ErrormodelPackage.ERROR_BEHAVIOR__PROCESS_FAULT:
				return processFault != null && !processFault.isEmpty();
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
			case ErrormodelPackage.ERROR_BEHAVIOR__BASE_BEHAVIOR:
				setBase_Behavior((Behavior)newValue);
				return;
			case ErrormodelPackage.ERROR_BEHAVIOR__FAILURE_LOGIC:
				setFailureLogic((String)newValue);
				return;
			case ErrormodelPackage.ERROR_BEHAVIOR__TYPE:
				setType((ErrorBehaviorKind)newValue);
				return;
			case ErrormodelPackage.ERROR_BEHAVIOR__INTERNAL_FAULT:
				getInternalFault().clear();
				getInternalFault().addAll((Collection<? extends InternalFaultPrototype>)newValue);
				return;
			case ErrormodelPackage.ERROR_BEHAVIOR__OWNER:
				setOwner((ErrorModelType)newValue);
				return;
			case ErrormodelPackage.ERROR_BEHAVIOR__EXTERNAL_FAILURE:
				getExternalFailure().clear();
				getExternalFailure().addAll((Collection<? extends FailureOutPort>)newValue);
				return;
			case ErrormodelPackage.ERROR_BEHAVIOR__EXTERNAL_FAULT:
				getExternalFault().clear();
				getExternalFault().addAll((Collection<? extends FaultInPort>)newValue);
				return;
			case ErrormodelPackage.ERROR_BEHAVIOR__PROCESS_FAULT:
				getProcessFault().clear();
				getProcessFault().addAll((Collection<? extends ProcessFaultPrototype>)newValue);
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
		return ErrormodelPackage.Literals.ERROR_BEHAVIOR;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ErrormodelPackage.ERROR_BEHAVIOR__BASE_BEHAVIOR, oldBase_Behavior, base_Behavior));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ErrormodelPackage.ERROR_BEHAVIOR__BASE_BEHAVIOR, oldBase_Behavior, base_Behavior));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ErrormodelPackage.ERROR_BEHAVIOR__BASE_BEHAVIOR:
				setBase_Behavior((Behavior)null);
				return;
			case ErrormodelPackage.ERROR_BEHAVIOR__FAILURE_LOGIC:
				setFailureLogic(FAILURE_LOGIC_EDEFAULT);
				return;
			case ErrormodelPackage.ERROR_BEHAVIOR__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case ErrormodelPackage.ERROR_BEHAVIOR__INTERNAL_FAULT:
				getInternalFault().clear();
				return;
			case ErrormodelPackage.ERROR_BEHAVIOR__OWNER:
				setOwner((ErrorModelType)null);
				return;
			case ErrormodelPackage.ERROR_BEHAVIOR__EXTERNAL_FAILURE:
				getExternalFailure().clear();
				return;
			case ErrormodelPackage.ERROR_BEHAVIOR__EXTERNAL_FAULT:
				getExternalFault().clear();
				return;
			case ErrormodelPackage.ERROR_BEHAVIOR__PROCESS_FAULT:
				getProcessFault().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FailureOutPort> getExternalFailure() {
		if (externalFailure == null) {
			externalFailure = new EObjectResolvingEList<FailureOutPort>(FailureOutPort.class, this, ErrormodelPackage.ERROR_BEHAVIOR__EXTERNAL_FAILURE);
		}
		return externalFailure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FaultInPort> getExternalFault() {
		if (externalFault == null) {
			externalFault = new EObjectResolvingEList<FaultInPort>(FaultInPort.class, this, ErrormodelPackage.ERROR_BEHAVIOR__EXTERNAL_FAULT);
		}
		return externalFault;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFailureLogic() {
		return failureLogic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFailureLogic(String newFailureLogic) {
		String oldFailureLogic = failureLogic;
		failureLogic = newFailureLogic;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ErrormodelPackage.ERROR_BEHAVIOR__FAILURE_LOGIC, oldFailureLogic, failureLogic));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InternalFaultPrototype> getInternalFault() {
		if (internalFault == null) {
			internalFault = new EObjectResolvingEList<InternalFaultPrototype>(InternalFaultPrototype.class, this, ErrormodelPackage.ERROR_BEHAVIOR__INTERNAL_FAULT);
		}
		return internalFault;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ErrorModelType getOwner() {
		if (owner != null && owner.eIsProxy()) {
			InternalEObject oldOwner = (InternalEObject)owner;
			owner = (ErrorModelType)eResolveProxy(oldOwner);
			if (owner != oldOwner) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ErrormodelPackage.ERROR_BEHAVIOR__OWNER, oldOwner, owner));
			}
		}
		return owner;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ProcessFaultPrototype> getProcessFault() {
		if (processFault == null) {
			processFault = new EObjectResolvingEList<ProcessFaultPrototype>(ProcessFaultPrototype.class, this, ErrormodelPackage.ERROR_BEHAVIOR__PROCESS_FAULT);
		}
		return processFault;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ErrorBehaviorKind getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwner(ErrorModelType newOwner) {
		if (newOwner != owner) {
			NotificationChain msgs = null;
			if (owner != null)
				msgs = ((InternalEObject)owner).eInverseRemove(this, ErrormodelPackage.ERROR_MODEL_TYPE__ERROR_BEHAVIOR_DESCRIPTION, ErrorModelType.class, msgs);
			if (newOwner != null)
				msgs = ((InternalEObject)newOwner).eInverseAdd(this, ErrormodelPackage.ERROR_MODEL_TYPE__ERROR_BEHAVIOR_DESCRIPTION, ErrorModelType.class, msgs);
			msgs = basicSetOwner(newOwner, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ErrormodelPackage.ERROR_BEHAVIOR__OWNER, newOwner, newOwner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(ErrorBehaviorKind newType) {
		ErrorBehaviorKind oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ErrormodelPackage.ERROR_BEHAVIOR__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (failureLogic: ");
		result.append(failureLogic);
		result.append(", type: ");
		result.append(type);
		result.append(')');
		return result.toString();
	}

} //ErrorBehaviorImpl
