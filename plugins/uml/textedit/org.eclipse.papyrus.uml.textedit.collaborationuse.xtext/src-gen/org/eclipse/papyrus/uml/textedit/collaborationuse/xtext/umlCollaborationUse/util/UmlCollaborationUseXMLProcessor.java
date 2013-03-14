/**
 */
package org.eclipse.papyrus.uml.textedit.collaborationuse.xtext.umlCollaborationUse.util;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.xmi.util.XMLProcessor;

import org.eclipse.papyrus.uml.textedit.collaborationuse.xtext.umlCollaborationUse.UmlCollaborationUsePackage;

/**
 * This class contains helper methods to serialize and deserialize XML documents
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class UmlCollaborationUseXMLProcessor extends XMLProcessor
{

  /**
   * Public constructor to instantiate the helper.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UmlCollaborationUseXMLProcessor()
  {
    super((EPackage.Registry.INSTANCE));
    UmlCollaborationUsePackage.eINSTANCE.eClass();
  }
  
  /**
   * Register for "*" and "xml" file extensions the UmlCollaborationUseResourceFactoryImpl factory.
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
      registrations.put(XML_EXTENSION, new UmlCollaborationUseResourceFactoryImpl());
      registrations.put(STAR_EXTENSION, new UmlCollaborationUseResourceFactoryImpl());
    }
    return registrations;
  }

} //UmlCollaborationUseXMLProcessor
