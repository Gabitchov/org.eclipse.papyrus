/**
 */
package org.eclipse.papyrus.papyrusgmfgenextension.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.gmf.codegen.gmfgen.GenCommonBase;

import org.eclipse.papyrus.papyrusgmfgenextension.ConstrainedByReferenceCompartmentItemSemanticEditPolicy;
import org.eclipse.papyrus.papyrusgmfgenextension.PapyrusgmfgenextensionPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Constrained By Reference Compartment Item Semantic Edit Policy</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.ConstrainedByReferenceCompartmentItemSemanticEditPolicyImpl#getGenView <em>Gen View</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConstrainedByReferenceCompartmentItemSemanticEditPolicyImpl extends CommentedElementImpl implements ConstrainedByReferenceCompartmentItemSemanticEditPolicy {
	/**
	 * The cached value of the '{@link #getGenView() <em>Gen View</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGenView()
	 * @generated
	 * @ordered
	 */
	protected EList<GenCommonBase> genView;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConstrainedByReferenceCompartmentItemSemanticEditPolicyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PapyrusgmfgenextensionPackage.Literals.CONSTRAINED_BY_REFERENCE_COMPARTMENT_ITEM_SEMANTIC_EDIT_POLICY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<GenCommonBase> getGenView() {
		if (genView == null) {
			genView = new EObjectResolvingEList<GenCommonBase>(GenCommonBase.class, this, PapyrusgmfgenextensionPackage.CONSTRAINED_BY_REFERENCE_COMPARTMENT_ITEM_SEMANTIC_EDIT_POLICY__GEN_VIEW);
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
			case PapyrusgmfgenextensionPackage.CONSTRAINED_BY_REFERENCE_COMPARTMENT_ITEM_SEMANTIC_EDIT_POLICY__GEN_VIEW:
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
			case PapyrusgmfgenextensionPackage.CONSTRAINED_BY_REFERENCE_COMPARTMENT_ITEM_SEMANTIC_EDIT_POLICY__GEN_VIEW:
				getGenView().clear();
				getGenView().addAll((Collection<? extends GenCommonBase>)newValue);
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
			case PapyrusgmfgenextensionPackage.CONSTRAINED_BY_REFERENCE_COMPARTMENT_ITEM_SEMANTIC_EDIT_POLICY__GEN_VIEW:
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
			case PapyrusgmfgenextensionPackage.CONSTRAINED_BY_REFERENCE_COMPARTMENT_ITEM_SEMANTIC_EDIT_POLICY__GEN_VIEW:
				return genView != null && !genView.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ConstrainedByReferenceCompartmentItemSemanticEditPolicyImpl
