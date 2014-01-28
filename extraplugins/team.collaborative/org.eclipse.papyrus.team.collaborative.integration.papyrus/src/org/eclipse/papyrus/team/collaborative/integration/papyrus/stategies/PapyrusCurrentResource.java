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
package org.eclipse.papyrus.team.collaborative.integration.papyrus.stategies;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.team.collaborative.IExtendedURI;
import org.eclipse.papyrus.team.collaborative.utils.CollabFunctionsFactory;
import org.eclipse.papyrus.team.collaborative.utils.ModelsUtil;

import com.google.common.collect.Collections2;
import com.google.common.collect.Sets;


/**
 * Strategy that will lock the current triplet resource of the selection (uml,di,notation).
 * 
 * @author adaussy
 */
public class PapyrusCurrentResource extends AbstractResourceBaseStrategy {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.team.collaborative.strategy.ILockingStrategy#getBusinessObject(java.util.Collection)
	 */
	@Override
	public Set<IExtendedURI> getBusinessObject(Collection<EObject> eOjbects) {
		if(!eOjbects.isEmpty()) {
			ResourceSet ressourceSet = eOjbects.iterator().next().eResource().getResourceSet();
			Collection<URI> uris = new HashSet<URI>();
			for(EObject o : ModelsUtil.getRoots(eOjbects)) {
				URI uri = o.eResource().getURI();
				if(!uris.contains(uri)) {
					uris.add(uri);
					addExtraResources(ressourceSet, uris, uri);
				}
			}
			return Sets.newHashSet(Collections2.transform(uris, CollabFunctionsFactory.getURIToExtendedURI()));
		}
		return Collections.emptySet();
	}




}
