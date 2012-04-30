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

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.compare.EMFCompareMessages;
import org.eclipse.emf.compare.FactoryException;
import org.eclipse.emf.compare.util.EFactory;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.uml.compare.merger.Activator;
import org.eclipse.papyrus.uml.merger.provider.PapyrusMergeCommandProvider;

//TODO : merge with thepapyrus table command factory?
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
	
	public static final <T>  Command getEAddCommand(final TransactionalEditingDomain domain, final EObject object, final String name, final T arg, final int elementIndex) throws FactoryException {
		return getEAddCommand(domain,object, name, arg, elementIndex, false);
	}
	
	public static final <T> Command getEAddCommand(final TransactionalEditingDomain domain,final EObject object, final String name, final T arg, final int elementIndex, final boolean reorder) throws FactoryException {
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
				} if(manyValue instanceof Collection<?>) {
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
		if (list instanceof List) {
			if (arg != null) {
				List<?> newValue = new ArrayList((List<?>)list);
				((List<?>)newValue).remove(arg);
				return getEAddCommand(domain, object, name, newValue);
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
	 * If we could not merge a given object at its expected position in a list, we'll attach an Adapter to it
	 * in order to "remember" that "expected" position. That will allow us to reorder the list later on if
	 * need be.
	 * 
	 * @param object
	 *        The object on which to attach an Adapter.
	 * @param expectedPosition
	 *        The expected position of <code>object</code> in its list.
	 */
	public static void attachRealPositionEAdapter(final Object object, final int expectedPosition) {
		Class<?> myClass = null;
		try {
			myClass = Class.forName("org.eclipse.emf.compare.util.EFactory");
		} catch (ClassNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		Class[] parameterTypes = new Class[2];
		parameterTypes[0] = java.lang.Object.class;
		parameterTypes[1] = Integer.TYPE;
		Method m = null;

		try {
			m = myClass.getDeclaredMethod("attachRealPositionEAdapter", parameterTypes);
		} catch (SecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (NoSuchMethodException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		m.setAccessible(true);
		Object[] parameters = new Object[2];
		parameters[0] = object;
		parameters[1] = expectedPosition;

		Object result = null;
		try {
			result = m.invoke(myClass, parameters);
		} catch (IllegalArgumentException e) {
			Activator.log.error(e);
		} catch (IllegalAccessException e) {
			Activator.log.error(e);
		} catch (InvocationTargetException e) {
			Activator.log.error(e);
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
	public static <T> void reorderList(final List<T> list) {
		Class<?> myClass = null;
		try {
			myClass = Class.forName("org.eclipse.emf.compare.util.EFactory");
		} catch (ClassNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		Class[] parameterTypes = new Class[1];
		parameterTypes[0] = java.util.List.class;
		Method m = null;

		try {
			m = myClass.getDeclaredMethod("reorderList", parameterTypes);
		} catch (SecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (NoSuchMethodException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		m.setAccessible(true);
		Object[] parameters = new Object[1];
		parameters[0] = list;


		Object result = null;
		try {
			result = m.invoke(myClass, parameters);
		} catch (IllegalArgumentException e) {
			Activator.log.error(e);
		} catch (IllegalAccessException e) {
			Activator.log.error(e);
		} catch (InvocationTargetException e) {
			Activator.log.error(e);
		}


	}

	/**
	 * This method should never been called, except by copyCollection;
	 * This method allows to invoke the clone method on Cloneable object.
	 * 
	 * @param cloneable
	 *        a cloneable object
	 * @return
	 *         a copy of the cloned object
	 * @throws UnsupportedOperationException
	 *         used when the object is {@link Cloneable}, but not implemented (like LinkedList...)
	 */
	private static Object clone(final Cloneable cloneable) throws UnsupportedOperationException {
		Class<?> cloneableClass = cloneable.getClass();
		Method cloneMethod = null;
		Object newValue = null;
		try {
			cloneMethod = cloneableClass.getMethod("clone", new Class[0]);
		} catch (SecurityException e) {
			Activator.log.error(e);
		} catch (NoSuchMethodException e) {
			Activator.log.error(e);
		}
		cloneMethod.setAccessible(true);
		try {
			newValue = cloneMethod.invoke(cloneable, new Object[0]);
		} catch (IllegalArgumentException e) {
			Activator.log.error(e);
		} catch (IllegalAccessException e) {
			Activator.log.error(e);
		} catch (InvocationTargetException e) {
			Activator.log.error(e);
		} catch (UnsupportedOperationException e) {
			Activator.log.error(NLS.bind("I can't clone this object : {0}", cloneableClass), e);
			throw e;
		}
		return newValue;
	}

}
