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
import org.eclipse.gmf.codegen.gmfgen.GMFGenPackage;

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
 * @see org.eclipse.papyrus.papyrusgmfgenextension.PapyrusgmfgenextensionFactory
 * @model kind="package"
 * @generated
 */
public interface PapyrusgmfgenextensionPackage extends EPackage {

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "papyrusgmfgenextension";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/2009/papyrusgmfgenextension";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "papyrusgmfgenextension";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PapyrusgmfgenextensionPackage eINSTANCE = org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusgmfgenextensionPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.CommentedElementImpl <em>Commented Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.CommentedElementImpl
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusgmfgenextensionPackageImpl#getCommentedElement()
	 * @generated
	 */
	int COMMENTED_ELEMENT = 1;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENTED_ELEMENT__COMMENT = 0;

	/**
	 * The number of structural features of the '<em>Commented Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENTED_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.ExtendedGenViewImpl <em>Extended Gen View</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.ExtendedGenViewImpl
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusgmfgenextensionPackageImpl#getExtendedGenView()
	 * @generated
	 */
	int EXTENDED_GEN_VIEW = 0;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_GEN_VIEW__COMMENT = COMMENTED_ELEMENT__COMMENT;

	/**
	 * The feature id for the '<em><b>Gen View</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_GEN_VIEW__GEN_VIEW = COMMENTED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_GEN_VIEW__IS_ABSTRACT = COMMENTED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Super Gen Views</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_GEN_VIEW__SUPER_GEN_VIEWS = COMMENTED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Prop Refresh Hook</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_GEN_VIEW__PROP_REFRESH_HOOK = COMMENTED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_GEN_VIEW__NAME = COMMENTED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Super Owned Edit Part</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_GEN_VIEW__SUPER_OWNED_EDIT_PART = COMMENTED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Extended Gen View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_GEN_VIEW_FEATURE_COUNT = COMMENTED_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.ExternalHookImpl <em>External Hook</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.ExternalHookImpl
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusgmfgenextensionPackageImpl#getExternalHook()
	 * @generated
	 */
	int EXTERNAL_HOOK = 3;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_HOOK__COMMENT = COMMENTED_ELEMENT__COMMENT;

	/**
	 * The feature id for the '<em><b>Classpath</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_HOOK__CLASSPATH = COMMENTED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>External Hook</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_HOOK_FEATURE_COUNT = COMMENTED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.PropertyRefreshHookImpl <em>Property Refresh Hook</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.PropertyRefreshHookImpl
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusgmfgenextensionPackageImpl#getPropertyRefreshHook()
	 * @generated
	 */
	int PROPERTY_REFRESH_HOOK = 2;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_REFRESH_HOOK__COMMENT = EXTERNAL_HOOK__COMMENT;

	/**
	 * The feature id for the '<em><b>Classpath</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_REFRESH_HOOK__CLASSPATH = EXTERNAL_HOOK__CLASSPATH;

	/**
	 * The feature id for the '<em><b>Triggering Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_REFRESH_HOOK__TRIGGERING_CONDITION = EXTERNAL_HOOK_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Action</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_REFRESH_HOOK__ACTION = EXTERNAL_HOOK_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Property Refresh Hook</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_REFRESH_HOOK_FEATURE_COUNT = EXTERNAL_HOOK_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.SpecificLocatorImpl <em>Specific Locator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.SpecificLocatorImpl
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusgmfgenextensionPackageImpl#getSpecificLocator()
	 * @generated
	 */
	int SPECIFIC_LOCATOR = 4;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_LOCATOR__COMMENT = EXTERNAL_HOOK__COMMENT;

	/**
	 * The feature id for the '<em><b>Classpath</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_LOCATOR__CLASSPATH = EXTERNAL_HOOK__CLASSPATH;

	/**
	 * The feature id for the '<em><b>Gen Child Side Affixed Node</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_LOCATOR__GEN_CHILD_SIDE_AFFIXED_NODE = EXTERNAL_HOOK_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Specific Locator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_LOCATOR_FEATURE_COUNT = EXTERNAL_HOOK_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusExtensionRootNodeImpl <em>Papyrus Extension Root Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusExtensionRootNodeImpl
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusgmfgenextensionPackageImpl#getPapyrusExtensionRootNode()
	 * @generated
	 */
	int PAPYRUS_EXTENSION_ROOT_NODE = 5;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_EXTENSION_ROOT_NODE__COMMENT = COMMENTED_ELEMENT__COMMENT;

	/**
	 * The feature id for the '<em><b>Extension Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_EXTENSION_ROOT_NODE__EXTENSION_NODES = COMMENTED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Papyrus Extension Root Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAPYRUS_EXTENSION_ROOT_NODE_FEATURE_COUNT = COMMENTED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.AlternateCanvasImpl <em>Alternate Canvas</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.AlternateCanvasImpl
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusgmfgenextensionPackageImpl#getAlternateCanvas()
	 * @generated
	 */
	int ALTERNATE_CANVAS = 6;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTERNATE_CANVAS__COMMENT = COMMENTED_ELEMENT__COMMENT;

	/**
	 * The feature id for the '<em><b>Domain Diagram Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTERNATE_CANVAS__DOMAIN_DIAGRAM_ELEMENT = COMMENTED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Alternate Top Level Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTERNATE_CANVAS__ALTERNATE_TOP_LEVEL_NODES = COMMENTED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Alternate Link Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTERNATE_CANVAS__ALTERNATE_LINK_NODES = COMMENTED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Diagram</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTERNATE_CANVAS__DIAGRAM = COMMENTED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Alternate Canvas</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTERNATE_CANVAS_FEATURE_COUNT = COMMENTED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.AlternateGenTopLevelNodeImpl <em>Alternate Gen Top Level Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.AlternateGenTopLevelNodeImpl
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusgmfgenextensionPackageImpl#getAlternateGenTopLevelNode()
	 * @generated
	 */
	int ALTERNATE_GEN_TOP_LEVEL_NODE = 7;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTERNATE_GEN_TOP_LEVEL_NODE__COMMENT = COMMENTED_ELEMENT__COMMENT;

	/**
	 * The feature id for the '<em><b>Gen Top Level Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTERNATE_GEN_TOP_LEVEL_NODE__GEN_TOP_LEVEL_NODE = COMMENTED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type Model Facet</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTERNATE_GEN_TOP_LEVEL_NODE__TYPE_MODEL_FACET = COMMENTED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Alternate Gen Top Level Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTERNATE_GEN_TOP_LEVEL_NODE_FEATURE_COUNT = COMMENTED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.AlternateGenLinkImpl <em>Alternate Gen Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.AlternateGenLinkImpl
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusgmfgenextensionPackageImpl#getAlternateGenLink()
	 * @generated
	 */
	int ALTERNATE_GEN_LINK = 8;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTERNATE_GEN_LINK__COMMENT = COMMENTED_ELEMENT__COMMENT;

	/**
	 * The feature id for the '<em><b>Gen Link Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTERNATE_GEN_LINK__GEN_LINK_NODE = COMMENTED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type Model Facet</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTERNATE_GEN_LINK__TYPE_MODEL_FACET = COMMENTED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Alternate Gen Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTERNATE_GEN_LINK_FEATURE_COUNT = COMMENTED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.MutatingCanvasImpl <em>Mutating Canvas</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.MutatingCanvasImpl
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusgmfgenextensionPackageImpl#getMutatingCanvas()
	 * @generated
	 */
	int MUTATING_CANVAS = 9;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTATING_CANVAS__COMMENT = COMMENTED_ELEMENT__COMMENT;

