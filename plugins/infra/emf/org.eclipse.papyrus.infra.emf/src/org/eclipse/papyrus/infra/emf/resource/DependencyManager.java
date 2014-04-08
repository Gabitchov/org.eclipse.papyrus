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
package org.eclipse.papyrus.infra.emf.resource;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.expressions.EvaluationContext;
import org.eclipse.core.expressions.EvaluationResult;
import org.eclipse.core.expressions.ExpressionConverter;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.papyrus.infra.emf.Activator;

import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;


/**
 * An utility for switching URI references in EMF models.
 */
public class DependencyManager {

	private final Collection<Resource> resources;

	private final EditingDomain editingDomain;

	public DependencyManager(Resource resource) {
		this(Collections.singletonList(resource));
	}

	public DependencyManager(Collection<Resource> resources) {
		this(resources, resources.isEmpty() ? null : TransactionUtil.getEditingDomain(resources.iterator().next()));
	}

	public DependencyManager(ResourceSet resourceSet) {
		this(resourceSet.getResources(), TransactionUtil.getEditingDomain(resourceSet));
	}

	public DependencyManager(EditingDomain editingDomain) {
		this(editingDomain.getResourceSet().getResources(), editingDomain);
	}

	protected DependencyManager(Collection<Resource> resources, EditingDomain editingDomain) {
		this.resources = resources;
		this.editingDomain = editingDomain;
	}

	public Collection<Replacement> updateDependencies(final URI oldURI, URI newURI, DiagnosticChain diagnostics, IProgressMonitor monitor) {
		final List<? extends IDependencyReplacementParticipant> participants = loadParticipants(oldURI, newURI);
		final SubMonitor subMonitor = SubMonitor.convert(monitor, (participants.size() * 2) + 1);
		
		// Don't attempt to update references within the resource whose URI we are replacing!
		Collection<Resource> resourcesToUpdate = ImmutableList.copyOf(Iterables.filter(resources, new Predicate<Resource>() {

			public boolean apply(Resource input) {
				return !oldURI.equals(input.getURI());
			}
		}));

		IProgressMonitor child = subMonitor.newChild(participants.size() + 1);
		child.beginTask("Updating references ...", IProgressMonitor.UNKNOWN);
		Collection<Replacement> result = DependencyManagementHelper.updateDependencies(oldURI, newURI, resourcesToUpdate, editingDomain);
		child.done();
		
		// Don't need participants if no replacements were made
		if(!result.isEmpty()) {
			for(IDependencyReplacementParticipant participant : participants) {
				try {
					participant.postProcessReplacements(result, resourcesToUpdate, subMonitor.newChild(1), diagnostics);
				} catch (Exception e) {
					Activator.log.error("Uncaught exception in dependency update participant.", e); //$NON-NLS-1$
				}
			}
		}
		
		subMonitor.done();

		return result;
	}

	protected List<? extends IDependencyReplacementParticipant> loadParticipants(URI oldURI, URI newURI) {
		List<IDependencyReplacementParticipant> result = Lists.newArrayList();

		IEvaluationContext context = new EvaluationContext(null, resources);
		context.addVariable("oldURI", oldURI); //$NON-NLS-1$
		context.addVariable("newURI", newURI);//$NON-NLS-1$

		for(IConfigurationElement next : Platform.getExtensionRegistry().getConfigurationElementsFor(Activator.PLUGIN_ID, "dependencyUpdateParticipant")) { //$NON-NLS-1$
			if("replaceParticipant".equals(next.getName())) { //$NON-NLS-1$
				IConfigurationElement[] enablement = next.getChildren("enablement"); //$NON-NLS-1$
				if((enablement == null) || (enablement.length == 0) || matches(enablement[0], context)) {
					try {
						result.add((IDependencyReplacementParticipant)next.createExecutableExtension("class")); //$NON-NLS-1$ 
					} catch (Exception e) {
						Activator.log.error("Invalid replaceParticipant extension in " + next.getContributor().getName(), e); //$NON-NLS-1$
					}
				}
			}
		}

		return result;
	}

	protected boolean matches(IConfigurationElement enablement, IEvaluationContext context) {
		EvaluationResult result = EvaluationResult.NOT_LOADED;

		try {
			ExpressionConverter.getDefault().perform(enablement).evaluate(context);
		} catch (Exception e) {
			Activator.log.error("Problem evaluating replaceParticipant enablement expression.", e); //$NON-NLS-1$
		}

		return result.or(EvaluationResult.FALSE).equals(EvaluationResult.TRUE);
	}
}
