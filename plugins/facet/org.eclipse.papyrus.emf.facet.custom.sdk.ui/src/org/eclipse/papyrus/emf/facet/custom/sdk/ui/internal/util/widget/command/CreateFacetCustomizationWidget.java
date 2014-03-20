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
import org.eclipse.papyrus.emf.facet.custom.sdk.ui.internal.util.widget.getorcreate.GetCustomizedFacetWidget;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet;
import org.eclipse.papyrus.emf.facet.util.ui.utils.PropertyElement;
import org.eclipse.papyrus.emf.facet.util.ui.utils.PropertyElement2;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.CustomFactory;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.Customization;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.FacetCustomization;
import org.eclipse.swt.widgets.Composite;

/**
 * Widget for the creation of an {@link FacetCustomization}. This Widget return
 * a command ( {@link #getCommand()} for the creation of the element into the
 * model and extends {@link CreateEClassCustomizationWidget}.
 * <p/>
 * 
 * This widget add a other widget to the 3 of
 * {@link CreateEClassCustomizationWidget}:
 * <p/>
 * <li> {@link GetCustomizedFacetWidget} for the selection of a {@link Facet}</li>
 */
public class CreateFacetCustomizationWidget extends
		CreateEClassCustomizationWidget {

	private final PropertyElement2<Facet> facetCustomProp;
	private GetCustomizedFacetWidget getCustomFacetW;

	/**
	 * Constructor.
	 * 
	 * @param parent
	 *            the parent of this composite.
	 * @param properties
	 *            the properties.
	 * @param mClassProperty
	 * @param customProperty
	 * @param extFacetProperty
	 * @param facetCustomProp
	 * @param facetCustomProp
	 */
	public CreateFacetCustomizationWidget(final Composite parent,
			final ICustomizationCommandFactory customCmdFactory,
			final EditingDomain editingDomain,
			final PropertyElement2<EClass> mClassProperty,
			final PropertyElement2<Customization> customProperty,
			final PropertyElement2<Facet> extFacetProperty,
			final PropertyElement2<Facet> facetCustomProp) {
		super(parent, customCmdFactory, editingDomain,
				customProperty, mClassProperty, extFacetProperty);
		this.facetCustomProp = facetCustomProp;
	}

	@Override
	public Command getCommand() {
		final Customization customization = (Customization) this
				.getCustomizationProperty().getValue();
		final FacetCustomization facetCustom = createFacetCustomization();
		return getCustomCmdFactory().createFacetCustomization(customization,
				facetCustom);
	}

	public FacetCustomization createFacetCustomization() {
		final EClass extendedMetaclass = (EClass) this.getMetaClassProperty()
				.getValue();
		final Facet extendedFacet = (Facet) this.getExtendedFacetProperty()
				.getValue();
		final String name = extendedMetaclass.getName() + " " //$NON-NLS-1$
				+ extendedFacet.getDocumentation();
		final Facet customizedFacet = (Facet) this.facetCustomProp.getValue();
		final FacetCustomization facetCustom = getFacetCustomization();
		facetCustom.setName(name);
		facetCustom.setExtendedMetaclass(extendedMetaclass);
		facetCustom.getExtendedFacets().add(extendedFacet);
		facetCustom.setCustomizedFacet(customizedFacet);
		return facetCustom;
	}

	@SuppressWarnings("static-method")
	//@SuppressWarnings("static-method") This method is overrode by EditFacetCustomizationWidget.
	public FacetCustomization getFacetCustomization() {
		return CustomFactory.eINSTANCE.createFacetCustomization();
	}

	@Override
	protected void addSubWidgets() {
		super.addSubWidgets();
		this.getCustomFacetW = new GetCustomizedFacetWidget(this,
				this.facetCustomProp);
		addSubWidget(this.getCustomFacetW);
	}

	/**
	 * @return the facetCustomizedProperty
	 */
	public PropertyElement getFacetCustomizedProperty() {
		return this.facetCustomProp;
	}

	/**
	 * @return the getCustomizedFacetWidget
	 */
	public GetCustomizedFacetWidget getGetCustomizedFacetWidget() {
		return this.getCustomFacetW;
	}

}
