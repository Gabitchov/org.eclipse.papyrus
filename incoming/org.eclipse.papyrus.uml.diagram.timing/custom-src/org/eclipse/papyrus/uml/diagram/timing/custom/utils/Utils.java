/*******************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.papyrus.uml.diagram.timing.custom.utils;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.transaction.Transaction;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.util.StringStatics;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.papyrus.uml.diagram.common.util.CrossReferencerUtil;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.TimingDiagramEditPart;
import org.eclipse.swt.widgets.Display;

public final class Utils {

	private Utils() {
		// utility class
	}

	public static boolean safeEquals(final Object a, final Object b) {
		if(a == null) {
			return b == null;
		}
		return a.equals(b);
	}

	/**
	 * Find elements linked to the given element (only Views if viewsOnly=true, otherwise both Views and semantic
	 * elements are returned)
	 * 
	 * @param element
	 *        the element for which related elements must be found
	 * @param references
	 *        the references through which the referencing elements must be found
	 * @param viewsOnly
	 *        whether to only return Views (otherwise both Views and semantic elements are returned).
	 * @param expectedParentView
	 *        if not <code>null</code>, then only return Views under this parent View
	 * @param expectedClasses
	 *        the classes of referencing elements to remove
	 * @return the list of linked elements to remove
	 */
	public static Set<EObject> getReferencingElementsToRemove(final EObject element, final EReference[] references, final boolean viewsOnly, final View expectedParentView, final Class<?>[] expectedClasses) {
		final Set<EObject> referencingElements = new HashSet<EObject>();
		final Collection<?> referencers = EMFCoreUtil.getReferencers(element, references);
		for(final Object object : referencers) {
			if(object instanceof EObject && isExpectedClass(object, expectedClasses)) {
				final EObject eObject = (EObject)object;
				if(!viewsOnly) {
					referencingElements.add(eObject);
				}
				final Set<View> crossReferencingViews = CrossReferencerUtil.getCrossReferencingViews(eObject, TimingDiagramEditPart.MODEL_ID);
				for(final View view : crossReferencingViews) {
					if(expectedParentView == null || ViewUtils.isContained(view, expectedParentView)) {
						referencingElements.add(view);
					}
				}
			}
		}
		return referencingElements;
	}

	private static boolean isExpectedClass(final Object object, final Class<?>[] expectedClasses) {
		for(final Class<?> expectedClass : expectedClasses) {
			if(expectedClass.isInstance(object)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Executes the given command in an "unprotected" transaction, without recording it on the undo/redo stack. The
	 * command is scheduled to be executed later, in order to be run outside any currently running transaction.
	 * 
	 * @param command
	 *        the command to execute
	 * @param domain
	 *        the editing domain
	 */
	public static void executeLaterUnprotected(final Command command, final TransactionalEditingDomain domain) {
		Display.getCurrent().asyncExec(new Runnable() {

			public void run() {
				try {
					final Map<String, Boolean> options = Collections.singletonMap(Transaction.OPTION_UNPROTECTED, Boolean.TRUE);
					final AbstractEMFOperation operation = new AbstractEMFOperation(domain, StringStatics.BLANK, options) {

						@Override
						protected IStatus doExecute(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
							command.execute();
							return Status.OK_STATUS;
						}
					};
					operation.execute(new NullProgressMonitor(), null);
				} catch (final Exception e) {
					Activator.log.error(e);
				}
			}
		});
	}

	/**
	 * Find model elements linked to the given element
	 * 
	 * @param element
	 *        the element for which related elements must be found
	 * @param references
	 *        the references through which the referencing elements must be found
	 * @param expectedClasses
	 *        the classes of referencing elements to look for
	 * @return the list of linked elements
	 */
	public static Set<EObject> findReferencingElements(final EObject element, final EReference[] references, final Class<?>[] expectedClasses) {
		final Set<EObject> referencingElements = new HashSet<EObject>();
		final Collection<?> referencers = EMFCoreUtil.getReferencers(element, references);
		for(final Object object : referencers) {
			if(object instanceof EObject && isExpectedClass(object, expectedClasses)) {
				final EObject eObject = (EObject)object;
				referencingElements.add(eObject);
			}
		}
		return referencingElements;
	}
}
