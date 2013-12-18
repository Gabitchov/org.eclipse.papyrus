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
package org.eclipse.papyrus.infra.extendedtypes.invariantcontainerconfiguration.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.infra.extendedtypes.invariantcontainerconfiguration.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class InvariantContainerConfigurationFactoryImpl extends EFactoryImpl implements InvariantContainerConfigurationFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static InvariantContainerConfigurationFactory init() {
		try {
			InvariantContainerConfigurationFactory theInvariantContainerConfigurationFactory = (InvariantContainerConfigurationFactory)EPackage.Registry.INSTANCE.getEFactory(InvariantContainerConfigurationPackage.eNS_URI);
			if (theInvariantContainerConfigurationFactory != null) {
				return theInvariantContainerConfigurationFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new InvariantContainerConfigurationFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InvariantContainerConfigurationFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case InvariantContainerConfigurationPackage.INVARIANT_CONTAINER_CONFIGURATION: return createInvariantContainerConfiguration();
			case InvariantContainerConfigurationPackage.HIERARCHY_PERMISSION: return createHierarchyPermission();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InvariantContainerConfiguration createInvariantContainerConfiguration() {
		InvariantContainerConfigurationImpl invariantContainerConfiguration = new InvariantContainerConfigurationImpl();
		return invariantContainerConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HierarchyPermission createHierarchyPermission() {
		HierarchyPermissionImpl hierarchyPermission = new HierarchyPermissionImpl();
		return hierarchyPermission;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InvariantContainerConfigurationPackage getInvariantContainerConfigurationPackage() {
		return (InvariantContainerConfigurationPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static InvariantContainerConfigurationPackage getPackage() {
		return InvariantContainerConfigurationPackage.eINSTANCE;
	}

} //InvariantContainerConfigurationFactoryImpl
