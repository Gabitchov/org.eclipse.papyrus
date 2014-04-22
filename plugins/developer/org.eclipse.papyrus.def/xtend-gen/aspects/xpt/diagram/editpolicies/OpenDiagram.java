/**
 * Copyright (c) 2007, 2010, 2013 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package aspects.xpt.diagram.editpolicies;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.eclipse.gmf.codegen.gmfgen.GenApplication;
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.codegen.gmfgen.OpenDiagramBehaviour;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import xpt.Common;
import xpt.editor.DiagramEditorUtil;

@Singleton
@SuppressWarnings("all")
public class OpenDiagram extends xpt.diagram.editpolicies.OpenDiagram {
  @Inject
  @Extension
  private Common _common;
  
  @Inject
  private DiagramEditorUtil xptDiagramEditorUtil;
  
  public CharSequence openCommandClass_intializeNewDiagram(final OpenDiagramBehaviour it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("protected org.eclipse.gmf.runtime.notation.Diagram intializeNewDiagram() throws org.eclipse.core.commands.ExecutionException {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("org.eclipse.gmf.runtime.notation.Diagram d = org.eclipse.gmf.runtime.diagram.core.services.ViewService.createDiagram(getDiagramDomainElement(), getDiagramKind(), getPreferencesHint());");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (d == null) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("throw new org.eclipse.core.commands.ExecutionException(\"Can\'t create diagram of \'\" + getDiagramKind() + \"\' kind\");");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("diagramFacet.setDiagramLink(d);");
    _builder.newLine();
    _builder.append("\t");
    CharSequence __assert = this._common._assert("diagramFacet.eResource() != null");
    _builder.append(__assert, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("diagramFacet.eResource().getContents().add(d);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("org.eclipse.emf.ecore.EObject container = diagramFacet.eContainer();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("while (container instanceof org.eclipse.gmf.runtime.notation.View) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("((org.eclipse.gmf.runtime.notation.View) container).persist();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("container = container.eContainer();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("try {");
    _builder.newLine();
    {
      GenCommonBase _subject = it.getSubject();
      GenDiagram _diagram = _subject.getDiagram();
      GenEditorGenerator _editorGen = _diagram.getEditorGen();
      GenApplication _application = _editorGen.getApplication();
      boolean _equals = Objects.equal(null, _application);
      if (_equals) {
        _builder.append("\t");
        _builder.append("new org.eclipse.ui.actions.WorkspaceModifyOperation() {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("protected void execute(org.eclipse.core.runtime.IProgressMonitor monitor) throws org.eclipse.core.runtime.CoreException, java.lang.reflect.InvocationTargetException, InterruptedException {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t\t");
        _builder.append("try {");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.append("for (java.util.Iterator<?> it = diagramFacet.eResource().getResourceSet().getResources().iterator(); it.hasNext();) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("org.eclipse.emf.ecore.resource.Resource nextResource = (org.eclipse.emf.ecore.resource.Resource) it.next();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (nextResource.isLoaded() && !getEditingDomain().isReadOnly(nextResource)) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("nextResource.save(");
    GenCommonBase _subject_1 = it.getSubject();
    GenDiagram _diagram_1 = _subject_1.getDiagram();
    CharSequence _qualifiedClassName = this.xptDiagramEditorUtil.qualifiedClassName(_diagram_1);
    _builder.append(_qualifiedClassName, "\t\t\t");
    _builder.append(".getSaveOptions());");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    {
      GenCommonBase _subject_2 = it.getSubject();
      GenDiagram _diagram_2 = _subject_2.getDiagram();
      GenEditorGenerator _editorGen_1 = _diagram_2.getEditorGen();
      GenApplication _application_1 = _editorGen_1.getApplication();
      boolean _equals_1 = Objects.equal(null, _application_1);
      if (_equals_1) {
        _builder.append("\t");
        _builder.append("} catch (java.io.IOException ex) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("throw new java.lang.reflect.InvocationTargetException(ex, \"Save operation failed\");");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}\t\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}.run(null);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("} catch (java.lang.reflect.InvocationTargetException e) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("throw new org.eclipse.core.commands.ExecutionException(\"Can\'t create diagram of \'\" + getDiagramKind() + \"\' kind\", e);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("} catch (InterruptedException e) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("throw new org.eclipse.core.commands.ExecutionException(\"Can\'t create diagram of \'\" + getDiagramKind() + \"\' kind\", e);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
      } else {
        _builder.append("\t");
        _builder.append("} catch (java.io.IOException ex) {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("throw new org.eclipse.core.commands.ExecutionException(\"Can\'t create diagram of \'\" + getDiagramKind() + \"\' kind\", ex);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.append("return d;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}
