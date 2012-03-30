/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>JDT Opaque Body</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTOpaqueBody#get_body <em>body</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JdtmmPackage#getJDTOpaqueBody()
 * @model
 * @generated
 */
public interface JDTOpaqueBody extends JDTMethodBody {
	/**
	 * Returns the value of the '<em><b>body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>body</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>body</em>' attribute.
	 * @see #set_body(String)
	 * @see org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JdtmmPackage#getJDTOpaqueBody__body()
	 * @model dataType="org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.String" required="true" ordered="false"
	 * @generated
	 */
	String get_body();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTOpaqueBody#get_body <em>body</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>body</em>' attribute.
	 * @see #get_body()
	 * @generated
	 */
	void set_body(String value);

} // JDTOpaqueBody
