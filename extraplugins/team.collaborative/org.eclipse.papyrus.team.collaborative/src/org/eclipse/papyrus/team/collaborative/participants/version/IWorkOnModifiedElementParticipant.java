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
package org.eclipse.papyrus.team.collaborative.participants.version;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.papyrus.team.collaborative.ExtendedURI;
import org.eclipse.papyrus.team.collaborative.IExtendedURI;
import org.eclipse.papyrus.team.collaborative.reports.CollabStatus;


/**
 * The Interface IWorkOnModifiedElementParticipant.
 * This kin of object are able to difference {@link ExtendedURI} which has been modified
 */
public interface IWorkOnModifiedElementParticipant {

	public static final CollabStatus MODIFIED_STATUS = CollabStatus.createErrorStatus("Modified file");

	/**
	 * Checks if the {@link ExtendedURI} has been modified.
	 * 
	 * @param uri
	 *        the uri
	 * @return the Istatus
	 * @throws CollabException
	 *         the collab exception
	 */
	IStatus isModified(IExtendedURI uri);

}
