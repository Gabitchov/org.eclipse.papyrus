/*******************************************************************************
 * Copyright (c) 2009 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are property of the CEA, their use is subject to specific agreement 
 * with the CEA.
 * 
 * Contributors:
 *    CEA LIST - initial API and implementation
 *******************************************************************************/

package org.eclipse.papyrus.papyrusgmfgenextension.popupaction;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.codegen.gmfgen.Behaviour;
import org.eclipse.gmf.codegen.gmfgen.CustomBehaviour;
import org.eclipse.gmf.codegen.gmfgen.CustomParser;
import org.eclipse.gmf.codegen.gmfgen.FeatureLabelModelFacet;
import org.eclipse.gmf.codegen.gmfgen.FigureViewmap;
import org.eclipse.gmf.codegen.gmfgen.GMFGenFactory;
import org.eclipse.gmf.codegen.gmfgen.GenChildNode;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.codegen.gmfgen.GenExpressionInterpreter;
import org.eclipse.gmf.codegen.gmfgen.GenExpressionProviderBase;
import org.eclipse.gmf.codegen.gmfgen.GenExpressionProviderContainer;
import org.eclipse.gmf.codegen.gmfgen.GenFeatureSeqInitializer;
import org.eclipse.gmf.codegen.gmfgen.GenFeatureValueSpec;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.gmf.codegen.gmfgen.GenNodeLabel;
import org.eclipse.gmf.codegen.gmfgen.GenParserImplementation;
import org.eclipse.gmf.codegen.gmfgen.GenParsers;
import org.eclipse.gmf.codegen.gmfgen.GenTopLevelNode;
import org.eclipse.gmf.codegen.gmfgen.OpenDiagramBehaviour;
import org.eclipse.gmf.codegen.gmfgen.ParentAssignedViewmap;
import org.eclipse.gmf.codegen.gmfgen.StyleAttributes;
import org.eclipse.gmf.codegen.gmfgen.TypeModelFacet;
import org.eclipse.gmf.codegen.gmfgen.ValueExpression;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;

/**
 * Implementation class for AddOrUpdateCommentEditParts action
 */
public class AddOrUpdateCommentEditParts extends Action {

	/** output messages for user information */
	protected List<String> messages = new ArrayList<String>();

	/** number of modified elements */
	protected int modifiedElements = 0;

	/** top node comment edit parts */
	protected List<GenTopLevelNode> topNodeComments = new ArrayList<GenTopLevelNode>();

	/** child node comment edit parts */
	protected List<GenChildNode> childNodeComments = new ArrayList<GenChildNode>();

	/** comment parser */
	protected CustomParser commentParser = null;

	final URI uri_UML2 = URI.createPlatformPluginURI("org.eclipse.uml2.uml/model/UML.genmodel", false);

	// final URI uri_GenModel = URI.createPlatformPluginURI("org.eclipse.gmf.runtime.notation/model/notation.genmodel", false);

	final URI uri_notation = URI.createPlatformPluginURI("org.eclipse.gmf.runtime.notation/model/notation.genmodel", false);

	/**
	 * {@inheritDoc}
	 */
	public void run(IAction action) {

		IProgressMonitor monitor = new NullProgressMonitor();
		messages.clear();
		modifiedElements = 0;

		// 1. retrieve existing elements: CommentEditParts (one top node, and one child node) and CommentParser
		// 2. update if existing, or create if necessary
		// selection should be the gen editor generator (root element)
		Iterator<EObject> it = getSelectedEObject().iterator();
		while(it.hasNext()) {
			EObject eObject = it.next();
			if(eObject instanceof GenEditorGenerator) {
				monitor.beginTask("Retrieve existing comments", IProgressMonitor.UNKNOWN);
				retrieveTopNodeCommentEditPart((GenEditorGenerator)eObject, monitor);
				monitor.worked(1);
				retrieveChildNodeCommentEditPart((GenEditorGenerator)eObject, monitor);
				monitor.worked(1);
				retrieveCommentParser((GenEditorGenerator)eObject, monitor);
				monitor.worked(1);
			}

			// elements have been retrieve. create new ones if necessary
			// 1. create the parser if necessary
			if(commentParser == null) {
				commentParser = createCommentParser((GenEditorGenerator)eObject, monitor);
			}

			// 2. create top node
			if(topNodeComments.isEmpty()) {
				createTopNodeComment((GenEditorGenerator)eObject, monitor);
			}

			// 3. create child node
			if(childNodeComments.isEmpty()) {
				createChildNodeComment((GenEditorGenerator)eObject, monitor);
			}

			// check if updates shall be done or the action should be aborted
			if(commentParser == null || topNodeComments.isEmpty() || childNodeComments.isEmpty()) {
				return;
			}

			// do the update
			updateCommentParser();
			updateTopLevelNodes();
			updateChildNodes();


			try {
				eObject.eResource().save(new HashMap());
			} catch (IOException e) {
				e.printStackTrace();
			}

			if(!messages.isEmpty()) {
				MessageDialog.openInformation(Display.getCurrent().getActiveShell(), "Information", messages.toString());
			}
		}
	}

