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
package org.eclipse.papyrus.team.collaborative.integration.papyrus.svn.queries;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.facet.infra.query.core.exception.ModelQueryExecutionException;
import org.eclipse.emf.facet.infra.query.core.java.IJavaModelQuery;
import org.eclipse.emf.facet.infra.query.core.java.ParameterValueList;
import org.eclipse.papyrus.team.collaborative.ICollaborativeManager;
import org.eclipse.papyrus.team.collaborative.IExtendedURI;
import org.eclipse.papyrus.team.collaborative.integration.papyrus.utils.PapyrusResourceUtils;
import org.eclipse.papyrus.team.collaborative.participants.locker.ILocker;
import org.eclipse.papyrus.team.collaborative.utils.CollabFunctionsFactory;

import com.google.common.collect.Collections2;
import com.google.common.collect.Sets;


/**
 * Return true if the element is a collab element
 * 
 * @author adaussy
 * 
 */
public class IsCollabQuery implements IJavaModelQuery<EObject, Boolean> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.facet.infra.query.core.java.IJavaModelQuery#evaluate(org.eclipse.emf.ecore.EObject,
	 * org.eclipse.emf.facet.infra.query.core.java.ParameterValueList)
	 */
	@Override
	public Boolean evaluate(EObject arg0, ParameterValueList arg1) throws ModelQueryExecutionException {
		List<URI> uris = new ArrayList<URI>();
		URI uri = arg0.eResource().getURI();
		ResourceSet resourceSet = arg0.eResource().getResourceSet();
		uris.add(uri);
		PapyrusResourceUtils.addExtraResources(resourceSet, uris, uri);
		Set<IExtendedURI> extendedURIS = Sets.newHashSet(Collections2.transform(uris, CollabFunctionsFactory.getURIToExtendedURIWithContainment()));
		ILocker locker = ICollaborativeManager.INSTANCE.getLocker(extendedURIS, resourceSet);
		if(locker == null) {
			return false;
		}
		boolean result = false;
		for(IExtendedURI extURI : extendedURIS) {
			if(locker.isLocked(extURI).isOK()) {
				result = true;
			}
		}
		return result;


	}

}
