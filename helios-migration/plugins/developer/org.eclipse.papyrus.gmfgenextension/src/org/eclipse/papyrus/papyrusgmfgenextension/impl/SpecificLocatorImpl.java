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
 * <li>{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.SpecificLocatorImpl#getGenChildSideAffixedNode <em>Gen Child Side Affixed Node</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class SpecificLocatorImpl extends ExternalHookImpl implements SpecificLocator {

	/**
	 * The cached value of the '{@link #getGenChildSideAffixedNode() <em>Gen Child Side Affixed Node</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getGenChildSideAffixedNode()
	 * @generated
	 * @ordered
	 */
	protected EList<GenChildSideAffixedNode> genChildSideAffixedNode;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected SpecificLocatorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PapyrusgmfgenextensionPackage.Literals.SPECIFIC_LOCATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<GenChildSideAffixedNode> getGenChildSideAffixedNode() {
		if(genChildSideAffixedNode == null) {
			genChildSideAffixedNode = new EObjectResolvingEList<GenChildSideAffixedNode>(GenChildSideAffixedNode.class, this, PapyrusgmfgenextensionPackage.SPECIFIC_LOCATOR__GEN_CHILD_SIDE_AFFIXED_NODE);
		}
		return genChildSideAffixedNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch(featureID) {
		case PapyrusgmfgenextensionPackage.SPECIFIC_LOCATOR__GEN_CHILD_SIDE_AFFIXED_NODE:
			return getGenChildSideAffixedNode();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch(featureID) {
		case PapyrusgmfgenextensionPackage.SPECIFIC_LOCATOR__GEN_CHILD_SIDE_AFFIXED_NODE:
			getGenChildSideAffixedNode().clear();
			getGenChildSideAffixedNode().addAll((Collection<? extends GenChildSideAffixedNode>)newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch(featureID) {
		case PapyrusgmfgenextensionPackage.SPECIFIC_LOCATOR__GEN_CHILD_SIDE_AFFIXED_NODE:
			getGenChildSideAffixedNode().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch(featureID) {
		case PapyrusgmfgenextensionPackage.SPECIFIC_LOCATOR__GEN_CHILD_SIDE_AFFIXED_NODE:
			return genChildSideAffixedNode != null && !genChildSideAffixedNode.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SpecificLocatorImpl
