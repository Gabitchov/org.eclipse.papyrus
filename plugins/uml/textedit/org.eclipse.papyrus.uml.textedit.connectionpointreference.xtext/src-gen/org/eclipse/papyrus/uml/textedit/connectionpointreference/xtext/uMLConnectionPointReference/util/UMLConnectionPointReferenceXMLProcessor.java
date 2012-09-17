/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.uMLConnectionPointReference.util;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.util.XMLProcessor;
import org.eclipse.papyrus.uml.textedit.connectionpointreference.xtext.uMLConnectionPointReference.UMLConnectionPointReferencePackage;

/**
 * This class contains helper methods to serialize and deserialize XML documents
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class UMLConnectionPointReferenceXMLProcessor extends XMLProcessor
{

  /**
   * Public constructor to instantiate the helper.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UMLConnectionPointReferenceXMLProcessor()
  {
    super((EPackage.Registry.INSTANCE));
    UMLConnectionPointReferencePackage.eINSTANCE.eClass();
  }
  
  /**
   * Register for "*" and "xml" file extensions the UMLConnectionPointReferenceResourceFactoryImpl factory.
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
      registrations.put(XML_EXTENSION, new UMLConnectionPointReferenceResourceFactoryImpl());
      registrations.put(STAR_EXTENSION, new UMLConnectionPointReferenceResourceFactoryImpl());
    }
    return registrations;
  }

} //UMLConnectionPointReferenceXMLProcessor
