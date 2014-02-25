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
 *    Artem Tikhomirov (Borland) - [257119] Create views directly, not through ViewFactories
 * 	  Michael Golubev (Montages) - #386838 - migrate to Xtend2
 *    Thibault Landre (Atos Origin) - initial API and implementation
 *	  Vincent Lorenzo (CEA-LIST) Add a line to initialize the display of the compartments to true
 *    Vincent Lorenzo (CEA-LIST) - Add lines to initialize the display of the labels - Bug 335987 [General][Enhancement] Show/Hide Connectors Labels and External Nodes Labels
 */
package aspects.xpt.providers

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.gmf.codegen.gmfgen.GenChildLabelNode
import org.eclipse.gmf.codegen.gmfgen.GenChildNode
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase
import org.eclipse.gmf.codegen.gmfgen.GenDiagram
import org.eclipse.gmf.codegen.gmfgen.GenExternalNodeLabel
import org.eclipse.gmf.codegen.gmfgen.GenLink
import org.eclipse.gmf.codegen.gmfgen.GenLinkLabel
import org.eclipse.gmf.codegen.gmfgen.GenNode
import org.eclipse.gmf.codegen.gmfgen.GenTopLevelNode
import org.eclipse.gmf.codegen.gmfgen.MetamodelType
import org.eclipse.gmf.codegen.gmfgen.NotationType
import org.eclipse.gmf.codegen.gmfgen.SpecializationType
import org.eclipse.papyrus.papyrusgmfgenextension.GenerateUsingElementTypeCreationCommand
import org.eclipse.papyrus.papyrusgmfgenextension.LabelVisibilityPreference
import xpt.Common
import xpt.Common_qvto
import xpt.diagram.Utils_qvto
import xpt.diagram.ViewmapAttributesUtils_qvto
import xpt.diagram.editpolicies.LinkUtils_qvto
import xpt.diagram.views.ViewStyles
import xpt.editor.VisualIDRegistry

@Singleton class ViewProvider extends xpt.providers.ViewProvider {
	@Inject extension Common;
	@Inject extension Common_qvto;

	@Inject extension Utils_qvto;
	@Inject extension LinkUtils_qvto;
	@Inject extension ViewmapAttributesUtils_qvto;
	@Inject extension VisualIDRegistry;

	@Inject VisualIDRegistry xptVisualIDRegistry;
	@Inject ViewStyles xptViewStyles;

