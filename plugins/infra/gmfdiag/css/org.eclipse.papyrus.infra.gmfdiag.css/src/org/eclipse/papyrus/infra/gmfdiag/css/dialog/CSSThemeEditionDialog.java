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
import org.eclipse.papyrus.infra.widgets.editors.MultipleValueSelectorDialog;
import org.eclipse.papyrus.infra.widgets.providers.AbstractStaticContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.CollectionContentProvider;
import org.eclipse.papyrus.infra.widgets.selectors.ReferenceSelector;
import org.eclipse.papyrus.views.properties.creation.EcorePropertyEditorFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.FileDialog;
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

	/** Id of edit button. */
	private static final int EDIT_BUTTON_ID = 19;

	/** Id of down button. */
	private static final int DOWN_BUTTON_ID = 18;

	/** Id of up button. */
	private static final int UP_BUTTON_ID = 17;

	/** ID of delete button. */
	private static final int DELETE_BUTTON_ID = 15;

	/** ID of add button. */
	private static final int ADD_BUTTON_ID = 14;

	/** ID of browse buton. */
	private static final int BROWSE_BUTTON_ID = 16;

	/** Array of all id's buttons which were added in dialog. */
	private static int[] actionIdList = new int[]{ DOWN_BUTTON_ID, UP_BUTTON_ID, DELETE_BUTTON_ID, ADD_BUTTON_ID, BROWSE_BUTTON_ID, EDIT_BUTTON_ID };

	/** Title for add action dialog. */
	private static final String ADD_DIALOG_TITLE = "Style sheets selection";

	private static final Image EDIT_ICON = AbstractUIPlugin.imageDescriptorFromPlugin("org.eclipse.papyrus.infra.widgets", "icons/Edit_12x12.gif").createImage(); //$NON-NLS-1$ //$NON-NLS-2$

	/** Icon for delete action button. */
	private static final Image DELETE_ICON = AbstractUIPlugin.imageDescriptorFromPlugin("org.eclipse.papyrus.infra.widgets", "icons/Delete_12x12.gif").createImage(); //$NON-NLS-1$ //$NON-NLS-2$

	/** Icon for add action button. */
	private static final Image ADD_ICON = AbstractUIPlugin.imageDescriptorFromPlugin("org.eclipse.papyrus.infra.widgets", "icons/Add_12x12.gif").createImage(); //$NON-NLS-1$ //$NON-NLS-2$

	/** Icon for up action button. */
	private static final Image UP_ICON = AbstractUIPlugin.imageDescriptorFromPlugin("org.eclipse.papyrus.infra.widgets", "icons/Up_12x12.gif").createImage(); //$NON-NLS-1$ //$NON-NLS-2$

	/** Icon for down action button. */
	private static final Image DOWN_ICON = AbstractUIPlugin.imageDescriptorFromPlugin("org.eclipse.papyrus.infra.widgets", "icons/Down_12x12.gif").createImage(); //$NON-NLS-1$ //$NON-NLS-2$

	/** Text for style sheets list label. */
	private static final String STYLE_SHEETS_LABEL = "Style sheets";

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

	/** Factory to edit contents of dialog. */
	private EcorePropertyEditorFactory editorFactory = new EcorePropertyEditorFactory(StylesheetsPackage.eINSTANCE.getTheme_Stylesheets());

	/** Current edited theme. */
	private Theme currentTheme = null;

	/** Label provider for different composites. */
	private LabelProvider labelProvider = null;


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
		container.setLayout(new GridLayout(2, false));

		createEditedThemeComposite(container);
		createThemeLabelPart(container);
		createThemeIconPart(container);
		createTreeActionButtons(container);
		createThemeStyleSheetsPart(container);

		refreshDialogContent(null);

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
		themeLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
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
		combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
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
		themeNameLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
		themeNameLabel.setText(THEME_NAME_LABEL);

		// Add theme label field
		themeLabelField = new Text(parent, SWT.BORDER);
		GridData gd_text = new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1);
		themeLabelField.setLayoutData(gd_text);

		themeLabelField.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				currentTheme.setLabel(themeLabelField.getText());

			}
		});
	}

	/**
	 * Create theme icon part.
	 * 
	 * @param parent
	 *        Parent composite where components will be added
	 */
	private void createThemeIconPart(Composite parent) {
		Label iconLabel = new Label(parent, SWT.NONE);
		iconLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
		iconLabel.setText(THEME_ICON_LABEL);

		iconPathfield = new Text(parent, SWT.BORDER);
		iconPathfield.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		iconPathfield.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				currentTheme.setIcon(iconPathfield.getText());

			}
		});
		createButton(parent, BROWSE_BUTTON_ID, BROWSE_BUTTON_LABEL, false);
	}

	/**
	 * Open file dialog to choose icon.
	 */
	private void browseIconAction() {
		FileDialog fileDialog = new FileDialog(getParentShell());
		fileDialog.setFileName(iconPathfield.getText());
		String resultDialog = fileDialog.open();

		if(resultDialog != null) {
			iconPathfield.setText(resultDialog);
		}

	}

	/**
	 * Create theme style sheets part.
	 * 
	 * @param parent
	 *        Parent composite where components will be added
	 */
	private void createThemeStyleSheetsPart(Composite parent) {

		// Create viewer
		themeStyleSheetsViewer = new TreeViewer(parent, SWT.BORDER);

		// Set standard collection content provider
		themeStyleSheetsViewer.setContentProvider(CollectionContentProvider.instance);

		labelProvider = new LabelProvider() {

			/**
			 * @see org.eclipse.jface.viewers.LabelProvider#getText(java.lang.Object)
			 *
			 * @param element
			 * @return
			 */
			@Override
			public String getText(Object element) {

				// Use ancestor result as default
				String text = super.getText(element);

				// Display path of style sheet reference
				if(element instanceof StyleSheetReference) {
					text = ((StyleSheetReference)element).getPath();
				} else if(element instanceof EmbeddedStyleSheet) {
					text = ((EmbeddedStyleSheet)element).getLabel();
				}

				return text;
			}
		};
		themeStyleSheetsViewer.setLabelProvider(labelProvider);

		// Set layout
		Tree tree = themeStyleSheetsViewer.getTree();
		tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1));


	}

	/**
	 * Create actions associate to tree viewer.
	 * 
	 * @param parent
	 *        Composite where action buttons will be added
	 */
	private void createTreeActionButtons(Composite parent) {
		Label labelViewer = new Label(parent, SWT.NONE);
		labelViewer.setText(STYLE_SHEETS_LABEL);

		Composite buttonsPanel = new Composite(parent, SWT.NONE);
		buttonsPanel.setLayout(new GridLayout());
		buttonsPanel.setLayoutData(new GridData(SWT.RIGHT, SWT.FILL, true, false, 2, 1));

		createButton(buttonsPanel, ADD_BUTTON_ID, ADD_ICON, false);
		createButton(buttonsPanel, DELETE_BUTTON_ID, DELETE_ICON, false);
		createButton(buttonsPanel, UP_BUTTON_ID, UP_ICON, false);
		createButton(buttonsPanel, DOWN_BUTTON_ID, DOWN_ICON, false);
		createButton(buttonsPanel, EDIT_BUTTON_ID, EDIT_ICON, false);

	}


	/**
	 * Override method to create a button with an icon and no label.
	 * 
	 * @see org.eclipse.jface.dialogs.Dialog#createButton(Composite, int, String, boolean)
	 * 
	 * @param parent
	 * @param id
	 * @param icon
	 * @return
	 */
	protected Button createButton(Composite parent, int id, Image icon, boolean defaultButton) {
		Button button = super.createButton(parent, id, "", defaultButton);
		button.setImage(icon);
		return button;
	}

	/**
	 * 
	 * Override method to define specific data layout for own dialog's buttons.
	 * 
	 * @see org.eclipse.jface.dialogs.Dialog#setButtonLayoutData(org.eclipse.swt.widgets.Button)
	 *
	 * @param button
	 */
	@Override
	protected void setButtonLayoutData(Button button) {

		// Determine id of button
		Object data = button.getData();
		int buttonId = -1;
		if(data instanceof Integer) {
			buttonId = (Integer)data;
		}

		//Filter specific button to set data layout
		switch(buttonId) {
		case ADD_BUTTON_ID:
		case DELETE_BUTTON_ID:
		case UP_BUTTON_ID:
		case DOWN_BUTTON_ID:
		case EDIT_BUTTON_ID:
			button.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false));
			break;
		default:
			super.setButtonLayoutData(button);
			break;
		}


	}

	/**
	 * Delete current selection of tree viewer.
	 */
	private void deleteAction() {
		ISelection selection = themeStyleSheetsViewer.getSelection();

		if(selection instanceof IStructuredSelection) {
			Object selectedElement = ((IStructuredSelection)selection).getFirstElement();
			if(selectedElement instanceof StyleSheet) {
				currentTheme.getStylesheets().remove(selectedElement);
			}

			themeStyleSheetsViewer.setInput(currentTheme.getStylesheets());
			refreshTreeviewer(currentTheme);
		}

	}


	/**
	 * Open a dialog to add a style sheet to current selected theme.
	 */
	private void addAction() {


		ReferenceSelector selector = new ReferenceSelector(true);
		selector.setContentProvider(new EMFContentProvider(currentTheme, StylesheetsPackage.eINSTANCE.getTheme_Stylesheets()) {

			@Override
			protected IStructuredContentProvider getSemanticProvider(final EObject editedEObject, final EStructuralFeature feature) {

				// Use a standard content provider
				return new AbstractStaticContentProvider() {

					public Object[] getElements() {
						List<Object> result = new LinkedList<Object>();
						if(editedEObject instanceof Theme) {
							result.addAll(currentTheme.getStylesheets());
						}
						return result.toArray();
					}
				};
			}
		});
		selector.setLabelProvider(labelProvider);

		// Use common component for add dialog and parameterize it
		MultipleValueSelectorDialog vDialog = new MultipleValueSelectorDialog(getShell(), selector, ADD_DIALOG_TITLE);
		vDialog.setContextElement(currentTheme);
		vDialog.setLabelProvider(labelProvider);
		vDialog.setFactory(new EcorePropertyEditorFactory(StylesheetsPackage.Literals.THEME__STYLESHEETS));

		// Handle dialog result
		int result = vDialog.open();
		if(result == Dialog.OK) {

			Object[] resultArray = vDialog.getResult();
			refreshStyleSheets(resultArray);

		}
	}


	/**
	 * Move up the selected style sheet in list.
	 */
	private void upAction() {

		// Handle selection to extract selected style sheet
		ISelection selection = themeStyleSheetsViewer.getSelection();
		if(selection instanceof IStructuredSelection) {
			Object selectedElement = ((IStructuredSelection)selection).getFirstElement();

			if(selectedElement instanceof StyleSheet) {

				// Get index of selected style sheet in list
				EList<StyleSheet> stylesheetsList = currentTheme.getStylesheets();
				int index = stylesheetsList.indexOf(selectedElement);

				// Check if selected style sheet is not at top of list
				if(index > 0) {
					stylesheetsList.move(--index, (StyleSheet)selectedElement);
					themeStyleSheetsViewer.setInput(stylesheetsList);
				}
			}
		}
	}

	/**
	 * Move down the selected style sheet in list.
	 */
	private void downAction() {

		// Handle selection to extract selected style sheet
		ISelection selection = themeStyleSheetsViewer.getSelection();

		if(selection instanceof IStructuredSelection) {
			Object selectedElement = ((IStructuredSelection)selection).getFirstElement();

			if(selectedElement instanceof StyleSheet) {

				// Get index of selected style sheet in list
				EList<StyleSheet> stylesheetsList = currentTheme.getStylesheets();
				int index = stylesheetsList.indexOf(selectedElement);

				// Check if selected style sheet is not at bottom of list
				if(index < stylesheetsList.size() - 1) {
					stylesheetsList.move(++index, (StyleSheet)selectedElement);
					themeStyleSheetsViewer.setInput(stylesheetsList);
				}
			}
		}
	}


	/**
	 * Edit action on selected style sheet in tree viewer.
	 */
	private void editAction() {

		ISelection selection = themeStyleSheetsViewer.getSelection();

		if(selection instanceof IStructuredSelection) {
			Object selectedObject = ((IStructuredSelection)selection).getFirstElement();
			if(selectedObject instanceof StyleSheet) {
				// Use editor factory
				editorFactory.edit(getContents(), selectedObject);
			}
		}


	}


	/**
	 * Fill style sheets viewer with selected style sheets.
	 * 
	 * @param result
	 *        Result from dialog selection
	 */
	private void refreshStyleSheets(Object[] result) {

		// Complete current theme with dialog result
		for(Object object : result) {

			// Check if this is a style sheet
			if(object instanceof StyleSheet)
				currentTheme.getStylesheets().add((StyleSheet)object);
		}

		refreshTreeviewer(currentTheme);
	}


	/**
	 * Refresh content of tree viewer according to selected theme/
	 * 
	 * @param currentTheme
	 *        Current theme
	 */
	private void refreshTreeviewer(Theme currentTheme) {

		if(currentTheme != null) {

			EList<StyleSheet> themeStyleSheetsList = currentTheme.getStylesheets();


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
					themeStyleSheetsList.add(basereference);
				}
			}

			// Set mirroring list as viewer input
			themeStyleSheetsViewer.setInput(themeStyleSheetsList);
		}

		updateButtons(currentTheme);

	}


	/**
	 * 
	 * Update state of dialog buttons.
	 * 
	 * @param currentTheme
	 *        Selected theme which determine state of different buttons.
	 */
	private void updateButtons(Theme currentTheme) {
		boolean editionEnable = currentTheme != null;

		for(int buttonId : actionIdList) {
			switch(buttonId) {
			case ADD_BUTTON_ID:
			case BROWSE_BUTTON_ID:
				getButton(buttonId).setEnabled(editionEnable);
				break;
			case DELETE_BUTTON_ID:
			case EDIT_BUTTON_ID:
				getButton(buttonId).setEnabled(editionEnable && !currentTheme.getStylesheets().isEmpty());
				break;
			case UP_BUTTON_ID:
			case DOWN_BUTTON_ID:
				getButton(buttonId).setEnabled(editionEnable && (currentTheme.getStylesheets().size() > 1));
			default:
				break;
			}

		}

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



		boolean editionEnable = currentTheme != null;
		themeLabelField.setEditable(editionEnable);
		iconPathfield.setEditable(editionEnable);

		if(editionEnable) {

			// Refresh text field (label, icon path, ...)
			String themeLabel = currentTheme.getLabel();
			if(themeLabel == null) {
				themeLabel = "";
			}
			themeLabelField.setText(themeLabel);


			String iconPath = currentTheme.getIcon();
			if(iconPath == null) {
				iconPath = "";
			}
			iconPathfield.setText(iconPath);
		}

		// Tree viewer
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
	 * @see org.eclipse.jface.dialogs.Dialog#buttonPressed(int)
	 *
	 * @param buttonId
	 */
	@Override
	protected void buttonPressed(int buttonId) {
		switch(buttonId) {
		case ADD_BUTTON_ID:
			addAction();
			break;
		case DELETE_BUTTON_ID:
			deleteAction();
			break;
		case BROWSE_BUTTON_ID:
			browseIconAction();
			break;
		case UP_BUTTON_ID:
			upAction();
			break;
		case DOWN_BUTTON_ID:
			downAction();
			break;
		case EDIT_BUTTON_ID:
			editAction();
		default:
			super.buttonPressed(buttonId);
		}
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
