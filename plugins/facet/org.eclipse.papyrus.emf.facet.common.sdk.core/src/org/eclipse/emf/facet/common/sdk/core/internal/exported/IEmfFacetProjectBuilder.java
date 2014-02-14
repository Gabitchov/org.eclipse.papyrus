/*******************************************************************************
 * Copyright (c) 2009-2012 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Grégoire Dupé (Mia-Software) - Initial API
 *    Nicolas Bros (Mia-Software) - Bug 375054 - Add validation warning for overlay on EClass
 *******************************************************************************/
package org.eclipse.emf.facet.common.sdk.core.internal.exported;

import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

/**
 * The EMF Facet project builder delegates its build behavior to a set of classes
 * implementing this interface. This set of classes is defined through the use of
 * the <tt>org.eclipse.emf.facet.common.sdk.core.builderRegistration</tt> extension
 * point.
 * 
 * @author Grégoire Dupé (Mia-Software)
 * 
 */
public interface IEmfFacetProjectBuilder {

	/**
	 * @param builder
	 *            The EMF Facet builder which delegates its build behavior to the
	 *            classes that implement {@link IEmfFacetProjectBuilder}.
	 * @throws CoreException
	 */
	IProject[] build(IncrementalProjectBuilder builder, int kind, Map<?, ?> args, IProgressMonitor monitor)
			throws CoreException;

	/**
	 * @see IncrementalProjectBuilder#clean(IProgressMonitor)
	 * @param builder
	 *            The EmfFacet builder which delegates the build behavior to the
	 *            classes that implement {@link IEmfFacetProjectBuilder}.
	 * @param monitor
	 * @throws CoreException
	 */
	void clean(IncrementalProjectBuilder builder, IProgressMonitor monitor) 
			throws CoreException;
}
