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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.papyrus.eastadl.infrastructure.elements.impl.TraceableSpecificationImpl;
import org.eclipse.papyrus.eastadl.requirements.Extend;
import org.eclipse.papyrus.eastadl.requirements.ExtensionPoint;
import org.eclipse.papyrus.eastadl.requirements.Include;
import org.eclipse.papyrus.eastadl.requirements.RequirementsPackage;
import org.eclipse.papyrus.eastadl.requirements.UseCase;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Use Case</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.requirements.impl.UseCaseImpl#getBase_UseCase <em>Base Use Case</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.requirements.impl.UseCaseImpl#getInclude <em>Include</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.requirements.impl.UseCaseImpl#getExtend <em>Extend</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.requirements.impl.UseCaseImpl#getExtensionPoint <em>Extension Point</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class UseCaseImpl extends TraceableSpecificationImpl implements UseCase {

	/**
	 * The cached value of the '{@link #getBase_UseCase() <em>Base Use Case</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getBase_UseCase()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.uml2.uml.UseCase base_UseCase;

	/**
	 * The cached value of the '{@link #getInclude() <em>Include</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getInclude()
	 * @generated
	 * @ordered
	 */
	protected EList<Include> include;

	/**
	 * The cached value of the '{@link #getExtend() <em>Extend</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getExtend()
	 * @generated
	 * @ordered
	 */
	protected EList<Extend> extend;

	/**
	 * The cached value of the '{@link #getExtensionPoint() <em>Extension Point</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getExtensionPoint()
	 * @generated
	 * @ordered
	 */
	protected EList<ExtensionPoint> extensionPoint;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected UseCaseImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RequirementsPackage.Literals.USE_CASE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public org.eclipse.uml2.uml.UseCase getBase_UseCase() {
		if(base_UseCase != null && base_UseCase.eIsProxy()) {
			InternalEObject oldBase_UseCase = (InternalEObject)base_UseCase;
			base_UseCase = (org.eclipse.uml2.uml.UseCase)eResolveProxy(oldBase_UseCase);
			if(base_UseCase != oldBase_UseCase) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RequirementsPackage.USE_CASE__BASE_USE_CASE, oldBase_UseCase, base_UseCase));
			}
		}
		return base_UseCase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public org.eclipse.uml2.uml.UseCase basicGetBase_UseCase() {
		return base_UseCase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setBase_UseCase(org.eclipse.uml2.uml.UseCase newBase_UseCase) {
		org.eclipse.uml2.uml.UseCase oldBase_UseCase = base_UseCase;
		base_UseCase = newBase_UseCase;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequirementsPackage.USE_CASE__BASE_USE_CASE, oldBase_UseCase, base_UseCase));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<Include> getInclude() {
		if(include == null) {
			include = new EObjectContainmentEList<Include>(Include.class, this, RequirementsPackage.USE_CASE__INCLUDE);
		}
		return include;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<Extend> getExtend() {
		if(extend == null) {
			extend = new EObjectContainmentEList<Extend>(Extend.class, this, RequirementsPackage.USE_CASE__EXTEND);
		}
		return extend;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<ExtensionPoint> getExtensionPoint() {
		if(extensionPoint == null) {
			extensionPoint = new EObjectContainmentEList<ExtensionPoint>(ExtensionPoint.class, this, RequirementsPackage.USE_CASE__EXTENSION_POINT);
		}
		return extensionPoint;
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
		case RequirementsPackage.USE_CASE__INCLUDE:
			return ((InternalEList<?>)getInclude()).basicRemove(otherEnd, msgs);
		case RequirementsPackage.USE_CASE__EXTEND:
			return ((InternalEList<?>)getExtend()).basicRemove(otherEnd, msgs);
		case RequirementsPackage.USE_CASE__EXTENSION_POINT:
			return ((InternalEList<?>)getExtensionPoint()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
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
		case RequirementsPackage.USE_CASE__BASE_USE_CASE:
			if(resolve)
				return getBase_UseCase();
			return basicGetBase_UseCase();
		case RequirementsPackage.USE_CASE__INCLUDE:
			return getInclude();
		case RequirementsPackage.USE_CASE__EXTEND:
			return getExtend();
		case RequirementsPackage.USE_CASE__EXTENSION_POINT:
			return getExtensionPoint();
		}
		return super.eGet(featureID, resolve, coreType);
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
		case RequirementsPackage.USE_CASE__BASE_USE_CASE:
			setBase_UseCase((org.eclipse.uml2.uml.UseCase)newValue);
			return;
		case RequirementsPackage.USE_CASE__INCLUDE:
			getInclude().clear();
			getInclude().addAll((Collection<? extends Include>)newValue);
			return;
		case RequirementsPackage.USE_CASE__EXTEND:
			getExtend().clear();
			getExtend().addAll((Collection<? extends Extend>)newValue);
			return;
		case RequirementsPackage.USE_CASE__EXTENSION_POINT:
			getExtensionPoint().clear();
			getExtensionPoint().addAll((Collection<? extends ExtensionPoint>)newValue);
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
	public void eUnset(int featureID) {
		switch(featureID) {
		case RequirementsPackage.USE_CASE__BASE_USE_CASE:
			setBase_UseCase((org.eclipse.uml2.uml.UseCase)null);
			return;
		case RequirementsPackage.USE_CASE__INCLUDE:
			getInclude().clear();
			return;
		case RequirementsPackage.USE_CASE__EXTEND:
			getExtend().clear();
			return;
		case RequirementsPackage.USE_CASE__EXTENSION_POINT:
			getExtensionPoint().clear();
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
	@Override
	public boolean eIsSet(int featureID) {
		switch(featureID) {
		case RequirementsPackage.USE_CASE__BASE_USE_CASE:
			return base_UseCase != null;
		case RequirementsPackage.USE_CASE__INCLUDE:
			return include != null && !include.isEmpty();
		case RequirementsPackage.USE_CASE__EXTEND:
			return extend != null && !extend.isEmpty();
		case RequirementsPackage.USE_CASE__EXTENSION_POINT:
			return extensionPoint != null && !extensionPoint.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //UseCaseImpl
