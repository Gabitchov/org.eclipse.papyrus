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
package org.eclipse.papyrus.infra.emf.compare.diff.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.compare.diff.merge.EMFCompareEObjectCopier;
import org.eclipse.emf.compare.diff.merge.IMergeListener;
import org.eclipse.emf.compare.diff.merge.IMerger;
import org.eclipse.emf.compare.diff.merge.MergeEvent;
import org.eclipse.emf.compare.diff.merge.service.MergeFactory;
import org.eclipse.emf.compare.diff.metamodel.ConflictingDiffElement;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.DiffGroup;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.diff.metamodel.DiffResourceSet;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.infra.emf.compare.diff.internal.command.FireMergeDiffEndCommand;
import org.eclipse.papyrus.infra.emf.compare.diff.internal.command.FireMergeDiffStartCommand;
import org.eclipse.papyrus.infra.emf.compare.diff.internal.command.FireMergeOperationEndCommand;
import org.eclipse.papyrus.infra.emf.compare.diff.internal.command.FireMergeOperationStartCommand;
import org.eclipse.papyrus.infra.emf.compare.diff.internal.merger.DiffGroupTransactionalMerger;
import org.eclipse.papyrus.infra.emf.compare.diff.internal.util.PapyrusCompareEObjectCopier;
import org.eclipse.papyrus.infra.emf.compare.diff.merge.ITransactionalMerger;



/**
 * 
 * This service should replace the EMF-Compare MergeService
 * 
 */
public class TransactionalMergeService {

	//	private static Method addMergeListenerMethod = null;
	//
	//	private static Method removeMergeListenerMethod = null;

	/** This copier will be used when merging references. */
	private static EMFCompareEObjectCopier copier;

	//	private static Object copier;


	/**
	 * Default constructor.
	 */
	private TransactionalMergeService() {
		// hides default constructor
	}

	//	/**
	//	 * TODO this method should be covered with a JUnit test
	//	 * Registers a new merge listener for notifications about merge operations. Has no effect if the listener
	//	 * is already registered.
	//	 * 
	//	 * @param listener
	//	 *        New Listener to register for notifications.
	//	 */
	//	public static void addMergeListener(final IMergeListener listener) {
	//		if(addMergeListenerMethod == null) {
	//			Class<?>[] parameterTypes = new Class[1];
	//			parameterTypes[0] = IMergeListener.class;
	//			try {
	//				addMergeListenerMethod = ReflectHelper.getMethod(MergeService.class, "addMergeListener", parameterTypes); //$NON-NLS-1$
	//			} catch (SecurityException e) {
	//				Activator.log.error(e);
	//			} catch (NoSuchMethodException e) {
	//				Activator.log.error(e);
	//			}
	//		}
	//		final Object[] parameters = new Object[1];
	//		parameters[0] = listener;
	//		try {
	//			addMergeListenerMethod.invoke(null, parameters);
	//		} catch (IllegalArgumentException e) {
	//			Activator.log.error(e);
	//		} catch (IllegalAccessException e) {
	//			Activator.log.error(e);
	//		} catch (InvocationTargetException e) {
	//			Activator.log.error(e);
	//		}
	//	}




	public static Command getMergeCommand(final TransactionalEditingDomain domain, final DiffElement element, final boolean leftToRight) {
		CompoundCommand cmd = new CompoundCommand("MergeCommand"); //$NON-NLS-1$
		cmd.append(new FireMergeOperationStartCommand(element, getMergeListeners()));
		cmd.append(getDoMergeCommand(domain, element, leftToRight));
		cmd.append(new FireMergeOperationEndCommand(element, getMergeListeners()));
		return cmd;
	}



	private static Command getDoMergeCommand(final TransactionalEditingDomain domain, final DiffElement element, final boolean leftToRight) {
		final CompoundCommand cmd = new CompoundCommand("DoMergeCommand"); //$NON-NLS-1$
		cmd.append(new FireMergeDiffStartCommand(element, getMergeListeners()));
		final ITransactionalMerger merger;
		//TODO post a bug to EMF-Compare -> we can't define our own merger for DiffGroup Element
		if(element instanceof DiffGroup) {
			merger = new DiffGroupTransactionalMerger();
			merger.setDiffElement(element);
		} else if(element instanceof ConflictingDiffElement) {
			merger = TransactionalMergeFactory.createMerger(element.getSubDiffElements().get(0));
		} else {
			merger = TransactionalMergeFactory.createMerger(element);
		}
		final Collection<DiffElement> alreadyManaged = new ArrayList<DiffElement>();
		if(merger instanceof ITransactionalMerger) {
			if(leftToRight) {
				cmd.append(((ITransactionalMerger)merger).getUndoInTargetCommand(domain, alreadyManaged));
			} else {
				cmd.append(((ITransactionalMerger)merger).getApplyInOriginCommand(domain, alreadyManaged));
			}
		} else {
			throw new UnsupportedOperationException(NLS.bind("I can't found the Papyrus Merger for {0}.", element)); //$NON-NLS-1$
		}
		alreadyManaged.clear();
		cmd.append(new FireMergeDiffEndCommand(element, getMergeListeners()));
		return cmd;
	}


