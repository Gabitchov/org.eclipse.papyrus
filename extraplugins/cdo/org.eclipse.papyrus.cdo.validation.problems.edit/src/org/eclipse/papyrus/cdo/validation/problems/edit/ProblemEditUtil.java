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
package org.eclipse.papyrus.cdo.validation.problems.edit;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.papyrus.cdo.validation.problems.EProblem;

/**
 * Utilities for accessing edit-provider information about {@link EProblem}s.
 */
public class ProblemEditUtil {

	private AdapterFactory adapterFactory;

	private DefaultProblemTypeProviderAdapter defaultAdapter;

	public ProblemEditUtil(AdapterFactory adapterFactory) {
		this.adapterFactory = adapterFactory;
	}

	public String getProblemType(EProblem problem) {
		IProblemTypeProvider provider = getProblemTypeProvider(problem);
		return provider.getProblemType(problem);
	}

	protected IProblemTypeProvider getProblemTypeProvider(EProblem problem) {
		Adapter provider = adapterFactory.adapt(problem,
			IProblemTypeProvider.class);
		IProblemTypeProvider result = provider instanceof IProblemTypeProvider
			? (IProblemTypeProvider) provider
			: null;

		if (result == null) {
			for (Adapter next : problem.eAdapters()) {
				if (next instanceof IProblemTypeProvider) {
					result = (IProblemTypeProvider) next;
					break;
				}
			}
		}

		if (result == null) {
			DefaultProblemTypeProviderAdapter adapter = getDefaultProblemTypeProvider();
			problem.eAdapters().add(adapter);
			result = adapter;
		}

		return result;
	}

	protected DefaultProblemTypeProviderAdapter getDefaultProblemTypeProvider() {
		if (defaultAdapter == null) {
			defaultAdapter = new DefaultProblemTypeProviderAdapter();
		}
		return defaultAdapter;
	}

	protected class DefaultProblemTypeProviderAdapter
			implements Adapter, IProblemTypeProvider {

		public String getProblemType(Object object) {
			String result = null;

			if (object instanceof EProblem) {
				EProblem problem = (EProblem) object;
				EObject element = problem.getElement();
				if (element != null) {
					EPackage model = element.eClass().getEPackage();
					IItemLabelProvider labels = (IItemLabelProvider) adapterFactory
						.adapt(model, IItemLabelProvider.class);
					if (labels != null) {
						result = labels.getText(model);
					} else {
						result = model.getName();
					}
				}
			}

			return result;
		}

		public boolean isAdapterForType(Object type) {
			return false;
		}

		public Notifier getTarget() {
			// I am stateless, so I am re-used on multiple targets
			return null;
		}

		public void setTarget(Notifier newTarget) {
			// pass
		}

		public void notifyChanged(Notification notification) {
			// pass
		}

	}
}
