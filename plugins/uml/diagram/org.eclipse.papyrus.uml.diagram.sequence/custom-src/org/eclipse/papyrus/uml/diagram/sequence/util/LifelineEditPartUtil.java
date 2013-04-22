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
package org.eclipse.papyrus.uml.diagram.sequence.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.ActionExecutionSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.BehaviorExecutionSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CombinedFragment2EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.figures.LifelineDotLineCustomFigure;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class LifelineEditPartUtil {

	/**
	 * This operation returns the ExecutionSpecification EditParts contained in the Lifeline
	 * EditPart
	 * 
	 * @return the list of ExecutionSpecification EditParts
	 */
	public static List<ShapeNodeEditPart> getChildShapeNodeEditPart(LifelineEditPart lifeline) {
		if(lifeline == null) {
			return Collections.emptyList();
		}
		List<ShapeNodeEditPart> executionSpecificationList = new ArrayList<ShapeNodeEditPart>();
		for(Object obj : lifeline.getChildren()) {
			if(obj instanceof BehaviorExecutionSpecificationEditPart) {
				executionSpecificationList.add((ShapeNodeEditPart)obj);
			} else if(obj instanceof ActionExecutionSpecificationEditPart) {
				executionSpecificationList.add((ShapeNodeEditPart)obj);
			} else if(obj instanceof CombinedFragment2EditPart) {
				executionSpecificationList.add((ShapeNodeEditPart)obj);
			}
		}
		return executionSpecificationList;
	}

	/**
	 * This operation returns the InnerConnectableElement EditParts contained in the Lifeline
	 * EditPart
	 * 
	 * @return the list of InnerConnectableElement EditParts
	 */
	public static List<LifelineEditPart> getInnerConnectableElementList(LifelineEditPart lifeline) {
		if(lifeline == null) {
			return Collections.emptyList();
		}
		List<LifelineEditPart> propertyList = new ArrayList<LifelineEditPart>();
		for(Object obj : lifeline.getChildren()) {
			if(obj instanceof LifelineEditPart) {
				propertyList.add((LifelineEditPart)obj);
			}
		}
		return propertyList;
	}

	public static NodeFigure getNodeFigure(LifelineEditPart lifelineEditPart) {
		if(lifelineEditPart == null) {
			return null;
		}
		IFigure contentPane = lifelineEditPart.getContentPane();
		NodeFigure centerFigure = null;
		if(contentPane instanceof LifelineDotLineCustomFigure) {
			return ((LifelineDotLineCustomFigure)contentPane).getDashLineRectangle();
		}
		return null;
	}

	/**
	 * Constructor.
	 * 
	 */
	private LifelineEditPartUtil() {
	}
}
