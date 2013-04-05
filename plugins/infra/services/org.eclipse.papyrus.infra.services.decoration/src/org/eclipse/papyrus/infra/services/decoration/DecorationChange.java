/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *	Ansgar Radermacher (CEA LIST) - ansgar.radermacher@cea.fr
 *   
 *****************************************************************************/

package org.eclipse.papyrus.infra.services.decoration;

import org.eclipse.papyrus.infra.services.decoration.util.Decoration;

/**
 * An instance of this class is passed to observers of the decoration service. The additional information
 * controls the actions that the observers have to do, in many cases it enables them to do nothing at
 * all by checking whether an added or removed decoration is "for them" (e.g. views are observers and can detect whether a decoration
 * is associated with the EObject they represent).
 * This greatly enhances performance, see bug 400593
 * 
 * @author ansgar
 */
public class DecorationChange {

	public enum DecorationChangeKind {
		DecorationAdded,
		DecorationRemoved,
		RefreshAll, 
		DecorationModified
	};

	protected DecorationChangeKind changeKind;

	protected Decoration decoration;

	public DecorationChange(DecorationChangeKind changeKind, Decoration decoration) {
		this.changeKind = changeKind;
		this.decoration = decoration;
	}

	public DecorationChangeKind getChangeKind() {
		return changeKind;
	}

	public Decoration getDecoration() {
		return decoration;
	}
}
