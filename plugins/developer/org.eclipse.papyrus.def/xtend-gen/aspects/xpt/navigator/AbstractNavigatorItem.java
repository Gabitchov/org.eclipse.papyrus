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
package aspects.xpt.navigator;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.codegen.gmfgen.GenNavigator;
import org.eclipse.gmf.codegen.gmfgen.GenPlugin;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import xpt.Common;

@Singleton
@SuppressWarnings("all")
public class AbstractNavigatorItem extends xpt.navigator.AbstractNavigatorItem {
  @Inject
  @Extension
  private Common _common;
  
  public CharSequence registerAdapterFactory(final GenNavigator it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("static {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@SuppressWarnings(\"rawtypes\")");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("final Class[] supportedTypes = new Class[] { org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor.class };");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("final org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor propertySheetPageContributor = new org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("public String getContributorId() {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return \"");
    GenEditorGenerator _editorGen = it.getEditorGen();
    GenPlugin _plugin = _editorGen.getPlugin();
    String _iD = _plugin.getID();
    _builder.append(_iD, "\t\t\t");
    _builder.append("\";  ");
    CharSequence _nonNLS = this._common.nonNLS(1);
    _builder.append(_nonNLS, "\t\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("};");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("org.eclipse.core.runtime.Platform.getAdapterManager().registerAdapters(new org.eclipse.core.runtime.IAdapterFactory() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("@SuppressWarnings(\"rawtypes\")");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("public Object getAdapter(Object adaptableObject, Class adapterType) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("if (adaptableObject instanceof ");
    CharSequence _qualifiedClassName = this.qualifiedClassName(it);
    _builder.append(_qualifiedClassName, "\t\t\t");
    _builder.append(" && adapterType == org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor.class) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t");
    _builder.append("return propertySheetPageContributor;\t\t\t\t");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return null;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("@SuppressWarnings(\"rawtypes\")");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("public Class[] getAdapterList() {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return supportedTypes;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}, ");
    CharSequence _qualifiedClassName_1 = this.qualifiedClassName(it);
    _builder.append(_qualifiedClassName_1, "\t");
    _builder.append(".class);");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}
