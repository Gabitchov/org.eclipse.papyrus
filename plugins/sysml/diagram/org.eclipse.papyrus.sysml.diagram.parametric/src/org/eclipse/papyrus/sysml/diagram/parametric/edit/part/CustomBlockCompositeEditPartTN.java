/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		Régis CHEVREL: chevrel.regis <at> gmail.com
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.parametric.edit.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.figures.IBorderItemLocator;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.sysml.blocks.Block;
import org.eclipse.papyrus.sysml.constraints.ConstraintBlock;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.BlockLabelNameEditPart;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.StructureCompartmentEditPart;
import org.eclipse.papyrus.sysml.diagram.parametric.figures.ParametricDiagramFrameFigure;
import org.eclipse.papyrus.uml.diagram.common.edit.part.AbstractElementEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.ConstraintParameterAffixedNodeEditPart;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AffixedNodeAlignmentEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.ShowHideRelatedContentsEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.locator.FullInsidePortPositionLocator;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.util.UMLUtil;


public class CustomBlockCompositeEditPartTN extends AbstractElementEditPart {

	public CustomBlockCompositeEditPartTN(View view) {
		super(view);
	}

	@Override
	protected void createDefaultEditPolicies() {
		installEditPolicy(ShowHideRelatedContentsEditPolicy.SHOW_HIDE_RELATED_CONTENTS_POLICY, new ShowHideRelatedContentsEditPolicy());
		installEditPolicy(AffixedNodeAlignmentEditPolicy.AFFIXED_CHILD_ALIGNMENT_ROLE, new AffixedNodeAlignmentEditPolicy());
		super.createDefaultEditPolicies();
	}
	@Override
	protected IFigure createNodeShape() {
		return this.primaryShape = new ParametricDiagramFrameFigure();
	}
	
	@Override
	public ParametricDiagramFrameFigure getPrimaryShape() {
		return (ParametricDiagramFrameFigure)primaryShape;
	}
	
	@Override
	protected boolean addFixedChild(EditPart childEditPart) {
		if(childEditPart instanceof BlockLabelNameEditPart) {
			((BlockLabelNameEditPart)childEditPart).setLabel(getPrimaryShape().getNameLabel());
			return true;
		}
		if(childEditPart instanceof StructureCompartmentEditPart) {
			IFigure pane = getPrimaryShape();
			setupContentPane(pane);
			pane.add(((StructureCompartmentEditPart)childEditPart).getFigure());
			return true;
		}
		if(childEditPart instanceof ConstraintParameterAffixedNodeEditPart) {
			IBorderItemLocator locator = new FullInsidePortPositionLocator(getMainFigure(), PositionConstants.NONE);
			getBorderedFigure().getBorderItemContainer().add(((ConstraintParameterAffixedNodeEditPart)childEditPart).getFigure(), locator);
			return true;
		}
		return false;
	}

	@Override
	protected boolean removeFixedChild(EditPart childEditPart) {
		if(childEditPart instanceof BlockLabelNameEditPart) {
			return true;
		}
		if(childEditPart instanceof StructureCompartmentEditPart) {
			IFigure pane = getPrimaryShape();
			setupContentPane(pane);
			pane.remove(((StructureCompartmentEditPart)childEditPart).getFigure());
			return true;
		}
		if(childEditPart instanceof ConstraintParameterAffixedNodeEditPart) {
			getBorderedFigure().getBorderItemContainer().remove(((ConstraintParameterAffixedNodeEditPart)childEditPart).getFigure());
			return true;
		}
		return false;
	}

	@Override
	protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {
		return getContentPane();
	}

	@Override
	public EditPart getPrimaryChildEditPart() {
		return null;
	}

	@Override
	protected LayoutEditPolicy createLayoutEditPolicy() {
		return null;
	}

	
	@Override
	protected void refreshVisuals() {
		refreshStereotypes();
		super.refreshVisuals();
	}

	protected void refreshStereotypes() {
		Element resolveSemanticElement = (Element)this.resolveSemanticElement();
		EList<EObject> stereotypeApplications = resolveSemanticElement.getStereotypeApplications();
		List<EObject> additionnalStereotypeApplications = new ArrayList<EObject>();
		for (EObject currentStereotypeApplication : stereotypeApplications) {
			if (!(currentStereotypeApplication instanceof Block) && !(currentStereotypeApplication instanceof ConstraintBlock)) {
				additionnalStereotypeApplications.add(currentStereotypeApplication);
			}
		}
		StringBuilder stereotypeLabel = new StringBuilder();
		String separator = ", ";
		for (EObject eObject : additionnalStereotypeApplications) {
			if (eObject != additionnalStereotypeApplications.get(0)) {
				stereotypeLabel.append(separator);
			}
			stereotypeLabel.append(firstLetterToLowerCase(UMLUtil.getStereotype(eObject).getName()));
		}
		getPrimaryShape().setStereotypeLabel(stereotypeLabel.toString());
	}
	
	private String firstLetterToLowerCase(String string) {
		String result = "";
		if (string != null && string.length() != 0) {
			String lowerCaseFirstLetter = string.substring(0, 1).toLowerCase();
			result = lowerCaseFirstLetter + string.substring(1);
		}
		return result;
	}
}
