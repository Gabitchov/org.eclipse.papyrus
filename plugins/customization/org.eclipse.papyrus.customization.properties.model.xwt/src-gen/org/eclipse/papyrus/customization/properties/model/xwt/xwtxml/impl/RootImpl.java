/**
 * *******************************************************************************
 * Copyright (c) 2009 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 
 *     Fabien Giquel (Mia-Software) - initial API and implementation
 * *******************************************************************************
 *
 */
package org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.DocumentTypeDeclaration;
import org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.Namespace;
import org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.ProcessingInstruction;
import org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.Root;
import org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.XwtxmlPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.impl.RootImpl#getNamespaces <em>Namespaces</em>}</li>
 *   <li>{@link org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.impl.RootImpl#getDtd <em>Dtd</em>}</li>
 *   <li>{@link org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.impl.RootImpl#getLeadingPIs <em>Leading PIs</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RootImpl extends ElementImpl implements Root {
	/**
	 * The cached value of the '{@link #getNamespaces() <em>Namespaces</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNamespaces()
	 * @generated
	 * @ordered
	 */
	protected EList<Namespace> namespaces;

	/**
	 * The cached value of the '{@link #getDtd() <em>Dtd</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDtd()
	 * @generated
	 * @ordered
	 */
	protected DocumentTypeDeclaration dtd;

	/**
	 * The cached value of the '{@link #getLeadingPIs() <em>Leading PIs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLeadingPIs()
	 * @generated
	 * @ordered
	 */
	protected EList<ProcessingInstruction> leadingPIs;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RootImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XwtxmlPackage.Literals.ROOT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Namespace> getNamespaces() {
		if (namespaces == null) {
			namespaces = new EObjectContainmentEList<Namespace>(Namespace.class, this, XwtxmlPackage.ROOT__NAMESPACES);
		}
		return namespaces;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DocumentTypeDeclaration getDtd() {
		return dtd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDtd(DocumentTypeDeclaration newDtd, NotificationChain msgs) {
		DocumentTypeDeclaration oldDtd = dtd;
		dtd = newDtd;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XwtxmlPackage.ROOT__DTD, oldDtd, newDtd);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDtd(DocumentTypeDeclaration newDtd) {
		if (newDtd != dtd) {
			NotificationChain msgs = null;
			if (dtd != null)
				msgs = ((InternalEObject)dtd).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XwtxmlPackage.ROOT__DTD, null, msgs);
			if (newDtd != null)
				msgs = ((InternalEObject)newDtd).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XwtxmlPackage.ROOT__DTD, null, msgs);
			msgs = basicSetDtd(newDtd, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XwtxmlPackage.ROOT__DTD, newDtd, newDtd));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ProcessingInstruction> getLeadingPIs() {
		if (leadingPIs == null) {
			leadingPIs = new EObjectContainmentEList<ProcessingInstruction>(ProcessingInstruction.class, this, XwtxmlPackage.ROOT__LEADING_PIS);
		}
		return leadingPIs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case XwtxmlPackage.ROOT__NAMESPACES:
				return ((InternalEList<?>)getNamespaces()).basicRemove(otherEnd, msgs);
			case XwtxmlPackage.ROOT__DTD:
				return basicSetDtd(null, msgs);
			case XwtxmlPackage.ROOT__LEADING_PIS:
				return ((InternalEList<?>)getLeadingPIs()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case XwtxmlPackage.ROOT__NAMESPACES:
				return getNamespaces();
			case XwtxmlPackage.ROOT__DTD:
				return getDtd();
			case XwtxmlPackage.ROOT__LEADING_PIS:
				return getLeadingPIs();
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
			case XwtxmlPackage.ROOT__NAMESPACES:
				getNamespaces().clear();
				getNamespaces().addAll((Collection<? extends Namespace>)newValue);
				return;
			case XwtxmlPackage.ROOT__DTD:
				setDtd((DocumentTypeDeclaration)newValue);
				return;
			case XwtxmlPackage.ROOT__LEADING_PIS:
				getLeadingPIs().clear();
				getLeadingPIs().addAll((Collection<? extends ProcessingInstruction>)newValue);
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
			case XwtxmlPackage.ROOT__NAMESPACES:
				getNamespaces().clear();
				return;
			case XwtxmlPackage.ROOT__DTD:
				setDtd((DocumentTypeDeclaration)null);
				return;
			case XwtxmlPackage.ROOT__LEADING_PIS:
				getLeadingPIs().clear();
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
			case XwtxmlPackage.ROOT__NAMESPACES:
				return namespaces != null && !namespaces.isEmpty();
			case XwtxmlPackage.ROOT__DTD:
				return dtd != null;
			case XwtxmlPackage.ROOT__LEADING_PIS:
				return leadingPIs != null && !leadingPIs.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //RootImpl
