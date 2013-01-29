/**
 */
package org.eclipse.papyrus.marte.vsl.vSL;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Type;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Jitter Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.marte.vsl.vSL.JitterExp#getFirstInstant <em>First Instant</em>}</li>
 *   <li>{@link org.eclipse.papyrus.marte.vsl.vSL.JitterExp#getSecondInstant <em>Second Instant</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.marte.vsl.vSL.VSLPackage#getJitterExp()
 * @model
 * @generated
 */
public interface JitterExp extends TimeExpression
{
  /**
   * Returns the value of the '<em><b>First Instant</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>First Instant</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>First Instant</em>' containment reference.
   * @see #setFirstInstant(InstantObsExpression)
   * @see org.eclipse.papyrus.marte.vsl.vSL.VSLPackage#getJitterExp_FirstInstant()
   * @model containment="true"
   * @generated
   */
  InstantObsExpression getFirstInstant();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.marte.vsl.vSL.JitterExp#getFirstInstant <em>First Instant</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>First Instant</em>' containment reference.
   * @see #getFirstInstant()
   * @generated
   */
  void setFirstInstant(InstantObsExpression value);

  /**
   * Returns the value of the '<em><b>Second Instant</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Second Instant</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Second Instant</em>' containment reference.
   * @see #setSecondInstant(InstantObsExpression)
   * @see org.eclipse.papyrus.marte.vsl.vSL.VSLPackage#getJitterExp_SecondInstant()
   * @model containment="true"
   * @generated
   */
  InstantObsExpression getSecondInstant();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.marte.vsl.vSL.JitterExp#getSecondInstant <em>Second Instant</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Second Instant</em>' containment reference.
   * @see #getSecondInstant()
   * @generated
   */
  void setSecondInstant(InstantObsExpression value);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return org.eclipse.papyrus.marte.vsl.extensions.VSLContextUtil.getFilteredParentRule(this, filter) ;'"
   * @generated
   */
  EObject getFilteredParentRule(EClass filter);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation"
   *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return org.eclipse.papyrus.marte.vsl.extensions.VSLContextUtil.getExpectedType(this) ;'"
   * @generated
   */
  Type getExpectedType();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation"
   *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return org.eclipse.papyrus.marte.vsl.extensions.VSLContextUtil.getContextElement(this) ;'"
   * @generated
   */
  Element getContextElement();

} // JitterExp
