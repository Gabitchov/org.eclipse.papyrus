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
import org.eclipse.gef.editpolicies.GraphicalEditPolicy;
import org.eclipse.gmf.runtime.notation.BooleanValueStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.gmfdiag.common.databinding.custom.CustomBooleanStyleObservableValue;

/**
 * this edit policy has in charge to set the ratio of the symbol if is displayed
 * associated figure has to be a {@link NodeNamedElementFigure}
 */
public class MaintainSymbolRatioEditPolicy extends GraphicalEditPolicy implements IChangeListener {

	public static final String MAINTAIN_SYMBOL_RATIO = "maintainSymbolRatio";

	/** key for this edit policy */
	public final static String MAINTAIN_SYMBOL_RATIO_EDITPOLICY = "MAINTAIN_SYMBOL_RATIO_EDITPOLICY";

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

		styleObservable = new CustomBooleanStyleObservableValue(view, EMFHelper.resolveEditingDomain(view), MAINTAIN_SYMBOL_RATIO);
		styleObservable.addChangeListener(this);
	}


	/**
	 * 
	 * @param currentView
	 * @return the current Style that reperesent the boder
	 */
	protected BooleanValueStyle getMaintainSymbolRatioStyle(View currentView) {
		return (BooleanValueStyle)currentView.getNamedStyle(NotationPackage.eINSTANCE.getBooleanValueStyle(), MAINTAIN_SYMBOL_RATIO);
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


}
