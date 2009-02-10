/*******************************************************************************
 * Copyright (c) 2007 Conselleria de Infraestructuras y Transporte, Generalitat 
 * de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Gabriel Merin Cubero (Prodevelop) – Sequence Diagram Implementation
 *				 Francisco Javier Cano Muñoz - Expanded functionality
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.sequence.edit.policies;

import java.util.Iterator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.papyrus.diagram.sequence.edit.commands.MessageOrderCommand;
import org.eclipse.papyrus.diagram.sequence.edit.parts.BehaviorExecutionSpecificationEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.uml2.uml.BehaviorExecutionSpecification;

public class LifelineXYLayoutEditPolicy extends XYLayoutEditPolicy {

	private final static int EXECUTION_INIT_WIDTH = 16;

	private final static int EXECUTION_INIT_HEIGHT = 60;

	@Override
	public Command getCommand(Request request) {
		if (request instanceof ChangeBoundsRequest && ((ChangeBoundsRequest) request).getEditParts() != null) {
			ChangeBoundsRequest chr = (ChangeBoundsRequest) request;

			// Compound Command
			CompoundCommand compoundCmd = new CompoundCommand();
			compoundCmd.setLabel("Resize of a Elements");
			compoundCmd.setDebugLabel("Debug: Resize of Elements");

			for (Iterator<EditPart> it = chr.getEditParts().iterator(); it.hasNext();) {
				EditPart ep = it.next();

				if (ep instanceof LifelineEditPart) {

					// Lifeline EditPart
					LifelineEditPart lifelineEditPart = (LifelineEditPart) ep;

					for (Object obj : lifelineEditPart.getChildren()) {
						if (obj instanceof BehaviorExecutionSpecificationEditPart) {
							IAdaptable adapter = (IAdaptable) obj;
							BehaviorExecutionSpecificationEditPart execEditPart = (BehaviorExecutionSpecificationEditPart) obj;
							TransactionalEditingDomain eDomain = execEditPart.getEditingDomain();

							Rectangle rDotLine = lifelineEditPart.getPrimaryShape().getFigureDotLineFigure().getBounds().getCopy();

							Point p = new Point();
							p.x = (rDotLine.width + chr.getSizeDelta().width) / 2 - EXECUTION_INIT_WIDTH / 2;
							p.y = -rDotLine.y + execEditPart.getFigure().getBounds().y;
							p.y = p.y <= 0 ? 1 : p.y; // to avoid non visible
							// positioning

							Dimension d = new Dimension();
							d.height = execEditPart.getFigure().getBounds().height;
							d.width = execEditPart.getFigure().getBounds().width;

							Rectangle bounds = new Rectangle(p, d);

							SetBoundsCommand setBoundsCmd = new SetBoundsCommand(eDomain, "Resize of a Lifeline", adapter, bounds);

							compoundCmd.add(new ICommandProxy(setBoundsCmd));
						}

					}

				} else if (ep instanceof BehaviorExecutionSpecificationEditPart) {
					IAdaptable adapter = ep;
					BehaviorExecutionSpecificationEditPart execEditPart = (BehaviorExecutionSpecificationEditPart) ep;
					TransactionalEditingDomain eDomain = execEditPart.getEditingDomain();

					Rectangle rDotLine = execEditPart.getFigure().getParent().getBounds().getCopy();

					Point p = new Point();
					p.x = rDotLine.width / 2 - EXECUTION_INIT_WIDTH / 2;
					p.y = -rDotLine.y + execEditPart.getFigure().getBounds().y + chr.getMoveDelta().y;
					p.y = p.y <= 0 ? 1 : p.y; // to avoid non visible
					// positioning

					Dimension d = new Dimension();
					d.height = execEditPart.getFigure().getBounds().height + chr.getSizeDelta().height;

					// Check if height is within the limits of the figure
					IFigure execFigure = execEditPart.getFigure();
					if (d.height > execFigure.getMaximumSize().height) {
						d.height = execFigure.getMaximumSize().height;
					} else if (d.height < execFigure.getMinimumSize().height) {
						d.height = execFigure.getMinimumSize().height;
					}

					d.width = execEditPart.getFigure().getBounds().width;

					Rectangle bounds = new Rectangle(p, d);

					SetBoundsCommand setBoundsCmd = new SetBoundsCommand(eDomain, "Resize of a Lifeline", adapter, bounds);

					compoundCmd.add(new ICommandProxy(setBoundsCmd));

					// Ordering should be updated
					BehaviorExecutionSpecification bes = (BehaviorExecutionSpecification) execEditPart.resolveSemanticElement();
					compoundCmd.add(new MessageOrderCommand(execEditPart));
				}
			}
			// return the compoundCmd
			if (compoundCmd.size() == 0)
				return super.getCommand(request);
			else
				return compoundCmd;
		}

		if (request instanceof CreateViewAndElementRequest) {

			CreateViewAndElementRequest cver = (CreateViewAndElementRequest) request;
			LifelineEditPart lifelineEditPart = (LifelineEditPart) getHost();

			TransactionalEditingDomain eDomain = lifelineEditPart.getEditingDomain();
			IAdaptable adapter = cver.getViewAndElementDescriptor();

			Rectangle r = lifelineEditPart.getPrimaryShape().getFigureDotLineFigure().getBounds().getCopy();
			lifelineEditPart.getPrimaryShape().getFigureDotLineFigure().translateToAbsolute(r);
			int yDelta = -r.y + cver.getLocation().y;
			yDelta = yDelta <= 0 ? 1 : yDelta; // to avoid creation of the new
			// figure in a non visible area

			int newHeight;
			if (cver.getSize() != null)
				newHeight = cver.getSize().height;
			else
				newHeight = EXECUTION_INIT_HEIGHT;

			Rectangle bounds = new Rectangle(lifelineEditPart.getPrimaryShape().getFigureDotLineFigure().getBounds().width / 2 - EXECUTION_INIT_WIDTH / 2, yDelta, EXECUTION_INIT_WIDTH, newHeight);

			SetBoundsCommand setBoundsCmd = new SetBoundsCommand(eDomain, "Creation of an ExecutionBehaviourSpecification", adapter, bounds);

			return new ICommandProxy(setBoundsCmd);
		}

		return super.getCommand(request);
	}
}
