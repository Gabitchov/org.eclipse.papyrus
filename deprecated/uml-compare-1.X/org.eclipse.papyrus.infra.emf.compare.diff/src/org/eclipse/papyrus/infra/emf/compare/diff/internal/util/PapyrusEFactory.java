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

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.compare.EMFCompareMessages;
import org.eclipse.emf.compare.FactoryException;
import org.eclipse.emf.compare.util.EFactory;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.emf.compare.diff.internal.command.PapyrusMergeCommandProvider;

//TODO : merge with thepapyrus table command factory?
/**
 * 
 * This class is adapted from {@link EFactory}
 * 
 */
/**
 * 
 * This class is adapted from {@link EFactory}
 * 
 */
public class PapyrusEFactory {


	private PapyrusEFactory() {
		//nothing to do
	}

	public static final <T> Command getEAddCommand(final TransactionalEditingDomain domain, final EObject object, final String name, final T arg) throws FactoryException {
		return getEAddCommand(domain, object, name, arg, -1);
	}

	public static final <T> Command getEAddCommand(final TransactionalEditingDomain domain, final EObject object, final String name, final T arg, final int elementIndex) throws FactoryException {
		return getEAddCommand(domain, object, name, arg, elementIndex, false);
	}

	public static final <T> Command getEAddCommand(final TransactionalEditingDomain domain, final EObject object, final String name, final T arg, final int elementIndex, final boolean reorder) throws FactoryException {
		Command returnedCommand = null;
		final EStructuralFeature feature = eStructuralFeature(object, name);
		if(feature.isMany() && arg != null) {
			final Object manyValue = object.eGet(feature);
			//			if (manyValue instanceof InternalEList<?>) {
			//				final InternalEList<? super T> internalEList = (InternalEList<? super T>)manyValue;
			//				final int listSize = internalEList.size();
			//				if (elementIndex > -1 && elementIndex < listSize) {
			//					internalEList.addUnique(elementIndex, arg);
			//				} else {
			//					internalEList.addUnique(arg);
			//				}
			//				if (reorder) {
			//					attachRealPositionEAdapter(arg, elementIndex);
			//					reorderList(internalEList);
			//				}
			//			} else if (manyValue instanceof List<?>) {
			//				final List<? super T> list = (List<? super T>)manyValue;
			//				final int listSize = list.size();
			//				if (elementIndex > -1 && elementIndex < listSize) {
			//					list.add(elementIndex, arg);
			//				} else {
			//					list.add(arg);
			//				}
			//				if (reorder) {
			//					attachRealPositionEAdapter(arg, elementIndex);
			//					reorderList(list);
			//				}
			//			} else if (manyValue instanceof Collection<?>) {
			//				((Collection<? super T>)manyValue).add(arg);
			//			}

			if(manyValue instanceof Collection<?>) {
				List<Object> newValue = new ArrayList<Object>((Collection<?>)manyValue);
				final int listSize = newValue.size();
				if(manyValue instanceof List<?>) {
					if(elementIndex > -1 && elementIndex < listSize) {
						newValue.add(elementIndex, arg);
					} else {
						newValue.add(arg);
					}
					if(reorder) {
						attachRealPositionEAdapter(arg, elementIndex);
						reorderList((List<?>)newValue);
					}
				} else if(manyValue instanceof Collection<?>) {
					newValue.add(arg);
				}
				returnedCommand = PapyrusMergeCommandProvider.INSTANCE.getSetCommand(domain, object, feature, newValue);
			}
		} else if(!feature.isMany()) {
			//			eSet(object, name, arg);
			returnedCommand = PapyrusMergeCommandProvider.INSTANCE.getSetCommand(domain, object, feature, arg);
		}
		return returnedCommand;
	}

	//TODO not tested
	public static final Command getERemoveCommand(final TransactionalEditingDomain domain, final EObject object, final String name, final Object arg) throws FactoryException {
		//		final Object list = object.eGet(eStructuralFeature(object, name));
		//		if (list instanceof List) {
		//			if (arg != null) {
		//				((List<?>)list).remove(arg);
		//			}
		//		} else {
		//			eSet(object, name, null);
		//		}
		final Object list = object.eGet(eStructuralFeature(object, name));
		if(list instanceof List) {
			if(arg != null) {
				List<?> newValue = new ArrayList((List<?>)list);
				((List<?>)newValue).remove(arg);
				return getESetCommand(domain, object, name, newValue);
			}
		} else {
			return getESetCommand(domain, object, name, null);
		}
		return null;
	}

	/**
	 * 
	 * @param object
	 * @param name
	 * @param arg
	 * @return
	 * @throws FactoryException
	 */
	public static final Command getESetCommand(final TransactionalEditingDomain domain, final EObject object, final String name, final Object arg) throws FactoryException {
		Command returnedCommand;
		final EStructuralFeature feature = eStructuralFeature(object, name);
		if(!feature.isChangeable())
			throw new FactoryException(EMFCompareMessages.getString("EFactory.UnSettableFeature", name)); //$NON-NLS-1$

		if(feature.getEType() instanceof EEnum && arg instanceof String) {
			final EEnumLiteral literal = ((EEnum)feature.getEType()).getEEnumLiteral((String)arg);
			//object.eSet(feature, literal);
			returnedCommand = PapyrusMergeCommandProvider.INSTANCE.getSetCommand(domain, object, feature, literal);
		} else {
			if(arg == null && feature.isMany()) {
				//object.eSet(feature, Collections.EMPTY_LIST);
				returnedCommand = PapyrusMergeCommandProvider.INSTANCE.getSetCommand(domain, object, feature, Collections.EMPTY_LIST);
			} else if(arg == null) {
				//object.eSet(feature, feature.getDefaultValue());
				returnedCommand = PapyrusMergeCommandProvider.INSTANCE.getSetCommand(domain, object, feature, feature.getDefaultValue());
			} else {
				//object.eSet(feature, arg);
				returnedCommand = PapyrusMergeCommandProvider.INSTANCE.getSetCommand(domain, object, feature, arg);
			}
		}
		return returnedCommand;
	}


	public static EStructuralFeature eStructuralFeature(final EObject object, final String name) throws FactoryException {
		return EFactory.eStructuralFeature(object, name);
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
	private static void attachRealPositionEAdapter(final Object object, final int expectedPosition) {
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
	private static <T> void reorderList(final List<T> list) {
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
