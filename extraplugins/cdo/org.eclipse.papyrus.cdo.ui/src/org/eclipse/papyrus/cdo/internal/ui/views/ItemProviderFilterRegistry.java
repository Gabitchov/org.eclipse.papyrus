/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.cdo.internal.ui.views;

import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.plugin.RegistryReader;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.net4j.util.ui.views.IElementFilter;
import org.eclipse.papyrus.cdo.internal.core.CDOUtils;
import org.eclipse.papyrus.cdo.internal.ui.Activator;
import org.osgi.framework.Bundle;

import com.google.common.base.Predicate;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.collect.Maps;


/**
 * This is the ItemProviderFilterRegistry type. Enjoy.
 */
class ItemProviderFilterRegistry {

	static final ItemProviderFilterRegistry INSTANCE = new ItemProviderFilterRegistry();

	private final Map<String, Filter> filters = Maps.newHashMap();

	private ItemProviderFilterRegistry() {
		super();

		new MyRegistryReader().readRegistry();
	}

	public Predicate<Object> createFilter(ILabelProvider labelProvider) {
		return new CompositeFilter(labelProvider);
	}

	//
	// Nested types
	//

	final class CompositeFilter implements Predicate<Object> {

		private final ILabelProvider labelProvider;

		private final LabelWrapper labelWrapper = new LabelWrapper();

		CompositeFilter(ILabelProvider labelProvider) {
			super();

			this.labelProvider = labelProvider;
		}

		public boolean apply(Object input) {
			boolean result = true;

			if(!filters.isEmpty()) {
				labelWrapper.object = input;
				labelWrapper.label = labelProvider.getText(input);

				for(Iterator<Filter> iter = filters.values().iterator(); result && iter.hasNext();) {
					result = !iter.next().apply(labelWrapper);
				}
			}

			return result;
		}
	}

	static final class LabelWrapper {

		Object object;

		String label;

		LabelWrapper() {
			super();
		}
	}

	static abstract class Filter implements Predicate<LabelWrapper> {

		final String id;

		Filter(String id) {
			super();

			this.id = id;
		}

		String getID() {
			return id;
		}
	}

	static class LabelPatternFilter extends Filter {

		private final Pattern pattern;

		LabelPatternFilter(String id, String pattern) {
			super(id);

			this.pattern = Pattern.compile(pattern);
		}

		public boolean apply(LabelWrapper input) {
			return (input.label != null) && pattern.matcher(input.label).find();
		}

	}

	static class LabelPatternFilterWithObjectClass extends LabelPatternFilter {

		private final Class<?> objectClass;

		private final boolean adapt;

		LabelPatternFilterWithObjectClass(String id, String pattern, Class<?> objectClass, boolean adapt) {
			super(id, pattern);

			this.objectClass = objectClass;
			this.adapt = adapt;
		}

		@Override
		public boolean apply(LabelWrapper input) {
			return adapts(input.object) && super.apply(input);
		}

		private boolean adapts(Object object) {
			return adapt ? (CDOUtils.adapt(object, objectClass) != null) : objectClass.isInstance(object);
		}
	}

	static class ElementFilterFilter extends Filter {

		private final Supplier<? extends IElementFilter> filter;

		private boolean enabled;

		ElementFilterFilter(String id, Supplier<? extends IElementFilter> filter) {
			super(id);

			this.filter = filter;
		}

		public boolean apply(LabelWrapper input) {
			try {
				return enabled && filter.get().filter(input.object);
			} catch (Exception e) {
				Activator.log.error("Uncaught exception in element filter. Filter will be disabled.", e);
				enabled = false;
				return false;
			}
		}
	}

	static class PredicateFilter extends Filter {

		private final Supplier<? extends Predicate<Object>> predicate;

		private boolean enabled;

		PredicateFilter(String id, Supplier<? extends Predicate<Object>> predicate) {
			super(id);

			this.predicate = predicate;
		}

		public boolean apply(LabelWrapper input) {
			try {
				return enabled && predicate.get().apply(input.object);
			} catch (Exception e) {
				Activator.log.error("Uncaught exception in predicate. Filter will be disabled.", e);
				enabled = false;
				return false;
			}
		}
	}

	class MyRegistryReader extends RegistryReader {

		static final String EXT_PT = "repositoryFilters"; //$NON-NLS-1$

		static final String E_ITEM_PROVIDER_FILTER = "itemProviderFilter"; //$NON-NLS-1$

		static final String A_ID = "id"; //$NON-NLS-1$

		static final String E_LABEL_PATTERN = "labelPattern"; //$NON-NLS-1$

		static final String A_PATTERN = "pattern"; //$NON-NLS-1$

		static final String A_OBJECT_CLASS = "objectClass"; //$NON-NLS-1$

		static final String A_ADAPT = "adapt"; //$NON-NLS-1$

		static final String E_ELEMENT_FILTER = "elementFilter"; //$NON-NLS-1$

		static final String A_CLASS = "class"; //$NON-NLS-1$

		static final String A_SUPPLIER_CLASS = "supplierClass"; //$NON-NLS-1$

		static final String E_PREDICATE = "predicate"; //$NON-NLS-1$

		private String currentID;

		private IConfigurationElement currentConfig;

		MyRegistryReader() {
			super(Platform.getExtensionRegistry(), Activator.PLUGIN_ID, EXT_PT);
		}

