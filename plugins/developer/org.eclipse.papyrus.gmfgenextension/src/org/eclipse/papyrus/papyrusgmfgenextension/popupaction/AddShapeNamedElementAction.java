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

import org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.codegen.gmfgen.CustomBehaviour;
import org.eclipse.gmf.codegen.gmfgen.DefaultSizeAttributes;
import org.eclipse.gmf.codegen.gmfgen.FigureViewmap;
import org.eclipse.gmf.codegen.gmfgen.GMFGenFactory;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenLabel;
import org.eclipse.gmf.codegen.gmfgen.GenTopLevelNode;
import org.eclipse.gmf.codegen.gmfgen.MetamodelType;
import org.eclipse.gmf.codegen.gmfgen.TypeModelFacet;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.resource.UML22UMLResource;


// TODO: Auto-generated Javadoc
/**
 * The Class AddShapeNamedElementAction: create an edit part to display an element as the shape that comes from applied stereotypes.
 */
public class AddShapeNamedElementAction extends Action {


	/** The Constant MESSAGE_INTRO. */
	protected static final String MESSAGE_INTRO = Messages.message_Intro;
	
	/** The Constant MESSAGE_INFO_1. */
	protected static final String MESSAGE_INFO_1	=Messages.rulesAboutShapeEditPart;
	
	/** The Constant MESSAGE_INFO_2. */
	protected static final String MESSAGE_INFO_2	=Messages.ruleAboutChangeEditPolicy;
	
	/** The Constant PACKAGED_ELEMENT_ATTRIBUTE. */
	protected static final String PACKAGED_ELEMENT_ATTRIBUTE = "packagedElement"; //$NON-NLS-1$
	
	/** The Constant PACKAGE_NAME. */
	protected static final String PACKAGE_NAME = "Package"; //$NON-NLS-1$
	
	/** The Constant UNKNOW_EDITPOLICY. */
	protected static final String UNKNOW_EDITPOLICY = "YOUR OWN CHANGE SHAPE EDIT POLICY"; //$NON-NLS-1$
	
	/** The Constant QUALIFIED_NAME_DISPLAY_EDIT_POLICY_VALUE. */
	protected static final String QUALIFIED_NAME_DISPLAY_EDIT_POLICY_VALUE = "org.eclipse.papyrus.diagram.common.editpolicies.QualifiedNameDisplayEditPolicy"; //$NON-NLS-1$
	
	/** The Constant NODE_LABEL_DISPLAY_EDIT_POLICY_VALUE. */
	protected static final String NODE_LABEL_DISPLAY_EDIT_POLICY_VALUE = "org.eclipse.papyrus.diagram.common.editpolicies.AppliedStereotypeNodeLabelDisplayEditPolicy"; //$NON-NLS-1$
	
	/** The Constant POPUP_BAR_EDIT_POLICY_VALUE. */
	protected static final String POPUP_BAR_EDIT_POLICY_VALUE = "org.eclipse.papyrus.diagram.common.editpolicies.HyperLinkPopupBarEditPolicy"; //$NON-NLS-1$
	
	/** The Constant CHANGE_SHAPE_POLICY_KEY. */
	protected static final String CHANGE_SHAPE_POLICY_KEY = "org.eclipse.papyrus.diagram.common.editpolicies.ChangeStereotypedShapeEditPolicy.CHANGE_SHAPE_POLICY"; //$NON-NLS-1$
	
	/** The Constant POLICY_QUALIFIED_NAME_POLICY_KEY. */
	protected static final String POLICY_QUALIFIED_NAME_POLICY_KEY = "org.eclipse.papyrus.diagram.common.editpolicies.QualifiedNameDisplayEditPolicy.QUALIFIED_NAME_POLICY"; //$NON-NLS-1$
	
	/** The Constant STEREOTYPE_LABEL_POLICY_KEY. */
	protected static final String STEREOTYPE_LABEL_POLICY_KEY = "org.eclipse.papyrus.diagram.common.editpolicies.AppliedStereotypeLabelDisplayEditPolicy.STEREOTYPE_LABEL_POLICY"; //$NON-NLS-1$
	
	/** The Constant POPUPBAR_ROLE_KEY. */
	protected static final String POPUPBAR_ROLE_KEY = "org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.POPUPBAR_ROLE"; //$NON-NLS-1$
	
	/** The Constant NAME_ATTRIBUTE. */
	protected static final String NAME_ATTRIBUTE = "name"; //$NON-NLS-1$
	
	/** The Constant NAMED_ELEMENT_NAME. */
	protected static final String NAMED_ELEMENT_NAME = "NamedElement"; //$NON-NLS-1$
	
	/** The Constant NODE_NAMED_ELEMENT_FIGURE. */
	protected static final String NODE_NAMED_ELEMENT_FIGURE = "org.eclipse.papyrus.diagram.common.figure.node.ShapeNamedElementFigure"; //$NON-NLS-1$
	
