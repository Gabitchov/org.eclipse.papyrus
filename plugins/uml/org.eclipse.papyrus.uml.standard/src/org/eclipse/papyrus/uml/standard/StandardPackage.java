/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.standard;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains accessors for the meta
 * objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.papyrus.uml.standard.StandardFactory
 * @model kind="package"
 * @generated
 */
public interface StandardPackage extends EPackage {

	/**
	 * The package name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "standard";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/uml2/schemas/Standard/1";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "Standard";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	StandardPackage eINSTANCE = org.eclipse.papyrus.uml.standard.impl.StandardPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.standard.impl.AuxiliaryImpl <em>Auxiliary</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.uml.standard.impl.AuxiliaryImpl
	 * @see org.eclipse.papyrus.uml.standard.impl.StandardPackageImpl#getAuxiliary()
	 * @generated
	 */
	int AUXILIARY = 0;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AUXILIARY__BASE_CLASS = 0;

	/**
	 * The number of structural features of the '<em>Auxiliary</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AUXILIARY_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.standard.impl.BuildComponentImpl <em>Build Component</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.uml.standard.impl.BuildComponentImpl
	 * @see org.eclipse.papyrus.uml.standard.impl.StandardPackageImpl#getBuildComponent()
	 * @generated
	 */
	int BUILD_COMPONENT = 1;

	/**
	 * The feature id for the '<em><b>Base Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BUILD_COMPONENT__BASE_COMPONENT = 0;

	/**
	 * The number of structural features of the '<em>Build Component</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BUILD_COMPONENT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.standard.impl.CreateImpl <em>Create</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.uml.standard.impl.CreateImpl
	 * @see org.eclipse.papyrus.uml.standard.impl.StandardPackageImpl#getCreate()
	 * @generated
	 */
	int CREATE = 2;

	/**
	 * The feature id for the '<em><b>Base Behavioral Feature</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CREATE__BASE_BEHAVIORAL_FEATURE = 0;

	/**
	 * The feature id for the '<em><b>Base Usage</b></em>' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CREATE__BASE_USAGE = 1;

	/**
	 * The number of structural features of the '<em>Create</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CREATE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.standard.impl.CallImpl <em>Call</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.uml.standard.impl.CallImpl
	 * @see org.eclipse.papyrus.uml.standard.impl.StandardPackageImpl#getCall()
	 * @generated
	 */
	int CALL = 3;

	/**
	 * The feature id for the '<em><b>Base Usage</b></em>' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CALL__BASE_USAGE = 0;

	/**
	 * The number of structural features of the '<em>Call</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CALL_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.standard.impl.DeriveImpl <em>Derive</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.uml.standard.impl.DeriveImpl
	 * @see org.eclipse.papyrus.uml.standard.impl.StandardPackageImpl#getDerive()
	 * @generated
	 */
	int DERIVE = 4;

	/**
	 * The feature id for the '<em><b>Base Abstraction</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DERIVE__BASE_ABSTRACTION = 0;

	/**
	 * The number of structural features of the '<em>Derive</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DERIVE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.standard.impl.DestroyImpl <em>Destroy</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.uml.standard.impl.DestroyImpl
	 * @see org.eclipse.papyrus.uml.standard.impl.StandardPackageImpl#getDestroy()
	 * @generated
	 */
	int DESTROY = 5;

	/**
	 * The feature id for the '<em><b>Base Behavioral Feature</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DESTROY__BASE_BEHAVIORAL_FEATURE = 0;

	/**
	 * The number of structural features of the '<em>Destroy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DESTROY_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.standard.impl.FocusImpl <em>Focus</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.uml.standard.impl.FocusImpl
	 * @see org.eclipse.papyrus.uml.standard.impl.StandardPackageImpl#getFocus()
	 * @generated
	 */
	int FOCUS = 6;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FOCUS__BASE_CLASS = 0;

	/**
	 * The number of structural features of the '<em>Focus</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FOCUS_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.standard.impl.FrameworkImpl <em>Framework</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.uml.standard.impl.FrameworkImpl
	 * @see org.eclipse.papyrus.uml.standard.impl.StandardPackageImpl#getFramework()
	 * @generated
	 */
	int FRAMEWORK = 7;

	/**
	 * The feature id for the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FRAMEWORK__BASE_PACKAGE = 0;

	/**
	 * The number of structural features of the '<em>Framework</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FRAMEWORK_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.standard.impl.ImplementImpl <em>Implement</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.uml.standard.impl.ImplementImpl
	 * @see org.eclipse.papyrus.uml.standard.impl.StandardPackageImpl#getImplement()
	 * @generated
	 */
	int IMPLEMENT = 8;

	/**
	 * The feature id for the '<em><b>Base Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IMPLEMENT__BASE_COMPONENT = 0;

	/**
	 * The number of structural features of the '<em>Implement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IMPLEMENT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.standard.impl.ImplementationClassImpl <em>Implementation Class</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.uml.standard.impl.ImplementationClassImpl
	 * @see org.eclipse.papyrus.uml.standard.impl.StandardPackageImpl#getImplementationClass()
	 * @generated
	 */
	int IMPLEMENTATION_CLASS = 9;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTATION_CLASS__BASE_CLASS = 0;

	/**
	 * The number of structural features of the '<em>Implementation Class</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTATION_CLASS_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.standard.impl.InstantiateImpl <em>Instantiate</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.uml.standard.impl.InstantiateImpl
	 * @see org.eclipse.papyrus.uml.standard.impl.StandardPackageImpl#getInstantiate()
	 * @generated
	 */
	int INSTANTIATE = 10;

	/**
	 * The feature id for the '<em><b>Base Usage</b></em>' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INSTANTIATE__BASE_USAGE = 0;

	/**
	 * The number of structural features of the '<em>Instantiate</em>' class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INSTANTIATE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.standard.impl.MetaclassImpl <em>Metaclass</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.uml.standard.impl.MetaclassImpl
	 * @see org.eclipse.papyrus.uml.standard.impl.StandardPackageImpl#getMetaclass()
	 * @generated
	 */
	int METACLASS = 11;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int METACLASS__BASE_CLASS = 0;

