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
package org.eclipse.papyrus.infra.nattable.model.tableeditorconfiguration;

import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Table Editor Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.tableeditorconfiguration.TableEditorConfiguration#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.tableeditorconfiguration.TableEditorConfiguration#getPastedElementTypeId <em>Pasted Element Type Id</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.tableeditorconfiguration.TableEditorConfiguration#getPastedElementContainmentFeature <em>Pasted Element Containment Feature</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.nattable.model.tableeditorconfiguration.TableEditorConfigurationPackage#getTableEditorConfiguration()
 * @model
 * @generated
 */
public interface TableEditorConfiguration extends EModelElement {
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
	 * @see org.eclipse.papyrus.infra.nattable.model.tableeditorconfiguration.TableEditorConfigurationPackage#getTableEditorConfiguration_Type()
	 * @model id="true"
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.nattable.model.tableeditorconfiguration.TableEditorConfiguration#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

	/**
	 * Returns the value of the '<em><b>Pasted Element Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pasted Element Type Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pasted Element Type Id</em>' attribute.
	 * @see #setPastedElementTypeId(String)
	 * @see org.eclipse.papyrus.infra.nattable.model.tableeditorconfiguration.TableEditorConfigurationPackage#getTableEditorConfiguration_PastedElementTypeId()
	 * @model
	 * @generated
	 */
	String getPastedElementTypeId();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.nattable.model.tableeditorconfiguration.TableEditorConfiguration#getPastedElementTypeId <em>Pasted Element Type Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pasted Element Type Id</em>' attribute.
	 * @see #getPastedElementTypeId()
	 * @generated
	 */
	void setPastedElementTypeId(String value);

	/**
	 * Returns the value of the '<em><b>Pasted Element Containment Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pasted Element Containment Feature</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pasted Element Containment Feature</em>' reference.
	 * @see #setPastedElementContainmentFeature(EReference)
	 * @see org.eclipse.papyrus.infra.nattable.model.tableeditorconfiguration.TableEditorConfigurationPackage#getTableEditorConfiguration_PastedElementContainmentFeature()
	 * @model
	 * @generated
	 */
	EReference getPastedElementContainmentFeature();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.nattable.model.tableeditorconfiguration.TableEditorConfiguration#getPastedElementContainmentFeature <em>Pasted Element Containment Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pasted Element Containment Feature</em>' reference.
	 * @see #getPastedElementContainmentFeature()
	 * @generated
	 */
	void setPastedElementContainmentFeature(EReference value);

} // TableEditorConfiguration
