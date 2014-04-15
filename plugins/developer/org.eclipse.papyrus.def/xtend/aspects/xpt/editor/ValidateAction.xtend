/**
 * Copyright (c) 2007, 2010, 2013 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package aspects.xpt.editor

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.gmf.codegen.gmfgen.GenDiagram
import xpt.Common
import xpt.editor.DiagramEditorUtil

@Singleton class ValidateAction extends xpt.editor.ValidateAction {
	@Inject extension Common;
	@Inject DiagramEditorUtil xptDiagramEditorUtil;

	override runNonUIValidation(GenDiagram it) '''
		
		«generatedMemberComment»
		public static void runNonUIValidation(org.eclipse.gmf.runtime.notation.View view) {
			org.eclipse.swt.widgets.Shell shell = org.eclipse.swt.widgets.Display.getCurrent().getActiveShell();
			if (shell == null) {
				shell = new org.eclipse.swt.widgets.Shell();
			}
			
			org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart diagramEditPart =
					org.eclipse.gmf.runtime.diagram.ui.OffscreenEditPartFactory.getInstance().createDiagramEditPart(
							view.getDiagram(),shell);
			runValidation(diagramEditPart, view);
		}		
	'''

	override createMarkersForStatus(GenDiagram it) '''
		
		«generatedMemberComment»
		private static void createMarkers(
				«IF editorGen.application == null»org.eclipse.core.resources.IFile
				«ELSE»org.eclipse.gmf.runtime.notation.View«ENDIF» target,
				org.eclipse.core.runtime.IStatus validationStatus,
				org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart diagramEditPart) {
			if (validationStatus.isOK()) {
			return;
			}
			final org.eclipse.core.runtime.IStatus rootStatus = validationStatus;
			java.util.List allStatuses = new java.util.ArrayList();
			«xptDiagramEditorUtil.qualifiedClassName(it)».LazyElement2ViewMap element2ViewMap = new «xptDiagramEditorUtil.
			qualifiedClassName(it)».LazyElement2ViewMap(
			diagramEditPart.getDiagramView(),
			collectTargetElements(rootStatus, new java.util.HashSet<org.eclipse.emf.ecore.EObject>(), allStatuses));
			for (java.util.Iterator it = allStatuses.iterator(); it.hasNext();) {
			org.eclipse.emf.validation.model.IConstraintStatus nextStatus =
			(org.eclipse.emf.validation.model.IConstraintStatus) it.next();
			org.eclipse.gmf.runtime.notation.View view = «xptDiagramEditorUtil.qualifiedClassName(it)».findView(
			diagramEditPart, nextStatus.getTarget(), element2ViewMap);			
			addMarker(diagramEditPart.getViewer(), target, view.eResource().getURIFragment(view), 
			org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil.getQualifiedName(nextStatus.getTarget(), true), 
			nextStatus.getMessage(), nextStatus.getSeverity());
			}
		}
	'''
	
	override createMarkersForDiagnostic(GenDiagram it) '''
		
		«generatedMemberComment»
		private static void createMarkers(
				«IF editorGen.application == null»org.eclipse.core.resources.IFile
				«ELSE»org.eclipse.gmf.runtime.notation.View«ENDIF» target,
				org.eclipse.emf.common.util.Diagnostic emfValidationStatus,
				org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart diagramEditPart) {
			if (emfValidationStatus.getSeverity() == org.eclipse.emf.common.util.Diagnostic.OK) {
			return;
			}
			final org.eclipse.emf.common.util.Diagnostic rootStatus = emfValidationStatus;
			java.util.List<org.eclipse.emf.common.util.Diagnostic> allDiagnostics = new java.util.ArrayList<org.eclipse.emf.common.util.Diagnostic>();
			«xptDiagramEditorUtil.qualifiedClassName(it)».LazyElement2ViewMap element2ViewMap =
			new «xptDiagramEditorUtil.qualifiedClassName(it)».LazyElement2ViewMap(
				diagramEditPart.getDiagramView(),
				collectTargetElements(rootStatus, new java.util.HashSet<org.eclipse.emf.ecore.EObject>(), allDiagnostics));
			for (java.util.Iterator<org.eclipse.emf.common.util.Diagnostic> it = emfValidationStatus.getChildren().iterator(); it.hasNext();) {
			org.eclipse.emf.common.util.Diagnostic nextDiagnostic = (org.eclipse.emf.common.util.Diagnostic) it.next();
			java.util.List<?> data = nextDiagnostic.getData();
			if (data != null && !data.isEmpty() && data.get(0) instanceof org.eclipse.emf.ecore.EObject) {
			org.eclipse.emf.ecore.EObject element = (org.eclipse.emf.ecore.EObject) data.get(0);
			org.eclipse.gmf.runtime.notation.View view = «xptDiagramEditorUtil.qualifiedClassName(it)».findView(
				diagramEditPart, element, element2ViewMap);
			addMarker(diagramEditPart.getViewer(), target, view.eResource().getURIFragment(view),
				org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil.getQualifiedName(element, true),
				nextDiagnostic.getMessage(), diagnosticToStatusSeverity(nextDiagnostic.getSeverity()));
			}
			}
		}
	'''
	
	override collectTargetElementsFromStatus(GenDiagram it) '''
		
		«generatedMemberComment»
		private static java.util.Set<org.eclipse.emf.ecore.EObject> collectTargetElements(org.eclipse.core.runtime.IStatus status,
				java.util.Set<org.eclipse.emf.ecore.EObject> targetElementCollector, java.util.List<org.eclipse.emf.validation.model.IConstraintStatus> allConstraintStatuses) {
			if (status instanceof org.eclipse.emf.validation.model.IConstraintStatus) {
			targetElementCollector.add(((org.eclipse.emf.validation.model.IConstraintStatus) status).getTarget());
			allConstraintStatuses.add((org.eclipse.emf.validation.model.IConstraintStatus)status);
			}
			if (status.isMultiStatus()) {
			org.eclipse.core.runtime.IStatus[] children = status.getChildren();
			for (int i = 0; i < children.length; i++) {
			collectTargetElements(children[i], targetElementCollector, allConstraintStatuses);				
			}
			}
			return targetElementCollector;
		}
	'''
	
	override collectTargetElementsFromDiagnostic(GenDiagram it) '''
		
		«generatedMemberComment»
		private static java.util.Set<org.eclipse.emf.ecore.EObject> collectTargetElements(org.eclipse.emf.common.util.Diagnostic diagnostic,
				java.util.Set<org.eclipse.emf.ecore.EObject> targetElementCollector, java.util.List<org.eclipse.emf.common.util.Diagnostic> allDiagnostics) {
			java.util.List<?> data = diagnostic.getData();
			org.eclipse.emf.ecore.EObject target = null;
			if (data != null && !data.isEmpty() && data.get(0) instanceof org.eclipse.emf.ecore.EObject) {
			target = (org.eclipse.emf.ecore.EObject) data.get(0);
			targetElementCollector.add(target);	
			allDiagnostics.add(diagnostic);
			}
			if (diagnostic.getChildren() != null && !diagnostic.getChildren().isEmpty()) {
			for (java.util.Iterator<org.eclipse.emf.common.util.Diagnostic> it = diagnostic.getChildren().iterator(); it.hasNext();) {
			collectTargetElements((org.eclipse.emf.common.util.Diagnostic) it.next(),
				targetElementCollector, allDiagnostics);
			}
			}
			return targetElementCollector;
		}
	'''

}
