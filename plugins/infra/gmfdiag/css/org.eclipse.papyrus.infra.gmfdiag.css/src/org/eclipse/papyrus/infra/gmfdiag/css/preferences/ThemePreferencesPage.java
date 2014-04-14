/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *	Gabriel Pascual (ALL4TEC) gabriel.pascual@all4tec.net - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.css.preferences;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.papyrus.infra.emf.providers.EMFContentProvider;
import org.eclipse.papyrus.infra.gmfdiag.common.helper.DiagramHelper;
import org.eclipse.papyrus.infra.gmfdiag.css.Activator;
import org.eclipse.papyrus.infra.gmfdiag.css.engine.WorkspaceCSSEngine;
import org.eclipse.papyrus.infra.gmfdiag.css.factory.ThemePropertyEditorFactory;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.EmbeddedStyleSheet;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StyleSheet;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StyleSheetReference;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StylesheetsPackage;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.Theme;
import org.eclipse.papyrus.infra.gmfdiag.css.theme.ThemeManager;
import org.eclipse.papyrus.infra.gmfdiag.css.widget.IDynamicFieldEditor;
import org.eclipse.papyrus.infra.gmfdiag.css.widget.InputComboFieldEditor;
import org.eclipse.papyrus.infra.widgets.editors.MultipleValueSelectorDialog;
import org.eclipse.papyrus.infra.widgets.providers.AbstractStaticContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.CollectionContentProvider;
import org.eclipse.papyrus.infra.widgets.selectors.ReferenceSelector;
import org.eclipse.papyrus.views.properties.creation.EcorePropertyEditorFactory;
import org.eclipse.papyrus.views.properties.creation.PropertyEditorFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 * A Preference page for selecting the Workspace CSS Theme
 * 
 * @author Camille Letavernier
 */
