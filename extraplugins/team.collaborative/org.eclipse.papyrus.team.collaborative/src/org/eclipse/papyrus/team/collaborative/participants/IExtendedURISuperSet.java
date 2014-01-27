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
package org.eclipse.papyrus.team.collaborative.participants;

import java.util.Set;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.team.collaborative.ExtendedURI;
import org.eclipse.papyrus.team.collaborative.IExtendedURI;
import org.eclipse.papyrus.team.collaborative.participants.locker.ILocker;
import org.eclipse.papyrus.team.collaborative.participants.locker.IUnlocker;
import org.eclipse.papyrus.team.collaborative.participants.version.ICommitter;
import org.eclipse.papyrus.team.collaborative.participants.version.IReverter;
import org.eclipse.papyrus.team.collaborative.participants.version.IUpdater;


/**
 * Interface which return a super set of set using specific rules.
 * 
 * @author adaussy
 */
public interface IExtendedURISuperSet extends ICollabParticipant {


	/**
	 * Return set of {@link ExtendedURI} which as to be used for an operation (see {@link ILocker}, {@link IUnlocker}, {@link IReverter},.
	 * 
	 * @return the extended set {@link ICommitter}, {@link IUpdater}
	 */
	Set<IExtendedURI> getExtendedSet();

	/**
	 * ResourceSet that is in use for those {@link ExtendedURI}.
	 * 
	 * @return the resource set
	 */
	ResourceSet getResourceSet();
}
