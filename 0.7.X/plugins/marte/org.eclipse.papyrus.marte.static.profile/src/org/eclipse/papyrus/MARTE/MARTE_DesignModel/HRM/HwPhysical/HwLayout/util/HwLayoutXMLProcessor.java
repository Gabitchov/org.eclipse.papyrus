/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwPhysical.HwLayout.util;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.xmi.util.XMLProcessor;

import org.eclipse.papyrus.MARTE.MARTE_DesignModel.HRM.HwPhysical.HwLayout.HwLayoutPackage;

/**
 * This class contains helper methods to serialize and deserialize XML documents
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class HwLayoutXMLProcessor extends XMLProcessor {

	/**
	 * Public constructor to instantiate the helper.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HwLayoutXMLProcessor() {
		super((EPackage.Registry.INSTANCE));
		HwLayoutPackage.eINSTANCE.eClass();
	}
	
	/**
	 * Register for "*" and "xml" file extensions the HwLayoutResourceFactoryImpl factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Map<String, Resource.Factory> getRegistrations() {
		if (registrations == null) {
			super.getRegistrations();
			registrations.put(XML_EXTENSION, new HwLayoutResourceFactoryImpl());
			registrations.put(STAR_EXTENSION, new HwLayoutResourceFactoryImpl());
		}
		return registrations;
	}

} //HwLayoutXMLProcessor
