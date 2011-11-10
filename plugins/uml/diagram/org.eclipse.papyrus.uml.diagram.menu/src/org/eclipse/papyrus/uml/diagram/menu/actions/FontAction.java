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

import java.util.List;

import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.core.util.Log;
import org.eclipse.gmf.runtime.common.core.util.Trace;
import org.eclipse.gmf.runtime.diagram.ui.actions.internal.l10n.DiagramUIActionsMessages;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GroupEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.internal.DiagramUIDebugOptions;
import org.eclipse.gmf.runtime.diagram.ui.internal.DiagramUIPlugin;
import org.eclipse.gmf.runtime.diagram.ui.internal.DiagramUIStatusCodes;
import org.eclipse.gmf.runtime.diagram.ui.internal.properties.Properties;
import org.eclipse.gmf.runtime.diagram.ui.requests.ChangePropertyValueRequest;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.emf.core.util.PackageUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.FontDialog;
import org.eclipse.swt.widgets.Shell;

/**
 * Adapted code from {@link FontDialogAction}
 * 
 * 
 * 
 */

public class FontAction extends AbstractGraphicalParametricAction {

	/**
	 * 
	 * Constructor.
	 * 
	 * @param selectedElements
	 *        the selected elements
	 */
	public FontAction(List<IGraphicalEditPart> selectedElements) {
		super(null, selectedElements);
	}



