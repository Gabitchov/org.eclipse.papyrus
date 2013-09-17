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
 * A representation of the model object '<em><b>Font Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.FontInstance#getFontColor <em>Font Color</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.FontInstance#getFontName <em>Font Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.FontInstance#getFontHeigh <em>Font Heigh</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.FontInstance#isBold <em>Bold</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage#getFontInstance()
 * @model
 * @generated
 */
public interface FontInstance extends TypeInstance {
	/**
	 * Returns the value of the '<em><b>Font Color</b></em>' attribute.
	 * The default value is <code>"15053796"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Font Color</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Font Color</em>' attribute.
	 * @see #setFontColor(int)
	 * @see org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage#getFontInstance_FontColor()
	 * @model default="15053796" dataType="org.eclipse.papyrus.layers.stackmodel.layers.int" required="true" ordered="false"
	 * @generated
	 */
	int getFontColor();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.layers.stackmodel.layers.FontInstance#getFontColor <em>Font Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Font Color</em>' attribute.
	 * @see #getFontColor()
	 * @generated
	 */
	void setFontColor(int value);

	/**
	 * Returns the value of the '<em><b>Font Name</b></em>' attribute.
	 * The default value is <code>"Segoe UI"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Font Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Font Name</em>' attribute.
	 * @see #setFontName(String)
	 * @see org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage#getFontInstance_FontName()
	 * @model default="Segoe UI" dataType="org.eclipse.papyrus.layers.stackmodel.layers.String" required="true" ordered="false"
	 * @generated
	 */
	String getFontName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.layers.stackmodel.layers.FontInstance#getFontName <em>Font Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Font Name</em>' attribute.
	 * @see #getFontName()
	 * @generated
	 */
	void setFontName(String value);

	/**
	 * Returns the value of the '<em><b>Font Heigh</b></em>' attribute.
	 * The default value is <code>"9"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Font Heigh</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Font Heigh</em>' attribute.
	 * @see #setFontHeigh(int)
	 * @see org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage#getFontInstance_FontHeigh()
	 * @model default="9" dataType="org.eclipse.papyrus.layers.stackmodel.layers.int" required="true" ordered="false"
	 * @generated
	 */
	int getFontHeigh();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.layers.stackmodel.layers.FontInstance#getFontHeigh <em>Font Heigh</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Font Heigh</em>' attribute.
	 * @see #getFontHeigh()
	 * @generated
	 */
	void setFontHeigh(int value);

	/**
	 * Returns the value of the '<em><b>Bold</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bold</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bold</em>' attribute.
	 * @see #setBold(boolean)
	 * @see org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage#getFontInstance_Bold()
	 * @model default="true" dataType="org.eclipse.papyrus.layers.stackmodel.layers.boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isBold();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.layers.stackmodel.layers.FontInstance#isBold <em>Bold</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bold</em>' attribute.
	 * @see #isBold()
	 * @generated
	 */
	void setBold(boolean value);

} // FontInstance
