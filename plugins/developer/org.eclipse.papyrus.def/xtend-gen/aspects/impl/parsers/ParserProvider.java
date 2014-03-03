/**
 * Copyright (c) 2007-2013 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 *    Artem Tikhomirov (Borland) - [235113] alternative parser access
 *                                 [244419] custom parsers
 *                                 [138179] expression-backed labels
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package aspects.impl.parsers;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import impl.parsers.expression_qvto;
import metamodel.MetaModel;
import org.eclipse.gmf.codegen.gmfgen.GenParsers;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import parsers.ExpressionLabelParser;
import parsers.PredefinedParser;
import plugin.Activator;
import xpt.Common;
import xpt.Common_qvto;
import xpt.editor.VisualIDRegistry;
import xpt.expressions.OclTracker_qvto;
import xpt.expressions.getExpression;
import xpt.providers.ElementTypes;
import xpt.providers.ParserUtils_qvto;

@Singleton
@SuppressWarnings("all")
public class ParserProvider extends impl.parsers.ParserProvider {
  @Inject
  @Extension
  private Common _common;
  
  @Inject
  @Extension
  private Common_qvto _common_qvto;
  
  @Inject
  @Extension
  private OclTracker_qvto _oclTracker_qvto;
  
  @Inject
  @Extension
  private ParserUtils_qvto _parserUtils_qvto;
  
  @Inject
  @Extension
  private expression_qvto _expression_qvto;
  
  @Inject
  @Extension
  private ExpressionLabelParser _expressionLabelParser;
  
  @Inject
  @Extension
  private PredefinedParser _predefinedParser;
  
  @Inject
  private getExpression xptGetExpression;
  
  @Inject
  private MetaModel xptMetaModel;
  
  @Inject
  private VisualIDRegistry xptVisualIDRegistry;
  
  @Inject
  private ElementTypes xptElementTypes;
  
  @Inject
  private parsers.ParserProvider xptParsers;
  
  @Inject
  private Activator xptActivator;
  
  public CharSequence HintAdapterClass(final GenParsers it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\t");
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("private static class HintAdapter extends org.eclipse.gmf.runtime.emf.ui.services.parser.ParserHintAdapter {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t");
    CharSequence _generatedMemberComment_1 = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment_1, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("private final org.eclipse.gmf.runtime.emf.type.core.IElementType elementType;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t");
    CharSequence _generatedMemberComment_2 = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment_2, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("public HintAdapter(org.eclipse.gmf.runtime.emf.type.core.IElementType type,");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("org.eclipse.emf.ecore.EObject object, String parserHint) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("super(object, parserHint);");
    _builder.newLine();
    _builder.append("\t\t\t");
    CharSequence __assert = this._common._assert("type != null");
    _builder.append(__assert, "\t\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("elementType = type;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t");
    CharSequence _generatedMemberComment_3 = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment_3, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("public Object getAdapter(@SuppressWarnings(\"rawtypes\") Class adapter) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("if (org.eclipse.gmf.runtime.emf.type.core.IElementType.class.equals(adapter)) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("return elementType;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return super.getAdapter(adapter);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}
