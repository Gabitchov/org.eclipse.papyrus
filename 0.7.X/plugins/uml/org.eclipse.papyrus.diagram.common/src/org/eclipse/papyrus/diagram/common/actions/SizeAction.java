/*****************************************************************************
 * Copyright (c) 2009-2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Adapted Code from Eclipse GMF 
 *  (AutoSizeAction, SizeBothAction, SizeHeightAction and SizeWidthAction)
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.common.actions;

import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;

/**
 * 
 * This class provides commands to change the size of the selected {@link IGraphicalEditPart}
 * 
 */
public class SizeAction {


	/** parameter for the autosize action */
	public static final String PARAMETER_AUTOSIZE = "parameter_autosize";

	/** parameter for the Same Height and Width action */
	public static final String PARAMETER_BOTH = "parameter_both";

	/** parameter for the same Height action */
	public static final String PARAMETER_HEIGHT = "parameter_height";

	/** parameter for the Same Width action */
	public static final String PARAMETER_WIDTH = "parameter_width";

	/** the size action type */
	protected int sizeActionType = 0;

	/** value for the AutoSize action */
	public static final int AUTOSIZE = 0;

	/** value for the Both (Same Height and Width) action */
	public static final int BOTH = AUTOSIZE + 1;

	/** value for the Same Height action */
	public static final int HEIGHT = BOTH + 1;

	/** value for the Same Width action */
	public static final int WIDTH = HEIGHT + 1;

	/** the selected elements */
	public List<IGraphicalEditPart> selectedElements;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param parameter
	 *        the parameter for this action
	 * @param selectedElements
	 *        the selected elements for this action
	 */
	public SizeAction(String parameter, List<IGraphicalEditPart> selectedElements) {
		this.selectedElements = selectedElements;
		if(PARAMETER_AUTOSIZE.equals(parameter)) {
			this.sizeActionType = AUTOSIZE;
		} else if(PARAMETER_BOTH.equals(parameter)) {
			this.sizeActionType = BOTH;
		} else if(PARAMETER_HEIGHT.equals(parameter)) {
			this.sizeActionType = HEIGHT;
		} else if(PARAMETER_WIDTH.equals(parameter)) {
			this.sizeActionType = WIDTH;
		}



	}

	/**
	 * Return the command for this Action
	 * 
	 * @return
	 *         The command for this Action
	 */
	public Command getCommand() {
		switch(this.sizeActionType) {
		case AUTOSIZE:
			return getAutoSizeCommand();
		case BOTH:
			return getBothCommand();
		case HEIGHT:
			return getHeightCommand();
		case WIDTH:
			return getWidthCommand();

		default:
			return UnexecutableCommand.INSTANCE;
		}

	}

	/**
	 * Return the command for the AutoSize Action
	 * 
	 * @return
	 *         the command for the AutoSize Action
	 */
	protected Command getAutoSizeCommand() {
		if(this.selectedElements.isEmpty()) {
			return UnexecutableCommand.INSTANCE;
		} else {
			boolean foundNonAutosizedPart = false;
			List<IGraphicalEditPart> operationSet = selectedElements;
			Iterator<IGraphicalEditPart> editParts = operationSet.iterator();
			CompoundCommand command = new CompoundCommand("AutoSize Command");
			while(editParts.hasNext()) {
				EditPart editPart = editParts.next();

				//check if the editpart is autosized
				if(editPart instanceof GraphicalEditPart) {
					GraphicalEditPart graphicalEditPart = (GraphicalEditPart)editPart;
					Integer containerWidth = (Integer)graphicalEditPart.getStructuralFeatureValue(NotationPackage.eINSTANCE.getSize_Width());
					Integer containerHeight = (Integer)graphicalEditPart.getStructuralFeatureValue(NotationPackage.eINSTANCE.getSize_Height());
					if(containerWidth.intValue() != -1 || containerHeight.intValue() != -1) {
						foundNonAutosizedPart = true;
					}
				}
				Request request = new Request(RequestConstants.REQ_AUTOSIZE);
				Command curCommand = editPart.getCommand(request);
				if(curCommand != null) {
					command.add(curCommand);
				}
			}
			return command.isEmpty() || command.size() != operationSet.size() || !foundNonAutosizedPart ? UnexecutableCommand.INSTANCE : (Command)command;
		}
	}