		@Override
		protected boolean readElement(IConfigurationElement config, boolean add) {
			boolean result = true;

			final String name = config.getName();

			if(E_ITEM_PROVIDER_FILTER.equals(name)) {
				String id = config.getAttribute(A_ID);
				if(id == null) {
					result = false;
					logMissingAttribute(config, A_ID);
					currentID = null;
					currentConfig = null;
				} else {
					if(add) {
						if(currentID != null) {
							// haven't created the previous filter
							logError(currentConfig, String.format("Missing specification of filter %s.", currentID));
						}

						currentID = id;
						currentConfig = config;
					} else if(id != null) {
						removeFilter(id);
					}
				}
			} else if(add) { // don't need to process deletion of filter specifications, only filters
				if(currentID == null) {
					result = false;
					logError(config, String.format("Too many filter specifications."));
				} else if(filters.containsKey(currentID)) {
					result = false;
					logError(config, String.format("Duplicate filter ID \"%s\".  The duplicate is ignored.", currentID));
				} else {
					result = createFilter(config);
				}
			}

			return result;
		}

		void removeFilter(String id) {
			filters.remove(id);
		}

		boolean createFilter(IConfigurationElement config) {
			boolean result = false;

			final String name = config.getName();

			if(E_LABEL_PATTERN.equals(name)) {
				result = createLabelPatternFilter(config);
			} else if(E_ELEMENT_FILTER.equals(name)) {
				result = createElementFilterFilter(config);
			} else if(E_PREDICATE.equals(config)) {
				result = createPredicateFilter(config);
			}

			return result;
		}

		private void addFilter(Filter filter) {
			filters.put(currentID, filter);
			currentID = null;
			currentConfig = null;
		}

		boolean createLabelPatternFilter(IConfigurationElement config) {
			boolean result = true;

			String pattern = config.getAttribute(A_PATTERN);
			if(pattern == null) {
				logMissingAttribute(config, A_PATTERN);
				result = false;
			} else {
				Class<?> objectClass = null;
				String className = config.getAttribute(A_OBJECT_CLASS);

				if(className != null) {
					String bundleID = config.getContributor().getName();

					try {
						Bundle bundle = Platform.getBundle(bundleID);
						objectClass = bundle.loadClass(className);
					} catch (Exception e) {
						result = false;
						logError(config, String.format("Could not find class \"%s\" in bundle \"%s\".", className, bundleID));
					}
				}

				if(result) {
					try {
						if(objectClass == null) {
							addFilter(new LabelPatternFilter(currentID, pattern));
						} else {
							boolean adapt = false;
							String adaptAttr = config.getAttribute(A_ADAPT);
							if(adaptAttr != null) {
								adapt = Boolean.parseBoolean(adaptAttr);
							}

							addFilter(new LabelPatternFilterWithObjectClass(currentID, pattern, objectClass, adapt));
						}
					} catch (Exception e) {
						result = false;
						Activator.log.error(e);
						logError(config, String.format("Failed to initialize filter on pattern \"%s\".", pattern));
					}
				}
			}

			return result;
		}

		boolean createElementFilterFilter(IConfigurationElement config) {
			boolean result = true;

			String className = config.getAttribute(A_CLASS);
			String supplierClassName = config.getAttribute(A_SUPPLIER_CLASS);

			if((className == null) && (supplierClassName == null)) {
				result = false;
				logMissingAttribute(config, A_CLASS);
			} else if(className != null) {
				try {
					Object extension = config.createExecutableExtension(A_CLASS);
					if(!(extension instanceof IElementFilter)) {
						result = false;
						logError(config, String.format("Extension is not an IElementFilter: %s", extension.getClass().getName()));
					}

					addFilter(new ElementFilterFilter(currentID, Suppliers.ofInstance((IElementFilter)extension)));
				} catch (CoreException e) {
					result = false;
					Activator.log.error(e);
				}
			} else {
				try {
					Object extension = config.createExecutableExtension(A_CLASS);
					if(!(extension instanceof Supplier<?>)) {
						result = false;
						logError(config, String.format("Extension is not a Supplier<? extends IElementFilter>: %s", extension.getClass().getName()));
					}

					@SuppressWarnings("unchecked")
					Supplier<? extends IElementFilter> supplier = (Supplier<? extends IElementFilter>)extension;
					addFilter(new ElementFilterFilter(currentID, Suppliers.memoize(supplier)));
				} catch (CoreException e) {
					result = false;
					Activator.log.error(e);
				}
			}

			return result;
		}

		boolean createPredicateFilter(IConfigurationElement config) {
			boolean result = true;

			String className = config.getAttribute(A_CLASS);
			String supplierClassName = config.getAttribute(A_SUPPLIER_CLASS);

			if((className == null) && (supplierClassName == null)) {
				result = false;
				logMissingAttribute(config, A_CLASS);
			} else if(className != null) {
				try {
					Object extension = config.createExecutableExtension(A_CLASS);
					if(!(extension instanceof Predicate<?>)) {
						result = false;
						logError(config, String.format("Extension is not a Predicate<Object>: %s", extension.getClass().getName()));
					}

					@SuppressWarnings("unchecked")
					Predicate<Object> predicate = (Predicate<Object>)extension;
					addFilter(new PredicateFilter(currentID, Suppliers.ofInstance(predicate)));
				} catch (CoreException e) {
					result = false;
					Activator.log.error(e);
				}
			} else {
				try {
					Object extension = config.createExecutableExtension(A_CLASS);
					if(!(extension instanceof Supplier<?>)) {
						result = false;
						logError(config, String.format("Extension is not a Supplier<? extends Predicate<Object>>: %s", extension.getClass().getName()));
					}

					@SuppressWarnings("unchecked")
					Supplier<? extends Predicate<Object>> supplier = (Supplier<? extends Predicate<Object>>)extension;
					addFilter(new PredicateFilter(currentID, Suppliers.memoize(supplier)));
				} catch (CoreException e) {
					result = false;
					Activator.log.error(e);
				}
			}

			return result;
		}
	}
}
