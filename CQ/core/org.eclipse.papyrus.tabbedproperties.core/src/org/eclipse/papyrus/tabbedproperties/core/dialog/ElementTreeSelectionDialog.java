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
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.papyrus.core.editor.BackboneContext;
import org.eclipse.papyrus.core.utils.DiResourceSet;
import org.eclipse.papyrus.tabbedproperties.core.filters.OperationFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.uml2.uml.Element;

/**
 * This dialog shows the tree of all owned element by taking in account a filter
 * 
 * @author Patrick Tessier
 */
public class ElementTreeSelectionDialog extends Dialog {

	/**
	 * The parent where we look for subElements
	 */
	protected Element umlParentElement;

	/**
	 * the label
	 */
	protected Label label;

	/**
	 * the button
	 */
	protected Button newButton;

	/**
	 * Chosen element.
	 */
	protected Element choosenElement;

	/**
	 * The selection tree.
	 */
	protected Tree tree;

	/** title of the window **/
	protected String title = "Element Selection";

	/** link ModelManager **/
	protected BackboneContext backboneContext;

	/**
	 * the mouse listener to create an element
	 */
	protected MouseListener createElement;

	/**
	 * filters
	 */
	protected ViewerFilter[] viewerFilters;

	/**
	 * flag to know if the element is abstract
	 */
	protected boolean abstractElement;

	/**
	 * Constructor with parent shell and Element.
	 * 
	 * @param parent
	 *            the Shell.
	 * @param umlparent
	 *            the uml element where we look for a children
	 * @param modelManager
	 *            the ModelManager
	 * @param filters
	 *            this is an array of filter see {@link ViewerFilter} or an example {@link OperationFilter}
	 * @param title
	 *            title of the window
	 * @param createElement
	 *            this is the listenr to create an element
	 * @param abstractElement
	 *            it used to inform about if the element is abstract in this case the creation button does not appear
	 * @param backboneContext
	 *            the context.
	 */
	public ElementTreeSelectionDialog(Shell parent, Element umlparent, BackboneContext backboneContext, ViewerFilter[] filters, String title, MouseListener createElement, boolean abstractElement) {
		super(parent);
		this.umlParentElement = umlparent;
		// add the resize ability to the window
		setShellStyle(SWT.RESIZE | super.getShellStyle());
		this.backboneContext = backboneContext;
		this.viewerFilters = filters;
		this.title = title;
		this.createElement = createElement;
		this.abstractElement = abstractElement;
	}

	/**
	 * Creates the dialog area.
	 * 
	 * @param parent
	 *            composite.
	 * 
	 * @return control Control.
	 */
	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite) super.createDialogArea(parent);

		newButton = new Button(composite, SWT.NONE);
		newButton.setText("New " + title);
		newButton.setLayoutData(new GridData(200, 25));
		newButton.addMouseListener(createElement);
		if (abstractElement) {
			newButton.setVisible(false);
		}

		tree = new Tree(composite, SWT.SINGLE | SWT.BORDER | SWT.V_SCROLL | SWT.RESIZE);
		DiResourceSet diResourceSet = backboneContext.getResourceSet();
		// use of EMF facilities
		TreeViewer newTreeViewer = new TreeViewer(tree);
		newTreeViewer.setContentProvider(new AdapterFactoryContentProvider(diResourceSet.getAdapterFactory()));
		newTreeViewer.setFilters(viewerFilters);
		newTreeViewer.setLabelProvider(new AdapterFactoryLabelProvider(diResourceSet.getAdapterFactory()));
		newTreeViewer.setInput(diResourceSet.getResourceSet());
		// newTreeViewer.setInput(modelManager.getDiResourceSet().getAllLoadedUMLRessource());

		tree.setLayoutData(new GridData(550, 300));

		tree.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				TreeItem[] selection = tree.getSelection();
				if (selection[0].getData() instanceof Element) {
					choosenElement = (Element) selection[0].getData();
				}
			}

			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
		return composite;
	}

	/**
	 * Returns the associated Element.
	 * 
	 * @return element Element
	 */
	public Element getResult() {
		return choosenElement;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText("Select or create " + this.title + ":");
	}

}
