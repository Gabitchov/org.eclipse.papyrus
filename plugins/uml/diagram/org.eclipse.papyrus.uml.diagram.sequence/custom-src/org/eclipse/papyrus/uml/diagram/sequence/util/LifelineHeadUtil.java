/*****************************************************************************
 * Copyright (c) 2013 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Soyatec - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.gef.ui.figures.SlidableAnchor;
import org.eclipse.gmf.runtime.notation.Anchor;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.IdentityAnchor;
import org.eclipse.gmf.runtime.notation.LayoutConstraint;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.Size;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.util.DiagramEditPartsUtil;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CombinedFragmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CustomLifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.GateEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionUseEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Message6EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Message7EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.figures.LifelineFigure;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.CombinedFragment;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.InteractionUse;
import org.eclipse.uml2.uml.Lifeline;


/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class LifelineHeadUtil {

	public static int computeLifelineVerticalPosition(final EditPart parent) {
		if(parent instanceof GraphicalEditPart) {
			List children = parent.getChildren();
			int bottom = -1;
			for(Object object : children) {
				if(!(object instanceof LifelineEditPart)) {
					continue;
				}
				LifelineEditPart lifeline = (LifelineEditPart)object;
				LifelineFigure primaryShape = lifeline.getPrimaryShape();
				RectangleFigure figure = primaryShape.getFigureLifelineNameContainerFigure();
				Rectangle r = figure.getBounds().getCopy();
				if(!r.isEmpty()) {
					bottom = Math.max(bottom, r.bottom());
				}
			}
			if(bottom != -1) {
				RectangleFigure figure = new RectangleFigure();
				figure.setBorder(new MarginBorder(7));
				ToolbarLayout layout = new ToolbarLayout();
				layout.setMinorAlignment(ToolbarLayout.ALIGN_CENTER);
				Label label = new Label("Lifeline");
				label.setFont(Display.getDefault().getSystemFont());
				figure.add(label);
				figure.setLayoutManager(layout);
				int height = figure.getPreferredSize().height;
				return bottom - height - 1;
			}
		}
		return SequenceUtil.LIFELINE_VERTICAL_OFFSET;
	}

	public static void updateHead(LifelineEditPart lifeline, int resized) {
		if(lifeline == null || resized == 0) {
			return;
		}
		List<LifelineEditPart> toMovedLifelines = new ArrayList<LifelineEditPart>();
		collectLifelines(toMovedLifelines, lifeline);
		List<ShapeNodeEditPart> children = LifelineEditPartUtil.getChildShapeNodeEditPart(lifeline);
		for(ShapeNodeEditPart child : children) {
			collectLifelines(toMovedLifelines, child);
		}
		EditPart parent = lifeline.getParent();
		while(parent instanceof LifelineEditPart) {
			parent = parent.getParent();
		}
		List childrenList = parent.getChildren();
		for(Object object : childrenList) {
			if(toMovedLifelines.contains(object) || !(object instanceof LifelineEditPart)) {
				continue;
			}
			toMovedLifelines.add((LifelineEditPart)object);
		}
		if(toMovedLifelines.isEmpty()) {
			return;
		}
		CompoundCommand command = new CompoundCommand();
		computeUpdateHeadCommand(command, lifeline, false, resized, new ArrayList<EditPart>());
		if(command.canExecute()) {
			CommandHelper.executeCommandWithoutHistory(lifeline.getEditingDomain(), command, true);
		}
	}

	private static void computeUpdateHeadCommand(CompoundCommand commands, LifelineEditPart lifeline, boolean moveChildren, int moveDelta, List<EditPart> movedEditParts) {
		//1. move children of current lifeline.
		if(moveChildren) {
			ShapeNodeEditPart nodeToMove = lifeline;
			EditPart parent = lifeline.getParent();
			while(parent instanceof LifelineEditPart) {
				nodeToMove = (ShapeNodeEditPart)parent;
				parent = parent.getParent();
			}
			Command cmd = getVerticalMoveShapeCommand(nodeToMove, moveDelta, false);
			commands.appendIfCanExecute(cmd);
		} else {
			View view = lifeline.getNotationView();
			LayoutConstraint constraint = ((Shape)view).getLayoutConstraint();
			if(constraint instanceof Size) {
				int height = ((Size)constraint).getHeight();
				if(height == -1) {
					height = lifeline.getFigure().getBounds().height;
				}
				height += moveDelta;
				commands.appendIfCanExecute(SetCommand.create(lifeline.getEditingDomain(), constraint, NotationPackage.eINSTANCE.getSize_Height(), height));
			}
		}
		movedEditParts.add(lifeline);

		//2. move covered CombinedFragment and InteractionUse
		EObject elt = lifeline.resolveSemanticElement();
		if(elt instanceof Lifeline) {
			EList<InteractionFragment> coveredBys = ((Lifeline)elt).getCoveredBys();
			EditPartViewer viewer = lifeline.getViewer();
			for(InteractionFragment fragment : coveredBys) {
				if(!(fragment instanceof CombinedFragment || fragment instanceof InteractionUse)) {
					continue;
				}
				List<View> views = DiagramEditPartsUtil.findViews(fragment, viewer);
				if(views.isEmpty()) {
					continue;
				}
				for(View view : views) {
					EditPart ep = (EditPart)viewer.getEditPartRegistry().get(view);
					if(ep == null) {
						continue;
					}
					if(movedEditParts.contains(ep)) {
						continue;
					}
					EditPart parent = ep.getParent();
					boolean parentMoved = false;
					while(parent != null) {
						if(movedEditParts.contains(parent)) {
							parentMoved = true;
							break;
						}
						parent = parent.getParent();
					}
					if(parentMoved) {
						continue;
					}
					if(ep instanceof CombinedFragmentEditPart || ep instanceof InteractionUseEditPart) {
						Command cmd = getVerticalMoveShapeCommand((ShapeNodeEditPart)ep, moveDelta, false);
						commands.appendIfCanExecute(cmd);
						movedEditParts.add(ep);
						List children = ep.getChildren();
						for(Object object : children) {
							if(movedEditParts.contains(object)) {
								continue;
							}
							if(object instanceof GateEditPart) {
								GateEditPart gate = (GateEditPart)object;
								Command command = getVerticalMoveShapeCommand(gate, moveDelta, false);
								commands.appendIfCanExecute(command);
								movedEditParts.add(gate);
								fillMoveDownMessageEnds(commands, gate, moveDelta, movedEditParts);
							}
						}
					}
				}
			}
		}

		//3. move Gate if existed.
		fillMoveDownMessageEnds(commands, lifeline, moveDelta, movedEditParts);
		List<ShapeNodeEditPart> childShapeNodeEditParts = LifelineEditPartUtil.getChildShapeNodeEditPart(lifeline);
		for(ShapeNodeEditPart shapeNodeEditPart : childShapeNodeEditParts) {
			fillMoveDownMessageEnds(commands, shapeNodeEditPart, moveDelta, movedEditParts);
		}

		//4. move children of linked lifelines.
		List<LifelineEditPart> toMovedLifelines = new ArrayList<LifelineEditPart>();
		collectLifelines(toMovedLifelines, lifeline);
		List<ShapeNodeEditPart> children = LifelineEditPartUtil.getChildShapeNodeEditPart(lifeline);
		for(ShapeNodeEditPart child : children) {
			collectLifelines(toMovedLifelines, child);
		}
		EditPart parent = lifeline.getParent();
		while(parent instanceof LifelineEditPart) {
			parent = parent.getParent();
		}
		List childrenList = parent.getChildren();
		for(Object object : childrenList) {
			if(toMovedLifelines.contains(object) || !(object instanceof LifelineEditPart)) {
				continue;
			}
			toMovedLifelines.add((LifelineEditPart)object);
		}
		for(LifelineEditPart editPart : toMovedLifelines) {
			if(movedEditParts.contains(editPart)) {
				continue;
			}
			computeUpdateHeadCommand(commands, editPart, true, moveDelta, movedEditParts);
		}
	}

	private static void fillMoveDownMessageEnds(CompoundCommand commands, GraphicalEditPart editPart, int moveDelta, List<EditPart> movedEditParts) {
		List sourceConnections = editPart.getSourceConnections();
		for(Object object : sourceConnections) {
			ConnectionEditPart conn = (ConnectionEditPart)object;
			EditPart target = conn.getTarget();
			if(target instanceof GateEditPart) {
				Command command = getVerticalMoveShapeCommand((GateEditPart)target, moveDelta, false);
				commands.appendIfCanExecute(command);
				movedEditParts.add(target);
			} else if(object instanceof Message6EditPart) {
				Command command = getMoveAnchorCommand(conn, moveDelta, false);
				commands.appendIfCanExecute(command);
			}
		}
		List targetConnections = editPart.getTargetConnections();
		for(Object object : targetConnections) {
			ConnectionEditPart conn = (ConnectionEditPart)object;
			if(conn instanceof Message7EditPart) {
				Command command = getMoveAnchorCommand(conn, moveDelta, true);
				commands.appendIfCanExecute(command);
			} else if(conn.getSource() instanceof GateEditPart) {
				Command command = getVerticalMoveShapeCommand((GateEditPart)conn.getSource(), moveDelta, false);
				commands.appendIfCanExecute(command);
				movedEditParts.add(conn.getSource());
			}
		}
	}

	private static Command getMoveAnchorCommand(ConnectionEditPart conn, int moveDelta, boolean moveSource) {
		EditPart editPart = moveSource ? conn.getSource() : conn.getTarget();
		if(!(editPart instanceof IGraphicalEditPart)) {
			return null;
		}
		Object model = conn.getModel();
		if(!(model instanceof Edge)) {
			return null;
		}
		Edge edge = (Edge)model;
		Anchor anchor = moveSource ? edge.getSourceAnchor() : edge.getTargetAnchor();
		if(!(anchor instanceof IdentityAnchor)) {
			return null;
		}
		String terminal = ((IdentityAnchor)anchor).getId();
		PrecisionPoint pt = SlidableAnchor.parseTerminalString(terminal);
		PrecisionPoint p = null;
		if(pt.preciseX() > 1 || pt.preciseY() > 1) {
			p = new PrecisionPoint(pt.preciseX(), pt.preciseY() + moveDelta);
		} else {
			Rectangle bounds = SequenceUtil.getAbsoluteBounds((IGraphicalEditPart)editPart);
			PrecisionPoint location = new PrecisionPoint(pt.preciseX() * bounds.preciseWidth() + bounds.preciseX(), pt.preciseY() * bounds.preciseHeight() + bounds.preciseY());
			location.translate(0, moveDelta);
			Dimension d = location.getDifference(bounds.getTopLeft());
			p = new PrecisionPoint(d.preciseWidth() / bounds.width, d.preciseHeight() / bounds.height);
		}
		StringBuffer s = new StringBuffer(24);
		s.append('('); // 1 char
		s.append(p.preciseX()); // 10 chars
		s.append(','); // 1 char
		s.append(p.preciseY()); // 10 chars
		s.append(')');
		return SetCommand.create(getEditingDomain((GraphicalEditPart)editPart), anchor, NotationPackage.eINSTANCE.getIdentityAnchor_Id(), s.toString());
	}

	private static void collectLifelines(List<LifelineEditPart> toMovedLifelines, GraphicalEditPart editPart) {
		if(editPart == null) {
			return;
		}
		//1. links from current lifeline
		List sourceConnections = editPart.getSourceConnections();
		for(Object object : sourceConnections) {
			ConnectionEditPart conn = (ConnectionEditPart)object;
			LifelineEditPart target = getLifeline(conn.getTarget());
			if(target == null || toMovedLifelines.contains(target) || editPart == target) {
				continue;
			}
			toMovedLifelines.add(target);
		}

		//2. links to current lifeline.
		List targetConnections = editPart.getTargetConnections();
		for(Object object : targetConnections) {
			ConnectionEditPart conn = (ConnectionEditPart)object;
			LifelineEditPart source = getLifeline(conn.getSource());
			if(source == null || toMovedLifelines.contains(source) || editPart == source) {
				continue;
			}
			toMovedLifelines.add(source);
		}

		if(editPart instanceof CustomLifelineEditPart && ((CustomLifelineEditPart)editPart).isInlineMode()) {
			List children = ((CustomLifelineEditPart)editPart).getChildren();
			for(Object object : children) {
				if(object instanceof LifelineEditPart) {
					collectLifelines(toMovedLifelines, (LifelineEditPart)object);
				}
			}
			if(toMovedLifelines.isEmpty()) {
				toMovedLifelines.add((LifelineEditPart)editPart);
			}
		}
	}

	private static Command getVerticalMoveShapeCommand(GraphicalEditPart shapeEditPart, int moveDelta, boolean increaseHeight) {
		if(shapeEditPart == null || moveDelta == 0) {
			return null;
		}
		Object view = shapeEditPart.getModel();
		if(!(view instanceof Shape)) {
			return null;
		}
		LayoutConstraint constraint = ((Shape)view).getLayoutConstraint();
		if(!(constraint instanceof Location)) {
			return null;
		}
		int y = ((Location)constraint).getY();
		int value = y + moveDelta;
		Command command = SetCommand.create(getEditingDomain(shapeEditPart), constraint, NotationPackage.eINSTANCE.getLocation_Y(), value);
		if(increaseHeight && constraint instanceof Size) {
			int height = ((Size)constraint).getHeight();
			if(height == -1) {
				height = shapeEditPart.getFigure().getBounds().height;
			}
			height += moveDelta;
			command = command.chain(SetCommand.create(getEditingDomain(shapeEditPart), constraint, NotationPackage.eINSTANCE.getSize_Height(), height));
		}
		return command;
	}

	private static EditingDomain getEditingDomain(GraphicalEditPart editPart) {
		if(editPart instanceof IGraphicalEditPart) {
			return ((IGraphicalEditPart)editPart).getEditingDomain();
		}
		return null;
	}

	private static LifelineEditPart getLifeline(EditPart editPart) {
		if(editPart == null) {
			return null;
		}
		if(editPart instanceof LifelineEditPart) {
			return (LifelineEditPart)editPart;
		}
		return getLifeline(editPart.getParent());
	}
}
