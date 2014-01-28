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
package org.eclipse.papyrus.team.collaborative.participants.locker;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.papyrus.team.collaborative.ExtendedURI;
import org.eclipse.papyrus.team.collaborative.IExtendedURI;
import org.eclipse.papyrus.team.collaborative.participants.IExtendedURISuperSet;


/**
 * Object to perform a lock
 * 
 * @author adaussy
 */
public interface ILocker extends IExtendedURISuperSet {


	/**
	 * Lock the element of {@link IExtendedURISuperSet#getExtendedSet()}
	 * 
	 * @return
	 * @throws CollabException
	 */
	IStatus lock();

	/**
	 * Return true if the {@link ExtendedURI} is locked
	 * 
	 * @return
	 */
	IStatus isLocked(IExtendedURI uri);

}
