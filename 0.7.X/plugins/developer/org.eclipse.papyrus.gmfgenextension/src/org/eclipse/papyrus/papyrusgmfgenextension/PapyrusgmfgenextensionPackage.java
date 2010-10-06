/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.papyrusgmfgenextension;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see org.eclipse.papyrus.papyrusgmfgenextension.PapyrusgmfgenextensionFactory
 * @model kind="package"
 * @generated
 */
public interface PapyrusgmfgenextensionPackage extends EPackage {

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "papyrusgmfgenextension";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/2009/papyrusgmfgenextension";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "papyrusgmfgenextension";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	PapyrusgmfgenextensionPackage eINSTANCE = org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusgmfgenextensionPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.CommentedElementImpl <em>Commented Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.CommentedElementImpl
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusgmfgenextensionPackageImpl#getCommentedElement()
	 * @generated
	 */
	int COMMENTED_ELEMENT = 1;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMENTED_ELEMENT__COMMENT = 0;

	/**
	 * The number of structural features of the '<em>Commented Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMMENTED_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.ExtendedGenViewImpl <em>Extended Gen View</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.ExtendedGenViewImpl
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusgmfgenextensionPackageImpl#getExtendedGenView()
	 * @generated
	 */
	int EXTENDED_GEN_VIEW = 0;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXTENDED_GEN_VIEW__COMMENT = COMMENTED_ELEMENT__COMMENT;

	/**
	 * The feature id for the '<em><b>Gen View</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXTENDED_GEN_VIEW__GEN_VIEW = COMMENTED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXTENDED_GEN_VIEW__IS_ABSTRACT = COMMENTED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Super Gen Views</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXTENDED_GEN_VIEW__SUPER_GEN_VIEWS = COMMENTED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Prop Refresh Hook</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXTENDED_GEN_VIEW__PROP_REFRESH_HOOK = COMMENTED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXTENDED_GEN_VIEW__NAME = COMMENTED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Super Owned Edit Part</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXTENDED_GEN_VIEW__SUPER_OWNED_EDIT_PART = COMMENTED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Extended Gen View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXTENDED_GEN_VIEW_FEATURE_COUNT = COMMENTED_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.ExternalHookImpl <em>External Hook</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.ExternalHookImpl
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusgmfgenextensionPackageImpl#getExternalHook()
	 * @generated
	 */
	int EXTERNAL_HOOK = 3;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_HOOK__COMMENT = COMMENTED_ELEMENT__COMMENT;

	/**
	 * The feature id for the '<em><b>Classpath</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_HOOK__CLASSPATH = COMMENTED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>External Hook</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_HOOK_FEATURE_COUNT = COMMENTED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.PropertyRefreshHookImpl <em>Property Refresh Hook</em>}'
	 * class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.PropertyRefreshHookImpl
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusgmfgenextensionPackageImpl#getPropertyRefreshHook()
	 * @generated
	 */
	int PROPERTY_REFRESH_HOOK = 2;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROPERTY_REFRESH_HOOK__COMMENT = EXTERNAL_HOOK__COMMENT;

	/**
	 * The feature id for the '<em><b>Classpath</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROPERTY_REFRESH_HOOK__CLASSPATH = EXTERNAL_HOOK__CLASSPATH;

	/**
	 * The feature id for the '<em><b>Triggering Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROPERTY_REFRESH_HOOK__TRIGGERING_CONDITION = EXTERNAL_HOOK_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Action</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROPERTY_REFRESH_HOOK__ACTION = EXTERNAL_HOOK_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Property Refresh Hook</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROPERTY_REFRESH_HOOK_FEATURE_COUNT = EXTERNAL_HOOK_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.SpecificLocatorImpl <em>Specific Locator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.SpecificLocatorImpl
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusgmfgenextensionPackageImpl#getSpecificLocator()
	 * @generated
	 */
	int SPECIFIC_LOCATOR = 4;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_LOCATOR__COMMENT = EXTERNAL_HOOK__COMMENT;

	/**
	 * The feature id for the '<em><b>Classpath</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_LOCATOR__CLASSPATH = EXTERNAL_HOOK__CLASSPATH;

	/**
	 * The feature id for the '<em><b>Gen Child Side Affixed Node</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_LOCATOR__GEN_CHILD_SIDE_AFFIXED_NODE = EXTERNAL_HOOK_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Specific Locator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_LOCATOR_FEATURE_COUNT = EXTERNAL_HOOK_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusExtensionRootNodeImpl
	 * <em>Papyrus Extension Root Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusExtensionRootNodeImpl
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusgmfgenextensionPackageImpl#getPapyrusExtensionRootNode()
	 * @generated
	 */
	int PAPYRUS_EXTENSION_ROOT_NODE = 5;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_EXTENSION_ROOT_NODE__COMMENT = COMMENTED_ELEMENT__COMMENT;

