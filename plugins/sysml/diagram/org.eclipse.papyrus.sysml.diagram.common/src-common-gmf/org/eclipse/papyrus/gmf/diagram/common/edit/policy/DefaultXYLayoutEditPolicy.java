/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.gmf.diagram.common.edit.policy;

import java.util.Iterator;

import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.SnapToHelper;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramRootEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.figures.LayoutHelper;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.XYLayoutWithConstrainedResizedEditPolicy;

/**
 * Avoid forcing (-1, -1) dimension in set bounds command (let the view factories deal with
 * size initialization if needed).
 */
public class DefaultXYLayoutEditPolicy extends XYLayoutWithConstrainedResizedEditPolicy {

	/**
	 * Called in response to a <tt>REQ_CREATE</tt> request. Returns a command
	 * to set each created element bounds and auto-size properties.
	 * 
	 * @param request
	 *        a create request (understands instances of {@link CreateViewRequest}).
	 * @return a command to satisfy the request; <tt>null</tt> if the request is not
	 *         understood.
	 */
	protected Command getCreateCommand(CreateRequest request) {
		CreateViewRequest req = (CreateViewRequest)request;


		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart)getHost()).getEditingDomain();

		CompositeTransactionalCommand cc = new CompositeTransactionalCommand(editingDomain, DiagramUIMessages.AddCommand_Label);
		Iterator<?> iter = req.getViewDescriptors().iterator();
		final Rectangle BOUNDS = (Rectangle)getConstraintFor(request);
		boolean couldBeSnaped = request.getLocation().equals(LayoutHelper.UNDEFINED.getLocation()) && req.isSnapToEnabled();
		while(iter.hasNext()) {
			CreateViewRequest.ViewDescriptor viewDescriptor = (CreateViewRequest.ViewDescriptor)iter.next();
			Rectangle rect = getBoundsOffest(req, BOUNDS, viewDescriptor);

			//see bug 427129: Figures newly created via the palette should be snapped to grid if "snap to grid" is activated
			if(couldBeSnaped) {
				//this code fix the bug in some case...
				int add = 0;
				DiagramRootEditPart drep = (DiagramRootEditPart)getHost().getRoot();
				double spacing = drep.getGridSpacing();
				final double max_value = spacing * 20;
				final SnapToHelper helper = (SnapToHelper)getHost().getAdapter(SnapToHelper.class);
				if(helper != null) {
					final LayoutHelper layoutHelper = new LayoutHelper();
					while(add < max_value) {//we define a max value to do test
						Rectangle LOCAL_BOUNDS = BOUNDS.getCopy();
						LOCAL_BOUNDS.translate(add, add);
						Rectangle tmp_rect = getBoundsOffest(req, LOCAL_BOUNDS, viewDescriptor);
						final PrecisionRectangle resultRect = new PrecisionRectangle(tmp_rect);
						resultRect.setWidth(-1);
						resultRect.setHeight(-1);
						PrecisionPoint res1 = new PrecisionPoint(tmp_rect.getLocation());
						helper.snapPoint(request, PositionConstants.NORTH_WEST, res1.getPreciseCopy(), res1);
						final Point pt = layoutHelper.validatePosition(getHostFigure(), resultRect.setLocation(res1));
						if(couldBeSnaped) {
							if(pt.equals(resultRect.getLocation())) {
								rect.setLocation(resultRect.getLocation());
								break;
							} else {
								add += spacing;
								continue;
							}
						}
					}
				}
			}
			if(rect.getSize().isEmpty()) {
				// Only set location and let the ViewFactory deal with dimension.
				cc.compose(new SetBoundsCommand(editingDomain, DiagramUIMessages.SetLocationCommand_Label_Resize, viewDescriptor, rect.getLocation().getCopy()));

			} else {
				// Default set bounds command.
				cc.compose(new SetBoundsCommand(editingDomain, DiagramUIMessages.SetLocationCommand_Label_Resize, viewDescriptor, rect));
			}
			break;

		}

		if(cc.reduce() == null) {
			return null;
		}
		return chainGuideAttachmentCommands(request, new ICommandProxy(cc.reduce()));
	}
}
