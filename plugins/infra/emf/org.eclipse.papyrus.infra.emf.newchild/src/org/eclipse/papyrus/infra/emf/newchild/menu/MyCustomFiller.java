/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.newchild.menu;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.papyrus.infra.emf.newchild.runtime.DisabledContributionItem;
import org.eclipse.papyrus.infra.emf.newchild.util.MenuHelper;

/**
 * Sample
 */
public class MyCustomFiller extends AbstractCustomFillElement {

	@Override
	public void fill(IMenuManager menuManager) {
		DisabledContributionItem item = new DisabledContributionItem("MyCustomFiller", null, null);
		item.setMenuStyle(true);
		MenuHelper.add(group, menuManager, item);
	}

}