	/**
	 * The number of structural features of the '<em>Metaclass</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int METACLASS_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.standard.impl.ModelLibraryImpl <em>Model Library</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.uml.standard.impl.ModelLibraryImpl
	 * @see org.eclipse.papyrus.uml.standard.impl.StandardPackageImpl#getModelLibrary()
	 * @generated
	 */
	int MODEL_LIBRARY = 12;

	/**
	 * The feature id for the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MODEL_LIBRARY__BASE_PACKAGE = 0;

	/**
	 * The number of structural features of the '<em>Model Library</em>' class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MODEL_LIBRARY_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.standard.impl.RefineImpl <em>Refine</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.uml.standard.impl.RefineImpl
	 * @see org.eclipse.papyrus.uml.standard.impl.StandardPackageImpl#getRefine()
	 * @generated
	 */
	int REFINE = 13;

	/**
	 * The feature id for the '<em><b>Base Abstraction</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REFINE__BASE_ABSTRACTION = 0;

	/**
	 * The number of structural features of the '<em>Refine</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REFINE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.standard.impl.ResponsibilityImpl <em>Responsibility</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.uml.standard.impl.ResponsibilityImpl
	 * @see org.eclipse.papyrus.uml.standard.impl.StandardPackageImpl#getResponsibility()
	 * @generated
	 */
	int RESPONSIBILITY = 14;

	/**
	 * The feature id for the '<em><b>Base Usage</b></em>' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RESPONSIBILITY__BASE_USAGE = 0;

	/**
	 * The number of structural features of the '<em>Responsibility</em>' class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RESPONSIBILITY_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.standard.impl.ScriptImpl <em>Script</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.uml.standard.impl.ScriptImpl
	 * @see org.eclipse.papyrus.uml.standard.impl.StandardPackageImpl#getScript()
	 * @generated
	 */
	int SCRIPT = 15;

	/**
	 * The feature id for the '<em><b>Base Artifact</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SCRIPT__BASE_ARTIFACT = 0;

	/**
	 * The number of structural features of the '<em>Script</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SCRIPT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.standard.impl.SendImpl <em>Send</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.uml.standard.impl.SendImpl
	 * @see org.eclipse.papyrus.uml.standard.impl.StandardPackageImpl#getSend()
	 * @generated
	 */
	int SEND = 16;

	/**
	 * The feature id for the '<em><b>Base Usage</b></em>' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SEND__BASE_USAGE = 0;

	/**
	 * The number of structural features of the '<em>Send</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SEND_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.standard.impl.TraceImpl <em>Trace</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.uml.standard.impl.TraceImpl
	 * @see org.eclipse.papyrus.uml.standard.impl.StandardPackageImpl#getTrace()
	 * @generated
	 */
	int TRACE = 17;

	/**
	 * The feature id for the '<em><b>Base Abstraction</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TRACE__BASE_ABSTRACTION = 0;

	/**
	 * The number of structural features of the '<em>Trace</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TRACE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.standard.impl.TypeImpl <em>Type</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.uml.standard.impl.TypeImpl
	 * @see org.eclipse.papyrus.uml.standard.impl.StandardPackageImpl#getType()
	 * @generated
	 */
	int TYPE = 18;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TYPE__BASE_CLASS = 0;

	/**
	 * The number of structural features of the '<em>Type</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TYPE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.standard.impl.UtilityImpl <em>Utility</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.uml.standard.impl.UtilityImpl
	 * @see org.eclipse.papyrus.uml.standard.impl.StandardPackageImpl#getUtility()
	 * @generated
	 */
	int UTILITY = 19;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UTILITY__BASE_CLASS = 0;

	/**
	 * The number of structural features of the '<em>Utility</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UTILITY_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.standard.impl.DocumentImpl <em>Document</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.uml.standard.impl.DocumentImpl
	 * @see org.eclipse.papyrus.uml.standard.impl.StandardPackageImpl#getDocument()
	 * @generated
	 */
	int DOCUMENT = 20;

	/**
	 * The feature id for the '<em><b>Base Artifact</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DOCUMENT__BASE_ARTIFACT = 0;

	/**
	 * The number of structural features of the '<em>Document</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.standard.impl.EntityImpl <em>Entity</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.uml.standard.impl.EntityImpl
	 * @see org.eclipse.papyrus.uml.standard.impl.StandardPackageImpl#getEntity()
	 * @generated
	 */
	int ENTITY = 21;

	/**
	 * The feature id for the '<em><b>Base Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENTITY__BASE_COMPONENT = 0;

	/**
	 * The number of structural features of the '<em>Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENTITY_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.standard.impl.ExecutableImpl <em>Executable</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.uml.standard.impl.ExecutableImpl
	 * @see org.eclipse.papyrus.uml.standard.impl.StandardPackageImpl#getExecutable()
	 * @generated
	 */
	int EXECUTABLE = 22;

	/**
	 * The feature id for the '<em><b>Base Artifact</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXECUTABLE__BASE_ARTIFACT = 0;

	/**
	 * The number of structural features of the '<em>Executable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXECUTABLE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.standard.impl.FileImpl <em>File</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.uml.standard.impl.FileImpl
	 * @see org.eclipse.papyrus.uml.standard.impl.StandardPackageImpl#getFile()
	 * @generated
	 */
	int FILE = 23;

	/**
	 * The feature id for the '<em><b>Base Artifact</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FILE__BASE_ARTIFACT = 0;

	/**
	 * The number of structural features of the '<em>File</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FILE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.standard.impl.LibraryImpl <em>Library</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.uml.standard.impl.LibraryImpl
	 * @see org.eclipse.papyrus.uml.standard.impl.StandardPackageImpl#getLibrary()
	 * @generated
	 */
	int LIBRARY = 24;

	/**
	 * The feature id for the '<em><b>Base Artifact</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LIBRARY__BASE_ARTIFACT = 0;

	/**
	 * The number of structural features of the '<em>Library</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LIBRARY_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.standard.impl.ProcessImpl <em>Process</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.uml.standard.impl.ProcessImpl
	 * @see org.eclipse.papyrus.uml.standard.impl.StandardPackageImpl#getProcess()
	 * @generated
	 */
	int PROCESS = 25;

