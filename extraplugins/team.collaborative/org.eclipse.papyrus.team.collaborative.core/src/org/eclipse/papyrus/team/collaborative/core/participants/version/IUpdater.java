/*******************************************************************************
 * Copyright (c) 2013 Atos
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Arthur Daussy - initial implementation
 *******************************************************************************/
package org.eclipse.papyrus.team.collaborative.core.participants.version;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.papyrus.team.collaborative.core.Activator;
import org.eclipse.papyrus.team.collaborative.core.IExtendedURI;
import org.eclipse.papyrus.team.collaborative.core.participants.IExtendedURISuperSet;
import org.eclipse.papyrus.team.collaborative.core.reports.CollabStatus;


/**
 * Do an update action
 * 
 * @author adaussy
 * 
 * 
 */
public interface IUpdater extends IExtendedURISuperSet {

	/** The Constant NOT_UP_TO_DATE. */
	public static final CollabStatus NOT_UP_TO_DATE = CollabStatus.createErrorStatus("Not up to Date");


	/**
	 * Update element of {@link IExtendedURISuperSet#getExtendedSet()}
	 * 
	 * @return
	 * @throws CollabException
	 */
	IStatus update();

	/**
	 * Check if the elements has been modified
	 * 
	 * @param uri
	 * @return
	 * @throws CollabException
	 */
	UpToDateStatus isUpToDate(IExtendedURI uri);

	public static class UpToDateStatus extends CollabStatus {

		protected String author;

		protected Long date;

		protected Long revision;

		private UpToDateStatus(int severity, String pluginId, int code, String message, Throwable exception, String author, Long date, Long revision) {
			super(severity, pluginId, code, message, exception);
			this.author = author;
			this.date = date;
			this.revision = revision;
		}

		public static int UP_TO_DATE_CODE = 578463;

		public static int NOT_UP_TO_DATE_CODE = 578463;

		public static int ERROR_DURING_OPERATION_CODE = 578462;

		public boolean isUpToDate() {
			return getSeverity() < IStatus.ERROR && getCode() == UP_TO_DATE_CODE;
		}

		public static UpToDateStatus createUpToDataStatus(String author, Long date, Long revision) {
			return new UpToDateStatus(IStatus.OK, Activator.PLUGIN_ID, UP_TO_DATE_CODE, "Is up to date", null, author, date, revision);
		}

		public static UpToDateStatus createNotUpToDataStatus(String author, Long date, Long revision) {
			return new UpToDateStatus(IStatus.ERROR, Activator.PLUGIN_ID, NOT_UP_TO_DATE_CODE, "Is noy up to date", null, author, date, revision);
		}

		public static UpToDateStatus createErrorDuringUpToDataStatus(String message, Throwable e) {
			return new UpToDateStatus(IStatus.ERROR, Activator.PLUGIN_ID, ERROR_DURING_OPERATION_CODE, message, e, null, null, null);
		}


		public static UpToDateStatus createErrorDuringUpToDataStatus(String message) {
			return createErrorDuringUpToDataStatus(message, null);
		}




	}



}
