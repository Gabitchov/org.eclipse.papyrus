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
package org.eclipse.papyrus.cdo.validation.problems.util;

import java.util.EventListener;

/**
 * This is the ProblemsListener type. Enjoy.
 */
public interface ProblemsListener
		extends EventListener {

	void problemAdded(ProblemsEvent event);

	void problemRemoved(ProblemsEvent event);
}
