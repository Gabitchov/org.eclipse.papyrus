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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.diff.merge.EMFCompareEObjectCopier;
import org.eclipse.emf.compare.diff.merge.service.MergeService;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.uml.merger.provider.PapyrusMergeCommandProvider;

/**
 * 
 * This class copies the code of {@link EMFCompareEObjectCopier}, to do the actions with EMFCommands
 * 
 */
public class PapyrusCompareEObjectCopier {

	/**
	 * we encapsulate the "standard" implementation of {@link EMFCompareEObjectCopier}
	 */
	private EMFCompareEObjectCopier copier = null;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param diff
	 *        a diff element
	 */
	public PapyrusCompareEObjectCopier(final DiffElement diff) {
		copier = MergeService.getCopier(diff);
	}

	/**
	 * Adapted from copyReferenceValue(EReference targetReference, EObject target, EObject value,
	 * EObject matchedValue, int index)
	 * 
	 * @param targetReference
	 * @param target
	 * @param value
	 * @param matchedValue
	 * @param index
	 * @return
	 */
	public Command getCopyReferenceValueCommand(final TransactionalEditingDomain domain, final EReference targetReference, final EObject target, final EObject value, final EObject matchedValue, final int index) {
		EObject actualValue = value;
		if(value == null && matchedValue != null) {
			//			handleLinkedResourceDependencyChange(matchedValue);
			//			actualValue = get(matchedValue);
			//TODO
			throw new UnsupportedOperationException("Not yet supported");
		}
		if(matchedValue != null) {
			this.copier.put(actualValue, matchedValue);

			final Object referenceValue = target.eGet(targetReference);
			if(referenceValue instanceof Collection<?>) {
				//tested with ReferenceChangeLefttargetExample
				return getAddAtIndexCommand(domain, target, targetReference, (Collection<EObject>)referenceValue, matchedValue, index);

			} else {
				//target.eSet(targetReference, matchedValue);
				//tested with the project UpdateReferenceExample2
				return PapyrusMergeCommandProvider.INSTANCE.getSetCommand(domain, target, targetReference, targetReference);
			}
		}
		//tested with ReferenceChangeLefttargetExample2
		return getCopyValueReferenceCommand(domain, targetReference, target, actualValue, index);
	}

