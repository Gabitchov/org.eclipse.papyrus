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
import org.eclipse.papyrus.eastadl.behavior.BehaviorPackage;
import org.eclipse.papyrus.eastadl.behavior.FunctionBehavior;
import org.eclipse.papyrus.eastadl.behavior.FunctionBehaviorKind;
import org.eclipse.papyrus.eastadl.behavior.Mode;
import org.eclipse.papyrus.eastadl.infrastructure.elements.impl.ContextImpl;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionType;
import org.eclipse.uml2.uml.Behavior;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Function Behavior</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.behavior.impl.FunctionBehaviorImpl#getBase_Behavior <em>Base Behavior</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.behavior.impl.FunctionBehaviorImpl#getPath <em>Path</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.behavior.impl.FunctionBehaviorImpl#getRepresentation <em>Representation</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.behavior.impl.FunctionBehaviorImpl#getMode <em>Mode</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.behavior.impl.FunctionBehaviorImpl#getFunction <em>Function</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class FunctionBehaviorImpl extends ContextImpl implements FunctionBehavior {

	/**
	 * The cached value of the '{@link #getBase_Behavior() <em>Base Behavior</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getBase_Behavior()
	 * @generated
	 * @ordered
	 */
	protected Behavior base_Behavior;

	/**
	 * The default value of the '{@link #getPath() <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getPath()
	 * @generated
	 * @ordered
	 */
	protected static final String PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPath() <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getPath()
	 * @generated
	 * @ordered
	 */
	protected String path = PATH_EDEFAULT;

	/**
	 * The default value of the '{@link #getRepresentation() <em>Representation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getRepresentation()
	 * @generated
	 * @ordered
	 */
	protected static final FunctionBehaviorKind REPRESENTATION_EDEFAULT = FunctionBehaviorKind.ASCET;

	/**
	 * The cached value of the '{@link #getRepresentation() <em>Representation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getRepresentation()
	 * @generated
	 * @ordered
	 */
	protected FunctionBehaviorKind representation = REPRESENTATION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMode() <em>Mode</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getMode()
	 * @generated
	 * @ordered
	 */
	protected EList<Mode> mode;

	/**
	 * The cached value of the '{@link #getFunction() <em>Function</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getFunction()
	 * @generated
	 * @ordered
	 */
	protected FunctionType function;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected FunctionBehaviorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public FunctionType basicGetFunction() {
		return function;
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
		case BehaviorPackage.FUNCTION_BEHAVIOR__BASE_BEHAVIOR:
			if(resolve)
				return getBase_Behavior();
			return basicGetBase_Behavior();
		case BehaviorPackage.FUNCTION_BEHAVIOR__PATH:
			return getPath();
		case BehaviorPackage.FUNCTION_BEHAVIOR__REPRESENTATION:
			return getRepresentation();
		case BehaviorPackage.FUNCTION_BEHAVIOR__MODE:
			return getMode();
		case BehaviorPackage.FUNCTION_BEHAVIOR__FUNCTION:
			if(resolve)
				return getFunction();
			return basicGetFunction();
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
		case BehaviorPackage.FUNCTION_BEHAVIOR__BASE_BEHAVIOR:
			return base_Behavior != null;
		case BehaviorPackage.FUNCTION_BEHAVIOR__PATH:
			return PATH_EDEFAULT == null ? path != null : !PATH_EDEFAULT.equals(path);
		case BehaviorPackage.FUNCTION_BEHAVIOR__REPRESENTATION:
			return representation != REPRESENTATION_EDEFAULT;
		case BehaviorPackage.FUNCTION_BEHAVIOR__MODE:
			return mode != null && !mode.isEmpty();
		case BehaviorPackage.FUNCTION_BEHAVIOR__FUNCTION:
			return function != null;
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
		case BehaviorPackage.FUNCTION_BEHAVIOR__BASE_BEHAVIOR:
			setBase_Behavior((Behavior)newValue);
			return;
		case BehaviorPackage.FUNCTION_BEHAVIOR__PATH:
			setPath((String)newValue);
			return;
		case BehaviorPackage.FUNCTION_BEHAVIOR__REPRESENTATION:
			setRepresentation((FunctionBehaviorKind)newValue);
			return;
		case BehaviorPackage.FUNCTION_BEHAVIOR__MODE:
			getMode().clear();
			getMode().addAll((Collection<? extends Mode>)newValue);
			return;
		case BehaviorPackage.FUNCTION_BEHAVIOR__FUNCTION:
			setFunction((FunctionType)newValue);
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
		return BehaviorPackage.Literals.FUNCTION_BEHAVIOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Behavior getBase_Behavior() {
		if(base_Behavior != null && base_Behavior.eIsProxy()) {
			InternalEObject oldBase_Behavior = (InternalEObject)base_Behavior;
			base_Behavior = (Behavior)eResolveProxy(oldBase_Behavior);
			if(base_Behavior != oldBase_Behavior) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BehaviorPackage.FUNCTION_BEHAVIOR__BASE_BEHAVIOR, oldBase_Behavior, base_Behavior));
			}
		}
		return base_Behavior;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Behavior basicGetBase_Behavior() {
		return base_Behavior;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setBase_Behavior(Behavior newBase_Behavior) {
		Behavior oldBase_Behavior = base_Behavior;
		base_Behavior = newBase_Behavior;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BehaviorPackage.FUNCTION_BEHAVIOR__BASE_BEHAVIOR, oldBase_Behavior, base_Behavior));
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
		case BehaviorPackage.FUNCTION_BEHAVIOR__BASE_BEHAVIOR:
			setBase_Behavior((Behavior)null);
			return;
		case BehaviorPackage.FUNCTION_BEHAVIOR__PATH:
			setPath(PATH_EDEFAULT);
			return;
		case BehaviorPackage.FUNCTION_BEHAVIOR__REPRESENTATION:
			setRepresentation(REPRESENTATION_EDEFAULT);
			return;
		case BehaviorPackage.FUNCTION_BEHAVIOR__MODE:
			getMode().clear();
			return;
		case BehaviorPackage.FUNCTION_BEHAVIOR__FUNCTION:
			setFunction((FunctionType)null);
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
	public FunctionType getFunction() {
		if(function != null && function.eIsProxy()) {
			InternalEObject oldFunction = (InternalEObject)function;
			function = (FunctionType)eResolveProxy(oldFunction);
			if(function != oldFunction) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BehaviorPackage.FUNCTION_BEHAVIOR__FUNCTION, oldFunction, function));
			}
		}
		return function;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<Mode> getMode() {
		if(mode == null) {
			mode = new EObjectResolvingEList<Mode>(Mode.class, this, BehaviorPackage.FUNCTION_BEHAVIOR__MODE);
		}
		return mode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getPath() {
		return path;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public FunctionBehaviorKind getRepresentation() {
		return representation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setFunction(FunctionType newFunction) {
		FunctionType oldFunction = function;
		function = newFunction;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BehaviorPackage.FUNCTION_BEHAVIOR__FUNCTION, oldFunction, function));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setPath(String newPath) {
		String oldPath = path;
		path = newPath;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BehaviorPackage.FUNCTION_BEHAVIOR__PATH, oldPath, path));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setRepresentation(FunctionBehaviorKind newRepresentation) {
		FunctionBehaviorKind oldRepresentation = representation;
		representation = newRepresentation == null ? REPRESENTATION_EDEFAULT : newRepresentation;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BehaviorPackage.FUNCTION_BEHAVIOR__REPRESENTATION, oldRepresentation, representation));
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
		result.append(" (path: ");
		result.append(path);
		result.append(", representation: ");
		result.append(representation);
		result.append(')');
		return result.toString();
	}

} //FunctionBehaviorImpl
