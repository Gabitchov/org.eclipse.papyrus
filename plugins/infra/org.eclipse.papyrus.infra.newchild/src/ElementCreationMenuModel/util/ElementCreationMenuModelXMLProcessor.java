/**
 */
package ElementCreationMenuModel.util;

import ElementCreationMenuModel.ElementCreationMenuModelPackage;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.xmi.util.XMLProcessor;

/**
 * This class contains helper methods to serialize and deserialize XML documents
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ElementCreationMenuModelXMLProcessor extends XMLProcessor {

	/**
	 * Public constructor to instantiate the helper.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementCreationMenuModelXMLProcessor() {
		super((EPackage.Registry.INSTANCE));
		ElementCreationMenuModelPackage.eINSTANCE.eClass();
	}
	
	/**
	 * Register for "*" and "xml" file extensions the ElementCreationMenuModelResourceFactoryImpl factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Map<String, Resource.Factory> getRegistrations() {
		if (registrations == null) {
			super.getRegistrations();
			registrations.put(XML_EXTENSION, new ElementCreationMenuModelResourceFactoryImpl());
			registrations.put(STAR_EXTENSION, new ElementCreationMenuModelResourceFactoryImpl());
		}
		return registrations;
	}

} //ElementCreationMenuModelXMLProcessor
