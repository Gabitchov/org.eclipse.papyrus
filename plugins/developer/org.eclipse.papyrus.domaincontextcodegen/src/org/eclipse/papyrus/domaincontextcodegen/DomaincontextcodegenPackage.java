/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.domaincontextcodegen;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenFactory
 * @model kind="package"
 * @generated
 */
public interface DomaincontextcodegenPackage extends EPackage {

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "domaincontextcodegen";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/2010/domaincontextcodegen";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "domaincontextcodegen";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	DomaincontextcodegenPackage eINSTANCE = org.eclipse.papyrus.domaincontextcodegen.impl.DomaincontextcodegenPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.domaincontextcodegen.impl.DomainContextImpl <em>Domain Context</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.domaincontextcodegen.impl.DomainContextImpl
	 * @see org.eclipse.papyrus.domaincontextcodegen.impl.DomaincontextcodegenPackageImpl#getDomainContext()
	 * @generated
	 */
	int DOMAIN_CONTEXT = 0;

	/**
	 * The feature id for the '<em><b>Type Project Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DOMAIN_CONTEXT__TYPE_PROJECT_NAME = 0;

	/**
	 * The feature id for the '<em><b>Handler Project Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DOMAIN_CONTEXT__HANDLER_PROJECT_NAME = 1;

	/**
	 * The feature id for the '<em><b>IClient Context ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DOMAIN_CONTEXT__ICLIENT_CONTEXT_ID = 2;

	/**
	 * The feature id for the '<em><b>Metamodel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DOMAIN_CONTEXT__METAMODEL = 3;

	/**
	 * The feature id for the '<em><b>Specialization Of</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DOMAIN_CONTEXT__SPECIALIZATION_OF = 4;

	/**
	 * The feature id for the '<em><b>Element Type ID Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DOMAIN_CONTEXT__ELEMENT_TYPE_ID_PREFIX = 5;

	/**
	 * The feature id for the '<em><b>Element Type Name Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DOMAIN_CONTEXT__ELEMENT_TYPE_NAME_PREFIX = 6;

	/**
	 * The feature id for the '<em><b>Matcher Patch</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DOMAIN_CONTEXT__MATCHER_PATCH = 7;

	/**
	 * The feature id for the '<em><b>Element Types</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DOMAIN_CONTEXT__ELEMENT_TYPES = 8;

	/**
	 * The feature id for the '<em><b>Default Helper Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DOMAIN_CONTEXT__DEFAULT_HELPER_PATH = 9;

	/**
	 * The feature id for the '<em><b>Advicebindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DOMAIN_CONTEXT__ADVICEBINDINGS = 10;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DOMAIN_CONTEXT__BINDINGS = 11;

	/**
	 * The feature id for the '<em><b>Gen Handlers</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DOMAIN_CONTEXT__GEN_HANDLERS = 12;

	/**
	 * The feature id for the '<em><b>Generated Source Folder</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DOMAIN_CONTEXT__GENERATED_SOURCE_FOLDER = 13;

	/**
	 * The number of structural features of the '<em>Domain Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DOMAIN_CONTEXT_FEATURE_COUNT = 14;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.domaincontextcodegen.impl.ElementTypesImpl <em>Element Types</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.domaincontextcodegen.impl.ElementTypesImpl
	 * @see org.eclipse.papyrus.domaincontextcodegen.impl.DomaincontextcodegenPackageImpl#getElementTypes()
	 * @generated
	 */
	int ELEMENT_TYPES = 1;

	/**
	 * The feature id for the '<em><b>Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPES__TYPES = 0;

	/**
	 * The number of structural features of the '<em>Element Types</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPES_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.domaincontextcodegen.impl.ElementTypeImpl <em>Element Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.domaincontextcodegen.impl.ElementTypeImpl
	 * @see org.eclipse.papyrus.domaincontextcodegen.impl.DomaincontextcodegenPackageImpl#getElementType()
	 * @generated
	 */
	int ELEMENT_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Meta Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPE__META_CLASS = 0;

