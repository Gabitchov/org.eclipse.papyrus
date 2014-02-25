/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.decoration;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.infra.gmfdiag.common.Activator;
import org.eclipse.papyrus.infra.services.decoration.IDecorationSpecificFunctions;
import org.eclipse.papyrus.infra.services.decoration.util.Decoration.PreferedPosition;
import org.eclipse.papyrus.infra.services.decoration.util.IPapyrusDecoration;
import org.eclipse.papyrus.infra.services.markerlistener.IPapyrusMarker;

/**
 * A Decorator for GMF Shapes, which is displayed when the graphical container is different
 * from the semantic container (i.e. highlight external references / imported elements)
 *
 * It is associated to the {@link ExternalReferenceMarker}
 *
 * @author Camille Letavernier
 */
public class ExternalReferenceDecoration implements IDecorationSpecificFunctions {

	@Override
	public MarkChildren supportsMarkerPropagation() {
		//This marker should not be propagated
		return null;
	}

	@Override
	public IPapyrusDecoration markerPropagation(EList<IPapyrusDecoration> childDecorations) {
		//This marker should not be propagated
		return null;
	}

	@Override
	public ImageDescriptor getImageDescriptorForGE(IPapyrusMarker marker) {
		return org.eclipse.papyrus.infra.widgets.Activator.getDefault().getImageDescriptor(Activator.ID, "icons/shortcut.gif"); //$NON-NLS-1$
	}

	@Override
	public ImageDescriptor getImageDescriptorForME(IPapyrusMarker marker) {
		//This decorator only applies to GMF elements
		return null;
	}

	@Override
	public PreferedPosition getPreferedPosition(IPapyrusMarker marker) {
		return PreferedPosition.NORTH_EAST;
	}

	@Override
	public String getMessage(IPapyrusMarker marker) {
		return "This element is imported";
	}

	@Override
	public int getPriority(IPapyrusMarker marker) {
		return 0;
	}

}
