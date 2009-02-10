/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Michael Golubev (Borland) - initial API and implementation
 */

package org.eclipse.papyrus.diagram.common.part;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.gef.Request;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeConnectionRequest;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

public abstract class CreateLinkToolBase extends UnspecifiedTypeConnectionTool {

	public CreateLinkToolBase(List<? extends IElementType> types) {
		super(types);
	}

	@Override
	@SuppressWarnings("unchecked")
	protected Request createTargetRequest() {
		CreateUnspecifiedTypeConnectionRequest request = (CreateUnspecifiedTypeConnectionRequest) super.createTargetRequest();

		// below is the only way to propagate extended data into IEditCommandRequest#parameters
		HashMap extendedData = new HashMap();
		extendedData.putAll(request.getExtendedData());
		extendedData.putAll(createAdditionalExtendedData());
		for (CreateRequest next : (List<CreateRequest>) request.getAllRequests()) {
			next.setExtendedData(extendedData);
		}
		return request;
	}

	/**
	 * Creates additional data that should be passed into IEditCommandRequest#parameters
	 * 
	 * @return not <code>null</code>
	 */
	protected abstract Map<String, ?> createAdditionalExtendedData();

}
