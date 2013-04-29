///*****************************************************************************
// * Copyright (c) 2010 CEA
// *
// *    
// * All rights reserved. This program and the accompanying materials
// * are made available under the terms of the Eclipse Public License v1.0
// * which accompanies this distribution, and is available at
// * http://www.eclipse.org/legal/epl-v10.html
// *
// * Contributors:
// *   Soyatec - Initial API and implementation
// *
// *****************************************************************************/
//package org.eclipse.papyrus.uml.diagram.sequence.edit.parts;
//
//import org.eclipse.draw2d.IFigure;
//import org.eclipse.gef.EditPart;
//import org.eclipse.gef.EditPolicy;
//import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
//import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
//import org.eclipse.gmf.runtime.diagram.ui.figures.BorderedNodeFigure;
//import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
//import org.eclipse.gmf.runtime.notation.View;
//import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.GateCreationEditPolicy;
//import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.GatesHolderGraphicalNodeEditPolicy;
//import org.eclipse.papyrus.uml.diagram.sequence.locator.GateLocator;
//
///**
// * Support Graphical presentation of Gate.
// * https://bugs.eclipse.org/bugs/show_bug.cgi?id=389531
// * 
// * @author Jin Liu (jin.liu@soyatec.com)
// */
//public abstract class GatesHolderEditPart extends InteractionFragmentEditPart {
//
//	/**
//	 * Constructor.
//	 * 
//	 * @param view
//	 */
//	public GatesHolderEditPart(View view) {
//		super(view);
//	}
//
//	@Override
//	protected void createDefaultEditPolicies() {
//		super.createDefaultEditPolicies();
//		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new GatesHolderGraphicalNodeEditPolicy());
//		installEditPolicy("Gate Creation Edit Policy", new GateCreationEditPolicy());
//	}
//
//	public IFigure getFigure() {
//		if(figure == null) {
//			setFigure(createBorderedFigure());
//		}
//		return super.getFigure();
//	}
//
//	protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {
//		if(editPart instanceof IBorderItemEditPart) {
//			return getBorderedFigure().getBorderItemContainer();
//		}
//		return getContentPane();
//	}
//
//	public final BorderedNodeFigure getBorderedFigure() {
//		return (BorderedNodeFigure)getFigure();
//	}
//
//	private IFigure createBorderedFigure() {
//		return new BorderedNodeFigure(createNodeFigure());
//	}
//
//	protected void addChildVisual(EditPart childEditPart, int index) {
//		if(addFixedChild(childEditPart)) {
//			return;
//		}
//		super.addChildVisual(childEditPart, -1);
//	}
//
//	protected void removeChildVisual(EditPart childEditPart) {
//		if(removeFixedChild(childEditPart)) {
//			return;
//		}
//		super.removeChildVisual(childEditPart);
//	}
//
//	protected boolean removeFixedChild(EditPart childEditPart) {
//		if(childEditPart instanceof GateEditPart) {
//			getBorderedFigure().getBorderItemContainer().remove(((GateEditPart)childEditPart).getFigure());
//			return true;
//		}
//		return false;
//	}
//
//	protected boolean addFixedChild(EditPart childEditPart) {
//		if(childEditPart instanceof GateEditPart) {
//			getBorderedFigure().getBorderItemContainer().add(((GateEditPart)childEditPart).getFigure(), new GateLocator(getFigure()));
//			return true;
//		}
//		return false;
//	}
//}
