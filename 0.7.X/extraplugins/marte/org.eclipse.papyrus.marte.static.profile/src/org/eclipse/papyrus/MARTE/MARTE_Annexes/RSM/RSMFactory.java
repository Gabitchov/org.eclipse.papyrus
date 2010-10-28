/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Chokri MRAIDHA (CEA LIST) chokri.mraidha@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM.RSMPackage
 * @generated
 */
public interface RSMFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RSMFactory eINSTANCE = org.eclipse.papyrus.MARTE.MARTE_Annexes.RSM.impl.RSMFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Default Link</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Default Link</em>'.
	 * @generated
	 */
	DefaultLink createDefaultLink();

	/**
	 * Returns a new object of class '<em>Inter Repetition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Inter Repetition</em>'.
	 * @generated
	 */
	InterRepetition createInterRepetition();

	/**
	 * Returns a new object of class '<em>Distribute</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Distribute</em>'.
	 * @generated
	 */
	Distribute createDistribute();

	/**
	 * Returns a new object of class '<em>Reshape</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reshape</em>'.
	 * @generated
	 */
	Reshape createReshape();

	/**
	 * Returns a new object of class '<em>Tiler</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tiler</em>'.
	 * @generated
	 */
	Tiler createTiler();

	/**
	 * Returns a new object of class '<em>Shaped</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Shaped</em>'.
	 * @generated
	 */
	Shaped createShaped();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	RSMPackage getRSMPackage();

} //RSMFactory
