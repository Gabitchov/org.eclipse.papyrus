/**
 */
package org.eclipse.papyrus.papyrusgmfgenextension;

import org.eclipse.gmf.codegen.gmfgen.MetamodelType;

import org.eclipse.papyrus.domaincontextcodegen.ElementType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>External Metamodel Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.papyrusgmfgenextension.ExternalMetamodelType#getElementTypeRef <em>Element Type Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.papyrusgmfgenextension.PapyrusgmfgenextensionPackage#getExternalMetamodelType()
 * @model
 * @generated
 */
public interface ExternalMetamodelType extends MetamodelType {
	/**
	 * Returns the value of the '<em><b>Element Type Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element Type Ref</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element Type Ref</em>' reference.
	 * @see #setElementTypeRef(ElementType)
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.PapyrusgmfgenextensionPackage#getExternalMetamodelType_ElementTypeRef()
	 * @model
	 * @generated
	 */
	ElementType getElementTypeRef();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.papyrusgmfgenextension.ExternalMetamodelType#getElementTypeRef <em>Element Type Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element Type Ref</em>' reference.
	 * @see #getElementTypeRef()
	 * @generated
	 */
	void setElementTypeRef(ElementType value);

} // ExternalMetamodelType
