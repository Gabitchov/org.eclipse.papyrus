/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.properties.generation.fieldselection;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
 * @see org.eclipse.papyrus.properties.generation.fieldselection.FieldSelectionFactory
 * @model kind="package"
 * @generated
 */
public interface FieldSelectionPackage extends EPackage {

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "fieldselection";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/properties/fieldSelection";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "fs";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	FieldSelectionPackage eINSTANCE = org.eclipse.papyrus.properties.generation.fieldselection.impl.FieldSelectionPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.properties.generation.fieldselection.impl.FieldSelectionImpl <em>Field Selection</em>}'
	 * class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.properties.generation.fieldselection.impl.FieldSelectionImpl
	 * @see org.eclipse.papyrus.properties.generation.fieldselection.impl.FieldSelectionPackageImpl#getFieldSelection()
	 * @generated
	 */
	int FIELD_SELECTION = 0;

	/**
	 * The feature id for the '<em><b>Fields</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FIELD_SELECTION__FIELDS = 0;

	/**
	 * The feature id for the '<em><b>Context Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FIELD_SELECTION__CONTEXT_ELEMENTS = 1;

	/**
	 * The number of structural features of the '<em>Field Selection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FIELD_SELECTION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.properties.generation.fieldselection.impl.PropertyDefinitionImpl
	 * <em>Property Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.properties.generation.fieldselection.impl.PropertyDefinitionImpl
	 * @see org.eclipse.papyrus.properties.generation.fieldselection.impl.FieldSelectionPackageImpl#getPropertyDefinition()
	 * @generated
	 */
	int PROPERTY_DEFINITION = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROPERTY_DEFINITION__NAME = 0;

	/**
	 * The feature id for the '<em><b>Value Single</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROPERTY_DEFINITION__VALUE_SINGLE = 1;

	/**
	 * The feature id for the '<em><b>Value Multiple</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROPERTY_DEFINITION__VALUE_MULTIPLE = 2;

	/**
	 * The number of structural features of the '<em>Property Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROPERTY_DEFINITION_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.properties.generation.fieldselection.impl.ContextElementImpl <em>Context Element</em>}'
	 * class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.properties.generation.fieldselection.impl.ContextElementImpl
	 * @see org.eclipse.papyrus.properties.generation.fieldselection.impl.FieldSelectionPackageImpl#getContextElement()
	 * @generated
	 */
	int CONTEXT_ELEMENT = 2;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONTEXT_ELEMENT__ELEMENTS = 0;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONTEXT_ELEMENT__PROPERTIES = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONTEXT_ELEMENT__NAME = 2;

