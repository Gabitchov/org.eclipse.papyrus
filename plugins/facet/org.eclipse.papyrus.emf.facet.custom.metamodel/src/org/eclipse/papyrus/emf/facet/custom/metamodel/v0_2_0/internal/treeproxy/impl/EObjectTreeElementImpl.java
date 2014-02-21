/**
 * Copyright (c) 2012 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Nicolas Bros (Mia-Software) - Bug 379683 - customizable Tree content provider
 *    Gregoire Dupe (Mia-Software) - Bug 386387 - [CustomizedTreeContentProvider] The TreeElements are not preserved between two calls to getElements()
 */
package org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.internal.treeproxy.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.internal.treeproxy.EObjectTreeElement;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.internal.treeproxy.EStructuralFeatureTreeElement;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.internal.treeproxy.TreeproxyPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EObject Tree Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.internal.treeproxy.impl.EObjectTreeElementImpl#getEObject <em>EObject</em>}</li>
 *   <li>{@link org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.internal.treeproxy.impl.EObjectTreeElementImpl#getSfTreeElmement <em>Sf Tree Elmement</em>}</li>
 *   <li>{@link org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.internal.treeproxy.impl.EObjectTreeElementImpl#getParent <em>Parent</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EObjectTreeElementImpl extends TreeElementImpl implements EObjectTreeElement {
	/**
	 * The cached value of the '{@link #getEObject() <em>EObject</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEObject()
	 * @generated
	 * @ordered
	 */
	protected EObject eObject;

	/**
	 * The cached value of the '{@link #getSfTreeElmement() <em>Sf Tree Elmement</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSfTreeElmement()
	 * @generated
	 * @ordered
	 */
	protected EList<EStructuralFeatureTreeElement> sfTreeElmement;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EObjectTreeElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TreeproxyPackage.Literals.EOBJECT_TREE_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getEObject() {
		if (eObject != null && eObject.eIsProxy()) {
			InternalEObject oldEObject = (InternalEObject)eObject;
			eObject = eResolveProxy(oldEObject);
			if (eObject != oldEObject) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TreeproxyPackage.EOBJECT_TREE_ELEMENT__EOBJECT, oldEObject, eObject));
			}
		}
		return eObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetEObject() {
		return eObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEObject(EObject newEObject) {
		EObject oldEObject = eObject;
		eObject = newEObject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TreeproxyPackage.EOBJECT_TREE_ELEMENT__EOBJECT, oldEObject, eObject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EStructuralFeatureTreeElement> getSfTreeElmement() {
		if (sfTreeElmement == null) {
			sfTreeElmement = new EObjectContainmentWithInverseEList<EStructuralFeatureTreeElement>(EStructuralFeatureTreeElement.class, this, TreeproxyPackage.EOBJECT_TREE_ELEMENT__SF_TREE_ELMEMENT, TreeproxyPackage.ESTRUCTURAL_FEATURE_TREE_ELEMENT__PARENT);
		}
		return sfTreeElmement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EStructuralFeatureTreeElement getParent() {
		if (eContainerFeatureID() != TreeproxyPackage.EOBJECT_TREE_ELEMENT__PARENT) return null;
		return (EStructuralFeatureTreeElement)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParent(EStructuralFeatureTreeElement newParent, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParent, TreeproxyPackage.EOBJECT_TREE_ELEMENT__PARENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParent(EStructuralFeatureTreeElement newParent) {
		if (newParent != eInternalContainer() || (eContainerFeatureID() != TreeproxyPackage.EOBJECT_TREE_ELEMENT__PARENT && newParent != null)) {
			if (EcoreUtil.isAncestor(this, newParent))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParent != null)
				msgs = ((InternalEObject)newParent).eInverseAdd(this, TreeproxyPackage.ESTRUCTURAL_FEATURE_TREE_ELEMENT__REFERED_EOBJECT_TE, EStructuralFeatureTreeElement.class, msgs);
			msgs = basicSetParent(newParent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TreeproxyPackage.EOBJECT_TREE_ELEMENT__PARENT, newParent, newParent));
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
			case TreeproxyPackage.EOBJECT_TREE_ELEMENT__SF_TREE_ELMEMENT:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSfTreeElmement()).basicAdd(otherEnd, msgs);
			case TreeproxyPackage.EOBJECT_TREE_ELEMENT__PARENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParent((EStructuralFeatureTreeElement)otherEnd, msgs);
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
			case TreeproxyPackage.EOBJECT_TREE_ELEMENT__SF_TREE_ELMEMENT:
				return ((InternalEList<?>)getSfTreeElmement()).basicRemove(otherEnd, msgs);
			case TreeproxyPackage.EOBJECT_TREE_ELEMENT__PARENT:
				return basicSetParent(null, msgs);
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
			case TreeproxyPackage.EOBJECT_TREE_ELEMENT__PARENT:
				return eInternalContainer().eInverseRemove(this, TreeproxyPackage.ESTRUCTURAL_FEATURE_TREE_ELEMENT__REFERED_EOBJECT_TE, EStructuralFeatureTreeElement.class, msgs);
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
			case TreeproxyPackage.EOBJECT_TREE_ELEMENT__EOBJECT:
				if (resolve) return getEObject();
				return basicGetEObject();
			case TreeproxyPackage.EOBJECT_TREE_ELEMENT__SF_TREE_ELMEMENT:
				return getSfTreeElmement();
			case TreeproxyPackage.EOBJECT_TREE_ELEMENT__PARENT:
				return getParent();
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
			case TreeproxyPackage.EOBJECT_TREE_ELEMENT__EOBJECT:
				setEObject((EObject)newValue);
				return;
			case TreeproxyPackage.EOBJECT_TREE_ELEMENT__SF_TREE_ELMEMENT:
				getSfTreeElmement().clear();
				getSfTreeElmement().addAll((Collection<? extends EStructuralFeatureTreeElement>)newValue);
				return;
			case TreeproxyPackage.EOBJECT_TREE_ELEMENT__PARENT:
				setParent((EStructuralFeatureTreeElement)newValue);
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
			case TreeproxyPackage.EOBJECT_TREE_ELEMENT__EOBJECT:
				setEObject((EObject)null);
				return;
			case TreeproxyPackage.EOBJECT_TREE_ELEMENT__SF_TREE_ELMEMENT:
				getSfTreeElmement().clear();
				return;
			case TreeproxyPackage.EOBJECT_TREE_ELEMENT__PARENT:
				setParent((EStructuralFeatureTreeElement)null);
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
			case TreeproxyPackage.EOBJECT_TREE_ELEMENT__EOBJECT:
				return eObject != null;
			case TreeproxyPackage.EOBJECT_TREE_ELEMENT__SF_TREE_ELMEMENT:
				return sfTreeElmement != null && !sfTreeElmement.isEmpty();
			case TreeproxyPackage.EOBJECT_TREE_ELEMENT__PARENT:
				return getParent() != null;
		}
		return super.eIsSet(featureID);
	}

} //EObjectTreeElementImpl