	private Command getCopyValueReferenceCommand(final TransactionalEditingDomain domain, final EReference targetReference, final EObject target, final EObject value, final int index) {
		final Command copyValueCommand = new GMFtoEMFCommandWrapper(new AbstractTransactionalCommand(domain, "", null) {

			@Override
			protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
				final EObject copy;
				final EObject targetValue = PapyrusCompareEObjectCopier.this.copier.get(value);
				if(targetValue != null) {
					copy = targetValue;
				} else {
					if(value.eResource() == null || value.eResource().getURI().isPlatformPlugin()) {
						// We can't copy that object
						copy = value;
					} else {
						copy = PapyrusCompareEObjectCopier.this.copier.copy(value);
					}
				}
				Command cmd = null;
				final Object referenceValue = target.eGet(targetReference);
				if(referenceValue instanceof List && targetReference.isMany()) {
					if(copy.eIsProxy() && copy instanceof InternalEObject) {
						// only add if the element is not already there.
						final URI proxURI = ((InternalEObject)copy).eProxyURI();
						boolean found = false;
						final Iterator<EObject> it = ((List<EObject>)referenceValue).iterator();
						while(!found && it.hasNext()) {
							final EObject obj = it.next();
							if(obj instanceof InternalEObject) {
								found = proxURI.equals(((InternalEObject)obj).eProxyURI());
							}
						}
						if(!found) {
							final List<EObject> targetList = (List<EObject>)referenceValue;
							//addAtIndex(targetList, copy, index);
							//not tested
							cmd = getAddAtIndexCommand(domain, target, targetReference, targetList, copy, index);
						}
					} else {
						final List<EObject> targetList = (List<EObject>)referenceValue;
						final int currentIndex = targetList.indexOf(copy);
						if(currentIndex == -1) {
							//addAtIndex(targetList, copy, index);
							//not tested
							cmd = getAddAtIndexCommand(domain, target, targetReference, targetList, copy, index);
						} else {
							// The order could be wrong in case of eOpposites
							//							movetoIndex(targetList, currentIndex, index);
							cmd = getMoveAtIndexCommand(domain, target, targetList, targetReference, copy, currentIndex, index);
							//							throw new UnsupportedOperationException("Not yet supported");
						}
					}
				} else {
					if(copy.eIsProxy() && copy instanceof InternalEObject) {
						// only change value if the URI changes
						final URI proxURI = ((InternalEObject)copy).eProxyURI();
						if(referenceValue instanceof InternalEObject) {
							if(!proxURI.equals(((InternalEObject)referenceValue).eProxyURI())) {
								//not tested
								//target.eSet(targetReference, copy);
								cmd = PapyrusMergeCommandProvider.INSTANCE.getSetCommand(domain, target, targetReference, copy);
							}
						}
					} else {
						//not tested
						//target.eSet(targetReference, copy);
						cmd = PapyrusMergeCommandProvider.INSTANCE.getSetCommand(domain, target, targetReference, copy);
					}
				}

				if(cmd != null) {
					cmd.execute();
				}
				return CommandResult.newOKCommandResult();
			}

		});
		return copyValueCommand;
	}

	/**
	 * 
	 * @param key
	 * @return
	 *         the copied object
	 */
	public EObject getCopiedValue(final EObject key) {
		return this.copier.get(key);
	}


	private Command getMoveAtIndexCommand(final TransactionalEditingDomain domain, final EObject target, final List<EObject> targetList, final EReference targetReference, final EObject copy, final int currentIndex, final int expectedIndex) {
		final List<EObject> newColl = new ArrayList<EObject>(targetList);
		final int size = targetList.size();
		if(size <= 1 || currentIndex < 0 || currentIndex >= size) {
			//					return;
			//do nothing
		} else if(expectedIndex != -1 && expectedIndex != currentIndex && expectedIndex <= size - 1) {
			newColl.add(expectedIndex, newColl.remove(currentIndex));
		}

		return PapyrusMergeCommandProvider.INSTANCE.getSetCommand(domain, target, targetReference, newColl);
	}

	/**
	 * Returns the command to set the wanted object at the wanted index
	 * 
	 * @param domain
	 * @param editedElement
	 * @param feature
	 * @param collection
	 * @param newValue
	 * @param index
	 * @return
	 */
	private Command getAddAtIndexCommand(final TransactionalEditingDomain domain, final EObject editedElement, final EStructuralFeature feature, final Collection<EObject> collection, final EObject newValue, final int index) {
		final List<EObject> newColl = new ArrayList<EObject>(collection);
		final int listSize = collection.size();
		if(index > -1 && index < listSize) {
			newColl.add(index, newValue);
		} else {
			newColl.add(newValue);
		}
		attachRealPositionEAdapter(newValue, index);
		reorderList(newColl);
		return PapyrusMergeCommandProvider.INSTANCE.getSetCommand(domain, editedElement, feature, newColl);
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
	 * Duplicate code from EFactory
	 * Reorders the given list if it contains EObjects associated with a PositionAdapter which are not located
	 * at their expected positions.
	 * 
	 * @param list
	 *        The list that is to be reordered.
	 * @param <T>
	 *        type of the list's elements.
	 */
	private <T> void reorderList(final List<T> list) {
		final List<T> newList = new ArrayList<T>(list);
		Collections.sort(newList, new EObjectComparator());
		for(int i = 0; i < list.size(); i++) {
			int oldIndex = list.indexOf(newList.get(i));
			list.add(i, list.remove(oldIndex));
		}
		return;
	}


	/**
	 * This class exists in several classes of this plugin. It is not an error : the same obejct can be referenced by different
	 * feature and different position at the same time. So we need to have a class PositionAdapter for each context!
	 * duplicate code from Efactory
	 * This adapter will be used to remember the accurate position of an EObject in its target list.
	 * 
	 * @author <a href="mailto:laurent.goubet@obeo.fr">Laurent Goubet</a>
	 */
	private class PositionAdapter extends AdapterImpl {

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

}
