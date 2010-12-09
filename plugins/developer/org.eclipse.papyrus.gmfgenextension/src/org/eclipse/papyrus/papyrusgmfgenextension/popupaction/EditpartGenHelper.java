/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.papyrusgmfgenextension.popupaction;

import java.util.Iterator;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.gmf.codegen.gmfgen.CustomBehaviour;
import org.eclipse.gmf.codegen.gmfgen.DefaultSizeAttributes;
import org.eclipse.gmf.codegen.gmfgen.FeatureLabelModelFacet;
import org.eclipse.gmf.codegen.gmfgen.FigureViewmap;
import org.eclipse.gmf.codegen.gmfgen.GMFGenFactory;
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.codegen.gmfgen.GenLabel;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.gmf.codegen.gmfgen.GenNodeLabel;
import org.eclipse.gmf.codegen.gmfgen.GenParserImplementation;
import org.eclipse.gmf.codegen.gmfgen.GenTopLevelNode;
import org.eclipse.gmf.codegen.gmfgen.MetamodelType;
import org.eclipse.gmf.codegen.gmfgen.ParentAssignedViewmap;
import org.eclipse.gmf.codegen.gmfgen.PredefinedParser;
import org.eclipse.gmf.codegen.gmfgen.StyleAttributes;
import org.eclipse.gmf.codegen.gmfgen.TypeModelFacet;



/**
 * The Class EditpartGenHelper tha contains a lot of useful method to create gennodes etc..
 */
public class EditpartGenHelper {

	/** The Constant EDIT_HELPER. */
	public static final String EDIT_HELPER = "EditHelper";

	/** The Constant CANONICAL_EDIT_POLICY. */
	protected static final String CANONICAL_EDIT_POLICY = "CanonicalEditPolicy"; //$NON-NLS-1$

	/** The Constant EDIT_PART. */
	private static final String EDIT_PART = "EditPart"; //$NON-NLS-1$

	/**
	 * Adds the behavior.
	 * 
	 * @param base
	 *        the base where we want to add a behvior
	 * @param key
	 *        the key
	 * @param value
	 *        the value
	 */
	public static void addBehavior(GenCommonBase base, String key, String value) {
		CustomBehaviour behaviour = GMFGenFactory.eINSTANCE.createCustomBehaviour();
		behaviour.setKey(key);
		behaviour.setEditPolicyQualifiedClassName(value);
		base.getBehaviour().add(behaviour);
	}

	/**
	 * Creates the top node.
	 * 
	 * @param genDiagram
	 *        the gen diagram
	 * @param name
	 *        the name
	 * @param visualClass
	 *        the visual class node etc..
	 * @return the gen top level node
	 */
	public static GenTopLevelNode createTopNode(GenDiagram genDiagram, String name, GenClass visualClass) {
		GenTopLevelNode topNode = GMFGenFactory.eINSTANCE.createGenTopLevelNode();
		topNode.setEditPartClassName(name + EDIT_PART);
		topNode.setCanonicalEditPolicyClassName(name + CANONICAL_EDIT_POLICY);
		topNode.setCreateCommandClassName(name + "CreateCommand"); //$NON-NLS-1$
		topNode.setGraphicalNodeEditPolicyClassName(name + "GraphicalNodeEditPolicy"); //$NON-NLS-1$
		topNode.setItemSemanticEditPolicyClassName(name + "ItemSemanticEditPolicy"); //$NON-NLS-1$
		topNode.setDiagramRunTimeClass(visualClass);
		genDiagram.getTopLevelNodes().add(topNode);
		topNode.setVisualID(SetVisualIDWithUnusedValue.getNewVisualID(topNode.eResource(), topNode.getClass()));


		return topNode;

	}

	/**
	 * Creates the gen node label.
	 * 
	 * @param genNode
	 *        the gen node
	 * @param name
	 *        the name
	 * @param visualClass
	 *        the visual class node etc...
	 * @return the gen node label
	 */
	public static GenNodeLabel createGenNodeLabel(GenNode genNode, String name, GenClass visualClass) {
		GenNodeLabel nodeLabel = GMFGenFactory.eINSTANCE.createGenNodeLabel();
		nodeLabel.setEditPartClassName(name + EDIT_PART);
		nodeLabel.setItemSemanticEditPolicyClassName(name + "ItemSemanticEditPolicy"); //$NON-NLS-1$
		nodeLabel.setDiagramRunTimeClass(visualClass);
		genNode.getLabels().add(nodeLabel);
		nodeLabel.setVisualID(SetVisualIDWithUnusedValue.getNewVisualID(genNode.eResource(), GenCommonBase.class));

		return nodeLabel;

	}

