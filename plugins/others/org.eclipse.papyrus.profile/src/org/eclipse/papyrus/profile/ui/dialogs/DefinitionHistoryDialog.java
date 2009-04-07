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
 *  Chokri Mraidha (CEA LIST) Chokri.Mraidha@cea.fr - Initial API and implementation
 *  Patrick Tessier (CEA LIST) Patrick.Tessier@cea.fr - modification
 *
 *****************************************************************************/
package org.eclipse.papyrus.profile.ui.dialogs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ColumnLayoutData;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.profile.ImageManager;
import org.eclipse.papyrus.profile.definition.IPapyrusVersionConstants;
import org.eclipse.papyrus.profile.definition.PapyrusDefinitionAnnotation;
import org.eclipse.papyrus.profile.utils.Util;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.uml2.uml.Profile;


public class DefinitionHistoryDialog extends TitleAreaDialog {

	/** path to the banner image */  
	public final static String PROFILE_ANNOTATION_IMG = ImageManager.IMAGE_PATH+"wizban/Annotation.gif";

	/** Profile for which definitions are displayed */
	protected Profile profile;

	/** list of previous definition annotations */
	List<PapyrusDefinitionAnnotation> oldVersionAnnotations = new ArrayList<PapyrusDefinitionAnnotation>();

	/**
	 * Creates a new ProfileDefinitionDialog
	 * @param parentShell the parent shell for this dialog
	 * @param profile the profile for which definition history is displayed
	 */
	public DefinitionHistoryDialog(Shell parentShell, Profile profile) {
		super(parentShell);
		setShellStyle(getShellStyle() | SWT.RESIZE);
		this.profile = profile;

		computeHistoryAnnotations();
	}

