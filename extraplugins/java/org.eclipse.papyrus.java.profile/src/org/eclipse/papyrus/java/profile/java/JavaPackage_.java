/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.java.profile.java;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Package </b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.java.profile.java.JavaPackage_#getPackageName <em>Package Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.java.profile.java.JavaPackage_#getBase_Package <em>Base Package</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.java.profile.java.JavaPackage#getJavaPackage_()
 * @model
 * @generated
 */
public interface JavaPackage_ extends JavaGen {
	/**
	 * Returns the value of the '<em><b>Package Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Package Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Package Name</em>' attribute.
	 * @see #setPackageName(String)
	 * @see org.eclipse.papyrus.java.profile.java.JavaPackage#getJavaPackage__PackageName()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	String getPackageName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.java.profile.java.JavaPackage_#getPackageName <em>Package Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Package Name</em>' attribute.
	 * @see #getPackageName()
	 * @generated
	 */
	void setPackageName(String value);

	/**
	 * Returns the value of the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Package</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Package</em>' reference.
	 * @see #setBase_Package(org.eclipse.uml2.uml.Package)
	 * @see org.eclipse.papyrus.java.profile.java.JavaPackage#getJavaPackage__Base_Package()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Package getBase_Package();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.java.profile.java.JavaPackage_#getBase_Package <em>Base Package</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Package</em>' reference.
	 * @see #getBase_Package()
	 * @generated
	 */
	void setBase_Package(org.eclipse.uml2.uml.Package value);

} // JavaPackage_
