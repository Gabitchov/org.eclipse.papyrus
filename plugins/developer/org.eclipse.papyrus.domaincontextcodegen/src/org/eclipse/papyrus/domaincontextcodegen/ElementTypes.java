/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.domaincontextcodegen;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element Types</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.domaincontextcodegen.ElementTypes#getTypes <em>Types</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage#getElementTypes()
 * @model
 * @generated
 */
public interface ElementTypes extends EObject {

	/**
	 * Returns the value of the '<em><b>Types</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.domaincontextcodegen.ElementType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Types</em>' containment reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Types</em>' containment reference list.
	 * @see org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage#getElementTypes_Types()
	 * @model containment="true"
	 * @generated
	 */
	EList<ElementType> getTypes();

} // ElementTypes
