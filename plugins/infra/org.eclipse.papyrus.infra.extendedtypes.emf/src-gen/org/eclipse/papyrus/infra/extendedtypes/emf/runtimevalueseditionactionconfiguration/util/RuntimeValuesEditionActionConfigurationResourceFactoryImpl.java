/**
 */
package org.eclipse.papyrus.infra.extendedtypes.emf.runtimevalueseditionactionconfiguration.util;

import org.eclipse.emf.common.util.URI;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl;

/**
 * <!-- begin-user-doc -->
 * The <b>Resource Factory</b> associated with the package.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.infra.extendedtypes.emf.runtimevalueseditionactionconfiguration.util.RuntimeValuesEditionActionConfigurationResourceImpl
 * @generated
 */
public class RuntimeValuesEditionActionConfigurationResourceFactoryImpl extends ResourceFactoryImpl {
	/**
	 * Creates an instance of the resource factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuntimeValuesEditionActionConfigurationResourceFactoryImpl() {
		super();
	}

	/**
	 * Creates an instance of the resource.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Resource createResource(URI uri) {
		Resource result = new RuntimeValuesEditionActionConfigurationResourceImpl(uri);
		return result;
	}

} //RuntimeValuesEditionActionConfigurationResourceFactoryImpl
