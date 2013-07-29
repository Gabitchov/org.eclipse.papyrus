/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.common.edit.part;

import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.figures.IBorderItemLocator;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.infra.emf.appearance.helper.NameLabelIconHelper;
import org.eclipse.papyrus.sysml.diagram.common.Activator;
import org.eclipse.papyrus.uml.diagram.common.edit.part.AbstractElementLabelEditPart;
import org.eclipse.papyrus.uml.diagram.common.figure.node.PapyrusWrappingLabel;
import org.eclipse.papyrus.uml.diagram.common.util.DiagramEditPartsUtil;
import org.eclipse.swt.graphics.Image;

/**
 * This class implements a FlowPort affixed label edit part.
 */
public class FlowPortAffixedLabelNameEditPart extends AbstractElementLabelEditPart implements IBorderItemEditPart {

	/** label provider for icons */
	private final ILabelProvider labelProvider;

	/** Constructor */
	public FlowPortAffixedLabelNameEditPart(View view) {
		super(view);
		addSnapBackLocation();
		labelProvider = Activator.getInstance().getLabelProvider();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
	}

	public IBorderItemLocator getBorderItemLocator() {
		IFigure parentFigure = getFigure().getParent();
		if(parentFigure != null && parentFigure.getLayoutManager() != null) {
			Object constraint = parentFigure.getLayoutManager().getConstraint(getFigure());
			return (IBorderItemLocator)constraint;
		}
		return null;
	}

	@Override
	public void refreshBounds() {
		int x = ((Integer)getStructuralFeatureValue(NotationPackage.eINSTANCE.getLocation_X())).intValue();
		int y = ((Integer)getStructuralFeatureValue(NotationPackage.eINSTANCE.getLocation_Y())).intValue();
		int width = ((Integer)getStructuralFeatureValue(NotationPackage.eINSTANCE.getSize_Width())).intValue();
		int height = ((Integer)getStructuralFeatureValue(NotationPackage.eINSTANCE.getSize_Height())).intValue();

		// Update locator constraint
		IBorderItemLocator locator = getBorderItemLocator();
		locator.setConstraint(new Rectangle(x, y, width, height));

		// Set new constraint on parent figure
		getFigure().getParent().setConstraint(getFigure(), locator);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Image getLabelIcon() {
		EObject parserElement = getParserElement();
		if(parserElement == null) {
			return null;
		}

		List<View> views = DiagramEditPartsUtil.findViews(parserElement, getViewer());
		for(View view : views) {
			if(NameLabelIconHelper.showLabelIcon(view)) {
				return labelProvider.getImage(parserElement);
			}
		}

		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected IFigure createFigure() {
		IFigure label = createFigurePrim();
		defaultText = getLabelTextHelper(label);
		return label;
	}

	protected IFigure createFigurePrim() {
		return new PapyrusWrappingLabel();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getLabelRole() {
		return "Label"; //$NON-NLS-1$
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getIconPathRole() {
		return ""; //$NON-NLS-1$
	}
}
