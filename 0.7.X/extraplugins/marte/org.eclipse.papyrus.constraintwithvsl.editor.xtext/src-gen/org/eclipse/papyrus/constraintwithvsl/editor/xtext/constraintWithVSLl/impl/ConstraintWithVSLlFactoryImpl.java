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
package org.eclipse.papyrus.constraintwithvsl.editor.xtext.constraintWithVSLl.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.constraintwithvsl.editor.xtext.constraintWithVSLl.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ConstraintWithVSLlFactoryImpl extends EFactoryImpl implements ConstraintWithVSLlFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ConstraintWithVSLlFactory init()
  {
    try
    {
      ConstraintWithVSLlFactory theConstraintWithVSLlFactory = (ConstraintWithVSLlFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/papyrus/constraintwithvsl/editor/xtext/ConstraintWithVSLl"); 
      if (theConstraintWithVSLlFactory != null)
      {
        return theConstraintWithVSLlFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new ConstraintWithVSLlFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConstraintWithVSLlFactoryImpl()
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
      case ConstraintWithVSLlPackage.CONSTRAINT_RULE: return createConstraintRule();
      case ConstraintWithVSLlPackage.CONSTRAINT_SPECIFICATION: return createConstraintSpecification();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConstraintRule createConstraintRule()
  {
    ConstraintRuleImpl constraintRule = new ConstraintRuleImpl();
    return constraintRule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConstraintSpecification createConstraintSpecification()
  {
    ConstraintSpecificationImpl constraintSpecification = new ConstraintSpecificationImpl();
    return constraintSpecification;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConstraintWithVSLlPackage getConstraintWithVSLlPackage()
  {
    return (ConstraintWithVSLlPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static ConstraintWithVSLlPackage getPackage()
  {
    return ConstraintWithVSLlPackage.eINSTANCE;
  }

} //ConstraintWithVSLlFactoryImpl
