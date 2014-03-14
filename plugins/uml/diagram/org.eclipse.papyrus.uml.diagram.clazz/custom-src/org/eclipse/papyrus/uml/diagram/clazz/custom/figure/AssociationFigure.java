/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.clazz.custom.figure;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.PolygonDecoration;
import org.eclipse.draw2d.PolylineDecoration;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.papyrus.uml.diagram.common.figure.edge.UMLEdgeFigure;
import org.eclipse.swt.SWT;

/**
 * this is the figure to display a association figure.
 */
public class AssociationFigure extends UMLEdgeFigure {

	/** the end of the association is an aggregation i.e. this a transparent diamond. */
	public static final int aggregation = 2;

	/** the end of the association is a composition so this a black diamond. */
	public static final int composition = 4;

	/** the end of the association is navigable so this is an arrow. */
	public static final int navigable = 1;

	/** the end of contained the property. */
	public static final int owned = 8;

	/** The association name label. */
	private WrappingLabel fAssociationNameLabel;

	/** The multiplicity source label. */
	private WrappingLabel fMultiplicitySourceLabel;

	/** The multiplicity target label. */
	private WrappingLabel fMultiplicityTargetLabel;

	/** The role source label. */
	private WrappingLabel fRoleSourceLabel;

	/** The role target label. */
	private WrappingLabel fRoleTargetLabel;

	/** Source decoration type */
	private int sourceType;

	/** Target decoration type */
	private int targetType;

	/**
	 * Instantiates a new association figure.
	 */
	public AssociationFigure() {
		super();
		setAntialias(SWT.ON);
		createContents();
	}

	/**
	 * create an association figure.
	 * 
	 * @param targetType
	 *        the type of end of the association {@link AssociationFigure#navigable}
	 * @param sourceType
	 *        the type of end of the association {@link AssociationFigure#navigable}
	 */
	public AssociationFigure(int sourceType, int targetType) {
		super();
		this.setEnd(sourceType, targetType);
		createContents();
	}

	/**
	 * Creates the contents.
	 */
	protected void createContents() {
		super.createContents();
		fAssociationNameLabel = new WrappingLabel();
		fAssociationNameLabel.setText("");
		this.add(fAssociationNameLabel);
		// fAppliedStereotypeAssociationLabel = new WrappingLabel();
		// fAppliedStereotypeAssociationLabel.setText("");
		//
		// this.add(fAppliedStereotypeAssociationLabel);
		fRoleSourceLabel = new WrappingLabel();
		fRoleSourceLabel.setText("");
		this.add(fRoleSourceLabel);
		fMultiplicitySourceLabel = new WrappingLabel();
		fMultiplicitySourceLabel.setText("");
		this.add(fMultiplicitySourceLabel);
		fRoleTargetLabel = new WrappingLabel();
		fRoleTargetLabel.setText("");
		this.add(fRoleTargetLabel);
		fMultiplicityTargetLabel = new WrappingLabel();
		fMultiplicityTargetLabel.setText("");
		this.add(fMultiplicityTargetLabel);
	}

	/**
	 * Gets the aggregation decoration.
	 * 
	 * @return the aggregation decoration
	 */
	protected RotatableDecoration getAggregationDecoration() {
		PolygonDecoration decoration = new PolygonDecoration();
		PointList decorationPointList = new PointList();
		decorationPointList.addPoint(0, 0);
		decorationPointList.addPoint(-2, 2);
		decorationPointList.addPoint(-4, 0);
		decorationPointList.addPoint(-2, -2);
		decoration.setTemplate(decorationPointList);
		decoration.setBackgroundColor(org.eclipse.draw2d.ColorConstants.white);
		decoration.setScale(4, 2);
		return decoration;
	}

	/**
	 * Gets the applied stereotype association label.
	 * 
	 * @return the applied stereotype association label
	 */
	public WrappingLabel getAppliedStereotypeAssociationLabel() {
		return appliedStereotypeLabel;
	}

	/**
	 * Gets the association name label.
	 * 
	 * @return the association name label
	 */
	public WrappingLabel getAssociationNameLabel() {
		return fAssociationNameLabel;
	}

	/**
	 * Gets the composition decoration.
	 * 
	 * @return the composition decoration
	 */
	protected RotatableDecoration getCompositionDecoration() {
		PolygonDecoration decoration = new PolygonDecoration();
		PointList decorationPointList = new PointList();
		decorationPointList.addPoint(0, 0);
		decorationPointList.addPoint(-2, 2);
		decorationPointList.addPoint(-4, 0);
		decorationPointList.addPoint(-2, -2);
		decoration.setTemplate(decorationPointList);
		decoration.setScale(4, 2);
		return decoration;
	}

