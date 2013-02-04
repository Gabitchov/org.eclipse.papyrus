/*******************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.papyrus.uml.diagram.timing.custom.utils;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gmf.runtime.notation.View;

public final class RequestUtils {

	private RequestUtils() {
		// utility class
	}

	/** Whether the given request is a ChangeBoundsRequest concerning instances of the given EClass only. */
	public static boolean isChangeBoundsRequestFor(final Request request, final EClass eClass) {
		if(request instanceof ChangeBoundsRequest) {
			final ChangeBoundsRequest changeBoundsRequest = (ChangeBoundsRequest)request;
			return isGroupRequestFor(changeBoundsRequest, eClass);
		}
		return false;
	}

	/** Whether the given request is a ChangeBoundsRequest concerning instances of the given EditPart only. */
	public static boolean isChangeBoundsRequestFor(final Request request, final Class<? extends EditPart> editPartClass) {
		if(request instanceof ChangeBoundsRequest) {
			final ChangeBoundsRequest changeBoundsRequest = (ChangeBoundsRequest)request;
			return isGroupRequestFor(changeBoundsRequest, editPartClass);
		}
		return false;
	}

	/** Whether the given request is a GroupRequest concerning instances of the given EClass only. */
	public static boolean isGroupRequestFor(final GroupRequest groupRequest, final EClass eClass) {
		@SuppressWarnings("unchecked")
		final List<EditPart> editParts = groupRequest.getEditParts();
		if(editParts == null) {
			return false;
		}
		for(final EditPart editPart : editParts) {
			final Object model = editPart.getModel();
			if(model instanceof View) {
				final View view = (View)model;
				final EObject element = view.getElement();
				if(!eClass.isInstance(element)) {
					return false;
				}
			} else {
				return false;
			}
		}
		return true;
	}

	/** Whether the given request is a GroupRequest concerning instances of the given EditPart only. */
	public static boolean isGroupRequestFor(final GroupRequest groupRequest, final Class<? extends EditPart> editPartClass) {
		@SuppressWarnings("unchecked")
		final List<EditPart> editParts = groupRequest.getEditParts();
		for(final EditPart editPart : editParts) {
			if(!editPartClass.isInstance(editPart)) {
				return false;
			}
		}
		return true;
	}
}
