/**
 */
package org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Service Desc</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.AbstractServiceDesc#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.AbstractServiceDesc#getDependsOn <em>Depends On</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.AbstractServiceDesc#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.AbstractServiceDesc#getPriority <em>Priority</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.AbstractServiceDesc#getBundleID <em>Bundle ID</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.AbstractServiceDesc#getParent <em>Parent</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.AbstractServiceDesc#getDependsOnIds <em>Depends On Ids</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServicedescriptorsPackage#getAbstractServiceDesc()
 * @model abstract="true"
 * @generated
 */
public interface AbstractServiceDesc extends EObject {
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
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServicedescriptorsPackage#getAbstractServiceDesc_Name()
	 * @model dataType="org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.String" required="true" ordered="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.AbstractServiceDesc#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Depends On</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.AbstractServiceDesc}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Depends On</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Depends On</em>' reference list.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServicedescriptorsPackage#getAbstractServiceDesc_DependsOn()
	 * @model ordered="false"
	 * @generated
	 */
	EList<AbstractServiceDesc> getDependsOn();

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
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServicedescriptorsPackage#getAbstractServiceDesc_Description()
	 * @model dataType="org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.String" required="true" ordered="false"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.AbstractServiceDesc#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Priority</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Priority</em>' attribute.
	 * @see #setPriority(int)
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServicedescriptorsPackage#getAbstractServiceDesc_Priority()
	 * @model dataType="org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.int" required="true" ordered="false"
	 * @generated
	 */
	int getPriority();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.AbstractServiceDesc#getPriority <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Priority</em>' attribute.
	 * @see #getPriority()
	 * @generated
	 */
	void setPriority(int value);

	/**
	 * Returns the value of the '<em><b>Bundle ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bundle ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bundle ID</em>' attribute.
	 * @see #setBundleID(String)
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServicedescriptorsPackage#getAbstractServiceDesc_BundleID()
	 * @model dataType="org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.String" required="true" ordered="false"
	 * @generated
	 */
	String getBundleID();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.AbstractServiceDesc#getBundleID <em>Bundle ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bundle ID</em>' attribute.
	 * @see #getBundleID()
	 * @generated
	 */
	void setBundleID(String value);

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServiceSetDesc#getOwnedServices <em>Owned Services</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' container reference.
	 * @see #setParent(ServiceSetDesc)
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServicedescriptorsPackage#getAbstractServiceDesc_Parent()
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServiceSetDesc#getOwnedServices
	 * @model opposite="ownedServices" required="true" transient="false" ordered="false"
	 * @generated
	 */
	ServiceSetDesc getParent();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.AbstractServiceDesc#getParent <em>Parent</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' container reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(ServiceSetDesc value);

	/**
	 * Returns the value of the '<em><b>Depends On Ids</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Depends On Ids</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Depends On Ids</em>' attribute list.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.ServicedescriptorsPackage#getAbstractServiceDesc_DependsOnIds()
	 * @model dataType="org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptors.String"
	 * @generated
	 */
	EList<String> getDependsOnIds();

} // AbstractServiceDesc
