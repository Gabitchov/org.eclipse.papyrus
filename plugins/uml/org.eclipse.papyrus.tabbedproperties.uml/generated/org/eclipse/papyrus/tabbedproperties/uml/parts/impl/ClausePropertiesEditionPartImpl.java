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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.papyrus.tabbedproperties.uml.providers.UMLMessages;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.policies.IPropertiesEditionPolicy;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPolicyProvider;
import org.eclipse.emf.eef.runtime.impl.policies.EObjectPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionPolicyProviderService;

import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.papyrus.tabbedproperties.uml.parts.ClausePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.jface.viewers.StructuredSelection;
import java.util.Iterator;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.emf.eef.runtime.ui.widgets.EMFModelViewerDialog;
import org.eclipse.emf.eef.runtime.ui.widgets.TabElementTreeSelectionDialog;
import org.eclipse.uml2.uml.ExecutableNode;
import org.eclipse.uml2.uml.ExecutableNode;
import org.eclipse.uml2.uml.Clause;
import org.eclipse.uml2.uml.Clause;
import org.eclipse.uml2.uml.OutputPin;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;
import org.eclipse.emf.eef.runtime.impl.filters.EObjectFilter;
import java.util.Map;
import org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.Comment;

import org.eclipse.papyrus.tabbedproperties.uml.parts.UMLViewsRepository;

