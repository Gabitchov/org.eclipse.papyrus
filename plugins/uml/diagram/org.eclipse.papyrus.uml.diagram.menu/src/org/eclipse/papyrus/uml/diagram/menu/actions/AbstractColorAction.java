/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.menu.actions;

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.ui.util.WindowUtil;
import org.eclipse.gmf.runtime.diagram.ui.actions.internal.l10n.DiagramUIActionsMessages;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.ChangePropertyValueRequest;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.PackageUtil;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.ColorDialog;
import org.eclipse.swt.widgets.Display;

/**
 * Adapted code from {@link ColorPropertyContributionItem}
 * 
 * This class is used for the ColorAction
 * 
 */
@SuppressWarnings("restriction")
public abstract class AbstractColorAction extends AbstractGraphicalParametricAction {

	/**
	 * A Class to represent easily the colors
	 * 
	 * 
	 * 
	 */
	public static class InventoryColorDescriptor {

		/** the RGB value for the color */
		public RGB colorValue;

		/** the color name */
		public String colorName;

		/**
		 * 
		 * Constructor.
		 * 
		 * @param colorValue
		 * @param colorName
		 */
		public InventoryColorDescriptor(RGB colorValue, String colorName) {
			this.colorValue = colorValue;
			this.colorName = colorName;
		}
	}

	/**
	 * the property id
	 */
	private String propertyID;

	/**
	 * the property name
	 */
	private String propertyName;


	/** the request type for the action */
	public static final String requestType = "property_change"; //$NON-NLS-1$

	/** the default preference color */
	private static final RGB DEFAULT_PREF_COLOR = new RGB(0, 0, 0);

	/**
	 * the available colors
	 */

	public static final InventoryColorDescriptor WHITE = new InventoryColorDescriptor(new RGB(255, 255, 255), DiagramUIActionsMessages.ColorPropertyChangeAction_white);

	public static final InventoryColorDescriptor BLACK_ = new InventoryColorDescriptor(new RGB(0, 0, 0), DiagramUIActionsMessages.ColorPropertyChangeAction_black);

	public static final InventoryColorDescriptor LIGHT_GRAY = new InventoryColorDescriptor(new RGB(192, 192, 192), DiagramUIActionsMessages.ColorPropertyChangeAction_lightGray);

	public static final InventoryColorDescriptor GRAY = new InventoryColorDescriptor(new RGB(128, 128, 128), DiagramUIActionsMessages.ColorPropertyChangeAction_gray);

	public static final InventoryColorDescriptor DARK_GRAY = new InventoryColorDescriptor(new RGB(64, 64, 64), DiagramUIActionsMessages.ColorPropertyChangeAction_darkGray);

	public static final InventoryColorDescriptor RED = new InventoryColorDescriptor(new RGB(227, 164, 156), DiagramUIActionsMessages.ColorPropertyChangeAction_red);

	public static final InventoryColorDescriptor GREEN = new InventoryColorDescriptor(new RGB(166, 193, 152), DiagramUIActionsMessages.ColorPropertyChangeAction_green);

	public static final InventoryColorDescriptor BLUE = new InventoryColorDescriptor(new RGB(152, 168, 191), DiagramUIActionsMessages.ColorPropertyChangeAction_blue);

	public static final InventoryColorDescriptor YELLOW = new InventoryColorDescriptor(new RGB(225, 225, 135), DiagramUIActionsMessages.ColorPropertyChangeAction_yellow);

	public static final InventoryColorDescriptor PURPLE = new InventoryColorDescriptor(new RGB(184, 151, 192), DiagramUIActionsMessages.ColorPropertyChangeAction_magenta);

	public static final InventoryColorDescriptor TEAL = new InventoryColorDescriptor(new RGB(155, 199, 204), DiagramUIActionsMessages.ColorPropertyChangeAction_cyan);

	public static final InventoryColorDescriptor PINK = new InventoryColorDescriptor(new RGB(228, 179, 229), DiagramUIActionsMessages.ColorPropertyChangeAction_pink);

