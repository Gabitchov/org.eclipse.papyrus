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
package org.eclipse.papyrus.infra.emf.compare.diff.internal.command;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
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
							attachRealPositionEAdapter(element, index);
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
									reorderList(values);
								}
							} else {
								((List)value).add(index, element);
								if(shouldReorder()) {
									reorderList((List)value);
								}
							}

						} else {
							((Collection)getTargetContainer().eGet(feature)).add(element);
							if(shouldReorder()) {
								reorderList((List)((Collection)getTargetContainer().eGet(feature)));
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

	/**
	 * Duplicate code from EFactory
	 * If we could not merge a given object at its expected position in a list, we'll attach an Adapter to it
	 * in order to "remember" that "expected" position. That will allow us to reorder the list later on if
	 * need be.
	 * 
	 * @param object
	 *        The object on which to attach an Adapter.
	 * @param expectedPosition
	 *        The expected position of <code>object</code> in its list.
	 */
	private void attachRealPositionEAdapter(final Object object, final int expectedPosition) {
		if(object instanceof EObject) {
			((EObject)object).eAdapters().add(new PositionAdapter(expectedPosition));
		}
	}

	/**
	 * Reorders the given list if it contains EObjects associated with a PositionAdapter which are not located
	 * at their expected positions.
	 * 
	 * @param list
	 *        The list that is to be reordered.
	 * @param <T>
	 *        type of the list's elements.
	 */
	private <T> void reorderList(final List<T> list) {
		List<T> newList = new ArrayList<T>(list);
		Collections.sort(newList, new EObjectComparator());
		for(int i = 0; i < list.size(); i++) {
			int oldIndex = list.indexOf(newList.get(i));
			list.add(i, list.remove(oldIndex));
		}
		return;
	}

	/**
	 * duplicate code from Efactory
	 * This adapter will be used to remember the accurate position of an EObject in its target list.
	 * 
	 * @author <a href="mailto:laurent.goubet@obeo.fr">Laurent Goubet</a>
	 */
	private static class PositionAdapter extends AdapterImpl {

		/** The index at which we expect to find this object. */
		private final int expectedIndex;

		/**
		 * Creates our adapter.
		 * 
		 * @param index
		 *        The index at which we expect to find this object.
		 */
		public PositionAdapter(final int index) {
			this.expectedIndex = index;
		}

		/**
		 * Returns the index at which we expect to find this object.
		 * 
		 * @return The index at which we expect to find this object.
		 */
		public int getExpectedIndex() {
			return expectedIndex;
		}
	}

	/**
	 * 
	 * This class allows to compare EObject using the PositionAdapter.
	 * 
	 * 
	 */
	private static class EObjectComparator<T> implements Comparator<T> {

		/**
		 * 
		 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
		 * 
		 * @param o1
		 * @param o2
		 * @return
		 */
		public int compare(final T o1, final T o2) {
			if(o1 instanceof EObject && o2 instanceof EObject) {
				final int position1 = getWantedPosition((EObject)o1);
				final int position2 = getWantedPosition((EObject)o2);
				if(position1 != -1 && position2 != -1) {
					return position1 - position2;
				}
			}
			return 0;
		}

		/**
		 * 
		 * @param obj1
		 *        an EObject
		 * @return
		 *         the wanted position for this object
		 */
		private int getWantedPosition(final EObject obj1) {
			final Iterator<Adapter> adapters = obj1.eAdapters().iterator();
			int expectedIndex = -1;
			while(expectedIndex == -1 && adapters.hasNext()) {
				final Adapter adapter = adapters.next();
				if(adapter instanceof PositionAdapter) {
					expectedIndex = ((PositionAdapter)adapter).getExpectedIndex();
				}
			}
			return expectedIndex;
		}

	}
}