// End of user code
/**
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class ClausePropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, ClausePropertiesEditionPart {

	private EMFListEditUtil ownedCommentEditUtil;

	private ReferencesTable<?> ownedComment;

	private EMFListEditUtil testEditUtil;

	private ReferencesTable<?> test;

	private EMFListEditUtil bodyEditUtil;

	private ReferencesTable<?> body;

	private EMFListEditUtil predecessorClauseEditUtil;

	private ReferencesTable<?> predecessorClause;

	private EMFListEditUtil successorClauseEditUtil;

	private ReferencesTable<?> successorClause;

	private EMFListEditUtil bodyOutputEditUtil;

	private ReferencesTable<?> bodyOutput;

	public ClausePropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	public Composite createFigure(final Composite parent) {
		view = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		view.setLayout(layout);

		createControls(view);
		return view;
	}

	public void createControls(Composite view) {
		createPropertiesGroup(view);

		// Start of user code for additional ui definition

		// End of user code
	}

	protected void createPropertiesGroup(Composite parent) {
		Group propertiesGroup = new Group(parent, SWT.NONE);
		propertiesGroup.setText(UMLMessages.ClausePropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		createOwnedCommentTableComposition(propertiesGroup);
		createTestReferencesTable(propertiesGroup);
		createBodyReferencesTable(propertiesGroup);
		createPredecessorClauseReferencesTable(propertiesGroup);
		createSuccessorClauseReferencesTable(propertiesGroup);
		createBodyOutputReferencesTable(propertiesGroup);
	}

	/**
	 * @param container
	 */
	protected void createOwnedCommentTableComposition(Composite parent) {
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
		this.ownedComment.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.Clause.ownedComment, UMLViewsRepository.SWT_KIND));
		this.ownedComment.createControls(parent);
		GridData ownedCommentData = new GridData(GridData.FILL_HORIZONTAL);
		ownedCommentData.horizontalSpan = 3;
		this.ownedComment.setLayoutData(ownedCommentData);
	}

	/**
	 * 
	 */
	private void moveOwnedComment(Comment element, int oldIndex, int newIndex) {

		EObject editedElement = ownedCommentEditUtil.foundCorrespondingEObject(element);
		ownedCommentEditUtil.moveElement(element, oldIndex, newIndex);
		ownedComment.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ClausePropertiesEditionPartImpl.this, UMLViewsRepository.Clause.ownedComment, PropertiesEditionEvent.COMMIT,
				PropertiesEditionEvent.MOVE, editedElement, newIndex));

	}

	/**
	 * 
	 */
	private void addToOwnedComment() {

		// Start of user code addToOwnedComment() method body

		Comment eObject = UMLFactory.eINSTANCE.createComment();
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(eObject);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent, eObject, resourceSet));
			if (propertiesEditionObject != null) {
				ownedCommentEditUtil.addElement(propertiesEditionObject);
				ownedComment.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ClausePropertiesEditionPartImpl.this, UMLViewsRepository.Clause.ownedComment,
						PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.ADD, null, propertiesEditionObject));
			}
		}

		// End of user code
	}

	/**
	 * 
	 */
	private void removeFromOwnedComment(Comment element) {

		// Start of user code for the removeFromOwnedComment() method body

		EObject editedElement = ownedCommentEditUtil.foundCorrespondingEObject(element);
		ownedCommentEditUtil.removeElement(element);
		ownedComment.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ClausePropertiesEditionPartImpl.this, UMLViewsRepository.Clause.ownedComment, PropertiesEditionEvent.CHANGE,
				PropertiesEditionEvent.REMOVE, null, editedElement));

		// End of user code
	}

	/**
	 * 
	 */
	private void editOwnedComment(Comment element) {

		// Start of user code editOwnedComment() method body

		EObject editedElement = ownedCommentEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if (propertiesEditionObject != null) {
				ownedCommentEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				ownedComment.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ClausePropertiesEditionPartImpl.this, UMLViewsRepository.Clause.ownedComment,
						PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}

		// End of user code
	}

	protected void createTestReferencesTable(Composite parent) {
		this.test = new ReferencesTable<ExecutableNode>(UMLMessages.ClausePropertiesEditionPart_TestLabel, new ReferencesTableListener<ExecutableNode>() {

			public void handleAdd() {
				ViewerFilter testFilter = new EObjectFilter(UMLPackage.eINSTANCE.getExecutableNode());
				ViewerFilter viewerFilter = new ViewerFilter() {

					public boolean select(Viewer viewer, Object parentElement, Object element) {
						if (element instanceof EObject)
							return (!testEditUtil.contains((EObject) element));
						return false;
					}

				};
				List filters = new ArrayList();
				filters.add(testFilter);
				filters.add(viewerFilter);
				TabElementTreeSelectionDialog<ExecutableNode> dialog = new TabElementTreeSelectionDialog<ExecutableNode>(resourceSet, filters, "ExecutableNode", UMLPackage.eINSTANCE
						.getExecutableNode()) {

					public void process(IStructuredSelection selection) {
						for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject) iter.next();
							if (!testEditUtil.getVirtualList().contains(elem))
								testEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ClausePropertiesEditionPartImpl.this, UMLViewsRepository.Clause.test,
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
		this.test.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.Clause.test, UMLViewsRepository.SWT_KIND));
		this.test.createControls(parent);
		GridData testData = new GridData(GridData.FILL_HORIZONTAL);
		testData.horizontalSpan = 3;
		this.test.setLayoutData(testData);
		this.test.disableMove();
	}

	/**
	 * 
	 */
	private void moveTest(ExecutableNode element, int oldIndex, int newIndex) {
	}

	/**
	 * 
	 */
	private void removeFromTest(ExecutableNode element) {

		// Start of user code for the removeFromTest() method body

		EObject editedElement = testEditUtil.foundCorrespondingEObject(element);
		testEditUtil.removeElement(element);
		test.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ClausePropertiesEditionPartImpl.this, UMLViewsRepository.Clause.test, PropertiesEditionEvent.COMMIT,
				PropertiesEditionEvent.REMOVE, null, editedElement));

		// End of user code
	}

	/**
	 * 
	 */
	private void editTest(ExecutableNode element) {

		// Start of user code editTest() method body

		EObject editedElement = testEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if (propertiesEditionObject != null) {
				testEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				test.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ClausePropertiesEditionPartImpl.this, UMLViewsRepository.Clause.test, PropertiesEditionEvent.COMMIT,
						PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}

		// End of user code
	}

	protected void createBodyReferencesTable(Composite parent) {
		this.body = new ReferencesTable<ExecutableNode>(UMLMessages.ClausePropertiesEditionPart_BodyLabel, new ReferencesTableListener<ExecutableNode>() {

			public void handleAdd() {
				ViewerFilter bodyFilter = new EObjectFilter(UMLPackage.eINSTANCE.getExecutableNode());
				ViewerFilter viewerFilter = new ViewerFilter() {

					public boolean select(Viewer viewer, Object parentElement, Object element) {
						if (element instanceof EObject)
							return (!bodyEditUtil.contains((EObject) element));
						return false;
					}

				};
				List filters = new ArrayList();
				filters.add(bodyFilter);
				filters.add(viewerFilter);
				TabElementTreeSelectionDialog<ExecutableNode> dialog = new TabElementTreeSelectionDialog<ExecutableNode>(resourceSet, filters, "ExecutableNode", UMLPackage.eINSTANCE
						.getExecutableNode()) {

					public void process(IStructuredSelection selection) {
						for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject) iter.next();
							if (!bodyEditUtil.getVirtualList().contains(elem))
								bodyEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ClausePropertiesEditionPartImpl.this, UMLViewsRepository.Clause.body,
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
		this.body.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.Clause.body, UMLViewsRepository.SWT_KIND));
		this.body.createControls(parent);
		GridData bodyData = new GridData(GridData.FILL_HORIZONTAL);
		bodyData.horizontalSpan = 3;
		this.body.setLayoutData(bodyData);
		this.body.disableMove();
	}

	/**
	 * 
	 */
	private void moveBody(ExecutableNode element, int oldIndex, int newIndex) {
	}

	/**
	 * 
	 */
	private void removeFromBody(ExecutableNode element) {

		// Start of user code for the removeFromBody() method body

		EObject editedElement = bodyEditUtil.foundCorrespondingEObject(element);
		bodyEditUtil.removeElement(element);
		body.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ClausePropertiesEditionPartImpl.this, UMLViewsRepository.Clause.body, PropertiesEditionEvent.COMMIT,
				PropertiesEditionEvent.REMOVE, null, editedElement));

		// End of user code
	}

	/**
	 * 
	 */
	private void editBody(ExecutableNode element) {

		// Start of user code editBody() method body

		EObject editedElement = bodyEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if (propertiesEditionObject != null) {
				bodyEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				body.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ClausePropertiesEditionPartImpl.this, UMLViewsRepository.Clause.body, PropertiesEditionEvent.COMMIT,
						PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}

		// End of user code
	}

	protected void createPredecessorClauseReferencesTable(Composite parent) {
		this.predecessorClause = new ReferencesTable<Clause>(UMLMessages.ClausePropertiesEditionPart_PredecessorClauseLabel, new ReferencesTableListener<Clause>() {

			public void handleAdd() {
				ViewerFilter predecessorClauseFilter = new EObjectFilter(UMLPackage.eINSTANCE.getClause());
				ViewerFilter viewerFilter = new ViewerFilter() {

					public boolean select(Viewer viewer, Object parentElement, Object element) {
						if (element instanceof EObject)
							return (!predecessorClauseEditUtil.contains((EObject) element));
						return false;
					}

				};
				List filters = new ArrayList();
				filters.add(predecessorClauseFilter);
				filters.add(viewerFilter);
				TabElementTreeSelectionDialog<Clause> dialog = new TabElementTreeSelectionDialog<Clause>(resourceSet, filters, "Clause", UMLPackage.eINSTANCE.getClause()) {

					public void process(IStructuredSelection selection) {
						for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject) iter.next();
							if (!predecessorClauseEditUtil.getVirtualList().contains(elem))
								predecessorClauseEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ClausePropertiesEditionPartImpl.this, UMLViewsRepository.Clause.predecessorClause,
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
		this.predecessorClause.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.Clause.predecessorClause, UMLViewsRepository.SWT_KIND));
		this.predecessorClause.createControls(parent);
		GridData predecessorClauseData = new GridData(GridData.FILL_HORIZONTAL);
		predecessorClauseData.horizontalSpan = 3;
		this.predecessorClause.setLayoutData(predecessorClauseData);
		this.predecessorClause.disableMove();
	}

	/**
	 * 
	 */
	private void movePredecessorClause(Clause element, int oldIndex, int newIndex) {
		EObject editedElement = predecessorClauseEditUtil.foundCorrespondingEObject(element);
		predecessorClauseEditUtil.moveElement(element, oldIndex, newIndex);
		predecessorClause.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ClausePropertiesEditionPartImpl.this, UMLViewsRepository.Clause.predecessorClause, PropertiesEditionEvent.COMMIT,
				PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	private void removeFromPredecessorClause(Clause element) {

		// Start of user code for the removeFromPredecessorClause() method body

		EObject editedElement = predecessorClauseEditUtil.foundCorrespondingEObject(element);
		predecessorClauseEditUtil.removeElement(element);
		predecessorClause.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ClausePropertiesEditionPartImpl.this, UMLViewsRepository.Clause.predecessorClause, PropertiesEditionEvent.COMMIT,
				PropertiesEditionEvent.REMOVE, null, editedElement));

		// End of user code
	}

	/**
	 * 
	 */
	private void editPredecessorClause(Clause element) {

		// Start of user code editPredecessorClause() method body

		EObject editedElement = predecessorClauseEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if (propertiesEditionObject != null) {
				predecessorClauseEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				predecessorClause.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ClausePropertiesEditionPartImpl.this, UMLViewsRepository.Clause.predecessorClause,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}

		// End of user code
	}

	protected void createSuccessorClauseReferencesTable(Composite parent) {
		this.successorClause = new ReferencesTable<Clause>(UMLMessages.ClausePropertiesEditionPart_SuccessorClauseLabel, new ReferencesTableListener<Clause>() {

			public void handleAdd() {
				ViewerFilter successorClauseFilter = new EObjectFilter(UMLPackage.eINSTANCE.getClause());
				ViewerFilter viewerFilter = new ViewerFilter() {

					public boolean select(Viewer viewer, Object parentElement, Object element) {
						if (element instanceof EObject)
							return (!successorClauseEditUtil.contains((EObject) element));
						return false;
					}

				};
				List filters = new ArrayList();
				filters.add(successorClauseFilter);
				filters.add(viewerFilter);
				TabElementTreeSelectionDialog<Clause> dialog = new TabElementTreeSelectionDialog<Clause>(resourceSet, filters, "Clause", UMLPackage.eINSTANCE.getClause()) {

					public void process(IStructuredSelection selection) {
						for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject) iter.next();
							if (!successorClauseEditUtil.getVirtualList().contains(elem))
								successorClauseEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ClausePropertiesEditionPartImpl.this, UMLViewsRepository.Clause.successorClause,
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
		this.successorClause.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.Clause.successorClause, UMLViewsRepository.SWT_KIND));
		this.successorClause.createControls(parent);
		GridData successorClauseData = new GridData(GridData.FILL_HORIZONTAL);
		successorClauseData.horizontalSpan = 3;
		this.successorClause.setLayoutData(successorClauseData);
		this.successorClause.disableMove();
	}

	/**
	 * 
	 */
	private void moveSuccessorClause(Clause element, int oldIndex, int newIndex) {
		EObject editedElement = successorClauseEditUtil.foundCorrespondingEObject(element);
		successorClauseEditUtil.moveElement(element, oldIndex, newIndex);
		successorClause.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ClausePropertiesEditionPartImpl.this, UMLViewsRepository.Clause.successorClause, PropertiesEditionEvent.COMMIT,
				PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	private void removeFromSuccessorClause(Clause element) {

		// Start of user code for the removeFromSuccessorClause() method body

		EObject editedElement = successorClauseEditUtil.foundCorrespondingEObject(element);
		successorClauseEditUtil.removeElement(element);
		successorClause.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ClausePropertiesEditionPartImpl.this, UMLViewsRepository.Clause.successorClause, PropertiesEditionEvent.COMMIT,
				PropertiesEditionEvent.REMOVE, null, editedElement));

		// End of user code
	}

	/**
	 * 
	 */
	private void editSuccessorClause(Clause element) {

		// Start of user code editSuccessorClause() method body

		EObject editedElement = successorClauseEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if (propertiesEditionObject != null) {
				successorClauseEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				successorClause.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ClausePropertiesEditionPartImpl.this, UMLViewsRepository.Clause.successorClause,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}

		// End of user code
	}

	protected void createBodyOutputReferencesTable(Composite parent) {
		this.bodyOutput = new ReferencesTable<OutputPin>(UMLMessages.ClausePropertiesEditionPart_BodyOutputLabel, new ReferencesTableListener<OutputPin>() {

			public void handleAdd() {
				ViewerFilter bodyOutputFilter = new EObjectFilter(UMLPackage.eINSTANCE.getOutputPin());
				ViewerFilter viewerFilter = new ViewerFilter() {

					public boolean select(Viewer viewer, Object parentElement, Object element) {
						if (element instanceof EObject)
							return (!bodyOutputEditUtil.contains((EObject) element));
						return false;
					}

				};
				List filters = new ArrayList();
				filters.add(bodyOutputFilter);
				filters.add(viewerFilter);
				TabElementTreeSelectionDialog<OutputPin> dialog = new TabElementTreeSelectionDialog<OutputPin>(resourceSet, filters, "OutputPin", UMLPackage.eINSTANCE.getOutputPin()) {

					public void process(IStructuredSelection selection) {
						for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject) iter.next();
							if (!bodyOutputEditUtil.getVirtualList().contains(elem))
								bodyOutputEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ClausePropertiesEditionPartImpl.this, UMLViewsRepository.Clause.bodyOutput,
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
		this.bodyOutput.setHelpText(propertiesEditionComponent.getHelpContent(UMLViewsRepository.Clause.bodyOutput, UMLViewsRepository.SWT_KIND));
		this.bodyOutput.createControls(parent);
		GridData bodyOutputData = new GridData(GridData.FILL_HORIZONTAL);
		bodyOutputData.horizontalSpan = 3;
		this.bodyOutput.setLayoutData(bodyOutputData);
		this.bodyOutput.disableMove();
	}

	/**
	 * 
	 */
	private void moveBodyOutput(OutputPin element, int oldIndex, int newIndex) {
		EObject editedElement = bodyOutputEditUtil.foundCorrespondingEObject(element);
		bodyOutputEditUtil.moveElement(element, oldIndex, newIndex);
		bodyOutput.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ClausePropertiesEditionPartImpl.this, UMLViewsRepository.Clause.bodyOutput, PropertiesEditionEvent.COMMIT,
				PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	private void removeFromBodyOutput(OutputPin element) {

		// Start of user code for the removeFromBodyOutput() method body

		EObject editedElement = bodyOutputEditUtil.foundCorrespondingEObject(element);
		bodyOutputEditUtil.removeElement(element);
		bodyOutput.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ClausePropertiesEditionPartImpl.this, UMLViewsRepository.Clause.bodyOutput, PropertiesEditionEvent.COMMIT,
				PropertiesEditionEvent.REMOVE, null, editedElement));

		// End of user code
	}

	/**
	 * 
	 */
	private void editBodyOutput(OutputPin element) {

		// Start of user code editBodyOutput() method body

		EObject editedElement = bodyOutputEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element, resourceSet));
			if (propertiesEditionObject != null) {
				bodyOutputEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				bodyOutput.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ClausePropertiesEditionPartImpl.this, UMLViewsRepository.Clause.bodyOutput, PropertiesEditionEvent.COMMIT,
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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ClausePropertiesEditionPart#initOwnedComment(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initOwnedComment(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
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
		if (ownedCommentEditUtil != null) {
			ownedCommentEditUtil.reinit(newValue);
			ownedComment.refresh();
		}
	}

	public void setMessageForOwnedComment(String msg, int msgLevel) {

	}

	public void unsetMessageForOwnedComment() {

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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ClausePropertiesEditionPart#initTest(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initTest(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
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
		if (testEditUtil != null) {
			testEditUtil.reinit(newValue);
			test.refresh();
		}
	}

	public void setMessageForTest(String msg, int msgLevel) {

	}

	public void unsetMessageForTest() {

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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ClausePropertiesEditionPart#initBody(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initBody(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
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
		if (bodyEditUtil != null) {
			bodyEditUtil.reinit(newValue);
			body.refresh();
		}
	}

	public void setMessageForBody(String msg, int msgLevel) {

	}

	public void unsetMessageForBody() {

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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ClausePropertiesEditionPart#initPredecessorClause(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initPredecessorClause(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
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
		if (predecessorClauseEditUtil != null) {
			predecessorClauseEditUtil.reinit(newValue);
			predecessorClause.refresh();
		}
	}

	public void setMessageForPredecessorClause(String msg, int msgLevel) {

	}

	public void unsetMessageForPredecessorClause() {

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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ClausePropertiesEditionPart#initSuccessorClause(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initSuccessorClause(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
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
		if (successorClauseEditUtil != null) {
			successorClauseEditUtil.reinit(newValue);
			successorClause.refresh();
		}
	}

	public void setMessageForSuccessorClause(String msg, int msgLevel) {

	}

	public void unsetMessageForSuccessorClause() {

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
	 * @see org.eclipse.papyrus.tabbedproperties.uml.parts.ClausePropertiesEditionPart#initBodyOutput(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initBodyOutput(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
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
		if (bodyOutputEditUtil != null) {
			bodyOutputEditUtil.reinit(newValue);
			bodyOutput.refresh();
		}
	}

	public void setMessageForBodyOutput(String msg, int msgLevel) {

	}

	public void unsetMessageForBodyOutput() {

	}

	// Start of user code additional methods

	// End of user code
}
