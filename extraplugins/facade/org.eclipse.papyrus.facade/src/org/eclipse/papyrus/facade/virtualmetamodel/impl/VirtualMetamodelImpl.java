/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.facade.virtualmetamodel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.facade.Facade;
import org.eclipse.papyrus.facade.FacadePackage;

import org.eclipse.papyrus.facade.virtualmetamodel.VirtualClassifier;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualMetamodel;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualmetamodelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Virtual Metamodel</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.facade.virtualmetamodel.impl.VirtualMetamodelImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.facade.virtualmetamodel.impl.VirtualMetamodelImpl#getNsPrefix <em>Ns Prefix</em>}</li>
 *   <li>{@link org.eclipse.papyrus.facade.virtualmetamodel.impl.VirtualMetamodelImpl#getNsURI <em>Ns URI</em>}</li>
 *   <li>{@link org.eclipse.papyrus.facade.virtualmetamodel.impl.VirtualMetamodelImpl#getVirtualClassifiers <em>Virtual Classifiers</em>}</li>
 *   <li>{@link org.eclipse.papyrus.facade.virtualmetamodel.impl.VirtualMetamodelImpl#getFacade <em>Facade</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VirtualMetamodelImpl extends MinimalEObjectImpl.Container implements VirtualMetamodel {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getNsPrefix() <em>Ns Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNsPrefix()
	 * @generated
	 * @ordered
	 */
	protected static final String NS_PREFIX_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNsPrefix() <em>Ns Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNsPrefix()
	 * @generated
	 * @ordered
	 */
	protected String nsPrefix = NS_PREFIX_EDEFAULT;

	/**
	 * The default value of the '{@link #getNsURI() <em>Ns URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNsURI()
	 * @generated
	 * @ordered
	 */
	protected static final String NS_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNsURI() <em>Ns URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNsURI()
	 * @generated
	 * @ordered
	 */
	protected String nsURI = NS_URI_EDEFAULT;

	/**
	 * The cached value of the '{@link #getVirtualClassifiers() <em>Virtual Classifiers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVirtualClassifiers()
	 * @generated
	 * @ordered
	 */
	protected EList<VirtualClassifier> virtualClassifiers;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VirtualMetamodelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VirtualmetamodelPackage.Literals.VIRTUAL_METAMODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VirtualmetamodelPackage.VIRTUAL_METAMODEL__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNsPrefix() {
		return nsPrefix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNsPrefix(String newNsPrefix) {
		String oldNsPrefix = nsPrefix;
		nsPrefix = newNsPrefix;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VirtualmetamodelPackage.VIRTUAL_METAMODEL__NS_PREFIX, oldNsPrefix, nsPrefix));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNsURI() {
		return nsURI;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNsURI(String newNsURI) {
		String oldNsURI = nsURI;
		nsURI = newNsURI;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VirtualmetamodelPackage.VIRTUAL_METAMODEL__NS_URI, oldNsURI, nsURI));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VirtualClassifier> getVirtualClassifiers() {
		if (virtualClassifiers == null) {
			virtualClassifiers = new EObjectContainmentWithInverseEList<VirtualClassifier>(VirtualClassifier.class, this, VirtualmetamodelPackage.VIRTUAL_METAMODEL__VIRTUAL_CLASSIFIERS, VirtualmetamodelPackage.VIRTUAL_CLASSIFIER__METAMODEL);
		}
		return virtualClassifiers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Facade getFacade() {
		if (eContainerFeatureID() != VirtualmetamodelPackage.VIRTUAL_METAMODEL__FACADE) return null;
		return (Facade)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFacade(Facade newFacade, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newFacade, VirtualmetamodelPackage.VIRTUAL_METAMODEL__FACADE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFacade(Facade newFacade) {
		if (newFacade != eInternalContainer() || (eContainerFeatureID() != VirtualmetamodelPackage.VIRTUAL_METAMODEL__FACADE && newFacade != null)) {
			if (EcoreUtil.isAncestor(this, newFacade))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newFacade != null)
				msgs = ((InternalEObject)newFacade).eInverseAdd(this, FacadePackage.FACADE__VIRTUALMETAMODEL, Facade.class, msgs);
			msgs = basicSetFacade(newFacade, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VirtualmetamodelPackage.VIRTUAL_METAMODEL__FACADE, newFacade, newFacade));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case VirtualmetamodelPackage.VIRTUAL_METAMODEL__VIRTUAL_CLASSIFIERS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getVirtualClassifiers()).basicAdd(otherEnd, msgs);
			case VirtualmetamodelPackage.VIRTUAL_METAMODEL__FACADE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetFacade((Facade)otherEnd, msgs);
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
			case VirtualmetamodelPackage.VIRTUAL_METAMODEL__VIRTUAL_CLASSIFIERS:
				return ((InternalEList<?>)getVirtualClassifiers()).basicRemove(otherEnd, msgs);
			case VirtualmetamodelPackage.VIRTUAL_METAMODEL__FACADE:
				return basicSetFacade(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case VirtualmetamodelPackage.VIRTUAL_METAMODEL__FACADE:
				return eInternalContainer().eInverseRemove(this, FacadePackage.FACADE__VIRTUALMETAMODEL, Facade.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case VirtualmetamodelPackage.VIRTUAL_METAMODEL__NAME:
				return getName();
			case VirtualmetamodelPackage.VIRTUAL_METAMODEL__NS_PREFIX:
				return getNsPrefix();
			case VirtualmetamodelPackage.VIRTUAL_METAMODEL__NS_URI:
				return getNsURI();
			case VirtualmetamodelPackage.VIRTUAL_METAMODEL__VIRTUAL_CLASSIFIERS:
				return getVirtualClassifiers();
			case VirtualmetamodelPackage.VIRTUAL_METAMODEL__FACADE:
				return getFacade();
		}
		return super.eGet(featureID, resolve, coreType);
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
			case VirtualmetamodelPackage.VIRTUAL_METAMODEL__NAME:
				setName((String)newValue);
				return;
			case VirtualmetamodelPackage.VIRTUAL_METAMODEL__NS_PREFIX:
				setNsPrefix((String)newValue);
				return;
			case VirtualmetamodelPackage.VIRTUAL_METAMODEL__NS_URI:
				setNsURI((String)newValue);
				return;
			case VirtualmetamodelPackage.VIRTUAL_METAMODEL__VIRTUAL_CLASSIFIERS:
				getVirtualClassifiers().clear();
				getVirtualClassifiers().addAll((Collection<? extends VirtualClassifier>)newValue);
				return;
			case VirtualmetamodelPackage.VIRTUAL_METAMODEL__FACADE:
				setFacade((Facade)newValue);
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
			case VirtualmetamodelPackage.VIRTUAL_METAMODEL__NAME:
				setName(NAME_EDEFAULT);
				return;
			case VirtualmetamodelPackage.VIRTUAL_METAMODEL__NS_PREFIX:
				setNsPrefix(NS_PREFIX_EDEFAULT);
				return;
			case VirtualmetamodelPackage.VIRTUAL_METAMODEL__NS_URI:
				setNsURI(NS_URI_EDEFAULT);
				return;
			case VirtualmetamodelPackage.VIRTUAL_METAMODEL__VIRTUAL_CLASSIFIERS:
				getVirtualClassifiers().clear();
				return;
			case VirtualmetamodelPackage.VIRTUAL_METAMODEL__FACADE:
				setFacade((Facade)null);
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
			case VirtualmetamodelPackage.VIRTUAL_METAMODEL__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case VirtualmetamodelPackage.VIRTUAL_METAMODEL__NS_PREFIX:
				return NS_PREFIX_EDEFAULT == null ? nsPrefix != null : !NS_PREFIX_EDEFAULT.equals(nsPrefix);
			case VirtualmetamodelPackage.VIRTUAL_METAMODEL__NS_URI:
				return NS_URI_EDEFAULT == null ? nsURI != null : !NS_URI_EDEFAULT.equals(nsURI);
			case VirtualmetamodelPackage.VIRTUAL_METAMODEL__VIRTUAL_CLASSIFIERS:
				return virtualClassifiers != null && !virtualClassifiers.isEmpty();
			case VirtualmetamodelPackage.VIRTUAL_METAMODEL__FACADE:
				return getFacade() != null;
		}
		return super.eIsSet(featureID);
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
		result.append(" (name: ");
		result.append(name);
		result.append(", nsPrefix: ");
		result.append(nsPrefix);
		result.append(", nsURI: ");
		result.append(nsURI);
		result.append(')');
		return result.toString();
	}

} //VirtualMetamodelImpl
