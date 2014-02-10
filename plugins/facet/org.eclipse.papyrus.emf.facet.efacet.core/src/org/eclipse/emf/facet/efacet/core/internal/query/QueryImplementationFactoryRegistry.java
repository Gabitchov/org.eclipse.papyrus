/*******************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Nicolas Bros (Mia-Software) - Bug 376941 - [EFacet] Facet operation arguments in Facet model
 *******************************************************************************/
package org.eclipse.emf.facet.efacet.core.internal.query;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.facet.efacet.core.IDerivedTypedElementManager;
import org.eclipse.emf.facet.efacet.core.exception.DerivedTypedElementException;
import org.eclipse.emf.facet.efacet.core.internal.Activator;
import org.eclipse.emf.facet.efacet.core.query.IQueryImplementation;
import org.eclipse.emf.facet.efacet.core.query.IQueryImplementationFactory;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.Query;
import org.eclipse.emf.facet.util.core.Logger;
import org.eclipse.emf.facet.util.emf.core.ICatalogSetManagerFactory;
import org.osgi.framework.Bundle;

public class QueryImplementationFactoryRegistry {
	private static final String EXT_ID = "org.eclipse.emf.facet.efacet.core.queryImplementationRegistration"; //$NON-NLS-1$
	private static final String CLASS = "class"; //$NON-NLS-1$
	public static final QueryImplementationFactoryRegistry INSTANCE = new QueryImplementationFactoryRegistry();

	private final List<IQueryImplementationFactory> factories = new ArrayList<IQueryImplementationFactory>();

	public QueryImplementationFactoryRegistry() {
		initRegisteredEntries();
	}

	private void initRegisteredEntries() {
		final IExtensionRegistry registry = Platform.getExtensionRegistry();
		final IExtensionPoint extPoint = registry.getExtensionPoint(QueryImplementationFactoryRegistry.EXT_ID);
		if (extPoint != null) {
			for (final IExtension ext : extPoint.getExtensions()) {
				for (final IConfigurationElement configElt : ext.getConfigurationElements()) {
					try {
						final Object impl = configElt.createExecutableExtension(QueryImplementationFactoryRegistry.CLASS);
						if (impl instanceof IQueryImplementationFactory) {
							final IQueryImplementationFactory factory = (IQueryImplementationFactory) impl;
							this.factories.add(factory);
						} else {
							Logger.logError("Invalid extension in " + ext.getNamespaceIdentifier() + "." + //$NON-NLS-1$ //$NON-NLS-2$
									". The factory must be an instance of " + IQueryImplementationFactory.class.getName(), Activator.getDefault()); //$NON-NLS-1$
						}
					} catch (final CoreException e) {
						Logger.logError(e, Activator.getDefault());
					}
				}
			}
		}
	}

	/**
	 * Returns the query evaluator that handles the given type of query
	 * 
	 * @param query
	 *            the type of query for which an {@link IQueryImplementation} is searched
	 * @return the {@link IQueryImplementation}
	 * @throws DerivedTypedElementException
	 *             if no factory implementation was registered for the type of the given query
	 */
	public IQueryImplementation getEvaluatorFor(final Query query, final IDerivedTypedElementManager manager)
			throws DerivedTypedElementException {
		if (query == null) {
			throw new IllegalArgumentException("query cannot be null"); //$NON-NLS-1$
		}
		IQueryImplementation queryImpl = null;
		boolean factoryFound = false;
		for (final IQueryImplementationFactory queryImplFactory : this.factories) {
			factoryFound = queryImplFactory.getManagedQueryType() == query.eClass();
			if (factoryFound) {
				final Resource queryResource = query.eResource();
				Bundle bundle = null;
				if (queryResource != null) {
					bundle = ICatalogSetManagerFactory.DEFAULT.createICatalogSetManager(query.eResource().getResourceSet()).getBundleByResource(queryResource);
				}
				queryImpl = queryImplFactory.create(query, bundle, manager);
				break;
			}
		}
		if (!factoryFound) {
			final StringBuffer buffer = new StringBuffer();
			buffer.append("No factory implementation found for "); //$NON-NLS-1$
			buffer.append(QueryUtils.getQueryDescription(query));
			buffer.append(".\nA factory should be registered through the "); //$NON-NLS-1$
			buffer.append(QueryImplementationFactoryRegistry.EXT_ID);
			buffer.append(" extension point."); //$NON-NLS-1$ // NOPMD: cannot merge with extracted constant string
			buffer.append("\nAvailable Query types are: "); //$NON-NLS-1$
			for (int i = 0; i < this.factories.size(); i++) {
				if (i > 0) {
					buffer.append(", "); //$NON-NLS-1$
				}
				final IQueryImplementationFactory factory = this.factories.get(i);
				buffer.append(factory.getManagedQueryType().getName());
			}
			throw new DerivedTypedElementException(buffer.toString());
		}
		return queryImpl;
	}
}
