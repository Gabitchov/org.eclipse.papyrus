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
package org.eclipse.papyrus.infra.nattable.wizard;

import java.io.File;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.papyrus.infra.nattable.Activator;
import org.eclipse.papyrus.infra.nattable.manager.ImportAxisInNattableManager;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.messages.Messages;
import org.eclipse.papyrus.infra.nattable.paste.PasteSeparator;
import org.eclipse.papyrus.infra.nattable.paste.TextDelimiter;
import org.eclipse.papyrus.infra.nattable.utils.CSVPasteHelper;
import org.eclipse.papyrus.infra.nattable.wizard.pages.ImportCSVConfigurationPage;
import org.eclipse.papyrus.infra.nattable.wizard.pages.ImportFilePage;
import org.eclipse.papyrus.infra.nattable.wizard.pages.ImportInvertedTableErrorPage;
import org.eclipse.papyrus.infra.nattable.wizard.pages.ImportTableErrorPage;
import org.eclipse.papyrus.infra.widgets.util.FileUtil;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IImportWizard;
import org.eclipse.ui.IWorkbench;

/**
 * 
 * This wizard allows to import a table in the Papyrus nattable editor
 * 
 */
public class ImportTableWizard extends Wizard implements IImportWizard {

	/**
	 * the import page
	 */
	private ImportFilePage importPage;

	/**
	 * the page used to configure the CSV import
	 */
	private ImportCSVConfigurationPage csvConfigurationPage;

	/**
	 * the nattable model manager to use for the import
	 */
	private INattableModelManager manager;


	/**
	 * 
	 * Constructor.
	 * 
	 */
	public ImportTableWizard() {
		setWindowTitle(Messages.ImportTableWizard_ImportTableFromFileInPapyrusModel);
		String pluginId = Activator.PLUGIN_ID;
		String path = "icons/importTablePapyrusWizban.png"; //$NON-NLS-1$
		ImageDescriptor desc = org.eclipse.papyrus.infra.widgets.Activator.getDefault().getImageDescriptor(pluginId, path);
		setDefaultPageImageDescriptor(desc);
	}

	/**
	 * 
	 * @see org.eclipse.ui.IWorkbenchWizard#init(org.eclipse.ui.IWorkbench, org.eclipse.jface.viewers.IStructuredSelection)
	 * 
	 * @param workbench
	 * @param selection
	 */
	@Override
	public void init(final IWorkbench workbench, final IStructuredSelection selection) {
		this.manager = getNattableModelManager(workbench, selection);
	}

	/**
	 * 
	 * @see org.eclipse.jface.wizard.Wizard#addPages()
	 * 
	 */
	@Override
	public void addPages() {
		final String pageTitle = Messages.ImportTableWizard_ImportTable;
		final ImageDescriptor desc = null;
		if(manager != null) {
			if(manager.getTable().isInvertAxis()) {
				addPage(new ImportInvertedTableErrorPage(Messages.ImportTableWizard_ImportTableError, pageTitle, desc));
			} else {
				this.importPage = new ImportFilePage(pageTitle, pageTitle, desc, this.manager);
				addPage(this.importPage);
				this.csvConfigurationPage = new ImportCSVConfigurationPage(pageTitle, Messages.ImportTableWizard_ConfigureImport, desc, PasteSeparator.SEMICOLON, TextDelimiter.DOUBLE_QUOTE);
				addPage(this.csvConfigurationPage);
			}
		} else {
			addPage(new ImportTableErrorPage(Messages.ImportTableWizard_ImportTableError, pageTitle, desc));
		}
	}


	/**
	 * 
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 * 
	 * @return
	 */
	@Override
	public boolean performFinish() {
		//the import file
		final File file = FileUtil.getFile(this.importPage.getFilePath());
		final CSVPasteHelper pasteHelper = new CSVPasteHelper(this.csvConfigurationPage.getSeparator(), this.csvConfigurationPage.getTextDelimiter(), ","); //$NON-NLS-1$
		final ImportAxisInNattableManager pasteManager = new ImportAxisInNattableManager(this.manager, pasteHelper, file, true);
		return pasteManager.doPaste();
	}

	/**
	 * 
	 * @param workbench
	 *        the current workbench
	 * @param selection
	 *        the current selection
	 * @return
	 *         the nattable manager to use to do the import
	 */
	private INattableModelManager getNattableModelManager(final IWorkbench workbench, final IStructuredSelection selection) {
		final IEditorPart editorPart = workbench.getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		if(editorPart != null) {
			return (INattableModelManager)editorPart.getAdapter(INattableModelManager.class);
		}
		return null;
	}


}
