/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.infra.emf.newchild.ncpolicy;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.infra.emf.newchild.ncpolicy.NcpolicyPackage
 * @generated
 */
public interface NcpolicyFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	NcpolicyFactory eINSTANCE = org.eclipse.papyrus.infra.emf.newchild.ncpolicy.impl.NcpolicyFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>New EMF Child Menu</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>New EMF Child Menu</em>'.
	 * @generated
	 */
	NewEMFChildMenu createNewEMFChildMenu();

	/**
	 * Returns a new object of class '<em>New Child Policy Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>New Child Policy Set</em>'.
	 * @generated
	 */
	NewChildPolicySet createNewChildPolicySet();

	/**
	 * Returns a new object of class '<em>Filter Policy</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Filter Policy</em>'.
	 * @generated
	 */
	FilterPolicy createFilterPolicy();

	/**
	 * Returns a new object of class '<em>Replace Policy</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Replace Policy</em>'.
	 * @generated
	 */
	ReplacePolicy createReplacePolicy();

	/**
	 * Returns a new object of class '<em>Custom Policy</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Custom Policy</em>'.
	 * @generated
	 */
	CustomPolicy createCustomPolicy();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	NcpolicyPackage getNcpolicyPackage();

} //NcpolicyFactory
