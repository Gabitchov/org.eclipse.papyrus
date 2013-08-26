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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.nattable.menu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.expressions.EvaluationResult;
import org.eclipse.core.expressions.Expression;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.action.ContributionItem;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.papyrus.infra.nattable.manager.axis.IAxisManager;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.FeatureIdAxis;
import org.eclipse.papyrus.infra.tools.util.EditorHelper;
import org.eclipse.papyrus.infra.widgets.Activator;
import org.eclipse.papyrus.infra.widgets.providers.HierarchicToFlatContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.IRestrictedContentProvider;
import org.eclipse.papyrus.uml.nattable.manager.axis.UMLStereotypePropertyAxisManager;
import org.eclipse.papyrus.uml.nattable.utils.Constants;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.menus.ExtensionContributionFactory;
import org.eclipse.ui.menus.IContributionRoot;
import org.eclipse.ui.services.IServiceLocator;
import org.eclipse.uml2.uml.Property;

/**
 * 
 * @author VL222926
 * 
 */
public abstract class AbstractCreateStereotypePropertyMenuFactory extends ExtensionContributionFactory {

	/**
	 * the label for the created menu
	 */
	private final String menuLabel;

	private final String iconPath;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param menuLabel
	 *        the label to use for the menu
	 */
	public AbstractCreateStereotypePropertyMenuFactory(final String menuLabel, final String iconPath) {
		this.menuLabel = menuLabel;
		this.iconPath = iconPath;
	}

	/**
	 * 
	 * @param tableManager
	 *        the current table manager
	 * @return
	 *         the uml stereotype property axis manager or <code>null</code> if not found
	 */
	protected abstract UMLStereotypePropertyAxisManager getStereotypeAxisManager(final INattableModelManager tableManager);

	/**
	 * 
	 * {@inheritDoc}
	 */
	public void createContributionItems(IServiceLocator serviceLocator, IContributionRoot additions) {
		final INattableModelManager tableManager = getTableManager();
		if(tableManager != null) {
			final IAxisManager steretoypeAxisManager = getStereotypeAxisManager(tableManager);
			if(steretoypeAxisManager == null) {
				return;
			}
			final IRestrictedContentProvider provider = steretoypeAxisManager.createPossibleAxisContentProvider(true);
			final HierarchicToFlatContentProvider flatProvider = new HierarchicToFlatContentProvider(provider);
			final Object[] elementss = flatProvider.getElements();

			final Map<String, Property> nameToPropertyMap = new HashMap<String, Property>();
			for(final Object current : elementss) {
				if(current instanceof Property) {
					nameToPropertyMap.put(((Property)current).getQualifiedName(), (Property)current);
				}
			}


			final Collection<String> initialSelection = new ArrayList<String>();

			for(final Object current : getAxisElementList(tableManager)) {
				if(current instanceof FeatureIdAxis) {
					String el = ((FeatureIdAxis)current).getElement();
					if(el.startsWith(Constants.PROPERTY_OF_STEREOTYPE_PREFIX)) {
						initialSelection.add(((FeatureIdAxis)current).getElement().replace(Constants.PROPERTY_OF_STEREOTYPE_PREFIX, ""));
					}
				}
			}

			if(tableManager != null) {
				if(true) {
					MenuManager manager = new MenuManager(menuLabel) {

						/**
						 * 
						 * {@inheritDoc}
						 */
						@Override
						public void fill(Menu parent, int index) {
							super.fill(parent, index);
							getMenu().getParentItem().setEnabled(true);
							Image image = Activator.getDefault().getImage(org.eclipse.papyrus.uml.nattable.Activator.getDefault().PLUGIN_ID, iconPath);
							getMenu().getParentItem().setImage(image);
						}


					};

					manager.setVisible(true);



					final IContributionItem item = new ContributionItem() {

						/**
						 * 
						 * {@inheritDoc}
						 */
						@Override
						public void fill(final Menu menu, int index) {
							fillMenu(menu, tableManager, initialSelection, nameToPropertyMap);
						}
					};

					Menu menu = manager.getMenu();
					if(menu != null) {
						menu.setEnabled(false);
					}
					manager.add(item);
					Expression visibleWhen = new Expression() {

						/**
						 * 
						 * {@inheritDoc}
						 */
						@Override
						public EvaluationResult evaluate(IEvaluationContext context) throws CoreException {
							return EvaluationResult.TRUE;
						}
					};

					additions.addContributionItem(manager, visibleWhen);
				}
			}
		}
	}

	/**
	 * 
	 * @param menu
	 *        the menu to fill
	 * @param tableManager
	 *        the table manager
	 * @param initialSelection
	 *        the initial selection
	 * @param nameToPropertyMap
	 *        the map with th available properties
	 */
	protected abstract void fillMenu(final Menu menu, final INattableModelManager tableManager, final Collection<String> initialSelection, final Map<String, Property> nameToPropertyMap);

	/**
	 * 
	 * @param tableManager
	 *        the table manager
	 * @return
	 *         the list of the element currently know by the axis
	 */
	protected abstract Collection<?> getAxisElementList(final INattableModelManager tableManager);

	/**
	 * 
	 * @return
	 *         the table manager
	 */
	protected final INattableModelManager getTableManager() {
		final IWorkbenchPart workbenchPart = EditorHelper.getActivePart();
		INattableModelManager tableManager = null;
		if(workbenchPart != null) {
			tableManager = (INattableModelManager)workbenchPart.getAdapter(INattableModelManager.class);
		}
		return tableManager;
	}
}
