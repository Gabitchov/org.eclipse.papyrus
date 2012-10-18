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
 *   Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.table.efacet.menu.handler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.dialogs.ContainerCheckedTreeViewer;
import org.eclipse.ui.dialogs.FilteredTree;
import org.eclipse.ui.dialogs.PatternFilter;
import org.eclipse.ui.dialogs.SelectionDialog;


public class ColumnsToShowDialog extends SelectionDialog {

	/** the label provider used by the tree viewer */
	private final ILabelProvider labelProvider;

	/** the content provider used by the tree viewer */
	private final IContentProvider contentProvider;

	/** the with of the dialog */
	private static final int DIALOG_WIDTH = 1000;

	/** the height of the dialog */
	private static final int DIALOG_HEIGHT = 600;

	/** the direct features */
	private final Collection<ETypedElement> directFeatures;

	/** the additional features */
	private final Collection<ENamedElement> additionalFeatures;

	/** the initial selection */
	private final Collection<ETypedElement> initialSelection;

	/** the tree used to display the direct features */
	private FilteredTree directFeaturesTree;

	/** the tree used to display the additional features */
	private FilteredTree additionnalFeaturesTree;

	/**
	 *
	 * Constructor.
	 *
	 * @param parentShell
	 *        the parent shell
	 * @param features
	 *        the direct features
	 * @param additionalFeatures
	 *        the additional features (FacetSet, Facets or ETypedElement)
	 * @param initialSelection
	 *        the initial selection
	 * @param labelProvider
	 *        the label provider used by the viewers
	 * @param contentProvider
	 *        the content provider used by the viewers
	 */
	public ColumnsToShowDialog(final Shell parentShell, final Collection<ETypedElement> features, final Collection<ENamedElement> additionalFeatures, final Collection<ETypedElement> initialSelection, final ILabelProvider labelProvider, final IContentProvider contentProvider) {
		super(parentShell);
		setTitle("Select the columns to show");
		this.directFeatures = features;
		this.additionalFeatures = additionalFeatures;
		this.labelProvider = labelProvider;
		this.contentProvider = contentProvider;
		this.initialSelection = initialSelection;
	}

	@Override
	public void create() {
		super.create();

		final Composite parent = (Composite)getDialogArea();
		final GridLayout layout = (GridLayout)parent.getLayout();
		layout.numColumns = 2;
		layout.makeColumnsEqualWidth = true;

		final Composite selectorPane = new Composite(parent, SWT.NONE);
		selectorPane.setLayout(new GridLayout(2, false));
		selectorPane.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		final Composite selectedPane = new Composite(parent, SWT.NONE);
		selectedPane.setLayout(new GridLayout(2, false));
		selectedPane.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		createDirectFeaturesSection(selectorPane);
		createAdditionalFeaturesSection(selectedPane);

		getShell().setSize(DIALOG_WIDTH, DIALOG_HEIGHT);
		getShell().layout();

		//TODO
		//		super.getShell().setImage(Activator.getDefault().getImage("/icons/papyrus.png")); //$NON-NLS-1$
	}

	/**
	 *
	 * @param parent
	 *        the parent of the button panel
	 * @return
	 *         the composite used as parent for the buttons
	 */
	protected Composite createButtonPanel(final Composite parent) {
		final Composite buttonsPanel = new Composite(parent, SWT.NONE);
		final GridLayout buttonPanelLayout = new GridLayout(2, true);
		buttonPanelLayout.marginWidth = 0;
		buttonPanelLayout.marginHeight = 0;
		buttonsPanel.setLayout(buttonPanelLayout);
		buttonsPanel.setLayoutData(new GridData(SWT.END, SWT.FILL, false, false));
		return buttonsPanel;
	}

