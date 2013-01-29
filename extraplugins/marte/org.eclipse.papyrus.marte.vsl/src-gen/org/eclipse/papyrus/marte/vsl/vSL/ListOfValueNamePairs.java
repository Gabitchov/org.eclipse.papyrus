/**
 */
package org.eclipse.papyrus.marte.vsl.vSL;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Type;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>List Of Value Name Pairs</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.marte.vsl.vSL.ListOfValueNamePairs#getValueNamePairs <em>Value Name Pairs</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.marte.vsl.vSL.VSLPackage#getListOfValueNamePairs()
 * @model
 * @generated
 */
public interface ListOfValueNamePairs extends EObject
{
  /**
   * Returns the value of the '<em><b>Value Name Pairs</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.papyrus.marte.vsl.vSL.ValueNamePair}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value Name Pairs</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value Name Pairs</em>' containment reference list.
   * @see org.eclipse.papyrus.marte.vsl.vSL.VSLPackage#getListOfValueNamePairs_ValueNamePairs()
   * @model containment="true"
   * @generated
   */
  EList<ValueNamePair> getValueNamePairs();

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

} // ListOfValueNamePairs
