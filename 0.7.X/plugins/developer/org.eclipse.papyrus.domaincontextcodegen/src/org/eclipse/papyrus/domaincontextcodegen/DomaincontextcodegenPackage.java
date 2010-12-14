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
	 * The feature id for the '<em><b>Element Types</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DOMAIN_CONTEXT__ELEMENT_TYPES = 7;

	/**
	 * The feature id for the '<em><b>Default Helper Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DOMAIN_CONTEXT__DEFAULT_HELPER_PATH = 8;

	/**
	 * The feature id for the '<em><b>Advices</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DOMAIN_CONTEXT__ADVICES = 9;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DOMAIN_CONTEXT__BINDINGS = 10;

	/**
	 * The feature id for the '<em><b>Gen Handlers</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DOMAIN_CONTEXT__GEN_HANDLERS = 11;

	/**
	 * The feature id for the '<em><b>Generated Source Folder</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DOMAIN_CONTEXT__GENERATED_SOURCE_FOLDER = 12;

	/**
	 * The feature id for the '<em><b>Menu</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DOMAIN_CONTEXT__MENU = 13;

	/**
	 * The feature id for the '<em><b>Command</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DOMAIN_CONTEXT__COMMAND = 14;

	/**
	 * The number of structural features of the '<em>Domain Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DOMAIN_CONTEXT_FEATURE_COUNT = 15;

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
	 * The feature id for the '<em><b>Domain</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPES__DOMAIN = 1;

	/**
	 * The number of structural features of the '<em>Element Types</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPES_FEATURE_COUNT = 2;

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
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Helper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPE__HELPER = 1;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPE__OWNER = 2;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPE__ICON = 3;

	/**
	 * The number of structural features of the '<em>Element Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.domaincontextcodegen.impl.MetaClassTypeImpl <em>Meta Class Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.domaincontextcodegen.impl.MetaClassTypeImpl
	 * @see org.eclipse.papyrus.domaincontextcodegen.impl.DomaincontextcodegenPackageImpl#getMetaClassType()
	 * @generated
	 */
	int META_CLASS_TYPE = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int META_CLASS_TYPE__NAME = ELEMENT_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Helper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int META_CLASS_TYPE__HELPER = ELEMENT_TYPE__HELPER;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int META_CLASS_TYPE__OWNER = ELEMENT_TYPE__OWNER;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int META_CLASS_TYPE__ICON = ELEMENT_TYPE__ICON;

	/**
	 * The feature id for the '<em><b>Meta Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int META_CLASS_TYPE__META_CLASS = ELEMENT_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Meta Class Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int META_CLASS_TYPE_FEATURE_COUNT = ELEMENT_TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.domaincontextcodegen.impl.SpecializationTypeImpl <em>Specialization Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.domaincontextcodegen.impl.SpecializationTypeImpl
	 * @see org.eclipse.papyrus.domaincontextcodegen.impl.DomaincontextcodegenPackageImpl#getSpecializationType()
	 * @generated
	 */
	int SPECIALIZATION_TYPE = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SPECIALIZATION_TYPE__NAME = ELEMENT_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Helper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SPECIALIZATION_TYPE__HELPER = ELEMENT_TYPE__HELPER;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SPECIALIZATION_TYPE__OWNER = ELEMENT_TYPE__OWNER;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SPECIALIZATION_TYPE__ICON = ELEMENT_TYPE__ICON;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SPECIALIZATION_TYPE__REF = ELEMENT_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Matcher</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SPECIALIZATION_TYPE__MATCHER = ELEMENT_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Gen Matcher</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SPECIALIZATION_TYPE__GEN_MATCHER = ELEMENT_TYPE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Gen Helper</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SPECIALIZATION_TYPE__GEN_HELPER = ELEMENT_TYPE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Specialization Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SPECIALIZATION_TYPE_FEATURE_COUNT = ELEMENT_TYPE_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.domaincontextcodegen.impl.AdviceImpl <em>Advice</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.domaincontextcodegen.impl.AdviceImpl
	 * @see org.eclipse.papyrus.domaincontextcodegen.impl.DomaincontextcodegenPackageImpl#getAdvice()
	 * @generated
	 */
	int ADVICE = 5;

	/**
	 * The feature id for the '<em><b>Advice ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ADVICE__ADVICE_ID = 0;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ADVICE__REF = 1;

	/**
	 * The feature id for the '<em><b>Advice Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ADVICE__ADVICE_PATH = 2;

	/**
	 * The feature id for the '<em><b>Inheritance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ADVICE__INHERITANCE = 3;

	/**
	 * The number of structural features of the '<em>Advice</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ADVICE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.domaincontextcodegen.impl.ElementTypeBindingsImpl <em>Element Type Bindings</em>}'
	 * class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.domaincontextcodegen.impl.ElementTypeBindingsImpl
	 * @see org.eclipse.papyrus.domaincontextcodegen.impl.DomaincontextcodegenPackageImpl#getElementTypeBindings()
	 * @generated
	 */
	int ELEMENT_TYPE_BINDINGS = 6;

	/**
	 * The feature id for the '<em><b>Client Context ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPE_BINDINGS__CLIENT_CONTEXT_ID = 0;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPE_BINDINGS__BINDINGS = 1;

	/**
	 * The number of structural features of the '<em>Element Type Bindings</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPE_BINDINGS_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.domaincontextcodegen.impl.AdviceBindingImpl <em>Advice Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.domaincontextcodegen.impl.AdviceBindingImpl
	 * @see org.eclipse.papyrus.domaincontextcodegen.impl.DomaincontextcodegenPackageImpl#getAdviceBinding()
	 * @generated
	 */
	int ADVICE_BINDING = 9;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.domaincontextcodegen.impl.BindingImpl <em>Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.domaincontextcodegen.impl.BindingImpl
	 * @see org.eclipse.papyrus.domaincontextcodegen.impl.DomaincontextcodegenPackageImpl#getBinding()
	 * @generated
	 */
	int BINDING = 7;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BINDING__OWNER = 0;

	/**
	 * The feature id for the '<em><b>Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BINDING__PATTERN = 1;

	/**
	 * The number of structural features of the '<em>Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BINDING_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.domaincontextcodegen.impl.ElementTypeBindingImpl <em>Element Type Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.domaincontextcodegen.impl.ElementTypeBindingImpl
	 * @see org.eclipse.papyrus.domaincontextcodegen.impl.DomaincontextcodegenPackageImpl#getElementTypeBinding()
	 * @generated
	 */
	int ELEMENT_TYPE_BINDING = 8;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPE_BINDING__OWNER = BINDING__OWNER;

	/**
	 * The feature id for the '<em><b>Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPE_BINDING__PATTERN = BINDING__PATTERN;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPE_BINDING__REF = BINDING_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Element Type Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPE_BINDING_FEATURE_COUNT = BINDING_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ADVICE_BINDING__OWNER = BINDING__OWNER;

	/**
	 * The feature id for the '<em><b>Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ADVICE_BINDING__PATTERN = BINDING__PATTERN;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ADVICE_BINDING__REF = BINDING_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Advice Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ADVICE_BINDING_FEATURE_COUNT = BINDING_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.domaincontextcodegen.impl.GenHandlersImpl <em>Gen Handlers</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.domaincontextcodegen.impl.GenHandlersImpl
	 * @see org.eclipse.papyrus.domaincontextcodegen.impl.DomaincontextcodegenPackageImpl#getGenHandlers()
	 * @generated
	 */
	int GEN_HANDLERS = 10;

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
	 * The feature id for the '<em><b>Visible Create Child Handlers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GEN_HANDLERS__VISIBLE_CREATE_CHILD_HANDLERS = 5;

	/**
	 * The feature id for the '<em><b>Parent Domain Create Child</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GEN_HANDLERS__PARENT_DOMAIN_CREATE_CHILD = 6;

	/**
	 * The feature id for the '<em><b>Create Child Menu Location URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GEN_HANDLERS__CREATE_CHILD_MENU_LOCATION_URI = 7;

	/**
	 * The number of structural features of the '<em>Gen Handlers</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GEN_HANDLERS_FEATURE_COUNT = 8;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.domaincontextcodegen.impl.GenMatcherImpl <em>Gen Matcher</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.domaincontextcodegen.impl.GenMatcherImpl
	 * @see org.eclipse.papyrus.domaincontextcodegen.impl.DomaincontextcodegenPackageImpl#getGenMatcher()
	 * @generated
	 */
	int GEN_MATCHER = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GEN_MATCHER__NAME = 0;

	/**
	 * The number of structural features of the '<em>Gen Matcher</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GEN_MATCHER_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.domaincontextcodegen.impl.GenHelperImpl <em>Gen Helper</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.domaincontextcodegen.impl.GenHelperImpl
	 * @see org.eclipse.papyrus.domaincontextcodegen.impl.DomaincontextcodegenPackageImpl#getGenHelper()
	 * @generated
	 */
	int GEN_HELPER = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GEN_HELPER__NAME = 0;

	/**
	 * The number of structural features of the '<em>Gen Helper</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GEN_HELPER_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.domaincontextcodegen.impl.StereotypedElementMatcherImpl
	 * <em>Stereotyped Element Matcher</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.domaincontextcodegen.impl.StereotypedElementMatcherImpl
	 * @see org.eclipse.papyrus.domaincontextcodegen.impl.DomaincontextcodegenPackageImpl#getStereotypedElementMatcher()
	 * @generated
	 */
	int STEREOTYPED_ELEMENT_MATCHER = 13;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STEREOTYPED_ELEMENT_MATCHER__NAME = GEN_MATCHER__NAME;

	/**
	 * The feature id for the '<em><b>Stereotype Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STEREOTYPED_ELEMENT_MATCHER__STEREOTYPE_NAME = GEN_MATCHER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Stereotype Package</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STEREOTYPED_ELEMENT_MATCHER__STEREOTYPE_PACKAGE = GEN_MATCHER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Base Element Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STEREOTYPED_ELEMENT_MATCHER__BASE_ELEMENT_NAME = GEN_MATCHER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Base Element Package</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STEREOTYPED_ELEMENT_MATCHER__BASE_ELEMENT_PACKAGE = GEN_MATCHER_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Stereotyped Element Matcher</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STEREOTYPED_ELEMENT_MATCHER_FEATURE_COUNT = GEN_MATCHER_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.domaincontextcodegen.impl.StereotypedElementHelperImpl
	 * <em>Stereotyped Element Helper</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.domaincontextcodegen.impl.StereotypedElementHelperImpl
	 * @see org.eclipse.papyrus.domaincontextcodegen.impl.DomaincontextcodegenPackageImpl#getStereotypedElementHelper()
	 * @generated
	 */
	int STEREOTYPED_ELEMENT_HELPER = 14;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STEREOTYPED_ELEMENT_HELPER__NAME = GEN_HELPER__NAME;

	/**
	 * The feature id for the '<em><b>Stereotype Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STEREOTYPED_ELEMENT_HELPER__STEREOTYPE_NAME = GEN_HELPER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Stereotype Package</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STEREOTYPED_ELEMENT_HELPER__STEREOTYPE_PACKAGE = GEN_HELPER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Base Element Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STEREOTYPED_ELEMENT_HELPER__BASE_ELEMENT_NAME = GEN_HELPER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Base Element Package</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STEREOTYPED_ELEMENT_HELPER__BASE_ELEMENT_PACKAGE = GEN_HELPER_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Stereotyped Element Helper</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STEREOTYPED_ELEMENT_HELPER_FEATURE_COUNT = GEN_HELPER_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.domaincontextcodegen.impl.MenuDeclarationImpl <em>Menu Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.domaincontextcodegen.impl.MenuDeclarationImpl
	 * @see org.eclipse.papyrus.domaincontextcodegen.impl.DomaincontextcodegenPackageImpl#getMenuDeclaration()
	 * @generated
	 */
	int MENU_DECLARATION = 15;

	/**
	 * The feature id for the '<em><b>Location URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MENU_DECLARATION__LOCATION_URI = 0;

	/**
	 * The feature id for the '<em><b>Commands</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MENU_DECLARATION__COMMANDS = 1;

	/**
	 * The number of structural features of the '<em>Menu Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MENU_DECLARATION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.domaincontextcodegen.impl.CommandDeclarationImpl <em>Command Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.domaincontextcodegen.impl.CommandDeclarationImpl
	 * @see org.eclipse.papyrus.domaincontextcodegen.impl.DomaincontextcodegenPackageImpl#getCommandDeclaration()
	 * @generated
	 */
	int COMMAND_DECLARATION = 16;

	/**
	 * The feature id for the '<em><b>Commands</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMAND_DECLARATION__COMMANDS = 0;

	/**
	 * The number of structural features of the '<em>Command Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMAND_DECLARATION_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.domaincontextcodegen.impl.CommandImpl <em>Command</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.domaincontextcodegen.impl.CommandImpl
	 * @see org.eclipse.papyrus.domaincontextcodegen.impl.DomaincontextcodegenPackageImpl#getCommand()
	 * @generated
	 */
	int COMMAND = 17;

	/**
	 * The feature id for the '<em><b>Element Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMAND__ELEMENT_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMAND__ICON = 1;

	/**
	 * The number of structural features of the '<em>Command</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMAND_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.domaincontextcodegen.InheritanceKind <em>Inheritance Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.domaincontextcodegen.InheritanceKind
	 * @see org.eclipse.papyrus.domaincontextcodegen.impl.DomaincontextcodegenPackageImpl#getInheritanceKind()
	 * @generated
	 */
	int INHERITANCE_KIND = 18;

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
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.domaincontextcodegen.DomainContext#getAdvices
	 * <em>Advices</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Advices</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.DomainContext#getAdvices()
	 * @see #getDomainContext()
	 * @generated
	 */
	EReference getDomainContext_Advices();

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
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.domaincontextcodegen.DomainContext#getMenu
	 * <em>Menu</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Menu</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.DomainContext#getMenu()
	 * @see #getDomainContext()
	 * @generated
	 */
	EReference getDomainContext_Menu();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.domaincontextcodegen.DomainContext#getCommand
	 * <em>Command</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Command</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.DomainContext#getCommand()
	 * @see #getDomainContext()
	 * @generated
	 */
	EReference getDomainContext_Command();

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
	 * Returns the meta object for the container reference '{@link org.eclipse.papyrus.domaincontextcodegen.ElementTypes#getDomain <em>Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the container reference '<em>Domain</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.ElementTypes#getDomain()
	 * @see #getElementTypes()
	 * @generated
	 */
	EReference getElementTypes_Domain();

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
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.domaincontextcodegen.ElementType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.ElementType#getName()
	 * @see #getElementType()
	 * @generated
	 */
	EAttribute getElementType_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.domaincontextcodegen.ElementType#getHelper <em>Helper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Helper</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.ElementType#getHelper()
	 * @see #getElementType()
	 * @generated
	 */
	EAttribute getElementType_Helper();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.papyrus.domaincontextcodegen.ElementType#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.ElementType#getOwner()
	 * @see #getElementType()
	 * @generated
	 */
	EReference getElementType_Owner();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.domaincontextcodegen.ElementType#getIcon <em>Icon</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Icon</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.ElementType#getIcon()
	 * @see #getElementType()
	 * @generated
	 */
	EAttribute getElementType_Icon();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.domaincontextcodegen.MetaClassType <em>Meta Class Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Meta Class Type</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.MetaClassType
	 * @generated
	 */
	EClass getMetaClassType();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.domaincontextcodegen.MetaClassType#getMetaClass <em>Meta Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Meta Class</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.MetaClassType#getMetaClass()
	 * @see #getMetaClassType()
	 * @generated
	 */
	EReference getMetaClassType_MetaClass();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.domaincontextcodegen.SpecializationType <em>Specialization Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Specialization Type</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.SpecializationType
	 * @generated
	 */
	EClass getSpecializationType();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.domaincontextcodegen.SpecializationType#getRef <em>Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Ref</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.SpecializationType#getRef()
	 * @see #getSpecializationType()
	 * @generated
	 */
	EReference getSpecializationType_Ref();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.domaincontextcodegen.SpecializationType#getMatcher <em>Matcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Matcher</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.SpecializationType#getMatcher()
	 * @see #getSpecializationType()
	 * @generated
	 */
	EAttribute getSpecializationType_Matcher();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.domaincontextcodegen.SpecializationType#getGenMatcher
	 * <em>Gen Matcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Gen Matcher</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.SpecializationType#getGenMatcher()
	 * @see #getSpecializationType()
	 * @generated
	 */
	EReference getSpecializationType_GenMatcher();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.domaincontextcodegen.SpecializationType#getGenHelper
	 * <em>Gen Helper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Gen Helper</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.SpecializationType#getGenHelper()
	 * @see #getSpecializationType()
	 * @generated
	 */
	EReference getSpecializationType_GenHelper();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.domaincontextcodegen.Advice <em>Advice</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Advice</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.Advice
	 * @generated
	 */
	EClass getAdvice();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.domaincontextcodegen.Advice#getAdviceID <em>Advice ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Advice ID</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.Advice#getAdviceID()
	 * @see #getAdvice()
	 * @generated
	 */
	EAttribute getAdvice_AdviceID();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.domaincontextcodegen.Advice#getRef <em>Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Ref</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.Advice#getRef()
	 * @see #getAdvice()
	 * @generated
	 */
	EReference getAdvice_Ref();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.domaincontextcodegen.Advice#getAdvicePath <em>Advice Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Advice Path</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.Advice#getAdvicePath()
	 * @see #getAdvice()
	 * @generated
	 */
	EAttribute getAdvice_AdvicePath();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.domaincontextcodegen.Advice#getInheritance <em>Inheritance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Inheritance</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.Advice#getInheritance()
	 * @see #getAdvice()
	 * @generated
	 */
	EAttribute getAdvice_Inheritance();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.domaincontextcodegen.ElementTypeBindings <em>Element Type Bindings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Element Type Bindings</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.ElementTypeBindings
	 * @generated
	 */
	EClass getElementTypeBindings();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.domaincontextcodegen.ElementTypeBindings#getClientContextID
	 * <em>Client Context ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Client Context ID</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.ElementTypeBindings#getClientContextID()
	 * @see #getElementTypeBindings()
	 * @generated
	 */
	EAttribute getElementTypeBindings_ClientContextID();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.domaincontextcodegen.ElementTypeBindings#getBindings
	 * <em>Bindings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Bindings</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.ElementTypeBindings#getBindings()
	 * @see #getElementTypeBindings()
	 * @generated
	 */
	EReference getElementTypeBindings_Bindings();

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
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.domaincontextcodegen.AdviceBinding#getRef <em>Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Ref</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.AdviceBinding#getRef()
	 * @see #getAdviceBinding()
	 * @generated
	 */
	EReference getAdviceBinding_Ref();

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
	 * Returns the meta object for the container reference '{@link org.eclipse.papyrus.domaincontextcodegen.Binding#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.Binding#getOwner()
	 * @see #getBinding()
	 * @generated
	 */
	EReference getBinding_Owner();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.domaincontextcodegen.Binding#getPattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Pattern</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.Binding#getPattern()
	 * @see #getBinding()
	 * @generated
	 */
	EAttribute getBinding_Pattern();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.domaincontextcodegen.ElementTypeBinding <em>Element Type Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Element Type Binding</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.ElementTypeBinding
	 * @generated
	 */
	EClass getElementTypeBinding();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.domaincontextcodegen.ElementTypeBinding#getRef <em>Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Ref</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.ElementTypeBinding#getRef()
	 * @see #getElementTypeBinding()
	 * @generated
	 */
	EReference getElementTypeBinding_Ref();

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
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.domaincontextcodegen.GenHandlers#getVisibleCreateChildHandlers
	 * <em>Visible Create Child Handlers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Visible Create Child Handlers</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.GenHandlers#getVisibleCreateChildHandlers()
	 * @see #getGenHandlers()
	 * @generated
	 */
	EReference getGenHandlers_VisibleCreateChildHandlers();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.domaincontextcodegen.GenHandlers#getParentDomainCreateChild
	 * <em>Parent Domain Create Child</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Parent Domain Create Child</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.GenHandlers#getParentDomainCreateChild()
	 * @see #getGenHandlers()
	 * @generated
	 */
	EReference getGenHandlers_ParentDomainCreateChild();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.domaincontextcodegen.GenHandlers#getCreateChildMenuLocationURI
	 * <em>Create Child Menu Location URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Create Child Menu Location URI</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.GenHandlers#getCreateChildMenuLocationURI()
	 * @see #getGenHandlers()
	 * @generated
	 */
	EAttribute getGenHandlers_CreateChildMenuLocationURI();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.domaincontextcodegen.GenMatcher <em>Gen Matcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Gen Matcher</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.GenMatcher
	 * @generated
	 */
	EClass getGenMatcher();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.domaincontextcodegen.GenMatcher#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.GenMatcher#getName()
	 * @see #getGenMatcher()
	 * @generated
	 */
	EAttribute getGenMatcher_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.domaincontextcodegen.GenHelper <em>Gen Helper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Gen Helper</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.GenHelper
	 * @generated
	 */
	EClass getGenHelper();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.domaincontextcodegen.GenHelper#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.GenHelper#getName()
	 * @see #getGenHelper()
	 * @generated
	 */
	EAttribute getGenHelper_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.domaincontextcodegen.StereotypedElementMatcher
	 * <em>Stereotyped Element Matcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Stereotyped Element Matcher</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.StereotypedElementMatcher
	 * @generated
	 */
	EClass getStereotypedElementMatcher();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.domaincontextcodegen.StereotypedElementMatcher#getStereotypeName
	 * <em>Stereotype Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Stereotype Name</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.StereotypedElementMatcher#getStereotypeName()
	 * @see #getStereotypedElementMatcher()
	 * @generated
	 */
	EAttribute getStereotypedElementMatcher_StereotypeName();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.domaincontextcodegen.StereotypedElementMatcher#getStereotypePackage
	 * <em>Stereotype Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Stereotype Package</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.StereotypedElementMatcher#getStereotypePackage()
	 * @see #getStereotypedElementMatcher()
	 * @generated
	 */
	EAttribute getStereotypedElementMatcher_StereotypePackage();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.domaincontextcodegen.StereotypedElementMatcher#getBaseElementName
	 * <em>Base Element Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Base Element Name</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.StereotypedElementMatcher#getBaseElementName()
	 * @see #getStereotypedElementMatcher()
	 * @generated
	 */
	EAttribute getStereotypedElementMatcher_BaseElementName();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.domaincontextcodegen.StereotypedElementMatcher#getBaseElementPackage
	 * <em>Base Element Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Base Element Package</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.StereotypedElementMatcher#getBaseElementPackage()
	 * @see #getStereotypedElementMatcher()
	 * @generated
	 */
	EAttribute getStereotypedElementMatcher_BaseElementPackage();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.domaincontextcodegen.StereotypedElementHelper
	 * <em>Stereotyped Element Helper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Stereotyped Element Helper</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.StereotypedElementHelper
	 * @generated
	 */
	EClass getStereotypedElementHelper();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.domaincontextcodegen.StereotypedElementHelper#getStereotypeName
	 * <em>Stereotype Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Stereotype Name</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.StereotypedElementHelper#getStereotypeName()
	 * @see #getStereotypedElementHelper()
	 * @generated
	 */
	EAttribute getStereotypedElementHelper_StereotypeName();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.domaincontextcodegen.StereotypedElementHelper#getStereotypePackage
	 * <em>Stereotype Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Stereotype Package</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.StereotypedElementHelper#getStereotypePackage()
	 * @see #getStereotypedElementHelper()
	 * @generated
	 */
	EAttribute getStereotypedElementHelper_StereotypePackage();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.domaincontextcodegen.StereotypedElementHelper#getBaseElementName
	 * <em>Base Element Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Base Element Name</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.StereotypedElementHelper#getBaseElementName()
	 * @see #getStereotypedElementHelper()
	 * @generated
	 */
	EAttribute getStereotypedElementHelper_BaseElementName();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.domaincontextcodegen.StereotypedElementHelper#getBaseElementPackage
	 * <em>Base Element Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Base Element Package</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.StereotypedElementHelper#getBaseElementPackage()
	 * @see #getStereotypedElementHelper()
	 * @generated
	 */
	EAttribute getStereotypedElementHelper_BaseElementPackage();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.domaincontextcodegen.MenuDeclaration <em>Menu Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Menu Declaration</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.MenuDeclaration
	 * @generated
	 */
	EClass getMenuDeclaration();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.domaincontextcodegen.MenuDeclaration#getLocationURI
	 * <em>Location URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Location URI</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.MenuDeclaration#getLocationURI()
	 * @see #getMenuDeclaration()
	 * @generated
	 */
	EAttribute getMenuDeclaration_LocationURI();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.domaincontextcodegen.MenuDeclaration#getCommands <em>Commands</em>}
	 * '.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Commands</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.MenuDeclaration#getCommands()
	 * @see #getMenuDeclaration()
	 * @generated
	 */
	EReference getMenuDeclaration_Commands();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.domaincontextcodegen.CommandDeclaration <em>Command Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Command Declaration</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.CommandDeclaration
	 * @generated
	 */
	EClass getCommandDeclaration();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.domaincontextcodegen.CommandDeclaration#getCommands
	 * <em>Commands</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Commands</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.CommandDeclaration#getCommands()
	 * @see #getCommandDeclaration()
	 * @generated
	 */
	EReference getCommandDeclaration_Commands();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.domaincontextcodegen.Command <em>Command</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Command</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.Command
	 * @generated
	 */
	EClass getCommand();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.domaincontextcodegen.Command#getElementType <em>Element Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Element Type</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.Command#getElementType()
	 * @see #getCommand()
	 * @generated
	 */
	EReference getCommand_ElementType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.domaincontextcodegen.Command#getIcon <em>Icon</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Icon</em>'.
	 * @see org.eclipse.papyrus.domaincontextcodegen.Command#getIcon()
	 * @see #getCommand()
	 * @generated
	 */
	EAttribute getCommand_Icon();

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
		 * The meta object literal for the '<em><b>Advices</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference DOMAIN_CONTEXT__ADVICES = eINSTANCE.getDomainContext_Advices();

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
		 * The meta object literal for the '<em><b>Menu</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference DOMAIN_CONTEXT__MENU = eINSTANCE.getDomainContext_Menu();

		/**
		 * The meta object literal for the '<em><b>Command</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference DOMAIN_CONTEXT__COMMAND = eINSTANCE.getDomainContext_Command();

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
		 * The meta object literal for the '<em><b>Domain</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ELEMENT_TYPES__DOMAIN = eINSTANCE.getElementTypes_Domain();

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
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ELEMENT_TYPE__NAME = eINSTANCE.getElementType_Name();

		/**
		 * The meta object literal for the '<em><b>Helper</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ELEMENT_TYPE__HELPER = eINSTANCE.getElementType_Helper();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ELEMENT_TYPE__OWNER = eINSTANCE.getElementType_Owner();

		/**
		 * The meta object literal for the '<em><b>Icon</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ELEMENT_TYPE__ICON = eINSTANCE.getElementType_Icon();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.domaincontextcodegen.impl.MetaClassTypeImpl <em>Meta Class Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.domaincontextcodegen.impl.MetaClassTypeImpl
		 * @see org.eclipse.papyrus.domaincontextcodegen.impl.DomaincontextcodegenPackageImpl#getMetaClassType()
		 * @generated
		 */
		EClass META_CLASS_TYPE = eINSTANCE.getMetaClassType();

		/**
		 * The meta object literal for the '<em><b>Meta Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference META_CLASS_TYPE__META_CLASS = eINSTANCE.getMetaClassType_MetaClass();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.domaincontextcodegen.impl.SpecializationTypeImpl <em>Specialization Type</em>}'
		 * class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.domaincontextcodegen.impl.SpecializationTypeImpl
		 * @see org.eclipse.papyrus.domaincontextcodegen.impl.DomaincontextcodegenPackageImpl#getSpecializationType()
		 * @generated
		 */
		EClass SPECIALIZATION_TYPE = eINSTANCE.getSpecializationType();

		/**
		 * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SPECIALIZATION_TYPE__REF = eINSTANCE.getSpecializationType_Ref();

		/**
		 * The meta object literal for the '<em><b>Matcher</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute SPECIALIZATION_TYPE__MATCHER = eINSTANCE.getSpecializationType_Matcher();

		/**
		 * The meta object literal for the '<em><b>Gen Matcher</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SPECIALIZATION_TYPE__GEN_MATCHER = eINSTANCE.getSpecializationType_GenMatcher();

		/**
		 * The meta object literal for the '<em><b>Gen Helper</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SPECIALIZATION_TYPE__GEN_HELPER = eINSTANCE.getSpecializationType_GenHelper();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.domaincontextcodegen.impl.AdviceImpl <em>Advice</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.domaincontextcodegen.impl.AdviceImpl
		 * @see org.eclipse.papyrus.domaincontextcodegen.impl.DomaincontextcodegenPackageImpl#getAdvice()
		 * @generated
		 */
		EClass ADVICE = eINSTANCE.getAdvice();

		/**
		 * The meta object literal for the '<em><b>Advice ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ADVICE__ADVICE_ID = eINSTANCE.getAdvice_AdviceID();

		/**
		 * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ADVICE__REF = eINSTANCE.getAdvice_Ref();

		/**
		 * The meta object literal for the '<em><b>Advice Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ADVICE__ADVICE_PATH = eINSTANCE.getAdvice_AdvicePath();

		/**
		 * The meta object literal for the '<em><b>Inheritance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ADVICE__INHERITANCE = eINSTANCE.getAdvice_Inheritance();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.domaincontextcodegen.impl.ElementTypeBindingsImpl
		 * <em>Element Type Bindings</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.domaincontextcodegen.impl.ElementTypeBindingsImpl
		 * @see org.eclipse.papyrus.domaincontextcodegen.impl.DomaincontextcodegenPackageImpl#getElementTypeBindings()
		 * @generated
		 */
		EClass ELEMENT_TYPE_BINDINGS = eINSTANCE.getElementTypeBindings();

		/**
		 * The meta object literal for the '<em><b>Client Context ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ELEMENT_TYPE_BINDINGS__CLIENT_CONTEXT_ID = eINSTANCE.getElementTypeBindings_ClientContextID();

		/**
		 * The meta object literal for the '<em><b>Bindings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ELEMENT_TYPE_BINDINGS__BINDINGS = eINSTANCE.getElementTypeBindings_Bindings();

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
		 * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ADVICE_BINDING__REF = eINSTANCE.getAdviceBinding_Ref();

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
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference BINDING__OWNER = eINSTANCE.getBinding_Owner();

		/**
		 * The meta object literal for the '<em><b>Pattern</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute BINDING__PATTERN = eINSTANCE.getBinding_Pattern();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.domaincontextcodegen.impl.ElementTypeBindingImpl <em>Element Type Binding</em>}
		 * ' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.domaincontextcodegen.impl.ElementTypeBindingImpl
		 * @see org.eclipse.papyrus.domaincontextcodegen.impl.DomaincontextcodegenPackageImpl#getElementTypeBinding()
		 * @generated
		 */
		EClass ELEMENT_TYPE_BINDING = eINSTANCE.getElementTypeBinding();

		/**
		 * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ELEMENT_TYPE_BINDING__REF = eINSTANCE.getElementTypeBinding_Ref();

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
		 * The meta object literal for the '<em><b>Visible Create Child Handlers</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference GEN_HANDLERS__VISIBLE_CREATE_CHILD_HANDLERS = eINSTANCE.getGenHandlers_VisibleCreateChildHandlers();

		/**
		 * The meta object literal for the '<em><b>Parent Domain Create Child</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference GEN_HANDLERS__PARENT_DOMAIN_CREATE_CHILD = eINSTANCE.getGenHandlers_ParentDomainCreateChild();

		/**
		 * The meta object literal for the '<em><b>Create Child Menu Location URI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute GEN_HANDLERS__CREATE_CHILD_MENU_LOCATION_URI = eINSTANCE.getGenHandlers_CreateChildMenuLocationURI();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.domaincontextcodegen.impl.GenMatcherImpl <em>Gen Matcher</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.domaincontextcodegen.impl.GenMatcherImpl
		 * @see org.eclipse.papyrus.domaincontextcodegen.impl.DomaincontextcodegenPackageImpl#getGenMatcher()
		 * @generated
		 */
		EClass GEN_MATCHER = eINSTANCE.getGenMatcher();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute GEN_MATCHER__NAME = eINSTANCE.getGenMatcher_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.domaincontextcodegen.impl.GenHelperImpl <em>Gen Helper</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.domaincontextcodegen.impl.GenHelperImpl
		 * @see org.eclipse.papyrus.domaincontextcodegen.impl.DomaincontextcodegenPackageImpl#getGenHelper()
		 * @generated
		 */
		EClass GEN_HELPER = eINSTANCE.getGenHelper();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute GEN_HELPER__NAME = eINSTANCE.getGenHelper_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.domaincontextcodegen.impl.StereotypedElementMatcherImpl
		 * <em>Stereotyped Element Matcher</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.domaincontextcodegen.impl.StereotypedElementMatcherImpl
		 * @see org.eclipse.papyrus.domaincontextcodegen.impl.DomaincontextcodegenPackageImpl#getStereotypedElementMatcher()
		 * @generated
		 */
		EClass STEREOTYPED_ELEMENT_MATCHER = eINSTANCE.getStereotypedElementMatcher();

		/**
		 * The meta object literal for the '<em><b>Stereotype Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute STEREOTYPED_ELEMENT_MATCHER__STEREOTYPE_NAME = eINSTANCE.getStereotypedElementMatcher_StereotypeName();

		/**
		 * The meta object literal for the '<em><b>Stereotype Package</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute STEREOTYPED_ELEMENT_MATCHER__STEREOTYPE_PACKAGE = eINSTANCE.getStereotypedElementMatcher_StereotypePackage();

		/**
		 * The meta object literal for the '<em><b>Base Element Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute STEREOTYPED_ELEMENT_MATCHER__BASE_ELEMENT_NAME = eINSTANCE.getStereotypedElementMatcher_BaseElementName();

		/**
		 * The meta object literal for the '<em><b>Base Element Package</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute STEREOTYPED_ELEMENT_MATCHER__BASE_ELEMENT_PACKAGE = eINSTANCE.getStereotypedElementMatcher_BaseElementPackage();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.domaincontextcodegen.impl.StereotypedElementHelperImpl
		 * <em>Stereotyped Element Helper</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.domaincontextcodegen.impl.StereotypedElementHelperImpl
		 * @see org.eclipse.papyrus.domaincontextcodegen.impl.DomaincontextcodegenPackageImpl#getStereotypedElementHelper()
		 * @generated
		 */
		EClass STEREOTYPED_ELEMENT_HELPER = eINSTANCE.getStereotypedElementHelper();

		/**
		 * The meta object literal for the '<em><b>Stereotype Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute STEREOTYPED_ELEMENT_HELPER__STEREOTYPE_NAME = eINSTANCE.getStereotypedElementHelper_StereotypeName();

		/**
		 * The meta object literal for the '<em><b>Stereotype Package</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute STEREOTYPED_ELEMENT_HELPER__STEREOTYPE_PACKAGE = eINSTANCE.getStereotypedElementHelper_StereotypePackage();

		/**
		 * The meta object literal for the '<em><b>Base Element Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute STEREOTYPED_ELEMENT_HELPER__BASE_ELEMENT_NAME = eINSTANCE.getStereotypedElementHelper_BaseElementName();

		/**
		 * The meta object literal for the '<em><b>Base Element Package</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute STEREOTYPED_ELEMENT_HELPER__BASE_ELEMENT_PACKAGE = eINSTANCE.getStereotypedElementHelper_BaseElementPackage();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.domaincontextcodegen.impl.MenuDeclarationImpl <em>Menu Declaration</em>}'
		 * class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.domaincontextcodegen.impl.MenuDeclarationImpl
		 * @see org.eclipse.papyrus.domaincontextcodegen.impl.DomaincontextcodegenPackageImpl#getMenuDeclaration()
		 * @generated
		 */
		EClass MENU_DECLARATION = eINSTANCE.getMenuDeclaration();

		/**
		 * The meta object literal for the '<em><b>Location URI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute MENU_DECLARATION__LOCATION_URI = eINSTANCE.getMenuDeclaration_LocationURI();

		/**
		 * The meta object literal for the '<em><b>Commands</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference MENU_DECLARATION__COMMANDS = eINSTANCE.getMenuDeclaration_Commands();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.domaincontextcodegen.impl.CommandDeclarationImpl <em>Command Declaration</em>}'
		 * class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.domaincontextcodegen.impl.CommandDeclarationImpl
		 * @see org.eclipse.papyrus.domaincontextcodegen.impl.DomaincontextcodegenPackageImpl#getCommandDeclaration()
		 * @generated
		 */
		EClass COMMAND_DECLARATION = eINSTANCE.getCommandDeclaration();

		/**
		 * The meta object literal for the '<em><b>Commands</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference COMMAND_DECLARATION__COMMANDS = eINSTANCE.getCommandDeclaration_Commands();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.domaincontextcodegen.impl.CommandImpl <em>Command</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.domaincontextcodegen.impl.CommandImpl
		 * @see org.eclipse.papyrus.domaincontextcodegen.impl.DomaincontextcodegenPackageImpl#getCommand()
		 * @generated
		 */
		EClass COMMAND = eINSTANCE.getCommand();

		/**
		 * The meta object literal for the '<em><b>Element Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference COMMAND__ELEMENT_TYPE = eINSTANCE.getCommand_ElementType();

		/**
		 * The meta object literal for the '<em><b>Icon</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute COMMAND__ICON = eINSTANCE.getCommand_Icon();

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
