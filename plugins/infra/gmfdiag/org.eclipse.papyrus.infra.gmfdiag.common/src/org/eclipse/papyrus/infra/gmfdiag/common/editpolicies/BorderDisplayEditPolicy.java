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
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.core.listener.DiagramEventBroker;
import org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.gef.ui.internal.editpolicies.GraphicalEditPolicyEx;
import org.eclipse.gmf.runtime.notation.BooleanValueStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.gmfdiag.common.databinding.custom.CustomBooleanStyleObservableValue;
import org.eclipse.papyrus.infra.gmfdiag.common.editpart.IPapyrusEditPart;

/**
 * this edit policy has in charge to toggle the border of its edit part's figure
 */
public class BorderDisplayEditPolicy extends GraphicalEditPolicyEx implements IChangeListener, NotificationListener {

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

		// adds a listener on the view and the element controlled by the
		// editpart
		getDiagramEventBroker().addNotificationListener(view, this);

		EObject semanticElement = EMFHelper.getEObject(getHost());
		if(semanticElement != null) {
			getDiagramEventBroker().addNotificationListener(semanticElement, this);
		}

		refreshBorderDisplay();
	}


	/**
	 * Gets the diagram event broker from the editing domain.
	 * 
	 * @return the diagram event broker
	 */
	protected DiagramEventBroker getDiagramEventBroker() {
		TransactionalEditingDomain theEditingDomain = ((IGraphicalEditPart)getHost()).getEditingDomain();
		if(theEditingDomain != null) {
			return DiagramEventBroker.getInstance(theEditingDomain);
		}
		return null;
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
	public void notifyChanged(Notification notification) {
		refreshBorderDisplay();
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

		BooleanValueStyle displayBorderStyle = findDisplayBorderStyle(view);

		if(displayBorderStyle != null && !displayBorderStyle.isBooleanValue()) {
			if(defaultBorder == null) {
				defaultBorder = getPrimaryShape().getBorder();
			}
			getPrimaryShape().setBorder(null);

			//TODO: This edit policy should be installed on all compartments. We shouldn't need to refresh them from here
			//			for(Object currentEditPart : getHost().getChildren()) {
			//				if(currentEditPart instanceof ResizableCompartmentEditPart) {
			//					((ResizableCompartmentEditPart)currentEditPart).getFigure().setBorder(null);
			//				}
			//			}
			//


		} else {
			if(defaultBorder != null) {
				getPrimaryShape().setBorder(defaultBorder);
			}
			defaultBorder = null;

			//TODO: This edit policy should be installed on all compartments. We shouldn't need to refresh them from here
			//			for(Object currentEditPart : getHost().getChildren()) {
			//				if(currentEditPart instanceof ResizableCompartmentEditPart) {
			//					((ResizableCompartmentEditPart)currentEditPart).getFigure().setBorder(new OneLineBorder());
			//				}
			//			}
			//

		}
	}


	private BooleanValueStyle findDisplayBorderStyle(View view) {
		View parentView = view;
		while(parentView.getElement() == view.getElement()) {
			BooleanValueStyle style = (BooleanValueStyle)parentView.getNamedStyle(NotationPackage.eINSTANCE.getBooleanValueStyle(), DISPLAY_BORDER);
			if(style != null) {
				return style;
			}

			if(parentView.eContainer() instanceof View) {
				parentView = (View)parentView.eContainer();
			}

		}

		return null;
	}

}
