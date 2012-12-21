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
 * A representation of the model object '<em><b>Rule Application</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link FCM.RuleApplication#getBase_Class <em>Base Class</em>}</li>
 *   <li>{@link FCM.RuleApplication#getContainerRule <em>Container Rule</em>}</li>
 *   <li>{@link FCM.RuleApplication#getPropagateRule <em>Propagate Rule</em>}</li>
 *   <li>{@link FCM.RuleApplication#getBase_Package <em>Base Package</em>}</li>
 * </ul>
 * </p>
 *
 * @see FCM.FCMPackage#getRuleApplication()
 * @model
 * @generated
 */
public interface RuleApplication extends EObject {
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
	 * @see FCM.FCMPackage#getRuleApplication_Base_Class()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getBase_Class();

	/**
	 * Sets the value of the '{@link FCM.RuleApplication#getBase_Class <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Class</em>' reference.
	 * @see #getBase_Class()
	 * @generated
	 */
	void setBase_Class(org.eclipse.uml2.uml.Class value);

	/**
	 * Returns the value of the '<em><b>Container Rule</b></em>' reference list.
	 * The list contents are of type {@link FCM.ContainerRule}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Container Rule</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Container Rule</em>' reference list.
	 * @see FCM.FCMPackage#getRuleApplication_ContainerRule()
	 * @model ordered="false"
	 * @generated
	 */
	EList<ContainerRule> getContainerRule();

	/**
	 * Returns the value of the '<em><b>Propagate Rule</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Boolean}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Propagate Rule</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Propagate Rule</em>' attribute list.
	 * @see FCM.FCMPackage#getRuleApplication_PropagateRule()
	 * @model unique="false" dataType="org.eclipse.uml2.types.Boolean" ordered="false"
	 * @generated
	 */
	EList<Boolean> getPropagateRule();

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
	 * @see FCM.FCMPackage#getRuleApplication_Base_Package()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Package getBase_Package();

	/**
	 * Sets the value of the '{@link FCM.RuleApplication#getBase_Package <em>Base Package</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Package</em>' reference.
	 * @see #getBase_Package()
	 * @generated
	 */
	void setBase_Package(org.eclipse.uml2.uml.Package value);

} // RuleApplication