	/**
	 * The feature id for the '<em><b>Base Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROCESS__BASE_COMPONENT = 0;

	/**
	 * The number of structural features of the '<em>Process</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROCESS_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.standard.impl.RealizationImpl <em>Realization</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.uml.standard.impl.RealizationImpl
	 * @see org.eclipse.papyrus.uml.standard.impl.StandardPackageImpl#getRealization()
	 * @generated
	 */
	int REALIZATION = 26;

	/**
	 * The feature id for the '<em><b>Base Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REALIZATION__BASE_CLASSIFIER = 0;

	/**
	 * The number of structural features of the '<em>Realization</em>' class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REALIZATION_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.standard.impl.ServiceImpl <em>Service</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.uml.standard.impl.ServiceImpl
	 * @see org.eclipse.papyrus.uml.standard.impl.StandardPackageImpl#getService()
	 * @generated
	 */
	int SERVICE = 27;

	/**
	 * The feature id for the '<em><b>Base Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SERVICE__BASE_COMPONENT = 0;

	/**
	 * The number of structural features of the '<em>Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SERVICE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.standard.impl.SourceImpl <em>Source</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.uml.standard.impl.SourceImpl
	 * @see org.eclipse.papyrus.uml.standard.impl.StandardPackageImpl#getSource()
	 * @generated
	 */
	int SOURCE = 28;

	/**
	 * The feature id for the '<em><b>Base Artifact</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SOURCE__BASE_ARTIFACT = 0;

	/**
	 * The number of structural features of the '<em>Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SOURCE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.standard.impl.SpecificationImpl <em>Specification</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.uml.standard.impl.SpecificationImpl
	 * @see org.eclipse.papyrus.uml.standard.impl.StandardPackageImpl#getSpecification()
	 * @generated
	 */
	int SPECIFICATION = 29;

	/**
	 * The feature id for the '<em><b>Base Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SPECIFICATION__BASE_CLASSIFIER = 0;

	/**
	 * The number of structural features of the '<em>Specification</em>' class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SPECIFICATION_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.standard.impl.SubsystemImpl <em>Subsystem</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.uml.standard.impl.SubsystemImpl
	 * @see org.eclipse.papyrus.uml.standard.impl.StandardPackageImpl#getSubsystem()
	 * @generated
	 */
	int SUBSYSTEM = 30;

	/**
	 * The feature id for the '<em><b>Base Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SUBSYSTEM__BASE_COMPONENT = 0;

	/**
	 * The number of structural features of the '<em>Subsystem</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SUBSYSTEM_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.standard.impl.MetamodelImpl <em>Metamodel</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.uml.standard.impl.MetamodelImpl
	 * @see org.eclipse.papyrus.uml.standard.impl.StandardPackageImpl#getMetamodel()
	 * @generated
	 */
	int METAMODEL = 31;

	/**
	 * The feature id for the '<em><b>Base Model</b></em>' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int METAMODEL__BASE_MODEL = 0;

	/**
	 * The number of structural features of the '<em>Metamodel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int METAMODEL_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.standard.impl.SystemModelImpl <em>System Model</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.uml.standard.impl.SystemModelImpl
	 * @see org.eclipse.papyrus.uml.standard.impl.StandardPackageImpl#getSystemModel()
	 * @generated
	 */
	int SYSTEM_MODEL = 32;

	/**
	 * The feature id for the '<em><b>Base Model</b></em>' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYSTEM_MODEL__BASE_MODEL = 0;

	/**
	 * The number of structural features of the '<em>System Model</em>' class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYSTEM_MODEL_FEATURE_COUNT = 1;

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.standard.Auxiliary <em>Auxiliary</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Auxiliary</em>'.
	 * @see org.eclipse.papyrus.uml.standard.Auxiliary
	 * @generated
	 */
	EClass getAuxiliary();

	/**
	 * Returns the meta object for the reference ' {@link org.eclipse.papyrus.uml.standard.Auxiliary#getBase_Class <em>Base Class</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.uml.standard.Auxiliary#getBase_Class()
	 * @see #getAuxiliary()
	 * @generated
	 */
	EReference getAuxiliary_Base_Class();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.standard.BuildComponent <em>Build Component</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Build Component</em>'.
	 * @see org.eclipse.papyrus.uml.standard.BuildComponent
	 * @generated
	 */
	EClass getBuildComponent();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.uml.standard.BuildComponent#getBase_Component <em>Base Component</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Component</em>'.
	 * @see org.eclipse.papyrus.uml.standard.BuildComponent#getBase_Component()
	 * @see #getBuildComponent()
	 * @generated
	 */
	EReference getBuildComponent_Base_Component();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.standard.Create <em>Create</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Create</em>'.
	 * @see org.eclipse.papyrus.uml.standard.Create
	 * @generated
	 */
	EClass getCreate();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.uml.standard.Create#getBase_BehavioralFeature
	 * <em>Base Behavioral Feature</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Behavioral Feature</em>'.
	 * @see org.eclipse.papyrus.uml.standard.Create#getBase_BehavioralFeature()
	 * @see #getCreate()
	 * @generated
	 */
	EReference getCreate_Base_BehavioralFeature();

	/**
	 * Returns the meta object for the reference ' {@link org.eclipse.papyrus.uml.standard.Create#getBase_Usage <em>Base Usage</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Usage</em>'.
	 * @see org.eclipse.papyrus.uml.standard.Create#getBase_Usage()
	 * @see #getCreate()
	 * @generated
	 */
	EReference getCreate_Base_Usage();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.standard.Call <em>Call</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Call</em>'.
	 * @see org.eclipse.papyrus.uml.standard.Call
	 * @generated
	 */
	EClass getCall();

