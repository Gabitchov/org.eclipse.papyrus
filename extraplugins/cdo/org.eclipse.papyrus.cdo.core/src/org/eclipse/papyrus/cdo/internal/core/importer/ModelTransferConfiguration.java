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
package org.eclipse.papyrus.cdo.internal.core.importer;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.cdo.core.importer.IModelDependentsProvider;
import org.eclipse.papyrus.cdo.core.importer.IModelTransferConfiguration;
import org.eclipse.papyrus.cdo.core.importer.IModelTransferListener;
import org.eclipse.papyrus.cdo.core.importer.IModelTransferNode;
import org.eclipse.papyrus.cdo.core.importer.IModelTransferOperation;
import org.eclipse.papyrus.cdo.core.importer.IModelTransferOperation.Context;
import org.eclipse.papyrus.cdo.internal.core.Activator;
import org.eclipse.papyrus.cdo.internal.core.l10n.Messages;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

/**
 * This is the ModelTransferConfiguration type. Enjoy.
 */
public class ModelTransferConfiguration implements IModelTransferConfiguration {

	private final Direction direction;

	private Map<URI, Resource> resources = Maps.newHashMap();

	private ResourceSet resourceSet;

	private final boolean ownResourceSet;

	private final IModelTransferOperation.Context operationContext;

	private final Map<Resource, IModelTransferNode> importNodes = Maps.newHashMap();

	private final Set<IModelTransferNode> modelsToImport = Sets.newHashSet();

	private final Collection<IModelDependentsProvider> dependentsProviders = Lists.newArrayList();

	private final CopyOnWriteArrayList<IModelTransferListener> listeners = new CopyOnWriteArrayList<IModelTransferListener>();

	public ModelTransferConfiguration(IModelTransferOperation.Context operationContext, ResourceSet resourceSet) {
		this(operationContext, resourceSet, Direction.IMPORT);
	}

	public ModelTransferConfiguration(IModelTransferOperation.Context operationContext, ResourceSet resourceSet, Direction direction) {
		super();

		this.direction = direction;
		this.operationContext = new ReentrantOperationContext(operationContext);

		if(resourceSet != null) {
			this.resourceSet = resourceSet;
			this.ownResourceSet = false;
		} else {
			this.resourceSet = new ResourceSetImpl();
			((ResourceSetImpl)this.resourceSet).setURIResourceMap(resources);
			this.ownResourceSet = true;
		}
	}

	public final Direction getDirection() {
		return direction;
	}

	public void dispose() {
		if(resourceSet != null) {
			if(ownResourceSet) {
				for(Resource next : resourceSet.getResources()) {
					next.unload();
					next.eAdapters().clear();
				}

				resourceSet.getResources().clear();
				resourceSet.eAdapters().clear();
				resourceSet = null;
			} else {
				// even if not owned, we should remove DependencyAdapters
				for(Resource next : resourceSet.getResources()) {
					DependencyAdapter adapter = DependencyAdapter.getExistingInstance(next);
					next.eAdapters().remove(adapter);
				}
			}

			resources.clear();
			resources = null;
		}

		listeners.clear();
	}

	public ResourceSet getResourceSet() {
		return resourceSet;
	}

	public Context getOperationContext() {
		return operationContext;
	}

	public Collection<IModelTransferNode> getModelsToTransfer() {
		return Collections.unmodifiableSet(modelsToImport);
	}

	public IModelTransferNode addModelToTransfer(URI resourceURI) {
		IModelTransferNode result = getNode(resourceURI);

		if(modelsToImport.add(result)) {
			fireModelsToImportChanged();
		}

		return result;
	}

	protected IModelTransferNode getNode(URI resourceURI) {
		IModelTransferNode result = null;

		final Resource resource = resourceSet.getResource(resourceURI, true);
		if(resource != null) {
			result = importNodes.get(resource);
			if(result == null) {
				final ModelTransferNode newNode = new ModelTransferNode(this, resource);
				importNodes.put(resource, newNode);

				newNode.initialize(getOperationContext());

				Diagnostic problems = getOperationContext().run(new IModelTransferOperation() {

					public Diagnostic run(IProgressMonitor monitor) {
						SubMonitor sub = SubMonitor.convert(monitor, Messages.ModelTransferConfiguration_0, dependentsProviders.size());

						for(IModelDependentsProvider next : dependentsProviders) {
							// first, if it's a DI resource, ensure that it gets its components
							if(DependencyAdapter.isDIResource(resource)) {
								DependencyAdapter adapter = DependencyAdapter.getInstance(resource);
								for(URI uri : next.getComponents(resource, monitor)) {
									// this is an implicit dependency, even if there are no references
									// to it (which occurs, e.g., in model sub-units that have no diagrams)
									Resource implicitDependency = resource.getResourceSet().getResource(uri, true);
									if(implicitDependency != null) {
										adapter.addDependency(implicitDependency);
									}
								}

								// scan for components again
								newNode.scanForComponents();
							}

							for(URI uri : next.getDependents(newNode.getPrimaryResource(), monitor)) {
								newNode.addDependent(getNode(uri));
							}

							sub.worked(1);
						}

						sub.done();
						return Diagnostic.OK_INSTANCE;
					}
				});

				fireModelDependentsChanged(newNode);
				fireProblemsEvent(problems);

				result = newNode;
			}
		}

		return result;
	}