	/**
	 * Return the command for the Same Height and Width Action
	 * 
	 * @return
	 *         Return the command for the Same Height and Width Action
	 */
	protected Command getBothCommand() {
		if(!(this.selectedElements.size() > 1)) {
			return UnexecutableCommand.INSTANCE;
		} else {
			// Create a compound command to hold the resize commands
			CompoundCommand doResizeCmd = new CompoundCommand();

			// Create an iterator for the selection
			Iterator<IGraphicalEditPart> iter = selectedElements.iterator();

			// Get the Primary Selection
			int last = selectedElements.size() - 1;
			IGraphicalEditPart primary = selectedElements.get(last);
			View primaryView = (View)primary.getModel();
			Integer width = (Integer)ViewUtil.getStructuralFeatureValue(primaryView, NotationPackage.eINSTANCE.getSize_Width());
			Integer height = (Integer)ViewUtil.getStructuralFeatureValue(primaryView, NotationPackage.eINSTANCE.getSize_Height());

			Dimension primarySize;
			if(width.intValue() == -1 || height.intValue() == -1)
				primarySize = primary.getFigure().getSize().getCopy();
			else
				primarySize = new Dimension(width.intValue(), height.intValue());

			while(iter.hasNext()) {
				IGraphicalEditPart toResize = iter.next();
				View resizeView = (View)toResize.getModel();

				doResizeCmd.add(new ICommandProxy(new SetBoundsCommand(toResize.getEditingDomain(), "", new EObjectAdapter(resizeView), primarySize))); //$NON-NLS-1$
			}

			return doResizeCmd.unwrap();
		}
	}

	/**
	 * Return the command for the Same Height Action
	 * 
	 * @return
	 *         Return the command for the Same Height Action
	 */
	protected Command getHeightCommand() {
		if(!(this.selectedElements.size() > 1)) {
			return UnexecutableCommand.INSTANCE;
		} else {
			// Create a compound command to hold the resize commands
			CompoundCommand doResizeCmd = new CompoundCommand();

			// Create an iterator for the selection
			Iterator<IGraphicalEditPart> iter = selectedElements.iterator();

			// Get the Primary Selection
			int last = selectedElements.size() - 1;
			IGraphicalEditPart primary = selectedElements.get(last);
			View primaryView = (View)primary.getModel();
			Integer width = (Integer)ViewUtil.getStructuralFeatureValue(primaryView, NotationPackage.eINSTANCE.getSize_Width());
			Integer height = (Integer)ViewUtil.getStructuralFeatureValue(primaryView, NotationPackage.eINSTANCE.getSize_Height());

			Dimension primarySize;
			if(width.intValue() == -1 || height.intValue() == -1)
				primarySize = primary.getFigure().getSize().getCopy();
			else
				primarySize = new Dimension(width.intValue(), height.intValue());

			while(iter.hasNext()) {
				IGraphicalEditPart toResize = iter.next();
				View resizeView = (View)toResize.getModel();

				// Make a copy of the primary view so the width doesn't change
				Dimension size = primarySize.getCopy();
				size.width = ((Integer)ViewUtil.getStructuralFeatureValue(resizeView, NotationPackage.eINSTANCE.getSize_Width())).intValue();

				doResizeCmd.add(new ICommandProxy(new SetBoundsCommand(toResize.getEditingDomain(), "", new EObjectAdapter(resizeView), size))); //$NON-NLS-1$
			}

			return doResizeCmd.unwrap();
		}
	}

	/**
	 * Return the command for the Same Width Action
	 * 
	 * @return
	 *         the command for the Same Width Action
	 */
	protected Command getWidthCommand() {
		if(!(this.selectedElements.size() > 1)) {
			return UnexecutableCommand.INSTANCE;
		} else {
			// Create a compound command to hold the resize commands
			CompoundCommand doResizeCmd = new CompoundCommand();

			// Create an iterator for the selection
			Iterator<IGraphicalEditPart> iter = selectedElements.iterator();

			// Get the Primary Selection
			int last = selectedElements.size() - 1;
			IGraphicalEditPart primary = selectedElements.get(last);
			View primaryView = (View)primary.getModel();
			Integer width = (Integer)ViewUtil.getStructuralFeatureValue(primaryView, NotationPackage.eINSTANCE.getSize_Width());
			Integer height = (Integer)ViewUtil.getStructuralFeatureValue(primaryView, NotationPackage.eINSTANCE.getSize_Height());

			Dimension primarySize;
			if(width.intValue() == -1 || height.intValue() == -1)
				primarySize = primary.getFigure().getSize().getCopy();
			else
				primarySize = new Dimension(width.intValue(), height.intValue());

			while(iter.hasNext()) {
				IGraphicalEditPart toResize = iter.next();
				View resizeView = (View)toResize.getModel();

				// Make a copy of the primary view so the width doesn't change
				Dimension size = primarySize.getCopy();
				size.height = ((Integer)ViewUtil.getStructuralFeatureValue(resizeView, NotationPackage.eINSTANCE.getSize_Height())).intValue();

				doResizeCmd.add(new ICommandProxy(new SetBoundsCommand(toResize.getEditingDomain(), "", new EObjectAdapter(resizeView), size))); //$NON-NLS-1$


			}

			return doResizeCmd.unwrap();
		}
	}





}