	/**
	 * Create the direct features section
	 *
	 * @param parent
	 *        crate the feature section
	 *
	 */
	protected void createDirectFeaturesSection(final Composite parent) {
		//1. create the composite used for this section
		final Composite featureComposite = new Composite(parent, SWT.BORDER);
		featureComposite.setLayout(new GridLayout(1, false));
		featureComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		//2. create the label of the section
		final Label label = new Label(featureComposite, SWT.NONE);
		label.setText("Direct Features");

		//3. create the tree
		this.directFeaturesTree = new FilteredCheckboxTree(featureComposite, SWT.BORDER | SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL | SWT.CHECK, new PatternFilter());
		GridDataFactory.fillDefaults().grab(true, true).applyTo(this.directFeaturesTree);

		this.directFeaturesTree.getViewer().setLabelProvider(this.labelProvider);
		this.directFeaturesTree.getViewer().setContentProvider(this.contentProvider);
		this.directFeaturesTree.getViewer().setInput(this.directFeatures);

		//3.bis set the initial selection
		((ContainerCheckedTreeViewer)this.directFeaturesTree.getViewer()).setCheckedElements(this.initialSelection.toArray());

		//4. create the buttons select all and deselect all
		final Composite buttonsPanel = createButtonPanel(featureComposite);
		final Button selectAllFeaturesButton = new Button(buttonsPanel, SWT.NONE);
		selectAllFeaturesButton.setText("Select All");
		selectAllFeaturesButton.setToolTipText("Select all available features.");
		selectAllFeaturesButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		selectAllFeaturesButton.addSelectionListener(new SelectionListener() {

			public void widgetSelected(final SelectionEvent e) {
				selectAllDirectFeatures();
			}

			public void widgetDefaultSelected(final SelectionEvent e) {
				//nothing to do
			}
		});

		final Button deselectAllFeaturesButton = new Button(buttonsPanel, SWT.NONE);
		deselectAllFeaturesButton.setText("Deselect All");
		deselectAllFeaturesButton.setToolTipText("Deselect all available features.");
		deselectAllFeaturesButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		deselectAllFeaturesButton.addSelectionListener(new SelectionListener() {

			public void widgetSelected(final SelectionEvent e) {
				deselectAllDirectFeatures();
			}

			public void widgetDefaultSelected(final SelectionEvent e) {
				//nothing to do
			}
		});

	}



	protected void createAdditionalFeaturesSection(final Composite facetPane) {
		//1. create the composite used for this section
		final Composite facetComposite = new Composite(facetPane, SWT.BORDER);
		facetComposite.setLayout(new GridLayout(1, true));
		facetComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		//2. create the label for this section
		final Label label = new Label(facetComposite, SWT.NONE);
		label.setText("Additional Features");

		//3. create the tree for this section
		this.additionnalFeaturesTree = new FilteredCheckboxTree(facetComposite, SWT.BORDER | SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.CHECK, new PatternFilter());//, true);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(this.additionnalFeaturesTree);
		this.additionnalFeaturesTree.getViewer().expandAll();
		this.additionnalFeaturesTree.getViewer().setLabelProvider(this.labelProvider);
		this.additionnalFeaturesTree.getViewer().setContentProvider(this.contentProvider);
		this.additionnalFeaturesTree.getViewer().setInput(this.additionalFeatures);
		this.additionnalFeaturesTree.getViewer().expandAll();
		((ContainerCheckedTreeViewer)this.additionnalFeaturesTree.getViewer()).setCheckedElements(this.initialSelection.toArray());

		//4. create the buttons select all and deselect all
		final Composite buttonsPanel = createButtonPanel(facetComposite);
		final Button selectAllAdditionalFeaturesButton = new Button(buttonsPanel, SWT.NONE);
		selectAllAdditionalFeaturesButton.setText("Select All");
		selectAllAdditionalFeaturesButton.setToolTipText("Select all available additional features.");
		selectAllAdditionalFeaturesButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		selectAllAdditionalFeaturesButton.addSelectionListener(new SelectionListener() {

			public void widgetSelected(final SelectionEvent e) {
				selectAllAdditionalFeatures();
			}

			public void widgetDefaultSelected(final SelectionEvent e) {
				//nothing to do
			}
		});

		final Button deselectAllAdditionalFeaturesButton = new Button(buttonsPanel, SWT.NONE);
		deselectAllAdditionalFeaturesButton.setText("Deselect All");
		deselectAllAdditionalFeaturesButton.setToolTipText("Deselect all available additional features.");
		deselectAllAdditionalFeaturesButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		deselectAllAdditionalFeaturesButton.addSelectionListener(new SelectionListener() {

			public void widgetSelected(final SelectionEvent e) {
				deselectAllAdditionalFeatures();
			}

			public void widgetDefaultSelected(final SelectionEvent e) {
				//nothing to do
			}
		});
	}