	/**
	 * Update the child nodes
	 */
	protected void updateChildNodes() {
		for(GenChildNode childNode : childNodeComments) {
			// set figure view map
			FigureViewmap figureViewmap = GMFGenFactory.eINSTANCE.createFigureViewmap();
			figureViewmap.setFigureQualifiedClassName("org.eclipse.papyrus.diagram.common.figure.node.HTMLCornerBentFigure");
			childNode.setViewmap(figureViewmap);

			updateBehaviours(childNode);

			updateTypeModelFacet(childNode);

			updateGenNodeLabel(childNode);

			messages.add("update child: " + childNode);
		}

	}

	/**
	 * Removes existing child edit part and creates a new one
	 * 
	 * @param childNode
	 *        the child node currently edited
	 */
	protected void updateGenNodeLabel(GenNode childNode) {
		// save information on existing child nodes and delete them
		int childVisualID = -1;
		String editPartClassName = "";
		String itemSemantic = "";
		if(childNode.getLabels().size() > 0) {
			// assume the first one is the child edit part for the body
			childVisualID = childNode.getLabels().get(0).getVisualID();
			editPartClassName = childNode.getLabels().get(0).getEditPartClassName();
			itemSemantic = childNode.getLabels().get(0).getItemSemanticEditPolicyClassName();

			// clear child nodes (remove the first one, as there should be only one)
			EcoreUtil.delete(childNode.getLabels().get(0).getModelFacet());
			EcoreUtil.delete(childNode.getLabels().get(0));
		}

		// generate values if wrong
		if(childVisualID < 1) {
			childVisualID = SetVisualIDWithUnusedValue.getNewVisualID(childNode.eResource(), childNode.getClass());
		}
		if(editPartClassName == null || editPartClassName == "") {
			String parentEditPartClassName = childNode.getEditPartClassName();
			String number = parentEditPartClassName.substring("Comment".length(), parentEditPartClassName.length() - "EditPart".length());
			editPartClassName = "CommentBody" + ((number == null) ? "" : number) + "EditPart";
			itemSemantic = "CommentBody" + ((number == null) ? "" : number) + "ItemSemanticEditPolicy";
		}


		GenNodeLabel bodyGenNode = GMFGenFactory.eINSTANCE.createGenNodeLabel();
		bodyGenNode.setEditPartClassName(editPartClassName);
		bodyGenNode.setItemSemanticEditPolicyClassName(itemSemantic);

		bodyGenNode.setVisualID(childVisualID);
		GenClass nodeGenClass = findGenClassForNotation(childNode, "Node");

		//		GenModelFactory.eINSTANCE.createGenClass();
		//		nodeGenClass.setEcoreClass(GMFGenPackage.eINSTANCE.getGenNode());
		bodyGenNode.setDiagramRunTimeClass(nodeGenClass);
		bodyGenNode.setElementIcon(false);
		bodyGenNode.setReadOnly(false);

		childNode.getLabels().add(bodyGenNode);

		// generate children for bodygen node
		FeatureLabelModelFacet childModelFacet = GMFGenFactory.eINSTANCE.createFeatureLabelModelFacet();
		childModelFacet.setParser(commentParser);
		GenFeature bodyFeature = findGenAttributeForMetaclass(childNode, "Comment", "body");
		childModelFacet.getMetaFeatures().add(bodyFeature);
		bodyGenNode.setModelFacet(childModelFacet);


		ParentAssignedViewmap viewMap = GMFGenFactory.eINSTANCE.createParentAssignedViewmap();
		viewMap.setGetterName("getCornerBentFigure");
		viewMap.setFigureQualifiedClassName("org.eclipse.papyrus.diagram.common.figure.node.HTMLCornerBentFigure");
		StyleAttributes styleAttribute = GMFGenFactory.eINSTANCE.createStyleAttributes();
		styleAttribute.setFixedBackground(false);
		styleAttribute.setFixedFont(true);
		styleAttribute.setFixedForeground(false);
		viewMap.getAttributes().add(styleAttribute);

		bodyGenNode.setViewmap(viewMap);

	}

