/**
 */
package org.eclipse.papyrus.alf.alf;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unlimited Natural Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.UnlimitedNaturalLiteral#getInteger <em>Integer</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.UnlimitedNaturalLiteral#isStar <em>Star</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getUnlimitedNaturalLiteral()
 * @model
 * @generated
 */
public interface UnlimitedNaturalLiteral extends EObject
{
  /**
   * Returns the value of the '<em><b>Integer</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Integer</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Integer</em>' containment reference.
   * @see #setInteger(INTEGER_LITERAL)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getUnlimitedNaturalLiteral_Integer()
   * @model containment="true"
   * @generated
   */
  INTEGER_LITERAL getInteger();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.UnlimitedNaturalLiteral#getInteger <em>Integer</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Integer</em>' containment reference.
   * @see #getInteger()
   * @generated
   */
  void setInteger(INTEGER_LITERAL value);

  /**
   * Returns the value of the '<em><b>Star</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Star</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Star</em>' attribute.
   * @see #setStar(boolean)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getUnlimitedNaturalLiteral_Star()
   * @model
   * @generated
   */
  boolean isStar();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.UnlimitedNaturalLiteral#isStar <em>Star</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Star</em>' attribute.
   * @see #isStar()
   * @generated
   */
  void setStar(boolean value);

} // UnlimitedNaturalLiteral
