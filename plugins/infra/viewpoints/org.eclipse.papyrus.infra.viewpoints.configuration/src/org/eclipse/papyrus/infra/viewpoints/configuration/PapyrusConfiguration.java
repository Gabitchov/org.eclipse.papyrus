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
import org.eclipse.papyrus.infra.viewpoints.iso42010.ArchitectureFramework;
import org.eclipse.papyrus.infra.viewpoints.iso42010.Stakeholder;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Papyrus Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusConfiguration#getDefaultStakeholder <em>Default Stakeholder</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusConfiguration#getMetamodel <em>Metamodel</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusConfiguration#getCategories <em>Categories</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.viewpoints.configuration.ConfigurationPackage#getPapyrusConfiguration()
 * @model
 * @generated
 */
public interface PapyrusConfiguration extends ArchitectureFramework {
	/**
	 * Returns the value of the '<em><b>Default Stakeholder</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Stakeholder</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Stakeholder</em>' reference.
	 * @see #setDefaultStakeholder(Stakeholder)
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.ConfigurationPackage#getPapyrusConfiguration_DefaultStakeholder()
	 * @model required="true"
	 * @generated
	 */
	Stakeholder getDefaultStakeholder();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusConfiguration#getDefaultStakeholder <em>Default Stakeholder</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Stakeholder</em>' reference.
	 * @see #getDefaultStakeholder()
	 * @generated
	 */
	void setDefaultStakeholder(Stakeholder value);

	/**
	 * Returns the value of the '<em><b>Metamodel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Metamodel</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Metamodel</em>' reference.
	 * @see #setMetamodel(EPackage)
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.ConfigurationPackage#getPapyrusConfiguration_Metamodel()
	 * @model required="true"
	 * @generated
	 */
	EPackage getMetamodel();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusConfiguration#getMetamodel <em>Metamodel</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Metamodel</em>' reference.
	 * @see #getMetamodel()
	 * @generated
	 */
	void setMetamodel(EPackage value);

	/**
	 * Returns the value of the '<em><b>Categories</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.viewpoints.configuration.Category}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Categories</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Categories</em>' containment reference list.
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.ConfigurationPackage#getPapyrusConfiguration_Categories()
	 * @model containment="true"
	 * @generated
	 */
	EList<Category> getCategories();

} // PapyrusConfiguration
