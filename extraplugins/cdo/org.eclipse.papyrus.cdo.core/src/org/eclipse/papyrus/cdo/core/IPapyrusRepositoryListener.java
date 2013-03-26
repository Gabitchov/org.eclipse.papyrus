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
package org.eclipse.papyrus.cdo.core;

import java.util.EventListener;


/**
 * An event listener call-back interface for notification of significant lifecycle
 * changes in an {@link IPapyrusRepository}.
 */
public interface IPapyrusRepositoryListener extends EventListener {

	void papyrusRepositoryChanged(PapyrusRepositoryEvent event);
}
