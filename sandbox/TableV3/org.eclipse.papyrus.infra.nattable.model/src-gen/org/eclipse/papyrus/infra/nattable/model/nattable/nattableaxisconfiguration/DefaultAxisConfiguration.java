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
package org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Default Axis Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.DefaultAxisConfiguration#getIndexStyle <em>Index Style</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.DefaultAxisConfiguration#isDisplayIndex <em>Display Index</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.DefaultAxisConfiguration#isDisplayLabel <em>Display Label</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.DefaultAxisConfiguration#isDisplayFilter <em>Display Filter</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.NattableaxisconfigurationPackage#getDefaultAxisConfiguration()
 * @model
 * @generated
 */
public interface DefaultAxisConfiguration extends AbstractAxisConfiguration {
	/**
	 * Returns the value of the '<em><b>Index Style</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AxisIndexStyle}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Index Style</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Index Style</em>' attribute.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AxisIndexStyle
	 * @see #setIndexStyle(AxisIndexStyle)
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.NattableaxisconfigurationPackage#getDefaultAxisConfiguration_IndexStyle()
	 * @model required="true"
	 * @generated
	 */
	AxisIndexStyle getIndexStyle();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.DefaultAxisConfiguration#getIndexStyle <em>Index Style</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Index Style</em>' attribute.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AxisIndexStyle
	 * @see #getIndexStyle()
	 * @generated
	 */
	void setIndexStyle(AxisIndexStyle value);

	/**
	 * Returns the value of the '<em><b>Display Index</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Display Index</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Display Index</em>' attribute.
	 * @see #setDisplayIndex(boolean)
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.NattableaxisconfigurationPackage#getDefaultAxisConfiguration_DisplayIndex()
	 * @model default="true" required="true"
	 * @generated
	 */
	boolean isDisplayIndex();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.DefaultAxisConfiguration#isDisplayIndex <em>Display Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Display Index</em>' attribute.
	 * @see #isDisplayIndex()
	 * @generated
	 */
	void setDisplayIndex(boolean value);

	/**
	 * Returns the value of the '<em><b>Display Label</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Display Label</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Display Label</em>' attribute.
	 * @see #setDisplayLabel(boolean)
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.NattableaxisconfigurationPackage#getDefaultAxisConfiguration_DisplayLabel()
	 * @model default="true" required="true"
	 * @generated
	 */
	boolean isDisplayLabel();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.DefaultAxisConfiguration#isDisplayLabel <em>Display Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Display Label</em>' attribute.
	 * @see #isDisplayLabel()
	 * @generated
	 */
	void setDisplayLabel(boolean value);

	/**
	 * Returns the value of the '<em><b>Display Filter</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Display Filter</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Display Filter</em>' attribute.
	 * @see #setDisplayFilter(boolean)
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.NattableaxisconfigurationPackage#getDefaultAxisConfiguration_DisplayFilter()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isDisplayFilter();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.DefaultAxisConfiguration#isDisplayFilter <em>Display Filter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Display Filter</em>' attribute.
	 * @see #isDisplayFilter()
	 * @generated
	 */
	void setDisplayFilter(boolean value);

} // DefaultAxisConfiguration
