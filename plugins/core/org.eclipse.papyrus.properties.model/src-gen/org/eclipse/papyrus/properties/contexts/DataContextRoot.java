/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.properties.contexts;

import org.eclipse.papyrus.properties.environment.ModelElementFactoryDescriptor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Context Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.properties.contexts.DataContextRoot#getLabel <em>Label</em>}</li>
 *   <li>{@link org.eclipse.papyrus.properties.contexts.DataContextRoot#getModelElementFactory <em>Model Element Factory</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.properties.contexts.ContextsPackage#getDataContextRoot()
 * @model
 * @generated
 */
public interface DataContextRoot extends DataContextPackage {
	/**
	 * Returns the value of the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Label</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Label</em>' attribute.
	 * @see #setLabel(String)
	 * @see org.eclipse.papyrus.properties.contexts.ContextsPackage#getDataContextRoot_Label()
	 * @model required="true"
	 * @generated
	 */
	String getLabel();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.properties.contexts.DataContextRoot#getLabel <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label</em>' attribute.
	 * @see #getLabel()
	 * @generated
	 */
	void setLabel(String value);

	/**
	 * Returns the value of the '<em><b>Model Element Factory</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Element Factory</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Element Factory</em>' reference.
	 * @see #setModelElementFactory(ModelElementFactoryDescriptor)
	 * @see org.eclipse.papyrus.properties.contexts.ContextsPackage#getDataContextRoot_ModelElementFactory()
	 * @model required="true"
	 * @generated
	 */
	ModelElementFactoryDescriptor getModelElementFactory();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.properties.contexts.DataContextRoot#getModelElementFactory <em>Model Element Factory</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model Element Factory</em>' reference.
	 * @see #getModelElementFactory()
	 * @generated
	 */
	void setModelElementFactory(ModelElementFactoryDescriptor value);

} // DataContextRoot
