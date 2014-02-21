/**
 * Copyright (c) 2011 Mia-Software.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	Nicolas Guyomar (Mia-Software) - Bug 349546 - EMF Facet facetSet editor
 */
package org.eclipse.emf.facet.efacet.ui.internal.dialogs;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.facet.efacet.Query;
import org.eclipse.emf.facet.efacet.QuerySet;
import org.eclipse.emf.facet.efacet.catalog.efacetcatalog.QuerySetCatalog;
import org.eclipse.emf.facet.efacet.ui.internal.Activator;
import org.eclipse.emf.facet.util.emf.catalog.Catalog;
import org.eclipse.emf.facet.util.emf.core.ICatalogSetManager;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.dialogs.SelectionDialog;

@Deprecated
//TODO @Deprecated must be removed after a refactoring planed by https://bugs.eclipse.org/bugs/show_bug.cgi?id=364601
public class SelectQueryDialog extends SelectionDialog {

	private static final int SHELL_SIZE = 300;
	private Tree tree = null;
	private Query selectedQuery = null;

	public SelectQueryDialog(final Shell parent) {
		super(parent);
	}

	@Override
	public Object[] getResult() {
		return new Object[] { this.selectedQuery };
	}

	@Override
	protected void configureShell(final Shell shell) {
		shell.setSize(SelectQueryDialog.SHELL_SIZE, SelectQueryDialog.SHELL_SIZE);
		super.configureShell(shell);
	}

	@Override
	protected Control createDialogArea(final Composite parent) {
		Composite composite = (Composite) super.createDialogArea(parent);
		Font font = parent.getFont();
		composite.setFont(font);
		GridData gd = new GridData(SWT.FILL, SWT.FILL, false, false);
		this.tree = new Tree(composite, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		this.tree.setLayoutData(gd);
		EList<Catalog> catalogs = ICatalogSetManager.INSTANCE.getCatalogSet().getCatalogs();

		QuerySetCatalog querySetCatalog = null;
		for (Catalog catalog : catalogs) {
			if (catalog instanceof QuerySetCatalog) {
				querySetCatalog = (QuerySetCatalog) catalog;
				break;
			}
		}
		Image rootIcon = ImageDescriptor.createFromURL(Activator.getDefault().getBundle().getResource("icons/querySet.gif")).createImage(); //$NON-NLS-1$

		if (querySetCatalog != null) {

			for (QuerySet querySet : querySetCatalog.getInstalledQuerySets()) {
				TreeItem root = new TreeItem(this.tree, 0);
				root.setText(querySet.getName());
				root.setData(querySet);
				root.setImage(rootIcon);
				// see
				// http://dev.eclipse.org/viewcvs/viewvc.cgi/org.eclipse.swt.snippets/src/org/eclipse/swt/snippets/Snippet8.java?view=co
				// for this dummyTreeItem, it will be populated later in the listener
				@SuppressWarnings("unused")
				TreeItem dummyTreeItem = new TreeItem(root, 0);
			}
			this.tree.addListener(SWT.Expand, new Listener() {
				public void handleEvent(final Event event) {
					final TreeItem root = (TreeItem) event.item;
					TreeItem[] items = root.getItems();
					for (TreeItem item : items) {
						if (item.getData() != null) {
							return;
						}
						item.dispose();
					}
					QuerySet querySet = (QuerySet) root.getData();
					EList<Query> queries = querySet.getQueries();
					if (queries == null) {
						return;
					}

					for (Query query : queries) {
						TreeItem item = new TreeItem(root, 0);
						item.setText(query.getName());
						item.setData(query);
					}
				}
			});

			this.tree.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(final SelectionEvent e) {
					if (e.item instanceof TreeItem) {
						TreeItem treeItem = (TreeItem) e.item;
						if (treeItem.getData() instanceof Query) {
							setSelectedQuery((Query) treeItem.getData());
						}
					}
				}
			});
		}

		return composite;
	}

	protected void setSelectedQuery(final Query selectedQuery) {
		this.selectedQuery = selectedQuery;
	}
}
