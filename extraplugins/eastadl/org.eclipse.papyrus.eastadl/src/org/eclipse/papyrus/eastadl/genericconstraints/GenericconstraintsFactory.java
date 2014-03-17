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
 *  Sara TUCCI (CEA LIST) sara.tucci@cea.fr - Initial API and implementation
 *  Chokri MRAIDHA (CEA LIST) chokri.mraidha@cea.fr - Initial API and implementation
 *  David SERVAT (CEA LIST) david.servat@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.eastadl.genericconstraints;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.papyrus.eastadl.genericconstraints.GenericconstraintsPackage
 * @generated
 */
public interface GenericconstraintsFactory extends EFactory {

	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	GenericconstraintsFactory eINSTANCE = org.eclipse.papyrus.eastadl.genericconstraints.impl.GenericconstraintsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Generic Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Generic Constraint</em>'.
	 * @generated
	 */
	GenericConstraint createGenericConstraint();

	/**
	 * Returns a new object of class '<em>Generic Constraint Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Generic Constraint Set</em>'.
	 * @generated
	 */
	GenericConstraintSet createGenericConstraintSet();

	/**
	 * Returns a new object of class '<em>Take Rate Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Take Rate Constraint</em>'.
	 * @generated
	 */
	TakeRateConstraint createTakeRateConstraint();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the package supported by this factory.
	 * @generated
	 */
	GenericconstraintsPackage getGenericconstraintsPackage();

} //GenericconstraintsFactory
