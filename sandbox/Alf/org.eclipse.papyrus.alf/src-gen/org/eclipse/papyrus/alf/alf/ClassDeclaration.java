/**
 */
package org.eclipse.papyrus.alf.alf;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.ClassDeclaration#isIsAbstract <em>Is Abstract</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.ClassDeclaration#getClassifierSignature <em>Classifier Signature</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getClassDeclaration()
 * @model
 * @generated
 */
public interface ClassDeclaration extends EObject
{
  /**
   * Returns the value of the '<em><b>Is Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Is Abstract</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Is Abstract</em>' attribute.
   * @see #setIsAbstract(boolean)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getClassDeclaration_IsAbstract()
   * @model
   * @generated
   */
  boolean isIsAbstract();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.ClassDeclaration#isIsAbstract <em>Is Abstract</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Is Abstract</em>' attribute.
   * @see #isIsAbstract()
   * @generated
   */
  void setIsAbstract(boolean value);

  /**
   * Returns the value of the '<em><b>Classifier Signature</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Classifier Signature</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Classifier Signature</em>' containment reference.
   * @see #setClassifierSignature(ClassifierSignature)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getClassDeclaration_ClassifierSignature()
   * @model containment="true"
   * @generated
   */
  ClassifierSignature getClassifierSignature();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.ClassDeclaration#getClassifierSignature <em>Classifier Signature</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Classifier Signature</em>' containment reference.
   * @see #getClassifierSignature()
   * @generated
   */
  void setClassifierSignature(ClassifierSignature value);

} // ClassDeclaration
