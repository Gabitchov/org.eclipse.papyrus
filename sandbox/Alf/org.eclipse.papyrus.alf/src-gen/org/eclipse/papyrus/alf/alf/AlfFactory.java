/**
 */
package org.eclipse.papyrus.alf.alf;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.alf.alf.AlfPackage
 * @generated
 */
public interface AlfFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  AlfFactory eINSTANCE = org.eclipse.papyrus.alf.alf.impl.AlfFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Unit Definition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Unit Definition</em>'.
   * @generated
   */
  UnitDefinition createUnitDefinition();

  /**
   * Returns a new object of class '<em>BOOLEAN LITERAL</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>BOOLEAN LITERAL</em>'.
   * @generated
   */
  BOOLEAN_LITERAL createBOOLEAN_LITERAL();

  /**
   * Returns a new object of class '<em>NUMBER LITERAL</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>NUMBER LITERAL</em>'.
   * @generated
   */
  NUMBER_LITERAL createNUMBER_LITERAL();

  /**
   * Returns a new object of class '<em>INTEGER LITERAL</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>INTEGER LITERAL</em>'.
   * @generated
   */
  INTEGER_LITERAL createINTEGER_LITERAL();

  /**
   * Returns a new object of class '<em>UNLIMITED NATURAL</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>UNLIMITED NATURAL</em>'.
   * @generated
   */
  UNLIMITED_NATURAL createUNLIMITED_NATURAL();

  /**
   * Returns a new object of class '<em>STRING LITERAL</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>STRING LITERAL</em>'.
   * @generated
   */
  STRING_LITERAL createSTRING_LITERAL();

  /**
   * Returns a new object of class '<em>Stereotype Annotations</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Stereotype Annotations</em>'.
   * @generated
   */
  StereotypeAnnotations createStereotypeAnnotations();

  /**
   * Returns a new object of class '<em>Stereotype Annotation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Stereotype Annotation</em>'.
   * @generated
   */
  StereotypeAnnotation createStereotypeAnnotation();

  /**
   * Returns a new object of class '<em>Tagged Values</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Tagged Values</em>'.
   * @generated
   */
  TaggedValues createTaggedValues();

  /**
   * Returns a new object of class '<em>Tagged Value List</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Tagged Value List</em>'.
   * @generated
   */
  TaggedValueList createTaggedValueList();

  /**
   * Returns a new object of class '<em>PRIMITIVE LITERAL</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>PRIMITIVE LITERAL</em>'.
   * @generated
   */
  PRIMITIVE_LITERAL createPRIMITIVE_LITERAL();

  /**
   * Returns a new object of class '<em>Tagged Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Tagged Value</em>'.
   * @generated
   */
  TaggedValue createTaggedValue();

  /**
   * Returns a new object of class '<em>Namespace Declaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Namespace Declaration</em>'.
   * @generated
   */
  NamespaceDeclaration createNamespaceDeclaration();

  /**
   * Returns a new object of class '<em>Import Declaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Import Declaration</em>'.
   * @generated
   */
  ImportDeclaration createImportDeclaration();

  /**
   * Returns a new object of class '<em>Import Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Import Reference</em>'.
   * @generated
   */
  ImportReference createImportReference();

  /**
   * Returns a new object of class '<em>Import Reference Qualified Name Completion</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Import Reference Qualified Name Completion</em>'.
   * @generated
   */
  ImportReferenceQualifiedNameCompletion createImportReferenceQualifiedNameCompletion();

  /**
   * Returns a new object of class '<em>Colon Qualified Name Completion Of Import Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Colon Qualified Name Completion Of Import Reference</em>'.
   * @generated
   */
  ColonQualifiedNameCompletionOfImportReference createColonQualifiedNameCompletionOfImportReference();

  /**
   * Returns a new object of class '<em>Alias Definition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Alias Definition</em>'.
   * @generated
   */
  AliasDefinition createAliasDefinition();

  /**
   * Returns a new object of class '<em>Namespace Definition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Namespace Definition</em>'.
   * @generated
   */
  NamespaceDefinition createNamespaceDefinition();

  /**
   * Returns a new object of class '<em>Visibility Indicator</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Visibility Indicator</em>'.
   * @generated
   */
  VisibilityIndicator createVisibilityIndicator();

  /**
   * Returns a new object of class '<em>Package Declaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Package Declaration</em>'.
   * @generated
   */
  PackageDeclaration createPackageDeclaration();

  /**
   * Returns a new object of class '<em>Package Definition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Package Definition</em>'.
   * @generated
   */
  PackageDefinition createPackageDefinition();

  /**
   * Returns a new object of class '<em>Package Definition Or Stub</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Package Definition Or Stub</em>'.
   * @generated
   */
  PackageDefinitionOrStub createPackageDefinitionOrStub();

  /**
   * Returns a new object of class '<em>Package Body</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Package Body</em>'.
   * @generated
   */
  PackageBody createPackageBody();

  /**
   * Returns a new object of class '<em>Packaged Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Packaged Element</em>'.
   * @generated
   */
  PackagedElement createPackagedElement();

  /**
   * Returns a new object of class '<em>Packaged Element Definition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Packaged Element Definition</em>'.
   * @generated
   */
  PackagedElementDefinition createPackagedElementDefinition();

  /**
   * Returns a new object of class '<em>Classifier Definition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Classifier Definition</em>'.
   * @generated
   */
  ClassifierDefinition createClassifierDefinition();

  /**
   * Returns a new object of class '<em>Classifier Definition Or Stub</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Classifier Definition Or Stub</em>'.
   * @generated
   */
  ClassifierDefinitionOrStub createClassifierDefinitionOrStub();

  /**
   * Returns a new object of class '<em>Classifier Signature</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Classifier Signature</em>'.
   * @generated
   */
  ClassifierSignature createClassifierSignature();

  /**
   * Returns a new object of class '<em>Template Parameters</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Template Parameters</em>'.
   * @generated
   */
  TemplateParameters createTemplateParameters();

  /**
   * Returns a new object of class '<em>Classifier Template Parameter</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Classifier Template Parameter</em>'.
   * @generated
   */
  ClassifierTemplateParameter createClassifierTemplateParameter();

  /**
   * Returns a new object of class '<em>Specialization Clause</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Specialization Clause</em>'.
   * @generated
   */
  SpecializationClause createSpecializationClause();

  /**
   * Returns a new object of class '<em>Class Declaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Class Declaration</em>'.
   * @generated
   */
  ClassDeclaration createClassDeclaration();

  /**
   * Returns a new object of class '<em>Class Definition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Class Definition</em>'.
   * @generated
   */
  ClassDefinition createClassDefinition();

  /**
   * Returns a new object of class '<em>Class Definition Or Stub</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Class Definition Or Stub</em>'.
   * @generated
   */
  ClassDefinitionOrStub createClassDefinitionOrStub();

  /**
   * Returns a new object of class '<em>Class Body</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Class Body</em>'.
   * @generated
   */
  ClassBody createClassBody();

  /**
   * Returns a new object of class '<em>Class Member</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Class Member</em>'.
   * @generated
   */
  ClassMember createClassMember();

  /**
   * Returns a new object of class '<em>Class Member Definition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Class Member Definition</em>'.
   * @generated
   */
  ClassMemberDefinition createClassMemberDefinition();

  /**
   * Returns a new object of class '<em>Active Class Declaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Active Class Declaration</em>'.
   * @generated
   */
  ActiveClassDeclaration createActiveClassDeclaration();

  /**
   * Returns a new object of class '<em>Active Class Definition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Active Class Definition</em>'.
   * @generated
   */
  ActiveClassDefinition createActiveClassDefinition();

  /**
   * Returns a new object of class '<em>Active Class Definition Or Stub</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Active Class Definition Or Stub</em>'.
   * @generated
   */
  ActiveClassDefinitionOrStub createActiveClassDefinitionOrStub();

  /**
   * Returns a new object of class '<em>Active Class Body</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Active Class Body</em>'.
   * @generated
   */
  ActiveClassBody createActiveClassBody();

  /**
   * Returns a new object of class '<em>Behavior Clause</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Behavior Clause</em>'.
   * @generated
   */
  BehaviorClause createBehaviorClause();

  /**
   * Returns a new object of class '<em>Active Class Member</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Active Class Member</em>'.
   * @generated
   */
  ActiveClassMember createActiveClassMember();

  /**
   * Returns a new object of class '<em>Active Class Member Definition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Active Class Member Definition</em>'.
   * @generated
   */
  ActiveClassMemberDefinition createActiveClassMemberDefinition();

  /**
   * Returns a new object of class '<em>Data Type Declaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Data Type Declaration</em>'.
   * @generated
   */
  DataTypeDeclaration createDataTypeDeclaration();

  /**
   * Returns a new object of class '<em>Data Type Definition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Data Type Definition</em>'.
   * @generated
   */
  DataTypeDefinition createDataTypeDefinition();

  /**
   * Returns a new object of class '<em>Data Type Definition Or Stub</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Data Type Definition Or Stub</em>'.
   * @generated
   */
  DataTypeDefinitionOrStub createDataTypeDefinitionOrStub();

  /**
   * Returns a new object of class '<em>Structured Body</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Structured Body</em>'.
   * @generated
   */
  StructuredBody createStructuredBody();

  /**
   * Returns a new object of class '<em>Structured Member</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Structured Member</em>'.
   * @generated
   */
  StructuredMember createStructuredMember();

  /**
   * Returns a new object of class '<em>Association Declaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Association Declaration</em>'.
   * @generated
   */
  AssociationDeclaration createAssociationDeclaration();

  /**
   * Returns a new object of class '<em>Association Definition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Association Definition</em>'.
   * @generated
   */
  AssociationDefinition createAssociationDefinition();

  /**
   * Returns a new object of class '<em>Association Definition Or Stub</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Association Definition Or Stub</em>'.
   * @generated
   */
  AssociationDefinitionOrStub createAssociationDefinitionOrStub();

  /**
   * Returns a new object of class '<em>Enumeration Declaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Enumeration Declaration</em>'.
   * @generated
   */
  EnumerationDeclaration createEnumerationDeclaration();

  /**
   * Returns a new object of class '<em>Enumeration Definition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Enumeration Definition</em>'.
   * @generated
   */
  EnumerationDefinition createEnumerationDefinition();

  /**
   * Returns a new object of class '<em>Enumeration Definition Or Stub</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Enumeration Definition Or Stub</em>'.
   * @generated
   */
  EnumerationDefinitionOrStub createEnumerationDefinitionOrStub();

  /**
   * Returns a new object of class '<em>Enumeration Body</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Enumeration Body</em>'.
   * @generated
   */
  EnumerationBody createEnumerationBody();

  /**
   * Returns a new object of class '<em>Enumeration Literal Name</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Enumeration Literal Name</em>'.
   * @generated
   */
  EnumerationLiteralName createEnumerationLiteralName();

  /**
   * Returns a new object of class '<em>Signal Declaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Signal Declaration</em>'.
   * @generated
   */
  SignalDeclaration createSignalDeclaration();

  /**
   * Returns a new object of class '<em>Signal Definition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Signal Definition</em>'.
   * @generated
   */
  SignalDefinition createSignalDefinition();

  /**
   * Returns a new object of class '<em>Signal Definition Or Stub</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Signal Definition Or Stub</em>'.
   * @generated
   */
  SignalDefinitionOrStub createSignalDefinitionOrStub();

  /**
   * Returns a new object of class '<em>Activity Declaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Activity Declaration</em>'.
   * @generated
   */
  ActivityDeclaration createActivityDeclaration();

  /**
   * Returns a new object of class '<em>Activity Definition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Activity Definition</em>'.
   * @generated
   */
  ActivityDefinition createActivityDefinition();

  /**
   * Returns a new object of class '<em>Activity Definition Or Stub</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Activity Definition Or Stub</em>'.
   * @generated
   */
  ActivityDefinitionOrStub createActivityDefinitionOrStub();

  /**
   * Returns a new object of class '<em>Formal Parameters</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Formal Parameters</em>'.
   * @generated
   */
  FormalParameters createFormalParameters();

  /**
   * Returns a new object of class '<em>Formal Parameter List</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Formal Parameter List</em>'.
   * @generated
   */
  FormalParameterList createFormalParameterList();

  /**
   * Returns a new object of class '<em>Formal Parameter</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Formal Parameter</em>'.
   * @generated
   */
  FormalParameter createFormalParameter();

  /**
   * Returns a new object of class '<em>Feature Definition Or Stub</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Feature Definition Or Stub</em>'.
   * @generated
   */
  FeatureDefinitionOrStub createFeatureDefinitionOrStub();

  /**
   * Returns a new object of class '<em>Active Feature Definition Or Stub</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Active Feature Definition Or Stub</em>'.
   * @generated
   */
  ActiveFeatureDefinitionOrStub createActiveFeatureDefinitionOrStub();

  /**
   * Returns a new object of class '<em>Property Definition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Property Definition</em>'.
   * @generated
   */
  PropertyDefinition createPropertyDefinition();

  /**
   * Returns a new object of class '<em>Attribute Definition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Attribute Definition</em>'.
   * @generated
   */
  AttributeDefinition createAttributeDefinition();

  /**
   * Returns a new object of class '<em>Attribute Initializer</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Attribute Initializer</em>'.
   * @generated
   */
  AttributeInitializer createAttributeInitializer();

  /**
   * Returns a new object of class '<em>Property Declaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Property Declaration</em>'.
   * @generated
   */
  PropertyDeclaration createPropertyDeclaration();

  /**
   * Returns a new object of class '<em>Type Part</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Type Part</em>'.
   * @generated
   */
  TypePart createTypePart();

  /**
   * Returns a new object of class '<em>Type Name</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Type Name</em>'.
   * @generated
   */
  TypeName createTypeName();

  /**
   * Returns a new object of class '<em>Multiplicity</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Multiplicity</em>'.
   * @generated
   */
  Multiplicity createMultiplicity();

  /**
   * Returns a new object of class '<em>Multiplicity Range</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Multiplicity Range</em>'.
   * @generated
   */
  MultiplicityRange createMultiplicityRange();

  /**
   * Returns a new object of class '<em>Unlimited Natural Literal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Unlimited Natural Literal</em>'.
   * @generated
   */
  UnlimitedNaturalLiteral createUnlimitedNaturalLiteral();

  /**
   * Returns a new object of class '<em>Operation Declaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Operation Declaration</em>'.
   * @generated
   */
  OperationDeclaration createOperationDeclaration();

  /**
   * Returns a new object of class '<em>Operation Definition Or Stub</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Operation Definition Or Stub</em>'.
   * @generated
   */
  OperationDefinitionOrStub createOperationDefinitionOrStub();

  /**
   * Returns a new object of class '<em>Redefinition Clause</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Redefinition Clause</em>'.
   * @generated
   */
  RedefinitionClause createRedefinitionClause();

  /**
   * Returns a new object of class '<em>Reception Definition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Reception Definition</em>'.
   * @generated
   */
  ReceptionDefinition createReceptionDefinition();

  /**
   * Returns a new object of class '<em>Signal Reception Declaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Signal Reception Declaration</em>'.
   * @generated
   */
  SignalReceptionDeclaration createSignalReceptionDeclaration();

  /**
   * Returns a new object of class '<em>Signal Reception Definition Or Stub</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Signal Reception Definition Or Stub</em>'.
   * @generated
   */
  SignalReceptionDefinitionOrStub createSignalReceptionDefinitionOrStub();

  /**
   * Returns a new object of class '<em>Name</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Name</em>'.
   * @generated
   */
  Name createName();

  /**
   * Returns a new object of class '<em>Qualified Name</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Qualified Name</em>'.
   * @generated
   */
  QualifiedName createQualifiedName();

  /**
   * Returns a new object of class '<em>Colon Qualified Name Completion</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Colon Qualified Name Completion</em>'.
   * @generated
   */
  ColonQualifiedNameCompletion createColonQualifiedNameCompletion();

  /**
   * Returns a new object of class '<em>Unqualified Name</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Unqualified Name</em>'.
   * @generated
   */
  UnqualifiedName createUnqualifiedName();

  /**
   * Returns a new object of class '<em>Name Binding</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Name Binding</em>'.
   * @generated
   */
  NameBinding createNameBinding();

  /**
   * Returns a new object of class '<em>Qualified Name Without Binding</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Qualified Name Without Binding</em>'.
   * @generated
   */
  QualifiedNameWithoutBinding createQualifiedNameWithoutBinding();

  /**
   * Returns a new object of class '<em>Colon Qualified Name Completion Without Binding</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Colon Qualified Name Completion Without Binding</em>'.
   * @generated
   */
  ColonQualifiedNameCompletionWithoutBinding createColonQualifiedNameCompletionWithoutBinding();

  /**
   * Returns a new object of class '<em>Template Binding</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Template Binding</em>'.
   * @generated
   */
  TemplateBinding createTemplateBinding();

  /**
   * Returns a new object of class '<em>Positional Template Binding</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Positional Template Binding</em>'.
   * @generated
   */
  PositionalTemplateBinding createPositionalTemplateBinding();

  /**
   * Returns a new object of class '<em>Named Template Binding</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Named Template Binding</em>'.
   * @generated
   */
  NamedTemplateBinding createNamedTemplateBinding();

  /**
   * Returns a new object of class '<em>Template Parameter Substitution</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Template Parameter Substitution</em>'.
   * @generated
   */
  TemplateParameterSubstitution createTemplateParameterSubstitution();

  /**
   * Returns a new object of class '<em>Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Expression</em>'.
   * @generated
   */
  Expression createExpression();

  /**
   * Returns a new object of class '<em>Non Name Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Non Name Expression</em>'.
   * @generated
   */
  NonNameExpression createNonNameExpression();

  /**
   * Returns a new object of class '<em>Name To Expression Completion</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Name To Expression Completion</em>'.
   * @generated
   */
  NameToExpressionCompletion createNameToExpressionCompletion();

  /**
   * Returns a new object of class '<em>Primary To Expression Completion</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Primary To Expression Completion</em>'.
   * @generated
   */
  PrimaryToExpressionCompletion createPrimaryToExpressionCompletion();

  /**
   * Returns a new object of class '<em>Expression Completion</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Expression Completion</em>'.
   * @generated
   */
  ExpressionCompletion createExpressionCompletion();

  /**
   * Returns a new object of class '<em>Primary Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Primary Expression</em>'.
   * @generated
   */
  PrimaryExpression createPrimaryExpression();

  /**
   * Returns a new object of class '<em>Base Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Base Expression</em>'.
   * @generated
   */
  BaseExpression createBaseExpression();

  /**
   * Returns a new object of class '<em>Name To Primary Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Name To Primary Expression</em>'.
   * @generated
   */
  NameToPrimaryExpression createNameToPrimaryExpression();

  /**
   * Returns a new object of class '<em>Primary Expression Completion</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Primary Expression Completion</em>'.
   * @generated
   */
  PrimaryExpressionCompletion createPrimaryExpressionCompletion();

  /**
   * Returns a new object of class '<em>Feature Or Sequence Operation Or Reduction Or Expansion Or Index</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Feature Or Sequence Operation Or Reduction Or Expansion Or Index</em>'.
   * @generated
   */
  Feature_Or_SequenceOperationOrReductionOrExpansion_Or_Index createFeature_Or_SequenceOperationOrReductionOrExpansion_Or_Index();

  /**
   * Returns a new object of class '<em>Literal Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Literal Expression</em>'.
   * @generated
   */
  LiteralExpression createLiteralExpression();

  /**
   * Returns a new object of class '<em>Name Or Primary Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Name Or Primary Expression</em>'.
   * @generated
   */
  NameOrPrimaryExpression createNameOrPrimaryExpression();

  /**
   * Returns a new object of class '<em>This Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>This Expression</em>'.
   * @generated
   */
  ThisExpression createThisExpression();

  /**
   * Returns a new object of class '<em>Parenthesized Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Parenthesized Expression</em>'.
   * @generated
   */
  ParenthesizedExpression createParenthesizedExpression();

  /**
   * Returns a new object of class '<em>Feature</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Feature</em>'.
   * @generated
   */
  Feature createFeature();

  /**
   * Returns a new object of class '<em>Tuple</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Tuple</em>'.
   * @generated
   */
  Tuple createTuple();

  /**
   * Returns a new object of class '<em>Positional Tuple Expression List</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Positional Tuple Expression List</em>'.
   * @generated
   */
  PositionalTupleExpressionList createPositionalTupleExpressionList();

  /**
   * Returns a new object of class '<em>Positional Tuple Expression List Completion</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Positional Tuple Expression List Completion</em>'.
   * @generated
   */
  PositionalTupleExpressionListCompletion createPositionalTupleExpressionListCompletion();

  /**
   * Returns a new object of class '<em>Named Tuple Expression List</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Named Tuple Expression List</em>'.
   * @generated
   */
  NamedTupleExpressionList createNamedTupleExpressionList();

  /**
   * Returns a new object of class '<em>Named Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Named Expression</em>'.
   * @generated
   */
  NamedExpression createNamedExpression();

  /**
   * Returns a new object of class '<em>Behavior Invocation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Behavior Invocation</em>'.
   * @generated
   */
  BehaviorInvocation createBehaviorInvocation();

  /**
   * Returns a new object of class '<em>Feature Invocation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Feature Invocation</em>'.
   * @generated
   */
  FeatureInvocation createFeatureInvocation();

  /**
   * Returns a new object of class '<em>Super Invocation Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Super Invocation Expression</em>'.
   * @generated
   */
  SuperInvocationExpression createSuperInvocationExpression();

  /**
   * Returns a new object of class '<em>Instance Creation Or Sequence Construction Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Instance Creation Or Sequence Construction Expression</em>'.
   * @generated
   */
  InstanceCreationOrSequenceConstructionExpression createInstanceCreationOrSequenceConstructionExpression();

  /**
   * Returns a new object of class '<em>Link Operation Completion</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Link Operation Completion</em>'.
   * @generated
   */
  LinkOperationCompletion createLinkOperationCompletion();

  /**
   * Returns a new object of class '<em>Link Operation Tuple</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Link Operation Tuple</em>'.
   * @generated
   */
  LinkOperationTuple createLinkOperationTuple();

  /**
   * Returns a new object of class '<em>Indexed Named Expression List Completion</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Indexed Named Expression List Completion</em>'.
   * @generated
   */
  IndexedNamedExpressionListCompletion createIndexedNamedExpressionListCompletion();

  /**
   * Returns a new object of class '<em>Indexed Named Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Indexed Named Expression</em>'.
   * @generated
   */
  IndexedNamedExpression createIndexedNamedExpression();

  /**
   * Returns a new object of class '<em>Class Extent Expression Completion</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Class Extent Expression Completion</em>'.
   * @generated
   */
  ClassExtentExpressionCompletion createClassExtentExpressionCompletion();

  /**
   * Returns a new object of class '<em>Sequence Any Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Sequence Any Expression</em>'.
   * @generated
   */
  SequenceAnyExpression createSequenceAnyExpression();

  /**
   * Returns a new object of class '<em>Sequence Construction Expression Completion</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Sequence Construction Expression Completion</em>'.
   * @generated
   */
  SequenceConstructionExpressionCompletion createSequenceConstructionExpressionCompletion();

  /**
   * Returns a new object of class '<em>Multiplicity Indicator</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Multiplicity Indicator</em>'.
   * @generated
   */
  MultiplicityIndicator createMultiplicityIndicator();

  /**
   * Returns a new object of class '<em>Sequence Elements</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Sequence Elements</em>'.
   * @generated
   */
  SequenceElements createSequenceElements();

  /**
   * Returns a new object of class '<em>Sequence Element List Completion</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Sequence Element List Completion</em>'.
   * @generated
   */
  SequenceElementListCompletion createSequenceElementListCompletion();

  /**
   * Returns a new object of class '<em>Sequence Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Sequence Element</em>'.
   * @generated
   */
  SequenceElement createSequenceElement();

  /**
   * Returns a new object of class '<em>Sequence Initialization Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Sequence Initialization Expression</em>'.
   * @generated
   */
  SequenceInitializationExpression createSequenceInitializationExpression();

  /**
   * Returns a new object of class '<em>Index</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Index</em>'.
   * @generated
   */
  Index createIndex();

  /**
   * Returns a new object of class '<em>Sequence Operation Or Reduction Or Expansion</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Sequence Operation Or Reduction Or Expansion</em>'.
   * @generated
   */
  SequenceOperationOrReductionOrExpansion createSequenceOperationOrReductionOrExpansion();

  /**
   * Returns a new object of class '<em>Postfix Expression Completion</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Postfix Expression Completion</em>'.
   * @generated
   */
  PostfixExpressionCompletion createPostfixExpressionCompletion();

  /**
   * Returns a new object of class '<em>Postfix Operation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Postfix Operation</em>'.
   * @generated
   */
  PostfixOperation createPostfixOperation();

  /**
   * Returns a new object of class '<em>Prefix Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Prefix Expression</em>'.
   * @generated
   */
  PrefixExpression createPrefixExpression();

  /**
   * Returns a new object of class '<em>Unary Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Unary Expression</em>'.
   * @generated
   */
  UnaryExpression createUnaryExpression();

  /**
   * Returns a new object of class '<em>Postfix Or Cast Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Postfix Or Cast Expression</em>'.
   * @generated
   */
  PostfixOrCastExpression createPostfixOrCastExpression();

  /**
   * Returns a new object of class '<em>Non Name Unary Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Non Name Unary Expression</em>'.
   * @generated
   */
  NonNameUnaryExpression createNonNameUnaryExpression();

  /**
   * Returns a new object of class '<em>Non Name Postfix Or Cast Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Non Name Postfix Or Cast Expression</em>'.
   * @generated
   */
  NonNamePostfixOrCastExpression createNonNamePostfixOrCastExpression();

  /**
   * Returns a new object of class '<em>Non Postfix Non Cast Unary Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Non Postfix Non Cast Unary Expression</em>'.
   * @generated
   */
  NonPostfixNonCastUnaryExpression createNonPostfixNonCastUnaryExpression();

  /**
   * Returns a new object of class '<em>Boolean Negation Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Boolean Negation Expression</em>'.
   * @generated
   */
  BooleanNegationExpression createBooleanNegationExpression();

  /**
   * Returns a new object of class '<em>Bit String Complement Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Bit String Complement Expression</em>'.
   * @generated
   */
  BitStringComplementExpression createBitStringComplementExpression();

  /**
   * Returns a new object of class '<em>Numeric Unary Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Numeric Unary Expression</em>'.
   * @generated
   */
  NumericUnaryExpression createNumericUnaryExpression();

  /**
   * Returns a new object of class '<em>Isolation Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Isolation Expression</em>'.
   * @generated
   */
  IsolationExpression createIsolationExpression();

  /**
   * Returns a new object of class '<em>Cast Completion</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Cast Completion</em>'.
   * @generated
   */
  CastCompletion createCastCompletion();

  /**
   * Returns a new object of class '<em>Multiplicative Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Multiplicative Expression</em>'.
   * @generated
   */
  MultiplicativeExpression createMultiplicativeExpression();

  /**
   * Returns a new object of class '<em>Multiplicative Expression Completion</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Multiplicative Expression Completion</em>'.
   * @generated
   */
  MultiplicativeExpressionCompletion createMultiplicativeExpressionCompletion();

  /**
   * Returns a new object of class '<em>Additive Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Additive Expression</em>'.
   * @generated
   */
  AdditiveExpression createAdditiveExpression();

  /**
   * Returns a new object of class '<em>Additive Expression Completion</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Additive Expression Completion</em>'.
   * @generated
   */
  AdditiveExpressionCompletion createAdditiveExpressionCompletion();

  /**
   * Returns a new object of class '<em>Shift Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Shift Expression</em>'.
   * @generated
   */
  ShiftExpression createShiftExpression();

  /**
   * Returns a new object of class '<em>Shift Expression Completion</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Shift Expression Completion</em>'.
   * @generated
   */
  ShiftExpressionCompletion createShiftExpressionCompletion();

  /**
   * Returns a new object of class '<em>Relational Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Relational Expression</em>'.
   * @generated
   */
  RelationalExpression createRelationalExpression();

  /**
   * Returns a new object of class '<em>Relational Expression Completion</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Relational Expression Completion</em>'.
   * @generated
   */
  RelationalExpressionCompletion createRelationalExpressionCompletion();

  /**
   * Returns a new object of class '<em>Classification Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Classification Expression</em>'.
   * @generated
   */
  ClassificationExpression createClassificationExpression();

  /**
   * Returns a new object of class '<em>Classification Expression Completion</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Classification Expression Completion</em>'.
   * @generated
   */
  ClassificationExpressionCompletion createClassificationExpressionCompletion();

  /**
   * Returns a new object of class '<em>Equality Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Equality Expression</em>'.
   * @generated
   */
  EqualityExpression createEqualityExpression();

  /**
   * Returns a new object of class '<em>Equality Expression Completion</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Equality Expression Completion</em>'.
   * @generated
   */
  EqualityExpressionCompletion createEqualityExpressionCompletion();

  /**
   * Returns a new object of class '<em>And Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>And Expression</em>'.
   * @generated
   */
  AndExpression createAndExpression();

  /**
   * Returns a new object of class '<em>And Expression Completion</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>And Expression Completion</em>'.
   * @generated
   */
  AndExpressionCompletion createAndExpressionCompletion();

  /**
   * Returns a new object of class '<em>Exclusive Or Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Exclusive Or Expression</em>'.
   * @generated
   */
  ExclusiveOrExpression createExclusiveOrExpression();

  /**
   * Returns a new object of class '<em>Exclusive Or Expression Completion</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Exclusive Or Expression Completion</em>'.
   * @generated
   */
  ExclusiveOrExpressionCompletion createExclusiveOrExpressionCompletion();

  /**
   * Returns a new object of class '<em>Inclusive Or Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Inclusive Or Expression</em>'.
   * @generated
   */
  InclusiveOrExpression createInclusiveOrExpression();

  /**
   * Returns a new object of class '<em>Inclusive Or Expression Completion</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Inclusive Or Expression Completion</em>'.
   * @generated
   */
  InclusiveOrExpressionCompletion createInclusiveOrExpressionCompletion();

  /**
   * Returns a new object of class '<em>Conditional And Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Conditional And Expression</em>'.
   * @generated
   */
  ConditionalAndExpression createConditionalAndExpression();

  /**
   * Returns a new object of class '<em>Conditional And Expression Completion</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Conditional And Expression Completion</em>'.
   * @generated
   */
  ConditionalAndExpressionCompletion createConditionalAndExpressionCompletion();

  /**
   * Returns a new object of class '<em>Conditional Or Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Conditional Or Expression</em>'.
   * @generated
   */
  ConditionalOrExpression createConditionalOrExpression();

  /**
   * Returns a new object of class '<em>Conditional Or Expression Completion</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Conditional Or Expression Completion</em>'.
   * @generated
   */
  ConditionalOrExpressionCompletion createConditionalOrExpressionCompletion();

  /**
   * Returns a new object of class '<em>Conditional Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Conditional Expression</em>'.
   * @generated
   */
  ConditionalExpression createConditionalExpression();

  /**
   * Returns a new object of class '<em>Conditional Expression Completion</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Conditional Expression Completion</em>'.
   * @generated
   */
  ConditionalExpressionCompletion createConditionalExpressionCompletion();

  /**
   * Returns a new object of class '<em>Assignment Expression Completion</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Assignment Expression Completion</em>'.
   * @generated
   */
  AssignmentExpressionCompletion createAssignmentExpressionCompletion();

  /**
   * Returns a new object of class '<em>Statement Sequence</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Statement Sequence</em>'.
   * @generated
   */
  StatementSequence createStatementSequence();

  /**
   * Returns a new object of class '<em>Documented Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Documented Statement</em>'.
   * @generated
   */
  DocumentedStatement createDocumentedStatement();

  /**
   * Returns a new object of class '<em>Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Statement</em>'.
   * @generated
   */
  Statement createStatement();

  /**
   * Returns a new object of class '<em>Block</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Block</em>'.
   * @generated
   */
  Block createBlock();

  /**
   * Returns a new object of class '<em>Annotated Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Annotated Statement</em>'.
   * @generated
   */
  AnnotatedStatement createAnnotatedStatement();

  /**
   * Returns a new object of class '<em>Annotations</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Annotations</em>'.
   * @generated
   */
  Annotations createAnnotations();

  /**
   * Returns a new object of class '<em>Annotation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Annotation</em>'.
   * @generated
   */
  Annotation createAnnotation();

  /**
   * Returns a new object of class '<em>Name List</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Name List</em>'.
   * @generated
   */
  NameList createNameList();

  /**
   * Returns a new object of class '<em>In Line Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>In Line Statement</em>'.
   * @generated
   */
  InLineStatement createInLineStatement();

  /**
   * Returns a new object of class '<em>Block Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Block Statement</em>'.
   * @generated
   */
  BlockStatement createBlockStatement();

  /**
   * Returns a new object of class '<em>Empty Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Empty Statement</em>'.
   * @generated
   */
  EmptyStatement createEmptyStatement();

  /**
   * Returns a new object of class '<em>Local Name Declaration Or Expression Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Local Name Declaration Or Expression Statement</em>'.
   * @generated
   */
  LocalNameDeclarationOrExpressionStatement createLocalNameDeclarationOrExpressionStatement();

  /**
   * Returns a new object of class '<em>Local Name Declaration Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Local Name Declaration Statement</em>'.
   * @generated
   */
  LocalNameDeclarationStatement createLocalNameDeclarationStatement();

  /**
   * Returns a new object of class '<em>Local Name Declaration Statement Completion</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Local Name Declaration Statement Completion</em>'.
   * @generated
   */
  LocalNameDeclarationStatementCompletion createLocalNameDeclarationStatementCompletion();

  /**
   * Returns a new object of class '<em>Initialization Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Initialization Expression</em>'.
   * @generated
   */
  InitializationExpression createInitializationExpression();

  /**
   * Returns a new object of class '<em>Instance Initialization Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Instance Initialization Expression</em>'.
   * @generated
   */
  InstanceInitializationExpression createInstanceInitializationExpression();

  /**
   * Returns a new object of class '<em>If Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>If Statement</em>'.
   * @generated
   */
  IfStatement createIfStatement();

  /**
   * Returns a new object of class '<em>Sequential Clauses</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Sequential Clauses</em>'.
   * @generated
   */
  SequentialClauses createSequentialClauses();

  /**
   * Returns a new object of class '<em>Concurrent Clauses</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Concurrent Clauses</em>'.
   * @generated
   */
  ConcurrentClauses createConcurrentClauses();

  /**
   * Returns a new object of class '<em>Non Final Clause</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Non Final Clause</em>'.
   * @generated
   */
  NonFinalClause createNonFinalClause();

  /**
   * Returns a new object of class '<em>Final Clause</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Final Clause</em>'.
   * @generated
   */
  FinalClause createFinalClause();

  /**
   * Returns a new object of class '<em>Switch Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Switch Statement</em>'.
   * @generated
   */
  SwitchStatement createSwitchStatement();

  /**
   * Returns a new object of class '<em>Switch Clause</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Switch Clause</em>'.
   * @generated
   */
  SwitchClause createSwitchClause();

  /**
   * Returns a new object of class '<em>Switch Case</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Switch Case</em>'.
   * @generated
   */
  SwitchCase createSwitchCase();

  /**
   * Returns a new object of class '<em>Switch Default Clause</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Switch Default Clause</em>'.
   * @generated
   */
  SwitchDefaultClause createSwitchDefaultClause();

  /**
   * Returns a new object of class '<em>Non Empty Statement Sequence</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Non Empty Statement Sequence</em>'.
   * @generated
   */
  NonEmptyStatementSequence createNonEmptyStatementSequence();

  /**
   * Returns a new object of class '<em>While Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>While Statement</em>'.
   * @generated
   */
  WhileStatement createWhileStatement();

  /**
   * Returns a new object of class '<em>Do Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Do Statement</em>'.
   * @generated
   */
  DoStatement createDoStatement();

  /**
   * Returns a new object of class '<em>For Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>For Statement</em>'.
   * @generated
   */
  ForStatement createForStatement();

  /**
   * Returns a new object of class '<em>For Control</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>For Control</em>'.
   * @generated
   */
  ForControl createForControl();

  /**
   * Returns a new object of class '<em>Loop Variable Definition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Loop Variable Definition</em>'.
   * @generated
   */
  LoopVariableDefinition createLoopVariableDefinition();

  /**
   * Returns a new object of class '<em>Break Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Break Statement</em>'.
   * @generated
   */
  BreakStatement createBreakStatement();

  /**
   * Returns a new object of class '<em>Return Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Return Statement</em>'.
   * @generated
   */
  ReturnStatement createReturnStatement();

  /**
   * Returns a new object of class '<em>Accept Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Accept Statement</em>'.
   * @generated
   */
  AcceptStatement createAcceptStatement();

  /**
   * Returns a new object of class '<em>Simple Accept Statement Completion</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Simple Accept Statement Completion</em>'.
   * @generated
   */
  SimpleAcceptStatementCompletion createSimpleAcceptStatementCompletion();

  /**
   * Returns a new object of class '<em>Compound Accept Statement Completion</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Compound Accept Statement Completion</em>'.
   * @generated
   */
  CompoundAcceptStatementCompletion createCompoundAcceptStatementCompletion();

  /**
   * Returns a new object of class '<em>Accept Block</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Accept Block</em>'.
   * @generated
   */
  AcceptBlock createAcceptBlock();

  /**
   * Returns a new object of class '<em>Accept Clause</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Accept Clause</em>'.
   * @generated
   */
  AcceptClause createAcceptClause();

  /**
   * Returns a new object of class '<em>Classify Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Classify Statement</em>'.
   * @generated
   */
  ClassifyStatement createClassifyStatement();

  /**
   * Returns a new object of class '<em>Classification Clause</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Classification Clause</em>'.
   * @generated
   */
  ClassificationClause createClassificationClause();

  /**
   * Returns a new object of class '<em>Classification From Clause</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Classification From Clause</em>'.
   * @generated
   */
  ClassificationFromClause createClassificationFromClause();

  /**
   * Returns a new object of class '<em>Classification To Clause</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Classification To Clause</em>'.
   * @generated
   */
  ClassificationToClause createClassificationToClause();

  /**
   * Returns a new object of class '<em>Reclassify All Clause</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Reclassify All Clause</em>'.
   * @generated
   */
  ReclassifyAllClause createReclassifyAllClause();

  /**
   * Returns a new object of class '<em>Qualified Name List</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Qualified Name List</em>'.
   * @generated
   */
  QualifiedNameList createQualifiedNameList();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  AlfPackage getAlfPackage();

} //AlfFactory