	/**
	 * Returns the meta object for the reference ' {@link org.eclipse.papyrus.uml.standard.Call#getBase_Usage <em>Base Usage</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Usage</em>'.
	 * @see org.eclipse.papyrus.uml.standard.Call#getBase_Usage()
	 * @see #getCall()
	 * @generated
	 */
	EReference getCall_Base_Usage();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.standard.Derive <em>Derive</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Derive</em>'.
	 * @see org.eclipse.papyrus.uml.standard.Derive
	 * @generated
	 */
	EClass getDerive();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.uml.standard.Derive#getBase_Abstraction <em>Base Abstraction</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Abstraction</em>'.
	 * @see org.eclipse.papyrus.uml.standard.Derive#getBase_Abstraction()
	 * @see #getDerive()
	 * @generated
	 */
	EReference getDerive_Base_Abstraction();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.standard.Destroy <em>Destroy</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Destroy</em>'.
	 * @see org.eclipse.papyrus.uml.standard.Destroy
	 * @generated
	 */
	EClass getDestroy();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.uml.standard.Destroy#getBase_BehavioralFeature
	 * <em>Base Behavioral Feature</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Behavioral Feature</em>'.
	 * @see org.eclipse.papyrus.uml.standard.Destroy#getBase_BehavioralFeature()
	 * @see #getDestroy()
	 * @generated
	 */
	EReference getDestroy_Base_BehavioralFeature();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.standard.Focus <em>Focus</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Focus</em>'.
	 * @see org.eclipse.papyrus.uml.standard.Focus
	 * @generated
	 */
	EClass getFocus();

	/**
	 * Returns the meta object for the reference ' {@link org.eclipse.papyrus.uml.standard.Focus#getBase_Class <em>Base Class</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.uml.standard.Focus#getBase_Class()
	 * @see #getFocus()
	 * @generated
	 */
	EReference getFocus_Base_Class();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.standard.Framework <em>Framework</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Framework</em>'.
	 * @see org.eclipse.papyrus.uml.standard.Framework
	 * @generated
	 */
	EClass getFramework();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.uml.standard.Framework#getBase_Package <em>Base Package</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Package</em>'.
	 * @see org.eclipse.papyrus.uml.standard.Framework#getBase_Package()
	 * @see #getFramework()
	 * @generated
	 */
	EReference getFramework_Base_Package();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.standard.Implement <em>Implement</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Implement</em>'.
	 * @see org.eclipse.papyrus.uml.standard.Implement
	 * @generated
	 */
	EClass getImplement();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.uml.standard.Implement#getBase_Component <em>Base Component</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Component</em>'.
	 * @see org.eclipse.papyrus.uml.standard.Implement#getBase_Component()
	 * @see #getImplement()
	 * @generated
	 */
	EReference getImplement_Base_Component();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.standard.ImplementationClass <em>Implementation Class</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Implementation Class</em>'.
	 * @see org.eclipse.papyrus.uml.standard.ImplementationClass
	 * @generated
	 */
	EClass getImplementationClass();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.uml.standard.ImplementationClass#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.uml.standard.ImplementationClass#getBase_Class()
	 * @see #getImplementationClass()
	 * @generated
	 */
	EReference getImplementationClass_Base_Class();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.standard.Instantiate <em>Instantiate</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Instantiate</em>'.
	 * @see org.eclipse.papyrus.uml.standard.Instantiate
	 * @generated
	 */
	EClass getInstantiate();

	/**
	 * Returns the meta object for the reference ' {@link org.eclipse.papyrus.uml.standard.Instantiate#getBase_Usage <em>Base Usage</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Usage</em>'.
	 * @see org.eclipse.papyrus.uml.standard.Instantiate#getBase_Usage()
	 * @see #getInstantiate()
	 * @generated
	 */
	EReference getInstantiate_Base_Usage();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.standard.Metaclass <em>Metaclass</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Metaclass</em>'.
	 * @see org.eclipse.papyrus.uml.standard.Metaclass
	 * @generated
	 */
	EClass getMetaclass();

	/**
	 * Returns the meta object for the reference ' {@link org.eclipse.papyrus.uml.standard.Metaclass#getBase_Class <em>Base Class</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.uml.standard.Metaclass#getBase_Class()
	 * @see #getMetaclass()
	 * @generated
	 */
	EReference getMetaclass_Base_Class();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.standard.ModelLibrary <em>Model Library</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Model Library</em>'.
	 * @see org.eclipse.papyrus.uml.standard.ModelLibrary
	 * @generated
	 */
	EClass getModelLibrary();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.uml.standard.ModelLibrary#getBase_Package <em>Base Package</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Package</em>'.
	 * @see org.eclipse.papyrus.uml.standard.ModelLibrary#getBase_Package()
	 * @see #getModelLibrary()
	 * @generated
	 */
	EReference getModelLibrary_Base_Package();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.standard.Refine <em>Refine</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Refine</em>'.
	 * @see org.eclipse.papyrus.uml.standard.Refine
	 * @generated
	 */
	EClass getRefine();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.uml.standard.Refine#getBase_Abstraction <em>Base Abstraction</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Abstraction</em>'.
	 * @see org.eclipse.papyrus.uml.standard.Refine#getBase_Abstraction()
	 * @see #getRefine()
	 * @generated
	 */
	EReference getRefine_Base_Abstraction();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.standard.Responsibility <em>Responsibility</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Responsibility</em>'.
	 * @see org.eclipse.papyrus.uml.standard.Responsibility
	 * @generated
	 */
	EClass getResponsibility();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.uml.standard.Responsibility#getBase_Usage <em>Base Usage</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Usage</em>'.
	 * @see org.eclipse.papyrus.uml.standard.Responsibility#getBase_Usage()
	 * @see #getResponsibility()
	 * @generated
	 */
	EReference getResponsibility_Base_Usage();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.standard.Script <em>Script</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Script</em>'.
	 * @see org.eclipse.papyrus.uml.standard.Script
	 * @generated
	 */
	EClass getScript();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.uml.standard.Script#getBase_Artifact <em>Base Artifact</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Artifact</em>'.
	 * @see org.eclipse.papyrus.uml.standard.Script#getBase_Artifact()
	 * @see #getScript()
	 * @generated
	 */
	EReference getScript_Base_Artifact();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.standard.Send <em>Send</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Send</em>'.
	 * @see org.eclipse.papyrus.uml.standard.Send
	 * @generated
	 */
	EClass getSend();

