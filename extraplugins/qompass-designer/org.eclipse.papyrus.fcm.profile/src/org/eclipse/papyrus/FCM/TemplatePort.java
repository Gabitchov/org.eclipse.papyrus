/**
 */
package org.eclipse.papyrus.FCM;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Template Port</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Template ports are ports that enable the binding of an extended port with an actual parameter: the resulting port kind is the port kind bound to the current port type.
 * For instance, we cound type a port with "MyType" and use an extended port Writer with a template with formal parameter T. Resulting port would be Writer with T bound to MyType.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.FCM.TemplatePort#getBoundType <em>Bound Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.FCM.FCMPackage#getTemplatePort()
 * @model
 * @generated
 */
public interface TemplatePort extends Port {
	/**
	 * Returns the value of the '<em><b>Bound Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bound Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bound Type</em>' reference.
	 * @see #isSetBoundType()
	 * @see #unsetBoundType()
	 * @see #setBoundType(PortKind)
	 * @see org.eclipse.papyrus.FCM.FCMPackage#getTemplatePort_BoundType()
	 * @model unsettable="true" transient="true" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	PortKind getBoundType();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.FCM.TemplatePort#getBoundType <em>Bound Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bound Type</em>' reference.
	 * @see #isSetBoundType()
	 * @see #unsetBoundType()
	 * @see #getBoundType()
	 * @generated
	 */
	void setBoundType(PortKind value);

	/**
	 * Unsets the value of the '{@link org.eclipse.papyrus.FCM.TemplatePort#getBoundType <em>Bound Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetBoundType()
	 * @see #getBoundType()
	 * @see #setBoundType(PortKind)
	 * @generated
	 */
	void unsetBoundType();

	/**
	 * Returns whether the value of the '{@link org.eclipse.papyrus.FCM.TemplatePort#getBoundType <em>Bound Type</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Bound Type</em>' reference is set.
	 * @see #unsetBoundType()
	 * @see #getBoundType()
	 * @see #setBoundType(PortKind)
	 * @generated
	 */
	boolean isSetBoundType();

} // TemplatePort
