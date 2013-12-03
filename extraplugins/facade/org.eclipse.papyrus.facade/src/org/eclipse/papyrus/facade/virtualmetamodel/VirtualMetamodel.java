/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.facade.virtualmetamodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.papyrus.facade.Facade;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Virtual Metamodel</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualMetamodel#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualMetamodel#getNsPrefix <em>Ns Prefix</em>}</li>
 *   <li>{@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualMetamodel#getNsURI <em>Ns URI</em>}</li>
 *   <li>{@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualMetamodel#getVirtualClassifiers <em>Virtual Classifiers</em>}</li>
 *   <li>{@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualMetamodel#getFacade <em>Facade</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.facade.virtualmetamodel.VirtualmetamodelPackage#getVirtualMetamodel()
 * @model
 * @generated
 */
public interface VirtualMetamodel extends EObject {
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
	 * @see org.eclipse.papyrus.facade.virtualmetamodel.VirtualmetamodelPackage#getVirtualMetamodel_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualMetamodel#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Ns Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ns Prefix</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ns Prefix</em>' attribute.
	 * @see #setNsPrefix(String)
	 * @see org.eclipse.papyrus.facade.virtualmetamodel.VirtualmetamodelPackage#getVirtualMetamodel_NsPrefix()
	 * @model
	 * @generated
	 */
	String getNsPrefix();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualMetamodel#getNsPrefix <em>Ns Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ns Prefix</em>' attribute.
	 * @see #getNsPrefix()
	 * @generated
	 */
	void setNsPrefix(String value);

	/**
	 * Returns the value of the '<em><b>Ns URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ns URI</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ns URI</em>' attribute.
	 * @see #setNsURI(String)
	 * @see org.eclipse.papyrus.facade.virtualmetamodel.VirtualmetamodelPackage#getVirtualMetamodel_NsURI()
	 * @model
	 * @generated
	 */
	String getNsURI();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualMetamodel#getNsURI <em>Ns URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ns URI</em>' attribute.
	 * @see #getNsURI()
	 * @generated
	 */
	void setNsURI(String value);

	/**
	 * Returns the value of the '<em><b>Virtual Classifiers</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualClassifier}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualClassifier#getMetamodel <em>Metamodel</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Virtual Classifiers</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Virtual Classifiers</em>' containment reference list.
	 * @see org.eclipse.papyrus.facade.virtualmetamodel.VirtualmetamodelPackage#getVirtualMetamodel_VirtualClassifiers()
	 * @see org.eclipse.papyrus.facade.virtualmetamodel.VirtualClassifier#getMetamodel
	 * @model opposite="metamodel" containment="true"
	 * @generated
	 */
	EList<VirtualClassifier> getVirtualClassifiers();

	/**
	 * Returns the value of the '<em><b>Facade</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.facade.Facade#getVirtualmetamodel <em>Virtualmetamodel</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Facade</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Facade</em>' container reference.
	 * @see #setFacade(Facade)
	 * @see org.eclipse.papyrus.facade.virtualmetamodel.VirtualmetamodelPackage#getVirtualMetamodel_Facade()
	 * @see org.eclipse.papyrus.facade.Facade#getVirtualmetamodel
	 * @model opposite="virtualmetamodel" required="true" transient="false"
	 * @generated
	 */
	Facade getFacade();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualMetamodel#getFacade <em>Facade</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Facade</em>' container reference.
	 * @see #getFacade()
	 * @generated
	 */
	void setFacade(Facade value);

} // VirtualMetamodel