	/**
	 * The feature id for the '<em><b>Extension Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_EXTENSION_ROOT_NODE__EXTENSION_NODES = COMMENTED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Papyrus Extension Root Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_EXTENSION_ROOT_NODE_FEATURE_COUNT = COMMENTED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.AlternateCanvasImpl <em>Alternate Canvas</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.AlternateCanvasImpl
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusgmfgenextensionPackageImpl#getAlternateCanvas()
	 * @generated
	 */
	int ALTERNATE_CANVAS = 6;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ALTERNATE_CANVAS__COMMENT = COMMENTED_ELEMENT__COMMENT;

	/**
	 * The feature id for the '<em><b>Domain Diagram Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ALTERNATE_CANVAS__DOMAIN_DIAGRAM_ELEMENT = COMMENTED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Alternate Top Level Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ALTERNATE_CANVAS__ALTERNATE_TOP_LEVEL_NODES = COMMENTED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Alternate Link Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ALTERNATE_CANVAS__ALTERNATE_LINK_NODES = COMMENTED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Diagram</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ALTERNATE_CANVAS__DIAGRAM = COMMENTED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Alternate Canvas</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ALTERNATE_CANVAS_FEATURE_COUNT = COMMENTED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.AlternateGenTopLevelNodeImpl
	 * <em>Alternate Gen Top Level Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.AlternateGenTopLevelNodeImpl
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusgmfgenextensionPackageImpl#getAlternateGenTopLevelNode()
	 * @generated
	 */
	int ALTERNATE_GEN_TOP_LEVEL_NODE = 7;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ALTERNATE_GEN_TOP_LEVEL_NODE__COMMENT = COMMENTED_ELEMENT__COMMENT;

	/**
	 * The feature id for the '<em><b>Gen Top Level Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ALTERNATE_GEN_TOP_LEVEL_NODE__GEN_TOP_LEVEL_NODE = COMMENTED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type Model Facet</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ALTERNATE_GEN_TOP_LEVEL_NODE__TYPE_MODEL_FACET = COMMENTED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Alternate Gen Top Level Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ALTERNATE_GEN_TOP_LEVEL_NODE_FEATURE_COUNT = COMMENTED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.AlternateGenLinkImpl <em>Alternate Gen Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.AlternateGenLinkImpl
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusgmfgenextensionPackageImpl#getAlternateGenLink()
	 * @generated
	 */
	int ALTERNATE_GEN_LINK = 8;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ALTERNATE_GEN_LINK__COMMENT = COMMENTED_ELEMENT__COMMENT;

	/**
	 * The feature id for the '<em><b>Gen Link Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ALTERNATE_GEN_LINK__GEN_LINK_NODE = COMMENTED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type Model Facet</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ALTERNATE_GEN_LINK__TYPE_MODEL_FACET = COMMENTED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Alternate Gen Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ALTERNATE_GEN_LINK_FEATURE_COUNT = COMMENTED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.MutatingCanvasImpl <em>Mutating Canvas</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.MutatingCanvasImpl
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusgmfgenextensionPackageImpl#getMutatingCanvas()
	 * @generated
	 */
	int MUTATING_CANVAS = 9;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MUTATING_CANVAS__COMMENT = COMMENTED_ELEMENT__COMMENT;

	/**
	 * The feature id for the '<em><b>Alternate Canvases</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MUTATING_CANVAS__ALTERNATE_CANVASES = COMMENTED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Mutating Canvas</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MUTATING_CANVAS_FEATURE_COUNT = COMMENTED_ELEMENT_FEATURE_COUNT + 1;


	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.OwnedEditpartImpl <em>Owned Editpart</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.OwnedEditpartImpl
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusgmfgenextensionPackageImpl#getOwnedEditpart()
	 * @generated
	 */
	int OWNED_EDITPART = 10;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OWNED_EDITPART__COMMENT = EXTERNAL_HOOK__COMMENT;

	/**
	 * The feature id for the '<em><b>Classpath</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OWNED_EDITPART__CLASSPATH = EXTERNAL_HOOK__CLASSPATH;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OWNED_EDITPART__NAME = EXTERNAL_HOOK_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Owned Editpart</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OWNED_EDITPART_FEATURE_COUNT = EXTERNAL_HOOK_FEATURE_COUNT + 1;


	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.SpecificDiagramUpdaterImpl
	 * <em>Specific Diagram Updater</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.SpecificDiagramUpdaterImpl
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusgmfgenextensionPackageImpl#getSpecificDiagramUpdater()
	 * @generated
	 */
	int SPECIFIC_DIAGRAM_UPDATER = 11;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_DIAGRAM_UPDATER__COMMENT = EXTERNAL_HOOK__COMMENT;

