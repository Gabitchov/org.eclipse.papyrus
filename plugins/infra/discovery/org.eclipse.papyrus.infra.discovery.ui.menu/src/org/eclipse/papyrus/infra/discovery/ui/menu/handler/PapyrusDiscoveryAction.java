/*******************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.infra.discovery.ui.menu.handler;

import org.eclipse.jface.action.Action;
import org.eclipse.papyrus.infra.discovery.ui.wizards.DiscoveryComponent;

/**
 * Action used for discovery 
 */
public class PapyrusDiscoveryAction extends Action {
	/**
	 * The constructor.
	 */
	public PapyrusDiscoveryAction() {
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		DiscoveryComponent.execute();
	}
}
