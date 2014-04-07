/**
 * Copyright (c) 2014 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.uml.diagram.statemachine.custom.commands;

import java.util.Iterator;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.statemachine.custom.helpers.Zone;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.RegionEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.StateCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.StateNameEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.part.UMLVisualIDRegistry;

public class CustomCompositeStateSetBoundsCommand extends AbstractTransactionalCommand {
	CreateViewRequest.ViewDescriptor viewDescriptor;
	Rectangle rect;
	Point location;
	Dimension size;
	boolean isComposite = false;

	public CustomCompositeStateSetBoundsCommand(TransactionalEditingDomain domain, String label, CreateViewRequest.ViewDescriptor viewDescriptor, Rectangle rect, boolean isComposite) {
		super(domain, label, null);
		this.viewDescriptor = viewDescriptor;
		this.rect = rect;
		location = rect.getLocation();
		size = rect.getSize();
		this.isComposite = isComposite;
		// make sure the return object is available even before
		// executing/undoing/redoing
		setResult(CommandResult.newOKCommandResult(viewDescriptor));
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		View stateView = (View) viewDescriptor.getAdapter(View.class);
		if (location != null) {
			Zone.setX(stateView, location.x);
			Zone.setY(stateView, location.y);
		}
		if ((size != null) && !size.equals(-1, -1)) {
			Zone.setWidth(stateView, size.width);
			Zone.setHeight(stateView, size.height);
		} else {
			Zone.setWidth(stateView, Zone.defaultWidth);
			Zone.setHeight(stateView, Zone.defaultHeight);
		}
		if (!isComposite) {
			Iterator<?> it = stateView.getChildren().iterator();
			while (it.hasNext()) {
				Object next = it.next();
				if (next instanceof Node) {
					Node currentNode = (Node) next;
					if (currentNode.getLayoutConstraint() == null) {
						currentNode.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
					}
					if (UMLVisualIDRegistry.getVisualID(currentNode.getType()) == StateNameEditPart.VISUAL_ID) {
						if ((size != null) && !size.equals(-1, -1)) {
							Zone.setWidth(currentNode, size.width);
							Zone.setHeight(currentNode, size.height);
						} else {
							Zone.setWidth(currentNode, 40);
							Zone.setHeight(currentNode, 40);
						}
					} else if (UMLVisualIDRegistry.getVisualID(currentNode.getType()) == StateCompartmentEditPart.VISUAL_ID) {
						Zone.setY(currentNode, 40);
						if ((size != null) && !size.equals(-1, -1)) {
							Zone.setWidth(currentNode, size.width);
							Zone.setHeight(currentNode, 0);
						} else {
							Zone.setWidth(currentNode, 40);
							Zone.setHeight(currentNode, 0);
						}
					}
				}
			}
		} else {
			Iterator<?> it = stateView.getChildren().iterator();
			while (it.hasNext()) {
				Object next = it.next();
				if (next instanceof Node) {
					Node currentNode = (Node) next;
					if (currentNode.getLayoutConstraint() == null) {
						currentNode.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
					}
					if (UMLVisualIDRegistry.getVisualID(currentNode.getType()) == StateNameEditPart.VISUAL_ID) {
						if ((size != null) && !size.equals(-1, -1)) {
							Zone.setWidth(currentNode, size.width);
							Zone.setHeight(currentNode, Zone.defaultHeader);
						} else {
							Zone.setWidth(currentNode, Zone.defaultWidth);
							Zone.setHeight(currentNode, Zone.defaultHeader);
						}
					} else if (UMLVisualIDRegistry.getVisualID(currentNode.getType()) == StateCompartmentEditPart.VISUAL_ID) {
						Zone.setY(currentNode, Zone.defaultHeader);
						if ((size != null) && !size.equals(-1, -1)) {
							Zone.setWidth(currentNode, size.width);
							Zone.setHeight(currentNode, size.height - Zone.defaultHeader);
						} else {
							Zone.setWidth(currentNode, Zone.defaultWidth);
							Zone.setHeight(currentNode, Zone.defaultHeight - Zone.defaultHeader);
						}
						int nRegions = currentNode.getChildren().size();
						String prefix = "";
						String zone = "";
						int i = 0;
						int width = 0;
						Iterator<?> subit = currentNode.getChildren().iterator();
						while (subit.hasNext()) {
							Object subnext = subit.next();
							if (subnext instanceof Node) {
								Node subCurrentNode = (Node) subnext;
								if (subCurrentNode.getLayoutConstraint() == null) {
									subCurrentNode.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
								}
								if (UMLVisualIDRegistry.getVisualID(subCurrentNode.getType()) == RegionEditPart.VISUAL_ID) {
									if ((size != null) && !size.equals(-1, -1)) {
										Zone.setWidth(subCurrentNode, (i == nRegions - 1) ? size.width - width : size.width / nRegions);
										Zone.setHeight(subCurrentNode, size.height - Zone.defaultHeader);
										Zone.setX(subCurrentNode, width);
										width += size.width / nRegions;
									} else {
										Zone.setWidth(subCurrentNode, (i == nRegions - 1) ? Zone.defaultWidth - width : Zone.defaultWidth / nRegions);
										Zone.setHeight(subCurrentNode, Zone.defaultHeight - Zone.defaultHeader);
										Zone.setX(subCurrentNode, width);
										width += Zone.defaultWidth / nRegions;
									}
									zone = (i == nRegions - 1) ? prefix : prefix + Zone.LEFT;
									Zone.setZone(subCurrentNode, zone);
									prefix = prefix + Zone.RIGHT;
									i++;
								}
							}
						}
					}
				}
			}
		}
		return CommandResult.newOKCommandResult();
	}
}
