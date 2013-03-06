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
package org.eclipse.papyrus.cdo.validation.problems.edit;

import org.eclipse.papyrus.cdo.validation.problems.EProblem;

/**
 * Optional protocol for edit providers to provide a "problem type" for an
 * {@link EProblem}. This is intended for models that extend the CDO Problems
 * model to provide custom problems.
 */
public interface IProblemTypeProvider {

	public String getProblemType(Object object);
}
