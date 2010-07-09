/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Saadia Dhouib (CEA LIST) saadia.dhouib@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.message.editor.xtext.ui.outline;

import org.eclipse.xtext.ui.editor.outline.actions.DefaultContentOutlineNodeAdapterFactory;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating UmlMessageOutlineNodeAdapter objects.
 */
public class UmlMessageOutlineNodeAdapterFactory extends DefaultContentOutlineNodeAdapterFactory {

	/** The Constant types. */
	private static final Class<?>[] types = { 
		// provide list of classes to adapt to, e.g.:
		// Entity.class
		// Service.class
	};

	/**
	 * @see org.eclipse.xtext.ui.editor.outline.actions.DefaultContentOutlineNodeAdapterFactory#getAdapterList()
	 *
	 * @return the adapter list
	 */
	
	@Override
	public Class<?>[] getAdapterList() {
		return types;
	}

}

