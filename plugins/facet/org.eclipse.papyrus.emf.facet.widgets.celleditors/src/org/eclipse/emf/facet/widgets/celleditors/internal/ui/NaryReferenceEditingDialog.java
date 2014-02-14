/*******************************************************************************
 * Copyright (c) 2010, 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Nicolas Bros (Mia-Software) - initial API and implementation
 *   Nicolas Guyomar (Mia-Software) - Bug 339554 - org.eclipse.emf.facet.widgets.celleditors API cleaning
 *   Nicolas Guyomar (Mia-Software) - Bug 342451 - To be able to edit derived facet attributes and derived facet references in a table
 *   Gregoire Dupe (Mia-Software) - Bug 369987 - [Restructuring][Table] Switch to the new customization and facet framework
 *******************************************************************************/
package org.eclipse.emf.facet.widgets.celleditors.internal.ui;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetReference;
import org.eclipse.emf.facet.util.emf.ui.internal.dialogs.CreateInstanceDialog;
import org.eclipse.emf.facet.widgets.celleditors.IModelCellEditHandler;
import org.eclipse.emf.facet.widgets.celleditors.internal.Messages;
import org.eclipse.emf.facet.widgets.internal.CustomizableLabelProvider;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IOpenListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.OpenEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.dialogs.PatternFilter;

/** A dialog to edit a multiplicity-many {@link EReference} */
public class NaryReferenceEditingDialog<T extends EObject> extends AbstractNaryEditingDialog<T> {


	private Button addButton;
	private Button removeButton;
	private Button addAllButton;
	private Button removeAllButton;
	private Button upButton;
	private Button downButton;

	private static final int NUM_COLUMNS = 4;
	// this is a *tree* viewer because PatternFilter only supports Trees
	private TreeViewer availableValuesTreeViewer;
	private ListViewer featureValuesListViewer;
	private Button createInstanceButton;

	private AssignableValuesContentProvider assignableValuesContentProvider;
	private final List<T> availableValues;


	/**
	 *
	 * @param parent
	 *              the parent {@link Shell}
	 * @param values
	 * 				the list of current values.
	 * @param feature
	 *            the feature to edit
	 * @param eObject
	 * 				the eObject being currently edited. Should not be modified in this dialog.
	 * @param editHandler
	 *  			The editHandler which has to be called when the edition is completed
	 */
	public NaryReferenceEditingDialog(final Shell shell, final List<T> values,
			final List<T> availableValues, final IModelCellEditHandler editHandler,
			final EObject eObject, final EStructuralFeature feature) {
		super(shell, values, editHandler, eObject, feature);
		this.availableValues = new ArrayList<T>(availableValues);
	}

	@Override
	protected void configureShell(final Shell shell) {
		super.configureShell(shell);
		shell.setText(NLS.bind(Messages.NaryReferenceEditingDialog_shellTitle,
				getFeature().getName(), geteObject().eClass().getName()));
	}