	/**
	 * The feature id for the '<em><b>Alternate Canvases</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTATING_CANVAS__ALTERNATE_CANVASES = COMMENTED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Mutating Canvas</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTATING_CANVAS_FEATURE_COUNT = COMMENTED_ELEMENT_FEATURE_COUNT + 1;


	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.OwnedEditpartImpl <em>Owned Editpart</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.OwnedEditpartImpl
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusgmfgenextensionPackageImpl#getOwnedEditpart()
	 * @generated
	 */
	int OWNED_EDITPART = 10;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OWNED_EDITPART__COMMENT = EXTERNAL_HOOK__COMMENT;

	/**
	 * The feature id for the '<em><b>Classpath</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OWNED_EDITPART__CLASSPATH = EXTERNAL_HOOK__CLASSPATH;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OWNED_EDITPART__NAME = EXTERNAL_HOOK_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Owned Editpart</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OWNED_EDITPART_FEATURE_COUNT = EXTERNAL_HOOK_FEATURE_COUNT + 1;


	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.SpecificDiagramUpdaterImpl <em>Specific Diagram Updater</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.SpecificDiagramUpdaterImpl
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusgmfgenextensionPackageImpl#getSpecificDiagramUpdater()
	 * @generated
	 */
	int SPECIFIC_DIAGRAM_UPDATER = 11;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_DIAGRAM_UPDATER__COMMENT = EXTERNAL_HOOK__COMMENT;

	/**
	 * The feature id for the '<em><b>Classpath</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_DIAGRAM_UPDATER__CLASSPATH = EXTERNAL_HOOK__CLASSPATH;

	/**
	 * The feature id for the '<em><b>Gen Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_DIAGRAM_UPDATER__GEN_NODE = EXTERNAL_HOOK_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Specific Diagram Updater</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_DIAGRAM_UPDATER_FEATURE_COUNT = EXTERNAL_HOOK_FEATURE_COUNT + 1;


	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.GenNodeConstraintImpl <em>Gen Node Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.GenNodeConstraintImpl
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusgmfgenextensionPackageImpl#getGenNodeConstraint()
	 * @generated
	 */
	int GEN_NODE_CONSTRAINT = 12;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_NODE_CONSTRAINT__COMMENT = COMMENTED_ELEMENT__COMMENT;

	/**
	 * The feature id for the '<em><b>Gen Node</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_NODE_CONSTRAINT__GEN_NODE = COMMENTED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Gen Constraint</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_NODE_CONSTRAINT__GEN_CONSTRAINT = COMMENTED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Gen Node Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_NODE_CONSTRAINT_FEATURE_COUNT = COMMENTED_ELEMENT_FEATURE_COUNT + 2;


	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.SpecificLocatorExternalLabelImpl <em>Specific Locator External Label</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.SpecificLocatorExternalLabelImpl
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusgmfgenextensionPackageImpl#getSpecificLocatorExternalLabel()
	 * @generated
	 */
	int SPECIFIC_LOCATOR_EXTERNAL_LABEL = 13;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_LOCATOR_EXTERNAL_LABEL__COMMENT = EXTERNAL_HOOK__COMMENT;

	/**
	 * The feature id for the '<em><b>Classpath</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_LOCATOR_EXTERNAL_LABEL__CLASSPATH = EXTERNAL_HOOK__CLASSPATH;

	/**
	 * The feature id for the '<em><b>Gen External Node Label</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_LOCATOR_EXTERNAL_LABEL__GEN_EXTERNAL_NODE_LABEL = EXTERNAL_HOOK_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Specific Locator External Label</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFIC_LOCATOR_EXTERNAL_LABEL_FEATURE_COUNT = EXTERNAL_HOOK_FEATURE_COUNT + 1;


	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.AdditionalEditPartCandiesImpl <em>Additional Edit Part Candies</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.AdditionalEditPartCandiesImpl
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusgmfgenextensionPackageImpl#getAdditionalEditPartCandies()
	 * @generated
	 */
	int ADDITIONAL_EDIT_PART_CANDIES = 14;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDITIONAL_EDIT_PART_CANDIES__COMMENT = COMMENTED_ELEMENT__COMMENT;

	/**
	 * The feature id for the '<em><b>Base Edit Helper Package</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDITIONAL_EDIT_PART_CANDIES__BASE_EDIT_HELPER_PACKAGE = COMMENTED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Additional Edit Part Candies</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDITIONAL_EDIT_PART_CANDIES_FEATURE_COUNT = COMMENTED_ELEMENT_FEATURE_COUNT + 1;


	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.EditPartUsingDeleteServiceImpl <em>Edit Part Using Delete Service</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.EditPartUsingDeleteServiceImpl
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusgmfgenextensionPackageImpl#getEditPartUsingDeleteService()
	 * @generated
	 */
	int EDIT_PART_USING_DELETE_SERVICE = 15;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIT_PART_USING_DELETE_SERVICE__COMMENT = COMMENTED_ELEMENT__COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIT_PART_USING_DELETE_SERVICE__NAME = COMMENTED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Gen View</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIT_PART_USING_DELETE_SERVICE__GEN_VIEW = COMMENTED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Edit Part Using Delete Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIT_PART_USING_DELETE_SERVICE_FEATURE_COUNT = COMMENTED_ELEMENT_FEATURE_COUNT + 2;


	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.EditPartUsingReorientServiceImpl <em>Edit Part Using Reorient Service</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.EditPartUsingReorientServiceImpl
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusgmfgenextensionPackageImpl#getEditPartUsingReorientService()
	 * @generated
	 */
	int EDIT_PART_USING_REORIENT_SERVICE = 16;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIT_PART_USING_REORIENT_SERVICE__COMMENT = COMMENTED_ELEMENT__COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIT_PART_USING_REORIENT_SERVICE__NAME = COMMENTED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Gen View</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIT_PART_USING_REORIENT_SERVICE__GEN_VIEW = COMMENTED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Edit Part Using Reorient Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIT_PART_USING_REORIENT_SERVICE_FEATURE_COUNT = COMMENTED_ELEMENT_FEATURE_COUNT + 2;


	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.LabelVisibilityPreferenceImpl <em>Label Visibility Preference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.LabelVisibilityPreferenceImpl
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusgmfgenextensionPackageImpl#getLabelVisibilityPreference()
	 * @generated
	 */
	int LABEL_VISIBILITY_PREFERENCE = 17;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL_VISIBILITY_PREFERENCE__COMMENT = COMMENTED_ELEMENT__COMMENT;

	/**
	 * The feature id for the '<em><b>Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL_VISIBILITY_PREFERENCE__ROLE = COMMENTED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Icon Path Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL_VISIBILITY_PREFERENCE__ICON_PATH_ROLE = COMMENTED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Link Labels</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL_VISIBILITY_PREFERENCE__LINK_LABELS = COMMENTED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>External Node Labels</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL_VISIBILITY_PREFERENCE__EXTERNAL_NODE_LABELS = COMMENTED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Visible By Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL_VISIBILITY_PREFERENCE__VISIBLE_BY_DEFAULT = COMMENTED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Label Visibility Preference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL_VISIBILITY_PREFERENCE_FEATURE_COUNT = COMMENTED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.CompartmentVisibilityPreferenceImpl <em>Compartment Visibility Preference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.CompartmentVisibilityPreferenceImpl
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusgmfgenextensionPackageImpl#getCompartmentVisibilityPreference()
	 * @generated
	 */
	int COMPARTMENT_VISIBILITY_PREFERENCE = 18;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARTMENT_VISIBILITY_PREFERENCE__COMMENT = COMMENTED_ELEMENT__COMMENT;

