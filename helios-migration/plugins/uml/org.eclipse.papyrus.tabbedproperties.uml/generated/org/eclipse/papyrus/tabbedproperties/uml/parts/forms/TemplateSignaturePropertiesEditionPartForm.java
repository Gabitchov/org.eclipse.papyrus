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
import java.util.Iterator;
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
import org.eclipse.emf.eef.runtime.ui.widgets.TabElementTreeSelectionDialog;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.papyrus.tabbedproperties.uml.parts.TemplateSignaturePropertiesEditionPart;
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
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.TemplateParameter;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

// End of user code

/**
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class TemplateSignaturePropertiesEditionPartForm extends CompositePropertiesEditionPart implements IFormPropertiesEditionPart, TemplateSignaturePropertiesEditionPart {

	protected EMFListEditUtil ownedCommentEditUtil;

	protected ReferencesTable<? extends EObject> ownedComment;

	protected List<ViewerFilter> ownedCommentBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> ownedCommentFilters = new ArrayList<ViewerFilter>();

	private EMFListEditUtil parameterEditUtil;

	protected ReferencesTable<? extends EObject> parameter;

	protected List<ViewerFilter> parameterBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> parameterFilters = new ArrayList<ViewerFilter>();

	protected EMFListEditUtil ownedParameterEditUtil;

	protected ReferencesTable<? extends EObject> ownedParameter;

	protected List<ViewerFilter> ownedParameterBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> ownedParameterFilters = new ArrayList<ViewerFilter>();





	/**
	 * Default constructor
	 * 
	 * @param editionComponent
	 *        the {@link IPropertiesEditionComponent} that manage this part
	 */
	public TemplateSignaturePropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		createPropertiesGroup(widgetFactory, view);
		// Start of user code for additional ui definition

		// End of user code

	}

	protected void createPropertiesGroup(FormToolkit widgetFactory, final Composite view) {
		Section propertiesSection = widgetFactory.createSection(view, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		propertiesSection.setText(UMLMessages.TemplateSignaturePropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesSectionData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesSectionData.horizontalSpan = 3;
		propertiesSection.setLayoutData(propertiesSectionData);
		Composite propertiesGroup = widgetFactory.createComposite(propertiesSection);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		createOwnedCommentTableComposition(widgetFactory, propertiesGroup);
		createParameterReferencesTable(widgetFactory, propertiesGroup);
		createOwnedParameterTableComposition(widgetFactory, propertiesGroup);
		propertiesSection.setClient(propertiesGroup);
	}

	/**
	 * @param container
	 */
	protected void createOwnedCommentTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.ownedComment = new ReferencesTable<Comment>(UMLMessages.TemplateSignaturePropertiesEditionPart_OwnedCommentLabel, new ReferencesTableListener<Comment>() {

			public void handleAdd() {
				addToOwnedComment();
			}

			public void handleEdit(Comment element) {
				editOwnedComment(element);
			}

			public void handleMove(Comment element, int oldIndex, int newIndex) {
				moveOwnedComment(element, oldIndex, newIndex);
			}

			public void handleRemove(Comment element) {
				removeFromOwnedComment(element);
			}

			public void navigateTo(Comment element) {
			}
		});
		this.ownedComment.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.TemplateSignature.ownedComment, UMLViewsRepository.FORM_KIND));
		this.ownedComment.createControls(parent, widgetFactory);
		GridData ownedCommentData = new GridData(GridData.FILL_HORIZONTAL);
		ownedCommentData.horizontalSpan = 3;
		this.ownedComment.setLayoutData(ownedCommentData);
	}

	/**
	 * 
	 */
	protected void moveOwnedComment(Comment element, int oldIndex, int newIndex) {
		EObject editedElement = ownedCommentEditUtil.foundCorrespondingEObject(element);
		ownedCommentEditUtil.moveElement(element, oldIndex, newIndex);
		ownedComment.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TemplateSignaturePropertiesEditionPartForm.this, UMLViewsRepository.TemplateSignature.ownedComment, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	protected void addToOwnedComment() {
		// Start of user code addToOwnedComment() method body
		Comment eObject = UMLFactory.eINSTANCE.createComment();
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(eObject);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent,
					eObject, resourceSet));
			if(propertiesEditionObject != null) {
				ownedCommentEditUtil.addElement(propertiesEditionObject);
				ownedComment.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						TemplateSignaturePropertiesEditionPartForm.this,
						UMLViewsRepository.TemplateSignature.ownedComment, PropertiesEditionEvent.COMMIT,
						PropertiesEditionEvent.ADD, null, propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * 
	 */
	protected void removeFromOwnedComment(Comment element) {
		// Start of user code for the removeFromOwnedComment() method body
		EObject editedElement = ownedCommentEditUtil.foundCorrespondingEObject(element);
		ownedCommentEditUtil.removeElement(element);
		ownedComment.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				TemplateSignaturePropertiesEditionPartForm.this, UMLViewsRepository.TemplateSignature.ownedComment,
				PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editOwnedComment(Comment element) {
		// Start of user code editOwnedComment() method body
		EObject editedElement = ownedCommentEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				ownedCommentEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				ownedComment.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						TemplateSignaturePropertiesEditionPartForm.this,
						UMLViewsRepository.TemplateSignature.ownedComment, PropertiesEditionEvent.COMMIT,
						PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}
		// End of user code

	}

	protected void createParameterReferencesTable(FormToolkit widgetFactory, Composite parent) {
		this.parameter = new ReferencesTable<TemplateParameter>(UMLMessages.TemplateSignaturePropertiesEditionPart_ParameterLabel, new ReferencesTableListener<TemplateParameter>() {

			public void handleAdd() {
				TabElementTreeSelectionDialog<TemplateParameter> dialog = new TabElementTreeSelectionDialog<TemplateParameter>(resourceSet, parameterFilters, parameterBusinessFilters,
						"TemplateParameter", UMLPackage.eINSTANCE.getTemplateParameter(), current.eResource()) {

					@Override
					public void process(IStructuredSelection selection) {
						for(Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject)iter.next();
							if(!parameterEditUtil.getVirtualList().contains(elem))
								parameterEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TemplateSignaturePropertiesEditionPartForm.this, UMLViewsRepository.TemplateSignature.parameter,
									PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
						}
						parameter.refresh();
					}
				};
				dialog.open();
			}

			public void handleEdit(TemplateParameter element) {
				editParameter(element);
			}

			public void handleMove(TemplateParameter element, int oldIndex, int newIndex) {
				moveParameter(element, oldIndex, newIndex);
			}

			public void handleRemove(TemplateParameter element) {
				removeFromParameter(element);
			}

			public void navigateTo(TemplateParameter element) {
			}
		});
		this.parameter.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.TemplateSignature.parameter, UMLViewsRepository.FORM_KIND));
		this.parameter.createControls(parent, widgetFactory);
		GridData parameterData = new GridData(GridData.FILL_HORIZONTAL);
		parameterData.horizontalSpan = 3;
		this.parameter.setLayoutData(parameterData);
		this.parameter.disableMove();
	}

	/**
	 * 
	 */
	protected void moveParameter(TemplateParameter element, int oldIndex, int newIndex) {
		EObject editedElement = parameterEditUtil.foundCorrespondingEObject(element);
		parameterEditUtil.moveElement(element, oldIndex, newIndex);
		parameter.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TemplateSignaturePropertiesEditionPartForm.this, UMLViewsRepository.TemplateSignature.parameter, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	protected void removeFromParameter(TemplateParameter element) {
		// Start of user code for the removeFromParameter() method body
		EObject editedElement = parameterEditUtil.foundCorrespondingEObject(element);
		parameterEditUtil.removeElement(element);
		parameter.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				TemplateSignaturePropertiesEditionPartForm.this, UMLViewsRepository.TemplateSignature.parameter,
				PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editParameter(TemplateParameter element) {
		// Start of user code editParameter() method body

		EObject editedElement = parameterEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				parameterEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				parameter.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						TemplateSignaturePropertiesEditionPartForm.this,
						UMLViewsRepository.TemplateSignature.parameter, PropertiesEditionEvent.COMMIT,
						PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * @param container
	 */
	protected void createOwnedParameterTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.ownedParameter = new ReferencesTable<TemplateParameter>(UMLMessages.TemplateSignaturePropertiesEditionPart_OwnedParameterLabel, new ReferencesTableListener<TemplateParameter>() {

			public void handleAdd() {
				addToOwnedParameter();
			}

			public void handleEdit(TemplateParameter element) {
				editOwnedParameter(element);
			}

			public void handleMove(TemplateParameter element, int oldIndex, int newIndex) {
				moveOwnedParameter(element, oldIndex, newIndex);
			}

			public void handleRemove(TemplateParameter element) {
				removeFromOwnedParameter(element);
			}

			public void navigateTo(TemplateParameter element) {
			}
		});
		this.ownedParameter.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.TemplateSignature.ownedParameter, UMLViewsRepository.FORM_KIND));
		this.ownedParameter.createControls(parent, widgetFactory);
		GridData ownedParameterData = new GridData(GridData.FILL_HORIZONTAL);
		ownedParameterData.horizontalSpan = 3;
		this.ownedParameter.setLayoutData(ownedParameterData);
	}

	/**
	 * 
	 */
	protected void moveOwnedParameter(TemplateParameter element, int oldIndex, int newIndex) {
		EObject editedElement = ownedParameterEditUtil.foundCorrespondingEObject(element);
		ownedParameterEditUtil.moveElement(element, oldIndex, newIndex);
		ownedParameter.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TemplateSignaturePropertiesEditionPartForm.this, UMLViewsRepository.TemplateSignature.ownedParameter, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	protected void addToOwnedParameter() {
		// Start of user code addToOwnedParameter() method body
		TemplateParameter eObject = UMLFactory.eINSTANCE.createTemplateParameter();
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(eObject);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent,
					eObject, resourceSet));
			if(propertiesEditionObject != null) {
				ownedParameterEditUtil.addElement(propertiesEditionObject);
				ownedParameter.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						TemplateSignaturePropertiesEditionPartForm.this,
						UMLViewsRepository.TemplateSignature.ownedParameter, PropertiesEditionEvent.COMMIT,
						PropertiesEditionEvent.ADD, null, propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * 
	 */
	protected void removeFromOwnedParameter(TemplateParameter element) {
		// Start of user code for the removeFromOwnedParameter() method body
		EObject editedElement = ownedParameterEditUtil.foundCorrespondingEObject(element);
		ownedParameterEditUtil.removeElement(element);
		ownedParameter.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				TemplateSignaturePropertiesEditionPartForm.this, UMLViewsRepository.TemplateSignature.ownedParameter,
				PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editOwnedParameter(TemplateParameter element) {
		// Start of user code editOwnedParameter() method body
		EObject editedElement = ownedParameterEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				ownedParameterEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				ownedParameter.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						TemplateSignaturePropertiesEditionPartForm.this,
						UMLViewsRepository.TemplateSignature.ownedParameter, PropertiesEditionEvent.COMMIT,
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TemplateSignaturePropertiesEditionPart#getOwnedCommentToAdd()
	 */
	public List getOwnedCommentToAdd() {
		return ownedCommentEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TemplateSignaturePropertiesEditionPart#getOwnedCommentToRemove()
	 */
	public List getOwnedCommentToRemove() {
		return ownedCommentEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TemplateSignaturePropertiesEditionPart#getOwnedCommentToEdit()
	 */
	public Map getOwnedCommentToEdit() {
		return ownedCommentEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TemplateSignaturePropertiesEditionPart#getOwnedCommentToMove()
	 */
	public List getOwnedCommentToMove() {
		return ownedCommentEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TemplateSignaturePropertiesEditionPart#getOwnedCommentTable()
	 */
	public List getOwnedCommentTable() {
		return ownedCommentEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TemplateSignaturePropertiesEditionPart#initOwnedComment(EObject current, EReference
	 *      containingFeature, EReference feature)
	 */
	public void initOwnedComment(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			ownedCommentEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			ownedCommentEditUtil = new EMFListEditUtil(current, feature);
		this.ownedComment.setInput(ownedCommentEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TemplateSignaturePropertiesEditionPart#updateOwnedComment(EObject newValue)
	 */
	public void updateOwnedComment(EObject newValue) {
		if(ownedCommentEditUtil != null) {
			ownedCommentEditUtil.reinit(newValue);
			ownedComment.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TemplateSignaturePropertiesEditionPart#addFilterOwnedComment(ViewerFilter filter)
	 */
	public void addFilterToOwnedComment(ViewerFilter filter) {
		ownedCommentFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TemplateSignaturePropertiesEditionPart#addBusinessFilterOwnedComment(ViewerFilter filter)
	 */
	public void addBusinessFilterToOwnedComment(ViewerFilter filter) {
		ownedCommentBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TemplateSignaturePropertiesEditionPart#isContainedInOwnedCommentTable(EObject element)
	 */
	public boolean isContainedInOwnedCommentTable(EObject element) {
		return ownedCommentEditUtil.contains(element);
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TemplateSignaturePropertiesEditionPart#getParameterToAdd()
	 */
	public List getParameterToAdd() {
		return parameterEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TemplateSignaturePropertiesEditionPart#getParameterToRemove()
	 */
	public List getParameterToRemove() {
		return parameterEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TemplateSignaturePropertiesEditionPart#getParameterTable()
	 */
	public List getParameterTable() {
		return parameterEditUtil.getVirtualList();
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TemplateSignaturePropertiesEditionPart#initParameter(EObject current, EReference
	 *      containingFeature, EReference feature)
	 */
	public void initParameter(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			parameterEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			parameterEditUtil = new EMFListEditUtil(current, feature);
		this.parameter.setInput(parameterEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TemplateSignaturePropertiesEditionPart#updateParameter(EObject newValue)
	 */
	public void updateParameter(EObject newValue) {
		if(parameterEditUtil != null) {
			parameterEditUtil.reinit(newValue);
			parameter.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TemplateSignaturePropertiesEditionPart#addFilterParameter(ViewerFilter filter)
	 */
	public void addFilterToParameter(ViewerFilter filter) {
		parameterFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TemplateSignaturePropertiesEditionPart#addBusinessFilterParameter(ViewerFilter filter)
	 */
	public void addBusinessFilterToParameter(ViewerFilter filter) {
		parameterBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TemplateSignaturePropertiesEditionPart#isContainedInParameterTable(EObject element)
	 */
	public boolean isContainedInParameterTable(EObject element) {
		return parameterEditUtil.contains(element);
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TemplateSignaturePropertiesEditionPart#getOwnedParameterToAdd()
	 */
	public List getOwnedParameterToAdd() {
		return ownedParameterEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TemplateSignaturePropertiesEditionPart#getOwnedParameterToRemove()
	 */
	public List getOwnedParameterToRemove() {
		return ownedParameterEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TemplateSignaturePropertiesEditionPart#getOwnedParameterToEdit()
	 */
	public Map getOwnedParameterToEdit() {
		return ownedParameterEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TemplateSignaturePropertiesEditionPart#getOwnedParameterToMove()
	 */
	public List getOwnedParameterToMove() {
		return ownedParameterEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TemplateSignaturePropertiesEditionPart#getOwnedParameterTable()
	 */
	public List getOwnedParameterTable() {
		return ownedParameterEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TemplateSignaturePropertiesEditionPart#initOwnedParameter(EObject current, EReference
	 *      containingFeature, EReference feature)
	 */
	public void initOwnedParameter(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			ownedParameterEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			ownedParameterEditUtil = new EMFListEditUtil(current, feature);
		this.ownedParameter.setInput(ownedParameterEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TemplateSignaturePropertiesEditionPart#updateOwnedParameter(EObject newValue)
	 */
	public void updateOwnedParameter(EObject newValue) {
		if(ownedParameterEditUtil != null) {
			ownedParameterEditUtil.reinit(newValue);
			ownedParameter.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TemplateSignaturePropertiesEditionPart#addFilterOwnedParameter(ViewerFilter filter)
	 */
	public void addFilterToOwnedParameter(ViewerFilter filter) {
		ownedParameterFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TemplateSignaturePropertiesEditionPart#addBusinessFilterOwnedParameter(ViewerFilter filter)
	 */
	public void addBusinessFilterToOwnedParameter(ViewerFilter filter) {
		ownedParameterBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TemplateSignaturePropertiesEditionPart#isContainedInOwnedParameterTable(EObject element)
	 */
	public boolean isContainedInOwnedParameterTable(EObject element) {
		return ownedParameterEditUtil.contains(element);
	}





	// Start of user code additional methods

	// End of user code

}
