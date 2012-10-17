/**
 */
package org.eclipse.papyrus.uml.alf.alf;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Annotation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.Annotation#getKind <em>Kind</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.Annotation#getArgs <em>Args</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getAnnotation()
 * @model
 * @generated
 */
public interface Annotation extends EObject
{
  /**
   * Returns the value of the '<em><b>Kind</b></em>' attribute.
   * The literals are from the enumeration {@link org.eclipse.papyrus.uml.alf.alf.AnnotationKind}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Kind</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Kind</em>' attribute.
   * @see org.eclipse.papyrus.uml.alf.alf.AnnotationKind
   * @see #setKind(AnnotationKind)
   * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getAnnotation_Kind()
   * @model
   * @generated
   */
  AnnotationKind getKind();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.alf.Annotation#getKind <em>Kind</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Kind</em>' attribute.
   * @see org.eclipse.papyrus.uml.alf.alf.AnnotationKind
   * @see #getKind()
   * @generated
   */
  void setKind(AnnotationKind value);

  /**
   * Returns the value of the '<em><b>Args</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Args</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Args</em>' attribute list.
   * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getAnnotation_Args()
   * @model unique="false"
   * @generated
   */
  EList<String> getArgs();

} // Annotation
