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
package org.eclipse.papyrus.team.collaborative.core;

import java.util.Set;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.team.collaborative.core.participants.locker.ILocker;
import org.eclipse.papyrus.team.collaborative.core.participants.locker.IUnlocker;
import org.eclipse.papyrus.team.collaborative.core.participants.version.ICommitter;
import org.eclipse.papyrus.team.collaborative.core.participants.version.IReverter;
import org.eclipse.papyrus.team.collaborative.core.participants.version.IUpdater;


/**
 * Factory for creating all necessary participant for collaborative actions
 * 
 * @author adaussy
 * 
 */
public interface ICollabFactory {

	ILocker createLocker(Set<IExtendedURI> uris, ResourceSet resourceSet);

	IUnlocker createUnlocker(Set<IExtendedURI> uris, ResourceSet resourceSet);

	IReverter createReverter(Set<IExtendedURI> uris, ResourceSet resourceSet);

	ICommitter createCommitter(Set<IExtendedURI> uris, ResourceSet resourceSet);

	IUpdater createUpdater(Set<IExtendedURI> uris, ResourceSet resourceSet);

	boolean provide(Set<IExtendedURI> uris, ResourceSet resourceSet);

}
