/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.gmf.diagram.common.compatibility;

import org.eclipse.gmf.runtime.notation.Diagram;

/**
 * This interface provides an API for migration of diagram from a version to another.
 */
public interface IDiagramVersionUpdater {

	/**
	 * Update a diagram to a new version.
	 * @param diagram the diagram to update
	 * @param oldVersion the old version of the diagram
	 * @param newVersion the new version of the diagram
	 * @return TODO : should return a status, not int.
	 */
	public int update(Diagram diagram, String oldVersion, String newVersion);
}
