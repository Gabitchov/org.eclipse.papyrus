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
 *  Laurent Wouters laurent.wouters@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.viewpoints.configuration;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.papyrus.infra.viewpoints.iso42010.ModelKind;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Papyrus View</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusView#getIcon <em>Icon</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusView#getParent <em>Parent</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusView#getProfiles <em>Profiles</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusView#getModelRules <em>Model Rules</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusView#getOwningRules <em>Owning Rules</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusView#getImplementationID <em>Implementation ID</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusView#getCategories <em>Categories</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.viewpoints.configuration.ConfigurationPackage#getPapyrusView()
 * @model
 * @generated
 */
public interface PapyrusView extends ModelKind {

	/**
	 * Returns the value of the '<em><b>Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Icon</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Icon</em>' attribute.
	 * @see #setIcon(String)
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.ConfigurationPackage#getPapyrusView_Icon()
	 * @model
	 * @generated
	 */
	String getIcon();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusView#getIcon <em>Icon</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Icon</em>' attribute.
	 * @see #getIcon()
	 * @generated
	 */
	void setIcon(String value);

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' reference.
	 * @see #setParent(PapyrusView)
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.ConfigurationPackage#getPapyrusView_Parent()
	 * @model
	 * @generated
	 */
	PapyrusView getParent();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusView#getParent <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(PapyrusView value);

	/**
	 * Returns the value of the '<em><b>Profiles</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EPackage}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Profiles</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Profiles</em>' reference list.
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.ConfigurationPackage#getPapyrusView_Profiles()
	 * @model
	 * @generated
	 */
	EList<EPackage> getProfiles();

	/**
	 * Returns the value of the '<em><b>Model Rules</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.viewpoints.configuration.ModelRule}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * These rules determine which model elements can be the semantic element behind this diagram
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Model Rules</em>' containment reference list.
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.ConfigurationPackage#getPapyrusView_ModelRules()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<ModelRule> getModelRules();

	/**
	 * Returns the value of the '<em><b>Owning Rules</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.viewpoints.configuration.OwningRule}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * These rules determine which elements can be the syntactic owner of this diagram
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owning Rules</em>' containment reference list.
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.ConfigurationPackage#getPapyrusView_OwningRules()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<OwningRule> getOwningRules();

	/**
	 * Returns the value of the '<em><b>Implementation ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Implementation ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Implementation ID</em>' attribute.
	 * @see #setImplementationID(String)
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.ConfigurationPackage#getPapyrusView_ImplementationID()
	 * @model required="true"
	 * @generated
	 */
	String getImplementationID();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusView#getImplementationID <em>Implementation ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Implementation ID</em>' attribute.
	 * @see #getImplementationID()
	 * @generated
	 */
	void setImplementationID(String value);

	/**
	 * Returns the value of the '<em><b>Categories</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.viewpoints.configuration.Category}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Categories</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Categories</em>' reference list.
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.ConfigurationPackage#getPapyrusView_Categories()
	 * @model
	 * @generated
	 */
	EList<Category> getCategories();
} // PapyrusView
