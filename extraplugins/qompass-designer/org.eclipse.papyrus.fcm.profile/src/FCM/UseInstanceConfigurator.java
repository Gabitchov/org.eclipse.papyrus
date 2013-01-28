/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package FCM;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Use Instance Configurator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link FCM.UseInstanceConfigurator#getBase_Class <em>Base Class</em>}</li>
 *   <li>{@link FCM.UseInstanceConfigurator#getConfigurator <em>Configurator</em>}</li>
 * </ul>
 * </p>
 *
 * @see FCM.FCMPackage#getUseInstanceConfigurator()
 * @model
 * @generated
 */
public interface UseInstanceConfigurator extends EObject {
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
	 * @see FCM.FCMPackage#getUseInstanceConfigurator_Base_Class()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getBase_Class();

	/**
	 * Sets the value of the '{@link FCM.UseInstanceConfigurator#getBase_Class <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Class</em>' reference.
	 * @see #getBase_Class()
	 * @generated
	 */
	void setBase_Class(org.eclipse.uml2.uml.Class value);

	/**
	 * Returns the value of the '<em><b>Configurator</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Configurator</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Configurator</em>' reference.
	 * @see #setConfigurator(InstanceConfigurator)
	 * @see FCM.FCMPackage#getUseInstanceConfigurator_Configurator()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	InstanceConfigurator getConfigurator();

	/**
	 * Sets the value of the '{@link FCM.UseInstanceConfigurator#getConfigurator <em>Configurator</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Configurator</em>' reference.
	 * @see #getConfigurator()
	 * @generated
	 */
	void setConfigurator(InstanceConfigurator value);

} // UseInstanceConfigurator
