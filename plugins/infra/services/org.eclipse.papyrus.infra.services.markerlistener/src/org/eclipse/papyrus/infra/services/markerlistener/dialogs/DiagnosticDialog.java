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
package org.eclipse.papyrus.infra.services.markerlistener.dialogs;

import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.papyrus.infra.services.markerlistener.Activator;
import org.eclipse.papyrus.infra.services.markerlistener.internal.messages.Messages;
import org.eclipse.papyrus.infra.services.markerlistener.providers.IMarkerProvider;
import org.eclipse.papyrus.infra.services.markerlistener.util.MarkerListenerUtils;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;


/**
 * A specialized error dialog for presentation of EMF {@link Diagnostic}s that includes a button for creation of problem markers.
 */
public class DiagnosticDialog extends ErrorDialog {

	/** Button ID for the "Create Markers" button. */
	public static final int CREATE_MARKERS_ID = IDialogConstants.CLIENT_ID + 1;

	private final Diagnostic diagnostics;

	public DiagnosticDialog(Shell parentShell, String dialogTitle, String message, Diagnostic diagnostics, int displayMask) {
		super(parentShell, dialogTitle, message, BasicDiagnostic.toIStatus(diagnostics), displayMask);

		this.diagnostics = diagnostics;
	}

	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		super.createButtonsForButtonBar(parent);

		createButton(parent, CREATE_MARKERS_ID, Messages.DiagnosticDialog_0, false);
	}

	@Override
	protected void buttonPressed(int id) {
		switch(id) {
		case CREATE_MARKERS_ID:
			createMarkers();
			getButton(CREATE_MARKERS_ID).setEnabled(false);
			break;
		default:
			super.buttonPressed(id);
			break;
		}
	}

	protected void createMarkers() {
		try {
			PlatformUI.getWorkbench().getProgressService().busyCursorWhile(new IRunnableWithProgress() {

				public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
					Map<Resource, Diagnostic> partitions = partitionByResource(diagnostics);
					SubMonitor subMonitor = SubMonitor.convert(monitor, partitions.size());

					for(Map.Entry<Resource, Diagnostic> next : partitions.entrySet()) {
						IMarkerProvider provider = getMarkerProvider(next.getKey());
						if(provider == null) {
							// Just tick
							subMonitor.worked(1);
						} else {
							try {
								provider.createMarkers(next.getKey(), next.getValue(), subMonitor.newChild(1));
							} catch (CoreException e) {
								Activator.log.error("Error creating problem markers.", e); //$NON-NLS-1$
							}
						}
					}

					subMonitor.done();
				}
			});
		} catch (Exception e) {
			Activator.log.error(e);
		}
	}

	protected Map<Resource, Diagnostic> partitionByResource(Diagnostic diagnostics) {
		Map<Resource, Diagnostic> result = new LinkedHashMap<Resource, Diagnostic>();

		if(!diagnostics.getChildren().isEmpty()) {
			for(Diagnostic next : diagnostics.getChildren()) {
				Resource context = getContextResource(next);
				if(context != null) {
					DiagnosticChain chain = (DiagnosticChain)result.get(context);
					if(chain == null) {
						chain = new BasicDiagnostic();
						result.put(context, (Diagnostic)chain);
					}
					chain.add(next);
				}
			}
		}

		return result;
	}

	protected Resource getContextResource(Diagnostic diagnostic) {
		Resource result = null;

		List<?> data = diagnostic.getData();
		if((data != null) && !data.isEmpty()) {
			for(Object next : data) {
				if(next instanceof Resource) {
					result = (Resource)next;
					break;
				} else if(next instanceof EObject) {
					result = ((EObject)next).eResource();
					if(result != null) {
						break;
					}
				}
			}
		}

		return result;
	}

	protected IMarkerProvider getMarkerProvider(Resource context) {
		List<IMarkerProvider> providers = MarkerListenerUtils.getMarkerProviders(context);
		return ((providers == null) || providers.isEmpty()) ? null : providers.get(0);
	}
}
