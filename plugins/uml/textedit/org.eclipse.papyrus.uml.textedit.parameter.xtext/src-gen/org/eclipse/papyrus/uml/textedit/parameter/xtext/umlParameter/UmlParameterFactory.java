/**
 */
package org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.UmlParameterPackage
 * @generated
 */
public interface UmlParameterFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  UmlParameterFactory eINSTANCE = org.eclipse.papyrus.uml.textedit.parameter.xtext.umlParameter.impl.UmlParameterFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Parameter Rule</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Parameter Rule</em>'.
   * @generated
   */
  ParameterRule createParameterRule();

  /**
   * Returns a new object of class '<em>Modifiers Rule</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Modifiers Rule</em>'.
   * @generated
   */
  ModifiersRule createModifiersRule();

  /**
   * Returns a new object of class '<em>Modifier Specification</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Modifier Specification</em>'.
   * @generated
   */
  ModifierSpecification createModifierSpecification();

  /**
   * Returns a new object of class '<em>Effect Rule</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Effect Rule</em>'.
   * @generated
   */
  EffectRule createEffectRule();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  UmlParameterPackage getUmlParameterPackage();

} //UmlParameterFactory
