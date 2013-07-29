/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.dialogs;

import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

/**
 * This abstract class allows to create columns with a tree viewer. A double
 * Click on an element of the tree allows to expand/collapse the node!
 * 
 * 
 */
public abstract class AbstractCheckedTreeColumnViewerSelectionDialog extends CustomCheckedTreeSelectionDialog {

	/** the number of columns */
	private int nbColumns = 0;

	/** the title of the columns */
	private String[] columnTitles = null;

	/** the width of the columns */
	private int[] columnWidths = null;

	/** the label provider for the columns */
	private CellLabelProvider[] columnCellLabelProvider;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param parent
	 *        the parent shell
	 * @param labelProvider
	 *        the label provider for the tree
	 * @param contentProvider
	 *        the content provider for the tree
	 * @param style
	 *        the style for the viewer
	 * @param nbColumns
	 *        the nomber of columns
	 */
	public AbstractCheckedTreeColumnViewerSelectionDialog(Shell parent, ILabelProvider labelProvider, ITreeContentProvider contentProvider, int style, int nbColumns) {
		super(parent, labelProvider, contentProvider, style);
		this.nbColumns = nbColumns;
		setSize(100, 20);

	}

	/**
	 * Setter for {@link #columnWidths}
	 * 
	 * @param widths
	 *        The array owning the widths of the columns
	 */
	public void setColumnWidths(int[] widths) {
		Assert.isTrue(widths.length == nbColumns);
		this.columnWidths = widths;
	}

	/**
	 * Setter for {@link #columnTitles}
	 * 
	 * @param titles
	 *        the titles of the columns
	 */
	public void setColumnTitles(String[] titles) {
		Assert.isTrue(titles.length == nbColumns);
		this.columnTitles = titles;
	}

	/**
	 * Setter for {@link #columnCellLabelProvider}
	 * 
	 * @param providers
	 *        the labels providers for the columns
	 */
	public void setColumnCellLabelProvider(CellLabelProvider[] providers) {
		Assert.isTrue(providers.length == nbColumns);
		this.columnCellLabelProvider = providers;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.common.dialogs.CustomCheckedTreeSelectionDialog#createDialogArea(org.eclipse.swt.widgets.Composite)
	 * 
	 * @param parent
	 * @return
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Control ctrl = super.createDialogArea(parent);
		for(int i = 0; i < nbColumns; i++) {
			TreeViewerColumn column = new TreeViewerColumn(getTreeViewer(), SWT.NONE);
			column.getColumn().setText(columnTitles[i]);
			column.getColumn().setWidth(columnWidths[i]);
			column.setLabelProvider(columnCellLabelProvider[i]);
			EditingSupport support = getEditingSupport(i);
			if(support != null) {
				column.setEditingSupport(support);
			}
		}

		getTreeViewer().getTree().setLinesVisible(true);
		getTreeViewer().getTree().setHeaderVisible(true);
		getTreeViewer().getTree().addMouseListener(new MouseListener() {

			/**
			 * 
			 * @see org.eclipse.swt.events.MouseListener#mouseUp(org.eclipse.swt.events.MouseEvent)
			 * 
			 * @param e
			 */
			public void mouseUp(MouseEvent e) {
				// nothing to do
			}

			/**
			 * 
			 * @see org.eclipse.swt.events.MouseListener#mouseDown(org.eclipse.swt.events.MouseEvent)
			 * 
			 * @param e
			 */
			public void mouseDown(MouseEvent e) {
				// nothing to do

			}

			/**
			 * 
			 * @see org.eclipse.swt.events.MouseListener#mouseDoubleClick(org.eclipse.swt.events.MouseEvent)
			 * 
			 * @param e
			 */
			public void mouseDoubleClick(MouseEvent e) {
				// we expand the selected element
				Tree source = (Tree)e.getSource();
				TreeItem[] item = source.getSelection();
				List<?> expandedElements = Arrays.asList(getTreeViewer().getExpandedElements());
				if(getTreeViewer().isExpandable(item[0].getData())) {
					boolean isExpanded = expandedElements.contains(item[0].getData());
					item[0].setExpanded(!isExpanded);
				}
			}
		});
		return ctrl;
	}

	/**
	 * Returns the {@link EditingSupport} for the column.
	 * 
	 * @param columnIndex
	 * @return the {@link EditingSupport} for the column or <code>null</code>
	 */
	abstract protected EditingSupport getEditingSupport(int columnIndex);
}
