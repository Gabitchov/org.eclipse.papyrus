/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Allanic Alexia (Atos Origin) alexia.allanic@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.layouttool.subeditor.gmf;

import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.draw2d.Animation;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.internal.commands.SetConnectionBendpointsCommand;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.layouttool.Activator;
import org.eclipse.papyrus.layouttool.LayouttoolInterface;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;

/**
 * The Class GMFSubEditor.
 */
public class GMFSubEditor implements LayouttoolInterface {

	/** The command. */
	CompositeCommand command = new CompositeCommand("Apply Layout");

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.layouttool.LayouttoolInterface#execute(java.util.Map)
	 */
	public void execute(Map<EditPart, Rectangle> map) {
		TransactionalEditingDomain ted = getTransactionalEditingDomain();
		if (ted != null) {
			CommandStack cs = null;
			// Add a command to apply new bounds of all nodes
			for (Entry<EditPart, Rectangle> s : map.entrySet()) {
				SetBoundsCommand boundsCommand = new SetBoundsCommand(ted, "apply layout", new EObjectAdapter((View) s
						.getKey().getModel()), s.getValue());
				command.add(boundsCommand);
				GraphicalEditPart gep = (GraphicalEditPart) s.getKey();
				if (cs == null) {
					cs = gep.getViewer().getEditDomain().getCommandStack();
				}
			}
			try {
				// Execute layout commands with animation
				Animation.markBegin();
				cs.execute(new ICommandProxy(command));
				Animation.run(1000);
			} catch (Exception e) {
				Activator.getDefault().log(e.getMessage() + " : Cannot apply new bounds of all nodes", e);
			}
		}
	}

	/**
	 * Gets the transactional editing domain.
	 * 
	 * @return the transactional editing domain
	 */
	private TransactionalEditingDomain getTransactionalEditingDomain() {
		TransactionalEditingDomain ted = null;
		IEditorPart activeEditor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
				.getActiveEditor();
		if (activeEditor instanceof IDiagramWorkbenchPart) {
			IDiagramWorkbenchPart workbenchPart = (IDiagramWorkbenchPart) activeEditor;
			ted = (TransactionalEditingDomain) workbenchPart.getAdapter(EditingDomain.class);
			if (ted == null) {
				if (workbenchPart instanceof DiagramEditor) {
					DiagramEditor editor = (DiagramEditor) workbenchPart;
					ted = editor.getEditingDomain();
				}
			}
		}
		return ted;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.layouttool.LayouttoolInterface#getBounds(org.eclipse.gef.EditPart)
	 */
	public Rectangle getBounds(EditPart element) {
		if (element.getModel() instanceof Node) {
			Node node = (Node) element.getModel();
			if (node.getLayoutConstraint() instanceof Bounds) {
				Bounds bounds = (Bounds) node.getLayoutConstraint();
				return new Rectangle(bounds.getX(), bounds.getY(), bounds.getWidth(), bounds.getHeight());
			}
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.layouttool.LayouttoolInterface#getTarget(org.eclipse.gef.EditPart)
	 */
	public EditPart getTarget(EditPart element) {
		if (element.getModel() instanceof Edge) {
			Edge edge = (Edge) element.getModel();
			removeBendPoints(edge);
			AbstractConnectionEditPart acep = (AbstractConnectionEditPart) element;
			return acep.getTarget();
		}
		return null;
	}

	/**
	 * Removes the bend points.
	 * 
	 * @param edge
	 *            the edge
	 */
	public void removeBendPoints(Edge edge) {
		SetConnectionBendpointsCommand scbc = new SetConnectionBendpointsCommand(getTransactionalEditingDomain());
		scbc.setEdgeAdapter(new EObjectAdapter((View) edge));
		scbc.setNewPointList(new PointList(), new Point(), new Point());
		command.add(scbc);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.layouttool.LayouttoolInterface#getLayoutArea(org.eclipse.gef.EditPart[])
	 */
	public Rectangle getLayoutArea(EditPart[] element) {
		Rectangle bounds;
		if (GMFLayoutAreaCreator.getBounds() != null) {
			bounds = GMFLayoutAreaCreator.getBounds();
			GMFLayoutAreaCreator.deleteLayoutArea();
			return bounds;
		}
		for (EditPart e : element) {
			if (e.getModel() instanceof Node) {
				if (e.getParent() instanceof GraphicalEditPart) {
					GraphicalEditPart gep = (GraphicalEditPart) e.getParent();
					bounds = gep.getFigure().getBounds();
					bounds.x = 0;
					bounds.y = 0;
					return bounds;
				}
			}
		}
		return new Rectangle(0, 0, 1000, 1000);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.layouttool.LayouttoolInterface#getSource(org.eclipse.gef.EditPart)
	 */
	public EditPart getSource(EditPart element) {
		if (element.getModel() instanceof Edge) {
			Edge edge = (Edge) element.getModel();
			removeBendPoints(edge);
			AbstractConnectionEditPart acep = (AbstractConnectionEditPart) element;
			return acep.getSource();
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.layouttool.LayouttoolInterface#isNode(org.eclipse.gef.EditPart)
	 */
	public boolean isNode(EditPart element) {
		if (element.getModel() instanceof Node) {
			if (GMFLayoutAreaCreator.getArea() != null && element.equals(GMFLayoutAreaCreator.getArea())) {
				return false;
			}
			return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.layouttool.LayouttoolInterface#isRelationship(org.eclipse.gef.EditPart)
	 */
	public boolean isRelationship(EditPart element) {
		if (element.getModel() instanceof Edge) {
			return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.layouttool.LayouttoolInterface#getEditorClass()
	 */
	public Class getEditorClass() {
		return IDiagramWorkbenchPart.class;
	}
}
