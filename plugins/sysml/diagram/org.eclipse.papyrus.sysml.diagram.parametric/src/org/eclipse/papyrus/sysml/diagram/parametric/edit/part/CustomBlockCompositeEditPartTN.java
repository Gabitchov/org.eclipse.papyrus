package org.eclipse.papyrus.sysml.diagram.parametric.edit.part;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.figures.IBorderItemLocator;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.BlockLabelNameEditPart;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.StructureCompartmentEditPart;
import org.eclipse.papyrus.sysml.diagram.common.figure.SysMLDiagramFrameFigure;
import org.eclipse.papyrus.sysml.diagram.parametric.figures.ParametricDiagramFrameFigure;
import org.eclipse.papyrus.uml.diagram.common.edit.part.AbstractElementEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.ConstraintParameterAffixedNodeEditPart;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AffixedNodeAlignmentEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.ShowHideRelatedContentsEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.figure.node.NodeNamedElementFigure;
import org.eclipse.papyrus.uml.diagram.common.locator.FullInsidePortPositionLocator;


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
	public NodeNamedElementFigure getPrimaryShape() {
		return (NodeNamedElementFigure)primaryShape;
	}
	
	@Override
	protected boolean addFixedChild(EditPart childEditPart) {
		if(childEditPart instanceof BlockLabelNameEditPart) {
			((BlockLabelNameEditPart)childEditPart).setLabel(getPrimaryShape().getNameLabel());
			return true;
		}
		if(childEditPart instanceof StructureCompartmentEditPart) {
			IFigure pane = ((SysMLDiagramFrameFigure)getPrimaryShape()).getStructureCompartmentFigure();
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
			IFigure pane = ((SysMLDiagramFrameFigure)getPrimaryShape()).getStructureCompartmentFigure();
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
		if(editPart instanceof StructureCompartmentEditPart) {
			return ((SysMLDiagramFrameFigure)getPrimaryShape()).getStructureCompartmentFigure();
		}
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
}
