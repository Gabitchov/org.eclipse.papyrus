/*******************************************************************************
 * Copyright (c) 2011 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Nicolas Bros (Mia-Software) - initial API and implementation
 *    Nicolas Bros (Mia-Software) - Bug 334116 - common tree view with columns
 *******************************************************************************/
package org.eclipse.papyrus.emf.facet.common.ui.internal.controls;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerColumn;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.papyrus.emf.facet.common.ui.internal.controls.wrappers.Column;
import org.eclipse.papyrus.emf.facet.common.ui.internal.controls.wrappers.SortableTable;
import org.eclipse.papyrus.emf.facet.common.ui.internal.controls.wrappers.SortableTree;
import org.eclipse.papyrus.emf.facet.common.ui.internal.controls.wrappers.SortableWidget;
import org.eclipse.papyrus.emf.facet.common.ui.internal.controls.wrappers.SortableWidgetFactory;
import org.eclipse.papyrus.emf.facet.common.ui.internal.controls.wrappers.TableColumn;
import org.eclipse.papyrus.emf.facet.common.ui.internal.controls.wrappers.TreeColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.part.ViewPart;

/**
 * A column in a {@link TreeViewer} or {@link TableViewer} that is sortable (using the given
 * {@link ColumnLabelProvider}) and can save its width to an {@link IMemento}.
 */
public class PersistableColumn {

	/**
	 * Saved column widths, static because we want to be able to save column widths during the
	 * session (if a view is closed and re-opened), instead of only when the workbench is closed
	 * (which is the case with {@link ViewPart#saveState(org.eclipse.ui.IMemento)})
	 */
	private static final Map<String, Integer> COLUMN_WIDTHS = new HashMap<String, Integer>();

	/** The unique id associated to this column */
	private String fUniqueID;

	/** The underlying JFace column */
	private final ViewerColumn fViewerColumn;

	private Column getColumn() {
		if (this.fViewerColumn instanceof TreeViewerColumn) {
			TreeViewerColumn treeViewerColumn = (TreeViewerColumn) this.fViewerColumn;
			return new TreeColumn(treeViewerColumn.getColumn());
		} else if (this.fViewerColumn instanceof TableViewerColumn) {
			TableViewerColumn tableViewerColumn = (TableViewerColumn) this.fViewerColumn;
			return new TableColumn(tableViewerColumn.getColumn());
		}
		throw new IllegalStateException("neither a table nor tree column"); //$NON-NLS-1$
	}

	/**
	 * Initialize a sortable column that can be persisted to an {@link IMemento} .
	 * 
	 * @param columnText
	 *            the title of the column
	 * @param uniqueID
	 *            a unique id used to persist the column width
	 * @param defaultWidth
	 *            the width to use if no previous information was saved
	 * @param columnLabelProvider
	 *            the label provider for this column
	 */
	protected void init(final String columnText, final String uniqueID, final int defaultWidth,
			final ColumnLabelProvider columnLabelProvider) {
		this.fUniqueID = uniqueID;
		final Column column = getColumn();
		column.setText(columnText);

		Integer width = PersistableColumn.getColumnWidths().get(uniqueID);
		if (width != null) {
			column.setWidth(width.intValue());
		} else {
			column.setWidth(defaultWidth);
		}
		column.addControlListener(new ControlAdapter() {
			@Override
			public void controlResized(final ControlEvent e) {
				PersistableColumn.getColumnWidths().put(uniqueID, new Integer(column.getWidth()));
			}
		});

		this.fViewerColumn.setLabelProvider(columnLabelProvider);
	}

	/**
	 * Create a sortable column that can be persisted to an {@link IMemento}.
	 * 
	 * @param columnText
	 *            the title of the column
	 * @param uniqueID
	 *            a unique id used to persist the column width
	 * @param defaultWidth
	 *            the width to use if no previous information was saved
	 * @param columnLabelProvider
	 *            the label provider for this column
	 * @param treeViewer
	 *            the {@link TreeViewer} in which to create the column
	 */
	public PersistableColumn(final String columnText, final String uniqueID,
			final int defaultWidth, final ColumnLabelProvider columnLabelProvider,
			final TreeViewer treeViewer) {
		TreeViewerColumn treeViewerColumn = new TreeViewerColumn(treeViewer, SWT.NONE);
		this.fViewerColumn = treeViewerColumn;
		init(columnText, uniqueID, defaultWidth, columnLabelProvider);

		addSorter(new TreeColumn(treeViewerColumn.getColumn()),
				getViewerSorter(columnLabelProvider), new SortableTree(treeViewer));
	}

	/**
	 * Create a sortable column that can be persisted to an {@link IMemento}.
	 * 
	 * @param columnText
	 *            the title of the column
	 * @param uniqueID
	 *            a unique id used to persist the column width
	 * @param defaultWidth
	 *            the width to use if no previous information was saved
	 * @param columnLabelProvider
	 *            the label provider for this column
	 * @param tableViewer
	 *            the {@link TableViewer} in which to create the column
	 */
	public PersistableColumn(final String columnText, final String uniqueID,
			final int defaultWidth, final ColumnLabelProvider columnLabelProvider,
			final TableViewer tableViewer) {
		TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		this.fViewerColumn = tableViewerColumn;
		init(columnText, uniqueID, defaultWidth, columnLabelProvider);

		addSorter(new TableColumn(tableViewerColumn.getColumn()),
				getViewerSorter(columnLabelProvider), new SortableTable(tableViewer));
	}

	private static ViewerSorter getViewerSorter(final ColumnLabelProvider columnLabelProvider) {
		return new ViewerSorter() {
			@Override
			public int compare(final Viewer viewer, final Object e1, final Object e2) {
				String text1 = columnLabelProvider.getText(e1);
				String text2 = columnLabelProvider.getText(e2);
				if (text1 == null) {
					return -1;
				}
				int compare = text1.compareTo(text2);
				SortableWidget sortableWidget = SortableWidgetFactory.createSortableWidget(viewer);
				if (sortableWidget.getSortDirection() == SWT.DOWN) {
					compare = compare * -1;
				}
				return compare;
			}
		};
	}

	private static void addSorter(final Column column, final ViewerSorter viewerSorter,
			final SortableWidget sortableWidget) {
		column.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				sortableWidget.setSorter(viewerSorter);
				sortableWidget.setSortColumn(column);
				if (sortableWidget.getSortDirection() == SWT.UP) {
					sortableWidget.setSortDirection(SWT.DOWN);
				} else if (sortableWidget.getSortDirection() == SWT.DOWN) {
					sortableWidget.setSortDirection(SWT.UP);
				} else {
					sortableWidget.setSortDirection(SWT.UP);
				}
				sortableWidget.refresh();
			}
		});
	}

	public void saveState(final IMemento memento) {
		Integer width = PersistableColumn.getColumnWidths().get(this.fUniqueID);
		if (width != null) {
			memento.putInteger(this.fUniqueID, width.intValue());
		}
	}

	/**
	 * Loads the saved state from the given {@link IMemento}. Columns created using the given id
	 * after this call will have their width set to the value that was loaded.
	 */
	public static void loadState(final IMemento memento, final String columnID) {
		Integer width = memento.getInteger(columnID);
		if (width != null) {
			PersistableColumn.getColumnWidths().put(columnID, width);
		}
	}

	public void setWidth(final int width) {
		getColumn().setWidth(width);
	}

	protected static Map<String, Integer> getColumnWidths() {
		return PersistableColumn.COLUMN_WIDTHS;
	}
}
