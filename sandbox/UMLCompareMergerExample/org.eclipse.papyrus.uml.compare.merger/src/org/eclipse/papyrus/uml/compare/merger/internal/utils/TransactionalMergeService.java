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

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.compare.diff.merge.IMergeListener;
import org.eclipse.emf.compare.diff.merge.IMerger;
import org.eclipse.emf.compare.diff.merge.service.MergeFactory;
import org.eclipse.emf.compare.diff.merge.service.MergeService;
import org.eclipse.emf.compare.diff.metamodel.ConflictingDiffElement;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.infra.tools.util.ReflectHelper;
import org.eclipse.papyrus.uml.compare.merger.Activator;
import org.eclipse.papyrus.uml.compare.merger.internal.commands.FireMergeDiffEndCommand;
import org.eclipse.papyrus.uml.compare.merger.internal.commands.FireMergeDiffStartCommand;
import org.eclipse.papyrus.uml.compare.merger.internal.commands.FireMergeOperationEndCommand;
import org.eclipse.papyrus.uml.compare.merger.internal.commands.FireMergeOperationStartCommand;
import org.eclipse.papyrus.uml.compare.merger.utils.ITransactionalMerger;

/**
 * 
 * This service should replace the EMF-Compare MergeService
 * 
 */
//TODO not used
public class TransactionalMergeService {

	private static Method addMergeListenerMethod = null;

	private static Method removeMergeListenerMethod = null;

	//	/** This copier will be used when merging references. */
	//	private static EMFCompareEObjectCopier copier;

	/**
	 * Default constructor.
	 */
	private TransactionalMergeService() {
		// hides default constructor
	}

	/**
	 * TODO this method should be covered with a JUnit test
	 * Registers a new merge listener for notifications about merge operations. Has no effect if the listener
	 * is already registered.
	 * 
	 * @param listener
	 *        New Listener to register for notifications.
	 */
	public static void addMergeListener(final IMergeListener listener) {
		if(addMergeListenerMethod == null) {
			Class<?>[] parameterTypes = new Class[1];
			parameterTypes[0] = IMergeListener.class;
			try {
				addMergeListenerMethod = ReflectHelper.getMethod(MergeService.class, "addMergeListener", parameterTypes); //$NON-NLS-1$
			} catch (SecurityException e) {
				Activator.log.error(e);
			} catch (NoSuchMethodException e) {
				Activator.log.error(e);
			}
		}
		final Object[] parameters = new Object[1];
		parameters[0] = listener;
		try {
			addMergeListenerMethod.invoke(null, parameters);
		} catch (IllegalArgumentException e) {
			Activator.log.error(e);
		} catch (IllegalAccessException e) {
			Activator.log.error(e);
		} catch (InvocationTargetException e) {
			Activator.log.error(e);
		}
	}


	//	/**
	//	 * Returns the copier given the diff it should merge.
	//	 * 
	//	 * @param diff
	//	 *            The DiffElement for which a copier is needed.
	//	 * @return The copier for a given diff.
	//	 */
	//	public static EMFCompareEObjectCopier getCopier(final DiffElement diff) {
	//		final DiffModel diffModel = getContainerDiffModel(diff);
	//		if (diffModel == null)
	//			throw new IllegalArgumentException("The diff element should be contained in a DiffModel instance"); //$NON-NLS-1$
	//		if (diffModel.eContainer() instanceof DiffResourceSet) {
	//			if (copier == null) {
	//				copier = new EMFCompareEObjectCopier((DiffResourceSet)diffModel.eContainer());
	//			} else if (copier.getDiffResourceSet() != diffModel.eContainer()) {
	//				copier.clear();
	//				copier = new EMFCompareEObjectCopier((DiffResourceSet)diffModel.eContainer());
	//			}
	//		} else {
	//			if (copier == null) {
	//				copier = new EMFCompareEObjectCopier(diffModel);
	//			} else if (copier.getDiffModel() != diffModel) {
	//				copier.clear();
	//				copier = new EMFCompareEObjectCopier(diffModel);
	//			}
	//		}
	//		return copier;
	//	}

