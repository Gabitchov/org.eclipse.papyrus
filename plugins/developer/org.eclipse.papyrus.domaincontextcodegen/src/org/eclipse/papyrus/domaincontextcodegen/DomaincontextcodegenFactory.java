/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.domaincontextcodegen;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage
 * @generated
 */
public interface DomaincontextcodegenFactory extends EFactory {

	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	DomaincontextcodegenFactory eINSTANCE = org.eclipse.papyrus.domaincontextcodegen.impl.DomaincontextcodegenFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Domain Context</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Domain Context</em>'.
	 * @generated
	 */
	DomainContext createDomainContext();

	/**
	 * Returns a new object of class '<em>Element Types</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Element Types</em>'.
	 * @generated
	 */
	ElementTypes createElementTypes();

	/**
	 * Returns a new object of class '<em>Meta Class Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Meta Class Type</em>'.
	 * @generated
	 */
	MetaClassType createMetaClassType();

	/**
	 * Returns a new object of class '<em>Specialization Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Specialization Type</em>'.
	 * @generated
	 */
	SpecializationType createSpecializationType();

	/**
	 * Returns a new object of class '<em>Advice</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Advice</em>'.
	 * @generated
	 */
	Advice createAdvice();

	/**
	 * Returns a new object of class '<em>Element Type Bindings</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Element Type Bindings</em>'.
	 * @generated
	 */
	ElementTypeBindings createElementTypeBindings();

	/**
	 * Returns a new object of class '<em>Element Type Binding</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Element Type Binding</em>'.
	 * @generated
	 */
	ElementTypeBinding createElementTypeBinding();

	/**
	 * Returns a new object of class '<em>Advice Binding</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Advice Binding</em>'.
	 * @generated
	 */
	AdviceBinding createAdviceBinding();

	/**
	 * Returns a new object of class '<em>Gen Handlers</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Gen Handlers</em>'.
	 * @generated
	 */
	GenHandlers createGenHandlers();

	/**
	 * Returns a new object of class '<em>Stereotyped Element Matcher</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Stereotyped Element Matcher</em>'.
	 * @generated
	 */
	StereotypedElementMatcher createStereotypedElementMatcher();

	/**
	 * Returns a new object of class '<em>Stereotyped Element Helper</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Stereotyped Element Helper</em>'.
	 * @generated
	 */
	StereotypedElementHelper createStereotypedElementHelper();

	/**
	 * Returns a new object of class '<em>Menu Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Menu Declaration</em>'.
	 * @generated
	 */
	MenuDeclaration createMenuDeclaration();

	/**
	 * Returns a new object of class '<em>Command Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Command Declaration</em>'.
	 * @generated
	 */
	CommandDeclaration createCommandDeclaration();

	/**
	 * Returns a new object of class '<em>Command</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Command</em>'.
	 * @generated
	 */
	Command createCommand();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the package supported by this factory.
	 * @generated
	 */
	DomaincontextcodegenPackage getDomaincontextcodegenPackage();

} //DomaincontextcodegenFactory
