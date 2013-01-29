/**
 */
package org.eclipse.papyrus.marte.vsl.vSL;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Type;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Interval</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.marte.vsl.vSL.Interval#getIsLowerIncluded <em>Is Lower Included</em>}</li>
 *   <li>{@link org.eclipse.papyrus.marte.vsl.vSL.Interval#getLower <em>Lower</em>}</li>
 *   <li>{@link org.eclipse.papyrus.marte.vsl.vSL.Interval#getUpper <em>Upper</em>}</li>
 *   <li>{@link org.eclipse.papyrus.marte.vsl.vSL.Interval#getIsUpperIncluded <em>Is Upper Included</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.marte.vsl.vSL.VSLPackage#getInterval()
 * @model
 * @generated
 */
public interface Interval extends ValueSpecification
{
  /**
   * Returns the value of the '<em><b>Is Lower Included</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Is Lower Included</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Is Lower Included</em>' attribute.
   * @see #setIsLowerIncluded(String)
   * @see org.eclipse.papyrus.marte.vsl.vSL.VSLPackage#getInterval_IsLowerIncluded()
   * @model
   * @generated
   */
  String getIsLowerIncluded();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.marte.vsl.vSL.Interval#getIsLowerIncluded <em>Is Lower Included</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Is Lower Included</em>' attribute.
   * @see #getIsLowerIncluded()
   * @generated
   */
  void setIsLowerIncluded(String value);

  /**
   * Returns the value of the '<em><b>Lower</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Lower</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Lower</em>' containment reference.
   * @see #setLower(Expression)
   * @see org.eclipse.papyrus.marte.vsl.vSL.VSLPackage#getInterval_Lower()
   * @model containment="true"
   * @generated
   */
  Expression getLower();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.marte.vsl.vSL.Interval#getLower <em>Lower</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Lower</em>' containment reference.
   * @see #getLower()
   * @generated
   */
  void setLower(Expression value);

  /**
   * Returns the value of the '<em><b>Upper</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Upper</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Upper</em>' containment reference.
   * @see #setUpper(Expression)
   * @see org.eclipse.papyrus.marte.vsl.vSL.VSLPackage#getInterval_Upper()
   * @model containment="true"
   * @generated
   */
  Expression getUpper();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.marte.vsl.vSL.Interval#getUpper <em>Upper</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Upper</em>' containment reference.
   * @see #getUpper()
   * @generated
   */
  void setUpper(Expression value);

  /**
   * Returns the value of the '<em><b>Is Upper Included</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Is Upper Included</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Is Upper Included</em>' attribute.
   * @see #setIsUpperIncluded(String)
   * @see org.eclipse.papyrus.marte.vsl.vSL.VSLPackage#getInterval_IsUpperIncluded()
   * @model
   * @generated
   */
  String getIsUpperIncluded();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.marte.vsl.vSL.Interval#getIsUpperIncluded <em>Is Upper Included</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Is Upper Included</em>' attribute.
   * @see #getIsUpperIncluded()
   * @generated
   */
  void setIsUpperIncluded(String value);

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

} // Interval