	//	/**
	//	 * Browse the diff model from the leaf to the top to find the containing {@link DiffModel} instance.
	//	 * 
	//	 * @param diff
	//	 *            any {@link DiffElement}.
	//	 * @return the containing {@link DiffModel} instance, null if not found.
	//	 */
	//	private static DiffModel getContainerDiffModel(final DiffElement diff) {
	//		EObject container = diff.eContainer();
	//		while (container != null) {
	//			if (container instanceof DiffModel)
	//				return (DiffModel)container;
	//			container = container.eContainer();
	//		}
	//		return null;
	//	}

	/**
	 * Merges a single DiffElement in the direction specified by <code>leftToRight</code>.
	 * <p>
	 * Will notify the list of its merge listeners before, and after the operation.
	 * </p>
	 * 
	 * @param element
	 *        {@link DiffElement} containing the information to merge.
	 * @param leftToRight
	 *        <code>True</code> if the changes must be applied from the left to the right model, <code>False</code> when they have to be applied the
	 *        other way around.
	 */
	//	public static void merge(final DiffElement element, final boolean leftToRight) {
	//		fireMergeOperationStart(element);
	//		doMerge(element, leftToRight);
	//		fireMergeOperationEnd(element);
	//	}

	public static Command getMergeCommand(final TransactionalEditingDomain domain, final DiffElement element, final boolean leftToRight) {
		CompoundCommand cmd = new CompoundCommand("MergeCommand"); //$NON-NLS-1$
		cmd.append(new FireMergeOperationStartCommand(element, getMergeListeners()));
		cmd.append(getDoMergeCommand(domain, element, leftToRight));
		cmd.append(new FireMergeOperationEndCommand(element, getMergeListeners()));
		return cmd;
	}

	/**
	 * Applies the changes implied by a given {@link DiffElement} in the direction specified by <code>leftToRight</code>.
	 * <p>
	 * Will notify the list of its merge listeners before, and after the merge.
	 * </p>
	 * 
	 * @param element
	 *        {@link DiffElement} containing the information to merge.
	 * @param leftToRight
	 *        <code>True</code> if the changes must be applied from the left to the right model, <code>False</code> when they have to be applied the
	 *        other way around.
	 */
	//	protected static void doMerge(final DiffElement element, final boolean leftToRight) {
	//		fireMergeDiffStart(element);
	//		final IMerger merger;
	//		if(element instanceof ConflictingDiffElement)
	//			merger = MergeFactory.createMerger(element.getSubDiffElements().get(0));
	//		else
	//			merger = MergeFactory.createMerger(element);
	//		if(leftToRight && merger.canUndoInTarget()) {
	//			merger.undoInTarget();
	//		} else if(!leftToRight && merger.canApplyInOrigin()) {
	//			merger.applyInOrigin();
	//		}
	//		fireMergeDiffEnd(element);
	//	}

	private static Command getDoMergeCommand(final TransactionalEditingDomain domain, final DiffElement element, final boolean leftToRight) {
		final CompoundCommand cmd = new CompoundCommand("DoMergeCommand"); //$NON-NLS-1$
		cmd.append(new FireMergeDiffStartCommand(element, getMergeListeners()));
		final IMerger merger;
		if(element instanceof ConflictingDiffElement) {
			merger = MergeFactory.createMerger(element.getSubDiffElements().get(0));
		} else {
			merger = MergeFactory.createMerger(element);
		}
		if(merger instanceof ITransactionalMerger) {
			if(leftToRight && merger.canUndoInTarget()) {
				cmd.append(((ITransactionalMerger)merger).getUndoInTargetCommand(domain));
			} else if(!leftToRight && merger.canApplyInOrigin()) {
				cmd.append(((ITransactionalMerger)merger).getApplyInOriginCommand(domain));
			}
		} else {
			throw new UnsupportedOperationException(NLS.bind("I can't found the Papyrus Merger for {0}.", element)); //$NON-NLS-1$
		}

		cmd.append(new FireMergeDiffEndCommand(element, getMergeListeners()));
		return cmd;
	}


