/*****************************************************************************
 * Copyright (c) 2011 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity.draw2d;

import org.eclipse.draw2d.Border;
import org.eclipse.draw2d.FlowLayout;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LayoutManager;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gmf.runtime.diagram.ui.util.MeasurementUnitHelper;
import org.eclipse.gmf.runtime.draw2d.ui.figures.GravityConstrainedFlowLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.GravityDirectionType;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;
import org.eclipse.gmf.runtime.notation.MeasurementUnit;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.uml.diagram.activity.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.uml.diagram.activity.preferences.IActivityPreferenceConstants;
import org.eclipse.papyrus.uml.diagram.common.draw2d.RoundedRectangleDashedBorder;
import org.eclipse.papyrus.uml.diagram.common.figure.node.PapyrusRoundedNodeFigure;
import org.eclipse.swt.graphics.Color;

/**
 * Figure for structured activity node and its derived element
 * 
 * @author arthur daussy
 * 
 */
public class StructuredActivityNodeFigure extends PapyrusRoundedNodeFigure {

	/**
	 * Since the Activity diagram is using Pixel unit we can use this as constant
	 */
	private static IMapMode mapNode = MeasurementUnitHelper.getMapMode(MeasurementUnit.PIXEL_LITERAL);

	/**
	 * Compartment for activity node
	 */
	private RoundedRectangle fStructuredActivityNodeCompartment;

	/**
	 * Compartment for label
	 */
	private RoundedRectangle fFigureCompartmentLabelStructuredActivityNode;

	/**
	 * Preferences Store
	 */
	protected IPreferenceStore store = UMLDiagramEditorPlugin.getInstance().getPreferenceStore();

	/**
	 * Constructor
	 */
	public StructuredActivityNodeFigure() {
		super();
		corner = 8;
		this.shadowborder = createBorder0();
		setBorder(getBorderedFigure(), this.shadowborder);
		createContentPane();
	}

	@Override
	protected Border getDefaultBorder(Color borderColor) {
		return createBorder0();
	}

	/**
	 * Custom border (Used to avoid the alpha setting affect the border)
	 * 
	 * @return
	 */
	private org.eclipse.draw2d.LineBorder createBorder0() {
		RoundedRectangleDashedBorder result = new RoundedRectangleDashedBorder(8, 8);
		result.setWidth(1);
		result.setStyle(Graphics.LINE_DASH);
		return result;
	}

	@Override
	public LayoutManager getLayoutManager() {
		FlowLayoutAdvanced layoutThis = new FlowLayoutAdvanced();
		layoutThis.setStretchMinorAxis(true);
		layoutThis.setMinorAlignment(FlowLayout.ALIGN_CENTER);
		layoutThis.setMajorAlignment(FlowLayout.ALIGN_TOPLEFT);
		layoutThis.setMajorSpacing(0);
		layoutThis.setMinorSpacing(0);
		layoutThis.setHorizontal(false);
		return layoutThis;
	}

	/**
	 * Create compartment for activity node
	 */
	protected void createContentPane() {
		/*
		 * Compartment
		 */
		this.setLayoutManager(getLayoutManager());
		fStructuredActivityNodeCompartment = new RoundedRectangle();
		fStructuredActivityNodeCompartment.setCornerDimensions(new Dimension(mapNode.DPtoLP(8), mapNode.DPtoLP(8)));
		fStructuredActivityNodeCompartment.setFill(false);
		fStructuredActivityNodeCompartment.setOutline(false);
		fStructuredActivityNodeCompartment.setLineWidth(0);
		FlowLayoutAdvancedConstraint constraintFStructuredActivityNodeCompartment = new FlowLayoutAdvancedConstraint();
		constraintFStructuredActivityNodeCompartment.setFull(true);
		this.add(fStructuredActivityNodeCompartment, constraintFStructuredActivityNodeCompartment);
	}

	@Override
	protected Object getDefaultLabelsConstraint() {
		GravityConstrainedFlowLayout layoutFFigureCompartmentLabelStructuredActivityNode = new GravityConstrainedFlowLayout();
		layoutFFigureCompartmentLabelStructuredActivityNode.setGravity(GravityDirectionType.WEST);
		fFigureCompartmentLabelStructuredActivityNode.setLayoutManager(layoutFFigureCompartmentLabelStructuredActivityNode);
		return super.getDefaultLabelsConstraint();
	}

	@Override
	protected Object getNameLabelConstraint() {
		GravityConstrainedFlowLayoutConstraint constraintFKeyword = new GravityConstrainedFlowLayoutConstraint();
		constraintFKeyword.setAlign(GravityConstrainedFlowLayout.ALIGN_TOPLEFT);
		return constraintFKeyword;
	}

	@Override
	protected IFigure getDefaultLabelsContainer() {
		if(fFigureCompartmentLabelStructuredActivityNode == null) {
			fFigureCompartmentLabelStructuredActivityNode = new RoundedRectangle();
			fFigureCompartmentLabelStructuredActivityNode.setCornerDimensions(new Dimension(mapNode.DPtoLP(8), mapNode.DPtoLP(8)));
			fFigureCompartmentLabelStructuredActivityNode.setFill(false);
			fFigureCompartmentLabelStructuredActivityNode.setOutline(false);
			fFigureCompartmentLabelStructuredActivityNode.setLineWidth(0);
			FlowLayoutAdvancedConstraint constraintFFigureCompartmentLabelStructuredActivityNode = new FlowLayoutAdvancedConstraint();
			constraintFFigureCompartmentLabelStructuredActivityNode.setHasMinsize(true);
			this.add(fFigureCompartmentLabelStructuredActivityNode, constraintFFigureCompartmentLabelStructuredActivityNode);
			GravityConstrainedFlowLayout layoutFFigureCompartmentLabelStructuredActivityNode = new GravityConstrainedFlowLayout();
			layoutFFigureCompartmentLabelStructuredActivityNode.setGravity(GravityDirectionType.WEST);
			layoutFFigureCompartmentLabelStructuredActivityNode.setSpacing(10);
			fFigureCompartmentLabelStructuredActivityNode.setLayoutManager(layoutFFigureCompartmentLabelStructuredActivityNode);
		}
		return fFigureCompartmentLabelStructuredActivityNode;
	}

	/**
	 * Override in order to use alpha component
	 */
	@Override
	public void paintFigure(Graphics graphics) {
		int transparency = getTransparency();
		if(transparency == 0) {
			transparency = UMLDiagramEditorPlugin.getInstance().getPreferenceStore().getInt(IActivityPreferenceConstants.PREF_STRUCTURED_NODE_ALPHA);
		} else {
			transparency = 100 - getTransparency();
		}
		graphics.setAlpha(transparency);
		super.paintFigure(graphics);
	}

	/**
	 * Compartment for activity node
	 */
	public RoundedRectangle getStructuredActivityNodeCompartment() {
		return fStructuredActivityNodeCompartment;
	}

	/**
	 * Get the keywork compartment
	 * 
	 * @return
	 */
	public WrappingLabel getKeyword() {
		return getNameLabel();
	}
}
