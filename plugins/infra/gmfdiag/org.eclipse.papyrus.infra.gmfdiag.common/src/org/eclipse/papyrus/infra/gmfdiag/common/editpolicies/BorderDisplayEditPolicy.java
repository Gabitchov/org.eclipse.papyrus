/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
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
package org.eclipse.papyrus.infra.gmfdiag.common.editpolicies;

import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.draw2d.Border;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ResizableCompartmentEditPart;
import org.eclipse.gmf.runtime.draw2d.ui.figures.OneLineBorder;
import org.eclipse.gmf.runtime.gef.ui.internal.editpolicies.GraphicalEditPolicyEx;
import org.eclipse.gmf.runtime.notation.BooleanValueStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.gmfdiag.common.databinding.custom.CustomBooleanStyleObservableValue;
import org.eclipse.papyrus.infra.gmfdiag.common.editpart.IPapyrusEditPart;

/**
 * this edit policy has in charge to display the border of node NodeNamedElement
 * associated figure has to be a {@link NodeNamedElementFigure}
 */
public class BorderDisplayEditPolicy extends GraphicalEditPolicyEx implements IChangeListener {

	public static final String DISPLAY_BORDER = "displayBorder";

	/** key for this edit policy */
	public final static String BORDER_DISPLAY_EDITPOLICY = "BORDER_DISPLAY_EDITPOLICY";

	protected IObservableValue styleObservable;

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public void activate() {
		// retrieve the view and the element managed by the edit part
		View view = (View)getHost().getModel();
		if(view == null) {
			return;
		}

		styleObservable = new CustomBooleanStyleObservableValue(view, EMFHelper.resolveEditingDomain(view), DISPLAY_BORDER);
		styleObservable.addChangeListener(this);

		getHost().refresh();
	}


	/**
	 * 
	 * @param currentView
	 * @return the current Style that reperesent the boder
	 */
	protected BooleanValueStyle getMaintainSymbolRatioStyle(View currentView) {
		return (BooleanValueStyle)currentView.getNamedStyle(NotationPackage.eINSTANCE.getBooleanValueStyle(), DISPLAY_BORDER);
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public void deactivate() {
		if(styleObservable != null) {
			styleObservable.removeChangeListener(this);
			styleObservable.dispose();
			styleObservable = null;
		}
	}

	@Override
	public void handleChange(ChangeEvent event) {
		getHost().refresh();
	}

	@Override
	public void refresh() {
		refreshBorderDisplay();
	}

	protected IFigure getPrimaryShape() {
		EditPart host = getHost();
		if(host instanceof IPapyrusEditPart) {
			IPapyrusEditPart graphicalHost = (IPapyrusEditPart)host;
			return graphicalHost.getPrimaryShape();
		}

		return getHostFigure();
	}

	protected View getNotationView() {
		EditPart host = getHost();
		if(host instanceof org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart) {
			return ((org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart)host).getNotationView();
		}

		View view = (View)host.getAdapter(View.class);
		return view;
	}

	protected Border defaultBorder;

	protected void refreshBorderDisplay() {
		View view = getNotationView();
		if(view == null) {
			return;
		}

		BooleanValueStyle displayBorderStyle = (BooleanValueStyle)view.getNamedStyle(NotationPackage.eINSTANCE.getBooleanValueStyle(), BorderDisplayEditPolicy.DISPLAY_BORDER);

		if(displayBorderStyle != null && !displayBorderStyle.isBooleanValue()) {
			if(defaultBorder == null) {
				defaultBorder = getPrimaryShape().getBorder();
			}
			getPrimaryShape().setBorder(null);

			for(Object currentEditPart : getHost().getChildren()) {
				if(currentEditPart instanceof ResizableCompartmentEditPart) {
					((ResizableCompartmentEditPart)currentEditPart).getFigure().setBorder(null);
				}

			}


		} else {
			if(defaultBorder != null) {
				getPrimaryShape().setBorder(defaultBorder);
			}
			defaultBorder = null;

			for(Object currentEditPart : getHost().getChildren()) {
				if(currentEditPart instanceof ResizableCompartmentEditPart) {
					((ResizableCompartmentEditPart)currentEditPart).getFigure().setBorder(new OneLineBorder());
				}
			}


		}
	}

}
