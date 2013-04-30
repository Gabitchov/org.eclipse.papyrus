/**
 */
package org.eclipse.papyrus.alf.alf;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Visibility Indicator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.VisibilityIndicator#getPUBLIC <em>PUBLIC</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.VisibilityIndicator#getPRIVATE <em>PRIVATE</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.VisibilityIndicator#getPROTECTED <em>PROTECTED</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getVisibilityIndicator()
 * @model
 * @generated
 */
public interface VisibilityIndicator extends EObject
{
  /**
   * Returns the value of the '<em><b>PUBLIC</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>PUBLIC</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>PUBLIC</em>' attribute.
   * @see #setPUBLIC(String)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getVisibilityIndicator_PUBLIC()
   * @model
   * @generated
   */
  String getPUBLIC();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.VisibilityIndicator#getPUBLIC <em>PUBLIC</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>PUBLIC</em>' attribute.
   * @see #getPUBLIC()
   * @generated
   */
  void setPUBLIC(String value);

  /**
   * Returns the value of the '<em><b>PRIVATE</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>PRIVATE</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>PRIVATE</em>' attribute.
   * @see #setPRIVATE(String)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getVisibilityIndicator_PRIVATE()
   * @model
   * @generated
   */
  String getPRIVATE();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.VisibilityIndicator#getPRIVATE <em>PRIVATE</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>PRIVATE</em>' attribute.
   * @see #getPRIVATE()
   * @generated
   */
  void setPRIVATE(String value);

  /**
   * Returns the value of the '<em><b>PROTECTED</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>PROTECTED</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>PROTECTED</em>' attribute.
   * @see #setPROTECTED(String)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getVisibilityIndicator_PROTECTED()
   * @model
   * @generated
   */
  String getPROTECTED();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.VisibilityIndicator#getPROTECTED <em>PROTECTED</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>PROTECTED</em>' attribute.
   * @see #getPROTECTED()
   * @generated
   */
  void setPROTECTED(String value);

} // VisibilityIndicator
