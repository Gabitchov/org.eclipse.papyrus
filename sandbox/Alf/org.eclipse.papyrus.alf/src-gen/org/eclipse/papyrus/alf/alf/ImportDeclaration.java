/**
 */
package org.eclipse.papyrus.alf.alf;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Import Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.ImportDeclaration#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.ImportDeclaration#getImportReference <em>Import Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getImportDeclaration()
 * @model
 * @generated
 */
public interface ImportDeclaration extends EObject
{
  /**
   * Returns the value of the '<em><b>Visibility</b></em>' attribute.
   * The literals are from the enumeration {@link org.eclipse.papyrus.alf.alf.ImportVisibilityIndicator}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Visibility</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Visibility</em>' attribute.
   * @see org.eclipse.papyrus.alf.alf.ImportVisibilityIndicator
   * @see #setVisibility(ImportVisibilityIndicator)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getImportDeclaration_Visibility()
   * @model
   * @generated
   */
  ImportVisibilityIndicator getVisibility();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.ImportDeclaration#getVisibility <em>Visibility</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Visibility</em>' attribute.
   * @see org.eclipse.papyrus.alf.alf.ImportVisibilityIndicator
   * @see #getVisibility()
   * @generated
   */
  void setVisibility(ImportVisibilityIndicator value);

  /**
   * Returns the value of the '<em><b>Import Reference</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Import Reference</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Import Reference</em>' containment reference.
   * @see #setImportReference(ImportReference)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getImportDeclaration_ImportReference()
   * @model containment="true"
   * @generated
   */
  ImportReference getImportReference();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.ImportDeclaration#getImportReference <em>Import Reference</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Import Reference</em>' containment reference.
   * @see #getImportReference()
   * @generated
   */
  void setImportReference(ImportReference value);

} // ImportDeclaration
