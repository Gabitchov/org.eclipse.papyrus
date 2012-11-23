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
package org.eclipse.papyrus.uml.diagram.common.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.CompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IResizableCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.EditPartService;
import org.eclipse.gmf.runtime.notation.BasicCompartment;
import org.eclipse.gmf.runtime.notation.DecorationNode;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.TitleStyle;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.editpart.IShapeCompartmentEditPart;

/**
 * This utils provides methods to manipulate compartments of the EditPart
 * 
 * 
 * 
 */
public class CompartmentUtils {

	private CompartmentUtils() {

	}

	/**
	 * Returns all the compartments edit part of an EditPart
	 * 
	 * @param editpart
	 *        an editpart
	 * @param includeTitleCompartment
	 *        if <code>true</code> we return the title compartment too
	 * @return all compartments of the EditPart
	 */
	public static List<IResizableCompartmentEditPart> getAllCompartmentsEditPart(EditPart editpart, boolean includeTitleCompartment) {
		List<IResizableCompartmentEditPart> compartments = new ArrayList<IResizableCompartmentEditPart>();

		List<?> localChildren = editpart.getChildren();
		for(Object current : localChildren) {
			if(current instanceof IResizableCompartmentEditPart) {
				if(includeTitleCompartment) {
					compartments.add((IResizableCompartmentEditPart)current);
				} else {
					if(!(current instanceof ITextAwareEditPart)) {
						compartments.add((IResizableCompartmentEditPart)current);
					}
				}
			}
		}
		return compartments;
	}

	/**
	 * Returns all the compartments of an EditPart
	 * 
	 * @param editpart
	 *        an editpart
	 * @param includeTitleCompartment
	 *        if <code>true</code> we return the title compartment too
	 * @return all compartments of the EditPart
	 */
	public static List<View> getAllCompartments(EditPart editpart, boolean includeTitleCompartment) {
		List<View> compartments = new ArrayList<View>();
		View notationView = ((GraphicalEditPart)editpart).getNotationView();
		//before it looks for persistedChildren
		//because we want to see compartment of stereotypes that are volatile
		//wee have replace it by getChildreen
		//List<?> graphicalChildren = notationView.getPersistedChildren();
		List<?> graphicalChildren = notationView.getChildren();
		String type = notationView.getType();

		for(Object child : graphicalChildren) {
			// Only add compartment
			if(child instanceof View && ((View)child).getType().equals(type)) {
				continue;
			}
			if(child instanceof BasicCompartment) {
				if(includeTitleCompartment) {
					compartments.add((View)child);
				} else {
					if(!isCompartmentName(editpart, (View)child)) {
						compartments.add((View)child);
					}
				}
			} else if(child instanceof DecorationNode) {
				if(includeTitleCompartment) {
					compartments.add((View)child);
				} else {
					if(!isCompartmentName(editpart, (View)child)) {
						compartments.add((View)child);
					}
				}
			} else if(child instanceof Node && isShapeCompartment((Node)child)) { // possible for shapes. 
				if(includeTitleCompartment) {
					compartments.add((View)child);
				} else {
					if(!isCompartmentName(editpart, (View)child)) {
						compartments.add((View)child);
					}
				}
			}
		}
		return compartments;
	}
	
	/**
	 * Returns <code>true</code> if the view corresponds to the display of a shape in a compartment
	 * @param view the view to test
	 * @return <code>true</code> if the view corresponds to the display of a shape in a compartment
	 */
	public static boolean isShapeCompartment(View view) {
		return IShapeCompartmentEditPart.VIEW_TYPE.equals(view.getType());
	}

	/**
	 * Returns all the displayed compartments for the EditPart
	 * 
	 * @param editpart
	 *        an editpart
	 * @param includeTitleCompartment
	 *        if <code>true</code> we return the title compartment too
	 * @return all the displayed compartments for the EditPart
	 */
	public static List<View> getAllVisibleCompartments(EditPart editpart, boolean includeTitleCompartment) {
		List<View> visibleCompartments = new ArrayList<View>();
		List<?> localChildren = editpart.getChildren();
		for(Object current : localChildren) {
			if(current instanceof CompartmentEditPart) {
				if(includeTitleCompartment) {
					visibleCompartments.add(((View)((CompartmentEditPart)current).getModel()));
				} else {
					if(!(current instanceof ITextAwareEditPart)) {
						visibleCompartments.add(((View)((CompartmentEditPart)current).getModel()));
					}
				}
			}
		}
		return visibleCompartments;
	}

	/**
	 * Tests if a view is a compartment name
	 * 
	 * @param editpart
	 *        the editpart
	 * @param view
	 *        a view of this editpart
	 * @return <code>true</code> if this view is compartment name
	 */
	public static boolean isCompartmentName(EditPart editpart, View view) {
		IGraphicalEditPart gep = EditPartService.getInstance().createGraphicEditPart(view);
		if(gep instanceof ITextAwareEditPart) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @param editpart
	 *        an editpart
	 * @return A list of {@link CompartmentTitleRepresentation} which represents
	 *         the visible titles of the compartments of the editpart
	 */
	public static List<CompartmentTitleRepresentation> getAllVisibleCompartmentName(EditPart editpart) {
		List<View> allCompartments = getAllCompartments(editpart, false);
		List<CompartmentTitleRepresentation> visibleTitle = new ArrayList<CompartmentTitleRepresentation>();
		for(View current : allCompartments) {
			if(isCompartmentTitleVisible(current)) {
				visibleTitle.add(new CompartmentTitleRepresentation(editpart, current));
			}
		}
		return visibleTitle;
	}

	/**
	 * 
	 * @param compartmentView
	 *        a view of a compartment
	 * @return <code>true</code> if the title of the compartment is visible
	 */
	public static boolean isCompartmentTitleVisible(View compartmentView) {
		TitleStyle style = (TitleStyle)compartmentView.getStyle(NotationPackage.eINSTANCE.getTitleStyle());
		if(style != null && style.isShowTitle()) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @param representations
	 *        a list of {@link CompartmentTitleRepresentation}
	 * @param view
	 *        a view
	 * @return the {@link CompartmentTitleRepresentation} which represents the
	 *         view or <code>null</code> if not found
	 */
	public static CompartmentTitleRepresentation getCompartmentTitleRepresentation(List<CompartmentTitleRepresentation> representations, View view) {
		for(CompartmentTitleRepresentation current : representations) {
			if(current.getRealObject().equals(view)) {
				return current;
			}
		}
		return null;

	}
}
