/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Juan Cadavid (CEA LIST) juan.cadavid@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.dialog;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.nebula.widgets.nattable.config.IConfigRegistry;
import org.eclipse.papyrus.infra.nattable.messages.Messages;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.IAxis;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.AbstractAxisProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

/**
 * This dialog displays in a table the axis providers stored in a table's historic. It allows to choose one of them.
 * 
 */
public class LoadCurrentAxisProvidersDialog extends Dialog {

	private TableViewer viewer;

	private EList<AbstractAxisProvider> iAxisProvidersHistory;

	private final AbstractAxisProvider currentColumnAxisProvider;

	private AbstractAxisProvider selectedAxisProvider;

	private ILabelProvider labelProvider;

	private IConfigRegistry registry;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param parentShell
	 * @param iAxisProvidersHistory
	 * @param currentColumnAxisProvider
	 * @param registry
	 */
	public LoadCurrentAxisProvidersDialog(Shell parentShell, EList<AbstractAxisProvider> iAxisProvidersHistory, AbstractAxisProvider currentColumnAxisProvider, IConfigRegistry registry) {
		super(parentShell);
		this.iAxisProvidersHistory = iAxisProvidersHistory;
		this.currentColumnAxisProvider = currentColumnAxisProvider;
		this.registry = registry;
	}

	/**
	 * Create the dialog.
	 * 
	 * @see org.eclipse.jface.dialogs.Dialog#createDialogArea(org.eclipse.swt.widgets.Composite)
	 * 
	 * @param parent
	 * @return
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		final Composite composite = (Composite)super.createDialogArea(parent);
		GridLayout layout = new GridLayout(1, false);
		composite.setLayout(layout);
		viewer = new TableViewer(composite, (SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER));
		int[] bounds = { 300, 400, 400 };
		String[] titles = { Messages.LoadCurrentAxisProvidersDialog_0, Messages.LoadCurrentAxisProvidersDialog_1, Messages.LoadCurrentAxisProvidersDialog_2 };

		TableViewerColumn colName = createTableViewerColumn(titles[0], bounds[0], 0, viewer);
		colName.setLabelProvider(new ColumnLabelProvider() {

			@Override
			public String getText(Object element) {
				AbstractAxisProvider provider = (AbstractAxisProvider)element;
				String text = provider.getName();
				if(currentColumnAxisProvider.equals(element)) {
					text += Messages.LoadCurrentAxisProvidersDialog_3;
				}
				return text;
			}

			@Override
			public Font getFont(Object element) {
				Font font = super.getFont(element);

				return font;
			}

		});
		TableViewerColumn colDescription = createTableViewerColumn(titles[1], bounds[1], 1, viewer);
		colDescription.setLabelProvider(new ColumnLabelProvider() {

			@Override
			public String getText(Object element) {
				AbstractAxisProvider provider = (AbstractAxisProvider)element;
				return provider.getDescription();
			}
		});
		TableViewerColumn colColumns = createTableViewerColumn(titles[2], bounds[2], 2, viewer);
		colColumns.setLabelProvider(new ColumnLabelProvider() {

			@Override
			public String getText(Object element) {
				AbstractAxisProvider provider = (AbstractAxisProvider)element;
				String text = ""; //$NON-NLS-1$
				for(IAxis axis : provider.getAxis()) {
					final Object representedElement = axis.getElement();
					//					ILabelProviderContextElement contextEl = new LabelProviderContextElement(axis, registry);
					//					LabelProviderService labelProvider = (ILabelProvider)registry.getConfigAttribute(NattableConfigAttributes.LABEL_PROVIDER_SERVICE_CONFIG_ATTRIBUTE, DisplayMode.NORMAL, NattableConfigAttributes.LABEL_PROVIDER_SERVICE_ID);
					if(labelProvider != null) {
						//						text += labelProvider.getText(contextEl) + ", ";
					} else {
						if(representedElement instanceof ENamedElement) {
							text += ((ENamedElement)representedElement).getName() + ", "; //$NON-NLS-1$
						} else {
							final String string = representedElement.toString();
							text += string.substring(string.lastIndexOf("::") + 2) + ", "; //$NON-NLS-1$ //$NON-NLS-2$
						}
					}
				}
				//We cut the remaining comma and space
				if(!text.isEmpty()) {
					text = text.substring(0, text.length() - 2);
				}
				return text;
			}
		});
		final Table table = viewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		viewer.setContentProvider(new ArrayContentProvider());
		viewer.setInput(iAxisProvidersHistory);

		//We add the listener for the selection
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				StructuredSelection selection = (StructuredSelection)event.getSelection();
				setSelectedAxisProvider(selection.getFirstElement());
			}

		});
		viewer.addDoubleClickListener(new IDoubleClickListener() {

			@Override
			public void doubleClick(DoubleClickEvent event) {
				StructuredSelection selection = (StructuredSelection)event.getSelection();
				setSelectedAxisProvider(selection.getFirstElement());
				close();
			}
		});

		viewer.refresh();
		return composite;
	}

	/**
	 * Set the axis provider selected by the user.
	 * 
	 * @param firstElement
	 */
	private void setSelectedAxisProvider(Object firstElement) {
		selectedAxisProvider = (AbstractAxisProvider)firstElement;
	}


	/**
	 * Getter for the selected provider
	 * 
	 * @return
	 */
	public AbstractAxisProvider getSelectedAxisProvider() {
		return selectedAxisProvider;
	}


	/**
	 * Create columns
	 * 
	 * @param title
	 * @param bound
	 * @param colNumber
	 * @param viewer
	 * @return
	 */
	private TableViewerColumn createTableViewerColumn(String title, int bound, final int colNumber, TableViewer viewer) {
		final TableViewerColumn viewerColumn = new TableViewerColumn(viewer, SWT.NONE);
		final TableColumn column = viewerColumn.getColumn();
		column.setText(title);
		column.setWidth(bound);
		column.setResizable(true);
		column.setMoveable(true);
		return viewerColumn;
	}

	/**
	 * Set a label provider to show labels for each one of the axis of every axis provider
	 * 
	 * @param labelProvider
	 */
	public void setLabelProvider(ILabelProvider labelProvider) {
		this.labelProvider = labelProvider;
	}

}