	/**
	 * Returns the command according to the request
	 * 
	 * @param req
	 *        the request to create the command
	 * @return
	 *         the command according to the request
	 */
	protected Command getCommand(ChangePropertyValueRequest req) {
		CompoundCommand cmd = new CompoundCommand("Change value for " + req.getPropertyName()); //$NON-NLS-1$
		for(IGraphicalEditPart editPart : getSelection()) {
			cmd.add(editPart.getCommand(req));
		}
		return cmd;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.menu.actions.AbstractParametricAction#isEnabled()
	 * 
	 * @return
	 */
	@Override
	public boolean isEnabled() {
		ChangePropertyValueRequest request = new ChangePropertyValueRequest("Font", "notation.FontStyle.fontColor"); //$NON-NLS-1$ //$NON-NLS-2$
		request.setType("property_change"); //$NON-NLS-1$
		CompoundCommand command = new CompoundCommand("Font Command"); //$NON-NLS-1$
		for(IGraphicalEditPart current : getSelection()) {
			Command tmp = current.getCommand(request);
			if(tmp != null) {
				command.add(tmp);
			}
		}
		if(command.isEmpty() || command.size() != getSelection().size()) {
			return false;
		}
		return true;
	}

	/**
	 * Returns the property value of the given property id of the current operation set's
	 * 
	 * The default implementation returns the current property value of the
	 * primary object in the operation set if not empty and <code>null</code> otherwise
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.internal.actions.PropertyChangeAction#getNewPropertyValue()
	 */
	@SuppressWarnings("restriction")
	protected Object getOperationSetPropertyValue(String id) {
		List<?> set = getSelection();
		if(!set.isEmpty()) {
			IGraphicalEditPart primaryEditPart = (IGraphicalEditPart)set.get(set.size() - 1);
			return getPropertyValue(primaryEditPart, id);
		}
		return null;
	}

	/**
	 * A utility method to return the value of a given property for a given editpart
	 * 
	 * @param editPart
	 *        The editpart
	 * @return The current value of the editpart's given property
	 */
	protected Object getPropertyValue(final IGraphicalEditPart editPart, final String thePropertyId) {

		try {
			return editPart.getEditingDomain().runExclusive(new RunnableWithResult.Impl() {

				public void run() {
					setResult(getStructuralFeatureValue(editPart, thePropertyId));
				}
			});
		} catch (InterruptedException e) {
			Trace.catching(DiagramUIPlugin.getInstance(), DiagramUIDebugOptions.EXCEPTIONS_CATCHING, getClass(), "getPropertyValue", e); //$NON-NLS-1$
			Log.error(DiagramUIPlugin.getInstance(), DiagramUIStatusCodes.IGNORED_EXCEPTION_WARNING, "getPropertyValue", e); //$NON-NLS-1$
		}
		return null;
	}

	/**
	 * Gets the structural feature value of the property id on the editpart
	 * passed in or one of the children if the editpart is a group and {@link #digIntoGroups()} returns true.
	 * 
	 * @param editpart
	 *        the editpart
	 * @param thePropertyId
	 *        the property id
	 */
	private Object getStructuralFeatureValue(IGraphicalEditPart editpart, final String thePropertyId) {
		ENamedElement element = PackageUtil.getElement(thePropertyId);
		if(element instanceof EStructuralFeature) {
			if(digIntoGroups() && editpart instanceof GroupEditPart) {
				editpart = (IGraphicalEditPart)editpart.getChildren().get(0);
			}
			return editpart.getStructuralFeatureValue((EStructuralFeature)element);
		}
		return null;
	}

	/**
	 * Override to return true to have this property action work on the shapes
	 * in a <code>GroupEditPart</code> as if the shapes were multi-selected.
	 * 
	 * @return true if this property action is to dig into the shapes of groups
	 */
	protected boolean digIntoGroups() {
		return true;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.menu.actions.AbstractGraphicalParametricAction#getBuildedCommand()
	 * 
	 * @return
	 */
	@Override
	protected Command getBuildedCommand() {
		String name = (String)getOperationSetPropertyValue(Properties.ID_FONTNAME);
		Integer height = (Integer)getOperationSetPropertyValue(Properties.ID_FONTSIZE);
		Boolean bold = (Boolean)getOperationSetPropertyValue(Properties.ID_FONTBOLD);
		Boolean italic = (Boolean)getOperationSetPropertyValue(Properties.ID_FONTITALIC);
		int style = (bold.booleanValue() ? SWT.BOLD : SWT.NORMAL) | (italic.booleanValue() ? SWT.ITALIC : SWT.NORMAL);
		FontData initFontData = new FontData(name, height.intValue(), style);

		Integer color = (Integer)getOperationSetPropertyValue(Properties.ID_FONTCOLOR);
		RGB initFontColor = FigureUtilities.integerToRGB(color);

		Shell shell = getDiagramGraphicalViewer().getControl().getShell();
		FontDialog fontDialog = new FontDialog(shell);
		fontDialog.setFontList(new FontData[]{ initFontData });
		fontDialog.setRGB(initFontColor);
		FontData fData = fontDialog.open();
		RGB fColor = fontDialog.getRGB();

		CompoundCommand cc = new CompoundCommand(DiagramUIActionsMessages.PropertyDescriptorFactory_Font);
		if(fData != null && fColor != null) {

			cc.add(getCommand(new ChangePropertyValueRequest(Properties.ID_FONTNAME, Properties.ID_FONTNAME, fData.getName())));
			cc.add(getCommand(new ChangePropertyValueRequest(Properties.ID_FONTSIZE, Properties.ID_FONTSIZE, new Integer(fData.getHeight()))));
			cc.add(getCommand(new ChangePropertyValueRequest(Properties.ID_FONTBOLD, Properties.ID_FONTBOLD, Boolean.valueOf((fData.getStyle() & SWT.BOLD) != 0))));
			cc.add(getCommand(new ChangePropertyValueRequest(Properties.ID_FONTITALIC, Properties.ID_FONTITALIC, Boolean.valueOf((fData.getStyle() & SWT.ITALIC) != 0))));
			cc.add(getCommand(new ChangePropertyValueRequest(Properties.ID_FONTCOLOR, Properties.ID_FONTCOLOR, FigureUtilities.RGBToInteger(fColor))));
		}

		if(!cc.isEmpty() && cc.canExecute()) {
			return cc;
		}
		return UnexecutableCommand.INSTANCE;
	}
}
