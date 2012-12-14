/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *  
 *****************************************************************************/
package org.eclipse.papyrus.sysml.efacet.extended_sysml.portandflows.impl;

import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.papyrus.sysml.efacet.extended_sysml.portandflows.NAFlowDirection;
import org.eclipse.papyrus.sysml.efacet.extended_sysml.portandflows.PortandflowsFactory;
import org.eclipse.papyrus.sysml.efacet.extended_sysml.portandflows.PortandflowsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PortandflowsPackageImpl extends EPackageImpl implements PortandflowsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum naFlowDirectionEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.papyrus.sysml.efacet.extended_sysml.portandflows.PortandflowsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private PortandflowsPackageImpl() {
		super(eNS_URI, PortandflowsFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link PortandflowsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static PortandflowsPackage init() {
		if (isInited) return (PortandflowsPackage)EPackage.Registry.INSTANCE.getEPackage(PortandflowsPackage.eNS_URI);

		// Obtain or create and register package
		PortandflowsPackageImpl thePortandflowsPackage = (PortandflowsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof PortandflowsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new PortandflowsPackageImpl());

		isInited = true;

		// Create package meta-data objects
		thePortandflowsPackage.createPackageContents();

		// Initialize created meta-data
		thePortandflowsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thePortandflowsPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(PortandflowsPackage.eNS_URI, thePortandflowsPackage);
		return thePortandflowsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getNAFlowDirection() {
		return naFlowDirectionEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PortandflowsFactory getPortandflowsFactory() {
		return (PortandflowsFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create enums
		naFlowDirectionEEnum = createEEnum(NA_FLOW_DIRECTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Initialize enums and add enum literals
		initEEnum(naFlowDirectionEEnum, NAFlowDirection.class, "NAFlowDirection");
		addEEnumLiteral(naFlowDirectionEEnum, NAFlowDirection.NA);

		// Create resource
		createResource(eNS_URI);
	}

} //PortandflowsPackageImpl
