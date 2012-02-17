/**
 *  Copyright (c) 2012 CEA LIST.
 * 
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *  Vincent Lorenzo (CEA-LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 * 
 * 
 */
package org.eclipse.papyrus.infra.emf.compare.instance.papyrusemfcompareinstance;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.infra.emf.compare.instance.papyrusemfcompareinstance.PapyrusemfcompareinstancePackage
 * @generated
 */
public interface PapyrusemfcompareinstanceFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PapyrusemfcompareinstanceFactory eINSTANCE = org.eclipse.papyrus.infra.emf.compare.instance.papyrusemfcompareinstance.impl.PapyrusemfcompareinstanceFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Papyrus EMF Compare Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Papyrus EMF Compare Instance</em>'.
	 * @generated
	 */
	PapyrusEMFCompareInstance createPapyrusEMFCompareInstance();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	PapyrusemfcompareinstancePackage getPapyrusemfcompareinstancePackage();

} //PapyrusemfcompareinstanceFactory