	/**
	 * Update Type model facet
	 * 
	 * @param childNode
	 *        the child node currently edited
	 */
	protected void updateTypeModelFacet(GenNode childNode) {
		// set model facet
		/*
		 * <modelFacet>
		 * <metaClass
		 * href="../../../plugin/org.eclipse.uml2.uml/model/UML.genmodel#//uml/Comment"/>
		 * <containmentMetaFeature
		 * href="../../../plugin/org.eclipse.uml2.uml/model/UML.genmodel#//uml/Element/ownedComment"/>
		 * <childMetaFeature
		 * href="../../../plugin/org.eclipse.uml2.uml/model/UML.genmodel#//uml/Element/ownedComment"/>
		 * <modelElementInitializer
		 * xsi:type="gmfgen:GenFeatureSeqInitializer">
		 * <initializers
		 * xsi:type="gmfgen:GenFeatureValueSpec"
		 * value="/0/@expressionProviders/@providers.1/@expressions.0">
		 * <feature
		 * href="../../../plugin/org.eclipse.uml2.uml/model/UML.genmodel#//uml/Comment/body"/>
		 * </initializers>
		 * </modelElementInitializer>
		 * </modelFacet>
		 */
		TypeModelFacet typeModelFacet = GMFGenFactory.eINSTANCE.createTypeModelFacet();
		GenClass commentMetaClass = findGenClassForMetaclass(childNode, "Comment");
		typeModelFacet.setMetaClass(commentMetaClass);

		// containment metafeature
		GenFeature containmentMetaFeature = findGenAttributeForMetaclass(childNode, "Element", "ownedComment");
		typeModelFacet.setContainmentMetaFeature(containmentMetaFeature);

		// child metafeature
		GenFeature childMetaFeature = findGenAttributeForMetaclass(childNode, "Element", "ownedComment");
		typeModelFacet.setChildMetaFeature(childMetaFeature);

		GenFeatureSeqInitializer elementInitializer = GMFGenFactory.eINSTANCE.createGenFeatureSeqInitializer();
		GenFeatureValueSpec featureValueSpec = GMFGenFactory.eINSTANCE.createGenFeatureValueSpec();
		GenFeature bodyFeature = findGenAttributeForMetaclass(childNode, "Comment", "body");
		featureValueSpec.setFeature(bodyFeature);
		// retrieve value expression ('') 
		featureValueSpec.setValue(retrieveValueExpression(childNode));
		elementInitializer.getInitializers().add(featureValueSpec);
		typeModelFacet.setModelElementInitializer(elementInitializer);

	}

	/**
	 * Retrieve value expression ('')
	 * 
	 * @param childNode
	 *        the child node currently edited
	 * @return
	 */
	protected ValueExpression retrieveValueExpression(GenNode childNode) {
		final String expressionBody = "\' \'";
		GenExpressionProviderContainer expressionProviderContainer = childNode.getDiagram().getEditorGen().getExpressionProviders();
		for(GenExpressionProviderBase base : expressionProviderContainer.getProviders()) {
			if(base instanceof GenExpressionInterpreter) {
				for(ValueExpression expression : ((GenExpressionInterpreter)base).getExpressions()) {
					if(expressionBody.equals(expression.getBody())) {
						return expression;
					}
				}

			}
		}

		GenExpressionInterpreter base = null;
		// create a new one if none exists
		for(GenExpressionProviderBase provider : expressionProviderContainer.getProviders()) {
			if(provider instanceof GenExpressionInterpreter) {
				base = (GenExpressionInterpreter)provider;
			}
		}
		if(base == null) {
			base = GMFGenFactory.eINSTANCE.createGenExpressionInterpreter();
			expressionProviderContainer.getProviders().add(base);
		}

		// base should not be null now
		ValueExpression expression = GMFGenFactory.eINSTANCE.createValueExpression();
		expression.setBody(expressionBody);
		base.getExpressions().add(expression);
		return expression;
	}

