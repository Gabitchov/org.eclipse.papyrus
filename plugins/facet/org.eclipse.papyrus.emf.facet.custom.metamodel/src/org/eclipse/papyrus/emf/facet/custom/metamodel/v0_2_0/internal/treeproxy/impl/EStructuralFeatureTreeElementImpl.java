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
 * An implementation of the model object '<em><b>EStructural Feature Tree Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.internal.treeproxy.impl.EStructuralFeatureTreeElementImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.internal.treeproxy.impl.EStructuralFeatureTreeElementImpl#getReferedEObjectTE <em>Refered EObject TE</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EStructuralFeatureTreeElementImpl extends TreeElementImpl implements EStructuralFeatureTreeElement {
	/**
	 * The cached value of the '{@link #getReferedEObjectTE() <em>Refered EObject TE</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferedEObjectTE()
	 * @generated
	 * @ordered
	 */
	protected EList<EObjectTreeElement> referedEObjectTE;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EStructuralFeatureTreeElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TreeproxyPackage.Literals.ESTRUCTURAL_FEATURE_TREE_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObjectTreeElement getParent() {
		if (eContainerFeatureID() != TreeproxyPackage.ESTRUCTURAL_FEATURE_TREE_ELEMENT__PARENT) return null;
		return (EObjectTreeElement)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParent(EObjectTreeElement newParent, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParent, TreeproxyPackage.ESTRUCTURAL_FEATURE_TREE_ELEMENT__PARENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParent(EObjectTreeElement newParent) {
		if (newParent != eInternalContainer() || (eContainerFeatureID() != TreeproxyPackage.ESTRUCTURAL_FEATURE_TREE_ELEMENT__PARENT && newParent != null)) {
			if (EcoreUtil.isAncestor(this, newParent))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParent != null)
				msgs = ((InternalEObject)newParent).eInverseAdd(this, TreeproxyPackage.EOBJECT_TREE_ELEMENT__SF_TREE_ELMEMENT, EObjectTreeElement.class, msgs);
			msgs = basicSetParent(newParent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TreeproxyPackage.ESTRUCTURAL_FEATURE_TREE_ELEMENT__PARENT, newParent, newParent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EObjectTreeElement> getReferedEObjectTE() {
		if (referedEObjectTE == null) {
			referedEObjectTE = new EObjectContainmentWithInverseEList<EObjectTreeElement>(EObjectTreeElement.class, this, TreeproxyPackage.ESTRUCTURAL_FEATURE_TREE_ELEMENT__REFERED_EOBJECT_TE, TreeproxyPackage.EOBJECT_TREE_ELEMENT__PARENT);
		}
		return referedEObjectTE;
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
			case TreeproxyPackage.ESTRUCTURAL_FEATURE_TREE_ELEMENT__PARENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParent((EObjectTreeElement)otherEnd, msgs);
			case TreeproxyPackage.ESTRUCTURAL_FEATURE_TREE_ELEMENT__REFERED_EOBJECT_TE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getReferedEObjectTE()).basicAdd(otherEnd, msgs);
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
			case TreeproxyPackage.ESTRUCTURAL_FEATURE_TREE_ELEMENT__PARENT:
				return basicSetParent(null, msgs);
			case TreeproxyPackage.ESTRUCTURAL_FEATURE_TREE_ELEMENT__REFERED_EOBJECT_TE:
				return ((InternalEList<?>)getReferedEObjectTE()).basicRemove(otherEnd, msgs);
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
			case TreeproxyPackage.ESTRUCTURAL_FEATURE_TREE_ELEMENT__PARENT:
				return eInternalContainer().eInverseRemove(this, TreeproxyPackage.EOBJECT_TREE_ELEMENT__SF_TREE_ELMEMENT, EObjectTreeElement.class, msgs);
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
			case TreeproxyPackage.ESTRUCTURAL_FEATURE_TREE_ELEMENT__PARENT:
				return getParent();
			case TreeproxyPackage.ESTRUCTURAL_FEATURE_TREE_ELEMENT__REFERED_EOBJECT_TE:
				return getReferedEObjectTE();
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
			case TreeproxyPackage.ESTRUCTURAL_FEATURE_TREE_ELEMENT__PARENT:
				setParent((EObjectTreeElement)newValue);
				return;
			case TreeproxyPackage.ESTRUCTURAL_FEATURE_TREE_ELEMENT__REFERED_EOBJECT_TE:
				getReferedEObjectTE().clear();
				getReferedEObjectTE().addAll((Collection<? extends EObjectTreeElement>)newValue);
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
			case TreeproxyPackage.ESTRUCTURAL_FEATURE_TREE_ELEMENT__PARENT:
				setParent((EObjectTreeElement)null);
				return;
			case TreeproxyPackage.ESTRUCTURAL_FEATURE_TREE_ELEMENT__REFERED_EOBJECT_TE:
				getReferedEObjectTE().clear();
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
			case TreeproxyPackage.ESTRUCTURAL_FEATURE_TREE_ELEMENT__PARENT:
				return getParent() != null;
			case TreeproxyPackage.ESTRUCTURAL_FEATURE_TREE_ELEMENT__REFERED_EOBJECT_TE:
				return referedEObjectTE != null && !referedEObjectTE.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //EStructuralFeatureTreeElementImpl