	/**
	 * Gets the decoration.
	 * 
	 * @param typeDecoration
	 *        the type decoration
	 * 
	 * @return the decoration
	 */
	public RotatableDecoration getDecoration(int typeDecoration) {
		// test if this a owned decoration
		int ownedValue = typeDecoration / owned;
		int remain = typeDecoration % owned;
		int compositeValue = remain / composition;
		remain = remain % composition;
		int aggregationValue = remain / aggregation;
		remain = remain % aggregation;
		int navigationValue = remain / navigable;
		// the end association is contained by the association?
		if(ownedValue == 1) {
			// this is composite.
			if(compositeValue == 1) {
				if(navigationValue == 1) {
					return getOwnedNavigableCompositionDecoration();
				}
				return getOwnedCompositionDecoration();
			}
			// an aggregation?
			else if(aggregationValue == 1) {
				if(navigationValue == 1) {
					return getOwnedNavigableAggregationDecoration();
				}
				return getOwnedAggregationDecoration();
			}
			// Is it navigable?
			else if(navigationValue == 1) {
				return getOwnedNavigationDecoration();
			} else {
				return getOwnedDecoration();
			}
		} else {
			// this is composite.
			if(compositeValue == 1) {
				if(navigationValue == 1) {
					return getNavigableCompositionDecoration();
				}
				return getCompositionDecoration();
			}
			// an aggregation?
			else if(aggregationValue == 1) {
				if(navigationValue == 1) {
					return getNavigableAggregationDecoration();
				}
				return getAggregationDecoration();
			}
			// Is it naviagable?
			else if(navigationValue == 1) {
				return getNavigationDecoration();
			}
		}
		return null;
	}

	/**
	 * Gets the multiplicity source label.
	 * 
	 * @return the multiplicity source label
	 */
	public WrappingLabel getMultiplicitySourceLabel() {
		return fMultiplicitySourceLabel;
	}

	/**
	 * Gets the multiplicity target label.
	 * 
	 * @return the multiplicity target label
	 */
	public WrappingLabel getMultiplicityTargetLabel() {
		return fMultiplicityTargetLabel;
	}

	/**
	 * Gets the navigable aggregation decoration.
	 * 
	 * @return the navigable aggregation decoration
	 */
	protected RotatableDecoration getNavigableAggregationDecoration() {
		PolygonDecoration decoration = new PolygonDecoration();
		PointList decorationPointList = new PointList();
		decorationPointList.addPoint(0, 0);
		decorationPointList.addPoint(-3, 2);
		decorationPointList.addPoint(-6, 0);
		decorationPointList.addPoint(-12, 2);
		decorationPointList.addPoint(-6, 0);
		decorationPointList.addPoint(-12, -2);
		decorationPointList.addPoint(-6, 0);
		decorationPointList.addPoint(-3, -2);
		decoration.setTemplate(decorationPointList);
		decoration.setBackgroundColor(org.eclipse.draw2d.ColorConstants.white);
		decoration.setScale(1, 1);
		return decoration;
	}

	/**
	 * Gets the navigable composition decoration.
	 * 
	 * @return the navigable composition decoration
	 */
	protected RotatableDecoration getNavigableCompositionDecoration() {
		PolygonDecoration decoration = new PolygonDecoration();
		PointList decorationPointList = new PointList();
		decorationPointList.addPoint(0, 0);
		decorationPointList.addPoint(-3, 2);
		decorationPointList.addPoint(-6, 0);
		decorationPointList.addPoint(-12, 2);
		decorationPointList.addPoint(-6, 0);
		decorationPointList.addPoint(-12, -2);
		decorationPointList.addPoint(-6, 0);
		decorationPointList.addPoint(-3, -2);
		decoration.setTemplate(decorationPointList);
		decoration.setScale(1, 1);
		return decoration;
	}

	/**
	 * Gets the navigation decoration.
	 * 
	 * @return the navigation decoration
	 */
	protected RotatableDecoration getNavigationDecoration() {
		PolylineDecoration dec = new PolylineDecoration();
		dec.setScale(15, 5);
		dec.setLineWidth(1);
		return dec;
	}