	/**
	 * select all additional features
	 */
	protected void selectAllAdditionalFeatures() {
		final ContainerCheckedTreeViewer viewer = (ContainerCheckedTreeViewer)this.additionnalFeaturesTree.getViewer();
		for(final Object current : this.additionalFeatures) {
			viewer.setSubtreeChecked(current, true);
		}
	}

	/**
	 * deselect all additional features
	 */
	protected void deselectAllAdditionalFeatures() {
		final ContainerCheckedTreeViewer viewer = (ContainerCheckedTreeViewer)this.additionnalFeaturesTree.getViewer();
		for(final Object current : this.additionalFeatures) {
			viewer.setSubtreeChecked(current, false);
		}
	}

	/**
	 * select all direct features
	 */
	protected void selectAllDirectFeatures() {
		final ContainerCheckedTreeViewer viewer = (ContainerCheckedTreeViewer)this.directFeaturesTree.getViewer();
		for(final Object current : this.directFeatures) {
			viewer.setSubtreeChecked(current, true);
		}
	}

	/**
	 * deselect all direct features
	 */
	protected void deselectAllDirectFeatures() {
		final ContainerCheckedTreeViewer viewer = (ContainerCheckedTreeViewer)this.directFeaturesTree.getViewer();
		for(final Object current : this.directFeatures) {
			viewer.setSubtreeChecked(current, false);
		}
	}

	public void pressOk() {
		okPressed();
	}

	/**
	 * The <code>ListSelectionDialog</code> implementation of this <code>Dialog</code> method builds a list of the selected elements for
	 * later retrieval by the client and closes this dialog.
	 */
	@Override
	protected void okPressed() {
		final Collection<ETypedElement> selectedFeatures = getAllChechedElements(this.directFeaturesTree);
		final Collection<ETypedElement> selectedAdditionalFeatures = getAllChechedElements(this.additionnalFeaturesTree);

		final List<Collection<ETypedElement>> result = new ArrayList<Collection<ETypedElement>>();
		result.add(selectedFeatures);
		result.add(selectedAdditionalFeatures);
		setResult(result);
		super.okPressed();
	}

	/**
	 *
	 * @param tree
	 *        a tree
	 * @return
	 *         all items checked ignoring grayed elements
	 */
	protected Collection<ETypedElement> getAllChechedElements(final FilteredTree tree) {
		final Collection<ETypedElement> checkedElements = new HashSet<ETypedElement>();
		final TreeViewer viewer = tree.getViewer();
		final TreeItem[] items = viewer.getTree().getItems();
		for(final TreeItem treeItem : items) {
			if(treeItem.getChecked()) {
				final Object data = treeItem.getData();
				if(data instanceof ETypedElement) {
					checkedElements.add((ETypedElement)data);
				}
			}
			if(treeItem.getChecked() || treeItem.getGrayed()) {
				checkedElements.addAll(getAllCheckedSubItems(treeItem));
			}
		}
		return checkedElements;
	}

	/**
	 *
	 * @param item
	 *        a item
	 * @return
	 *         all sub items checked ignoring grayed items
	 */
	protected Collection<ETypedElement> getAllCheckedSubItems(final TreeItem item) {
		final Collection<ETypedElement> checkedElements = new HashSet<ETypedElement>();
		for(final TreeItem current : item.getItems()) {
			if(current.getGrayed()) {

			} else if(current.getChecked()) {
				final Object data = current.getData();
				if(data instanceof ETypedElement) {
					checkedElements.add((ETypedElement)data);
				}
			}
			checkedElements.addAll(getAllCheckedSubItems(current));
		}

		return checkedElements;
	}

	/**
	 *
	 *
	 * @return
	 *         the result of the dialog :
	 *         an array of 2 List<ETypeElement> : the first list contains the direct features selected and the second one contains the additional
	 *         features
	 */
	@Override
	public Object[] getResult() {
		//overriden only for the documentation of the methods
		return super.getResult();
	}

}
