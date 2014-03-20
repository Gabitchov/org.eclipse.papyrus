/**
 * Copyright (c) 2007, 2009, 2013 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package aspects.xpt.diagram.updater;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.eclipse.gmf.codegen.gmfgen.GenDiagramUpdater;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import xpt.Common;

@Singleton
@SuppressWarnings("all")
public class UpdateCommand extends xpt.diagram.updater.UpdateCommand {
  @Inject
  @Extension
  private Common _common;
  
  public CharSequence execute(final GenDiagramUpdater it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("public Object execute(org.eclipse.core.commands.ExecutionEvent event) throws org.eclipse.core.commands.ExecutionException {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("org.eclipse.jface.viewers.ISelection selection = org.eclipse.ui.PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (selection instanceof org.eclipse.jface.viewers.IStructuredSelection) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("org.eclipse.jface.viewers.IStructuredSelection structuredSelection = (org.eclipse.jface.viewers.IStructuredSelection) selection;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (structuredSelection.size() != 1) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return null;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (structuredSelection.getFirstElement() instanceof org.eclipse.gef.EditPart && ((org.eclipse.gef.EditPart) structuredSelection.getFirstElement()).getModel() instanceof org.eclipse.gmf.runtime.notation.View) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("org.eclipse.emf.ecore.EObject modelElement = ((org.eclipse.gmf.runtime.notation.View) ((org.eclipse.gef.EditPart) structuredSelection.getFirstElement()).getModel()).getElement();");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("java.util.List<?> editPolicies = org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy.getRegisteredEditPolicies(modelElement);");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("for (java.util.Iterator<?> it = editPolicies.iterator(); it.hasNext();) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy nextEditPolicy = (org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy) it.next();");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("nextEditPolicy.refresh();");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return null;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}
