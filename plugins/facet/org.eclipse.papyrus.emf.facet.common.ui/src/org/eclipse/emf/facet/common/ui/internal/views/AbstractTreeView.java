/*******************************************************************************
 * Copyright (c) 2010 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Nicolas Bros (Mia-Software) - initial API and implementation
 *    Nicolas Bros (Mia-Software) - Bug 334116 - common tree view with columns
 *******************************************************************************/

package org.eclipse.emf.facet.common.ui.internal.views;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.facet.common.ui.internal.Activator;
import org.eclipse.emf.facet.common.ui.internal.controls.PersistableColumn;
import org.eclipse.emf.facet.util.core.Logger;
import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.IOpenListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.OpenEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.ViewPart;

/** An abstract Eclipse view that displays a list of elements. */
public abstract class AbstractTreeView extends ViewPart {

	private final List<PersistableColumn> columns = new ArrayList<PersistableColumn>();
	private final Map<String, Integer> persistedValues = new HashMap<String, Integer>();

	private static final int JOB_SCHEDULE_DELAY = 500;
	private Job fRefreshJob = null;

	private TreeViewer fTreeViewer;

	public TreeViewer getViewer() {
		return this.fTreeViewer;
	}

	@Override
	public void createPartControl(final Composite parent) {
		parent.setLayout(new FillLayout());

		this.fTreeViewer = new TreeViewer(parent, SWT.H_SCROLL | SWT.V_SCROLL | SWT.SINGLE
				| SWT.FULL_SELECTION);
		this.fTreeViewer.getTree().setLinesVisible(true);
		this.fTreeViewer.getTree().setHeaderVisible(true);

		this.fTreeViewer.addOpenListener(new IOpenListener() {
			public void open(final OpenEvent event) {
				IStructuredSelection selection = (IStructuredSelection) AbstractTreeView.this
						.getViewer().getSelection();
				openElement(selection.getFirstElement());
			}
		});

		createColumns();

		this.fTreeViewer.setContentProvider(getContentProvider());

		createContextMenu();
		getSite().setSelectionProvider(this.fTreeViewer);
		refresh(false);
	}

	protected void createContextMenu() {
		final MenuManager contextMenu = new MenuManager("#PopUp"); //$NON-NLS-1$
		contextMenu.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
		final Menu menu = contextMenu.createContextMenu(getViewer().getControl());
		getViewer().getControl().setMenu(menu);
		getSite().registerContextMenu(contextMenu, getViewer());
	}

	protected abstract void createColumns();

	protected abstract IContentProvider getContentProvider();

	protected abstract void openElement(Object element);

	@Override
	public void setFocus() {
		this.fTreeViewer.getControl().setFocus();
	}

	/** Optionally delayed refresh */
	protected void refresh(final boolean delayed) {
		if (this.fRefreshJob == null) {
			this.fRefreshJob = new Job(getRefreshMessage()) {
				@Override
				protected IStatus run(final IProgressMonitor monitor) {
					doRefresh();
					return Status.OK_STATUS;
				}
			};
		}
		// delayed until it stops changing
		this.fRefreshJob.cancel();
		if (delayed) {
			this.fRefreshJob.setPriority(Job.DECORATE);
			this.fRefreshJob.schedule(AbstractTreeView.JOB_SCHEDULE_DELAY);
		} else {
			this.fRefreshJob.setPriority(Job.INTERACTIVE);
			this.fRefreshJob.schedule();
		}
	}

	protected abstract String getRefreshMessage();

	protected abstract Object getInput();

	protected void doRefresh() {
		// Accesses the catalog, which can block if done inside the UI thread.
		final Object input = getInput();
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				getViewer().setInput(input);
				getViewer().refresh();
			}
		});
	}

	protected void createColumn(final String columnText, final String uniqueID,
			final int defaultWidth, final ColumnLabelProvider columnLabelProvider) {
		PersistableColumn persistableColumn = new PersistableColumn(columnText, uniqueID,
				defaultWidth, columnLabelProvider, this.fTreeViewer);
		this.columns.add(persistableColumn);
		Integer width = this.persistedValues.get(uniqueID);
		if (width != null) {
			persistableColumn.setWidth(width.intValue());
		}
	}

	@Override
	public void saveState(final IMemento memento) {
		super.saveState(memento);
		try {
			for (PersistableColumn column : this.columns) {
				column.saveState(memento);
			}
		} catch (Exception e) {
			Logger.logError(e, "Error saving view state", Activator.getDefault()); //$NON-NLS-1$
		}
	}

	@Override
	public void init(final IViewSite site, final IMemento memento) throws PartInitException {
		super.init(site, memento);
		if (memento != null) {
			String[] attributeKeys = memento.getAttributeKeys();
			for (String key : attributeKeys) {
				this.persistedValues.put(key, memento.getInteger(key));
			}
		}
	}
}
