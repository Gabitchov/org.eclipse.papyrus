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

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.team.collaborative.integration.papyrus.utils.PapyrusResourceUtils;
import org.eclipse.papyrus.team.collaborative.strategy.AbstractLockingStrategy;


/**
 * The Class AbstractResourceBaseStrategy.
 * Abstract class for strategy based on resources
 * TODO remove this class after release
 */
public abstract class AbstractResourceBaseStrategy extends AbstractLockingStrategy {



	/**
	 * Add all satellite resources (uml,di,notation).
	 * 
	 * @param ressourceSet
	 *        the ressource set
	 * @param uris
	 *        the uris
	 * @param uri
	 *        the uri
	 */
	protected void addExtraResources(ResourceSet ressourceSet, Collection<URI> uris, URI uri) {
		PapyrusResourceUtils.addExtraResources(ressourceSet, uris, uri);
	}
}
