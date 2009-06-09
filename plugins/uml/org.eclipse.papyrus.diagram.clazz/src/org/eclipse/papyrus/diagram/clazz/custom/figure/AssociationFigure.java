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
package org.eclipse.papyrus.diagram.clazz.custom.figure;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.PolygonDecoration;
import org.eclipse.draw2d.PolylineDecoration;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.swt.SWT;

/**
 * this is the figure to display a association figure.
 */

public class AssociationFigure extends PolylineConnectionEx {

	/**
	 * the end of the association is an aggregation i.e. this a transparent diamond.
	 */
	public static final int aggregation = 2;

	/**
	 * the end of the association is a composition so this a black diamond.
	 */
	public static final int composition = 4;

	/**
	 * the end of the association is navigable so this is an arrow.
	 */
	public static final int navigable = 1;

	/**
	 * the end of contained the property.
	 */
	public static final int owned = 8;

	/**
	 * @generated
	 */
	private WrappingLabel fAppliedStereotypeAssociationLabel;

	/**
	 * @generated
	 */
	private WrappingLabel fAssociationNameLabel;

	/**
	 * @generated
	 */
	private WrappingLabel fMultiplicitySourceLabel;

	/**
	 * @generated
	 */
	private WrappingLabel fMultiplicityTargetLabel;

	/**
	 * @generated
	 */
	private WrappingLabel fRoleSourceLabel;

	/**
	 * @generated
	 */
	private WrappingLabel fRoleTargetLabel;

	public AssociationFigure() {
		super();
		setAntialias(SWT.ON);
		createContents();
	}

	/**
	 * create an association figure.
	 * 
	 * @param targetType
	 *            the type of end of the association {@link AssociationFigure#navigable}
	 * @param sourceType
	 *            the type of end of the association {@link AssociationFigure#navigable}
	 */
	public AssociationFigure(int sourceType, int targetType) {
		super();
		this.setEnd(sourceType, targetType);
		createContents();
	}

	/**
	 * @generated
	 */
	private void createContents() {

		fAssociationNameLabel = new WrappingLabel();
		fAssociationNameLabel.setText("");

		this.add(fAssociationNameLabel);

		fAppliedStereotypeAssociationLabel = new WrappingLabel();
		fAppliedStereotypeAssociationLabel.setText("");

		this.add(fAppliedStereotypeAssociationLabel);

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

	protected RotatableDecoration getAggregationDecoration() {
		PolygonDecoration decoration = new PolygonDecoration();
		PointList decorationPointList = new PointList();
		decorationPointList.addPoint(0, 0);
		decorationPointList.addPoint(-2, 2);
		decorationPointList.addPoint(-4, 0);
		decorationPointList.addPoint(-2, -2);
		decoration.setTemplate(decorationPointList);
		decoration.setBackgroundColor(org.eclipse.draw2d.ColorConstants.white);
		decoration.setScale(3, 3);
		return decoration;
	}

	/**
	 * @generated
	 */
	public WrappingLabel getAppliedStereotypeAssociationLabel() {
		return fAppliedStereotypeAssociationLabel;
	}

	/**
	 * @generated
	 */
	public WrappingLabel getAssociationNameLabel() {
		return fAssociationNameLabel;
	}

	protected RotatableDecoration getCompositionDecoration() {
		PolygonDecoration decoration = new PolygonDecoration();
		PointList decorationPointList = new PointList();
		decorationPointList.addPoint(0, 0);
		decorationPointList.addPoint(-2, 2);
		decorationPointList.addPoint(-4, 0);
		decorationPointList.addPoint(-2, -2);
		decoration.setTemplate(decorationPointList);
		decoration.setScale(3, 3);
		return decoration;
	}

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
		if (ownedValue == 1) {
			// this is composite.
			if (compositeValue == 1) {
				if (navigationValue == 1) {
					return getOwnedNavigableCompositionDecoration();
				}
				return getOwnedCompositionDecoration();
			}
			// an aggregation?
			else if (aggregationValue == 1) {
				if (navigationValue == 1) {
					return getOwnedNavigableAggregationDecoration();
				}
				return getOwnedAggregationDecoration();
			}
			// Is it navigable?
			else if (navigationValue == 1) {
				return getOwnedNavigationDecoration();
			} else {
				return getOwnedDecoration();
			}
		}

		else {
			// this is composite.
			if (compositeValue == 1) {
				if (navigationValue == 1) {
					return getNavigableCompositionDecoration();
				}
				return getCompositionDecoration();
			}
			// an aggregation?
			else if (aggregationValue == 1) {
				if (navigationValue == 1) {
					return getNavigableAggregationDecoration();
				}
				return getAggregationDecoration();
			}
			// Is it naviagable?
			else if (navigationValue == 1) {
				return getNavigationDecoration();
			}
		}
		return null;

	}

	/**
	 * @generated
	 */
	public WrappingLabel getMultiplicitySourceLabel() {
		return fMultiplicitySourceLabel;
	}

	/**
	 * @generated
	 */
	public WrappingLabel getMultiplicityTargetLabel() {
		return fMultiplicityTargetLabel;
	}

	protected RotatableDecoration getNavigableAggregationDecoration() {
		PolygonDecoration decoration = new PolygonDecoration();
		PointList decorationPointList = new PointList();
		decorationPointList.addPoint(0, 0);
		decorationPointList.addPoint(-2, 2);
		decorationPointList.addPoint(-4, 0);
		decorationPointList.addPoint(-10, 2);
		decorationPointList.addPoint(-4, 0);
		decorationPointList.addPoint(-10, -2);
		decorationPointList.addPoint(-4, 0);
		decorationPointList.addPoint(-2, -2);
		decoration.setTemplate(decorationPointList);
		decoration.setBackgroundColor(org.eclipse.draw2d.ColorConstants.white);
		decoration.setScale(3, 3);
		return decoration;
	}

