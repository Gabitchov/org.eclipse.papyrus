/**
 */
package org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.PropertyRule#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.PropertyRule#getIsDerived <em>Is Derived</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.PropertyRule#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.PropertyRule#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.PropertyRule#getMultiplicity <em>Multiplicity</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.PropertyRule#getModifiers <em>Modifiers</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.PropertyRule#getDefault <em>Default</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.UmlPropertyPackage#getPropertyRule()
 * @model
 * @generated
 */
public interface PropertyRule extends EObject
{
  /**
   * Returns the value of the '<em><b>Visibility</b></em>' attribute.
   * The literals are from the enumeration {@link org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.VisibilityKind}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Visibility</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Visibility</em>' attribute.
   * @see org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.VisibilityKind
   * @see #setVisibility(VisibilityKind)
   * @see org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.UmlPropertyPackage#getPropertyRule_Visibility()
   * @model
   * @generated
   */
  VisibilityKind getVisibility();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.PropertyRule#getVisibility <em>Visibility</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Visibility</em>' attribute.
   * @see org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.VisibilityKind
   * @see #getVisibility()
   * @generated
   */
  void setVisibility(VisibilityKind value);

  /**
   * Returns the value of the '<em><b>Is Derived</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Is Derived</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Is Derived</em>' attribute.
   * @see #setIsDerived(String)
   * @see org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.UmlPropertyPackage#getPropertyRule_IsDerived()
   * @model
   * @generated
   */
  String getIsDerived();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.PropertyRule#getIsDerived <em>Is Derived</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Is Derived</em>' attribute.
   * @see #getIsDerived()
   * @generated
   */
  void setIsDerived(String value);

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
   * @see org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.UmlPropertyPackage#getPropertyRule_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.PropertyRule#getName <em>Name</em>}' attribute.
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
   * @see org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.UmlPropertyPackage#getPropertyRule_Type()
   * @model containment="true"
   * @generated
   */
  TypeRule getType();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.PropertyRule#getType <em>Type</em>}' containment reference.
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
   * @see org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.UmlPropertyPackage#getPropertyRule_Multiplicity()
   * @model containment="true"
   * @generated
   */
  MultiplicityRule getMultiplicity();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.PropertyRule#getMultiplicity <em>Multiplicity</em>}' containment reference.
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
   * @see org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.UmlPropertyPackage#getPropertyRule_Modifiers()
   * @model containment="true"
   * @generated
   */
  ModifiersRule getModifiers();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.PropertyRule#getModifiers <em>Modifiers</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Modifiers</em>' containment reference.
   * @see #getModifiers()
   * @generated
   */
  void setModifiers(ModifiersRule value);

  /**
   * Returns the value of the '<em><b>Default</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Default</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Default</em>' containment reference.
   * @see #setDefault(DefaultValueRule)
   * @see org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.UmlPropertyPackage#getPropertyRule_Default()
   * @model containment="true"
   * @generated
   */
  DefaultValueRule getDefault();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.textedit.property.xtext.umlProperty.PropertyRule#getDefault <em>Default</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Default</em>' containment reference.
   * @see #getDefault()
   * @generated
   */
  void setDefault(DefaultValueRule value);

} // PropertyRule
