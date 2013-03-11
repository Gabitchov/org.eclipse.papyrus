/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.cdo.internal.ui.dnd;

import org.eclipse.core.resources.IContainer;
import org.eclipse.papyrus.cdo.internal.core.CDOUtils;
import org.eclipse.papyrus.cdo.internal.ui.handlers.ExportModelHandler;
import org.eclipse.ui.part.IDropActionDelegate;


/**
 * This is the ResourceDropActionDelegate type. Enjoy.
 */
public class ResourceDropActionDelegate implements IDropActionDelegate {

	public static final String DROP_ACTION_ID = "org.eclipse.papyrus.cdo.ui.modelDropAction"; //$NON-NLS-1$

	public ResourceDropActionDelegate() {
		super();
	}

	public boolean run(Object source, Object target) {
		boolean result = false;

		byte[] serial = null;
		if(source instanceof byte[]) {
			serial = (byte[])source;
		}

		if(serial != null) {
			IContainer container = CDOUtils.adapt(target, IContainer.class);
			if(container != null) {
				CDOResourceURITransferData data = CDOResourceURITransferData.deserialize(serial);
				if(!data.getURIs().isEmpty()) {
					result = true;
					ExportModelHandler.exportModels(container, data.getURIs());
				}
			}
		}

		return result;
	}

}
