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
package org.eclipse.papyrus.infra.nattable.manager;

import java.io.IOException;
import java.io.Reader;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.infra.nattable.Activator;
import org.eclipse.papyrus.infra.nattable.dialog.PasteImportStatusDialog;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.messages.Messages;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.IPasteConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.NattableaxisconfigurationPackage;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.PasteEObjectConfiguration;
import org.eclipse.papyrus.infra.nattable.parsers.CSVParser;
import org.eclipse.papyrus.infra.nattable.parsers.CellIterator;
import org.eclipse.papyrus.infra.nattable.parsers.RowIterator;
import org.eclipse.papyrus.infra.nattable.provider.PasteEObjectAxisInNattableCommandProvider;
import org.eclipse.papyrus.infra.nattable.utils.AxisConfigurationUtils;
import org.eclipse.papyrus.infra.nattable.utils.CSVPasteHelper;
import org.eclipse.papyrus.infra.nattable.utils.CreatableEObjectAxisUtils;
import org.eclipse.papyrus.infra.nattable.utils.PasteConfigurationUtils;
import org.eclipse.papyrus.infra.nattable.utils.PasteEnablementStatus;
import org.eclipse.papyrus.infra.nattable.utils.PasteModeEnumeration;
import org.eclipse.swt.widgets.Display;

/**
 * 
 * Abstract class for the copy/paste and import file in the table
 * 
 */
public abstract class AbstractPasteImportInNattableManager {

	/**
	 * the helper used to do the paste (help for the split of the string)
	 */
	protected final CSVPasteHelper pasteHelper;

	/**
	 * the table manager
	 */
	protected final INattableModelManager tableManager;

	/**
	 * true if we must use progress monitor
	 */
	private boolean useProgressMonitorDialog;

	/**
	 * message in case of inverted table
	 */
	private static final String INVERTED_MESSAGE = Messages.AbstractPasteImportInNattableManager_INVERTED_MESSAGE;


	/**
	 * 
	 * Constructor.
	 * 
	 * @param pasteHelper
	 *        the helper used to do the paste (help for the split of the string)
	 */
	public AbstractPasteImportInNattableManager(final INattableModelManager tableManager, final CSVPasteHelper pasteHelper, final boolean useProgressMonitorDialog) {
		this.pasteHelper = pasteHelper;
		this.tableManager = tableManager;
		this.useProgressMonitorDialog = useProgressMonitorDialog;
	}



	/**
	 * This method manages the paste and the possible error dialog before doing the paste
	 * 
	 * @return
	 *         <code>true</code> if the paste can be done (as it is done in a job, it will be after the return of this method)
	 */
	public boolean doPaste() {
		if(this.tableManager.getTable().isInvertAxis()) {
			new PasteImportStatusDialog(Display.getDefault().getActiveShell(), INVERTED_MESSAGE).open();
			return false;
		}
		final PasteEnablementStatus pasteStatus = findPasteModeFromTableConfiguration(this.tableManager);
		if(pasteStatus.getPasteMode() == PasteModeEnumeration.PASTE_EOBJECT_ROW_OR_COLUMN) {
			boolean value = MessageDialog.openQuestion(Display.getDefault().getActiveShell(), PasteImportStatusDialog.DIALOG_TITLE, Messages.AbstractPasteImportInNattableManager_WhatAreYouPasting);
			if(value) {
				pasteStatus.getColumnStatus().add(new Status(IStatus.CANCEL, Activator.PLUGIN_ID, Messages.AbstractPasteImportInNattableManager_TheUserChosesToPasteRows));
			} else {
				pasteStatus.getRowStatus().add(new Status(IStatus.CANCEL, Activator.PLUGIN_ID, Messages.AbstractPasteImportInNattableManager_TheUserChosesToPasteColumns));
			}
		}
		PasteModeEnumeration pasteMode = pasteStatus.getPasteMode();
		switch(pasteMode) {
		case PASTE_NO_CONFIGURATION:
			return openPasteWithNoConfigurationDialog();
		case CANT_PASTE:
			return openCantPasteDialog(pasteStatus);
		case PASTE_EOBJECT_ROW:
			return pasteRow(this.tableManager, pasteStatus, pasteHelper);
		case PASTE_EOBJECT_COLUMN:
			return pasteColumn(this.tableManager, pasteStatus, pasteHelper);
		case PASTE_EOBJECT_ROW_OR_COLUMN:
			//nothing to do
			break;
		default:
			break;
		}

		return false;
	}


