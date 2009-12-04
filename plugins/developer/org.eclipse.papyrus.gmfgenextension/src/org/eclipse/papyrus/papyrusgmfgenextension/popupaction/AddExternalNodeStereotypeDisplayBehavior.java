/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
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
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.codegen.gmfgen.Behaviour;
import org.eclipse.gmf.codegen.gmfgen.CustomBehaviour;
import org.eclipse.gmf.codegen.gmfgen.FeatureLabelModelFacet;
import org.eclipse.gmf.codegen.gmfgen.FigureViewmap;
import org.eclipse.gmf.codegen.gmfgen.GMFGenFactory;
import org.eclipse.gmf.codegen.gmfgen.GenExternalNodeLabel;
import org.eclipse.gmf.codegen.gmfgen.GenLink;
import org.eclipse.gmf.codegen.gmfgen.GenLinkLabel;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.gmf.codegen.gmfgen.GenNodeLabel;
import org.eclipse.gmf.codegen.gmfgen.LabelOffsetAttributes;
import org.eclipse.gmf.codegen.gmfgen.LinkLabelAlignment;
import org.eclipse.gmf.codegen.gmfgen.ParentAssignedViewmap;
import org.eclipse.jface.action.IAction;
import org.eclipse.ui.IViewPart;

/**
 * this class is used to add a label to display applied stereotypes for external node
 */
public class AddExternalNodeStereotypeDisplayBehavior extends Action {

	public static final String FIGURE_VIEWMAP_PATH = "org.eclipse.papyrus.diagram.common.figure.node.AppliedStereotypeWrappingLabelFigure"; //$NON-NLS-1$

	public static final String STEREOTYPE_LABEL_POLICY_KEY = "org.eclipse.papyrus.diagram.common.editpolicies.AppliedStereotypeLabelDisplayEditPolicy.STEREOTYPE_LABEL_POLICY"; //$NON-NLS-1$

	public static final String STEREOTYPE_LABEL_POLICY_CLASS = "org.eclipse.papyrus.diagram.common.editpolicies.AppliedStereotypeExternalNodeEditPolicy"; //$NON-NLS-1$

	public static final String DEFAULT_GETTER_NAME = "getAppliedStereotypeLabel"; //$NON-NLS-1$

	public static final String DEFAULT_EDITPART_NAME_SUFFIX = "AppliedStereotypeEditPart"; //$NON-NLS-1$

	public static final String DEFAULT_EDITPOLICY_NAME_SUFFIX = "AppliedStereotypeItemSemanticEditPolicy"; //$NON-NLS-1$

	public static final String DEFAULT_WRAPPING_LABEL_CLASS = "org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel"; //$NON-NLS-1$

	public static final int DEFAULT_OFFSET_X = 0;

	public static final int DEFAULT_OFFSET_Y = 60;

	public static final String DEFAULT_PARSER_PATTERN = "<<{0}>>"; //$NON-NLS-1$

	public static final String APPLIED_STEREOTYPE_CUSTOM_PARSER_CLASS = "org.eclipse.papyrus.diagram.common.parser.stereotype.AppliedStereotypeParser"; //$NON-NLS-1$

	public static final String GEN_CLASS_RT_CLASS = "Node"; //$NON-NLS-1$

	public static final String GEN_CLASS_FACET_META_FEATURE = "NamedElement"; //$NON-NLS-1$

	public static final String GEN_FEATURE_FACET_META_FEATURE = "name"; //$NON-NLS-1$

	public static final String URI_NOTATION_GENMODEL = "org.eclipse.gmf.runtime.notation/model/notation.genmodel"; //$NON-NLS-1$

	public static final String URI_UML_GENMODEL = "org.eclipse.uml2.uml/model/UML.genmodel"; //$NON-NLS-1$

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IViewActionDelegate#init(org.eclipse.ui.IViewPart)
	 */
	public void init(IViewPart view) {
		// NO OP
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
	 */
	public void run(IAction action) {

		// Parse selected GenLink(s) and add the desired CustomBehavior
		Iterator<EObject> it = getSelectedEObject().iterator();
		while(it.hasNext()) {
			EObject eObject = it.next();
			if(eObject instanceof GenNode) {
				//test if it has got a external node to display applied stereotype
				if(!hasAnAppliedStereotypExternalNode((GenNode)eObject)) {
					createAnAppliedStereotypExternalNode((GenNode)eObject);
				}
			}
		}
	}


	/**
	 * creation an external node stereotype
	 * 
	 * @param eObject
	 *        the parent genNode
	 */
	private void createAnAppliedStereotypExternalNode(GenNode eObject) {
		GenExternalNodeLabel label = GMFGenFactory.eINSTANCE.createGenExternalNodeLabel();
		label.setEditPartClassName(eObject.getClassNamePrefix() + DEFAULT_EDITPART_NAME_SUFFIX);
		label.setItemSemanticEditPolicyClassName(eObject.getClassNamePrefix() + DEFAULT_EDITPOLICY_NAME_SUFFIX);
		label.setReadOnly(true);

		// Set GenLinkLabel VisualID with new unique ID
		int visualID = SetVisualIDWithUnusedValue.getNewVisualID(eObject.eResource(), GenLinkLabel.class);
		label.setVisualID(visualID);

		// Retrieve DiagramRunTimeClass in notation.genmodel (Node -> View)
		URI uri_notation = URI.createPlatformPluginURI(URI_NOTATION_GENMODEL, false);
		Resource notation = eObject.eResource().getResourceSet().getResource(uri_notation, true);
		label.setDiagramRunTimeClass(findGenClass(notation, GEN_CLASS_RT_CLASS));

		// Create Viewmap
		FigureViewmap viewmap = GMFGenFactory.eINSTANCE.createFigureViewmap();
		viewmap.setFigureQualifiedClassName(FIGURE_VIEWMAP_PATH);


		// Create FeatureLabelModelFacet
		FeatureLabelModelFacet facet = GMFGenFactory.eINSTANCE.createFeatureLabelModelFacet();
		facet.setEditPattern(DEFAULT_PARSER_PATTERN);
		facet.setEditorPattern(DEFAULT_PARSER_PATTERN);
		facet.setViewPattern(DEFAULT_PARSER_PATTERN);
		// Select NamedElement::name property in UML.genmodel for MetaFeatures
		URI uri_uml = URI.createPlatformPluginURI(URI_UML_GENMODEL, false);
		Resource uml = eObject.eResource().getResourceSet().getResource(uri_uml, true);
		facet.getMetaFeatures().add(findGenFeature(uml, GEN_CLASS_FACET_META_FEATURE, GEN_FEATURE_FACET_META_FEATURE));

		// Attach created element one to another in the model
		label.setViewmap(viewmap);
		label.setModelFacet(facet);

		addCustomBehavior(label, STEREOTYPE_LABEL_POLICY_KEY, STEREOTYPE_LABEL_POLICY_CLASS);
		eObject.getLabels().add(label);


	}


	public boolean hasAnAppliedStereotypExternalNode(GenNode node) {
		Iterator<GenNodeLabel> iterator = node.getLabels().iterator();
		while(iterator.hasNext()) {
			GenNodeLabel currentGenNodeLabel = iterator.next();
			if(currentGenNodeLabel instanceof GenExternalNodeLabel) {
				if(isAnAppliedStereotypExternalNode((GenExternalNodeLabel)currentGenNodeLabel)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean isAnAppliedStereotypExternalNode(GenExternalNodeLabel node) {
		return hasCustomBehavior(node, STEREOTYPE_LABEL_POLICY_KEY);
	}



}
