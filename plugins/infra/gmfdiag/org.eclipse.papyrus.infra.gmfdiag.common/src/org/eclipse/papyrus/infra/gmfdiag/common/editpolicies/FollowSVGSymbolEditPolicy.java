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
import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.editpolicies.GraphicalEditPolicy;
import org.eclipse.gmf.runtime.diagram.core.listener.DiagramEventBroker;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.BooleanValueStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.gmfdiag.common.databinding.custom.CustomBooleanStyleObservableValue;

/**
 * this edit policy has in charge to display follow the symbol associated to the node 
 * associated figure has to be a {@link NodeNamedElementFigure}
 */
public class FollowSVGSymbolEditPolicy extends GraphicalEditPolicy implements IChangeListener {
	/**
	 * name of the style to get for follow the Symbol
	 */
	public static final String FOLLOW_SVG_SYMBOL = "FollowSVGSymbol";

	/** key for this edit policy */
	public final static String FOLLOW_SVG_SYMBOL_EDITPOLICY = "followSVGSymbolEditPolicy";

	protected IObservableValue styleObservable;



	/**
	 * Creates a new QualifiedNameDisplayEditPolicy
	 */
	public FollowSVGSymbolEditPolicy() {
		super();
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public void activate() {
		// retrieve the view and the element managed by the edit part
		View view = (View)getHost().getModel();
		if(view == null) {
			return;
		}

		styleObservable = new CustomBooleanStyleObservableValue(view, EMFHelper.resolveEditingDomain(view), FOLLOW_SVG_SYMBOL);
		styleObservable.addChangeListener(this);

		refreshFigure();
	}


	/**
	 * refresh the qualified name
	 */
	protected void refreshFigure() {
		if(getHost() instanceof GraphicalEditPart) {
			GraphicalEditPart editPart=(GraphicalEditPart)getHost();
			BooleanValueStyle followStyle=getFollowSymbolStyle(editPart.getNotationView());
			if(followStyle!=null && followStyle.isBooleanValue()==true){
				final IFigure fig=getHostFigure();





				System.err.println(fig);


			}
		}
	}

	/**
	 * 
	 * @param currentView
	 * @return the current Style that repersent the boder
	 */
	protected BooleanValueStyle getFollowSymbolStyle(View currentView){
		return (BooleanValueStyle)currentView.getNamedStyle(NotationPackage.eINSTANCE.getBooleanValueStyle(),FOLLOW_SVG_SYMBOL);

	}
	/**
	 * 
	 * {@inheritDoc}
	 */
	public void deactivate() {
		// retrieve the view and the element managed by the edit part
		View view = (View)getHost().getModel();
		if(view == null) {
			return;
		}
		if(styleObservable != null) {
			styleObservable.removeChangeListener(this);
			styleObservable.dispose();
			styleObservable = null;
		}

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

	public void handleChange(ChangeEvent event) {
		getHost().refresh();
	}

}