	/**
	 * retrieve version annotation history
	 */
	private void computeHistoryAnnotations() {
		// get all annotations for the given profile
		oldVersionAnnotations = Util.getAllPapyrusDefinitionAnnotation(profile);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		// top level composite
		Composite parentComposite = (Composite) super.createDialogArea(parent);

		setTitle("Profile definition history"); 
		setTitleImage(ImageManager.getImage(PROFILE_ANNOTATION_IMG));

		// create a composite with standard margins and spacing
		Composite composite = new Composite(parentComposite, SWT.NONE);
		GridLayout layout = new GridLayout(1, true);
		layout.marginHeight = convertVerticalDLUsToPixels(IDialogConstants.VERTICAL_MARGIN);
		layout.marginWidth = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_MARGIN);
		layout.verticalSpacing = convertVerticalDLUsToPixels(IDialogConstants.VERTICAL_SPACING);
		layout.horizontalSpacing = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_SPACING);
		composite.setLayout(layout);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		composite.setFont(parentComposite.getFont());

		// fill composite with information about definitions:
		GridData gd;

		Composite tableArea = createTableArea(composite);
		gd = new GridData(SWT.FILL, SWT.FILL, true, true);
		tableArea.setLayoutData(gd);

		applyDialogFont(parentComposite);
		return parentComposite;
	}

	/**
	 * Creates and returns the content of the advanced area. 
	 * @param composite The parent composite to contain the advanced area
	 */
	private Composite createTableArea(Composite composite) {
		Composite parent= new Composite(composite, SWT.FILL);
		GridLayout layout = new GridLayout();
		parent.setLayout(layout);
		Font font = composite.getFont();

		TableViewer viewer = new TableViewer(parent, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.MULTI | SWT.FULL_SELECTION);
		final Table table = viewer.getTable();
		TableLayout tableLayout = new TableLayout();
		table.setLayout(tableLayout);
		table.setHeaderVisible(true);
		table.setFont(font);
		GridData gridData = new GridData(GridData.FILL_BOTH);
		gridData.widthHint = 450;
		gridData.heightHint = 300;
		viewer.getControl().setLayoutData(gridData);
		viewer.setContentProvider(new DefinitionHistoryContentProvider());
		viewer.setLabelProvider(new DefinitionHistoryTableLabelProvider());

		createTableColumn(table, 20, "version", true, SWT.CENTER);
		createTableColumn(table, 40, "author", true, SWT.CENTER);
		createTableColumn(table, 30, "date", true, SWT.CENTER);
		createTableColumn(table, 30, "comment", true, SWT.LEFT);
		createTableColumn(table, 50, "copyright", true, SWT.LEFT);

//		// display is a table with all history versions
//		final Table table = new Table(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
//		final TableColumn versionColumn = new TableColumn(table, SWT.CENTER);
//		versionColumn.setText("version");
//		final TableColumn dateColumn = new TableColumn(table, SWT.CENTER);
//		dateColumn.setText("date");
//		final TableColumn authorColumn = new TableColumn(table, SWT.CENTER);
//		authorColumn.setText("author");
//		final TableColumn commentColumn = new TableColumn(table, SWT.CENTER);
//		commentColumn.setText("comment");

//		GridData gd = new GridData(SWT.FILL, SWT.FILL, true, true);
//		table.setLayoutData(gd);

//		TableViewer viewer = new TableViewer(table);
		// configure viewer
		viewer.setContentProvider(new DefinitionHistoryContentProvider());
		viewer.setLabelProvider(new DefinitionHistoryTableLabelProvider());
		viewer.setInput(profile);

		return parent;
	}

	/**
	 * Creates table columns for the viewer
	 * @param table the modified table
	 * @param weight weight of the column (size)
	 * @param title title of the column
	 * @param resizable is the column resizable
	 * @return the create column
	 */
	protected TableColumn createTableColumn(Table table, int weight, String title, boolean resizable, int style) {
		((TableLayout)table.getLayout()).addColumnData(new ColumnWeightData(weight));
		final TableColumn tc = new TableColumn(table, style);
		tc.setResizable(true);
		tc.setText(title);
		return tc;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		setShellStyle(getShellStyle() | SWT.RESIZE);
		shell.setText("Profile Definition"); //$NON-NLS-1$
	}

	/**
	 * Content provider for table that displays information about Definition History
	 */
	public class DefinitionHistoryContentProvider implements IStructuredContentProvider {

		/**
		 * {@inheritDoc}
		 */
		public Object[] getElements(Object inputElement) {
			if(inputElement instanceof Profile) {
				// retrieve all definitions
				EAnnotation eAnnotation = ((Profile)inputElement).getEAnnotation("http://www.eclipse.org/uml2/2.0.0/UML");
				if (eAnnotation != null) {
					EList<EObject> definitions = eAnnotation.getContents();
					List<Object> elements = new ArrayList<Object>();
					// convert Papyrus Upgraded Annotation if possible (annotation with PapyrusVersion source added to the definition)
					Iterator<EObject> it = definitions.listIterator();
					while (it.hasNext()) {
						EPackage object = (EPackage) it.next();
						EAnnotation annotation = object.getEAnnotation(IPapyrusVersionConstants.PAPYRUS_EANNOTATION_SOURCE);
						if(annotation == null) {
							elements.add(0, PapyrusDefinitionAnnotation.UNDEFINED_ANNOTATION);
						} else {
							elements.add(0, PapyrusDefinitionAnnotation.parseEAnnotation(annotation));
						}
					}
					return elements.toArray();
				}
				return new Object[] {};
			}
			return new Object[] {};
		}

		/**
		 * {@inheritDoc}
		 */
		public void dispose() {
		}

		/**
		 * {@inheritDoc}
		 */
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}
	}

	/**
	 * Label provider for table that displays information about Definition History
	 */
	public class DefinitionHistoryTableLabelProvider implements ITableLabelProvider {

		/**
		 * {@inheritDoc}
		 */
		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}

		/**
		 * {@inheritDoc}
		 */
		public String getColumnText(Object element, int columnIndex) {
			if(element instanceof PapyrusDefinitionAnnotation) {
				return getColumnText((PapyrusDefinitionAnnotation)element, columnIndex);
			}
			// should never append
			return "naa";
		}

		/**
		 * Returns the label text for the given column index 
		 * @param annotation the annotation representing the entire row (should never be <code>null</code>)
		 * @param columnIndex the zero-based index of the column in which the label appears
		 * @return
		 */
		public String getColumnText(PapyrusDefinitionAnnotation annotation, int columnIndex) {
			switch (columnIndex) {
			case 0:
				return annotation.getVersion().toString();
			case 1:
				return annotation.getAuthor();
			case 2:
				return annotation.getDate();
			case 3:
				return annotation.getComment();
			case 4:
				return annotation.getCopyright();
			default:
				return "unknown";
			}
		}

		/**
		 * {@inheritDoc}
		 */
		public void addListener(ILabelProviderListener listener) {
		}

		/**
		 * {@inheritDoc}
		 */
		public void dispose() {
		}

		/**
		 * {@inheritDoc}
		 */
		public boolean isLabelProperty(Object element, String property) {
			return false;
		}

		/**
		 * {@inheritDoc}
		 */
		public void removeListener(ILabelProviderListener listener) {
		}
	}
}
