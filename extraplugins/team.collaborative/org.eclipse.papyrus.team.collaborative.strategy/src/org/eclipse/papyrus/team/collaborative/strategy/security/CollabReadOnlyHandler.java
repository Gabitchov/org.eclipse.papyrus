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
package org.eclipse.papyrus.team.collaborative.strategy.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.core.resource.AbstractReadOnlyHandler;
import org.eclipse.papyrus.infra.core.resource.IReadOnlyHandler;
import org.eclipse.papyrus.infra.core.resource.ReadOnlyAxis;
import org.eclipse.papyrus.team.collaborative.core.ICollaborativeManager;
import org.eclipse.papyrus.team.collaborative.core.IExtendedURI;
import org.eclipse.papyrus.team.collaborative.core.participants.locker.ILocker;
import org.eclipse.papyrus.team.collaborative.core.utils.CollabFunctionsFactory;
import org.eclipse.papyrus.team.collaborative.strategy.ui.actions.LockAction;

import com.google.common.base.Optional;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;


/**
 * The Class CollabReadOnlyHandler.
 * This read only handler implement {@link IReadOnlyHandler} using the collaborative framework
 */
public class CollabReadOnlyHandler extends AbstractReadOnlyHandler {

	public CollabReadOnlyHandler(EditingDomain editingDomain) {
		super(editingDomain);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.readonly.IReadOnlyHandler#isReadOnly(org.eclipse.emf.common.util.URI[], org.eclipse.emf.edit.domain.EditingDomain)
	 */
	public Optional<Boolean> anyReadOnly(Set<ReadOnlyAxis> axes, URI[] uris) {
		if(uris != null && uris.length > 0 && getEditingDomain() != null && axes.contains(ReadOnlyAxis.PERMISSION)) {
			ArrayList<URI> urisList = Lists.newArrayList(uris);
			Collection<IExtendedURI> extendedURICollection = Collections2.transform(urisList, CollabFunctionsFactory.getURIToExtendedURIWithContainment());
			HashSet<IExtendedURI> extendURISet = Sets.newHashSet(extendedURICollection);
			ResourceSet resourceSet = getEditingDomain().getResourceSet();
			if(ICollaborativeManager.INSTANCE.isCollab(extendURISet, resourceSet)) {
				ILocker locker;
				locker = ICollaborativeManager.INSTANCE.getLocker(extendURISet, resourceSet);
				if(locker == null) {
					return Optional.absent();
				}
				for(IExtendedURI extendURI : locker.getExtendedSet()) {
					if(!locker.isLocked(extendURI).isOK()) {
						return Optional.of(true);
					}
				}
			}
		}
		return Optional.absent();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.readonly.IReadOnlyHandler#enableWrite(org.eclipse.emf.common.util.URI[], org.eclipse.emf.edit.domain.EditingDomain)
	 */
	public Optional<Boolean> makeWritable(Set<ReadOnlyAxis> axes, URI[] uris) {
		if(axes.contains(ReadOnlyAxis.PERMISSION)) {
			ArrayList<URI> urisList = Lists.newArrayList(uris);
			Collection<IExtendedURI> extendedURICollection = Collections2.transform(urisList, CollabFunctionsFactory.getURIToExtendedURIWithContainment());
			HashSet<IExtendedURI> extendedURISet = Sets.newHashSet(extendedURICollection);
			ResourceSet resourceSet = getEditingDomain().getResourceSet();
			if(ICollaborativeManager.INSTANCE.isCollab(extendedURISet, resourceSet)) {
				IStatus status = LockAction.doSafeLock(resourceSet, extendedURISet, true);
				if(!status.isOK()) {
					return Optional.absent();
				}
				return Optional.of(true);
			}
		}
		return Optional.absent();
	}
}