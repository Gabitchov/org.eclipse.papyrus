/*
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.papyrus.uml.diagram.timing.part;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.emf.validation.model.EvaluationMode;
import org.eclipse.emf.validation.model.IConstraintStatus;
import org.eclipse.emf.validation.service.IBatchValidator;
import org.eclipse.emf.validation.service.ModelValidationService;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gmf.runtime.diagram.ui.OffscreenEditPartFactory;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.papyrus.uml.diagram.timing.providers.UMLMarkerNavigationProvider;
import org.eclipse.papyrus.uml.diagram.timing.providers.UMLValidationProvider;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.WorkspaceModifyDelegatingOperation;

/**
 * @generated
 */
@SuppressWarnings("all")
// disable warnings on generated code
public class ValidateAction extends Action {

	/**
	 * @generated
	 */
	private final IWorkbenchPage page;

	/**
	 * @generated
	 */
	public ValidateAction(final IWorkbenchPage page) {
		setText(Messages.ValidateActionMessage);
		this.page = page;
	}

	/**
	 * @generated
	 */
	@Override
	public void run() {
		final IWorkbenchPart workbenchPart = this.page.getActivePart();
		if(workbenchPart instanceof IDiagramWorkbenchPart) {
			final IDiagramWorkbenchPart part = (IDiagramWorkbenchPart)workbenchPart;
			try {
				new WorkspaceModifyDelegatingOperation(new IRunnableWithProgress() {

					public void run(final IProgressMonitor monitor) throws InterruptedException, InvocationTargetException {
						runValidation(part.getDiagramEditPart(), part.getDiagram());
					}
				}).run(new NullProgressMonitor());
			} catch (final Exception e) {
				UMLDiagramEditorPlugin.getInstance().logError("Validation action failed", e); //$NON-NLS-1$
			}
		}
	}

