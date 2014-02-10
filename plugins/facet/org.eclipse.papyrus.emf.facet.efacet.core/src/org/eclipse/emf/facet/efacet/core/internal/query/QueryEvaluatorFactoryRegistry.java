/**
 * Copyright (c) 2011 Mia-Software.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	Nicolas Guyomar (Mia-Software) - Bug 333553 - The user has not to deal with two files to create a facet
 *  Nicolas Guyomar (Mia-Software) - Bug 349566 - Need some new query utils method for query creation
 *  Nicolas Bros (Mia-Software) - Bug 361617 - Deprecation of APIs for the old Facet metamodels
 */
package org.eclipse.emf.facet.efacet.core.internal.query;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.facet.efacet.Query;
import org.eclipse.emf.facet.efacet.core.exception.QueryException;
import org.eclipse.emf.facet.efacet.core.internal.Activator;
import org.eclipse.emf.facet.efacet.core.query.IQueryEvaluator;
import org.eclipse.emf.facet.efacet.core.query.IQueryEvaluatorFactory;
import org.eclipse.emf.facet.util.core.Logger;
import org.eclipse.emf.facet.util.emf.core.ICatalogSetManager;

/** @deprecated replaced by {@link DerivedTypedElementImplementationFactoryRegistry} with the new eFacet2 metamodel */
@Deprecated
public class QueryEvaluatorFactoryRegistry {
	private static final String QUERY_EVALUATOR_REGISTRATION_ID = "org.eclipse.emf.facet.efacet.core.query.evaluatorregistration"; //$NON-NLS-1$
	private static final String CLASS = "class"; //$NON-NLS-1$
	public static final QueryEvaluatorFactoryRegistry INSTANCE = new QueryEvaluatorFactoryRegistry();

	private final List<IQueryEvaluatorFactory> queryEvaluatorFactories = new ArrayList<IQueryEvaluatorFactory>();

	public QueryEvaluatorFactoryRegistry() {
		initRegisteredEntries();
	}

	private void initRegisteredEntries() {
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IExtensionPoint extPoint = registry
				.getExtensionPoint(QueryEvaluatorFactoryRegistry.QUERY_EVALUATOR_REGISTRATION_ID);
		if (extPoint != null) {
			for (IExtension ext : extPoint.getExtensions()) {
				for (IConfigurationElement configElt : ext.getConfigurationElements()) {

					IQueryEvaluatorFactory queryEvaluatorFactory;
					try {
						queryEvaluatorFactory = (IQueryEvaluatorFactory) configElt
								.createExecutableExtension(QueryEvaluatorFactoryRegistry.CLASS);

						this.queryEvaluatorFactories.add(queryEvaluatorFactory);
					} catch (CoreException e) {
						Logger.logError(e, Activator.getDefault());
					}
				}
			}
		}
	}

	public IQueryEvaluator getEvaluatorFor(final Query query) throws QueryException {
		IQueryEvaluator queryEvaluator = null;
		boolean factoryFound = false;
		for (IQueryEvaluatorFactory queryEvaluatorFactory : this.queryEvaluatorFactories) {
			factoryFound = queryEvaluatorFactory.getManagedQueryType() == query.eClass();
			if (factoryFound) {
				queryEvaluator = queryEvaluatorFactory.create(query,
						ICatalogSetManager.INSTANCE.getBundleByResource(query.eResource()));
				break;
			}
		}
		if (!factoryFound) {
			StringBuffer sb = new StringBuffer();
			sb.append("No factory implementation found for: "); //$NON-NLS-1$
			sb.append(query.eClass().getName());
			sb.append(":"); //$NON-NLS-1$
			sb.append(query.getName());
			sb.append("\n Available Query types are: "); //$NON-NLS-1$
			for (IQueryEvaluatorFactory queryEvaluatorFactory : this.queryEvaluatorFactories) {
				sb.append(queryEvaluatorFactory.getManagedQueryType().getName());
				sb.append(", "); //$NON-NLS-1$
			}
			QueryException e = new QueryException(sb.toString());
			throw e;
		}
		return queryEvaluator;
	}

	public List<IQueryEvaluatorFactory> getInstalledQueryFactories() {
		return this.queryEvaluatorFactories;
	}

}
