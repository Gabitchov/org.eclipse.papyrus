/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *  Emilien Perico (Atos Origin) - adapt class for use case association
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.usecase.figure;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.PolylineDecoration;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.papyrus.uml.diagram.common.figure.edge.UMLEdgeFigure;
import org.eclipse.swt.SWT;

/**
 * this is the figure to display a association figure.
 */
public class AssociationFigure extends UMLEdgeFigure {

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

	/** The f role source label. */
	private WrappingLabel fRoleSourceLabel;

	/** The f role target label. */
	private WrappingLabel fRoleTargetLabel;

	/** Source decoration type */
	private int sourceType;

	/** Target decoration type */
	private int targetType;

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
	 * Creates the contents of the association
	 */
	protected void createContents() {
		super.createContents();
		fAssociationNameLabel = new WrappingLabel();
		fAssociationNameLabel.setText("");
		this.add(fAssociationNameLabel);
		fMultiplicitySourceLabel = new WrappingLabel();
		fMultiplicitySourceLabel.setText("");
		this.add(fMultiplicitySourceLabel);
		fMultiplicityTargetLabel = new WrappingLabel();
		fMultiplicityTargetLabel.setText("");
		this.add(fMultiplicityTargetLabel);
		fRoleSourceLabel = new WrappingLabel();
		fRoleSourceLabel.setText("");
		this.add(fRoleSourceLabel);
		fRoleTargetLabel = new WrappingLabel();
		fRoleTargetLabel.setText("");
		this.add(fRoleTargetLabel);
	}

	/**
	 * Gets the decoration.
	 * 
	 * @param typeDecoration
	 *        the type decoration
	 * 
	 * @return the appropriate decoration
	 */
	public RotatableDecoration getDecoration(int typeDecoration) {
		int remain = typeDecoration % owned;
		int navigationValue = remain / navigable;
		if(navigationValue == 1) {
			return getNavigationDecoration();
		}
		return null;
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

	/**
	 * @generated
	 */
	public WrappingLabel getAssociationNameLabel() {
		return fAssociationNameLabel;
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
}
