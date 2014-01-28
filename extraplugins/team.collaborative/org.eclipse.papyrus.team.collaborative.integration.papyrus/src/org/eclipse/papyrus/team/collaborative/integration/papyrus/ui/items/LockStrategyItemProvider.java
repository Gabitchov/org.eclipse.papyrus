/*******************************************************************************
 * Copyright (c) 2013 Atos
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Arthur Daussy - initial implementation
 *******************************************************************************/
package org.eclipse.papyrus.team.collaborative.integration.papyrus.ui.items;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.papyrus.team.collaborative.ICollaborativeManager;
import org.eclipse.papyrus.team.collaborative.integration.papyrus.ui.actions.LockAction;
import org.eclipse.papyrus.team.collaborative.integration.papyrus.utils.UIUtils;
import org.eclipse.papyrus.team.collaborative.strategy.ILockingStrategy;
import org.eclipse.papyrus.team.collaborative.utils.CollabUtils;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;


/**
 * Item provider which fill the menu with all lock strategy.
 * 
 * @author adaussy
 */
public class LockStrategyItemProvider extends org.eclipse.ui.actions.CompoundContributionItem {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.actions.CompoundContributionItem#getContributionItems()
	 */
	@Override
	protected IContributionItem[] getContributionItems() {
		if(isEnabled()) {
			Collection<ActionContributionItem> contribution = Collections2.transform(ICollaborativeManager.INSTANCE.getStrategies().values(), new Function<ILockingStrategy.Descriptor, ActionContributionItem>() {

				@Override
				public ActionContributionItem apply(final ILockingStrategy.Descriptor from) {

					Action action = new LockAction(from);
					ActionContributionItem actionContributionItem = new ActionContributionItem(action);
					return actionContributionItem;
				}
			});
			return contribution.toArray(new IContributionItem[contribution.size()]);
		}

		return new IContributionItem[0];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.action.ContributionItem#isEnabled()
	 */
	public boolean isEnabled() {
		EObject firstSelection = UIUtils.getFirstSelection();
		if(firstSelection != null) {
			return CollabUtils.isCollab(firstSelection);
		}
		return false;
	}


}
