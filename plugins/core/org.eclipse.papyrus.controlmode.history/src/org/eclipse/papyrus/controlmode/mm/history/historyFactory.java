/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.controlmode.mm.history;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.controlmode.mm.history.historyPackage
 * @generated
 */
public interface historyFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	historyFactory eINSTANCE = org.eclipse.papyrus.controlmode.mm.history.impl.historyFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Controled Resource</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Controled Resource</em>'.
	 * @generated
	 */
	ControledResource createControledResource();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	historyPackage gethistoryPackage();

} //historyFactory