	/**
	 * Gets the owned aggregation decoration.
	 * 
	 * @return the owned aggregation decoration
	 */
	protected RotatableDecoration getOwnedAggregationDecoration() {
		PolygonDecoration decoration = new PolygonDecoration();
		PointList decorationPointList = new PointList();
		decorationPointList.addPoint(0, 1);
		decorationPointList.addPoint(-2, 3);
		decorationPointList.addPoint(-4, 3);
		decorationPointList.addPoint(-6, 1);
		decorationPointList.addPoint(-6, 0);
		decorationPointList.addPoint(-15, 6);
		decorationPointList.addPoint(-24, 0);
		decorationPointList.addPoint(-15, -6);
		decorationPointList.addPoint(-6, 0);
		decorationPointList.addPoint(-6, -1);
		decorationPointList.addPoint(-4, -3);
		decorationPointList.addPoint(-2, -3);
		decorationPointList.addPoint(0, -1); // color Point
		decorationPointList.addPoint(-1, -1);
		decorationPointList.addPoint(-1, 1);
		decorationPointList.addPoint(-2, 3);
		decorationPointList.addPoint(-2, -3);
		decorationPointList.addPoint(-3, -3);
		decorationPointList.addPoint(-3, 3);
		decorationPointList.addPoint(-4, 3);
		decorationPointList.addPoint(-4, -3);
		decorationPointList.addPoint(-5, -2);
		decorationPointList.addPoint(-5, 2);
		decorationPointList.addPoint(-6, 1);
		decorationPointList.addPoint(-6, -1);
		decoration.setScale(3, 2);
		decoration.setTemplate(decorationPointList);
		decoration.setBackgroundColor(org.eclipse.draw2d.ColorConstants.white);
		return decoration;
	}

	/**
	 * Gets the owned composition decoration.
	 * 
	 * @return the owned composition decoration
	 */
	protected RotatableDecoration getOwnedCompositionDecoration() {
		PolygonDecoration decoration = new PolygonDecoration();
		PointList decorationPointList = new PointList();
		decorationPointList.addPoint(0, 1);
		decorationPointList.addPoint(-2, 3);
		decorationPointList.addPoint(-4, 3);
		decorationPointList.addPoint(-6, 1);
		decorationPointList.addPoint(-6, 0);
		decorationPointList.addPoint(-15, 6);
		decorationPointList.addPoint(-24, 0);
		decorationPointList.addPoint(-15, -6);
		decorationPointList.addPoint(-6, 0);
		decorationPointList.addPoint(-6, -1);
		decorationPointList.addPoint(-4, -3);
		decorationPointList.addPoint(-2, -3);
		decorationPointList.addPoint(0, -1); // color Point
		// decorationPointList.addPoint(-1, -1);
		// decorationPointList.addPoint(-1, 1);
		// decorationPointList.addPoint(-2, 3);
		// decorationPointList.addPoint(-2, -3);
		// decorationPointList.addPoint(-3, -3);
		// decorationPointList.addPoint(-3, 3);
		// decorationPointList.addPoint(-4, 3);
		// decorationPointList.addPoint(-4, -3);
		// decorationPointList.addPoint(-5, -2);
		// decorationPointList.addPoint(-5, 2);
		// decorationPointList.addPoint(-6, 1);
		// decorationPointList.addPoint(-6, -1);
		decoration.setScale(3, 2);
		decoration.setTemplate(decorationPointList);
		return decoration;
	}

	/**
	 * Gets the owned decoration.
	 * 
	 * @return the owned decoration
	 */
	protected RotatableDecoration getOwnedDecoration() {
		PolygonDecoration decoration = new PolygonDecoration();
		PointList decorationPointList = new PointList();
		decorationPointList.addPoint(0, 1);
		decorationPointList.addPoint(-2, 3);
		decorationPointList.addPoint(-4, 3);
		decorationPointList.addPoint(-6, 1);
		decorationPointList.addPoint(-6, -1);
		decorationPointList.addPoint(-4, -3);
		decorationPointList.addPoint(-2, -3);
		decorationPointList.addPoint(0, -1);
		decoration.setTemplate(decorationPointList);
		decoration.setScale(1, 1);
		return decoration;
	}

	/**
	 * Gets the owned navigable aggregation decoration.
	 * 
	 * @return the owned navigable aggregation decoration
	 */
	protected RotatableDecoration getOwnedNavigableAggregationDecoration() {
		PolygonDecoration decoration = new PolygonDecoration();
		PointList decorationPointList = new PointList();
		decorationPointList.addPoint(0, 1);
		decorationPointList.addPoint(-2, 3);
		decorationPointList.addPoint(-4, 3);
		decorationPointList.addPoint(-6, 1);
		decorationPointList.addPoint(-6, 0);
		decorationPointList.addPoint(-15, 5);
		decorationPointList.addPoint(-24, 0);
		decorationPointList.addPoint(-40, 5);
		decorationPointList.addPoint(-24, 0);
		decorationPointList.addPoint(-40, -5);
		decorationPointList.addPoint(-24, 0);
		decorationPointList.addPoint(-15, -5);
		decorationPointList.addPoint(-6, 0);
		decorationPointList.addPoint(-6, -1);
		decorationPointList.addPoint(-4, -3);
		decorationPointList.addPoint(-2, -3);
		decorationPointList.addPoint(0, -1); // color Point
		decorationPointList.addPoint(-1, -1);
		decorationPointList.addPoint(-1, -1);
		decorationPointList.addPoint(-1, 1);
		decorationPointList.addPoint(-2, 3);
		decorationPointList.addPoint(-2, -3);
		decorationPointList.addPoint(-3, -3);
		decorationPointList.addPoint(-3, 3);
		decorationPointList.addPoint(-4, 3);
		decorationPointList.addPoint(-4, -3);
		decorationPointList.addPoint(-5, -2);
		decorationPointList.addPoint(-5, 2);
		decorationPointList.addPoint(-6, 1);
		decorationPointList.addPoint(-6, -1);
		decoration.setScale(1, 0.75);
		decoration.setTemplate(decorationPointList);
		decoration.setBackgroundColor(org.eclipse.draw2d.ColorConstants.white);
		return decoration;
	}

