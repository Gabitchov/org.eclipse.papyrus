/**
 */
package org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.util;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.xmi.util.XMLProcessor;

import org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.UmlCommonPackage;

/**
 * This class contains helper methods to serialize and deserialize XML documents
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class UmlCommonXMLProcessor extends XMLProcessor
{

  /**
   * Public constructor to instantiate the helper.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UmlCommonXMLProcessor()
  {
    super((EPackage.Registry.INSTANCE));
    UmlCommonPackage.eINSTANCE.eClass();
  }
  
  /**
   * Register for "*" and "xml" file extensions the UmlCommonResourceFactoryImpl factory.
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
      registrations.put(XML_EXTENSION, new UmlCommonResourceFactoryImpl());
      registrations.put(STAR_EXTENSION, new UmlCommonResourceFactoryImpl());
    }
    return registrations;
  }

} //UmlCommonXMLProcessor
