/**
 */
package org.eclipse.papyrus.customization.properties.model.xwt.xwtxml;

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
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.XwtxmlFactory
 * @model kind="package"
 * @generated
 */
public interface XwtxmlPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "xwtxml";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/xwt/XML";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "xwtxml";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	XwtxmlPackage eINSTANCE = org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.impl.XwtxmlPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.impl.NodeImpl <em>Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.impl.NodeImpl
	 * @see org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.impl.XwtxmlPackageImpl#getNode()
	 * @generated
	 */
	int NODE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__PARENT = 1;

	/**
	 * The number of structural features of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.impl.AttributeImpl <em>Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.impl.AttributeImpl
	 * @see org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.impl.XwtxmlPackageImpl#getAttribute()
	 * @generated
	 */
	int ATTRIBUTE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__NAME = NODE__NAME;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__PARENT = NODE__PARENT;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__VALUE = NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_FEATURE_COUNT = NODE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_OPERATION_COUNT = NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.impl.TextImpl <em>Text</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.impl.TextImpl
	 * @see org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.impl.XwtxmlPackageImpl#getText()
	 * @generated
	 */
	int TEXT = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT__NAME = NODE__NAME;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT__PARENT = NODE__PARENT;

	/**
	 * The number of structural features of the '<em>Text</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_FEATURE_COUNT = NODE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Text</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_OPERATION_COUNT = NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.impl.ElementImpl <em>Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.impl.ElementImpl
	 * @see org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.impl.XwtxmlPackageImpl#getElement()
	 * @generated
	 */
	int ELEMENT = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__NAME = NODE__NAME;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__PARENT = NODE__PARENT;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__CHILDREN = NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_FEATURE_COUNT = NODE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_OPERATION_COUNT = NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.impl.RootImpl <em>Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.impl.RootImpl
	 * @see org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.impl.XwtxmlPackageImpl#getRoot()
	 * @generated
	 */
	int ROOT = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__NAME = ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__PARENT = ELEMENT__PARENT;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__CHILDREN = ELEMENT__CHILDREN;

	/**
	 * The feature id for the '<em><b>Namespaces</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__NAMESPACES = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Dtd</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__DTD = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Leading PIs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__LEADING_PIS = ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_OPERATION_COUNT = ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.impl.NamespaceImpl <em>Namespace</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.impl.NamespaceImpl
	 * @see org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.impl.XwtxmlPackageImpl#getNamespace()
	 * @generated
	 */
	int NAMESPACE = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMESPACE__NAME = ATTRIBUTE__NAME;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMESPACE__PARENT = ATTRIBUTE__PARENT;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMESPACE__VALUE = ATTRIBUTE__VALUE;

	/**
	 * The number of structural features of the '<em>Namespace</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMESPACE_FEATURE_COUNT = ATTRIBUTE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Namespace</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMESPACE_OPERATION_COUNT = ATTRIBUTE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.impl.CommentImpl <em>Comment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.impl.CommentImpl
	 * @see org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.impl.XwtxmlPackageImpl#getComment()
	 * @generated
	 */
	int COMMENT = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT__NAME = NODE__NAME;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT__PARENT = NODE__PARENT;

	/**
	 * The number of structural features of the '<em>Comment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT_FEATURE_COUNT = NODE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Comment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT_OPERATION_COUNT = NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.impl.DocumentTypeDeclarationImpl <em>Document Type Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.impl.DocumentTypeDeclarationImpl
	 * @see org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.impl.XwtxmlPackageImpl#getDocumentTypeDeclaration()
	 * @generated
	 */
	int DOCUMENT_TYPE_DECLARATION = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_TYPE_DECLARATION__NAME = NODE__NAME;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_TYPE_DECLARATION__PARENT = NODE__PARENT;

	/**
	 * The feature id for the '<em><b>Public ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_TYPE_DECLARATION__PUBLIC_ID = NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>System ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_TYPE_DECLARATION__SYSTEM_ID = NODE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Document Type Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_TYPE_DECLARATION_FEATURE_COUNT = NODE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Document Type Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_TYPE_DECLARATION_OPERATION_COUNT = NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.impl.CDATAImpl <em>CDATA</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.impl.CDATAImpl
	 * @see org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.impl.XwtxmlPackageImpl#getCDATA()
	 * @generated
	 */
	int CDATA = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CDATA__NAME = TEXT__NAME;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CDATA__PARENT = TEXT__PARENT;

	/**
	 * The number of structural features of the '<em>CDATA</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CDATA_FEATURE_COUNT = TEXT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>CDATA</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CDATA_OPERATION_COUNT = TEXT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.impl.ProcessingInstructionImpl <em>Processing Instruction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.impl.ProcessingInstructionImpl
	 * @see org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.impl.XwtxmlPackageImpl#getProcessingInstruction()
	 * @generated
	 */
	int PROCESSING_INSTRUCTION = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSING_INSTRUCTION__NAME = NODE__NAME;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSING_INSTRUCTION__PARENT = NODE__PARENT;

	/**
	 * The feature id for the '<em><b>Data</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSING_INSTRUCTION__DATA = NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Processing Instruction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSING_INSTRUCTION_FEATURE_COUNT = NODE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Processing Instruction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSING_INSTRUCTION_OPERATION_COUNT = NODE_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.Node <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node</em>'.
	 * @see org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.Node
	 * @generated
	 */
	EClass getNode();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.Node#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.Node#getName()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_Name();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.Node#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent</em>'.
	 * @see org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.Node#getParent()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_Parent();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.Attribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute</em>'.
	 * @see org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.Attribute
	 * @generated
	 */
	EClass getAttribute();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.Attribute#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.Attribute#getValue()
	 * @see #getAttribute()
	 * @generated
	 */
	EAttribute getAttribute_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.Text <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Text</em>'.
	 * @see org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.Text
	 * @generated
	 */
	EClass getText();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.Element <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element</em>'.
	 * @see org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.Element
	 * @generated
	 */
	EClass getElement();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.Element#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Children</em>'.
	 * @see org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.Element#getChildren()
	 * @see #getElement()
	 * @generated
	 */
	EReference getElement_Children();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.Root <em>Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Root</em>'.
	 * @see org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.Root
	 * @generated
	 */
	EClass getRoot();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.Root#getNamespaces <em>Namespaces</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Namespaces</em>'.
	 * @see org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.Root#getNamespaces()
	 * @see #getRoot()
	 * @generated
	 */
	EReference getRoot_Namespaces();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.Root#getDtd <em>Dtd</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Dtd</em>'.
	 * @see org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.Root#getDtd()
	 * @see #getRoot()
	 * @generated
	 */
	EReference getRoot_Dtd();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.Root#getLeadingPIs <em>Leading PIs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Leading PIs</em>'.
	 * @see org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.Root#getLeadingPIs()
	 * @see #getRoot()
	 * @generated
	 */
	EReference getRoot_LeadingPIs();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.Namespace <em>Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Namespace</em>'.
	 * @see org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.Namespace
	 * @generated
	 */
	EClass getNamespace();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.Comment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Comment</em>'.
	 * @see org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.Comment
	 * @generated
	 */
	EClass getComment();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.DocumentTypeDeclaration <em>Document Type Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Document Type Declaration</em>'.
	 * @see org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.DocumentTypeDeclaration
	 * @generated
	 */
	EClass getDocumentTypeDeclaration();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.DocumentTypeDeclaration#getPublicID <em>Public ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Public ID</em>'.
	 * @see org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.DocumentTypeDeclaration#getPublicID()
	 * @see #getDocumentTypeDeclaration()
	 * @generated
	 */
	EAttribute getDocumentTypeDeclaration_PublicID();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.DocumentTypeDeclaration#getSystemID <em>System ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>System ID</em>'.
	 * @see org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.DocumentTypeDeclaration#getSystemID()
	 * @see #getDocumentTypeDeclaration()
	 * @generated
	 */
	EAttribute getDocumentTypeDeclaration_SystemID();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.CDATA <em>CDATA</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CDATA</em>'.
	 * @see org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.CDATA
	 * @generated
	 */
	EClass getCDATA();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.ProcessingInstruction <em>Processing Instruction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Processing Instruction</em>'.
	 * @see org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.ProcessingInstruction
	 * @generated
	 */
	EClass getProcessingInstruction();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.ProcessingInstruction#getData <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Data</em>'.
	 * @see org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.ProcessingInstruction#getData()
	 * @see #getProcessingInstruction()
	 * @generated
	 */
	EAttribute getProcessingInstruction_Data();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	XwtxmlFactory getXwtxmlFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.impl.NodeImpl <em>Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.impl.NodeImpl
		 * @see org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.impl.XwtxmlPackageImpl#getNode()
		 * @generated
		 */
		EClass NODE = eINSTANCE.getNode();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__NAME = eINSTANCE.getNode_Name();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__PARENT = eINSTANCE.getNode_Parent();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.impl.AttributeImpl <em>Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.impl.AttributeImpl
		 * @see org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.impl.XwtxmlPackageImpl#getAttribute()
		 * @generated
		 */
		EClass ATTRIBUTE = eINSTANCE.getAttribute();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE__VALUE = eINSTANCE.getAttribute_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.impl.TextImpl <em>Text</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.impl.TextImpl
		 * @see org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.impl.XwtxmlPackageImpl#getText()
		 * @generated
		 */
		EClass TEXT = eINSTANCE.getText();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.impl.ElementImpl <em>Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.impl.ElementImpl
		 * @see org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.impl.XwtxmlPackageImpl#getElement()
		 * @generated
		 */
		EClass ELEMENT = eINSTANCE.getElement();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT__CHILDREN = eINSTANCE.getElement_Children();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.impl.RootImpl <em>Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.impl.RootImpl
		 * @see org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.impl.XwtxmlPackageImpl#getRoot()
		 * @generated
		 */
		EClass ROOT = eINSTANCE.getRoot();

		/**
		 * The meta object literal for the '<em><b>Namespaces</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOT__NAMESPACES = eINSTANCE.getRoot_Namespaces();

		/**
		 * The meta object literal for the '<em><b>Dtd</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOT__DTD = eINSTANCE.getRoot_Dtd();

		/**
		 * The meta object literal for the '<em><b>Leading PIs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOT__LEADING_PIS = eINSTANCE.getRoot_LeadingPIs();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.impl.NamespaceImpl <em>Namespace</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.impl.NamespaceImpl
		 * @see org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.impl.XwtxmlPackageImpl#getNamespace()
		 * @generated
		 */
		EClass NAMESPACE = eINSTANCE.getNamespace();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.impl.CommentImpl <em>Comment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.impl.CommentImpl
		 * @see org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.impl.XwtxmlPackageImpl#getComment()
		 * @generated
		 */
		EClass COMMENT = eINSTANCE.getComment();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.impl.DocumentTypeDeclarationImpl <em>Document Type Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.impl.DocumentTypeDeclarationImpl
		 * @see org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.impl.XwtxmlPackageImpl#getDocumentTypeDeclaration()
		 * @generated
		 */
		EClass DOCUMENT_TYPE_DECLARATION = eINSTANCE.getDocumentTypeDeclaration();

		/**
		 * The meta object literal for the '<em><b>Public ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_TYPE_DECLARATION__PUBLIC_ID = eINSTANCE.getDocumentTypeDeclaration_PublicID();

		/**
		 * The meta object literal for the '<em><b>System ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_TYPE_DECLARATION__SYSTEM_ID = eINSTANCE.getDocumentTypeDeclaration_SystemID();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.impl.CDATAImpl <em>CDATA</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.impl.CDATAImpl
		 * @see org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.impl.XwtxmlPackageImpl#getCDATA()
		 * @generated
		 */
		EClass CDATA = eINSTANCE.getCDATA();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.impl.ProcessingInstructionImpl <em>Processing Instruction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.impl.ProcessingInstructionImpl
		 * @see org.eclipse.papyrus.customization.properties.model.xwt.xwtxml.impl.XwtxmlPackageImpl#getProcessingInstruction()
		 * @generated
		 */
		EClass PROCESSING_INSTRUCTION = eINSTANCE.getProcessingInstruction();

		/**
		 * The meta object literal for the '<em><b>Data</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCESSING_INSTRUCTION__DATA = eINSTANCE.getProcessingInstruction_Data();

	}

} //XwtxmlPackage