	protected RotatableDecoration getNavigableCompositionDecoration() {
		PolygonDecoration decoration = new PolygonDecoration();
		PointList decorationPointList = new PointList();
		decorationPointList.addPoint(0, 0);
		decorationPointList.addPoint(-2, 2);
		decorationPointList.addPoint(-4, 0);
		decorationPointList.addPoint(-10, 2);
		decorationPointList.addPoint(-4, 0);
		decorationPointList.addPoint(-10, -2);
		decorationPointList.addPoint(-4, 0);
		decorationPointList.addPoint(-2, -2);
		decoration.setTemplate(decorationPointList);
		decoration.setScale(3, 3);
		return decoration;
	}

	protected RotatableDecoration getNavigationDecoration() {
		PolylineDecoration dec = new PolylineDecoration();
		dec.setScale(15, 5);
		dec.setLineWidth(1);
		return dec;
	}

	protected RotatableDecoration getOwnedAggregationDecoration() {
		PolygonDecoration decoration = new PolygonDecoration();
		PointList decorationPointList = new PointList();
		decorationPointList.addPoint(0, 1);
		decorationPointList.addPoint(-2, 3);
		decorationPointList.addPoint(-4, 3);
		decorationPointList.addPoint(-6, 1);
		decorationPointList.addPoint(-6, 0);
		decorationPointList.addPoint(-12, 6);
		decorationPointList.addPoint(-18, 0);
		decorationPointList.addPoint(-12, -6);
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

		decoration.setScale(1, 1);
		decoration.setTemplate(decorationPointList);
		decoration.setBackgroundColor(org.eclipse.draw2d.ColorConstants.white);
		return decoration;
	}

	protected RotatableDecoration getOwnedCompositionDecoration() {
		PolygonDecoration decoration = new PolygonDecoration();
		PointList decorationPointList = new PointList();
		decorationPointList.addPoint(0, 1);
		decorationPointList.addPoint(-2, 3);
		decorationPointList.addPoint(-4, 3);
		decorationPointList.addPoint(-6, 1);
		decorationPointList.addPoint(-6, 0);
		decorationPointList.addPoint(-12, 6);
		decorationPointList.addPoint(-18, 0);
		decorationPointList.addPoint(-12, -6);
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

		decoration.setScale(1, 1);
		decoration.setTemplate(decorationPointList);
		return decoration;
	}

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

	protected RotatableDecoration getOwnedNavigableAggregationDecoration() {
		PolygonDecoration decoration = new PolygonDecoration();
		PointList decorationPointList = new PointList();
		decorationPointList.addPoint(0, 1);
		decorationPointList.addPoint(-2, 3);
		decorationPointList.addPoint(-4, 3);
		decorationPointList.addPoint(-6, 1);
		decorationPointList.addPoint(-6, 0);
		decorationPointList.addPoint(-12, 6);
		decorationPointList.addPoint(-18, 0);
		decorationPointList.addPoint(-36, 6);
		decorationPointList.addPoint(-18, 0);
		decorationPointList.addPoint(-36, -6);
		decorationPointList.addPoint(-18, 0);
		decorationPointList.addPoint(-12, -6);
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

		decoration.setScale(1, 1);
		decoration.setTemplate(decorationPointList);
		decoration.setBackgroundColor(org.eclipse.draw2d.ColorConstants.white);
		return decoration;
	}

	protected RotatableDecoration getOwnedNavigableCompositionDecoration() {
		PolygonDecoration decoration = new PolygonDecoration();
		PointList decorationPointList = new PointList();
		decorationPointList.addPoint(0, 1);
		decorationPointList.addPoint(-2, 3);
		decorationPointList.addPoint(-4, 3);
		decorationPointList.addPoint(-6, 1);
		decorationPointList.addPoint(-6, 0);
		decorationPointList.addPoint(-12, 6);
		decorationPointList.addPoint(-18, 0);
		decorationPointList.addPoint(-36, 6);
		decorationPointList.addPoint(-18, 0);
		decorationPointList.addPoint(-36, -6);
		decorationPointList.addPoint(-18, 0);
		decorationPointList.addPoint(-12, -6);
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

		decoration.setScale(1, 1);
		decoration.setTemplate(decorationPointList);
		return decoration;
	}

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
	 * @generated
	 */
	public WrappingLabel getRoleSourceLabel() {
		return fRoleSourceLabel;
	}

	/**
	 * @generated
	 */
	public WrappingLabel getRoleTargetLabel() {
		return fRoleTargetLabel;
	}

	/**
	 * @{inheritDoc
	 */
	public void paintFigure(Graphics graphics) {
		graphics.setAntialias(SWT.ON);
		super.paintFigure(graphics);

	}

	/**
	 * used to display end of the association.
	 * 
	 * @param targetType
	 *            the type of end of the association {@link AssociationFigure#navigable}
	 * @param sourceType
	 *            the type of end of the association {@link AssociationFigure#navigable}
	 */
	public void setEnd(int sourceType, int targetType) {

		this.setSourceDecoration(getDecoration(sourceType));
		this.setTargetDecoration(getDecoration(targetType));
	}
}
