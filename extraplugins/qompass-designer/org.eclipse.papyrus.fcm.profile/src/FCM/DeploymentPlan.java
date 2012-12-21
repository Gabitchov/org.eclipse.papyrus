/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package FCM;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.InstanceSpecification;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Deployment Plan</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link FCM.DeploymentPlan#getMainInstance <em>Main Instance</em>}</li>
 *   <li>{@link FCM.DeploymentPlan#getBase_Package <em>Base Package</em>}</li>
 * </ul>
 * </p>
 *
 * @see FCM.FCMPackage#getDeploymentPlan()
 * @model
 * @generated
 */
public interface DeploymentPlan extends EObject {
	/**
	 * Returns the value of the '<em><b>Main Instance</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Main Instance</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Main Instance</em>' reference.
	 * @see #setMainInstance(InstanceSpecification)
	 * @see FCM.FCMPackage#getDeploymentPlan_MainInstance()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	InstanceSpecification getMainInstance();

	/**
	 * Sets the value of the '{@link FCM.DeploymentPlan#getMainInstance <em>Main Instance</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Main Instance</em>' reference.
	 * @see #getMainInstance()
	 * @generated
	 */
	void setMainInstance(InstanceSpecification value);

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
	 * @see FCM.FCMPackage#getDeploymentPlan_Base_Package()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Package getBase_Package();

	/**
	 * Sets the value of the '{@link FCM.DeploymentPlan#getBase_Package <em>Base Package</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Package</em>' reference.
	 * @see #getBase_Package()
	 * @generated
	 */
	void setBase_Package(org.eclipse.uml2.uml.Package value);

} // DeploymentPlan
