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
package org.eclipse.papyrus.uml.commands.command;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.MoveRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.uml.commands.Activator;
import org.eclipse.papyrus.uml.tools.utils.NamedElementUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.util.UMLUtil;


/**
 * this handler has in charge to exexute the paste of UML element with their applied stereotypes
 * 
 */
public class PasteElementCommand extends AbstractCommand {

	private static final String TARGET_OWNER = "Target_Owner"; //$NON-NLS-1$

	private static final String ADDITIONAL_DUPLICATED_ELEMENTS = "Additional_Duplicated_Elements"; //$NON-NLS-1$

	protected List<EObject> eobjectTopaste = null;

	protected List<EObject> stereotypeApplicationTopaste = null;

	protected EObject targetOwner;

	protected CompositeCommand command;


	/**
	 * get the command do the paste on the target owner
	 * 
	 * @param domain
	 *        the editing owner
	 * @param targetOwner
	 *        the element where the paste will be done
	 */
	public PasteElementCommand(EditingDomain domain, EObject targetOwner) {
		super();

		if(domain.getClipboard() != null) {
			//1. get Data from the clipboard
			Collection<Object> rawData = domain.getClipboard();

			//2. filter only EObject
			List<EObject> eobjectsTopaste = new ArrayList<EObject>();
			Iterator<Object> iterData = rawData.iterator();
			while(iterData.hasNext()) {
				Object object = iterData.next();
				if(object instanceof EObject) {
					eobjectsTopaste.add((EObject)object);
				}
			}

			// 2b retrieve now the original stereotype application
			List<EObject> originalStereotypeApplications = new ArrayList<EObject>();
			Iterator<EObject> selecIterator = eobjectsTopaste.iterator();
			while(selecIterator.hasNext()) {
				EObject eObject = selecIterator.next();

				if(eObject instanceof Element) {
					originalStereotypeApplications.addAll(((Element)eObject).getStereotypeApplications());
				}
				//copy stereotype contained into
				Iterator<EObject> iter = eObject.eAllContents();
				while(iter.hasNext()) {
					EObject subeObject = iter.next();
					if(subeObject instanceof Element) {
						originalStereotypeApplications.addAll(((Element)subeObject).getStereotypeApplications());
					}

				}
			}
			eobjectsTopaste.addAll(originalStereotypeApplications);

			//3. Copy all eObjects (inspired from PasteFromClipboardCommand)
			// Collection<EObject> duplicatedObject = EcoreUtil.copyAll(eobjectsTopaste);
			EcoreUtil.Copier copier = new EcoreUtil.Copier();
			copier.copyAll(eobjectsTopaste);
			copier.copyReferences();
			Map<EObject, EObject> duplicatedObjects = new HashMap<EObject, EObject>();
			duplicatedObjects.putAll(copier);

			//4. filter eobject that are UML elements and application of stereotypes
			Iterator<EObject> iter = duplicatedObjects.values().iterator();
			eobjectTopaste = new ArrayList<EObject>();
			stereotypeApplicationTopaste = new ArrayList<EObject>();
			while(iter.hasNext()) {
				EObject eObject = iter.next();
				boolean isaUMLElement = false;
				if(eObject instanceof Element) {
					isaUMLElement = true;
				}
				//functionality that comes from UML2 plugins
				Stereotype st = UMLUtil.getStereotype(eObject);
				if(isaUMLElement && !originalStereotypeApplications.contains(eObject)) {
					eobjectTopaste.add(eObject);
				}
			}

			// 4b retrieve stereotypeapplications to paste
			Iterator<EObject> stereotypeIterator = originalStereotypeApplications.listIterator();
			while(stereotypeIterator.hasNext()) {
				EObject originalStereotypeApp = stereotypeIterator.next();
				EObject duplicateStereotype = duplicatedObjects.get(originalStereotypeApp);
				if(duplicateStereotype == null) {
					Activator.log.debug("warning a stereotype could not be copied/paste : " + originalStereotypeApp);
				} else {
					stereotypeApplicationTopaste.add(duplicateStereotype);
				}
			}

			this.targetOwner = targetOwner;

			//5. prepare the move command to move UML element to their new owner
			//Nota: move only the "root" semantic elements to be paste
			List<EObject> objectsToMove = new ArrayList<EObject>();
			Iterator<EObject> it = eobjectsTopaste.iterator();
			while(it.hasNext()) {
				EObject eObject = it.next();
				boolean isaUMLElement = false;
				if(eObject instanceof Element) {
					isaUMLElement = true;
				}
				//functionality that comes from UML2 plugins
				if((isaUMLElement && !originalStereotypeApplications.contains(eObject))) {// UML element, but not a stereotype => should be moved
					// this is one of the original elements to paste, not a stereotype.
					// the copy of this one should be moved
					EObject copyObject = duplicatedObjects.get(eObject);
					if(copyObject != null) {
						objectsToMove.add(copyObject);
					}
				}
			}


			MoveRequest moveRequest = new MoveRequest(targetOwner, objectsToMove);
			IElementEditService provider = ElementEditServiceUtils.getCommandProvider(targetOwner);
			if(provider != null) {
				command = new CompositeCommand("Copy Object");
				command.compose(provider.getEditCommand(moveRequest));
			}

			renameDuplicatedObject(domain, targetOwner, objectsToMove, provider);

			ICommand externalObjectsDuplicateCommand = getExternalObjectsDuplicateCommand(duplicatedObjects, targetOwner);
			if(externalObjectsDuplicateCommand != null && command != null) {
				command.compose(externalObjectsDuplicateCommand);
			}

		}
	}

	
	/**
	 *  Rename duplicated objects
	 * @param domain
	 * @param targetOwner
	 * @param objectsToMove
	 * @param provider
	 */
	private void renameDuplicatedObject(EditingDomain domain,
			EObject targetOwner, List<EObject> objectsToMove,
			IElementEditService provider) {
		//5 bis. Rename the duplicated objects (only the root elements that are copied, no need to rename *all* nested elements)
		for(int i = 0; i < objectsToMove.size(); i++) {
			EObject element = objectsToMove.get(i);
			if(element instanceof NamedElement && domain instanceof TransactionalEditingDomain) {
				String incrementedName = NamedElementUtil.getDefaultCopyNameWithIncrement((NamedElement)element,targetOwner.eContents());
				SetRequest renameRequest = new SetRequest((TransactionalEditingDomain)domain, element, UMLFactory.eINSTANCE.getUMLPackage().getNamedElement_Name(), incrementedName);
				if(provider != null && command != null) {
					command.compose(provider.getEditCommand(renameRequest));
				}
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
				Activator.log.error(e);
			}
		}
		//7. move stereotypes applications into the resource
		Iterator<EObject> stereoApplIter = stereotypeApplicationTopaste.iterator();
		while(stereoApplIter.hasNext()) {
			EObject eObject = stereoApplIter.next();
			targetOwner.eResource().getContents().add(eObject);
		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean canExecute() {
		if(command == null) {
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
				Activator.log.error(e);
			}
		}
		//7. move stereotype application into the resource 
		Iterator<EObject> stereoApplIter = stereotypeApplicationTopaste.iterator();
		while(stereoApplIter.hasNext()) {
			EObject eObject = stereoApplIter.next();
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
			IProgressMonitor monitor = new NullProgressMonitor();
			command.undo(monitor, null);
		} catch (ExecutionException e) {
			Activator.log.error(e);
		}
		//7. remove stereotype application from the resource
		Iterator<EObject> stereoApplIter = stereotypeApplicationTopaste.iterator();
		while(stereoApplIter.hasNext()) {
			EObject eObject = stereoApplIter.next();
			targetOwner.eResource().getContents().remove(eObject);
		}
	}

	/**
	 * Returns the list of external objects to duplicate
	 * 
	 * @return the list of external objects to duplicate or an empty list if not elements are found to add.
	 */
	protected ICommand getExternalObjectsDuplicateCommand(Map duplicatedElementsMap, EObject targetOwner) {
		CompositeCommand result = new CompositeCommand("Additional Duplications");
		Set<Object> duplicatedExternalElements = new HashSet<Object>();

		for(Object o : duplicatedElementsMap.keySet()) {
			if(o instanceof EObject) {
				EObject object = (EObject)o;
				DuplicateElementsRequest request = new DuplicateElementsRequest(Collections.singletonList(object));
				request.setAllDuplicatedElementsMap(duplicatedElementsMap);
				request.setParameter(ADDITIONAL_DUPLICATED_ELEMENTS, duplicatedExternalElements);
				request.setParameter(TARGET_OWNER, targetOwner);
				IElementEditService service = ElementEditServiceUtils.getCommandProvider(object);
				ICommand command = service.getEditCommand(request);
				if(command != null) {
					result.add(command);
				}
			}
		}

		return result.isEmpty() ? null : result.reduce();
	}
}
