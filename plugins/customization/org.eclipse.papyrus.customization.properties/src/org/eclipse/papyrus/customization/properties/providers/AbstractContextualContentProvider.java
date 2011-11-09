/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.customization.properties.providers;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.infra.widgets.providers.AbstractFilteredContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;
import org.eclipse.papyrus.views.properties.contexts.Context;
import org.eclipse.papyrus.views.properties.util.Util;

/**
 * An abstract implementation of {@link IStaticContentProvider} for
 * content providers which rely on the available {@link Context}s
 * to retrieve their elements.
 * 
 * @author Camille Letavernier
 * 
 */
public abstract class AbstractContextualContentProvider extends AbstractFilteredContentProvider implements IStaticContentProvider {

	/**
	 * The list of available contexts in the current model
	 */
	protected Collection<Context> contexts;

	/**
	 * The EObject used to retrieve the available contexts
	 */
	protected EObject source;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param source
	 *        The EObject used to retrieve the available contexts
	 */
	protected AbstractContextualContentProvider(EObject source) {
		contexts = findContexts(source);
		this.source = source;
		showIfHasVisibleParent = true;
	}

	private List<Context> findContexts(EObject source) {
		List<Context> contexts = new LinkedList<Context>();

		Context rootContext = null;
		if(source.eResource() != null) {
			for(Resource resource : source.eResource().getResourceSet().getResources()) {
				if(!resource.getContents().isEmpty() && resource.getContents().get(0) instanceof Context) {
					rootContext = (Context)resource.getContents().get(0);
					contexts.add(rootContext);
					break;
				}
			}
		}

		return Util.getDependencies(rootContext);
	}
}
