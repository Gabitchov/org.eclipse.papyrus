/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *	Gabriel Pascual (ALL4TEC) gabriel.pascual@all4tec.net - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.css.dialog;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.papyrus.infra.core.utils.PapyrusImageUtils;
import org.eclipse.papyrus.infra.emf.providers.EMFContentProvider;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.EmbeddedStyleSheet;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StyleSheet;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StyleSheetReference;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StylesheetsFactory;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StylesheetsPackage;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.Theme;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.WorkspaceThemes;
import org.eclipse.papyrus.infra.widgets.providers.AbstractStaticContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.CollectionContentProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 * Dialog to edit theme from an initial selection in workspace.
 * 
 * @author gpascual
 *
 */
public class CSSThemeEditionDialog extends Dialog {

	/** Icon for delete action button. */
	private static final Image DELETE_ICON = AbstractUIPlugin.imageDescriptorFromPlugin("org.eclipse.papyrus.infra.widgets", "icons/Delete_12x12.gif").createImage(); //$NON-NLS-1$ //$NON-NLS-2$

	/** Icon for add action button. */
	private static final Image ADD_ICON = AbstractUIPlugin.imageDescriptorFromPlugin("org.eclipse.papyrus.infra.widgets", "icons/Add_12x12.gif").createImage(); //$NON-NLS-1$ //$NON-NLS-2$

	/** Text for browse button. */
	private static final String BROWSE_BUTTON_LABEL = "Browse...";

	/** Text for theme icon label. */
	private static final String THEME_ICON_LABEL = "Icon";

	/** Text for theme name label. */
	private static final String THEME_NAME_LABEL = "Label";

	/** Text for theme combo label. */
	private static final String THEME_COMBO_LABEL = "Theme";

	/** Title of dialog. */
	private static final String DIALOG_TITLE = "CSS Theme Edition";

	/** Field for theme label. */
	private Text themeLabelField = null;

	/** Field for theme icon path. */
	private Text iconPathfield = null;

	/** Workspace themes from preference file. */
	private WorkspaceThemes workspaceThemes = null;


	/** Initial selection in workspace. */
	private List<StyleSheet> selectedStyleSheetsList = null;

	/** Viewer for style sheets of current theme. */
	private TreeViewer themeStyleSheetsViewer = null;

	/** Current edited theme. */
	private Theme currentTheme = null;


	/**
	 * Default constructor.
	 *
	 * @param parentShell
	 */
	public CSSThemeEditionDialog(Shell parentShell, WorkspaceThemes themes, IStructuredSelection parentSelection) {
		super(parentShell);
		workspaceThemes = themes;

		initialiseWithSelection(parentSelection);
	}


	/**
	 * Initialise selected style sheets list with selection.
	 * 
	 * @param selection
	 *        Source to extract style sheets
	 */
	private void initialiseWithSelection(IStructuredSelection selection) {
		Assert.isNotNull(selection);

		// Instantiate an empty list
		selectedStyleSheetsList = new ArrayList<StyleSheet>();

		// Create iterator and factory for initialisation
		Iterator<?> selectionIterator = selection.iterator();
		StylesheetsFactory styleSheetsFactory = StylesheetsFactory.eINSTANCE;

		// Explore selection
		while(selectionIterator.hasNext()) {

			// Check only file from selection
			Object object = selectionIterator.next();
			if(object instanceof IFile) {

				// Create a style sheet reference and add it to list
				StyleSheetReference reference = styleSheetsFactory.createStyleSheetReference();
				reference.setPath(URI.createFileURI(((IFile)object).getLocation().toOSString()).toString());

				selectedStyleSheetsList.add(reference);
			}
		}


	}

