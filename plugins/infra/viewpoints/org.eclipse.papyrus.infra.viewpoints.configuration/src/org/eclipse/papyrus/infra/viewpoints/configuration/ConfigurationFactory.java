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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.infra.viewpoints.configuration.ConfigurationPackage
 * @generated
 */
public interface ConfigurationFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ConfigurationFactory eINSTANCE = org.eclipse.papyrus.infra.viewpoints.configuration.impl.ConfigurationFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Papyrus Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Papyrus Configuration</em>'.
	 * @generated
	 */
	PapyrusConfiguration createPapyrusConfiguration();

	/**
	 * Returns a new object of class '<em>Papyrus Viewpoint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Papyrus Viewpoint</em>'.
	 * @generated
	 */
	PapyrusViewpoint createPapyrusViewpoint();

	/**
	 * Returns a new object of class '<em>Papyrus View</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Papyrus View</em>'.
	 * @generated
	 */
	PapyrusView createPapyrusView();

	/**
	 * Returns a new object of class '<em>Papyrus Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Papyrus Diagram</em>'.
	 * @generated
	 */
	PapyrusDiagram createPapyrusDiagram();

	/**
	 * Returns a new object of class '<em>Papyrus Sync Table</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Papyrus Sync Table</em>'.
	 * @generated
	 */
	PapyrusSyncTable createPapyrusSyncTable();

	/**
	 * Returns a new object of class '<em>Papyrus Table</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Papyrus Table</em>'.
	 * @generated
	 */
	PapyrusTable createPapyrusTable();

	/**
	 * Returns a new object of class '<em>Model Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model Rule</em>'.
	 * @generated
	 */
	ModelRule createModelRule();

	/**
	 * Returns a new object of class '<em>Owning Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Owning Rule</em>'.
	 * @generated
	 */
	OwningRule createOwningRule();

	/**
	 * Returns a new object of class '<em>Child Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Child Rule</em>'.
	 * @generated
	 */
	ChildRule createChildRule();

	/**
	 * Returns a new object of class '<em>Palette Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Palette Rule</em>'.
	 * @generated
	 */
	PaletteRule createPaletteRule();

	/**
	 * Returns a new object of class '<em>Path Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Path Element</em>'.
	 * @generated
	 */
	PathElement createPathElement();

	/**
	 * Returns a new object of class '<em>Category</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Category</em>'.
	 * @generated
	 */
	Category createCategory();

	/**
	 * Returns a new object of class '<em>Element Import</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Element Import</em>'.
	 * @generated
	 */
	ElementImport createElementImport();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ConfigurationPackage getConfigurationPackage();

} //ConfigurationFactory
