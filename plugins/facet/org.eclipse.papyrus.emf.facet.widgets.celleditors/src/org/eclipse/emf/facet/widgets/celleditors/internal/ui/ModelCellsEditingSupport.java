/*******************************************************************************
 * Copyright (c) 2010, 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Nicolas Bros (Mia-Software) - initial API and implementation
 *   Nicolas Guyomar (Mia-Software) - Bug 339554 - org.eclipse.emf.facet.widgets.celleditors API cleaning
 *   Nicolas Bros (Mia-Software) - Bug 339855 - ModelCellEditor class should not be exposed
 *   Nicolas Guyomar (Mia-Software) - Bug 342451 - To be able to edit derived facet attributes and derived facet references in a table
 *******************************************************************************/
package org.eclipse.emf.facet.widgets.celleditors.internal.ui;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.facet.widgets.celleditors.ICellEditorsRegistry;
import org.eclipse.emf.facet.widgets.celleditors.IModelCellEditHandler;
import org.eclipse.emf.facet.widgets.celleditors.IModelCellEditor;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

public class ModelCellsEditingSupport<T> extends EditingSupport {

	private final EStructuralFeature feature;
	private final IModelCellEditor cellEditor;
	private final EObject eObject;
	private final ColumnViewer columnViewer;
	private final Object newValuePlaceholder;
	private List<T> values;

	public ModelCellsEditingSupport(final ColumnViewer columnViewer,
			final EStructuralFeature feature, final EObject eObject,
			final Object newValuePlaceholder, final List<T> values) {
		super(columnViewer);
		this.columnViewer = columnViewer;
		this.feature = feature;
		this.eObject = eObject;
		this.values = values;
		this.newValuePlaceholder = newValuePlaceholder;
		this.cellEditor = ICellEditorsRegistry.INSTANCE.getCellEditorFor(this.feature.getEType());
		if (this.cellEditor == null) {
			throw new IllegalStateException(
					"no cell editor found for " + this.feature.getEType().getName()); //$NON-NLS-1$
		}
	}

	@Override
	protected CellEditor getCellEditor(final Object element) {
		return new CellEditor((Composite) this.columnViewer.getControl()) {

			private Control control;

			@Override
			protected void doSetValue(final Object value) {
				//
			}

			@Override
			protected void doSetFocus() {
				this.control.setFocus();
			}

			@Override
			protected Object doGetValue() {
				return null;
			}

			@Override
			protected Control createControl(final Composite parent) {
				IModelCellEditHandler editHandler = new IModelCellEditHandler() {
					public void commit() {
						@SuppressWarnings("unchecked")
						//unchecked: The cellEditor.getValue() type cannot be checked.
						T value = (T) ModelCellsEditingSupport.this.cellEditor.getValue();
						int index = ModelCellsEditingSupport.this.values.indexOf(element);
						if (index != -1
								|| element == ModelCellsEditingSupport.this.newValuePlaceholder) {
							ModelCellsEditingSupport.this.values.set(index, value);
						}
						close();
						ModelCellsEditingSupport.this.columnViewer.refresh();
					}

				};

				Object originalValue = null;
				if (element != ModelCellsEditingSupport.this.newValuePlaceholder) {
					originalValue = element;
				}

				this.control = ModelCellsEditingSupport.this.cellEditor.activateCell(parent,
						originalValue, editHandler, ModelCellsEditingSupport.this.feature,
						ModelCellsEditingSupport.this.eObject);
				return this.control;
			}

			public void close() {
				deactivate();
				Control parentControl = ModelCellsEditingSupport.this.columnViewer.getControl();
				if (parentControl != null && !parentControl.isDisposed()) {
					parentControl.forceFocus();
				}
				dispose();
			}
		};
	}

	@Override
	protected boolean canEdit(final Object element) {
		return true;
	}

	@Override
	protected Object getValue(final Object element) {
		return element;
	}

	@Override
	protected void setValue(final Object element, final Object value) {
		// TODO Auto-generated method stub
	}
}
