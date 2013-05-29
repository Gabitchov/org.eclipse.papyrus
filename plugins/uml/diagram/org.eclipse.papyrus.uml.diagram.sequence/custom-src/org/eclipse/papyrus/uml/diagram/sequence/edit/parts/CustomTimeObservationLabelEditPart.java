/*****************************************************************************
 * Copyright (c) 2010 CEA
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
package org.eclipse.papyrus.uml.diagram.sequence.edit.parts;

import java.util.List;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.requests.DropRequest;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.common.core.util.Log;
import org.eclipse.gmf.runtime.common.core.util.Trace;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.INodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.internal.DiagramUIDebugOptions;
import org.eclipse.gmf.runtime.diagram.ui.internal.DiagramUIPlugin;
import org.eclipse.gmf.runtime.diagram.ui.internal.DiagramUIStatusCodes;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.Anchor;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.IdentityAnchor;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.CustomConnectionHandleEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.util.ElementIconUtil;
import org.eclipse.swt.graphics.Image;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class CustomTimeObservationLabelEditPart extends TimeObservationLabelEditPart implements INodeEditPart {

	/**
	 * Constructor.
	 * 
	 * @param view
	 */
	public CustomTimeObservationLabelEditPart(View view) {
		super(view);
	}

	/**
	 * @Override
	 */
	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.CONNECTION_HANDLES_ROLE, new CustomConnectionHandleEditPolicy());
	}

	/**
	 * @Override
	 */
	@Override
	protected String getLabelTextHelper(IFigure figure) {
		if(figure instanceof NodeFigure && getWrappingLabel(figure) != null) {
			return getWrappingLabel(figure).getText();
		}
		return super.getLabelTextHelper(figure);
	}

	/**
	 * @Override
	 */
	@Override
	protected void setLabelTextHelper(IFigure figure, String text) {
		if(figure instanceof NodeFigure && getWrappingLabel(figure) != null) {
			getWrappingLabel(figure).setText(text);
		} else {
			super.setLabelTextHelper(figure, text);
		}
	}

	/**
	 * @Override
	 */
	@Override
	protected Image getLabelIconHelper(IFigure figure) {
		if(figure instanceof NodeFigure && getWrappingLabel(figure) != null) {
			return getWrappingLabel(figure).getIcon();
		} else {
			return super.getLabelIconHelper(figure);
		}
	}

	/**
	 * @Override
	 */
	@Override
	protected void setLabelIconHelper(IFigure figure, Image icon) {
		if(figure instanceof NodeFigure && getWrappingLabel(figure) != null) {
			getWrappingLabel(figure).setIcon(icon);
		} else {
			super.setLabelIconHelper(figure, icon);
		}
	}

	/**
	 * @Override
	 */
	@Override
	protected void handleNotificationEvent(Notification event) {
		Object feature = event.getFeature();
		if(NotationPackage.eINSTANCE.getView_SourceEdges().equals(feature)) {
			refreshSourceConnections();
		} else if(NotationPackage.eINSTANCE.getView_TargetEdges().equals(feature)) {
			refreshTargetConnections();
		}
		if(ElementIconUtil.isIconNotification(event)) {
			refreshLabel();
		}
		super.handleNotificationEvent(event);
	}

	@Override
	protected NodeFigure createFigure() {
		NodeFigure figure = createNodePlate();
		figure.setLayoutManager(new StackLayout());
		IFigure shape = createNodeShape();
		figure.add(shape);
		return figure;
	}

	protected NodeFigure createNodePlate() {
		NodeFigure result = new NodeFigure();
		return result;
	}

	protected IFigure createNodeShape() {
		IFigure label = createFigurePrim();
		return label;
	}

	protected WrappingLabel getWrappingLabel(IFigure nodeFigure) {
		if(nodeFigure instanceof NodeFigure) {
			return ((WrappingLabel)(nodeFigure.getChildren().get(0)));
		}
		return null;
	}

	//Fix https://bugs.eclipse.org/bugs/show_bug.cgi?id=364826
	@Override
	protected List getModelSourceConnections() {
		return ViewUtil.getSourceConnectionsConnectingVisibleViews((View)getModel());
	}

	@Override
	protected List getModelTargetConnections() {
		List list = ViewUtil.getTargetConnectionsConnectingVisibleViews((View)getModel());
		return list;
	}

	public ConnectionAnchor getSourceConnectionAnchor(Request request) {
		if(request instanceof ReconnectRequest) {
			if(((DropRequest)request).getLocation() == null) {
				return ((NodeFigure)getFigure()).getSourceConnectionAnchorAt(null);
			}
			Point pt = ((DropRequest)request).getLocation().getCopy();
			return ((NodeFigure)getFigure()).getSourceConnectionAnchorAt(pt);
		} else if(request instanceof DropRequest) {
			return ((NodeFigure)getFigure()).getSourceConnectionAnchorAt(((DropRequest)request).getLocation());
		}
		return ((NodeFigure)getFigure()).getSourceConnectionAnchorAt(null);
	}

	public ConnectionAnchor getSourceConnectionAnchor(ConnectionEditPart connEditPart) {
		final org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart connection = (org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart)connEditPart;
		String t = ""; //$NON-NLS-1$
		try {
			t = (String)getEditingDomain().runExclusive(new RunnableWithResult.Impl() {

				public void run() {
					Anchor a = ((Edge)connection.getModel()).getSourceAnchor();
					if(a instanceof IdentityAnchor) {
						setResult(((IdentityAnchor)a).getId());
					} else {
						setResult(""); //$NON-NLS-1$
					}
				}
			});
		} catch (InterruptedException e) {
			Trace.catching(DiagramUIPlugin.getInstance(), DiagramUIDebugOptions.EXCEPTIONS_CATCHING, getClass(), "getSourceConnectionAnchor", e); //$NON-NLS-1$
			Log.error(DiagramUIPlugin.getInstance(), DiagramUIStatusCodes.IGNORED_EXCEPTION_WARNING, "getSourceConnectionAnchor", e); //$NON-NLS-1$
		}
		return ((NodeFigure)getFigure()).getConnectionAnchor(t);
	}

	public ConnectionAnchor getTargetConnectionAnchor(ConnectionEditPart connEditPart) {
		final org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart connection = (org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart)connEditPart;
		String t = ""; //$NON-NLS-1$
		try {
			t = (String)getEditingDomain().runExclusive(new RunnableWithResult.Impl() {

				public void run() {
					Anchor a = ((Edge)connection.getModel()).getTargetAnchor();
					if(a instanceof IdentityAnchor) {
						setResult(((IdentityAnchor)a).getId());
					} else {
						setResult(""); //$NON-NLS-1$
					}
				}
			});
		} catch (InterruptedException e) {
			Trace.catching(DiagramUIPlugin.getInstance(), DiagramUIDebugOptions.EXCEPTIONS_CATCHING, getClass(), "getTargetConnectionAnchor", e); //$NON-NLS-1$
			Log.error(DiagramUIPlugin.getInstance(), DiagramUIStatusCodes.IGNORED_EXCEPTION_WARNING, "getTargetConnectionAnchor", e); //$NON-NLS-1$
		}
		return ((NodeFigure)getFigure()).getConnectionAnchor(t);
	}

	public ConnectionAnchor getTargetConnectionAnchor(Request request) {
		if(request instanceof ReconnectRequest) {
			if(((DropRequest)request).getLocation() == null) {
				return ((NodeFigure)getFigure()).getTargetConnectionAnchorAt(null);
			}
			Point pt = ((DropRequest)request).getLocation().getCopy();
			return ((NodeFigure)getFigure()).getTargetConnectionAnchorAt(pt);
		} else if(request instanceof DropRequest) {
			return ((NodeFigure)getFigure()).getTargetConnectionAnchorAt(((DropRequest)request).getLocation());
		}
		return ((NodeFigure)getFigure()).getTargetConnectionAnchorAt(null);
	}

	public String mapConnectionAnchorToTerminal(ConnectionAnchor c) {
		return ((NodeFigure)getFigure()).getConnectionAnchorTerminal(c);
	}

	public ConnectionAnchor mapTerminalToConnectionAnchor(String terminal) {
		return ((NodeFigure)getFigure()).getConnectionAnchor(terminal);
	}

	public boolean canAttachNote() {
		return true;
	}

	@Override
	protected Image getLabelIcon() {
		return ElementIconUtil.getLabelIcon(this);
	}
}
