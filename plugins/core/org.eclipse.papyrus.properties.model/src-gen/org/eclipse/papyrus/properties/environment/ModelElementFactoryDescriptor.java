/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.properties.environment;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Element Factory Descriptor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.properties.environment.ModelElementFactoryDescriptor#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.properties.environment.ModelElementFactoryDescriptor#getFactoryClass <em>Factory Class</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.properties.environment.EnvironmentPackage#getModelElementFactoryDescriptor()
 * @model
 * @generated
 */
public interface ModelElementFactoryDescriptor extends EObject {
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
	 * @see org.eclipse.papyrus.properties.environment.EnvironmentPackage#getModelElementFactoryDescriptor_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.properties.environment.ModelElementFactoryDescriptor#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Factory Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Factory Class</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Factory Class</em>' attribute.
	 * @see #setFactoryClass(String)
	 * @see org.eclipse.papyrus.properties.environment.EnvironmentPackage#getModelElementFactoryDescriptor_FactoryClass()
	 * @model required="true"
	 * @generated
	 */
	String getFactoryClass();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.properties.environment.ModelElementFactoryDescriptor#getFactoryClass <em>Factory Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Factory Class</em>' attribute.
	 * @see #getFactoryClass()
	 * @generated
	 */
	void setFactoryClass(String value);

} // ModelElementFactoryDescriptor