	/**
	 * Execute the command to merge The DiffElement
	 * 
	 * @param domain
	 *        the {@link TransactionalEditingDomain}
	 * @param element
	 *        the DiffElement to merger
	 * @param leftToRight
	 *        <code>True</code> if the changes must be applied from the left to the right model, <code>False</code> when they have to be applied the
	 *        other way around.
	 */
	public static void merge(final TransactionalEditingDomain domain, final DiffElement element, boolean leftToRight) {
		final Command cmd = getMergeCommand(domain, element, leftToRight);
		domain.getCommandStack().execute(cmd);
	}

	/**
	 * Execute the command to merge The DiffElement
	 * 
	 * @param domain
	 *        the {@link TransactionalEditingDomain}
	 * @param elements
	 *        the elements to merge
	 * @param leftToRight
	 *        <code>True</code> if the changes must be applied from the left to the right model, <code>False</code> when they have to be applied the
	 *        other way around.
	 */
	public static void merge(final TransactionalEditingDomain domain, final List<DiffElement> elements, final boolean leftToRight) {
		final Command cmd = getMergeCommand(domain, elements, leftToRight);
		domain.getCommandStack().execute(cmd);
	}


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


	//	/**
	//	 * removes a merge listener from the list of registered listeners. This will have no effect if the given
	//	 * listener is not registered for notifications on this service.
	//	 * 
	//	 * @param listener
	//	 *        New Listener to register for notifications.
	//	 */
	//	public static void removeMergeListener(final IMergeListener listener) {
	//		if(removeMergeListenerMethod == null) {
	//			Class<?>[] parameterTypes = new Class[1];
	//			parameterTypes[0] = IMergeListener.class;
	//			try {
	//				removeMergeListenerMethod = ReflectHelper.getMethod(MergeService.class, "removeMergeListener", parameterTypes); //$NON-NLS-1$
	//			} catch (SecurityException e) {
	//				Activator.log.error(e);
	//			} catch (NoSuchMethodException e) {
	//				Activator.log.error(e);
	//			}
	//		}
	//		final Object[] parameters = new Object[1];
	//		parameters[0] = listener;
	//		try {
	//			removeMergeListenerMethod.invoke(null, parameters);
	//		} catch (IllegalArgumentException e) {
	//			Activator.log.error(e);
	//		} catch (IllegalAccessException e) {
	//			Activator.log.error(e);
	//		} catch (InvocationTargetException e) {
	//			Activator.log.error(e);
	//		}
	//	}


	//	@SuppressWarnings("unchecked")
	//	//we suppress this warning because the field is always a List of IMergeListener
	//	private static List<IMergeListener> getMergeListeners() {
	//		List<IMergeListener> listeners = null;
	//		Field myField = null;
	//		try {
	//			myField = MergeService.class.getDeclaredField("MERGE_LISTENERS"); //$NON-NLS-1$
	//		} catch (SecurityException e) {
	//			Activator.log.error(e);
	//		} catch (NoSuchFieldException e) {
	//			Activator.log.error(e);
	//		}
	//		myField.setAccessible(true);
	//		try {
	//			listeners = (List<IMergeListener>)myField.get(null);
	//		} catch (IllegalArgumentException e) {
	//			Activator.log.error(e);
	//		} catch (IllegalAccessException e) {
	//			Activator.log.error(e);
	//		}
	//		return listeners;
	//	}

	private static List<IMergeListener> getMergeListeners() {
		return MERGE_LISTENERS;
	}


	//FIXME : from HERE to the end : duplicated code from MergeService
	/** This copier will be used when merging references. */
	//	private static EMFCompareEObjectCopier copier;

	/**
	 * Holds a list of all the merge listeners registered for notifications on merge operations.
	 */
	private static final List<IMergeListener> MERGE_LISTENERS = new ArrayList<IMergeListener>();


	/**
	 * Registers a new merge listener for notifications about merge operations. Has no effect if the listener
	 * is already registered.
	 * 
	 * @param listener
	 *        New Listener to register for notifications.
	 */
	//TODO should be done with a command...
	public static void addMergeListener(IMergeListener listener) {
		MERGE_LISTENERS.add(listener);
	}

	/**
	 * Returns the copier given the diff it should merge.
	 * 
	 * @param diff
	 *        The DiffElement for which a copier is needed.
	 * @return The copier for a given diff.
	 */
	public static EMFCompareEObjectCopier getCopier(DiffElement diff) {
		final DiffModel diffModel = getContainerDiffModel(diff);
		if(diffModel == null)
			throw new IllegalArgumentException("The diff element should be contained in a DiffModel instance"); //$NON-NLS-1$
		if(diffModel.eContainer() instanceof DiffResourceSet) {
			if(copier == null) {
				copier = new PapyrusCompareEObjectCopier((DiffResourceSet)diffModel.eContainer());
			} else if(copier.getDiffResourceSet() != diffModel.eContainer()) {
				copier.clear();
				copier = new PapyrusCompareEObjectCopier((DiffResourceSet)diffModel.eContainer());
			}
		} else {
			if(copier == null) {
				copier = new PapyrusCompareEObjectCopier(diffModel);
			} else if(copier.getDiffModel() != diffModel) {
				copier.clear();
				copier = new PapyrusCompareEObjectCopier(diffModel);
			}
		}
		return copier;
	}

