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
 *    Artem Tikhomirov             - refactoring of containerBaseCanonicalMethods.xpt; extraction of API/non-API of CEP templates
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package aspects.impl.diagram.update;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Set;
import metamodel.MetaModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.common.util.EList;
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase;
import org.eclipse.gmf.codegen.gmfgen.GenContainerBase;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenDiagramUpdater;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.codegen.gmfgen.GenLink;
import org.eclipse.gmf.codegen.gmfgen.LinkModelFacet;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import xpt.Common;
import xpt.diagram.updater.DiagramUpdater;
import xpt.diagram.updater.LinkDescriptor;
import xpt.diagram.updater.NodeDescriptor;
import xpt.diagram.updater.Utils_qvto;
import xpt.editor.VisualIDRegistry;

@Singleton
@SuppressWarnings("all")
public class CanonicalUpdate extends impl.diagram.update.CanonicalUpdate {
  @Inject
  @Extension
  private Common _common;
  
  @Inject
  @Extension
  private Utils_qvto _utils_qvto;
  
  @Inject
  private NodeDescriptor nodeDescriptor;
  
  @Inject
  private MetaModel xptMetaModel;
  
  @Inject
  private DiagramUpdater xptDiagramUpdater;
  
  @Inject
  private LinkDescriptor linkDescriptor;
  
  @Inject
  private VisualIDRegistry xptVisualIDRegistry;
  
