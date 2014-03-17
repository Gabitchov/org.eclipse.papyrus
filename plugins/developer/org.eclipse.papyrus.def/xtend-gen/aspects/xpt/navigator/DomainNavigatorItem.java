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
import org.eclipse.gmf.codegen.gmfgen.GenNavigator;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import xpt.Common;

@Singleton
@SuppressWarnings("all")
public class DomainNavigatorItem extends xpt.navigator.DomainNavigatorItem {
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
    _builder.append("final Class[] supportedTypes = new Class[] { org.eclipse.emf.ecore.EObject.class, org.eclipse.ui.views.properties.IPropertySource.class };");
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
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t");
    CharSequence _qualifiedClassName_1 = this.qualifiedClassName(it);
    _builder.append(_qualifiedClassName_1, "\t\t\t\t");
    _builder.append(" domainNavigatorItem = (");
    CharSequence _qualifiedClassName_2 = this.qualifiedClassName(it);
    _builder.append(_qualifiedClassName_2, "\t\t\t\t");
    _builder.append(") adaptableObject;");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t");
    _builder.append("org.eclipse.emf.ecore.EObject eObject = domainNavigatorItem.getEObject();");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("if (adapterType == org.eclipse.emf.ecore.EObject.class) {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("return eObject;");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("if (adapterType == org.eclipse.ui.views.properties.IPropertySource.class) {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("return domainNavigatorItem.getPropertySourceProvider().getPropertySource(eObject);");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
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
    CharSequence _qualifiedClassName_3 = this.qualifiedClassName(it);
    _builder.append(_qualifiedClassName_3, "\t");
    _builder.append(".class);");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}
