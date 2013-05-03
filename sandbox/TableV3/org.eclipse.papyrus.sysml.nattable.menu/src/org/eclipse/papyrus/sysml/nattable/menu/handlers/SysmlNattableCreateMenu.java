/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Juan Cadavid (CEA LIST) juan.cadavid@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.sysml.nattable.menu.handlers;

import org.eclipse.papyrus.sysml.service.types.menu.AbstractCreateSysmlChildMenu;
import org.eclipse.papyrus.uml.nattable.menu.tester.TableEditorPropertyTester;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.menus.IContributionRoot;
import org.eclipse.ui.services.IServiceLocator;

/**
 * Menu contributions for the creation of Sysml elements from the Nattable editor
 */
public class SysmlNattableCreateMenu extends AbstractCreateSysmlChildMenu {

	//FIXME : use the same property tester than in oep.infra.nattable.modelexplorer
	private TableEditorPropertyTester tester = new TableEditorPropertyTester();

	@Override
	public void createContributionItems(IServiceLocator serviceLocator, IContributionRoot additions) {
		IWorkbenchPart part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActivePart();
		if(tester.test(part, TableEditorPropertyTester.IS_TABLE, null, Boolean.TRUE)) {
			super.createContributionItems(serviceLocator, additions);
		}
	}
}
