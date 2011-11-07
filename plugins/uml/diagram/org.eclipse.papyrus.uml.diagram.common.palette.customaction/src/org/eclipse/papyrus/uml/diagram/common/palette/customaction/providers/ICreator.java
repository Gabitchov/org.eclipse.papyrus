/*****************************************************************************
 * Copyright (c) 2011 Atos.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan FAURE (Atos) tristan.faure@atos.net - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.palette.customaction.providers;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.EditPart;
import org.eclipse.papyrus.uml.diagram.common.service.palette.IPaletteEntryProxy;

public interface ICreator {

	/**
	 * Creates an instance of {@link ITool}
	 * 
	 * @param part
	 *        , the edit part created by MDT Papyrus
	 * @return the {@link ITool}
	 */
	ITool create(EditPart part);

	/**
	 * Determines if the {@link ICreator} can be used
	 * 
	 * @param entryProxy
	 *        , the palette entry used
	 * @return true if it can be enabled
	 */
	boolean isEnabled(IPaletteEntryProxy entryProxy);

	/**
	 * This method is used to determines features set by the tool
	 * 
	 * @return an array of {@link EStructuralFeature}
	 */
	EStructuralFeature[] getAllImpactedFeatures();
}
