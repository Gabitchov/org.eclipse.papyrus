/*******************************************************************************
 * Copyright (c) 2010-2012 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Nicolas Bros (Mia-Software) - initial API and implementation
 *    Nicolas Bros (Mia-Software) - Bug 334116 - common tree view with columns
 *    Nicolas Bros (Mia-Software) - Bug 372732 - [Facet] Rewrite the catalog views for 0.2
 *******************************************************************************/
package org.eclipse.emf.facet.common.ui.internal.views;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.facet.common.ui.internal.Activator;
import org.eclipse.emf.facet.common.ui.internal.Messages;
import org.eclipse.emf.facet.common.ui.internal.controls.PersistableColumn;
import org.eclipse.emf.facet.common.ui.internal.exported.views.IColumnDescription;
import org.eclipse.emf.facet.util.core.Logger;
import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.IOpenListener;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.OpenEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.ViewPart;

public class ElementsView extends ViewPart {

	private static final int JOB_SCHEDULE_DELAY = 500;
	private final Collection<? extends IColumnDescription> columnDescriptions;
	private final ITreeContentProvider contentProvider;
	private final Object input;
	private final List<PersistableColumn> columns = new ArrayList<PersistableColumn>();
	private final Map<String, Integer> persistedValues = new HashMap<String, Integer>();
	private TreeViewer treeViewer;
	private Job refreshJob = null;
	private final IOpenListener openListener;
	private final String title;
	private final Image titleImage;

	public ElementsView(final Collection<? extends IColumnDescription> columnDescriptions,
			final ITreeContentProvider contentProvider, final Object input, final String title, final Image titleImage, final IOpenListener openListener) {
		this.columnDescriptions = columnDescriptions;
		this.contentProvider = contentProvider;
		this.input = input;
		this.title = title;
		this.titleImage = titleImage;
		this.openListener = openListener;
	}

	public TreeViewer getViewer() {
		return this.treeViewer;
	}

	@Override
	public void createPartControl(final Composite parent) {
		setPartName(this.title);
		setTitleImage(this.titleImage);
		parent.setLayout(new FillLayout());

		this.treeViewer = new TreeViewer(parent, SWT.H_SCROLL | SWT.V_SCROLL | SWT.SINGLE
				| SWT.FULL_SELECTION);
		this.treeViewer.getTree().setLinesVisible(true);
		this.treeViewer.getTree().setHeaderVisible(true);

		this.treeViewer.addOpenListener(new IOpenListener() {
			public void open(final OpenEvent event) {
				ElementsView.this.open(event);
			}
		});

		createColumns();
		this.treeViewer.setContentProvider(getContentProvider());
		createContextMenu();
		getSite().setSelectionProvider(this.treeViewer);
		refresh(false);
	}

	protected void createContextMenu() {
		final MenuManager contextMenu = new MenuManager("#PopUp"); //$NON-NLS-1$
		contextMenu.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
		final Menu menu = contextMenu.createContextMenu(getViewer().getControl());
		getViewer().getControl().setMenu(menu);
		getSite().registerContextMenu(contextMenu, getViewer());
	}

	protected void createColumns() {
		for (IColumnDescription columnDescription : this.columnDescriptions) {
			createColumn(columnDescription.getTitle(), columnDescription.getUniqueID(),
					columnDescription.getDefaultWidth(), columnDescription.getColumnLabelProvider());
		}
	}

	protected IContentProvider getContentProvider() {
		return this.contentProvider;
	}

	protected void open(final OpenEvent event) {
		if (this.openListener != null) {
			this.openListener.open(event);
		}
	}

	@Override
	public void setFocus() {
		this.treeViewer.getControl().setFocus();
	}

	/** Optionally delayed refresh */
	protected void refresh(final boolean delayed) {
		if (this.refreshJob == null) {
			this.refreshJob = new Job(getRefreshMessage()) {
				@Override
				protected IStatus run(final IProgressMonitor monitor) {
					doRefresh();
					return Status.OK_STATUS;
				}
			};
		}
		// delayed until it stops changing
		this.refreshJob.cancel();
		if (delayed) {
			this.refreshJob.setPriority(Job.DECORATE);
			this.refreshJob.schedule(ElementsView.JOB_SCHEDULE_DELAY);
		} else {
			this.refreshJob.setPriority(Job.INTERACTIVE);
			this.refreshJob.schedule();
		}
	}

	protected String getRefreshMessage() {
		return NLS.bind(Messages.ElementsView_refreshJobTitle, this.title);
	}

	protected Object getInput() {
		return this.input;
	}

	protected void doRefresh() {
		// Accesses the catalog, which can block if done inside the UI thread.
		final Object viewerInput = getInput();
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				getViewer().setInput(viewerInput);
				getViewer().refresh();
			}
		});
	}

	protected void createColumn(final String columnText, final String uniqueID,
			final int defaultWidth, final ColumnLabelProvider columnLabelProvider) {
		PersistableColumn persistableColumn = new PersistableColumn(columnText, uniqueID,
				defaultWidth, columnLabelProvider, this.treeViewer);
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
