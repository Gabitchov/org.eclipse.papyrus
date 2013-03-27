/**
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.cdo.validation.problems;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a
 * create method for each non-abstract class of the model. <!-- end-user-doc -->
 * @see org.eclipse.papyrus.cdo.validation.problems.ProblemsPackage
 * @generated
 */
public interface ProblemsFactory extends EFactory {

	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	ProblemsFactory eINSTANCE = org.eclipse.papyrus.cdo.validation.problems.impl.ProblemsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>EProblem</em>'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return a new object of class '<em>EProblem</em>'.
	 * @generated
	 */
	EProblem createEProblem();

	/**
	 * Returns a new object of class '<em>EProblems Container</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>EProblems Container</em>'.
	 * @generated
	 */
	EProblemsContainer createEProblemsContainer();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ProblemsPackage getProblemsPackage();

} // ProblemsFactory
