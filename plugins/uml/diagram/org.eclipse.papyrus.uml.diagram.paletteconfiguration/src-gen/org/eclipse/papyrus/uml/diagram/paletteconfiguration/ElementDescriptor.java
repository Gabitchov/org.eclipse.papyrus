/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.uml.diagram.paletteconfiguration;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element Descriptor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.diagram.paletteconfiguration.ElementDescriptor#getElementTypeId <em>Element Type Id</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.diagram.paletteconfiguration.ElementDescriptor#getGraphicalHints <em>Graphical Hints</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.uml.diagram.paletteconfiguration.PaletteconfigurationPackage#getElementDescriptor()
 * @model
 * @generated
 */
public interface ElementDescriptor extends EObject {
	/**
	 * Returns the value of the '<em><b>Element Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element Type Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element Type Id</em>' attribute.
	 * @see #setElementTypeId(String)
	 * @see org.eclipse.papyrus.uml.diagram.paletteconfiguration.PaletteconfigurationPackage#getElementDescriptor_ElementTypeId()
	 * @model required="true"
	 * @generated
	 */
	String getElementTypeId();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.diagram.paletteconfiguration.ElementDescriptor#getElementTypeId <em>Element Type Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element Type Id</em>' attribute.
	 * @see #getElementTypeId()
	 * @generated
	 */
	void setElementTypeId(String value);

	/**
	 * Returns the value of the '<em><b>Graphical Hints</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Graphical Hints</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Graphical Hints</em>' attribute list.
	 * @see org.eclipse.papyrus.uml.diagram.paletteconfiguration.PaletteconfigurationPackage#getElementDescriptor_GraphicalHints()
	 * @model
	 * @generated
	 */
	EList<String> getGraphicalHints();

} // ElementDescriptor
