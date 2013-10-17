/**
 */
package org.eclipse.papyrus.uml.textedit.port.xtext.umlPort;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.UmlPortFactory
 * @model kind="package"
 * @generated
 */
public interface UmlPortPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "umlPort";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/papyrus/uml/textedit/port/xtext/UmlPort";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "umlPort";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  UmlPortPackage eINSTANCE = org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.impl.UmlPortPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.impl.PortRuleImpl <em>Port Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.impl.PortRuleImpl
   * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.impl.UmlPortPackageImpl#getPortRule()
   * @generated
   */
  int PORT_RULE = 0;

  /**
   * The feature id for the '<em><b>Visibility</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_RULE__VISIBILITY = 0;

  /**
   * The feature id for the '<em><b>Is Derived</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_RULE__IS_DERIVED = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_RULE__NAME = 2;

  /**
   * The feature id for the '<em><b>Is Conjugated</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_RULE__IS_CONJUGATED = 3;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_RULE__TYPE = 4;

  /**
   * The feature id for the '<em><b>Multiplicity</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_RULE__MULTIPLICITY = 5;

  /**
   * The feature id for the '<em><b>Modifiers</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_RULE__MODIFIERS = 6;

  /**
   * The feature id for the '<em><b>Default</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_RULE__DEFAULT = 7;

  /**
   * The number of structural features of the '<em>Port Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PORT_RULE_FEATURE_COUNT = 8;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.impl.TypeRuleImpl <em>Type Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.impl.TypeRuleImpl
   * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.impl.UmlPortPackageImpl#getTypeRule()
   * @generated
   */
  int TYPE_RULE = 1;

  /**
   * The feature id for the '<em><b>Path</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_RULE__PATH = 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_RULE__TYPE = 1;

  /**
   * The number of structural features of the '<em>Type Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_RULE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.impl.QualifiedNameImpl <em>Qualified Name</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.impl.QualifiedNameImpl
   * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.impl.UmlPortPackageImpl#getQualifiedName()
   * @generated
   */
  int QUALIFIED_NAME = 2;

  /**
   * The feature id for the '<em><b>Path</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALIFIED_NAME__PATH = 0;

  /**
   * The feature id for the '<em><b>Remaining</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALIFIED_NAME__REMAINING = 1;

  /**
   * The number of structural features of the '<em>Qualified Name</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALIFIED_NAME_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.impl.MultiplicityRuleImpl <em>Multiplicity Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.impl.MultiplicityRuleImpl
   * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.impl.UmlPortPackageImpl#getMultiplicityRule()
   * @generated
   */
  int MULTIPLICITY_RULE = 3;

  /**
   * The feature id for the '<em><b>Bounds</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICITY_RULE__BOUNDS = 0;

  /**
   * The number of structural features of the '<em>Multiplicity Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICITY_RULE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.impl.BoundSpecificationImpl <em>Bound Specification</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.impl.BoundSpecificationImpl
   * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.impl.UmlPortPackageImpl#getBoundSpecification()
   * @generated
   */
  int BOUND_SPECIFICATION = 4;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOUND_SPECIFICATION__VALUE = 0;

  /**
   * The number of structural features of the '<em>Bound Specification</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOUND_SPECIFICATION_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.impl.ModifiersRuleImpl <em>Modifiers Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.impl.ModifiersRuleImpl
   * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.impl.UmlPortPackageImpl#getModifiersRule()
   * @generated
   */
  int MODIFIERS_RULE = 5;

  /**
   * The feature id for the '<em><b>Values</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODIFIERS_RULE__VALUES = 0;

  /**
   * The number of structural features of the '<em>Modifiers Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODIFIERS_RULE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.impl.ModifierSpecificationImpl <em>Modifier Specification</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.impl.ModifierSpecificationImpl
   * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.impl.UmlPortPackageImpl#getModifierSpecification()
   * @generated
   */
  int MODIFIER_SPECIFICATION = 6;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODIFIER_SPECIFICATION__VALUE = 0;

  /**
   * The feature id for the '<em><b>Redefines</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODIFIER_SPECIFICATION__REDEFINES = 1;

  /**
   * The feature id for the '<em><b>Subsets</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODIFIER_SPECIFICATION__SUBSETS = 2;

  /**
   * The number of structural features of the '<em>Modifier Specification</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODIFIER_SPECIFICATION_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.impl.RedefinesRuleImpl <em>Redefines Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.impl.RedefinesRuleImpl
   * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.impl.UmlPortPackageImpl#getRedefinesRule()
   * @generated
   */
  int REDEFINES_RULE = 7;

  /**
   * The feature id for the '<em><b>Port</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REDEFINES_RULE__PORT = 0;

  /**
   * The number of structural features of the '<em>Redefines Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REDEFINES_RULE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.impl.SubsetsRuleImpl <em>Subsets Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.impl.SubsetsRuleImpl
   * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.impl.UmlPortPackageImpl#getSubsetsRule()
   * @generated
   */
  int SUBSETS_RULE = 8;

  /**
   * The feature id for the '<em><b>Port</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBSETS_RULE__PORT = 0;

  /**
   * The number of structural features of the '<em>Subsets Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBSETS_RULE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.impl.DefaultValueRuleImpl <em>Default Value Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.impl.DefaultValueRuleImpl
   * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.impl.UmlPortPackageImpl#getDefaultValueRule()
   * @generated
   */
  int DEFAULT_VALUE_RULE = 9;

  /**
   * The feature id for the '<em><b>Default</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFAULT_VALUE_RULE__DEFAULT = 0;

  /**
   * The number of structural features of the '<em>Default Value Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFAULT_VALUE_RULE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.VisibilityKind <em>Visibility Kind</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.VisibilityKind
   * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.impl.UmlPortPackageImpl#getVisibilityKind()
   * @generated
   */
  int VISIBILITY_KIND = 10;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.ModifierKind <em>Modifier Kind</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.ModifierKind
   * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.impl.UmlPortPackageImpl#getModifierKind()
   * @generated
   */
  int MODIFIER_KIND = 11;


  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.PortRule <em>Port Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Port Rule</em>'.
   * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.PortRule
   * @generated
   */
  EClass getPortRule();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.PortRule#getVisibility <em>Visibility</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Visibility</em>'.
   * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.PortRule#getVisibility()
   * @see #getPortRule()
   * @generated
   */
  EAttribute getPortRule_Visibility();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.PortRule#getIsDerived <em>Is Derived</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Is Derived</em>'.
   * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.PortRule#getIsDerived()
   * @see #getPortRule()
   * @generated
   */
  EAttribute getPortRule_IsDerived();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.PortRule#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.PortRule#getName()
   * @see #getPortRule()
   * @generated
   */
  EAttribute getPortRule_Name();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.PortRule#getIsConjugated <em>Is Conjugated</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Is Conjugated</em>'.
   * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.PortRule#getIsConjugated()
   * @see #getPortRule()
   * @generated
   */
  EAttribute getPortRule_IsConjugated();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.PortRule#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.PortRule#getType()
   * @see #getPortRule()
   * @generated
   */
  EReference getPortRule_Type();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.PortRule#getMultiplicity <em>Multiplicity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Multiplicity</em>'.
   * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.PortRule#getMultiplicity()
   * @see #getPortRule()
   * @generated
   */
  EReference getPortRule_Multiplicity();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.PortRule#getModifiers <em>Modifiers</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Modifiers</em>'.
   * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.PortRule#getModifiers()
   * @see #getPortRule()
   * @generated
   */
  EReference getPortRule_Modifiers();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.PortRule#getDefault <em>Default</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Default</em>'.
   * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.PortRule#getDefault()
   * @see #getPortRule()
   * @generated
   */
  EReference getPortRule_Default();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.TypeRule <em>Type Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type Rule</em>'.
   * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.TypeRule
   * @generated
   */
  EClass getTypeRule();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.TypeRule#getPath <em>Path</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Path</em>'.
   * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.TypeRule#getPath()
   * @see #getTypeRule()
   * @generated
   */
  EReference getTypeRule_Path();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.TypeRule#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Type</em>'.
   * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.TypeRule#getType()
   * @see #getTypeRule()
   * @generated
   */
  EReference getTypeRule_Type();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.QualifiedName <em>Qualified Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Qualified Name</em>'.
   * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.QualifiedName
   * @generated
   */
  EClass getQualifiedName();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.QualifiedName#getPath <em>Path</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Path</em>'.
   * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.QualifiedName#getPath()
   * @see #getQualifiedName()
   * @generated
   */
  EReference getQualifiedName_Path();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.QualifiedName#getRemaining <em>Remaining</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Remaining</em>'.
   * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.QualifiedName#getRemaining()
   * @see #getQualifiedName()
   * @generated
   */
  EReference getQualifiedName_Remaining();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.MultiplicityRule <em>Multiplicity Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Multiplicity Rule</em>'.
   * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.MultiplicityRule
   * @generated
   */
  EClass getMultiplicityRule();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.MultiplicityRule#getBounds <em>Bounds</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Bounds</em>'.
   * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.MultiplicityRule#getBounds()
   * @see #getMultiplicityRule()
   * @generated
   */
  EReference getMultiplicityRule_Bounds();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.BoundSpecification <em>Bound Specification</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Bound Specification</em>'.
   * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.BoundSpecification
   * @generated
   */
  EClass getBoundSpecification();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.BoundSpecification#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.BoundSpecification#getValue()
   * @see #getBoundSpecification()
   * @generated
   */
  EAttribute getBoundSpecification_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.ModifiersRule <em>Modifiers Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Modifiers Rule</em>'.
   * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.ModifiersRule
   * @generated
   */
  EClass getModifiersRule();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.ModifiersRule#getValues <em>Values</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Values</em>'.
   * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.ModifiersRule#getValues()
   * @see #getModifiersRule()
   * @generated
   */
  EReference getModifiersRule_Values();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.ModifierSpecification <em>Modifier Specification</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Modifier Specification</em>'.
   * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.ModifierSpecification
   * @generated
   */
  EClass getModifierSpecification();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.ModifierSpecification#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.ModifierSpecification#getValue()
   * @see #getModifierSpecification()
   * @generated
   */
  EAttribute getModifierSpecification_Value();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.ModifierSpecification#getRedefines <em>Redefines</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Redefines</em>'.
   * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.ModifierSpecification#getRedefines()
   * @see #getModifierSpecification()
   * @generated
   */
  EReference getModifierSpecification_Redefines();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.ModifierSpecification#getSubsets <em>Subsets</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Subsets</em>'.
   * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.ModifierSpecification#getSubsets()
   * @see #getModifierSpecification()
   * @generated
   */
  EReference getModifierSpecification_Subsets();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.RedefinesRule <em>Redefines Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Redefines Rule</em>'.
   * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.RedefinesRule
   * @generated
   */
  EClass getRedefinesRule();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.RedefinesRule#getPort <em>Port</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Port</em>'.
   * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.RedefinesRule#getPort()
   * @see #getRedefinesRule()
   * @generated
   */
  EReference getRedefinesRule_Port();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.SubsetsRule <em>Subsets Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Subsets Rule</em>'.
   * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.SubsetsRule
   * @generated
   */
  EClass getSubsetsRule();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.SubsetsRule#getPort <em>Port</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Port</em>'.
   * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.SubsetsRule#getPort()
   * @see #getSubsetsRule()
   * @generated
   */
  EReference getSubsetsRule_Port();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.DefaultValueRule <em>Default Value Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Default Value Rule</em>'.
   * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.DefaultValueRule
   * @generated
   */
  EClass getDefaultValueRule();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.DefaultValueRule#getDefault <em>Default</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Default</em>'.
   * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.DefaultValueRule#getDefault()
   * @see #getDefaultValueRule()
   * @generated
   */
  EAttribute getDefaultValueRule_Default();

  /**
   * Returns the meta object for enum '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.VisibilityKind <em>Visibility Kind</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Visibility Kind</em>'.
   * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.VisibilityKind
   * @generated
   */
  EEnum getVisibilityKind();

  /**
   * Returns the meta object for enum '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.ModifierKind <em>Modifier Kind</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Modifier Kind</em>'.
   * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.ModifierKind
   * @generated
   */
  EEnum getModifierKind();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  UmlPortFactory getUmlPortFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.impl.PortRuleImpl <em>Port Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.impl.PortRuleImpl
     * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.impl.UmlPortPackageImpl#getPortRule()
     * @generated
     */
    EClass PORT_RULE = eINSTANCE.getPortRule();

    /**
     * The meta object literal for the '<em><b>Visibility</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PORT_RULE__VISIBILITY = eINSTANCE.getPortRule_Visibility();

    /**
     * The meta object literal for the '<em><b>Is Derived</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PORT_RULE__IS_DERIVED = eINSTANCE.getPortRule_IsDerived();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PORT_RULE__NAME = eINSTANCE.getPortRule_Name();

    /**
     * The meta object literal for the '<em><b>Is Conjugated</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PORT_RULE__IS_CONJUGATED = eINSTANCE.getPortRule_IsConjugated();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PORT_RULE__TYPE = eINSTANCE.getPortRule_Type();

    /**
     * The meta object literal for the '<em><b>Multiplicity</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PORT_RULE__MULTIPLICITY = eINSTANCE.getPortRule_Multiplicity();

    /**
     * The meta object literal for the '<em><b>Modifiers</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PORT_RULE__MODIFIERS = eINSTANCE.getPortRule_Modifiers();

    /**
     * The meta object literal for the '<em><b>Default</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PORT_RULE__DEFAULT = eINSTANCE.getPortRule_Default();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.impl.TypeRuleImpl <em>Type Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.impl.TypeRuleImpl
     * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.impl.UmlPortPackageImpl#getTypeRule()
     * @generated
     */
    EClass TYPE_RULE = eINSTANCE.getTypeRule();

    /**
     * The meta object literal for the '<em><b>Path</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPE_RULE__PATH = eINSTANCE.getTypeRule_Path();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPE_RULE__TYPE = eINSTANCE.getTypeRule_Type();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.impl.QualifiedNameImpl <em>Qualified Name</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.impl.QualifiedNameImpl
     * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.impl.UmlPortPackageImpl#getQualifiedName()
     * @generated
     */
    EClass QUALIFIED_NAME = eINSTANCE.getQualifiedName();

    /**
     * The meta object literal for the '<em><b>Path</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference QUALIFIED_NAME__PATH = eINSTANCE.getQualifiedName_Path();

    /**
     * The meta object literal for the '<em><b>Remaining</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference QUALIFIED_NAME__REMAINING = eINSTANCE.getQualifiedName_Remaining();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.impl.MultiplicityRuleImpl <em>Multiplicity Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.impl.MultiplicityRuleImpl
     * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.impl.UmlPortPackageImpl#getMultiplicityRule()
     * @generated
     */
    EClass MULTIPLICITY_RULE = eINSTANCE.getMultiplicityRule();

    /**
     * The meta object literal for the '<em><b>Bounds</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MULTIPLICITY_RULE__BOUNDS = eINSTANCE.getMultiplicityRule_Bounds();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.impl.BoundSpecificationImpl <em>Bound Specification</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.impl.BoundSpecificationImpl
     * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.impl.UmlPortPackageImpl#getBoundSpecification()
     * @generated
     */
    EClass BOUND_SPECIFICATION = eINSTANCE.getBoundSpecification();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BOUND_SPECIFICATION__VALUE = eINSTANCE.getBoundSpecification_Value();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.impl.ModifiersRuleImpl <em>Modifiers Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.impl.ModifiersRuleImpl
     * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.impl.UmlPortPackageImpl#getModifiersRule()
     * @generated
     */
    EClass MODIFIERS_RULE = eINSTANCE.getModifiersRule();

    /**
     * The meta object literal for the '<em><b>Values</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODIFIERS_RULE__VALUES = eINSTANCE.getModifiersRule_Values();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.impl.ModifierSpecificationImpl <em>Modifier Specification</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.impl.ModifierSpecificationImpl
     * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.impl.UmlPortPackageImpl#getModifierSpecification()
     * @generated
     */
    EClass MODIFIER_SPECIFICATION = eINSTANCE.getModifierSpecification();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODIFIER_SPECIFICATION__VALUE = eINSTANCE.getModifierSpecification_Value();

    /**
     * The meta object literal for the '<em><b>Redefines</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODIFIER_SPECIFICATION__REDEFINES = eINSTANCE.getModifierSpecification_Redefines();

    /**
     * The meta object literal for the '<em><b>Subsets</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODIFIER_SPECIFICATION__SUBSETS = eINSTANCE.getModifierSpecification_Subsets();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.impl.RedefinesRuleImpl <em>Redefines Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.impl.RedefinesRuleImpl
     * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.impl.UmlPortPackageImpl#getRedefinesRule()
     * @generated
     */
    EClass REDEFINES_RULE = eINSTANCE.getRedefinesRule();

    /**
     * The meta object literal for the '<em><b>Port</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REDEFINES_RULE__PORT = eINSTANCE.getRedefinesRule_Port();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.impl.SubsetsRuleImpl <em>Subsets Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.impl.SubsetsRuleImpl
     * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.impl.UmlPortPackageImpl#getSubsetsRule()
     * @generated
     */
    EClass SUBSETS_RULE = eINSTANCE.getSubsetsRule();

    /**
     * The meta object literal for the '<em><b>Port</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUBSETS_RULE__PORT = eINSTANCE.getSubsetsRule_Port();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.impl.DefaultValueRuleImpl <em>Default Value Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.impl.DefaultValueRuleImpl
     * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.impl.UmlPortPackageImpl#getDefaultValueRule()
     * @generated
     */
    EClass DEFAULT_VALUE_RULE = eINSTANCE.getDefaultValueRule();

    /**
     * The meta object literal for the '<em><b>Default</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DEFAULT_VALUE_RULE__DEFAULT = eINSTANCE.getDefaultValueRule_Default();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.VisibilityKind <em>Visibility Kind</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.VisibilityKind
     * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.impl.UmlPortPackageImpl#getVisibilityKind()
     * @generated
     */
    EEnum VISIBILITY_KIND = eINSTANCE.getVisibilityKind();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.ModifierKind <em>Modifier Kind</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.ModifierKind
     * @see org.eclipse.papyrus.uml.textedit.port.xtext.umlPort.impl.UmlPortPackageImpl#getModifierKind()
     * @generated
     */
    EEnum MODIFIER_KIND = eINSTANCE.getModifierKind();

  }

} //UmlPortPackage
