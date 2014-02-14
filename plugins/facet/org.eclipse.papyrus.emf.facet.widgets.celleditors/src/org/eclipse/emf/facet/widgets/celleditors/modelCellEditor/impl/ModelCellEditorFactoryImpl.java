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
package org.eclipse.emf.facet.widgets.celleditors.modelCellEditor.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.facet.widgets.celleditors.modelCellEditor.BasicCellEditor;
import org.eclipse.emf.facet.widgets.celleditors.modelCellEditor.ModelCellEditorDeclarations;
import org.eclipse.emf.facet.widgets.celleditors.modelCellEditor.ModelCellEditorFactory;
import org.eclipse.emf.facet.widgets.celleditors.modelCellEditor.ModelCellEditorPackage;
import org.eclipse.emf.facet.widgets.celleditors.modelCellEditor.NaryFeatureCellEditor;
import org.eclipse.emf.facet.widgets.celleditors.modelCellEditor.UnaryReferenceCellEditor;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!--
 * end-user-doc -->
 * 
 * @generated
 */
public class ModelCellEditorFactoryImpl extends EFactoryImpl implements ModelCellEditorFactory {
	/**
	 * Creates the default factory implementation. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public static ModelCellEditorFactory init() {
		try {
			ModelCellEditorFactory theModelCellEditorFactory = (ModelCellEditorFactory) EPackage.Registry.INSTANCE
					.getEFactory("http://www.eclipse.org/EMF_Facet/ModelCellEditor/0.1.0/modelCellEditor"); //$NON-NLS-1$
			if (theModelCellEditorFactory != null) {
				return theModelCellEditorFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ModelCellEditorFactoryImpl();
	}

	/**
	 * Creates an instance of the factory. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public ModelCellEditorFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EObject create(final EClass eClass) {
		switch (eClass.getClassifierID()) {
		case ModelCellEditorPackage.MODEL_CELL_EDITOR_DECLARATIONS:
			return createModelCellEditorDeclarations();
		case ModelCellEditorPackage.BASIC_CELL_EDITOR:
			return createBasicCellEditor();
		case ModelCellEditorPackage.UNARY_REFERENCE_CELL_EDITOR:
			return createUnaryReferenceCellEditor();
		case ModelCellEditorPackage.NARY_FEATURE_CELL_EDITOR:
			return createNaryFeatureCellEditor();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() //$NON-NLS-1$
					+ "' is not a valid classifier"); //$NON-NLS-1$
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ModelCellEditorDeclarations createModelCellEditorDeclarations() {
		ModelCellEditorDeclarationsImpl modelCellEditorDeclarations = new ModelCellEditorDeclarationsImpl();
		return modelCellEditorDeclarations;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public BasicCellEditor createBasicCellEditor() {
		BasicCellEditorImpl basicCellEditor = new BasicCellEditorImpl();
		return basicCellEditor;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public UnaryReferenceCellEditor createUnaryReferenceCellEditor() {
		UnaryReferenceCellEditorImpl unaryReferenceCellEditor = new UnaryReferenceCellEditorImpl();
		return unaryReferenceCellEditor;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NaryFeatureCellEditor createNaryFeatureCellEditor() {
		NaryFeatureCellEditorImpl naryFeatureCellEditor = new NaryFeatureCellEditorImpl();
		return naryFeatureCellEditor;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ModelCellEditorPackage getModelCellEditorPackage() {
		return (ModelCellEditorPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ModelCellEditorPackage getPackage() {
		return ModelCellEditorPackage.eINSTANCE;
	}

} // ModelCellEditorFactoryImpl
