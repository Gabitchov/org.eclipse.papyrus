/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.papyrus.collaborationuse.editor.xtext.umlCollaborationUse;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.papyrus.common.editor.xtext.umlCommon.QualifiedName;

import org.eclipse.uml2.uml.Collaboration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.collaborationuse.editor.xtext.umlCollaborationUse.TypeRule#getPath <em>Path</em>}</li>
 *   <li>{@link org.eclipse.papyrus.collaborationuse.editor.xtext.umlCollaborationUse.TypeRule#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.collaborationuse.editor.xtext.umlCollaborationUse.UmlCollaborationUsePackage#getTypeRule()
 * @model
 * @generated
 */
public interface TypeRule extends EObject
{
  /**
   * Returns the value of the '<em><b>Path</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Path</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Path</em>' containment reference.
   * @see #setPath(QualifiedName)
   * @see org.eclipse.papyrus.collaborationuse.editor.xtext.umlCollaborationUse.UmlCollaborationUsePackage#getTypeRule_Path()
   * @model containment="true"
   * @generated
   */
  QualifiedName getPath();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.collaborationuse.editor.xtext.umlCollaborationUse.TypeRule#getPath <em>Path</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Path</em>' containment reference.
   * @see #getPath()
   * @generated
   */
  void setPath(QualifiedName value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' reference.
   * @see #setType(Collaboration)
   * @see org.eclipse.papyrus.collaborationuse.editor.xtext.umlCollaborationUse.UmlCollaborationUsePackage#getTypeRule_Type()
   * @model
   * @generated
   */
  Collaboration getType();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.collaborationuse.editor.xtext.umlCollaborationUse.TypeRule#getType <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' reference.
   * @see #getType()
   * @generated
   */
  void setType(Collaboration value);

} // TypeRule
