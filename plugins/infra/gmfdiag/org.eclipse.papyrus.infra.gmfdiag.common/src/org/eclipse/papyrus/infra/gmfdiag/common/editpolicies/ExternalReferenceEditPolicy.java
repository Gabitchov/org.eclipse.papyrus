/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.editpolicies;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.gmf.runtime.gef.ui.internal.editpolicies.GraphicalEditPolicyEx;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.gmfdiag.common.Activator;
import org.eclipse.papyrus.infra.gmfdiag.common.decoration.ExternalReferenceMarker;
import org.eclipse.papyrus.infra.gmfdiag.common.helper.NotationHelper;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.ServiceUtilsForEditPart;
import org.eclipse.papyrus.infra.services.decoration.DecorationService;
import org.eclipse.papyrus.infra.services.markerlistener.IPapyrusMarker;

/**
 * A generic EditPolicy which applies {@link ExternalReferenceMarker} to EditParts when they have been imported
 * (According to {@link NotationHelper#isExternalRef(View)}
 *
 * @author Camille Letavernier
 *
 */
//Rely on the GraphicalEditPolicyEx, which is less expensive than adding a listener to detect changes in the containment tree
@SuppressWarnings("restriction")
public class ExternalReferenceEditPolicy extends GraphicalEditPolicyEx {

	/**
	 * The Edit Policy Role/ID
	 */
	public static final Object EDIT_POLICY_ROLE = Activator.ID + ".externalReferenceDecorator"; //$NON-NLS-1$

	/**
	 * Last known value for isExternalReference
	 */
	protected boolean isExternalReference = false;

	protected DecorationService decorationService;

	protected IPapyrusMarker marker;

	protected Adapter listener;

	@Override
	public void activate() {
		super.activate();

		try {
			decorationService = ServiceUtilsForEditPart.getInstance().getService(DecorationService.class, getHost());
			refresh();
		} catch (ServiceException ex) {
			Activator.log.error(ex);
		}
	}

	@Override
	public void refresh() {
		if(getView() == null) {
			return;
		}
		if(decorationService == null) {
			return;
		}

		//Add or remove the decoration when the current value is different from the last known value
		if(NotationHelper.isExternalRef(getView()) != isExternalReference) {
			isExternalReference = !isExternalReference;
			if(isExternalReference) {
				decorationService.addDecoration(getMarker(), getView());
			} else {
				decorationService.removeDecoration(getMarker().toString());
			}
			//We need to call refresh again, so that the decorator gets display.
			//We shouldn't end up with a StackOverFlow, because we arrive here only when the "isExternalRef" value changes
			getHost().refresh();
		}
	}

	/**
	 * Returns the marker instance. It is never null
	 *
	 * @return
	 */
	protected IPapyrusMarker getMarker() {
		if(marker == null) {
			marker = new ExternalReferenceMarker(getView());
		}
		return marker;
	}

	/**
	 * Return the view associated to this edit policy
	 *
	 * @return
	 */
	protected View getView() {
		return (View)getHost().getModel();
	}

	@Override
	public void deactivate() {
		super.deactivate();

		if(marker != null && decorationService != null) {
			//Remove the marker from the View to avoid duplication
			decorationService.removeDecoration(getMarker().toString());
			isExternalReference = false;
		}

		marker = null;
		decorationService = null;
	}
}