	/**
	 * 
	 * @param pasteStatus
	 *        the paste status
	 * @return
	 */
	private boolean openCantPasteDialog(final PasteEnablementStatus pasteStatus) {
		final MultiStatus rowStatus = pasteStatus.getRowStatus();
		final MultiStatus columnStatus = pasteStatus.getColumnStatus();
		if(rowStatus == null && columnStatus != null) {
			new PasteImportStatusDialog(Display.getCurrent().getActiveShell(), getFirstNonOKStatus(columnStatus).getMessage()).open();
		} else if(columnStatus == null && rowStatus != null) {
			new PasteImportStatusDialog(Display.getCurrent().getActiveShell(), getFirstNonOKStatus(rowStatus).getMessage()).open();
		} else if(columnStatus != null && rowStatus != null) {
			StringBuffer buffer = new StringBuffer(Messages.AbstractPasteImportInNattableManager_NoPasteConfiguration);
			buffer.append(Messages.AbstractPasteImportInNattableManager_PasteRowsError);
			buffer.append(getFirstNonOKStatus(rowStatus).getMessage());
			buffer.append(Messages.AbstractPasteImportInNattableManager_PasteColumnsError);
			buffer.append(getFirstNonOKStatus(columnStatus).getMessage());
			new PasteImportStatusDialog(Display.getDefault().getActiveShell(), buffer.toString()).open();
		} else {
			//never possible
			openPasteWithNoConfigurationDialog();
		}
		return true;
	}

	/**
	 * 
	 * @param status
	 *        a status
	 * @return
	 *         the first non ok status
	 */
	private IStatus getFirstNonOKStatus(final IStatus status) {
		if(status != null && !status.isOK()) {
			for(final IStatus current : status.getChildren()) {
				if(!current.isOK()) {
					if(current.isMultiStatus()) {
						return getFirstNonOKStatus(current);
					} else {
						return current;
					}
				}
			}
		}
		return null;
	}

	/**
	 * open the dialog used when the table has no paste configuration
	 * 
	 * @return
	 */
	private boolean openPasteWithNoConfigurationDialog() {
		new PasteImportStatusDialog(Display.getDefault().getActiveShell(), Messages.AbstractPasteImportInNattableManager_NoPasteConfiguration2, MessageDialog.INFORMATION).open();
		return true;
	}

	/**
	 * 
	 * @param manager
	 *        the table manager
	 * @param pasteStatus
	 *        the paste status
	 * @param pasteHelper
	 *        the paste helper
	 * @return
	 *         <code>true</code> if the paste can be done
	 */
	private boolean pasteColumn(final INattableModelManager manager, final PasteEnablementStatus pasteStatus, final CSVPasteHelper pasteHelper) {
		//TODO
		return false;
	}

	/**
	 * 
	 * @param manager
	 *        the table manager
	 * @param pasteStatus
	 *        the paste status
	 * @param pasteHelper
	 *        the paste helper
	 * @return
	 *         <code>true</code> if the paste can be done
	 */
	private boolean pasteRow(final INattableModelManager manager, final PasteEnablementStatus pasteStatus, final CSVPasteHelper pasteHelper) {
		final Reader reader = createReader();
		final IStatus status = verifyColumnCountOnFirstLine(manager, reader);
		try {
			reader.close();
		} catch (IOException e) {
			Activator.log.error(e);
		}
		if(status.isOK()) {
			paste(manager, pasteStatus, useProgressMonitorDialog, createReader(), getDataSize());
		} else {
			new PasteImportStatusDialog(Display.getDefault().getActiveShell(), status.getMessage()).open();
			return false;
		}
		return true;
	}


	/**
	 * 
	 * @param tableManager
	 *        the table manager
	 * @param reader
	 *        the reader to use to do parsing
	 * @return
	 *         a status indicating if the first line of the file allows to do the paste
	 */
	private IStatus verifyColumnCountOnFirstLine(final INattableModelManager tableManager, final Reader reader) {
		CSVParser parser = this.pasteHelper.createParser(reader);
		//we verify the nb of columns
		final RowIterator rowIter = parser.parse();
		int nbCell = 0;
		if(rowIter.hasNext()) {
			final CellIterator cellIter = rowIter.next();
			while(cellIter.hasNext()) {
				cellIter.next();
				nbCell++;
			}
		}
		final int axisCount = tableManager.getColumnCount();
		if(axisCount == nbCell) {
			return new Status(IStatus.OK, Activator.PLUGIN_ID, Messages.AbstractPasteImportInNattableManager_NumberOfColumnsAreEquals);
		} else {
			return new Status(IStatus.ERROR, Activator.PLUGIN_ID, NLS.bind(Messages.AbstractPasteImportInNattableManager_NumberOfColumnsAreNotEquals, nbCell, axisCount));
		}
	}



