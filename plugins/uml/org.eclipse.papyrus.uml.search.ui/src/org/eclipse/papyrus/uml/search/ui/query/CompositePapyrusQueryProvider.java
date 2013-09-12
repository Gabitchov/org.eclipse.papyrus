/*****************************************************************************
 * Copyright (c) 2013 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.search.ui.query;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.plugin.RegistryReader;
import org.eclipse.papyrus.uml.search.ui.Activator;


/**
 * A composite query provider that partitions the query scope according to the pluggable query providers that handle each URI and composes the
 * resulting queries into a synthesized whole.
 */
public class CompositePapyrusQueryProvider implements IPapyrusQueryProvider {

	private static final CompositePapyrusQueryProvider INSTANCE = new CompositePapyrusQueryProvider();

	private final Iterable<? extends IPapyrusQueryProvider> queryProviders;

	private CompositePapyrusQueryProvider() {
		super();

		this.queryProviders = loadQueryProviders();
	}

	public static IPapyrusQueryProvider getInstance() {
		return INSTANCE;
	}

	public boolean canProvideFor(URI scope) {
		// we never actually ask
		return true;
	}

	public AbstractPapyrusQuery createSimpleSearchQuery(QueryInfo queryInfo) {
		Map<IPapyrusQueryProvider, Collection<URI>> partitions = partitionSearchScope(queryInfo.getScope());
		List<AbstractPapyrusQuery> result = new java.util.ArrayList<AbstractPapyrusQuery>(partitions.size());

		for(Map.Entry<IPapyrusQueryProvider, Collection<URI>> next : partitions.entrySet()) {
			AbstractPapyrusQuery query = next.getKey().createSimpleSearchQuery(queryInfo.partition(next.getValue()));

			if(query != null) {
				result.add(query);
			}
		}

		return composite(result);
	}

	public AbstractPapyrusQuery createAdvancedSearchQuery(QueryInfo queryInfo) {
		Map<IPapyrusQueryProvider, Collection<URI>> partitions = partitionSearchScope(queryInfo.getScope());
		List<AbstractPapyrusQuery> result = new java.util.ArrayList<AbstractPapyrusQuery>(partitions.size());

		for(Map.Entry<IPapyrusQueryProvider, Collection<URI>> next : partitions.entrySet()) {
			AbstractPapyrusQuery query = next.getKey().createAdvancedSearchQuery(queryInfo.partition(next.getValue()));

			if(query != null) {
				result.add(query);
			}
		}

		return composite(result);
	}

	private AbstractPapyrusQuery composite(final List<? extends AbstractPapyrusQuery> queries) {
		AbstractPapyrusQuery result;

		if(queries.isEmpty()) {
			result = AbstractPapyrusQuery.Empty.INSTANCE;
		} else if(queries.size() == 1) {
			result = queries.get(0);
		} else {
			result = new CompositePapyrusQuery(queries);
		}

		return result;
	}

	Map<IPapyrusQueryProvider, Collection<URI>> partitionSearchScope(Collection<URI> scope) {
		Map<IPapyrusQueryProvider, Collection<URI>> result = new java.util.HashMap<IPapyrusQueryProvider, Collection<URI>>();

		Iterable<? extends IPapyrusQueryProvider> providers = getQueryProviders();
		for(URI next : scope) {
			for(IPapyrusQueryProvider provider : providers) {
				if(provider.canProvideFor(next)) {
					Collection<URI> myScope = result.get(provider);

					if(myScope == null) {
						// preserve order but ensure uniqueness
						myScope = new java.util.LinkedHashSet<URI>();
						result.put(provider, myScope);
					}

					myScope.add(next);
					break; // don't consult the next provider
				}
			}
		}

		return result;
	}

	private Iterable<? extends IPapyrusQueryProvider> loadQueryProviders() {
		return new ProvidersReader().load();
	}

	final Iterable<? extends IPapyrusQueryProvider> getQueryProviders() {
		List<IPapyrusQueryProvider> result = new ArrayList<IPapyrusQueryProvider>();

		synchronized(queryProviders) {
			for(IPapyrusQueryProvider next : queryProviders) {
				result.add(next);
			}
		}

		return result;
	}

