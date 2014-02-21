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
package org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.AbstractModelCellEditor;
import org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.BasicCellEditor;
import org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.ModelCellEditorDeclarations;
import org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.ModelCellEditorPackage;
import org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.NaryFeatureCellEditor;
import org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.UnaryReferenceCellEditor;

/**
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides
 * an adapter <code>createXXX</code> method for each class of the model. <!--
 * end-user-doc -->
 * 
 * @see org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.ModelCellEditorPackage
 * @generated
 */
public class ModelCellEditorAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static ModelCellEditorPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public ModelCellEditorAdapterFactory() {
		if (ModelCellEditorAdapterFactory.modelPackage == null) {
			ModelCellEditorAdapterFactory.modelPackage = ModelCellEditorPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc --> This implementation returns <code>true</code> if
	 * the object is either the model's package or is an instance object of the
	 * model. <!-- end-user-doc -->
	 * 
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(final Object object) {
		if (object == ModelCellEditorAdapterFactory.modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject) object).eClass().getEPackage() == ModelCellEditorAdapterFactory.modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ModelCellEditorSwitch<Adapter> modelSwitch = new ModelCellEditorSwitch<Adapter>() {
		@Override
		public Adapter caseModelCellEditorDeclarations(final ModelCellEditorDeclarations object) {
			return createModelCellEditorDeclarationsAdapter();
		}

		@Override
		public Adapter caseAbstractModelCellEditor(final AbstractModelCellEditor object) {
			return createAbstractModelCellEditorAdapter();
		}

		@Override
		public Adapter caseBasicCellEditor(final BasicCellEditor object) {
			return createBasicCellEditorAdapter();
		}

		@Override
		public Adapter caseUnaryReferenceCellEditor(final UnaryReferenceCellEditor object) {
			return createUnaryReferenceCellEditorAdapter();
		}

		@Override
		public Adapter caseNaryFeatureCellEditor(final NaryFeatureCellEditor object) {
			return createNaryFeatureCellEditorAdapter();
		}

		@Override
		public Adapter defaultCase(final EObject object) {
			return createEObjectAdapter();
		}
	};

	/**
	 * Creates an adapter for the <code>target</code>. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param target
	 *            the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(final Notifier target) {
		return this.modelSwitch.doSwitch((EObject) target);
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.ModelCellEditorDeclarations
	 * <em>Declarations</em>}'. <!-- begin-user-doc --> This default
	 * implementation returns null so that we can easily ignore cases; it's
	 * useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.ModelCellEditorDeclarations
	 * @generated
	 */
	public Adapter createModelCellEditorDeclarationsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.AbstractModelCellEditor
	 * <em>Abstract Model Cell Editor</em>}'. <!-- begin-user-doc --> This
	 * default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases
	 * anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.AbstractModelCellEditor
	 * @generated
	 */
	public Adapter createAbstractModelCellEditorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.BasicCellEditor
	 * <em>Basic Cell Editor</em>}'. <!-- begin-user-doc --> This default
	 * implementation returns null so that we can easily ignore cases; it's
	 * useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.BasicCellEditor
	 * @generated
	 */
	public Adapter createBasicCellEditorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.UnaryReferenceCellEditor
	 * <em>Unary Reference Cell Editor</em>}'. <!-- begin-user-doc --> This
	 * default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases
	 * anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.UnaryReferenceCellEditor
	 * @generated
	 */
	public Adapter createUnaryReferenceCellEditorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.NaryFeatureCellEditor
	 * <em>Nary Feature Cell Editor</em>}'. <!-- begin-user-doc --> This default
	 * implementation returns null so that we can easily ignore cases; it's
	 * useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.NaryFeatureCellEditor
	 * @generated
	 */
	public Adapter createNaryFeatureCellEditorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case. <!-- begin-user-doc --> This
	 * default implementation returns null. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} // ModelCellEditorAdapterFactory
