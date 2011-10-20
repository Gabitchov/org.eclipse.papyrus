/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.design.profile.architecture;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.design.profile.architecture.ArchitectureFactory
 * @model kind="package"
 * @generated
 */
public interface ArchitecturePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "architecture";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/design/architecture/1";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "architecture";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ArchitecturePackage eINSTANCE = org.eclipse.papyrus.design.profile.architecture.impl.ArchitecturePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.design.profile.architecture.impl.ElementImpl <em>Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.design.profile.architecture.impl.ElementImpl
	 * @see org.eclipse.papyrus.design.profile.architecture.impl.ArchitecturePackageImpl#getElement()
	 * @generated
	 */
	int ELEMENT = 1;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__DOCUMENTATION = 0;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__COMMENT = 1;

	/**
	 * The number of structural features of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.design.profile.architecture.impl.LayerImpl <em>Layer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.design.profile.architecture.impl.LayerImpl
	 * @see org.eclipse.papyrus.design.profile.architecture.impl.ArchitecturePackageImpl#getLayer()
	 * @generated
	 */
	int LAYER = 0;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER__DOCUMENTATION = ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER__COMMENT = ELEMENT__COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER__NAME = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent Folder</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER__PARENT_FOLDER = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER__BASE_PACKAGE = ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Is Deprecated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER__IS_DEPRECATED = ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Deprecated Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER__DEPRECATED_COMMENT = ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Referent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER__REFERENT = ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Layer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 6;


	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.design.profile.architecture.impl.LayerDependencyImpl <em>Layer Dependency</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.design.profile.architecture.impl.LayerDependencyImpl
	 * @see org.eclipse.papyrus.design.profile.architecture.impl.ArchitecturePackageImpl#getLayerDependency()
	 * @generated
	 */
	int LAYER_DEPENDENCY = 2;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_DEPENDENCY__DOCUMENTATION = ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_DEPENDENCY__COMMENT = ELEMENT__COMMENT;

	/**
	 * The feature id for the '<em><b>Is Deprecated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_DEPENDENCY__IS_DEPRECATED = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Deprecated Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_DEPENDENCY__DEPRECATED_COMMENT = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Base Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_DEPENDENCY__BASE_DEPENDENCY = ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Layer Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYER_DEPENDENCY_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 3;


	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.design.profile.architecture.impl.ProjectImpl <em>Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.design.profile.architecture.impl.ProjectImpl
	 * @see org.eclipse.papyrus.design.profile.architecture.impl.ArchitecturePackageImpl#getProject()
	 * @generated
	 */
	int PROJECT = 4;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__DOCUMENTATION = ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__COMMENT = ELEMENT__COMMENT;

	/**
	 * The feature id for the '<em><b>Is Deprecated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__IS_DEPRECATED = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Deprecated Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__DEPRECATED_COMMENT = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__NAME = ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Referent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__REFERENT = ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Parent Folder</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__PARENT_FOLDER = ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Original Parent Folder</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__ORIGINAL_PARENT_FOLDER = ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__BASE_PACKAGE = ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.design.profile.architecture.impl.PluginImpl <em>Plugin</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.design.profile.architecture.impl.PluginImpl
	 * @see org.eclipse.papyrus.design.profile.architecture.impl.ArchitecturePackageImpl#getPlugin()
	 * @generated
	 */
	int PLUGIN = 3;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUGIN__DOCUMENTATION = PROJECT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUGIN__COMMENT = PROJECT__COMMENT;

	/**
	 * The feature id for the '<em><b>Is Deprecated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUGIN__IS_DEPRECATED = PROJECT__IS_DEPRECATED;

	/**
	 * The feature id for the '<em><b>Deprecated Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUGIN__DEPRECATED_COMMENT = PROJECT__DEPRECATED_COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUGIN__NAME = PROJECT__NAME;

	/**
	 * The feature id for the '<em><b>Referent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUGIN__REFERENT = PROJECT__REFERENT;

	/**
	 * The feature id for the '<em><b>Parent Folder</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUGIN__PARENT_FOLDER = PROJECT__PARENT_FOLDER;

	/**
	 * The feature id for the '<em><b>Original Parent Folder</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUGIN__ORIGINAL_PARENT_FOLDER = PROJECT__ORIGINAL_PARENT_FOLDER;

	/**
	 * The feature id for the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUGIN__BASE_PACKAGE = PROJECT__BASE_PACKAGE;

	/**
	 * The number of structural features of the '<em>Plugin</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUGIN_FEATURE_COUNT = PROJECT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.design.profile.architecture.impl.ProjectDependencyImpl <em>Project Dependency</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.design.profile.architecture.impl.ProjectDependencyImpl
	 * @see org.eclipse.papyrus.design.profile.architecture.impl.ArchitecturePackageImpl#getProjectDependency()
	 * @generated
	 */
	int PROJECT_DEPENDENCY = 5;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_DEPENDENCY__DOCUMENTATION = ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_DEPENDENCY__COMMENT = ELEMENT__COMMENT;

	/**
	 * The feature id for the '<em><b>Deprecated Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_DEPENDENCY__DEPRECATED_COMMENT = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Deprecated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_DEPENDENCY__IS_DEPRECATED = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Base Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_DEPENDENCY__BASE_DEPENDENCY = ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Project Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_DEPENDENCY_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 3;

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.design.profile.architecture.Layer <em>Layer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Layer</em>'.
	 * @see org.eclipse.papyrus.design.profile.architecture.Layer
	 * @generated
	 */
	EClass getLayer();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.design.profile.architecture.Layer#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.design.profile.architecture.Layer#getName()
	 * @see #getLayer()
	 * @generated
	 */
	EAttribute getLayer_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.design.profile.architecture.Layer#getParentFolder <em>Parent Folder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Parent Folder</em>'.
	 * @see org.eclipse.papyrus.design.profile.architecture.Layer#getParentFolder()
	 * @see #getLayer()
	 * @generated
	 */
	EAttribute getLayer_ParentFolder();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.design.profile.architecture.Layer#getBase_Package <em>Base Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Package</em>'.
	 * @see org.eclipse.papyrus.design.profile.architecture.Layer#getBase_Package()
	 * @see #getLayer()
	 * @generated
	 */
	EReference getLayer_Base_Package();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.design.profile.architecture.Layer#isDeprecated <em>Is Deprecated</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Deprecated</em>'.
	 * @see org.eclipse.papyrus.design.profile.architecture.Layer#isDeprecated()
	 * @see #getLayer()
	 * @generated
	 */
	EAttribute getLayer_IsDeprecated();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.design.profile.architecture.Layer#getDeprecatedComment <em>Deprecated Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Deprecated Comment</em>'.
	 * @see org.eclipse.papyrus.design.profile.architecture.Layer#getDeprecatedComment()
	 * @see #getLayer()
	 * @generated
	 */
	EAttribute getLayer_DeprecatedComment();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.design.profile.architecture.Layer#getReferent <em>Referent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Referent</em>'.
	 * @see org.eclipse.papyrus.design.profile.architecture.Layer#getReferent()
	 * @see #getLayer()
	 * @generated
	 */
	EAttribute getLayer_Referent();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.design.profile.architecture.Element <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element</em>'.
	 * @see org.eclipse.papyrus.design.profile.architecture.Element
	 * @generated
	 */
	EClass getElement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.design.profile.architecture.Element#getDocumentation <em>Documentation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Documentation</em>'.
	 * @see org.eclipse.papyrus.design.profile.architecture.Element#getDocumentation()
	 * @see #getElement()
	 * @generated
	 */
	EAttribute getElement_Documentation();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.design.profile.architecture.Element#getComment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comment</em>'.
	 * @see org.eclipse.papyrus.design.profile.architecture.Element#getComment()
	 * @see #getElement()
	 * @generated
	 */
	EAttribute getElement_Comment();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.design.profile.architecture.LayerDependency <em>Layer Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Layer Dependency</em>'.
	 * @see org.eclipse.papyrus.design.profile.architecture.LayerDependency
	 * @generated
	 */
	EClass getLayerDependency();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.design.profile.architecture.LayerDependency#isDeprecated <em>Is Deprecated</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Deprecated</em>'.
	 * @see org.eclipse.papyrus.design.profile.architecture.LayerDependency#isDeprecated()
	 * @see #getLayerDependency()
	 * @generated
	 */
	EAttribute getLayerDependency_IsDeprecated();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.design.profile.architecture.LayerDependency#getDeprecatedComment <em>Deprecated Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Deprecated Comment</em>'.
	 * @see org.eclipse.papyrus.design.profile.architecture.LayerDependency#getDeprecatedComment()
	 * @see #getLayerDependency()
	 * @generated
	 */
	EAttribute getLayerDependency_DeprecatedComment();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.design.profile.architecture.LayerDependency#getBase_Dependency <em>Base Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Dependency</em>'.
	 * @see org.eclipse.papyrus.design.profile.architecture.LayerDependency#getBase_Dependency()
	 * @see #getLayerDependency()
	 * @generated
	 */
	EReference getLayerDependency_Base_Dependency();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.design.profile.architecture.Plugin <em>Plugin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Plugin</em>'.
	 * @see org.eclipse.papyrus.design.profile.architecture.Plugin
	 * @generated
	 */
	EClass getPlugin();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.design.profile.architecture.Project <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Project</em>'.
	 * @see org.eclipse.papyrus.design.profile.architecture.Project
	 * @generated
	 */
	EClass getProject();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.design.profile.architecture.Project#isDeprecated <em>Is Deprecated</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Deprecated</em>'.
	 * @see org.eclipse.papyrus.design.profile.architecture.Project#isDeprecated()
	 * @see #getProject()
	 * @generated
	 */
	EAttribute getProject_IsDeprecated();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.design.profile.architecture.Project#getDeprecatedComment <em>Deprecated Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Deprecated Comment</em>'.
	 * @see org.eclipse.papyrus.design.profile.architecture.Project#getDeprecatedComment()
	 * @see #getProject()
	 * @generated
	 */
	EAttribute getProject_DeprecatedComment();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.design.profile.architecture.Project#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.design.profile.architecture.Project#getName()
	 * @see #getProject()
	 * @generated
	 */
	EAttribute getProject_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.design.profile.architecture.Project#getReferent <em>Referent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Referent</em>'.
	 * @see org.eclipse.papyrus.design.profile.architecture.Project#getReferent()
	 * @see #getProject()
	 * @generated
	 */
	EAttribute getProject_Referent();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.design.profile.architecture.Project#getParentFolder <em>Parent Folder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Parent Folder</em>'.
	 * @see org.eclipse.papyrus.design.profile.architecture.Project#getParentFolder()
	 * @see #getProject()
	 * @generated
	 */
	EAttribute getProject_ParentFolder();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.design.profile.architecture.Project#getOriginalParentFolder <em>Original Parent Folder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Original Parent Folder</em>'.
	 * @see org.eclipse.papyrus.design.profile.architecture.Project#getOriginalParentFolder()
	 * @see #getProject()
	 * @generated
	 */
	EAttribute getProject_OriginalParentFolder();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.design.profile.architecture.Project#getBase_Package <em>Base Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Package</em>'.
	 * @see org.eclipse.papyrus.design.profile.architecture.Project#getBase_Package()
	 * @see #getProject()
	 * @generated
	 */
	EReference getProject_Base_Package();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.design.profile.architecture.ProjectDependency <em>Project Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Project Dependency</em>'.
	 * @see org.eclipse.papyrus.design.profile.architecture.ProjectDependency
	 * @generated
	 */
	EClass getProjectDependency();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.design.profile.architecture.ProjectDependency#getDeprecatedComment <em>Deprecated Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Deprecated Comment</em>'.
	 * @see org.eclipse.papyrus.design.profile.architecture.ProjectDependency#getDeprecatedComment()
	 * @see #getProjectDependency()
	 * @generated
	 */
	EAttribute getProjectDependency_DeprecatedComment();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.design.profile.architecture.ProjectDependency#isDeprecated <em>Is Deprecated</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Deprecated</em>'.
	 * @see org.eclipse.papyrus.design.profile.architecture.ProjectDependency#isDeprecated()
	 * @see #getProjectDependency()
	 * @generated
	 */
	EAttribute getProjectDependency_IsDeprecated();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.design.profile.architecture.ProjectDependency#getBase_Dependency <em>Base Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Dependency</em>'.
	 * @see org.eclipse.papyrus.design.profile.architecture.ProjectDependency#getBase_Dependency()
	 * @see #getProjectDependency()
	 * @generated
	 */
	EReference getProjectDependency_Base_Dependency();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ArchitectureFactory getArchitectureFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.design.profile.architecture.impl.LayerImpl <em>Layer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.design.profile.architecture.impl.LayerImpl
		 * @see org.eclipse.papyrus.design.profile.architecture.impl.ArchitecturePackageImpl#getLayer()
		 * @generated
		 */
		EClass LAYER = eINSTANCE.getLayer();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LAYER__NAME = eINSTANCE.getLayer_Name();

		/**
		 * The meta object literal for the '<em><b>Parent Folder</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LAYER__PARENT_FOLDER = eINSTANCE.getLayer_ParentFolder();

		/**
		 * The meta object literal for the '<em><b>Base Package</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LAYER__BASE_PACKAGE = eINSTANCE.getLayer_Base_Package();

		/**
		 * The meta object literal for the '<em><b>Is Deprecated</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LAYER__IS_DEPRECATED = eINSTANCE.getLayer_IsDeprecated();

		/**
		 * The meta object literal for the '<em><b>Deprecated Comment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LAYER__DEPRECATED_COMMENT = eINSTANCE.getLayer_DeprecatedComment();

		/**
		 * The meta object literal for the '<em><b>Referent</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LAYER__REFERENT = eINSTANCE.getLayer_Referent();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.design.profile.architecture.impl.ElementImpl <em>Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.design.profile.architecture.impl.ElementImpl
		 * @see org.eclipse.papyrus.design.profile.architecture.impl.ArchitecturePackageImpl#getElement()
		 * @generated
		 */
		EClass ELEMENT = eINSTANCE.getElement();

		/**
		 * The meta object literal for the '<em><b>Documentation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELEMENT__DOCUMENTATION = eINSTANCE.getElement_Documentation();

		/**
		 * The meta object literal for the '<em><b>Comment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELEMENT__COMMENT = eINSTANCE.getElement_Comment();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.design.profile.architecture.impl.LayerDependencyImpl <em>Layer Dependency</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.design.profile.architecture.impl.LayerDependencyImpl
		 * @see org.eclipse.papyrus.design.profile.architecture.impl.ArchitecturePackageImpl#getLayerDependency()
		 * @generated
		 */
		EClass LAYER_DEPENDENCY = eINSTANCE.getLayerDependency();

		/**
		 * The meta object literal for the '<em><b>Is Deprecated</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LAYER_DEPENDENCY__IS_DEPRECATED = eINSTANCE.getLayerDependency_IsDeprecated();

		/**
		 * The meta object literal for the '<em><b>Deprecated Comment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LAYER_DEPENDENCY__DEPRECATED_COMMENT = eINSTANCE.getLayerDependency_DeprecatedComment();

		/**
		 * The meta object literal for the '<em><b>Base Dependency</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LAYER_DEPENDENCY__BASE_DEPENDENCY = eINSTANCE.getLayerDependency_Base_Dependency();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.design.profile.architecture.impl.PluginImpl <em>Plugin</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.design.profile.architecture.impl.PluginImpl
		 * @see org.eclipse.papyrus.design.profile.architecture.impl.ArchitecturePackageImpl#getPlugin()
		 * @generated
		 */
		EClass PLUGIN = eINSTANCE.getPlugin();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.design.profile.architecture.impl.ProjectImpl <em>Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.design.profile.architecture.impl.ProjectImpl
		 * @see org.eclipse.papyrus.design.profile.architecture.impl.ArchitecturePackageImpl#getProject()
		 * @generated
		 */
		EClass PROJECT = eINSTANCE.getProject();

		/**
		 * The meta object literal for the '<em><b>Is Deprecated</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT__IS_DEPRECATED = eINSTANCE.getProject_IsDeprecated();

		/**
		 * The meta object literal for the '<em><b>Deprecated Comment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT__DEPRECATED_COMMENT = eINSTANCE.getProject_DeprecatedComment();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT__NAME = eINSTANCE.getProject_Name();

		/**
		 * The meta object literal for the '<em><b>Referent</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT__REFERENT = eINSTANCE.getProject_Referent();

		/**
		 * The meta object literal for the '<em><b>Parent Folder</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT__PARENT_FOLDER = eINSTANCE.getProject_ParentFolder();

		/**
		 * The meta object literal for the '<em><b>Original Parent Folder</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT__ORIGINAL_PARENT_FOLDER = eINSTANCE.getProject_OriginalParentFolder();

		/**
		 * The meta object literal for the '<em><b>Base Package</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROJECT__BASE_PACKAGE = eINSTANCE.getProject_Base_Package();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.design.profile.architecture.impl.ProjectDependencyImpl <em>Project Dependency</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.design.profile.architecture.impl.ProjectDependencyImpl
		 * @see org.eclipse.papyrus.design.profile.architecture.impl.ArchitecturePackageImpl#getProjectDependency()
		 * @generated
		 */
		EClass PROJECT_DEPENDENCY = eINSTANCE.getProjectDependency();

		/**
		 * The meta object literal for the '<em><b>Deprecated Comment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT_DEPENDENCY__DEPRECATED_COMMENT = eINSTANCE.getProjectDependency_DeprecatedComment();

		/**
		 * The meta object literal for the '<em><b>Is Deprecated</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT_DEPENDENCY__IS_DEPRECATED = eINSTANCE.getProjectDependency_IsDeprecated();

		/**
		 * The meta object literal for the '<em><b>Base Dependency</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROJECT_DEPENDENCY__BASE_DEPENDENCY = eINSTANCE.getProjectDependency_Base_Dependency();

	}

} //ArchitecturePackage