	/**
	 * Returns the meta object for the reference ' {@link org.eclipse.papyrus.uml.standard.Send#getBase_Usage <em>Base Usage</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Usage</em>'.
	 * @see org.eclipse.papyrus.uml.standard.Send#getBase_Usage()
	 * @see #getSend()
	 * @generated
	 */
	EReference getSend_Base_Usage();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.standard.Trace <em>Trace</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Trace</em>'.
	 * @see org.eclipse.papyrus.uml.standard.Trace
	 * @generated
	 */
	EClass getTrace();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.uml.standard.Trace#getBase_Abstraction <em>Base Abstraction</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Abstraction</em>'.
	 * @see org.eclipse.papyrus.uml.standard.Trace#getBase_Abstraction()
	 * @see #getTrace()
	 * @generated
	 */
	EReference getTrace_Base_Abstraction();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.standard.Type <em>Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Type</em>'.
	 * @see org.eclipse.papyrus.uml.standard.Type
	 * @generated
	 */
	EClass getType();

	/**
	 * Returns the meta object for the reference ' {@link org.eclipse.papyrus.uml.standard.Type#getBase_Class <em>Base Class</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.uml.standard.Type#getBase_Class()
	 * @see #getType()
	 * @generated
	 */
	EReference getType_Base_Class();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.standard.Utility <em>Utility</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Utility</em>'.
	 * @see org.eclipse.papyrus.uml.standard.Utility
	 * @generated
	 */
	EClass getUtility();

	/**
	 * Returns the meta object for the reference ' {@link org.eclipse.papyrus.uml.standard.Utility#getBase_Class <em>Base Class</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.uml.standard.Utility#getBase_Class()
	 * @see #getUtility()
	 * @generated
	 */
	EReference getUtility_Base_Class();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.standard.Document <em>Document</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Document</em>'.
	 * @see org.eclipse.papyrus.uml.standard.Document
	 * @generated
	 */
	EClass getDocument();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.uml.standard.Document#getBase_Artifact <em>Base Artifact</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Artifact</em>'.
	 * @see org.eclipse.papyrus.uml.standard.Document#getBase_Artifact()
	 * @see #getDocument()
	 * @generated
	 */
	EReference getDocument_Base_Artifact();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.standard.Entity <em>Entity</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Entity</em>'.
	 * @see org.eclipse.papyrus.uml.standard.Entity
	 * @generated
	 */
	EClass getEntity();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.uml.standard.Entity#getBase_Component <em>Base Component</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Component</em>'.
	 * @see org.eclipse.papyrus.uml.standard.Entity#getBase_Component()
	 * @see #getEntity()
	 * @generated
	 */
	EReference getEntity_Base_Component();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.standard.Executable <em>Executable</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Executable</em>'.
	 * @see org.eclipse.papyrus.uml.standard.Executable
	 * @generated
	 */
	EClass getExecutable();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.uml.standard.Executable#getBase_Artifact <em>Base Artifact</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Artifact</em>'.
	 * @see org.eclipse.papyrus.uml.standard.Executable#getBase_Artifact()
	 * @see #getExecutable()
	 * @generated
	 */
	EReference getExecutable_Base_Artifact();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.standard.File <em>File</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>File</em>'.
	 * @see org.eclipse.papyrus.uml.standard.File
	 * @generated
	 */
	EClass getFile();

	/**
	 * Returns the meta object for the reference ' {@link org.eclipse.papyrus.uml.standard.File#getBase_Artifact <em>Base Artifact</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Artifact</em>'.
	 * @see org.eclipse.papyrus.uml.standard.File#getBase_Artifact()
	 * @see #getFile()
	 * @generated
	 */
	EReference getFile_Base_Artifact();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.standard.Library <em>Library</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Library</em>'.
	 * @see org.eclipse.papyrus.uml.standard.Library
	 * @generated
	 */
	EClass getLibrary();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.uml.standard.Library#getBase_Artifact <em>Base Artifact</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Artifact</em>'.
	 * @see org.eclipse.papyrus.uml.standard.Library#getBase_Artifact()
	 * @see #getLibrary()
	 * @generated
	 */
	EReference getLibrary_Base_Artifact();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.standard.Process <em>Process</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Process</em>'.
	 * @see org.eclipse.papyrus.uml.standard.Process
	 * @generated
	 */
	EClass getProcess();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.uml.standard.Process#getBase_Component <em>Base Component</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Component</em>'.
	 * @see org.eclipse.papyrus.uml.standard.Process#getBase_Component()
	 * @see #getProcess()
	 * @generated
	 */
	EReference getProcess_Base_Component();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.standard.Realization <em>Realization</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Realization</em>'.
	 * @see org.eclipse.papyrus.uml.standard.Realization
	 * @generated
	 */
	EClass getRealization();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.uml.standard.Realization#getBase_Classifier <em>Base Classifier</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Classifier</em>'.
	 * @see org.eclipse.papyrus.uml.standard.Realization#getBase_Classifier()
	 * @see #getRealization()
	 * @generated
	 */
	EReference getRealization_Base_Classifier();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.standard.Service <em>Service</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Service</em>'.
	 * @see org.eclipse.papyrus.uml.standard.Service
	 * @generated
	 */
	EClass getService();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.uml.standard.Service#getBase_Component <em>Base Component</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Component</em>'.
	 * @see org.eclipse.papyrus.uml.standard.Service#getBase_Component()
	 * @see #getService()
	 * @generated
	 */
	EReference getService_Base_Component();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.standard.Source <em>Source</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Source</em>'.
	 * @see org.eclipse.papyrus.uml.standard.Source
	 * @generated
	 */
	EClass getSource();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.uml.standard.Source#getBase_Artifact <em>Base Artifact</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Artifact</em>'.
	 * @see org.eclipse.papyrus.uml.standard.Source#getBase_Artifact()
	 * @see #getSource()
	 * @generated
	 */
	EReference getSource_Base_Artifact();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.standard.Specification <em>Specification</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Specification</em>'.
	 * @see org.eclipse.papyrus.uml.standard.Specification
	 * @generated
	 */
	EClass getSpecification();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.uml.standard.Specification#getBase_Classifier <em>Base Classifier</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Classifier</em>'.
	 * @see org.eclipse.papyrus.uml.standard.Specification#getBase_Classifier()
	 * @see #getSpecification()
	 * @generated
	 */
	EReference getSpecification_Base_Classifier();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.standard.Subsystem <em>Subsystem</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Subsystem</em>'.
	 * @see org.eclipse.papyrus.uml.standard.Subsystem
	 * @generated
	 */
	EClass getSubsystem();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.uml.standard.Subsystem#getBase_Component <em>Base Component</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Component</em>'.
	 * @see org.eclipse.papyrus.uml.standard.Subsystem#getBase_Component()
	 * @see #getSubsystem()
	 * @generated
	 */
	EReference getSubsystem_Base_Component();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.standard.Metamodel <em>Metamodel</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Metamodel</em>'.
	 * @see org.eclipse.papyrus.uml.standard.Metamodel
	 * @generated
	 */
	EClass getMetamodel();

