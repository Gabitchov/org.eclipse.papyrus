/**
 */
package org.eclipse.papyrus.marte.vsl.vSL;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.Type;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Qualified Name</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.marte.vsl.vSL.QualifiedName#getPath <em>Path</em>}</li>
 *   <li>{@link org.eclipse.papyrus.marte.vsl.vSL.QualifiedName#getRemaining <em>Remaining</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.marte.vsl.vSL.VSLPackage#getQualifiedName()
 * @model
 * @generated
 */
public interface QualifiedName extends EObject
{
  /**
   * Returns the value of the '<em><b>Path</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Path</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Path</em>' reference.
   * @see #setPath(Namespace)
   * @see org.eclipse.papyrus.marte.vsl.vSL.VSLPackage#getQualifiedName_Path()
   * @model
   * @generated
   */
  Namespace getPath();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.marte.vsl.vSL.QualifiedName#getPath <em>Path</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Path</em>' reference.
   * @see #getPath()
   * @generated
   */
  void setPath(Namespace value);

  /**
   * Returns the value of the '<em><b>Remaining</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Remaining</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Remaining</em>' containment reference.
   * @see #setRemaining(QualifiedName)
   * @see org.eclipse.papyrus.marte.vsl.vSL.VSLPackage#getQualifiedName_Remaining()
   * @model containment="true"
   * @generated
   */
  QualifiedName getRemaining();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.marte.vsl.vSL.QualifiedName#getRemaining <em>Remaining</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Remaining</em>' containment reference.
   * @see #getRemaining()
   * @generated
   */
  void setRemaining(QualifiedName value);

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

} // QualifiedName
