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

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>JDT Package Fragment Root</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTPackageFragmentRoot#getJavaProject <em>Java Project</em>}</li>
 * <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTPackageFragmentRoot#getPackageFragments <em>Package Fragments</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JdtmmPackage#getJDTPackageFragmentRoot()
 * @model
 * @generated
 */
public interface JDTPackageFragmentRoot extends JDTParentJavaElement {

	/**
	 * Returns the value of the '<em><b>Java Project</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTJavaProject#getPackageFragmentRoots
	 * <em>Package Fragment Roots</em>}'.
	 * <p>
	 * This feature redefines the following features:
	 * <ul>
	 * <li>'{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTJavaElement#getParent() <em>Parent</em>}'</li>
	 * </ul>
	 * </p>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Java Project</em>' container reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Java Project</em>' container reference.
	 * @see #setJavaProject(JDTJavaProject)
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JdtmmPackage#getJDTPackageFragmentRoot_JavaProject()
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTJavaProject#getPackageFragmentRoots
	 * @model opposite="packageFragmentRoots" transient="false" ordered="false"
	 * @generated
	 */
	JDTJavaProject getJavaProject();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTPackageFragmentRoot#getJavaProject
	 * <em>Java Project</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Java Project</em>' container reference.
	 * @see #getJavaProject()
	 * @generated
	 */
	void setJavaProject(JDTJavaProject value);

	/**
	 * Returns the value of the '<em><b>Package Fragments</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTPackageFragment}.
	 * It is bidirectional and its opposite is '
	 * {@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTPackageFragment#getPackageFragmentRoot <em>Package Fragment Root</em>}'.
	 * <p>
	 * This feature subsets the following features:
	 * <ul>
	 * <li>'{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTParent#getChildren() <em>Children</em>}'</li>
	 * </ul>
	 * </p>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Package Fragments</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Package Fragments</em>' containment reference list.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JdtmmPackage#getJDTPackageFragmentRoot_PackageFragments()
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTPackageFragment#getPackageFragmentRoot
	 * @model opposite="packageFragmentRoot" containment="true" ordered="false"
	 * @generated
	 */
	EList<JDTPackageFragment> getPackageFragments();
} // JDTPackageFragmentRoot
