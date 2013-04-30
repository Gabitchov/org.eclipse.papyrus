/**
 */
package org.eclipse.papyrus.alf.alf;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Classification Clause</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.ClassificationClause#getClassificationFromClause <em>Classification From Clause</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.ClassificationClause#getClassificationToClause <em>Classification To Clause</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.ClassificationClause#getReclassifyAllClause <em>Reclassify All Clause</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getClassificationClause()
 * @model
 * @generated
 */
public interface ClassificationClause extends EObject
{
  /**
   * Returns the value of the '<em><b>Classification From Clause</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Classification From Clause</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Classification From Clause</em>' containment reference.
   * @see #setClassificationFromClause(ClassificationFromClause)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getClassificationClause_ClassificationFromClause()
   * @model containment="true"
   * @generated
   */
  ClassificationFromClause getClassificationFromClause();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.ClassificationClause#getClassificationFromClause <em>Classification From Clause</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Classification From Clause</em>' containment reference.
   * @see #getClassificationFromClause()
   * @generated
   */
  void setClassificationFromClause(ClassificationFromClause value);

  /**
   * Returns the value of the '<em><b>Classification To Clause</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Classification To Clause</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Classification To Clause</em>' containment reference.
   * @see #setClassificationToClause(ClassificationToClause)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getClassificationClause_ClassificationToClause()
   * @model containment="true"
   * @generated
   */
  ClassificationToClause getClassificationToClause();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.ClassificationClause#getClassificationToClause <em>Classification To Clause</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Classification To Clause</em>' containment reference.
   * @see #getClassificationToClause()
   * @generated
   */
  void setClassificationToClause(ClassificationToClause value);

  /**
   * Returns the value of the '<em><b>Reclassify All Clause</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Reclassify All Clause</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Reclassify All Clause</em>' containment reference.
   * @see #setReclassifyAllClause(ReclassifyAllClause)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getClassificationClause_ReclassifyAllClause()
   * @model containment="true"
   * @generated
   */
  ReclassifyAllClause getReclassifyAllClause();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.ClassificationClause#getReclassifyAllClause <em>Reclassify All Clause</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Reclassify All Clause</em>' containment reference.
   * @see #getReclassifyAllClause()
   * @generated
   */
  void setReclassifyAllClause(ReclassifyAllClause value);

} // ClassificationClause
