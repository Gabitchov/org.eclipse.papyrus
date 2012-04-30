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
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.compare.merger.utils;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.edit.command.MoveCommand;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.MoveElementsCommand;
import org.eclipse.gmf.runtime.emf.type.core.internal.l10n.EMFTypeCoreMessages;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.MoveRequest;

//TODO move this class and create it in the service edit
public class MoveWithIndexCommand extends MoveElementsCommand {

	public MoveWithIndexCommand(MoveRequest request) {
		super(request);
	}

	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		int index = getIndex();
		if(index != -1) {
			for(Iterator<?> i = getElementsToMove().keySet().iterator(); i.hasNext();) {
				EObject element = (EObject)i.next();
				EReference feature = getTargetFeature(element);

				if(feature != null) {
					if(FeatureMapUtil.isMany(getTargetContainer(), feature)) {
						Object value = getTargetContainer().eGet(feature);
						if(value instanceof List<?>) {
							List<?> listValue = (List<?>)value;
							int indexMax = listValue.size() - 1;
							if(indexMax < index) {
								//we add the element at the end of the list
								((Collection)getTargetContainer().eGet(feature)).add(element);
							} else {
								((List)value).add(index, element);
							}

						} else {
							((Collection)getTargetContainer().eGet(feature)).add(element);
						}
					} else {
						getTargetContainer().eSet(feature, element);
					}
				} else {
					return CommandResult.newErrorCommandResult(EMFTypeCoreMessages.moveElementsCommand_noTargetFeature);
				}
			}
			return CommandResult.newOKCommandResult();
		}
		return super.doExecuteWithResult(monitor, info);
	}

	/**
	 * 
	 * @return
	 *         the index for the move command
	 */
	protected int getIndex() {
		IEditCommandRequest req = getRequest();
		if(req instanceof MoveWithIndexRequest) {
			return ((MoveWithIndexRequest)req).getIndex();
		}
		return -1;
	}
}
