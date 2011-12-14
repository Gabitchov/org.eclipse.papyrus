/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.infra.extendedtypes;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Extended Element Type Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.extendedtypes.ExtendedElementTypeSet#getElementType <em>Element Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.extendedtypes.ExtendedElementTypeSet#getId <em>Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.extendedtypes.ExtendedtypesPackage#getExtendedElementTypeSet()
 * @model
 * @generated
 */
public interface ExtendedElementTypeSet extends EObject {
	/**
	 * Returns the value of the '<em><b>Element Type</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.extendedtypes.ExtendedElementTypeConfiguration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element Type</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element Type</em>' containment reference list.
	 * @see org.eclipse.papyrus.infra.extendedtypes.ExtendedtypesPackage#getExtendedElementTypeSet_ElementType()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<ExtendedElementTypeConfiguration> getElementType();

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
	 * @see org.eclipse.papyrus.infra.extendedtypes.ExtendedtypesPackage#getExtendedElementTypeSet_Id()
	 * @model required="true"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.extendedtypes.ExtendedElementTypeSet#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

} // ExtendedElementTypeSet
