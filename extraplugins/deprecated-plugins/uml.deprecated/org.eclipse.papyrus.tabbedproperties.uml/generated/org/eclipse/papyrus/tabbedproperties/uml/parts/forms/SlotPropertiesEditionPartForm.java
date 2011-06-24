/*******************************************************************************
 * Copyright (c) 2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.tabbedproperties.uml.parts.forms;

// Start of user code for imports

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.EEFMessageManager;
import org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.policies.IPropertiesEditionPolicy;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPolicyProvider;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.policies.EObjectPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionPolicyProviderService;
import org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.papyrus.tabbedproperties.uml.parts.SlotPropertiesEditionPart;
import org.eclipse.papyrus.tabbedproperties.uml.parts.UMLViewsRepository;
import org.eclipse.papyrus.tabbedproperties.uml.providers.UMLMessages;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.IMessageManager;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.uml2.uml.ValueSpecification;

// End of user code

/**
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class SlotPropertiesEditionPartForm extends CompositePropertiesEditionPart implements IFormPropertiesEditionPart, SlotPropertiesEditionPart {

	protected EMFListEditUtil valueEditUtil;

	protected ReferencesTable<? extends EObject> value;

	protected List<ViewerFilter> valueBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> valueFilters = new ArrayList<ViewerFilter>();





	/**
	 * Default constructor
	 * 
	 * @param editionComponent
	 *        the {@link IPropertiesEditionComponent} that manage this part
	 */
	public SlotPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart# createFigure(org.eclipse.swt.widgets.Composite,
	 *      org.eclipse.ui.forms.widgets.FormToolkit)
	 */
	public Composite createFigure(final Composite parent, final FormToolkit widgetFactory) {
		ScrolledForm scrolledForm = widgetFactory.createScrolledForm(parent);
		Form form = scrolledForm.getForm();
		view = form.getBody();
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		view.setLayout(layout);
		createControls(widgetFactory, view, new EEFMessageManager(scrolledForm, widgetFactory));
		return scrolledForm;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart# createControls(org.eclipse.ui.forms.widgets.FormToolkit,
	 *      org.eclipse.swt.widgets.Composite, org.eclipse.ui.forms.IMessageManager)
	 */
	public void createControls(final FormToolkit widgetFactory, Composite view, IMessageManager messageManager) {
		this.messageManager = messageManager;
		createGeneralGroup(widgetFactory, view);
		// Start of user code for additional ui definition

		// End of user code

	}

	protected void createGeneralGroup(FormToolkit widgetFactory, final Composite view) {
		Section generalSection = widgetFactory.createSection(view, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		generalSection.setText(UMLMessages.SlotPropertiesEditionPart_GeneralGroupLabel);
		GridData generalSectionData = new GridData(GridData.FILL_HORIZONTAL);
		generalSectionData.horizontalSpan = 3;
		generalSection.setLayoutData(generalSectionData);
		Composite generalGroup = widgetFactory.createComposite(generalSection);
		GridLayout generalGroupLayout = new GridLayout();
		generalGroupLayout.numColumns = 3;
		generalGroup.setLayout(generalGroupLayout);
		createValueTableComposition(widgetFactory, generalGroup);
		generalSection.setClient(generalGroup);
	}

	/**
	 * @param container
	 */
	protected void createValueTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.value = new ReferencesTable<ValueSpecification>(UMLMessages.SlotPropertiesEditionPart_ValueLabel, new ReferencesTableListener<ValueSpecification>() {

			public void handleAdd() {
				addToValue();
			}

			public void handleEdit(ValueSpecification element) {
				editValue(element);
			}

			public void handleMove(ValueSpecification element, int oldIndex, int newIndex) {
				moveValue(element, oldIndex, newIndex);
			}

			public void handleRemove(ValueSpecification element) {
				removeFromValue(element);
			}

			public void navigateTo(ValueSpecification element) {
			}
		});
		this.value.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.Slot.value, UMLViewsRepository.FORM_KIND));
		this.value.createControls(parent, widgetFactory);
		GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
		valueData.horizontalSpan = 3;
		this.value.setLayoutData(valueData);
	}

	/**
	 * 
	 */
	protected void moveValue(ValueSpecification element, int oldIndex, int newIndex) {
	}

	/**
	 * 
	 */
	protected void addToValue() {
		// Start of user code addToValue() method body
		// End of user code

	}

	/**
	 * 
	 */
	protected void removeFromValue(ValueSpecification element) {
		// Start of user code for the removeFromValue() method body
		EObject editedElement = valueEditUtil.foundCorrespondingEObject(element);
		valueEditUtil.removeElement(element);
		value.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SlotPropertiesEditionPartForm.this,
				UMLViewsRepository.Slot.value, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null,
				editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editValue(ValueSpecification element) {
		// Start of user code editValue() method body
		EObject editedElement = valueEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				valueEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				value.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						SlotPropertiesEditionPartForm.this, UMLViewsRepository.Slot.value,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, editedElement,
						propertiesEditionObject));
			}
		}
		// End of user code

	}


	public void firePropertiesChanged(PropertiesEditionEvent event) {
		// Start of user code for tab synchronization

		// End of user code

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.SlotPropertiesEditionPart#getValueToAdd()
	 */
	public List getValueToAdd() {
		return valueEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.SlotPropertiesEditionPart#getValueToRemove()
	 */
	public List getValueToRemove() {
		return valueEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.SlotPropertiesEditionPart#getValueToEdit()
	 */
	public Map getValueToEdit() {
		return valueEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.SlotPropertiesEditionPart#getValueToMove()
	 */
	public List getValueToMove() {
		return valueEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.SlotPropertiesEditionPart#getValueTable()
	 */
	public List getValueTable() {
		return valueEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.SlotPropertiesEditionPart#initValue(EObject current, EReference containingFeature,
	 *      EReference feature)
	 */
	public void initValue(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			valueEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			valueEditUtil = new EMFListEditUtil(current, feature);
		this.value.setInput(valueEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.SlotPropertiesEditionPart#updateValue(EObject newValue)
	 */
	public void updateValue(EObject newValue) {
		if(valueEditUtil != null) {
			valueEditUtil.reinit(newValue);
			value.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.SlotPropertiesEditionPart#addFilterValue(ViewerFilter filter)
	 */
	public void addFilterToValue(ViewerFilter filter) {
		valueFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.SlotPropertiesEditionPart#addBusinessFilterValue(ViewerFilter filter)
	 */
	public void addBusinessFilterToValue(ViewerFilter filter) {
		valueBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.SlotPropertiesEditionPart#isContainedInValueTable(EObject element)
	 */
	public boolean isContainedInValueTable(EObject element) {
		return valueEditUtil.contains(element);
	}





	// Start of user code additional methods

	// End of user code

}
