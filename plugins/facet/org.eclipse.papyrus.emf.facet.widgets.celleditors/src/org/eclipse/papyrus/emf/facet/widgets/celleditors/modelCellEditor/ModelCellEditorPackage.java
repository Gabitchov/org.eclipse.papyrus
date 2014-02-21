/**
 * Copyright (c) 2010 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Nicolas Bros (Mia-Software) - initial API and implementation
 */
package org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains
 * accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.ModelCellEditorFactory
 * @model kind="package"
 * @generated
 */
public interface ModelCellEditorPackage extends EPackage {
	/**
	 * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "modelCellEditor"; //$NON-NLS-1$

	/**
	 * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/EMF_Facet/ModelCellEditor/0.1.0/modelCellEditor"; //$NON-NLS-1$

	/**
	 * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "modelCellEditor"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	ModelCellEditorPackage eINSTANCE = org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.impl.ModelCellEditorPackageImpl
			.init();

	/**
	 * The meta object id for the '
	 * {@link org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.impl.ModelCellEditorDeclarationsImpl
	 * <em>Declarations</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.impl.ModelCellEditorDeclarationsImpl
	 * @see org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.impl.ModelCellEditorPackageImpl#getModelCellEditorDeclarations()
	 * @generated
	 */
	int MODEL_CELL_EDITOR_DECLARATIONS = 0;

	/**
	 * The feature id for the '<em><b>Model Cell Editors</b></em>' containment
	 * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MODEL_CELL_EDITOR_DECLARATIONS__MODEL_CELL_EDITORS = 0;

	/**
	 * The number of structural features of the '<em>Declarations</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MODEL_CELL_EDITOR_DECLARATIONS_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '
	 * {@link org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.impl.AbstractModelCellEditorImpl
	 * <em>Abstract Model Cell Editor</em>}' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.impl.AbstractModelCellEditorImpl
	 * @see org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.impl.ModelCellEditorPackageImpl#getAbstractModelCellEditor()
	 * @generated
	 */
	int ABSTRACT_MODEL_CELL_EDITOR = 1;

	/**
	 * The feature id for the '<em><b>Cell Type</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MODEL_CELL_EDITOR__CELL_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Cell Id</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MODEL_CELL_EDITOR__CELL_ID = 1;

	/**
	 * The number of structural features of the '
	 * <em>Abstract Model Cell Editor</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_MODEL_CELL_EDITOR_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '
	 * {@link org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.impl.BasicCellEditorImpl
	 * <em>Basic Cell Editor</em>}' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.impl.BasicCellEditorImpl
	 * @see org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.impl.ModelCellEditorPackageImpl#getBasicCellEditor()
	 * @generated
	 */
	int BASIC_CELL_EDITOR = 2;

	/**
	 * The feature id for the '<em><b>Cell Type</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BASIC_CELL_EDITOR__CELL_TYPE = ModelCellEditorPackage.ABSTRACT_MODEL_CELL_EDITOR__CELL_TYPE;

	/**
	 * The feature id for the '<em><b>Cell Id</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BASIC_CELL_EDITOR__CELL_ID = ModelCellEditorPackage.ABSTRACT_MODEL_CELL_EDITOR__CELL_ID;

	/**
	 * The feature id for the '<em><b>Basic Cell Editor Impl</b></em>'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BASIC_CELL_EDITOR__BASIC_CELL_EDITOR_IMPL = ModelCellEditorPackage.ABSTRACT_MODEL_CELL_EDITOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Basic Cell Editor</em>'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BASIC_CELL_EDITOR_FEATURE_COUNT = ModelCellEditorPackage.ABSTRACT_MODEL_CELL_EDITOR_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '
	 * {@link org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.impl.UnaryReferenceCellEditorImpl
	 * <em>Unary Reference Cell Editor</em>}' class. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.impl.UnaryReferenceCellEditorImpl
	 * @see org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.impl.ModelCellEditorPackageImpl#getUnaryReferenceCellEditor()
	 * @generated
	 */
	int UNARY_REFERENCE_CELL_EDITOR = 3;

	/**
	 * The feature id for the '<em><b>Cell Type</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UNARY_REFERENCE_CELL_EDITOR__CELL_TYPE = ModelCellEditorPackage.ABSTRACT_MODEL_CELL_EDITOR__CELL_TYPE;

	/**
	 * The feature id for the '<em><b>Cell Id</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UNARY_REFERENCE_CELL_EDITOR__CELL_ID = ModelCellEditorPackage.ABSTRACT_MODEL_CELL_EDITOR__CELL_ID;

	/**
	 * The feature id for the '<em><b>Unary Reference Cell Editor Impl</b></em>'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UNARY_REFERENCE_CELL_EDITOR__UNARY_REFERENCE_CELL_EDITOR_IMPL = ModelCellEditorPackage.ABSTRACT_MODEL_CELL_EDITOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '
	 * <em>Unary Reference Cell Editor</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UNARY_REFERENCE_CELL_EDITOR_FEATURE_COUNT = ModelCellEditorPackage.ABSTRACT_MODEL_CELL_EDITOR_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '
	 * {@link org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.impl.NaryFeatureCellEditorImpl
	 * <em>Nary Feature Cell Editor</em>}' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.impl.NaryFeatureCellEditorImpl
	 * @see org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.impl.ModelCellEditorPackageImpl#getNaryFeatureCellEditor()
	 * @generated
	 */
	int NARY_FEATURE_CELL_EDITOR = 4;