	/**
	 * @generated
	 */
	public static void runValidation(final View view) {
		try {
			if(UMLDiagramEditorUtil.openDiagram(view.eResource())) {
				final IEditorPart editorPart = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
				if(editorPart instanceof IDiagramWorkbenchPart) {
					runValidation(((IDiagramWorkbenchPart)editorPart).getDiagramEditPart(), view);
				} else {
					runNonUIValidation(view);
				}
			}
		} catch (final Exception e) {
			UMLDiagramEditorPlugin.getInstance().logError("Validation action failed", e); //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	public static void runNonUIValidation(final View view) {
		final DiagramEditPart diagramEditPart = OffscreenEditPartFactory.getInstance().createDiagramEditPart(view.getDiagram());
		runValidation(diagramEditPart, view);
	}

	/**
	 * @generated
	 */
	public static void runValidation(final DiagramEditPart diagramEditPart, final View view) {
		final DiagramEditPart fpart = diagramEditPart;
		final View fview = view;
		final TransactionalEditingDomain txDomain = TransactionUtil.getEditingDomain(view);
		UMLValidationProvider.runWithConstraints(txDomain, new Runnable() {

			public void run() {
				validate(fpart, fview);
			}
		});
	}

	/**
	 * @generated
	 */
	private static Diagnostic runEMFValidator(final View target) {
		if(target.isSetElement() && target.getElement() != null) {
			return new Diagnostician() {

				@Override
				public String getObjectLabel(final EObject eObject) {
					return EMFCoreUtil.getQualifiedName(eObject, true);
				}
			}.validate(target.getElement());
		}
		return Diagnostic.OK_INSTANCE;
	}

	/**
	 * @generated
	 */
	private static void validate(final DiagramEditPart diagramEditPart, final View view) {
		final IFile target = view.eResource() != null ? WorkspaceSynchronizer.getFile(view.eResource()) : null;
		if(target != null) {
			UMLMarkerNavigationProvider.deleteMarkers(target);
		}
		final Diagnostic diagnostic = runEMFValidator(view);
		createMarkers(target, diagnostic, diagramEditPart);
		final IBatchValidator validator = (IBatchValidator)ModelValidationService.getInstance().newValidator(EvaluationMode.BATCH);
		validator.setIncludeLiveConstraints(true);
		if(view.isSetElement() && view.getElement() != null) {
			final IStatus status = validator.validate(view.getElement());
			createMarkers(target, status, diagramEditPart);
		}
	}

	/**
	 * @generated
	 */
	private static void createMarkers(final IFile target, final IStatus validationStatus, final DiagramEditPart diagramEditPart) {
		if(validationStatus.isOK()) {
			return;
		}
		final IStatus rootStatus = validationStatus;
		final List allStatuses = new ArrayList();
		final UMLDiagramEditorUtil.LazyElement2ViewMap element2ViewMap = new UMLDiagramEditorUtil.LazyElement2ViewMap(diagramEditPart.getDiagramView(), collectTargetElements(rootStatus, new HashSet<EObject>(), allStatuses));
		for(final Iterator it = allStatuses.iterator(); it.hasNext();) {
			final IConstraintStatus nextStatus = (IConstraintStatus)it.next();
			final View view = UMLDiagramEditorUtil.findView(diagramEditPart, nextStatus.getTarget(), element2ViewMap);
			addMarker(diagramEditPart.getViewer(), target, view.eResource().getURIFragment(view), EMFCoreUtil.getQualifiedName(nextStatus.getTarget(), true), nextStatus.getMessage(), nextStatus.getSeverity());
		}
	}

	/**
	 * @generated
	 */
	private static void createMarkers(final IFile target, final Diagnostic emfValidationStatus, final DiagramEditPart diagramEditPart) {
		if(emfValidationStatus.getSeverity() == Diagnostic.OK) {
			return;
		}
		final Diagnostic rootStatus = emfValidationStatus;
		final List allDiagnostics = new ArrayList();
		final UMLDiagramEditorUtil.LazyElement2ViewMap element2ViewMap = new UMLDiagramEditorUtil.LazyElement2ViewMap(diagramEditPart.getDiagramView(), collectTargetElements(rootStatus, new HashSet<EObject>(), allDiagnostics));
		for(final Object element2 : emfValidationStatus.getChildren()) {
			final Diagnostic nextDiagnostic = (Diagnostic)element2;
			final List data = nextDiagnostic.getData();
			if(data != null && !data.isEmpty() && data.get(0) instanceof EObject) {
				final EObject element = (EObject)data.get(0);
				final View view = UMLDiagramEditorUtil.findView(diagramEditPart, element, element2ViewMap);
				addMarker(diagramEditPart.getViewer(), target, view.eResource().getURIFragment(view), EMFCoreUtil.getQualifiedName(element, true), nextDiagnostic.getMessage(), diagnosticToStatusSeverity(nextDiagnostic.getSeverity()));
			}
		}
	}

	/**
	 * @generated
	 */
	private static void addMarker(final EditPartViewer viewer, final IFile target, final String elementId, final String location, final String message, final int statusSeverity) {
		if(target == null) {
			return;
		}
		UMLMarkerNavigationProvider.addMarker(target, elementId, location, message, statusSeverity);
	}

	/**
	 * @generated
	 */
	private static int diagnosticToStatusSeverity(final int diagnosticSeverity) {
		if(diagnosticSeverity == Diagnostic.OK) {
			return IStatus.OK;
		} else if(diagnosticSeverity == Diagnostic.INFO) {
			return IStatus.INFO;
		} else if(diagnosticSeverity == Diagnostic.WARNING) {
			return IStatus.WARNING;
		} else if(diagnosticSeverity == Diagnostic.ERROR || diagnosticSeverity == Diagnostic.CANCEL) {
			return IStatus.ERROR;
		}
		return IStatus.INFO;
	}

	/**
	 * @generated
	 */
	private static Set<EObject> collectTargetElements(final IStatus status, final Set<EObject> targetElementCollector, final List allConstraintStatuses) {
		if(status instanceof IConstraintStatus) {
			targetElementCollector.add(((IConstraintStatus)status).getTarget());
			allConstraintStatuses.add(status);
		}
		if(status.isMultiStatus()) {
			final IStatus[] children = status.getChildren();
			for(final IStatus element : children) {
				collectTargetElements(element, targetElementCollector, allConstraintStatuses);
			}
		}
		return targetElementCollector;
	}

	/**
	 * @generated
	 */
	private static Set<EObject> collectTargetElements(final Diagnostic diagnostic, final Set<EObject> targetElementCollector, final List allDiagnostics) {
		final List data = diagnostic.getData();
		EObject target = null;
		if(data != null && !data.isEmpty() && data.get(0) instanceof EObject) {
			target = (EObject)data.get(0);
			targetElementCollector.add(target);
			allDiagnostics.add(diagnostic);
		}
		if(diagnostic.getChildren() != null && !diagnostic.getChildren().isEmpty()) {
			for(final Object element : diagnostic.getChildren()) {
				collectTargetElements((Diagnostic)element, targetElementCollector, allDiagnostics);
			}
		}
		return targetElementCollector;
	}
}