	@Override
	protected Control createDialogArea(final Composite parent) {
		final Composite contents = (Composite) super.createDialogArea(parent);

		final GridLayout contentsGridLayout = (GridLayout) contents.getLayout();
		contentsGridLayout.numColumns = NaryReferenceEditingDialog.NUM_COLUMNS;

		final GridData contentsGridData = (GridData) contents.getLayoutData();
		contentsGridData.horizontalAlignment = SWT.FILL;
		contentsGridData.verticalAlignment = SWT.FILL;

		createLeftPane(contents);
		createMiddleButtonsPane(contents);
		createRightPane(contents);
		createRightButtonsPane(contents);

		this.availableValuesTreeViewer.addOpenListener(new IOpenListener() {
			public void open(final OpenEvent event) {
				if (NaryReferenceEditingDialog.this.addButton.isEnabled()) {
					NaryReferenceEditingDialog.this.addButton.notifyListeners(SWT.Selection, null);
				}
			}
		});

		this.featureValuesListViewer.addOpenListener(new IOpenListener() {
			public void open(final OpenEvent event) {
				if (NaryReferenceEditingDialog.this.removeButton.isEnabled()) {
					NaryReferenceEditingDialog.this.removeButton.notifyListeners(SWT.Selection,
							null);
				}
			}
		});

		this.upButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent event) {
				upButtonClicked();
			}
		});

		this.downButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent event) {
				downButtonClicked();
			}
		});

		this.addButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent event) {
				addButtonClicked();
			}
		});

		this.addAllButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent event) {
				addAllButtonClicked();
			}
		});

		this.removeButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent event) {
				removeButtonClicked();
			}
		});

		this.removeAllButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent event) {
				removeAllButtonClicked();
			}
		});

		if (this.createInstanceButton != null) {
			this.createInstanceButton.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(final SelectionEvent event) {
					createInstanceButtonClicked();
				}
			});
		}

		return contents;
	}

	private void addButtonClicked() {
		final IStructuredSelection selection = (IStructuredSelection) this.availableValuesTreeViewer
				.getSelection();
		if (selection.isEmpty() || !confirmMove()) {
			return;
		}
		Iterator<T> it = getTCastedStructuredSelectionIterator(selection);
		while (it.hasNext()) {
			T element = it.next();
			if (!(getValues() != null && getValues().contains(element))) {
				getValues().add(element);
				this.availableValues.remove(element);
			}
		}
		refresh();
		this.featureValuesListViewer.setSelection(selection);
	}

	@SuppressWarnings({ "unchecked", "static-method" })
	//unchecked: the selection in not type parameterized, then we cannot get a cleaned cast iterator
	//static-method: this method cannot be static to be able to use the T type.
	private Iterator<T> getTCastedStructuredSelectionIterator(final IStructuredSelection selection) {
		return selection.iterator();
	}

	private void addAllButtonClicked() {
		if (this.availableValues.isEmpty() || !confirmMove()) {
			return;
		}
		getValues().addAll(this.availableValues);
		this.availableValues.removeAll(getValues());
		refresh();
	}

	private void removeButtonClicked() {
		final IStructuredSelection selection = (IStructuredSelection) this.featureValuesListViewer
				.getSelection();
		if (selection.isEmpty() || !confirmRemove()) {
			return;
		}

		Iterator<T> it = this.getTCastedStructuredSelectionIterator(selection);
		while (it.hasNext()) {
			T element = it.next();
			if (getValues().contains(element)) {
				this.availableValues.add(element);
				getValues().remove(element);
			}
		}
		refresh();
	}

	private void removeAllButtonClicked() {
		if (getValues().isEmpty() || !confirmRemove()) {
			return;
		}
		this.availableValues.addAll(getValues());
		getValues().removeAll(getValues());
		refresh();
	}

	private boolean confirmRemove() {
		if (getFeature() instanceof EReference) {
			EReference eReference = (EReference) getFeature();
			if (eReference.isContainment()) {
				return MessageDialog.openConfirm(getShell(),
						Messages.NaryReferenceEditingDialog_deleteElements,
						Messages.NaryReferenceEditingDialog_deleteElementsLong);
			}
		}
		return true;
	}

	private boolean confirmMove() {
		if (getFeature() instanceof EReference || getFeature() instanceof FacetReference) {
			EReference reference = (EReference) getFeature();
			if (reference.isContainment()) {
				String fullMessage = Messages.NaryReferenceEditingDialog_moveWarning;
				return MessageDialog.openConfirm(getShell(),
						Messages.NaryReferenceEditingDialog_moveElement, fullMessage);
			}
		}
		return true;
	}

	@SuppressWarnings("unchecked") // type erasure on generic
	private void createInstanceButtonClicked() {
		EClassifier eType = getFeature().getEType();
		if (eType instanceof EClass) {
			EClass eClass = (EClass) eType;
			EObject newInstance = CreateInstanceDialog.open(getShell(), eClass,
					new CustomizableLabelProvider());
			if (newInstance != null) {
				getValues().add((T) newInstance);
				refresh();
			}
		}
	}

	private void createLeftPane(final Composite contents) {
		final Composite choiceComposite = new Composite(contents, SWT.NONE);
		final GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
		data.horizontalAlignment = SWT.END;
		choiceComposite.setLayoutData(data);

		final GridLayout layout = new GridLayout();
		data.horizontalAlignment = SWT.FILL;
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		layout.numColumns = 1;
		choiceComposite.setLayout(layout);

		final Label choiceLabel = new Label(choiceComposite, SWT.NONE);
		choiceLabel.setText(Messages.NaryReferenceEditingDialog_availableValues);

		final GridData choiceLabelGridData = new GridData();
		choiceLabelGridData.verticalAlignment = SWT.FILL;
		choiceLabelGridData.horizontalAlignment = SWT.FILL;
		choiceLabel.setLayoutData(choiceLabelGridData);

		final Text patternText = createFilterText(choiceComposite);

		final Tree availableValuesTree = new Tree(choiceComposite, SWT.MULTI | SWT.BORDER);
		final GridData availableValuesGridData = new GridData();
		availableValuesGridData.widthHint = AbstractNaryEditingDialog.AVAILABLE_VALUES_TREE_WIDTH;
		availableValuesGridData.heightHint = AbstractNaryEditingDialog.AVAILABLE_VALUES_TREE_HEIGHT;
		availableValuesGridData.horizontalAlignment = SWT.FILL;
		availableValuesGridData.verticalAlignment = SWT.FILL;
		availableValuesGridData.grabExcessHorizontalSpace = true;
		availableValuesGridData.grabExcessVerticalSpace = true;
		availableValuesTree.setLayoutData(availableValuesGridData);

		this.availableValuesTreeViewer = new TreeViewer(availableValuesTree);
		this.assignableValuesContentProvider = new AssignableValuesContentProvider();
		this.availableValuesTreeViewer.setContentProvider(this.assignableValuesContentProvider);
		this.availableValuesTreeViewer.setLabelProvider(new CustomizableLabelProvider());
		final PatternFilter filter = new PatternFilter();
		this.availableValuesTreeViewer.addFilter(filter);

		this.availableValuesTreeViewer.setInput(this.availableValues);

		patternText.addModifyListener(new ModifyListener() {
			public void modifyText(final ModifyEvent e) {
				filter.setPattern(patternText.getText());
				NaryReferenceEditingDialog.this.availableValuesTreeViewer.refresh();
			}
		});
	}

	private void createMiddleButtonsPane(final Composite contents) {
		final Composite buttonsComposite = new Composite(contents, SWT.NONE);
		final GridData buttonsCompositeGridData = new GridData();
		buttonsCompositeGridData.verticalAlignment = SWT.CENTER;
		buttonsCompositeGridData.horizontalAlignment = SWT.FILL;
		buttonsComposite.setLayoutData(buttonsCompositeGridData);
		buttonsComposite.setLayout(new GridLayout());

		// new Label(buttonsComposite, SWT.NONE);

		this.addButton = new Button(buttonsComposite, SWT.PUSH);
		this.addButton.setText(Messages.NaryReferenceEditingDialog_add);
		this.addButton.setToolTipText(Messages.NaryReferenceEditingDialog_addTooltip);
		final GridData addButtonGridData = new GridData();
		addButtonGridData.verticalAlignment = SWT.FILL;
		addButtonGridData.horizontalAlignment = SWT.FILL;
		this.addButton.setLayoutData(addButtonGridData);

		this.removeButton = new Button(buttonsComposite, SWT.PUSH);
		this.removeButton.setText(Messages.NaryReferenceEditingDialog_remove);
		this.removeButton.setToolTipText(Messages.NaryReferenceEditingDialog_removeTooltip);
		final GridData removeButtonGridData = new GridData();
		removeButtonGridData.verticalAlignment = SWT.FILL;
		removeButtonGridData.horizontalAlignment = SWT.FILL;
		this.removeButton.setLayoutData(removeButtonGridData);

		spacer(buttonsComposite);

		this.addAllButton = new Button(buttonsComposite, SWT.PUSH);
		this.addAllButton.setText(Messages.NaryReferenceEditingDialog_addAll);
		this.addAllButton.setToolTipText(Messages.NaryReferenceEditingDialog_addAllTooltip);

		this.removeAllButton = new Button(buttonsComposite, SWT.PUSH);
		this.removeAllButton.setText(Messages.NaryReferenceEditingDialog_removeAll);
		this.removeAllButton.setToolTipText(Messages.NaryReferenceEditingDialog_removeAllTooltip);
	}

	private void spacer(final Composite parent) {
		@SuppressWarnings("unused")
		Label label = new Label(parent, SWT.NONE);
	}

	private void createRightButtonsPane(final Composite contents) {
		final Composite buttonsComposite = new Composite(contents, SWT.NONE);
		final GridData buttonsCompositeGridData = new GridData();
		buttonsCompositeGridData.verticalAlignment = SWT.FILL;
		buttonsCompositeGridData.horizontalAlignment = SWT.FILL;
		buttonsComposite.setLayoutData(buttonsCompositeGridData);
		buttonsComposite.setLayout(new GridLayout());

		// spacer
		spacer(buttonsComposite);

		if (getFeature() instanceof EReference) {
			EReference eReference = (EReference) getFeature();
			if (eReference.isContainment()) {
				this.createInstanceButton = new Button(buttonsComposite, SWT.PUSH);
				this.createInstanceButton.setText(Messages.NaryReferenceEditingDialog_newInstance);
				final GridData createButtonGridData = new GridData();
				createButtonGridData.verticalAlignment = SWT.FILL;
				createButtonGridData.horizontalAlignment = SWT.FILL;
				this.createInstanceButton.setLayoutData(createButtonGridData);
				spacer(buttonsComposite);
			}

		}

		this.upButton = new Button(buttonsComposite, SWT.PUSH);
		this.upButton.setText(Messages.NaryReferenceEditingDialog_up);
		final GridData upButtonGridData = new GridData();
		upButtonGridData.verticalAlignment = SWT.FILL;
		upButtonGridData.horizontalAlignment = SWT.FILL;
		this.upButton.setLayoutData(upButtonGridData);

		this.downButton = new Button(buttonsComposite, SWT.PUSH);
		this.downButton.setText(Messages.NaryReferenceEditingDialog_down);
		final GridData downButtonGridData = new GridData();
		downButtonGridData.verticalAlignment = SWT.FILL;
		downButtonGridData.horizontalAlignment = SWT.FILL;
		this.downButton.setLayoutData(downButtonGridData);
	}

	private void createRightPane(final Composite contents) {
		final Composite featureComposite = new Composite(contents, SWT.NONE);
		final GridData featureCompositeData = new GridData(SWT.FILL, SWT.FILL, true, true);
		featureCompositeData.horizontalAlignment = SWT.END;
		featureComposite.setLayoutData(featureCompositeData);

		final GridLayout featureCompositeLayout = new GridLayout();
		featureCompositeData.horizontalAlignment = SWT.FILL;
		featureCompositeLayout.marginHeight = 0;
		featureCompositeLayout.marginWidth = 0;
		featureCompositeLayout.numColumns = 1;
		featureComposite.setLayout(featureCompositeLayout);

		final Label featureLabel = new Label(featureComposite, SWT.NONE);
		featureLabel.setText(Messages.NaryReferenceEditingDialog_values);
		final GridData valuesLabelGridData = new GridData();
		valuesLabelGridData.horizontalSpan = 2;
		valuesLabelGridData.horizontalAlignment = SWT.FILL;
		valuesLabelGridData.verticalAlignment = SWT.FILL;
		featureLabel.setLayoutData(valuesLabelGridData);

		final org.eclipse.swt.widgets.List availableValuesList = new org.eclipse.swt.widgets.List(
				featureComposite, SWT.MULTI | SWT.BORDER | SWT.V_SCROLL);
		final GridData availableValuesGridData = new GridData();
		availableValuesGridData.widthHint = AbstractNaryEditingDialog.AVAILABLE_VALUES_TREE_WIDTH;
		availableValuesGridData.heightHint = AbstractNaryEditingDialog.AVAILABLE_VALUES_TREE_HEIGHT;
		availableValuesGridData.verticalAlignment = SWT.FILL;
		availableValuesGridData.horizontalAlignment = SWT.FILL;
		availableValuesGridData.grabExcessHorizontalSpace = true;
		availableValuesGridData.grabExcessVerticalSpace = true;
		availableValuesList.setLayoutData(availableValuesGridData);

		this.featureValuesListViewer = new ListViewer(availableValuesList);
		this.featureValuesListViewer.setContentProvider(new AssignedValuesContentProvider());
		this.featureValuesListViewer.setLabelProvider(new CustomizableLabelProvider());
		this.featureValuesListViewer
				.setInput(getValues());
	}

	private Text createFilterText(final Composite contents) {
		Text patternText = new Text(contents, SWT.BORDER | SWT.SEARCH);
		patternText.setMessage(Messages.NaryReferenceEditingDialog_typeFilterText);
		patternText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		return patternText;
	}

	@Override
	public void refresh() {
		this.availableValuesTreeViewer.refresh();
		this.featureValuesListViewer.refresh();
	}

	@Override
	protected boolean isResizable() {
		return true;
	}

	@Override
	protected void createButtonsForButtonBar(final Composite parent) {
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
	}

	@Override
	public ISelection getSelection() {
		return this.featureValuesListViewer.getSelection();
	}
}
