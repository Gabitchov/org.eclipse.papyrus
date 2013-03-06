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
package org.eclipse.papyrus.views.validation.internal;

import static org.eclipse.papyrus.views.validation.internal.providers.InvertedViewerComparator.direction;
import static org.eclipse.papyrus.views.validation.internal.providers.InvertedViewerComparator.invert;

import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ColumnLayoutData;
import org.eclipse.jface.viewers.ColumnPixelData;
import org.eclipse.jface.viewers.ColumnViewerToolTipSupport;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.papyrus.views.validation.internal.actions.CopyMarkerAction;
import org.eclipse.papyrus.views.validation.internal.actions.DeleteMarkerAction;
import org.eclipse.papyrus.views.validation.internal.actions.GotoMarkerAction;
import org.eclipse.papyrus.views.validation.internal.actions.SelectAllAction;
import org.eclipse.papyrus.views.validation.internal.providers.DescriptionLabelProvider;
import org.eclipse.papyrus.views.validation.internal.providers.ElementLabelProvider;
import org.eclipse.papyrus.views.validation.internal.providers.InvertedViewerComparator;
import org.eclipse.papyrus.views.validation.internal.providers.PathLabelProvider;
import org.eclipse.papyrus.views.validation.internal.providers.ProblemLabelProvider;
import org.eclipse.papyrus.views.validation.internal.providers.ProblemsContentProvider;
import org.eclipse.papyrus.views.validation.internal.providers.SeverityLabelProvider;
import org.eclipse.papyrus.views.validation.internal.providers.TypeLabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.part.Page;

/**
 * This is the ModelValidationPage type. Enjoy.
 */