	override ViewProvider(GenDiagram it) '''
		«copyright(editorGen)»
		package «packageName(it)»;
		
		«generatedClassComment»
		public class «className(it)» «extendsList(it)»«implementsList(it)» {
		
			«generatedMemberComment»
			public final boolean provides(org.eclipse.gmf.runtime.common.core.service.IOperation operation) {
				if (operation instanceof org.eclipse.gmf.runtime.diagram.core.services.view.CreateViewForKindOperation) {
					return provides((org.eclipse.gmf.runtime.diagram.core.services.view.CreateViewForKindOperation) operation);
				}
				«_assert('operation instanceof org.eclipse.gmf.runtime.diagram.core.services.view.CreateViewOperation')»
				if (operation instanceof org.eclipse.gmf.runtime.diagram.core.services.view.CreateDiagramViewOperation) {
					return provides((org.eclipse.gmf.runtime.diagram.core.services.view.CreateDiagramViewOperation) operation);
				} else if (operation instanceof org.eclipse.gmf.runtime.diagram.core.services.view.CreateEdgeViewOperation) {
					return provides((org.eclipse.gmf.runtime.diagram.core.services.view.CreateEdgeViewOperation) operation);
				} else if (operation instanceof org.eclipse.gmf.runtime.diagram.core.services.view.CreateNodeViewOperation) {
					return provides((org.eclipse.gmf.runtime.diagram.core.services.view.CreateNodeViewOperation) operation);
				}
				return false;
			}
		
			«generatedMemberComment»
			protected boolean provides(org.eclipse.gmf.runtime.diagram.core.services.view.CreateViewForKindOperation op) {
		/*
				if (op.getViewKind() == Node.class)
					return getNodeViewClass(op.getSemanticAdapter(), op.getContainerView(), op.getSemanticHint()) != null;
				if (op.getViewKind() == Edge.class)
					return getEdgeViewClass(op.getSemanticAdapter(), op.getContainerView(), op.getSemanticHint()) != null;
		*/
		
		      // check Diagram Type should be the class diagram
		         String modelID = «getModelIDMethodCall(it)»(op.getContainerView());
		         if(!getDiagramProvidedId().equals(modelID)) {
		               return false;
		         }
		         
		         int visualID = «getVisualIDMethodCall(it)»(op.getSemanticHint());
		         if(org.eclipse.gmf.runtime.notation.Node.class.isAssignableFrom(op.getViewKind())) {
		               return «canCreateNodeMethodCall(it)»(op.getContainerView(), visualID);
		         }
		
				return true;
			}
		
		«generatedMemberComment»
		     protected String getDiagramProvidedId() {
		     /*
		     * Indicates for which diagram this provider works for.
		     * <p>
		     * This method can be overloaded when diagram editor inherits from another one, but should never be <code>null</code>
		     * </p>
		     * 
		      * @return the unique identifier of the diagram for which views are provided.
		     */
		           return «VisualIDRegistry::modelID(it)»;
		     }
		
			«generatedMemberComment»«/* When diagram domain element is null only diagram kind is checked */»
			protected boolean provides(org.eclipse.gmf.runtime.diagram.core.services.view.CreateDiagramViewOperation op) {
				return «VisualIDRegistry::modelID(it)».equals(op.getSemanticHint())«IF domainDiagramElement != null» && «xptVisualIDRegistry.getDiagramVisualIDMethodCall(it)»(getSemanticElement(op.getSemanticAdapter())) != -1«ENDIF»;
			}
		
			«generatedMemberComment»
			protected boolean provides(org.eclipse.gmf.runtime.diagram.core.services.view.CreateNodeViewOperation op) {
				if (op.getContainerView() == null) {
					return false;
				}
				org.eclipse.gmf.runtime.emf.type.core.IElementType elementType = getSemanticElementType(op.getSemanticAdapter());
				org.eclipse.emf.ecore.EObject domainElement = getSemanticElement(op.getSemanticAdapter());
				int visualID;
				if (op.getSemanticHint() == null) {
					// Semantic hint is not specified. Can be a result of call from CanonicalEditPolicy.
					// In this situation there should be NO elementType, visualID will be determined
					// by VisualIDRegistry.getNodeVisualID() for domainElement.
					if (elementType != null || domainElement == null) {«/* XXX Perhaps, better to fix CanonicalEP instead of this hack? */»
						return false;
					}
					visualID = «xptVisualIDRegistry.getNodeVisualIDMethodCall(it)»(op.getContainerView(), domainElement);
				} else {
					visualID = «xptVisualIDRegistry.getVisualIDMethodCall(it)»(op.getSemanticHint());
					if (elementType != null) {«/*
					Semantic hint is specified together with element type.
					Both parameters should describe exactly the same diagram element.
					In addition we check that visualID returned by VisualIDRegistry.getNodeVisualID() for
					domainElement (if specified) is the same as in element type. */»
				if(elementType instanceof org.eclipse.papyrus.infra.extendedtypes.types.IExtendedHintedElementType) {
					org.eclipse.gmf.runtime.emf.type.core.IElementType closestNonExtendedType = org.eclipse.papyrus.infra.extendedtypes.util.ElementTypeUtils.getClosestDiagramType(elementType);
					if(!«getElementTypesQualifiedClassName()».isKnownElementType(closestNonExtendedType) || (!(closestNonExtendedType instanceof org.eclipse.gmf.runtime.emf.type.core.IHintedType))) {
						return false; // foreign element type.
					}
				} else {
					if (!«getElementTypesQualifiedClassName()».isKnownElementType(elementType) || (!(elementType instanceof org.eclipse.gmf.runtime.emf.type.core.IHintedType))) {
						return false; // foreign element type
					}
				}
				String elementTypeHint = ((org.eclipse.gmf.runtime.emf.type.core.IHintedType) elementType).getSemanticHint();
				if (!op.getSemanticHint().equals(elementTypeHint)) {
					return false; // if semantic hint is specified it should be the same as in element type
				}
				if (domainElement != null && visualID != «getNodeVisualIDMethodCall(it)»(op.getContainerView(), domainElement)) {
					return false; // visual id for node EClass should match visual id from element type
				}
			} else {«/*
					Element type is not specified. Domain element should be present (except pure design elements).
					 This method is called with EObjectAdapter as parameter from:
					   - ViewService.createNode(View container, EObject eObject, String type, PreferencesHint preferencesHint) 
					   - generated ViewFactory.decorateView() for parent element */»
				«IF ! getAllTypedElements(it).filter[e|e.elementType != null].empty»
					if (!«VisualIDRegistry::modelID(it)».equals(«xptVisualIDRegistry.getModelIDMethodCall(it)»(op.getContainerView()))) {
						return false; // foreign diagram
					}
					switch (visualID) {
					«IF getAllNodes().exists[e|e.elementType instanceof NotationType]»
						«FOR e : getAllNodes().map[e|e.elementType].filter(typeof(NotationType))»
							«localCaseVisualID(e)»
						«ENDFOR»
						break; // pure design element
					«ENDIF»
					«IF getAllNodes().exists[e|e.elementType instanceof MetamodelType || e.elementType instanceof SpecializationType]»
						«FOR e : getAllNodes().map[e|e.elementType].filter(typeof(MetamodelType))»
							«localCaseVisualID(e)»
						«ENDFOR»
						«FOR e : getAllNodes().map[e|e.elementType].filter(typeof(SpecializationType))»
							«localCaseVisualID(e)»
						«ENDFOR»
						if (domainElement == null || visualID != «xptVisualIDRegistry.getNodeVisualIDMethodCall(it)»(op.getContainerView(), domainElement)) {
							return false; // visual id in semantic hint should match visual id for domain element
						}
						break;«/*FIXME: Perhaps, can return true or false right away, without any further check?*/»
					«ENDIF»
					default:
						return false;
					}
				«ELSE»
					return false;
				«ENDIF»
				}
				}
				«IF it.eResource.allContents.filter(typeof(GenerateUsingElementTypeCreationCommand)).size>0»
					return «canCreateNodeMethodCall(it)»(op.getContainerView(), visualID);
				«ELSE»
					return «FOR n : getAllNodes() SEPARATOR '||'»«VisualIDRegistry::visualID(n)» == visualID«ENDFOR»;
				«ENDIF»
				
				
			}
		
			«generatedMemberComment»«/* XXX: unlike createNode, we don't check op.containerView() for null here. On purpose? */»
	protected boolean provides(org.eclipse.gmf.runtime.diagram.core.services.view.CreateEdgeViewOperation op) {
		org.eclipse.gmf.runtime.emf.type.core.IElementType elementType = getSemanticElementType(op.getSemanticAdapter());
		//RS: add code for extended types creation
		if(elementType instanceof org.eclipse.papyrus.infra.extendedtypes.types.IExtendedHintedElementType) {
			org.eclipse.gmf.runtime.emf.type.core.IElementType closestNonExtendedType = org.eclipse.papyrus.infra.extendedtypes.util.ElementTypeUtils.getClosestDiagramType(elementType);
			if(!«getElementTypesQualifiedClassName()».isKnownElementType(closestNonExtendedType) || (!(closestNonExtendedType instanceof org.eclipse.gmf.runtime.emf.type.core.IHintedType))) {
				return false; // foreign element type.
			}
		} else {
			if (!«getElementTypesQualifiedClassName()».isKnownElementType(elementType) || (!(elementType instanceof org.eclipse.gmf.runtime.emf.type.core.IHintedType))) {
				return false; // foreign element type
			}
		}
		//if (!«getElementTypesQualifiedClassName()».isKnownElementType(elementType) || (!(elementType instanceof org.eclipse.gmf.runtime.emf.type.core.IHintedType))) {
		//	return false; // foreign element type
		//}
		// END R.S.
		String elementTypeHint = ((org.eclipse.gmf.runtime.emf.type.core.IHintedType) elementType).getSemanticHint();
		if (elementTypeHint == null || (op.getSemanticHint() != null && !elementTypeHint.equals(op.getSemanticHint()))) {
			return false; // our hint is visual id and must be specified, and it should be the same as in element type
		}
		int visualID = «getVisualIDMethodCall(it)»(elementTypeHint);
		org.eclipse.emf.ecore.EObject domainElement = getSemanticElement(op.getSemanticAdapter());
		if (domainElement != null && visualID != «getLinkWithClassVisualIDMethodCall(it)»(domainElement)) {
			return false; // visual id for link EClass should match visual id from element type
		}
		return true; «««Does it make sense to check visualID here, like we did for nodes?
	}

		
			«generatedMemberComment»
			public org.eclipse.gmf.runtime.notation.Diagram createDiagram(org.eclipse.core.runtime.IAdaptable semanticAdapter, String diagramKind, org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint preferencesHint) {
				org.eclipse.gmf.runtime.notation.Diagram diagram = org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createDiagram();«/* FIXME instantiate diagramRunTimeClass instead */»
				diagram.getStyles().add(org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createDiagramStyle());
				«xptViewStyles.addCustomStyles(it, 'diagram.getStyles()')»
				diagram.setType(«VisualIDRegistry::modelID(it)»);
				diagram.setElement(«IF domainDiagramElement != null»getSemanticElement(semanticAdapter)«ELSE»null«ENDIF»);
			«IF units != null»
				diagram.setMeasurementUnit(org.eclipse.gmf.runtime.notation.MeasurementUnit.«units.toUpperCase»_LITERAL);
			«ENDIF»
			«IF ! styles.empty»
				// initializeFromPreferences
				org.eclipse.jface.preferences.IPreferenceStore store = (org.eclipse.jface.preferences.IPreferenceStore) preferencesHint.getPreferenceStore();
				«initializeStyles(it, 'diagram', 'store', false, false, false)»
			«ENDIF»
			return diagram;
			}
		
			«generatedMemberComment»
			public org.eclipse.gmf.runtime.notation.Node createNode(org.eclipse.core.runtime.IAdaptable semanticAdapter, org.eclipse.gmf.runtime.notation.View containerView, String semanticHint, int index, boolean persisted, org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint preferencesHint) {
				final org.eclipse.emf.ecore.EObject domainElement = getSemanticElement(semanticAdapter);
				final int visualID;
				if (semanticHint == null) {
					visualID = «xptVisualIDRegistry.getNodeVisualIDMethodCall(it)»(containerView, domainElement);
				} else {
					visualID = «xptVisualIDRegistry.getVisualIDMethodCall(it)»(semanticHint);
				}
				switch(visualID) {
				«FOR n : getAllNodes()»
					«xptVisualIDRegistry.caseVisualID(n)»
						return create«n.uniqueIdentifier»(domainElement, containerView, index, persisted, preferencesHint);
				«ENDFOR»
				}
				// can't happen, provided #provides(CreateNodeViewOperation) is correct
				return null;
			}
		
			«generatedMemberComment»
			public org.eclipse.gmf.runtime.notation.Edge createEdge(org.eclipse.core.runtime.IAdaptable semanticAdapter, org.eclipse.gmf.runtime.notation.View containerView, String semanticHint, int index, boolean persisted, org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint preferencesHint) {
				org.eclipse.gmf.runtime.emf.type.core.IElementType elementType = getSemanticElementType(semanticAdapter);
				String elementTypeHint = ((org.eclipse.gmf.runtime.emf.type.core.IHintedType) elementType).getSemanticHint();
				switch («xptVisualIDRegistry.getVisualIDMethodCall(it)»(elementTypeHint)) {
				«FOR link : links»
					«xptVisualIDRegistry.caseVisualID(link)»
						return create«link.uniqueIdentifier»(«IF isTypeLink(link)» getSemanticElement(semanticAdapter), «ENDIF»containerView, index, persisted, preferencesHint);
				«ENDFOR»
				}
				// can never happen, provided #provides(CreateEdgeViewOperation) is correct
				return null;
			}
		
			«FOR next : getAllNodes()»
				«createNodeMethod(next)»
			«ENDFOR»
			«FOR next : links»
				«createEdgeMethod(next)»
			«ENDFOR»
		
			«IF ! nodesForTopLevel.empty»
				«generatedMemberComment»
				protected void stampShortcut(org.eclipse.gmf.runtime.notation.View containerView, org.eclipse.gmf.runtime.notation.Node target) {
					if (!«VisualIDRegistry::modelID(it)».equals(«xptVisualIDRegistry.getModelIDMethodCall(it)»(containerView))) {
						«addShortcutAnnotation(it, 'target')»
					}
				}
			«ENDIF»
		
			«IF links.map[l|l.labels].flatten.notEmpty || nodesForTopLevel.map[n|n.labels].flatten.notEmpty || nodesForInnerLevel.map[n|n.labels].flatten.notEmpty»
				«generatedMemberComment»
				protected org.eclipse.gmf.runtime.notation.Node createLabel(org.eclipse.gmf.runtime.notation.View owner, String hint) {
					org.eclipse.gmf.runtime.notation.DecorationNode rv = org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createDecorationNode();
					rv.setType(hint);
					org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.insertChildView(owner, rv, org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.APPEND, true);
					return rv;
				}
			«ENDIF»
		
			«IF getAllNodes().map[n|n.compartments].flatten.notEmpty»
				«generatedMemberComment»
				protected org.eclipse.gmf.runtime.notation.Node createCompartment(org.eclipse.gmf.runtime.notation.View owner, String hint, boolean canCollapse, boolean hasTitle, boolean canSort, boolean canFilter) {
					//SemanticListCompartment rv = NotationFactory.eINSTANCE.createSemanticListCompartment();
					//rv.setShowTitle(showTitle);
					//rv.setCollapsed(isCollapsed);
					org.eclipse.gmf.runtime.notation.Node rv;
					if (canCollapse) {
						rv = org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createBasicCompartment();
					} else {
						rv = org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createDecorationNode();
					}
					
					rv.setLayoutConstraint(org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createBounds());
					
					if (hasTitle) {
						org.eclipse.gmf.runtime.notation.TitleStyle ts = org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createTitleStyle();
						rv.getStyles().add(ts);
					}
					if (canSort) {
						rv.getStyles().add(org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createSortingStyle());
					}
					if (canFilter) {
						rv.getStyles().add(org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createFilteringStyle());
					}
					rv.setType(hint);
					org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.insertChildView(owner, rv, org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.APPEND, true);
					return rv;
				}
			«ENDIF»
		
			«getSemanticElementMethod(it)»
			«getSemanticElementTypeMethod(it)»
			«additions(it)»
		}
	'''
	

	
	override dispatch createNodeMethod(GenNode it) '''
		«generatedMemberComment»
		public org.eclipse.gmf.runtime.notation.Node create«uniqueIdentifier»(org.eclipse.emf.ecore.EObject domainElement, org.eclipse.gmf.runtime.notation.View containerView, int index, boolean persisted, org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint preferencesHint) {
			«IF canUseShapeStyle(viewmap)»
			org.eclipse.gmf.runtime.notation.Shape node = org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createShape();
			«ELSE»
			org.eclipse.gmf.runtime.notation.Node node = org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createNode();
			node.getStyles().add(org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createDescriptionStyle());«/* FIXME Contionally add this style, whether toolsmith needs Notes or not */»
			«xptViewStyles.addFontLineFillStylesConditionally(it.viewmap, 'node.getStyles()')»
			«ENDIF»
			«xptViewStyles.addLinkedDiagramStyle(it, 'node.getStyles()')»
			«xptViewStyles.addCustomStyles(it, 'node.getStyles()')»
			node.setLayoutConstraint(org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createBounds());
			node.setType(«xptVisualIDRegistry.typeMethodCall(it)»);
			org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.insertChildView(containerView, node, index, persisted);
			node.setElement(domainElement);
			«IF it instanceof GenTopLevelNode»
			stampShortcut(containerView, node);
			«ENDIF»
			// initializeFromPreferences «/* XXX Perhaps, do init only once, for complete figure? */»
			final org.eclipse.jface.preference.IPreferenceStore prefStore = (org.eclipse.jface.preference.IPreferenceStore) preferencesHint.getPreferenceStore();
			«initializeStyles(it, 'node', 'prefStore', !isFixedForeground(viewmap), !isFixedBackground(viewmap), !isFixedFont(viewmap))»
			«FOR label : it.labels»
			«initLabel(label, 'node', 'prefStore')»
			«ENDFOR»
			«FOR comp : it.compartments»
			«initCompartment(comp, 'node', 'prefStore')»
			«ENDFOR»
			«««	BEGIN Papyrus Modification
			«IF compartments.size != 0»
				org.eclipse.papyrus.uml.diagram.common.helper.PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(«'node'», «'prefStore'», "«elementType.displayName»");
			«ENDIF»
			«««	END Papyrus Modification
			return node;
		}
	'''
	
