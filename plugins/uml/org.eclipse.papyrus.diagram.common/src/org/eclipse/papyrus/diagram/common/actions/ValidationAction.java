/***************************************************************************
 * Copyright (c) 2008 Conselleria de Infraestructuras y Transporte,
 * Generalitat de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Francisco Javier Cano Muñoz (Prodevelop) - initial api implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.common.actions;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.common.ui.util.IWorkbenchPartDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.papyrus.diagram.common.Activator;
import org.eclipse.papyrus.diagram.common.providers.DiagramValidationMarkerNavigationProvider;
import org.eclipse.papyrus.diagram.common.providers.DiagramValidationProvider;
import org.eclipse.papyrus.diagram.common.util.DiagramEditPartsUtil;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.actions.WorkspaceModifyDelegatingOperation;

/**
 * An {@link Action} that launches the diagram validation.
 * After the validation it marks the diagram file to show decoratos where errors occurred.
 * 
 * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano Muñoz</a>
 * 
 */
public class ValidationAction extends Action {

	public static final String VALIDATE_ACTION_KEY = "validateDiagramAction"; //$NON-NLS-1$

	private IWorkbenchPartDescriptor workbenchPartDescriptor;

	public ValidationAction(IWorkbenchPartDescriptor workbenchPartDescriptor) {
		setId(VALIDATE_ACTION_KEY);
		setText("Diagram Validation");
		this.workbenchPartDescriptor = workbenchPartDescriptor;
	}

	/**
	 * Executes the action
	 */
	public void run() {
		IWorkbenchPart workbenchPart = workbenchPartDescriptor.getPartPage()
				.getActivePart();
		if(workbenchPart instanceof IDiagramWorkbenchPart) {
			final IDiagramWorkbenchPart part = (IDiagramWorkbenchPart)workbenchPart;
			try {
				new WorkspaceModifyDelegatingOperation(
						new IRunnableWithProgress() {

					public void run(IProgressMonitor monitor)
							throws InterruptedException,
							InvocationTargetException {
						runValidation(part.getDiagramEditPart(), part
								.getDiagram());
					}
				}).run(new NullProgressMonitor());
			} catch (Exception e) {
				Activator.getDefault().logError(
						"Diagram Validation action failed", e);
			}
		}
	}

	/**
	 * Runs the validation for the given diagram
	 * 
	 * @param diagramEditPart
	 * @param view
	 */
	public static void runValidation(DiagramEditPart diagramEditPart, View view) {
		final DiagramEditPart fpart = diagramEditPart;
		final View fview = view;
		TransactionalEditingDomain txDomain = TransactionUtil
				.getEditingDomain(view);
		DiagramValidationProvider.runWithConstraints(txDomain, new Runnable() {

			public void run() {
				validate(fpart, fview);
			}
		});
	}

	/**
	 * Executes the validation for the given diagram
	 * 
	 * @param diagramEditPart
	 * @param view
	 */
	private static void validate(DiagramEditPart diagramEditPart, View view) {
		IFile target = view.eResource() != null ? WorkspaceSynchronizer
				.getFile(view.eResource()) : null;
		if(target != null) {
			DiagramValidationMarkerNavigationProvider.deleteMarkers(target);
		}
		Diagnostic diagnostic = runEMFValidator(view);
		createMarkers(target, diagnostic, diagramEditPart);
	}

	/**
	 * Runs the EMF Validations andCheck Validations for the given View
	 * 
	 * @param target
	 * @return
	 */
	private static Diagnostic runEMFValidator(View target) {
		if(target.isSetElement() && target.getElement() != null) {
			// do the validation on the root element to check all the elements
			// contained into the model
			EObject eo = target.getElement();
			while(eo.eContainer() != null)
				eo = eo.eContainer();

			return new Diagnostician() {

				public String getObjectLabel(EObject eObject) {
					return EMFCoreUtil.getQualifiedName(eObject, true);
				}
			}.validate(eo);
		}
		return Diagnostic.OK_INSTANCE;
	}

	/**
	 * Add the Markers for all the views affected by the validation
	 * 
	 * @param target
	 * @param emfValidationStatus
	 * @param diagramEditPart
	 */
	private static void createMarkers(IFile target,
			Diagnostic emfValidationStatus, DiagramEditPart diagramEditPart) {
		if(emfValidationStatus.getSeverity() == Diagnostic.OK) {
			return;
		}
		for(Iterator<?> it = emfValidationStatus.getChildren().iterator(); it
				.hasNext();) {
			Diagnostic nextDiagnostic = (Diagnostic)it.next();
			List<?> data = nextDiagnostic.getData();
			if(data != null && !data.isEmpty()
					&& data.get(0) instanceof EObject) {
				EObject element = (EObject)data.get(0);
				List<?> list = DiagramEditPartsUtil.getEObjectViews(element);

				// add the marker to the file if affected element has no
				// graphical representation
				if(list.size() == 0) {
					addMarker(target, element.eResource().getURI().toString(),
							EMFCoreUtil.getQualifiedName(element, true),
							nextDiagnostic.getMessage(),
							diagnosticToStatusSeverity(nextDiagnostic
							.getSeverity()));
				}
				// add the marker to the views if the element has representation
				for(Object o : list) {
					if(o instanceof View) {
						View v = (View)o;
						addMarker(target, v.eResource().getURIFragment(v),
								EMFCoreUtil.getQualifiedName(element, true),
								nextDiagnostic.getMessage(),
								diagnosticToStatusSeverity(nextDiagnostic
								.getSeverity()));
					}
				}
			}
		}
	}

	/**
	 * Add one marker to the given element
	 * 
	 * @param target
	 * @param elementId
	 * @param location
	 * @param message
	 * @param statusSeverity
	 */
	private static void addMarker(IFile target, String elementId,
			String location, String message, int statusSeverity) {
		if(target == null) {
			return;
		}
		DiagramValidationMarkerNavigationProvider.addMarker(target, elementId,
				location, message, statusSeverity);
	}

	/**
	 * Check the severity of the Diagnostic
	 * 
	 * @param diagnosticSeverity
	 * @return
	 */
	private static int diagnosticToStatusSeverity(int diagnosticSeverity) {
		if(diagnosticSeverity == Diagnostic.OK) {
			return IStatus.OK;
		} else if(diagnosticSeverity == Diagnostic.INFO) {
			return IStatus.INFO;
		} else if(diagnosticSeverity == Diagnostic.WARNING) {
			return IStatus.WARNING;
		} else if(diagnosticSeverity == Diagnostic.ERROR
				|| diagnosticSeverity == Diagnostic.CANCEL) {
			return IStatus.ERROR;
		}
		return IStatus.INFO;
	}
}
