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

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.IAxisContentsProvider;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Table Editor Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableEditorConfiguration#getPastedElementTypeId <em>Pasted Element Type Id</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableEditorConfiguration#getPastedElementContainmentFeature <em>Pasted Element Containment Feature</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableEditorConfiguration#getJavaVerticalContentProviderIds <em>Java Vertical Content Provider Ids</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableEditorConfiguration#getJavaHorizontalContentProviderIds <em>Java Horizontal Content Provider Ids</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableEditorConfiguration#getDefaultVerticalContentProvider <em>Default Vertical Content Provider</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableEditorConfiguration#getDefaultHorizontalContentProvider <em>Default Horizontal Content Provider</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.NattableconfigurationPackage#getTableEditorConfiguration()
 * @model
 * @generated
 */
public interface TableEditorConfiguration extends EModelElement {
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
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.NattableconfigurationPackage#getTableEditorConfiguration_PastedElementTypeId()
	 * @model
	 * @generated
	 */
	String getPastedElementTypeId();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableEditorConfiguration#getPastedElementTypeId <em>Pasted Element Type Id</em>}' attribute.
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
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.NattableconfigurationPackage#getTableEditorConfiguration_PastedElementContainmentFeature()
	 * @model
	 * @generated
	 */
	EReference getPastedElementContainmentFeature();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableEditorConfiguration#getPastedElementContainmentFeature <em>Pasted Element Containment Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pasted Element Containment Feature</em>' reference.
	 * @see #getPastedElementContainmentFeature()
	 * @generated
	 */
	void setPastedElementContainmentFeature(EReference value);

	/**
	 * Returns the value of the '<em><b>Java Vertical Content Provider Ids</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Java Vertical Content Provider Ids</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Java Vertical Content Provider Ids</em>' attribute list.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.NattableconfigurationPackage#getTableEditorConfiguration_JavaVerticalContentProviderIds()
	 * @model required="true"
	 * @generated
	 */
	EList<String> getJavaVerticalContentProviderIds();

	/**
	 * Returns the value of the '<em><b>Java Horizontal Content Provider Ids</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Java Horizontal Content Provider Ids</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Java Horizontal Content Provider Ids</em>' attribute list.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.NattableconfigurationPackage#getTableEditorConfiguration_JavaHorizontalContentProviderIds()
	 * @model required="true"
	 * @generated
	 */
	EList<String> getJavaHorizontalContentProviderIds();

	/**
	 * Returns the value of the '<em><b>Default Vertical Content Provider</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Vertical Content Provider</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Vertical Content Provider</em>' containment reference.
	 * @see #setDefaultVerticalContentProvider(IAxisContentsProvider)
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.NattableconfigurationPackage#getTableEditorConfiguration_DefaultVerticalContentProvider()
	 * @model containment="true"
	 * @generated
	 */
	IAxisContentsProvider getDefaultVerticalContentProvider();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableEditorConfiguration#getDefaultVerticalContentProvider <em>Default Vertical Content Provider</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Vertical Content Provider</em>' containment reference.
	 * @see #getDefaultVerticalContentProvider()
	 * @generated
	 */
	void setDefaultVerticalContentProvider(IAxisContentsProvider value);

	/**
	 * Returns the value of the '<em><b>Default Horizontal Content Provider</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Horizontal Content Provider</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Horizontal Content Provider</em>' containment reference.
	 * @see #setDefaultHorizontalContentProvider(IAxisContentsProvider)
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.NattableconfigurationPackage#getTableEditorConfiguration_DefaultHorizontalContentProvider()
	 * @model containment="true"
	 * @generated
	 */
	IAxisContentsProvider getDefaultHorizontalContentProvider();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableEditorConfiguration#getDefaultHorizontalContentProvider <em>Default Horizontal Content Provider</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Horizontal Content Provider</em>' containment reference.
	 * @see #getDefaultHorizontalContentProvider()
	 * @generated
	 */
	void setDefaultHorizontalContentProvider(IAxisContentsProvider value);

} // TableEditorConfiguration
