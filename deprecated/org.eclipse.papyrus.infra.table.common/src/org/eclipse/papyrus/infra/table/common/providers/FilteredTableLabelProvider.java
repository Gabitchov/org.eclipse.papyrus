/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.table.common.providers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.services.labelprovider.service.IFilteredLabelProvider;
import org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrusTableInstance;

/**
 * A Filter Label Provider for {@link PapyrusTableInstance}
 * 
 * @author Camille Letavernier
 * 
 */
public class FilteredTableLabelProvider extends TableLabelProvider implements IFilteredLabelProvider {

	/**
	 * Accepts {@link PapyrusTableInstance}
	 */
	public boolean accept(Object element) {
		//The element is a PapyrusTableInstance or can be adapted to an PapyrusTableInstance
		EObject eObject = EMFHelper.getEObject(element);

		return eObject instanceof PapyrusTableInstance;
	}

}
