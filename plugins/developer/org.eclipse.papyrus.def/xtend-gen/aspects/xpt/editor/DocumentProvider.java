/**
 * Copyright (c) 2007, 2010, 2013 Borland Software Corporation and others
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
package aspects.xpt.editor;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.eclipse.gmf.codegen.gmfgen.GenApplication;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.codegen.gmfgen.GenPlugin;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import plugin.Activator;
import xpt.Common;
import xpt.Externalizer;

@Singleton
@SuppressWarnings("all")
public class DocumentProvider extends xpt.editor.DocumentProvider {
  @Inject
  @Extension
  private Common _common;
  
  @Inject
  private Activator xptActivator;
  
  @Inject
  private Externalizer xptExternalizer;
  
  public CharSequence setDocumentContent(final GenDiagram it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("protected void setDocumentContent(org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDocument document, org.eclipse.ui.IEditorInput element) throws org.eclipse.core.runtime.CoreException {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDiagramDocument diagramDocument = (org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDiagramDocument) document;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("org.eclipse.emf.transaction.TransactionalEditingDomain domain = diagramDocument.getEditingDomain();");
    _builder.newLine();
    _builder.append("\t");
    {
      GenEditorGenerator _editorGen = it.getEditorGen();
      GenApplication _application = _editorGen.getApplication();
      boolean _equals = Objects.equal(null, _application);
      if (_equals) {
        _builder.append("if (element instanceof ");
        CharSequence _fileEditorInputClassFQName = this.fileEditorInputClassFQName(it);
        _builder.append(_fileEditorInputClassFQName, "\t");
        _builder.append(") {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("org.eclipse.core.resources.IStorage storage = ((");
        CharSequence _fileEditorInputClassFQName_1 = this.fileEditorInputClassFQName(it);
        _builder.append(_fileEditorInputClassFQName_1, "\t\t");
        _builder.append(") element).getStorage();");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("org.eclipse.gmf.runtime.notation.Diagram diagram = org.eclipse.gmf.runtime.diagram.ui.resources.editor.internal.util.DiagramIOUtil.load(domain, storage, true, getProgressMonitor());");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("document.setContent(diagram);");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("} else ");
      }
    }
    _builder.append("if(element instanceof ");
    CharSequence _uriEditorInputClassFQName = this.uriEditorInputClassFQName(it);
    _builder.append(_uriEditorInputClassFQName, "\t");
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("org.eclipse.emf.common.util.URI uri = ((");
    CharSequence _uriEditorInputClassFQName_1 = this.uriEditorInputClassFQName(it);
    _builder.append(_uriEditorInputClassFQName_1, "\t\t");
    _builder.append(") element).getURI();");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("org.eclipse.emf.ecore.resource.Resource resource = null;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("resource = domain.getResourceSet().getResource(uri.trimFragment(), false);");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("if (resource == null) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("resource = domain.getResourceSet().createResource(uri.trimFragment());");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("if (!resource.isLoaded()) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("@SuppressWarnings({ \"rawtypes\", \"unchecked\" })");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("java.util.Map<?,?> options = new java.util.HashMap(org.eclipse.gmf.runtime.emf.core.resources.GMFResourceFactory.getDefaultLoadOptions());");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("// @see 171060 ");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("// options.put(org.eclipse.emf.ecore.xmi.XMLResource.OPTION_RECORD_UNKNOWN_FEATURE, Boolean.TRUE);");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("resource.load(options);");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("} catch (java.io.IOException e) {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("resource.unload();");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("throw e;");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("if (uri.fragment() != null) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("org.eclipse.emf.ecore.EObject rootElement = resource.getEObject(uri.fragment());");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("if (rootElement instanceof org.eclipse.gmf.runtime.notation.Diagram) {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("document.setContent((org.eclipse.gmf.runtime.notation.Diagram) rootElement);");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("return;");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("for (java.util.Iterator<org.eclipse.emf.ecore.EObject> it = resource.getContents().iterator(); it.hasNext();) {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("Object rootElement = it.next();");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("if (rootElement instanceof org.eclipse.gmf.runtime.notation.Diagram) {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("document.setContent((org.eclipse.gmf.runtime.notation.Diagram) rootElement);");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("return;");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("throw new RuntimeException(");
    GenEditorGenerator _editorGen_1 = it.getEditorGen();
    String _i18nKeyForDocumentProviderNoDiagramInResourceError = this.i18nKeyForDocumentProviderNoDiagramInResourceError(it);
    CharSequence _accessorCall = this.xptExternalizer.accessorCall(_editorGen_1, _i18nKeyForDocumentProviderNoDiagramInResourceError);
    _builder.append(_accessorCall, "\t\t\t");
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("} catch (Exception e) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("org.eclipse.core.runtime.CoreException thrownExcp = null;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("if (e instanceof org.eclipse.core.runtime.CoreException) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("thrownExcp = (org.eclipse.core.runtime.CoreException) e;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("String msg = e.getLocalizedMessage();");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("thrownExcp = new org.eclipse.core.runtime.CoreException(new org.eclipse.core.runtime.Status(org.eclipse.core.runtime.IStatus.ERROR, ");
    GenEditorGenerator _editorGen_2 = it.getEditorGen();
    GenPlugin _plugin = _editorGen_2.getPlugin();
    CharSequence _qualifiedClassName = this.xptActivator.qualifiedClassName(_plugin);
    _builder.append(_qualifiedClassName, "\t\t\t\t");
    _builder.append(".ID, 0, ");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t");
    _builder.append("msg != null ? msg : ");
    GenEditorGenerator _editorGen_3 = it.getEditorGen();
    String _i18nKeyForDocumentProviderDiagramLoadingError = this.i18nKeyForDocumentProviderDiagramLoadingError(it);
    CharSequence _accessorCall_1 = this.xptExternalizer.accessorCall(_editorGen_3, _i18nKeyForDocumentProviderDiagramLoadingError);
    _builder.append(_accessorCall_1, "\t\t\t\t");
    _builder.append(", e));");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("throw thrownExcp;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _throwIncorrectInputException = this.throwIncorrectInputException(it);
    _builder.append(_throwIncorrectInputException, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}
