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
package aspects.xpt.navigator;

import aspects.xpt.navigator.DomainNavigatorItem;
import aspects.xpt.navigator.NavigatorContentProvider;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.eclipse.gmf.codegen.gmfgen.GenNavigator;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import plugin.Activator;
import xpt.Common;

@Singleton
@SuppressWarnings("all")
public class DomainNavigatorContentProvider extends xpt.navigator.DomainNavigatorContentProvider {
  @Inject
  @Extension
  private Common _common;
  
  @Inject
  private Activator xptActivator;
  
  @Inject
  private NavigatorContentProvider xptNavigatorContentProvider;
  
  @Inject
  private DomainNavigatorItem xptDomainNavigatorItem;
  
  public CharSequence wrapEObjects(final GenNavigator it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("public Object[] wrapEObjects(Object[] objects, Object parentElement) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("java.util.Collection<");
    CharSequence _qualifiedClassName = this.xptDomainNavigatorItem.qualifiedClassName(it);
    _builder.append(_qualifiedClassName, "\t");
    _builder.append("> result = new java.util.ArrayList<");
    CharSequence _qualifiedClassName_1 = this.xptDomainNavigatorItem.qualifiedClassName(it);
    _builder.append(_qualifiedClassName_1, "\t");
    _builder.append(">();");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("for (int i = 0; i < objects.length; i++) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (objects[i] instanceof org.eclipse.emf.ecore.EObject) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("result.add(new ");
    CharSequence _qualifiedClassName_2 = this.xptDomainNavigatorItem.qualifiedClassName(it);
    _builder.append(_qualifiedClassName_2, "\t\t\t");
    _builder.append("((org.eclipse.emf.ecore.EObject) objects[i], parentElement, myAdapterFctoryContentProvier));");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return result.toArray();");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}
