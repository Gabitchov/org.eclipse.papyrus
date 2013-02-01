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
package org.eclipse.papyrus.infra.emf.compare.diff.internal.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.diff.merge.EMFCompareEObjectCopier;
import org.eclipse.emf.compare.diff.metamodel.ComparisonResourceSnapshot;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.diff.metamodel.DiffResourceSet;
import org.eclipse.emf.compare.match.metamodel.Match2Elements;
import org.eclipse.emf.compare.match.metamodel.MatchElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.emf.compare.diff.internal.command.PapyrusMergeCommandProvider;
import org.eclipse.papyrus.infra.emf.utils.ResourceUtils;

/**
 * 
 * This class copies the code of {@link EMFCompareEObjectCopier}, to do the actions with EMFCommands
 * 
 */
public class PapyrusCompareEObjectCopier extends EMFCompareEObjectCopier {

	/**
	 * the serial UID
	 */
	private static final long serialVersionUID = -6723632034214667973L;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param diff
	 */
	public PapyrusCompareEObjectCopier(final DiffResourceSet diff) {
		super(diff);
		throw new UnsupportedOperationException("not yet implemented");//we should initialize the map as it is done in the 2nd constructor //$NON-NLS-1$
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param diff
	 */
	public PapyrusCompareEObjectCopier(final DiffModel diff) {
		super(diff);
		final EObject container = diff.eContainer();
		if(container instanceof ComparisonResourceSnapshot) {
			final ComparisonResourceSnapshot snapshot = (ComparisonResourceSnapshot)container;
			final EList<MatchElement> matchedElements = snapshot.getMatch().getMatchedElements();
			for(MatchElement current : matchedElements) {
				if(current instanceof Match2Elements) {
					initializeCopier((Match2Elements)current);

				}
			}
		}
	}

	/**
	 * Initialize the copier with the couple of Object matched during the diff
	 * It is useful for comparison between stereotyped elements in the nested editor
	 * see bug 384490: [UML Compare] Comparison between stereotyped elements doesn't work in the nested Compare Editor
	 * 
	 * @param matchElement
	 * 
	 */
	protected void initializeCopier(final Match2Elements matchElement) {
		final EObject left = ((Match2Elements)matchElement).getLeftElement();
		final EObject right = ((Match2Elements)matchElement).getRightElement();
		put(left, right);
		put(right, left);
		for(final MatchElement current : matchElement.getSubMatchElements()) {
			if(current instanceof Match2Elements) {
				initializeCopier((Match2Elements)current);
			}
		}
	}

	/**
	 * Copy the XMi_ID only when the id doesn't exist in the target resource
	 * 
	 * @see org.eclipse.emf.compare.diff.merge.EMFCompareEObjectCopier#copyXMIIDs()
	 * 
	 */
	@Override
	public void copyXMIIDs() {
		for(final Map.Entry<EObject, EObject> entry : entrySet()) {
			final EObject original = entry.getKey();
			final EObject copy = entry.getValue();
			if(original.eResource() instanceof XMIResource && copy.eResource() instanceof XMIResource) {
				final XMIResource originResource = (XMIResource)original.eResource();
				final XMIResource copyResource = (XMIResource)copy.eResource();
				if(originResource.getID(original) != null) {
					if(original.eResource() == copy.eResource()) {
						final String currentID = originResource.getID(original);
						if(ResourceUtils.getAllResourceIds(copyResource).contains(currentID)) {
							continue;
						}
					}
					copyResource.setID(copy, originResource.getID(original));
					final TreeIterator<EObject> originalIterator = original.eAllContents();
					final TreeIterator<EObject> copyIterator = copy.eAllContents();
					while(originalIterator.hasNext() && copyIterator.hasNext()) {
						final EObject nextOriginalChild = originalIterator.next();
						final EObject nextCopyChild = copyIterator.next();
						if(nextOriginalChild.eResource() == nextCopyChild.eResource()) {
							final String currentID = originResource.getID(nextOriginalChild);
							if(ResourceUtils.getAllResourceIds(copyResource).contains(currentID)) {
								continue;
							}
						}
						copyResource.setID(nextCopyChild, originResource.getID(nextOriginalChild));
					}
				}
			}
		}
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
			throw new UnsupportedOperationException("Not yet supported"); //$NON-NLS-1$
		}
		if(matchedValue != null) {
			put(actualValue, matchedValue);

			final Object referenceValue = target.eGet(targetReference);
			if(referenceValue instanceof Collection<?>) {
				//tested with ReferenceChangeLefttargetExample
				return getAddAtIndexCommand(domain, target, targetReference, (Collection<EObject>)referenceValue, matchedValue, index);

			} else {
				//target.eSet(targetReference, matchedValue);
				//tested with the project UpdateReferenceExample2
				return PapyrusMergeCommandProvider.INSTANCE.getSetCommand(domain, target, targetReference, matchedValue);
			}
		}
		//tested with ReferenceChangeLefttargetExample2
		return getCopyValueReferenceCommand(domain, targetReference, target, actualValue, index);
	}

	private Command getCopyValueReferenceCommand(final TransactionalEditingDomain domain, final EReference targetReference, final EObject target, final EObject value, final int index) {
		final Command copyValueCommand = new GMFtoEMFCommandWrapper(new AbstractTransactionalCommand(domain, "", null) { //$NON-NLS-1$

			@Override
			protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
				final EObject copy;
				final EObject targetValue = PapyrusCompareEObjectCopier.this.get(value);
				if(targetValue != null) {
					copy = targetValue;
				} else {
					if(value.eResource() == null || value.eResource().getURI().isPlatformPlugin()) {
						// We can't copy that object
						copy = value;
					} else {
						copy = PapyrusCompareEObjectCopier.this.copy(value);
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
		return get(key);
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

	/**
	 * 
	 * This class allows to compare EObject using the PositionAdapter.
	 * 
	 * 
	 */
	private class EObjectComparator<T> implements Comparator<T> {

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
