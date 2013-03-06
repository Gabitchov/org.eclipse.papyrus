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
package org.eclipse.papyrus.cdo.internal.ui.markers;

import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.papyrus.cdo.validation.problems.edit.ProblemEditUtil;
import org.eclipse.papyrus.cdo.validation.problems.util.ProblemsEvent;
import org.eclipse.papyrus.cdo.validation.problems.util.ProblemsListener;
import org.eclipse.papyrus.cdo.validation.problems.util.ProblemsManager;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.services.markerlistener.providers.AbstractMarkerMonitor;

/**
 * This is the CDOMarkerMonitor type. Enjoy.
 */
public class CDOMarkerMonitor
		extends AbstractMarkerMonitor {

	private ProblemEditUtil util;

	private ProblemsListener problemsListener;

	public CDOMarkerMonitor() {
		super();
	}

	@Override
	public void initialize(ModelSet modelSet) {
		super.initialize(modelSet);
		
		this.util = new ProblemEditUtil(
			((AdapterFactoryEditingDomain) modelSet
				.getTransactionalEditingDomain()).getAdapterFactory());
		this.problemsListener = createProblemsListener();
		ProblemsManager.getProblemsManager(modelSet).addProblemsListener(
			problemsListener);
	}

	@Override
	public void dispose() {
		if (problemsListener != null) {
			ProblemsManager.getProblemsManager(getModelSet())
				.removeProblemsListener(problemsListener);
			problemsListener = null;
		}
		
		super.dispose();
	}

	protected ProblemsListener createProblemsListener() {
		return new ProblemsListener() {

			public void problemAdded(ProblemsEvent event) {
				fireMarkerAdded(new CDOPapyrusMarker(event.getProblem(), util));
			}

			public void problemRemoved(ProblemsEvent event) {
				fireMarkerRemoved(new CDOPapyrusMarker(event.getProblem(), util));
			}

		};
	}
}