		// Location as layoutConstraint, no children
	override dispatch createNodeMethod(GenChildLabelNode it) '''
		«generatedMemberComment»
		public org.eclipse.gmf.runtime.notation.Node create«uniqueIdentifier»(org.eclipse.emf.ecore.EObject domainElement, org.eclipse.gmf.runtime.notation.View containerView, int index, boolean persisted, org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint preferencesHint) {
			org.eclipse.gmf.runtime.notation.Node node = org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createNode();
			node.setLayoutConstraint(org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createLocation());«/* [artem] XXX not sure, why LabelNode needs location */»
			«xptViewStyles.addLinkedDiagramStyle(it, 'node.getStyles()')»
			«xptViewStyles.addCustomStyles(it, 'node.getStyles()')»
			node.setType(«xptVisualIDRegistry.typeMethodCall(it)»);
			org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.insertChildView(containerView, node, index, persisted);
			node.setElement(domainElement);
			
			final org.eclipse.jface.preference.IPreferenceStore prefStore = (org.eclipse.jface.preference.IPreferenceStore) preferencesHint.getPreferenceStore();
			«initFontFromPrefs(it,'node', 'prefStore')»
			«initForegroundFromPrefs(it,'node', 'prefStore')»
			return node;
		}
	'''
	
		override createEdgeMethod(GenLink it) '''
	«generatedMemberComment»
	public org.eclipse.gmf.runtime.notation.Edge create«uniqueIdentifier»(«IF isTypeLink(it)»org.eclipse.emf.ecore.EObject domainElement, «ENDIF»org.eclipse.gmf.runtime.notation.View containerView, int index, boolean persisted, org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint preferencesHint) {
	«IF isFixedForeground(viewmap)»
		org.eclipse.gmf.runtime.notation.Edge edge = org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createEdge();
		edge.getStyles().add(org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createRoutingStyle());
	«ELSE»
		org.eclipse.gmf.runtime.notation.Connector edge = org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createConnector();
	«ENDIF»
	«IF !isFixedFont(viewmap)»
		edge.getStyles().add(org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createFontStyle());
	«ENDIF»
		«xptViewStyles.addCustomStyles(it, 'edge.getStyles()')»
		org.eclipse.gmf.runtime.notation.RelativeBendpoints bendpoints = org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createRelativeBendpoints();
		java.util.ArrayList<org.eclipse.gmf.runtime.notation.datatype.RelativeBendpoint> points = new java.util.ArrayList<org.eclipse.gmf.runtime.notation.datatype.RelativeBendpoint>(2); 
		points.add(new org.eclipse.gmf.runtime.notation.datatype.RelativeBendpoint());
		points.add(new org.eclipse.gmf.runtime.notation.datatype.RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(«xptVisualIDRegistry.typeMethodCall(it)»);
		edge.setElement(«IF isTypeLink(it)»domainElement«ELSE»null«ENDIF»);
		// initializePreferences
		final org.eclipse.jface.preference.IPreferenceStore prefStore = (org.eclipse.jface.preference.IPreferenceStore) preferencesHint.getPreferenceStore();
		«initializeStyles(it, 'edge', 'prefStore', !isFixedForeground(viewmap), false, !isFixedFont(viewmap))»
		//org.eclipse.gmf.runtime.notation.Routing routing = org.eclipse.gmf.runtime.notation.Routing.get(prefStore.getInt(org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_LINE_STYLE));
		//if (routing != null) {
		//	org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(edge, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		//}
		«initRountingFromPrefs(it,'edge', 'prefStore')»
		«FOR label : it.labels»
			«initLabel(label, 'edge', 'prefStore')»
		«ENDFOR»
		«initLabelVisibility(it,'edge', 'prefStore')»
		return edge;
	}
	'''
	
