/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.papyrus.property.editor.xtext.umlProperty;

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
 * @see org.eclipse.papyrus.property.editor.xtext.umlProperty.UmlPropertyFactory
 * @model kind="package"
 * @generated
 */
public interface UmlPropertyPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "umlProperty";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/papyrus/property/editor/xtext/UmlProperty";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "umlProperty";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  UmlPropertyPackage eINSTANCE = org.eclipse.papyrus.property.editor.xtext.umlProperty.impl.UmlPropertyPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.property.editor.xtext.umlProperty.impl.PropertyRuleImpl <em>Property Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.property.editor.xtext.umlProperty.impl.PropertyRuleImpl
   * @see org.eclipse.papyrus.property.editor.xtext.umlProperty.impl.UmlPropertyPackageImpl#getPropertyRule()
   * @generated
   */
  int PROPERTY_RULE = 0;

  /**
   * The feature id for the '<em><b>Visibility</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_RULE__VISIBILITY = 0;

  /**
   * The feature id for the '<em><b>Is Derived</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_RULE__IS_DERIVED = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_RULE__NAME = 2;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_RULE__TYPE = 3;

  /**
   * The feature id for the '<em><b>Multiplicity</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_RULE__MULTIPLICITY = 4;

  /**
   * The feature id for the '<em><b>Modifiers</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_RULE__MODIFIERS = 5;

  /**
   * The number of structural features of the '<em>Property Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_RULE_FEATURE_COUNT = 6;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.property.editor.xtext.umlProperty.impl.MultiplicityRuleImpl <em>Multiplicity Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.property.editor.xtext.umlProperty.impl.MultiplicityRuleImpl
   * @see org.eclipse.papyrus.property.editor.xtext.umlProperty.impl.UmlPropertyPackageImpl#getMultiplicityRule()
   * @generated
   */
  int MULTIPLICITY_RULE = 1;

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
   * The meta object id for the '{@link org.eclipse.papyrus.property.editor.xtext.umlProperty.impl.BoundSpecificationImpl <em>Bound Specification</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.property.editor.xtext.umlProperty.impl.BoundSpecificationImpl
   * @see org.eclipse.papyrus.property.editor.xtext.umlProperty.impl.UmlPropertyPackageImpl#getBoundSpecification()
   * @generated
   */
  int BOUND_SPECIFICATION = 2;

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
   * The meta object id for the '{@link org.eclipse.papyrus.property.editor.xtext.umlProperty.impl.ModifiersRuleImpl <em>Modifiers Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.property.editor.xtext.umlProperty.impl.ModifiersRuleImpl
   * @see org.eclipse.papyrus.property.editor.xtext.umlProperty.impl.UmlPropertyPackageImpl#getModifiersRule()
   * @generated
   */
  int MODIFIERS_RULE = 3;

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
   * The meta object id for the '{@link org.eclipse.papyrus.property.editor.xtext.umlProperty.impl.ModifierSpecificationImpl <em>Modifier Specification</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.property.editor.xtext.umlProperty.impl.ModifierSpecificationImpl
   * @see org.eclipse.papyrus.property.editor.xtext.umlProperty.impl.UmlPropertyPackageImpl#getModifierSpecification()
   * @generated
   */
  int MODIFIER_SPECIFICATION = 4;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODIFIER_SPECIFICATION__VALUE = 0;

  /**
   * The number of structural features of the '<em>Modifier Specification</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODIFIER_SPECIFICATION_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.property.editor.xtext.umlProperty.VisibilityKind <em>Visibility Kind</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.property.editor.xtext.umlProperty.VisibilityKind
   * @see org.eclipse.papyrus.property.editor.xtext.umlProperty.impl.UmlPropertyPackageImpl#getVisibilityKind()
   * @generated
   */
  int VISIBILITY_KIND = 5;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.property.editor.xtext.umlProperty.ModifierKind <em>Modifier Kind</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.property.editor.xtext.umlProperty.ModifierKind
   * @see org.eclipse.papyrus.property.editor.xtext.umlProperty.impl.UmlPropertyPackageImpl#getModifierKind()
   * @generated
   */
  int MODIFIER_KIND = 6;


  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.property.editor.xtext.umlProperty.PropertyRule <em>Property Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Property Rule</em>'.
   * @see org.eclipse.papyrus.property.editor.xtext.umlProperty.PropertyRule
   * @generated
   */
  EClass getPropertyRule();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.papyrus.property.editor.xtext.umlProperty.PropertyRule#getVisibility <em>Visibility</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Visibility</em>'.
   * @see org.eclipse.papyrus.property.editor.xtext.umlProperty.PropertyRule#getVisibility()
   * @see #getPropertyRule()
   * @generated
   */
  EAttribute getPropertyRule_Visibility();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.papyrus.property.editor.xtext.umlProperty.PropertyRule#getIsDerived <em>Is Derived</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Is Derived</em>'.
   * @see org.eclipse.papyrus.property.editor.xtext.umlProperty.PropertyRule#getIsDerived()
   * @see #getPropertyRule()
   * @generated
   */
  EAttribute getPropertyRule_IsDerived();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.papyrus.property.editor.xtext.umlProperty.PropertyRule#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.papyrus.property.editor.xtext.umlProperty.PropertyRule#getName()
   * @see #getPropertyRule()
   * @generated
   */
  EAttribute getPropertyRule_Name();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.papyrus.property.editor.xtext.umlProperty.PropertyRule#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Type</em>'.
   * @see org.eclipse.papyrus.property.editor.xtext.umlProperty.PropertyRule#getType()
   * @see #getPropertyRule()
   * @generated
   */
  EReference getPropertyRule_Type();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.property.editor.xtext.umlProperty.PropertyRule#getMultiplicity <em>Multiplicity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Multiplicity</em>'.
   * @see org.eclipse.papyrus.property.editor.xtext.umlProperty.PropertyRule#getMultiplicity()
   * @see #getPropertyRule()
   * @generated
   */
  EReference getPropertyRule_Multiplicity();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.property.editor.xtext.umlProperty.PropertyRule#getModifiers <em>Modifiers</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Modifiers</em>'.
   * @see org.eclipse.papyrus.property.editor.xtext.umlProperty.PropertyRule#getModifiers()
   * @see #getPropertyRule()
   * @generated
   */
  EReference getPropertyRule_Modifiers();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.property.editor.xtext.umlProperty.MultiplicityRule <em>Multiplicity Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Multiplicity Rule</em>'.
   * @see org.eclipse.papyrus.property.editor.xtext.umlProperty.MultiplicityRule
   * @generated
   */
  EClass getMultiplicityRule();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.property.editor.xtext.umlProperty.MultiplicityRule#getBounds <em>Bounds</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Bounds</em>'.
   * @see org.eclipse.papyrus.property.editor.xtext.umlProperty.MultiplicityRule#getBounds()
   * @see #getMultiplicityRule()
   * @generated
   */
  EReference getMultiplicityRule_Bounds();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.property.editor.xtext.umlProperty.BoundSpecification <em>Bound Specification</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Bound Specification</em>'.
   * @see org.eclipse.papyrus.property.editor.xtext.umlProperty.BoundSpecification
   * @generated
   */
  EClass getBoundSpecification();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.papyrus.property.editor.xtext.umlProperty.BoundSpecification#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.papyrus.property.editor.xtext.umlProperty.BoundSpecification#getValue()
   * @see #getBoundSpecification()
   * @generated
   */
  EAttribute getBoundSpecification_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.property.editor.xtext.umlProperty.ModifiersRule <em>Modifiers Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Modifiers Rule</em>'.
   * @see org.eclipse.papyrus.property.editor.xtext.umlProperty.ModifiersRule
   * @generated
   */
  EClass getModifiersRule();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.property.editor.xtext.umlProperty.ModifiersRule#getValues <em>Values</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Values</em>'.
   * @see org.eclipse.papyrus.property.editor.xtext.umlProperty.ModifiersRule#getValues()
   * @see #getModifiersRule()
   * @generated
   */
  EReference getModifiersRule_Values();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.property.editor.xtext.umlProperty.ModifierSpecification <em>Modifier Specification</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Modifier Specification</em>'.
   * @see org.eclipse.papyrus.property.editor.xtext.umlProperty.ModifierSpecification
   * @generated
   */
  EClass getModifierSpecification();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.papyrus.property.editor.xtext.umlProperty.ModifierSpecification#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.papyrus.property.editor.xtext.umlProperty.ModifierSpecification#getValue()
   * @see #getModifierSpecification()
   * @generated
   */
  EAttribute getModifierSpecification_Value();

  /**
   * Returns the meta object for enum '{@link org.eclipse.papyrus.property.editor.xtext.umlProperty.VisibilityKind <em>Visibility Kind</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Visibility Kind</em>'.
   * @see org.eclipse.papyrus.property.editor.xtext.umlProperty.VisibilityKind
   * @generated
   */
  EEnum getVisibilityKind();

  /**
   * Returns the meta object for enum '{@link org.eclipse.papyrus.property.editor.xtext.umlProperty.ModifierKind <em>Modifier Kind</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Modifier Kind</em>'.
   * @see org.eclipse.papyrus.property.editor.xtext.umlProperty.ModifierKind
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
  UmlPropertyFactory getUmlPropertyFactory();

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
     * The meta object literal for the '{@link org.eclipse.papyrus.property.editor.xtext.umlProperty.impl.PropertyRuleImpl <em>Property Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.property.editor.xtext.umlProperty.impl.PropertyRuleImpl
     * @see org.eclipse.papyrus.property.editor.xtext.umlProperty.impl.UmlPropertyPackageImpl#getPropertyRule()
     * @generated
     */
    EClass PROPERTY_RULE = eINSTANCE.getPropertyRule();

    /**
     * The meta object literal for the '<em><b>Visibility</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PROPERTY_RULE__VISIBILITY = eINSTANCE.getPropertyRule_Visibility();

    /**
     * The meta object literal for the '<em><b>Is Derived</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PROPERTY_RULE__IS_DERIVED = eINSTANCE.getPropertyRule_IsDerived();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PROPERTY_RULE__NAME = eINSTANCE.getPropertyRule_Name();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROPERTY_RULE__TYPE = eINSTANCE.getPropertyRule_Type();

    /**
     * The meta object literal for the '<em><b>Multiplicity</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROPERTY_RULE__MULTIPLICITY = eINSTANCE.getPropertyRule_Multiplicity();

    /**
     * The meta object literal for the '<em><b>Modifiers</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROPERTY_RULE__MODIFIERS = eINSTANCE.getPropertyRule_Modifiers();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.property.editor.xtext.umlProperty.impl.MultiplicityRuleImpl <em>Multiplicity Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.property.editor.xtext.umlProperty.impl.MultiplicityRuleImpl
     * @see org.eclipse.papyrus.property.editor.xtext.umlProperty.impl.UmlPropertyPackageImpl#getMultiplicityRule()
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
     * The meta object literal for the '{@link org.eclipse.papyrus.property.editor.xtext.umlProperty.impl.BoundSpecificationImpl <em>Bound Specification</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.property.editor.xtext.umlProperty.impl.BoundSpecificationImpl
     * @see org.eclipse.papyrus.property.editor.xtext.umlProperty.impl.UmlPropertyPackageImpl#getBoundSpecification()
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
     * The meta object literal for the '{@link org.eclipse.papyrus.property.editor.xtext.umlProperty.impl.ModifiersRuleImpl <em>Modifiers Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.property.editor.xtext.umlProperty.impl.ModifiersRuleImpl
     * @see org.eclipse.papyrus.property.editor.xtext.umlProperty.impl.UmlPropertyPackageImpl#getModifiersRule()
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
     * The meta object literal for the '{@link org.eclipse.papyrus.property.editor.xtext.umlProperty.impl.ModifierSpecificationImpl <em>Modifier Specification</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.property.editor.xtext.umlProperty.impl.ModifierSpecificationImpl
     * @see org.eclipse.papyrus.property.editor.xtext.umlProperty.impl.UmlPropertyPackageImpl#getModifierSpecification()
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
     * The meta object literal for the '{@link org.eclipse.papyrus.property.editor.xtext.umlProperty.VisibilityKind <em>Visibility Kind</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.property.editor.xtext.umlProperty.VisibilityKind
     * @see org.eclipse.papyrus.property.editor.xtext.umlProperty.impl.UmlPropertyPackageImpl#getVisibilityKind()
     * @generated
     */
    EEnum VISIBILITY_KIND = eINSTANCE.getVisibilityKind();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.property.editor.xtext.umlProperty.ModifierKind <em>Modifier Kind</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.property.editor.xtext.umlProperty.ModifierKind
     * @see org.eclipse.papyrus.property.editor.xtext.umlProperty.impl.UmlPropertyPackageImpl#getModifierKind()
     * @generated
     */
    EEnum MODIFIER_KIND = eINSTANCE.getModifierKind();

  }

} //UmlPropertyPackage
