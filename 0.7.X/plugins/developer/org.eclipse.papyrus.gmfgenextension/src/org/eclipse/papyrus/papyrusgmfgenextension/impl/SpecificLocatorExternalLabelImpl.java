/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.papyrusgmfgenextension.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.gmf.codegen.gmfgen.GenExternalNodeLabel;
import org.eclipse.papyrus.papyrusgmfgenextension.PapyrusgmfgenextensionPackage;
import org.eclipse.papyrus.papyrusgmfgenextension.SpecificLocatorExternalLabel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Specific Locator External Label</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.SpecificLocatorExternalLabelImpl#getGenExternalNodeLabel <em>Gen External Node Label</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SpecificLocatorExternalLabelImpl extends ExternalHookImpl implements SpecificLocatorExternalLabel {

	/**
	 * The cached value of the '{@link #getGenExternalNodeLabel() <em>Gen External Node Label</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGenExternalNodeLabel()
	 * @generated
	 * @ordered
	 */
	protected EList<GenExternalNodeLabel> genExternalNodeLabel;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SpecificLocatorExternalLabelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PapyrusgmfgenextensionPackage.Literals.SPECIFIC_LOCATOR_EXTERNAL_LABEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<GenExternalNodeLabel> getGenExternalNodeLabel() {
		if (genExternalNodeLabel == null) {
			genExternalNodeLabel = new EObjectResolvingEList<GenExternalNodeLabel>(GenExternalNodeLabel.class, this, PapyrusgmfgenextensionPackage.SPECIFIC_LOCATOR_EXTERNAL_LABEL__GEN_EXTERNAL_NODE_LABEL);
		}
		return genExternalNodeLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PapyrusgmfgenextensionPackage.SPECIFIC_LOCATOR_EXTERNAL_LABEL__GEN_EXTERNAL_NODE_LABEL:
				return getGenExternalNodeLabel();
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
			case PapyrusgmfgenextensionPackage.SPECIFIC_LOCATOR_EXTERNAL_LABEL__GEN_EXTERNAL_NODE_LABEL:
				getGenExternalNodeLabel().clear();
				getGenExternalNodeLabel().addAll((Collection<? extends GenExternalNodeLabel>)newValue);
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
			case PapyrusgmfgenextensionPackage.SPECIFIC_LOCATOR_EXTERNAL_LABEL__GEN_EXTERNAL_NODE_LABEL:
				getGenExternalNodeLabel().clear();
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
			case PapyrusgmfgenextensionPackage.SPECIFIC_LOCATOR_EXTERNAL_LABEL__GEN_EXTERNAL_NODE_LABEL:
				return genExternalNodeLabel != null && !genExternalNodeLabel.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SpecificLocatorExternalLabelImpl
