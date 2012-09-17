/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.Direction;
import org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.MultiplicityRule;
import org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.TypeRule;
import org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.VisibilityKind;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parameter Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ParameterRule#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ParameterRule#getDirection <em>Direction</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ParameterRule#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ParameterRule#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ParameterRule#getMultiplicity <em>Multiplicity</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ParameterRule#getModifiers <em>Modifiers</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ParameterRule#getEffect <em>Effect</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.UmlParameterPackage#getParameterRule()
 * @model
 * @generated
 */
public interface ParameterRule extends EObject
{
  /**
   * Returns the value of the '<em><b>Visibility</b></em>' attribute.
   * The literals are from the enumeration {@link org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.VisibilityKind}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Visibility</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Visibility</em>' attribute.
   * @see org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.VisibilityKind
   * @see #setVisibility(VisibilityKind)
   * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.UmlParameterPackage#getParameterRule_Visibility()
   * @model
   * @generated
   */
  VisibilityKind getVisibility();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ParameterRule#getVisibility <em>Visibility</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Visibility</em>' attribute.
   * @see org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.VisibilityKind
   * @see #getVisibility()
   * @generated
   */
  void setVisibility(VisibilityKind value);

  /**
   * Returns the value of the '<em><b>Direction</b></em>' attribute.
   * The literals are from the enumeration {@link org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.Direction}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Direction</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Direction</em>' attribute.
   * @see org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.Direction
   * @see #setDirection(Direction)
   * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.UmlParameterPackage#getParameterRule_Direction()
   * @model
   * @generated
   */
  Direction getDirection();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ParameterRule#getDirection <em>Direction</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Direction</em>' attribute.
   * @see org.eclipse.papyrus.uml.textedit.common.xtext.umlCommon.Direction
   * @see #getDirection()
   * @generated
   */
  void setDirection(Direction value);

  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.UmlParameterPackage#getParameterRule_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ParameterRule#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' containment reference.
   * @see #setType(TypeRule)
   * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.UmlParameterPackage#getParameterRule_Type()
   * @model containment="true"
   * @generated
   */
  TypeRule getType();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ParameterRule#getType <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' containment reference.
   * @see #getType()
   * @generated
   */
  void setType(TypeRule value);

  /**
   * Returns the value of the '<em><b>Multiplicity</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Multiplicity</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Multiplicity</em>' containment reference.
   * @see #setMultiplicity(MultiplicityRule)
   * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.UmlParameterPackage#getParameterRule_Multiplicity()
   * @model containment="true"
   * @generated
   */
  MultiplicityRule getMultiplicity();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ParameterRule#getMultiplicity <em>Multiplicity</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Multiplicity</em>' containment reference.
   * @see #getMultiplicity()
   * @generated
   */
  void setMultiplicity(MultiplicityRule value);

  /**
   * Returns the value of the '<em><b>Modifiers</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Modifiers</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Modifiers</em>' containment reference.
   * @see #setModifiers(ModifiersRule)
   * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.UmlParameterPackage#getParameterRule_Modifiers()
   * @model containment="true"
   * @generated
   */
  ModifiersRule getModifiers();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ParameterRule#getModifiers <em>Modifiers</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Modifiers</em>' containment reference.
   * @see #getModifiers()
   * @generated
   */
  void setModifiers(ModifiersRule value);

  /**
   * Returns the value of the '<em><b>Effect</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Effect</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Effect</em>' containment reference.
   * @see #setEffect(EffectRule)
   * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.UmlParameterPackage#getParameterRule_Effect()
   * @model containment="true"
   * @generated
   */
  EffectRule getEffect();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.ParameterRule#getEffect <em>Effect</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Effect</em>' containment reference.
   * @see #getEffect()
   * @generated
   */
  void setEffect(EffectRule value);

} // ParameterRule
