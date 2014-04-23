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
package org.eclipse.papyrus.infra.gmfdiag.css.properties.dialog;

import java.io.File;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.BaseLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.utils.PapyrusImageUtils;
import org.eclipse.papyrus.infra.emf.providers.EMFContentProvider;
import org.eclipse.papyrus.infra.gmfdiag.css.Activator;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StyleSheetReference;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StylesheetsPackage;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.Theme;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.papyrus.infra.services.labelprovider.service.impl.LabelProviderServiceImpl;
import org.eclipse.papyrus.infra.widgets.editors.TreeSelectorDialog;
import org.eclipse.papyrus.infra.widgets.providers.AbstractStaticContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.WorkspaceContentProvider;
import org.eclipse.papyrus.infra.widgets.util.FileUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;


/**
 * Dialog to define a local theme from a selected CSS style.
 * 
 * @author gpascual
 */
public class CSSThemeCreationDialog extends Dialog {

	/** Title for icon selection dialog. */
	private static final String ICON_SELECTION_DIALOG_TITLE = "Icon selection";

	/** Label for workspace menu. */
	private static final String WORKSPACE_MENU_LABEL = "Workspace";

	/** Label for file system menu. */
	private static final String FILE_SYSTEM_MENU_LABEL = "File System";

	/** Id for file system menu item. */
	private static final int FILESYSTEM_MENU_ID = 15;

	/** Id for workspace menu item. */
	private static final int WORKSPACE_MENU_ID = 12;

	/** Label for browse button to select theme icon. */
	private static final String BROWSE_BUTTON_LABEL = "Browse...";

	/** List of valid extensions for an icon. */
	private static List<String> filterExtensions = Arrays.asList(new String[]{ "*.*", "*.gif", "*.png" });

	/** List of name associated to valid extensions. */
	private static List<String> filterNames = Arrays.asList(new String[]{ "All", "GIF Icon", "PNG Icon" });

	/** Text for dialog title. */
	private static final String DIALOG_TITLE = "CSS Theme Definition";

	/** Text for theme icon field. */
	private static final String ICON_PATH_LABEL = "Icon";

	/** Text for theme label field. */
	private static final String THEME_NAME_LABEL = "Label";

	/** Id of browse button. */
	private static final int BROWSE_BUTTON_ID = 13;

	/** Theme to definr with dialog. */
	private Theme theme = null;

	/** Theme label field. */
	private Text themeLabelField = null;

	/** Theme icon path field. */
	private Text iconPathField = null;

	/** Theme style sheets viewer. */
	private TreeViewer styleSheetsViewer = null;

	/** Menu of browse button to select theme icon. */
	private Menu browseMenu = null;

	/**
	 * Default constructor.
	 *
	 * @param parentShell
	 *        shell of parent widget
	 * @param theme
	 *        theme to edit
	 */
	public CSSThemeCreationDialog(Shell parentShell, Theme theme) {
		super(parentShell);

		// Set theme to edit
		this.theme = theme;
	}

	/**
	 * @see org.eclipse.jface.dialogs.Dialog#getInitialSize()
	 *
	 * @return
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(320, 360);
	}

	/**
	 * @see org.eclipse.jface.dialogs.Dialog#isResizable()
	 *
	 * @return
	 */
	@Override
	protected boolean isResizable() {

		// Set dialog resizable
		return true;
	}

