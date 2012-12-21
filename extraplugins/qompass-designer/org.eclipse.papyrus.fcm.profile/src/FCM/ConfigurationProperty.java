/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package FCM;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.Property;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Configuration Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This stereotype indicuates that the attribute does not only store values but needs to be configured initially be the user. It corresponds to the automatic creation of an entry  (slot+nstance specification) in the deployment plan 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link FCM.ConfigurationProperty#getBase_Property <em>Base Property</em>}</li>
 * </ul>
 * </p>
 *
 * @see FCM.FCMPackage#getConfigurationProperty()
 * @model
 * @generated
 */
public interface ConfigurationProperty extends EObject {
	/**
	 * Returns the value of the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Property</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Property</em>' reference.
	 * @see #setBase_Property(Property)
	 * @see FCM.FCMPackage#getConfigurationProperty_Base_Property()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Property getBase_Property();

	/**
	 * Sets the value of the '{@link FCM.ConfigurationProperty#getBase_Property <em>Base Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Property</em>' reference.
	 * @see #getBase_Property()
	 * @generated
	 */
	void setBase_Property(Property value);

} // ConfigurationProperty
