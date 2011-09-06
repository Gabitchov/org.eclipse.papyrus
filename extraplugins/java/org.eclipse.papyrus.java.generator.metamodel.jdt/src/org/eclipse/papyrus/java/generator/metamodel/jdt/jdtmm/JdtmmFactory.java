/*****************************************************************************
 * Copyright (c) 2011 Nicolas Deblock & Cedric Dumoulin & Manuel Giles.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	Nicolas Deblock  nico.deblock@gmail.com  - Meta-model conception
 * 	Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Meta-model conception 
 * 	Manuel Giles	 giles.manu@live.fr		 - Meta-model conception
 *
 *****************************************************************************/

/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JdtmmPackage
 * @generated
 */
public interface JdtmmFactory extends EFactory {

	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	JdtmmFactory eINSTANCE = org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.impl.JdtmmFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>JDT Type Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>JDT Type Parameter</em>'.
	 * @generated
	 */
	JDTTypeParameter createJDTTypeParameter();

	/**
	 * Returns a new object of class '<em>JDT Field</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>JDT Field</em>'.
	 * @generated
	 */
	JDTField createJDTField();

	/**
	 * Returns a new object of class '<em>JDT Method</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>JDT Method</em>'.
	 * @generated
	 */
	JDTMethod createJDTMethod();

	/**
	 * Returns a new object of class '<em>JDT Class</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>JDT Class</em>'.
	 * @generated
	 */
	JDTClass createJDTClass();

	/**
	 * Returns a new object of class '<em>JDT Interface</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>JDT Interface</em>'.
	 * @generated
	 */
	JDTInterface createJDTInterface();

	/**
	 * Returns a new object of class '<em>JDT Enum</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>JDT Enum</em>'.
	 * @generated
	 */
	JDTEnum createJDTEnum();

	/**
	 * Returns a new object of class '<em>JDT Compilation Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>JDT Compilation Unit</em>'.
	 * @generated
	 */
	JDTCompilationUnit createJDTCompilationUnit();

	/**
	 * Returns a new object of class '<em>JDT Import Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>JDT Import Declaration</em>'.
	 * @generated
	 */
	JDTImportDeclaration createJDTImportDeclaration();

	/**
	 * Returns a new object of class '<em>JDT Import Container</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>JDT Import Container</em>'.
	 * @generated
	 */
	JDTImportContainer createJDTImportContainer();

	/**
	 * Returns a new object of class '<em>JDT Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>JDT Parameter</em>'.
	 * @generated
	 */
	JDTParameter createJDTParameter();

	/**
	 * Returns a new object of class '<em>JDT Exception</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>JDT Exception</em>'.
	 * @generated
	 */
	JDTException createJDTException();

	/**
	 * Returns a new object of class '<em>JDT Java Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>JDT Java Model</em>'.
	 * @generated
	 */
	JDTJavaModel createJDTJavaModel();

	/**
	 * Returns a new object of class '<em>JDT Package Fragment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>JDT Package Fragment</em>'.
	 * @generated
	 */
	JDTPackageFragment createJDTPackageFragment();

	/**
	 * Returns a new object of class '<em>JDT Package Fragment Root</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>JDT Package Fragment Root</em>'.
	 * @generated
	 */
	JDTPackageFragmentRoot createJDTPackageFragmentRoot();

	/**
	 * Returns a new object of class '<em>JDT Java Project</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>JDT Java Project</em>'.
	 * @generated
	 */
	JDTJavaProject createJDTJavaProject();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the package supported by this factory.
	 * @generated
	 */
	JdtmmPackage getJdtmmPackage();

} //JdtmmFactory
