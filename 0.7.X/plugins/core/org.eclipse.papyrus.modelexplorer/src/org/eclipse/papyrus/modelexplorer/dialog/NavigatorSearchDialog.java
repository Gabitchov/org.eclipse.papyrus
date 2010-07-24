/*******************************************************************************
 * Copyright (c) 2009 Conselleria de Infraestructuras y Transporte, Generalitat 
 * de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Francisco Javier Cano Muñoz (Prodevelop) - initial api contribution
 *
 ******************************************************************************/
package org.eclipse.papyrus.modelexplorer.dialog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.navigator.CommonNavigator;

/**
 * A dialog that allows searching elements in the Model navigator by name.
 * 
 * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano Munoz</a>
 * 
 * @author cedric dumoulin
 */
public class NavigatorSearchDialog extends TrayDialog {

	private ITreeContentProvider contentProvider = null;

	private ILabelProvider labelProvider = null;

	private Object root = null;

	private ISelectionProvider viewer = null;

	private List<Object> matchedObjects = Collections.emptyList();

	private Label matchesLabel;

	private Text searchText;

	private Button backButton;

	private Button nextButton;

	private Button caseButton;

	/**
	 * 
	 * Constructor.
	 *
	 * @param shell
	 * @param modelNavigator
	 * @deprecated Use {@link #NavigatorSearchDialog(Shell, TreeViewer)}
	 */
	public NavigatorSearchDialog(Shell shell, CommonNavigator modelNavigator) {
		super(shell);
		IContentProvider cprovider = modelNavigator.getCommonViewer()
				.getContentProvider();
		if(cprovider instanceof ITreeContentProvider) {
			contentProvider = (ITreeContentProvider)cprovider;
		}
		root = modelNavigator.getCommonViewer().getInput();
		viewer = modelNavigator.getCommonViewer();
		labelProvider = (ILabelProvider)modelNavigator.getCommonViewer()
				.getLabelProvider();

	}

	/**
	 * Constructor.
	 *
	 * @param shell Shell used to show this Dialog
	 * @param viewer 
	 * @param contentProvider
	 * @param labelProvider
	 * @param root
	 */
	public NavigatorSearchDialog(Shell shell, TreeViewer viewer) {
		super(shell);
		this.viewer = viewer;
		try {
			this.labelProvider = (ILabelProvider)viewer.getLabelProvider();
			this.contentProvider = (ITreeContentProvider)viewer.getContentProvider();
		} catch (ClassCastException e) {
			// Content or label provider are not of appropriate type.
			// let them null
		}
		this.root = viewer.getInput();
	}

	
	/**
	 * Constructor.
	 *
	 * @param shell Shell used to show this Dialog
	 * @param viewer 
	 * @param contentProvider
	 * @param labelProvider
	 * @param root
	 */
	public NavigatorSearchDialog(Shell shell, Viewer viewer, ITreeContentProvider contentProvider, ILabelProvider labelProvider, Object root) {
		super(shell);
		this.viewer = viewer;
		this.contentProvider = contentProvider;
		this.labelProvider = labelProvider;
		this.root = root;
	}

   /**
    * Sets a new selection for the associated {@link ISelectionProvider} and optionally makes it visible.
    * <p>
    * Subclasses must implement this method.
    * </p>
    *
    * @param selection the new selection
    * @param reveal <code>true</code> if the selection is to be made
    *   visible, and <code>false</code> otherwise
    */
	private void fireSetSelection( ISelection selection, boolean reveal) {
		// Note : if we want to force reveal, it is possible to check if 
		// selectionProvider instanceof Viewer, and then call selectionProvider.setSelection(selection, true).
		// By default a TreeViewer reveal the selection.
		viewer.setSelection(selection);
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.dialogs.Dialog#createDialogArea(org.eclipse.swt.widgets
	 * .Composite)
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite background = new Composite(parent, SWT.None);
		GridData bgData = new GridData(GridData.FILL_BOTH);
		bgData.minimumWidth = 300;
		background.setLayoutData(bgData);
		GridLayout bgLayout = new GridLayout();
		bgLayout.numColumns = 2;
		background.setLayout(bgLayout);

