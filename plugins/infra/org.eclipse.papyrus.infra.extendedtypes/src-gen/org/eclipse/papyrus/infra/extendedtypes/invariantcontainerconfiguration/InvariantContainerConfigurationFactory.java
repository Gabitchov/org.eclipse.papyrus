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
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.infra.extendedtypes.invariantcontainerconfiguration;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.infra.extendedtypes.invariantcontainerconfiguration.InvariantContainerConfigurationPackage
 * @generated
 */
public interface InvariantContainerConfigurationFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	InvariantContainerConfigurationFactory eINSTANCE = org.eclipse.papyrus.infra.extendedtypes.invariantcontainerconfiguration.impl.InvariantContainerConfigurationFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Invariant Container Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Invariant Container Configuration</em>'.
	 * @generated
	 */
	InvariantContainerConfiguration createInvariantContainerConfiguration();

	/**
	 * Returns a new object of class '<em>Hierarchy Permission</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Hierarchy Permission</em>'.
	 * @generated
	 */
	HierarchyPermission createHierarchyPermission();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	InvariantContainerConfigurationPackage getInvariantContainerConfigurationPackage();

} //InvariantContainerConfigurationFactory