	//	/**
	//	 * Merges a list of DiffElements in the direction specified by <code>leftToRight</code>.
	//	 * <p>
	//	 * Will notify the list of its merge listeners before, and after the operation.
	//	 * </p>
	//	 * 
	//	 * @param elements
	//	 *        {@link DiffElement}s containing the information to merge.
	//	 * @param leftToRight
	//	 *        <code>True</code> if the changes must be applied from the left to the right model, <code>False</code> when they have to be applied the
	//	 *        other way around.
	//	 */
	//	public static void merge(final List<DiffElement> elements, final boolean leftToRight) {
	//		fireMergeOperationStart(elements);
	//		for(DiffElement element : new ArrayList<DiffElement>(elements))
	//			// we might remove the diff from the list before merging it
	//			// (eOpposite reference)
	//			if(element.eContainer() != null)
	//				doMerge(element, leftToRight);
	//		fireMergeOperationEnd(elements);
	//	}

	public static Command getMergeCommand(final TransactionalEditingDomain domain, final List<DiffElement> elements, final boolean leftToRight) {
		final CompoundCommand cmd = new CompoundCommand("MergeCommand"); //$NON-NLS-1$
		cmd.append(new FireMergeOperationStartCommand(elements, getMergeListeners()));
		for(DiffElement element : new ArrayList<DiffElement>(elements)) {
			// we might remove the diff from the list before merging it
			// (eOpposite reference)
			if(element.eContainer() != null) {
				cmd.append(getDoMergeCommand(domain, element, leftToRight));
			}
		}
		cmd.append(new FireMergeOperationEndCommand(elements, getMergeListeners()));
		return cmd;
	}

	/**
	 * removes a merge listener from the list of registered listeners. This will have no effect if the given
	 * listener is not registered for notifications on this service.
	 * 
	 * @param listener
	 *        New Listener to register for notifications.
	 */
	public static void removeMergeListener(final IMergeListener listener) {
		if(removeMergeListenerMethod == null) {
			Class<?>[] parameterTypes = new Class[1];
			parameterTypes[0] = IMergeListener.class;
			try {
				removeMergeListenerMethod = ReflectHelper.getMethod(MergeService.class, "removeMergeListener", parameterTypes); //$NON-NLS-1$
			} catch (SecurityException e) {
				Activator.log.error(e);
			} catch (NoSuchMethodException e) {
				Activator.log.error(e);
			}
		}
		final Object[] parameters = new Object[1];
		parameters[0] = listener;
		try {
			removeMergeListenerMethod.invoke(null, parameters);
		} catch (IllegalArgumentException e) {
			Activator.log.error(e);
		} catch (IllegalAccessException e) {
			Activator.log.error(e);
		} catch (InvocationTargetException e) {
			Activator.log.error(e);
		}
	}


	@SuppressWarnings("unchecked")
	//we suppress this warning because the field is always a List of IMergeListener
	private static List<IMergeListener> getMergeListeners() {
		List<IMergeListener> listeners = null;
		Field myField = null;
		try {
			myField = MergeService.class.getDeclaredField("MERGE_LISTENERS"); //$NON-NLS-1$
		} catch (SecurityException e) {
			Activator.log.error(e);
		} catch (NoSuchFieldException e) {
			Activator.log.error(e);
		}
		myField.setAccessible(true);
		try {
			listeners = (List<IMergeListener>)myField.get(null);
		} catch (IllegalArgumentException e) {
			Activator.log.error(e);
		} catch (IllegalAccessException e) {
			Activator.log.error(e);
		}
		return listeners;
	}

}
