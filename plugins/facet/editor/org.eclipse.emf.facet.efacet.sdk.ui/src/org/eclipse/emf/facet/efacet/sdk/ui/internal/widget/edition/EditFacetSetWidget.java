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
package org.eclipse.emf.facet.efacet.sdk.ui.internal.widget.edition;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.Messages;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.exported.widget.component.getorcreate.IGetOrCreateFacetSetWidget;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.exported.widget.creation.IGetOrCreateFilteredFacetSetWidget;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.widget.component.getorcreate.GetOrCreateFacetSetWidget;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.widget.creation.AbstractENamedElementWidget;
import org.eclipse.emf.facet.util.ui.internal.exported.util.widget.component.properties.name.AbstractGetElementNameWidget;
import org.eclipse.emf.facet.util.ui.utils.PropertyElement;
import org.eclipse.emf.facet.util.ui.utils.PropertyElement2;
import org.eclipse.swt.widgets.Composite;

/**
 * Widget for the edition of a {@link FacetSet}.
 */
public class EditFacetSetWidget
		extends
		AbstractENamedElementWidget<FacetSet, FacetSet, IGetOrCreateFilteredFacetSetWidget> {

	private final PropertyElement2<FacetSet> containerProperty;
	private final FacetSet editedFacetSet;

	/**
	 * Constructor.
	 * 
	 * @param parent
	 *            the parent of this composite.
	 * @param properties
	 *            the properties.
	 * @param editedFacetSet
	 *            the {@link FacetSet} to edit.
	 * @param nameProperty
	 * @param containerProp
	 */
	public EditFacetSetWidget(final Composite parent,
			final FacetSet editedFacetSet, final EditingDomain editingDomain,
			final PropertyElement2<String> nameProperty,
			final PropertyElement2<FacetSet> containerProp) {
		super(parent, editingDomain, containerProp, nameProperty);
		this.containerProperty = containerProp;
		this.editedFacetSet = editedFacetSet;
	}

	@Override
	public Command getCommand() {
		final FacetSet container = this.containerProperty.getValue2();
		return this.getCommandFactory().createEditFacetSetCommand(
				this.editedFacetSet, container,
				this.getElementNamePropertyValue());
	}

	@Override
	public void notifyChanged() {
		// No action has to be done if a change appends.
	}

	@Override
	public void onDialogValidation() {
		// Nothing.
	}


	@Override
	protected IGetOrCreateFacetSetWidget createGetOrCreateElementWidgetComposite() {
		return new GetOrCreateFacetSetWidget(this, this.containerProperty,
				this.getEditingDomain(), null);
	}

	@Override
	protected AbstractGetElementNameWidget createGetElementNameSubWidgetComposite() {
		final AbstractGetElementNameWidget widget = new AbstractGetElementNameWidget(
				this, this.getElementNameProperty()) {
			@Override
			protected String getErrorMessage() {
				return ""; //$NON-NLS-1$
			}

			@Override
			protected String getLabel() {
				return Messages.EditFacetSetWidget_FacetSetName;
			}

			@Override
			public void notifyChanged() {
				// Noting to do
			}

		};
		return widget;
	}
	

	protected final PropertyElement getContainerProperty() {
		return this.containerProperty;
	}


}
