/**
 * Copyright (c) 2013 CEA LIST.
 * 
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.infra.nattable.model.nattable.nattabletester;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Java Table Tester</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <!-- begin-model-doc -->
 * This class allows to references a JavaTableTester. The Java class is declared with an id, using the extension point
 * org.eclipse.papyrus.infra.nattable.tester.
 * The field tester must be the id declared in this extension point.
 * <!-- end-model-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattabletester.JavaTableTester#getTester <em>Tester</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattabletester.NattabletesterPackage#getJavaTableTester()
 * @model
 * @generated
 */
public interface JavaTableTester extends AbstractTableTester {

	/**
	 * Returns the value of the '<em><b>Tester</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The id of the java tester declared using the extension point org.eclispe.papyrus.infra.nattable.tester
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Tester</em>' attribute.
	 * @see #setTester(String)
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattabletester.NattabletesterPackage#getJavaTableTester_Tester()
	 * @model required="true"
	 * @generated
	 */
	String getTester();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattabletester.JavaTableTester#getTester <em>Tester</em>}'
	 * attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Tester</em>' attribute.
	 * @see #getTester()
	 * @generated
	 */
	void setTester(String value);

} // JavaTableTester
