/**
 * 
 * Copyright (c) 2012 CEA LIST.
 * 
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 * 
 */
package org.eclipse.papyrus.sysml.efacet.extended_sysml.portandflows;

import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.sysml.efacet.extended_sysml.portandflows.PortandflowsFactory
 * @model kind="package"
 * @generated
 */
public interface PortandflowsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "portandflows"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/0.9.0/ExtendedSysML/PortAndFlows"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "PortAndFlows"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PortandflowsPackage eINSTANCE = org.eclipse.papyrus.sysml.efacet.extended_sysml.portandflows.impl.PortandflowsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.sysml.efacet.extended_sysml.portandflows.NAFlowDirection <em>NA Flow Direction</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.sysml.efacet.extended_sysml.portandflows.NAFlowDirection
	 * @see org.eclipse.papyrus.sysml.efacet.extended_sysml.portandflows.impl.PortandflowsPackageImpl#getNAFlowDirection()
	 * @generated
	 */
	int NA_FLOW_DIRECTION = 0;


	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.sysml.efacet.extended_sysml.portandflows.NAFlowDirection <em>NA Flow Direction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>NA Flow Direction</em>'.
	 * @see org.eclipse.papyrus.sysml.efacet.extended_sysml.portandflows.NAFlowDirection
	 * @generated
	 */
	EEnum getNAFlowDirection();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PortandflowsFactory getPortandflowsFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.sysml.efacet.extended_sysml.portandflows.NAFlowDirection <em>NA Flow Direction</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.sysml.efacet.extended_sysml.portandflows.NAFlowDirection
		 * @see org.eclipse.papyrus.sysml.efacet.extended_sysml.portandflows.impl.PortandflowsPackageImpl#getNAFlowDirection()
		 * @generated
		 */
		EEnum NA_FLOW_DIRECTION = eINSTANCE.getNAFlowDirection();

	}

} //PortandflowsPackage