	/**
	 * Update behaviors for the comment edit part
	 * 
	 * @param childNode
	 *        the node currently edited
	 */
	protected void updateBehaviours(GenNode childNode) {
		boolean createOpenDiagramBehaviour = true;
		boolean createGraphicalNodeRole = false;
		boolean createStereotypeBehaviour = true;


		// retrieve existing behaviours
		List<Behaviour> behaviours = childNode.getBehaviour();
		for(Behaviour behaviour : behaviours) {
			if(behaviour instanceof OpenDiagramBehaviour) {
				createOpenDiagramBehaviour = false;
			} else if(behaviour instanceof CustomBehaviour) {
				// look for the role
				if("org.eclipse.gef.EditPolicy.GRAPHICAL_NODE_ROLE".equals(((CustomBehaviour)behaviour).getKey())) {
					createGraphicalNodeRole = false;
				} else if("org.eclipse.papyrus.diagram.common.editpolicies.AppliedStereotypeLabelDisplayEditPolicy.STEREOTYPE_LABEL_POLICY".equals(((CustomBehaviour)behaviour).getKey())) {
					createStereotypeBehaviour = false;
				}

			}
		}

		if(createOpenDiagramBehaviour) {
			OpenDiagramBehaviour diagramBehaviour = GMFGenFactory.eINSTANCE.createOpenDiagramBehaviour();
			diagramBehaviour.setEditPolicyClassName("OpenDiagramEditPolicy");
			diagramBehaviour.setOpenAsEclipseEditor(true);
			childNode.getBehaviour().add(diagramBehaviour);
		}

		if(createGraphicalNodeRole) {
			// add a custom edit policy if necessary for graphical node role
			CustomBehaviour customBehaviour = GMFGenFactory.eINSTANCE.createCustomBehaviour();
			customBehaviour.setEditPolicyQualifiedClassName("");
			customBehaviour.setKey("org.eclipse.gef.EditPolicy.GRAPHICAL_NODE_ROLE");
			childNode.getBehaviour().add(customBehaviour);
		}

		if(createStereotypeBehaviour) {
			// add a custom edit policy if necessary
			CustomBehaviour stereotypeBehaviour = GMFGenFactory.eINSTANCE.createCustomBehaviour();
			stereotypeBehaviour.setEditPolicyQualifiedClassName("org.eclipse.papyrus.diagram.common.editpolicies.AppliedStereotypeNodeLabelDisplayEditPolicy");
			stereotypeBehaviour.setKey("org.eclipse.papyrus.diagram.common.editpolicies.AppliedStereotypeLabelDisplayEditPolicy.STEREOTYPE_LABEL_POLICY");
			childNode.getBehaviour().add(stereotypeBehaviour);
		}

	}

	/**
	 * Update the top nodes
	 */
	protected void updateTopLevelNodes() {
		for(GenTopLevelNode node : topNodeComments) {
			// set figure view map
			FigureViewmap figureViewmap = GMFGenFactory.eINSTANCE.createFigureViewmap();
			figureViewmap.setFigureQualifiedClassName("org.eclipse.papyrus.diagram.common.figure.node.HTMLCornerBentFigure");
			node.setViewmap(figureViewmap);

			updateBehaviours(node);

			updateTypeModelFacet(node);

			updateGenNodeLabel(node);

			messages.add("update top: " + node);
		}
	}

	/**
	 * update the comment parser
	 */
	protected void updateCommentParser() {
		if(!"org.eclipse.papyrus.diagram.common.parser.CommentParser".equals(commentParser.getQualifiedName())) {
			commentParser.setQualifiedName("org.eclipse.papyrus.diagram.common.parser.CommentParser");
		}

		if(commentParser.isGenerateBoilerplate()) {
			commentParser.setGenerateBoilerplate(false);
		}

	}

	/**
	 * Creates and returns the comment custom parser
	 * 
	 * @param editorGenerator
	 *        the root node of the gmfgen
	 * @param monitor
	 *        the progress monitor
	 * @return the comment custom parser
	 */
	protected CustomParser createCommentParser(GenEditorGenerator editorGenerator, IProgressMonitor monitor) {
		GenParsers parsers = editorGenerator.getLabelParsers();
		if(parsers == null) {
			MessageDialog.openError(Display.getCurrent().getActiveShell(), "Impossible to find the parsers associated to this editor", "No parser container was found for this editor. \n\nYou should create the parsers container before running this action");
		}
		CustomParser parser = GMFGenFactory.eINSTANCE.createCustomParser();
		parsers.getImplementations().add(parser);
		return parser;
	}

	/**
	 * Creates and returns the comment custom parser
	 * 
	 * @param editorGenerator
	 *        the root node of the gmfgen
	 * @param monitor
	 *        the progress monitor
	 * @return the comment custom parser
	 */
	protected void createTopNodeComment(GenEditorGenerator editorGenerator, IProgressMonitor monitor) {
		GenDiagram diagram = editorGenerator.getDiagram();
		if(diagram == null) {
			return;
		}

		GenTopLevelNode topNode = GMFGenFactory.eINSTANCE.createGenTopLevelNode();
		diagram.getTopLevelNodes().add(topNode);
		topNodeComments.add(topNode);
	}