	/**
	 * Returns the meta object for the reference ' {@link org.eclipse.papyrus.uml.standard.Metamodel#getBase_Model <em>Base Model</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Model</em>'.
	 * @see org.eclipse.papyrus.uml.standard.Metamodel#getBase_Model()
	 * @see #getMetamodel()
	 * @generated
	 */
	EReference getMetamodel_Base_Model();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.standard.SystemModel <em>System Model</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>System Model</em>'.
	 * @see org.eclipse.papyrus.uml.standard.SystemModel
	 * @generated
	 */
	EClass getSystemModel();

	/**
	 * Returns the meta object for the reference ' {@link org.eclipse.papyrus.uml.standard.SystemModel#getBase_Model <em>Base Model</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Model</em>'.
	 * @see org.eclipse.papyrus.uml.standard.SystemModel#getBase_Model()
	 * @see #getSystemModel()
	 * @generated
	 */
	EReference getSystemModel_Base_Model();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	StandardFactory getStandardFactory();

	/**
	 * <!-- begin-user-doc --> Defines literals for the meta objects that represent
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
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.standard.impl.AuxiliaryImpl <em>Auxiliary</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.uml.standard.impl.AuxiliaryImpl
		 * @see org.eclipse.papyrus.uml.standard.impl.StandardPackageImpl#getAuxiliary()
		 * @generated
		 */
		EClass AUXILIARY = eINSTANCE.getAuxiliary();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference AUXILIARY__BASE_CLASS = eINSTANCE.getAuxiliary_Base_Class();

		/**
		 * The meta object literal for the ' {@link org.eclipse.papyrus.uml.standard.impl.BuildComponentImpl <em>Build Component</em>} ' class. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.uml.standard.impl.BuildComponentImpl
		 * @see org.eclipse.papyrus.uml.standard.impl.StandardPackageImpl#getBuildComponent()
		 * @generated
		 */
		EClass BUILD_COMPONENT = eINSTANCE.getBuildComponent();

		/**
		 * The meta object literal for the '<em><b>Base Component</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference BUILD_COMPONENT__BASE_COMPONENT = eINSTANCE.getBuildComponent_Base_Component();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.standard.impl.CreateImpl <em>Create</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.uml.standard.impl.CreateImpl
		 * @see org.eclipse.papyrus.uml.standard.impl.StandardPackageImpl#getCreate()
		 * @generated
		 */
		EClass CREATE = eINSTANCE.getCreate();

		/**
		 * The meta object literal for the '<em><b>Base Behavioral Feature</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CREATE__BASE_BEHAVIORAL_FEATURE = eINSTANCE.getCreate_Base_BehavioralFeature();

		/**
		 * The meta object literal for the '<em><b>Base Usage</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CREATE__BASE_USAGE = eINSTANCE.getCreate_Base_Usage();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.standard.impl.CallImpl <em>Call</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.uml.standard.impl.CallImpl
		 * @see org.eclipse.papyrus.uml.standard.impl.StandardPackageImpl#getCall()
		 * @generated
		 */
		EClass CALL = eINSTANCE.getCall();

		/**
		 * The meta object literal for the '<em><b>Base Usage</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CALL__BASE_USAGE = eINSTANCE.getCall_Base_Usage();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.standard.impl.DeriveImpl <em>Derive</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.uml.standard.impl.DeriveImpl
		 * @see org.eclipse.papyrus.uml.standard.impl.StandardPackageImpl#getDerive()
		 * @generated
		 */
		EClass DERIVE = eINSTANCE.getDerive();

		/**
		 * The meta object literal for the '<em><b>Base Abstraction</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference DERIVE__BASE_ABSTRACTION = eINSTANCE.getDerive_Base_Abstraction();

		/**
		 * The meta object literal for the ' {@link org.eclipse.papyrus.uml.standard.impl.DestroyImpl <em>Destroy</em>}' class. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.uml.standard.impl.DestroyImpl
		 * @see org.eclipse.papyrus.uml.standard.impl.StandardPackageImpl#getDestroy()
		 * @generated
		 */
		EClass DESTROY = eINSTANCE.getDestroy();

		/**
		 * The meta object literal for the '<em><b>Base Behavioral Feature</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference DESTROY__BASE_BEHAVIORAL_FEATURE = eINSTANCE.getDestroy_Base_BehavioralFeature();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.standard.impl.FocusImpl <em>Focus</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.uml.standard.impl.FocusImpl
		 * @see org.eclipse.papyrus.uml.standard.impl.StandardPackageImpl#getFocus()
		 * @generated
		 */
		EClass FOCUS = eINSTANCE.getFocus();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference FOCUS__BASE_CLASS = eINSTANCE.getFocus_Base_Class();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.standard.impl.FrameworkImpl <em>Framework</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.uml.standard.impl.FrameworkImpl
		 * @see org.eclipse.papyrus.uml.standard.impl.StandardPackageImpl#getFramework()
		 * @generated
		 */
		EClass FRAMEWORK = eINSTANCE.getFramework();

