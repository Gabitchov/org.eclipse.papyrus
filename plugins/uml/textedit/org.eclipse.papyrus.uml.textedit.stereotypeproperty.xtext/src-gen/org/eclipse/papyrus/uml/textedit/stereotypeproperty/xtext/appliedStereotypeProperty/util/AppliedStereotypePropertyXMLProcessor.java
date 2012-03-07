/**
 */
package org.eclipse.papyrus.uml.textedit.stereotypeproperty.xtext.appliedStereotypeProperty.util;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.xmi.util.XMLProcessor;

import org.eclipse.papyrus.uml.textedit.stereotypeproperty.xtext.appliedStereotypeProperty.AppliedStereotypePropertyPackage;

/**
 * This class contains helper methods to serialize and deserialize XML documents
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class AppliedStereotypePropertyXMLProcessor extends XMLProcessor
{

  /**
   * Public constructor to instantiate the helper.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AppliedStereotypePropertyXMLProcessor()
  {
    super((EPackage.Registry.INSTANCE));
    AppliedStereotypePropertyPackage.eINSTANCE.eClass();
  }
  
  /**
   * Register for "*" and "xml" file extensions the AppliedStereotypePropertyResourceFactoryImpl factory.
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
      registrations.put(XML_EXTENSION, new AppliedStereotypePropertyResourceFactoryImpl());
      registrations.put(STAR_EXTENSION, new AppliedStereotypePropertyResourceFactoryImpl());
    }
    return registrations;
  }

} //AppliedStereotypePropertyXMLProcessor
