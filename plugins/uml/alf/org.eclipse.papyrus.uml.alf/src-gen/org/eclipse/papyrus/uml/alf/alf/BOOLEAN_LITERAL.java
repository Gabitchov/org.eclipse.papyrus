/**
 */
package org.eclipse.papyrus.uml.alf.alf;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>BOOLEAN LITERAL</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.BOOLEAN_LITERAL#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getBOOLEAN_LITERAL()
 * @model
 * @generated
 */
public interface BOOLEAN_LITERAL extends LITERAL
{
  /**
   * Returns the value of the '<em><b>Value</b></em>' attribute.
   * The literals are from the enumeration {@link org.eclipse.papyrus.uml.alf.alf.BooleanValue}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' attribute.
   * @see org.eclipse.papyrus.uml.alf.alf.BooleanValue
   * @see #setValue(BooleanValue)
   * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getBOOLEAN_LITERAL_Value()
   * @model
   * @generated
   */
  BooleanValue getValue();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.alf.BOOLEAN_LITERAL#getValue <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' attribute.
   * @see org.eclipse.papyrus.uml.alf.alf.BooleanValue
   * @see #getValue()
   * @generated
   */
  void setValue(BooleanValue value);

} // BOOLEAN_LITERAL