	/**
	 * The number of structural features of the '<em>Context Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONTEXT_ELEMENT_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '<em>Value</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.properties.generation.wizard.widget.TernaryButton.State
	 * @see org.eclipse.papyrus.properties.generation.fieldselection.impl.FieldSelectionPackageImpl#getValue()
	 * @generated
	 */
	int VALUE = 3;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.properties.generation.fieldselection.FieldSelection <em>Field Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Field Selection</em>'.
	 * @see org.eclipse.papyrus.properties.generation.fieldselection.FieldSelection
	 * @generated
	 */
	EClass getFieldSelection();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.eclipse.papyrus.properties.generation.fieldselection.FieldSelection#getFields <em>Fields</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Fields</em>'.
	 * @see org.eclipse.papyrus.properties.generation.fieldselection.FieldSelection#getFields()
	 * @see #getFieldSelection()
	 * @generated
	 */
	EReference getFieldSelection_Fields();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.eclipse.papyrus.properties.generation.fieldselection.FieldSelection#getContextElements <em>Context Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Context Elements</em>'.
	 * @see org.eclipse.papyrus.properties.generation.fieldselection.FieldSelection#getContextElements()
	 * @see #getFieldSelection()
	 * @generated
	 */
	EReference getFieldSelection_ContextElements();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.properties.generation.fieldselection.PropertyDefinition
	 * <em>Property Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Property Definition</em>'.
	 * @see org.eclipse.papyrus.properties.generation.fieldselection.PropertyDefinition
	 * @generated
	 */
	EClass getPropertyDefinition();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.properties.generation.fieldselection.PropertyDefinition#getName
	 * <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.properties.generation.fieldselection.PropertyDefinition#getName()
	 * @see #getPropertyDefinition()
	 * @generated
	 */
	EAttribute getPropertyDefinition_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.properties.generation.fieldselection.PropertyDefinition#getValueSingle
	 * <em>Value Single</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Value Single</em>'.
	 * @see org.eclipse.papyrus.properties.generation.fieldselection.PropertyDefinition#getValueSingle()
	 * @see #getPropertyDefinition()
	 * @generated
	 */
	EAttribute getPropertyDefinition_ValueSingle();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.properties.generation.fieldselection.PropertyDefinition#getValueMultiple
	 * <em>Value Multiple</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Value Multiple</em>'.
	 * @see org.eclipse.papyrus.properties.generation.fieldselection.PropertyDefinition#getValueMultiple()
	 * @see #getPropertyDefinition()
	 * @generated
	 */
	EAttribute getPropertyDefinition_ValueMultiple();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.properties.generation.fieldselection.ContextElement <em>Context Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Context Element</em>'.
	 * @see org.eclipse.papyrus.properties.generation.fieldselection.ContextElement
	 * @generated
	 */
	EClass getContextElement();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.eclipse.papyrus.properties.generation.fieldselection.ContextElement#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see org.eclipse.papyrus.properties.generation.fieldselection.ContextElement#getElements()
	 * @see #getContextElement()
	 * @generated
	 */
	EReference getContextElement_Elements();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.eclipse.papyrus.properties.generation.fieldselection.ContextElement#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Properties</em>'.
	 * @see org.eclipse.papyrus.properties.generation.fieldselection.ContextElement#getProperties()
	 * @see #getContextElement()
	 * @generated
	 */
	EReference getContextElement_Properties();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.properties.generation.fieldselection.ContextElement#getName
	 * <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.properties.generation.fieldselection.ContextElement#getName()
	 * @see #getContextElement()
	 * @generated
	 */
	EAttribute getContextElement_Name();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.papyrus.properties.generation.wizard.widget.TernaryButton.State <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for data type '<em>Value</em>'.
	 * @see org.eclipse.papyrus.properties.generation.wizard.widget.TernaryButton.State
	 * @model instanceClass="org.eclipse.papyrus.properties.generation.wizard.widget.TernaryButton.State"
	 * @generated
	 */
	EDataType getValue();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	FieldSelectionFactory getFieldSelectionFactory();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.properties.generation.fieldselection.impl.FieldSelectionImpl
		 * <em>Field Selection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.properties.generation.fieldselection.impl.FieldSelectionImpl
		 * @see org.eclipse.papyrus.properties.generation.fieldselection.impl.FieldSelectionPackageImpl#getFieldSelection()
		 * @generated
		 */
		EClass FIELD_SELECTION = eINSTANCE.getFieldSelection();

		/**
		 * The meta object literal for the '<em><b>Fields</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference FIELD_SELECTION__FIELDS = eINSTANCE.getFieldSelection_Fields();

		/**
		 * The meta object literal for the '<em><b>Context Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference FIELD_SELECTION__CONTEXT_ELEMENTS = eINSTANCE.getFieldSelection_ContextElements();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.properties.generation.fieldselection.impl.PropertyDefinitionImpl
		 * <em>Property Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.properties.generation.fieldselection.impl.PropertyDefinitionImpl
		 * @see org.eclipse.papyrus.properties.generation.fieldselection.impl.FieldSelectionPackageImpl#getPropertyDefinition()
		 * @generated
		 */
		EClass PROPERTY_DEFINITION = eINSTANCE.getPropertyDefinition();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute PROPERTY_DEFINITION__NAME = eINSTANCE.getPropertyDefinition_Name();

		/**
		 * The meta object literal for the '<em><b>Value Single</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute PROPERTY_DEFINITION__VALUE_SINGLE = eINSTANCE.getPropertyDefinition_ValueSingle();

		/**
		 * The meta object literal for the '<em><b>Value Multiple</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute PROPERTY_DEFINITION__VALUE_MULTIPLE = eINSTANCE.getPropertyDefinition_ValueMultiple();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.properties.generation.fieldselection.impl.ContextElementImpl
		 * <em>Context Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.properties.generation.fieldselection.impl.ContextElementImpl
		 * @see org.eclipse.papyrus.properties.generation.fieldselection.impl.FieldSelectionPackageImpl#getContextElement()
		 * @generated
		 */
		EClass CONTEXT_ELEMENT = eINSTANCE.getContextElement();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CONTEXT_ELEMENT__ELEMENTS = eINSTANCE.getContextElement_Elements();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CONTEXT_ELEMENT__PROPERTIES = eINSTANCE.getContextElement_Properties();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute CONTEXT_ELEMENT__NAME = eINSTANCE.getContextElement_Name();

		/**
		 * The meta object literal for the '<em>Value</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.properties.generation.wizard.widget.TernaryButton.State
		 * @see org.eclipse.papyrus.properties.generation.fieldselection.impl.FieldSelectionPackageImpl#getValue()
		 * @generated
		 */
		EDataType VALUE = eINSTANCE.getValue();

	}

} //FieldSelectionPackage