	//
	// Nested types
	//

	private static class PriorityQueryProvider implements IPapyrusQueryProvider, Comparable<PriorityQueryProvider> {

		private final IPapyrusQueryProvider delegate;

		private final int priority;

		public PriorityQueryProvider(IPapyrusQueryProvider delegate, int priority) {
			this.delegate = delegate;
			this.priority = priority;
		}

		public int compareTo(PriorityQueryProvider o) {
			// sort by descending priority
			return o.priority - this.priority;
		}

		@Override
		public int hashCode() {
			return delegate.hashCode();
		}

		@Override
		public boolean equals(Object obj) {
			return (obj instanceof PriorityQueryProvider) && ((PriorityQueryProvider)obj).delegate.equals(delegate);
		}

		//
		// API delegation
		//

		public boolean canProvideFor(URI scope) {
			return delegate.canProvideFor(scope);
		}

		public AbstractPapyrusQuery createSimpleSearchQuery(QueryInfo queryInfo) {
			return delegate.createSimpleSearchQuery(queryInfo);
		}

		public AbstractPapyrusQuery createAdvancedSearchQuery(QueryInfo queryInfo) {
			return delegate.createAdvancedSearchQuery(queryInfo);
		}

	}

	private class ProvidersReader extends RegistryReader {

		private static final String EXT_PT = "queryProviders"; //$NON-NLS-1$

		private static final String TAG_PROVIDER = "queryProvider"; //$NON-NLS-1$

		private static final String ATTR_CLASS = "class"; //$NON-NLS-1$

		private static final String ATTR_PRIORITY = "priority"; //$NON-NLS-1$

		private final SortedSet<PriorityQueryProvider> providers = new java.util.TreeSet<PriorityQueryProvider>();

		ProvidersReader() {
			super(Platform.getExtensionRegistry(), Activator.PLUGIN_ID, EXT_PT);
		}

		Iterable<? extends IPapyrusQueryProvider> load() {
			synchronized(providers) {
				providers.clear();
				readRegistry();
			}

			return providers;
		}

		@Override
		protected boolean readElement(IConfigurationElement element, boolean add) {
			boolean result = false;

			if(TAG_PROVIDER.equals(element.getName())) {
				result = true;

				String className = element.getAttribute(ATTR_CLASS);
				if((className == null) || (className.length() == 0)) {
					logMissingAttribute(element, ATTR_CLASS);
				} else if(add) {
					addProvider(element, className);
				} else {
					removeProvider(element, className);
				}
			}

			return result;
		}

		private void addProvider(IConfigurationElement element, String className) {
			try {
				Object provider = element.createExecutableExtension(ATTR_CLASS);

				if(!(provider instanceof IPapyrusQueryProvider)) {
					Activator.log.error("Query provider extension does not implement IPapyrusQueryProvider interface: " + className, null); //$NON-NLS-1$
				} else {
					String priorityString = element.getAttribute(ATTR_PRIORITY);
					int priority = 0;

					try {
						if((priorityString) != null && (priorityString.length() > 0)) {
							priority = Integer.parseInt(priorityString);
							if(priority < 0) {
								Activator.log.warn("Negative priority in query provider " + className); //$NON-NLS-1$
								priority = 0;
							}
						}
					} catch (NumberFormatException e) {
						Activator.log.warn("Not an integer priority in query provider " + className); //$NON-NLS-1$
					}

					synchronized(providers) {
						providers.add(new PriorityQueryProvider((IPapyrusQueryProvider)provider, priority));
					}
				}
			} catch (CoreException e) {
				Activator.getDefault().getLog().log(e.getStatus());
			}
		}

		private void removeProvider(IConfigurationElement element, String className) {
			synchronized(providers) {
				for(Iterator<PriorityQueryProvider> iter = providers.iterator(); iter.hasNext();) {
					if(iter.next().delegate.getClass().getName().equals(className)) {
						iter.remove();
					}
				}
			}
		}
	}

}
