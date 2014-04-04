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
package aspects.xpt.editor;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.eclipse.gmf.codegen.gmfgen.GenApplication;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import xpt.Common;
import xpt.editor.DiagramEditorUtil;

@Singleton
@SuppressWarnings("all")
public class ValidateAction extends xpt.editor.ValidateAction {
  @Inject
  @Extension
  private Common _common;
  
  @Inject
  private DiagramEditorUtil xptDiagramEditorUtil;
  
  public CharSequence runNonUIValidation(final GenDiagram it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("public static void runNonUIValidation(org.eclipse.gmf.runtime.notation.View view) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("org.eclipse.swt.widgets.Shell shell = org.eclipse.swt.widgets.Display.getCurrent().getActiveShell();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (shell == null) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("shell = new org.eclipse.swt.widgets.Shell();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart diagramEditPart =");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("org.eclipse.gmf.runtime.diagram.ui.OffscreenEditPartFactory.getInstance().createDiagramEditPart(");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("view.getDiagram(),shell);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("runValidation(diagramEditPart, view);");
    _builder.newLine();
    _builder.append("}\t\t");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence createMarkersForStatus(final GenDiagram it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("private static void createMarkers(");
    _builder.newLine();
    _builder.append("\t\t");
    {
      GenEditorGenerator _editorGen = it.getEditorGen();
      GenApplication _application = _editorGen.getApplication();
      boolean _equals = Objects.equal(_application, null);
      if (_equals) {
        _builder.append("org.eclipse.core.resources.IFile");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
      } else {
        _builder.append("org.eclipse.gmf.runtime.notation.View");
      }
    }
    _builder.append(" target,");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("org.eclipse.core.runtime.IStatus validationStatus,");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart diagramEditPart) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (validationStatus.isOK()) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("final org.eclipse.core.runtime.IStatus rootStatus = validationStatus;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("java.util.List allStatuses = new java.util.ArrayList();");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _qualifiedClassName = this.xptDiagramEditorUtil.qualifiedClassName(it);
    _builder.append(_qualifiedClassName, "\t");
    _builder.append(".LazyElement2ViewMap element2ViewMap = new ");
    CharSequence _qualifiedClassName_1 = this.xptDiagramEditorUtil.qualifiedClassName(it);
    _builder.append(_qualifiedClassName_1, "\t");
    _builder.append(".LazyElement2ViewMap(");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("diagramEditPart.getDiagramView(),");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("collectTargetElements(rootStatus, new java.util.HashSet<org.eclipse.emf.ecore.EObject>(), allStatuses));");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("for (java.util.Iterator it = allStatuses.iterator(); it.hasNext();) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("org.eclipse.emf.validation.model.IConstraintStatus nextStatus =");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("(org.eclipse.emf.validation.model.IConstraintStatus) it.next();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("org.eclipse.gmf.runtime.notation.View view = ");
    CharSequence _qualifiedClassName_2 = this.xptDiagramEditorUtil.qualifiedClassName(it);
    _builder.append(_qualifiedClassName_2, "\t");
    _builder.append(".findView(");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("diagramEditPart, nextStatus.getTarget(), element2ViewMap);\t\t\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("addMarker(diagramEditPart.getViewer(), target, view.eResource().getURIFragment(view), ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil.getQualifiedName(nextStatus.getTarget(), true), ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("nextStatus.getMessage(), nextStatus.getSeverity());");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence createMarkersForDiagnostic(final GenDiagram it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("private static void createMarkers(");
    _builder.newLine();
    _builder.append("\t\t");
    {
      GenEditorGenerator _editorGen = it.getEditorGen();
      GenApplication _application = _editorGen.getApplication();
      boolean _equals = Objects.equal(_application, null);
      if (_equals) {
        _builder.append("org.eclipse.core.resources.IFile");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
      } else {
        _builder.append("org.eclipse.gmf.runtime.notation.View");
      }
    }
    _builder.append(" target,");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("org.eclipse.emf.common.util.Diagnostic emfValidationStatus,");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart diagramEditPart) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (emfValidationStatus.getSeverity() == org.eclipse.emf.common.util.Diagnostic.OK) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("final org.eclipse.emf.common.util.Diagnostic rootStatus = emfValidationStatus;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("java.util.List<org.eclipse.emf.common.util.Diagnostic> allDiagnostics = new java.util.ArrayList<org.eclipse.emf.common.util.Diagnostic>();");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _qualifiedClassName = this.xptDiagramEditorUtil.qualifiedClassName(it);
    _builder.append(_qualifiedClassName, "\t");
    _builder.append(".LazyElement2ViewMap element2ViewMap =");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("new ");
    CharSequence _qualifiedClassName_1 = this.xptDiagramEditorUtil.qualifiedClassName(it);
    _builder.append(_qualifiedClassName_1, "\t");
    _builder.append(".LazyElement2ViewMap(");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("diagramEditPart.getDiagramView(),");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("collectTargetElements(rootStatus, new java.util.HashSet<org.eclipse.emf.ecore.EObject>(), allDiagnostics));");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("for (java.util.Iterator<org.eclipse.emf.common.util.Diagnostic> it = emfValidationStatus.getChildren().iterator(); it.hasNext();) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("org.eclipse.emf.common.util.Diagnostic nextDiagnostic = (org.eclipse.emf.common.util.Diagnostic) it.next();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("java.util.List<?> data = nextDiagnostic.getData();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (data != null && !data.isEmpty() && data.get(0) instanceof org.eclipse.emf.ecore.EObject) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("org.eclipse.emf.ecore.EObject element = (org.eclipse.emf.ecore.EObject) data.get(0);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("org.eclipse.gmf.runtime.notation.View view = ");
    CharSequence _qualifiedClassName_2 = this.xptDiagramEditorUtil.qualifiedClassName(it);
    _builder.append(_qualifiedClassName_2, "\t");
    _builder.append(".findView(");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("diagramEditPart, element, element2ViewMap);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("addMarker(diagramEditPart.getViewer(), target, view.eResource().getURIFragment(view),");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil.getQualifiedName(element, true),");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("nextDiagnostic.getMessage(), diagnosticToStatusSeverity(nextDiagnostic.getSeverity()));");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence collectTargetElementsFromStatus(final GenDiagram it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("private static java.util.Set<org.eclipse.emf.ecore.EObject> collectTargetElements(org.eclipse.core.runtime.IStatus status,");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("java.util.Set<org.eclipse.emf.ecore.EObject> targetElementCollector, java.util.List<org.eclipse.emf.validation.model.IConstraintStatus> allConstraintStatuses) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (status instanceof org.eclipse.emf.validation.model.IConstraintStatus) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("targetElementCollector.add(((org.eclipse.emf.validation.model.IConstraintStatus) status).getTarget());");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("allConstraintStatuses.add((org.eclipse.emf.validation.model.IConstraintStatus)status);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (status.isMultiStatus()) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("org.eclipse.core.runtime.IStatus[] children = status.getChildren();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("for (int i = 0; i < children.length; i++) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("collectTargetElements(children[i], targetElementCollector, allConstraintStatuses);\t\t\t\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return targetElementCollector;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence collectTargetElementsFromDiagnostic(final GenDiagram it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("private static java.util.Set<org.eclipse.emf.ecore.EObject> collectTargetElements(org.eclipse.emf.common.util.Diagnostic diagnostic,");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("java.util.Set<org.eclipse.emf.ecore.EObject> targetElementCollector, java.util.List<org.eclipse.emf.common.util.Diagnostic> allDiagnostics) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("java.util.List<?> data = diagnostic.getData();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("org.eclipse.emf.ecore.EObject target = null;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (data != null && !data.isEmpty() && data.get(0) instanceof org.eclipse.emf.ecore.EObject) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("target = (org.eclipse.emf.ecore.EObject) data.get(0);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("targetElementCollector.add(target);\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("allDiagnostics.add(diagnostic);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (diagnostic.getChildren() != null && !diagnostic.getChildren().isEmpty()) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("for (java.util.Iterator<org.eclipse.emf.common.util.Diagnostic> it = diagnostic.getChildren().iterator(); it.hasNext();) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("collectTargetElements((org.eclipse.emf.common.util.Diagnostic) it.next(),");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("targetElementCollector, allDiagnostics);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return targetElementCollector;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}
