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
package org.eclipse.papyrus.infra.gmfdiag.common.editpart;

import org.eclipse.gef.EditPart;


/**
 * A filter that detects whether an {@link EditPart} has model changes that
 * are in conflict with changes made by another editor. Conflicting edit parts
 * are not removed from the diagram when it is refreshed.
 */
public interface IConflictingEditPartFilter {

	/**
	 * The default filter, which never detects a conflict.
	 */
	IConflictingEditPartFilter DEFAULT = new IConflictingEditPartFilter() {

		public boolean isConflicting(EditPart editPart) {
			return false;
		}
	};

	boolean isConflicting(EditPart editPart);
}