	/**
	 * 
	 * @param manager
	 *        the table manager
	 * @param status
	 *        the status
	 * @param useProgressMonitorDialog
	 *        if <code>true</code> a progress monitor will be used
	 * @param reader
	 *        the reader used to import data in the table.
	 * @param totalSize
	 *        the full size of the elements to import
	 */
	private void paste(final INattableModelManager manager, final PasteEnablementStatus status, final boolean useProgressMonitorDialog, final Reader reader, final long totalSize) {
		PasteEObjectAxisInNattableCommandProvider commandProvider = null;
		switch(status.getPasteMode()) {
		case PASTE_EOBJECT_ROW:
			commandProvider = new PasteEObjectAxisInNattableCommandProvider(manager, false, reader, this.pasteHelper, totalSize);
			break;
		case PASTE_EOBJECT_COLUMN:
			commandProvider = new PasteEObjectAxisInNattableCommandProvider(manager, true, reader, this.pasteHelper, totalSize);
			break;
		default:
			break;
		}
		//TODO : ask for the element to paste (column or row)!
		if(commandProvider != null) {
			commandProvider.executePasteFromStringCommand(useProgressMonitorDialog);
		}
	}

	/**
	 * 
	 * @param tableManager
	 *        the table manager used to calculate the enablement of the paste
	 * @return
	 *         the status for the paste
	 */
	private PasteEnablementStatus findPasteModeFromTableConfiguration(final INattableModelManager tableManager) {
		final MultiStatus pasteRowsStatus = canPasteAxis_verifyPasteConfiguration(tableManager, false);
		final MultiStatus pasteColumnsStatus = canPasteAxis_verifyPasteConfiguration(tableManager, true);
		final PasteEnablementStatus pasteStatus = new PasteEnablementStatus(pasteColumnsStatus, pasteRowsStatus);
		return pasteStatus;
	}

	/**
	 * 
	 * @param tableManager
	 *        teh table manager
	 * @param columnAxis
	 *        if <code>true</code> this method tests the paste configuration for the columns, if not, it tests the paste configuration for the rows
	 * @return
	 *         a multi status with information on all verified point in the table configuration or <code>null</code> when there is no table
	 *         configuration
	 */
	private static MultiStatus canPasteAxis_verifyPasteConfiguration(final INattableModelManager tableManager, final boolean columnAxis) {
		final IPasteConfiguration conf = (IPasteConfiguration)AxisConfigurationUtils.getIAxisConfigurationUsedInTable(tableManager.getTable(), NattableaxisconfigurationPackage.eINSTANCE.getPasteEObjectConfiguration(), columnAxis);
		final String pluginId = Activator.PLUGIN_ID;
		final String axisName = columnAxis ? Messages.AbstractPasteImportInNattableManager_column : Messages.AbstractPasteImportInNattableManager_row;
		MultiStatus status = null;
		if(conf instanceof PasteEObjectConfiguration) {
			status = new MultiStatus(pluginId, IStatus.OK, NLS.bind(Messages.AbstractPasteImportInNattableManager_EnablementStatusForPasteInTheTable, axisName), null);
			status.add(new Status(IStatus.OK, pluginId, NLS.bind(Messages.AbstractPasteImportInNattableManager_TheTableHasAConfigurationToPaste, axisName)));
			if(status.isOK()) {
				final PasteEObjectConfiguration pasteConfiguration = (PasteEObjectConfiguration)conf;
				status.add(PasteConfigurationUtils.hasConsistentPasteEObjectConfiguration(pasteConfiguration));

				//verify that the table context have the required feature
				if(status.isOK()) {
					final EStructuralFeature containmentFeature = pasteConfiguration.getPasteElementContainementFeature();
					if(tableManager.getTable().getContext().eClass().getEAllStructuralFeatures().contains(containmentFeature)) {
						status.add(new Status(IStatus.OK, pluginId, Messages.AbstractPasteImportInNattableManager_TheContextOfTheTableHasTheContainmentFeatureDefinedForThePaste));
					} else {
						status.add(new Status(IStatus.ERROR, pluginId, Messages.AbstractPasteImportInNattableManager_TheContextOfTheTableHasNotTheContainmentFeatureDefinedForThePaste));
					}

					//verify that the elements to create are supported by the axis manager
					if(status.isOK()) {
						final String elementId = pasteConfiguration.getPastedElementId();
						if(CreatableEObjectAxisUtils.getCreatableElementIds(tableManager, columnAxis).contains(elementId)) {
							status.add(new Status(IStatus.OK, pluginId, NLS.bind(Messages.AbstractPasteImportInNattableManager_TheTableCanCreateElement, elementId, axisName)));
						} else {
							status.add(new Status(IStatus.OK, pluginId, NLS.bind(Messages.AbstractPasteImportInNattableManager_TheTableCantCreateElement, elementId, axisName)));
						}
					}
				}
			}
		}
		return status;
	}

	/**
	 * 
	 * @return
	 *         a new reader
	 */
	protected abstract Reader createReader();

	/**
	 * 
	 * @return
	 *         the size of the copied data
	 */
	protected abstract long getDataSize();
}
