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

import static org.eclipse.papyrus.uml.diagram.common.Activator.log;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditDomain;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramEditDomain;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.uml.diagram.common.part.UmlGmfDiagramEditor;
import org.eclipse.ui.IWorkbenchPart;


/**
 * A set of utility methods to get the Services from the core.
 * 
 * @author cedric dumoulin
 * @deprecated Use {@link ServiceUtilsForGMF}
 */
@Deprecated
public class DiagramCoreServiceUtils {

	/**
	 * Get the {@link ServiceRegistry} from the {@link IDiagramEditDomain}.
	 * This method can be used from EditParts and EditPolicies to retrieve the {@link ServicesRegistry}. <br>
	 * The IDiagramEditDomain can be found :
	 * <ul>
	 * <li>EditParts - getDiagramEditDomain()</li>
	 * <li>EditPolicies - getHost().getDiagramEditDomain()</li>
	 * </ul>
	 * 
	 * @param domain
	 *        or null if not found
	 * @return
	 */
	static ServicesRegistry getServiceRegistry(IDiagramEditDomain domain) {

		if(domain instanceof DiagramEditDomain) {
			IWorkbenchPart part = ((DiagramEditDomain)domain).getEditorPart().getEditorSite().getPart();
			if(part instanceof UmlGmfDiagramEditor) {
				return ((UmlGmfDiagramEditor)part).getServicesRegistry();
			}
		}
		return null;

	}

	/**
	 * Get the {@link ServiceRegistry} from the {@link IDiagramEditDomain}.
	 * This method can be used from EditParts and EditPolicies to retrieve the {@link ServicesRegistry}. <br>
	 * The IDiagramEditDomain can be found :
	 * <ul>
	 * <li>EditParts - getDiagramEditDomain()</li>
	 * <li>EditPolicies - getHost().getDiagramEditDomain()</li>
	 * </ul>
	 * 
	 * @param domain
	 *        or null if not found
	 * @return
	 */
	static ServicesRegistry getServiceRegistryChecked(IDiagramEditDomain domain) throws ServiceException {

		return ServiceUtilsForGMF.getInstance().getServiceRegistry(domain);

		//		if(domain instanceof DiagramEditDomain) {
		//			IWorkbenchPart part = ((DiagramEditDomain)domain).getEditorPart().getEditorSite().getPart();
		//			if(part instanceof UmlGmfDiagramEditor) {
		//				return ((UmlGmfDiagramEditor)part).getServicesRegistry();
		//			}
		//		}
		//		throw new ServiceNotFoundException("Can't get the ServiceRegistry.");

	}

	/**
	 * Gets the {@link TransactionalEditingDomain} registered in the {@link ServicesRegistry}.
	 * 
	 * @param domain
	 * @return
	 */
	public static TransactionalEditingDomain getTransactionalEditingDomain(IDiagramEditDomain domain) {


		try {
			return getServiceRegistryChecked(domain).getService(TransactionalEditingDomain.class);
		} catch (IllegalStateException e) {
			// Registry can't be found, do nothing.
		} catch (ServiceException e) {
			log.error(e);
		}
		return null;
	}

	/**
	 * Gets the {@link TransactionalEditingDomain} registered in the {@link ServicesRegistry}.
	 * 
	 * @param domain
	 * @return
	 * @throws ServiceException
	 *         If the TransactionalEditingDomain can not be found.
	 */
	public static TransactionalEditingDomain getTransactionalEditingDomainChecked(IDiagramEditDomain domain) throws ServiceException {
		return getServiceRegistryChecked(domain).getService(TransactionalEditingDomain.class);
	}


}