	/**
	 * @see org.eclipse.jface.window.Window#configureShell(org.eclipse.swt.widgets.Shell)
	 *
	 * @param newShell
	 */
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);

		// Set title and icon of dialog
		newShell.setText(DIALOG_TITLE);
		newShell.setImage(PapyrusImageUtils.getDefaultIcon());
	}

	/**
	 * Create contents of the dialog.
	 * 
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite)super.createDialogArea(parent);
		container.setLayout(new GridLayout(4, false));

		createEditedThemeComposite(container);
		createThemeLabelPart(container);
		createThemeIconPart(container);
		createThemeStyleSheetsPart(container);

		return container;
	}

	/**
	 * Create composite whith that can select theme to edit.
	 * 
	 * @param parent
	 *        Parent composite where components will be added
	 */
	private void createEditedThemeComposite(Composite parent) {

		// Label for combo of themes
		Label themeLabel = new Label(parent, SWT.NONE);
		themeLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
		themeLabel.setText(THEME_COMBO_LABEL);

		// Create a combo so that user can choice theme to edit
		ComboViewer comboViewer = new ComboViewer(parent, SWT.READ_ONLY);
		comboViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 *
			 * @param event
			 */
			@Override
			public void selectionChanged(SelectionChangedEvent event) {

				// Refresh content of dialog
				refreshDialogContent(event.getSelection());

			}
		});

		// Add label provider to combo viewer
		comboViewer.setLabelProvider(new LabelProvider() {

			/**
			 * @see org.eclipse.jface.viewers.LabelProvider#getText(java.lang.Object)
			 *
			 * @param element
			 * @return
			 */
			@Override
			public String getText(Object element) {

				// Super return as default result
				String text = super.getText(element);

				// Display label of theme in combo viewer
				if(element instanceof Theme) {
					text = ((Theme)element).getLabel();
				}


				return text;
			}
		});

		comboViewer.setContentProvider(new EMFContentProvider(workspaceThemes, StylesheetsPackage.eINSTANCE.getWorkspaceThemes_Themes()) {

			/**
			 * @see org.eclipse.papyrus.infra.emf.providers.EMFContentProvider#getSemanticProvider(org.eclipse.emf.ecore.EObject,
			 *      org.eclipse.emf.ecore.EStructuralFeature)
			 *
			 * @param editedEObject
			 * @param feature
			 * @return
			 */
			@Override
			protected IStructuredContentProvider getSemanticProvider(final EObject editedEObject, final EStructuralFeature feature) {

				// Use a standard content provider
				return new AbstractStaticContentProvider() {

					public Object[] getElements() {

						List<Object> result = new LinkedList<Object>();

						// Create list with workspace themes
						if(editedEObject instanceof WorkspaceThemes) {
							result.addAll(workspaceThemes.getThemes());
						}

						return result.toArray();
					}
				};

			}
		});

		comboViewer.setInput(workspaceThemes.getThemes());
		Combo combo = comboViewer.getCombo();
		combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
	}

	/**
	 * Create theme label composite.
	 * 
	 * @param parent
	 *        Parent composite where components will be added
	 */
	private void createThemeLabelPart(Composite parent) {

		// Create label for label field
		Label themeNameLabel = new Label(parent, SWT.NONE);
		themeNameLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
		themeNameLabel.setText(THEME_NAME_LABEL);

		// Add theme label field
		themeLabelField = new Text(parent, SWT.BORDER);
		GridData gd_text = new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1);
		themeLabelField.setLayoutData(gd_text);
	}

	/**
	 * Create theme icon part.
	 * 
	 * @param parent
	 *        Parent composite where components will be added
	 */
	private void createThemeIconPart(Composite parent) {
		Label lblIcon = new Label(parent, SWT.NONE);
		lblIcon.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
		lblIcon.setText(THEME_ICON_LABEL);

		iconPathfield = new Text(parent, SWT.BORDER);
		iconPathfield.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		Button btnBrowse = new Button(parent, SWT.NONE);
		btnBrowse.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1));
		btnBrowse.setText(BROWSE_BUTTON_LABEL);
	}

	/**
	 * @param container
	 */
	private void createThemeStyleSheetsPart(Composite container) {
		themeStyleSheetsViewer = new TreeViewer(container, SWT.BORDER);
		themeStyleSheetsViewer.setContentProvider(CollectionContentProvider.instance);

		themeStyleSheetsViewer.setLabelProvider(new LabelProvider() {

			@Override
			public String getText(Object element) {

				String text = super.getText(element);

				if(element instanceof StyleSheetReference) {
					text = ((StyleSheetReference)element).getPath();
				}

				return text;
			}
		});

		Tree tree = themeStyleSheetsViewer.getTree();
		tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1));

		createTreeActionButtons(container);
	}

	/**
	 * @param parent
	 */
	private void createTreeActionButtons(Composite parent) {
		Composite buttonsPanel = new Composite(parent, SWT.NONE);
		buttonsPanel.setLayout(new GridLayout());
		buttonsPanel.setLayoutData(new GridData(SWT.CENTER, SWT.FILL, false, false));


		Button addButton = new Button(buttonsPanel, SWT.NONE);
		addButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false));
		addButton.setImage(ADD_ICON);

		Button deleteButton = new Button(buttonsPanel, SWT.NONE);
		deleteButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false));
		deleteButton.setImage(DELETE_ICON);
	}

	/**
	 * Refresh content of tree viewer according to selected theme/
	 * 
	 * @param currentTheme
	 *        Current theme
	 */
	private void refreshTreeviewer(Theme currentTheme) {

		// Create mirroring list
		List<StyleSheet> mirrorList = new ArrayList<StyleSheet>();


		EList<StyleSheet> themeStyleSheetsList = currentTheme.getStylesheets();
		mirrorList.addAll(themeStyleSheetsList);

		// For each selected reference, check match with existing reference in theme
		for(StyleSheet basereference : selectedStyleSheetsList) {

			// Flag for search
			boolean found = false;
			int i = 0;

			// Explore theme style s
			while(i < themeStyleSheetsList.size() && !found) {

				// Use own comparator to determine if style sheet reference exist
				found = StylesheetsComparator.instance.compare(themeStyleSheetsList.get(i), basereference) == 0;
				i++;
			}

			// Add selected reference only if it don't exist in theme
			if(!found) {
				mirrorList.add(basereference);
			}
		}

		// Set mirroring list as viewer input
		themeStyleSheetsViewer.setInput(mirrorList);

	}


	/**
	 * Refresh dialog area according to combo selection.
	 * 
	 * @param selection
	 *        selection which comes from combo viewer
	 */
	protected void refreshDialogContent(ISelection selection) {

		// Current selected theme
		currentTheme = null;

		// Get selected theme from combo
		if(selection instanceof IStructuredSelection) {
			Object selectedElement = ((IStructuredSelection)selection).getFirstElement();

			if(selectedElement instanceof Theme) {
				currentTheme = (Theme)selectedElement;
			}
		}

		// Refresh text field (label, icon path, ...)
		themeLabelField.setText(currentTheme.getLabel());
		iconPathfield.setText(currentTheme.getIcon());

		// 
		refreshTreeviewer(currentTheme);

	}


	/**
	 * Create contents of the button bar.
	 * 
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(450, 300);
	}

	/**
	 * @see org.eclipse.jface.dialogs.Dialog#isResizable()
	 *
	 * @return
	 */
	@Override
	protected boolean isResizable() {
		return true;
	}

	/**
	 * @see org.eclipse.jface.dialogs.Dialog#okPressed()
	 *
	 */
	@Override
	protected void okPressed() {
		setReturnTheme();
		super.okPressed();
	}



	/**
	 * Save dialog contents in current theme.
	 */
	private void setReturnTheme() {
		Object inputViewer = themeStyleSheetsViewer.getInput();

		// Update style sheets list of current theme
		currentTheme.getStylesheets().clear();
		if(inputViewer instanceof List<?>) {
			for(Object inputEntry : (List<?>)inputViewer) {

				// Verify if entry is a style sheet
				if(inputEntry instanceof StyleSheet) {
					currentTheme.getStylesheets().add((StyleSheet)inputEntry);
				}
			}
		}


	}

	/**
	 * @return last selected theme for edition
	 */
	public Theme getEditedTheme() {
		return currentTheme;
	}

	/**
	 * Comparator basic for style sheets. It compare path for reference and label for embedded.
	 */
	public static class StylesheetsComparator implements Comparator<StyleSheet> {

		public static final Comparator<StyleSheet> instance = new StylesheetsComparator();

		/**
		 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
		 *
		 * @param firstStyleSheet
		 * @param secondStyleSheet
		 * @return
		 */
		@Override
		public int compare(StyleSheet firstStyleSheet, StyleSheet secondStyleSheet) {

			// Default result for comparison
			boolean comparisonResult = false;
			String rightOperand = null;
			String leftOperand = null;

			if(firstStyleSheet instanceof StyleSheetReference && secondStyleSheet instanceof StyleSheetReference) {

				// Get both compared reference path
				rightOperand = ((StyleSheetReference)firstStyleSheet).getPath();
				leftOperand = ((StyleSheetReference)secondStyleSheet).getPath();

				// Use standard string comparison
				comparisonResult = rightOperand.equals(leftOperand);

			} else if(firstStyleSheet instanceof EmbeddedStyleSheet && secondStyleSheet instanceof EmbeddedStyleSheet) {

				// Get both of compared embedded label
				rightOperand = ((EmbeddedStyleSheet)firstStyleSheet).getLabel();
				leftOperand = ((EmbeddedStyleSheet)secondStyleSheet).getLabel();

				// Use standard string comparison
				comparisonResult = rightOperand.equals(leftOperand);
			}

			// Final comparison value
			int comparisonValue = -1;
			if(comparisonResult) {
				comparisonValue = 0;
			}

			return comparisonValue;
		}



	}

}
