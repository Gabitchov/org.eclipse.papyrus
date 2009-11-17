/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.diagram.common.wizards;

import java.util.List;

import org.eclipse.papyrus.diagram.common.service.AspectCreationEntry;

/**
 * Proxy for the aspect tool entries
 */
public class PaletteAspectToolEntryProxy extends PaletteEntryProxy {

	/**
	 * Creates a new {@link PaletteAspectToolEntryProxy}
	 * 
	 * @param entry
	 *            the proxied entry
	 */
	public PaletteAspectToolEntryProxy(AspectCreationEntry entry) {
		super(entry);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public AspectCreationEntry getEntry() {
		return (AspectCreationEntry) super.getEntry();
	}

	/**
	 * Returns the ID of the referenced entry of the aspect entry
	 * 
	 * @return the ID of the referenced entry of the aspect entry
	 */
	public String getReferencedPaletteID() {
		return getEntry().getReferencedEntry().getId();
	}

	/**
	 * Returns the list of stereotypes Qualified names to apply
	 * 
	 * @return the list of stereotypes qualified names to apply
	 */
	public List<String> getStereotypesQNList() {
		return getEntry().getStereotypeList();
	}

}
