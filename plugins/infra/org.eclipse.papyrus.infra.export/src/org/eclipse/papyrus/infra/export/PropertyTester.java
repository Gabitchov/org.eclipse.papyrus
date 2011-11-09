/*******************************************************************************
 * Copyright (c) 2011 AtoS
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Anass RADOUANI (AtoS) - test property to enable or disable Export All menu item
 *******************************************************************************/

package org.eclipse.papyrus.infra.export;

import org.eclipse.papyrus.infra.export.actions.ExportAllDiagramsAction;

public class PropertyTester extends org.eclipse.core.expressions.PropertyTester {

	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if("isFileExportable".equals(property) || "isCollectionExportable".equals(property)) {
			return ExportAllDiagramsAction.getIFile(receiver) != null;
		}
		return false;
	}

}
