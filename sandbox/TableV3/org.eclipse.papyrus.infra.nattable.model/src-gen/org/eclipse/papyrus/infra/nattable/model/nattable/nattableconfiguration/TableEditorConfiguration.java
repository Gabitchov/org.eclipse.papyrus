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
package org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration;

import org.eclipse.emf.ecore.EModelElement;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.AbstractAxisProvider;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Table Editor Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableEditorConfiguration#getVerticalAxisProvider <em>Vertical Axis Provider</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableEditorConfiguration#getHorizontalAxisProvider <em>Horizontal Axis Provider</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableEditorConfiguration#getEditorDeclaration <em>Editor Declaration</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableEditorConfiguration#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.NattableconfigurationPackage#getTableEditorConfiguration()
 * @model
 * @generated
 */
public interface TableEditorConfiguration extends EModelElement {
	/**
	 * Returns the value of the '<em><b>Vertical Axis Provider</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Vertical Axis Provider</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vertical Axis Provider</em>' containment reference.
	 * @see #setVerticalAxisProvider(AbstractAxisProvider)
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.NattableconfigurationPackage#getTableEditorConfiguration_VerticalAxisProvider()
	 * @model containment="true" required="true"
	 * @generated
	 */
	AbstractAxisProvider getVerticalAxisProvider();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableEditorConfiguration#getVerticalAxisProvider <em>Vertical Axis Provider</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Vertical Axis Provider</em>' containment reference.
	 * @see #getVerticalAxisProvider()
	 * @generated
	 */
	void setVerticalAxisProvider(AbstractAxisProvider value);

	/**
	 * Returns the value of the '<em><b>Horizontal Axis Provider</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Horizontal Axis Provider</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Horizontal Axis Provider</em>' containment reference.
	 * @see #setHorizontalAxisProvider(AbstractAxisProvider)
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.NattableconfigurationPackage#getTableEditorConfiguration_HorizontalAxisProvider()
	 * @model containment="true" required="true"
	 * @generated
	 */
	AbstractAxisProvider getHorizontalAxisProvider();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableEditorConfiguration#getHorizontalAxisProvider <em>Horizontal Axis Provider</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Horizontal Axis Provider</em>' containment reference.
	 * @see #getHorizontalAxisProvider()
	 * @generated
	 */
	void setHorizontalAxisProvider(AbstractAxisProvider value);

	/**
	 * Returns the value of the '<em><b>Editor Declaration</b></em>' attribute.
	 * The default value is <code>"COLUMN"</code>.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.CellEditorDeclaration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Editor Declaration</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Editor Declaration</em>' attribute.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.CellEditorDeclaration
	 * @see #setEditorDeclaration(CellEditorDeclaration)
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.NattableconfigurationPackage#getTableEditorConfiguration_EditorDeclaration()
	 * @model default="COLUMN" required="true"
	 * @generated
	 */
	CellEditorDeclaration getEditorDeclaration();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableEditorConfiguration#getEditorDeclaration <em>Editor Declaration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Editor Declaration</em>' attribute.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.CellEditorDeclaration
	 * @see #getEditorDeclaration()
	 * @generated
	 */
	void setEditorDeclaration(CellEditorDeclaration value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.NattableconfigurationPackage#getTableEditorConfiguration_Type()
	 * @model id="true" required="true"
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableEditorConfiguration#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

} // TableEditorConfiguration
