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
package org.eclipse.papyrus.uml.modelrepair.internal.stereotypes;

import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.infra.services.markerlistener.providers.IMarkerProvider;
import org.eclipse.papyrus.infra.services.markerlistener.util.MarkerListenerUtils;
import org.eclipse.papyrus.uml.modelrepair.Activator;


/**
 * This is the CreateMarkersAction type. Enjoy.
 */
public class CreateMarkersAction extends AbstractRepairAction {

	static final CreateMarkersAction INSTANCE = new CreateMarkersAction();

	private CreateMarkersAction() {
		super(Kind.CREATE_MARKERS);
	}

	public boolean repair(Resource resource, EPackage profileDefinition, Collection<? extends EObject> stereotypeApplications, DiagnosticChain problems, IProgressMonitor monitor) {
		List<IMarkerProvider> providers = MarkerListenerUtils.getMarkerProviders(resource);
		if(!providers.isEmpty()) {
			IMarkerProvider provider = providers.get(0);
			BasicDiagnostic diagnostics = new BasicDiagnostic();

			for(EObject next : stereotypeApplications) {
				EObject subject = getBaseElement(next);
				if(subject == null) {
					// OK, apply it to the application, instead
					subject = next;
				}

				diagnostics.add(new BasicDiagnostic(Diagnostic.WARNING, Activator.PLUGIN_ID, 0, "Obsolete application of stereotype " + UML2EcoreConverter.getOriginalName(next.eClass()), new Object[]{ subject, next }));
			}

			try {
				provider.createMarkers(resource, diagnostics, monitor);
			} catch (CoreException e) {
				if(problems == null) {
					Activator.log.error(e);
				} else {
					problems.add(BasicDiagnostic.toDiagnostic(e.getStatus()));
				}
			}
		}

		return true;
	}

}