	/**
	 * Creates the external gen node label.
	 * 
	 * @param genNode
	 *        the gen node
	 * @param name
	 *        the name
	 * @param visualClass
	 *        the visual class node etc ...
	 * @return the gen node label
	 */
	public static GenNodeLabel createExternalGenNodeLabel(GenNode genNode, String name, GenClass visualClass) {
		GenNodeLabel nodeLabel = GMFGenFactory.eINSTANCE.createGenExternalNodeLabel();
		nodeLabel.setEditPartClassName(name + EDIT_PART);
		nodeLabel.setItemSemanticEditPolicyClassName(name + "ItemSemanticEditPolicy"); //$NON-NLS-1$
		nodeLabel.setDiagramRunTimeClass(visualClass);
		genNode.getLabels().add(nodeLabel);
		nodeLabel.setVisualID(SetVisualIDWithUnusedValue.getNewVisualID(genNode.eResource(), GenCommonBase.class));

		return nodeLabel;

	}

	/**
	 * Creates the meta model type.
	 * 
	 * @param base
	 *        the base that will contains the metamodel type
	 * @param name
	 *        the name of the edit class helper
	 */
	public static void createMetaModelType(GenCommonBase base, String name) {
		MetamodelType metamodelType = GMFGenFactory.eINSTANCE.createMetamodelType();
		metamodelType.setDefinedExternally(false);
		metamodelType.setDisplayName(name);
		metamodelType.setEditHelperClassName(name + EDIT_HELPER); //$NON-NLS-1$
		metamodelType.setDiagramElement(base);
	}


	/**
	 * Creates the label view map.
	 * 
	 * @param base
	 *        the base that will contains the labelview map
	 * @param qualifiedNameFigure
	 *        the qualified name figure
	 */
	public static void createLabelViewMap(GenCommonBase base, String qualifiedNameFigure) {
		ParentAssignedViewmap figureViewmap = GMFGenFactory.eINSTANCE.createParentAssignedViewmap();
		figureViewmap.setFigureQualifiedClassName(qualifiedNameFigure);
		figureViewmap.setGetterName("getNameLabel");
		StyleAttributes styleAttributes = GMFGenFactory.eINSTANCE.createStyleAttributes();
		styleAttributes.setFixedBackground(false);
		styleAttributes.setFixedFont(true);
		styleAttributes.setFixedForeground(false);

		figureViewmap.getAttributes().add(styleAttributes);
		base.setViewmap(figureViewmap);
	}

	/**
	 * Creates the figure view map.
	 * 
	 * @param base
	 *        the base that will contains the labelview map
	 * @param qualifiedNameFigure
	 *        the qualified name figure
	 * @param width
	 *        the width of the default figure
	 * @param height
	 *        the height of the default figure
	 */
	public static void createFigureViewMap(GenCommonBase base, String qualifiedNameFigure, int width, int height) {
		FigureViewmap figureViewmap = GMFGenFactory.eINSTANCE.createFigureViewmap();
		figureViewmap.setFigureQualifiedClassName(qualifiedNameFigure);
		DefaultSizeAttributes defaultSizeAttributes = GMFGenFactory.eINSTANCE.createDefaultSizeAttributes();
		defaultSizeAttributes.setWidth(width);
		defaultSizeAttributes.setHeight(height);
		figureViewmap.getAttributes().add(defaultSizeAttributes);
		base.setViewmap(figureViewmap);
	}

	/**
	 * Creates the model facet.
	 * 
	 * @param base
	 *        the base that will contains the model facet
	 * @param genFeature
	 *        the gen feature
	 * @param genclass
	 *        the genclass
	 */
	public static void createModelFacet(GenNode base, GenFeature genFeature, GenClass genclass) {
		TypeModelFacet facet = GMFGenFactory.eINSTANCE.createTypeModelFacet();
		facet.setMetaClass(genclass);
		facet.setContainmentMetaFeature(genFeature);
		base.setModelFacet(facet);

	}

	/**
	 * Creates the label model facet.
	 * 
	 * @param label
	 *        the label that will contains the label model facet
	 * @param genFeature
	 *        the gen feature
	 * @param value
	 *        the value
	 */
	public static void createLabelModelFacet(GenLabel label, GenFeature genFeature, GenParserImplementation value) {
		FeatureLabelModelFacet facet = GMFGenFactory.eINSTANCE.createFeatureLabelModelFacet();
		facet.getMetaFeatures().add(genFeature);
		facet.setParser(value);
		label.setModelFacet(facet);

	}

	/**
	 * Gets the first predefined parse.
	 * 
	 * @param editorView
	 *        the editor view
	 * @return the first predefined parse
	 */
	public static PredefinedParser getFirstPredefinedParse(GenEditorGenerator editorView) {
		Iterator<GenParserImplementation> iter = editorView.getLabelParsers().getImplementations().iterator();
		while(iter.hasNext()) {
			GenParserImplementation base = iter.next();
			if(base instanceof PredefinedParser) {
				return (PredefinedParser)base;
			}

		}
		return null;
	}
}
