/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.FCM;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Container Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A container rule, i.e. a specification of extension or interception within a container. Beside the two options, a container rule is basically a composite class whose parts are added to the container.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.FCM.ContainerRule#getBase_Class <em>Base Class</em>}</li>
 *   <li>{@link org.eclipse.papyrus.FCM.ContainerRule#getForConfig <em>For Config</em>}</li>
 *   <li>{@link org.eclipse.papyrus.FCM.ContainerRule#getKind <em>Kind</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.FCM.FCMPackage#getContainerRule()
 * @model
 * @generated
 */
public interface ContainerRule extends EObject {
	/**
	 * Returns the value of the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Class</em>' reference.
	 * @see #setBase_Class(org.eclipse.uml2.uml.Class)
	 * @see org.eclipse.papyrus.FCM.FCMPackage#getContainerRule_Base_Class()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getBase_Class();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.FCM.ContainerRule#getBase_Class <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Class</em>' reference.
	 * @see #getBase_Class()
	 * @generated
	 */
	void setBase_Class(org.eclipse.uml2.uml.Class value);

	/**
	 * Returns the value of the '<em><b>For Config</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.FCM.ConfigOption}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>For Config</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>For Config</em>' reference list.
	 * @see org.eclipse.papyrus.FCM.FCMPackage#getContainerRule_ForConfig()
	 * @model ordered="false"
	 * @generated
	 */
	EList<ConfigOption> getForConfig();

	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.FCM.ContainerRuleKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see org.eclipse.papyrus.FCM.ContainerRuleKind
	 * @see #setKind(ContainerRuleKind)
	 * @see org.eclipse.papyrus.FCM.FCMPackage#getContainerRule_Kind()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ContainerRuleKind getKind();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.FCM.ContainerRule#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see org.eclipse.papyrus.FCM.ContainerRuleKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(ContainerRuleKind value);

} // ContainerRule