	public void removeModelToTransfer(IModelTransferNode node) {
		if(modelsToImport.remove(node)) {
			fireModelsToImportChanged();
		}
	}

	public void addModelDependentsProvider(IModelDependentsProvider provider) {
		if(!dependentsProviders.contains(provider)) {
			dependentsProviders.add(provider);
		}
	}

	public Diagnostic validate() {
		BasicDiagnostic result = new BasicDiagnostic();

		Set<IModelTransferNode> toImport = ImmutableSet.copyOf(getModelsToTransfer());
		for(IModelTransferNode node : toImport) {
			checkDependents(node, toImport, result);
			checkDependencies(node, toImport, result);
		}

		fireProblemsEvent(result);

		return result;
	}

	protected void checkDependents(IModelTransferNode node, Set<IModelTransferNode> toImport, DiagnosticChain diagnostics) {
		Set<IModelTransferNode> dependents = ImmutableSet.copyOf(node.getDependents());
		Set<IModelTransferNode> leftOut = Sets.difference(dependents, toImport);
		if(!leftOut.isEmpty()) {
			int severity = direction.isImport() ? Diagnostic.WARNING : Diagnostic.INFO;
			diagnostics.add(new BasicDiagnostic(severity, Activator.PLUGIN_ID, 0, NLS.bind(Messages.ModelTransferConfiguration_1, node.getName(), direction), new Object[]{ node, leftOut }));
		}
	}

	protected void checkDependencies(IModelTransferNode node, Set<IModelTransferNode> toImport, DiagnosticChain diagnostics) {
		Set<IModelTransferNode> dependencies = ImmutableSet.copyOf(node.getDependencies());
		Set<IModelTransferNode> leftOut = Sets.difference(dependencies, toImport);
		if(!leftOut.isEmpty()) {
			int severity = direction.isImport() ? Diagnostic.INFO : Diagnostic.WARNING;
			diagnostics.add(new BasicDiagnostic(severity, Activator.PLUGIN_ID, 0, NLS.bind(Messages.ModelTransferConfiguration_2, node.getName(), direction), new Object[]{ node, leftOut }));
		}
	}

	public void addModelTransferListener(IModelTransferListener listener) {
		listeners.addIfAbsent(listener);
	}

	public void removeModelTransferListener(IModelTransferListener listener) {
		listeners.remove(listener);
	}

	void fireProblemsEvent(Diagnostic problems) {
		if(problems.getSeverity() > Diagnostic.OK) {
			for(IModelTransferListener next : listeners) {
				try {
					next.modelTransferProblemsOccurred(problems);
				} catch (Exception e) {
					Activator.log.error(NLS.bind("Uncaught exception in model {0} listener.", direction.name()), e); //$NON-NLS-1$
				}
			}
		}
	}

	void fireModelsToImportChanged() {
		for(IModelTransferListener next : listeners) {
			try {
				next.modelsToTransferChanged(this);
			} catch (Exception e) {
				Activator.log.error(NLS.bind("Uncaught exception in model {0} listener.", direction.name()), e); //$NON-NLS-1$
			}
		}
	}

	void fireModelDependentsChanged(IModelTransferNode node) {
		for(IModelTransferListener next : listeners) {
			try {
				next.modelDependentsChanged(node);
			} catch (Exception e) {
				Activator.log.error(NLS.bind("Uncaught exception in model {0} listener.", direction.name()), e); //$NON-NLS-1$
			}
		}
	}

	boolean hasResource(URI uri) {
		return resources.containsKey(uri);
	}

	//
	// Nested types
	//

	public static enum Direction {
		IMPORT(Messages.ModelTransferConfiguration_6), EXPORT(Messages.ModelTransferConfiguration_7);

		private final String label;

		private Direction(String label) {
			this.label = label;
		}

		public boolean isImport() {
			return this == IMPORT;
		}

		@Override
		public String toString() {
			return label;
		}
	}
}
