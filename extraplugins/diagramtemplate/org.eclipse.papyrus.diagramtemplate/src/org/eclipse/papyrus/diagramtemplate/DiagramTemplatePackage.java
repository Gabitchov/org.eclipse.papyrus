/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.diagramtemplate;

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
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.diagramtemplate.DiagramTemplateFactory
 * @model kind="package"
 * @generated
 */
public interface DiagramTemplatePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "diagramtemplate";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/diagramtemplate";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "diagramtemplate";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DiagramTemplatePackage eINSTANCE = org.eclipse.papyrus.diagramtemplate.impl.DiagramTemplatePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.diagramtemplate.impl.DiagramDefinitionImpl <em>Diagram Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.diagramtemplate.impl.DiagramDefinitionImpl
	 * @see org.eclipse.papyrus.diagramtemplate.impl.DiagramTemplatePackageImpl#getDiagramDefinition()
	 * @generated
	 */
	int DIAGRAM_DEFINITION = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_DEFINITION__DESCRIPTION = 0;

	/**
	 * The feature id for the '<em><b>From Root</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_DEFINITION__FROM_ROOT = 1;

	/**
	 * The feature id for the '<em><b>Selection</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_DEFINITION__SELECTION = 2;

	/**
	 * The feature id for the '<em><b>Diagram Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_DEFINITION__DIAGRAM_KIND = 3;

	/**
	 * The feature id for the '<em><b>Layout To Apply</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_DEFINITION__LAYOUT_TO_APPLY = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_DEFINITION__NAME = 5;

	/**
	 * The feature id for the '<em><b>Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_DEFINITION__PREFIX = 6;

	/**
	 * The number of structural features of the '<em>Diagram Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_DEFINITION_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.diagramtemplate.impl.AbstractSelectionImpl <em>Abstract Selection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.diagramtemplate.impl.AbstractSelectionImpl
	 * @see org.eclipse.papyrus.diagramtemplate.impl.DiagramTemplatePackageImpl#getAbstractSelection()
	 * @generated
	 */
	int ABSTRACT_SELECTION = 4;

	/**
	 * The feature id for the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_SELECTION__ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_SELECTION__KIND = 1;

	/**
	 * The feature id for the '<em><b>Selection Ref</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_SELECTION__SELECTION_REF = 2;

	/**
	 * The feature id for the '<em><b>Sub Types</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_SELECTION__SUB_TYPES = 3;

	/**
	 * The feature id for the '<em><b>Stereotyped By</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_SELECTION__STEREOTYPED_BY = 4;

	/**
	 * The number of structural features of the '<em>Abstract Selection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_SELECTION_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.diagramtemplate.impl.SelectionImpl <em>Selection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.diagramtemplate.impl.SelectionImpl
	 * @see org.eclipse.papyrus.diagramtemplate.impl.DiagramTemplatePackageImpl#getSelection()
	 * @generated
	 */
	int SELECTION = 1;

	/**
	 * The feature id for the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTION__ELEMENT = ABSTRACT_SELECTION__ELEMENT;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTION__KIND = ABSTRACT_SELECTION__KIND;

	/**
	 * The feature id for the '<em><b>Selection Ref</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTION__SELECTION_REF = ABSTRACT_SELECTION__SELECTION_REF;

	/**
	 * The feature id for the '<em><b>Sub Types</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTION__SUB_TYPES = ABSTRACT_SELECTION__SUB_TYPES;

	/**
	 * The feature id for the '<em><b>Stereotyped By</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTION__STEREOTYPED_BY = ABSTRACT_SELECTION__STEREOTYPED_BY;

	/**
	 * The feature id for the '<em><b>Recursively</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTION__RECURSIVELY = ABSTRACT_SELECTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Selection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTION_FEATURE_COUNT = ABSTRACT_SELECTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.diagramtemplate.impl.SelectionRefImpl <em>Selection Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.diagramtemplate.impl.SelectionRefImpl
	 * @see org.eclipse.papyrus.diagramtemplate.impl.DiagramTemplatePackageImpl#getSelectionRef()
	 * @generated
	 */
	int SELECTION_REF = 2;

	/**
	 * The feature id for the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTION_REF__ELEMENT = ABSTRACT_SELECTION__ELEMENT;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTION_REF__KIND = ABSTRACT_SELECTION__KIND;

	/**
	 * The feature id for the '<em><b>Selection Ref</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTION_REF__SELECTION_REF = ABSTRACT_SELECTION__SELECTION_REF;

	/**
	 * The feature id for the '<em><b>Sub Types</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTION_REF__SUB_TYPES = ABSTRACT_SELECTION__SUB_TYPES;

	/**
	 * The feature id for the '<em><b>Stereotyped By</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTION_REF__STEREOTYPED_BY = ABSTRACT_SELECTION__STEREOTYPED_BY;

	/**
	 * The feature id for the '<em><b>EReference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTION_REF__EREFERENCE = ABSTRACT_SELECTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Selection Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTION_REF_FEATURE_COUNT = ABSTRACT_SELECTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.diagramtemplate.impl.TemplateImpl <em>Template</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.diagramtemplate.impl.TemplateImpl
	 * @see org.eclipse.papyrus.diagramtemplate.impl.DiagramTemplatePackageImpl#getTemplate()
	 * @generated
	 */
	int TEMPLATE = 3;

	/**
	 * The feature id for the '<em><b>Diagram Definitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE__DIAGRAM_DEFINITIONS = 0;

	/**
	 * The feature id for the '<em><b>Target Root</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE__TARGET_ROOT = 1;

	/**
	 * The number of structural features of the '<em>Template</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.diagramtemplate.SelectionKind <em>Selection Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.diagramtemplate.SelectionKind
	 * @see org.eclipse.papyrus.diagramtemplate.impl.DiagramTemplatePackageImpl#getSelectionKind()
	 * @generated
	 */
	int SELECTION_KIND = 5;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.diagramtemplate.DiagramDefinition <em>Diagram Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Diagram Definition</em>'.
	 * @see org.eclipse.papyrus.diagramtemplate.DiagramDefinition
	 * @generated
	 */
	EClass getDiagramDefinition();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.diagramtemplate.DiagramDefinition#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.eclipse.papyrus.diagramtemplate.DiagramDefinition#getDescription()
	 * @see #getDiagramDefinition()
	 * @generated
	 */
	EAttribute getDiagramDefinition_Description();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.diagramtemplate.DiagramDefinition#getFromRoot <em>From Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>From Root</em>'.
	 * @see org.eclipse.papyrus.diagramtemplate.DiagramDefinition#getFromRoot()
	 * @see #getDiagramDefinition()
	 * @generated
	 */
	EReference getDiagramDefinition_FromRoot();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.diagramtemplate.DiagramDefinition#getSelection <em>Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Selection</em>'.
	 * @see org.eclipse.papyrus.diagramtemplate.DiagramDefinition#getSelection()
	 * @see #getDiagramDefinition()
	 * @generated
	 */
	EReference getDiagramDefinition_Selection();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.diagramtemplate.DiagramDefinition#getDiagramKind <em>Diagram Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Diagram Kind</em>'.
	 * @see org.eclipse.papyrus.diagramtemplate.DiagramDefinition#getDiagramKind()
	 * @see #getDiagramDefinition()
	 * @generated
	 */
	EAttribute getDiagramDefinition_DiagramKind();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.diagramtemplate.DiagramDefinition#getLayoutToApply <em>Layout To Apply</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Layout To Apply</em>'.
	 * @see org.eclipse.papyrus.diagramtemplate.DiagramDefinition#getLayoutToApply()
	 * @see #getDiagramDefinition()
	 * @generated
	 */
	EAttribute getDiagramDefinition_LayoutToApply();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.diagramtemplate.DiagramDefinition#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.diagramtemplate.DiagramDefinition#getName()
	 * @see #getDiagramDefinition()
	 * @generated
	 */
	EAttribute getDiagramDefinition_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.diagramtemplate.DiagramDefinition#getPrefix <em>Prefix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Prefix</em>'.
	 * @see org.eclipse.papyrus.diagramtemplate.DiagramDefinition#getPrefix()
	 * @see #getDiagramDefinition()
	 * @generated
	 */
	EAttribute getDiagramDefinition_Prefix();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.diagramtemplate.Selection <em>Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Selection</em>'.
	 * @see org.eclipse.papyrus.diagramtemplate.Selection
	 * @generated
	 */
	EClass getSelection();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.diagramtemplate.Selection#isRecursively <em>Recursively</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Recursively</em>'.
	 * @see org.eclipse.papyrus.diagramtemplate.Selection#isRecursively()
	 * @see #getSelection()
	 * @generated
	 */
	EAttribute getSelection_Recursively();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.diagramtemplate.SelectionRef <em>Selection Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Selection Ref</em>'.
	 * @see org.eclipse.papyrus.diagramtemplate.SelectionRef
	 * @generated
	 */
	EClass getSelectionRef();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.diagramtemplate.SelectionRef#getEReference <em>EReference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>EReference</em>'.
	 * @see org.eclipse.papyrus.diagramtemplate.SelectionRef#getEReference()
	 * @see #getSelectionRef()
	 * @generated
	 */
	EReference getSelectionRef_EReference();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.diagramtemplate.Template <em>Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Template</em>'.
	 * @see org.eclipse.papyrus.diagramtemplate.Template
	 * @generated
	 */
	EClass getTemplate();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.diagramtemplate.Template#getDiagramDefinitions <em>Diagram Definitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Diagram Definitions</em>'.
	 * @see org.eclipse.papyrus.diagramtemplate.Template#getDiagramDefinitions()
	 * @see #getTemplate()
	 * @generated
	 */
	EReference getTemplate_DiagramDefinitions();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.diagramtemplate.Template#getTargetRoot <em>Target Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Root</em>'.
	 * @see org.eclipse.papyrus.diagramtemplate.Template#getTargetRoot()
	 * @see #getTemplate()
	 * @generated
	 */
	EReference getTemplate_TargetRoot();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.diagramtemplate.AbstractSelection <em>Abstract Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Selection</em>'.
	 * @see org.eclipse.papyrus.diagramtemplate.AbstractSelection
	 * @generated
	 */
	EClass getAbstractSelection();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.diagramtemplate.AbstractSelection#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Element</em>'.
	 * @see org.eclipse.papyrus.diagramtemplate.AbstractSelection#getElement()
	 * @see #getAbstractSelection()
	 * @generated
	 */
	EReference getAbstractSelection_Element();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.diagramtemplate.AbstractSelection#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.eclipse.papyrus.diagramtemplate.AbstractSelection#getKind()
	 * @see #getAbstractSelection()
	 * @generated
	 */
	EAttribute getAbstractSelection_Kind();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.diagramtemplate.AbstractSelection#getSelectionRef <em>Selection Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Selection Ref</em>'.
	 * @see org.eclipse.papyrus.diagramtemplate.AbstractSelection#getSelectionRef()
	 * @see #getAbstractSelection()
	 * @generated
	 */
	EReference getAbstractSelection_SelectionRef();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.diagramtemplate.AbstractSelection#isSubTypes <em>Sub Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sub Types</em>'.
	 * @see org.eclipse.papyrus.diagramtemplate.AbstractSelection#isSubTypes()
	 * @see #getAbstractSelection()
	 * @generated
	 */
	EAttribute getAbstractSelection_SubTypes();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.diagramtemplate.AbstractSelection#getStereotypedBy <em>Stereotyped By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stereotyped By</em>'.
	 * @see org.eclipse.papyrus.diagramtemplate.AbstractSelection#getStereotypedBy()
	 * @see #getAbstractSelection()
	 * @generated
	 */
	EAttribute getAbstractSelection_StereotypedBy();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.diagramtemplate.SelectionKind <em>Selection Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Selection Kind</em>'.
	 * @see org.eclipse.papyrus.diagramtemplate.SelectionKind
	 * @generated
	 */
	EEnum getSelectionKind();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DiagramTemplateFactory getDiagramTemplateFactory();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.diagramtemplate.impl.DiagramDefinitionImpl <em>Diagram Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.diagramtemplate.impl.DiagramDefinitionImpl
		 * @see org.eclipse.papyrus.diagramtemplate.impl.DiagramTemplatePackageImpl#getDiagramDefinition()
		 * @generated
		 */
		EClass DIAGRAM_DEFINITION = eINSTANCE.getDiagramDefinition();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIAGRAM_DEFINITION__DESCRIPTION = eINSTANCE.getDiagramDefinition_Description();

		/**
		 * The meta object literal for the '<em><b>From Root</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIAGRAM_DEFINITION__FROM_ROOT = eINSTANCE.getDiagramDefinition_FromRoot();

		/**
		 * The meta object literal for the '<em><b>Selection</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIAGRAM_DEFINITION__SELECTION = eINSTANCE.getDiagramDefinition_Selection();

		/**
		 * The meta object literal for the '<em><b>Diagram Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIAGRAM_DEFINITION__DIAGRAM_KIND = eINSTANCE.getDiagramDefinition_DiagramKind();

		/**
		 * The meta object literal for the '<em><b>Layout To Apply</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIAGRAM_DEFINITION__LAYOUT_TO_APPLY = eINSTANCE.getDiagramDefinition_LayoutToApply();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIAGRAM_DEFINITION__NAME = eINSTANCE.getDiagramDefinition_Name();

		/**
		 * The meta object literal for the '<em><b>Prefix</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIAGRAM_DEFINITION__PREFIX = eINSTANCE.getDiagramDefinition_Prefix();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.diagramtemplate.impl.SelectionImpl <em>Selection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.diagramtemplate.impl.SelectionImpl
		 * @see org.eclipse.papyrus.diagramtemplate.impl.DiagramTemplatePackageImpl#getSelection()
		 * @generated
		 */
		EClass SELECTION = eINSTANCE.getSelection();

		/**
		 * The meta object literal for the '<em><b>Recursively</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SELECTION__RECURSIVELY = eINSTANCE.getSelection_Recursively();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.diagramtemplate.impl.SelectionRefImpl <em>Selection Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.diagramtemplate.impl.SelectionRefImpl
		 * @see org.eclipse.papyrus.diagramtemplate.impl.DiagramTemplatePackageImpl#getSelectionRef()
		 * @generated
		 */
		EClass SELECTION_REF = eINSTANCE.getSelectionRef();

		/**
		 * The meta object literal for the '<em><b>EReference</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SELECTION_REF__EREFERENCE = eINSTANCE.getSelectionRef_EReference();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.diagramtemplate.impl.TemplateImpl <em>Template</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.diagramtemplate.impl.TemplateImpl
		 * @see org.eclipse.papyrus.diagramtemplate.impl.DiagramTemplatePackageImpl#getTemplate()
		 * @generated
		 */
		EClass TEMPLATE = eINSTANCE.getTemplate();

		/**
		 * The meta object literal for the '<em><b>Diagram Definitions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE__DIAGRAM_DEFINITIONS = eINSTANCE.getTemplate_DiagramDefinitions();

		/**
		 * The meta object literal for the '<em><b>Target Root</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE__TARGET_ROOT = eINSTANCE.getTemplate_TargetRoot();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.diagramtemplate.impl.AbstractSelectionImpl <em>Abstract Selection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.diagramtemplate.impl.AbstractSelectionImpl
		 * @see org.eclipse.papyrus.diagramtemplate.impl.DiagramTemplatePackageImpl#getAbstractSelection()
		 * @generated
		 */
		EClass ABSTRACT_SELECTION = eINSTANCE.getAbstractSelection();

		/**
		 * The meta object literal for the '<em><b>Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_SELECTION__ELEMENT = eINSTANCE.getAbstractSelection_Element();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_SELECTION__KIND = eINSTANCE.getAbstractSelection_Kind();

		/**
		 * The meta object literal for the '<em><b>Selection Ref</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_SELECTION__SELECTION_REF = eINSTANCE.getAbstractSelection_SelectionRef();

		/**
		 * The meta object literal for the '<em><b>Sub Types</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_SELECTION__SUB_TYPES = eINSTANCE.getAbstractSelection_SubTypes();

		/**
		 * The meta object literal for the '<em><b>Stereotyped By</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_SELECTION__STEREOTYPED_BY = eINSTANCE.getAbstractSelection_StereotypedBy();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.diagramtemplate.SelectionKind <em>Selection Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.diagramtemplate.SelectionKind
		 * @see org.eclipse.papyrus.diagramtemplate.impl.DiagramTemplatePackageImpl#getSelectionKind()
		 * @generated
		 */
		EEnum SELECTION_KIND = eINSTANCE.getSelectionKind();

	}

} //DiagramTemplatePackage
