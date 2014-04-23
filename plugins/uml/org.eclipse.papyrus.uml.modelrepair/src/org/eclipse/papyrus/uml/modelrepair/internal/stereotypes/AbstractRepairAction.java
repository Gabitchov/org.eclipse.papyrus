/*
 * Copyright (c) 2014 CEA and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus (CEA) - Initial API and implementation
 *
 */
package org.eclipse.papyrus.uml.modelrepair.internal.stereotypes;

import org.eclipse.uml2.uml.util.UMLUtil;



/**
 * This is the AbstractRepairAction type. Enjoy.
 */
abstract class AbstractRepairAction extends UMLUtil implements IRepairAction {

	private final Kind kind;

	protected AbstractRepairAction(Kind kind) {
		this.kind = kind;
	}

	public Kind kind() {
		return kind;
	}

	public boolean isNull() {
		return kind() == null;
	}

}