	/**
	 * Creates and returns the child node comment
	 * 
	 * @param editorGenerator
	 *        the root node of the gmfgen
	 * @param monitor
	 *        the progress monitor
	 */
	protected void createChildNodeComment(GenEditorGenerator editorGenerator, IProgressMonitor monitor) {
		GenDiagram diagram = editorGenerator.getDiagram();
		if(diagram == null) {
			return;
		}

		GenChildNode childNode = GMFGenFactory.eINSTANCE.createGenChildNode();
		diagram.getChildNodes().add(childNode);
		childNodeComments.add(childNode);
	}

	/**
	 * Retrieves the top node comment edit parts
	 * 
	 * @param editorGenerator
	 *        the root node of the gmfgen
	 * @param monitor
	 *        the progress monitor
	 */
	protected void retrieveTopNodeCommentEditPart(GenEditorGenerator editorGenerator, IProgressMonitor monitor) {
		GenDiagram diagram = editorGenerator.getDiagram();
		if(diagram == null) {
			MessageDialog.openError(Display.getCurrent().getActiveShell(), "Impossible to find the diagram associated to this editor", "No diagram was found for this editor. \n\nYou should create one diagram before running this action");
		}

		GenClass commentGenClass = findGenClassForMetaclass(editorGenerator, "Comment");
		for(GenTopLevelNode topLevelNode : diagram.getTopLevelNodes()) {
			TypeModelFacet modelFacet = topLevelNode.getModelFacet();
			if(modelFacet != null && modelFacet.getMetaClass() != null) {
				if(commentGenClass.equals(modelFacet.getMetaClass())) {
					topNodeComments.add(topLevelNode);
				}
			}
		}
	}

	/**
	 * Retrieves the child node comment edit parts
	 * 
	 * @param editorGenerator
	 *        the root node of the gmfgen
	 * @param monitor
	 *        the progress monitor
	 */
	protected void retrieveChildNodeCommentEditPart(GenEditorGenerator editorGenerator, IProgressMonitor monitor) {
		GenDiagram diagram = editorGenerator.getDiagram();
		if(diagram == null) {
			MessageDialog.openError(Display.getCurrent().getActiveShell(), "Impossible to find the diagram associated to this editor", "No diagram was found for this editor. \n\nYou should create one diagram before running this action");
		}
		GenClass commentGenClass = findGenClassForMetaclass(editorGenerator, "Comment");
		for(GenChildNode childNode : diagram.getChildNodes()) {
			TypeModelFacet modelFacet = childNode.getModelFacet();
			if(modelFacet != null && modelFacet.getMetaClass() != null) {
				if(commentGenClass.equals(modelFacet.getMetaClass())) {
					childNodeComments.add(childNode);
				}
			}
		}
	}

	/**
	 * Retrieves the child node comment edit parts
	 * 
	 * @param editorGenerator
	 *        the root node of the gmfgen
	 * @param monitor
	 *        the progress monitor
	 */
	protected void retrieveCommentParser(GenEditorGenerator editorGenerator, IProgressMonitor monitor) {
		GenParsers parsers = editorGenerator.getLabelParsers();
		if(parsers == null) {
			MessageDialog.openError(Display.getCurrent().getActiveShell(), "Impossible to find the parsers associated to this editor", "No parser container was found for this editor. \n\nYou should create the parsers container before running this action");
		}
		for(GenParserImplementation parserImplementation : parsers.getImplementations()) {
			if(parserImplementation instanceof CustomParser) {
				if("org.eclipse.papyrus.diagram.common.parser.CommentParser".equals(((CustomParser)parserImplementation).getQualifiedName())) {
					commentParser = ((CustomParser)parserImplementation);
				}
			}
		}
	}


	/**
	 * 
	 */
	protected GenClass findGenClassForMetaclass(EObject eObject, String name) {
		Resource notation = eObject.eResource().getResourceSet().getResource(uri_UML2, true);
		return findGenClass(notation, name);
	}

	/**
	 * 
	 */
	protected GenClass findGenClassForNotation(EObject eObject, String name) {
		Resource notation = eObject.eResource().getResourceSet().getResource(uri_notation, true);
		return findGenClass(notation, name);
	}

	/**
	 * 
	 */
	protected GenFeature findGenAttributeForMetaclass(EObject eObject, String genClassName, String genFeatureName) {
		Resource notation = eObject.eResource().getResourceSet().getResource(uri_UML2, true);
		return findGenFeature(notation, genClassName, genFeatureName);
	}
}
