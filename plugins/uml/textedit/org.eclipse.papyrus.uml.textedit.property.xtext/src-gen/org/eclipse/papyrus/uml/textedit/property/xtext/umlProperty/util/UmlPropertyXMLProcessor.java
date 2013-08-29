/**
 */
package org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.util;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.xmi.util.XMLProcessor;

import org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.UmlPropertyPackage;

/**
 * This class contains helper methods to serialize and deserialize XML documents
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class UmlPropertyXMLProcessor extends XMLProcessor
{

  /**
   * Public constructor to instantiate the helper.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UmlPropertyXMLProcessor()
  {
    super((EPackage.Registry.INSTANCE));
    UmlPropertyPackage.eINSTANCE.eClass();
  }
  
  /**
   * Register for "*" and "xml" file extensions the UmlPropertyResourceFactoryImpl factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected Map<String, Resource.Factory> getRegistrations()
  {
    if (registrations == null)
    {
      super.getRegistrations();
      registrations.put(XML_EXTENSION, new UmlPropertyResourceFactoryImpl());
      registrations.put(STAR_EXTENSION, new UmlPropertyResourceFactoryImpl());
    }
    return registrations;
  }

} //UmlPropertyXMLProcessor
