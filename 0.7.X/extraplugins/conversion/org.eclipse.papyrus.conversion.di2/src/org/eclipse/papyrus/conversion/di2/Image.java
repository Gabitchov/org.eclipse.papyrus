/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.conversion.di2;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Image</b></em>'. <!--
 * end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.conversion.di2.Image#getUri <em>Uri</em>}</li>
 * <li>{@link org.eclipse.papyrus.conversion.di2.Image#getMimeType <em>Mime Type</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.conversion.di2.Di2Package#getImage()
 * @model
 * @generated
 */
public interface Image extends LeafElement {

	/**
	 * Returns the value of the '<em><b>Uri</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uri</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Uri</em>' attribute.
	 * @see #setUri(String)
	 * @see org.eclipse.papyrus.conversion.di2.Di2Package#getImage_Uri()
	 * @model dataType="org.eclipse.uml2.uml.String"
	 * @generated
	 */
	String getUri();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.conversion.di2.Image#getUri
	 * <em>Uri</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Uri</em>' attribute.
	 * @see #getUri()
	 * @generated
	 */
	void setUri(String value);

	/**
	 * Returns the value of the '<em><b>Mime Type</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mime Type</em>' attribute isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Mime Type</em>' attribute.
	 * @see #setMimeType(String)
	 * @see org.eclipse.papyrus.conversion.di2.Di2Package#getImage_MimeType()
	 * @model dataType="org.eclipse.uml2.uml.String"
	 * @generated
	 */
	String getMimeType();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.conversion.di2.Image#getMimeType
	 * <em>Mime Type</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Mime Type</em>' attribute.
	 * @see #getMimeType()
	 * @generated
	 */
	void setMimeType(String value);

} // Image
