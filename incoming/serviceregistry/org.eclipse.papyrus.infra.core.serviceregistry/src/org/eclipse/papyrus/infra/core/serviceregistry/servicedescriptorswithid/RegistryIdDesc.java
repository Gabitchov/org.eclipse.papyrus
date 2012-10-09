/**
 */
package org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Registry Desc</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.RegistryIdDesc#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.RegistryIdDesc#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.RegistryIdDesc#isUnique <em>Is Unique</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.RegistryIdDesc#getSets <em>Sets</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.RegistryIdDesc#getExtends <em>Extends</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.RegistryIdDesc#getParents <em>Parents</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ServicedescriptorswithidPackage#getRegistryIdDesc()
 * @model
 * @generated
 */
public interface RegistryIdDesc extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ServicedescriptorswithidPackage#getRegistryIdDesc_Name()
	 * @model dataType="org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.String" required="true" ordered="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.RegistryIdDesc#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ServicedescriptorswithidPackage#getRegistryIdDesc_Description()
	 * @model dataType="org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.String" required="true" ordered="false"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.RegistryIdDesc#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Is Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Unique</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Unique</em>' attribute.
	 * @see #setIsUnique(boolean)
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ServicedescriptorswithidPackage#getRegistryIdDesc_IsUnique()
	 * @model dataType="org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isUnique();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.RegistryIdDesc#isUnique <em>Is Unique</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Unique</em>' attribute.
	 * @see #isUnique()
	 * @generated
	 */
	void setIsUnique(boolean value);

	/**
	 * Returns the value of the '<em><b>Sets</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sets</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sets</em>' attribute list.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ServicedescriptorswithidPackage#getRegistryIdDesc_Sets()
	 * @model dataType="org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.String"
	 * @generated
	 */
	EList<String> getSets();

	/**
	 * Returns the value of the '<em><b>Extends</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extends</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extends</em>' attribute list.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ServicedescriptorswithidPackage#getRegistryIdDesc_Extends()
	 * @model dataType="org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.String"
	 * @generated
	 */
	EList<String> getExtends();

	/**
	 * Returns the value of the '<em><b>Parents</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parents</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parents</em>' attribute list.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ServicedescriptorswithidPackage#getRegistryIdDesc_Parents()
	 * @model dataType="org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.String"
	 * @generated
	 */
	EList<String> getParents();

} // RegistryIdDesc
