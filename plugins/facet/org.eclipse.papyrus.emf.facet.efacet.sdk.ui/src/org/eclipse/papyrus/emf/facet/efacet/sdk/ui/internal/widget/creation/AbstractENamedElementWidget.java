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
package org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.widget.creation;

import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.emf.facet.efacet.core.IFacetCommandFactory;
import org.eclipse.papyrus.emf.facet.efacet.core.IFacetCommandFactoryFactory;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.exported.widget.IENamedElementWidget;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.dialog.IDialog;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.widget.command.AbstractCommandWidget;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.widget.getorcreate.IAbstractGetOrCreateElementWidget;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.widget.getorcreate.IAbstractGetOrCreateElementWithButtonWidget;
import org.eclipse.papyrus.emf.facet.util.ui.utils.PropertyElement2;
import org.eclipse.swt.widgets.Composite;

/**
 * Abstract widget implementing {@link IENamedElementWidget}.
 * 
 * @param C
 *            container
 * @param T
 *            type of edited element
 * @param CW
 *            the type of the widget contained by the dialog open to edit the
 *            container field
 * 
 * */
public abstract class AbstractENamedElementWidget<T extends ENamedElement, C extends EObject, CW extends Object>
		extends AbstractCommandWidget implements IENamedElementWidget<C, CW> {

	private final PropertyElement2<C> containerProperty;
	private final PropertyElement2<String> nameProperty;

	private IAbstractGetOrCreateElementWithButtonWidget<IDialog<CW>> containerWidget;
	private IAbstractGetOrCreateElementWidget elementNameSubWC;
	private final IFacetCommandFactory commandFatory;
	private final EditingDomain editingDomain;

	public AbstractENamedElementWidget(final Composite parent,
			final EditingDomain editingDomain,
			final PropertyElement2<C> facetProperty,
			final PropertyElement2<String> nameProperty) {
		super(parent);
		this.containerProperty = facetProperty;
		this.nameProperty = nameProperty;
		this.editingDomain = editingDomain;
		this.commandFatory = IFacetCommandFactoryFactory.DEFAULT
				.createCommandFactory(editingDomain);
	}

	@Override
	protected void addSubWidgets() {
		this.containerWidget = createGetOrCreateElementWidgetComposite();
		addSubWidget(this.containerWidget);
		this.elementNameSubWC = createGetElementNameSubWidgetComposite();
		addSubWidget(this.elementNameSubWC);
	}

	/**
	 * @return the sub widget composite for the creation of the element.
	 */
	protected abstract IAbstractGetOrCreateElementWithButtonWidget<IDialog<CW>> createGetOrCreateElementWidgetComposite();

	/**
	 * @return the sub widget composite for the get of the element name.
	 */
	protected abstract IAbstractGetOrCreateElementWidget createGetElementNameSubWidgetComposite();

	/**
	 * 
	 * @return the facetProperty
	 */
	public PropertyElement2<C> getContainerPropery() {
		return this.containerProperty;
	}

	/**
	 * @return the elementNameProperty
	 */
	public PropertyElement2<String> getElementNameProperty() {
		return this.nameProperty;
	}

	public String getElementNamePropertyValue() {
		return this.nameProperty.getValue2();
	}

	public IDialog<CW> pressParentButton() {
		return this.containerWidget.pressButton();
	}

	public String getElementName() {
		return this.elementNameSubWC.getText();
	}

	public void setName(final String value) {
		this.elementNameSubWC.setText(value);
	}

	public C getContainer() {
		return this.containerProperty.getValue2();
	}

	protected final IFacetCommandFactory getCommandFactory() {
		return this.commandFatory;
	}

	protected final EditingDomain getEditingDomain() {
		return this.editingDomain;
	}

}

