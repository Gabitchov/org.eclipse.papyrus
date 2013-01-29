/**
 */
package org.eclipse.papyrus.marte.vsl.vSL.util;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.xmi.util.XMLProcessor;

import org.eclipse.papyrus.marte.vsl.vSL.VSLPackage;

/**
 * This class contains helper methods to serialize and deserialize XML documents
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class VSLXMLProcessor extends XMLProcessor
{

  /**
   * Public constructor to instantiate the helper.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VSLXMLProcessor()
  {
    super((EPackage.Registry.INSTANCE));
    VSLPackage.eINSTANCE.eClass();
  }
  
  /**
   * Register for "*" and "xml" file extensions the VSLResourceFactoryImpl factory.
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
      registrations.put(XML_EXTENSION, new VSLResourceFactoryImpl());
      registrations.put(STAR_EXTENSION, new VSLResourceFactoryImpl());
    }
    return registrations;
  }

} //VSLXMLProcessor
