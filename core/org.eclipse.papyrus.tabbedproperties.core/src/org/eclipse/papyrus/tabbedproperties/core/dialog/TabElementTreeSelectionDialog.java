/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
  *****************************************************************************/
package org.eclipse.papyrus.tabbedproperties.core.dialog;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.AbstractTreeViewer;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.papyrus.core.editor.BackboneContext;
import org.eclipse.papyrus.core.utils.DiResourceSet;
import org.eclipse.papyrus.tabbedproperties.core.filters.InModelFilter;
import org.eclipse.papyrus.tabbedproperties.core.filters.InProfileFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.FilteredTree;
import org.eclipse.ui.dialogs.PatternFilter;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;

/**
 * this class display a dialog box to look for element like {@link ElementTreeSelectionDialog} but some tabs arre added: resources about models, resources about profile, and all resources.
 * 
 * @author Patrick Tessier
 * 
 */
public class TabElementTreeSelectionDialog extends ElementTreeSelectionDialog {

	/**
	 * constructor of a {@link TabElementTreeSelectionDialog}
	 * 
	 * @param parent
	 *            the composite parent
	 * @param umlparent
	 *            the element parent the nwe value will be associated
	 * @param backboneContext
	 *            the context
	 * @param filters
	 *            the list of filter to look for in a model
	 * @param title
	 *            the the name of tool box
	 * @param createElement
	 *            the listenr to create an element
	 * @param abstractElement
	 *            used to know of the element that we look for is anstract, in this case the button is not created
	 */
	public TabElementTreeSelectionDialog(Shell parent, Element umlparent, BackboneContext backboneContext, ViewerFilter[] filters, String title, MouseListener createElement, boolean abstractElement) {
		super(parent, umlparent, backboneContext, filters, title, createElement, abstractElement);

	}

	/**
	 * {@inheritDoc}
	 */
	protected Control createDialogArea(Composite parent) {
		final CTabFolder tabFolder = new CTabFolder(parent, SWT.BORDER);
		tabFolder.setMaximized(true);

		CTabItem tabItem = new CTabItem(tabFolder, SWT.NULL);
		tabItem.setText("Model Resources");
		tabItem.setControl(fillModelpage(tabFolder, new InModelFilter()));

		tabItem = new CTabItem(tabFolder, SWT.NULL);
		tabItem.setText("Profile Resources");
		tabItem.setControl(fillModelpage(tabFolder, new InProfileFilter()));

		tabItem = new CTabItem(tabFolder, SWT.NULL);
		tabItem.setText("All Ressources ");
		tabItem.setControl(fillModelpage(tabFolder, null));

		return tabFolder;
	}

	/**
	 * Used to display a page in a tab
	 * 
	 * @param tabFolder
	 *            that contains all tabs
	 * @param specificTabFilter
	 *            a specific filter to this page
	 * @return the composite of this page
	 */
	public Control fillModelpage(CTabFolder tabFolder, final ViewerFilter specificTabFilter) {
		Composite composite = new Composite(tabFolder, SWT.None);
		GridLayout layout = new GridLayout();
		layout.marginHeight = convertVerticalDLUsToPixels(IDialogConstants.VERTICAL_MARGIN);
		layout.marginWidth = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_MARGIN);
		layout.verticalSpacing = convertVerticalDLUsToPixels(IDialogConstants.VERTICAL_SPACING);
		layout.horizontalSpacing = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_SPACING);
		composite.setLayout(layout);
		newButton = new Button(composite, SWT.NONE);
		newButton.setText("New " + title);
		newButton.setLayoutData(new GridData(200, 25));

		newButton.addMouseListener(createElement);
		if (abstractElement) {
			newButton.setVisible(false);
		}

		PatternFilter patternFilter = new PatternFilter() {

			@Override
			protected boolean isParentMatch(Viewer viewer, Object element) {
				Object[] children = ((ITreeContentProvider) ((AbstractTreeViewer) viewer).getContentProvider()).getChildren(element);
				// apply all filters
				if (viewerFilters != null && children != null) {
					// if one child match, show the parent in tree
					for (ViewerFilter viewerFilter : viewerFilters) {
						for (Object child : children) {
							if (viewerFilter.select(viewer, null, child)) {
								return super.isParentMatch(viewer, element);
							}
						}
					}
					return false;
				} else {
					return super.isParentMatch(viewer, element);
				}
			}

			@Override
			protected boolean isLeafMatch(Viewer viewer, Object element) {
				if (element instanceof NamedElement) {
					String labelText = ((NamedElement) element).getName();
					if (labelText != null) {
						return wordMatches(labelText);
					}
				}
				return false;
			}

		};
		patternFilter.setIncludeLeadingWildcard(true);
		FilteredTree filteredTree = new FilteredTree(composite, SWT.SINGLE | SWT.BORDER | SWT.V_SCROLL | SWT.RESIZE, patternFilter);
		DiResourceSet diResourceSet = backboneContext.getResourceSet();
		// use of EMF facilities
		TreeViewer newTreeViewer = filteredTree.getViewer();
		newTreeViewer.setUseHashlookup(true);
		newTreeViewer.setContentProvider(new AdapterFactoryContentProvider(diResourceSet.getAdapterFactory()));
		if (specificTabFilter == null) {
			newTreeViewer.setFilters(new ViewerFilter[] { viewerFilters[0], patternFilter });
		} else {
			newTreeViewer.setFilters(new ViewerFilter[] { specificTabFilter, viewerFilters[0], patternFilter });
		}
		newTreeViewer.setLabelProvider(new AdapterFactoryLabelProvider(diResourceSet.getAdapterFactory()));
		newTreeViewer.setInput(diResourceSet.getResourceSet());

		filteredTree.setLayoutData(new GridData(550, 300));

		// handle selection change
		newTreeViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				if (event.getSelection() instanceof IStructuredSelection) {
					IStructuredSelection selection = (IStructuredSelection) event.getSelection();
					if (selection.getFirstElement() instanceof Element) {
						choosenElement = (Element) selection.getFirstElement();
					}
				}
			}
		});

		// handle double click to validate
		newTreeViewer.addDoubleClickListener(new IDoubleClickListener() {

			public void doubleClick(DoubleClickEvent event) {
				okPressed();
			}
		});

		return composite;

	}

}