public class ThemePreferencesPage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	/** Label of theme field editor. */
	private static final String CURRENT_THEME_FIELD_LABEL = "Current theme:";

	/** Title of preference page. */
	private static final String PAGE_TITLE = "CSS Theme";

	/** Id of delete theme button. */
	private static final int DELETE_THEME_BUTTON_ID = 46;

	/** Id of new button. */
	private static final int NEW_BUTTON_ID = 45;

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

	/** Flag to define if refresh must be done. */
	public boolean needsRefresh = false;

	/** Main composite of preference page. */
	private Composite mainContainer = null;

	/** Field for label of theme. */
	private Text themeLabelField = null;

	/** Current selected theme. */
	protected Theme currentTheme = null;

	/** Field for icon path of theme. */
	private Text iconPathfield = null;

	/** Viewer for style sheets of current theme. */
	private TreeViewer themeStyleSheetsViewer = null;

	/** Label provider for treeviewer. */
	private LabelProvider labelProvider = null;

	/** Dynamic combo editor for select theme preference. */
	private IDynamicFieldEditor themesCombo = null;

	/** Array of all id's buttons which were added in dialog. */
	private Map<Integer, Button> buttonsMap = new HashMap<Integer, Button>();

	/** Editor factory for theme. */
	private PropertyEditorFactory editorFactory = new ThemePropertyEditorFactory(StylesheetsPackage.Literals.WORKSPACE_THEMES__THEMES);


	/**
	 * 
	 * Default constructor.
	 * 
	 */
	public ThemePreferencesPage() {
		super(PAGE_TITLE, org.eclipse.papyrus.infra.widgets.Activator.getDefault().getImageDescriptor("/icons/papyrus.png"), FieldEditorPreferencePage.GRID);
	}

	/**
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 *
	 * @param workbench
	 */

	public void init(IWorkbench workbench) {

		//Used default preference store to save current theme
		setPreferenceStore(Activator.getDefault().getPreferenceStore());

		// Set description for page 
		setDescription("Papyrus Theme preferences");
	}


	/**
	 * @see org.eclipse.jface.preference.FieldEditorPreferencePage#createContents(org.eclipse.swt.widgets.Composite)
	 *
	 * @param parent
	 * @return
	 */
	@Override
	protected Control createContents(Composite parent) {

		// Create principal layout
		mainContainer = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		mainContainer.setLayout(layout);
		mainContainer.setFont(parent.getFont());

		// Populate preference page
		createPreferenceThemePart(mainContainer);
		createThemeLabelPart(mainContainer);
		createThemeIconPart(mainContainer);
		createTreeActionButtons(mainContainer);
		createThemeStyleSheetsPart(mainContainer);

		// Initialize step
		initialize();
		checkState();


		return mainContainer;
	}

	/**
	 * Create part of page to select, add and remove theme.
	 * 
	 * @param parent
	 *        Parent composite where components will be added
	 */
	private void createPreferenceThemePart(Composite parent) {

		// Add theme field editor 
		createFieldEditors();
		Composite buttonsPanel = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.marginLeft = 0;
		layout.marginRight = 0;
		buttonsPanel.setLayout(layout);

		// Add buttons to delete and add theme
		createButton(buttonsPanel, NEW_BUTTON_ID, ADD_ICON, null);
		createButton(buttonsPanel, DELETE_THEME_BUTTON_ID, DELETE_ICON, null);
	}

	/**
	 * @see org.eclipse.jface.preference.FieldEditorPreferencePage#createFieldEditors()
	 *
	 */
	@Override
	protected void createFieldEditors() {
		//Get all themes define in application instance
		String[][] themes = getFieldThemes();

		themesCombo = new InputComboFieldEditor(ThemePreferences.CURRENT_THEME, CURRENT_THEME_FIELD_LABEL, themes, mainContainer);


		addField((FieldEditor)themesCombo);


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
		createButton(parent, BROWSE_BUTTON_ID, null, BROWSE_BUTTON_LABEL);
	}



	/**
	 * Open file dialog to choose icon.
	 */
	private void browseIconAction() {
		FileDialog fileDialog = new FileDialog(getShell());
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

		createButton(buttonsPanel, ADD_BUTTON_ID, ADD_ICON, null);
		createButton(buttonsPanel, DELETE_BUTTON_ID, DELETE_ICON, null);
		createButton(buttonsPanel, UP_BUTTON_ID, UP_ICON, null);
		createButton(buttonsPanel, DOWN_BUTTON_ID, DOWN_ICON, null);
		createButton(buttonsPanel, EDIT_BUTTON_ID, EDIT_ICON, null);

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
	protected Button createButton(Composite parent, int id, Image icon, String label) {
		((GridLayout)parent.getLayout()).numColumns++;
		Button button = new Button(parent, SWT.PUSH);
		button.setFont(JFaceResources.getDialogFont());
		button.setData(new Integer(id));
		button.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent event) {
				buttonPressed(((Integer)event.widget.getData()).intValue());
			}
		});

		if(label != null) {
			button.setText(label);
		}
		if(icon != null) {
			button.setImage(icon);
		}
		buttonsMap.put(new Integer(id), button);
		//setButtonLayoutData(button);
		return button;
	}

	/**
	 * @see org.eclipse.jface.dialogs.Dialog#buttonPressed(int)
	 *
	 * @param buttonId
	 */
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
			break;
		case NEW_BUTTON_ID:
			addThemeAction();
			break;
		case DELETE_THEME_BUTTON_ID:
			deleteThemeAction();
			break;
		default:
			//Nothing to do
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

		needsRefresh = true;

		refreshTreeviewer(currentTheme);
	}

	/**
	 * Refresh content of tree viewer according to selected theme/
	 * 
	 * @param currentTheme
	 *        Current theme
	 */
	private void refreshTreeviewer(Theme currentTheme) {


		boolean isEditatble = ThemeManager.instance.isEditable(currentTheme.getId());

		EList<StyleSheet> themeStyleSheetsList = currentTheme.getStylesheets();


		// Set mirroring list as viewer input
		themeStyleSheetsViewer.getTree().setEnabled(isEditatble);
		themeStyleSheetsViewer.setInput(themeStyleSheetsList);


		updateButtons(currentTheme);

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

				needsRefresh = true;
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

				needsRefresh = true;
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
				editorFactory.edit(buttonsMap.get(EDIT_BUTTON_ID), selectedObject);
				needsRefresh = true;
			}
		}


	}

	/**
	 * Create a theme.
	 */
	private void addThemeAction() {

		ThemeManager themeManager = ThemeManager.instance;
		Object createdObject = editorFactory.createObject(buttonsMap.get(NEW_BUTTON_ID), themeManager.getWorkspaceThemesPreferences());

		if(createdObject instanceof Theme) {

			themeManager.addTemporaryTheme((Theme)createdObject);
			currentTheme = (Theme)createdObject;

			themesCombo.setInput(getFieldThemes());
			themesCombo.setSelection(((Theme)createdObject).getId());
			refreshPreferencePage();
		}
	}

	/**
	 * Delete selected theme.
	 */
	private void deleteThemeAction() {
		ThemeManager themeManager = ThemeManager.instance;
		themeManager.delete(currentTheme);
		String[][] fieldThemes = getFieldThemes();
		themesCombo.setInput(fieldThemes);
		currentTheme = themeManager.getTheme(fieldThemes[0][1]);
		refreshPreferencePage();

	}

	/**
	 * 
	 * Update state of dialog buttons.
	 * 
	 * @param currentTheme
	 *        Selected theme which determine state of different buttons.
	 */
	private void updateButtons(Theme currentTheme) {
		boolean editionEnable = ThemeManager.instance.isEditable(currentTheme.getId());

		for(int buttonId : buttonsMap.keySet()) {
			switch(buttonId) {
			case ADD_BUTTON_ID:
			case BROWSE_BUTTON_ID:
				buttonsMap.get(buttonId).setEnabled(editionEnable);
				break;
			case DELETE_BUTTON_ID:
			case EDIT_BUTTON_ID:
				buttonsMap.get(buttonId).setEnabled(editionEnable && !currentTheme.getStylesheets().isEmpty());
				break;
			case UP_BUTTON_ID:
			case DOWN_BUTTON_ID:
				buttonsMap.get(buttonId).setEnabled(editionEnable && (currentTheme.getStylesheets().size() > 1));
			case DELETE_THEME_BUTTON_ID:
				buttonsMap.get(buttonId).setEnabled(ThemeManager.instance.isEditable(currentTheme.getId()));
			default:
				break;
			}

		}
	}


	/**
	 * @see org.eclipse.jface.dialogs.DialogPage#setButtonLayoutData(org.eclipse.swt.widgets.Button)
	 *
	 * @param button
	 * @return
	 */
	@Override
	protected GridData setButtonLayoutData(Button button) {
		GridData layoutData = null;

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
			layoutData = new GridData(SWT.FILL, SWT.FILL, false, false);
			button.setLayoutData(data);
			break;
		default:
			layoutData = super.setButtonLayoutData(button);
			break;
		}

		return layoutData;
	}

	/**
	 * @see org.eclipse.jface.preference.FieldEditorPreferencePage#propertyChange(org.eclipse.jface.util.PropertyChangeEvent)
	 *
	 * @param event
	 */

	@Override
	public void propertyChange(PropertyChangeEvent event) {
		super.propertyChange(event);
		if(ThemePreferences.CURRENT_THEME.equals(event.getProperty())) {
			needsRefresh = true;
		}
		if(FieldEditor.VALUE.equals(event.getProperty())) {
			FieldEditor fieldEditor = (FieldEditor)event.getSource();
			if(ThemePreferences.CURRENT_THEME.equals(fieldEditor.getPreferenceName())) {

				Object newValue = event.getNewValue();
				ThemeManager themeManager = ThemeManager.instance;

				currentTheme = themeManager.getTheme(String.valueOf(newValue));
				themesCombo.setInput(getFieldThemes());
				themesCombo.setSelection(String.valueOf(newValue));


				refreshPreferencePage();
			}
		}
	}

	/**
	 * Refresh dialog area according to combo selection.
	 * 
	 * @param selection
	 *        selection which comes from combo viewer
	 */
	protected void refreshPreferencePage() {

		// Refresh text field (label, icon path, ...)
		String themeLabel = currentTheme.getLabel();
		boolean editableTheme = ThemeManager.instance.isEditable(currentTheme.getId());
		needsRefresh = true;

		if(themeLabel == null) {
			themeLabel = "";
		}
		themeLabelField.setEnabled(editableTheme);
		themeLabelField.setText(themeLabel);


		String iconPath = currentTheme.getIcon();
		if(iconPath == null) {
			iconPath = "";
		}
		iconPathfield.setEnabled(editableTheme);
		iconPathfield.setText(iconPath);


		// Tree viewer
		refreshTreeviewer(currentTheme);

	}

	/**
	 * @see org.eclipse.jface.preference.FieldEditorPreferencePage#initialize()
	 *
	 */
	@Override
	protected void initialize() {
		String prefrenceValue = getPreferenceStore().getString(ThemePreferences.CURRENT_THEME);
		currentTheme = ThemeManager.instance.getTheme(prefrenceValue);
		refreshPreferencePage();
		super.initialize();
	}

	/**
	 * @see org.eclipse.jface.preference.PreferencePage#performApply()
	 *
	 */
	@Override
	protected void performApply() {
		super.performApply();
		themesCombo.setInput(getFieldThemes());
		refreshPreferencePage();

	}

	/**
	 * @see org.eclipse.jface.preference.FieldEditorPreferencePage#performOk()
	 *
	 * @return
	 */
	@Override
	public boolean performOk() {
		boolean result = super.performOk();
		if(needsRefresh) {
			WorkspaceCSSEngine.instance.reset();
			DiagramHelper.setNeedsRefresh();
			DiagramHelper.refreshDiagrams();
		}


		ThemeManager themeManager = ThemeManager.instance;
		themeManager.persist();
		return result;
	}

	/**
	 * 
	 * @see org.eclipse.jface.preference.PreferencePage#performCancel()
	 *
	 * @return
	 */
	@Override
	public boolean performCancel() {
		ThemeManager.instance.reloadThemes();
		ThemeManager.instance.clearTemporaryThemes();
		ThemeManager.instance.clearDeletedThemes();

		return super.performCancel();
	}


	/**
	 * @return Formatted themes list for combo field editor
	 */
	protected String[][] getFieldThemes() {

		// Use a manager to get all theme in application
		ThemeManager themeManager = ThemeManager.instance;
		themeManager.refreshThemes();
		List<Theme> themes = themeManager.getThemes();

		// Build theme list for combo editor
		String[][] result = new String[themes.size()][2];
		int i = 0;
		for(Theme theme : themes) {
			result[i][0] = theme.getLabel();
			result[i][1] = theme.getId();
			i++;
		}

		return result;
	}



}
