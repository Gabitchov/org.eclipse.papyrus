/*****************************************************************************
 * Copyright (c) 2010 LIFL & CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin (LIFL) cedric.dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.common.util;

import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditDomain;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramEditDomain;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServiceNotFoundException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.AbstractServiceUtils;
import org.eclipse.papyrus.uml.diagram.common.part.UmlGmfDiagramEditor;
import org.eclipse.ui.IWorkbenchPart;

/**
 * Set of utility methods for accessing core Services. This methods are designed
 * to be used from code from Papyrus GMF diagrams.
 * 
 * 
 * @author cedric dumoulin
 * 
 */
public class ServiceUtilsForGMF extends AbstractServiceUtils<IDiagramEditDomain> {

	private final static ServiceUtilsForGMF instance = new ServiceUtilsForGMF();

	/**
	 * Get the singleton instance of the class.
	 * 
	 * @return
	 */
	public static final ServiceUtilsForGMF getInstance() {
		return instance;
	}

	/**
	 * Get the {@link ServicesRegistry} from an {@link IDiagramEditDomain}.
	 * Throw an exception if the ServiceRegistry can't be found. <br>
	 * This method get the ServiceRegistry from the IDiagramEditDomain
	 * associated to an GMF EditPart. This IDiagramEditDomain can be obtained by
	 * calling:
	 * <ul>
	 * <li>from EditParts - editpart.getDiagramEditDomain()</li>
	 * <li>from EditPolicies - policy.getHost().getDiagramEditDomain()</li>
	 * </ul>
	 * 
	 * @see org.eclipse.papyrus.infra.core.utils.AbstractServiceUtils#getServiceRegistry(java.lang.Object)
	 * 
	 * @param domain
	 *        The domain associated to an EditPart.
	 * @return
	 * @throws ServiceException
	 *         If an error occurs
	 * @throws ServiceNotFoundException
	 *         If the ServiceRegistry can't be found from the domain
	 */
	@Override
	public ServicesRegistry getServiceRegistry(IDiagramEditDomain domain) throws ServiceException {
		if(domain instanceof DiagramEditDomain) {
			IWorkbenchPart part = ((DiagramEditDomain)domain).getEditorPart().getEditorSite().getPart();
			if(part instanceof UmlGmfDiagramEditor) {
				return ((UmlGmfDiagramEditor)part).getServicesRegistry();
			}
		}

		throw new ServiceNotFoundException("Can't find ServiceRegistry from '" + domain + "'");
	}

}
