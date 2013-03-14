/**
 */
package org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter;

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
 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.UmlParameterFactory
 * @model kind="package"
 * @generated
 */
public interface UmlParameterPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "umlParameter";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/papyrus/uml/textedit/parameter/xtext/UmlParameter";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "umlParameter";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  UmlParameterPackage eINSTANCE = org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.UmlParameterPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.ParameterRuleImpl <em>Parameter Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.ParameterRuleImpl
   * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.UmlParameterPackageImpl#getParameterRule()
   * @generated
   */
  int PARAMETER_RULE = 0;

  /**
   * The feature id for the '<em><b>Visibility</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_RULE__VISIBILITY = 0;

  /**
   * The feature id for the '<em><b>Direction</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_RULE__DIRECTION = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_RULE__NAME = 2;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_RULE__TYPE = 3;

  /**
   * The feature id for the '<em><b>Multiplicity</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_RULE__MULTIPLICITY = 4;

  /**
   * The feature id for the '<em><b>Modifiers</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_RULE__MODIFIERS = 5;

  /**
   * The feature id for the '<em><b>Effect</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_RULE__EFFECT = 6;

  /**
   * The number of structural features of the '<em>Parameter Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_RULE_FEATURE_COUNT = 7;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.ModifiersRuleImpl <em>Modifiers Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.ModifiersRuleImpl
   * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.UmlParameterPackageImpl#getModifiersRule()
   * @generated
   */
  int MODIFIERS_RULE = 1;

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
   * The meta object id for the '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.ModifierSpecificationImpl <em>Modifier Specification</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.ModifierSpecificationImpl
   * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.UmlParameterPackageImpl#getModifierSpecification()
   * @generated
   */
  int MODIFIER_SPECIFICATION = 2;

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
   * The meta object id for the '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.EffectRuleImpl <em>Effect Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.EffectRuleImpl
   * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.UmlParameterPackageImpl#getEffectRule()
   * @generated
   */
  int EFFECT_RULE = 3;

  /**
   * The feature id for the '<em><b>Effect Kind</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EFFECT_RULE__EFFECT_KIND = 0;

  /**
   * The number of structural features of the '<em>Effect Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EFFECT_RULE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ModifierKind <em>Modifier Kind</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ModifierKind
   * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.UmlParameterPackageImpl#getModifierKind()
   * @generated
   */
  int MODIFIER_KIND = 4;

  /**
   * The meta object id for the '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.EffectKind <em>Effect Kind</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.EffectKind
   * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.UmlParameterPackageImpl#getEffectKind()
   * @generated
   */
  int EFFECT_KIND = 5;


  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ParameterRule <em>Parameter Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Parameter Rule</em>'.
   * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ParameterRule
   * @generated
   */
  EClass getParameterRule();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ParameterRule#getVisibility <em>Visibility</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Visibility</em>'.
   * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ParameterRule#getVisibility()
   * @see #getParameterRule()
   * @generated
   */
  EAttribute getParameterRule_Visibility();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ParameterRule#getDirection <em>Direction</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Direction</em>'.
   * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ParameterRule#getDirection()
   * @see #getParameterRule()
   * @generated
   */
  EAttribute getParameterRule_Direction();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ParameterRule#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ParameterRule#getName()
   * @see #getParameterRule()
   * @generated
   */
  EAttribute getParameterRule_Name();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ParameterRule#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ParameterRule#getType()
   * @see #getParameterRule()
   * @generated
   */
  EReference getParameterRule_Type();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ParameterRule#getMultiplicity <em>Multiplicity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Multiplicity</em>'.
   * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ParameterRule#getMultiplicity()
   * @see #getParameterRule()
   * @generated
   */
  EReference getParameterRule_Multiplicity();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ParameterRule#getModifiers <em>Modifiers</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Modifiers</em>'.
   * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ParameterRule#getModifiers()
   * @see #getParameterRule()
   * @generated
   */
  EReference getParameterRule_Modifiers();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ParameterRule#getEffect <em>Effect</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Effect</em>'.
   * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ParameterRule#getEffect()
   * @see #getParameterRule()
   * @generated
   */
  EReference getParameterRule_Effect();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ModifiersRule <em>Modifiers Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Modifiers Rule</em>'.
   * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ModifiersRule
   * @generated
   */
  EClass getModifiersRule();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ModifiersRule#getValues <em>Values</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Values</em>'.
   * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ModifiersRule#getValues()
   * @see #getModifiersRule()
   * @generated
   */
  EReference getModifiersRule_Values();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ModifierSpecification <em>Modifier Specification</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Modifier Specification</em>'.
   * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ModifierSpecification
   * @generated
   */
  EClass getModifierSpecification();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ModifierSpecification#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ModifierSpecification#getValue()
   * @see #getModifierSpecification()
   * @generated
   */
  EAttribute getModifierSpecification_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.EffectRule <em>Effect Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Effect Rule</em>'.
   * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.EffectRule
   * @generated
   */
  EClass getEffectRule();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.EffectRule#getEffectKind <em>Effect Kind</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Effect Kind</em>'.
   * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.EffectRule#getEffectKind()
   * @see #getEffectRule()
   * @generated
   */
  EAttribute getEffectRule_EffectKind();

  /**
   * Returns the meta object for enum '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ModifierKind <em>Modifier Kind</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Modifier Kind</em>'.
   * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ModifierKind
   * @generated
   */
  EEnum getModifierKind();

  /**
   * Returns the meta object for enum '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.EffectKind <em>Effect Kind</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Effect Kind</em>'.
   * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.EffectKind
   * @generated
   */
  EEnum getEffectKind();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  UmlParameterFactory getUmlParameterFactory();

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
     * The meta object literal for the '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.ParameterRuleImpl <em>Parameter Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.ParameterRuleImpl
     * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.UmlParameterPackageImpl#getParameterRule()
     * @generated
     */
    EClass PARAMETER_RULE = eINSTANCE.getParameterRule();

    /**
     * The meta object literal for the '<em><b>Visibility</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PARAMETER_RULE__VISIBILITY = eINSTANCE.getParameterRule_Visibility();

    /**
     * The meta object literal for the '<em><b>Direction</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PARAMETER_RULE__DIRECTION = eINSTANCE.getParameterRule_Direction();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PARAMETER_RULE__NAME = eINSTANCE.getParameterRule_Name();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PARAMETER_RULE__TYPE = eINSTANCE.getParameterRule_Type();

    /**
     * The meta object literal for the '<em><b>Multiplicity</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PARAMETER_RULE__MULTIPLICITY = eINSTANCE.getParameterRule_Multiplicity();

    /**
     * The meta object literal for the '<em><b>Modifiers</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PARAMETER_RULE__MODIFIERS = eINSTANCE.getParameterRule_Modifiers();

    /**
     * The meta object literal for the '<em><b>Effect</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PARAMETER_RULE__EFFECT = eINSTANCE.getParameterRule_Effect();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.ModifiersRuleImpl <em>Modifiers Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.ModifiersRuleImpl
     * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.UmlParameterPackageImpl#getModifiersRule()
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
     * The meta object literal for the '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.ModifierSpecificationImpl <em>Modifier Specification</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.ModifierSpecificationImpl
     * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.UmlParameterPackageImpl#getModifierSpecification()
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
     * The meta object literal for the '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.EffectRuleImpl <em>Effect Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.EffectRuleImpl
     * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.UmlParameterPackageImpl#getEffectRule()
     * @generated
     */
    EClass EFFECT_RULE = eINSTANCE.getEffectRule();

    /**
     * The meta object literal for the '<em><b>Effect Kind</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EFFECT_RULE__EFFECT_KIND = eINSTANCE.getEffectRule_EffectKind();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ModifierKind <em>Modifier Kind</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ModifierKind
     * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.UmlParameterPackageImpl#getModifierKind()
     * @generated
     */
    EEnum MODIFIER_KIND = eINSTANCE.getModifierKind();

    /**
     * The meta object literal for the '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.EffectKind <em>Effect Kind</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.EffectKind
     * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.UmlParameterPackageImpl#getEffectKind()
     * @generated
     */
    EEnum EFFECT_KIND = eINSTANCE.getEffectKind();

  }

} //UmlParameterPackage