	/**
	 * The feature id for the '<em><b>Visible By Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARTMENT_VISIBILITY_PREFERENCE__VISIBLE_BY_DEFAULT = COMMENTED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Compartments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARTMENT_VISIBILITY_PREFERENCE__COMPARTMENTS = COMMENTED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Compartment Visibility Preference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARTMENT_VISIBILITY_PREFERENCE_FEATURE_COUNT = COMMENTED_ELEMENT_FEATURE_COUNT + 2;


	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.CompartmentTitleVisibilityPreferenceImpl <em>Compartment Title Visibility Preference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.CompartmentTitleVisibilityPreferenceImpl
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusgmfgenextensionPackageImpl#getCompartmentTitleVisibilityPreference()
	 * @generated
	 */
	int COMPARTMENT_TITLE_VISIBILITY_PREFERENCE = 19;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARTMENT_TITLE_VISIBILITY_PREFERENCE__COMMENT = COMMENTED_ELEMENT__COMMENT;

	/**
	 * The feature id for the '<em><b>Visible By Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARTMENT_TITLE_VISIBILITY_PREFERENCE__VISIBLE_BY_DEFAULT = COMMENTED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Compartments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARTMENT_TITLE_VISIBILITY_PREFERENCE__COMPARTMENTS = COMMENTED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Compartment Title Visibility Preference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARTMENT_TITLE_VISIBILITY_PREFERENCE_FEATURE_COUNT = COMMENTED_ELEMENT_FEATURE_COUNT + 2;


	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.ConstrainedByReferenceCompartmentItemSemanticEditPolicyImpl <em>Constrained By Reference Compartment Item Semantic Edit Policy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.ConstrainedByReferenceCompartmentItemSemanticEditPolicyImpl
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusgmfgenextensionPackageImpl#getConstrainedByReferenceCompartmentItemSemanticEditPolicy()
	 * @generated
	 */
	int CONSTRAINED_BY_REFERENCE_COMPARTMENT_ITEM_SEMANTIC_EDIT_POLICY = 20;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINED_BY_REFERENCE_COMPARTMENT_ITEM_SEMANTIC_EDIT_POLICY__COMMENT = COMMENTED_ELEMENT__COMMENT;

	/**
	 * The feature id for the '<em><b>Gen View</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINED_BY_REFERENCE_COMPARTMENT_ITEM_SEMANTIC_EDIT_POLICY__GEN_VIEW = COMMENTED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Constrained By Reference Compartment Item Semantic Edit Policy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINED_BY_REFERENCE_COMPARTMENT_ITEM_SEMANTIC_EDIT_POLICY_FEATURE_COUNT = COMMENTED_ELEMENT_FEATURE_COUNT + 1;


	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.ExternalElementTypesLibraryImpl <em>External Element Types Library</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.ExternalElementTypesLibraryImpl
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusgmfgenextensionPackageImpl#getExternalElementTypesLibrary()
	 * @generated
	 */
	int EXTERNAL_ELEMENT_TYPES_LIBRARY = 21;

	/**
	 * The feature id for the '<em><b>Diagram Run Time Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_ELEMENT_TYPES_LIBRARY__DIAGRAM_RUN_TIME_CLASS = GMFGenPackage.GEN_NODE__DIAGRAM_RUN_TIME_CLASS;

	/**
	 * The feature id for the '<em><b>Visual ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_ELEMENT_TYPES_LIBRARY__VISUAL_ID = GMFGenPackage.GEN_NODE__VISUAL_ID;

	/**
	 * The feature id for the '<em><b>Element Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_ELEMENT_TYPES_LIBRARY__ELEMENT_TYPE = GMFGenPackage.GEN_NODE__ELEMENT_TYPE;

	/**
	 * The feature id for the '<em><b>Edit Part Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_ELEMENT_TYPES_LIBRARY__EDIT_PART_CLASS_NAME = GMFGenPackage.GEN_NODE__EDIT_PART_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Item Semantic Edit Policy Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_ELEMENT_TYPES_LIBRARY__ITEM_SEMANTIC_EDIT_POLICY_CLASS_NAME = GMFGenPackage.GEN_NODE__ITEM_SEMANTIC_EDIT_POLICY_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Notation View Factory Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_ELEMENT_TYPES_LIBRARY__NOTATION_VIEW_FACTORY_CLASS_NAME = GMFGenPackage.GEN_NODE__NOTATION_VIEW_FACTORY_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Viewmap</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_ELEMENT_TYPES_LIBRARY__VIEWMAP = GMFGenPackage.GEN_NODE__VIEWMAP;

	/**
	 * The feature id for the '<em><b>Styles</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_ELEMENT_TYPES_LIBRARY__STYLES = GMFGenPackage.GEN_NODE__STYLES;

	/**
	 * The feature id for the '<em><b>Behaviour</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_ELEMENT_TYPES_LIBRARY__BEHAVIOUR = GMFGenPackage.GEN_NODE__BEHAVIOUR;

	/**
	 * The feature id for the '<em><b>Sans Domain</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_ELEMENT_TYPES_LIBRARY__SANS_DOMAIN = GMFGenPackage.GEN_NODE__SANS_DOMAIN;

	/**
	 * The feature id for the '<em><b>Contained Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_ELEMENT_TYPES_LIBRARY__CONTAINED_NODES = GMFGenPackage.GEN_NODE__CONTAINED_NODES;

	/**
	 * The feature id for the '<em><b>Canonical Edit Policy Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_ELEMENT_TYPES_LIBRARY__CANONICAL_EDIT_POLICY_CLASS_NAME = GMFGenPackage.GEN_NODE__CANONICAL_EDIT_POLICY_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Child Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_ELEMENT_TYPES_LIBRARY__CHILD_NODES = GMFGenPackage.GEN_NODE__CHILD_NODES;

	/**
	 * The feature id for the '<em><b>Gen Outgoing Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_ELEMENT_TYPES_LIBRARY__GEN_OUTGOING_LINKS = GMFGenPackage.GEN_NODE__GEN_OUTGOING_LINKS;

	/**
	 * The feature id for the '<em><b>Gen Incoming Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_ELEMENT_TYPES_LIBRARY__GEN_INCOMING_LINKS = GMFGenPackage.GEN_NODE__GEN_INCOMING_LINKS;

	/**
	 * The feature id for the '<em><b>Model Facet</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_ELEMENT_TYPES_LIBRARY__MODEL_FACET = GMFGenPackage.GEN_NODE__MODEL_FACET;

	/**
	 * The feature id for the '<em><b>Labels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_ELEMENT_TYPES_LIBRARY__LABELS = GMFGenPackage.GEN_NODE__LABELS;

	/**
	 * The feature id for the '<em><b>Compartments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_ELEMENT_TYPES_LIBRARY__COMPARTMENTS = GMFGenPackage.GEN_NODE__COMPARTMENTS;

	/**
	 * The feature id for the '<em><b>Primary Drag Edit Policy Qualified Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_ELEMENT_TYPES_LIBRARY__PRIMARY_DRAG_EDIT_POLICY_QUALIFIED_CLASS_NAME = GMFGenPackage.GEN_NODE__PRIMARY_DRAG_EDIT_POLICY_QUALIFIED_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Graphical Node Edit Policy Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_ELEMENT_TYPES_LIBRARY__GRAPHICAL_NODE_EDIT_POLICY_CLASS_NAME = GMFGenPackage.GEN_NODE__GRAPHICAL_NODE_EDIT_POLICY_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Create Command Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_ELEMENT_TYPES_LIBRARY__CREATE_COMMAND_CLASS_NAME = GMFGenPackage.GEN_NODE__CREATE_COMMAND_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Reoriented Incoming Links</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_ELEMENT_TYPES_LIBRARY__REORIENTED_INCOMING_LINKS = GMFGenPackage.GEN_NODE__REORIENTED_INCOMING_LINKS;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_ELEMENT_TYPES_LIBRARY__COMMENT = GMFGenPackage.GEN_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>External Element Types Library</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_ELEMENT_TYPES_LIBRARY_FEATURE_COUNT = GMFGenPackage.GEN_NODE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.ExternalMetamodelTypeImpl <em>External Metamodel Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.ExternalMetamodelTypeImpl
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusgmfgenextensionPackageImpl#getExternalMetamodelType()
	 * @generated
	 */
	int EXTERNAL_METAMODEL_TYPE = 22;

