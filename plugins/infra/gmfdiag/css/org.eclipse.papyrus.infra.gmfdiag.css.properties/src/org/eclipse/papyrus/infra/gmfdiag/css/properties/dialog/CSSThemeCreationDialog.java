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

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.BaseLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.papyrus.infra.core.utils.PapyrusImageUtils;
import org.eclipse.papyrus.infra.emf.providers.EMFContentProvider;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StyleSheetReference;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StylesheetsPackage;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.Theme;
import org.eclipse.papyrus.infra.widgets.providers.AbstractStaticContentProvider;
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
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;


/**
 * Dialog to define a local theme from a selected CSS style.
 * 
 * @author gpascual
 */
public class CSSThemeCreationDialog extends Dialog {

	private static final String[] ICON_EXTENSION_FILTERS = new String[]{ "*.gif", "*.png" };

	private static final String BROWSE_BUTTON_LABEL = "Browse...";

	/** Text for dialog title. */
	private static final String DIALOG_TITLE = "CSS Theme Definition";

	/** Text for theme icon field. */
	private static final String ICON_PATH_LABEL = "Icon";

	/** Text for theme label field. */
	private static final String THEME_NAME_LABEL = "Label";

	private Theme theme = null;

	/** Theme label field. */
	private Text themeLabelField = null;

	/** Theme icon path field. */
	private Text iconPathField = null;

	/** Theme style sheets viewer. */
	private TreeViewer styleSheetsViewer;

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
		mainComposite.setLayout(new GridLayout(3, false));

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
		Button browseButton = new Button(parent, SWT.NONE);
		browseButton.setText(BROWSE_BUTTON_LABEL);

		browseButton.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {

				// Use file dialog for that user find icon
				FileDialog dialog = new FileDialog(getParentShell());
				dialog.setFilterExtensions(ICON_EXTENSION_FILTERS);

				String path = dialog.open();
				if(path != null) {
					iconPathField.setText(path);
				}



			}
		});
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
