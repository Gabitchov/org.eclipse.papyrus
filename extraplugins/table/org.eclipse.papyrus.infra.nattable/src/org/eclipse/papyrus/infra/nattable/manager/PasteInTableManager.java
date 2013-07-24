/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.manager;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.IPasteConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.NattableaxisconfigurationPackage;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.PasteEObjectConfiguration;
import org.eclipse.papyrus.infra.nattable.provider.PasteEObjectAxisInTableCommandProvider;
import org.eclipse.papyrus.infra.nattable.utils.AxisConfigurationUtils;
import org.eclipse.papyrus.infra.nattable.utils.CreatableEObjectAxisUtils;
import org.eclipse.papyrus.infra.nattable.utils.PasteConfigurationUtils;
import org.eclipse.papyrus.infra.nattable.utils.PasteModeEnumeration;
import org.eclipse.papyrus.infra.nattable.utils.TableClipboardUtils;

/**
 * 
 * This class manager the paste into the table
 * 
 */
public class PasteInTableManager {

	/**
	 * 
	 * @param evaluationContext
	 *        the evaluation context
	 * @param tableManager
	 *        the table manager
	 * @return
	 *         the paste mode
	 */
	public PasteModeEnumeration getPasteMode(final Object evaluationContext, final INattableModelManager tableManager) {
		return getPasteMode(tableManager);
	}



	/**
	 * 
	 * @param tableManager
	 *        the table manager
	 * @param pasteMode
	 *        the paste mode
	 * @param useProgressMonitorDialog
	 *        if <code>true</code> we will use a progress monitor to do the paste
	 */
	public void paste(final INattableModelManager tableManager, final PasteModeEnumeration pasteMode, boolean useProgressMonitorDialog) {
		switch(pasteMode) {
		case PASTE_EOBJECT_COLUMN:
		case PASTE_EOBJECT_ROW:
		case PASTE_EOBJECT_ROW_OR_COLUMN:
			PasteEObjectAxisInTableCommandProvider commandProvider = new PasteEObjectAxisInTableCommandProvider(tableManager, pasteMode);
			commandProvider.executePasteFromStringCommand(useProgressMonitorDialog);
			commandProvider.dispose();
			break;
		default:
			break;
		}
	}

	/**
	 * 
	 * @param tableManager
	 *        the table manager
	 * @return
	 *         a java enumeration literal indicating the way to do the paste
	 */
	private static final PasteModeEnumeration getPasteMode(final INattableModelManager tableManager) {
		PasteModeEnumeration result = PasteModeEnumeration.CANT_PASTE;
		boolean canPasteColumns = canPasteAxis(tableManager, true);
		boolean canPasteRows = canPasteAxis(tableManager, false);
		if(canPasteColumns && canPasteRows) {
			result = PasteModeEnumeration.PASTE_EOBJECT_ROW_OR_COLUMN;
		} else if(canPasteColumns) {
			result = PasteModeEnumeration.PASTE_EOBJECT_COLUMN;
		} else if(canPasteRows) {
			result = PasteModeEnumeration.PASTE_EOBJECT_ROW;
		}
		return result;
	}


	/**
	 * 
	 * @param tableManager
	 *        the table manager
	 * @return
	 *         <code>true</code> if the contents of the clipboard contains the same number of columns than the table manager displays
	 */
	private static boolean canPasteAxis(final INattableModelManager tableManager, boolean columnAxis) {
		final IPasteConfiguration conf = (IPasteConfiguration)AxisConfigurationUtils.getIAxisConfigurationUsedInTable(tableManager.getTable(), NattableaxisconfigurationPackage.eINSTANCE.getPasteEObjectConfiguration(), columnAxis);
		boolean result = conf instanceof PasteEObjectConfiguration;
		PasteEObjectConfiguration pasteConfiguration = (PasteEObjectConfiguration)conf;
		result = result && PasteConfigurationUtils.hasConsistentPasteEObjectConfiguration(pasteConfiguration);

		//verify that the table context have the required feature
		if(result) {
			final EStructuralFeature containmentFeature = pasteConfiguration.getPasteElementContainementFeature();
			result = result && tableManager.getTable().getContext().eClass().getEAllStructuralFeatures().contains(containmentFeature);
		}
		//verify that the elements to create are supported by the axis manager
		if(result) {
			final String elementId = pasteConfiguration.getPastedElementId();
			result = result && CreatableEObjectAxisUtils.getCreatableElementIds(tableManager, columnAxis).contains(elementId);
		}
		if(result) {
			final String[] axis;
			final int axisCount;
			if(columnAxis) {
				axis = TableClipboardUtils.getColumnsFromClipboard();
				axisCount = tableManager.getRowCount();
			} else {
				axis = TableClipboardUtils.getRowsFromClipboard();
				axisCount = tableManager.getColumnCount();
			}

			if(axis != null && axis.length > 0) {
				int nbAxis = TableClipboardUtils.getCells(axis[0]).length;
				result = axisCount == nbAxis;
			}
		}
		return result;
	}

}
