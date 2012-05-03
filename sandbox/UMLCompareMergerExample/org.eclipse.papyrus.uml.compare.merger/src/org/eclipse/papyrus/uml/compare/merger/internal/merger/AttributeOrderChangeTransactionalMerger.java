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
package org.eclipse.papyrus.uml.compare.merger.internal.merger;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.compare.diff.internal.merge.impl.AttributeOrderChangeMerger;
import org.eclipse.emf.compare.diff.metamodel.AttributeOrderChange;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.tools.util.ReflectHelper;
import org.eclipse.papyrus.uml.compare.merger.Activator;
import org.eclipse.papyrus.uml.compare.merger.internal.utils.MergerUtils;
import org.eclipse.papyrus.uml.compare.merger.utils.ITransactionalMerger;
import org.eclipse.papyrus.uml.merger.internal.provider.PapyrusMergeCommandProvider;


public class AttributeOrderChangeTransactionalMerger extends AttributeOrderChangeMerger implements ITransactionalMerger {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.diff.merge.IMerger#applyInOrigin()
	 */
	@Override
	public void applyInOrigin() {
		if(MergerUtils.usePapyrusMerger()) {
			final TransactionalEditingDomain domain = MergerUtils.getEditingDomain();
			final Command cmd = getApplyInOriginCommand(domain);
			if(cmd.canExecute()) {
				domain.getCommandStack().execute(cmd);
			}
		} else {
			super.applyInOrigin();
		}
	}

	/**
	 * 
	 * @see org.eclipse.emf.compare.diff.merge.DefaultMerger#undoInTarget()
	 * 
	 */
	@Override
	public void undoInTarget() {
		if(MergerUtils.usePapyrusMerger()) {
			final TransactionalEditingDomain domain = MergerUtils.getEditingDomain();
			final Command cmd = getUndoInTargetCommand(domain);
			if(cmd.canExecute()) {
				domain.getCommandStack().execute(cmd);
			}
		} else {
			super.undoInTarget();
		}
	}

	public Command getApplyInOriginCommand(final TransactionalEditingDomain domain) {
		//		mergeRequiredDifferences(true);
		//		doApplyInOrigin();
		//		postProcess();
		CompoundCommand cmd = new CompoundCommand("Apply in Origin Command for AttributeOrderChangeMerger");
		cmd.append(getMergeRequiredDifferencesCommand(domain, true));
		cmd.append(getDoApplyInOriginCommand(domain));
		cmd.append(getPostProcessCommand(domain));
		return cmd;
	}

	public Command getUndoInTargetCommand(final TransactionalEditingDomain domain) {
		//		mergeRequiredDifferences(false);
		//		doUndoInTarget();
		//		postProcess();

		CompoundCommand cmd = new CompoundCommand("Undo In Target Command for AttributeOrderChangeMerger");
		cmd.append(getMergeRequiredDifferencesCommand(domain, false));
		cmd.append(getDoUndoInTargetCommand(domain));
		cmd.append(getPostProcessCommand(domain));
		return cmd;
	}

	public Command getDoApplyInOriginCommand(final TransactionalEditingDomain domain) {
		final AttributeOrderChange theDiff = (AttributeOrderChange)this.diff;
		final EAttribute attribute = theDiff.getAttribute();
		final EObject leftElement = theDiff.getLeftElement();
		final EObject rightElement = theDiff.getRightElement();

		final List<Object> leftList = (List<Object>)leftElement.eGet(attribute);
		final List<Object> rightList = (List<Object>)rightElement.eGet(attribute);

		/*
		 * We need to transform the "left" list into the "right" list, modulo missing values. In practical
		 * terms, this means that we'll simply leave untouched any element that has no match in the "right"
		 * list (elements that were deleted) while reordering the others in the order they have in the "right"
		 * list.
		 */
		final List<Object> leftCopy = new ArrayList<Object>(leftList);
		final List<Object> result = new ArrayList<Object>(leftList.size());
		// Add all unmatched values in the result list
		for(int i = 0; i < leftList.size(); i++) {
			final Object left = leftList.get(i);

			boolean hasMatch = false;
			for(int j = 0; !hasMatch && j < rightList.size(); j++) {
				hasMatch = !areDistinctValues(left, rightList.get(j));
			}

			if(!hasMatch) {
				leftCopy.remove(left);
				result.add(left);
			}
		}
		// Then reorder according to the right list's order
		for(int i = 0; i < rightList.size(); i++) {
			final Object right = rightList.get(i);

			Object leftMatch = null;
			for(int j = 0; leftMatch == null && j < leftCopy.size(); j++) {
				if(!areDistinctValues(right, leftCopy.get(j))) {
					leftMatch = leftCopy.get(j);
				}
			}

			if(leftMatch != null) {
				leftCopy.remove(leftMatch);
				result.add(leftMatch);
			}
		}
		// Finally, set the value of our attribute to this new list
		//			leftElement.eSet(attribute, result);
		return PapyrusMergeCommandProvider.INSTANCE.getSetCommand(domain, leftElement, attribute, result);
	}