	/**
	 * The feature id for the '<em><b>Diagram Element</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_METAMODEL_TYPE__DIAGRAM_ELEMENT = GMFGenPackage.METAMODEL_TYPE__DIAGRAM_ELEMENT;

	/**
	 * The feature id for the '<em><b>Unique Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_METAMODEL_TYPE__UNIQUE_IDENTIFIER = GMFGenPackage.METAMODEL_TYPE__UNIQUE_IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_METAMODEL_TYPE__DISPLAY_NAME = GMFGenPackage.METAMODEL_TYPE__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Defined Externally</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_METAMODEL_TYPE__DEFINED_EXTERNALLY = GMFGenPackage.METAMODEL_TYPE__DEFINED_EXTERNALLY;

	/**
	 * The feature id for the '<em><b>Edit Helper Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_METAMODEL_TYPE__EDIT_HELPER_CLASS_NAME = GMFGenPackage.METAMODEL_TYPE__EDIT_HELPER_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Element Type Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_METAMODEL_TYPE__ELEMENT_TYPE_REF = GMFGenPackage.METAMODEL_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>External Metamodel Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_METAMODEL_TYPE_FEATURE_COUNT = GMFGenPackage.METAMODEL_TYPE_FEATURE_COUNT + 1;


	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.GenerateUsingElementTypeCreationCommandImpl <em>Generate Using Element Type Creation Command</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.GenerateUsingElementTypeCreationCommandImpl
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusgmfgenextensionPackageImpl#getGenerateUsingElementTypeCreationCommand()
	 * @generated
	 */
	int GENERATE_USING_ELEMENT_TYPE_CREATION_COMMAND = 23;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATE_USING_ELEMENT_TYPE_CREATION_COMMAND__COMMENT = COMMENTED_ELEMENT__COMMENT;

	/**
	 * The number of structural features of the '<em>Generate Using Element Type Creation Command</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATE_USING_ELEMENT_TYPE_CREATION_COMMAND_FEATURE_COUNT = COMMENTED_ELEMENT_FEATURE_COUNT + 0;


	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.CustomDiagramUpdaterSingletonImpl <em>Custom Diagram Updater Singleton</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.CustomDiagramUpdaterSingletonImpl
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusgmfgenextensionPackageImpl#getCustomDiagramUpdaterSingleton()
	 * @generated
	 */
	int CUSTOM_DIAGRAM_UPDATER_SINGLETON = 24;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_DIAGRAM_UPDATER_SINGLETON__COMMENT = COMMENTED_ELEMENT__COMMENT;

