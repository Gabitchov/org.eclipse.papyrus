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
 *   Atos Origin - Initial API and implementation
 *	 Arthur Daussy - 372745: [ActivityDiagram] Major refactoring group framework
 *****************************************************************************/
package org.eclipse.papyrus.diagram.activity.figures;

import java.util.Collections;
import java.util.List;

import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.papyrus.diagram.common.figure.node.CompartmentFigure;

/**
 * Figure an activity partition
 */
public class ActivityPartitionFigure extends CompartmentFigure {

	private static final String ACTIVITY_CONTENT_COMPARTMENT = "ActivityContentCompartment";


	public ActivityPartitionFigure(List<String> compartmentFigure) {
		super(compartmentFigure);
	}
	
	public ActivityPartitionFigure() {
		super(Collections.singletonList(ACTIVITY_CONTENT_COMPARTMENT));
//		this.setFocusTraversable(true);
		this.setOpaque(true);
		/**
		 * TODO use transparency
		 */
		setTransparency(50);
		getActivityPartitionCompartment().setOpaque(true);
		
	}

//	public ActivityPartitionDescriptor() {
//		PileLayout layoutThis = new PileLayout();
//		layoutThis.setStretchBottom(true);
////		layoutThis.setStretchMinorAxis(true);
////		layoutThis.setMinorAlignment(FlowLayout.ALIGN_CENTER);
////		layoutThis.setMajorAlignment(FlowLayout.ALIGN_TOPLEFT);
////		layoutThis.setMajorSpacing(0);
////		layoutThis.setMinorSpacing(0);
////		layoutThis.setHorizontal(false);
//		this.setFill(false);
//		this.setLayoutManager(layoutThis);
//		this.setOutline(false);
//		this.setBorder(createBorder0());
//		createContents();
//	}


//	private void createContents() {
//		fFigureCompartmentLabelActivityPartition = new RectangleFigure();
//		fFigureCompartmentLabelActivityPartition.setOutline(false);
//		fFigureCompartmentLabelActivityPartition.setLineWidth(0);
//		fFigureCompartmentLabelActivityPartition.setBorder(createBorder1());
//		FlowLayoutAdvancedConstraint constraintFFigureCompartmentLabelActivityPartition = new FlowLayoutAdvancedConstraint();
//		constraintFFigureCompartmentLabelActivityPartition.setHasMinsize(true);
//		this.add(fFigureCompartmentLabelActivityPartition, constraintFFigureCompartmentLabelActivityPartition);
//		FlowLayout layoutFFigureCompartmentLabelActivityPartition = new FlowLayout();
//		layoutFFigureCompartmentLabelActivityPartition.setStretchMinorAxis(true);
//		layoutFFigureCompartmentLabelActivityPartition.setMinorAlignment(FlowLayout.ALIGN_CENTER);
//		layoutFFigureCompartmentLabelActivityPartition.setMajorAlignment(FlowLayout.ALIGN_CENTER);
//		layoutFFigureCompartmentLabelActivityPartition.setMajorSpacing(0);
//		layoutFFigureCompartmentLabelActivityPartition.setMinorSpacing(0);
//		layoutFFigureCompartmentLabelActivityPartition.setHorizontal(true);
//		fFigureCompartmentLabelActivityPartition.setLayoutManager(layoutFFigureCompartmentLabelActivityPartition);
//		fPartitionLabel = new CenteredWrappedLabel();
//		fFigureCompartmentLabelActivityPartition.add(fPartitionLabel);
//		fActivityPartitionCompartment = new RectangleFigure();
//		fActivityPartitionCompartment.setFill(false);
//		fActivityPartitionCompartment.setOutline(false);
//		fActivityPartitionCompartment.setLineWidth(0);
//		FlowLayoutAdvancedConstraint constraintFActivityPartitionCompartment = new FlowLayoutAdvancedConstraint();
//		
////		fActivityPartitionCompartment.setFocusTraversable(true);
////		fActivityPartitionCompartment.setRequestFocusEnabled(false);
//	
//		
//		constraintFActivityPartitionCompartment.setFill(true);
//		this.add(fActivityPartitionCompartment, constraintFActivityPartitionCompartment);
//	}


//	private Border createBorder0() {
//		LinesBorder result = new LinesBorder();
//		result.setSides(PositionConstants.TOP | PositionConstants.LEFT | PositionConstants.RIGHT);
//		return result;
//	}
//
//
//	private Border createBorder1() {
//		LinesBorder result = new LinesBorder();
//		result.setSides(PositionConstants.BOTTOM);
//		result.setLeftInset(5);
//		result.setRightInset(5);
//		result.setTopInset(5);
//		result.setBottomInset(5);
//		return result;
//	}


	public RectangleFigure getActivityPartitionCompartment() {
		return getCompartment(ACTIVITY_CONTENT_COMPARTMENT);
	}


	public WrappingLabel getPartitionLabel() {
		return getNameLabel();
	}
	
	


}
