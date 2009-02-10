/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.papyrusgmfgenextension.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.gmf.codegen.gmfgen.GenChildSideAffixedNode;

import org.eclipse.papyrus.papyrusgmfgenextension.PapyrusgmfgenextensionPackage;
import org.eclipse.papyrus.papyrusgmfgenextension.SpecificLocator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Specific Locator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.SpecificLocatorImpl#getGenChildSideAffixedNode <em>Gen Child Side Affixed Node</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SpecificLocatorImpl extends ExternalHookImpl implements SpecificLocator {
	/**
	 * The cached value of the '{@link #getGenChildSideAffixedNode() <em>Gen Child Side Affixed Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGenChildSideAffixedNode()
	 * @generated
	 * @ordered
	 */
	protected GenChildSideAffixedNode genChildSideAffixedNode;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SpecificLocatorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PapyrusgmfgenextensionPackage.Literals.SPECIFIC_LOCATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenChildSideAffixedNode getGenChildSideAffixedNode() {
		if (genChildSideAffixedNode != null && genChildSideAffixedNode.eIsProxy()) {
			InternalEObject oldGenChildSideAffixedNode = (InternalEObject)genChildSideAffixedNode;
			genChildSideAffixedNode = (GenChildSideAffixedNode)eResolveProxy(oldGenChildSideAffixedNode);
			if (genChildSideAffixedNode != oldGenChildSideAffixedNode) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PapyrusgmfgenextensionPackage.SPECIFIC_LOCATOR__GEN_CHILD_SIDE_AFFIXED_NODE, oldGenChildSideAffixedNode, genChildSideAffixedNode));
			}
		}
		return genChildSideAffixedNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenChildSideAffixedNode basicGetGenChildSideAffixedNode() {
		return genChildSideAffixedNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGenChildSideAffixedNode(GenChildSideAffixedNode newGenChildSideAffixedNode) {
		GenChildSideAffixedNode oldGenChildSideAffixedNode = genChildSideAffixedNode;
		genChildSideAffixedNode = newGenChildSideAffixedNode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PapyrusgmfgenextensionPackage.SPECIFIC_LOCATOR__GEN_CHILD_SIDE_AFFIXED_NODE, oldGenChildSideAffixedNode, genChildSideAffixedNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PapyrusgmfgenextensionPackage.SPECIFIC_LOCATOR__GEN_CHILD_SIDE_AFFIXED_NODE:
				if (resolve) return getGenChildSideAffixedNode();
				return basicGetGenChildSideAffixedNode();
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
			case PapyrusgmfgenextensionPackage.SPECIFIC_LOCATOR__GEN_CHILD_SIDE_AFFIXED_NODE:
				setGenChildSideAffixedNode((GenChildSideAffixedNode)newValue);
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
			case PapyrusgmfgenextensionPackage.SPECIFIC_LOCATOR__GEN_CHILD_SIDE_AFFIXED_NODE:
				setGenChildSideAffixedNode((GenChildSideAffixedNode)null);
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
			case PapyrusgmfgenextensionPackage.SPECIFIC_LOCATOR__GEN_CHILD_SIDE_AFFIXED_NODE:
				return genChildSideAffixedNode != null;
		}
		return super.eIsSet(featureID);
	}

} //SpecificLocatorImpl
