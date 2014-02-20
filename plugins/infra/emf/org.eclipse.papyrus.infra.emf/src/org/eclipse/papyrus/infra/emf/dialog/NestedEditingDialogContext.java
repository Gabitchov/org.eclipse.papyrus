/*
 * Copyright (c) 2014 CEA and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus (CEA) - Initial API and implementation
 *
 */
package org.eclipse.papyrus.infra.emf.dialog;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

/**
 * A tracker of nested editing-dialog context information required by various components that have no direct access to the context.
 */
public class NestedEditingDialogContext {

	private static final NestedEditingDialogContext INSTANCE = new NestedEditingDialogContext();

	private final ThreadLocal<Integer> nesting = new ThreadLocal<Integer>();

	private final ThreadLocal<ResourceSet> resourceSet = new ThreadLocal<ResourceSet>();

	public static NestedEditingDialogContext getInstance() {
		return INSTANCE;
	}

	/**
	 * Queries whether the current editing dialog is nested in (created by) a higher-level dialog editing some other object.
	 * 
	 * @return whether the current thread is presenting a nested editing dialog
	 */
	public boolean isNested() {
		Integer depth = nesting.get();
		return (depth != null) && (depth.intValue() > 0);
	}

	/**
	 * Signals entry of an editing dialog context (the current thread is now presenting a dialog). Must be matched by a subsequent
	 * call to {@linkplain #exit() exit} the context.
	 * 
	 * @see #exit()
	 */
	public void enter() {
		Integer depth = nesting.get();
		if((depth == null) || (depth.intValue() < 1)) {
			depth = 1;
		} else {
			depth = depth.intValue() + 1;
		}
		nesting.set(depth);
	}

	/**
	 * Signals the end of an editing dialog context (the current thread is no longer presenting a dialog). Must match an earlier
	 * call to {@linkplain #enter() enter} the context.
	 * 
	 * @see #enter()
	 */
	public void exit() {
		Integer depth = nesting.get();
		if(depth != null) {
			if(depth.intValue() <= 1) {
				depth = null;
			} else {
				depth = depth.intValue() - 1;
			}
			nesting.set(depth);
		}
	}

	/**
	 * Obtains the resource set in the editing-dialog context of the current thread.
	 * 
	 * @return the current contextual resource set
	 */
	public ResourceSet getResourceSet() {
		return resourceSet.get();
	}

	/**
	 * Determines, if possible, the resource set containing the given {@code context} object being edited and pushes it onto the
	 * current thread's context stack.
	 * 
	 * @param context
	 *        the object currently being edited in a dialog
	 * 
	 * @return the resource set that was previously the context (which may be the same as the new one being pushed). This
	 *         must be {@linkplain #pop(ResourceSet) popped} from the context subsequently
	 * 
	 * @see #pop(ResourceSet)
	 */
	public ResourceSet push(Object context) {
		final ResourceSet previous = resourceSet.get();

		if(context instanceof EObject) {
			Resource res = ((EObject)context).eResource();
			if(res != null) {
				ResourceSet current = res.getResourceSet();
				if(current != null) {
					// put it in context
					resourceSet.set(current);
				}
			}
		}

		return previous;
	}

	/**
	 * Pops the current resource set from the context, restoring the given resource set that was returned by a previous {@linkplain #push(Object)
	 * push}, even if it was {@code null}.
	 * 
	 * @param previous
	 *        a resource set returned by an earlier push (may be {@code null})
	 * 
	 * @see #push(Object)
	 */
	public void pop(ResourceSet previous) {
		if(previous == null) {
			resourceSet.remove();
		} else {
			resourceSet.set(previous);
		}
	}
}
