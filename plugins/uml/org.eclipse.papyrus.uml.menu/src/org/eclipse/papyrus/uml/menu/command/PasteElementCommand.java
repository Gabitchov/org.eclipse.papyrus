/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.menu.command;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.MoveRequest;
import org.eclipse.papyrus.service.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.service.edit.service.IElementEditService;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * this handler has in charge to exexute the paste of UML element with their applied stereotypes
 *
 */
public class PasteElementCommand extends AbstractCommand {

	protected ArrayList<EObject> eobjectTopaste=null;
	protected ArrayList<EObject> stereotypeApplicationTopaste=null;
	protected EObject targetOwner;
	protected ICommand command;

	/**
	 * get the command do the paste on the target owner
	 * @param domain the editing owner
	 * @param targetOwner the element where the paste will be done
	 */
	public PasteElementCommand(EditingDomain domain, EObject targetOwner) {
		super();
		
		if(domain.getClipboard()!=null){
			//1. get Data from the clipboard
			Collection<Object> rawData=domain.getClipboard();
			
			//2. filter only EObject
			ArrayList<EObject> eobjectsTopaste=new ArrayList<EObject>();
			Iterator<Object> iterData= rawData.iterator();
			while (iterData.hasNext()) {
				Object object = (Object) iterData.next();
				if(object instanceof EObject){
					eobjectsTopaste.add((EObject)object);
				}
			}

			//3. Copy all eObjects (inspired from PasteFromClipboardCommand)
			Collection<EObject> duplicatedObject= EcoreUtil.copyAll(eobjectsTopaste);

			//4. filter eobject that are UML elements and application of stereotypes
			Iterator<EObject>iter=duplicatedObject.iterator();
			eobjectTopaste= new ArrayList<EObject>();
			stereotypeApplicationTopaste= new ArrayList<EObject>();
			while (iter.hasNext()) {
				EObject eObject = (EObject) iter.next();
				boolean isaUMLElement=false;
				if (eObject instanceof Element){
					isaUMLElement=true;
				}
				//functionality that comes from UML2 plugins
				if((UMLUtil.getStereotype(eObject) == null)&& isaUMLElement) {
					eobjectTopaste.add(eObject);
				}
				else{
					stereotypeApplicationTopaste.add(eObject);
				}
			}
			this.targetOwner = targetOwner;
			
			//5. prepare the move command to move UML element to their new owner
			MoveRequest moveRequest= new MoveRequest(targetOwner, eobjectTopaste);
			IElementEditService provider = ElementEditServiceUtils.getCommandProvider(targetOwner);
			if(provider != null) {
				command = provider.getEditCommand(moveRequest);
			}
		}
	}
/**
 * {@inheritDoc}
 */
	public void execute() {
		// for steps 1. 2. 3. 4. 5. see constructor
		//6. execute the move command for UML element
		if(command != null) {
			try {
				command.execute(new NullProgressMonitor(), null);
			} catch (ExecutionException e) {

			}
		}
		//7. move stereotypes applications into the resource
		Iterator<EObject> stereoApplIter= stereotypeApplicationTopaste.iterator();
		while (stereoApplIter.hasNext()) {
			EObject eObject = (EObject) stereoApplIter.next();
			targetOwner.eResource().getContents().add(eObject);


		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean canExecute() {
		if( command==null){
			return false;
		}
		return command.canExecute();
	}
	/**
	 * {@inheritDoc}
	 */
	public void redo() {
		// for steps 1. 2. 3. 4. 5. see constructor
		//6. execute the move command for UML element
		if(command != null) {
			try {
				command.redo(new NullProgressMonitor(), null);
			} catch (ExecutionException e) {

			}
		}
		//7. move stereotype application into the resource 
		Iterator<EObject> stereoApplIter= stereotypeApplicationTopaste.iterator();
		while (stereoApplIter.hasNext()) {
			EObject eObject = (EObject) stereoApplIter.next();
			targetOwner.eResource().getContents().add(eObject);


		}

	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void undo() {
		// for steps 1. 2. 3. 4. 5. see constructor
		//6. Undo the move command for UML element
		try {
			command.undo(new NullProgressMonitor(), null);
		} catch (ExecutionException e) {

		}
		//7. remove stereotype application from the resource
		Iterator<EObject> stereoApplIter= stereotypeApplicationTopaste.iterator();
		while (stereoApplIter.hasNext()) {
			EObject eObject = (EObject) stereoApplIter.next();
			targetOwner.eResource().getContents().remove(eObject);
		}
	}
}
