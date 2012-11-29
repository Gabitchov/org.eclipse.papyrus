/**
 * Copyright (c) 2012 CEA LIST.
 * 
 *     
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * ttp://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.infra.table.papyrustableconfiguration.metamodel.PapyrusTableConfiguration;

import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.facet.widgets.nattable.tableconfiguration2.TableConfiguration2;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Papyrus Table Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.table.papyrustableconfiguration.metamodel.PapyrusTableConfiguration.PapyrusTableConfiguration#getPastedElementContainmentFeature <em>Pasted Element Containment Feature</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.table.papyrustableconfiguration.metamodel.PapyrusTableConfiguration.PapyrusTableConfiguration#getPastedElementId <em>Pasted Element Id</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.table.papyrustableconfiguration.metamodel.PapyrusTableConfiguration.PapyrusTableConfiguration#getTableConfiguration <em>Table Configuration</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.table.papyrustableconfiguration.metamodel.PapyrusTableConfiguration.PapyrusTableConfigurationPackage#getPapyrusTableConfiguration()
 * @model
 * @generated
 */
public interface PapyrusTableConfiguration extends EModelElement {
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
	 * @see org.eclipse.papyrus.infra.table.papyrustableconfiguration.metamodel.PapyrusTableConfiguration.PapyrusTableConfigurationPackage#getPapyrusTableConfiguration_PastedElementContainmentFeature()
	 * @model
	 * @generated
	 */
	EReference getPastedElementContainmentFeature();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.table.papyrustableconfiguration.metamodel.PapyrusTableConfiguration.PapyrusTableConfiguration#getPastedElementContainmentFeature <em>Pasted Element Containment Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pasted Element Containment Feature</em>' reference.
	 * @see #getPastedElementContainmentFeature()
	 * @generated
	 */
	void setPastedElementContainmentFeature(EReference value);

	/**
	 * Returns the value of the '<em><b>Pasted Element Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pasted Element Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pasted Element Id</em>' attribute.
	 * @see #setPastedElementId(String)
	 * @see org.eclipse.papyrus.infra.table.papyrustableconfiguration.metamodel.PapyrusTableConfiguration.PapyrusTableConfigurationPackage#getPapyrusTableConfiguration_PastedElementId()
	 * @model
	 * @generated
	 */
	String getPastedElementId();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.table.papyrustableconfiguration.metamodel.PapyrusTableConfiguration.PapyrusTableConfiguration#getPastedElementId <em>Pasted Element Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pasted Element Id</em>' attribute.
	 * @see #getPastedElementId()
	 * @generated
	 */
	void setPastedElementId(String value);

	/**
	 * Returns the value of the '<em><b>Table Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Table Configuration</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Table Configuration</em>' containment reference.
	 * @see #setTableConfiguration(TableConfiguration2)
	 * @see org.eclipse.papyrus.infra.table.papyrustableconfiguration.metamodel.PapyrusTableConfiguration.PapyrusTableConfigurationPackage#getPapyrusTableConfiguration_TableConfiguration()
	 * @model containment="true"
	 * @generated
	 */
	TableConfiguration2 getTableConfiguration();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.table.papyrustableconfiguration.metamodel.PapyrusTableConfiguration.PapyrusTableConfiguration#getTableConfiguration <em>Table Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Table Configuration</em>' containment reference.
	 * @see #getTableConfiguration()
	 * @generated
	 */
	void setTableConfiguration(TableConfiguration2 value);

} // PapyrusTableConfiguration