		createSearchTextComposite(background);
		return background;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.dialogs.Dialog#createButtonsForButtonBar(org.eclipse
	 * .swt.widgets.Composite)
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {

		backButton = createButton(parent, IDialogConstants.BACK_ID,
				IDialogConstants.BACK_LABEL, false);
		nextButton = createButton(parent, IDialogConstants.NEXT_ID,
				IDialogConstants.NEXT_LABEL, false);
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL,
				true);

		backButton.setEnabled(false);
		nextButton.setEnabled(false);

		nextButton.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				ISelection sel = viewer.getSelection();
				if(!(sel instanceof StructuredSelection)) {
					return;
				}
				StructuredSelection ssel = (StructuredSelection)sel;

				int index = matchedObjects.lastIndexOf(ssel.getFirstElement());
				if(index == matchedObjects.size() - 1) {
					index = -1;
				}
				index++;
				fireSetSelection(new StructuredSelection(matchedObjects.get(index)), true);
			}

		});

		backButton.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				ISelection sel = viewer.getSelection();
				if(!(sel instanceof StructuredSelection)) {
					return;
				}
				StructuredSelection ssel = (StructuredSelection)sel;

				int index = matchedObjects.lastIndexOf(ssel.getFirstElement());
				if(index == 0) {
					index = matchedObjects.size() - 1;
				}
				index--;
				fireSetSelection(new StructuredSelection(matchedObjects.get(index)), true);
			}

		});
	}

	private void createSearchTextComposite(Composite background) {
		Label searchLabel = new Label(background, SWT.None);
		searchLabel.setText("Search:");
		searchLabel.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_END));

		searchText = new Text(background, SWT.SEARCH);
		searchText.setFocus();
		searchText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		searchText.addKeyListener(getKeyListener());

		caseButton = new Button(background, SWT.CHECK);
		caseButton.setText("Case sensitive?");
		GridData caseButtonData = new GridData(
				GridData.HORIZONTAL_ALIGN_BEGINNING);
		caseButtonData.horizontalSpan = 2;
		caseButton.setSelection(false);
		caseButton.setLayoutData(caseButtonData);
		caseButton.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				updateMatches();
			}

		});

		Label resultsLabel = new Label(background, SWT.None);
		resultsLabel.setText("Results:");
		resultsLabel.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_END));

		matchesLabel = new Label(background, SWT.None);
		matchesLabel.setText("No matchings.");
		matchesLabel
				.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING
						| GridData.FILL_HORIZONTAL));

	}

	private void updateMatches() {
		if(contentProvider == null && labelProvider == null) {
			return;
		}

		String pattern = searchText.getText();
		if(pattern.length() == 0) {
			matchedObjects = Collections.emptyList();
			backButton.setEnabled(false);
			nextButton.setEnabled(false);
			matchesLabel.setText("No matchings.");
			return;
		}

		if(!caseButton.getSelection()) {
			pattern = pattern.toUpperCase();
		}

		matchedObjects = searchPattern(pattern, Arrays.asList(contentProvider
				.getElements(root)));

		// Update matches label
		matchesLabel.setText(matchedObjects.size() + " matches found");

		// Select first match and update buttons
		if(!matchedObjects.isEmpty()) {
			fireSetSelection(new StructuredSelection(matchedObjects.get(0)), true);
			nextButton.setEnabled(true);
			backButton.setEnabled(true);
		} else {
			nextButton.setEnabled(false);
			backButton.setEnabled(false);
		}

	}

	private List<Object> searchPattern(String pattern, List<Object> objects) {
		List<Object> matches = new ArrayList<Object>();

		List<Object> childs = new ArrayList<Object>();
		String objectLabel;
		boolean caseSensitive = caseButton.getSelection();
		for(Object o : objects) {
			// Search matches in this level
			if(!(o instanceof Diagram)) {
				objectLabel = caseSensitive ? labelProvider.getText(o)
						: labelProvider.getText(o).toUpperCase();

				if(objectLabel.contains(pattern)) {
					matches.add(o);
				}

				// Find childs

				for(int i = 0; i < contentProvider.getChildren(o).length; i++) {
					if(contentProvider.getChildren(o)[i] instanceof IAdaptable) {

						EObject eObject = (EObject)((IAdaptable)contentProvider
								.getChildren(o)[i]).getAdapter(EObject.class);

						if(eObject.eContainer().equals(
								(EObject)((IAdaptable)o)
										.getAdapter(EObject.class))) {
							childs.add(contentProvider.getChildren(o)[i]);
						}
					}
				}
			}
		}
		if(!childs.isEmpty()) {
			matches.addAll(searchPattern(pattern, childs));
		}

		return matches;
	}

	protected KeyListener getKeyListener() {
		return new KeyListener() {

			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			public void keyReleased(KeyEvent e) {
				updateMatches();

			}

		};
	}

}
