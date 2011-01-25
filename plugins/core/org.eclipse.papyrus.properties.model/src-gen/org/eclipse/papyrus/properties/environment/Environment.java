/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.properties.environment;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.papyrus.properties.contexts.Context;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Environment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.properties.environment.Environment#getModelElementFactories <em>Model Element Factories</em>}</li>
 *   <li>{@link org.eclipse.papyrus.properties.environment.Environment#getConstraintTypes <em>Constraint Types</em>}</li>
 *   <li>{@link org.eclipse.papyrus.properties.environment.Environment#getWidgetTypes <em>Widget Types</em>}</li>
 *   <li>{@link org.eclipse.papyrus.properties.environment.Environment#getPropertyEditorTypes <em>Property Editor Types</em>}</li>
 *   <li>{@link org.eclipse.papyrus.properties.environment.Environment#getCompositeWidgetTypes <em>Composite Widget Types</em>}</li>
 *   <li>{@link org.eclipse.papyrus.properties.environment.Environment#getLayoutTypes <em>Layout Types</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.properties.environment.EnvironmentPackage#getEnvironment()
 * @model
 * @generated
 */
public interface Environment extends EObject {
	/**
	 * Returns the value of the '<em><b>Model Element Factories</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.properties.environment.ModelElementFactoryDescriptor}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Element Factories</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Element Factories</em>' containment reference list.
	 * @see org.eclipse.papyrus.properties.environment.EnvironmentPackage#getEnvironment_ModelElementFactories()
	 * @model containment="true"
	 * @generated
	 */
	EList<ModelElementFactoryDescriptor> getModelElementFactories();

	/**
	 * Returns the value of the '<em><b>Constraint Types</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.properties.environment.ConstraintType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint Types</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraint Types</em>' containment reference list.
	 * @see org.eclipse.papyrus.properties.environment.EnvironmentPackage#getEnvironment_ConstraintTypes()
	 * @model containment="true"
	 * @generated
	 */
	EList<ConstraintType> getConstraintTypes();

	/**
	 * Returns the value of the '<em><b>Widget Types</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.properties.environment.StandardWidgetType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Widget Types</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Widget Types</em>' containment reference list.
	 * @see org.eclipse.papyrus.properties.environment.EnvironmentPackage#getEnvironment_WidgetTypes()
	 * @model containment="true"
	 * @generated
	 */
	EList<StandardWidgetType> getWidgetTypes();

	/**
	 * Returns the value of the '<em><b>Property Editor Types</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.properties.environment.PropertyEditorType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property Editor Types</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property Editor Types</em>' containment reference list.
	 * @see org.eclipse.papyrus.properties.environment.EnvironmentPackage#getEnvironment_PropertyEditorTypes()
	 * @model containment="true"
	 * @generated
	 */
	EList<PropertyEditorType> getPropertyEditorTypes();

	/**
	 * Returns the value of the '<em><b>Composite Widget Types</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.properties.environment.CompositeWidgetType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Composite Widget Types</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Composite Widget Types</em>' containment reference list.
	 * @see org.eclipse.papyrus.properties.environment.EnvironmentPackage#getEnvironment_CompositeWidgetTypes()
	 * @model containment="true"
	 * @generated
	 */
	EList<CompositeWidgetType> getCompositeWidgetTypes();

	/**
	 * Returns the value of the '<em><b>Layout Types</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.properties.environment.LayoutType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Layout Types</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Layout Types</em>' containment reference list.
	 * @see org.eclipse.papyrus.properties.environment.EnvironmentPackage#getEnvironment_LayoutTypes()
	 * @model containment="true"
	 * @generated
	 */
	EList<LayoutType> getLayoutTypes();

} // Environment