	/**
	 * The feature id for the '<em><b>Classpath</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_DIAGRAM_UPDATER__CLASSPATH = EXTERNAL_HOOK__CLASSPATH;

	/**
	 * The feature id for the '<em><b>Gen Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_DIAGRAM_UPDATER__GEN_NODE = EXTERNAL_HOOK_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Specific Diagram Updater</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_DIAGRAM_UPDATER_FEATURE_COUNT = EXTERNAL_HOOK_FEATURE_COUNT + 1;


	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.GenNodeConstraintImpl <em>Gen Node Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.GenNodeConstraintImpl
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusgmfgenextensionPackageImpl#getGenNodeConstraint()
	 * @generated
	 */
	int GEN_NODE_CONSTRAINT = 12;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GEN_NODE_CONSTRAINT__COMMENT = COMMENTED_ELEMENT__COMMENT;

	/**
	 * The feature id for the '<em><b>Gen Node</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GEN_NODE_CONSTRAINT__GEN_NODE = COMMENTED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Gen Constraint</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GEN_NODE_CONSTRAINT__GEN_CONSTRAINT = COMMENTED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Gen Node Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GEN_NODE_CONSTRAINT_FEATURE_COUNT = COMMENTED_ELEMENT_FEATURE_COUNT + 2;


	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.SpecificLocatorExternalLabelImpl
	 * <em>Specific Locator External Label</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.SpecificLocatorExternalLabelImpl
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusgmfgenextensionPackageImpl#getSpecificLocatorExternalLabel()
	 * @generated
	 */
	int SPECIFIC_LOCATOR_EXTERNAL_LABEL = 13;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_LOCATOR_EXTERNAL_LABEL__COMMENT = EXTERNAL_HOOK__COMMENT;

	/**
	 * The feature id for the '<em><b>Classpath</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_LOCATOR_EXTERNAL_LABEL__CLASSPATH = EXTERNAL_HOOK__CLASSPATH;

	/**
	 * The feature id for the '<em><b>Gen External Node Label</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_LOCATOR_EXTERNAL_LABEL__GEN_EXTERNAL_NODE_LABEL = EXTERNAL_HOOK_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Specific Locator External Label</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_LOCATOR_EXTERNAL_LABEL_FEATURE_COUNT = EXTERNAL_HOOK_FEATURE_COUNT + 1;


	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.AdditionalEditPartCandiesImpl
	 * <em>Additional Edit Part Candies</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.AdditionalEditPartCandiesImpl
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusgmfgenextensionPackageImpl#getAdditionalEditPartCandies()
	 * @generated
	 */
	int ADDITIONAL_EDIT_PART_CANDIES = 14;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ADDITIONAL_EDIT_PART_CANDIES__COMMENT = COMMENTED_ELEMENT__COMMENT;

