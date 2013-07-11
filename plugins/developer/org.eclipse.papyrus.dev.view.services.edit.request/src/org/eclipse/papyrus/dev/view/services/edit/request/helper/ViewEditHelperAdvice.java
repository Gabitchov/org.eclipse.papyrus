/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.dev.view.services.edit.request.helper;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.IEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.papyrus.dev.view.services.edit.request.view.RequestView;

/**
 * 
 * We use this advice to know the request sended to the service edit
 * 
 */
public class ViewEditHelperAdvice implements IEditHelperAdvice {

	public ICommand getBeforeEditCommand(final IEditCommandRequest request) {
		RequestView view = RequestView.INSTANCE;
		if(view != null) {
			view.addRequest(request);
		}
		return null;
	}

	public ICommand getAfterEditCommand(final IEditCommandRequest request) {
		//nothing to do
		return null;
	}

	public void configureRequest(final IEditCommandRequest request) {
		//nothing to do
	}

	public boolean approveRequest(final IEditCommandRequest request) {
		return true;
	}

}
