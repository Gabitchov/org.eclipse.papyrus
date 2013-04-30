/**
 */
package org.eclipse.papyrus.alf.alf;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unit Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.UnitDefinition#getNamespaceDeclaration <em>Namespace Declaration</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.UnitDefinition#getImportDeclarations <em>Import Declarations</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.UnitDefinition#getComment <em>Comment</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.UnitDefinition#getStereotypeAnnotations <em>Stereotype Annotations</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.UnitDefinition#getNamesapceDefinition <em>Namesapce Definition</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getUnitDefinition()
 * @model
 * @generated
 */
public interface UnitDefinition extends EObject
{
  /**
   * Returns the value of the '<em><b>Namespace Declaration</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Namespace Declaration</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Namespace Declaration</em>' containment reference.
   * @see #setNamespaceDeclaration(NamespaceDeclaration)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getUnitDefinition_NamespaceDeclaration()
   * @model containment="true"
   * @generated
   */
  NamespaceDeclaration getNamespaceDeclaration();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.UnitDefinition#getNamespaceDeclaration <em>Namespace Declaration</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Namespace Declaration</em>' containment reference.
   * @see #getNamespaceDeclaration()
   * @generated
   */
  void setNamespaceDeclaration(NamespaceDeclaration value);

  /**
   * Returns the value of the '<em><b>Import Declarations</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.papyrus.alf.alf.ImportDeclaration}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Import Declarations</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Import Declarations</em>' containment reference list.
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getUnitDefinition_ImportDeclarations()
   * @model containment="true"
   * @generated
   */
  EList<ImportDeclaration> getImportDeclarations();

  /**
   * Returns the value of the '<em><b>Comment</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Comment</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Comment</em>' attribute.
   * @see #setComment(String)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getUnitDefinition_Comment()
   * @model
   * @generated
   */
  String getComment();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.UnitDefinition#getComment <em>Comment</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Comment</em>' attribute.
   * @see #getComment()
   * @generated
   */
  void setComment(String value);

  /**
   * Returns the value of the '<em><b>Stereotype Annotations</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Stereotype Annotations</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Stereotype Annotations</em>' containment reference.
   * @see #setStereotypeAnnotations(StereotypeAnnotations)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getUnitDefinition_StereotypeAnnotations()
   * @model containment="true"
   * @generated
   */
  StereotypeAnnotations getStereotypeAnnotations();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.UnitDefinition#getStereotypeAnnotations <em>Stereotype Annotations</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Stereotype Annotations</em>' containment reference.
   * @see #getStereotypeAnnotations()
   * @generated
   */
  void setStereotypeAnnotations(StereotypeAnnotations value);

  /**
   * Returns the value of the '<em><b>Namesapce Definition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Namesapce Definition</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Namesapce Definition</em>' containment reference.
   * @see #setNamesapceDefinition(NamespaceDefinition)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getUnitDefinition_NamesapceDefinition()
   * @model containment="true"
   * @generated
   */
  NamespaceDefinition getNamesapceDefinition();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.UnitDefinition#getNamesapceDefinition <em>Namesapce Definition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Namesapce Definition</em>' containment reference.
   * @see #getNamesapceDefinition()
   * @generated
   */
  void setNamesapceDefinition(NamespaceDefinition value);

} // UnitDefinition