	/**
	 * The feature id for the '<em><b>Specific Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPE__SPECIFIC_NAME = 1;

	/**
	 * The feature id for the '<em><b>Edithelper Edit Helper Advice Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPE__EDITHELPER_EDIT_HELPER_ADVICE_PATH = 2;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPE__KIND = 3;

	/**
	 * The feature id for the '<em><b>Specializationof</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPE__SPECIALIZATIONOF = 4;

	/**
	 * The feature id for the '<em><b>Specialization IDof</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPE__SPECIALIZATION_IDOF = 5;

	/**
	 * The number of structural features of the '<em>Element Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPE_FEATURE_COUNT = 6;


	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.domaincontextcodegen.impl.AdviceBindingImpl <em>Advice Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.domaincontextcodegen.impl.AdviceBindingImpl
	 * @see org.eclipse.papyrus.domaincontextcodegen.impl.DomaincontextcodegenPackageImpl#getAdviceBinding()
	 * @generated
	 */
	int ADVICE_BINDING = 3;

	/**
	 * The feature id for the '<em><b>Advice Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ADVICE_BINDING__ADVICE_PATH = 0;

	/**
	 * The feature id for the '<em><b>Advice ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ADVICE_BINDING__ADVICE_ID = 1;

	/**
	 * The feature id for the '<em><b>Inheritance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ADVICE_BINDING__INHERITANCE = 2;

	/**
	 * The feature id for the '<em><b>Element Type Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ADVICE_BINDING__ELEMENT_TYPE_REF = 3;

	/**
	 * The feature id for the '<em><b>Element Type IDref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ADVICE_BINDING__ELEMENT_TYPE_IDREF = 4;

	/**
	 * The number of structural features of the '<em>Advice Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ADVICE_BINDING_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.domaincontextcodegen.impl.BindingImpl <em>Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.domaincontextcodegen.impl.BindingImpl
	 * @see org.eclipse.papyrus.domaincontextcodegen.impl.DomaincontextcodegenPackageImpl#getBinding()
	 * @generated
	 */
	int BINDING = 4;

	/**
	 * The feature id for the '<em><b>Advice</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BINDING__ADVICE = 0;

	/**
	 * The feature id for the '<em><b>Element Type Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BINDING__ELEMENT_TYPE_PATTERN = 1;

	/**
	 * The feature id for the '<em><b>Advice ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BINDING__ADVICE_ID = 2;

	/**
	 * The number of structural features of the '<em>Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BINDING_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.domaincontextcodegen.impl.GenHandlersImpl <em>Gen Handlers</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.domaincontextcodegen.impl.GenHandlersImpl
	 * @see org.eclipse.papyrus.domaincontextcodegen.impl.DomaincontextcodegenPackageImpl#getGenHandlers()
	 * @generated
	 */
	int GEN_HANDLERS = 5;

