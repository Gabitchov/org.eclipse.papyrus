/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package FCM;

import org.eclipse.uml2.uml.Interface;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Port</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link FCM.Port#getBase_Port <em>Base Port</em>}</li>
 *   <li>{@link FCM.Port#getKind <em>Kind</em>}</li>
 *   <li>{@link FCM.Port#getProvidedInterface <em>Provided Interface</em>}</li>
 *   <li>{@link FCM.Port#getRequiredInterface <em>Required Interface</em>}</li>
 *   <li>{@link FCM.Port#isConjugated <em>Conjugated</em>}</li>
 * </ul>
 * </p>
 *
 * @see FCM.FCMPackage#getPort()
 * @model
 * @generated
 */
public interface Port extends ConfigurableElementInstance {
	/**
	 * Returns the value of the '<em><b>Base Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Port</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Port</em>' reference.
	 * @see #setBase_Port(org.eclipse.uml2.uml.Port)
	 * @see FCM.FCMPackage#getPort_Base_Port()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Port getBase_Port();

	/**
	 * Sets the value of the '{@link FCM.Port#getBase_Port <em>Base Port</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Port</em>' reference.
	 * @see #getBase_Port()
	 * @generated
	 */
	void setBase_Port(org.eclipse.uml2.uml.Port value);

	/**
	 * Returns the value of the '<em><b>Kind</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' reference.
	 * @see #setKind(PortKind)
	 * @see FCM.FCMPackage#getPort_Kind()
	 * @model ordered="false"
	 * @generated
	 */
	PortKind getKind();

	/**
	 * Sets the value of the '{@link FCM.Port#getKind <em>Kind</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' reference.
	 * @see #getKind()
	 * @generated
	 */
	void setKind(PortKind value);

	/**
	 * Returns the value of the '<em><b>Provided Interface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Provided Interface</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Provided Interface</em>' reference.
	 * @see #isSetProvidedInterface()
	 * @see FCM.FCMPackage#getPort_ProvidedInterface()
	 * @model unsettable="true" transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	Interface getProvidedInterface();

	/**
	 * Returns whether the value of the '{@link FCM.Port#getProvidedInterface <em>Provided Interface</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Provided Interface</em>' reference is set.
	 * @see #getProvidedInterface()
	 * @generated
	 */
	boolean isSetProvidedInterface();

	/**
	 * Returns the value of the '<em><b>Required Interface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Required Interface</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Required Interface</em>' reference.
	 * @see #isSetRequiredInterface()
	 * @see FCM.FCMPackage#getPort_RequiredInterface()
	 * @model unsettable="true" transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	Interface getRequiredInterface();

	/**
	 * Returns whether the value of the '{@link FCM.Port#getRequiredInterface <em>Required Interface</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Required Interface</em>' reference is set.
	 * @see #getRequiredInterface()
	 * @generated
	 */
	boolean isSetRequiredInterface();

	/**
	 * Returns the value of the '<em><b>Conjugated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Conjugated</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Conjugated</em>' attribute.
	 * @see #setConjugated(boolean)
	 * @see FCM.FCMPackage#getPort_Conjugated()
	 * @model unique="false" dataType="org.eclipse.uml2.types.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isConjugated();

	/**
	 * Sets the value of the '{@link FCM.Port#isConjugated <em>Conjugated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Conjugated</em>' attribute.
	 * @see #isConjugated()
	 * @generated
	 */
	void setConjugated(boolean value);

} // Port
