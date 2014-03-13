/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		 Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.wizard.pages;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.infra.nattable.Activator;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.messages.Messages;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.papyrus.infra.widgets.editors.AbstractEditor;
import org.eclipse.papyrus.infra.widgets.editors.ICommitListener;
import org.eclipse.papyrus.infra.widgets.editors.StringFileSelector;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

/**
 * 
 * Import page
 * 
 */
public class ImportFilePage extends WizardPage {

	/**
	 * allowed file to import table
	 */
	private static final String[] allowedFiles = new String[]{ "*.csv" }; //$NON-NLS-1$

	/**
	 * the selected file path
	 */
	private String selectedFilePath;

	/**
	 * the table manager where the import will be done
	 */
	private final INattableModelManager tableManager;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param pageName
	 *        the name of the import page
	 * @param title
	 *        the title of the page
	 * @param titleImage
	 *        the image for this page
	 * @param tableManager
	 *        the table manager where the import will be done
	 */
	public ImportFilePage(final String pageName, final String title, final ImageDescriptor titleImage, final INattableModelManager tableManager) {
		super(pageName, title, titleImage);
		setDescription(Messages.ImportFilePage_SelectTheFileToImport);
		this.tableManager = tableManager;
		this.selectedFilePath = null;
	}

	/**
	 * 
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 * 
	 * @param parent
	 */
	@Override
	public void createControl(final Composite parent) {
		final Composite localComposite = new Composite(parent, SWT.NONE);
		setControl(localComposite);
		final ILabelProvider labelProvider = getLabelProvider();
		Composite localParent = new Composite(localComposite, SWT.NONE);
		final Label label = new Label(localParent, SWT.NONE);
		label.setText(Messages.ImportFilePage_YourFileWillBeImported);
		final CLabel cLabel = new CLabel(localParent, SWT.NONE);
		cLabel.setText(tableManager.getTableName());

		final Label label2 = new Label(localParent, SWT.NONE);
		label2.setText(Messages.ImportFilePage_TheImportedElementWillBeAddedTo);
		final CLabel cLabel2 = new CLabel(localParent, SWT.NONE);
		cLabel2.setText(labelProvider.getText(tableManager.getTable().getContext()));
		cLabel2.setImage(labelProvider.getImage(tableManager.getTable().getContext()));


		cLabel.setImage(labelProvider.getImage(this.tableManager.getTable()));

		localParent.setLayout(new GridLayout(2, true));
		final StringFileSelector selector = new StringFileSelector(localComposite, SWT.NONE);
		selector.setAllowFileSystem(true);
		selector.setAllowWorkspace(true);
		selector.setFilterExtensions(allowedFiles);

		localComposite.setLayout(new GridLayout(1, true));
		selector.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		selector.getText().setEditable(false);
		selector.addCommitListener(new ICommitListener() {

			@Override
			public void commit(final AbstractEditor editor) {
				final Object value = selector.getValue();
				if(value instanceof String && ((String)value).length() > 0) {
					setFilePath((String)value);
					setPageComplete(isPageComplete());
				}
			}
		});

		final CLabel warningLabel = new CLabel(localComposite, SWT.NONE);
		warningLabel.setText(Messages.ImportFilePage_BeSureThatYourImportFileHasTheSameNumberOfColumns);
		warningLabel.setImage(org.eclipse.papyrus.infra.widgets.Activator.getDefault().getImage(Activator.PLUGIN_ID, "/icons/warning.gif")); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return
	 *         the label provider to use or <code>null</code> if not found
	 */
	protected ILabelProvider getLabelProvider() {
		LabelProviderService labelService = null;
		try {
			labelService = ServiceUtilsForEObject.getInstance().getService(LabelProviderService.class, tableManager.getTable());

		} catch (ServiceException e) {
			Activator.log.error("Label Provider Service Not Found", e); //$NON-NLS-1$
		}
		if(labelService != null) {
			return labelService.getLabelProvider();
		}
		return null;

	}

	/**
	 * 
	 * @see org.eclipse.jface.wizard.WizardPage#isPageComplete()
	 * 
	 * @return
	 */
	@Override
	public boolean isPageComplete() {
		return getFilePath() != null;
	}


	/**
	 * 
	 * @return
	 *         the selected file
	 */
	public String getFilePath() {
		return this.selectedFilePath;
	}

	/**
	 * 
	 * @param filePath
	 *        find the file from the filePath and set it
	 */
	protected void setFilePath(final String filePath) {
		if(filePath == null || filePath.length() == 0) {
			this.selectedFilePath = null;
		} else {
			this.selectedFilePath = filePath;
		}

	}

}
