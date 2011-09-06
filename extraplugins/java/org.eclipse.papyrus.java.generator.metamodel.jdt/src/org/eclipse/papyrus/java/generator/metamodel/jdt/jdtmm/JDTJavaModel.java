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
 * A representation of the model object '<em><b>JDT Java Model</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTJavaModel#getJavaProject <em>Java Project</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JdtmmPackage#getJDTJavaModel()
 * @model
 * @generated
 */
public interface JDTJavaModel extends JDTParentJavaElement {

	/**
	 * Returns the value of the '<em><b>Java Project</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTJavaProject}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTJavaProject#getJavaModel
	 * <em>Java Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Java Project</em>' containment reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Java Project</em>' containment reference list.
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JdtmmPackage#getJDTJavaModel_JavaProject()
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTJavaProject#getJavaModel
	 * @model opposite="javaModel" containment="true" ordered="false"
	 * @generated
	 */
	EList<JDTJavaProject> getJavaProject();
} // JDTJavaModel
