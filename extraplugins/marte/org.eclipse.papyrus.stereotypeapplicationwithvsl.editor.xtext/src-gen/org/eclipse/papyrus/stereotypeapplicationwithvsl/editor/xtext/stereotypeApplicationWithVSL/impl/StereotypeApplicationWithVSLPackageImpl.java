/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.papyrus.marte.vsl.vSL.VSLPackage;

import org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.ExpressionValueRule;
import org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.StereotypeApplicationRule;
import org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.StereotypeApplicationWithVSLFactory;
import org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.StereotypeApplicationWithVSLPackage;
import org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.StereotypeApplicationsRule;
import org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.TagSpecificationRule;

import org.eclipse.uml2.uml.UMLPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class StereotypeApplicationWithVSLPackageImpl extends EPackageImpl implements StereotypeApplicationWithVSLPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass stereotypeApplicationsRuleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass stereotypeApplicationRuleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass tagSpecificationRuleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass expressionValueRuleEClass = null;

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
   * @see org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.StereotypeApplicationWithVSLPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private StereotypeApplicationWithVSLPackageImpl()
  {
    super(eNS_URI, StereotypeApplicationWithVSLFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link StereotypeApplicationWithVSLPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static StereotypeApplicationWithVSLPackage init()
  {
    if (isInited) return (StereotypeApplicationWithVSLPackage)EPackage.Registry.INSTANCE.getEPackage(StereotypeApplicationWithVSLPackage.eNS_URI);

    // Obtain or create and register package
    StereotypeApplicationWithVSLPackageImpl theStereotypeApplicationWithVSLPackage = (StereotypeApplicationWithVSLPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof StereotypeApplicationWithVSLPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new StereotypeApplicationWithVSLPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    VSLPackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theStereotypeApplicationWithVSLPackage.createPackageContents();

    // Initialize created meta-data
    theStereotypeApplicationWithVSLPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theStereotypeApplicationWithVSLPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(StereotypeApplicationWithVSLPackage.eNS_URI, theStereotypeApplicationWithVSLPackage);
    return theStereotypeApplicationWithVSLPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStereotypeApplicationsRule()
  {
    return stereotypeApplicationsRuleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStereotypeApplicationsRule_StereotypeApplications()
  {
    return (EReference)stereotypeApplicationsRuleEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStereotypeApplicationRule()
  {
    return stereotypeApplicationRuleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStereotypeApplicationRule_Stereotype()
  {
    return (EReference)stereotypeApplicationRuleEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStereotypeApplicationRule_TagSpecification()
  {
    return (EReference)stereotypeApplicationRuleEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTagSpecificationRule()
  {
    return tagSpecificationRuleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTagSpecificationRule_Property()
  {
    return (EReference)tagSpecificationRuleEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTagSpecificationRule_Value()
  {
    return (EReference)tagSpecificationRuleEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExpressionValueRule()
  {
    return expressionValueRuleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExpressionValueRule_Expression()
  {
    return (EReference)expressionValueRuleEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StereotypeApplicationWithVSLFactory getStereotypeApplicationWithVSLFactory()
  {
    return (StereotypeApplicationWithVSLFactory)getEFactoryInstance();
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
    stereotypeApplicationsRuleEClass = createEClass(STEREOTYPE_APPLICATIONS_RULE);
    createEReference(stereotypeApplicationsRuleEClass, STEREOTYPE_APPLICATIONS_RULE__STEREOTYPE_APPLICATIONS);

    stereotypeApplicationRuleEClass = createEClass(STEREOTYPE_APPLICATION_RULE);
    createEReference(stereotypeApplicationRuleEClass, STEREOTYPE_APPLICATION_RULE__STEREOTYPE);
    createEReference(stereotypeApplicationRuleEClass, STEREOTYPE_APPLICATION_RULE__TAG_SPECIFICATION);

    tagSpecificationRuleEClass = createEClass(TAG_SPECIFICATION_RULE);
    createEReference(tagSpecificationRuleEClass, TAG_SPECIFICATION_RULE__PROPERTY);
    createEReference(tagSpecificationRuleEClass, TAG_SPECIFICATION_RULE__VALUE);

    expressionValueRuleEClass = createEClass(EXPRESSION_VALUE_RULE);
    createEReference(expressionValueRuleEClass, EXPRESSION_VALUE_RULE__EXPRESSION);
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
    initEClass(stereotypeApplicationsRuleEClass, StereotypeApplicationsRule.class, "StereotypeApplicationsRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getStereotypeApplicationsRule_StereotypeApplications(), this.getStereotypeApplicationRule(), null, "stereotypeApplications", null, 0, -1, StereotypeApplicationsRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    addEOperation(stereotypeApplicationsRuleEClass, theUMLPackage.getType(), "getExpectedType", 0, 1, IS_UNIQUE, IS_ORDERED);

    addEOperation(stereotypeApplicationsRuleEClass, theUMLPackage.getElement(), "getContextElement", 0, 1, IS_UNIQUE, IS_ORDERED);

    initEClass(stereotypeApplicationRuleEClass, StereotypeApplicationRule.class, "StereotypeApplicationRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getStereotypeApplicationRule_Stereotype(), theUMLPackage.getStereotype(), null, "stereotype", null, 0, 1, StereotypeApplicationRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getStereotypeApplicationRule_TagSpecification(), this.getTagSpecificationRule(), null, "tagSpecification", null, 0, -1, StereotypeApplicationRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    addEOperation(stereotypeApplicationRuleEClass, theUMLPackage.getType(), "getExpectedType", 0, 1, IS_UNIQUE, IS_ORDERED);

    addEOperation(stereotypeApplicationRuleEClass, theUMLPackage.getElement(), "getContextElement", 0, 1, IS_UNIQUE, IS_ORDERED);

    initEClass(tagSpecificationRuleEClass, TagSpecificationRule.class, "TagSpecificationRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTagSpecificationRule_Property(), theUMLPackage.getProperty(), null, "property", null, 0, 1, TagSpecificationRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTagSpecificationRule_Value(), this.getExpressionValueRule(), null, "value", null, 0, 1, TagSpecificationRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    addEOperation(tagSpecificationRuleEClass, theUMLPackage.getType(), "getExpectedType", 0, 1, IS_UNIQUE, IS_ORDERED);

    addEOperation(tagSpecificationRuleEClass, theUMLPackage.getElement(), "getContextElement", 0, 1, IS_UNIQUE, IS_ORDERED);

    initEClass(expressionValueRuleEClass, ExpressionValueRule.class, "ExpressionValueRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getExpressionValueRule_Expression(), theVSLPackage.getExpression(), null, "expression", null, 0, 1, ExpressionValueRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    addEOperation(expressionValueRuleEClass, theUMLPackage.getType(), "getExpectedType", 0, 1, IS_UNIQUE, IS_ORDERED);

    addEOperation(expressionValueRuleEClass, theUMLPackage.getElement(), "getContextElement", 0, 1, IS_UNIQUE, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //StereotypeApplicationWithVSLPackageImpl
