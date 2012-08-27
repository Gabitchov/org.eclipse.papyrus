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
package org.eclipse.papyrus.tabbedproperties.uml.parts.impl;

// Start of user code for imports

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;
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
import org.eclipse.papyrus.tabbedproperties.uml.parts.TemplateBindingPropertiesEditionPart;
import org.eclipse.papyrus.tabbedproperties.uml.parts.UMLViewsRepository;
import org.eclipse.papyrus.tabbedproperties.uml.providers.UMLMessages;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.uml2.uml.TemplateParameterSubstitution;
import org.eclipse.uml2.uml.UMLFactory;

// End of user code

/**
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class TemplateBindingPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, TemplateBindingPropertiesEditionPart {

	protected EMFListEditUtil parameterSubstitutionEditUtil;

	protected ReferencesTable<? extends EObject> parameterSubstitution;

	protected List<ViewerFilter> parameterSubstitutionBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> parameterSubstitutionFilters = new ArrayList<ViewerFilter>();





	/**
	 * Default constructor
	 * 
	 * @param editionComponent
	 *        the {@link IPropertiesEditionComponent} that manage this part
	 */
	public TemplateBindingPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart# createFigure(org.eclipse.swt.widgets.Composite)
	 */
	public Composite createFigure(final Composite parent) {
		view = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		view.setLayout(layout);

		createControls(view);
		return view;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart# createControls(org.eclipse.swt.widgets.Composite)
	 */
	public void createControls(Composite view) {
		createGeneralGroup(view);

		// Start of user code for additional ui definition

		// End of user code

	}

	protected void createGeneralGroup(Composite parent) {
		Group generalGroup = new Group(parent, SWT.NONE);
		generalGroup.setText(UMLMessages.TemplateBindingPropertiesEditionPart_GeneralGroupLabel);
		GridData generalGroupData = new GridData(GridData.FILL_HORIZONTAL);
		generalGroupData.horizontalSpan = 3;
		generalGroup.setLayoutData(generalGroupData);
		GridLayout generalGroupLayout = new GridLayout();
		generalGroupLayout.numColumns = 3;
		generalGroup.setLayout(generalGroupLayout);
		createParameterSubstitutionAdvancedTableComposition(generalGroup);
	}

	/**
	 * @param container
	 */
	protected void createParameterSubstitutionAdvancedTableComposition(Composite parent) {
		this.parameterSubstitution = new ReferencesTable<TemplateParameterSubstitution>(UMLMessages.TemplateBindingPropertiesEditionPart_ParameterSubstitutionLabel, new ReferencesTableListener<TemplateParameterSubstitution>() {

			public void handleAdd() {
				addToParameterSubstitution();
			}

			public void handleEdit(TemplateParameterSubstitution element) {
				editParameterSubstitution(element);
			}

			public void handleMove(TemplateParameterSubstitution element, int oldIndex, int newIndex) {
				moveParameterSubstitution(element, oldIndex, newIndex);
			}

			public void handleRemove(TemplateParameterSubstitution element) {
				removeFromParameterSubstitution(element);
			}

			public void navigateTo(TemplateParameterSubstitution element) {
			}
		});
		this.parameterSubstitution.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.TemplateBinding.parameterSubstitution, UMLViewsRepository.SWT_KIND));
		this.parameterSubstitution.createControls(parent);
		GridData parameterSubstitutionData = new GridData(GridData.FILL_HORIZONTAL);
		parameterSubstitutionData.horizontalSpan = 3;
		this.parameterSubstitution.setLayoutData(parameterSubstitutionData);
	}

	/**
	 * 
	 */
	protected void moveParameterSubstitution(TemplateParameterSubstitution element, int oldIndex, int newIndex) {
		EObject editedElement = parameterSubstitutionEditUtil.foundCorrespondingEObject(element);
		parameterSubstitutionEditUtil.moveElement(element, oldIndex, newIndex);
		parameterSubstitution.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TemplateBindingPropertiesEditionPartImpl.this, UMLViewsRepository.TemplateBinding.parameterSubstitution, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	protected void addToParameterSubstitution() {

		// Start of user code addToParameterSubstitution() method body
		TemplateParameterSubstitution eObject = UMLFactory.eINSTANCE.createTemplateParameterSubstitution();
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(eObject);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent,
					eObject, resourceSet));
			if(propertiesEditionObject != null) {
				parameterSubstitutionEditUtil.addElement(propertiesEditionObject);
				parameterSubstitution.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						TemplateBindingPropertiesEditionPartImpl.this,
						UMLViewsRepository.TemplateBinding.parameterSubstitution, PropertiesEditionEvent.CHANGE,
						PropertiesEditionEvent.ADD, null, propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * 
	 */
	protected void removeFromParameterSubstitution(TemplateParameterSubstitution element) {

		// Start of user code removeFromParameterSubstitution() method body
		EObject editedElement = parameterSubstitutionEditUtil.foundCorrespondingEObject(element);
		parameterSubstitutionEditUtil.removeElement(element);
		parameterSubstitution.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				TemplateBindingPropertiesEditionPartImpl.this,
				UMLViewsRepository.TemplateBinding.parameterSubstitution, PropertiesEditionEvent.CHANGE,
				PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editParameterSubstitution(TemplateParameterSubstitution element) {

		// Start of user code editParameterSubstitution() method body
		EObject editedElement = parameterSubstitutionEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				parameterSubstitutionEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				parameterSubstitution.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						TemplateBindingPropertiesEditionPartImpl.this,
						UMLViewsRepository.TemplateBinding.parameterSubstitution, PropertiesEditionEvent.CHANGE,
						PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TemplateBindingPropertiesEditionPart#getParameterSubstitutionToAdd()
	 */
	public List getParameterSubstitutionToAdd() {
		return parameterSubstitutionEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TemplateBindingPropertiesEditionPart#getParameterSubstitutionToRemove()
	 */
	public List getParameterSubstitutionToRemove() {
		return parameterSubstitutionEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TemplateBindingPropertiesEditionPart#getParameterSubstitutionToEdit()
	 */
	public Map getParameterSubstitutionToEdit() {
		return parameterSubstitutionEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TemplateBindingPropertiesEditionPart#getParameterSubstitutionToMove()
	 */
	public List getParameterSubstitutionToMove() {
		return parameterSubstitutionEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TemplateBindingPropertiesEditionPart#getParameterSubstitutionTable()
	 */
	public List getParameterSubstitutionTable() {
		return parameterSubstitutionEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TemplateBindingPropertiesEditionPart#initParameterSubstitution(EObject current, EReference
	 *      containingFeature, EReference feature)
	 */
	public void initParameterSubstitution(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			parameterSubstitutionEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			parameterSubstitutionEditUtil = new EMFListEditUtil(current, feature);
		this.parameterSubstitution.setInput(parameterSubstitutionEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TemplateBindingPropertiesEditionPart#updateParameterSubstitution(EObject newValue)
	 */
	public void updateParameterSubstitution(EObject newValue) {
		if(parameterSubstitutionEditUtil != null) {
			parameterSubstitutionEditUtil.reinit(newValue);
			parameterSubstitution.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TemplateBindingPropertiesEditionPart#addFilterParameterSubstitution(ViewerFilter filter)
	 */
	public void addFilterToParameterSubstitution(ViewerFilter filter) {
		parameterSubstitutionFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TemplateBindingPropertiesEditionPart#addBusinessFilterParameterSubstitution(ViewerFilter
	 *      filter)
	 */
	public void addBusinessFilterToParameterSubstitution(ViewerFilter filter) {
		parameterSubstitutionBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TemplateBindingPropertiesEditionPart#isContainedInParameterSubstitutionTable(EObject
	 *      element)
	 */
	public boolean isContainedInParameterSubstitutionTable(EObject element) {
		return parameterSubstitutionEditUtil.contains(element);
	}

	public void setMessageForParameterSubstitution(String msg, int msgLevel) {

	}

	public void unsetMessageForParameterSubstitution() {

	}





	// Start of user code additional methods

	// End of user code

}
