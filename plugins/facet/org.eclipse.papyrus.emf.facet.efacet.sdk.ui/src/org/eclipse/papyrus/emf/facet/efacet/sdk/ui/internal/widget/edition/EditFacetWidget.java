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
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.Messages;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.exported.widget.IFacetWidget;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.exported.widget.component.getorcreate.IGetOrCreateFacetSetWidget;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.exported.widget.component.metaclass.IGetExtendedMetaclassWidget;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.exported.widget.creation.IGetOrCreateFilteredFacetSetWidget;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.sync.generated.SynchronizedGetExtendedMetaclassWidget;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.widget.component.getorcreate.GetOrCreateFacetSetWidget;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.widget.component.metaclass.GetExtendedMetaclassWidget;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.widget.component.metaclass.SelectSubTypingTypeWidget;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.widget.creation.AbstractENamedElementWidget;
import org.eclipse.emf.facet.util.ui.internal.exported.dialog.IDialog;
import org.eclipse.emf.facet.util.ui.internal.exported.util.widget.command.IGetOrCreateFilteredElementCommmandWidget;
import org.eclipse.emf.facet.util.ui.internal.exported.util.widget.component.properties.name.AbstractGetElementNameWidget;
import org.eclipse.emf.facet.util.ui.internal.exported.widget.IAbstractWidget;
import org.eclipse.emf.facet.util.ui.utils.PropertyElement2;
import org.eclipse.swt.widgets.Composite;

/**
 * Widget for the edition of a {@link Facet}.
 */
public class EditFacetWidget
		extends
		AbstractENamedElementWidget<Facet, FacetSet, IGetOrCreateFilteredFacetSetWidget> implements IFacetWidget {

	private final Facet initialFacet;
	private final PropertyElement2<String> facetNameProperty;
	private final PropertyElement2<EClass> facetMetaclass;
	private final PropertyElement2<ETypedElement> conformProperty;
	private SelectSubTypingTypeWidget subTypingTypeW;
	private GetExtendedMetaclassWidget extMetaclassW;

	/**
	 * Constructor.
	 * 
	 * @param parent
	 *            the parent of this composite.
	 * @param editingDomain
	 *            the current editing domain.
	 * @param properties
	 *            the properties.
	 * @param initialFacet
	 *            the {@link Facet} to edit.
	 * @param facetNameProperty
	 * @param containerProperty
	 * @param conformProperty
	 * @param facetMetaclass
	 */
	public EditFacetWidget(final Composite parent,
			final Facet initialFacet, final EditingDomain editingDomain,
			final PropertyElement2<String> facetNameProperty,
			final PropertyElement2<FacetSet> facetSetProperty,
			final PropertyElement2<ETypedElement> conformProperty,
			final PropertyElement2<EClass> facetMetaclass) {
		super(parent, editingDomain, facetSetProperty, facetNameProperty);
		this.facetNameProperty = facetNameProperty;
		this.facetMetaclass = facetMetaclass;
		this.conformProperty = conformProperty;
		this.initialFacet = initialFacet;
	}

	@Override
	public Command getCommand() {
		return this.getCommandFactory().createEditFacetCommand(
				this.initialFacet, this.getContainerPropery().getValue2(),
				this.facetNameProperty.getValue2(),
				this.conformProperty.getValue2(),
				this.facetMetaclass.getValue2(), null);
	}

	@Override
	protected void addSubWidgets() {
		super.addSubWidgets();
		this.extMetaclassW = new GetExtendedMetaclassWidget(this,
				this.facetMetaclass, this.getContainerPropery());
		addSubWidget(this.extMetaclassW);
		this.subTypingTypeW = new SelectSubTypingTypeWidget(this,
				this.conformProperty, this.getEditingDomain(),
				this.facetMetaclass.getValue2(), this.initialFacet);
		addSubWidget(this.subTypingTypeW);
	}

	@Override
	public void notifyChanged() {
		// No action has to be done if a change appends.
	}

	@Override
	public void onDialogValidation() {
		// Nothing.
	}

	public IAbstractWidget getSelectSubTypingTypeWidget() {
		return this.subTypingTypeW;
	}

	public IGetExtendedMetaclassWidget getGetExtendedMetaclassWidget() {
		return new SynchronizedGetExtendedMetaclassWidget(this.extMetaclassW,
				this.extMetaclassW.getDisplay());
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.facet.efacet.sdk.ui.internal.widget.edition.IFacetWidget#setSubTypingFacetSelection(boolean)
	 */
	public void setSubTypingFacetSelection(final boolean enable) {
		this.subTypingTypeW.setSelection(enable);
	}

	public String getSubTypingFacet() {
		return this.subTypingTypeW.getSubTypingText();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.facet.efacet.sdk.ui.internal.widget.edition.IFacetWidget#pressSubTypingButton()
	 */
	public IDialog<IGetOrCreateFilteredElementCommmandWidget<ETypedElement, Object>> pressSubTypingButton() {
		return this.subTypingTypeW.pressButton();
	}

	@Override
	protected IGetOrCreateFacetSetWidget createGetOrCreateElementWidgetComposite() {
		return new GetOrCreateFacetSetWidget(this, this.getContainerPropery(),
				this.getEditingDomain(), null);
	}

	@Override
	protected AbstractGetElementNameWidget createGetElementNameSubWidgetComposite() {
		final AbstractGetElementNameWidget widget = new AbstractGetElementNameWidget(
				this, this.facetNameProperty) {
			@Override
			protected String getErrorMessage() {
				return ""; //$NON-NLS-1$
			}

			@Override
			protected String getLabel() {
				return Messages.EditFacetWidget_FacetName;
			}

			@Override
			public void notifyChanged() {
				// Noting to do
			}

		};
		return widget;
	}

}
