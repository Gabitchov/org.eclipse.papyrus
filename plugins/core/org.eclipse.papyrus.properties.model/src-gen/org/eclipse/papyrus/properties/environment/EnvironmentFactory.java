/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.properties.environment;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.properties.environment.EnvironmentPackage
 * @generated
 */
public interface EnvironmentFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EnvironmentFactory eINSTANCE = org.eclipse.papyrus.properties.environment.impl.EnvironmentFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Environment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Environment</em>'.
	 * @generated
	 */
	Environment createEnvironment();

	/**
	 * Returns a new object of class '<em>Property Editor Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Property Editor Type</em>'.
	 * @generated
	 */
	PropertyEditorType createPropertyEditorType();

	/**
	 * Returns a new object of class '<em>Composite Widget Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Composite Widget Type</em>'.
	 * @generated
	 */
	CompositeWidgetType createCompositeWidgetType();

	/**
	 * Returns a new object of class '<em>Layout Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Layout Type</em>'.
	 * @generated
	 */
	LayoutType createLayoutType();

	/**
	 * Returns a new object of class '<em>Constraint Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Constraint Type</em>'.
	 * @generated
	 */
	ConstraintType createConstraintType();

	/**
	 * Returns a new object of class '<em>Model Element Factory Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model Element Factory Descriptor</em>'.
	 * @generated
	 */
	ModelElementFactoryDescriptor createModelElementFactoryDescriptor();

	/**
	 * Returns a new object of class '<em>Standard Widget Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Standard Widget Type</em>'.
	 * @generated
	 */
	StandardWidgetType createStandardWidgetType();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	EnvironmentPackage getEnvironmentPackage();

} //EnvironmentFactory
