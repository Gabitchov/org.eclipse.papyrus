/*******************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Nicolas Guyomar (Mia-Software) - Bug 342451 - To be able to edit derived facet attributes and derived facet references in a table
 *******************************************************************************/
package org.eclipse.papyrus.emf.facet.widgets.celleditors.internal.ui;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.emf.facet.widgets.celleditors.IModelCellEditHandler;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Shell;

public abstract class AbstractNaryEditingDialog<T extends Object> extends Dialog {

	public static final int AVAILABLE_VALUES_TREE_WIDTH = 200;
	public static final int AVAILABLE_VALUES_TREE_HEIGHT = 250;

	private final List<T> values;
	private final IModelCellEditHandler editHandler;
	private final EObject eObject;
	private final EStructuralFeature feature;

	protected AbstractNaryEditingDialog(final Shell shell, final List<T> values,
			final IModelCellEditHandler editHandler, final EObject eObject,
			final EStructuralFeature feature) {
		super(shell);
		this.values = new ArrayList<T>(values);
		this.feature = feature;
		this.editHandler = editHandler;
		this.eObject = eObject;
	}
	
	public class AssignedValuesContentProvider implements IStructuredContentProvider {
		public Object[] getElements(final Object inputElement) {
			if (inputElement instanceof FeatureValuesInput) {
				FeatureValuesInput valuesInput = (FeatureValuesInput) inputElement;
				EObject source = valuesInput.getSource();
				List<?> list = (List<?>) source.eGet(valuesInput.getFeature());
				if (list == null) {
					return new Object[0];
				}
				return list.toArray();
			} else if (inputElement instanceof List<?>) {
				return ((List<?>) inputElement).toArray();
			}
			throw new IllegalArgumentException(FeatureValuesInput.class.getSimpleName()
					+ " expected"); //$NON-NLS-1$
		}

		public void dispose() {
			//
		}

		public void inputChanged(final Viewer viewer, final Object oldInput, final Object newInput) {
			//
		}
	}

	public List<T> getValue() {
		return this.values;
	}

	@SuppressWarnings("unchecked") // type erasure on generic
	public void upButtonClicked() {
		final IStructuredSelection selection = (IStructuredSelection) getSelection();

		int minIndex = 0;
		for (Object element : selection.toList()) {
			final int index = this.values.indexOf(element);
			T object = this.values.set(Math.max(index - 1, minIndex++), (T) element);
			this.values.set(index, object);
		}
		refresh();
	}

	@SuppressWarnings("unchecked") // type erasure on generic
	public void downButtonClicked() {
		final IStructuredSelection selection = (StructuredSelection) getSelection();

		List<?> selectionList = selection.toList();
		boolean canMove = !selectionList.contains(this.values.get(this.values.size() - 1));
		for (int i = this.values.size() - 2; i >= 0; i--) {
			final Object selectedObject = this.values.get(i);
			if (selectionList.contains(selectedObject)) {
				if (canMove) {
					T object = this.values.set(i + 1, (T) selectedObject);
					this.values.set(i, object);
				}
			} else {
				canMove = true;
			}

		}

		refresh();
	}

	public abstract ISelection getSelection();

	public abstract void refresh();

	@Override
	protected void okPressed() {
		super.okPressed();
		this.editHandler.commit();
	}
	
	protected List<T> getValues() {
		return this.values;
	}

	protected IModelCellEditHandler getEditHandler() {
		return this.editHandler;
	}

	protected EObject geteObject() {
		return this.eObject;
	}

	protected EStructuralFeature getFeature() {
		return this.feature;
	}

}
