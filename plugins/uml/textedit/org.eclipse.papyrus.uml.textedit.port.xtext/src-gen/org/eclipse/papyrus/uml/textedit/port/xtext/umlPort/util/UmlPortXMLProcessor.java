/**
 */
package org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.util;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.xmi.util.XMLProcessor;

import org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.UmlPortPackage;

/**
 * This class contains helper methods to serialize and deserialize XML documents
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class UmlPortXMLProcessor extends XMLProcessor
{

  /**
   * Public constructor to instantiate the helper.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UmlPortXMLProcessor()
  {
    super((EPackage.Registry.INSTANCE));
    UmlPortPackage.eINSTANCE.eClass();
  }
  
  /**
   * Register for "*" and "xml" file extensions the UmlPortResourceFactoryImpl factory.
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
      registrations.put(XML_EXTENSION, new UmlPortResourceFactoryImpl());
      registrations.put(STAR_EXTENSION, new UmlPortResourceFactoryImpl());
    }
    return registrations;
  }

} //UmlPortXMLProcessor