	/**
	 * The feature id for the '<em><b>Singleton Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_DIAGRAM_UPDATER_SINGLETON__SINGLETON_PATH = COMMENTED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Custom Diagram Updater Singleton</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_DIAGRAM_UPDATER_SINGLETON_FEATURE_COUNT = COMMENTED_ELEMENT_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.papyrusgmfgenextension.ExtendedGenView <em>Extended Gen View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extended Gen View</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.ExtendedGenView
	 * @generated
	 */
	EClass getExtendedGenView();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.papyrusgmfgenextension.ExtendedGenView#getGenView <em>Gen View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Gen View</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.ExtendedGenView#getGenView()
	 * @see #getExtendedGenView()
	 * @generated
	 */
	EReference getExtendedGenView_GenView();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.papyrusgmfgenextension.ExtendedGenView#isIsAbstract <em>Is Abstract</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Abstract</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.ExtendedGenView#isIsAbstract()
	 * @see #getExtendedGenView()
	 * @generated
	 */
	EAttribute getExtendedGenView_IsAbstract();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.papyrusgmfgenextension.ExtendedGenView#getSuperGenViews <em>Super Gen Views</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Super Gen Views</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.ExtendedGenView#getSuperGenViews()
	 * @see #getExtendedGenView()
	 * @generated
	 */
	EReference getExtendedGenView_SuperGenViews();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.papyrusgmfgenextension.ExtendedGenView#getPropRefreshHook <em>Prop Refresh Hook</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.ExtendedGenView#getName()
	 * @see #getExtendedGenView()
	 * @generated
	 */
	EAttribute getExtendedGenView_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.papyrusgmfgenextension.ExtendedGenView#getSuperOwnedEditPart <em>Super Owned Edit Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	 * @return the meta object for class '<em>Commented Element</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.CommentedElement
	 * @generated
	 */
	EClass getCommentedElement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.papyrusgmfgenextension.CommentedElement#getComment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	 * @return the meta object for class '<em>Property Refresh Hook</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.PropertyRefreshHook
	 * @generated
	 */
	EClass getPropertyRefreshHook();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.papyrusgmfgenextension.PropertyRefreshHook#getTriggeringCondition <em>Triggering Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	 * @return the meta object for class '<em>External Hook</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.ExternalHook
	 * @generated
	 */
	EClass getExternalHook();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.papyrusgmfgenextension.ExternalHook#getClasspath <em>Classpath</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	 * @return the meta object for class '<em>Specific Locator</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.SpecificLocator
	 * @generated
	 */
	EClass getSpecificLocator();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.papyrusgmfgenextension.SpecificLocator#getGenChildSideAffixedNode <em>Gen Child Side Affixed Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Gen Child Side Affixed Node</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.SpecificLocator#getGenChildSideAffixedNode()
	 * @see #getSpecificLocator()
	 * @generated
	 */
	EReference getSpecificLocator_GenChildSideAffixedNode();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.papyrusgmfgenextension.PapyrusExtensionRootNode <em>Papyrus Extension Root Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Papyrus Extension Root Node</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.PapyrusExtensionRootNode
	 * @generated
	 */
	EClass getPapyrusExtensionRootNode();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.papyrusgmfgenextension.PapyrusExtensionRootNode#getExtensionNodes <em>Extension Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	 * @return the meta object for class '<em>Alternate Canvas</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.AlternateCanvas
	 * @generated
	 */
	EClass getAlternateCanvas();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.papyrusgmfgenextension.AlternateCanvas#getDomainDiagramElement <em>Domain Diagram Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Domain Diagram Element</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.AlternateCanvas#getDomainDiagramElement()
	 * @see #getAlternateCanvas()
	 * @generated
	 */
	EReference getAlternateCanvas_DomainDiagramElement();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.papyrusgmfgenextension.AlternateCanvas#getAlternateTopLevelNodes <em>Alternate Top Level Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Alternate Top Level Nodes</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.AlternateCanvas#getAlternateTopLevelNodes()
	 * @see #getAlternateCanvas()
	 * @generated
	 */
	EReference getAlternateCanvas_AlternateTopLevelNodes();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.papyrusgmfgenextension.AlternateCanvas#getAlternateLinkNodes <em>Alternate Link Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	 * @return the meta object for the reference '<em>Diagram</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.AlternateCanvas#getDiagram()
	 * @see #getAlternateCanvas()
	 * @generated
	 */
	EReference getAlternateCanvas_Diagram();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.papyrusgmfgenextension.AlternateGenTopLevelNode <em>Alternate Gen Top Level Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Alternate Gen Top Level Node</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.AlternateGenTopLevelNode
	 * @generated
	 */
	EClass getAlternateGenTopLevelNode();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.papyrusgmfgenextension.AlternateGenTopLevelNode#getGenTopLevelNode <em>Gen Top Level Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Gen Top Level Node</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.AlternateGenTopLevelNode#getGenTopLevelNode()
	 * @see #getAlternateGenTopLevelNode()
	 * @generated
	 */
	EReference getAlternateGenTopLevelNode_GenTopLevelNode();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.papyrusgmfgenextension.AlternateGenTopLevelNode#getTypeModelFacet <em>Type Model Facet</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	 * @return the meta object for class '<em>Alternate Gen Link</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.AlternateGenLink
	 * @generated
	 */
	EClass getAlternateGenLink();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.papyrusgmfgenextension.AlternateGenLink#getGenLinkNode <em>Gen Link Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Gen Link Node</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.AlternateGenLink#getGenLinkNode()
	 * @see #getAlternateGenLink()
	 * @generated
	 */
	EReference getAlternateGenLink_GenLinkNode();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.papyrusgmfgenextension.AlternateGenLink#getTypeModelFacet <em>Type Model Facet</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	 * @return the meta object for class '<em>Mutating Canvas</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.MutatingCanvas
	 * @generated
	 */
	EClass getMutatingCanvas();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.papyrusgmfgenextension.MutatingCanvas#getAlternateCanvases <em>Alternate Canvases</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	 * @return the meta object for class '<em>Owned Editpart</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.OwnedEditpart
	 * @generated
	 */
	EClass getOwnedEditpart();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.papyrusgmfgenextension.OwnedEditpart#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.OwnedEditpart#getName()
	 * @see #getOwnedEditpart()
	 * @generated
	 */
	EAttribute getOwnedEditpart_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.papyrusgmfgenextension.SpecificDiagramUpdater <em>Specific Diagram Updater</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Specific Diagram Updater</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.SpecificDiagramUpdater
	 * @generated
	 */
	EClass getSpecificDiagramUpdater();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.papyrusgmfgenextension.SpecificDiagramUpdater#getGenNode <em>Gen Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	 * @return the meta object for class '<em>Gen Node Constraint</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.GenNodeConstraint
	 * @generated
	 */
	EClass getGenNodeConstraint();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.papyrusgmfgenextension.GenNodeConstraint#getGenNode <em>Gen Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Gen Node</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.GenNodeConstraint#getGenNode()
	 * @see #getGenNodeConstraint()
	 * @generated
	 */
	EReference getGenNodeConstraint_GenNode();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.papyrusgmfgenextension.GenNodeConstraint#getGenConstraint <em>Gen Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Gen Constraint</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.GenNodeConstraint#getGenConstraint()
	 * @see #getGenNodeConstraint()
	 * @generated
	 */
	EReference getGenNodeConstraint_GenConstraint();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.papyrusgmfgenextension.SpecificLocatorExternalLabel <em>Specific Locator External Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Specific Locator External Label</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.SpecificLocatorExternalLabel
	 * @generated
	 */
	EClass getSpecificLocatorExternalLabel();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.papyrusgmfgenextension.SpecificLocatorExternalLabel#getGenExternalNodeLabel <em>Gen External Node Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Gen External Node Label</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.SpecificLocatorExternalLabel#getGenExternalNodeLabel()
	 * @see #getSpecificLocatorExternalLabel()
	 * @generated
	 */
	EReference getSpecificLocatorExternalLabel_GenExternalNodeLabel();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.papyrusgmfgenextension.AdditionalEditPartCandies <em>Additional Edit Part Candies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Additional Edit Part Candies</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.AdditionalEditPartCandies
	 * @generated
	 */
	EClass getAdditionalEditPartCandies();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.papyrusgmfgenextension.AdditionalEditPartCandies#getBaseEditHelperPackage <em>Base Edit Helper Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Base Edit Helper Package</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.AdditionalEditPartCandies#getBaseEditHelperPackage()
	 * @see #getAdditionalEditPartCandies()
	 * @generated
	 */
	EAttribute getAdditionalEditPartCandies_BaseEditHelperPackage();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.papyrusgmfgenextension.EditPartUsingDeleteService <em>Edit Part Using Delete Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Edit Part Using Delete Service</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.EditPartUsingDeleteService
	 * @generated
	 */
	EClass getEditPartUsingDeleteService();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.papyrusgmfgenextension.EditPartUsingDeleteService#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.EditPartUsingDeleteService#getName()
	 * @see #getEditPartUsingDeleteService()
	 * @generated
	 */
	EAttribute getEditPartUsingDeleteService_Name();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.papyrusgmfgenextension.EditPartUsingDeleteService#getGenView <em>Gen View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Gen View</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.EditPartUsingDeleteService#getGenView()
	 * @see #getEditPartUsingDeleteService()
	 * @generated
	 */
	EReference getEditPartUsingDeleteService_GenView();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.papyrusgmfgenextension.EditPartUsingReorientService <em>Edit Part Using Reorient Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Edit Part Using Reorient Service</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.EditPartUsingReorientService
	 * @generated
	 */
	EClass getEditPartUsingReorientService();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.papyrusgmfgenextension.EditPartUsingReorientService#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.EditPartUsingReorientService#getName()
	 * @see #getEditPartUsingReorientService()
	 * @generated
	 */
	EAttribute getEditPartUsingReorientService_Name();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.papyrusgmfgenextension.EditPartUsingReorientService#getGenView <em>Gen View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Gen View</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.EditPartUsingReorientService#getGenView()
	 * @see #getEditPartUsingReorientService()
	 * @generated
	 */
	EReference getEditPartUsingReorientService_GenView();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.papyrusgmfgenextension.LabelVisibilityPreference <em>Label Visibility Preference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Label Visibility Preference</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.LabelVisibilityPreference
	 * @generated
	 */
	EClass getLabelVisibilityPreference();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.papyrusgmfgenextension.LabelVisibilityPreference#getRole <em>Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Role</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.LabelVisibilityPreference#getRole()
	 * @see #getLabelVisibilityPreference()
	 * @generated
	 */
	EAttribute getLabelVisibilityPreference_Role();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.papyrusgmfgenextension.LabelVisibilityPreference#getIconPathRole <em>Icon Path Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Icon Path Role</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.LabelVisibilityPreference#getIconPathRole()
	 * @see #getLabelVisibilityPreference()
	 * @generated
	 */
	EAttribute getLabelVisibilityPreference_IconPathRole();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.papyrusgmfgenextension.LabelVisibilityPreference#getLinkLabels <em>Link Labels</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Link Labels</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.LabelVisibilityPreference#getLinkLabels()
	 * @see #getLabelVisibilityPreference()
	 * @generated
	 */
	EReference getLabelVisibilityPreference_LinkLabels();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.papyrusgmfgenextension.LabelVisibilityPreference#getExternalNodeLabels <em>External Node Labels</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>External Node Labels</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.LabelVisibilityPreference#getExternalNodeLabels()
	 * @see #getLabelVisibilityPreference()
	 * @generated
	 */
	EReference getLabelVisibilityPreference_ExternalNodeLabels();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.papyrusgmfgenextension.LabelVisibilityPreference#isVisibleByDefault <em>Visible By Default</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Visible By Default</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.LabelVisibilityPreference#isVisibleByDefault()
	 * @see #getLabelVisibilityPreference()
	 * @generated
	 */
	EAttribute getLabelVisibilityPreference_VisibleByDefault();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.papyrusgmfgenextension.CompartmentVisibilityPreference <em>Compartment Visibility Preference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Compartment Visibility Preference</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.CompartmentVisibilityPreference
	 * @generated
	 */
	EClass getCompartmentVisibilityPreference();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.papyrusgmfgenextension.CompartmentVisibilityPreference#isVisibleByDefault <em>Visible By Default</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Visible By Default</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.CompartmentVisibilityPreference#isVisibleByDefault()
	 * @see #getCompartmentVisibilityPreference()
	 * @generated
	 */
	EAttribute getCompartmentVisibilityPreference_VisibleByDefault();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.papyrusgmfgenextension.CompartmentVisibilityPreference#getCompartments <em>Compartments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Compartments</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.CompartmentVisibilityPreference#getCompartments()
	 * @see #getCompartmentVisibilityPreference()
	 * @generated
	 */
	EReference getCompartmentVisibilityPreference_Compartments();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.papyrusgmfgenextension.CompartmentTitleVisibilityPreference <em>Compartment Title Visibility Preference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Compartment Title Visibility Preference</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.CompartmentTitleVisibilityPreference
	 * @generated
	 */
	EClass getCompartmentTitleVisibilityPreference();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.papyrusgmfgenextension.CompartmentTitleVisibilityPreference#isVisibleByDefault <em>Visible By Default</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Visible By Default</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.CompartmentTitleVisibilityPreference#isVisibleByDefault()
	 * @see #getCompartmentTitleVisibilityPreference()
	 * @generated
	 */
	EAttribute getCompartmentTitleVisibilityPreference_VisibleByDefault();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.papyrusgmfgenextension.CompartmentTitleVisibilityPreference#getCompartments <em>Compartments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Compartments</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.CompartmentTitleVisibilityPreference#getCompartments()
	 * @see #getCompartmentTitleVisibilityPreference()
	 * @generated
	 */
	EReference getCompartmentTitleVisibilityPreference_Compartments();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.papyrusgmfgenextension.ConstrainedByReferenceCompartmentItemSemanticEditPolicy <em>Constrained By Reference Compartment Item Semantic Edit Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constrained By Reference Compartment Item Semantic Edit Policy</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.ConstrainedByReferenceCompartmentItemSemanticEditPolicy
	 * @generated
	 */
	EClass getConstrainedByReferenceCompartmentItemSemanticEditPolicy();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.papyrusgmfgenextension.ConstrainedByReferenceCompartmentItemSemanticEditPolicy#getGenView <em>Gen View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Gen View</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.ConstrainedByReferenceCompartmentItemSemanticEditPolicy#getGenView()
	 * @see #getConstrainedByReferenceCompartmentItemSemanticEditPolicy()
	 * @generated
	 */
	EReference getConstrainedByReferenceCompartmentItemSemanticEditPolicy_GenView();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.papyrusgmfgenextension.ExternalElementTypesLibrary <em>External Element Types Library</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>External Element Types Library</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.ExternalElementTypesLibrary
	 * @generated
	 */
	EClass getExternalElementTypesLibrary();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.papyrusgmfgenextension.ExternalMetamodelType <em>External Metamodel Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>External Metamodel Type</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.ExternalMetamodelType
	 * @generated
	 */
	EClass getExternalMetamodelType();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.papyrusgmfgenextension.ExternalMetamodelType#getElementTypeRef <em>Element Type Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Element Type Ref</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.ExternalMetamodelType#getElementTypeRef()
	 * @see #getExternalMetamodelType()
	 * @generated
	 */
	EReference getExternalMetamodelType_ElementTypeRef();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.papyrusgmfgenextension.GenerateUsingElementTypeCreationCommand <em>Generate Using Element Type Creation Command</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Generate Using Element Type Creation Command</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.GenerateUsingElementTypeCreationCommand
	 * @generated
	 */
	EClass getGenerateUsingElementTypeCreationCommand();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.papyrusgmfgenextension.CustomDiagramUpdaterSingleton <em>Custom Diagram Updater Singleton</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Custom Diagram Updater Singleton</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.CustomDiagramUpdaterSingleton
	 * @generated
	 */
	EClass getCustomDiagramUpdaterSingleton();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.papyrusgmfgenextension.CustomDiagramUpdaterSingleton#getSingletonPath <em>Singleton Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Singleton Path</em>'.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.CustomDiagramUpdaterSingleton#getSingletonPath()
	 * @see #getCustomDiagramUpdaterSingleton()
	 * @generated
	 */
	EAttribute getCustomDiagramUpdaterSingleton_SingletonPath();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	 * @generated
	 */
	interface Literals {

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.ExtendedGenViewImpl <em>Extended Gen View</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.ExtendedGenViewImpl
		 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusgmfgenextensionPackageImpl#getExtendedGenView()
		 * @generated
		 */
		EClass EXTENDED_GEN_VIEW = eINSTANCE.getExtendedGenView();

