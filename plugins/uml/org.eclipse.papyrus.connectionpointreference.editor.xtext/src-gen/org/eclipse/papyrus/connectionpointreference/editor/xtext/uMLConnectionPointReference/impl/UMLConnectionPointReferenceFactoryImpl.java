/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.connectionpointreference.editor.xtext.uMLConnectionPointReference.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.connectionpointreference.editor.xtext.uMLConnectionPointReference.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UMLConnectionPointReferenceFactoryImpl extends EFactoryImpl implements UMLConnectionPointReferenceFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static UMLConnectionPointReferenceFactory init()
  {
    try
    {
      UMLConnectionPointReferenceFactory theUMLConnectionPointReferenceFactory = (UMLConnectionPointReferenceFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/papyrus/connectionpointreference/editor/xtext/UMLConnectionPointReference"); 
      if (theUMLConnectionPointReferenceFactory != null)
      {
        return theUMLConnectionPointReferenceFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new UMLConnectionPointReferenceFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UMLConnectionPointReferenceFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case UMLConnectionPointReferencePackage.CONNECTION_POINT_REFERENCE_RULE: return createConnectionPointReferenceRule();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConnectionPointReferenceRule createConnectionPointReferenceRule()
  {
    ConnectionPointReferenceRuleImpl connectionPointReferenceRule = new ConnectionPointReferenceRuleImpl();
    return connectionPointReferenceRule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UMLConnectionPointReferencePackage getUMLConnectionPointReferencePackage()
  {
    return (UMLConnectionPointReferencePackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static UMLConnectionPointReferencePackage getPackage()
  {
    return UMLConnectionPointReferencePackage.eINSTANCE;
  }

} //UMLConnectionPointReferenceFactoryImpl
