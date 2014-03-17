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
package org.eclipse.papyrus.eastadl.behavior.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.papyrus.eastadl.behavior.Behavior;
import org.eclipse.papyrus.eastadl.behavior.BehaviorPackage;
import org.eclipse.papyrus.eastadl.behavior.FunctionBehavior;
import org.eclipse.papyrus.eastadl.behavior.FunctionTrigger;
import org.eclipse.papyrus.eastadl.behavior.ModeGroup;
import org.eclipse.papyrus.eastadl.infrastructure.elements.impl.ContextImpl;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Behavior</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.behavior.impl.BehaviorImpl#getBehavior <em>Behavior</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.behavior.impl.BehaviorImpl#getFunctionTrigger <em>Function Trigger</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.behavior.impl.BehaviorImpl#getModeGroup <em>Mode Group</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.behavior.impl.BehaviorImpl#getBase_Package <em>Base Package</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.behavior.impl.BehaviorImpl#getBase_Class <em>Base Class</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class BehaviorImpl extends ContextImpl implements Behavior {

	/**
	 * The cached value of the '{@link #getBehavior() <em>Behavior</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getBehavior()
	 * @generated
	 * @ordered
	 */
	protected EList<FunctionBehavior> behavior;

	/**
	 * The cached value of the '{@link #getFunctionTrigger() <em>Function Trigger</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getFunctionTrigger()
	 * @generated
	 * @ordered
	 */
	protected EList<FunctionTrigger> functionTrigger;

	/**
	 * The cached value of the '{@link #getModeGroup() <em>Mode Group</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getModeGroup()
	 * @generated
	 * @ordered
	 */
	protected EList<ModeGroup> modeGroup;

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
	protected BehaviorImpl() {
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
		case BehaviorPackage.BEHAVIOR__BEHAVIOR:
			return getBehavior();
		case BehaviorPackage.BEHAVIOR__FUNCTION_TRIGGER:
			return getFunctionTrigger();
		case BehaviorPackage.BEHAVIOR__MODE_GROUP:
			return getModeGroup();
		case BehaviorPackage.BEHAVIOR__BASE_PACKAGE:
			if(resolve)
				return getBase_Package();
			return basicGetBase_Package();
		case BehaviorPackage.BEHAVIOR__BASE_CLASS:
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
		case BehaviorPackage.BEHAVIOR__BEHAVIOR:
			return behavior != null && !behavior.isEmpty();
		case BehaviorPackage.BEHAVIOR__FUNCTION_TRIGGER:
			return functionTrigger != null && !functionTrigger.isEmpty();
		case BehaviorPackage.BEHAVIOR__MODE_GROUP:
			return modeGroup != null && !modeGroup.isEmpty();
		case BehaviorPackage.BEHAVIOR__BASE_PACKAGE:
			return base_Package != null;
		case BehaviorPackage.BEHAVIOR__BASE_CLASS:
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
		case BehaviorPackage.BEHAVIOR__BEHAVIOR:
			getBehavior().clear();
			getBehavior().addAll((Collection<? extends FunctionBehavior>)newValue);
			return;
		case BehaviorPackage.BEHAVIOR__FUNCTION_TRIGGER:
			getFunctionTrigger().clear();
			getFunctionTrigger().addAll((Collection<? extends FunctionTrigger>)newValue);
			return;
		case BehaviorPackage.BEHAVIOR__MODE_GROUP:
			getModeGroup().clear();
			getModeGroup().addAll((Collection<? extends ModeGroup>)newValue);
			return;
		case BehaviorPackage.BEHAVIOR__BASE_PACKAGE:
			setBase_Package((org.eclipse.uml2.uml.Package)newValue);
			return;
		case BehaviorPackage.BEHAVIOR__BASE_CLASS:
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
		return BehaviorPackage.Literals.BEHAVIOR;
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
		case BehaviorPackage.BEHAVIOR__BEHAVIOR:
			getBehavior().clear();
			return;
		case BehaviorPackage.BEHAVIOR__FUNCTION_TRIGGER:
			getFunctionTrigger().clear();
			return;
		case BehaviorPackage.BEHAVIOR__MODE_GROUP:
			getModeGroup().clear();
			return;
		case BehaviorPackage.BEHAVIOR__BASE_PACKAGE:
			setBase_Package((org.eclipse.uml2.uml.Package)null);
			return;
		case BehaviorPackage.BEHAVIOR__BASE_CLASS:
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
	public EList<FunctionBehavior> getBehavior() {
		if(behavior == null) {
			behavior = new EObjectResolvingEList<FunctionBehavior>(FunctionBehavior.class, this, BehaviorPackage.BEHAVIOR__BEHAVIOR);
		}
		return behavior;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<FunctionTrigger> getFunctionTrigger() {
		if(functionTrigger == null) {
			functionTrigger = new EObjectResolvingEList<FunctionTrigger>(FunctionTrigger.class, this, BehaviorPackage.BEHAVIOR__FUNCTION_TRIGGER);
		}
		return functionTrigger;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<ModeGroup> getModeGroup() {
		if(modeGroup == null) {
			modeGroup = new EObjectResolvingEList<ModeGroup>(ModeGroup.class, this, BehaviorPackage.BEHAVIOR__MODE_GROUP);
		}
		return modeGroup;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BehaviorPackage.BEHAVIOR__BASE_PACKAGE, oldBase_Package, base_Package));
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
			eNotify(new ENotificationImpl(this, Notification.SET, BehaviorPackage.BEHAVIOR__BASE_PACKAGE, oldBase_Package, base_Package));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BehaviorPackage.BEHAVIOR__BASE_CLASS, oldBase_Class, base_Class));
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
			eNotify(new ENotificationImpl(this, Notification.SET, BehaviorPackage.BEHAVIOR__BASE_CLASS, oldBase_Class, base_Class));
	}

} //BehaviorImpl