		/**
		 * The meta object literal for the '<em><b>Gen View</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENDED_GEN_VIEW__GEN_VIEW = eINSTANCE.getExtendedGenView_GenView();

		/**
		 * The meta object literal for the '<em><b>Is Abstract</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTENDED_GEN_VIEW__IS_ABSTRACT = eINSTANCE.getExtendedGenView_IsAbstract();

		/**
		 * The meta object literal for the '<em><b>Super Gen Views</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENDED_GEN_VIEW__SUPER_GEN_VIEWS = eINSTANCE.getExtendedGenView_SuperGenViews();

		/**
		 * The meta object literal for the '<em><b>Prop Refresh Hook</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENDED_GEN_VIEW__PROP_REFRESH_HOOK = eINSTANCE.getExtendedGenView_PropRefreshHook();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTENDED_GEN_VIEW__NAME = eINSTANCE.getExtendedGenView_Name();

		/**
		 * The meta object literal for the '<em><b>Super Owned Edit Part</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTENDED_GEN_VIEW__SUPER_OWNED_EDIT_PART = eINSTANCE.getExtendedGenView_SuperOwnedEditPart();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.CommentedElementImpl <em>Commented Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.CommentedElementImpl
		 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusgmfgenextensionPackageImpl#getCommentedElement()
		 * @generated
		 */
		EClass COMMENTED_ELEMENT = eINSTANCE.getCommentedElement();

		/**
		 * The meta object literal for the '<em><b>Comment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMMENTED_ELEMENT__COMMENT = eINSTANCE.getCommentedElement_Comment();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.PropertyRefreshHookImpl <em>Property Refresh Hook</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.PropertyRefreshHookImpl
		 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusgmfgenextensionPackageImpl#getPropertyRefreshHook()
		 * @generated
		 */
		EClass PROPERTY_REFRESH_HOOK = eINSTANCE.getPropertyRefreshHook();

		/**
		 * The meta object literal for the '<em><b>Triggering Condition</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_REFRESH_HOOK__TRIGGERING_CONDITION = eINSTANCE.getPropertyRefreshHook_TriggeringCondition();

		/**
		 * The meta object literal for the '<em><b>Action</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_REFRESH_HOOK__ACTION = eINSTANCE.getPropertyRefreshHook_Action();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.ExternalHookImpl <em>External Hook</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.ExternalHookImpl
		 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusgmfgenextensionPackageImpl#getExternalHook()
		 * @generated
		 */
		EClass EXTERNAL_HOOK = eINSTANCE.getExternalHook();

