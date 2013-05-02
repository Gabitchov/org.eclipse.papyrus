/**
 */
package org.eclipse.papyrus.C_Cpp;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Storage Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.C_Cpp.StorageClass#getStorageClass <em>Storage Class</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.C_Cpp.C_CppPackage#getStorageClass()
 * @model
 * @generated
 */
public interface StorageClass extends EObject {
	/**
	 * Returns the value of the '<em><b>Storage Class</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.C_Cpp.EStorageClass}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Storage Class</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Storage Class</em>' attribute.
	 * @see org.eclipse.papyrus.C_Cpp.EStorageClass
	 * @see #setStorageClass(EStorageClass)
	 * @see org.eclipse.papyrus.C_Cpp.C_CppPackage#getStorageClass_StorageClass()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	EStorageClass getStorageClass();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.C_Cpp.StorageClass#getStorageClass <em>Storage Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Storage Class</em>' attribute.
	 * @see org.eclipse.papyrus.C_Cpp.EStorageClass
	 * @see #getStorageClass()
	 * @generated
	 */
	void setStorageClass(EStorageClass value);

} // StorageClass
