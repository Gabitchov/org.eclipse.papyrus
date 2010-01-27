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

import java.util.List;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.core.internal.commands.SendToBackCommand;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.commands.CreateCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.layouttool.LayoutToolAreaInterface;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;

/**
 * The Class GMFLayoutAreaCreator.
 */
public class GMFLayoutAreaCreator implements LayoutToolAreaInterface {

	/** The margin. */
	private int margin = 10;

	/** The my edit part node. */
	private static EditPart myEditPartNode;

	/** The node. */
	private static Node node;

	/** The edit part parent. */
	private static EditPart editPartParent;

	/** The idwp. */
	private IDiagramWorkbenchPart idwp;

	/** The ted. */
	private static TransactionalEditingDomain ted;

	/** The childs. */
	private List<EditPart> childs;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.layouttool.LayoutToolAreaInterface#paintLayoutArea()
	 */
	public void paintLayoutArea() {
		idwp = (IDiagramWorkbenchPart)PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
				.getActiveEditor();
		editPartParent = idwp.getDiagramEditPart();
		childs = editPartParent.getChildren();
		if(myEditPartNode == null || !childs.contains(myEditPartNode)) {
			createLayoutArea();
		} else if(myEditPartNode != null && childs.contains(myEditPartNode)) {
			deleteLayoutArea();
			createLayoutArea();
		}
	}

	/**
	 * Gets the area.
	 * 
	 * @return the area
	 */
	public static EditPart getArea() {
		return myEditPartNode;
	}

	/**
	 * Delete layout area.
	 */
	public static void deleteLayoutArea() {
		if(myEditPartNode != null) {
			CommandStack cs = ((GraphicalEditPart)editPartParent).getViewer().getEditDomain().getCommandStack();
			CompositeCommand mycommand = new CompositeCommand("mcb");
			DeleteCommand dc = new DeleteCommand(ted, (View)myEditPartNode.getModel());
			mycommand.add(dc);
			cs.execute(new ICommandProxy(mycommand));
			myEditPartNode = null;
			node = null;
		}
	}

	/**
	 * Gets the bounds.
	 * 
	 * @return the bounds
	 */
	public static Rectangle getBounds() {
		if(myEditPartNode != null) {
			return ((GraphicalEditPart)myEditPartNode).getFigure().getBounds();
		}
		return null;
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
		if(activeEditor instanceof IDiagramWorkbenchPart) {
			IDiagramWorkbenchPart workbenchPart = (IDiagramWorkbenchPart)activeEditor;
			ted = (TransactionalEditingDomain)workbenchPart.getAdapter(EditingDomain.class);
			if(ted == null) {
				if(workbenchPart instanceof DiagramEditor) {
					DiagramEditor editor = (DiagramEditor)workbenchPart;
					ted = editor.getEditingDomain();
				}
			}
		}
		return ted;
	}

	/**
	 * Creates the layout area.
	 */
	private void createLayoutArea() {
		CommandStack cs = ((GraphicalEditPart)editPartParent).getViewer().getEditDomain().getCommandStack();
		CompositeCommand command2 = new CompositeCommand("cb2");
		CreateViewRequest.ViewDescriptor viewDescriptor = new CreateViewRequest.ViewDescriptor(null, Node.class,
				"Note", -1, false, PreferencesHint.USE_DEFAULTS);
		ted = getTransactionalEditingDomain();
		CreateCommand cc = new CreateCommand(getTransactionalEditingDomain(), viewDescriptor, (View)editPartParent
				.getModel());
		command2.add(cc);
		cs.execute(new ICommandProxy(command2));
		node = (Node)((CreateViewRequest.ViewDescriptor)cc.getCommandResult().getReturnValue())
				.getAdapter(Node.class);
		for(EditPart n : childs) {
			if(n.getModel().equals(node))
				myEditPartNode = n;
		}
		((GraphicalEditPart)myEditPartNode).getFigure().setBackgroundColor(null);
		((GraphicalEditPart)myEditPartNode).getFigure().setOpaque(false);
		CompositeCommand command = new CompositeCommand("cb");
		SetBoundsCommand sbc = new SetBoundsCommand(getTransactionalEditingDomain(), "changebounds",
				new EObjectAdapter((View)myEditPartNode.getModel()), calculateBoundsLayoutArea());
		command.add(sbc);

		SendToBackCommand stbc = new SendToBackCommand(getTransactionalEditingDomain(), (View)myEditPartNode
				.getModel());
		command.add(stbc);
		cs.execute(new ICommandProxy(command));
	}

	/**
	 * Calculate bounds layout area.
	 * 
	 * @return the rectangle
	 */
	private Rectangle calculateBoundsLayoutArea() {
		int minX = ((Bounds)((Node)childs.get(0).getModel()).getLayoutConstraint()).getX();
		int maxX = ((Bounds)((Node)childs.get(0).getModel()).getLayoutConstraint()).getX();
		int minY = ((Bounds)((Node)childs.get(0).getModel()).getLayoutConstraint()).getY();
		int maxY = ((Bounds)((Node)childs.get(0).getModel()).getLayoutConstraint()).getY();
		for(EditPart e : childs) {
			if(e != childs.get(childs.size() - 1)) {
				minX = Math.min(minX, ((GraphicalEditPart)e).getFigure().getBounds().x - this.margin);
				maxX = Math.max(maxX, ((GraphicalEditPart)e).getFigure().getBounds().x
						+ ((GraphicalEditPart)e).getFigure().getBounds().width + this.margin);
				minY = Math.min(minY, ((GraphicalEditPart)e).getFigure().getBounds().y - this.margin);
				maxY = Math.max(maxY, ((GraphicalEditPart)e).getFigure().getBounds().y
						+ ((GraphicalEditPart)e).getFigure().getBounds().height + this.margin);
			}
		}
		maxX = maxX - minX;
		maxY = maxY - minY;
		if(minX == 0 && minY == 0 && maxX == 0 && maxY == 0) {
			return new Rectangle(20, 20, 20, 20);
		}
		return new Rectangle(minX, minY, maxX, maxY);
	}
}
