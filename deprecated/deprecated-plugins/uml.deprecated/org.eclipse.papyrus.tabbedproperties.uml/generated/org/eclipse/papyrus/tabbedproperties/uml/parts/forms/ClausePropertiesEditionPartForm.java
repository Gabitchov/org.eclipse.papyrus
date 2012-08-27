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
import org.eclipse.papyrus.tabbedproperties.uml.parts.ClausePropertiesEditionPart;
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
import org.eclipse.uml2.uml.Clause;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.ExecutableNode;
import org.eclipse.uml2.uml.OutputPin;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

// End of user code

/**
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class ClausePropertiesEditionPartForm extends CompositePropertiesEditionPart implements IFormPropertiesEditionPart, ClausePropertiesEditionPart {

	protected EMFListEditUtil ownedCommentEditUtil;

	protected ReferencesTable<? extends EObject> ownedComment;

	protected List<ViewerFilter> ownedCommentBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> ownedCommentFilters = new ArrayList<ViewerFilter>();

	private EMFListEditUtil testEditUtil;

	protected ReferencesTable<? extends EObject> test;

	protected List<ViewerFilter> testBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> testFilters = new ArrayList<ViewerFilter>();

	private EMFListEditUtil bodyEditUtil;

	protected ReferencesTable<? extends EObject> body;

	protected List<ViewerFilter> bodyBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> bodyFilters = new ArrayList<ViewerFilter>();

	private EMFListEditUtil predecessorClauseEditUtil;

	protected ReferencesTable<? extends EObject> predecessorClause;

	protected List<ViewerFilter> predecessorClauseBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> predecessorClauseFilters = new ArrayList<ViewerFilter>();

	private EMFListEditUtil successorClauseEditUtil;

	protected ReferencesTable<? extends EObject> successorClause;

	protected List<ViewerFilter> successorClauseBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> successorClauseFilters = new ArrayList<ViewerFilter>();

	private EMFListEditUtil bodyOutputEditUtil;

	protected ReferencesTable<? extends EObject> bodyOutput;

	protected List<ViewerFilter> bodyOutputBusinessFilters = new ArrayList<ViewerFilter>();

	protected List<ViewerFilter> bodyOutputFilters = new ArrayList<ViewerFilter>();





	/**
	 * Default constructor
	 * 
	 * @param editionComponent
	 *        the {@link IPropertiesEditionComponent} that manage this part
	 */
	public ClausePropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		propertiesSection.setText(UMLMessages.ClausePropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesSectionData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesSectionData.horizontalSpan = 3;
		propertiesSection.setLayoutData(propertiesSectionData);
		Composite propertiesGroup = widgetFactory.createComposite(propertiesSection);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		createOwnedCommentTableComposition(widgetFactory, propertiesGroup);
		createTestReferencesTable(widgetFactory, propertiesGroup);
		createBodyReferencesTable(widgetFactory, propertiesGroup);
		createPredecessorClauseReferencesTable(widgetFactory, propertiesGroup);
		createSuccessorClauseReferencesTable(widgetFactory, propertiesGroup);
		createBodyOutputReferencesTable(widgetFactory, propertiesGroup);
		propertiesSection.setClient(propertiesGroup);
	}

	/**
	 * @param container
	 */
	protected void createOwnedCommentTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.ownedComment = new ReferencesTable<Comment>(UMLMessages.ClausePropertiesEditionPart_OwnedCommentLabel, new ReferencesTableListener<Comment>() {

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
		this.ownedComment.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.Clause.ownedComment, UMLViewsRepository.FORM_KIND));
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
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ClausePropertiesEditionPartForm.this, UMLViewsRepository.Clause.ownedComment, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
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
						ClausePropertiesEditionPartForm.this, UMLViewsRepository.Clause.ownedComment,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, propertiesEditionObject));
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
				ClausePropertiesEditionPartForm.this, UMLViewsRepository.Clause.ownedComment,
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
						ClausePropertiesEditionPartForm.this, UMLViewsRepository.Clause.ownedComment,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, editedElement,
						propertiesEditionObject));
			}
		}
		// End of user code

	}

	protected void createTestReferencesTable(FormToolkit widgetFactory, Composite parent) {
		this.test = new ReferencesTable<ExecutableNode>(UMLMessages.ClausePropertiesEditionPart_TestLabel, new ReferencesTableListener<ExecutableNode>() {

			public void handleAdd() {
				TabElementTreeSelectionDialog<ExecutableNode> dialog = new TabElementTreeSelectionDialog<ExecutableNode>(resourceSet, testFilters, testBusinessFilters,
						"ExecutableNode", UMLPackage.eINSTANCE.getExecutableNode(), current.eResource()) {

					@Override
					public void process(IStructuredSelection selection) {
						for(Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject)iter.next();
							if(!testEditUtil.getVirtualList().contains(elem))
								testEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ClausePropertiesEditionPartForm.this, UMLViewsRepository.Clause.test,
									PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
						}
						test.refresh();
					}
				};
				dialog.open();
			}

			public void handleEdit(ExecutableNode element) {
				editTest(element);
			}

			public void handleMove(ExecutableNode element, int oldIndex, int newIndex) {
				moveTest(element, oldIndex, newIndex);
			}

			public void handleRemove(ExecutableNode element) {
				removeFromTest(element);
			}

			public void navigateTo(ExecutableNode element) {
			}
		});
		this.test.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.Clause.test, UMLViewsRepository.FORM_KIND));
		this.test.createControls(parent, widgetFactory);
		GridData testData = new GridData(GridData.FILL_HORIZONTAL);
		testData.horizontalSpan = 3;
		this.test.setLayoutData(testData);
		this.test.disableMove();
	}

	/**
	 * 
	 */
	protected void moveTest(ExecutableNode element, int oldIndex, int newIndex) {
	}

	/**
	 * 
	 */
	protected void removeFromTest(ExecutableNode element) {
		// Start of user code for the removeFromTest() method body
		EObject editedElement = testEditUtil.foundCorrespondingEObject(element);
		testEditUtil.removeElement(element);
		test.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				ClausePropertiesEditionPartForm.this, UMLViewsRepository.Clause.test, PropertiesEditionEvent.COMMIT,
				PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editTest(ExecutableNode element) {
		// Start of user code editTest() method body

		EObject editedElement = testEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				testEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				test.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						ClausePropertiesEditionPartForm.this, UMLViewsRepository.Clause.test,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, editedElement,
						propertiesEditionObject));
			}
		}
		// End of user code

	}

	protected void createBodyReferencesTable(FormToolkit widgetFactory, Composite parent) {
		this.body = new ReferencesTable<ExecutableNode>(UMLMessages.ClausePropertiesEditionPart_BodyLabel, new ReferencesTableListener<ExecutableNode>() {

			public void handleAdd() {
				TabElementTreeSelectionDialog<ExecutableNode> dialog = new TabElementTreeSelectionDialog<ExecutableNode>(resourceSet, bodyFilters, bodyBusinessFilters,
						"ExecutableNode", UMLPackage.eINSTANCE.getExecutableNode(), current.eResource()) {

					@Override
					public void process(IStructuredSelection selection) {
						for(Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject)iter.next();
							if(!bodyEditUtil.getVirtualList().contains(elem))
								bodyEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ClausePropertiesEditionPartForm.this, UMLViewsRepository.Clause.body,
									PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
						}
						body.refresh();
					}
				};
				dialog.open();
			}

			public void handleEdit(ExecutableNode element) {
				editBody(element);
			}

			public void handleMove(ExecutableNode element, int oldIndex, int newIndex) {
				moveBody(element, oldIndex, newIndex);
			}

			public void handleRemove(ExecutableNode element) {
				removeFromBody(element);
			}

			public void navigateTo(ExecutableNode element) {
			}
		});
		this.body.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.Clause.body, UMLViewsRepository.FORM_KIND));
		this.body.createControls(parent, widgetFactory);
		GridData bodyData = new GridData(GridData.FILL_HORIZONTAL);
		bodyData.horizontalSpan = 3;
		this.body.setLayoutData(bodyData);
		this.body.disableMove();
	}

	/**
	 * 
	 */
	protected void moveBody(ExecutableNode element, int oldIndex, int newIndex) {
	}

	/**
	 * 
	 */
	protected void removeFromBody(ExecutableNode element) {
		// Start of user code for the removeFromBody() method body
		EObject editedElement = bodyEditUtil.foundCorrespondingEObject(element);
		bodyEditUtil.removeElement(element);
		body.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				ClausePropertiesEditionPartForm.this, UMLViewsRepository.Clause.body, PropertiesEditionEvent.COMMIT,
				PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editBody(ExecutableNode element) {
		// Start of user code editBody() method body

		EObject editedElement = bodyEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				bodyEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				body.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						ClausePropertiesEditionPartForm.this, UMLViewsRepository.Clause.body,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, editedElement,
						propertiesEditionObject));
			}
		}
		// End of user code

	}

	protected void createPredecessorClauseReferencesTable(FormToolkit widgetFactory, Composite parent) {
		this.predecessorClause = new ReferencesTable<Clause>(UMLMessages.ClausePropertiesEditionPart_PredecessorClauseLabel, new ReferencesTableListener<Clause>() {

			public void handleAdd() {
				TabElementTreeSelectionDialog<Clause> dialog = new TabElementTreeSelectionDialog<Clause>(resourceSet, predecessorClauseFilters, predecessorClauseBusinessFilters,
						"Clause", UMLPackage.eINSTANCE.getClause(), current.eResource()) {

					@Override
					public void process(IStructuredSelection selection) {
						for(Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject)iter.next();
							if(!predecessorClauseEditUtil.getVirtualList().contains(elem))
								predecessorClauseEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ClausePropertiesEditionPartForm.this, UMLViewsRepository.Clause.predecessorClause,
									PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
						}
						predecessorClause.refresh();
					}
				};
				dialog.open();
			}

			public void handleEdit(Clause element) {
				editPredecessorClause(element);
			}

			public void handleMove(Clause element, int oldIndex, int newIndex) {
				movePredecessorClause(element, oldIndex, newIndex);
			}

			public void handleRemove(Clause element) {
				removeFromPredecessorClause(element);
			}

			public void navigateTo(Clause element) {
			}
		});
		this.predecessorClause.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.Clause.predecessorClause, UMLViewsRepository.FORM_KIND));
		this.predecessorClause.createControls(parent, widgetFactory);
		GridData predecessorClauseData = new GridData(GridData.FILL_HORIZONTAL);
		predecessorClauseData.horizontalSpan = 3;
		this.predecessorClause.setLayoutData(predecessorClauseData);
		this.predecessorClause.disableMove();
	}

	/**
	 * 
	 */
	protected void movePredecessorClause(Clause element, int oldIndex, int newIndex) {
		EObject editedElement = predecessorClauseEditUtil.foundCorrespondingEObject(element);
		predecessorClauseEditUtil.moveElement(element, oldIndex, newIndex);
		predecessorClause.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ClausePropertiesEditionPartForm.this, UMLViewsRepository.Clause.predecessorClause, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	protected void removeFromPredecessorClause(Clause element) {
		// Start of user code for the removeFromPredecessorClause() method body
		EObject editedElement = predecessorClauseEditUtil.foundCorrespondingEObject(element);
		predecessorClauseEditUtil.removeElement(element);
		predecessorClause.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				ClausePropertiesEditionPartForm.this, UMLViewsRepository.Clause.predecessorClause,
				PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editPredecessorClause(Clause element) {
		// Start of user code editPredecessorClause() method body

		EObject editedElement = predecessorClauseEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				predecessorClauseEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				predecessorClause.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						ClausePropertiesEditionPartForm.this, UMLViewsRepository.Clause.predecessorClause,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, editedElement,
						propertiesEditionObject));
			}
		}
		// End of user code

	}

	protected void createSuccessorClauseReferencesTable(FormToolkit widgetFactory, Composite parent) {
		this.successorClause = new ReferencesTable<Clause>(UMLMessages.ClausePropertiesEditionPart_SuccessorClauseLabel, new ReferencesTableListener<Clause>() {

			public void handleAdd() {
				TabElementTreeSelectionDialog<Clause> dialog = new TabElementTreeSelectionDialog<Clause>(resourceSet, successorClauseFilters, successorClauseBusinessFilters,
						"Clause", UMLPackage.eINSTANCE.getClause(), current.eResource()) {

					@Override
					public void process(IStructuredSelection selection) {
						for(Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject)iter.next();
							if(!successorClauseEditUtil.getVirtualList().contains(elem))
								successorClauseEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ClausePropertiesEditionPartForm.this, UMLViewsRepository.Clause.successorClause,
									PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
						}
						successorClause.refresh();
					}
				};
				dialog.open();
			}

			public void handleEdit(Clause element) {
				editSuccessorClause(element);
			}

			public void handleMove(Clause element, int oldIndex, int newIndex) {
				moveSuccessorClause(element, oldIndex, newIndex);
			}

			public void handleRemove(Clause element) {
				removeFromSuccessorClause(element);
			}

			public void navigateTo(Clause element) {
			}
		});
		this.successorClause.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.Clause.successorClause, UMLViewsRepository.FORM_KIND));
		this.successorClause.createControls(parent, widgetFactory);
		GridData successorClauseData = new GridData(GridData.FILL_HORIZONTAL);
		successorClauseData.horizontalSpan = 3;
		this.successorClause.setLayoutData(successorClauseData);
		this.successorClause.disableMove();
	}

	/**
	 * 
	 */
	protected void moveSuccessorClause(Clause element, int oldIndex, int newIndex) {
		EObject editedElement = successorClauseEditUtil.foundCorrespondingEObject(element);
		successorClauseEditUtil.moveElement(element, oldIndex, newIndex);
		successorClause.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ClausePropertiesEditionPartForm.this, UMLViewsRepository.Clause.successorClause, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	protected void removeFromSuccessorClause(Clause element) {
		// Start of user code for the removeFromSuccessorClause() method body
		EObject editedElement = successorClauseEditUtil.foundCorrespondingEObject(element);
		successorClauseEditUtil.removeElement(element);
		successorClause.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				ClausePropertiesEditionPartForm.this, UMLViewsRepository.Clause.successorClause,
				PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editSuccessorClause(Clause element) {
		// Start of user code editSuccessorClause() method body

		EObject editedElement = successorClauseEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				successorClauseEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				successorClause.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						ClausePropertiesEditionPartForm.this, UMLViewsRepository.Clause.successorClause,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, editedElement,
						propertiesEditionObject));
			}
		}
		// End of user code

	}

	protected void createBodyOutputReferencesTable(FormToolkit widgetFactory, Composite parent) {
		this.bodyOutput = new ReferencesTable<OutputPin>(UMLMessages.ClausePropertiesEditionPart_BodyOutputLabel, new ReferencesTableListener<OutputPin>() {

			public void handleAdd() {
				TabElementTreeSelectionDialog<OutputPin> dialog = new TabElementTreeSelectionDialog<OutputPin>(resourceSet, bodyOutputFilters, bodyOutputBusinessFilters,
						"OutputPin", UMLPackage.eINSTANCE.getOutputPin(), current.eResource()) {

					@Override
					public void process(IStructuredSelection selection) {
						for(Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject)iter.next();
							if(!bodyOutputEditUtil.getVirtualList().contains(elem))
								bodyOutputEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ClausePropertiesEditionPartForm.this, UMLViewsRepository.Clause.bodyOutput,
									PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
						}
						bodyOutput.refresh();
					}
				};
				dialog.open();
			}

			public void handleEdit(OutputPin element) {
				editBodyOutput(element);
			}

			public void handleMove(OutputPin element, int oldIndex, int newIndex) {
				moveBodyOutput(element, oldIndex, newIndex);
			}

			public void handleRemove(OutputPin element) {
				removeFromBodyOutput(element);
			}

			public void navigateTo(OutputPin element) {
			}
		});
		this.bodyOutput.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.Clause.bodyOutput, UMLViewsRepository.FORM_KIND));
		this.bodyOutput.createControls(parent, widgetFactory);
		GridData bodyOutputData = new GridData(GridData.FILL_HORIZONTAL);
		bodyOutputData.horizontalSpan = 3;
		this.bodyOutput.setLayoutData(bodyOutputData);
		this.bodyOutput.disableMove();
	}

	/**
	 * 
	 */
	protected void moveBodyOutput(OutputPin element, int oldIndex, int newIndex) {
		EObject editedElement = bodyOutputEditUtil.foundCorrespondingEObject(element);
		bodyOutputEditUtil.moveElement(element, oldIndex, newIndex);
		bodyOutput.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ClausePropertiesEditionPartForm.this, UMLViewsRepository.Clause.bodyOutput, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	protected void removeFromBodyOutput(OutputPin element) {
		// Start of user code for the removeFromBodyOutput() method body
		EObject editedElement = bodyOutputEditUtil.foundCorrespondingEObject(element);
		bodyOutputEditUtil.removeElement(element);
		bodyOutput.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
				ClausePropertiesEditionPartForm.this, UMLViewsRepository.Clause.bodyOutput,
				PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editBodyOutput(OutputPin element) {
		// Start of user code editBodyOutput() method body

		EObject editedElement = bodyOutputEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance()
				.getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if(editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy
					.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if(propertiesEditionObject != null) {
				bodyOutputEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				bodyOutput.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
						ClausePropertiesEditionPartForm.this, UMLViewsRepository.Clause.bodyOutput,
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ClausePropertiesEditionPart#getOwnedCommentToAdd()
	 */
	public List getOwnedCommentToAdd() {
		return ownedCommentEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ClausePropertiesEditionPart#getOwnedCommentToRemove()
	 */
	public List getOwnedCommentToRemove() {
		return ownedCommentEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ClausePropertiesEditionPart#getOwnedCommentToEdit()
	 */
	public Map getOwnedCommentToEdit() {
		return ownedCommentEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ClausePropertiesEditionPart#getOwnedCommentToMove()
	 */
	public List getOwnedCommentToMove() {
		return ownedCommentEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ClausePropertiesEditionPart#getOwnedCommentTable()
	 */
	public List getOwnedCommentTable() {
		return ownedCommentEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ClausePropertiesEditionPart#initOwnedComment(EObject current, EReference containingFeature,
	 *      EReference feature)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ClausePropertiesEditionPart#updateOwnedComment(EObject newValue)
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ClausePropertiesEditionPart#addFilterOwnedComment(ViewerFilter filter)
	 */
	public void addFilterToOwnedComment(ViewerFilter filter) {
		ownedCommentFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ClausePropertiesEditionPart#addBusinessFilterOwnedComment(ViewerFilter filter)
	 */
	public void addBusinessFilterToOwnedComment(ViewerFilter filter) {
		ownedCommentBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ClausePropertiesEditionPart#isContainedInOwnedCommentTable(EObject element)
	 */
	public boolean isContainedInOwnedCommentTable(EObject element) {
		return ownedCommentEditUtil.contains(element);
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ClausePropertiesEditionPart#getTestToAdd()
	 */
	public List getTestToAdd() {
		return testEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ClausePropertiesEditionPart#getTestToRemove()
	 */
	public List getTestToRemove() {
		return testEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ClausePropertiesEditionPart#getTestTable()
	 */
	public List getTestTable() {
		return testEditUtil.getVirtualList();
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ClausePropertiesEditionPart#initTest(EObject current, EReference containingFeature,
	 *      EReference feature)
	 */
	public void initTest(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			testEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			testEditUtil = new EMFListEditUtil(current, feature);
		this.test.setInput(testEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ClausePropertiesEditionPart#updateTest(EObject newValue)
	 */
	public void updateTest(EObject newValue) {
		if(testEditUtil != null) {
			testEditUtil.reinit(newValue);
			test.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ClausePropertiesEditionPart#addFilterTest(ViewerFilter filter)
	 */
	public void addFilterToTest(ViewerFilter filter) {
		testFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ClausePropertiesEditionPart#addBusinessFilterTest(ViewerFilter filter)
	 */
	public void addBusinessFilterToTest(ViewerFilter filter) {
		testBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ClausePropertiesEditionPart#isContainedInTestTable(EObject element)
	 */
	public boolean isContainedInTestTable(EObject element) {
		return testEditUtil.contains(element);
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ClausePropertiesEditionPart#getBodyToAdd()
	 */
	public List getBodyToAdd() {
		return bodyEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ClausePropertiesEditionPart#getBodyToRemove()
	 */
	public List getBodyToRemove() {
		return bodyEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ClausePropertiesEditionPart#getBodyTable()
	 */
	public List getBodyTable() {
		return bodyEditUtil.getVirtualList();
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ClausePropertiesEditionPart#initBody(EObject current, EReference containingFeature,
	 *      EReference feature)
	 */
	public void initBody(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			bodyEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			bodyEditUtil = new EMFListEditUtil(current, feature);
		this.body.setInput(bodyEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ClausePropertiesEditionPart#updateBody(EObject newValue)
	 */
	public void updateBody(EObject newValue) {
		if(bodyEditUtil != null) {
			bodyEditUtil.reinit(newValue);
			body.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ClausePropertiesEditionPart#addFilterBody(ViewerFilter filter)
	 */
	public void addFilterToBody(ViewerFilter filter) {
		bodyFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ClausePropertiesEditionPart#addBusinessFilterBody(ViewerFilter filter)
	 */
	public void addBusinessFilterToBody(ViewerFilter filter) {
		bodyBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ClausePropertiesEditionPart#isContainedInBodyTable(EObject element)
	 */
	public boolean isContainedInBodyTable(EObject element) {
		return bodyEditUtil.contains(element);
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ClausePropertiesEditionPart#getPredecessorClauseToAdd()
	 */
	public List getPredecessorClauseToAdd() {
		return predecessorClauseEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ClausePropertiesEditionPart#getPredecessorClauseToRemove()
	 */
	public List getPredecessorClauseToRemove() {
		return predecessorClauseEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ClausePropertiesEditionPart#getPredecessorClauseTable()
	 */
	public List getPredecessorClauseTable() {
		return predecessorClauseEditUtil.getVirtualList();
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ClausePropertiesEditionPart#initPredecessorClause(EObject current, EReference
	 *      containingFeature, EReference feature)
	 */
	public void initPredecessorClause(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			predecessorClauseEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			predecessorClauseEditUtil = new EMFListEditUtil(current, feature);
		this.predecessorClause.setInput(predecessorClauseEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ClausePropertiesEditionPart#updatePredecessorClause(EObject newValue)
	 */
	public void updatePredecessorClause(EObject newValue) {
		if(predecessorClauseEditUtil != null) {
			predecessorClauseEditUtil.reinit(newValue);
			predecessorClause.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ClausePropertiesEditionPart#addFilterPredecessorClause(ViewerFilter filter)
	 */
	public void addFilterToPredecessorClause(ViewerFilter filter) {
		predecessorClauseFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ClausePropertiesEditionPart#addBusinessFilterPredecessorClause(ViewerFilter filter)
	 */
	public void addBusinessFilterToPredecessorClause(ViewerFilter filter) {
		predecessorClauseBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ClausePropertiesEditionPart#isContainedInPredecessorClauseTable(EObject element)
	 */
	public boolean isContainedInPredecessorClauseTable(EObject element) {
		return predecessorClauseEditUtil.contains(element);
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ClausePropertiesEditionPart#getSuccessorClauseToAdd()
	 */
	public List getSuccessorClauseToAdd() {
		return successorClauseEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ClausePropertiesEditionPart#getSuccessorClauseToRemove()
	 */
	public List getSuccessorClauseToRemove() {
		return successorClauseEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ClausePropertiesEditionPart#getSuccessorClauseTable()
	 */
	public List getSuccessorClauseTable() {
		return successorClauseEditUtil.getVirtualList();
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ClausePropertiesEditionPart#initSuccessorClause(EObject current, EReference
	 *      containingFeature, EReference feature)
	 */
	public void initSuccessorClause(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			successorClauseEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			successorClauseEditUtil = new EMFListEditUtil(current, feature);
		this.successorClause.setInput(successorClauseEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ClausePropertiesEditionPart#updateSuccessorClause(EObject newValue)
	 */
	public void updateSuccessorClause(EObject newValue) {
		if(successorClauseEditUtil != null) {
			successorClauseEditUtil.reinit(newValue);
			successorClause.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ClausePropertiesEditionPart#addFilterSuccessorClause(ViewerFilter filter)
	 */
	public void addFilterToSuccessorClause(ViewerFilter filter) {
		successorClauseFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ClausePropertiesEditionPart#addBusinessFilterSuccessorClause(ViewerFilter filter)
	 */
	public void addBusinessFilterToSuccessorClause(ViewerFilter filter) {
		successorClauseBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ClausePropertiesEditionPart#isContainedInSuccessorClauseTable(EObject element)
	 */
	public boolean isContainedInSuccessorClauseTable(EObject element) {
		return successorClauseEditUtil.contains(element);
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ClausePropertiesEditionPart#getBodyOutputToAdd()
	 */
	public List getBodyOutputToAdd() {
		return bodyOutputEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ClausePropertiesEditionPart#getBodyOutputToRemove()
	 */
	public List getBodyOutputToRemove() {
		return bodyOutputEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ClausePropertiesEditionPart#getBodyOutputTable()
	 */
	public List getBodyOutputTable() {
		return bodyOutputEditUtil.getVirtualList();
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ClausePropertiesEditionPart#initBodyOutput(EObject current, EReference containingFeature,
	 *      EReference feature)
	 */
	public void initBodyOutput(EObject current, EReference containingFeature, EReference feature) {
		if(current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if(containingFeature != null)
			bodyOutputEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			bodyOutputEditUtil = new EMFListEditUtil(current, feature);
		this.bodyOutput.setInput(bodyOutputEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ClausePropertiesEditionPart#updateBodyOutput(EObject newValue)
	 */
	public void updateBodyOutput(EObject newValue) {
		if(bodyOutputEditUtil != null) {
			bodyOutputEditUtil.reinit(newValue);
			bodyOutput.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ClausePropertiesEditionPart#addFilterBodyOutput(ViewerFilter filter)
	 */
	public void addFilterToBodyOutput(ViewerFilter filter) {
		bodyOutputFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ClausePropertiesEditionPart#addBusinessFilterBodyOutput(ViewerFilter filter)
	 */
	public void addBusinessFilterToBodyOutput(ViewerFilter filter) {
		bodyOutputBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ClausePropertiesEditionPart#isContainedInBodyOutputTable(EObject element)
	 */
	public boolean isContainedInBodyOutputTable(EObject element) {
		return bodyOutputEditUtil.contains(element);
	}





	// Start of user code additional methods

	// End of user code

}