	/**
	 * 
	 * @see org.eclipse.jface.window.Window#configureShell(org.eclipse.swt.widgets.Shell)
	 *
	 * @param newShell
	 */
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);

		// Add title and icon to dialog
		newShell.setText(DIALOG_TITLE);
		newShell.setImage(PapyrusImageUtils.getDefaultIcon());
	}


	/**
	 * @see org.eclipse.jface.dialogs.Dialog#createDialogArea(org.eclipse.swt.widgets.Composite)
	 *
	 * @param parent
	 * @return
	 */
	@Override
	protected Control createDialogArea(Composite parent) {

		// Create main container to dialog
		Composite mainComposite = (Composite)super.createDialogArea(parent);
		mainComposite.setLayout(new GridLayout(2, false));

		// Add different parts to dialog
		createThemeLabelPart(mainComposite);
		createThemeIconPart(mainComposite);
		createStyleSheetsTreeComposite(mainComposite);

		// Initialise tree viewer 
		initialiseTree();

		return mainComposite;
	}

	/**
	 * Create all components for theme label.
	 * 
	 * @param parent
	 *        Composite where components will be added
	 */
	private void createThemeLabelPart(Composite parent) {

		// Label for theme name field
		Label themeNameLabel = new Label(parent, SWT.NONE);
		themeNameLabel.setText(THEME_NAME_LABEL);

		// Field to edit theme label
		themeLabelField = new Text(parent, SWT.BORDER);
		GridData layoutData = new GridData(SWT.FILL, SWT.CENTER, true, false);
		layoutData.horizontalSpan = 2;
		themeLabelField.setLayoutData(layoutData);

		// Add behavior to text field
		themeLabelField.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				theme.setLabel(themeLabelField.getText());
			}
		});
	}

	/**
	 * Create all components for theme icon.
	 * 
	 * @param parent
	 *        Composite where components will be added
	 */
	private void createThemeIconPart(Composite parent) {

		//Label for theme icon field
		Label themeIconLabel = new Label(parent, SWT.NONE);
		themeIconLabel.setText(ICON_PATH_LABEL);

		// Field to edit icon path for theme
		iconPathField = new Text(parent, SWT.BORDER);
		iconPathField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		// Add behavior to text field
		iconPathField.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				theme.setIcon(iconPathField.getText());
			}
		});


		// Add browse button to help user
		Button browseButton = createButton(parent, BROWSE_BUTTON_ID, BROWSE_BUTTON_LABEL, false);

		browseMenu = new Menu(browseButton);

		createMenuItem(browseMenu, FILE_SYSTEM_MENU_LABEL, FILESYSTEM_MENU_ID);
		createMenuItem(browseMenu, WORKSPACE_MENU_LABEL, WORKSPACE_MENU_ID);

	}

	/**
	 * Create menu item.
	 * 
	 * @param parentMenu
	 *        Menu where it will be added
	 * @param label
	 *        Label of menu item
	 * @param menuId
	 */
	private void createMenuItem(Menu parentMenu, String label, int menuId) {

		MenuItem menuItem = new MenuItem(parentMenu, SWT.NONE);
		menuItem.setText(label);
		menuItem.setData(new Integer(menuId));
		menuItem.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				menuSelected(((Integer)e.widget.getData()).intValue());
			}
		});


	}

	/**
	 * Action to run when a menu is slected.
	 * 
	 * @param menuId
	 *        ID of selected menu
	 */
	private void menuSelected(int menuId) {
		switch(menuId) {
		case WORKSPACE_MENU_ID:
			browseWorkspace();
			break;
		case FILESYSTEM_MENU_ID:
			browseFileSytem();
			break;
		default:
			// Nothing to do 
			break;
		}
	}

	/**
	 * Browse file in file system.
	 */
	private void browseFileSytem() {
		File file = getFile(iconPathField.getText());

		FileDialog dialog = new FileDialog(getShell());
		dialog.setText(ICON_SELECTION_DIALOG_TITLE);

		dialog.setFileName(file.getAbsolutePath());
		dialog.setFilterExtensions(filterExtensions.toArray(new String[filterExtensions.size()]));
		dialog.setFilterNames(filterNames.toArray(new String[filterNames.size()]));
		String result = dialog.open();
		if(result == null) { //Cancel
			return;
		}
		setResult(result);
	}

	/**
	 * Browse file in workspace.
	 */
	private void browseWorkspace() {
		LabelProviderService labelProviderService = new LabelProviderServiceImpl();
		try {
			labelProviderService.startService();
		} catch (ServiceException ex) {
			Activator.log.error(ex);
		}

		ILabelProvider labelProvider = labelProviderService.getLabelProvider();

		IFile currentFile = getIFile(iconPathField.getText());

		TreeSelectorDialog dialog = new TreeSelectorDialog(getShell());
		dialog.setTitle(ICON_SELECTION_DIALOG_TITLE);


		WorkspaceContentProvider contentProvider = new WorkspaceContentProvider();


		if(!(filterExtensions.isEmpty() || filterNames.isEmpty())) {
			//The filters have been defined 
			contentProvider.setExtensionFilters(new LinkedHashMap<String, String>()); //Reset the default filters

			//Use our own filters
			for(int i = 0; i < Math.min(filterNames.size(), filterExtensions.size()); i++) {
				contentProvider.addExtensionFilter(filterExtensions.get(i), filterNames.get(i));
			}
		}

		dialog.setContentProvider(contentProvider);
		dialog.setLabelProvider(labelProvider);


		if(currentFile != null && currentFile.exists()) {
			dialog.setInitialSelections(new IFile[]{ currentFile });
		}

		int code = dialog.open();
		if(code == Window.OK) {
			Object[] result = dialog.getResult();
			if(result.length > 0) {
				Object file = result[0];
				if(file instanceof IFile) {
					setResult((IFile)file);
				}
			}
		}
	}

	/**
	 * @see org.eclipse.jface.dialogs.Dialog#buttonPressed(int)
	 *
	 * @param buttonId
	 */
	@Override
	protected void buttonPressed(int buttonId) {

		switch(buttonId) {
		case BROWSE_BUTTON_ID:
			browseMenu.setVisible(true);
			break;
		default:
			super.buttonPressed(buttonId);
			break;
		}

	}



	/**
	 * Sets the result.
	 *
	 * @param file
	 *        the new result
	 */
	protected void setResult(IFile file) {
		iconPathField.setText(file.getFullPath().toString());
	}

	/**
	 * Sets the result.
	 *
	 * @param file
	 *        the new result
	 */
	protected void setResult(File file) {
		iconPathField.setText(file.getAbsolutePath());

	}

	/**
	 * Sets the result.
	 *
	 * @param path
	 *        the new result
	 */
	protected void setResult(String path) {
		iconPathField.setText(path);

	}

	/**
	 * Gets the file.
	 *
	 * @param path
	 *        the path
	 * @return the i file
	 */
	protected IFile getIFile(String path) {
		return FileUtil.getIFile(path);
	}

	/**
	 * Gets the file.
	 *
	 * @param path
	 *        the path
	 * @return the file
	 */
	protected File getFile(String path) {
		return FileUtil.getFile(path);
	}



	/**
	 * Create composite containing style sheets viewer.
	 * 
	 * @param parent
	 *        Composite where components will be added
	 */
	private void createStyleSheetsTreeComposite(Composite parent) {

		styleSheetsViewer = new TreeViewer(parent, SWT.BORDER);
		Tree tree = styleSheetsViewer.getTree();
		tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1));
	}

	/**
	 * Initialise display of style sheets tree viewer.
	 */
	private void initialiseTree() {
		styleSheetsViewer.setContentProvider(new EMFContentProvider(theme, StylesheetsPackage.eINSTANCE.getTheme_Stylesheets()) {

			@Override
			protected IStructuredContentProvider getSemanticProvider(final EObject editedEObject, final EStructuralFeature feature) {

				// Use a standard content provider
				return new AbstractStaticContentProvider() {

					public Object[] getElements() {
						List<Object> result = new LinkedList<Object>();
						if(editedEObject instanceof Theme) {
							result.addAll(theme.getStylesheets());
						}
						return result.toArray();
					}
				};

			}
		});

		styleSheetsViewer.setLabelProvider(new StyleSheetLabelProvider());
		styleSheetsViewer.setInput(theme.getStylesheets());
	}


	/**
	 * Label provider for style sheets tree viwer.
	 * 
	 * @author gpascual
	 *
	 */
	private class StyleSheetLabelProvider extends BaseLabelProvider implements ILabelProvider {

		/**
		 * Default constructor.
		 *
		 */
		public StyleSheetLabelProvider() {
			super();
		}

		/**
		 * @see org.eclipse.jface.viewers.ILabelProvider#getImage(java.lang.Object)
		 *
		 * @param element
		 * @return
		 */
		public Image getImage(Object element) {
			return null;
		}

		/**
		 * @see org.eclipse.jface.viewers.ILabelProvider#getText(java.lang.Object)
		 *
		 * @param element
		 * @return
		 */
		public String getText(Object element) {
			String text = element.toString();

			if(element instanceof StyleSheetReference) {
				text = ((StyleSheetReference)element).getPath();
			}

			return text;
		}

	}

}
