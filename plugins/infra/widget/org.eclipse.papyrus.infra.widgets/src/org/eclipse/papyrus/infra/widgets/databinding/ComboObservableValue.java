/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.widgets.databinding;

import org.eclipse.core.databinding.observable.value.AbstractObservableValue;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.ValueDiff;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.infra.tools.databinding.AggregatedObservable;
import org.eclipse.papyrus.infra.widgets.providers.ComboLabelProvider;
import org.eclipse.papyrus.infra.widgets.providers.UnchangedObject;
import org.eclipse.papyrus.infra.widgets.providers.UnsetObject;

/**
 * An ObservableValue for a ComboViewer, with support for AggregatedObservable
 * 
 * @author Camille Letavernier
 */
public class ComboObservableValue extends AbstractObservableValue implements ISelectionChangedListener {

	/**
	 * The Observed ComboViewer
	 */
	protected ComboViewer viewer;

	/**
	 * The current value
	 */
	protected Object currentValue;

	/**
	 * If the Combo may represent more than one value,
	 * use an AggregatedObservable
	 * 
	 * May be null
	 */
	protected AggregatedObservable modelProperty;

	/**
	 * 
	 * @param viewer
	 *        The observed ComboViewer
	 * @param modelProperty
	 *        The Model IObservable
	 */
	public ComboObservableValue(ComboViewer viewer, IObservableValue modelProperty) {
		this.viewer = viewer;
		viewer.setLabelProvider(new ComboLabelProvider(viewer.getLabelProvider()));
		if(modelProperty instanceof AggregatedObservable) {
			this.modelProperty = (AggregatedObservable)modelProperty;
		}
		viewer.addSelectionChangedListener(this);
	}

	public Object getValueType() {
		return Object.class;
	}

	@Override
	protected Object doGetValue() {
		ISelection selection = viewer.getSelection();
		if(!selection.isEmpty() && selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection)selection;
			Object firstElement = structuredSelection.getFirstElement();
			if(firstElement == UnsetObject.instance) {
				return null;
			}
			if(firstElement == UnchangedObject.instance) {
				return null;
			}
			return firstElement;
		}

		return null;
	}

	@Override
	protected void doSetValue(Object value) {
		currentValue = value;

		if(modelProperty != null && modelProperty.hasDifferentValues()) {
			viewer.setSelection(new StructuredSelection(UnchangedObject.instance));
		} else if(value == null) {
			viewer.setSelection(new StructuredSelection(UnsetObject.instance));
		} else {
			viewer.setSelection(new StructuredSelection(value));
		}
	}

	@Override
	public synchronized void dispose() {
		viewer.removeSelectionChangedListener(this);
		super.dispose();
	}

	public void selectionChanged(SelectionChangedEvent event) {
		if(((IStructuredSelection)event.getSelection()).getFirstElement() != UnchangedObject.instance) {

			final Object oldValue = currentValue;
			final Object newValue = doGetValue();
			currentValue = newValue;

			fireValueChange(new ValueDiff() {

				@Override
				public Object getOldValue() {
					return oldValue;
				}

				@Override
				public Object getNewValue() {
					return newValue;
				}

			});
		}
	}

}