		/**
		 * The meta object literal for the '<em><b>Classpath</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTERNAL_HOOK__CLASSPATH = eINSTANCE.getExternalHook_Classpath();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.SpecificLocatorImpl <em>Specific Locator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.SpecificLocatorImpl
		 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusgmfgenextensionPackageImpl#getSpecificLocator()
		 * @generated
		 */
		EClass SPECIFIC_LOCATOR = eINSTANCE.getSpecificLocator();

		/**
		 * The meta object literal for the '<em><b>Gen Child Side Affixed Node</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIFIC_LOCATOR__GEN_CHILD_SIDE_AFFIXED_NODE = eINSTANCE.getSpecificLocator_GenChildSideAffixedNode();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusExtensionRootNodeImpl <em>Papyrus Extension Root Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusExtensionRootNodeImpl
		 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusgmfgenextensionPackageImpl#getPapyrusExtensionRootNode()
		 * @generated
		 */
		EClass PAPYRUS_EXTENSION_ROOT_NODE = eINSTANCE.getPapyrusExtensionRootNode();

		/**
		 * The meta object literal for the '<em><b>Extension Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAPYRUS_EXTENSION_ROOT_NODE__EXTENSION_NODES = eINSTANCE.getPapyrusExtensionRootNode_ExtensionNodes();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.AlternateCanvasImpl <em>Alternate Canvas</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.AlternateCanvasImpl
		 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusgmfgenextensionPackageImpl#getAlternateCanvas()
		 * @generated
		 */
		EClass ALTERNATE_CANVAS = eINSTANCE.getAlternateCanvas();

		/**
		 * The meta object literal for the '<em><b>Domain Diagram Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ALTERNATE_CANVAS__DOMAIN_DIAGRAM_ELEMENT = eINSTANCE.getAlternateCanvas_DomainDiagramElement();

		/**
		 * The meta object literal for the '<em><b>Alternate Top Level Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ALTERNATE_CANVAS__ALTERNATE_TOP_LEVEL_NODES = eINSTANCE.getAlternateCanvas_AlternateTopLevelNodes();

		/**
		 * The meta object literal for the '<em><b>Alternate Link Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ALTERNATE_CANVAS__ALTERNATE_LINK_NODES = eINSTANCE.getAlternateCanvas_AlternateLinkNodes();

		/**
		 * The meta object literal for the '<em><b>Diagram</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ALTERNATE_CANVAS__DIAGRAM = eINSTANCE.getAlternateCanvas_Diagram();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.AlternateGenTopLevelNodeImpl <em>Alternate Gen Top Level Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.AlternateGenTopLevelNodeImpl
		 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusgmfgenextensionPackageImpl#getAlternateGenTopLevelNode()
		 * @generated
		 */
		EClass ALTERNATE_GEN_TOP_LEVEL_NODE = eINSTANCE.getAlternateGenTopLevelNode();

		/**
		 * The meta object literal for the '<em><b>Gen Top Level Node</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ALTERNATE_GEN_TOP_LEVEL_NODE__GEN_TOP_LEVEL_NODE = eINSTANCE.getAlternateGenTopLevelNode_GenTopLevelNode();

		/**
		 * The meta object literal for the '<em><b>Type Model Facet</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ALTERNATE_GEN_TOP_LEVEL_NODE__TYPE_MODEL_FACET = eINSTANCE.getAlternateGenTopLevelNode_TypeModelFacet();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.AlternateGenLinkImpl <em>Alternate Gen Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.AlternateGenLinkImpl
		 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusgmfgenextensionPackageImpl#getAlternateGenLink()
		 * @generated
		 */
		EClass ALTERNATE_GEN_LINK = eINSTANCE.getAlternateGenLink();

		/**
		 * The meta object literal for the '<em><b>Gen Link Node</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ALTERNATE_GEN_LINK__GEN_LINK_NODE = eINSTANCE.getAlternateGenLink_GenLinkNode();

		/**
		 * The meta object literal for the '<em><b>Type Model Facet</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ALTERNATE_GEN_LINK__TYPE_MODEL_FACET = eINSTANCE.getAlternateGenLink_TypeModelFacet();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.MutatingCanvasImpl <em>Mutating Canvas</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.MutatingCanvasImpl
		 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusgmfgenextensionPackageImpl#getMutatingCanvas()
		 * @generated
		 */
		EClass MUTATING_CANVAS = eINSTANCE.getMutatingCanvas();

		/**
		 * The meta object literal for the '<em><b>Alternate Canvases</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MUTATING_CANVAS__ALTERNATE_CANVASES = eINSTANCE.getMutatingCanvas_AlternateCanvases();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.OwnedEditpartImpl <em>Owned Editpart</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.OwnedEditpartImpl
		 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusgmfgenextensionPackageImpl#getOwnedEditpart()
		 * @generated
		 */
		EClass OWNED_EDITPART = eINSTANCE.getOwnedEditpart();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OWNED_EDITPART__NAME = eINSTANCE.getOwnedEditpart_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.SpecificDiagramUpdaterImpl <em>Specific Diagram Updater</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.SpecificDiagramUpdaterImpl
		 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusgmfgenextensionPackageImpl#getSpecificDiagramUpdater()
		 * @generated
		 */
		EClass SPECIFIC_DIAGRAM_UPDATER = eINSTANCE.getSpecificDiagramUpdater();

		/**
		 * The meta object literal for the '<em><b>Gen Node</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIFIC_DIAGRAM_UPDATER__GEN_NODE = eINSTANCE.getSpecificDiagramUpdater_GenNode();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.GenNodeConstraintImpl <em>Gen Node Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.GenNodeConstraintImpl
		 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusgmfgenextensionPackageImpl#getGenNodeConstraint()
		 * @generated
		 */
		EClass GEN_NODE_CONSTRAINT = eINSTANCE.getGenNodeConstraint();

		/**
		 * The meta object literal for the '<em><b>Gen Node</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_NODE_CONSTRAINT__GEN_NODE = eINSTANCE.getGenNodeConstraint_GenNode();

		/**
		 * The meta object literal for the '<em><b>Gen Constraint</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_NODE_CONSTRAINT__GEN_CONSTRAINT = eINSTANCE.getGenNodeConstraint_GenConstraint();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.SpecificLocatorExternalLabelImpl <em>Specific Locator External Label</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.SpecificLocatorExternalLabelImpl
		 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusgmfgenextensionPackageImpl#getSpecificLocatorExternalLabel()
		 * @generated
		 */
		EClass SPECIFIC_LOCATOR_EXTERNAL_LABEL = eINSTANCE.getSpecificLocatorExternalLabel();

		/**
		 * The meta object literal for the '<em><b>Gen External Node Label</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIFIC_LOCATOR_EXTERNAL_LABEL__GEN_EXTERNAL_NODE_LABEL = eINSTANCE.getSpecificLocatorExternalLabel_GenExternalNodeLabel();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.AdditionalEditPartCandiesImpl <em>Additional Edit Part Candies</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.AdditionalEditPartCandiesImpl
		 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusgmfgenextensionPackageImpl#getAdditionalEditPartCandies()
		 * @generated
		 */
		EClass ADDITIONAL_EDIT_PART_CANDIES = eINSTANCE.getAdditionalEditPartCandies();

		/**
		 * The meta object literal for the '<em><b>Base Edit Helper Package</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADDITIONAL_EDIT_PART_CANDIES__BASE_EDIT_HELPER_PACKAGE = eINSTANCE.getAdditionalEditPartCandies_BaseEditHelperPackage();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.EditPartUsingDeleteServiceImpl <em>Edit Part Using Delete Service</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.EditPartUsingDeleteServiceImpl
		 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusgmfgenextensionPackageImpl#getEditPartUsingDeleteService()
		 * @generated
		 */
		EClass EDIT_PART_USING_DELETE_SERVICE = eINSTANCE.getEditPartUsingDeleteService();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EDIT_PART_USING_DELETE_SERVICE__NAME = eINSTANCE.getEditPartUsingDeleteService_Name();