	/**
	 * The feature id for the '<em><b>Base Edit Helper Package</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ADDITIONAL_EDIT_PART_CANDIES__BASE_EDIT_HELPER_PACKAGE = COMMENTED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Additional Edit Part Candies</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ADDITIONAL_EDIT_PART_CANDIES_FEATURE_COUNT = COMMENTED_ELEMENT_FEATURE_COUNT + 1;


	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.EditPartUsingDeleteServiceImpl
	 * <em>Edit Part Using Delete Service</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.EditPartUsingDeleteServiceImpl
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusgmfgenextensionPackageImpl#getEditPartUsingDeleteService()
	 * @generated
	 */
	int EDIT_PART_USING_DELETE_SERVICE = 15;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EDIT_PART_USING_DELETE_SERVICE__COMMENT = COMMENTED_ELEMENT__COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EDIT_PART_USING_DELETE_SERVICE__NAME = COMMENTED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Gen View</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EDIT_PART_USING_DELETE_SERVICE__GEN_VIEW = COMMENTED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Edit Part Using Delete Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EDIT_PART_USING_DELETE_SERVICE_FEATURE_COUNT = COMMENTED_ELEMENT_FEATURE_COUNT + 2;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.papyrusgmfgenextension.ExtendedGenView <em>Extended Gen View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Extended Gen View</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.ExtendedGenView
	 * @generated
	 */
	EClass getExtendedGenView();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.papyrusgmfgenextension.ExtendedGenView#getGenView <em>Gen View</em>}
	 * '.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Gen View</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.ExtendedGenView#getGenView()
	 * @see #getExtendedGenView()
	 * @generated
	 */
	EReference getExtendedGenView_GenView();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.papyrusgmfgenextension.ExtendedGenView#isIsAbstract <em>Is Abstract</em>}
	 * '.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Is Abstract</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.ExtendedGenView#isIsAbstract()
	 * @see #getExtendedGenView()
	 * @generated
	 */
	EAttribute getExtendedGenView_IsAbstract();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.papyrusgmfgenextension.ExtendedGenView#getSuperGenViews
	 * <em>Super Gen Views</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Super Gen Views</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.ExtendedGenView#getSuperGenViews()
	 * @see #getExtendedGenView()
	 * @generated
	 */
	EReference getExtendedGenView_SuperGenViews();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.papyrusgmfgenextension.ExtendedGenView#getPropRefreshHook
	 * <em>Prop Refresh Hook</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Prop Refresh Hook</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.ExtendedGenView#getPropRefreshHook()
	 * @see #getExtendedGenView()
	 * @generated
	 */
	EReference getExtendedGenView_PropRefreshHook();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.papyrusgmfgenextension.ExtendedGenView#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.ExtendedGenView#getName()
	 * @see #getExtendedGenView()
	 * @generated
	 */
	EAttribute getExtendedGenView_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.papyrusgmfgenextension.ExtendedGenView#getSuperOwnedEditPart
	 * <em>Super Owned Edit Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Super Owned Edit Part</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.ExtendedGenView#getSuperOwnedEditPart()
	 * @see #getExtendedGenView()
	 * @generated
	 */
	EAttribute getExtendedGenView_SuperOwnedEditPart();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.papyrusgmfgenextension.CommentedElement <em>Commented Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Commented Element</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.CommentedElement
	 * @generated
	 */
	EClass getCommentedElement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.papyrusgmfgenextension.CommentedElement#getComment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Comment</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.CommentedElement#getComment()
	 * @see #getCommentedElement()
	 * @generated
	 */
	EAttribute getCommentedElement_Comment();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.papyrusgmfgenextension.PropertyRefreshHook <em>Property Refresh Hook</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Property Refresh Hook</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.PropertyRefreshHook
	 * @generated
	 */
	EClass getPropertyRefreshHook();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.papyrusgmfgenextension.PropertyRefreshHook#getTriggeringCondition
	 * <em>Triggering Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Triggering Condition</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.PropertyRefreshHook#getTriggeringCondition()
	 * @see #getPropertyRefreshHook()
	 * @generated
	 */
	EAttribute getPropertyRefreshHook_TriggeringCondition();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.papyrusgmfgenextension.PropertyRefreshHook#getAction <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Action</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.PropertyRefreshHook#getAction()
	 * @see #getPropertyRefreshHook()
	 * @generated
	 */
	EAttribute getPropertyRefreshHook_Action();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.papyrusgmfgenextension.ExternalHook <em>External Hook</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>External Hook</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.ExternalHook
	 * @generated
	 */
	EClass getExternalHook();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.papyrusgmfgenextension.ExternalHook#getClasspath <em>Classpath</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Classpath</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.ExternalHook#getClasspath()
	 * @see #getExternalHook()
	 * @generated
	 */
	EAttribute getExternalHook_Classpath();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.papyrusgmfgenextension.SpecificLocator <em>Specific Locator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Specific Locator</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.SpecificLocator
	 * @generated
	 */
	EClass getSpecificLocator();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.papyrusgmfgenextension.SpecificLocator#getGenChildSideAffixedNode
	 * <em>Gen Child Side Affixed Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Gen Child Side Affixed Node</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.SpecificLocator#getGenChildSideAffixedNode()
	 * @see #getSpecificLocator()
	 * @generated
	 */
	EReference getSpecificLocator_GenChildSideAffixedNode();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.papyrusgmfgenextension.PapyrusExtensionRootNode
	 * <em>Papyrus Extension Root Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Papyrus Extension Root Node</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.PapyrusExtensionRootNode
	 * @generated
	 */
	EClass getPapyrusExtensionRootNode();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.eclipse.papyrus.papyrusgmfgenextension.PapyrusExtensionRootNode#getExtensionNodes <em>Extension Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Extension Nodes</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.PapyrusExtensionRootNode#getExtensionNodes()
	 * @see #getPapyrusExtensionRootNode()
	 * @generated
	 */
	EReference getPapyrusExtensionRootNode_ExtensionNodes();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.papyrusgmfgenextension.AlternateCanvas <em>Alternate Canvas</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Alternate Canvas</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.AlternateCanvas
	 * @generated
	 */
	EClass getAlternateCanvas();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.papyrusgmfgenextension.AlternateCanvas#getDomainDiagramElement
	 * <em>Domain Diagram Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Domain Diagram Element</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.AlternateCanvas#getDomainDiagramElement()
	 * @see #getAlternateCanvas()
	 * @generated
	 */
	EReference getAlternateCanvas_DomainDiagramElement();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.eclipse.papyrus.papyrusgmfgenextension.AlternateCanvas#getAlternateTopLevelNodes <em>Alternate Top Level Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Alternate Top Level Nodes</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.AlternateCanvas#getAlternateTopLevelNodes()
	 * @see #getAlternateCanvas()
	 * @generated
	 */
	EReference getAlternateCanvas_AlternateTopLevelNodes();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.eclipse.papyrus.papyrusgmfgenextension.AlternateCanvas#getAlternateLinkNodes <em>Alternate Link Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Alternate Link Nodes</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.AlternateCanvas#getAlternateLinkNodes()
	 * @see #getAlternateCanvas()
	 * @generated
	 */
	EReference getAlternateCanvas_AlternateLinkNodes();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.papyrusgmfgenextension.AlternateCanvas#getDiagram <em>Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Diagram</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.AlternateCanvas#getDiagram()
	 * @see #getAlternateCanvas()
	 * @generated
	 */
	EReference getAlternateCanvas_Diagram();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.papyrusgmfgenextension.AlternateGenTopLevelNode
	 * <em>Alternate Gen Top Level Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Alternate Gen Top Level Node</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.AlternateGenTopLevelNode
	 * @generated
	 */
	EClass getAlternateGenTopLevelNode();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.papyrusgmfgenextension.AlternateGenTopLevelNode#getGenTopLevelNode
	 * <em>Gen Top Level Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Gen Top Level Node</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.AlternateGenTopLevelNode#getGenTopLevelNode()
	 * @see #getAlternateGenTopLevelNode()
	 * @generated
	 */
	EReference getAlternateGenTopLevelNode_GenTopLevelNode();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.eclipse.papyrus.papyrusgmfgenextension.AlternateGenTopLevelNode#getTypeModelFacet <em>Type Model Facet</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Type Model Facet</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.AlternateGenTopLevelNode#getTypeModelFacet()
	 * @see #getAlternateGenTopLevelNode()
	 * @generated
	 */
	EReference getAlternateGenTopLevelNode_TypeModelFacet();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.papyrusgmfgenextension.AlternateGenLink <em>Alternate Gen Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Alternate Gen Link</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.AlternateGenLink
	 * @generated
	 */
	EClass getAlternateGenLink();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.papyrusgmfgenextension.AlternateGenLink#getGenLinkNode
	 * <em>Gen Link Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Gen Link Node</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.AlternateGenLink#getGenLinkNode()
	 * @see #getAlternateGenLink()
	 * @generated
	 */
	EReference getAlternateGenLink_GenLinkNode();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.papyrusgmfgenextension.AlternateGenLink#getTypeModelFacet
	 * <em>Type Model Facet</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Type Model Facet</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.AlternateGenLink#getTypeModelFacet()
	 * @see #getAlternateGenLink()
	 * @generated
	 */
	EReference getAlternateGenLink_TypeModelFacet();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.papyrusgmfgenextension.MutatingCanvas <em>Mutating Canvas</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Mutating Canvas</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.MutatingCanvas
	 * @generated
	 */
	EClass getMutatingCanvas();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.eclipse.papyrus.papyrusgmfgenextension.MutatingCanvas#getAlternateCanvases <em>Alternate Canvases</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Alternate Canvases</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.MutatingCanvas#getAlternateCanvases()
	 * @see #getMutatingCanvas()
	 * @generated
	 */
	EReference getMutatingCanvas_AlternateCanvases();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.papyrusgmfgenextension.OwnedEditpart <em>Owned Editpart</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Owned Editpart</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.OwnedEditpart
	 * @generated
	 */
	EClass getOwnedEditpart();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.papyrusgmfgenextension.OwnedEditpart#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.OwnedEditpart#getName()
	 * @see #getOwnedEditpart()
	 * @generated
	 */
	EAttribute getOwnedEditpart_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.papyrusgmfgenextension.SpecificDiagramUpdater <em>Specific Diagram Updater</em>}
	 * '.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Specific Diagram Updater</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.SpecificDiagramUpdater
	 * @generated
	 */
	EClass getSpecificDiagramUpdater();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.papyrusgmfgenextension.SpecificDiagramUpdater#getGenNode
	 * <em>Gen Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Gen Node</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.SpecificDiagramUpdater#getGenNode()
	 * @see #getSpecificDiagramUpdater()
	 * @generated
	 */
	EReference getSpecificDiagramUpdater_GenNode();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.papyrusgmfgenextension.GenNodeConstraint <em>Gen Node Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Gen Node Constraint</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.GenNodeConstraint
	 * @generated
	 */
	EClass getGenNodeConstraint();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.papyrusgmfgenextension.GenNodeConstraint#getGenNode
	 * <em>Gen Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Gen Node</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.GenNodeConstraint#getGenNode()
	 * @see #getGenNodeConstraint()
	 * @generated
	 */
	EReference getGenNodeConstraint_GenNode();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.papyrusgmfgenextension.GenNodeConstraint#getGenConstraint
	 * <em>Gen Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Gen Constraint</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.GenNodeConstraint#getGenConstraint()
	 * @see #getGenNodeConstraint()
	 * @generated
	 */
	EReference getGenNodeConstraint_GenConstraint();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.papyrusgmfgenextension.SpecificLocatorExternalLabel
	 * <em>Specific Locator External Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Specific Locator External Label</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.SpecificLocatorExternalLabel
	 * @generated
	 */
	EClass getSpecificLocatorExternalLabel();

	/**
	 * Returns the meta object for the reference list '
	 * {@link org.eclipse.papyrus.papyrusgmfgenextension.SpecificLocatorExternalLabel#getGenExternalNodeLabel <em>Gen External Node Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Gen External Node Label</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.SpecificLocatorExternalLabel#getGenExternalNodeLabel()
	 * @see #getSpecificLocatorExternalLabel()
	 * @generated
	 */
	EReference getSpecificLocatorExternalLabel_GenExternalNodeLabel();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.papyrusgmfgenextension.AdditionalEditPartCandies
	 * <em>Additional Edit Part Candies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Additional Edit Part Candies</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.AdditionalEditPartCandies
	 * @generated
	 */
	EClass getAdditionalEditPartCandies();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.papyrus.papyrusgmfgenextension.AdditionalEditPartCandies#getBaseEditHelperPackage <em>Base Edit Helper Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Base Edit Helper Package</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.AdditionalEditPartCandies#getBaseEditHelperPackage()
	 * @see #getAdditionalEditPartCandies()
	 * @generated
	 */
	EAttribute getAdditionalEditPartCandies_BaseEditHelperPackage();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.papyrusgmfgenextension.EditPartUsingDeleteService
	 * <em>Edit Part Using Delete Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Edit Part Using Delete Service</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.EditPartUsingDeleteService
	 * @generated
	 */
	EClass getEditPartUsingDeleteService();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.papyrusgmfgenextension.EditPartUsingDeleteService#getName <em>Name</em>}
	 * '.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.EditPartUsingDeleteService#getName()
	 * @see #getEditPartUsingDeleteService()
	 * @generated
	 */
	EAttribute getEditPartUsingDeleteService_Name();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.papyrusgmfgenextension.EditPartUsingDeleteService#getGenView
	 * <em>Gen View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Gen View</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.EditPartUsingDeleteService#getGenView()
	 * @see #getEditPartUsingDeleteService()
	 * @generated
	 */
	EReference getEditPartUsingDeleteService_GenView();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PapyrusgmfgenextensionFactory getPapyrusgmfgenextensionFactory();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.ExtendedGenViewImpl <em>Extended Gen View</em>}'
		 * class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.ExtendedGenViewImpl
		 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusgmfgenextensionPackageImpl#getExtendedGenView()
		 * @generated
		 */
		EClass EXTENDED_GEN_VIEW = eINSTANCE.getExtendedGenView();

		/**
		 * The meta object literal for the '<em><b>Gen View</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference EXTENDED_GEN_VIEW__GEN_VIEW = eINSTANCE.getExtendedGenView_GenView();

		/**
		 * The meta object literal for the '<em><b>Is Abstract</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute EXTENDED_GEN_VIEW__IS_ABSTRACT = eINSTANCE.getExtendedGenView_IsAbstract();

		/**
		 * The meta object literal for the '<em><b>Super Gen Views</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference EXTENDED_GEN_VIEW__SUPER_GEN_VIEWS = eINSTANCE.getExtendedGenView_SuperGenViews();

		/**
		 * The meta object literal for the '<em><b>Prop Refresh Hook</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference EXTENDED_GEN_VIEW__PROP_REFRESH_HOOK = eINSTANCE.getExtendedGenView_PropRefreshHook();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute EXTENDED_GEN_VIEW__NAME = eINSTANCE.getExtendedGenView_Name();

		/**
		 * The meta object literal for the '<em><b>Super Owned Edit Part</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute EXTENDED_GEN_VIEW__SUPER_OWNED_EDIT_PART = eINSTANCE.getExtendedGenView_SuperOwnedEditPart();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.CommentedElementImpl <em>Commented Element</em>}'
		 * class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.CommentedElementImpl
		 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusgmfgenextensionPackageImpl#getCommentedElement()
		 * @generated
		 */
		EClass COMMENTED_ELEMENT = eINSTANCE.getCommentedElement();

		/**
		 * The meta object literal for the '<em><b>Comment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute COMMENTED_ELEMENT__COMMENT = eINSTANCE.getCommentedElement_Comment();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.PropertyRefreshHookImpl
		 * <em>Property Refresh Hook</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.PropertyRefreshHookImpl
		 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusgmfgenextensionPackageImpl#getPropertyRefreshHook()
		 * @generated
		 */
		EClass PROPERTY_REFRESH_HOOK = eINSTANCE.getPropertyRefreshHook();

		/**
		 * The meta object literal for the '<em><b>Triggering Condition</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute PROPERTY_REFRESH_HOOK__TRIGGERING_CONDITION = eINSTANCE.getPropertyRefreshHook_TriggeringCondition();

		/**
		 * The meta object literal for the '<em><b>Action</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute PROPERTY_REFRESH_HOOK__ACTION = eINSTANCE.getPropertyRefreshHook_Action();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.ExternalHookImpl <em>External Hook</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.ExternalHookImpl
		 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusgmfgenextensionPackageImpl#getExternalHook()
		 * @generated
		 */
		EClass EXTERNAL_HOOK = eINSTANCE.getExternalHook();

		/**
		 * The meta object literal for the '<em><b>Classpath</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute EXTERNAL_HOOK__CLASSPATH = eINSTANCE.getExternalHook_Classpath();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.SpecificLocatorImpl <em>Specific Locator</em>}'
		 * class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.SpecificLocatorImpl
		 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusgmfgenextensionPackageImpl#getSpecificLocator()
		 * @generated
		 */
		EClass SPECIFIC_LOCATOR = eINSTANCE.getSpecificLocator();

		/**
		 * The meta object literal for the '<em><b>Gen Child Side Affixed Node</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SPECIFIC_LOCATOR__GEN_CHILD_SIDE_AFFIXED_NODE = eINSTANCE.getSpecificLocator_GenChildSideAffixedNode();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusExtensionRootNodeImpl
		 * <em>Papyrus Extension Root Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusExtensionRootNodeImpl
		 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusgmfgenextensionPackageImpl#getPapyrusExtensionRootNode()
		 * @generated
		 */
		EClass PAPYRUS_EXTENSION_ROOT_NODE = eINSTANCE.getPapyrusExtensionRootNode();

		/**
		 * The meta object literal for the '<em><b>Extension Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference PAPYRUS_EXTENSION_ROOT_NODE__EXTENSION_NODES = eINSTANCE.getPapyrusExtensionRootNode_ExtensionNodes();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.AlternateCanvasImpl <em>Alternate Canvas</em>}'
		 * class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.AlternateCanvasImpl
		 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusgmfgenextensionPackageImpl#getAlternateCanvas()
		 * @generated
		 */
		EClass ALTERNATE_CANVAS = eINSTANCE.getAlternateCanvas();

		/**
		 * The meta object literal for the '<em><b>Domain Diagram Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ALTERNATE_CANVAS__DOMAIN_DIAGRAM_ELEMENT = eINSTANCE.getAlternateCanvas_DomainDiagramElement();

		/**
		 * The meta object literal for the '<em><b>Alternate Top Level Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ALTERNATE_CANVAS__ALTERNATE_TOP_LEVEL_NODES = eINSTANCE.getAlternateCanvas_AlternateTopLevelNodes();

		/**
		 * The meta object literal for the '<em><b>Alternate Link Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ALTERNATE_CANVAS__ALTERNATE_LINK_NODES = eINSTANCE.getAlternateCanvas_AlternateLinkNodes();

		/**
		 * The meta object literal for the '<em><b>Diagram</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ALTERNATE_CANVAS__DIAGRAM = eINSTANCE.getAlternateCanvas_Diagram();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.AlternateGenTopLevelNodeImpl
		 * <em>Alternate Gen Top Level Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.AlternateGenTopLevelNodeImpl
		 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusgmfgenextensionPackageImpl#getAlternateGenTopLevelNode()
		 * @generated
		 */
		EClass ALTERNATE_GEN_TOP_LEVEL_NODE = eINSTANCE.getAlternateGenTopLevelNode();

		/**
		 * The meta object literal for the '<em><b>Gen Top Level Node</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ALTERNATE_GEN_TOP_LEVEL_NODE__GEN_TOP_LEVEL_NODE = eINSTANCE.getAlternateGenTopLevelNode_GenTopLevelNode();

		/**
		 * The meta object literal for the '<em><b>Type Model Facet</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ALTERNATE_GEN_TOP_LEVEL_NODE__TYPE_MODEL_FACET = eINSTANCE.getAlternateGenTopLevelNode_TypeModelFacet();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.AlternateGenLinkImpl <em>Alternate Gen Link</em>}'
		 * class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.AlternateGenLinkImpl
		 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusgmfgenextensionPackageImpl#getAlternateGenLink()
		 * @generated
		 */
		EClass ALTERNATE_GEN_LINK = eINSTANCE.getAlternateGenLink();

		/**
		 * The meta object literal for the '<em><b>Gen Link Node</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ALTERNATE_GEN_LINK__GEN_LINK_NODE = eINSTANCE.getAlternateGenLink_GenLinkNode();

		/**
		 * The meta object literal for the '<em><b>Type Model Facet</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ALTERNATE_GEN_LINK__TYPE_MODEL_FACET = eINSTANCE.getAlternateGenLink_TypeModelFacet();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.MutatingCanvasImpl <em>Mutating Canvas</em>}'
		 * class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.MutatingCanvasImpl
		 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusgmfgenextensionPackageImpl#getMutatingCanvas()
		 * @generated
		 */
		EClass MUTATING_CANVAS = eINSTANCE.getMutatingCanvas();

		/**
		 * The meta object literal for the '<em><b>Alternate Canvases</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference MUTATING_CANVAS__ALTERNATE_CANVASES = eINSTANCE.getMutatingCanvas_AlternateCanvases();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.OwnedEditpartImpl <em>Owned Editpart</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.OwnedEditpartImpl
		 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusgmfgenextensionPackageImpl#getOwnedEditpart()
		 * @generated
		 */
		EClass OWNED_EDITPART = eINSTANCE.getOwnedEditpart();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute OWNED_EDITPART__NAME = eINSTANCE.getOwnedEditpart_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.SpecificDiagramUpdaterImpl
		 * <em>Specific Diagram Updater</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.SpecificDiagramUpdaterImpl
		 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusgmfgenextensionPackageImpl#getSpecificDiagramUpdater()
		 * @generated
		 */
		EClass SPECIFIC_DIAGRAM_UPDATER = eINSTANCE.getSpecificDiagramUpdater();

		/**
		 * The meta object literal for the '<em><b>Gen Node</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SPECIFIC_DIAGRAM_UPDATER__GEN_NODE = eINSTANCE.getSpecificDiagramUpdater_GenNode();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.GenNodeConstraintImpl <em>Gen Node Constraint</em>}
		 * ' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.GenNodeConstraintImpl
		 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusgmfgenextensionPackageImpl#getGenNodeConstraint()
		 * @generated
		 */
		EClass GEN_NODE_CONSTRAINT = eINSTANCE.getGenNodeConstraint();

		/**
		 * The meta object literal for the '<em><b>Gen Node</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference GEN_NODE_CONSTRAINT__GEN_NODE = eINSTANCE.getGenNodeConstraint_GenNode();

		/**
		 * The meta object literal for the '<em><b>Gen Constraint</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference GEN_NODE_CONSTRAINT__GEN_CONSTRAINT = eINSTANCE.getGenNodeConstraint_GenConstraint();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.SpecificLocatorExternalLabelImpl
		 * <em>Specific Locator External Label</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.SpecificLocatorExternalLabelImpl
		 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusgmfgenextensionPackageImpl#getSpecificLocatorExternalLabel()
		 * @generated
		 */
		EClass SPECIFIC_LOCATOR_EXTERNAL_LABEL = eINSTANCE.getSpecificLocatorExternalLabel();

		/**
		 * The meta object literal for the '<em><b>Gen External Node Label</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SPECIFIC_LOCATOR_EXTERNAL_LABEL__GEN_EXTERNAL_NODE_LABEL = eINSTANCE.getSpecificLocatorExternalLabel_GenExternalNodeLabel();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.AdditionalEditPartCandiesImpl
		 * <em>Additional Edit Part Candies</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.AdditionalEditPartCandiesImpl
		 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusgmfgenextensionPackageImpl#getAdditionalEditPartCandies()
		 * @generated
		 */
		EClass ADDITIONAL_EDIT_PART_CANDIES = eINSTANCE.getAdditionalEditPartCandies();

		/**
		 * The meta object literal for the '<em><b>Base Edit Helper Package</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ADDITIONAL_EDIT_PART_CANDIES__BASE_EDIT_HELPER_PACKAGE = eINSTANCE.getAdditionalEditPartCandies_BaseEditHelperPackage();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.EditPartUsingDeleteServiceImpl
		 * <em>Edit Part Using Delete Service</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.EditPartUsingDeleteServiceImpl
		 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusgmfgenextensionPackageImpl#getEditPartUsingDeleteService()
		 * @generated
		 */
		EClass EDIT_PART_USING_DELETE_SERVICE = eINSTANCE.getEditPartUsingDeleteService();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute EDIT_PART_USING_DELETE_SERVICE__NAME = eINSTANCE.getEditPartUsingDeleteService_Name();

		/**
		 * The meta object literal for the '<em><b>Gen View</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference EDIT_PART_USING_DELETE_SERVICE__GEN_VIEW = eINSTANCE.getEditPartUsingDeleteService_GenView();

	}

} //PapyrusgmfgenextensionPackage