	/**
	 * Gets the owned navigable composition decoration.
	 * 
	 * @return the owned navigable composition decoration
	 */
	protected RotatableDecoration getOwnedNavigableCompositionDecoration() {
		PolygonDecoration decoration = new PolygonDecoration();
		PointList decorationPointList = new PointList();
		decorationPointList.addPoint(0, 1);
		decorationPointList.addPoint(-2, 3);
		decorationPointList.addPoint(-4, 3);
		decorationPointList.addPoint(-6, 1);
		decorationPointList.addPoint(-6, 0);
		decorationPointList.addPoint(-15, 6);
		decorationPointList.addPoint(-24, 0);
		decorationPointList.addPoint(-40, 8);
		decorationPointList.addPoint(-24, 0);
		decorationPointList.addPoint(-40, -8);
		decorationPointList.addPoint(-24, 0);
		decorationPointList.addPoint(-15, -6);
		decorationPointList.addPoint(-6, 0);
		decorationPointList.addPoint(-6, -1);
		decorationPointList.addPoint(-4, -3);
		decorationPointList.addPoint(-2, -3);
		decorationPointList.addPoint(0, -1); // color Point
		// decorationPointList.addPoint(-1, -1);
		// decorationPointList.addPoint(-1, 1);
		// decorationPointList.addPoint(-2, 3);
		// decorationPointList.addPoint(-2, -3);
		// decorationPointList.addPoint(-3, -3);
		// decorationPointList.addPoint(-3, 3);
		// decorationPointList.addPoint(-4, 3);
		// decorationPointList.addPoint(-4, -3);
		// decorationPointList.addPoint(-5, -2);
		// decorationPointList.addPoint(-5, 2);
		// decorationPointList.addPoint(-6, 1);
		// decorationPointList.addPoint(-6, -1);
		decoration.setScale(1, 0.75);
		decoration.setTemplate(decorationPointList);
		return decoration;
	}

	/**
	 * Gets the owned navigation decoration.
	 * 
	 * @return the owned navigation decoration
	 */
	protected RotatableDecoration getOwnedNavigationDecoration() {
		PolygonDecoration decoration = new PolygonDecoration();
		PointList decorationPointList = new PointList();
		decorationPointList.addPoint(0, 1);
		decorationPointList.addPoint(-2, 3);
		decorationPointList.addPoint(-4, 3);
		decorationPointList.addPoint(-6, 1);
		decorationPointList.addPoint(-6, 0);
		decorationPointList.addPoint(-18, 6);
		decorationPointList.addPoint(-6, 0);
		decorationPointList.addPoint(-18, -6);
		decorationPointList.addPoint(-6, 0);
		decorationPointList.addPoint(-6, -1);
		decorationPointList.addPoint(-4, -3);
		decorationPointList.addPoint(-2, -3);
		decorationPointList.addPoint(0, -1);
		decoration.setScale(1, 1);
		decoration.setTemplate(decorationPointList);
		return decoration;
	}

	/**
	 * Gets the role source label.
	 * 
	 * @return the role source label
	 */
	public WrappingLabel getRoleSourceLabel() {
		return fRoleSourceLabel;
	}

	/**
	 * Gets the role target label.
	 * 
	 * @return the role target label
	 */
	public WrappingLabel getRoleTargetLabel() {
		return fRoleTargetLabel;
	}

	/**
	 * {@inheritedDoc}
	 */
	public void paintFigure(Graphics graphics) {
		graphics.setAntialias(SWT.ON);
		super.paintFigure(graphics);
	}

	/**
	 * used to display end of the association.
	 * 
	 * @param targetType
	 *        the type of end of the association {@link AssociationFigure#navigable}
	 * @param sourceType
	 *        the type of end of the association {@link AssociationFigure#navigable}
	 */
	public void setEnd(int sourceType, int targetType) {
		this.sourceType = sourceType;
		this.targetType = targetType;
		this.setSourceDecoration(getDecoration(sourceType));
		this.setTargetDecoration(getDecoration(targetType));
	}

	@Override
	public void resetStyle() {
		super.resetStyle();
		setSourceDecoration(getDecoration(sourceType));
		setTargetDecoration(getDecoration(targetType));
	}
}
