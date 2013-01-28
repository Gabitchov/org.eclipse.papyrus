/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package FCM;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Container Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link FCM.ContainerRule#getBase_Class <em>Base Class</em>}</li>
 *   <li>{@link FCM.ContainerRule#getForConfig <em>For Config</em>}</li>
 *   <li>{@link FCM.ContainerRule#getKind <em>Kind</em>}</li>
 * </ul>
 * </p>
 *
 * @see FCM.FCMPackage#getContainerRule()
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
	 * @see FCM.FCMPackage#getContainerRule_Base_Class()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getBase_Class();

	/**
	 * Sets the value of the '{@link FCM.ContainerRule#getBase_Class <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Class</em>' reference.
	 * @see #getBase_Class()
	 * @generated
	 */
	void setBase_Class(org.eclipse.uml2.uml.Class value);

	/**
	 * Returns the value of the '<em><b>For Config</b></em>' reference list.
	 * The list contents are of type {@link FCM.ConfigOption}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>For Config</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>For Config</em>' reference list.
	 * @see FCM.FCMPackage#getContainerRule_ForConfig()
	 * @model ordered="false"
	 * @generated
	 */
	EList<ConfigOption> getForConfig();

	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link FCM.ContainerRuleKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see FCM.ContainerRuleKind
	 * @see #setKind(ContainerRuleKind)
	 * @see FCM.FCMPackage#getContainerRule_Kind()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ContainerRuleKind getKind();

	/**
	 * Sets the value of the '{@link FCM.ContainerRule#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see FCM.ContainerRuleKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(ContainerRuleKind value);

} // ContainerRule
