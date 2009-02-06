/***********************************************************************
 * Copyright (c) 2008 Anyware Technologies
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 * 
 * $Id$
 **********************************************************************/
package org.eclipse.papyrus.outline.actions;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IContributionManager;
import org.eclipse.jface.action.MenuManager;

/**
 * A default 'Create sibling' menu. <br>
 * 
 * Creation : 04 jul. 2008
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques Lescot</a>
 */
public class DefaultCreateSiblingMenu extends MenuManager {

	/**
	 * Constructor
	 */
	public DefaultCreateSiblingMenu(EObject selectedObject) {
		super("Create sibling");

		// Retrieve the editingDomain from the given model element
		TransactionalEditingDomain editingDomain = TransactionUtil
				.getEditingDomain(selectedObject);

		// Populate all the "Create Sibling" actions
		populateManager(this, generateCreateActions(editingDomain,
				selectedObject), null);
	}

	/**
	 * This populates the specified <code>manager</code> with
	 * {@link org.eclipse.jface.action.ActionContributionItem}s based on the
	 * {@link org.eclipse.jface.action.IAction}s contained in the
	 * <code>actions</code> collection, by inserting them before the specified
	 * contribution item <code>contributionID</code>. If <code>ID</code> is
	 * <code>null</code>, they are simply added.
	 * 
	 * @param manager
	 *            the menu to fill
	 * @param actions
	 *            the actions to add
	 * @param contributionID
	 *            the position of the contribution
	 */
	protected void populateManager(IContributionManager manager,
			Collection<IAction> actions, String contributionID) {
		if (actions != null) {
			for (IAction action : actions) {
				if (contributionID != null) {
					manager.insertBefore(contributionID, action);
				} else {
					manager.add(action);
				}
			}
		}
	}

	/**
	 * This generates a CreateChildAction for each object in
	 * <code>descriptors</code>, and returns the collection of these actions.
	 * 
	 * @param domain
	 *            The modeler domain
	 * @param descriptors
	 *            the child descriptors
	 * @param selection
	 *            the selected object
	 * @return a collection of actions
	 */
	protected Collection<IAction> generateCreateActions(
			TransactionalEditingDomain editingDomain, EObject selectedObject) {
		Collection<IAction> actions = new ArrayList<IAction>();
		Collection<?> descriptors = editingDomain.getNewChildDescriptors(null,
				selectedObject);
		if (descriptors != null) {
			for (Object object : descriptors) {
				actions.add(new CreateSiblingAction(editingDomain,
						selectedObject, object));
			}
		}
		return actions;
	}
}
