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
 *  Camille Letavernier (camille.letavernier@cea.fr) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.search.ui.adapter;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.search.ui.ISearchPageScoreComputer;

/**
 * Adapter factory for Papyrus Search
 * 
 * @author Camille
 * 
 */
public class PapyrusSearchAdapterFactory implements IAdapterFactory {

	public PapyrusSearchAdapterFactory() {
		//Nothing
	}

	public Object getAdapter(Object adaptableObject, Class adapterType) {
		if(adapterType == ISearchPageScoreComputer.class) {
			return new PapyrusSearchPageScoreComputer();
		}
		return null;
	}

	public Class[] getAdapterList() {
		return new Class[]{ ISearchPageScoreComputer.class };
	}
}
