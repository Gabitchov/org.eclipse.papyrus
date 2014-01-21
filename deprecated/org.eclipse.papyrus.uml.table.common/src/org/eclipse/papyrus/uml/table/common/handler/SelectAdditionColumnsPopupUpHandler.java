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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.table.common.handler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.facet.infra.facet.FacetStructuralFeature;
import org.eclipse.emf.facet.widgets.nattable.internal.NatTableWidget;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.action.ContributionItem;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.papyrus.infra.emf.utils.ENamedElementComparator;
import org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrusTableInstance;
import org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.ProfileFacetSet;
import org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.StereotypeFacet;
import org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.StereotypePropertyElement;
import org.eclipse.papyrus.uml.table.common.Activator;
import org.eclipse.papyrus.uml.tools.utils.StereotypeUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;


public class SelectAdditionColumnsPopupUpHandler extends SelectColumnsHandler {


	private Collection<ETypedElement> newAdditionalContentsSelection;


	/**
	 * 
	 * Constructor.
	 * 
	 */
	public SelectAdditionColumnsPopupUpHandler() {
		final NatTableWidget widget = getTableWidget();
		final PapyrusTableInstance papyrusTable = getPapyrusTable();
		if(widget != null && papyrusTable != null) {
			super.initField(widget, papyrusTable);
		}
	}

	/**
	 * Setter for the field newAdditionalContentsSelection
	 * 
	 * @param newSelection
	 */
	public void setNewSelectedAdditionalFeature(final Collection<ETypedElement> newSelection) {
		this.newAdditionalContentsSelection = newSelection;
	}

	/**
	 * 
	 * @return
	 *         the list of the stereotype properties elements which can be used in the table
	 */
	public final Collection<FacetStructuralFeature> getApplicableStereotypePropertyElements() {
		final PapyrusTableInstance pTable = getPapyrusTable();
		final Collection<ENamedElement> allFacetSets = new TreeSet<ENamedElement>(new ENamedElementComparator());
		allFacetSets.addAll(getFacetSetsUsedInTheTable());
		allFacetSets.addAll(getAllAdditionalContents());


		//1. get all applied stereotypes
		final Collection<Stereotype> stes = new HashSet<Stereotype>();
		for(final EObject current : pTable.getTable().getElements()) {
			if(current instanceof Element) {
				stes.addAll(((Element)current).getAppliedStereotypes());
			}
		}

		//2. get all extended stereotypes
		final Collection<Stereotype> allStereotypes = new HashSet<Stereotype>();
		for(final Stereotype current : stes) {
			allStereotypes.add(current);
			allStereotypes.addAll(StereotypeUtil.getAllSuperStereotypes(current));
		}

		//3. build the list of the qualified stereotype name
		final Collection<String> steQN = new TreeSet<String>();
		for(final Stereotype ste : stes) {
			steQN.add(ste.getQualifiedName());
		}

		//4. create the list of the possible features
		final Collection<FacetStructuralFeature> features = new ArrayList<FacetStructuralFeature>();
		for(final ENamedElement set : allFacetSets) {
			if(set instanceof ProfileFacetSet) {
				final TreeIterator<EObject> iter = set.eAllContents();
				while(iter.hasNext()) {
					final EObject current = iter.next();
					if(current instanceof StereotypeFacet) {
						final String QN = ((StereotypeFacet)current).getStereotypeQualifiedName();
						if(steQN.contains(QN)) {
							features.addAll(((StereotypeFacet)current).getStereotypePropertyElements());
						}
					}
				}
			}
		}
		return features;
	}


	/**
	 * 
	 * @see org.eclipse.papyrus.uml.table.common.handler.SelectColumnsHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 * 
	 * @param event
	 * @return
	 * @throws ExecutionException
	 */
	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		final TransactionalEditingDomain domain = getEditingDomain();
		final Command cmd = getCreateDestroyAdditonalFeatureColumnsCommand(getPapyrusTable(), getTableWidget(), this.newAdditionalContentsSelection);
		domain.getCommandStack().execute(cmd);
		return null;
	}

	/**
	 * This method allows to contribute to a menu. Its adds check menu to show hide stereotypes properties columns
	 * 
	 * @param manager
	 *        the menu manager
	 */
	public void addContributionItems(final MenuManager manager) {
		IContributionItem item = new ContributionItem() {

			/**
			 * 
			 * {@inheritDoc}
			 */
			@Override
			public void fill(final Menu menu, int index) {
				final Collection<ETypedElement> initialSelection = getInitialAdditionalFeatureSelected();
				final Iterator<FacetStructuralFeature> iter = getApplicableStereotypePropertyElements().iterator();
				while(iter.hasNext()) {
					final StereotypePropertyElement el = (StereotypePropertyElement)iter.next();

					final MenuItem menuItem = new MenuItem(menu, SWT.CHECK);
					menuItem.setText(el.getPropertyQualifiedName()); //$NON-NLS-1$
					if(initialSelection.contains(el)) {
						menuItem.setSelection(true);
					}
					menuItem.addSelectionListener(new SelectionAdapter() {

						@Override
						public void widgetSelected(final SelectionEvent e) {
							final boolean toAdd = menuItem.getSelection();
							final Collection<ETypedElement> newSelection = new ArrayList<ETypedElement>();
							newSelection.addAll(initialSelection);
							if(toAdd) {
								newSelection.add((ETypedElement)el);
							} else {
								newSelection.remove(el);
							}
							setNewSelectedAdditionalFeature(newSelection);
							try {
								execute(new ExecutionEvent());
							} catch (final ExecutionException e1) {
								Activator.log.error(e1);
							}
						}
					});
				}
				boolean enabled = menu.getItemCount() != 0;
				menu.setEnabled(enabled);
			}
		};

		Menu menu = manager.getMenu();
		if(menu != null) {
			menu.setEnabled(false);
		}
		manager.add(item);

	}
}
