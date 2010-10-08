/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.papyrusgmfgenextension.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.gmf.codegen.gmfgen.GenLink;

import org.eclipse.papyrus.papyrusgmfgenextension.EditPartUsingReorientService;
import org.eclipse.papyrus.papyrusgmfgenextension.PapyrusgmfgenextensionPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Edit Part Using Reorient Service</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.EditPartUsingReorientServiceImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.EditPartUsingReorientServiceImpl#getGenView <em>Gen View</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EditPartUsingReorientServiceImpl extends CommentedElementImpl implements EditPartUsingReorientService {
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
	 * The cached value of the '{@link #getGenView() <em>Gen View</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGenView()
	 * @generated
	 * @ordered
	 */
	protected EList<GenLink> genView;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EditPartUsingReorientServiceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PapyrusgmfgenextensionPackage.Literals.EDIT_PART_USING_REORIENT_SERVICE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, PapyrusgmfgenextensionPackage.EDIT_PART_USING_REORIENT_SERVICE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<GenLink> getGenView() {
		if (genView == null) {
			genView = new EObjectResolvingEList<GenLink>(GenLink.class, this, PapyrusgmfgenextensionPackage.EDIT_PART_USING_REORIENT_SERVICE__GEN_VIEW);
		}
		return genView;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PapyrusgmfgenextensionPackage.EDIT_PART_USING_REORIENT_SERVICE__NAME:
				return getName();
			case PapyrusgmfgenextensionPackage.EDIT_PART_USING_REORIENT_SERVICE__GEN_VIEW:
				return getGenView();
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
			case PapyrusgmfgenextensionPackage.EDIT_PART_USING_REORIENT_SERVICE__NAME:
				setName((String)newValue);
				return;
			case PapyrusgmfgenextensionPackage.EDIT_PART_USING_REORIENT_SERVICE__GEN_VIEW:
				getGenView().clear();
				getGenView().addAll((Collection<? extends GenLink>)newValue);
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
			case PapyrusgmfgenextensionPackage.EDIT_PART_USING_REORIENT_SERVICE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PapyrusgmfgenextensionPackage.EDIT_PART_USING_REORIENT_SERVICE__GEN_VIEW:
				getGenView().clear();
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
			case PapyrusgmfgenextensionPackage.EDIT_PART_USING_REORIENT_SERVICE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PapyrusgmfgenextensionPackage.EDIT_PART_USING_REORIENT_SERVICE__GEN_VIEW:
				return genView != null && !genView.isEmpty();
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
		result.append(')');
		return result.toString();
	}

} //EditPartUsingReorientServiceImpl
