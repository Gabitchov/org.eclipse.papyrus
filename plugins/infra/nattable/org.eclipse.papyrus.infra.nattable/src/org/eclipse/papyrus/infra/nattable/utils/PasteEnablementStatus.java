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
package org.eclipse.papyrus.infra.nattable.utils;

import org.eclipse.core.runtime.MultiStatus;

/**
 * 
 * This class is used to store the tests about the paste capability of the table
 * 
 */
public class PasteEnablementStatus {

	/**
	 * the result of the tests to paste rows in the table
	 */
	private MultiStatus rowStatus;

	/**
	 * the result of the test to paste columns in the table
	 */
	private MultiStatus columnStatus;


	/**
	 * 
	 * Constructor.
	 * 
	 * @param columnStatus
	 *        the paste column status
	 * @param rowStatus
	 *        the paste row status
	 */
	public PasteEnablementStatus(final MultiStatus columnStatus, final MultiStatus rowStatus) {
		this.rowStatus = rowStatus;
		this.columnStatus = columnStatus;
	}

	/**
	 * 
	 * @return
	 *         the paste mode according to the row and column status
	 */
	public PasteModeEnumeration getPasteMode() {
		if(this.rowStatus == null && this.columnStatus == null) {
			return PasteModeEnumeration.PASTE_NO_CONFIGURATION;
		}
		if(this.rowStatus != null && this.columnStatus != null) {
			if(this.columnStatus.isOK() && this.rowStatus.isOK()) {
				return PasteModeEnumeration.PASTE_EOBJECT_ROW_OR_COLUMN;
			}
			if(this.columnStatus.isOK() && !this.rowStatus.isOK()) {
				return PasteModeEnumeration.PASTE_EOBJECT_COLUMN;
			}
			if(!this.columnStatus.isOK() && this.rowStatus.isOK()) {
				return PasteModeEnumeration.PASTE_EOBJECT_ROW;
			}
		}
		if(this.rowStatus != null && this.rowStatus.isOK() && this.columnStatus == null) {
			return PasteModeEnumeration.PASTE_EOBJECT_ROW;
		}
		if(this.columnStatus != null && this.rowStatus == null && this.columnStatus.isOK()) {
			return PasteModeEnumeration.PASTE_EOBJECT_COLUMN;
		}
		return PasteModeEnumeration.CANT_PASTE;
	}

	/**
	 * 
	 * @return
	 *         the column status
	 */
	public MultiStatus getColumnStatus() {
		return this.columnStatus;
	}

	/**
	 * 
	 * @return
	 *         the row status
	 */
	public MultiStatus getRowStatus() {
		return this.rowStatus;
	}


}
