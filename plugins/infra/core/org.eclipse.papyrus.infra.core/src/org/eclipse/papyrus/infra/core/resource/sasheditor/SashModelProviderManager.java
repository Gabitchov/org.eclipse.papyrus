/*
 * Copyright (c) 2014 CEA and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus (CEA) - Initial API and implementation
 *
 */
package org.eclipse.papyrus.infra.core.resource.sasheditor;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.papyrus.infra.core.Activator;
import org.eclipse.papyrus.infra.core.resource.ModelSet;

import com.google.common.base.Predicate;
import com.google.common.base.Strings;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;


/**
 * This is the SashModelProviderManager type. Enjoy.
 */
class SashModelProviderManager {

	private static final String E_PROVIDER = "sashModelProvider"; //$NON-NLS-1$

	private static final String EXT_PT = Activator.PLUGIN_ID + "." + E_PROVIDER; //$NON-NLS-1$

	private final ModelSet modelSet;

	private final ISashModelProvider defaultSashModelProvider;

	private final List<ProviderDescriptor> descriptors;

	SashModelProviderManager(ModelSet modelSet) {
		super();

		this.modelSet = modelSet;
		this.defaultSashModelProvider = createDefaultSashModelProvider();
		this.descriptors = new CopyOnWriteArrayList<SashModelProviderManager.ProviderDescriptor>(createDescriptors());
	}

	void dispose() {
		for(ProviderDescriptor next : descriptors) {
			next.dispose();
		}
	}

	/**
	 * Obtains the most appropriate sash model provider for the specified URI.
	 * 
	 * @param userModelURI
	 * 
	 * @return the sash model provider, never {@code null} (there is always a default available)
	 */
	ISashModelProvider getSashModelProvider(final URI userModelURI) {
		ISashModelProvider result = null;

		// We know at least the back-stop descriptor will match
		ProviderDescriptor descriptor = Iterables.find(descriptors, new Predicate<Predicate<URI>>() {

			@Override
			public boolean apply(Predicate<URI> input) {
				return input.apply(userModelURI);
			}
		});

		try {
			result = descriptor.getProvider();
		} catch (CoreException e) {
			Activator.getDefault().getLog().log(e.getStatus());
			result = defaultSashModelProvider;

			// Remove the offending descriptor
			descriptors.remove(descriptor);
		}

		return result;
	}

	private List<ProviderDescriptor> createDescriptors() {
		List<ProviderDescriptor> result = Lists.newArrayListWithExpectedSize(1);

		for(IConfigurationElement next : Platform.getExtensionRegistry().getConfigurationElementsFor(EXT_PT)) {
			if(E_PROVIDER.equals(next.getName())) {
				try {
					result.add(new ProviderDescriptor(next));
				} catch (CoreException e) {
					Activator.getDefault().getLog().log(e.getStatus());
				}
			}
		}

		// The back-stop that will match any URI not previously matched
		result.add(new ProviderDescriptor(defaultSashModelProvider));

		return result;
	}

	private ISashModelProvider createDefaultSashModelProvider() {
		return new AbstractSashModelProvider() {

			@Override
			public URI getSashModelURI(URI userModelURI) {
				final URI uriWithoutExtension = userModelURI.trimFileExtension();

				IPath stateLocation = Activator.getDefault().getStateLocation();

				if(uriWithoutExtension.isPlatform()) {
					stateLocation = stateLocation.append(uriWithoutExtension.toPlatformString(true));
				} else {
					//TODO properly support and test non-platform URIs that are not already handled by extensions
					stateLocation = stateLocation.append(URI.decode(uriWithoutExtension.toString()));
				}

				URI workspaceFileURI = URI.createFileURI(stateLocation.toString()).appendFileExtension(SashModel.SASH_MODEL_FILE_EXTENSION);

				return workspaceFileURI;
			}
		};
	}

	//
	// Nested types
	//

	private class ProviderDescriptor implements Predicate<URI> {

		private static final String A_SCHEME = "scheme"; //$NON-NLS-1$

		private static final String A_PATTERN = "pattern"; //$NON-NLS-1$

		private static final String A_CLASS = "class"; //$NON-NLS-1$

		private final IConfigurationElement config;

		private final String scheme;

		private final Pattern pattern;

		private ISashModelProvider provider;

		ProviderDescriptor(ISashModelProvider provider) {
			this.provider = provider;

			this.config = null;
			this.scheme = null;
			this.pattern = null;
		}

		ProviderDescriptor(IConfigurationElement config) throws CoreException {
			this.config = config;

			this.scheme = config.getAttribute(A_SCHEME);
			String pattern = config.getAttribute(A_PATTERN);

			if(Strings.isNullOrEmpty(scheme) && Strings.isNullOrEmpty(pattern)) {
				throw new CoreException(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Sash model provider missing both scheme and pattern filter.")); //$NON-NLS-1$
			}

			try {
				this.pattern = (pattern == null) ? null : Pattern.compile(pattern);
			} catch (PatternSyntaxException e) {
				throw new CoreException(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Invalid sash model provider URI pattern filter.", e)); //$NON-NLS-1$
			}
		}

		@Override
		public boolean apply(URI input) {
			return ((scheme == null) || scheme.equals(input.scheme())) // Scheme filter
				&& ((pattern == null) || pattern.matcher(input.toString()).find()); // Pattern filter
		}

		ISashModelProvider getProvider() throws CoreException {
			if(provider == null) {
				try {
					provider = (ISashModelProvider)config.createExecutableExtension(A_CLASS);
					provider.initialize(modelSet);
				} catch (CoreException e) {
					throw e;
				} catch (ClassCastException e) {
					throw new CoreException(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Invalid sash model provider implementation.", e)); //$NON-NLS-1$
				} catch (Exception e) {
					throw new CoreException(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Failed to initialize sash model provider implementation.", e)); //$NON-NLS-1$
				}
			}

			return provider;
		}

		void dispose() {
			if(provider != null) {
				try {
					provider.dispose();
				} catch (Exception e) {
					Activator.log.error("Failed to initialize sash model provider implementation.", e); //$NON-NLS-1$
				}

				provider = null;
			}
		}
	}
}