	public static final InventoryColorDescriptor ORANGE = new InventoryColorDescriptor(new RGB(237, 201, 122), DiagramUIActionsMessages.ColorPropertyChangeAction_orange);

	/** parameter used to set the color to the default value */
	public static final String DEFAULT_COLOR = "default_color"; //$NON-NLS-1$

	/** parameter used to open a dialog to choose more color */
	public static final String MORE_COLORS = "more_colors"; //$NON-NLS-1$

	/**
	 * 
	 * Constructor.
	 * 
	 * @param propertyID
	 *        the property id
	 * @param propertyName
	 *        the property name
	 * @param parameter
	 *        the parameter for the action
	 * @param selectedEditPart
	 *        the selected editpart for the action
	 */
	public AbstractColorAction(String propertyID, String propertyName, String parameter, List<IGraphicalEditPart> selectedEditPart) {
		super(parameter, selectedEditPart);
		this.propertyID = propertyID;
		this.propertyName = propertyName;
	}

	/**
	 * Returns a int representing the color for the action
	 * 
	 * @return
	 *         a int representing the color for the action
	 */
	protected int getColor() {
		InventoryColorDescriptor currentColor = null;
		if(WHITE.colorName.equals(getParameter())) {
			currentColor = WHITE;
		} else if(BLACK_.colorName.equals(getParameter())) {
			currentColor = BLACK_;
		} else if(LIGHT_GRAY.colorName.equals(getParameter())) {
			currentColor = LIGHT_GRAY;
		} else if(GRAY.colorName.equals(getParameter())) {
			currentColor = GRAY;
		} else if(DARK_GRAY.colorName.equals(getParameter())) {
			currentColor = DARK_GRAY;
		} else if(RED.colorName.equals(getParameter())) {
			currentColor = RED;
		} else if(GREEN.colorName.equals(getParameter())) {
			currentColor = GREEN;
		} else if(BLUE.colorName.equals(getParameter())) {
			currentColor = BLUE;
		} else if(YELLOW.colorName.equals(getParameter())) {
			currentColor = YELLOW;
		} else if(PURPLE.colorName.equals(getParameter())) {
			currentColor = PURPLE;
		} else if(TEAL.colorName.equals(getParameter())) {
			currentColor = TEAL;
		} else if(PINK.colorName.equals(getParameter())) {
			currentColor = PINK;
		} else if(ORANGE.colorName.equals(getParameter())) {
			currentColor = ORANGE;
		} else if(DEFAULT_COLOR.equals(getParameter())) {
			currentColor = new InventoryColorDescriptor(getDefaultColor(), ""); //$NON-NLS-1$
		}
		//		else if(MORE_COLORS.equals(getParameter())) {
		//			//nothing to do
		//		} 
		return org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities.RGBToInteger(currentColor.colorValue);

	}

	/**
	 * Returns the color to use in the default mode. A limitation is that if
	 * there are multiple editparts with different default colors only the
	 * default color of the first is returned.
	 * 
	 * @return The color to use in default mode
	 */
	protected RGB getDefaultColor() {
		for(Iterator<?> iter = getSelection().iterator(); iter.hasNext();) {
			EditPart editpart = (EditPart)iter.next();
			if(editpart instanceof IGraphicalEditPart) {
				final EStructuralFeature feature = (EStructuralFeature)PackageUtil.getElement(getPropertyId());

				Object preferredValue = ((IGraphicalEditPart)editpart).getPreferredValue(feature);
				if(preferredValue instanceof Integer) {
					return FigureUtilities.integerToRGB((Integer)preferredValue);
				}

			}

		}
		return DEFAULT_PREF_COLOR;
	}