		/**
		 * The meta object literal for the '<em><b>Gen View</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDIT_PART_USING_DELETE_SERVICE__GEN_VIEW = eINSTANCE.getEditPartUsingDeleteService_GenView();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.EditPartUsingReorientServiceImpl <em>Edit Part Using Reorient Service</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.EditPartUsingReorientServiceImpl
		 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusgmfgenextensionPackageImpl#getEditPartUsingReorientService()
		 * @generated
		 */
		EClass EDIT_PART_USING_REORIENT_SERVICE = eINSTANCE.getEditPartUsingReorientService();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EDIT_PART_USING_REORIENT_SERVICE__NAME = eINSTANCE.getEditPartUsingReorientService_Name();

		/**
		 * The meta object literal for the '<em><b>Gen View</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDIT_PART_USING_REORIENT_SERVICE__GEN_VIEW = eINSTANCE.getEditPartUsingReorientService_GenView();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.LabelVisibilityPreferenceImpl <em>Label Visibility Preference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.LabelVisibilityPreferenceImpl
		 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusgmfgenextensionPackageImpl#getLabelVisibilityPreference()
		 * @generated
		 */
		EClass LABEL_VISIBILITY_PREFERENCE = eINSTANCE.getLabelVisibilityPreference();

		/**
		 * The meta object literal for the '<em><b>Role</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LABEL_VISIBILITY_PREFERENCE__ROLE = eINSTANCE.getLabelVisibilityPreference_Role();

		/**
		 * The meta object literal for the '<em><b>Icon Path Role</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LABEL_VISIBILITY_PREFERENCE__ICON_PATH_ROLE = eINSTANCE.getLabelVisibilityPreference_IconPathRole();

		/**
		 * The meta object literal for the '<em><b>Link Labels</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LABEL_VISIBILITY_PREFERENCE__LINK_LABELS = eINSTANCE.getLabelVisibilityPreference_LinkLabels();

		/**
		 * The meta object literal for the '<em><b>External Node Labels</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LABEL_VISIBILITY_PREFERENCE__EXTERNAL_NODE_LABELS = eINSTANCE.getLabelVisibilityPreference_ExternalNodeLabels();

		/**
		 * The meta object literal for the '<em><b>Visible By Default</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LABEL_VISIBILITY_PREFERENCE__VISIBLE_BY_DEFAULT = eINSTANCE.getLabelVisibilityPreference_VisibleByDefault();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.CompartmentVisibilityPreferenceImpl <em>Compartment Visibility Preference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.CompartmentVisibilityPreferenceImpl
		 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusgmfgenextensionPackageImpl#getCompartmentVisibilityPreference()
		 * @generated
		 */
		EClass COMPARTMENT_VISIBILITY_PREFERENCE = eINSTANCE.getCompartmentVisibilityPreference();

		/**
		 * The meta object literal for the '<em><b>Visible By Default</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPARTMENT_VISIBILITY_PREFERENCE__VISIBLE_BY_DEFAULT = eINSTANCE.getCompartmentVisibilityPreference_VisibleByDefault();

		/**
		 * The meta object literal for the '<em><b>Compartments</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPARTMENT_VISIBILITY_PREFERENCE__COMPARTMENTS = eINSTANCE.getCompartmentVisibilityPreference_Compartments();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.CompartmentTitleVisibilityPreferenceImpl <em>Compartment Title Visibility Preference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.CompartmentTitleVisibilityPreferenceImpl
		 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusgmfgenextensionPackageImpl#getCompartmentTitleVisibilityPreference()
		 * @generated
		 */
		EClass COMPARTMENT_TITLE_VISIBILITY_PREFERENCE = eINSTANCE.getCompartmentTitleVisibilityPreference();

		/**
		 * The meta object literal for the '<em><b>Visible By Default</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPARTMENT_TITLE_VISIBILITY_PREFERENCE__VISIBLE_BY_DEFAULT = eINSTANCE.getCompartmentTitleVisibilityPreference_VisibleByDefault();

		/**
		 * The meta object literal for the '<em><b>Compartments</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPARTMENT_TITLE_VISIBILITY_PREFERENCE__COMPARTMENTS = eINSTANCE.getCompartmentTitleVisibilityPreference_Compartments();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.ConstrainedByReferenceCompartmentItemSemanticEditPolicyImpl <em>Constrained By Reference Compartment Item Semantic Edit Policy</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.ConstrainedByReferenceCompartmentItemSemanticEditPolicyImpl
		 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusgmfgenextensionPackageImpl#getConstrainedByReferenceCompartmentItemSemanticEditPolicy()
		 * @generated
		 */
		EClass CONSTRAINED_BY_REFERENCE_COMPARTMENT_ITEM_SEMANTIC_EDIT_POLICY = eINSTANCE.getConstrainedByReferenceCompartmentItemSemanticEditPolicy();

		/**
		 * The meta object literal for the '<em><b>Gen View</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINED_BY_REFERENCE_COMPARTMENT_ITEM_SEMANTIC_EDIT_POLICY__GEN_VIEW = eINSTANCE.getConstrainedByReferenceCompartmentItemSemanticEditPolicy_GenView();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.ExternalElementTypesLibraryImpl <em>External Element Types Library</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.ExternalElementTypesLibraryImpl
		 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusgmfgenextensionPackageImpl#getExternalElementTypesLibrary()
		 * @generated
		 */
		EClass EXTERNAL_ELEMENT_TYPES_LIBRARY = eINSTANCE.getExternalElementTypesLibrary();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.ExternalMetamodelTypeImpl <em>External Metamodel Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.ExternalMetamodelTypeImpl
		 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusgmfgenextensionPackageImpl#getExternalMetamodelType()
		 * @generated
		 */
		EClass EXTERNAL_METAMODEL_TYPE = eINSTANCE.getExternalMetamodelType();

		/**
		 * The meta object literal for the '<em><b>Element Type Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTERNAL_METAMODEL_TYPE__ELEMENT_TYPE_REF = eINSTANCE.getExternalMetamodelType_ElementTypeRef();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.GenerateUsingElementTypeCreationCommandImpl <em>Generate Using Element Type Creation Command</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.GenerateUsingElementTypeCreationCommandImpl
		 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusgmfgenextensionPackageImpl#getGenerateUsingElementTypeCreationCommand()
		 * @generated
		 */
		EClass GENERATE_USING_ELEMENT_TYPE_CREATION_COMMAND = eINSTANCE.getGenerateUsingElementTypeCreationCommand();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.CustomDiagramUpdaterSingletonImpl <em>Custom Diagram Updater Singleton</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.CustomDiagramUpdaterSingletonImpl
		 * @see org.eclipse.papyrus.papyrusgmfgenextension.impl.PapyrusgmfgenextensionPackageImpl#getCustomDiagramUpdaterSingleton()
		 * @generated
		 */
		EClass CUSTOM_DIAGRAM_UPDATER_SINGLETON = eINSTANCE.getCustomDiagramUpdaterSingleton();

		/**
		 * The meta object literal for the '<em><b>Singleton Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CUSTOM_DIAGRAM_UPDATER_SINGLETON__SINGLETON_PATH = eINSTANCE.getCustomDiagramUpdaterSingleton_SingletonPath();

	}

} //PapyrusgmfgenextensionPackage
