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
package org.eclipse.papyrus.tabbedproperties.uml.components;

// Start of user code for imports

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.command.IdentityCommand;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.command.MoveCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.eef.runtime.EMFPropertiesRuntime;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPartProvider;
import org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.impl.filters.EObjectFilter;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesContextService;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionPartProviderService;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.papyrus.tabbedproperties.uml.parts.ClausePropertiesEditionPart;
import org.eclipse.papyrus.tabbedproperties.uml.parts.UMLViewsRepository;
import org.eclipse.uml2.uml.Clause;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.UMLPackage;

// End of user code

/**
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class ClauseBasePropertiesEditionComponent extends StandardPropertiesEditionComponent {

	public static String BASE_PART = "Base"; //$NON-NLS-1$

	private String[] parts = { BASE_PART };

	/**
	 * The EObject to edit
	 */
	private Clause clause;

	/**
	 * The Base part
	 */
	private ClausePropertiesEditionPart basePart;

	/**
	 * Default constructor
	 */
	public ClauseBasePropertiesEditionComponent(EObject clause, String editing_mode) {
		if(clause instanceof Clause) {
			this.clause = (Clause)clause;
			if(IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
				semanticAdapter = initializeSemanticAdapter();
				this.clause.eAdapters().add(semanticAdapter);
			}
		}
		this.editing_mode = editing_mode;
	}

	/**
	 * Initialize the semantic model listener for live editing mode
	 * 
	 * @return the semantic model listener
	 */
	private AdapterImpl initializeSemanticAdapter() {
		return new EContentAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.emf.common.notify.impl.AdapterImpl#notifyChanged(org.eclipse.emf.common.notify.Notification)
			 */
			public void notifyChanged(Notification msg) {
				if(basePart == null)
					ClauseBasePropertiesEditionComponent.this.dispose();
				else {
					if(msg.getFeature() != null &&
							(((EStructuralFeature)msg.getFeature()) == UMLPackage.eINSTANCE.getElement_OwnedComment()
							|| ((EStructuralFeature)msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE.getElement_OwnedComment())) {
						basePart.updateOwnedComment(clause);
					}
					if(UMLPackage.eINSTANCE.getClause_Test().equals(msg.getFeature()))
						basePart.updateTest(clause);
					if(UMLPackage.eINSTANCE.getClause_Body().equals(msg.getFeature()))
						basePart.updateBody(clause);
					if(UMLPackage.eINSTANCE.getClause_PredecessorClause().equals(msg.getFeature()))
						basePart.updatePredecessorClause(clause);
					if(UMLPackage.eINSTANCE.getClause_SuccessorClause().equals(msg.getFeature()))
						basePart.updateSuccessorClause(clause);
					if(UMLPackage.eINSTANCE.getClause_BodyOutput().equals(msg.getFeature()))
						basePart.updateBodyOutput(clause);


				}
			}

		};
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#translatePart(java.lang.String)
	 */
	public java.lang.Class translatePart(String key) {
		if(BASE_PART.equals(key))
			return UMLViewsRepository.Clause.class;
		return super.translatePart(key);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#partsList()
	 */
	public String[] partsList() {
		return parts;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getPropertiesEditionPart (java.lang.String, java.lang.String)
	 */
	public IPropertiesEditionPart getPropertiesEditionPart(int kind, String key) {
		if(clause != null && BASE_PART.equals(key)) {
			if(basePart == null) {
				IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(UMLViewsRepository.class);
				if(provider != null) {
					basePart = (ClausePropertiesEditionPart)provider.getPropertiesEditionPart(UMLViewsRepository.Clause.class, kind, this);
					addListener((IPropertiesEditionListener)basePart);
				}
			}
			return (IPropertiesEditionPart)basePart;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent# setPropertiesEditionPart(java.lang.Class, int,
	 *      org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart)
	 */
	public void setPropertiesEditionPart(java.lang.Class key, int kind, IPropertiesEditionPart propertiesEditionPart) {
		if(key == UMLViewsRepository.Clause.class)
			this.basePart = (ClausePropertiesEditionPart)propertiesEditionPart;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#initPart(java.lang.Class, int, org.eclipse.emf.ecore.EObject,
	 *      org.eclipse.emf.ecore.resource.ResourceSet)
	 */
	public void initPart(java.lang.Class key, int kind, EObject elt, ResourceSet allResource) {
		if(basePart != null && key == UMLViewsRepository.Clause.class) {
			((IPropertiesEditionPart)basePart).setContext(elt, allResource);
			final Clause clause = (Clause)elt;
			// init values
			basePart.initOwnedComment(clause, null, UMLPackage.eINSTANCE.getElement_OwnedComment());
			basePart.initTest(clause, null, UMLPackage.eINSTANCE.getClause_Test());
			basePart.initBody(clause, null, UMLPackage.eINSTANCE.getClause_Body());
			basePart.initPredecessorClause(clause, null, UMLPackage.eINSTANCE.getClause_PredecessorClause());
			basePart.initSuccessorClause(clause, null, UMLPackage.eINSTANCE.getClause_SuccessorClause());
			basePart.initBodyOutput(clause, null, UMLPackage.eINSTANCE.getClause_BodyOutput());

			// init filters
			basePart.addFilterToOwnedComment(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					return (element instanceof String && element.equals("")) || (element instanceof Comment); //$NON-NLS-1$ 

				}

			});
			// Start of user code for additional businessfilters for ownedComment

			// End of user code
			basePart.addFilterToTest(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					if(element instanceof EObject)
						return (!basePart.isContainedInTestTable((EObject)element));
					return element instanceof Resource;
				}

			});
			basePart.addFilterToTest(new EObjectFilter(UMLPackage.eINSTANCE.getExecutableNode()));
			// Start of user code for additional businessfilters for test

			// End of user code
			basePart.addFilterToBody(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					if(element instanceof EObject)
						return (!basePart.isContainedInBodyTable((EObject)element));
					return element instanceof Resource;
				}

			});
			basePart.addFilterToBody(new EObjectFilter(UMLPackage.eINSTANCE.getExecutableNode()));
			// Start of user code for additional businessfilters for body

			// End of user code
			basePart.addFilterToPredecessorClause(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					if(element instanceof EObject)
						return (!basePart.isContainedInPredecessorClauseTable((EObject)element));
					return element instanceof Resource;
				}

			});
			basePart.addFilterToPredecessorClause(new EObjectFilter(UMLPackage.eINSTANCE.getClause()));
			// Start of user code for additional businessfilters for predecessorClause

			// End of user code
			basePart.addFilterToSuccessorClause(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					if(element instanceof EObject)
						return (!basePart.isContainedInSuccessorClauseTable((EObject)element));
					return element instanceof Resource;
				}

			});
			basePart.addFilterToSuccessorClause(new EObjectFilter(UMLPackage.eINSTANCE.getClause()));
			// Start of user code for additional businessfilters for successorClause

			// End of user code
			basePart.addFilterToBodyOutput(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					if(element instanceof EObject)
						return (!basePart.isContainedInBodyOutputTable((EObject)element));
					return element instanceof Resource;
				}

			});
			basePart.addFilterToBodyOutput(new EObjectFilter(UMLPackage.eINSTANCE.getOutputPin()));
			// Start of user code for additional businessfilters for bodyOutput

			// End of user code
		}
		// init values for referenced views

		// init filters for referenced views

	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getPropertiesEditionCommand
	 *      (org.eclipse.emf.edit.domain.EditingDomain)
	 */
	public CompoundCommand getPropertiesEditionCommand(EditingDomain editingDomain) {
		CompoundCommand cc = new CompoundCommand();
		if(clause != null) {
			List ownedCommentToAddFromOwnedComment = basePart.getOwnedCommentToAdd();
			for(Iterator iter = ownedCommentToAddFromOwnedComment.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, clause, UMLPackage.eINSTANCE.getElement_OwnedComment(), iter.next()));
			Map ownedCommentToRefreshFromOwnedComment = basePart.getOwnedCommentToEdit();
			for(Iterator iter = ownedCommentToRefreshFromOwnedComment.keySet().iterator(); iter.hasNext();) {



				Comment nextElement = (Comment)iter.next();
				Comment ownedComment = (Comment)ownedCommentToRefreshFromOwnedComment.get(nextElement);

				for(EStructuralFeature feature : nextElement.eClass().getEAllStructuralFeatures()) {
					if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
						cc.append(SetCommand.create(editingDomain, nextElement, feature, ownedComment.eGet(feature)));
					}
				}



			}
			List ownedCommentToRemoveFromOwnedComment = basePart.getOwnedCommentToRemove();
			for(Iterator iter = ownedCommentToRemoveFromOwnedComment.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List ownedCommentToMoveFromOwnedComment = basePart.getOwnedCommentToMove();
			for(Iterator iter = ownedCommentToMoveFromOwnedComment.iterator(); iter.hasNext();) {
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
				cc.append(MoveCommand.create(editingDomain, clause, UMLPackage.eINSTANCE.getComment(), moveElement.getElement(), moveElement.getIndex()));
			}
			List testToAddFromTest = basePart.getTestToAdd();
			for(Iterator iter = testToAddFromTest.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, clause, UMLPackage.eINSTANCE.getClause_Test(), iter.next()));
			List testToRemoveFromTest = basePart.getTestToRemove();
			for(Iterator iter = testToRemoveFromTest.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, clause, UMLPackage.eINSTANCE.getClause_Test(), iter.next()));
			//List testToMoveFromTest = basePart.getTestToMove();
			//for (Iterator iter = testToMoveFromTest.iterator(); iter.hasNext();){
			//	org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, clause, UMLPackage.eINSTANCE.getExecutableNode(), moveElement.getElement(), moveElement.getIndex()));
			//}
			List bodyToAddFromBody = basePart.getBodyToAdd();
			for(Iterator iter = bodyToAddFromBody.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, clause, UMLPackage.eINSTANCE.getClause_Body(), iter.next()));
			List bodyToRemoveFromBody = basePart.getBodyToRemove();
			for(Iterator iter = bodyToRemoveFromBody.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, clause, UMLPackage.eINSTANCE.getClause_Body(), iter.next()));
			//List bodyToMoveFromBody = basePart.getBodyToMove();
			//for (Iterator iter = bodyToMoveFromBody.iterator(); iter.hasNext();){
			//	org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, clause, UMLPackage.eINSTANCE.getExecutableNode(), moveElement.getElement(), moveElement.getIndex()));
			//}
			List predecessorClauseToAddFromPredecessorClause = basePart.getPredecessorClauseToAdd();
			for(Iterator iter = predecessorClauseToAddFromPredecessorClause.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, clause, UMLPackage.eINSTANCE.getClause_PredecessorClause(), iter.next()));
			List predecessorClauseToRemoveFromPredecessorClause = basePart.getPredecessorClauseToRemove();
			for(Iterator iter = predecessorClauseToRemoveFromPredecessorClause.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, clause, UMLPackage.eINSTANCE.getClause_PredecessorClause(), iter.next()));
			//List predecessorClauseToMoveFromPredecessorClause = basePart.getPredecessorClauseToMove();
			//for (Iterator iter = predecessorClauseToMoveFromPredecessorClause.iterator(); iter.hasNext();){
			//	org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, clause, UMLPackage.eINSTANCE.getClause(), moveElement.getElement(), moveElement.getIndex()));
			//}
			List successorClauseToAddFromSuccessorClause = basePart.getSuccessorClauseToAdd();
			for(Iterator iter = successorClauseToAddFromSuccessorClause.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, clause, UMLPackage.eINSTANCE.getClause_SuccessorClause(), iter.next()));
			List successorClauseToRemoveFromSuccessorClause = basePart.getSuccessorClauseToRemove();
			for(Iterator iter = successorClauseToRemoveFromSuccessorClause.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, clause, UMLPackage.eINSTANCE.getClause_SuccessorClause(), iter.next()));
			//List successorClauseToMoveFromSuccessorClause = basePart.getSuccessorClauseToMove();
			//for (Iterator iter = successorClauseToMoveFromSuccessorClause.iterator(); iter.hasNext();){
			//	org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, clause, UMLPackage.eINSTANCE.getClause(), moveElement.getElement(), moveElement.getIndex()));
			//}
			List bodyOutputToAddFromBodyOutput = basePart.getBodyOutputToAdd();
			for(Iterator iter = bodyOutputToAddFromBodyOutput.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, clause, UMLPackage.eINSTANCE.getClause_BodyOutput(), iter.next()));
			List bodyOutputToRemoveFromBodyOutput = basePart.getBodyOutputToRemove();
			for(Iterator iter = bodyOutputToRemoveFromBodyOutput.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, clause, UMLPackage.eINSTANCE.getClause_BodyOutput(), iter.next()));
			//List bodyOutputToMoveFromBodyOutput = basePart.getBodyOutputToMove();
			//for (Iterator iter = bodyOutputToMoveFromBodyOutput.iterator(); iter.hasNext();){
			//	org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, clause, UMLPackage.eINSTANCE.getOutputPin(), moveElement.getElement(), moveElement.getIndex()));
			//}


		}
		if(!cc.isEmpty())
			return cc;
		cc.append(IdentityCommand.INSTANCE);
		return cc;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getPropertiesEditionObject()
	 */
	public EObject getPropertiesEditionObject(EObject source) {
		if(source instanceof Clause) {
			Clause clauseToUpdate = (Clause)source;
			clauseToUpdate.getOwnedComments().addAll(basePart.getOwnedCommentToAdd());
			clauseToUpdate.getTests().addAll(basePart.getTestToAdd());
			clauseToUpdate.getBodies().addAll(basePart.getBodyToAdd());
			clauseToUpdate.getPredecessorClauses().addAll(basePart.getPredecessorClauseToAdd());
			clauseToUpdate.getSuccessorClauses().addAll(basePart.getSuccessorClauseToAdd());
			clauseToUpdate.getBodyOutputs().addAll(basePart.getBodyOutputToAdd());


			return clauseToUpdate;
		} else
			return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener#firePropertiesChanged(org.eclipse.emf.common.notify.Notification)
	 */
	public void firePropertiesChanged(PropertiesEditionEvent event) {
		super.firePropertiesChanged(event);
		if(PropertiesEditionEvent.COMMIT == event.getState() && IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
			CompoundCommand command = new CompoundCommand();
			if(UMLViewsRepository.Clause.ownedComment == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.SET == event.getKind()) {
					Comment oldValue = (Comment)event.getOldValue();
					Comment newValue = (Comment)event.getNewValue();


					// TODO: Complete the clause update command
					for(EStructuralFeature feature : newValue.eClass().getEAllStructuralFeatures()) {
						if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
							command.append(SetCommand.create(liveEditingDomain, oldValue, feature, newValue.eGet(feature)));
						}
					}


				} else if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, clause, UMLPackage.eINSTANCE.getElement_OwnedComment(), event.getNewValue()));
				else if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, clause, UMLPackage.eINSTANCE.getComment(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.Clause.test == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, clause, UMLPackage.eINSTANCE.getClause_Test(), event.getNewValue()));
				if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, clause, UMLPackage.eINSTANCE.getClause_Test(), event.getNewValue()));
				if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, clause, UMLPackage.eINSTANCE.getClause_Test(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.Clause.body == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, clause, UMLPackage.eINSTANCE.getClause_Body(), event.getNewValue()));
				if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, clause, UMLPackage.eINSTANCE.getClause_Body(), event.getNewValue()));
				if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, clause, UMLPackage.eINSTANCE.getClause_Body(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.Clause.predecessorClause == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, clause, UMLPackage.eINSTANCE.getClause_PredecessorClause(), event.getNewValue()));
				if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, clause, UMLPackage.eINSTANCE.getClause_PredecessorClause(), event.getNewValue()));
				if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, clause, UMLPackage.eINSTANCE.getClause_PredecessorClause(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.Clause.successorClause == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, clause, UMLPackage.eINSTANCE.getClause_SuccessorClause(), event.getNewValue()));
				if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, clause, UMLPackage.eINSTANCE.getClause_SuccessorClause(), event.getNewValue()));
				if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, clause, UMLPackage.eINSTANCE.getClause_SuccessorClause(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.Clause.bodyOutput == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, clause, UMLPackage.eINSTANCE.getClause_BodyOutput(), event.getNewValue()));
				if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, clause, UMLPackage.eINSTANCE.getClause_BodyOutput(), event.getNewValue()));
				if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, clause, UMLPackage.eINSTANCE.getClause_BodyOutput(), event.getNewValue(), event.getNewIndex()));
			}


			if(!command.isEmpty() && !command.canExecute()) {
				EMFPropertiesRuntime.getDefault().logError("Cannot perform model change command.", null);
			} else {
				liveEditingDomain.getCommandStack().execute(command);
			}
		} else if(PropertiesEditionEvent.CHANGE == event.getState()) {
			Diagnostic diag = this.validateValue(event);
			if(diag != null && diag.getSeverity() != Diagnostic.OK) {





			} else {





			}
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#validateValue(org.eclipse.emf.common.notify.Notification)
	 */
	public Diagnostic validateValue(PropertiesEditionEvent event) {
		Diagnostic ret = null;
		if(event.getNewValue() != null) {
			String newStringValue = event.getNewValue().toString();
			try {

			} catch (IllegalArgumentException iae) {
				ret = BasicDiagnostic.toDiagnostic(iae);
			}
		}
		return ret;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#validate()
	 */
	public Diagnostic validate() {
		Diagnostic validate = null;
		if(IPropertiesEditionComponent.BATCH_MODE.equals(editing_mode)) {
			EObject copy = EcoreUtil.copy(PropertiesContextService.getInstance().entryPointElement());
			copy = PropertiesContextService.getInstance().entryPointComponent().getPropertiesEditionObject(copy);
			validate = Diagnostician.INSTANCE.validate(copy);
		} else if(IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode))
			validate = Diagnostician.INSTANCE.validate(clause);
		// Start of user code for custom validation check

		// End of user code

		return validate;
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#dispose()
	 */
	public void dispose() {
		if(semanticAdapter != null)
			clause.eAdapters().remove(semanticAdapter);
	}

}