	/**
	 * Returns the current color of the figure
	 * 
	 * @return
	 *         the current color of the figure
	 */
	protected RGB getCurrentColor() {
		for(Iterator<?> iter = getSelection().iterator(); iter.hasNext();) {
			EditPart editpart = (EditPart)iter.next();
			if(editpart instanceof IGraphicalEditPart) {
				final EStructuralFeature feature = (EStructuralFeature)PackageUtil.getElement(getPropertyId());

				Object preferredValue = ((IGraphicalEditPart)editpart).getStructuralFeatureValue(feature);
				if(preferredValue instanceof Integer) {
					return FigureUtilities.integerToRGB((Integer)preferredValue);
				}

			}
		}
		return DEFAULT_PREF_COLOR;
	}

	/**
	 * Getter for {@link #propertyID}
	 * 
	 * @return
	 *         {@link #propertyID}
	 */
	protected String getPropertyId() {
		return propertyID;
	}

	/**
	 * Getter for {@link #propertyName}
	 * 
	 * @return
	 *         {@link #propertyName}
	 */
	protected String getPropertyName() {
		return this.propertyName;
	}

	/**
	 * A custom command used when the user want used a custom color
	 * 
	 * 
	 * 
	 */
	public class CustomColorCommand extends AbstractTransactionalCommand {

		/**
		 * 
		 * Constructor.
		 * 
		 * @param domain
		 *        the domain for the action
		 * @param label
		 *        the label of the command
		 * @param selectedElements
		 * 
		 */
		public CustomColorCommand(TransactionalEditingDomain domain, String label) {
			super(domain, label, null);
		}

		/**
		 * 
		 * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor,
		 *      org.eclipse.core.runtime.IAdaptable)
		 * 
		 * @param monitor
		 * @param info
		 * @return
		 * @throws ExecutionException
		 */
		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
			ColorDialog dialog = new ColorDialog(Display.getCurrent().getActiveShell());
			WindowUtil.centerDialog(dialog.getParent(), Display.getCurrent().getActiveShell());
			if(getCurrentColor() != null) {
				dialog.setRGB(getCurrentColor());
			}
			dialog.open();
			ChangePropertyValueRequest request = new ChangePropertyValueRequest(getPropertyName(), getPropertyId());
			request.setType(requestType);
			RGB rgb = dialog.getRGB();
			request.setValue(FigureUtilities.RGBToInteger(rgb));
			Command cmd = getCommand(request);
			if(cmd.canExecute()) {
				cmd.execute();
			}
			return CommandResult.newOKCommandResult();
		}

		/**
		 * 
		 * @see org.eclipse.core.commands.operations.AbstractOperation#canExecute()
		 * 
		 * @return
		 */
		@Override
		public boolean canExecute() {
			//we test a color change to know if the command can be done
			ChangePropertyValueRequest request = new ChangePropertyValueRequest(getPropertyName(), getPropertyId());
			request.setValue(FigureUtilities.RGBToInteger(BLACK_.colorValue));
			return getCommand(request).canExecute();
		}

	}

	/**
	 * Returns the command for this action, corresponding to the request
	 * 
	 * @param request
	 *        the request for the action
	 * @return
	 *         the command to do the request
	 */
	protected Command getCommand(ChangePropertyValueRequest request) {
		CompoundCommand command = new CompoundCommand();
		for(IGraphicalEditPart current : getSelection()) {
			Command tmp = current.getCommand(request);
			if(tmp != null && tmp.canExecute()) {
				command.add(tmp);
			}
		}
		return command;
	}


	/**
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.menu.actions.AbstractGraphicalParametricAction#getBuildedCommand()
	 * 
	 * @return
	 */
	@Override
	protected Command getBuildedCommand() {
		if(getParameter().equals(MORE_COLORS)) {
			TransactionalEditingDomain editingDomain = getEditingDomain();
			CustomColorCommand cmd = new CustomColorCommand(editingDomain, "More Colors Command"); //$NON-NLS-1$
			return new ICommandProxy(cmd);

		} else {
			ChangePropertyValueRequest request = new ChangePropertyValueRequest(getPropertyName(), getPropertyId());
			request.setType(requestType);
			request.setValue(getColor());
			return getCommand(request);
		}
	}

}
