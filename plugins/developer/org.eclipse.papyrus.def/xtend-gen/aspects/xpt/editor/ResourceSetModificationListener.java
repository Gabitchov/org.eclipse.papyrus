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

@Singleton
@SuppressWarnings("all")
public class ResourceSetModificationListener extends xpt.editor.ResourceSetModificationListener {
  @Inject
  @Extension
  private Common _common;
  
  public CharSequence notifyChanged(final GenDiagram it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.append("\t");
    _builder.newLineIfNotEmpty();
    _builder.append("public void notifyChanged(org.eclipse.emf.common.notify.Notification notification) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (notification.getNotifier() instanceof org.eclipse.emf.ecore.resource.ResourceSet) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("super.notifyChanged(notification);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (!notification.isTouch() && myModifiedFilter.matches(notification)) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (notification.getNotifier() instanceof org.eclipse.emf.ecore.resource.Resource) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("org.eclipse.emf.ecore.resource.Resource resource = (org.eclipse.emf.ecore.resource.Resource) notification.getNotifier();");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("if (resource.isLoaded()) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("boolean modified = false;");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("for (java.util.Iterator<org.eclipse.emf.ecore.resource.Resource> it = myInfo.getLoadedResourcesIterator(); it.hasNext() && !modified;) {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("org.eclipse.emf.ecore.resource.Resource nextResource = (org.eclipse.emf.ecore.resource.Resource) it.next();");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("if (nextResource.isLoaded()) {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("modified = nextResource.isModified();");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("boolean dirtyStateChanged = false;");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("synchronized (myInfo) {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("if (modified != myInfo.fCanBeSaved) {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("myInfo.fCanBeSaved = modified;");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("dirtyStateChanged = true;");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    {
      GenEditorGenerator _editorGen = it.getEditorGen();
      GenApplication _application = _editorGen.getApplication();
      boolean _equals = Objects.equal(null, _application);
      if (_equals) {
        _builder.append("\t\t\t\t\t");
        _builder.append("if (!resource.isModified()) {");
        _builder.newLine();
        _builder.append("\t\t\t\t\t");
        _builder.append("\t");
        _builder.append("myInfo.setSynchronized(resource);");
        _builder.newLine();
        _builder.append("\t\t\t\t\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("if (dirtyStateChanged) {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("fireElementDirtyStateChanged(myInfo.getEditorInput(), modified);");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("if (!modified) {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t\t");
    _builder.append("myInfo.setModificationStamp(computeModificationStamp(myInfo));");
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
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}
