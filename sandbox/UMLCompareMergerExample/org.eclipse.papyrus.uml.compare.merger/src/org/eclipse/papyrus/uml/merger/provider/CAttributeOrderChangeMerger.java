package org.eclipse.papyrus.uml.merger.provider;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.compare.diff.internal.merge.impl.AttributeOrderChangeMerger;
import org.eclipse.emf.compare.diff.metamodel.AttributeOrderChange;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.uml.compare.merger.Activator;
import org.eclipse.papyrus.uml.compare.merger.utils.MergerUtils;


public class CAttributeOrderChangeMerger extends AttributeOrderChangeMerger {


	@Override
	public void doApplyInOrigin() {
		if(MergerUtils.usePapyrusMerger()) {
			TransactionalEditingDomain domain = MergerUtils.getEditingDomain();
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
			Command command = PapyrusMergeCommandProvider.INSTANCE.getSetCommand(domain, leftElement, attribute, result);
			domain.getCommandStack().execute(command);
		} else {
			super.doApplyInOrigin();
		}
	}

	@Override
	public void doUndoInTarget() {
		if(MergerUtils.usePapyrusMerger()) {
			TransactionalEditingDomain domain = MergerUtils.getEditingDomain();
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
			Command command = PapyrusMergeCommandProvider.INSTANCE.getSetCommand(domain, rightElement, attribute, result);
			domain.getCommandStack().execute(command);
		} else {
			super.doUndoInTarget();
		}
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
	protected boolean areDistinctValues(final Object left, final Object right) {
		AttributeOrderChangeMerger myClass = new AttributeOrderChangeMerger();
		Class[] parameterTypes = new Class[2];
		parameterTypes[0] = java.lang.Object.class;
		parameterTypes[1] = java.lang.Object.class;
		Method m = null;
		try {
			m = myClass.getClass().getDeclaredMethod("areDistinctValues", parameterTypes);
		} catch (SecurityException e) {
			Activator.log.error(e);
		} catch (NoSuchMethodException e) {
			Activator.log.error(e);
		}
		m.setAccessible(true);

		Object[] parameters = new Object[2];
		parameters[0] = left;
		parameters[1] = right;

		Object result = null;
		try {
			result = (Object)m.invoke(myClass, parameters);
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
