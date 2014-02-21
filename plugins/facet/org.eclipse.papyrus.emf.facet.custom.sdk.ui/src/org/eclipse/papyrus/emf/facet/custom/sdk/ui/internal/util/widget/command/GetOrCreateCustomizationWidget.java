/**
 * Copyright (c) 2012 Mia-Software.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  	Alban Ménager (Soft-Maint) - Bug 387470 - [EFacet][Custom] Editors
 *  	Grégoire Dupé (Mia-Software) - Bug 387470 - [EFacet][Custom] Editors
 */
package org.eclipse.papyrus.emf.facet.custom.sdk.ui.internal.util.widget.command;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.emf.facet.custom.sdk.ui.internal.util.dialog.command.CreateEClassCustomizationDialog;
import org.eclipse.papyrus.emf.facet.efacet.core.FacetUtils;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.dialog.IDialog;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.widget.command.AbstractGetOrCreateFilteredElementCommandWidget;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.widget.command.ICommandWidget;
import org.eclipse.papyrus.emf.facet.util.ui.utils.PropertyElement2;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.Customization;
import org.eclipse.swt.widgets.Composite;

/**
 * This widget allow the user to select a Customization.
 * 
 * @see AbstractGetOrCreateFilteredElementCommandWidget
 */
public class GetOrCreateCustomizationWidget extends
		AbstractGetOrCreateFilteredElementCommandWidget<Customization, ICommandWidget> {

	private final EditingDomain editingDomain;
	private final PropertyElement2<Customization> customProperty;

	/**
	 * Constructor.
	 * 
	 * @param parent
	 *            the parent of this composite.
	 * @param properties
	 *            the properties.
	 * @param customProperty
	 */
	public GetOrCreateCustomizationWidget(final Composite parent,
			final EditingDomain editingDomain,
			final PropertyElement2<Customization> customProperty) {
		super(parent);
		this.editingDomain = editingDomain;
		this.customProperty = customProperty;
	}

	@Override
	protected Map<String, Customization> getElements() {
		final Map<String, Customization> result = new HashMap<String, Customization>();
		final Customization initialSelection = this.customProperty.getValue2();
		final FacetSet parent = FacetUtils
				.getContainingFacetSet(initialSelection);
		final Map<String, FacetSet> allFacetSets = FacetUtils
				.getAllFacetSetsByName(parent);
		for (String key : allFacetSets.keySet()) {
			final FacetSet value = allFacetSets.get(key);
			if (value instanceof Customization) {
				final Customization custom = (Customization) value;
				result.put(key, custom);
			}
		}
		final Object name = initialSelection.getName();
		result.remove(name);
		return result;
	}

	@Override
	protected IDialog<ICommandWidget> createDialog() {
		return new CreateEClassCustomizationDialog(
				this.customProperty.getValue2(), this.editingDomain);
	}

	@Override
	public Command getCommand() {
		// Here, this widget only return a selected element so, no command is
		// returned.
		return null;
	}

	@Override
	public void notifyChanged() {
		// No action has to be done if a change appends.
	}

	@Override
	public void onDialogValidation() {
		// Nothing.
	}

}
