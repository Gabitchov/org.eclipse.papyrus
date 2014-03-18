/**
 * Copyright (c) 2006, 2010, 2013 Borland Software Corporation and others
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
package aspects.xpt.providers;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.List;
import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.common.util.EList;
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenLink;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.gmf.codegen.gmfgen.LinkModelFacet;
import org.eclipse.gmf.codegen.gmfgen.TypeModelFacet;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import xpt.Common;
import xpt.diagram.Utils_qvto;

@Singleton
@SuppressWarnings("all")
public class ElementTypes extends xpt.providers.ElementTypes {
  @Inject
  @Extension
  private Common _common;
  
  @Inject
  @Extension
  private Utils_qvto _utils_qvto;
  
  public CharSequence getElement(final GenDiagram it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment("Returns \'type\' of the ecore object associated with the hint.\n");
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("public static synchronized org.eclipse.emf.ecore.ENamedElement getElement(org.eclipse.core.runtime.IAdaptable hint) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Object type = hint.getAdapter(org.eclipse.gmf.runtime.emf.type.core.IElementType.class);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (elements == null) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("elements = new java.util.IdentityHashMap<org.eclipse.gmf.runtime.emf.type.core.IElementType, org.eclipse.emf.ecore.ENamedElement>();");
    _builder.newLine();
    _builder.append("\t\t");
    {
      GenClass _domainDiagramElement = it.getDomainDiagramElement();
      boolean _notEquals = (!Objects.equal(_domainDiagramElement, null));
      if (_notEquals) {
        GenClass _domainDiagramElement_1 = it.getDomainDiagramElement();
        String _uniqueIdentifier = it.getUniqueIdentifier();
        CharSequence _bindUniqueIdentifierToNamedElement = this.bindUniqueIdentifierToNamedElement(_domainDiagramElement_1, _uniqueIdentifier);
        _builder.append(_bindUniqueIdentifierToNamedElement, "\t\t");
      }
    }
    _builder.newLineIfNotEmpty();
    {
      EList<GenNode> _allNodes = it.getAllNodes();
      for(final GenNode node : _allNodes) {
        _builder.append("\t\t");
        {
          TypeModelFacet _modelFacet = node.getModelFacet();
          boolean _notEquals_1 = (!Objects.equal(_modelFacet, null));
          if (_notEquals_1) {
            TypeModelFacet _modelFacet_1 = node.getModelFacet();
            String _uniqueIdentifier_1 = node.getUniqueIdentifier();
            CharSequence _bindUniqueIdentifierToNamedElement_1 = this.bindUniqueIdentifierToNamedElement(_modelFacet_1, _uniqueIdentifier_1);
            _builder.append(_bindUniqueIdentifierToNamedElement_1, "\t\t");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    {
      EList<GenLink> _links = it.getLinks();
      for(final GenLink link : _links) {
        _builder.append("\t\t");
        {
          LinkModelFacet _modelFacet_2 = link.getModelFacet();
          boolean _notEquals_2 = (!Objects.equal(_modelFacet_2, null));
          if (_notEquals_2) {
            LinkModelFacet _modelFacet_3 = link.getModelFacet();
            String _uniqueIdentifier_2 = link.getUniqueIdentifier();
            CharSequence _bindUniqueIdentifierToNamedElement_2 = this.bindUniqueIdentifierToNamedElement(_modelFacet_3, _uniqueIdentifier_2);
            _builder.append(_bindUniqueIdentifierToNamedElement_2, "\t\t");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return (org.eclipse.emf.ecore.ENamedElement) elements.get(type);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence isKnownElementType(final GenDiagram it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("public static synchronized boolean isKnownElementType(org.eclipse.gmf.runtime.emf.type.core.IElementType elementType) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (KNOWN_ELEMENT_TYPES == null) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("KNOWN_ELEMENT_TYPES = new java.util.HashSet<org.eclipse.gmf.runtime.emf.type.core.IElementType>();");
    _builder.newLine();
    {
      List<GenCommonBase> _allTypedElements = this._utils_qvto.getAllTypedElements(it);
      for(final GenCommonBase e : _allTypedElements) {
        _builder.append("\t\t");
        CharSequence _addKnownElementType = this.addKnownElementType(e);
        _builder.append(_addKnownElementType, "\t\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return KNOWN_ELEMENT_TYPES.contains(elementType);");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}
