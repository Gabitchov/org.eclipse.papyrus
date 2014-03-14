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
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.configuration.ModelRule#getElement <em>Element</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.configuration.ModelRule#getStereotypes <em>Stereotypes</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.configuration.ModelRule#getMultiplicity <em>Multiplicity</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.configuration.ModelRule#getAutoSelectPath <em>Auto Select Path</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.viewpoints.configuration.ConfigurationPackage#getModelRule()
 * @model
 * @generated
 */
public interface ModelRule extends Rule {
	/**
	 * Returns the value of the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element</em>' reference.
	 * @see #setElement(EClass)
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.ConfigurationPackage#getModelRule_Element()
	 * @model
	 * @generated
	 */
	EClass getElement();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.viewpoints.configuration.ModelRule#getElement <em>Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element</em>' reference.
	 * @see #getElement()
	 * @generated
	 */
	void setElement(EClass value);

	/**
	 * Returns the value of the '<em><b>Stereotypes</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EClass}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stereotypes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stereotypes</em>' reference list.
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.ConfigurationPackage#getModelRule_Stereotypes()
	 * @model
	 * @generated
	 */
	EList<EClass> getStereotypes();

	/**
	 * Returns the value of the '<em><b>Multiplicity</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Multiplicity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Multiplicity</em>' attribute.
	 * @see #setMultiplicity(int)
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.ConfigurationPackage#getModelRule_Multiplicity()
	 * @model default="-1" required="true"
	 * @generated
	 */
	int getMultiplicity();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.viewpoints.configuration.ModelRule#getMultiplicity <em>Multiplicity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Multiplicity</em>' attribute.
	 * @see #getMultiplicity()
	 * @generated
	 */
	void setMultiplicity(int value);

	/**
	 * Returns the value of the '<em><b>Auto Select Path</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.viewpoints.configuration.PathElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Auto Select Path</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Auto Select Path</em>' containment reference list.
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.ConfigurationPackage#getModelRule_AutoSelectPath()
	 * @model containment="true"
	 * @generated
	 */
	EList<PathElement> getAutoSelectPath();

} // ModelRule
