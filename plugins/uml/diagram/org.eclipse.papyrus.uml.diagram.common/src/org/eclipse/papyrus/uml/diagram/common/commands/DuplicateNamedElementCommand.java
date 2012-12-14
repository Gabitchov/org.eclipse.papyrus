/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
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
package org.eclipse.papyrus.uml.diagram.common.commands;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.commands.DuplicateEObjectsCommand;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.uml.NamedElement;

/**
 * This command is used to prefix element by "Copy_Of" during the duplication
 */
public class DuplicateNamedElementCommand extends DuplicateEObjectsCommand {

	/** copy_of constant to prefix name of copied elements */
	public static final String COPY_OF = "Copy_Of_"; // //$NON-NLS-1$

	protected Object diagram;

	@SuppressWarnings("rawtypes")
	public DuplicateNamedElementCommand(TransactionalEditingDomain editingDomain, String label, List eObjectsToBeDuplicated, Map allDuplicatedObjectsMap, Diagram currentDiagram) {
		super(editingDomain, label, eObjectsToBeDuplicated, allDuplicatedObjectsMap);
		this.diagram = currentDiagram;
	}

	/**
	 * Executes this command by duplicating the original eobjects, adding the
	 * duplicates to the original's container, and populating the map of
	 * duplicates to be returned.
	 * 
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
		super.doExecuteWithResult(progressMonitor, info);
		ArrayList<EObject> processedData = new ArrayList<EObject>();
		NamedElement namedElement = null;

		// for all selected object, will get the duplicate one and change its name (if valid)
		Iterator iterator = getObjectsToBeDuplicated().iterator();

		while(iterator.hasNext()) {
			Object o = iterator.next();
			// get Duplicated object for this
			Object currentObject = getAllDuplicatedObjectsMap().get(o);
			if(currentObject instanceof View) {
				if(((View)currentObject).getElement() != null && ((View)currentObject).getElement() instanceof NamedElement) {
					namedElement = ((NamedElement)((View)currentObject).getElement());
					if(!processedData.contains(namedElement)) {
						namedElement.setName(computeNewName(namedElement.getName(), namedElement.eContainer().eContents()));
						processedData.add(namedElement);
					}
				}

			} else if(currentObject instanceof NamedElement) {
				namedElement = ((NamedElement)currentObject);
				if(!processedData.contains(namedElement)) {
					namedElement.setName(computeNewName(namedElement.getName(), namedElement.eContainer().eContents()));
					processedData.add(namedElement);
				}
			}
		}

		iterator = getAllDuplicatedObjectsMap().values().iterator();
		while(iterator.hasNext()) {
			Object currentObject = iterator.next();
			if((currentObject instanceof EObject) && (((EObject)currentObject).eContainer() == null) && (((EObject)currentObject).eResource() == null)) {
				namedElement.eResource().getContents().add((EObject)currentObject);
			}
		}
		return CommandResult.newOKCommandResult(getAllDuplicatedObjectsMap());
	}

	/**
	 * Computes and sets the new name for an element.
	 * 
	 * @param baseName
	 *        the name from which to comupte the new name
	 * @param siblings
	 *        list of siblings from which to compare to find the new name
	 */
	public static String computeNewName(String baseName, List<EObject> siblings) {
		int max = 0;
		EObject maxObject = null;
		if(baseName == null) {
			return "";
		}
		if(siblings == null) {
			return baseName;
		}

		// compute base.
		// if it contains Copy_Of, do not add it
		// then look for the last '_' and remove it
		// This will be the base for the computation of max elements.

		int lowIndex = (baseName.startsWith(COPY_OF) ? COPY_OF.length() : 0);
		int tmp = baseName.lastIndexOf("_");
		int maxIndex = baseName.length();
		if(tmp < maxIndex && tmp > 0) {
			maxIndex = tmp;
		}

		if(maxIndex < lowIndex) { // check we are in the valid bounds of the upcoming substring method
			maxIndex = lowIndex;
		}

		String base = COPY_OF + baseName.substring(lowIndex, maxIndex) + "_";

		if(siblings != null) {
			for(EObject o : siblings) {
				if(o != null) {
					String name = EMFCoreUtil.getName(o);
					if(name != null && name.startsWith(base)) {
						String end = name.substring(base.length()); // for the "_" at the end
						int nextNumberTmp = 1;
						if(end != null && end.length() > 0) {
							try {
								nextNumberTmp = Integer.parseInt(end);
							} catch (NumberFormatException ex) {
							}
						}

						if(nextNumberTmp > max && !o.equals(maxObject)) {
							max = nextNumberTmp;
							maxObject = (EObject)o;
						}
					}
				}
			}
		}
		max++;
		return base + max;
	}

}
