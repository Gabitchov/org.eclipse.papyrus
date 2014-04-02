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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Papyrus Diagram</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusDiagram#getCustomPalette <em>Custom Palette</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusDiagram#getCustomStyle <em>Custom Style</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusDiagram#getChildRules <em>Child Rules</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusDiagram#getPaletteRules <em>Palette Rules</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.viewpoints.configuration.ConfigurationPackage#getPapyrusDiagram()
 * @model
 * @generated
 */
public interface PapyrusDiagram extends PapyrusView {
	/**
	 * Returns the value of the '<em><b>Custom Palette</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Custom Palette</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Custom Palette</em>' attribute.
	 * @see #setCustomPalette(String)
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.ConfigurationPackage#getPapyrusDiagram_CustomPalette()
	 * @model
	 * @generated
	 */
	String getCustomPalette();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusDiagram#getCustomPalette <em>Custom Palette</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Custom Palette</em>' attribute.
	 * @see #getCustomPalette()
	 * @generated
	 */
	void setCustomPalette(String value);

	/**
	 * Returns the value of the '<em><b>Custom Style</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Custom Style</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Custom Style</em>' attribute.
	 * @see #setCustomStyle(String)
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.ConfigurationPackage#getPapyrusDiagram_CustomStyle()
	 * @model
	 * @generated
	 */
	String getCustomStyle();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusDiagram#getCustomStyle <em>Custom Style</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Custom Style</em>' attribute.
	 * @see #getCustomStyle()
	 * @generated
	 */
	void setCustomStyle(String value);

	/**
	 * Returns the value of the '<em><b>Child Rules</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.viewpoints.configuration.ChildRule}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * These rules determine which model elements can be added as child of the origin through this diagram
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Child Rules</em>' containment reference list.
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.ConfigurationPackage#getPapyrusDiagram_ChildRules()
	 * @model containment="true"
	 * @generated
	 */
	EList<ChildRule> getChildRules();

	/**
	 * Returns the value of the '<em><b>Palette Rules</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.viewpoints.configuration.PaletteRule}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * These rules determine which palette elements should be available for this diagram
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Palette Rules</em>' containment reference list.
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.ConfigurationPackage#getPapyrusDiagram_PaletteRules()
	 * @model containment="true"
	 * @generated
	 */
	EList<PaletteRule> getPaletteRules();

} // PapyrusDiagram