		/**
		 * The meta object literal for the '<em><b>Base Package</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference FRAMEWORK__BASE_PACKAGE = eINSTANCE.getFramework_Base_Package();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.standard.impl.ImplementImpl <em>Implement</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.uml.standard.impl.ImplementImpl
		 * @see org.eclipse.papyrus.uml.standard.impl.StandardPackageImpl#getImplement()
		 * @generated
		 */
		EClass IMPLEMENT = eINSTANCE.getImplement();

		/**
		 * The meta object literal for the '<em><b>Base Component</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference IMPLEMENT__BASE_COMPONENT = eINSTANCE.getImplement_Base_Component();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.standard.impl.ImplementationClassImpl <em>Implementation Class</em>}'
		 * class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.uml.standard.impl.ImplementationClassImpl
		 * @see org.eclipse.papyrus.uml.standard.impl.StandardPackageImpl#getImplementationClass()
		 * @generated
		 */
		EClass IMPLEMENTATION_CLASS = eINSTANCE.getImplementationClass();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference IMPLEMENTATION_CLASS__BASE_CLASS = eINSTANCE.getImplementationClass_Base_Class();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.standard.impl.InstantiateImpl <em>Instantiate</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.uml.standard.impl.InstantiateImpl
		 * @see org.eclipse.papyrus.uml.standard.impl.StandardPackageImpl#getInstantiate()
		 * @generated
		 */
		EClass INSTANTIATE = eINSTANCE.getInstantiate();

		/**
		 * The meta object literal for the '<em><b>Base Usage</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference INSTANTIATE__BASE_USAGE = eINSTANCE.getInstantiate_Base_Usage();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.standard.impl.MetaclassImpl <em>Metaclass</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.uml.standard.impl.MetaclassImpl
		 * @see org.eclipse.papyrus.uml.standard.impl.StandardPackageImpl#getMetaclass()
		 * @generated
		 */
		EClass METACLASS = eINSTANCE.getMetaclass();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference METACLASS__BASE_CLASS = eINSTANCE.getMetaclass_Base_Class();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.standard.impl.ModelLibraryImpl <em>Model Library</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.uml.standard.impl.ModelLibraryImpl
		 * @see org.eclipse.papyrus.uml.standard.impl.StandardPackageImpl#getModelLibrary()
		 * @generated
		 */
		EClass MODEL_LIBRARY = eINSTANCE.getModelLibrary();

		/**
		 * The meta object literal for the '<em><b>Base Package</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference MODEL_LIBRARY__BASE_PACKAGE = eINSTANCE.getModelLibrary_Base_Package();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.standard.impl.RefineImpl <em>Refine</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.uml.standard.impl.RefineImpl
		 * @see org.eclipse.papyrus.uml.standard.impl.StandardPackageImpl#getRefine()
		 * @generated
		 */
		EClass REFINE = eINSTANCE.getRefine();

		/**
		 * The meta object literal for the '<em><b>Base Abstraction</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference REFINE__BASE_ABSTRACTION = eINSTANCE.getRefine_Base_Abstraction();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.standard.impl.ResponsibilityImpl <em>Responsibility</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.uml.standard.impl.ResponsibilityImpl
		 * @see org.eclipse.papyrus.uml.standard.impl.StandardPackageImpl#getResponsibility()
		 * @generated
		 */
		EClass RESPONSIBILITY = eINSTANCE.getResponsibility();

		/**
		 * The meta object literal for the '<em><b>Base Usage</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference RESPONSIBILITY__BASE_USAGE = eINSTANCE.getResponsibility_Base_Usage();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.standard.impl.ScriptImpl <em>Script</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.uml.standard.impl.ScriptImpl
		 * @see org.eclipse.papyrus.uml.standard.impl.StandardPackageImpl#getScript()
		 * @generated
		 */
		EClass SCRIPT = eINSTANCE.getScript();

		/**
		 * The meta object literal for the '<em><b>Base Artifact</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SCRIPT__BASE_ARTIFACT = eINSTANCE.getScript_Base_Artifact();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.standard.impl.SendImpl <em>Send</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.uml.standard.impl.SendImpl
		 * @see org.eclipse.papyrus.uml.standard.impl.StandardPackageImpl#getSend()
		 * @generated
		 */
		EClass SEND = eINSTANCE.getSend();

		/**
		 * The meta object literal for the '<em><b>Base Usage</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SEND__BASE_USAGE = eINSTANCE.getSend_Base_Usage();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.standard.impl.TraceImpl <em>Trace</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.uml.standard.impl.TraceImpl
		 * @see org.eclipse.papyrus.uml.standard.impl.StandardPackageImpl#getTrace()
		 * @generated
		 */
		EClass TRACE = eINSTANCE.getTrace();

		/**
		 * The meta object literal for the '<em><b>Base Abstraction</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference TRACE__BASE_ABSTRACTION = eINSTANCE.getTrace_Base_Abstraction();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.standard.impl.TypeImpl <em>Type</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.uml.standard.impl.TypeImpl
		 * @see org.eclipse.papyrus.uml.standard.impl.StandardPackageImpl#getType()
		 * @generated
		 */
		EClass TYPE = eINSTANCE.getType();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference TYPE__BASE_CLASS = eINSTANCE.getType_Base_Class();

		/**
		 * The meta object literal for the ' {@link org.eclipse.papyrus.uml.standard.impl.UtilityImpl <em>Utility</em>}' class. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.uml.standard.impl.UtilityImpl
		 * @see org.eclipse.papyrus.uml.standard.impl.StandardPackageImpl#getUtility()
		 * @generated
		 */
		EClass UTILITY = eINSTANCE.getUtility();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference UTILITY__BASE_CLASS = eINSTANCE.getUtility_Base_Class();

		/**
		 * The meta object literal for the ' {@link org.eclipse.papyrus.uml.standard.impl.DocumentImpl <em>Document</em>}' class. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.uml.standard.impl.DocumentImpl
		 * @see org.eclipse.papyrus.uml.standard.impl.StandardPackageImpl#getDocument()
		 * @generated
		 */
		EClass DOCUMENT = eINSTANCE.getDocument();

