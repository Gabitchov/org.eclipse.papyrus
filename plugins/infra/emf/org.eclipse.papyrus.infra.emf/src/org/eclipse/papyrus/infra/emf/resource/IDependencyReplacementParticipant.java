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

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.resource.Resource;


/**
 * A participant in the
 * {@link DependencyManager#updateDependencies(org.eclipse.emf.common.util.URI, org.eclipse.emf.common.util.URI, org.eclipse.emf.common.util.DiagnosticChain)}
 * operation.
 */
public interface IDependencyReplacementParticipant {

	/**
	 * Post-processes a set of replacements that resulted from a dependency update on the specified {@code resources}.
	 * 
	 * @param replacements
	 *        the replacements resulting from the dependency update operation
	 * @param resources
	 *        the resources on which the replacements were computed
	 * @param monitor
	 *        an optional progress monitor. If {@code null}, then the client does not want progress reporting
	 * @param diagnostics
	 *        an optional diagnostic chain to collect problems. If {@code null}, then the client does not want problem reporting
	 * 
	 * @return a diagnostic indicating any problems in post-processing, or {@code null} if no problems
	 */
	void postProcessReplacements(Collection<? extends Replacement> replacements, Collection<? extends Resource> resources, IProgressMonitor monitor, DiagnosticChain diagnostics);
}
