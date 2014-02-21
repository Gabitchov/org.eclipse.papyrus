/*******************************************************************************
 * Copyright (c) 2009-2012 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Gregoire Dupe (Mia-Software)
 *    Nicolas Bros (Mia-Software)
 *    Nicolas Bros (Mia-Software) - Bug 375054 - Add validation warning for overlay on EClass
 *******************************************************************************/
package org.eclipse.emf.facet.common.sdk.core.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.facet.common.sdk.core.internal.exported.CommonConstants;
import org.eclipse.emf.facet.common.sdk.core.internal.exported.IEmfFacetProjectBuilder;
import org.eclipse.emf.facet.util.core.Logger;

/**
 * A builder for EMF Facet projects, that delegates to children builders provided by the extension point
 * "builderRegistration".
 * 
 * @author Gregoire Dupe (Mia-Software)
 */
public class EmfFacetProjectBuilder extends IncrementalProjectBuilder {

	private static ArrayList<BuilderDescriptor> emffacetBuilders = null;

	public EmfFacetProjectBuilder() {
		super();
		if (EmfFacetProjectBuilder.emffacetBuilders == null) {
			EmfFacetProjectBuilder.emffacetBuilders = new ArrayList<BuilderDescriptor>();
			synchronized (EmfFacetProjectBuilder.emffacetBuilders) {
				final IConfigurationElement[] configs = Platform.getExtensionRegistry()
						.getConfigurationElementsFor(CommonConstants.BUILDER_EXTENSION_POINT_ID);
				for (final IConfigurationElement config : configs) {
					try {
						final String id = config.getDeclaringExtension().getUniqueIdentifier();
						final IEmfFacetProjectBuilder builderInst = (IEmfFacetProjectBuilder) config
								.createExecutableExtension("class"); //$NON-NLS-1$
						final BuilderDescriptor builderDescriptor = new BuilderDescriptor(
								builderInst, id);
						EmfFacetProjectBuilder.emffacetBuilders.add(builderDescriptor);
						for (final IConfigurationElement depends : config.getChildren("depends")) { //$NON-NLS-1$
							builderDescriptor.getDependsOn().add(depends.getAttribute("builder")); //$NON-NLS-1$
						}
					} catch (final Exception e) {
						Logger.logError(e, Activator.getDefault());
					}
				}
				EmfFacetProjectBuilder.emffacetBuilders = sortBuilders(EmfFacetProjectBuilder.emffacetBuilders);
			}
		}
		validateBuilderDependencies();
	}

	/**
	 * Sort builders by dependencies : first those that depend on nothing, then those that depend on those already in
	 * the list, etc.
	 */
	private static ArrayList<BuilderDescriptor> sortBuilders(final ArrayList<BuilderDescriptor> builders) {
		final ArrayList<BuilderDescriptor> result = new ArrayList<EmfFacetProjectBuilder.BuilderDescriptor>();
		final List<BuilderDescriptor> remaining = new LinkedList<EmfFacetProjectBuilder.BuilderDescriptor>();
		remaining.addAll(builders);

		while (!remaining.isEmpty()) {
			boolean stuck = true;
			final ListIterator<BuilderDescriptor> listIterator = remaining.listIterator();
			while (listIterator.hasNext()) {
				final BuilderDescriptor builder = listIterator.next();
				// if it depends only on builders that are already in the list
				// before it, then add it here
				if (dependendsOnlyOn(builder, result)) {
					result.add(builder);
					listIterator.remove();
					stuck = false;
				}
			}
			if (stuck) {
				throw new RuntimeException("Cannot order builders due to incoherent dependencies"); //$NON-NLS-1$
			}
		}

		return result;
	}

	/** Whether the given builder only depends on those in the list. */
	private static boolean dependendsOnlyOn(final BuilderDescriptor builder, final ArrayList<BuilderDescriptor> list) {
		final List<String> dependsOn = builder.getDependsOn();
		for (final String dep : dependsOn) {
			boolean found = false;
			for (final BuilderDescriptor prev : list) {
				if (prev.getId().equals(dep)) {
					found = true;
					break;
				}
			}
			if (!found) {
				return false;
			}
		}
		return true;
	}

	private static void validateBuilderDependencies() {
		final List<String> idList = new ArrayList<String>();
		for (final BuilderDescriptor descriptor : EmfFacetProjectBuilder.emffacetBuilders) {
			idList.add(descriptor.getId());
		}
		for (final BuilderDescriptor descriptor : EmfFacetProjectBuilder.emffacetBuilders) {
			for (final String dependsOn : descriptor.getDependsOn()) {
				if (!idList.contains(dependsOn)) {
					Logger.logWarning("The builder " + descriptor.getId() + " depends on " //$NON-NLS-1$//$NON-NLS-2$
							+ dependsOn + " which does not exist.", Activator //$NON-NLS-1$
							.getDefault());
				}
			}
		}

	}

	@Override
	protected void clean(final IProgressMonitor monitor) throws CoreException {
		synchronized (EmfFacetProjectBuilder.emffacetBuilders) {
			final Iterator<BuilderDescriptor> builders = EmfFacetProjectBuilder.emffacetBuilders
					.iterator();
			while (builders.hasNext()) {
				final BuilderDescriptor builder = builders.next();
				builder.getBuilderInst().clean(this, monitor);
			}
		}
	}

	@Override
	protected IProject[] build(final int kind, @SuppressWarnings("rawtypes") final Map args, final IProgressMonitor monitor)
			throws CoreException {
		synchronized (EmfFacetProjectBuilder.emffacetBuilders) {
			final Iterator<BuilderDescriptor> builders = EmfFacetProjectBuilder.emffacetBuilders
					.iterator();
			while (builders.hasNext()) {
				final BuilderDescriptor builder = builders.next();
				builder.getBuilderInst().build(this, kind, args, monitor);
			}
		}
		return null;
	}

	/**
	 * This class is used to hold the builder id, the builder instance and the builder dependencies in a single
	 * structure.
	 */
	private class BuilderDescriptor {
		private final IEmfFacetProjectBuilder builderInst;

		private final List<String> dependsOn = new ArrayList<String>();

		private final String id;

		/**
		 * @param builderInst
		 *            an instance of the described builder
		 * @param id
		 *            the id of the described builder
		 */
		public BuilderDescriptor(final IEmfFacetProjectBuilder builderInst, final String id) {
			this.builderInst = builderInst;
			this.id = id;
		}

		public String getId() {
			return this.id;
		}

		/** @return the list of dependencies on other EmfFacet builders. */
		public List<String> getDependsOn() {
			return this.dependsOn;
		}

		/** @return the instance of the described builder */
		public IEmfFacetProjectBuilder getBuilderInst() {
			return this.builderInst;
		}

		@Override
		public String toString() {
			return this.id + "(" + this.builderInst.getClass().getName() + ")"; //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

}