  public CharSequence getFeaturesToSynchronizeMethod(final GenContainerBase it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      Set<GenFeature> _semanticChildrenChildFeatures = this._utils_qvto.getSemanticChildrenChildFeatures(it);
      int _size = _semanticChildrenChildFeatures.size();
      boolean _equals = (_size == 1);
      if (_equals) {
        _builder.newLine();
        _builder.append("\t");
        CharSequence _generatedMemberComment = this._common.generatedMemberComment();
        _builder.append(_generatedMemberComment, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("protected org.eclipse.emf.ecore.EStructuralFeature getFeatureToSynchronize() {");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("return ");
        Set<GenFeature> _semanticChildrenContainmentFeatures = this._utils_qvto.getSemanticChildrenContainmentFeatures(it);
        GenFeature _head = IterableExtensions.<GenFeature>head(_semanticChildrenContainmentFeatures);
        CharSequence _MetaFeature = this.xptMetaModel.MetaFeature(_head);
        _builder.append(_MetaFeature, "\t\t");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
      } else {
        Set<GenFeature> _semanticChildrenChildFeatures_1 = this._utils_qvto.getSemanticChildrenChildFeatures(it);
        int _size_1 = _semanticChildrenChildFeatures_1.size();
        boolean _greaterThan = (_size_1 > 1);
        if (_greaterThan) {
          _builder.newLine();
          _builder.append("\t");
          CharSequence _generatedMemberComment_1 = this._common.generatedMemberComment();
          _builder.append(_generatedMemberComment_1, "\t");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("protected java.util.Set<org.eclipse.emf.ecore.EStructuralFeature> getFeaturesToSynchronize() {");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("if (myFeaturesToSynchronize == null) {");
          _builder.newLine();
          _builder.append("\t\t\t");
          _builder.append("myFeaturesToSynchronize = new java.util.HashSet<org.eclipse.emf.ecore.EStructuralFeature>();");
          _builder.newLine();
          {
            Set<GenFeature> _semanticChildrenContainmentFeatures_1 = this._utils_qvto.getSemanticChildrenContainmentFeatures(it);
            for(final GenFeature f : _semanticChildrenContainmentFeatures_1) {
              _builder.append("\t\t\t");
              CharSequence _addContainmentFeature = this.addContainmentFeature(f);
              _builder.append(_addContainmentFeature, "\t\t\t");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("\t\t");
          _builder.append("}");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("return myFeaturesToSynchronize;");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
        }
      }
    }
    return _builder;
  }
  
  public CharSequence getSemanticChildrenListMethod(final GenContainerBase it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("protected java.util.List<org.eclipse.emf.ecore.EObject> getSemanticChildrenList() {");
    _builder.newLine();
    {
      boolean _hasSemanticChildren = this._utils_qvto.hasSemanticChildren(it);
      if (_hasSemanticChildren) {
        _builder.append("\t");
        _builder.append("org.eclipse.gmf.runtime.notation.View viewObject = (org.eclipse.gmf.runtime.notation.View) getHost().getModel();");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("java.util.LinkedList<org.eclipse.emf.ecore.EObject> result = new java.util.LinkedList<org.eclipse.emf.ecore.EObject>();");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("java.util.List<");
        GenDiagram _diagram = it.getDiagram();
        GenEditorGenerator _editorGen = _diagram.getEditorGen();
        GenDiagramUpdater _diagramUpdater = _editorGen.getDiagramUpdater();
        CharSequence _qualifiedClassName = this.nodeDescriptor.qualifiedClassName(_diagramUpdater);
        _builder.append(_qualifiedClassName, "\t");
        _builder.append("> childDescriptors = ");
        CharSequence _semanticChildrenMethodCall = this.xptDiagramUpdater.getSemanticChildrenMethodCall(it);
        _builder.append(_semanticChildrenMethodCall, "\t");
        _builder.append("(viewObject);");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("for (");
        GenDiagram _diagram_1 = it.getDiagram();
        GenEditorGenerator _editorGen_1 = _diagram_1.getEditorGen();
        GenDiagramUpdater _diagramUpdater_1 = _editorGen_1.getDiagramUpdater();
        CharSequence _qualifiedClassName_1 = this.nodeDescriptor.qualifiedClassName(_diagramUpdater_1);
        _builder.append(_qualifiedClassName_1, "\t");
        _builder.append(" d : childDescriptors) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("result.add(d.getModelElement());");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("return result;");
        _builder.newLine();
      } else {
        _builder.append("\t");
        _builder.append("return java.util.Collections.EMPTY_LIST;");
        _builder.newLine();
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence refreshConnectionsBody(final GenDiagram it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _Domain2Notation = this.Domain2Notation(it);
    _builder.append(_Domain2Notation, "");
    _builder.append(" domain2NotationMap = new ");
    CharSequence _Domain2Notation_1 = this.Domain2Notation(it);
    _builder.append(_Domain2Notation_1, "");
    _builder.append("();");
    _builder.newLineIfNotEmpty();
    _builder.append("java.util.Collection<");
    GenEditorGenerator _editorGen = it.getEditorGen();
    GenDiagramUpdater _diagramUpdater = _editorGen.getDiagramUpdater();
    CharSequence _qualifiedClassName = this.linkDescriptor.qualifiedClassName(_diagramUpdater);
    _builder.append(_qualifiedClassName, "");
    _builder.append("> linkDescriptors = collectAllLinks(getDiagram(), domain2NotationMap);");
    _builder.newLineIfNotEmpty();
    _builder.append("java.util.List<org.eclipse.gmf.runtime.notation.View> edges = new java.util.ArrayList<org.eclipse.gmf.runtime.notation.View>();");
    _builder.newLine();
    _builder.append("for (Object edge : getDiagram().getEdges())");
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (edge instanceof org.eclipse.gmf.runtime.notation.View)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("edges.add((org.eclipse.gmf.runtime.notation.View) edge);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("java.util.Collection<org.eclipse.gmf.runtime.notation.View> existingLinks = new java.util.LinkedList<org.eclipse.gmf.runtime.notation.View>(edges);");
    _builder.newLine();
    _builder.append("for (java.util.Iterator<org.eclipse.gmf.runtime.notation.View> linksIterator = existingLinks.iterator(); linksIterator.hasNext();) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("org.eclipse.gmf.runtime.notation.Edge nextDiagramLink = (org.eclipse.gmf.runtime.notation.Edge) linksIterator.next();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int diagramLinkVisualID = ");
    CharSequence _visualIDMethodCall = this.xptVisualIDRegistry.getVisualIDMethodCall(it);
    _builder.append(_visualIDMethodCall, "\t");
    _builder.append("(nextDiagramLink);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("if (diagramLinkVisualID == -1");
    {
      EList<GenLink> _links = it.getLinks();
      final Function1<GenLink,Boolean> _function = new Function1<GenLink,Boolean>() {
        public Boolean apply(final GenLink gl) {
          LinkModelFacet _modelFacet = gl.getModelFacet();
          return Boolean.valueOf(Objects.equal(_modelFacet, null));
        }
      };
      Iterable<GenLink> _filter = IterableExtensions.<GenLink>filter(_links, _function);
      for(final GenLink link : _filter) {
        CharSequence _compareLinkVisualID = this.compareLinkVisualID(link);
        _builder.append(_compareLinkVisualID, "\t");
      }
    }
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("if (nextDiagramLink.getSource() != null && nextDiagramLink.getTarget() != null) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("linksIterator.remove();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("continue;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("org.eclipse.emf.ecore.EObject diagramLinkObject = nextDiagramLink.getElement();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("org.eclipse.emf.ecore.EObject diagramLinkSrc = nextDiagramLink.getSource().getElement();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("org.eclipse.emf.ecore.EObject diagramLinkDst = nextDiagramLink.getTarget().getElement();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("for (java.util.Iterator<");
    GenEditorGenerator _editorGen_1 = it.getEditorGen();
    GenDiagramUpdater _diagramUpdater_1 = _editorGen_1.getDiagramUpdater();
    String _linkDescriptorQualifiedClassName = _diagramUpdater_1.getLinkDescriptorQualifiedClassName();
    _builder.append(_linkDescriptorQualifiedClassName, "\t");
    _builder.append("> linkDescriptorsIterator = linkDescriptors.iterator(); linkDescriptorsIterator.hasNext();) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    GenEditorGenerator _editorGen_2 = it.getEditorGen();
    GenDiagramUpdater _diagramUpdater_2 = _editorGen_2.getDiagramUpdater();
    CharSequence _qualifiedClassName_1 = this.linkDescriptor.qualifiedClassName(_diagramUpdater_2);
    _builder.append(_qualifiedClassName_1, "\t\t");
    _builder.append(" nextLinkDescriptor = linkDescriptorsIterator.next();");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("if (diagramLinkObject == nextLinkDescriptor.getModelElement() && diagramLinkSrc == nextLinkDescriptor.getSource() && diagramLinkDst == nextLinkDescriptor.getDestination() && diagramLinkVisualID == nextLinkDescriptor.getVisualID()) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("linksIterator.remove();");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("linkDescriptorsIterator.remove();");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("break;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("deleteViews(existingLinks.iterator());");
    _builder.newLine();
    _builder.append("return createConnections(linkDescriptors, domain2NotationMap);");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence collectAllLinksMethod(final GenDiagram it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _generatedMemberComment = this._common.generatedMemberComment();
    _builder.append(_generatedMemberComment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("private java.util.Collection<");
    GenEditorGenerator _editorGen = it.getEditorGen();
    GenDiagramUpdater _diagramUpdater = _editorGen.getDiagramUpdater();
    CharSequence _qualifiedClassName = this.linkDescriptor.qualifiedClassName(_diagramUpdater);
    _builder.append(_qualifiedClassName, "");
    _builder.append("> collectAllLinks(org.eclipse.gmf.runtime.notation.View view, ");
    CharSequence _Domain2Notation = this.Domain2Notation(it);
    _builder.append(_Domain2Notation, "");
    _builder.append(" domain2NotationMap) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("if (!");
    CharSequence _modelID = VisualIDRegistry.modelID(it);
    _builder.append(_modelID, "\t");
    _builder.append(".equals(");
    CharSequence _modelIDMethodCall = this.xptVisualIDRegistry.getModelIDMethodCall(it);
    _builder.append(_modelIDMethodCall, "\t");
    _builder.append("(view))) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("return java.util.Collections.emptyList();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("java.util.LinkedList<");
    GenEditorGenerator _editorGen_1 = it.getEditorGen();
    GenDiagramUpdater _diagramUpdater_1 = _editorGen_1.getDiagramUpdater();
    CharSequence _qualifiedClassName_1 = this.linkDescriptor.qualifiedClassName(_diagramUpdater_1);
    _builder.append(_qualifiedClassName_1, "\t");
    _builder.append("> result = new java.util.LinkedList<");
    GenEditorGenerator _editorGen_2 = it.getEditorGen();
    GenDiagramUpdater _diagramUpdater_2 = _editorGen_2.getDiagramUpdater();
    CharSequence _qualifiedClassName_2 = this.linkDescriptor.qualifiedClassName(_diagramUpdater_2);
    _builder.append(_qualifiedClassName_2, "\t");
    _builder.append(">();");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("switch (");
    CharSequence _visualIDMethodCall = this.xptVisualIDRegistry.getVisualIDMethodCall(it);
    _builder.append(_visualIDMethodCall, "\t");
    _builder.append("(view)) {");
    _builder.newLineIfNotEmpty();
    {
      Iterable<GenCommonBase> _allSemanticElements = this._utils_qvto.getAllSemanticElements(it);
      for(final GenCommonBase se : _allSemanticElements) {
        _builder.append("\t\t");
        CharSequence _caseSemanticElement = this.caseSemanticElement(se);
        _builder.append(_caseSemanticElement, "\t\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("for (java.util.Iterator<?> children = view.getChildren().iterator(); children.hasNext();) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("result.addAll(collectAllLinks((org.eclipse.gmf.runtime.notation.View) children.next(), domain2NotationMap));");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("for (java.util.Iterator<?> edges = view.getSourceEdges().iterator(); edges.hasNext();) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("result.addAll(collectAllLinks((org.eclipse.gmf.runtime.notation.View) edges.next(), domain2NotationMap));");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return result;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}
