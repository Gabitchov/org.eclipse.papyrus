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
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.service.creation.helper;

import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.papyrus.service.edit.service.ElementEditServiceUtils;
import org.eclipse.uml2.uml.ActionExecutionSpecification;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.Lifeline;


/**
 * this is a default Helper for UML element
 * 
 */
public class LifelineEditHelper extends DefaultUMLHelper {

	protected ICommand getDestroyElementCommand(DestroyElementRequest req) {

		Lifeline l = (Lifeline)req.getElementToDestroy();

		ICommand ddrCommand = super.getDestroyElementCommand(req);

		for(InteractionFragment fragment : l.getCoveredBys()) {

			if(fragment instanceof ActionExecutionSpecification) {

				DestroyElementRequest der = new DestroyElementRequest(fragment, false);
				//				IElementType typeToDestroy = null;
				//				try {
				//					typeToDestroy = ElementTypeRegistry.getInstance().getElementType(fragment, UMLTypeContext.getContext());
				//				} catch (Exception e) {
				//					// TODO Auto-generated catch block
				//					e.printStackTrace();
				//				}

				//if(typeToDestroy != null) {
				ddrCommand = CompositeCommand.compose(ddrCommand, ElementEditServiceUtils.getCommandProvider(fragment).getEditCommand(der));
				//				DestroyDependentsRequest ddr = new DestroyDependentsRequest(req.getEditingDomain(), req.getElementToDestroy(), false);
				//				ddrCommand = CompositeCommand.compose(ddrCommand, ddr.getDestroyDependentCommand(fragment));
				//}
			}
		}
		return ddrCommand.reduce();
	}
	//	protected ICommand getDestroyElementWithDependentsCommand(DestroyElementRequest req) {
	//
	//		ICommand result = getBasicDestroyElementCommand(req);
	//
	//		EObject initial = (EObject)req.getParameter(DestroyElementRequest.INITIAL_ELEMENT_TO_DESTROY_PARAMETER);
	//
	//		if(initial == null) {
	//			// set the parameter to keep track of the initial element to destroy
	//			req.setParameter(DestroyElementRequest.INITIAL_ELEMENT_TO_DESTROY_PARAMETER, req.getElementToDestroy());
	//		}
	//
	//		//	 get elements dependent on the element we are destroying, that
	//		//   must also be destroyed
	//		DestroyDependentsRequest ddr = (DestroyDependentsRequest)req.getParameter(DestroyElementRequest.DESTROY_DEPENDENTS_REQUEST_PARAMETER);
	//		if(ddr == null) {
	//			// create the destroy-dependents request that will be propagated to
	//			//    destroy requests for all elements destroyed in this operation
	//			ddr = new DestroyDependentsRequest(req.getEditingDomain(), req.getElementToDestroy(), req.isConfirmationRequired());
	//			// propagate the parameters, including the initial element to
	//			//    destroy parameter
	//			ddr.addParameters(req.getParameters());
	//			ddr.setClientContext(req.getClientContext());
	//			req.setParameter(DestroyElementRequest.DESTROY_DEPENDENTS_REQUEST_PARAMETER, ddr);
	//		} else {
	//			ddr.setElementToDestroy(req.getElementToDestroy());
	//		}
	//
	//		IElementType typeToDestroy = null;
	//		//		Map cacheMaps = (Map)req.getParameter(RequestCacheEntries.Cache_Maps);
	//		//		if(cacheMaps != null) {
	//		//			Map map = (Map)cacheMaps.get(req.getElementToDestroy());
	//		//			if(map != null) {
	//		//				typeToDestroy = (IElementType)map.get(RequestCacheEntries.Element_Type);
	//		//			}
	//		//		}
	//
	//		if(typeToDestroy == null) {
	//			typeToDestroy = ElementTypeRegistry.getInstance().getElementType(req.getElementToDestroy(), req.getClientContext());
	//		}
	//
	//		if(typeToDestroy != null) {
	//			ICommand command = typeToDestroy.getEditCommand(ddr);
	//
	//			if(command != null) {
	//				result = result.compose(command);
	//			}
	//		}
	//
	//		return result;
	//	}
	//
	//	protected ICommand getDestroyDependentsCommand(DestroyDependentsRequest req) {
	//		ICompositeCommand command = new CompositeCommand("Destroy lifeline dependants elements");
	//
	//		Lifeline l = (Lifeline)req.getElementToDestroy();
	//		for(InteractionFragment fragment : l.getCoveredBys()) {
	//
	//			ICommand destroyFragmentCommand = req.getDestroyDependentCommand(fragment);
	//			CompositeCommand.compose(command, destroyFragmentCommand);
	//
	//			//DestroyElementRequest der = new DestroyElementRequest(fragment, false);
	//			//			IClientContext context = null;
	//			//			try {
	//			//				context = UMLTypeContext.getContext();
	//			//			} catch (Exception e) {
	//			//				e.printStackTrace();
	//			//			}
	//			//
	//			//			IElementType type = ElementTypeRegistry.getInstance().getElementType(req.getContainer(), context);
	//			//			command.add(type.getEditCommand(der));
	//		}
	//
	//		return command;
	//	}
}
