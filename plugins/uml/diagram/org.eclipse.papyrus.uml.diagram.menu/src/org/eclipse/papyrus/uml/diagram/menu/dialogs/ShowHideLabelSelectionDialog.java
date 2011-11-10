/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
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
package org.eclipse.papyrus.uml.diagram.menu.dialogs;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.EditPartService;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.papyrus.uml.diagram.common.dialogs.AbstractCheckedTreeColumnViewerSelectionDialog;
import org.eclipse.papyrus.uml.diagram.common.editparts.ILabelRoleProvider;
import org.eclipse.papyrus.uml.diagram.common.util.DiagramEditPartsUtil;
import org.eclipse.papyrus.uml.diagram.menu.Activator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Shell;

/**
 * This class provides a Dialog with 2 columns. In the first column, we have a TreeViewer and in the other one, you have a text.
 * 
 * 
 * 
 */
public class ShowHideLabelSelectionDialog extends AbstractCheckedTreeColumnViewerSelectionDialog {

	/**
	 * The diagram editpart
	 */
	private DiagramEditPart diagramEP = null;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param parent
	 *        the shell parent
	 * @param labelProvider
	 *        the label provider (used only to get the name of the root elements
	 * @param contentProvider
	 *        the content provider
	 * @param diagramEP
	 *        the current diagram EditPart
	 */
	public ShowHideLabelSelectionDialog(Shell parent, ILabelProvider labelProvider, ITreeContentProvider contentProvider) {
		super(parent, labelProvider, contentProvider, SWT.CENTER | SWT.BORDER | SWT.FULL_SELECTION, 2);
		init();
	}


	protected void init() {
		setColumnTitles(new String[]{ "Label Role", "Displayed Text" });
		setColumnWidths(new int[]{ 300, 300 });
		setColumnCellLabelProvider(new CellLabelProvider[]{ new RoleLabelProvider(), new TextLabelProvider() });
	}


	/**
	 * 
	 * @see org.eclipse.ui.dialogs.CheckedTreeSelectionDialog#setInput(java.lang.Object)
	 * 
	 * @param input
	 */
	@Override
	public void setInput(Object input) {
		super.setInput(input);
		if(input instanceof List<?> && !((List<?>)input).isEmpty()) {
			Object obj = ((List<?>)input).get(0);
			if(obj instanceof EditPart) {
				diagramEP = DiagramEditPartsUtil.getDiagramEditPart((EditPart)obj);
			}
		}
		Assert.isNotNull(diagramEP);
	}


	/**
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.common.dialogs.AbstractCheckedTreeColumnViewerSelectionDialog#getEditingSupport(int)
	 * 
	 * @param columnIndex
	 * @return
	 */
	@Override
	protected EditingSupport getEditingSupport(int columnIndex) {
		return null;
	}

	/**
	 * This provider is used by the first column
	 * 
	 * 
	 * 
	 */
	public class RoleLabelProvider extends CellLabelProvider implements ILabelProvider {

		/**
		 * 
		 * @see org.eclipse.jface.viewers.ILabelProvider#getImage(java.lang.Object)
		 * 
		 * @param element
		 * @return
		 */
		public Image getImage(Object element) {
			if(element instanceof View) {
				EditPart dummyEP = EditPartService.getInstance().createGraphicEditPart((View)element);
				String iconPath = "";
				if(dummyEP instanceof ILabelRoleProvider) {
					iconPath = ((ILabelRoleProvider)dummyEP).getIconPathRole();
					if(iconPath != null) {
						if(iconPath.indexOf("platform") == 0) {
							//the path looks like "platform:/plugin/org.eclipse.uml2.uml.edit/icons/full/obj16/Package.gif"
							try {
								return ImageDescriptor.createFromURL(new URL(iconPath)).createImage();
							} catch (MalformedURLException e) {
								Activator.log.error("I can't find the following image " + iconPath, e);
								return null;
							}
						}
					}
				}
			}
			return null;
		}

		/**
		 * 
		 * @see org.eclipse.jface.viewers.ILabelProvider#getText(java.lang.Object)
		 * 
		 * @param element
		 * @return
		 */
		public String getText(Object element) {
			if(element instanceof View) {
				EditPart dummyEP = EditPartService.getInstance().createGraphicEditPart((View)element);
				if(dummyEP instanceof ILabelRoleProvider) {
					return ((ILabelRoleProvider)dummyEP).getLabelRole();
				}
			}
			return "";
		}

		/**
		 * 
		 * @see org.eclipse.jface.viewers.CellLabelProvider#update(org.eclipse.jface.viewers.ViewerCell)
		 * 
		 * @param cell
		 */
		@Override
		public void update(ViewerCell cell) {
			cell.setImage(getImage(cell.getElement()));
			cell.setText(getText(cell.getElement()));

		}
	}

	/**
	 * This provider is used by the 2nd column
	 * 
	 * 
	 * 
	 */
	class TextLabelProvider extends CellLabelProvider implements ILabelProvider {

		/**
		 * 
		 * @see org.eclipse.jface.viewers.ILabelProvider#getImage(java.lang.Object)
		 * 
		 * @param element
		 * @return
		 */
		public Image getImage(Object element) {
			return null;
		}

		/**
		 * 
		 * @see org.eclipse.jface.viewers.ILabelProvider#getText(java.lang.Object)
		 * 
		 * @param element
		 * @return
		 */
		public String getText(Object element) {
			EditPart dummyEP = DiagramEditPartsUtil.getEditPartFromView((View)element, diagramEP);
			String text = "[No Text To Display]";
			if(dummyEP instanceof GraphicalEditPart) {
				IFigure figure = ((GraphicalEditPart)dummyEP).getFigure();
				if(figure instanceof WrappingLabel) {
					String str = ((WrappingLabel)figure).getText();
					if(str != null && str.length() != 0) {
						text = str;
					}
				}
			}
			return text;
		}


		/**
		 * 
		 * @see org.eclipse.jface.viewers.CellLabelProvider#update(org.eclipse.jface.viewers.ViewerCell)
		 * 
		 * @param cell
		 */
		@Override
		public void update(ViewerCell cell) {
			cell.setImage(getImage(cell.getElement()));
			cell.setText(getText(cell.getElement()));
		}

	}
}
