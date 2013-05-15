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
package org.eclipse.papyrus.uml.nattable.menu.handlers;

import org.eclipse.papyrus.infra.nattable.utils.NattableWidgetPropertyTester;
import org.eclipse.papyrus.uml.service.types.menu.AbstractCreateUmlChildMenu;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.menus.IContributionRoot;
import org.eclipse.ui.services.IServiceLocator;

/**
 * Menu contributions for the creation of UML elements from the Nattable editor
 */
public class UmlNattableCreateMenu extends AbstractCreateUmlChildMenu {

	private NattableWidgetPropertyTester tester = new NattableWidgetPropertyTester();

	@Override
	public void createContributionItems(IServiceLocator serviceLocator, IContributionRoot additions) {
		IWorkbenchPart part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActivePart();
		if(tester.test(part, NattableWidgetPropertyTester.IS_NATTABLE_WIDGET, null, Boolean.TRUE)) {
			super.createContributionItems(serviceLocator, additions);
		}
	}
}
