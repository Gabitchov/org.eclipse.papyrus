/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.infra.table.instance.papyrustableinstance;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrustableinstancePackage
 * @generated
 */
public interface PapyrustableinstanceFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PapyrustableinstanceFactory eINSTANCE = org.eclipse.papyrus.infra.table.instance.papyrustableinstance.impl.PapyrustableinstanceFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Papyrus Table Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Papyrus Table Instance</em>'.
	 * @generated
	 */
	PapyrusTableInstance createPapyrusTableInstance();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	PapyrustableinstancePackage getPapyrustableinstancePackage();

} //PapyrustableinstanceFactory
