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

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.emf.facet.custom.sdk.core.ICustomizationCommandFactory;
import org.eclipse.papyrus.emf.facet.custom.sdk.ui.internal.util.widget.getorcreate.GetExtendedFacetWidget;
import org.eclipse.papyrus.emf.facet.custom.sdk.ui.internal.util.widget.getorcreate.GetOrCreateCustomizationWidget;
import org.eclipse.papyrus.emf.facet.custom.sdk.ui.internal.util.widget.metaclass.GetExtendedMetaclassWidget;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.widget.command.AbstractCommandWidget;
import org.eclipse.papyrus.emf.facet.util.ui.utils.PropertyElement;
import org.eclipse.papyrus.emf.facet.util.ui.utils.PropertyElement2;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.CustomFactory;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.Customization;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.EClassCustomization;
import org.eclipse.swt.widgets.Composite;

/**
 * Widget for the creation of an {@link EClassCustomization}. This Widget return
 * a command ( {@link #getCommand()} for the creation of the element into the
 * model.
 * <p/>
 * 
 * This widget uses 3 others:
 * <p/>
 * <li> {@link GetOrCreateCustomizationWidget} for the selection of the parent.</li>
 * <p/>
 * <li> {@link GetExtendedMetaclassWidget} for the selection of the extended
 * meta-class</li>
 * <p/>
 * <li> {@link GetExtendedFacetWidget} for the selection of the extended
 * {@link Facet}</li>
 */
public class CreateEClassCustomizationWidget extends AbstractCommandWidget {

	private final PropertyElement2<Customization> customProperty;
	private final PropertyElement2<EClass> mClassProperty;
	private final PropertyElement2<Facet> extFacetProperty;

	private GetOrCreateCustomizationWidget customWidget;
	private GetExtendedMetaclassWidget extendedMCWidget;
	private GetExtendedFacetWidget extendedFacetW;
	private final ICustomizationCommandFactory customCmdFactory;
	private final EditingDomain editingDomain;

	/**
	 * Constructor.
	 * 
	 * @param parent
	 *            the parent of this composite.
	 * @param properties
	 *            the properties.
	 */
	public CreateEClassCustomizationWidget(final Composite parent,
			final ICustomizationCommandFactory customCmdFactory,
			final EditingDomain editingDomain,
			final PropertyElement2<Customization> customProperty,
			final PropertyElement2<EClass> mClassProperty,
			final PropertyElement2<Facet> extFacetProperty) {
		super(parent);
		this.customCmdFactory = customCmdFactory;
		this.editingDomain = editingDomain;
		this.customProperty = customProperty;
		this.mClassProperty = mClassProperty;
		this.extFacetProperty = extFacetProperty;
	}

	@Override
	public Command getCommand() {
		final Customization customization = (Customization) this
				.getCustomizationProperty().getValue();
		final EClassCustomization eClassCustom = createEClassCustomization();
		return this.customCmdFactory.createEClassCustomization(customization,
				eClassCustom);
	}

	public EClassCustomization createEClassCustomization() {
		final EClass extendedMetaclass = (EClass) this.getMetaClassProperty()
				.getValue();
		final Facet extendedFacet = (Facet) this.getExtendedFacetProperty()
				.getValue();
		final String name = extendedMetaclass.getName() + " " //$NON-NLS-1$
				+ extendedFacet.getDocumentation();
		final EClassCustomization eClassCustom = getEClassCustomization();
		eClassCustom.setName(name);
		eClassCustom.setExtendedMetaclass(extendedMetaclass);
		eClassCustom.getExtendedFacets().add(extendedFacet);
		return eClassCustom;
	}

	@SuppressWarnings("static-method")
	// @SuppressWarnings("static-method") This method is overrode by
	// EditEClassCustomizationWidget.
	public EClassCustomization getEClassCustomization() {
		return CustomFactory.eINSTANCE.createEClassCustomization();
	}

	@Override
	public void onDialogValidation() {
		// Nothing.
	}

	@Override
	protected void addSubWidgets() {
		this.customWidget = new GetOrCreateCustomizationWidget(this,
				this.customProperty, this.editingDomain);
		addSubWidget(this.customWidget);
		this.extendedMCWidget = new GetExtendedMetaclassWidget(this,
				this.mClassProperty, this.customProperty);
		addSubWidget(this.extendedMCWidget);
		this.extendedFacetW = new GetExtendedFacetWidget(this,
				this.extFacetProperty);
		addSubWidget(this.extendedFacetW);
	}

	@Override
	public void notifyChanged() {
		// Nothing.
	}

	/**
	 * @return the customizationProperty
	 */
	public PropertyElement getCustomizationProperty() {
		return this.customProperty;
	}

	/**
	 * @return the metaClassProperty
	 */
	public PropertyElement getMetaClassProperty() {
		return this.mClassProperty;
	}

	/**
	 * @return the extendedFacetProperty
	 */
	public PropertyElement getExtendedFacetProperty() {
		return this.extFacetProperty;
	}

	/**
	 * @return the getOrCreateCustomizationWidget
	 */
	public GetOrCreateCustomizationWidget getGetOrCreateCustomizationWidget() {
		return this.customWidget;
	}

	/**
	 * @return the getExtendedMetaclassWidget
	 */
	public GetExtendedMetaclassWidget getGetExtendedMetaclassWidget() {
		return this.extendedMCWidget;
	}

	/**
	 * @return the getExtendedFacetWidget
	 */
	public GetExtendedFacetWidget getGetExtendedFacetWidget() {
		return this.extendedFacetW;
	}

	protected final ICustomizationCommandFactory getCustomCmdFactory() {
		return this.customCmdFactory;
	}

}