	/**
	 * The feature id for the '<em><b>Cell Type</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NARY_FEATURE_CELL_EDITOR__CELL_TYPE = ModelCellEditorPackage.ABSTRACT_MODEL_CELL_EDITOR__CELL_TYPE;

	/**
	 * The feature id for the '<em><b>Cell Id</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NARY_FEATURE_CELL_EDITOR__CELL_ID = ModelCellEditorPackage.ABSTRACT_MODEL_CELL_EDITOR__CELL_ID;

	/**
	 * The feature id for the '<em><b>Nary Feature Cell Editor Impl</b></em>'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NARY_FEATURE_CELL_EDITOR__NARY_FEATURE_CELL_EDITOR_IMPL = ModelCellEditorPackage.ABSTRACT_MODEL_CELL_EDITOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '
	 * <em>Nary Feature Cell Editor</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NARY_FEATURE_CELL_EDITOR_FEATURE_COUNT = ModelCellEditorPackage.ABSTRACT_MODEL_CELL_EDITOR_FEATURE_COUNT + 1;

	/**
	 * Returns the meta object for class '
	 * {@link org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.ModelCellEditorDeclarations
	 * <em>Declarations</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Declarations</em>'.
	 * @see org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.ModelCellEditorDeclarations
	 * @generated
	 */
	EClass getModelCellEditorDeclarations();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.ModelCellEditorDeclarations#getModelCellEditors
	 * <em>Model Cell Editors</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for the containment reference list '
	 *         <em>Model Cell Editors</em>'.
	 * @see org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.ModelCellEditorDeclarations#getModelCellEditors()
	 * @see #getModelCellEditorDeclarations()
	 * @generated
	 */
	EReference getModelCellEditorDeclarations_ModelCellEditors();

	/**
	 * Returns the meta object for class '
	 * {@link org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.AbstractModelCellEditor
	 * <em>Abstract Model Cell Editor</em>}'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Abstract Model Cell Editor</em>'.
	 * @see org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.AbstractModelCellEditor
	 * @generated
	 */
	EClass getAbstractModelCellEditor();

	/**
	 * Returns the meta object for the reference '
	 * {@link org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.AbstractModelCellEditor#getCellType
	 * <em>Cell Type</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Cell Type</em>'.
	 * @see org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.AbstractModelCellEditor#getCellType()
	 * @see #getAbstractModelCellEditor()
	 * @generated
	 */
	EReference getAbstractModelCellEditor_CellType();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.AbstractModelCellEditor#getCellId
	 * <em>Cell Id</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Cell Id</em>'.
	 * @see org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.AbstractModelCellEditor#getCellId()
	 * @see #getAbstractModelCellEditor()
	 * @generated
	 */
	EAttribute getAbstractModelCellEditor_CellId();

