/**
 */
package Cpp;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see Cpp.CppPackage
 * @generated
 */
public interface CppFactory extends EFactory {

	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CppFactory eINSTANCE = Cpp.impl.CppFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Array</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Array</em>'.
	 * @generated
	 */
	CppArray createCppArray();

	/**
	 * Returns a new object of class '<em>Const</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Const</em>'.
	 * @generated
	 */
	CppConst createCppConst();

	/**
	 * Returns a new object of class '<em>Default</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Default</em>'.
	 * @generated
	 */
	CppDefault createCppDefault();

	/**
	 * Returns a new object of class '<em>Ptr</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ptr</em>'.
	 * @generated
	 */
	CppPtr createCppPtr();

	/**
	 * Returns a new object of class '<em>Ref</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ref</em>'.
	 * @generated
	 */
	CppRef createCppRef();

	/**
	 * Returns a new object of class '<em>Extern Class</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Extern Class</em>'.
	 * @generated
	 */
	CppExternClass createCppExternClass();

	/**
	 * Returns a new object of class '<em>Extern Library</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Extern Library</em>'.
	 * @generated
	 */
	CppExternLibrary createCppExternLibrary();

	/**
	 * Returns a new object of class '<em>Include</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Include</em>'.
	 * @generated
	 */
	CppInclude createCppInclude();

	/**
	 * Returns a new object of class '<em>Manual Generation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Manual Generation</em>'.
	 * @generated
	 */
	ManualGeneration createManualGeneration();

	/**
	 * Returns a new object of class '<em>Root</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Root</em>'.
	 * @generated
	 */
	CppRoot createCppRoot();

	/**
	 * Returns a new object of class '<em>No Code Gen</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>No Code Gen</em>'.
	 * @generated
	 */
	CppNoCodeGen createCppNoCodeGen();

	/**
	 * Returns a new object of class '<em>Const Init</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Const Init</em>'.
	 * @generated
	 */
	CppConstInit createCppConstInit();

	/**
	 * Returns a new object of class '<em>Friend</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Friend</em>'.
	 * @generated
	 */
	CppFriend createCppFriend();

	/**
	 * Returns a new object of class '<em>Inline</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Inline</em>'.
	 * @generated
	 */
	CppInline createCppInline();

	/**
	 * Returns a new object of class '<em>Virtual</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Virtual</em>'.
	 * @generated
	 */
	CppVirtual createCppVirtual();

	/**
	 * Returns a new object of class '<em>Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Type</em>'.
	 * @generated
	 */
	CppType createCppType();

	/**
	 * Returns a new object of class '<em>Visibility</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Visibility</em>'.
	 * @generated
	 */
	CppVisibility createCppVisibility();

	/**
	 * Returns a new object of class '<em>Init</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Init</em>'.
	 * @generated
	 */
	CppInit createCppInit();

	/**
	 * Returns a new object of class '<em>Template</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Template</em>'.
	 * @generated
	 */
	CppTemplate createCppTemplate();

	/**
	 * Returns a new object of class '<em>Template Binding</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Template Binding</em>'.
	 * @generated
	 */
	CppTemplateBinding createCppTemplateBinding();

	/**
	 * Returns a new object of class '<em>Template Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Template Parameter</em>'.
	 * @generated
	 */
	CppTemplateParameter createCppTemplateParameter();

	/**
	 * Returns a new object of class '<em>Union</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Union</em>'.
	 * @generated
	 */
	Union createUnion();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	CppPackage getCppPackage();

} //CppFactory
