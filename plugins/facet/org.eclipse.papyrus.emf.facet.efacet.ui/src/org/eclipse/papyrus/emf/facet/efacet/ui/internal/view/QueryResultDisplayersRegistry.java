/*******************************************************************************
 * Copyright (c) 2008, 2010, 2012 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Nicolas Bros (Mia-Software) - initial API and implementation
 *    Gregoire Dupe (Mia-Software) - Bug 364325 - [Restructuring] The user must be able to navigate into a model using the Facet.
 *******************************************************************************/

package org.eclipse.papyrus.emf.facet.efacet.ui.internal.view;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.papyrus.emf.facet.efacet.ui.IETypedElementResultDisplayer;
import org.eclipse.papyrus.emf.facet.efacet.ui.internal.Activator;
import org.eclipse.papyrus.emf.facet.util.core.Logger;
import org.eclipse.papyrus.emf.facet.util.core.internal.exported.AbstractRegistry;
import org.eclipse.osgi.util.NLS;

/**
 * The singleton registry of {@link IETypedElementResultDisplayer}s, which initializes
 * the registry by reading extensions when first accessed.
 */
//Copied from org.eclipse.papyrus.emf.facet.infra.query.ui.views.queryExecution.internal.QueryResultDisplayersRegistry
public class QueryResultDisplayersRegistry extends AbstractRegistry {

	private static final String EXTENSION_POINT_NAME = "eTypedElementResultDisplay"; //$NON-NLS-1$
	private static final String ELEMENT_QUERY_RESULT_DISPLAYER = "displayer"; //$NON-NLS-1$
	private static final String ATTRIBUTE_CLASS = "class"; //$NON-NLS-1$

	private static QueryResultDisplayersRegistry instance = null;

	private final List<IETypedElementResultDisplayer> queryResultDisplayers;

	public QueryResultDisplayersRegistry() {
		this.queryResultDisplayers = new ArrayList<IETypedElementResultDisplayer>();
		initialize();
	}

	public static QueryResultDisplayersRegistry getInstance() {
		if (QueryResultDisplayersRegistry.instance == null) {
			QueryResultDisplayersRegistry.instance = new QueryResultDisplayersRegistry();
		}
		return QueryResultDisplayersRegistry.instance;
	}

	public List<IETypedElementResultDisplayer> getQueryResultDisplayers() {
		return this.queryResultDisplayers;
	}

	public IETypedElementResultDisplayer getQueryResultDisplayer(final String name) {
		for (IETypedElementResultDisplayer namedQueryResultDisplayer : this.queryResultDisplayers) {
			if (name.equals(namedQueryResultDisplayer.getName())) {
				return namedQueryResultDisplayer;
			}
		}
		return null;
	}

	@Override
	protected String getExtensionPointName() {
		return QueryResultDisplayersRegistry.EXTENSION_POINT_NAME;
	}

	@Override
	protected String getExtensionPointNamespace() {
		return Activator.getDefault().getBundle().getSymbolicName();
	}

	@Override
	protected void handleRootElement(final IConfigurationElement configurationElement) {
		final String name = configurationElement.getName();
		if (name.equalsIgnoreCase(QueryResultDisplayersRegistry.ELEMENT_QUERY_RESULT_DISPLAYER)) {
			readQueryResultDisplayer(configurationElement);
		} else {
			logUnknownElement(configurationElement);
		}
	}

	private void readQueryResultDisplayer(final IConfigurationElement configurationElement) {
		Object queryResultDisplayerObject = null;
		try {
			queryResultDisplayerObject = configurationElement
					.createExecutableExtension(QueryResultDisplayersRegistry.ATTRIBUTE_CLASS);
		} catch (final CoreException e) {
			Logger.logError(e, Activator.getDefault());
		}
		if (queryResultDisplayerObject == null) {
			logMissingAttribute(configurationElement, QueryResultDisplayersRegistry.ATTRIBUTE_CLASS);
			return;
		}

		if (queryResultDisplayerObject instanceof IETypedElementResultDisplayer) {
			IETypedElementResultDisplayer queryResultDisplayer = (IETypedElementResultDisplayer) queryResultDisplayerObject;
			this.queryResultDisplayers.add(queryResultDisplayer);
		} else {
			logError(configurationElement, NLS.bind("The given class is not a {0}.", //$NON-NLS-1$
					IETypedElementResultDisplayer.class.getSimpleName()));
		}

	}
}
