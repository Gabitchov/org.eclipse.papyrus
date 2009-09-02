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

import org.eclipse.gmf.codegen.gmfgen.GenCommonBase;
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
 *   <li>{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.SpecificDiagramUpdaterImpl#getGenNode <em>Gen Node</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SpecificDiagramUpdaterImpl extends ExternalHookImpl implements SpecificDiagramUpdater {
	/**
	 * The cached value of the '{@link #getGenNode() <em>Gen Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGenNode()
	 * @generated
	 * @ordered
	 */
	protected GenCommonBase genNode;
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
	public GenCommonBase getGenNode() {
		if (genNode != null && genNode.eIsProxy()) {
			InternalEObject oldGenNode = (InternalEObject)genNode;
			genNode = (GenCommonBase)eResolveProxy(oldGenNode);
			if (genNode != oldGenNode) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PapyrusgmfgenextensionPackage.SPECIFIC_DIAGRAM_UPDATER__GEN_NODE, oldGenNode, genNode));
			}
		}
		return genNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenCommonBase basicGetGenNode() {
		return genNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGenNode(GenCommonBase newGenNode) {
		GenCommonBase oldGenNode = genNode;
		genNode = newGenNode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PapyrusgmfgenextensionPackage.SPECIFIC_DIAGRAM_UPDATER__GEN_NODE, oldGenNode, genNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PapyrusgmfgenextensionPackage.SPECIFIC_DIAGRAM_UPDATER__GEN_NODE:
				if (resolve) return getGenNode();
				return basicGetGenNode();
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
			case PapyrusgmfgenextensionPackage.SPECIFIC_DIAGRAM_UPDATER__GEN_NODE:
				setGenNode((GenCommonBase)newValue);
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
			case PapyrusgmfgenextensionPackage.SPECIFIC_DIAGRAM_UPDATER__GEN_NODE:
				setGenNode((GenCommonBase)null);
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
			case PapyrusgmfgenextensionPackage.SPECIFIC_DIAGRAM_UPDATER__GEN_NODE:
				return genNode != null;
		}
		return super.eIsSet(featureID);
	}

} //SpecificDiagramUpdaterImpl
