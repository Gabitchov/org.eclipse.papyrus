/**
 */
package org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.stereotypeApplicationWithVSL.util;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.xmi.util.XMLProcessor;

import org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.stereotypeApplicationWithVSL.StereotypeApplicationWithVSLPackage;

/**
 * This class contains helper methods to serialize and deserialize XML documents
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class StereotypeApplicationWithVSLXMLProcessor extends XMLProcessor
{

  /**
   * Public constructor to instantiate the helper.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StereotypeApplicationWithVSLXMLProcessor()
  {
    super((EPackage.Registry.INSTANCE));
    StereotypeApplicationWithVSLPackage.eINSTANCE.eClass();
  }
  
  /**
   * Register for "*" and "xml" file extensions the StereotypeApplicationWithVSLResourceFactoryImpl factory.
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
      registrations.put(XML_EXTENSION, new StereotypeApplicationWithVSLResourceFactoryImpl());
      registrations.put(STAR_EXTENSION, new StereotypeApplicationWithVSLResourceFactoryImpl());
    }
    return registrations;
  }

} //StereotypeApplicationWithVSLXMLProcessor