	override getSemanticElementMethod(GenDiagram it) '''
		«generatedMemberComment»
		protected org.eclipse.emf.ecore.EObject getSemanticElement(org.eclipse.core.runtime.IAdaptable semanticAdapter) {
			if (semanticAdapter == null) {
				return null;
			}
			org.eclipse.emf.ecore.EObject eObject = (org.eclipse.emf.ecore.EObject) semanticAdapter.getAdapter(org.eclipse.emf.ecore.EObject.class);
			if (eObject != null) {
				return org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil.resolve(org.eclipse.emf.transaction.util.TransactionUtil.getEditingDomain(eObject), eObject);
			}
			return null;
		}
	'''

	override getSemanticElementTypeMethod(GenDiagram it) '''
	«generatedMemberComment»
	protected org.eclipse.gmf.runtime.emf.type.core.IElementType getSemanticElementType(org.eclipse.core.runtime.IAdaptable semanticAdapter) {
		if (semanticAdapter == null) {
			return null;
		}
		return (org.eclipse.gmf.runtime.emf.type.core.IElementType) semanticAdapter.getAdapter(org.eclipse.gmf.runtime.emf.type.core.IElementType.class);
	}
	'''
	
	 
override additions(GenDiagram it)'''

	«generatedMemberComment»
	private void initFontStyleFromPrefs(org.eclipse.gmf.runtime.notation.View view, final org.eclipse.jface.preference.IPreferenceStore store, String elementName)
	{
		String fontConstant = org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper.getElementConstant(elementName, org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper.FONT);
		String fontColorConstant = org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper.getElementConstant(elementName, org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper.COLOR_FONT);
				
		org.eclipse.gmf.runtime.notation.FontStyle viewFontStyle = (org.eclipse.gmf.runtime.notation.FontStyle) view.getStyle(org.eclipse.gmf.runtime.notation.NotationPackage.Literals.FONT_STYLE);
		if (viewFontStyle != null) 
		{
			org.eclipse.swt.graphics.FontData fontData = org.eclipse.jface.preference.PreferenceConverter.getFontData(store, fontConstant);
			viewFontStyle.setFontName(fontData.getName());
			viewFontStyle.setFontHeight(fontData.getHeight());
			viewFontStyle.setBold((fontData.getStyle() & org.eclipse.swt.SWT.BOLD) != 0);
			viewFontStyle.setItalic((fontData.getStyle() & org.eclipse.swt.SWT.ITALIC) != 0);
			
			org.eclipse.swt.graphics.RGB fontRGB = org.eclipse.jface.preference.PreferenceConverter.getColor(store, fontColorConstant);
				viewFontStyle.setFontColor(org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
	}
	
	«generatedMemberComment»
	private void initForegroundFromPrefs(org.eclipse.gmf.runtime.notation.View view, final org.eclipse.jface.preference.IPreferenceStore store, String elementName)
	{
		String lineColorConstant = org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper.getElementConstant(elementName, org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper.COLOR_LINE);
		org.eclipse.swt.graphics.RGB lineRGB = org.eclipse.jface.preference.PreferenceConverter.getColor(store, lineColorConstant);
		org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(view, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getLineStyle_LineColor(), org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities.RGBToInteger(lineRGB));
	}
	
	«generatedMemberComment»
	private void initBackgroundFromPrefs(org.eclipse.gmf.runtime.notation.View view, final org.eclipse.jface.preference.IPreferenceStore store, String elementName)
	{
		String fillColorConstant = org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper.getElementConstant(elementName, org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper.COLOR_FILL);
		String gradientColorConstant = org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper.getElementConstant(elementName,org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper.COLOR_GRADIENT);
		String gradientPolicyConstant = org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper.getElementConstant(elementName,org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper.GRADIENT_POLICY);
	
	
		org.eclipse.swt.graphics.RGB fillRGB = org.eclipse.jface.preference.PreferenceConverter.getColor(store, fillColorConstant);
		org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(view, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getFillStyle_FillColor(), org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities.RGBToInteger(fillRGB));
		

		org.eclipse.gmf.runtime.notation.FillStyle fillStyle = (org.eclipse.gmf.runtime.notation.FillStyle) view
				.getStyle(org.eclipse.gmf.runtime.notation.NotationPackage.Literals.FILL_STYLE);
		fillStyle
				.setFillColor(org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities.RGBToInteger(fillRGB).intValue());

		;
		if (store.getBoolean(gradientPolicyConstant)) {
			org.eclipse.papyrus.infra.gmfdiag.preferences.utils.GradientPreferenceConverter gradientPreferenceConverter = new org.eclipse.papyrus.infra.gmfdiag.preferences.utils.GradientPreferenceConverter(
					store.getString(gradientColorConstant));
			fillStyle.setGradient(gradientPreferenceConverter.getGradientData());
			fillStyle
					.setTransparency(gradientPreferenceConverter.getTransparency());
		}
	}
	

'''

override initFontFromPrefs(GenCommonBase it,String viewVar, String prefStoreVar)'''
	«specificInitFontFromPrefs(it,viewVar, prefStoreVar)»
'''


def specificInitFontFromPrefs(GenNode it,String viewVar, String prefStoreVar)'''
	«IF !"UNDEFINED".equals(elementType.displayName.toUpperCase())»
		org.eclipse.papyrus.uml.diagram.common.helper.PreferenceInitializerForElementHelper.initFontStyleFromPrefs(«viewVar», «prefStoreVar», "«elementType.displayName»");
	«ENDIF»
'''

def specificInitFontFromPrefs(GenChildNode it,String viewVar, String prefStoreVar) '''
«IF !"UNDEFINED".equals(elementType.displayName.toUpperCase())»
		org.eclipse.papyrus.uml.diagram.common.helper.PreferenceInitializerForElementHelper.initFontStyleFromPrefs(«viewVar», «prefStoreVar», "«elementType.displayName»");
	«ENDIF»
'''

def specificInitFontFromPrefs(GenLink it,String viewVar, String prefStoreVar) '''
	«IF !"UNDEFINED".equals(elementType.displayName.toUpperCase())»
		org.eclipse.papyrus.uml.diagram.common.helper.PreferenceInitializerForElementHelper.initFontStyleFromPrefs(«viewVar», «prefStoreVar», "«elementType.displayName»");
	«ENDIF»
'''

def specificInitFontFromPrefs(GenCommonBase it,String viewVar, String prefStoreVar) '''
«IF !"UNDEFINED".equals(elementType.displayName.toUpperCase())»
		org.eclipse.papyrus.uml.diagram.common.helper.PreferenceInitializerForElementHelper.initFontStyleFromPrefs(«viewVar», «prefStoreVar», "«elementType.displayName»");
	«ENDIF»
'''



override initForegroundFromPrefs(GenCommonBase it,String viewVar, String prefStoreVar) '''
	«specificInitForegroundFromPrefs(it,viewVar, prefStoreVar)»
'''

def specificInitForegroundFromPrefs(GenNode it,String viewVar, String prefStoreVar)'''
	«IF !"UNDEFINED".equals(elementType.displayName.toUpperCase())»
		org.eclipse.papyrus.uml.diagram.common.helper.PreferenceInitializerForElementHelper.initForegroundFromPrefs(«viewVar», «prefStoreVar», "«elementType.displayName»");
	«ENDIF»
'''

def specificInitForegroundFromPrefs(GenChildNode it,String viewVar, String prefStoreVar) '''
	«IF !"UNDEFINED".equals(elementType.displayName.toUpperCase())»
		org.eclipse.papyrus.uml.diagram.common.helper.PreferenceInitializerForElementHelper.initForegroundFromPrefs(«viewVar», «prefStoreVar», "«elementType.displayName»");
	«ENDIF»
'''

def specificInitForegroundFromPrefs(GenLink it,String viewVar, String prefStoreVar) '''
	«IF !"UNDEFINED".equals(elementType.displayName.toUpperCase())»
		org.eclipse.papyrus.uml.diagram.common.helper.PreferenceInitializerForElementHelper.initForegroundFromPrefs(«viewVar», «prefStoreVar», "«elementType.displayName»");
	«ENDIF»
'''

def specificInitForegroundFromPrefs(GenCommonBase it,String viewVar, String prefStoreVar) '''
'''




	
override initBackgroundFromPrefs(GenCommonBase it,String viewVar, String prefStoreVar) '''
 	« specificInitBackgroundFromPrefs(it,viewVar, prefStoreVar) »
'''

def specificInitBackgroundFromPrefs(GenNode it,String viewVar, String prefStoreVar) '''
	«IF !"UNDEFINED".equals(elementType.displayName.toUpperCase())»
	org.eclipse.papyrus.uml.diagram.common.helper.PreferenceInitializerForElementHelper.initBackgroundFromPrefs(«viewVar», «prefStoreVar», "«elementType.displayName»");
	«ENDIF»
'''

def specificInitBackgroundFromPrefs(GenChildNode it,String viewVar, String prefStoreVar) '''
	«IF !"UNDEFINED".equals(elementType.displayName.toUpperCase())»
		org.eclipse.papyrus.uml.diagram.common.helper.PreferenceInitializerForElementHelper.initBackgroundFromPrefs(«viewVar», «prefStoreVar», "«elementType.displayName»");
	«ENDIF»
'''

def specificInitBackgroundFromPrefs(GenLink it, String viewVar, String prefStoreVar) '''
	«IF !"UNDEFINED".equals(elementType.displayName.toUpperCase())»
		org.eclipse.papyrus.uml.diagram.common.helper.PreferenceInitializerForElementHelper.initBackgroundFromPrefs(«viewVar», «prefStoreVar», "«elementType.displayName»");
	«ENDIF»
'''

def specificInitBackgroundFromPrefs(GenCommonBase it,String viewVar, String prefStoreVar) '''
'''


def initRountingFromPrefs(GenCommonBase it,String viewVar, String prefStoreVar) '''
 	« specificInitRountingFromPrefs(it,viewVar, prefStoreVar)»
'''

def specificInitRountingFromPrefs(GenNode it,String viewVar, String prefStoreVar) '''
	«IF !"UNDEFINED".equals(elementType.displayName.toUpperCase())»
	org.eclipse.papyrus.uml.diagram.common.helper.PreferenceInitializerForElementHelper.initRountingFromPrefs(«viewVar», «prefStoreVar», "«elementType.displayName»");
	«ENDIF»
'''

def specificInitRountingFromPrefs(GenChildNode it,String viewVar, String prefStoreVar) '''
	«IF !"UNDEFINED".equals(elementType.displayName.toUpperCase())»
		org.eclipse.papyrus.uml.diagram.common.helper.PreferenceInitializerForElementHelper.initRountingFromPrefs(«viewVar», «prefStoreVar», "«elementType.displayName»");
	«ENDIF»
'''

def specificInitRountingFromPrefs(GenLink it, String viewVar, String prefStoreVar) '''
	«IF !"UNDEFINED".equals(elementType.displayName.toUpperCase())»
		org.eclipse.papyrus.uml.diagram.common.helper.PreferenceInitializerForElementHelper.initRountingFromPrefs(«viewVar», «prefStoreVar», "«elementType.displayName»");
	«ENDIF»
'''

def specificInitRountingFromPrefs(GenCommonBase it,String viewVar, String prefStoreVar) '''
'''

//write the line to initialize the property isVisible for the label of the link
def initLabelVisibility(GenLink it,String viewVar, String prefStoreVar) '''

	«IF it.labels.filter(typeof (GenLinkLabel)).exists[lbl  | 
		(it.eResource.allContents.filter(typeof (LabelVisibilityPreference)).filter[label | label.linkLabels.contains(lbl)]).size !=0]»
	 org.eclipse.papyrus.uml.diagram.common.helper.PreferenceInitializerForElementHelper.initLabelVisibilityFromPrefs(«viewVar», «prefStoreVar», "«elementType.displayName»");
	«ENDIF»
'''

//write the line to initialize the property isVisible for the label of the link
def initLabelVisibility(GenNode it,String viewVar, String prefStoreVar) '''
	«IF it.labels.filter(typeof (GenExternalNodeLabel)).exists[lbl  | 
		(it.eResource.allContents.filter(typeof (LabelVisibilityPreference)).filter[label | label.externalNodeLabels.contains(lbl)]).size !=0]»
	 org.eclipse.papyrus.uml.diagram.common.helper.PreferenceInitializerForElementHelper.initLabelVisibilityFromPrefs(«viewVar», «prefStoreVar», "«elementType.displayName»");
	«ENDIF»
'''

}
