/**
 */
package org.eclipse.papyrus.alf.alf;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Annotation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.Annotation#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.Annotation#getNameList <em>Name List</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getAnnotation()
 * @model
 * @generated
 */
public interface Annotation extends EObject
{
  /**
   * Returns the value of the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Id</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Id</em>' attribute.
   * @see #setId(String)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getAnnotation_Id()
   * @model
   * @generated
   */
  String getId();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.Annotation#getId <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Id</em>' attribute.
   * @see #getId()
   * @generated
   */
  void setId(String value);

  /**
   * Returns the value of the '<em><b>Name List</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name List</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name List</em>' containment reference.
   * @see #setNameList(NameList)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getAnnotation_NameList()
   * @model containment="true"
   * @generated
   */
  NameList getNameList();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.Annotation#getNameList <em>Name List</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name List</em>' containment reference.
   * @see #getNameList()
   * @generated
   */
  void setNameList(NameList value);

} // Annotation
