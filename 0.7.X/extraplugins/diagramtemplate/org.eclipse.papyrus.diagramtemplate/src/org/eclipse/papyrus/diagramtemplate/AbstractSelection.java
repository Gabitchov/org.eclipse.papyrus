/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.diagramtemplate;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Selection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.diagramtemplate.AbstractSelection#getElement <em>Element</em>}</li>
 *   <li>{@link org.eclipse.papyrus.diagramtemplate.AbstractSelection#getKind <em>Kind</em>}</li>
 *   <li>{@link org.eclipse.papyrus.diagramtemplate.AbstractSelection#getSelectionRef <em>Selection Ref</em>}</li>
 *   <li>{@link org.eclipse.papyrus.diagramtemplate.AbstractSelection#isSubTypes <em>Sub Types</em>}</li>
 *   <li>{@link org.eclipse.papyrus.diagramtemplate.AbstractSelection#getStereotypedBy <em>Stereotyped By</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.diagramtemplate.DiagramTemplatePackage#getAbstractSelection()
 * @model abstract="true"
 * @generated
 */
public interface AbstractSelection extends EObject {
	/**
	 * Returns the value of the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element</em>' reference.
	 * @see #setElement(EObject)
	 * @see org.eclipse.papyrus.diagramtemplate.DiagramTemplatePackage#getAbstractSelection_Element()
	 * @model
	 * @generated
	 */
	EObject getElement();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.diagramtemplate.AbstractSelection#getElement <em>Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element</em>' reference.
	 * @see #getElement()
	 * @generated
	 */
	void setElement(EObject value);

	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.diagramtemplate.SelectionKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see org.eclipse.papyrus.diagramtemplate.SelectionKind
	 * @see #setKind(SelectionKind)
	 * @see org.eclipse.papyrus.diagramtemplate.DiagramTemplatePackage#getAbstractSelection_Kind()
	 * @model required="true"
	 * @generated
	 */
	SelectionKind getKind();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.diagramtemplate.AbstractSelection#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see org.eclipse.papyrus.diagramtemplate.SelectionKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(SelectionKind value);

	/**
	 * Returns the value of the '<em><b>Selection Ref</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.diagramtemplate.SelectionRef}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Selection Ref</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Selection Ref</em>' containment reference list.
	 * @see org.eclipse.papyrus.diagramtemplate.DiagramTemplatePackage#getAbstractSelection_SelectionRef()
	 * @model containment="true"
	 * @generated
	 */
	EList<SelectionRef> getSelectionRef();

	/**
	 * Returns the value of the '<em><b>Sub Types</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Types</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Types</em>' attribute.
	 * @see #setSubTypes(boolean)
	 * @see org.eclipse.papyrus.diagramtemplate.DiagramTemplatePackage#getAbstractSelection_SubTypes()
	 * @model required="true"
	 * @generated
	 */
	boolean isSubTypes();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.diagramtemplate.AbstractSelection#isSubTypes <em>Sub Types</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sub Types</em>' attribute.
	 * @see #isSubTypes()
	 * @generated
	 */
	void setSubTypes(boolean value);

	/**
	 * Returns the value of the '<em><b>Stereotyped By</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stereotyped By</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stereotyped By</em>' attribute.
	 * @see #setStereotypedBy(String)
	 * @see org.eclipse.papyrus.diagramtemplate.DiagramTemplatePackage#getAbstractSelection_StereotypedBy()
	 * @model required="true"
	 * @generated
	 */
	String getStereotypedBy();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.diagramtemplate.AbstractSelection#getStereotypedBy <em>Stereotyped By</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stereotyped By</em>' attribute.
	 * @see #getStereotypedBy()
	 * @generated
	 */
	void setStereotypedBy(String value);

} // AbstractSelection
