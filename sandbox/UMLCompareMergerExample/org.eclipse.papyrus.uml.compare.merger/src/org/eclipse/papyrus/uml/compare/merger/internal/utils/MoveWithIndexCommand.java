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
package org.eclipse.papyrus.uml.compare.merger.internal.utils;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.MoveElementsCommand;
import org.eclipse.gmf.runtime.emf.type.core.internal.l10n.EMFTypeCoreMessages;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.MoveRequest;

//TODO move this class and create it in the service edit
//TODO : breaks this class into 2 classes : 1 for the move and another one for the reorder?
public class MoveWithIndexCommand extends MoveElementsCommand {

	/**
	 * 
	 * Constructor.
	 * 
	 * @param request
	 */
	public MoveWithIndexCommand(final MoveRequest request) {
		super(request);
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.emf.type.core.commands.MoveElementsCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor,
	 *      org.eclipse.core.runtime.IAdaptable)
	 * 
	 * @param monitor
	 * @param info
	 * @return
	 * @throws ExecutionException
	 */
	@Override
	protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
		final int index = getIndex();
		if(index != -1) {
			for(Iterator<?> i = getElementsToMove().keySet().iterator(); i.hasNext();) {
				final EObject element = (EObject)i.next();
				final EReference feature = getTargetFeature(element);
				if(feature != null) {
					if(FeatureMapUtil.isMany(getTargetContainer(), feature)) {
						if(shouldReorder()) {
							//we attach the real position to the object
							PapyrusEFactory.attachRealPositionEAdapter(element, index);
						}
						final Object value = getTargetContainer().eGet(feature);
						if(value instanceof List<?>) {
							final List<?> listValue = (List<?>)value;
							final int indexMax = listValue.size() - 1;
							if(indexMax < index) {
								//we add the element at the end of the list
								final List values = ((List<?>)getTargetContainer().eGet(feature));
								values.add(element);
								if(shouldReorder()) {
									PapyrusEFactory.reorderList(values);
								}
							} else {
								((List)value).add(index, element);
								if(shouldReorder()) {
									PapyrusEFactory.reorderList((List)value);
								}
							}

						} else {
							((Collection)getTargetContainer().eGet(feature)).add(element);
							if(shouldReorder()) {
								PapyrusEFactory.reorderList((List)((Collection)getTargetContainer().eGet(feature)));
							}
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

	@Override
	public boolean canExecute() {
		super.canExecute();
		return true;
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

	/**
	 * 
	 * @return
	 *         <code>true</code> when the list should be reorderded
	 */
	protected boolean shouldReorder() {
		final IEditCommandRequest req = getRequest();
		boolean shouldReoder = false;
		if(req instanceof MoveWithIndexRequest) {
			shouldReoder = ((MoveWithIndexRequest)req).shouldReoder();
		}
		return shouldReoder;
	}
}