	/**
	 * Browse the diff model from the leaf to the top to find the containing {@link DiffModel} instance.
	 * 
	 * @param diff
	 *        any {@link DiffElement}.
	 * @return the containing {@link DiffModel} instance, null if not found.
	 */
	private static DiffModel getContainerDiffModel(DiffElement diff) {
		EObject container = diff.eContainer();
		while(container != null) {
			if(container instanceof DiffModel)
				return (DiffModel)container;
			container = container.eContainer();
		}
		return null;
	}

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
	public static void merge(DiffElement element, boolean leftToRight) {
		fireMergeOperationStart(element);
		doMerge(element, leftToRight);
		fireMergeOperationEnd(element);
	}

	/**
	 * Merges a list of DiffElements in the direction specified by <code>leftToRight</code>.
	 * <p>
	 * Will notify the list of its merge listeners before, and after the operation.
	 * </p>
	 * 
	 * @param elements
	 *        {@link DiffElement}s containing the information to merge.
	 * @param leftToRight
	 *        <code>True</code> if the changes must be applied from the left to the right model, <code>False</code> when they have to be applied the
	 *        other way around.
	 */
	public static void merge(List<DiffElement> elements, boolean leftToRight) {
		fireMergeOperationStart(elements);
		for(DiffElement element : new ArrayList<DiffElement>(elements))
			// we might remove the diff from the list before merging it
			// (eOpposite reference)
			if(element.eContainer() != null)
				doMerge(element, leftToRight);
		fireMergeOperationEnd(elements);
	}

	/**
	 * removes a merge listener from the list of registered listeners. This will have no effect if the given
	 * listener is not registered for notifications on this service.
	 * 
	 * @param listener
	 *        New Listener to register for notifications.
	 */
	//TODO should be done with a command
	public static void removeMergeListener(IMergeListener listener) {
		MERGE_LISTENERS.remove(listener);
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
	protected static void doMerge(DiffElement element, boolean leftToRight) {
		fireMergeDiffStart(element);
		final IMerger merger;
		if(element instanceof ConflictingDiffElement)
			merger = MergeFactory.createMerger(element.getSubDiffElements().get(0));
		else
			merger = MergeFactory.createMerger(element);
		if(leftToRight && merger.canUndoInTarget()) {
			merger.undoInTarget();
		} else if(!leftToRight && merger.canApplyInOrigin()) {
			merger.applyInOrigin();
		}
		fireMergeDiffEnd(element);
	}

	/**
	 * Notifies all registered listeners that a {@link DiffElement} has just been merged.
	 * 
	 * @param diff
	 *        {@link DiffElement} which has just been merged.
	 */
	protected static void fireMergeDiffEnd(DiffElement diff) {
		for(IMergeListener listener : MERGE_LISTENERS)
			listener.mergeDiffEnd(new MergeEvent(diff));
	}

	/**
	 * Notifies all registered listeners that a DiffElement is about to be merged.
	 * 
	 * @param diff
	 *        {@link DiffElement} which is about to be merged.
	 */
	protected static void fireMergeDiffStart(DiffElement diff) {
		for(IMergeListener listener : MERGE_LISTENERS)
			listener.mergeDiffStart(new MergeEvent(diff));
	}

	/**
	 * Notifies all registered listeners that a merge operation on a single diff just ended.
	 * 
	 * @param diff
	 *        {@link DiffElement} which has just been merged.
	 */
	protected static void fireMergeOperationEnd(DiffElement diff) {
		for(IMergeListener listener : MERGE_LISTENERS)
			listener.mergeOperationEnd(new MergeEvent(diff));
	}

	/**
	 * Notifies all registered listeners that a merge operation has ended for a list of differences.
	 * 
	 * @param diffs
	 *        {@link DiffElement}s which have been merged.
	 */
	protected static void fireMergeOperationEnd(List<DiffElement> diffs) {
		for(IMergeListener listener : MERGE_LISTENERS)
			listener.mergeOperationEnd(new MergeEvent(diffs));
	}

	/**
	 * Notifies all registered listeners that a merge operation is about to start for a single diff.
	 * 
	 * @param diff
	 *        {@link DiffElement} which is about to be merged.
	 */
	protected static void fireMergeOperationStart(DiffElement diff) {
		for(IMergeListener listener : MERGE_LISTENERS)
			listener.mergeOperationStart(new MergeEvent(diff));
	}

	/**
	 * Notifies all registered listeners that a merge operation is about to start for a list of differences.
	 * 
	 * @param diffs
	 *        {@link DiffElement}s which are about to be merged.
	 */
	protected static void fireMergeOperationStart(List<DiffElement> diffs) {
		for(IMergeListener listener : MERGE_LISTENERS)
			listener.mergeOperationStart(new MergeEvent(diffs));
	}

}
