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
import org.eclipse.papyrus.cdo.core.importer.IModelImportConfiguration;
import org.eclipse.papyrus.cdo.core.importer.IModelImportListener;
import org.eclipse.papyrus.cdo.core.importer.IModelImportNode;
import org.eclipse.papyrus.cdo.core.importer.IModelImportOperation;
import org.eclipse.papyrus.cdo.core.importer.IModelImportOperation.Context;
import org.eclipse.papyrus.cdo.internal.core.Activator;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

/**
 * This is the ModelImportConfiguration type. Enjoy.
 */
public class ModelImportConfiguration
		implements IModelImportConfiguration {

	private Map<URI, Resource> resources = Maps.newHashMap();

	private ResourceSet resourceSet;

	private IModelImportOperation.Context operationContext;

	private Map<Resource, IModelImportNode> importNodes = Maps.newHashMap();

	private Set<IModelImportNode> modelsToImport = Sets.newHashSet();

	private Collection<IModelDependentsProvider> dependentsProviders = Lists
		.newArrayList();

	private CopyOnWriteArrayList<IModelImportListener> listeners = new CopyOnWriteArrayList<IModelImportListener>();

	public ModelImportConfiguration(
			IModelImportOperation.Context operationContext) {

		super();

		this.resourceSet = new ResourceSetImpl();
		((ResourceSetImpl) this.resourceSet).setURIResourceMap(resources);
		this.operationContext = new ReentrantOperationContext(operationContext);
	}

	public void dispose() {
		if (resourceSet != null) {
			for (Resource next : resourceSet.getResources()) {
				next.unload();
				next.eAdapters().clear();
			}

			resourceSet.getResources().clear();
			resourceSet.eAdapters().clear();
			resourceSet = null;

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

	public Collection<IModelImportNode> getModelsToImport() {
		return Collections.unmodifiableSet(modelsToImport);
	}

	public IModelImportNode addModelToImport(URI resourceURI) {
		IModelImportNode result = getNode(resourceURI);

		if (modelsToImport.add(result)) {
			fireModelsToImportChanged();
		}

		return result;
	}

	protected IModelImportNode getNode(URI resourceURI) {
		IModelImportNode result = null;

		Resource resource = resourceSet.getResource(resourceURI, true);
		if (resource != null) {
			result = importNodes.get(resource);
			if (result == null) {
				final ModelImportNode newNode = new ModelImportNode(this,
					resource);
				importNodes.put(resource, newNode);

				newNode.initialize(getOperationContext());

				Diagnostic problems = getOperationContext().run(
					new IModelImportOperation() {

						public Diagnostic run(IProgressMonitor monitor) {
							SubMonitor sub = SubMonitor.convert(monitor,
								"Calculating model dependents ...",
								dependentsProviders.size());

							for (IModelDependentsProvider next : dependentsProviders) {
								for (URI uri : next.getDependents(
									newNode.getPrimaryResource(), monitor)) {

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

	public void removeModelToImport(IModelImportNode node) {
		if (modelsToImport.remove(node)) {
			fireModelsToImportChanged();
		}
	}

	public void addModelDependentsProvider(IModelDependentsProvider provider) {
		if (!dependentsProviders.contains(provider)) {
			dependentsProviders.add(provider);
		}
	}

	public Diagnostic validate() {
		BasicDiagnostic result = new BasicDiagnostic();

		Set<IModelImportNode> toImport = ImmutableSet
			.copyOf(getModelsToImport());
		for (IModelImportNode node : toImport) {
			checkDependents(node, toImport, result);
			checkDependencies(node, toImport, result);
		}

		fireProblemsEvent(result);

		return result;
	}

	protected void checkDependents(IModelImportNode node,
			Set<IModelImportNode> toImport, DiagnosticChain diagnostics) {

		Set<IModelImportNode> dependents = ImmutableSet.copyOf(node
			.getDependents());
		Set<IModelImportNode> leftOut = Sets.difference(dependents, toImport);
		if (!leftOut.isEmpty()) {
			diagnostics
				.add(new BasicDiagnostic(
					Diagnostic.WARNING,
					Activator.PLUGIN_ID,
					0,
					NLS.bind(
						"Not all models that reference {0} are selected for import.",
						node.getName()), new Object[]{node, leftOut}));
		}
	}

	protected void checkDependencies(IModelImportNode node,
			Set<IModelImportNode> toImport, DiagnosticChain diagnostics) {

		Set<IModelImportNode> dependencies = ImmutableSet.copyOf(node
			.getDependencies());
		Set<IModelImportNode> leftOut = Sets.difference(dependencies, toImport);
		if (!leftOut.isEmpty()) {
			diagnostics
				.add(new BasicDiagnostic(
					Diagnostic.INFO,
					Activator.PLUGIN_ID,
					0,
					NLS.bind(
						"Not all models that are referenced by {0} are selected for import.",
						node.getName()), new Object[]{node, leftOut}));
		}
	}

	public void addModelImportListener(IModelImportListener listener) {
		listeners.addIfAbsent(listener);
	}

	public void removeModelImportListener(IModelImportListener listener) {
		listeners.remove(listener);
	}

	void fireProblemsEvent(Diagnostic problems) {
		if (problems.getSeverity() > Diagnostic.OK) {
			for (IModelImportListener next : listeners) {
				try {
					next.modelImportProblemsOccurred(problems);
				} catch (Exception e) {
					Activator.log.error(
						"Uncaught exception in model import listener.", e);
				}
			}
		}
	}

	void fireModelsToImportChanged() {
		for (IModelImportListener next : listeners) {
			try {
				next.modelsToImportChanged(this);
			} catch (Exception e) {
				Activator.log.error(
					"Uncaught exception in model import listener.", e);
			}
		}
	}

	void fireModelDependentsChanged(IModelImportNode node) {
		for (IModelImportListener next : listeners) {
			try {
				next.modelDependentsChanged(node);
			} catch (Exception e) {
				Activator.log.error(
					"Uncaught exception in model import listener.", e);
			}
		}
	}

	boolean hasResource(URI uri) {
		return resources.containsKey(uri);
	}
}
