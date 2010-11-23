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
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.papyrus.constraintwithvsl.editor.xtext.constraintWithVSLl.ConstraintRule;
import org.eclipse.papyrus.constraintwithvsl.editor.xtext.constraintWithVSLl.ConstraintSpecification;
import org.eclipse.papyrus.constraintwithvsl.editor.xtext.constraintWithVSLl.ConstraintWithVSLlFactory;
import org.eclipse.papyrus.constraintwithvsl.editor.xtext.constraintWithVSLl.ConstraintWithVSLlPackage;

import org.eclipse.papyrus.marte.vsl.vSL.VSLPackage;

import org.eclipse.uml2.uml.UMLPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ConstraintWithVSLlPackageImpl extends EPackageImpl implements ConstraintWithVSLlPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass constraintRuleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass constraintSpecificationEClass = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see org.eclipse.papyrus.constraintwithvsl.editor.xtext.constraintWithVSLl.ConstraintWithVSLlPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private ConstraintWithVSLlPackageImpl()
  {
    super(eNS_URI, ConstraintWithVSLlFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link ConstraintWithVSLlPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static ConstraintWithVSLlPackage init()
  {
    if (isInited) return (ConstraintWithVSLlPackage)EPackage.Registry.INSTANCE.getEPackage(ConstraintWithVSLlPackage.eNS_URI);

    // Obtain or create and register package
    ConstraintWithVSLlPackageImpl theConstraintWithVSLlPackage = (ConstraintWithVSLlPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ConstraintWithVSLlPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ConstraintWithVSLlPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    VSLPackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theConstraintWithVSLlPackage.createPackageContents();

    // Initialize created meta-data
    theConstraintWithVSLlPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theConstraintWithVSLlPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(ConstraintWithVSLlPackage.eNS_URI, theConstraintWithVSLlPackage);
    return theConstraintWithVSLlPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getConstraintRule()
  {
    return constraintRuleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConstraintRule_Specification()
  {
    return (EReference)constraintRuleEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getConstraintSpecification()
  {
    return constraintSpecificationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConstraintSpecification_Expression()
  {
    return (EReference)constraintSpecificationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConstraintWithVSLlFactory getConstraintWithVSLlFactory()
  {
    return (ConstraintWithVSLlFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    constraintRuleEClass = createEClass(CONSTRAINT_RULE);
    createEReference(constraintRuleEClass, CONSTRAINT_RULE__SPECIFICATION);

    constraintSpecificationEClass = createEClass(CONSTRAINT_SPECIFICATION);
    createEReference(constraintSpecificationEClass, CONSTRAINT_SPECIFICATION__EXPRESSION);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Obtain other dependent packages
    UMLPackage theUMLPackage = (UMLPackage)EPackage.Registry.INSTANCE.getEPackage(UMLPackage.eNS_URI);
    VSLPackage theVSLPackage = (VSLPackage)EPackage.Registry.INSTANCE.getEPackage(VSLPackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes

    // Initialize classes and features; add operations and parameters
    initEClass(constraintRuleEClass, ConstraintRule.class, "ConstraintRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getConstraintRule_Specification(), this.getConstraintSpecification(), null, "specification", null, 0, 1, ConstraintRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    addEOperation(constraintRuleEClass, theUMLPackage.getType(), "getExpectedType", 0, 1, IS_UNIQUE, IS_ORDERED);

    addEOperation(constraintRuleEClass, theUMLPackage.getElement(), "getContextElement", 0, 1, IS_UNIQUE, IS_ORDERED);

    initEClass(constraintSpecificationEClass, ConstraintSpecification.class, "ConstraintSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getConstraintSpecification_Expression(), theVSLPackage.getExpression(), null, "expression", null, 0, 1, ConstraintSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    addEOperation(constraintSpecificationEClass, theUMLPackage.getType(), "getExpectedType", 0, 1, IS_UNIQUE, IS_ORDERED);

    addEOperation(constraintSpecificationEClass, theUMLPackage.getElement(), "getContextElement", 0, 1, IS_UNIQUE, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //ConstraintWithVSLlPackageImpl