	/**
	 * The feature id for the '<em><b>Handler Package</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GEN_HANDLERS__HANDLER_PACKAGE = 0;

	/**
	 * The feature id for the '<em><b>Super Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GEN_HANDLERS__SUPER_CLASS = 1;

	/**
	 * The feature id for the '<em><b>Super Class Package</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GEN_HANDLERS__SUPER_CLASS_PACKAGE = 2;

	/**
	 * The feature id for the '<em><b>Element Type Enumerator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GEN_HANDLERS__ELEMENT_TYPE_ENUMERATOR = 3;

	/**
	 * The feature id for the '<em><b>Element Type Enumerator Package</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GEN_HANDLERS__ELEMENT_TYPE_ENUMERATOR_PACKAGE = 4;

	/**
	 * The number of structural features of the '<em>Gen Handlers</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GEN_HANDLERS_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.domaincontextcodegen.InheritanceKind <em>Inheritance Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.domaincontextcodegen.InheritanceKind
	 * @see org.eclipse.papyrus.domaincontextcodegen.impl.DomaincontextcodegenPackageImpl#getInheritanceKind()
	 * @generated
	 */
	int INHERITANCE_KIND = 6;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.domaincontextcodegen.DomainContext <em>Domain Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Domain Context</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.DomainContext
	 * @generated
	 */
	EClass getDomainContext();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.domaincontextcodegen.DomainContext#getTypeProjectName
	 * <em>Type Project Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Type Project Name</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.DomainContext#getTypeProjectName()
	 * @see #getDomainContext()
	 * @generated
	 */
	EAttribute getDomainContext_TypeProjectName();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.domaincontextcodegen.DomainContext#getHandlerProjectName
	 * <em>Handler Project Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Handler Project Name</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.DomainContext#getHandlerProjectName()
	 * @see #getDomainContext()
	 * @generated
	 */
	EAttribute getDomainContext_HandlerProjectName();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.domaincontextcodegen.DomainContext#getIClientContextID
	 * <em>IClient Context ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>IClient Context ID</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.DomainContext#getIClientContextID()
	 * @see #getDomainContext()
	 * @generated
	 */
	EAttribute getDomainContext_IClientContextID();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.domaincontextcodegen.DomainContext#getMetamodel <em>Metamodel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Metamodel</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.DomainContext#getMetamodel()
	 * @see #getDomainContext()
	 * @generated
	 */
	EReference getDomainContext_Metamodel();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.domaincontextcodegen.DomainContext#getSpecializationOf
	 * <em>Specialization Of</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Specialization Of</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.DomainContext#getSpecializationOf()
	 * @see #getDomainContext()
	 * @generated
	 */
	EReference getDomainContext_SpecializationOf();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.domaincontextcodegen.DomainContext#getElementTypeIDPrefix
	 * <em>Element Type ID Prefix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Element Type ID Prefix</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.DomainContext#getElementTypeIDPrefix()
	 * @see #getDomainContext()
	 * @generated
	 */
	EAttribute getDomainContext_ElementTypeIDPrefix();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.domaincontextcodegen.DomainContext#getElementTypeNamePrefix
	 * <em>Element Type Name Prefix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Element Type Name Prefix</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.DomainContext#getElementTypeNamePrefix()
	 * @see #getDomainContext()
	 * @generated
	 */
	EAttribute getDomainContext_ElementTypeNamePrefix();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.domaincontextcodegen.DomainContext#getMatcherPatch
	 * <em>Matcher Patch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Matcher Patch</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.DomainContext#getMatcherPatch()
	 * @see #getDomainContext()
	 * @generated
	 */
	EAttribute getDomainContext_MatcherPatch();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.domaincontextcodegen.DomainContext#getElementTypes
	 * <em>Element Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Element Types</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.DomainContext#getElementTypes()
	 * @see #getDomainContext()
	 * @generated
	 */
	EReference getDomainContext_ElementTypes();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.domaincontextcodegen.DomainContext#getDefaultHelperPath
	 * <em>Default Helper Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Default Helper Path</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.DomainContext#getDefaultHelperPath()
	 * @see #getDomainContext()
	 * @generated
	 */
	EAttribute getDomainContext_DefaultHelperPath();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.domaincontextcodegen.DomainContext#getAdvicebindings
	 * <em>Advicebindings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Advicebindings</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.DomainContext#getAdvicebindings()
	 * @see #getDomainContext()
	 * @generated
	 */
	EReference getDomainContext_Advicebindings();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.domaincontextcodegen.DomainContext#getBindings
	 * <em>Bindings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Bindings</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.DomainContext#getBindings()
	 * @see #getDomainContext()
	 * @generated
	 */
	EReference getDomainContext_Bindings();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.domaincontextcodegen.DomainContext#getGenHandlers
	 * <em>Gen Handlers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Gen Handlers</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.DomainContext#getGenHandlers()
	 * @see #getDomainContext()
	 * @generated
	 */
	EReference getDomainContext_GenHandlers();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.domaincontextcodegen.DomainContext#getGeneratedSourceFolder
	 * <em>Generated Source Folder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Generated Source Folder</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.DomainContext#getGeneratedSourceFolder()
	 * @see #getDomainContext()
	 * @generated
	 */
	EAttribute getDomainContext_GeneratedSourceFolder();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.domaincontextcodegen.ElementTypes <em>Element Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Element Types</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.ElementTypes
	 * @generated
	 */
	EClass getElementTypes();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.domaincontextcodegen.ElementTypes#getTypes
	 * <em>Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Types</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.ElementTypes#getTypes()
	 * @see #getElementTypes()
	 * @generated
	 */
	EReference getElementTypes_Types();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.domaincontextcodegen.ElementType <em>Element Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Element Type</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.ElementType
	 * @generated
	 */
	EClass getElementType();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.domaincontextcodegen.ElementType#getMetaClass <em>Meta Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Meta Class</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.ElementType#getMetaClass()
	 * @see #getElementType()
	 * @generated
	 */
	EReference getElementType_MetaClass();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.domaincontextcodegen.ElementType#getSpecificName <em>Specific Name</em>}
	 * '.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Specific Name</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.ElementType#getSpecificName()
	 * @see #getElementType()
	 * @generated
	 */
	EAttribute getElementType_SpecificName();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.domaincontextcodegen.ElementType#getEdithelper_EditHelperAdvicePath
	 * <em>Edithelper Edit Helper Advice Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Edithelper Edit Helper Advice Path</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.ElementType#getEdithelper_EditHelperAdvicePath()
	 * @see #getElementType()
	 * @generated
	 */
	EAttribute getElementType_Edithelper_EditHelperAdvicePath();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.domaincontextcodegen.ElementType#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.ElementType#getKind()
	 * @see #getElementType()
	 * @generated
	 */
	EAttribute getElementType_Kind();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.domaincontextcodegen.ElementType#getSpecializationof
	 * <em>Specializationof</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Specializationof</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.ElementType#getSpecializationof()
	 * @see #getElementType()
	 * @generated
	 */
	EReference getElementType_Specializationof();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.domaincontextcodegen.ElementType#getSpecializationIDof
	 * <em>Specialization IDof</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Specialization IDof</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.ElementType#getSpecializationIDof()
	 * @see #getElementType()
	 * @generated
	 */
	EAttribute getElementType_SpecializationIDof();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.domaincontextcodegen.AdviceBinding <em>Advice Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Advice Binding</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.AdviceBinding
	 * @generated
	 */
	EClass getAdviceBinding();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.domaincontextcodegen.AdviceBinding#getAdvicePath <em>Advice Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Advice Path</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.AdviceBinding#getAdvicePath()
	 * @see #getAdviceBinding()
	 * @generated
	 */
	EAttribute getAdviceBinding_AdvicePath();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.domaincontextcodegen.AdviceBinding#getAdviceID <em>Advice ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Advice ID</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.AdviceBinding#getAdviceID()
	 * @see #getAdviceBinding()
	 * @generated
	 */
	EAttribute getAdviceBinding_AdviceID();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.domaincontextcodegen.AdviceBinding#getInheritance <em>Inheritance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Inheritance</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.AdviceBinding#getInheritance()
	 * @see #getAdviceBinding()
	 * @generated
	 */
	EAttribute getAdviceBinding_Inheritance();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.domaincontextcodegen.AdviceBinding#getElementTypeRef
	 * <em>Element Type Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Element Type Ref</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.AdviceBinding#getElementTypeRef()
	 * @see #getAdviceBinding()
	 * @generated
	 */
	EReference getAdviceBinding_ElementTypeRef();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.domaincontextcodegen.AdviceBinding#getElementTypeIDref
	 * <em>Element Type IDref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Element Type IDref</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.AdviceBinding#getElementTypeIDref()
	 * @see #getAdviceBinding()
	 * @generated
	 */
	EAttribute getAdviceBinding_ElementTypeIDref();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.domaincontextcodegen.Binding <em>Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Binding</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.Binding
	 * @generated
	 */
	EClass getBinding();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.domaincontextcodegen.Binding#getAdvice <em>Advice</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Advice</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.Binding#getAdvice()
	 * @see #getBinding()
	 * @generated
	 */
	EReference getBinding_Advice();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.domaincontextcodegen.Binding#getElementTypePattern
	 * <em>Element Type Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Element Type Pattern</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.Binding#getElementTypePattern()
	 * @see #getBinding()
	 * @generated
	 */
	EAttribute getBinding_ElementTypePattern();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.domaincontextcodegen.Binding#getAdviceID <em>Advice ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Advice ID</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.Binding#getAdviceID()
	 * @see #getBinding()
	 * @generated
	 */
	EAttribute getBinding_AdviceID();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.domaincontextcodegen.GenHandlers <em>Gen Handlers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Gen Handlers</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.GenHandlers
	 * @generated
	 */
	EClass getGenHandlers();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.domaincontextcodegen.GenHandlers#getHandlerPackage
	 * <em>Handler Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Handler Package</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.GenHandlers#getHandlerPackage()
	 * @see #getGenHandlers()
	 * @generated
	 */
	EAttribute getGenHandlers_HandlerPackage();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.domaincontextcodegen.GenHandlers#getSuperClass <em>Super Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Super Class</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.GenHandlers#getSuperClass()
	 * @see #getGenHandlers()
	 * @generated
	 */
	EAttribute getGenHandlers_SuperClass();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.domaincontextcodegen.GenHandlers#getSuperClassPackage
	 * <em>Super Class Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Super Class Package</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.GenHandlers#getSuperClassPackage()
	 * @see #getGenHandlers()
	 * @generated
	 */
	EAttribute getGenHandlers_SuperClassPackage();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.domaincontextcodegen.GenHandlers#getElementTypeEnumerator
	 * <em>Element Type Enumerator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Element Type Enumerator</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.GenHandlers#getElementTypeEnumerator()
	 * @see #getGenHandlers()
	 * @generated
	 */
	EAttribute getGenHandlers_ElementTypeEnumerator();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.domaincontextcodegen.GenHandlers#getElementTypeEnumeratorPackage
	 * <em>Element Type Enumerator Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Element Type Enumerator Package</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.GenHandlers#getElementTypeEnumeratorPackage()
	 * @see #getGenHandlers()
	 * @generated
	 */
	EAttribute getGenHandlers_ElementTypeEnumeratorPackage();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.domaincontextcodegen.InheritanceKind <em>Inheritance Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for enum '<em>Inheritance Kind</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.InheritanceKind
	 * @generated
	 */
	EEnum getInheritanceKind();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DomaincontextcodegenFactory getDomaincontextcodegenFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	interface Literals {

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.domaincontextcodegen.impl.DomainContextImpl <em>Domain Context</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.domaincontextcodegen.impl.DomainContextImpl
		 * @see org.eclipse.papyrus.domaincontextcodegen.impl.DomaincontextcodegenPackageImpl#getDomainContext()
		 * @generated
		 */
		EClass DOMAIN_CONTEXT = eINSTANCE.getDomainContext();

		/**
		 * The meta object literal for the '<em><b>Type Project Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DOMAIN_CONTEXT__TYPE_PROJECT_NAME = eINSTANCE.getDomainContext_TypeProjectName();

		/**
		 * The meta object literal for the '<em><b>Handler Project Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DOMAIN_CONTEXT__HANDLER_PROJECT_NAME = eINSTANCE.getDomainContext_HandlerProjectName();

		/**
		 * The meta object literal for the '<em><b>IClient Context ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DOMAIN_CONTEXT__ICLIENT_CONTEXT_ID = eINSTANCE.getDomainContext_IClientContextID();

		/**
		 * The meta object literal for the '<em><b>Metamodel</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference DOMAIN_CONTEXT__METAMODEL = eINSTANCE.getDomainContext_Metamodel();

		/**
		 * The meta object literal for the '<em><b>Specialization Of</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference DOMAIN_CONTEXT__SPECIALIZATION_OF = eINSTANCE.getDomainContext_SpecializationOf();

		/**
		 * The meta object literal for the '<em><b>Element Type ID Prefix</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DOMAIN_CONTEXT__ELEMENT_TYPE_ID_PREFIX = eINSTANCE.getDomainContext_ElementTypeIDPrefix();

		/**
		 * The meta object literal for the '<em><b>Element Type Name Prefix</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DOMAIN_CONTEXT__ELEMENT_TYPE_NAME_PREFIX = eINSTANCE.getDomainContext_ElementTypeNamePrefix();

		/**
		 * The meta object literal for the '<em><b>Matcher Patch</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DOMAIN_CONTEXT__MATCHER_PATCH = eINSTANCE.getDomainContext_MatcherPatch();

		/**
		 * The meta object literal for the '<em><b>Element Types</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference DOMAIN_CONTEXT__ELEMENT_TYPES = eINSTANCE.getDomainContext_ElementTypes();

		/**
		 * The meta object literal for the '<em><b>Default Helper Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DOMAIN_CONTEXT__DEFAULT_HELPER_PATH = eINSTANCE.getDomainContext_DefaultHelperPath();

		/**
		 * The meta object literal for the '<em><b>Advicebindings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference DOMAIN_CONTEXT__ADVICEBINDINGS = eINSTANCE.getDomainContext_Advicebindings();

		/**
		 * The meta object literal for the '<em><b>Bindings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference DOMAIN_CONTEXT__BINDINGS = eINSTANCE.getDomainContext_Bindings();

		/**
		 * The meta object literal for the '<em><b>Gen Handlers</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference DOMAIN_CONTEXT__GEN_HANDLERS = eINSTANCE.getDomainContext_GenHandlers();

		/**
		 * The meta object literal for the '<em><b>Generated Source Folder</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DOMAIN_CONTEXT__GENERATED_SOURCE_FOLDER = eINSTANCE.getDomainContext_GeneratedSourceFolder();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.domaincontextcodegen.impl.ElementTypesImpl <em>Element Types</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.domaincontextcodegen.impl.ElementTypesImpl
		 * @see org.eclipse.papyrus.domaincontextcodegen.impl.DomaincontextcodegenPackageImpl#getElementTypes()
		 * @generated
		 */
		EClass ELEMENT_TYPES = eINSTANCE.getElementTypes();

		/**
		 * The meta object literal for the '<em><b>Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ELEMENT_TYPES__TYPES = eINSTANCE.getElementTypes_Types();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.domaincontextcodegen.impl.ElementTypeImpl <em>Element Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.domaincontextcodegen.impl.ElementTypeImpl
		 * @see org.eclipse.papyrus.domaincontextcodegen.impl.DomaincontextcodegenPackageImpl#getElementType()
		 * @generated
		 */
		EClass ELEMENT_TYPE = eINSTANCE.getElementType();

		/**
		 * The meta object literal for the '<em><b>Meta Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ELEMENT_TYPE__META_CLASS = eINSTANCE.getElementType_MetaClass();

		/**
		 * The meta object literal for the '<em><b>Specific Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ELEMENT_TYPE__SPECIFIC_NAME = eINSTANCE.getElementType_SpecificName();

		/**
		 * The meta object literal for the '<em><b>Edithelper Edit Helper Advice Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ELEMENT_TYPE__EDITHELPER_EDIT_HELPER_ADVICE_PATH = eINSTANCE.getElementType_Edithelper_EditHelperAdvicePath();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ELEMENT_TYPE__KIND = eINSTANCE.getElementType_Kind();

		/**
		 * The meta object literal for the '<em><b>Specializationof</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ELEMENT_TYPE__SPECIALIZATIONOF = eINSTANCE.getElementType_Specializationof();

		/**
		 * The meta object literal for the '<em><b>Specialization IDof</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ELEMENT_TYPE__SPECIALIZATION_IDOF = eINSTANCE.getElementType_SpecializationIDof();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.domaincontextcodegen.impl.AdviceBindingImpl <em>Advice Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.domaincontextcodegen.impl.AdviceBindingImpl
		 * @see org.eclipse.papyrus.domaincontextcodegen.impl.DomaincontextcodegenPackageImpl#getAdviceBinding()
		 * @generated
		 */
		EClass ADVICE_BINDING = eINSTANCE.getAdviceBinding();

		/**
		 * The meta object literal for the '<em><b>Advice Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ADVICE_BINDING__ADVICE_PATH = eINSTANCE.getAdviceBinding_AdvicePath();

		/**
		 * The meta object literal for the '<em><b>Advice ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ADVICE_BINDING__ADVICE_ID = eINSTANCE.getAdviceBinding_AdviceID();

		/**
		 * The meta object literal for the '<em><b>Inheritance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ADVICE_BINDING__INHERITANCE = eINSTANCE.getAdviceBinding_Inheritance();

		/**
		 * The meta object literal for the '<em><b>Element Type Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ADVICE_BINDING__ELEMENT_TYPE_REF = eINSTANCE.getAdviceBinding_ElementTypeRef();

		/**
		 * The meta object literal for the '<em><b>Element Type IDref</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ADVICE_BINDING__ELEMENT_TYPE_IDREF = eINSTANCE.getAdviceBinding_ElementTypeIDref();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.domaincontextcodegen.impl.BindingImpl <em>Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.domaincontextcodegen.impl.BindingImpl
		 * @see org.eclipse.papyrus.domaincontextcodegen.impl.DomaincontextcodegenPackageImpl#getBinding()
		 * @generated
		 */
		EClass BINDING = eINSTANCE.getBinding();

		/**
		 * The meta object literal for the '<em><b>Advice</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference BINDING__ADVICE = eINSTANCE.getBinding_Advice();

		/**
		 * The meta object literal for the '<em><b>Element Type Pattern</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute BINDING__ELEMENT_TYPE_PATTERN = eINSTANCE.getBinding_ElementTypePattern();

		/**
		 * The meta object literal for the '<em><b>Advice ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute BINDING__ADVICE_ID = eINSTANCE.getBinding_AdviceID();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.domaincontextcodegen.impl.GenHandlersImpl <em>Gen Handlers</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.domaincontextcodegen.impl.GenHandlersImpl
		 * @see org.eclipse.papyrus.domaincontextcodegen.impl.DomaincontextcodegenPackageImpl#getGenHandlers()
		 * @generated
		 */
		EClass GEN_HANDLERS = eINSTANCE.getGenHandlers();

		/**
		 * The meta object literal for the '<em><b>Handler Package</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute GEN_HANDLERS__HANDLER_PACKAGE = eINSTANCE.getGenHandlers_HandlerPackage();

		/**
		 * The meta object literal for the '<em><b>Super Class</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute GEN_HANDLERS__SUPER_CLASS = eINSTANCE.getGenHandlers_SuperClass();

		/**
		 * The meta object literal for the '<em><b>Super Class Package</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute GEN_HANDLERS__SUPER_CLASS_PACKAGE = eINSTANCE.getGenHandlers_SuperClassPackage();

		/**
		 * The meta object literal for the '<em><b>Element Type Enumerator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute GEN_HANDLERS__ELEMENT_TYPE_ENUMERATOR = eINSTANCE.getGenHandlers_ElementTypeEnumerator();

		/**
		 * The meta object literal for the '<em><b>Element Type Enumerator Package</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute GEN_HANDLERS__ELEMENT_TYPE_ENUMERATOR_PACKAGE = eINSTANCE.getGenHandlers_ElementTypeEnumeratorPackage();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.domaincontextcodegen.InheritanceKind <em>Inheritance Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.domaincontextcodegen.InheritanceKind
		 * @see org.eclipse.papyrus.domaincontextcodegen.impl.DomaincontextcodegenPackageImpl#getInheritanceKind()
		 * @generated
		 */
		EEnum INHERITANCE_KIND = eINSTANCE.getInheritanceKind();

	}

} //DomaincontextcodegenPackage