public class ModelValidationPage
		extends Page {

	private final ViewSettings settings;

	private ValidationMarkersService markers;

	private LabelProviderService labelProviders;

	private ModelSet modelSet;

	private Control control;

	private TableViewer table;

	private GotoMarkerAction gotoMarkerAction;

	private CopyMarkerAction copyMarkerAction;

	private DeleteMarkerAction deleteMarkerAction;

	private SelectAllAction selectAllAction;

	private boolean ready;

	public ModelValidationPage(ServicesRegistry services, ViewSettings settings)
			throws ServiceException {

		super();

		this.settings = settings;

		this.markers = ServiceUtils.getInstance().getService(
			ValidationMarkersService.class, services);
		this.labelProviders = ServiceUtils.getInstance().getService(
			LabelProviderService.class, services);
		this.modelSet = ServiceUtils.getInstance().getModelSet(services);
	}

	@Override
	public void dispose() {
		markers = null;
		modelSet = null;

		super.dispose();
	}

	@Override
	public void createControl(Composite parent) {
		Composite tableParent = new Composite(parent, SWT.NONE);
		control = tableParent;
		TableColumnLayout layout = new TableColumnLayout();
		tableParent.setLayout(layout);

		table = new TableViewer(tableParent, SWT.BORDER | SWT.V_SCROLL
			| SWT.H_SCROLL | SWT.FULL_SELECTION | SWT.MULTI);
		table.getTable().setHeaderVisible(true);
		table.getTable().setLinesVisible(true);
		table.setUseHashlookup(true);

		// the severity column has fixed width
		TableViewerColumn severity = new TableViewerColumn(table, SWT.NONE);
		layout.setColumnData(severity.getColumn(), new ColumnPixelData(24,
			false));
		severity.getColumn().setResizable(false);
		labels(severity, new SeverityLabelProvider());

		// the other columns are user-resizable
		labels(column(table, "Description"), new DescriptionLabelProvider());
		labels(column(table, "Element"), new ElementLabelProvider(modelSet));
		labels(column(table, "Path"), new PathLabelProvider(labelProviders));
		labels(column(table, "Type"), new TypeLabelProvider());

		ColumnViewerToolTipSupport.enableFor(table);

		table.setContentProvider(new ProblemsContentProvider());
		table.setInput(markers);

		table.addDoubleClickListener(new IDoubleClickListener() {

			public void doubleClick(DoubleClickEvent event) {
				if (gotoMarkerAction.isEnabled()) {
					gotoMarkerAction.run();
				}
			}
		});

		getSite().setSelectionProvider(table);

		createActions();
		createContextMenu();

		table.getControl().getDisplay().asyncExec(new Runnable() {

			public void run() {
				updateColumnWidth(-1);
			}
		});
	}

	private TableViewerColumn column(TableViewer table, String title) {
		TableViewerColumn result = new TableViewerColumn(table, SWT.NONE);
		result.getColumn().setText(title);

		TableColumnLayout layout = (TableColumnLayout) table.getControl()
			.getParent().getLayout();

		final int columnIndex = table.getTable().indexOf(result.getColumn());

		int width = settings.getColumnWidth(columnIndex);
		ColumnLayoutData layoutData;
		if (width < 0) {
			// it's a relative weight
			layoutData = new ColumnWeightData(-width, true);
		} else {
			layoutData = new ColumnPixelData(width, true);
		}
		layout.setColumnData(result.getColumn(), layoutData);

		result.getColumn().addListener(SWT.Resize, new Listener() {

			public void handleEvent(Event event) {
				updateColumnWidth(columnIndex);
			}
		});

		return result;
	}

	private TableViewerColumn labels(final TableViewerColumn col,
			ProblemLabelProvider labelProvider) {

		final TableViewer viewer = (TableViewer) col.getViewer();
		final ViewerComparator sorter = labelProvider.createSorter();
		final int columnIndex = viewer.getTable().indexOf(col.getColumn());

		col.setLabelProvider(labelProvider.createCellLabelProvider());
		col.getColumn().addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				ViewerComparator current = viewer.getComparator();

				if (InvertedViewerComparator.unwrap(current) == sorter) {
					// toggle the sort direction
					ViewerComparator newSorter = invert(current);
					viewer.setComparator(newSorter);

					int direction = direction(newSorter);
					viewer.getTable().setSortDirection(direction);
					settings.setSortDirection(direction);
				} else {
					viewer.setComparator(sorter);
					viewer.getTable().setSortColumn(col.getColumn());
					viewer.getTable().setSortDirection(SWT.UP);

					settings.setSortColumn(columnIndex);
					settings.setSortDirection(SWT.UP);
				}
			}
		});

		if (settings.getSortColumn() == columnIndex) {
			int direction = settings.getSortDirection();
			viewer.setComparator(direction == SWT.UP
				? sorter
				: invert(sorter));
			viewer.getTable().setSortColumn(col.getColumn());
			viewer.getTable().setSortDirection(direction);
		}

		return col;
	}

	private void createContextMenu() {
		MenuManager contextMenu = new MenuManager();
		contextMenu.setRemoveAllWhenShown(true);
		contextMenu.addMenuListener(new IMenuListener() {

			public void menuAboutToShow(IMenuManager manager) {
				fillContextMenu(manager);
			}
		});

		Menu menu = contextMenu.createContextMenu(table.getControl());
		table.getControl().setMenu(menu);

		getSite().registerContextMenu(ModelValidationView.VIEW_ID, contextMenu,
			table);
	}

	protected void createActions() {
		final ISelectionProvider selectionProvider = getSite()
			.getSelectionProvider();

		gotoMarkerAction = new GotoMarkerAction(getSite());
		selectionProvider.addSelectionChangedListener(gotoMarkerAction);
		copyMarkerAction = new CopyMarkerAction(getSite());
		selectionProvider.addSelectionChangedListener(copyMarkerAction);
		deleteMarkerAction = new DeleteMarkerAction(getSite());
		selectionProvider.addSelectionChangedListener(deleteMarkerAction);
		selectAllAction = new SelectAllAction(getSite());

		final IActionBars actionBars = getSite().getActionBars();
		actionBars.setGlobalActionHandler(ActionFactory.COPY.getId(),
			copyMarkerAction);
		actionBars.setGlobalActionHandler(ActionFactory.DELETE.getId(),
			deleteMarkerAction);
		actionBars.setGlobalActionHandler(ActionFactory.SELECT_ALL.getId(),
			selectAllAction);
	}

	protected void fillContextMenu(IMenuManager menu) {
		menu.add(gotoMarkerAction);
		menu.add(copyMarkerAction);
		menu.add(deleteMarkerAction);
		menu.add(selectAllAction);

		menu.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
	}

	@Override
	public Control getControl() {
		return control;
	}

	@Override
	public void setFocus() {
		// pass
	}

	private void updateColumnWidth(int index) {
		if ((index >= 0) != ready) {
			return;
		}

		if (index < 0) {
			// initialization step: normalize all of the layout data to pixels
			ready = true;

			final int startIndex = 1; // the severity column is not resizable
			TableColumn[] columns = table.getTable().getColumns();
			Composite parent = table.getTable().getParent();
			TableColumnLayout layout = (TableColumnLayout) parent.getLayout();

			// store the widths
			for (int i = startIndex; i < columns.length; i++) {
				settings.setColumnWidth(i, columns[i].getWidth());
			}

			// apply to the columns
			for (int i = startIndex; i < columns.length; i++) {
				layout.setColumnData(columns[i],
					new ColumnPixelData(settings.getColumnWidth(i)));
			}

			// discover the new layout data
			parent.layout();
		} else {
			// update the settings for next time
			settings.setColumnWidth(index, table.getTable().getColumn(index)
				.getWidth());
		}
	}
}