	/** The Constant GMF_NODE. */
	protected static final String GMF_NODE = "Node"; //$NON-NLS-1$
	
	/** The Constant WRAPPING_LABEL. */
	protected static final String WRAPPING_LABEL = "org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel"; //$NON-NLS-1$
	
	/** The Constant DEFAULT_NAMED_ELEMENT_NAME. */
	protected static final String DEFAULT_NAMED_ELEMENT_NAME = "ShapeNamedElementName"; //$NON-NLS-1$
	
	/** The Constant URI_UML_GENMODEL. */
	protected static final String URI_UML_GENMODEL = "org.eclipse.uml2.uml/model/UML.genmodel"; //$NON-NLS-1$
	
	/** The Constant URI_NOTATION_GENMODEL. */
	protected static final String URI_NOTATION_GENMODEL = "org.eclipse.gmf.runtime.notation/model/notation.genmodel"; //$NON-NLS-1$

	/** The Constant DEFAULT_NAMED_ELEMENT. */
	private static final String DEFAULT_NAMED_ELEMENT = "ShapeNamedElement"; //$NON-NLS-1$
	
	/**
	 * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
	 *
	 * @param action
	 */
	
	@Override
	public void run(IAction action) {
		Iterator<EObject> it = getSelectedEObject().iterator();
		while(it.hasNext()) {
			EObject eObject = it.next();
			if(eObject instanceof GenDiagram){
				GenDiagram genDiagram= ((GenDiagram)eObject);
				createTopNode(genDiagram);
			}
		}
	}

	/**
	 * Creates the top node.
	 *
	 * @param genDiagram the gen diagram
	 */
	public void createTopNode(GenDiagram genDiagram){
		URI uri_notation = URI.createPlatformPluginURI(URI_NOTATION_GENMODEL, false);

		Resource notation = genDiagram.eResource().getResourceSet().getResource(uri_notation, true);

		GenTopLevelNode topNode=EditpartGenHelper.createTopNode(genDiagram, DEFAULT_NAMED_ELEMENT,findGenClass(notation, GMF_NODE));
		genDiagram.getTopLevelNodes().add(topNode);
		EditpartGenHelper.createMetaModelType(topNode, DEFAULT_NAMED_ELEMENT);
		addBehavior(topNode);
		addModelFacet(topNode);
		GenLabel label=EditpartGenHelper.createExternalGenNodeLabel(topNode, DEFAULT_NAMED_ELEMENT_NAME, findGenClass(notation, GMF_NODE));
		EditpartGenHelper.createLabelViewMap(label, WRAPPING_LABEL);
		findGenClass(notation, GMF_NODE);
		EditpartGenHelper.createFigureViewMap(topNode, NODE_NAMED_ELEMENT_FIGURE, 100, 50);
		URI uri_uml = URI.createPlatformPluginURI(URI_UML_GENMODEL, false);
		Resource uml = topNode.eResource().getResourceSet().getResource(uri_uml, true);
		EditpartGenHelper.createLabelModelFacet(label,findGenFeature(uml,NAMED_ELEMENT_NAME, NAME_ATTRIBUTE) ,EditpartGenHelper.getFirstPredefinedParse(genDiagram.getEditorGen()));
		MessageDialog.open(MessageDialog.INFORMATION, new Shell(), Messages.generalInformation, MESSAGE_INTRO+MESSAGE_INFO_1+MESSAGE_INFO_2, MessageDialog.NONE); 

	}
	
	/**
	 * Adds the behavior.
	 *
	 * @param topNode the top node
	 */
	public void addBehavior(GenTopLevelNode topNode){
		// add behavior
		EditpartGenHelper.addBehavior(topNode, POPUPBAR_ROLE_KEY, POPUP_BAR_EDIT_POLICY_VALUE);
		EditpartGenHelper.addBehavior(topNode, STEREOTYPE_LABEL_POLICY_KEY,NODE_LABEL_DISPLAY_EDIT_POLICY_VALUE);
		EditpartGenHelper.addBehavior(topNode, POLICY_QUALIFIED_NAME_POLICY_KEY,QUALIFIED_NAME_DISPLAY_EDIT_POLICY_VALUE);
		EditpartGenHelper.addBehavior(topNode, CHANGE_SHAPE_POLICY_KEY,UNKNOW_EDITPOLICY);
	}

	/**
	 * Adds the model facet.
	 *
	 * @param topNode the top node
	 */
	public void addModelFacet(GenTopLevelNode topNode){
		URI uri_uml = URI.createPlatformPluginURI(URI_UML_GENMODEL, false);
		Resource uml = topNode.eResource().getResourceSet().getResource(uri_uml, true);
		EditpartGenHelper.createModelFacet(topNode, findGenFeature(uml,PACKAGE_NAME, PACKAGED_ELEMENT_ATTRIBUTE), findGenClass(uml, NAMED_ELEMENT_NAME));

	}

}

