/**
 */
package org.eclipse.papyrus.facade.extensiondefinition;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.facade.extensiondefinition.ExtensiondefinitionPackage
 * @generated
 */
public interface ExtensiondefinitionFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ExtensiondefinitionFactory eINSTANCE = org.eclipse.papyrus.facade.extensiondefinition.impl.ExtensiondefinitionFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Extension Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Extension Definition</em>'.
	 * @generated
	 */
	ExtensionDefinition createExtensionDefinition();

	/**
	 * Returns a new object of class '<em>Base Metaclass</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Base Metaclass</em>'.
	 * @generated
	 */
	BaseMetaclass createBaseMetaclass();

	/**
	 * Returns a new object of class '<em>Combination</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Combination</em>'.
	 * @generated
	 */
	Combination createCombination();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ExtensiondefinitionPackage getExtensiondefinitionPackage();

} //ExtensiondefinitionFactory
