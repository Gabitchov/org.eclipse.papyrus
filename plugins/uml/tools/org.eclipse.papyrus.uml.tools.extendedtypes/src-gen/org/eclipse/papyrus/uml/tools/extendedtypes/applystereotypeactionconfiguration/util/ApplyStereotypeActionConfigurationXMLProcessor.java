/**
 */
package org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.util;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.xmi.util.XMLProcessor;

import org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.ApplyStereotypeActionConfigurationPackage;

/**
 * This class contains helper methods to serialize and deserialize XML documents
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ApplyStereotypeActionConfigurationXMLProcessor extends XMLProcessor {

	/**
	 * Public constructor to instantiate the helper.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ApplyStereotypeActionConfigurationXMLProcessor() {
		super((EPackage.Registry.INSTANCE));
		ApplyStereotypeActionConfigurationPackage.eINSTANCE.eClass();
	}
	
	/**
	 * Register for "*" and "xml" file extensions the ApplyStereotypeActionConfigurationResourceFactoryImpl factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Map<String, Resource.Factory> getRegistrations() {
		if (registrations == null) {
			super.getRegistrations();
			registrations.put(XML_EXTENSION, new ApplyStereotypeActionConfigurationResourceFactoryImpl());
			registrations.put(STAR_EXTENSION, new ApplyStereotypeActionConfigurationResourceFactoryImpl());
		}
		return registrations;
	}

} //ApplyStereotypeActionConfigurationXMLProcessor