		/**
		 * The meta object literal for the '<em><b>Base Artifact</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference DOCUMENT__BASE_ARTIFACT = eINSTANCE.getDocument_Base_Artifact();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.standard.impl.EntityImpl <em>Entity</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.uml.standard.impl.EntityImpl
		 * @see org.eclipse.papyrus.uml.standard.impl.StandardPackageImpl#getEntity()
		 * @generated
		 */
		EClass ENTITY = eINSTANCE.getEntity();

		/**
		 * The meta object literal for the '<em><b>Base Component</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ENTITY__BASE_COMPONENT = eINSTANCE.getEntity_Base_Component();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.standard.impl.ExecutableImpl <em>Executable</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.uml.standard.impl.ExecutableImpl
		 * @see org.eclipse.papyrus.uml.standard.impl.StandardPackageImpl#getExecutable()
		 * @generated
		 */
		EClass EXECUTABLE = eINSTANCE.getExecutable();

		/**
		 * The meta object literal for the '<em><b>Base Artifact</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference EXECUTABLE__BASE_ARTIFACT = eINSTANCE.getExecutable_Base_Artifact();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.standard.impl.FileImpl <em>File</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.uml.standard.impl.FileImpl
		 * @see org.eclipse.papyrus.uml.standard.impl.StandardPackageImpl#getFile()
		 * @generated
		 */
		EClass FILE = eINSTANCE.getFile();

		/**
		 * The meta object literal for the '<em><b>Base Artifact</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference FILE__BASE_ARTIFACT = eINSTANCE.getFile_Base_Artifact();

		/**
		 * The meta object literal for the ' {@link org.eclipse.papyrus.uml.standard.impl.LibraryImpl <em>Library</em>}' class. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.uml.standard.impl.LibraryImpl
		 * @see org.eclipse.papyrus.uml.standard.impl.StandardPackageImpl#getLibrary()
		 * @generated
		 */
		EClass LIBRARY = eINSTANCE.getLibrary();

		/**
		 * The meta object literal for the '<em><b>Base Artifact</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference LIBRARY__BASE_ARTIFACT = eINSTANCE.getLibrary_Base_Artifact();

		/**
		 * The meta object literal for the ' {@link org.eclipse.papyrus.uml.standard.impl.ProcessImpl <em>Process</em>}' class. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.uml.standard.impl.ProcessImpl
		 * @see org.eclipse.papyrus.uml.standard.impl.StandardPackageImpl#getProcess()
		 * @generated
		 */
		EClass PROCESS = eINSTANCE.getProcess();

		/**
		 * The meta object literal for the '<em><b>Base Component</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference PROCESS__BASE_COMPONENT = eINSTANCE.getProcess_Base_Component();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.standard.impl.RealizationImpl <em>Realization</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.uml.standard.impl.RealizationImpl
		 * @see org.eclipse.papyrus.uml.standard.impl.StandardPackageImpl#getRealization()
		 * @generated
		 */
		EClass REALIZATION = eINSTANCE.getRealization();

		/**
		 * The meta object literal for the '<em><b>Base Classifier</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference REALIZATION__BASE_CLASSIFIER = eINSTANCE.getRealization_Base_Classifier();

		/**
		 * The meta object literal for the ' {@link org.eclipse.papyrus.uml.standard.impl.ServiceImpl <em>Service</em>}' class. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.uml.standard.impl.ServiceImpl
		 * @see org.eclipse.papyrus.uml.standard.impl.StandardPackageImpl#getService()
		 * @generated
		 */
		EClass SERVICE = eINSTANCE.getService();

		/**
		 * The meta object literal for the '<em><b>Base Component</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SERVICE__BASE_COMPONENT = eINSTANCE.getService_Base_Component();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.standard.impl.SourceImpl <em>Source</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.uml.standard.impl.SourceImpl
		 * @see org.eclipse.papyrus.uml.standard.impl.StandardPackageImpl#getSource()
		 * @generated
		 */
		EClass SOURCE = eINSTANCE.getSource();

		/**
		 * The meta object literal for the '<em><b>Base Artifact</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SOURCE__BASE_ARTIFACT = eINSTANCE.getSource_Base_Artifact();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.standard.impl.SpecificationImpl <em>Specification</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.uml.standard.impl.SpecificationImpl
		 * @see org.eclipse.papyrus.uml.standard.impl.StandardPackageImpl#getSpecification()
		 * @generated
		 */
		EClass SPECIFICATION = eINSTANCE.getSpecification();

		/**
		 * The meta object literal for the '<em><b>Base Classifier</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SPECIFICATION__BASE_CLASSIFIER = eINSTANCE.getSpecification_Base_Classifier();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.standard.impl.SubsystemImpl <em>Subsystem</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.uml.standard.impl.SubsystemImpl
		 * @see org.eclipse.papyrus.uml.standard.impl.StandardPackageImpl#getSubsystem()
		 * @generated
		 */
		EClass SUBSYSTEM = eINSTANCE.getSubsystem();

		/**
		 * The meta object literal for the '<em><b>Base Component</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SUBSYSTEM__BASE_COMPONENT = eINSTANCE.getSubsystem_Base_Component();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.standard.impl.MetamodelImpl <em>Metamodel</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.uml.standard.impl.MetamodelImpl
		 * @see org.eclipse.papyrus.uml.standard.impl.StandardPackageImpl#getMetamodel()
		 * @generated
		 */
		EClass METAMODEL = eINSTANCE.getMetamodel();

		/**
		 * The meta object literal for the '<em><b>Base Model</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference METAMODEL__BASE_MODEL = eINSTANCE.getMetamodel_Base_Model();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.standard.impl.SystemModelImpl <em>System Model</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.uml.standard.impl.SystemModelImpl
		 * @see org.eclipse.papyrus.uml.standard.impl.StandardPackageImpl#getSystemModel()
		 * @generated
		 */
		EClass SYSTEM_MODEL = eINSTANCE.getSystemModel();

		/**
		 * The meta object literal for the '<em><b>Base Model</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SYSTEM_MODEL__BASE_MODEL = eINSTANCE.getSystemModel_Base_Model();

	}

} // StandardPackage
