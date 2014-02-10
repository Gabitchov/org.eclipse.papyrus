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
 *  Emmanuelle Rouillé (Mia-Software) - Bug 352618 - To be able to use non derived facet structural features and save them values.
 *  Nicolas Bros (Mia-Software) - Bug 361612 - New core for new version of the Facet metamodel
 *  Gregoire Dupe (Mia-Software) - Bug 362087 - [Deprecated] org.eclipse.emf.facet.util.emf.core.ICatalogSetManager
 *  Nicolas Bros (Mia-Software) - Bug 362191 - [Restructuring] Query mechanism for eFacet2
 *  Gregoire Dupe (Mia-Software) - Bug 369987 - [Restructuring][Table] Switch to the new customization and facet framework
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
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.facet.efacet.core.IDerivedTypedElementManager;
import org.eclipse.emf.facet.efacet.core.exception.DerivedTypedElementException;
import org.eclipse.emf.facet.efacet.core.internal.Activator;
import org.eclipse.emf.facet.efacet.core.query.IDerivedTypedElementImplementation;
import org.eclipse.emf.facet.efacet.core.query.IDerivedTypedElementImplementationFactory;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.Query;
import org.eclipse.emf.facet.util.core.Logger;
import org.eclipse.emf.facet.util.emf.core.ICatalogSetManagerFactory;
import org.osgi.framework.Bundle;

/** @deprecated replaced by {@link QueryImplementationFactoryRegistry}. No tracking bug because this API has not been released yet. */
@Deprecated
public class DerivedTypedElementImplementationFactoryRegistry {
	private static final String DERIVED_TYPED_ELEMENT_IMPLEMENTATION_REGISTRATION_ID = "org.eclipse.emf.facet.efacet.core.derivedTypedElementImplementationRegistration"; //$NON-NLS-1$
	private static final String CLASS = "class"; //$NON-NLS-1$
	public static final DerivedTypedElementImplementationFactoryRegistry INSTANCE = new DerivedTypedElementImplementationFactoryRegistry();

	private final List<IDerivedTypedElementImplementationFactory> derivedTypedElementImplementationFactories = new ArrayList<IDerivedTypedElementImplementationFactory>();

	public DerivedTypedElementImplementationFactoryRegistry() {
		initRegisteredEntries();
	}

	private void initRegisteredEntries() {
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IExtensionPoint extPoint = registry
				.getExtensionPoint(DerivedTypedElementImplementationFactoryRegistry.DERIVED_TYPED_ELEMENT_IMPLEMENTATION_REGISTRATION_ID);
		if (extPoint != null) {
			for (IExtension ext : extPoint.getExtensions()) {
				for (IConfigurationElement configElt : ext.getConfigurationElements()) {

					IDerivedTypedElementImplementationFactory derivedTypedElementImplementationFactory;
					try {
						derivedTypedElementImplementationFactory = (IDerivedTypedElementImplementationFactory) configElt
								.createExecutableExtension(DerivedTypedElementImplementationFactoryRegistry.CLASS);
						this.derivedTypedElementImplementationFactories.add(derivedTypedElementImplementationFactory);
					} catch (CoreException e) {
						Logger.logError(e, Activator.getDefault());
					}
				}
			}
		}
	}

	/**
	 * Returns the derived typed element evaluator that handles the given type of query
	 *
	 * @param query
	 *            the type of query for which an {@link IDerivedTypedElementImplementation} is searched
	 * @param derivedTEManager 
	 * @return the {@link IDerivedTypedElementImplementation}
	 * @throws DerivedTypedElementException
	 *             if no factory implementation was registered for the type of the given query
	 */
	public IDerivedTypedElementImplementation getEvaluatorFor(final Query query, final IDerivedTypedElementManager derivedTEManager)
			throws DerivedTypedElementException {
		if (query == null) {
			throw new IllegalArgumentException("query cannot be null"); //$NON-NLS-1$
		}
		IDerivedTypedElementImplementation derivedTypedElementImplementation = null;
		boolean factoryFound = false;
		for (IDerivedTypedElementImplementationFactory derivedTypedElementImplementationFactory : this.derivedTypedElementImplementationFactories) {
			factoryFound = derivedTypedElementImplementationFactory.getManagedQueryType() == query.eClass();
			if (factoryFound) {
				Resource queryResource = query.eResource();
				Bundle bundle;
				if (queryResource != null) {
					bundle = ICatalogSetManagerFactory.DEFAULT.createICatalogSetManager(query.eResource().getResourceSet()).getBundleByResource(queryResource);
				} else {
					bundle = null;
				}
				derivedTypedElementImplementation = derivedTypedElementImplementationFactory.create(query, bundle, derivedTEManager);
				break;
			}
		}
		if (!factoryFound) {
			StringBuffer sb = new StringBuffer();
			sb.append("No factory implementation found for "); //$NON-NLS-1$
			sb.append(QueryUtils.getQueryDescription(query));
			sb.append(".\nA factory should be registered through the " + DerivedTypedElementImplementationFactoryRegistry.DERIVED_TYPED_ELEMENT_IMPLEMENTATION_REGISTRATION_ID + " extension point."); //$NON-NLS-1$ //$NON-NLS-2$
			sb.append("\nAvailable Query types are: "); //$NON-NLS-1$
			for (int i = 0; i < this.derivedTypedElementImplementationFactories.size(); i++) {
				if (i > 0) {
					sb.append(", "); //$NON-NLS-1$
				}
				IDerivedTypedElementImplementationFactory queryEvaluatorFactory = this.derivedTypedElementImplementationFactories.get(i);
				sb.append(queryEvaluatorFactory.getManagedQueryType().getName());
			}
			throw new DerivedTypedElementException(sb.toString());
		}
		return derivedTypedElementImplementation;
	}
}
