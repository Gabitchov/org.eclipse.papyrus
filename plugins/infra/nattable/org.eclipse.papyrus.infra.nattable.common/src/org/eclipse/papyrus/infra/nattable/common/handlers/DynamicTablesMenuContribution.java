/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Laurent Wouters laurent.wouters@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.common.handlers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusSyncTable;
import org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusTable;
import org.eclipse.papyrus.infra.viewpoints.policy.DynamicContribution;
import org.eclipse.papyrus.infra.viewpoints.policy.PolicyChecker;
import org.eclipse.papyrus.infra.viewpoints.policy.ViewPrototype;

/**
 * Represents the dynamic contribution of a policy to menus
 * @author Laurent Wouters
 */
public class DynamicTablesMenuContribution extends DynamicContribution {
	/**
	 * Constructor.
	 */
	public DynamicTablesMenuContribution() { }

	/**
	 * Constructor.
	 * @param id
	 */
	public DynamicTablesMenuContribution(String id) {
		super(id);
	}
	
	/**
	 * @see org.eclipse.ui.actions.CompoundContributionItem#getContributionItems()
	 */
	@Override
	protected IContributionItem[] getContributionItems() {
		final EObject selection = getSelection();
		if (selection == null)
			return new IContributionItem[0];
		
		// build a list of all the available prototypes
		List<ViewPrototype> data = new ArrayList<ViewPrototype>();
		for (final ViewPrototype proto : PolicyChecker.getCurrent().getPrototypesFor(selection)) {
			if (!(proto.getConfiguration() instanceof PapyrusTable || proto.getConfiguration() instanceof PapyrusSyncTable))
				continue;
			data.add(proto);
		}
		
		// sort them
		Collections.sort(data, new ViewPrototype.Comp());
		
		// build the full labels
		List<String> labels = new ArrayList<String>(data.size());
		String last = null;
		boolean first = true;
		for (ViewPrototype item : data) {
			String label = item.getLabel();
			if (last != null && last.equals(label)) {
				// name collision
				if (first) {
					labels.set(labels.size() - 1, data.get(labels.size() - 1).getFullLabel());
					first = false;
				}
				labels.add(item.getFullLabel());
			} else {
				labels.add(label);
				last = label;
				first = true;
			}
		}

		// build the menu
		List<IContributionItem> items = new ArrayList<IContributionItem>(data.size());
		for (int i = 0; i != data.size(); i++) {
			final ViewPrototype proto = data.get(i);
			String label = labels.get(i);
			items.add(new ActionContributionItem(new Action(CREATE_MESSAGE + label, proto.getIconDescriptor()) {
				@Override
				public void run() {
					proto.instantiateOn(selection);
				}
			}));
		}
		return items.toArray(new IContributionItem[items.size()]);
	}
}
