/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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
package org.eclipse.papyrus.uml.service.types.helper;

import java.util.Collections;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.command.CreateChildCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.internal.EMFTypePlugin;
import org.eclipse.gmf.runtime.emf.type.core.internal.l10n.EMFTypeCoreMessages;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.uml2.uml.UMLPackage;


public class ActivityHelper extends ElementEditHelper {
	
//	{
//		getDefaultContainmentFeatures().put(UMLPackage.eINSTANCE.getCentralBufferNode(), UMLPackage.eINSTANCE.getActivity_OwnedNode());
//	}
//	
//	@Override
//	protected ICommand getCreateCommand(CreateElementRequest req) {
//		return super.getCreateCommand(req);
//		// return new CreateActivityNode(req);
//	}
//	
//	
//	/**
//	 * this inner class is used to call specific command of UML 
//	 *
//	 */
//	private class CreateActivityNode extends CreateElementCommand{
//
//		protected Command emfcmd=null;
//		public CreateActivityNode(CreateElementRequest request) {
//			super(request);
//		}
//		 @Override
//		protected EObject doDefaultElementCreation() {
//			 EObject result = null;
//				EReference containment = getContainmentFeature();
//				EClass eClass = getElementType().getEClass();
//
//				if (containment != null) {
//					EObject element = getElementToEdit();
//					if (element != null) {
//						result = eClass.getEPackage().getEFactoryInstance().create(eClass);
//						//Command cmd=new CreateChildCommand(getRequest().getEditingDomain(), element,  UMLPackage.eINSTANCE.getActivity_OwnedNode(), UMLFactory.eINSTANCE.createOpaqueAction(), Collections.EMPTY_LIST);
//						emfcmd= new CreateChildCommand(getRequest().getEditingDomain(),element,  containment, result, Collections.EMPTY_LIST);
//						emfcmd.canExecute();
//						emfcmd.execute();
//						if(!emfcmd.getResult().isEmpty()){
//						result=(EObject)emfcmd.getResult().toArray()[0];
//						}
//					}
//				}
//
//				IStatus status = (result != null) ? Status.OK_STATUS
//						: new Status(
//								Status.ERROR,
//								EMFTypePlugin.getPluginId(),
//								EMFTypeCoreMessages
//										.bind(
//												EMFTypeCoreMessages.createElementCommand_noElementCreated,
//												getElementType().getDisplayName()));
//				
//				setDefaultElementCreationStatus(status);
//				
//				return result;
//		}
//		 @Override
//		protected IStatus doUndo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
//			emfcmd.undo();
//			return super.doUndo(monitor, info);
//		}
//		 
//		 @Override
//		protected IStatus doRedo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
//			
//			IStatus status= super.doRedo(monitor, info);
//			 emfcmd.redo();
//			return status;
//		}
//	}
//	
//	
}
