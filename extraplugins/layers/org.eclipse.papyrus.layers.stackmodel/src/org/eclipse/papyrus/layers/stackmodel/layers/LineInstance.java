/*******************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cedric Dumoulin Cedric.dumoulin@lifl.fr
 ******************************************************************************/
/**
 */
package org.eclipse.papyrus.layers.stackmodel.layers;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Line Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.LineInstance#getLineColor <em>Line Color</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.LineInstance#getLineWith <em>Line With</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage#getLineInstance()
 * @model
 * @generated
 */
public interface LineInstance extends TypeInstance {
	/**
	 * Returns the value of the '<em><b>Line Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Line Color</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Line Color</em>' attribute.
	 * @see #setLineColor(int)
	 * @see org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage#getLineInstance_LineColor()
	 * @model dataType="org.eclipse.papyrus.layers.stackmodel.layers.int" required="true" ordered="false"
	 * @generated
	 */
	int getLineColor();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.layers.stackmodel.layers.LineInstance#getLineColor <em>Line Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Line Color</em>' attribute.
	 * @see #getLineColor()
	 * @generated
	 */
	void setLineColor(int value);

	/**
	 * Returns the value of the '<em><b>Line With</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Line With</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Line With</em>' attribute.
	 * @see #setLineWith(int)
	 * @see org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage#getLineInstance_LineWith()
	 * @model dataType="org.eclipse.papyrus.layers.stackmodel.layers.int" required="true" ordered="false"
	 * @generated
	 */
	int getLineWith();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.layers.stackmodel.layers.LineInstance#getLineWith <em>Line With</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Line With</em>' attribute.
	 * @see #getLineWith()
	 * @generated
	 */
	void setLineWith(int value);

} // LineInstance
