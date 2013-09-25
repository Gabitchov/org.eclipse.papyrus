/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.cdo.internal.ui.widgets;

import java.util.Iterator;
import java.util.List;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.actions.BaseSelectionListenerAction;

import com.google.common.collect.Lists;


/**
 * An encapsulation of a SWT {@code Button} that invokes an arbitrary pre-defined {@linkplain IAction UI action} when selected (pushed/checked/etc).
 * For actions that are not {@code BaseSelectionListenerAction}s, an {@linkplain ISelectionAdapter adapter} is required to push the selection
 * changes in {@linkplain #attach(StructuredViewer) attached viewers} to the action to determine its enablement and the object on which it operates.
 */
public class ActionButton {

	private final SelectionWrapper selection;

	private final IAction action;

	private final String label;

	private final int style;

	private Button button;

	private List<StructuredViewer> dependentViewers;

	private ISelectionChangedListener selectionListener;

	public ActionButton(final String label, BaseSelectionListenerAction action, int style) {
		this(label, action, new DefaultSelectionAdapter(action), style);
	}

	public ActionButton(final String label, IAction action, ISelectionAdapter selectionAdapter, int style) {
		this.selection = new SelectionWrapper(selectionAdapter);
		this.action = action;
		this.label = label;
		this.style = style;
	}

	public Button createControl(Composite parent) {
		button = new Button(parent, style);
		button.setText(label);

		button.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				action.run();
				refreshViewers(selection.getSelection());
			}
		});

		button.setEnabled(action.isEnabled());

		button.addDisposeListener(new DisposeListener() {

			public void widgetDisposed(DisposeEvent e) {
				dispose();
			}
		});

		return button;
	}

	public void attach(StructuredViewer viewer) {
		if(dependentViewers == null) {
			dependentViewers = Lists.newArrayListWithExpectedSize(1);
			dependentViewers.add(viewer);
			viewer.addSelectionChangedListener(getSelectionListener());
		} else if(!dependentViewers.contains(viewer)) {
			dependentViewers.add(viewer);
			viewer.addSelectionChangedListener(getSelectionListener());
		}
	}

	private void refreshViewers(IStructuredSelection objectsToUpdate) {
		if(dependentViewers != null) {
			for(StructuredViewer next : dependentViewers) {
				for(Iterator<?> iter = objectsToUpdate.iterator(); iter.hasNext();) {
					next.refresh(iter.next());
				}
			}
		}
	}

	private ISelectionChangedListener getSelectionListener() {
		if(selectionListener == null) {
			selectionListener = new ISelectionChangedListener() {

				public void selectionChanged(SelectionChangedEvent event) {
					selection.selectionChanged((IStructuredSelection)event.getSelection());
					if(button != null) {
						button.setEnabled(action.isEnabled());
					}
				}
			};
		}

		return selectionListener;
	}

	private void dispose() {
		if((dependentViewers != null) && (selectionListener != null)) {
			for(StructuredViewer next : dependentViewers) {
				next.removeSelectionChangedListener(selectionListener);
			}
		}

		dependentViewers = null;
		selectionListener = null;
	}

	//
	// Nested types
	//

	public static interface ISelectionAdapter {

		void selectionChanged(IStructuredSelection selection);
	}

	private static final class DefaultSelectionAdapter implements ISelectionAdapter {

		private final BaseSelectionListenerAction action;

		DefaultSelectionAdapter(BaseSelectionListenerAction action) {
			this.action = action;
		}

		public void selectionChanged(IStructuredSelection selection) {
			action.selectionChanged(selection);
		}
	}

	private static final class SelectionWrapper implements ISelectionAdapter {

		private final ISelectionAdapter adapter;

		private IStructuredSelection selection;

		SelectionWrapper(ISelectionAdapter adapter) {
			this.adapter = adapter;
		}

		public void selectionChanged(IStructuredSelection selection) {
			// stash the selection
			this.selection = selection;

			// delegate
			adapter.selectionChanged(selection);
		}

		IStructuredSelection getSelection() {
			return selection;
		}
	}
}