	/**
	 * Returns the meta object for class '
	 * {@link org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.BasicCellEditor
	 * <em>Basic Cell Editor</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for class '<em>Basic Cell Editor</em>'.
	 * @see org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.BasicCellEditor
	 * @generated
	 */
	EClass getBasicCellEditor();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.BasicCellEditor#getBasicCellEditorImpl
	 * <em>Basic Cell Editor Impl</em>}'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the meta object for the attribute '
	 *         <em>Basic Cell Editor Impl</em>'.
	 * @see org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.BasicCellEditor#getBasicCellEditorImpl()
	 * @see #getBasicCellEditor()
	 * @generated
	 */
	EAttribute getBasicCellEditor_BasicCellEditorImpl();

	/**
	 * Returns the meta object for class '
	 * {@link org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.UnaryReferenceCellEditor
	 * <em>Unary Reference Cell Editor</em>}'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Unary Reference Cell Editor</em>'.
	 * @see org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.UnaryReferenceCellEditor
	 * @generated
	 */
	EClass getUnaryReferenceCellEditor();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.UnaryReferenceCellEditor#getUnaryReferenceCellEditorImpl
	 * <em>Unary Reference Cell Editor Impl</em>}'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the meta object for the attribute '
	 *         <em>Unary Reference Cell Editor Impl</em>'.
	 * @see org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.UnaryReferenceCellEditor#getUnaryReferenceCellEditorImpl()
	 * @see #getUnaryReferenceCellEditor()
	 * @generated
	 */
	EAttribute getUnaryReferenceCellEditor_UnaryReferenceCellEditorImpl();

	/**
	 * Returns the meta object for class '
	 * {@link org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.NaryFeatureCellEditor
	 * <em>Nary Feature Cell Editor</em>}'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Nary Feature Cell Editor</em>'.
	 * @see org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.NaryFeatureCellEditor
	 * @generated
	 */
	EClass getNaryFeatureCellEditor();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.NaryFeatureCellEditor#getNaryFeatureCellEditorImpl
	 * <em>Nary Feature Cell Editor Impl</em>}'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the meta object for the attribute '
	 *         <em>Nary Feature Cell Editor Impl</em>'.
	 * @see org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.NaryFeatureCellEditor#getNaryFeatureCellEditorImpl()
	 * @see #getNaryFeatureCellEditor()
	 * @generated
	 */
	EAttribute getNaryFeatureCellEditor_NaryFeatureCellEditorImpl();

	/**
	 * Returns the factory that creates the instances of the model. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ModelCellEditorFactory getModelCellEditorFactory();

	/**
	 * <!-- begin-user-doc --> Defines literals for the meta objects that
	 * represent
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
		 * The meta object literal for the '
		 * {@link org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.impl.ModelCellEditorDeclarationsImpl
		 * <em>Declarations</em>}' class. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.impl.ModelCellEditorDeclarationsImpl
		 * @see org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.impl.ModelCellEditorPackageImpl#getModelCellEditorDeclarations()
		 * @generated
		 */
		EClass MODEL_CELL_EDITOR_DECLARATIONS = ModelCellEditorPackage.eINSTANCE
				.getModelCellEditorDeclarations();

		/**
		 * The meta object literal for the '<em><b>Model Cell Editors</b></em>'
		 * containment reference list feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EReference MODEL_CELL_EDITOR_DECLARATIONS__MODEL_CELL_EDITORS = ModelCellEditorPackage.eINSTANCE
				.getModelCellEditorDeclarations_ModelCellEditors();

		/**
		 * The meta object literal for the '
		 * {@link org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.impl.AbstractModelCellEditorImpl
		 * <em>Abstract Model Cell Editor</em>}' class. <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.impl.AbstractModelCellEditorImpl
		 * @see org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.impl.ModelCellEditorPackageImpl#getAbstractModelCellEditor()
		 * @generated
		 */
		EClass ABSTRACT_MODEL_CELL_EDITOR = ModelCellEditorPackage.eINSTANCE
				.getAbstractModelCellEditor();

		/**
		 * The meta object literal for the '<em><b>Cell Type</b></em>' reference
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ABSTRACT_MODEL_CELL_EDITOR__CELL_TYPE = ModelCellEditorPackage.eINSTANCE
				.getAbstractModelCellEditor_CellType();

		/**
		 * The meta object literal for the '<em><b>Cell Id</b></em>' attribute
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ABSTRACT_MODEL_CELL_EDITOR__CELL_ID = ModelCellEditorPackage.eINSTANCE
				.getAbstractModelCellEditor_CellId();

		/**
		 * The meta object literal for the '
		 * {@link org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.impl.BasicCellEditorImpl
		 * <em>Basic Cell Editor</em>}' class. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.impl.BasicCellEditorImpl
		 * @see org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.impl.ModelCellEditorPackageImpl#getBasicCellEditor()
		 * @generated
		 */
		EClass BASIC_CELL_EDITOR = ModelCellEditorPackage.eINSTANCE.getBasicCellEditor();

		/**
		 * The meta object literal for the '
		 * <em><b>Basic Cell Editor Impl</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute BASIC_CELL_EDITOR__BASIC_CELL_EDITOR_IMPL = ModelCellEditorPackage.eINSTANCE
				.getBasicCellEditor_BasicCellEditorImpl();

		/**
		 * The meta object literal for the '
		 * {@link org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.impl.UnaryReferenceCellEditorImpl
		 * <em>Unary Reference Cell Editor</em>}' class. <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.impl.UnaryReferenceCellEditorImpl
		 * @see org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.impl.ModelCellEditorPackageImpl#getUnaryReferenceCellEditor()
		 * @generated
		 */
		EClass UNARY_REFERENCE_CELL_EDITOR = ModelCellEditorPackage.eINSTANCE
				.getUnaryReferenceCellEditor();

		/**
		 * The meta object literal for the '
		 * <em><b>Unary Reference Cell Editor Impl</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute UNARY_REFERENCE_CELL_EDITOR__UNARY_REFERENCE_CELL_EDITOR_IMPL = ModelCellEditorPackage.eINSTANCE
				.getUnaryReferenceCellEditor_UnaryReferenceCellEditorImpl();

		/**
		 * The meta object literal for the '
		 * {@link org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.impl.NaryFeatureCellEditorImpl
		 * <em>Nary Feature Cell Editor</em>}' class. <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.impl.NaryFeatureCellEditorImpl
		 * @see org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.impl.ModelCellEditorPackageImpl#getNaryFeatureCellEditor()
		 * @generated
		 */
		EClass NARY_FEATURE_CELL_EDITOR = ModelCellEditorPackage.eINSTANCE
				.getNaryFeatureCellEditor();

		/**
		 * The meta object literal for the '
		 * <em><b>Nary Feature Cell Editor Impl</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute NARY_FEATURE_CELL_EDITOR__NARY_FEATURE_CELL_EDITOR_IMPL = ModelCellEditorPackage.eINSTANCE
				.getNaryFeatureCellEditor_NaryFeatureCellEditorImpl();

	}

} // ModelCellEditorPackage
