/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.diagramtemplate;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Selection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.diagramtemplate.Selection#isRecursively <em>Recursively</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.diagramtemplate.DiagramTemplatePackage#getSelection()
 * @model
 * @generated
 */
public interface Selection extends AbstractSelection {
	/**
	 * Returns the value of the '<em><b>Recursively</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Recursively</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Recursively</em>' attribute.
	 * @see #setRecursively(boolean)
	 * @see org.eclipse.papyrus.diagramtemplate.DiagramTemplatePackage#getSelection_Recursively()
	 * @model required="true"
	 * @generated
	 */
	boolean isRecursively();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.diagramtemplate.Selection#isRecursively <em>Recursively</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Recursively</em>' attribute.
	 * @see #isRecursively()
	 * @generated
	 */
	void setRecursively(boolean value);

} // Selection
