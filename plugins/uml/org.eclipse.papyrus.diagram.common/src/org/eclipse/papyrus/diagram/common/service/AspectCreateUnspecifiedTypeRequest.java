/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.diagram.common.service;

import java.util.List;

import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeRequest;

/**
 * This request encapsulates a list of <code>CreateViewRequest</code> or
 * <code>CreateViewAndElementRequest</code> for each type that this tool supports. Each method in
 * <code>CreateRequest</code> that is called to configure the request in <code>CreationTool</code>
 * is propagated to each individual request. It also adds pre-requests and post-request
 */
public class AspectCreateUnspecifiedTypeRequest extends CreateUnspecifiedTypeRequest {

	/** list of stereotype to apply */
	protected List<String> stereotypesToApply;

	/**
	 * Creates a new AspectCreateUnspecifiedTypeRequest
	 * 
	 * @param elementTypes
	 *            element types to create
	 * @param preferencesHint
	 *            preference hints for the creation
	 */
	public AspectCreateUnspecifiedTypeRequest(List elementTypes, PreferencesHint preferencesHint,
			List<String> stereotypesToApply) {
		super(elementTypes, preferencesHint);
		this.stereotypesToApply = stereotypesToApply;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void createRequests() {
		// adds super requests
		super.createRequests();
		requests.put(ApplyStereotypeRequest.APPLY_STEREOTYPE_REQUEST, new ApplyStereotypeRequest(stereotypesToApply));
	}
}
