/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwPhysical.HwPower;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwPhysical.HwPower.HwPowerPackage
 * @generated
 */
public interface HwPowerFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	HwPowerFactory eINSTANCE = org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwPhysical.HwPower.impl.HwPowerFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Supply</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Supply</em>'.
	 * @generated
	 */
	HwPowerSupply createHwPowerSupply();

	/**
	 * Returns a new object of class '<em>Hw Cooling Supply</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Hw Cooling Supply</em>'.
	 * @generated
	 */
	HwCoolingSupply createHwCoolingSupply();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	HwPowerPackage getHwPowerPackage();

} //HwPowerFactory
