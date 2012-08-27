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
import org.eclipse.papyrus.tabbedproperties.uml.parts.TemplateParameterSubstitutionPropertiesEditionPart;
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
import org.eclipse.uml2.uml.ParameterableElement;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

// End of user code

/**
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class TemplateParameterSubstitutionPropertiesEditionPartForm extends CompositePropertiesEditionPart implements IFormPropertiesEditionPart, TemplateParameterSubstitutionPropertiesEditionPart {

	protected EMFListEditUtil ownedCommentEditUtil;

	protected ReferencesTable<? extends EObject> ownedComment;

	protected List<ViewerFilter> ownedCommentBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> ownedCommentFilters = new ArrayList<ViewerFilter>();

	private EMFListEditUtil actualEditUtil;

	protected ReferencesTable<? extends EObject> actual;

	protected List<ViewerFilter> actualBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> actualFilters = new ArrayList<ViewerFilter>();

	protected EMFListEditUtil ownedActualEditUtil;

	protected ReferencesTable<? extends EObject> ownedActual;

	protected List<ViewerFilter> ownedActualBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> ownedActualFilters = new ArrayList<ViewerFilter>();





	/**
	 * Default constructor
	 * 
	 * @param editionComponent
	 *        the {@link IPropertiesEditionComponent} that manage this part
	 */
	public TemplateParameterSubstitutionPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		propertiesSection.setText(UMLMessages.TemplateParameterSubstitutionPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesSectionData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesSectionData.horizontalSpan = 3;
		propertiesSection.setLayoutData(propertiesSectionData);
		Composite propertiesGroup = widgetFactory.createComposite(propertiesSection);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		createOwnedCommentTableComposition(widgetFactory, propertiesGroup);
		createActualReferencesTable(widgetFactory, propertiesGroup);
		createOwnedActualTableComposition(widgetFactory, propertiesGroup);
		propertiesSection.setClient(propertiesGroup);
	}

	/**
	 * @param container
	 */
	protected void createOwnedCommentTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.ownedComment = new ReferencesTable<Comment>(UMLMessages.TemplateParameterSubstitutionPropertiesEditionPart_OwnedCommentLabel, new ReferencesTableListener<Comment>() {

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
		this.ownedComment.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.TemplateParameterSubstitution.ownedComment, UMLViewsRepository.FORM_KIND));
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
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TemplateParameterSubstitutionPropertiesEditionPartForm.this, UMLViewsRepository.TemplateParameterSubstitution.ownedComment, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
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
						TemplateParameterSubstitutionPropertiesEditionPartForm.this,
						UMLViewsRepository.TemplateParameterSubstitution.ownedComment, PropertiesEditionEvent.COMMIT,
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
				TemplateParameterSubstitutionPropertiesEditionPartForm.this,
				UMLViewsRepository.TemplateParameterSubstitution.ownedComment, PropertiesEditionEvent.COMMIT,
				PropertiesEditionEvent.REMOVE, null, editedElement));
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
						TemplateParameterSubstitutionPropertiesEditionPartForm.this,
						UMLViewsRepository.TemplateParameterSubstitution.ownedComment, PropertiesEditionEvent.COMMIT,
						PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}
		// End of user code

	}

	protected void createActualReferencesTable(FormToolkit widgetFactory, Composite parent) {
		this.actual = new ReferencesTable<ParameterableElement>(UMLMessages.TemplateParameterSubstitutionPropertiesEditionPart_ActualLabel, new ReferencesTableListener<ParameterableElement>() {

			public void handleAdd() {
				TabElementTreeSelectionDialog<ParameterableElement> dialog = new TabElementTreeSelectionDialog<ParameterableElement>(resourceSet, actualFilters, actualBusinessFilters,
						"ParameterableElement", UMLPackage.eINSTANCE.getParameterableElement(), current.eResource()) {

					@Override
					public void process(IStructuredSelection selection) {
						for(Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject)iter.next();
							if(!actualEditUtil.getVirtualList().contains(elem))
								actualEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TemplateParameterSubstitutionPropertiesEditionPartForm.this, UMLViewsRepository.TemplateParameterSubstitution.actual,
									PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
						}
						actual.refresh();
					}
				};
				dialog.open();
			}

			public void handleEdit(ParameterableElement element) {
				editActual(element);
			}

			public void handleMove(ParameterableElement element, int oldIndex, int newIndex) {
				moveActual(element, oldIndex, newIndex);
			}

			public void handleRemove(ParameterableElement element) {
				removeFromActual(element);
			}

			public void navigateTo(ParameterableElement element) {
			}
		});
		this.actual.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.TemplateParameterSubstitution.actual, UMLViewsRepository.FORM_KIND));
		this.actual.createControls(parent, widgetFactory);
		GridData actualData = new GridData(GridData.FILL_HORIZONTAL);
		actualData.horizontalSpan = 3;
		this.actual.setLayoutData(actualData);
		this.actual.disableMove();
	}

	/**
	 * 
	 */
	protected void moveActual(ParameterableElement element, int oldIndex, int newIndex) {
	}

	/**
	 * 
	 */
	protected void removeFromActual(ParameterableElement element) {
		// Start of user code for the removeFromActual() method body
		EObject editedElement = actualEditUtil.foundCorrespondingEObject(element);
		actualEditUtil.removeElement(element);
		actual.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				TemplateParameterSubstitutionPropertiesEditionPartForm.this,
				UMLViewsRepository.TemplateParameterSubstitution.actual, PropertiesEditionEvent.COMMIT,
				PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editActual(ParameterableElement element) {
		// Start of user code editActual() method body

		EObject editedElement = actualEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				actualEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				actual.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						TemplateParameterSubstitutionPropertiesEditionPartForm.this,
						UMLViewsRepository.TemplateParameterSubstitution.actual, PropertiesEditionEvent.COMMIT,
						PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * @param container
	 */
	protected void createOwnedActualTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.ownedActual = new ReferencesTable<ParameterableElement>(UMLMessages.TemplateParameterSubstitutionPropertiesEditionPart_OwnedActualLabel, new ReferencesTableListener<ParameterableElement>() {

			public void handleAdd() {
				addToOwnedActual();
			}

			public void handleEdit(ParameterableElement element) {
				editOwnedActual(element);
			}

			public void handleMove(ParameterableElement element, int oldIndex, int newIndex) {
				moveOwnedActual(element, oldIndex, newIndex);
			}

			public void handleRemove(ParameterableElement element) {
				removeFromOwnedActual(element);
			}

			public void navigateTo(ParameterableElement element) {
			}
		});
		this.ownedActual.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.TemplateParameterSubstitution.ownedActual, UMLViewsRepository.FORM_KIND));
		this.ownedActual.createControls(parent, widgetFactory);
		GridData ownedActualData = new GridData(GridData.FILL_HORIZONTAL);
		ownedActualData.horizontalSpan = 3;
		this.ownedActual.setLayoutData(ownedActualData);
	}

	/**
	 * 
	 */
	protected void moveOwnedActual(ParameterableElement element, int oldIndex, int newIndex) {
	}

	/**
	 * 
	 */
	protected void addToOwnedActual() {
		// Start of user code addToOwnedActual() method body
		// End of user code

	}

	/**
	 * 
	 */
	protected void removeFromOwnedActual(ParameterableElement element) {
		// Start of user code for the removeFromOwnedActual() method body
		EObject editedElement = ownedActualEditUtil.foundCorrespondingEObject(element);
		ownedActualEditUtil.removeElement(element);
		ownedActual.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				TemplateParameterSubstitutionPropertiesEditionPartForm.this,
				UMLViewsRepository.TemplateParameterSubstitution.ownedActual, PropertiesEditionEvent.COMMIT,
				PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editOwnedActual(ParameterableElement element) {
		// Start of user code editOwnedActual() method body
		EObject editedElement = ownedActualEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				ownedActualEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				ownedActual.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						TemplateParameterSubstitutionPropertiesEditionPartForm.this,
						UMLViewsRepository.TemplateParameterSubstitution.ownedActual, PropertiesEditionEvent.COMMIT,
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TemplateParameterSubstitutionPropertiesEditionPart#getOwnedCommentToAdd()
	 */
	public List getOwnedCommentToAdd() {
		return ownedCommentEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TemplateParameterSubstitutionPropertiesEditionPart#getOwnedCommentToRemove()
	 */
	public List getOwnedCommentToRemove() {
		return ownedCommentEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TemplateParameterSubstitutionPropertiesEditionPart#getOwnedCommentToEdit()
	 */
	public Map getOwnedCommentToEdit() {
		return ownedCommentEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TemplateParameterSubstitutionPropertiesEditionPart#getOwnedCommentToMove()
	 */
	public List getOwnedCommentToMove() {
		return ownedCommentEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TemplateParameterSubstitutionPropertiesEditionPart#getOwnedCommentTable()
	 */
	public List getOwnedCommentTable() {
		return ownedCommentEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TemplateParameterSubstitutionPropertiesEditionPart#initOwnedComment(EObject current,
	 *      EReference containingFeature, EReference feature)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TemplateParameterSubstitutionPropertiesEditionPart#updateOwnedComment(EObject newValue)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TemplateParameterSubstitutionPropertiesEditionPart#addFilterOwnedComment(ViewerFilter
	 *      filter)
	 */
	public void addFilterToOwnedComment(ViewerFilter filter) {
		ownedCommentFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TemplateParameterSubstitutionPropertiesEditionPart#addBusinessFilterOwnedComment(ViewerFilter
	 *      filter)
	 */
	public void addBusinessFilterToOwnedComment(ViewerFilter filter) {
		ownedCommentBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TemplateParameterSubstitutionPropertiesEditionPart#isContainedInOwnedCommentTable(EObject
	 *      element)
	 */
	public boolean isContainedInOwnedCommentTable(EObject element) {
		return ownedCommentEditUtil.contains(element);
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TemplateParameterSubstitutionPropertiesEditionPart#getActualToAdd()
	 */
	public List getActualToAdd() {
		return actualEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TemplateParameterSubstitutionPropertiesEditionPart#getActualToRemove()
	 */
	public List getActualToRemove() {
		return actualEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TemplateParameterSubstitutionPropertiesEditionPart#getActualTable()
	 */
	public List getActualTable() {
		return actualEditUtil.getVirtualList();
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TemplateParameterSubstitutionPropertiesEditionPart#initActual(EObject current, EReference
	 *      containingFeature, EReference feature)
	 */
	public void initActual(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			actualEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			actualEditUtil = new EMFListEditUtil(current, feature);
		this.actual.setInput(actualEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TemplateParameterSubstitutionPropertiesEditionPart#updateActual(EObject newValue)
	 */
	public void updateActual(EObject newValue) {
		if(actualEditUtil != null) {
			actualEditUtil.reinit(newValue);
			actual.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TemplateParameterSubstitutionPropertiesEditionPart#addFilterActual(ViewerFilter filter)
	 */
	public void addFilterToActual(ViewerFilter filter) {
		actualFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TemplateParameterSubstitutionPropertiesEditionPart#addBusinessFilterActual(ViewerFilter
	 *      filter)
	 */
	public void addBusinessFilterToActual(ViewerFilter filter) {
		actualBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TemplateParameterSubstitutionPropertiesEditionPart#isContainedInActualTable(EObject
	 *      element)
	 */
	public boolean isContainedInActualTable(EObject element) {
		return actualEditUtil.contains(element);
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TemplateParameterSubstitutionPropertiesEditionPart#getOwnedActualToAdd()
	 */
	public List getOwnedActualToAdd() {
		return ownedActualEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TemplateParameterSubstitutionPropertiesEditionPart#getOwnedActualToRemove()
	 */
	public List getOwnedActualToRemove() {
		return ownedActualEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TemplateParameterSubstitutionPropertiesEditionPart#getOwnedActualToEdit()
	 */
	public Map getOwnedActualToEdit() {
		return ownedActualEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TemplateParameterSubstitutionPropertiesEditionPart#getOwnedActualToMove()
	 */
	public List getOwnedActualToMove() {
		return ownedActualEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TemplateParameterSubstitutionPropertiesEditionPart#getOwnedActualTable()
	 */
	public List getOwnedActualTable() {
		return ownedActualEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TemplateParameterSubstitutionPropertiesEditionPart#initOwnedActual(EObject current,
	 *      EReference containingFeature, EReference feature)
	 */
	public void initOwnedActual(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			ownedActualEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			ownedActualEditUtil = new EMFListEditUtil(current, feature);
		this.ownedActual.setInput(ownedActualEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TemplateParameterSubstitutionPropertiesEditionPart#updateOwnedActual(EObject newValue)
	 */
	public void updateOwnedActual(EObject newValue) {
		if(ownedActualEditUtil != null) {
			ownedActualEditUtil.reinit(newValue);
			ownedActual.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TemplateParameterSubstitutionPropertiesEditionPart#addFilterOwnedActual(ViewerFilter
	 *      filter)
	 */
	public void addFilterToOwnedActual(ViewerFilter filter) {
		ownedActualFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TemplateParameterSubstitutionPropertiesEditionPart#addBusinessFilterOwnedActual(ViewerFilter
	 *      filter)
	 */
	public void addBusinessFilterToOwnedActual(ViewerFilter filter) {
		ownedActualBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.TemplateParameterSubstitutionPropertiesEditionPart#isContainedInOwnedActualTable(EObject
	 *      element)
	 */
	public boolean isContainedInOwnedActualTable(EObject element) {
		return ownedActualEditUtil.contains(element);
	}





	// Start of user code additional methods

	// End of user code

}
