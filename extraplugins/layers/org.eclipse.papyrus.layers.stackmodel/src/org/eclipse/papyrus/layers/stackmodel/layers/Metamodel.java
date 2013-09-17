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

import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Metamodel</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.Metamodel#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.Metamodel#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.Metamodel#getNsuri <em>Nsuri</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.Metamodel#getPluginID <em>Plugin ID</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.Metamodel#getEPackageInstanceName <em>EPackage Instance Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.Metamodel#isTypeValid <em>Is Type Valid</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage#getMetamodel()
 * @model
 * @generated
 */
public interface Metamodel extends FolderElement {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage#getMetamodel_Name()
	 * @model dataType="org.eclipse.papyrus.layers.stackmodel.layers.String" required="true" ordered="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.layers.stackmodel.layers.Metamodel#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage#getMetamodel_Description()
	 * @model dataType="org.eclipse.papyrus.layers.stackmodel.layers.String" required="true" ordered="false"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.layers.stackmodel.layers.Metamodel#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Nsuri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nsuri</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nsuri</em>' attribute.
	 * @see #setNsuri(String)
	 * @see org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage#getMetamodel_Nsuri()
	 * @model dataType="org.eclipse.papyrus.layers.stackmodel.layers.String" required="true" ordered="false"
	 * @generated
	 */
	String getNsuri();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.layers.stackmodel.layers.Metamodel#getNsuri <em>Nsuri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nsuri</em>' attribute.
	 * @see #getNsuri()
	 * @generated
	 */
	void setNsuri(String value);

	/**
	 * Returns the value of the '<em><b>Plugin ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Plugin ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Plugin ID</em>' attribute.
	 * @see #setPluginID(String)
	 * @see org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage#getMetamodel_PluginID()
	 * @model dataType="org.eclipse.papyrus.layers.stackmodel.layers.String" required="true" ordered="false"
	 * @generated
	 */
	String getPluginID();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.layers.stackmodel.layers.Metamodel#getPluginID <em>Plugin ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Plugin ID</em>' attribute.
	 * @see #getPluginID()
	 * @generated
	 */
	void setPluginID(String value);

	/**
	 * Returns the value of the '<em><b>EPackage Instance Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EPackage Instance Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EPackage Instance Name</em>' attribute.
	 * @see #setEPackageInstanceName(String)
	 * @see org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage#getMetamodel_EPackageInstanceName()
	 * @model dataType="org.eclipse.papyrus.layers.stackmodel.layers.String" required="true" ordered="false"
	 * @generated
	 */
	String getEPackageInstanceName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.layers.stackmodel.layers.Metamodel#getEPackageInstanceName <em>EPackage Instance Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>EPackage Instance Name</em>' attribute.
	 * @see #getEPackageInstanceName()
	 * @generated
	 */
	void setEPackageInstanceName(String value);

	/**
	 * Returns the value of the '<em><b>Is Type Valid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Type Valid</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Type Valid</em>' attribute.
	 * @see #setIsTypeValid(boolean)
	 * @see org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage#getMetamodel_IsTypeValid()
	 * @model dataType="org.eclipse.papyrus.layers.stackmodel.layers.boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isTypeValid();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.layers.stackmodel.layers.Metamodel#isTypeValid <em>Is Type Valid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Type Valid</em>' attribute.
	 * @see #isTypeValid()
	 * @generated
	 */
	void setIsTypeValid(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" dataType="org.eclipse.papyrus.layers.stackmodel.layers.EPackage" required="true" ordered="false"
	 * @generated
	 */
	EPackage getEPackage();

} // Metamodel
