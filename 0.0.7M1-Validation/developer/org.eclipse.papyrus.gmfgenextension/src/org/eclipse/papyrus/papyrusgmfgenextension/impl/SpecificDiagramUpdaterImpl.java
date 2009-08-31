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

import org.eclipse.gmf.codegen.gmfgen.GenChildNode;

import org.eclipse.papyrus.papyrusgmfgenextension.PapyrusgmfgenextensionPackage;
import org.eclipse.papyrus.papyrusgmfgenextension.SpecificDiagramUpdater;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Specific Diagram Updater</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.SpecificDiagramUpdaterImpl#getGenChildNode <em>Gen Child Node</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SpecificDiagramUpdaterImpl extends ExternalHookImpl implements SpecificDiagramUpdater {
	/**
	 * The cached value of the '{@link #getGenChildNode() <em>Gen Child Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGenChildNode()
	 * @generated
	 * @ordered
	 */
	protected GenChildNode genChildNode;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SpecificDiagramUpdaterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PapyrusgmfgenextensionPackage.Literals.SPECIFIC_DIAGRAM_UPDATER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenChildNode getGenChildNode() {
		if (genChildNode != null && genChildNode.eIsProxy()) {
			InternalEObject oldGenChildNode = (InternalEObject)genChildNode;
			genChildNode = (GenChildNode)eResolveProxy(oldGenChildNode);
			if (genChildNode != oldGenChildNode) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PapyrusgmfgenextensionPackage.SPECIFIC_DIAGRAM_UPDATER__GEN_CHILD_NODE, oldGenChildNode, genChildNode));
			}
		}
		return genChildNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenChildNode basicGetGenChildNode() {
		return genChildNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGenChildNode(GenChildNode newGenChildNode) {
		GenChildNode oldGenChildNode = genChildNode;
		genChildNode = newGenChildNode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PapyrusgmfgenextensionPackage.SPECIFIC_DIAGRAM_UPDATER__GEN_CHILD_NODE, oldGenChildNode, genChildNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PapyrusgmfgenextensionPackage.SPECIFIC_DIAGRAM_UPDATER__GEN_CHILD_NODE:
				if (resolve) return getGenChildNode();
				return basicGetGenChildNode();
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
			case PapyrusgmfgenextensionPackage.SPECIFIC_DIAGRAM_UPDATER__GEN_CHILD_NODE:
				setGenChildNode((GenChildNode)newValue);
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
			case PapyrusgmfgenextensionPackage.SPECIFIC_DIAGRAM_UPDATER__GEN_CHILD_NODE:
				setGenChildNode((GenChildNode)null);
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
			case PapyrusgmfgenextensionPackage.SPECIFIC_DIAGRAM_UPDATER__GEN_CHILD_NODE:
				return genChildNode != null;
		}
		return super.eIsSet(featureID);
	}

} //SpecificDiagramUpdaterImpl
