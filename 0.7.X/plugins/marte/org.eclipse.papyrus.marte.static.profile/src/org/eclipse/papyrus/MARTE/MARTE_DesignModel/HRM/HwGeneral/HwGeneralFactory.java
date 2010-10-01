/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwGeneral;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwGeneral.HwGeneralPackage
 * @generated
 */
public interface HwGeneralFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	HwGeneralFactory eINSTANCE = org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwGeneral.impl.HwGeneralFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Hw Resource Service</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Hw Resource Service</em>'.
	 * @generated
	 */
	HwResourceService createHwResourceService();

	/**
	 * Returns a new object of class '<em>Hw Resource</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Hw Resource</em>'.
	 * @generated
	 */
	HwResource createHwResource();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	HwGeneralPackage getHwGeneralPackage();

} //HwGeneralFactory