	public Command getDoUndoInTargetCommand(final TransactionalEditingDomain domain) {
		final AttributeOrderChange theDiff = (AttributeOrderChange)this.diff;
		final EAttribute attribute = theDiff.getAttribute();
		final EObject leftElement = theDiff.getLeftElement();
		final EObject rightElement = theDiff.getRightElement();

		final List<Object> leftList = (List<Object>)leftElement.eGet(attribute);
		final List<Object> rightList = (List<Object>)rightElement.eGet(attribute);

		/*
		 * We need to transform the "right" list into the "left" list, modulo missing values. In practical
		 * terms, this means that we'll simply leave untouched any element that has no match in the "left"
		 * list (elements that were added) while reordering the others in the order they have in the "left"
		 * list.
		 */
		final List<Object> rightCopy = new ArrayList<Object>(rightList);
		final List<Object> result = new ArrayList<Object>(rightList.size());
		// Add all unmatched values in the result list
		for(int i = 0; i < rightList.size(); i++) {
			final Object right = rightList.get(i);

			boolean hasMatch = false;
			for(int j = 0; !hasMatch && j < leftList.size(); j++) {
				hasMatch = !areDistinctValues(right, leftList.get(j));
			}

			if(!hasMatch) {
				rightCopy.remove(right);
				result.add(right);
			}
		}
		// Then reorder according to the left list's order
		for(int i = 0; i < leftList.size(); i++) {
			final Object left = leftList.get(i);

			Object rightMatch = null;
			for(int j = 0; rightMatch == null && j < rightCopy.size(); j++) {
				if(!areDistinctValues(left, rightCopy.get(j))) {
					rightMatch = rightCopy.get(j);
				}
			}

			if(rightMatch != null) {
				rightCopy.remove(rightMatch);
				result.add(rightMatch);
			}
		}
		// Finally, set the value of our attribute to this new list
		//			rightElement.eSet(attribute, result);
		return PapyrusMergeCommandProvider.INSTANCE.getSetCommand(domain, rightElement, attribute, result);
	}

	public Command getMergeRequiredDifferencesCommand(final TransactionalEditingDomain domain, final boolean applyInOrigin) {
		// TODO the super method mergeRequiredDifferences should be rewritten to use cmd too
		return new GMFtoEMFCommandWrapper(new AbstractTransactionalCommand(domain, "Merge Required Differences", null) {

			@Override
			protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
				AttributeOrderChangeTransactionalMerger.this.mergeRequiredDifferences(applyInOrigin);
				return null;
			}
		});
	}

	public Command getPostProcessCommand(final TransactionalEditingDomain domain) {
		return new GMFtoEMFCommandWrapper(new AbstractTransactionalCommand(domain, "Merge Required Differences", null) {

			@Override
			protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
				AttributeOrderChangeTransactionalMerger.this.postProcess();
				return null;
			}
		});
	}

	/**
	 * This method uses the reflexive way to call the static method of the super class
	 * 
	 * @param left
	 *        the left object
	 * @param right
	 *        the right object
	 * @return
	 *         <code>true</code> if the 2 objects are dictinct.
	 */
	//TODO write a JUnit test to be sure that this methods is always accessible
	protected boolean areDistinctValues(final Object left, final Object right) {

		final Class<?>[] parameterTypes = new Class[2];
		parameterTypes[0] = java.lang.Object.class;
		parameterTypes[1] = java.lang.Object.class;
		Method m = null;
		try {
			m = ReflectHelper.getMethod(AttributeOrderChangeMerger.class, "areDistinctValues", parameterTypes);
		} catch (SecurityException e) {
			Activator.log.error(e);
		} catch (NoSuchMethodException e) {
			Activator.log.error(e);
		}

		Object[] parameters = new Object[2];
		parameters[0] = left;
		parameters[1] = right;

		Object result = null;
		try {
			result = m.invoke(AttributeOrderChangeMerger.class, parameters);
		} catch (IllegalArgumentException e) {
			Activator.log.error(e);
		} catch (IllegalAccessException e) {
			Activator.log.error(e);
		} catch (InvocationTargetException e) {
			Activator.log.error(e);
		}
		assert (result instanceof Boolean);
		return ((Boolean)result).booleanValue();
	}
}
