/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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
package org.eclipse.papyrus.uml.textedit.operation.xtext.operation.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.papyrus.uml.alf.alf.AlfPackage;

import org.eclipse.papyrus.uml.textedit.operation.xtext.operation.FormalParameter;
import org.eclipse.papyrus.uml.textedit.operation.xtext.operation.FormalParameterList;
import org.eclipse.papyrus.uml.textedit.operation.xtext.operation.FormalParameters;
import org.eclipse.papyrus.uml.textedit.operation.xtext.operation.Multiplicity;
import org.eclipse.papyrus.uml.textedit.operation.xtext.operation.MultiplicityRange;
import org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationDeclaration;
import org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationDefinitionOrStub;
import org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationFactory;
import org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationPackage;
import org.eclipse.papyrus.uml.textedit.operation.xtext.operation.ParameterDirection;
import org.eclipse.papyrus.uml.textedit.operation.xtext.operation.RedefinitionClause;
import org.eclipse.papyrus.uml.textedit.operation.xtext.operation.TypeName;
import org.eclipse.papyrus.uml.textedit.operation.xtext.operation.TypePart;
import org.eclipse.papyrus.uml.textedit.operation.xtext.operation.VisibilityIndicator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class OperationPackageImpl extends EPackageImpl implements OperationPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass operationDefinitionOrStubEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass operationDeclarationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass formalParametersEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass formalParameterListEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass formalParameterEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typePartEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass multiplicityEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass multiplicityRangeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass numbeR_LITERAL_WITHOUT_SUFFIXEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass integeR_LITERAL_WITHOUT_SUFFIXEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass unlimiteD_LITERAL_WITHOUT_SUFFIXEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeNameEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass redefinitionClauseEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum visibilityIndicatorEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum parameterDirectionEEnum = null;

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
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private OperationPackageImpl()
  {
    super(eNS_URI, OperationFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link OperationPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static OperationPackage init()
  {
    if (isInited) return (OperationPackage)EPackage.Registry.INSTANCE.getEPackage(OperationPackage.eNS_URI);

    // Obtain or create and register package
    OperationPackageImpl theOperationPackage = (OperationPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof OperationPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new OperationPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    EcorePackage.eINSTANCE.eClass();
    AlfPackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theOperationPackage.createPackageContents();

    // Initialize created meta-data
    theOperationPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theOperationPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(OperationPackage.eNS_URI, theOperationPackage);
    return theOperationPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOperationDefinitionOrStub()
  {
    return operationDefinitionOrStubEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOperationDefinitionOrStub_Declaration()
  {
    return (EReference)operationDefinitionOrStubEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOperationDefinitionOrStub_Body()
  {
    return (EReference)operationDefinitionOrStubEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOperationDeclaration()
  {
    return operationDeclarationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getOperationDeclaration_IsConstructor()
  {
    return (EAttribute)operationDeclarationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getOperationDeclaration_IsDestructor()
  {
    return (EAttribute)operationDeclarationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getOperationDeclaration_VisibilityIndicator()
  {
    return (EAttribute)operationDeclarationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getOperationDeclaration_Abstract()
  {
    return (EAttribute)operationDeclarationEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getOperationDeclaration_Name()
  {
    return (EAttribute)operationDeclarationEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOperationDeclaration_FormalParameters()
  {
    return (EReference)operationDeclarationEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOperationDeclaration_ReturnType()
  {
    return (EReference)operationDeclarationEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOperationDeclaration_Redefinition()
  {
    return (EReference)operationDeclarationEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFormalParameters()
  {
    return formalParametersEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFormalParameters_FormalParameterList()
  {
    return (EReference)formalParametersEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFormalParameterList()
  {
    return formalParameterListEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFormalParameterList_FormalParameter()
  {
    return (EReference)formalParameterListEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFormalParameter()
  {
    return formalParameterEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFormalParameter_Direction()
  {
    return (EAttribute)formalParameterEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFormalParameter_Name()
  {
    return (EAttribute)formalParameterEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFormalParameter_Type()
  {
    return (EReference)formalParameterEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTypePart()
  {
    return typePartEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTypePart_TypeName()
  {
    return (EReference)typePartEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTypePart_Multiplicity()
  {
    return (EReference)typePartEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMultiplicity()
  {
    return multiplicityEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMultiplicity_Range()
  {
    return (EReference)multiplicityEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMultiplicity_Ordered()
  {
    return (EAttribute)multiplicityEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMultiplicity_NonUnique()
  {
    return (EAttribute)multiplicityEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMultiplicity_Sequence()
  {
    return (EAttribute)multiplicityEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMultiplicityRange()
  {
    return multiplicityRangeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMultiplicityRange_Lower()
  {
    return (EReference)multiplicityRangeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMultiplicityRange_Upper()
  {
    return (EReference)multiplicityRangeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNUMBER_LITERAL_WITHOUT_SUFFIX()
  {
    return numbeR_LITERAL_WITHOUT_SUFFIXEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getNUMBER_LITERAL_WITHOUT_SUFFIX_Value()
  {
    return (EAttribute)numbeR_LITERAL_WITHOUT_SUFFIXEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getINTEGER_LITERAL_WITHOUT_SUFFIX()
  {
    return integeR_LITERAL_WITHOUT_SUFFIXEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUNLIMITED_LITERAL_WITHOUT_SUFFIX()
  {
    return unlimiteD_LITERAL_WITHOUT_SUFFIXEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTypeName()
  {
    return typeNameEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTypeName_QualifiedName()
  {
    return (EReference)typeNameEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRedefinitionClause()
  {
    return redefinitionClauseEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRedefinitionClause_RedefinedOperations()
  {
    return (EReference)redefinitionClauseEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getVisibilityIndicator()
  {
    return visibilityIndicatorEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getParameterDirection()
  {
    return parameterDirectionEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OperationFactory getOperationFactory()
  {
    return (OperationFactory)getEFactoryInstance();
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
    operationDefinitionOrStubEClass = createEClass(OPERATION_DEFINITION_OR_STUB);
    createEReference(operationDefinitionOrStubEClass, OPERATION_DEFINITION_OR_STUB__DECLARATION);
    createEReference(operationDefinitionOrStubEClass, OPERATION_DEFINITION_OR_STUB__BODY);

    operationDeclarationEClass = createEClass(OPERATION_DECLARATION);
    createEAttribute(operationDeclarationEClass, OPERATION_DECLARATION__IS_CONSTRUCTOR);
    createEAttribute(operationDeclarationEClass, OPERATION_DECLARATION__IS_DESTRUCTOR);
    createEAttribute(operationDeclarationEClass, OPERATION_DECLARATION__VISIBILITY_INDICATOR);
    createEAttribute(operationDeclarationEClass, OPERATION_DECLARATION__ABSTRACT);
    createEAttribute(operationDeclarationEClass, OPERATION_DECLARATION__NAME);
    createEReference(operationDeclarationEClass, OPERATION_DECLARATION__FORMAL_PARAMETERS);
    createEReference(operationDeclarationEClass, OPERATION_DECLARATION__RETURN_TYPE);
    createEReference(operationDeclarationEClass, OPERATION_DECLARATION__REDEFINITION);

    formalParametersEClass = createEClass(FORMAL_PARAMETERS);
    createEReference(formalParametersEClass, FORMAL_PARAMETERS__FORMAL_PARAMETER_LIST);

    formalParameterListEClass = createEClass(FORMAL_PARAMETER_LIST);
    createEReference(formalParameterListEClass, FORMAL_PARAMETER_LIST__FORMAL_PARAMETER);

    formalParameterEClass = createEClass(FORMAL_PARAMETER);
    createEAttribute(formalParameterEClass, FORMAL_PARAMETER__DIRECTION);
    createEAttribute(formalParameterEClass, FORMAL_PARAMETER__NAME);
    createEReference(formalParameterEClass, FORMAL_PARAMETER__TYPE);

    typePartEClass = createEClass(TYPE_PART);
    createEReference(typePartEClass, TYPE_PART__TYPE_NAME);
    createEReference(typePartEClass, TYPE_PART__MULTIPLICITY);

    multiplicityEClass = createEClass(MULTIPLICITY);
    createEReference(multiplicityEClass, MULTIPLICITY__RANGE);
    createEAttribute(multiplicityEClass, MULTIPLICITY__ORDERED);
    createEAttribute(multiplicityEClass, MULTIPLICITY__NON_UNIQUE);
    createEAttribute(multiplicityEClass, MULTIPLICITY__SEQUENCE);

    multiplicityRangeEClass = createEClass(MULTIPLICITY_RANGE);
    createEReference(multiplicityRangeEClass, MULTIPLICITY_RANGE__LOWER);
    createEReference(multiplicityRangeEClass, MULTIPLICITY_RANGE__UPPER);

    numbeR_LITERAL_WITHOUT_SUFFIXEClass = createEClass(NUMBER_LITERAL_WITHOUT_SUFFIX);
    createEAttribute(numbeR_LITERAL_WITHOUT_SUFFIXEClass, NUMBER_LITERAL_WITHOUT_SUFFIX__VALUE);

    integeR_LITERAL_WITHOUT_SUFFIXEClass = createEClass(INTEGER_LITERAL_WITHOUT_SUFFIX);

    unlimiteD_LITERAL_WITHOUT_SUFFIXEClass = createEClass(UNLIMITED_LITERAL_WITHOUT_SUFFIX);

    typeNameEClass = createEClass(TYPE_NAME);
    createEReference(typeNameEClass, TYPE_NAME__QUALIFIED_NAME);

    redefinitionClauseEClass = createEClass(REDEFINITION_CLAUSE);
    createEReference(redefinitionClauseEClass, REDEFINITION_CLAUSE__REDEFINED_OPERATIONS);

    // Create enums
    visibilityIndicatorEEnum = createEEnum(VISIBILITY_INDICATOR);
    parameterDirectionEEnum = createEEnum(PARAMETER_DIRECTION);
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
    AlfPackage theAlfPackage = (AlfPackage)EPackage.Registry.INSTANCE.getEPackage(AlfPackage.eNS_URI);
    EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    integeR_LITERAL_WITHOUT_SUFFIXEClass.getESuperTypes().add(this.getNUMBER_LITERAL_WITHOUT_SUFFIX());
    unlimiteD_LITERAL_WITHOUT_SUFFIXEClass.getESuperTypes().add(this.getNUMBER_LITERAL_WITHOUT_SUFFIX());

    // Initialize classes and features; add operations and parameters
    initEClass(operationDefinitionOrStubEClass, OperationDefinitionOrStub.class, "OperationDefinitionOrStub", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getOperationDefinitionOrStub_Declaration(), this.getOperationDeclaration(), null, "declaration", null, 0, 1, OperationDefinitionOrStub.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getOperationDefinitionOrStub_Body(), theAlfPackage.getBlock(), null, "body", null, 0, 1, OperationDefinitionOrStub.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(operationDeclarationEClass, OperationDeclaration.class, "OperationDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getOperationDeclaration_IsConstructor(), theEcorePackage.getEBoolean(), "isConstructor", null, 0, 1, OperationDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getOperationDeclaration_IsDestructor(), theEcorePackage.getEBoolean(), "isDestructor", null, 0, 1, OperationDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getOperationDeclaration_VisibilityIndicator(), this.getVisibilityIndicator(), "visibilityIndicator", null, 0, 1, OperationDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getOperationDeclaration_Abstract(), theEcorePackage.getEBoolean(), "abstract", null, 0, 1, OperationDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getOperationDeclaration_Name(), theEcorePackage.getEString(), "name", null, 0, 1, OperationDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getOperationDeclaration_FormalParameters(), this.getFormalParameters(), null, "formalParameters", null, 0, 1, OperationDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getOperationDeclaration_ReturnType(), this.getTypePart(), null, "returnType", null, 0, 1, OperationDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getOperationDeclaration_Redefinition(), this.getRedefinitionClause(), null, "redefinition", null, 0, 1, OperationDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(formalParametersEClass, FormalParameters.class, "FormalParameters", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getFormalParameters_FormalParameterList(), this.getFormalParameterList(), null, "formalParameterList", null, 0, 1, FormalParameters.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(formalParameterListEClass, FormalParameterList.class, "FormalParameterList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getFormalParameterList_FormalParameter(), this.getFormalParameter(), null, "formalParameter", null, 0, -1, FormalParameterList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(formalParameterEClass, FormalParameter.class, "FormalParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getFormalParameter_Direction(), this.getParameterDirection(), "direction", null, 0, 1, FormalParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getFormalParameter_Name(), theEcorePackage.getEString(), "name", null, 0, 1, FormalParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFormalParameter_Type(), this.getTypePart(), null, "type", null, 0, 1, FormalParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(typePartEClass, TypePart.class, "TypePart", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTypePart_TypeName(), this.getTypeName(), null, "typeName", null, 0, 1, TypePart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTypePart_Multiplicity(), this.getMultiplicity(), null, "multiplicity", null, 0, 1, TypePart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(multiplicityEClass, Multiplicity.class, "Multiplicity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMultiplicity_Range(), this.getMultiplicityRange(), null, "range", null, 0, 1, Multiplicity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMultiplicity_Ordered(), theEcorePackage.getEBoolean(), "ordered", null, 0, 1, Multiplicity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMultiplicity_NonUnique(), theEcorePackage.getEBoolean(), "nonUnique", null, 0, 1, Multiplicity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMultiplicity_Sequence(), theEcorePackage.getEBoolean(), "sequence", null, 0, 1, Multiplicity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(multiplicityRangeEClass, MultiplicityRange.class, "MultiplicityRange", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMultiplicityRange_Lower(), this.getNUMBER_LITERAL_WITHOUT_SUFFIX(), null, "lower", null, 0, 1, MultiplicityRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMultiplicityRange_Upper(), this.getNUMBER_LITERAL_WITHOUT_SUFFIX(), null, "upper", null, 0, 1, MultiplicityRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(numbeR_LITERAL_WITHOUT_SUFFIXEClass, org.eclipse.papyrus.uml.textedit.operation.xtext.operation.NUMBER_LITERAL_WITHOUT_SUFFIX.class, "NUMBER_LITERAL_WITHOUT_SUFFIX", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getNUMBER_LITERAL_WITHOUT_SUFFIX_Value(), theEcorePackage.getEString(), "value", null, 0, 1, org.eclipse.papyrus.uml.textedit.operation.xtext.operation.NUMBER_LITERAL_WITHOUT_SUFFIX.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(integeR_LITERAL_WITHOUT_SUFFIXEClass, org.eclipse.papyrus.uml.textedit.operation.xtext.operation.INTEGER_LITERAL_WITHOUT_SUFFIX.class, "INTEGER_LITERAL_WITHOUT_SUFFIX", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(unlimiteD_LITERAL_WITHOUT_SUFFIXEClass, org.eclipse.papyrus.uml.textedit.operation.xtext.operation.UNLIMITED_LITERAL_WITHOUT_SUFFIX.class, "UNLIMITED_LITERAL_WITHOUT_SUFFIX", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(typeNameEClass, TypeName.class, "TypeName", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTypeName_QualifiedName(), theAlfPackage.getQualifiedNameWithBinding(), null, "qualifiedName", null, 0, 1, TypeName.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(redefinitionClauseEClass, RedefinitionClause.class, "RedefinitionClause", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRedefinitionClause_RedefinedOperations(), theAlfPackage.getQualifiedNameList(), null, "redefinedOperations", null, 0, 1, RedefinitionClause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Initialize enums and add enum literals
    initEEnum(visibilityIndicatorEEnum, VisibilityIndicator.class, "VisibilityIndicator");
    addEEnumLiteral(visibilityIndicatorEEnum, VisibilityIndicator.PUBLIC);
    addEEnumLiteral(visibilityIndicatorEEnum, VisibilityIndicator.PRIVATE);
    addEEnumLiteral(visibilityIndicatorEEnum, VisibilityIndicator.PROTECTED);

    initEEnum(parameterDirectionEEnum, ParameterDirection.class, "ParameterDirection");
    addEEnumLiteral(parameterDirectionEEnum, ParameterDirection.IN);
    addEEnumLiteral(parameterDirectionEEnum, ParameterDirection.OUT);
    addEEnumLiteral(parameterDirectionEEnum, ParameterDirection.INOUT);

    // Create resource
    createResource(eNS_URI);
  }

} //OperationPackageImpl
