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
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EEnum;
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
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.papyrus.tabbedproperties.uml.parts.LoopNodePropertiesEditionPart;
import org.eclipse.papyrus.tabbedproperties.uml.parts.UMLViewsRepository;
import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.ExceptionHandler;
import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.LoopNode;
import org.eclipse.uml2.uml.OutputPin;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.Variable;
import org.eclipse.uml2.uml.VisibilityKind;

// End of user code

/**
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class LoopNodeBasePropertiesEditionComponent extends StandardPropertiesEditionComponent {

	public static String BASE_PART = "Base"; //$NON-NLS-1$

	private String[] parts = { BASE_PART };

	/**
	 * The EObject to edit
	 */
	private LoopNode loopNode;

	/**
	 * The Base part
	 */
	private LoopNodePropertiesEditionPart basePart;

	/**
	 * Default constructor
	 */
	public LoopNodeBasePropertiesEditionComponent(EObject loopNode, String editing_mode) {
		if(loopNode instanceof LoopNode) {
			this.loopNode = (LoopNode)loopNode;
			if(IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
				semanticAdapter = initializeSemanticAdapter();
				this.loopNode.eAdapters().add(semanticAdapter);
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
					LoopNodeBasePropertiesEditionComponent.this.dispose();
				else {
					if(msg.getFeature() != null &&
							(((EStructuralFeature)msg.getFeature()) == UMLPackage.eINSTANCE.getElement_OwnedComment()
							|| ((EStructuralFeature)msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE.getElement_OwnedComment())) {
						basePart.updateOwnedComment(loopNode);
					}
					if(UMLPackage.eINSTANCE.getNamedElement_Name().equals(msg.getFeature()) && basePart != null) {
						if(msg.getNewValue() != null) {
							basePart.setName((String)msg.getNewValue());
						} else {
							basePart.setName("");
						}
					}
					if(UMLPackage.eINSTANCE.getNamedElement_Visibility().equals(msg.getFeature()) && basePart != null)
						basePart.setVisibility((Enumerator)msg.getNewValue());

					if(UMLPackage.eINSTANCE.getNamedElement_ClientDependency().equals(msg.getFeature()))
						basePart.updateClientDependency(loopNode);
					if(UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf().equals(msg.getFeature()) && basePart != null)
						basePart.setIsLeaf((Boolean)msg.getNewValue());

					if(UMLPackage.eINSTANCE.getActivityNode_Outgoing().equals(msg.getFeature()))
						basePart.updateOutgoing(loopNode);
					if(UMLPackage.eINSTANCE.getActivityNode_Incoming().equals(msg.getFeature()))
						basePart.updateIncoming(loopNode);
					if(UMLPackage.eINSTANCE.getActivityNode_InPartition().equals(msg.getFeature()))
						basePart.updateInPartition(loopNode);
					if(UMLPackage.eINSTANCE.getActivityNode_InInterruptibleRegion().equals(msg.getFeature()))
						basePart.updateInInterruptibleRegion(loopNode);
					if(UMLPackage.eINSTANCE.getActivityNode_RedefinedNode().equals(msg.getFeature()))
						basePart.updateRedefinedNode(loopNode);
					if(msg.getFeature() != null &&
							(((EStructuralFeature)msg.getFeature()) == UMLPackage.eINSTANCE.getExecutableNode_Handler()
							|| ((EStructuralFeature)msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE.getExecutableNode_Handler())) {
						basePart.updateHandler(loopNode);
					}
					if(msg.getFeature() != null &&
							(((EStructuralFeature)msg.getFeature()) == UMLPackage.eINSTANCE.getAction_LocalPrecondition()
							|| ((EStructuralFeature)msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE.getAction_LocalPrecondition())) {
						basePart.updateLocalPrecondition(loopNode);
					}
					if(msg.getFeature() != null &&
							(((EStructuralFeature)msg.getFeature()) == UMLPackage.eINSTANCE.getAction_LocalPostcondition()
							|| ((EStructuralFeature)msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE.getAction_LocalPostcondition())) {
						basePart.updateLocalPostcondition(loopNode);
					}
					if(msg.getFeature() != null &&
							(((EStructuralFeature)msg.getFeature()) == UMLPackage.eINSTANCE.getNamespace_ElementImport()
							|| ((EStructuralFeature)msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE.getNamespace_ElementImport())) {
						basePart.updateElementImport(loopNode);
					}
					if(msg.getFeature() != null &&
							(((EStructuralFeature)msg.getFeature()) == UMLPackage.eINSTANCE.getNamespace_PackageImport()
							|| ((EStructuralFeature)msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE.getNamespace_PackageImport())) {
						basePart.updatePackageImport(loopNode);
					}
					if(msg.getFeature() != null &&
							(((EStructuralFeature)msg.getFeature()) == UMLPackage.eINSTANCE.getNamespace_OwnedRule()
							|| ((EStructuralFeature)msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE.getNamespace_OwnedRule())) {
						basePart.updateOwnedRule(loopNode);
					}
					if(msg.getFeature() != null &&
							(((EStructuralFeature)msg.getFeature()) == UMLPackage.eINSTANCE.getStructuredActivityNode_Variable()
							|| ((EStructuralFeature)msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE.getStructuredActivityNode_Variable())) {
						basePart.updateVariable(loopNode);
					}
					if(msg.getFeature() != null &&
							(((EStructuralFeature)msg.getFeature()) == UMLPackage.eINSTANCE.getStructuredActivityNode_Edge()
							|| ((EStructuralFeature)msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE.getStructuredActivityNode_Edge())) {
						basePart.updateEdge(loopNode);
					}
					if(UMLPackage.eINSTANCE.getStructuredActivityNode_MustIsolate().equals(msg.getFeature()) && basePart != null)
						basePart.setMustIsolate((Boolean)msg.getNewValue());

					if(msg.getFeature() != null &&
							(((EStructuralFeature)msg.getFeature()) == UMLPackage.eINSTANCE.getStructuredActivityNode_Node()
							|| ((EStructuralFeature)msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE.getStructuredActivityNode_Node())) {
						basePart.updateNode(loopNode);
					}
					if(UMLPackage.eINSTANCE.getLoopNode_IsTestedFirst().equals(msg.getFeature()) && basePart != null)
						basePart.setIsTestedFirst((Boolean)msg.getNewValue());

					if(UMLPackage.eINSTANCE.getLoopNode_BodyPart().equals(msg.getFeature()))
						basePart.updateBodyPart(loopNode);
					if(UMLPackage.eINSTANCE.getLoopNode_SetupPart().equals(msg.getFeature()))
						basePart.updateSetupPart(loopNode);
					if(UMLPackage.eINSTANCE.getLoopNode_Test().equals(msg.getFeature()))
						basePart.updateTest(loopNode);
					if(msg.getFeature() != null &&
							(((EStructuralFeature)msg.getFeature()) == UMLPackage.eINSTANCE.getLoopNode_Result()
							|| ((EStructuralFeature)msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE.getLoopNode_Result())) {
						basePart.updateResult(loopNode);
					}
					if(UMLPackage.eINSTANCE.getLoopNode_LoopVariable().equals(msg.getFeature()))
						basePart.updateLoopVariable(loopNode);
					if(UMLPackage.eINSTANCE.getLoopNode_BodyOutput().equals(msg.getFeature()))
						basePart.updateBodyOutput(loopNode);
					if(msg.getFeature() != null &&
							(((EStructuralFeature)msg.getFeature()) == UMLPackage.eINSTANCE.getLoopNode_LoopVariableInput()
							|| ((EStructuralFeature)msg.getFeature()).getEContainingClass() == UMLPackage.eINSTANCE.getLoopNode_LoopVariableInput())) {
						basePart.updateLoopVariableInput(loopNode);
					}


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
			return UMLViewsRepository.LoopNode.class;
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
		if(loopNode != null && BASE_PART.equals(key)) {
			if(basePart == null) {
				IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(UMLViewsRepository.class);
				if(provider != null) {
					basePart = (LoopNodePropertiesEditionPart)provider.getPropertiesEditionPart(UMLViewsRepository.LoopNode.class, kind, this);
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
		if(key == UMLViewsRepository.LoopNode.class)
			this.basePart = (LoopNodePropertiesEditionPart)propertiesEditionPart;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#initPart(java.lang.Class, int, org.eclipse.emf.ecore.EObject,
	 *      org.eclipse.emf.ecore.resource.ResourceSet)
	 */
	public void initPart(java.lang.Class key, int kind, EObject elt, ResourceSet allResource) {
		if(basePart != null && key == UMLViewsRepository.LoopNode.class) {
			((IPropertiesEditionPart)basePart).setContext(elt, allResource);
			final LoopNode loopNode = (LoopNode)elt;
			// init values
			basePart.initOwnedComment(loopNode, null, UMLPackage.eINSTANCE.getElement_OwnedComment());
			if(loopNode.getName() != null)
				basePart.setName(loopNode.getName());

			basePart.initVisibility((EEnum)UMLPackage.eINSTANCE.getNamedElement_Visibility().getEType(), loopNode.getVisibility());
			basePart.initClientDependency(loopNode, null, UMLPackage.eINSTANCE.getNamedElement_ClientDependency());
			basePart.setIsLeaf(loopNode.isLeaf());

			basePart.initOutgoing(loopNode, null, UMLPackage.eINSTANCE.getActivityNode_Outgoing());
			basePart.initIncoming(loopNode, null, UMLPackage.eINSTANCE.getActivityNode_Incoming());
			basePart.initInPartition(loopNode, null, UMLPackage.eINSTANCE.getActivityNode_InPartition());
			basePart.initInInterruptibleRegion(loopNode, null, UMLPackage.eINSTANCE.getActivityNode_InInterruptibleRegion());
			basePart.initRedefinedNode(loopNode, null, UMLPackage.eINSTANCE.getActivityNode_RedefinedNode());
			basePart.initHandler(loopNode, null, UMLPackage.eINSTANCE.getExecutableNode_Handler());
			basePart.initLocalPrecondition(loopNode, null, UMLPackage.eINSTANCE.getAction_LocalPrecondition());
			basePart.initLocalPostcondition(loopNode, null, UMLPackage.eINSTANCE.getAction_LocalPostcondition());
			basePart.initElementImport(loopNode, null, UMLPackage.eINSTANCE.getNamespace_ElementImport());
			basePart.initPackageImport(loopNode, null, UMLPackage.eINSTANCE.getNamespace_PackageImport());
			basePart.initOwnedRule(loopNode, null, UMLPackage.eINSTANCE.getNamespace_OwnedRule());
			basePart.initVariable(loopNode, null, UMLPackage.eINSTANCE.getStructuredActivityNode_Variable());
			basePart.initEdge(loopNode, null, UMLPackage.eINSTANCE.getStructuredActivityNode_Edge());
			basePart.setMustIsolate(loopNode.isMustIsolate());

			basePart.initNode(loopNode, null, UMLPackage.eINSTANCE.getStructuredActivityNode_Node());
			basePart.setIsTestedFirst(loopNode.isTestedFirst());

			basePart.initBodyPart(loopNode, null, UMLPackage.eINSTANCE.getLoopNode_BodyPart());
			basePart.initSetupPart(loopNode, null, UMLPackage.eINSTANCE.getLoopNode_SetupPart());
			basePart.initTest(loopNode, null, UMLPackage.eINSTANCE.getLoopNode_Test());
			basePart.initResult(loopNode, null, UMLPackage.eINSTANCE.getLoopNode_Result());
			basePart.initLoopVariable(loopNode, null, UMLPackage.eINSTANCE.getLoopNode_LoopVariable());
			basePart.initBodyOutput(loopNode, null, UMLPackage.eINSTANCE.getLoopNode_BodyOutput());
			basePart.initLoopVariableInput(loopNode, null, UMLPackage.eINSTANCE.getLoopNode_LoopVariableInput());

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


			basePart.addFilterToClientDependency(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					if(element instanceof EObject)
						return (!basePart.isContainedInClientDependencyTable((EObject)element));
					return element instanceof Resource;
				}

			});
			basePart.addFilterToClientDependency(new EObjectFilter(UMLPackage.eINSTANCE.getDependency()));
			// Start of user code for additional businessfilters for clientDependency

			// End of user code

			basePart.addFilterToOutgoing(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					if(element instanceof EObject)
						return (!basePart.isContainedInOutgoingTable((EObject)element));
					return element instanceof Resource;
				}

			});
			basePart.addFilterToOutgoing(new EObjectFilter(UMLPackage.eINSTANCE.getActivityEdge()));
			// Start of user code for additional businessfilters for outgoing

			// End of user code
			basePart.addFilterToIncoming(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					if(element instanceof EObject)
						return (!basePart.isContainedInIncomingTable((EObject)element));
					return element instanceof Resource;
				}

			});
			basePart.addFilterToIncoming(new EObjectFilter(UMLPackage.eINSTANCE.getActivityEdge()));
			// Start of user code for additional businessfilters for incoming

			// End of user code
			basePart.addFilterToInPartition(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					if(element instanceof EObject)
						return (!basePart.isContainedInInPartitionTable((EObject)element));
					return element instanceof Resource;
				}

			});
			basePart.addFilterToInPartition(new EObjectFilter(UMLPackage.eINSTANCE.getActivityPartition()));
			// Start of user code for additional businessfilters for inPartition

			// End of user code
			basePart.addFilterToInInterruptibleRegion(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					if(element instanceof EObject)
						return (!basePart.isContainedInInInterruptibleRegionTable((EObject)element));
					return element instanceof Resource;
				}

			});
			basePart.addFilterToInInterruptibleRegion(new EObjectFilter(UMLPackage.eINSTANCE.getInterruptibleActivityRegion()));
			// Start of user code for additional businessfilters for inInterruptibleRegion

			// End of user code
			basePart.addFilterToRedefinedNode(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					if(element instanceof EObject)
						return (!basePart.isContainedInRedefinedNodeTable((EObject)element));
					return element instanceof Resource;
				}

			});
			basePart.addFilterToRedefinedNode(new EObjectFilter(UMLPackage.eINSTANCE.getActivityNode()));
			// Start of user code for additional businessfilters for redefinedNode

			// End of user code
			basePart.addFilterToHandler(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					return (element instanceof String && element.equals("")) || (element instanceof ExceptionHandler); //$NON-NLS-1$ 

				}

			});
			// Start of user code for additional businessfilters for handler

			// End of user code
			basePart.addFilterToLocalPrecondition(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					return (element instanceof String && element.equals("")) || (element instanceof Constraint); //$NON-NLS-1$ 

				}

			});
			// Start of user code for additional businessfilters for localPrecondition

			// End of user code
			basePart.addFilterToLocalPostcondition(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					return (element instanceof String && element.equals("")) || (element instanceof Constraint); //$NON-NLS-1$ 

				}

			});
			// Start of user code for additional businessfilters for localPostcondition

			// End of user code
			basePart.addFilterToElementImport(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					return (element instanceof String && element.equals("")) || (element instanceof ElementImport); //$NON-NLS-1$ 

				}

			});
			// Start of user code for additional businessfilters for elementImport

			// End of user code
			basePart.addFilterToPackageImport(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					return (element instanceof String && element.equals("")) || (element instanceof PackageImport); //$NON-NLS-1$ 

				}

			});
			// Start of user code for additional businessfilters for packageImport

			// End of user code
			basePart.addFilterToOwnedRule(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					return (element instanceof String && element.equals("")) || (element instanceof Constraint); //$NON-NLS-1$ 

				}

			});
			// Start of user code for additional businessfilters for ownedRule

			// End of user code
			basePart.addFilterToVariable(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					return (element instanceof String && element.equals("")) || (element instanceof Variable); //$NON-NLS-1$ 

				}

			});
			// Start of user code for additional businessfilters for variable

			// End of user code
			basePart.addFilterToEdge(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					return (element instanceof String && element.equals("")) || (element instanceof ActivityEdge); //$NON-NLS-1$ 

				}

			});
			// Start of user code for additional businessfilters for edge

			// End of user code

			basePart.addFilterToNode(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					return (element instanceof String && element.equals("")) || (element instanceof ActivityNode); //$NON-NLS-1$ 

				}

			});
			// Start of user code for additional businessfilters for node

			// End of user code

			basePart.addFilterToBodyPart(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					if(element instanceof EObject)
						return (!basePart.isContainedInBodyPartTable((EObject)element));
					return element instanceof Resource;
				}

			});
			basePart.addFilterToBodyPart(new EObjectFilter(UMLPackage.eINSTANCE.getExecutableNode()));
			// Start of user code for additional businessfilters for bodyPart

			// End of user code
			basePart.addFilterToSetupPart(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					if(element instanceof EObject)
						return (!basePart.isContainedInSetupPartTable((EObject)element));
					return element instanceof Resource;
				}

			});
			basePart.addFilterToSetupPart(new EObjectFilter(UMLPackage.eINSTANCE.getExecutableNode()));
			// Start of user code for additional businessfilters for setupPart

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
			basePart.addFilterToResult(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					return (element instanceof String && element.equals("")) || (element instanceof OutputPin); //$NON-NLS-1$ 

				}

			});
			// Start of user code for additional businessfilters for result

			// End of user code
			basePart.addFilterToLoopVariable(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					if(element instanceof EObject)
						return (!basePart.isContainedInLoopVariableTable((EObject)element));
					return element instanceof Resource;
				}

			});
			basePart.addFilterToLoopVariable(new EObjectFilter(UMLPackage.eINSTANCE.getOutputPin()));
			// Start of user code for additional businessfilters for loopVariable

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
			basePart.addFilterToLoopVariableInput(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					return (element instanceof String && element.equals("")) || (element instanceof InputPin); //$NON-NLS-1$ 

				}

			});
			// Start of user code for additional businessfilters for loopVariableInput

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
		if(loopNode != null) {
			List ownedCommentToAddFromOwnedComment = basePart.getOwnedCommentToAdd();
			for(Iterator iter = ownedCommentToAddFromOwnedComment.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getElement_OwnedComment(), iter.next()));
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
				cc.append(MoveCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getComment(), moveElement.getElement(), moveElement.getIndex()));
			}
			cc.append(SetCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getNamedElement_Name(), basePart.getName()));

			cc.append(SetCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getNamedElement_Visibility(), basePart.getVisibility()));

			List clientDependencyToAddFromClientDependency = basePart.getClientDependencyToAdd();
			for(Iterator iter = clientDependencyToAddFromClientDependency.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), iter.next()));
			List clientDependencyToRemoveFromClientDependency = basePart.getClientDependencyToRemove();
			for(Iterator iter = clientDependencyToRemoveFromClientDependency.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), iter.next()));
			//List clientDependencyToMoveFromClientDependency = basePart.getClientDependencyToMove();
			//for (Iterator iter = clientDependencyToMoveFromClientDependency.iterator(); iter.hasNext();){
			//	org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getDependency(), moveElement.getElement(), moveElement.getIndex()));
			//}
			cc.append(SetCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf(), basePart.getIsLeaf()));

			List outgoingToAddFromOutgoing = basePart.getOutgoingToAdd();
			for(Iterator iter = outgoingToAddFromOutgoing.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getActivityNode_Outgoing(), iter.next()));
			List outgoingToRemoveFromOutgoing = basePart.getOutgoingToRemove();
			for(Iterator iter = outgoingToRemoveFromOutgoing.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getActivityNode_Outgoing(), iter.next()));
			//List outgoingToMoveFromOutgoing = basePart.getOutgoingToMove();
			//for (Iterator iter = outgoingToMoveFromOutgoing.iterator(); iter.hasNext();){
			//	org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getActivityEdge(), moveElement.getElement(), moveElement.getIndex()));
			//}
			List incomingToAddFromIncoming = basePart.getIncomingToAdd();
			for(Iterator iter = incomingToAddFromIncoming.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getActivityNode_Incoming(), iter.next()));
			List incomingToRemoveFromIncoming = basePart.getIncomingToRemove();
			for(Iterator iter = incomingToRemoveFromIncoming.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getActivityNode_Incoming(), iter.next()));
			//List incomingToMoveFromIncoming = basePart.getIncomingToMove();
			//for (Iterator iter = incomingToMoveFromIncoming.iterator(); iter.hasNext();){
			//	org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getActivityEdge(), moveElement.getElement(), moveElement.getIndex()));
			//}
			List inPartitionToAddFromInPartition = basePart.getInPartitionToAdd();
			for(Iterator iter = inPartitionToAddFromInPartition.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getActivityNode_InPartition(), iter.next()));
			List inPartitionToRemoveFromInPartition = basePart.getInPartitionToRemove();
			for(Iterator iter = inPartitionToRemoveFromInPartition.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getActivityNode_InPartition(), iter.next()));
			//List inPartitionToMoveFromInPartition = basePart.getInPartitionToMove();
			//for (Iterator iter = inPartitionToMoveFromInPartition.iterator(); iter.hasNext();){
			//	org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getActivityPartition(), moveElement.getElement(), moveElement.getIndex()));
			//}
			List inInterruptibleRegionToAddFromInInterruptibleRegion = basePart.getInInterruptibleRegionToAdd();
			for(Iterator iter = inInterruptibleRegionToAddFromInInterruptibleRegion.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getActivityNode_InInterruptibleRegion(), iter.next()));
			List inInterruptibleRegionToRemoveFromInInterruptibleRegion = basePart.getInInterruptibleRegionToRemove();
			for(Iterator iter = inInterruptibleRegionToRemoveFromInInterruptibleRegion.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getActivityNode_InInterruptibleRegion(), iter.next()));
			//List inInterruptibleRegionToMoveFromInInterruptibleRegion = basePart.getInInterruptibleRegionToMove();
			//for (Iterator iter = inInterruptibleRegionToMoveFromInInterruptibleRegion.iterator(); iter.hasNext();){
			//	org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getInterruptibleActivityRegion(), moveElement.getElement(), moveElement.getIndex()));
			//}
			List redefinedNodeToAddFromRedefinedNode = basePart.getRedefinedNodeToAdd();
			for(Iterator iter = redefinedNodeToAddFromRedefinedNode.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getActivityNode_RedefinedNode(), iter.next()));
			List redefinedNodeToRemoveFromRedefinedNode = basePart.getRedefinedNodeToRemove();
			for(Iterator iter = redefinedNodeToRemoveFromRedefinedNode.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getActivityNode_RedefinedNode(), iter.next()));
			//List redefinedNodeToMoveFromRedefinedNode = basePart.getRedefinedNodeToMove();
			//for (Iterator iter = redefinedNodeToMoveFromRedefinedNode.iterator(); iter.hasNext();){
			//	org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getActivityNode(), moveElement.getElement(), moveElement.getIndex()));
			//}
			List handlerToAddFromHandler = basePart.getHandlerToAdd();
			for(Iterator iter = handlerToAddFromHandler.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getExecutableNode_Handler(), iter.next()));
			Map handlerToRefreshFromHandler = basePart.getHandlerToEdit();
			for(Iterator iter = handlerToRefreshFromHandler.keySet().iterator(); iter.hasNext();) {



				ExceptionHandler nextElement = (ExceptionHandler)iter.next();
				ExceptionHandler handler = (ExceptionHandler)handlerToRefreshFromHandler.get(nextElement);

				for(EStructuralFeature feature : nextElement.eClass().getEAllStructuralFeatures()) {
					if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
						cc.append(SetCommand.create(editingDomain, nextElement, feature, handler.eGet(feature)));
					}
				}



			}
			List handlerToRemoveFromHandler = basePart.getHandlerToRemove();
			for(Iterator iter = handlerToRemoveFromHandler.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List handlerToMoveFromHandler = basePart.getHandlerToMove();
			for(Iterator iter = handlerToMoveFromHandler.iterator(); iter.hasNext();) {
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
				cc.append(MoveCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getExceptionHandler(), moveElement.getElement(), moveElement.getIndex()));
			}
			List localPreconditionToAddFromLocalPrecondition = basePart.getLocalPreconditionToAdd();
			for(Iterator iter = localPreconditionToAddFromLocalPrecondition.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getAction_LocalPrecondition(), iter.next()));
			Map localPreconditionToRefreshFromLocalPrecondition = basePart.getLocalPreconditionToEdit();
			for(Iterator iter = localPreconditionToRefreshFromLocalPrecondition.keySet().iterator(); iter.hasNext();) {



				Constraint nextElement = (Constraint)iter.next();
				Constraint localPrecondition = (Constraint)localPreconditionToRefreshFromLocalPrecondition.get(nextElement);

				for(EStructuralFeature feature : nextElement.eClass().getEAllStructuralFeatures()) {
					if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
						cc.append(SetCommand.create(editingDomain, nextElement, feature, localPrecondition.eGet(feature)));
					}
				}



			}
			List localPreconditionToRemoveFromLocalPrecondition = basePart.getLocalPreconditionToRemove();
			for(Iterator iter = localPreconditionToRemoveFromLocalPrecondition.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List localPreconditionToMoveFromLocalPrecondition = basePart.getLocalPreconditionToMove();
			for(Iterator iter = localPreconditionToMoveFromLocalPrecondition.iterator(); iter.hasNext();) {
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
				cc.append(MoveCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getConstraint(), moveElement.getElement(), moveElement.getIndex()));
			}
			List localPostconditionToAddFromLocalPostcondition = basePart.getLocalPostconditionToAdd();
			for(Iterator iter = localPostconditionToAddFromLocalPostcondition.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getAction_LocalPostcondition(), iter.next()));
			Map localPostconditionToRefreshFromLocalPostcondition = basePart.getLocalPostconditionToEdit();
			for(Iterator iter = localPostconditionToRefreshFromLocalPostcondition.keySet().iterator(); iter.hasNext();) {



				Constraint nextElement = (Constraint)iter.next();
				Constraint localPostcondition = (Constraint)localPostconditionToRefreshFromLocalPostcondition.get(nextElement);

				for(EStructuralFeature feature : nextElement.eClass().getEAllStructuralFeatures()) {
					if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
						cc.append(SetCommand.create(editingDomain, nextElement, feature, localPostcondition.eGet(feature)));
					}
				}



			}
			List localPostconditionToRemoveFromLocalPostcondition = basePart.getLocalPostconditionToRemove();
			for(Iterator iter = localPostconditionToRemoveFromLocalPostcondition.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List localPostconditionToMoveFromLocalPostcondition = basePart.getLocalPostconditionToMove();
			for(Iterator iter = localPostconditionToMoveFromLocalPostcondition.iterator(); iter.hasNext();) {
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
				cc.append(MoveCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getConstraint(), moveElement.getElement(), moveElement.getIndex()));
			}
			List elementImportToAddFromElementImport = basePart.getElementImportToAdd();
			for(Iterator iter = elementImportToAddFromElementImport.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getNamespace_ElementImport(), iter.next()));
			Map elementImportToRefreshFromElementImport = basePart.getElementImportToEdit();
			for(Iterator iter = elementImportToRefreshFromElementImport.keySet().iterator(); iter.hasNext();) {



				ElementImport nextElement = (ElementImport)iter.next();
				ElementImport elementImport = (ElementImport)elementImportToRefreshFromElementImport.get(nextElement);

				for(EStructuralFeature feature : nextElement.eClass().getEAllStructuralFeatures()) {
					if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
						cc.append(SetCommand.create(editingDomain, nextElement, feature, elementImport.eGet(feature)));
					}
				}



			}
			List elementImportToRemoveFromElementImport = basePart.getElementImportToRemove();
			for(Iterator iter = elementImportToRemoveFromElementImport.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List elementImportToMoveFromElementImport = basePart.getElementImportToMove();
			for(Iterator iter = elementImportToMoveFromElementImport.iterator(); iter.hasNext();) {
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
				cc.append(MoveCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getElementImport(), moveElement.getElement(), moveElement.getIndex()));
			}
			List packageImportToAddFromPackageImport = basePart.getPackageImportToAdd();
			for(Iterator iter = packageImportToAddFromPackageImport.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getNamespace_PackageImport(), iter.next()));
			Map packageImportToRefreshFromPackageImport = basePart.getPackageImportToEdit();
			for(Iterator iter = packageImportToRefreshFromPackageImport.keySet().iterator(); iter.hasNext();) {



				PackageImport nextElement = (PackageImport)iter.next();
				PackageImport packageImport = (PackageImport)packageImportToRefreshFromPackageImport.get(nextElement);

				for(EStructuralFeature feature : nextElement.eClass().getEAllStructuralFeatures()) {
					if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
						cc.append(SetCommand.create(editingDomain, nextElement, feature, packageImport.eGet(feature)));
					}
				}



			}
			List packageImportToRemoveFromPackageImport = basePart.getPackageImportToRemove();
			for(Iterator iter = packageImportToRemoveFromPackageImport.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List packageImportToMoveFromPackageImport = basePart.getPackageImportToMove();
			for(Iterator iter = packageImportToMoveFromPackageImport.iterator(); iter.hasNext();) {
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
				cc.append(MoveCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getPackageImport(), moveElement.getElement(), moveElement.getIndex()));
			}
			List ownedRuleToAddFromOwnedRule = basePart.getOwnedRuleToAdd();
			for(Iterator iter = ownedRuleToAddFromOwnedRule.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getNamespace_OwnedRule(), iter.next()));
			Map ownedRuleToRefreshFromOwnedRule = basePart.getOwnedRuleToEdit();
			for(Iterator iter = ownedRuleToRefreshFromOwnedRule.keySet().iterator(); iter.hasNext();) {



				Constraint nextElement = (Constraint)iter.next();
				Constraint ownedRule = (Constraint)ownedRuleToRefreshFromOwnedRule.get(nextElement);

				for(EStructuralFeature feature : nextElement.eClass().getEAllStructuralFeatures()) {
					if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
						cc.append(SetCommand.create(editingDomain, nextElement, feature, ownedRule.eGet(feature)));
					}
				}



			}
			List ownedRuleToRemoveFromOwnedRule = basePart.getOwnedRuleToRemove();
			for(Iterator iter = ownedRuleToRemoveFromOwnedRule.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List ownedRuleToMoveFromOwnedRule = basePart.getOwnedRuleToMove();
			for(Iterator iter = ownedRuleToMoveFromOwnedRule.iterator(); iter.hasNext();) {
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
				cc.append(MoveCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getConstraint(), moveElement.getElement(), moveElement.getIndex()));
			}
			List variableToAddFromVariable = basePart.getVariableToAdd();
			for(Iterator iter = variableToAddFromVariable.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getStructuredActivityNode_Variable(), iter.next()));
			Map variableToRefreshFromVariable = basePart.getVariableToEdit();
			for(Iterator iter = variableToRefreshFromVariable.keySet().iterator(); iter.hasNext();) {



				Variable nextElement = (Variable)iter.next();
				Variable variable = (Variable)variableToRefreshFromVariable.get(nextElement);

				for(EStructuralFeature feature : nextElement.eClass().getEAllStructuralFeatures()) {
					if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
						cc.append(SetCommand.create(editingDomain, nextElement, feature, variable.eGet(feature)));
					}
				}



			}
			List variableToRemoveFromVariable = basePart.getVariableToRemove();
			for(Iterator iter = variableToRemoveFromVariable.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List variableToMoveFromVariable = basePart.getVariableToMove();
			for(Iterator iter = variableToMoveFromVariable.iterator(); iter.hasNext();) {
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
				cc.append(MoveCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getVariable(), moveElement.getElement(), moveElement.getIndex()));
			}
			List edgeToAddFromEdge = basePart.getEdgeToAdd();
			for(Iterator iter = edgeToAddFromEdge.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getStructuredActivityNode_Edge(), iter.next()));
			Map edgeToRefreshFromEdge = basePart.getEdgeToEdit();
			for(Iterator iter = edgeToRefreshFromEdge.keySet().iterator(); iter.hasNext();) {



				ActivityEdge nextElement = (ActivityEdge)iter.next();
				ActivityEdge edge = (ActivityEdge)edgeToRefreshFromEdge.get(nextElement);

				for(EStructuralFeature feature : nextElement.eClass().getEAllStructuralFeatures()) {
					if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
						cc.append(SetCommand.create(editingDomain, nextElement, feature, edge.eGet(feature)));
					}
				}



			}
			List edgeToRemoveFromEdge = basePart.getEdgeToRemove();
			for(Iterator iter = edgeToRemoveFromEdge.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List edgeToMoveFromEdge = basePart.getEdgeToMove();
			for(Iterator iter = edgeToMoveFromEdge.iterator(); iter.hasNext();) {
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
				cc.append(MoveCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getActivityEdge(), moveElement.getElement(), moveElement.getIndex()));
			}
			cc.append(SetCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getStructuredActivityNode_MustIsolate(), basePart.getMustIsolate()));

			List nodeToAddFromNode = basePart.getNodeToAdd();
			for(Iterator iter = nodeToAddFromNode.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getStructuredActivityNode_Node(), iter.next()));
			Map nodeToRefreshFromNode = basePart.getNodeToEdit();
			for(Iterator iter = nodeToRefreshFromNode.keySet().iterator(); iter.hasNext();) {



				ActivityNode nextElement = (ActivityNode)iter.next();
				ActivityNode node = (ActivityNode)nodeToRefreshFromNode.get(nextElement);

				for(EStructuralFeature feature : nextElement.eClass().getEAllStructuralFeatures()) {
					if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
						cc.append(SetCommand.create(editingDomain, nextElement, feature, node.eGet(feature)));
					}
				}



			}
			List nodeToRemoveFromNode = basePart.getNodeToRemove();
			for(Iterator iter = nodeToRemoveFromNode.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List nodeToMoveFromNode = basePart.getNodeToMove();
			for(Iterator iter = nodeToMoveFromNode.iterator(); iter.hasNext();) {
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
				cc.append(MoveCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getActivityNode(), moveElement.getElement(), moveElement.getIndex()));
			}
			cc.append(SetCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getLoopNode_IsTestedFirst(), basePart.getIsTestedFirst()));

			List bodyPartToAddFromBodyPart = basePart.getBodyPartToAdd();
			for(Iterator iter = bodyPartToAddFromBodyPart.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getLoopNode_BodyPart(), iter.next()));
			List bodyPartToRemoveFromBodyPart = basePart.getBodyPartToRemove();
			for(Iterator iter = bodyPartToRemoveFromBodyPart.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getLoopNode_BodyPart(), iter.next()));
			//List bodyPartToMoveFromBodyPart = basePart.getBodyPartToMove();
			//for (Iterator iter = bodyPartToMoveFromBodyPart.iterator(); iter.hasNext();){
			//	org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getExecutableNode(), moveElement.getElement(), moveElement.getIndex()));
			//}
			List setupPartToAddFromSetupPart = basePart.getSetupPartToAdd();
			for(Iterator iter = setupPartToAddFromSetupPart.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getLoopNode_SetupPart(), iter.next()));
			List setupPartToRemoveFromSetupPart = basePart.getSetupPartToRemove();
			for(Iterator iter = setupPartToRemoveFromSetupPart.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getLoopNode_SetupPart(), iter.next()));
			//List setupPartToMoveFromSetupPart = basePart.getSetupPartToMove();
			//for (Iterator iter = setupPartToMoveFromSetupPart.iterator(); iter.hasNext();){
			//	org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getExecutableNode(), moveElement.getElement(), moveElement.getIndex()));
			//}
			List testToAddFromTest = basePart.getTestToAdd();
			for(Iterator iter = testToAddFromTest.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getLoopNode_Test(), iter.next()));
			List testToRemoveFromTest = basePart.getTestToRemove();
			for(Iterator iter = testToRemoveFromTest.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getLoopNode_Test(), iter.next()));
			//List testToMoveFromTest = basePart.getTestToMove();
			//for (Iterator iter = testToMoveFromTest.iterator(); iter.hasNext();){
			//	org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getExecutableNode(), moveElement.getElement(), moveElement.getIndex()));
			//}
			List resultToAddFromResult = basePart.getResultToAdd();
			for(Iterator iter = resultToAddFromResult.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getLoopNode_Result(), iter.next()));
			Map resultToRefreshFromResult = basePart.getResultToEdit();
			for(Iterator iter = resultToRefreshFromResult.keySet().iterator(); iter.hasNext();) {



				OutputPin nextElement = (OutputPin)iter.next();
				OutputPin result = (OutputPin)resultToRefreshFromResult.get(nextElement);

				for(EStructuralFeature feature : nextElement.eClass().getEAllStructuralFeatures()) {
					if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
						cc.append(SetCommand.create(editingDomain, nextElement, feature, result.eGet(feature)));
					}
				}



			}
			List resultToRemoveFromResult = basePart.getResultToRemove();
			for(Iterator iter = resultToRemoveFromResult.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List resultToMoveFromResult = basePart.getResultToMove();
			for(Iterator iter = resultToMoveFromResult.iterator(); iter.hasNext();) {
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
				cc.append(MoveCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getOutputPin(), moveElement.getElement(), moveElement.getIndex()));
			}
			List loopVariableToAddFromLoopVariable = basePart.getLoopVariableToAdd();
			for(Iterator iter = loopVariableToAddFromLoopVariable.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getLoopNode_LoopVariable(), iter.next()));
			List loopVariableToRemoveFromLoopVariable = basePart.getLoopVariableToRemove();
			for(Iterator iter = loopVariableToRemoveFromLoopVariable.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getLoopNode_LoopVariable(), iter.next()));
			//List loopVariableToMoveFromLoopVariable = basePart.getLoopVariableToMove();
			//for (Iterator iter = loopVariableToMoveFromLoopVariable.iterator(); iter.hasNext();){
			//	org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getOutputPin(), moveElement.getElement(), moveElement.getIndex()));
			//}
			List bodyOutputToAddFromBodyOutput = basePart.getBodyOutputToAdd();
			for(Iterator iter = bodyOutputToAddFromBodyOutput.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getLoopNode_BodyOutput(), iter.next()));
			List bodyOutputToRemoveFromBodyOutput = basePart.getBodyOutputToRemove();
			for(Iterator iter = bodyOutputToRemoveFromBodyOutput.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getLoopNode_BodyOutput(), iter.next()));
			//List bodyOutputToMoveFromBodyOutput = basePart.getBodyOutputToMove();
			//for (Iterator iter = bodyOutputToMoveFromBodyOutput.iterator(); iter.hasNext();){
			//	org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getOutputPin(), moveElement.getElement(), moveElement.getIndex()));
			//}
			List loopVariableInputToAddFromLoopVariableInput = basePart.getLoopVariableInputToAdd();
			for(Iterator iter = loopVariableInputToAddFromLoopVariableInput.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getLoopNode_LoopVariableInput(), iter.next()));
			Map loopVariableInputToRefreshFromLoopVariableInput = basePart.getLoopVariableInputToEdit();
			for(Iterator iter = loopVariableInputToRefreshFromLoopVariableInput.keySet().iterator(); iter.hasNext();) {



				InputPin nextElement = (InputPin)iter.next();
				InputPin loopVariableInput = (InputPin)loopVariableInputToRefreshFromLoopVariableInput.get(nextElement);

				for(EStructuralFeature feature : nextElement.eClass().getEAllStructuralFeatures()) {
					if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
						cc.append(SetCommand.create(editingDomain, nextElement, feature, loopVariableInput.eGet(feature)));
					}
				}



			}
			List loopVariableInputToRemoveFromLoopVariableInput = basePart.getLoopVariableInputToRemove();
			for(Iterator iter = loopVariableInputToRemoveFromLoopVariableInput.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List loopVariableInputToMoveFromLoopVariableInput = basePart.getLoopVariableInputToMove();
			for(Iterator iter = loopVariableInputToMoveFromLoopVariableInput.iterator(); iter.hasNext();) {
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
				cc.append(MoveCommand.create(editingDomain, loopNode, UMLPackage.eINSTANCE.getInputPin(), moveElement.getElement(), moveElement.getIndex()));
			}


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
		if(source instanceof LoopNode) {
			LoopNode loopNodeToUpdate = (LoopNode)source;
			loopNodeToUpdate.getOwnedComments().addAll(basePart.getOwnedCommentToAdd());
			loopNodeToUpdate.setName(basePart.getName());

			loopNodeToUpdate.setVisibility((VisibilityKind)basePart.getVisibility());

			loopNodeToUpdate.getClientDependencies().addAll(basePart.getClientDependencyToAdd());
			loopNodeToUpdate.setIsLeaf(new Boolean(basePart.getIsLeaf()).booleanValue());

			loopNodeToUpdate.getOutgoings().addAll(basePart.getOutgoingToAdd());
			loopNodeToUpdate.getIncomings().addAll(basePart.getIncomingToAdd());
			loopNodeToUpdate.getInPartitions().addAll(basePart.getInPartitionToAdd());
			loopNodeToUpdate.getInInterruptibleRegions().addAll(basePart.getInInterruptibleRegionToAdd());
			loopNodeToUpdate.getRedefinedNodes().addAll(basePart.getRedefinedNodeToAdd());
			loopNodeToUpdate.getHandlers().addAll(basePart.getHandlerToAdd());
			loopNodeToUpdate.getLocalPreconditions().addAll(basePart.getLocalPreconditionToAdd());
			loopNodeToUpdate.getLocalPostconditions().addAll(basePart.getLocalPostconditionToAdd());
			loopNodeToUpdate.getElementImports().addAll(basePart.getElementImportToAdd());
			loopNodeToUpdate.getPackageImports().addAll(basePart.getPackageImportToAdd());
			loopNodeToUpdate.getOwnedRules().addAll(basePart.getOwnedRuleToAdd());
			loopNodeToUpdate.getVariables().addAll(basePart.getVariableToAdd());
			loopNodeToUpdate.getEdges().addAll(basePart.getEdgeToAdd());
			loopNodeToUpdate.setMustIsolate(new Boolean(basePart.getMustIsolate()).booleanValue());

			loopNodeToUpdate.getNodes().addAll(basePart.getNodeToAdd());
			loopNodeToUpdate.setIsTestedFirst(new Boolean(basePart.getIsTestedFirst()).booleanValue());

			loopNodeToUpdate.getBodyParts().addAll(basePart.getBodyPartToAdd());
			loopNodeToUpdate.getSetupParts().addAll(basePart.getSetupPartToAdd());
			loopNodeToUpdate.getTests().addAll(basePart.getTestToAdd());
			loopNodeToUpdate.getResults().addAll(basePart.getResultToAdd());
			loopNodeToUpdate.getLoopVariables().addAll(basePart.getLoopVariableToAdd());
			loopNodeToUpdate.getBodyOutputs().addAll(basePart.getBodyOutputToAdd());
			loopNodeToUpdate.getLoopVariableInputs().addAll(basePart.getLoopVariableInputToAdd());


			return loopNodeToUpdate;
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
			if(UMLViewsRepository.LoopNode.ownedComment == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.SET == event.getKind()) {
					Comment oldValue = (Comment)event.getOldValue();
					Comment newValue = (Comment)event.getNewValue();


					// TODO: Complete the loopNode update command
					for(EStructuralFeature feature : newValue.eClass().getEAllStructuralFeatures()) {
						if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
							command.append(SetCommand.create(liveEditingDomain, oldValue, feature, newValue.eGet(feature)));
						}
					}


				} else if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getElement_OwnedComment(), event.getNewValue()));
				else if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getComment(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.LoopNode.name == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getNamedElement_Name(), event.getNewValue()));

			if(UMLViewsRepository.LoopNode.visibility == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getNamedElement_Visibility(), event.getNewValue()));

			if(UMLViewsRepository.LoopNode.clientDependency == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), event.getNewValue()));
				if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), event.getNewValue()));
				if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getNamedElement_ClientDependency(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.LoopNode.isLeaf == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf(), event.getNewValue()));

			if(UMLViewsRepository.LoopNode.outgoing == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getActivityNode_Outgoing(), event.getNewValue()));
				if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getActivityNode_Outgoing(), event.getNewValue()));
				if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getActivityNode_Outgoing(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.LoopNode.incoming == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getActivityNode_Incoming(), event.getNewValue()));
				if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getActivityNode_Incoming(), event.getNewValue()));
				if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getActivityNode_Incoming(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.LoopNode.inPartition == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getActivityNode_InPartition(), event.getNewValue()));
				if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getActivityNode_InPartition(), event.getNewValue()));
				if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getActivityNode_InPartition(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.LoopNode.inInterruptibleRegion == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getActivityNode_InInterruptibleRegion(), event.getNewValue()));
				if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getActivityNode_InInterruptibleRegion(), event.getNewValue()));
				if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getActivityNode_InInterruptibleRegion(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.LoopNode.redefinedNode == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getActivityNode_RedefinedNode(), event.getNewValue()));
				if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getActivityNode_RedefinedNode(), event.getNewValue()));
				if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getActivityNode_RedefinedNode(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.LoopNode.handler == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.SET == event.getKind()) {
					ExceptionHandler oldValue = (ExceptionHandler)event.getOldValue();
					ExceptionHandler newValue = (ExceptionHandler)event.getNewValue();


					// TODO: Complete the loopNode update command
					for(EStructuralFeature feature : newValue.eClass().getEAllStructuralFeatures()) {
						if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
							command.append(SetCommand.create(liveEditingDomain, oldValue, feature, newValue.eGet(feature)));
						}
					}


				} else if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getExecutableNode_Handler(), event.getNewValue()));
				else if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getExceptionHandler(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.LoopNode.localPrecondition == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.SET == event.getKind()) {
					Constraint oldValue = (Constraint)event.getOldValue();
					Constraint newValue = (Constraint)event.getNewValue();


					// TODO: Complete the loopNode update command
					for(EStructuralFeature feature : newValue.eClass().getEAllStructuralFeatures()) {
						if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
							command.append(SetCommand.create(liveEditingDomain, oldValue, feature, newValue.eGet(feature)));
						}
					}


				} else if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getAction_LocalPrecondition(), event.getNewValue()));
				else if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getConstraint(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.LoopNode.localPostcondition == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.SET == event.getKind()) {
					Constraint oldValue = (Constraint)event.getOldValue();
					Constraint newValue = (Constraint)event.getNewValue();


					// TODO: Complete the loopNode update command
					for(EStructuralFeature feature : newValue.eClass().getEAllStructuralFeatures()) {
						if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
							command.append(SetCommand.create(liveEditingDomain, oldValue, feature, newValue.eGet(feature)));
						}
					}


				} else if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getAction_LocalPostcondition(), event.getNewValue()));
				else if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getConstraint(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.LoopNode.elementImport == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.SET == event.getKind()) {
					ElementImport oldValue = (ElementImport)event.getOldValue();
					ElementImport newValue = (ElementImport)event.getNewValue();


					// TODO: Complete the loopNode update command
					for(EStructuralFeature feature : newValue.eClass().getEAllStructuralFeatures()) {
						if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
							command.append(SetCommand.create(liveEditingDomain, oldValue, feature, newValue.eGet(feature)));
						}
					}


				} else if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getNamespace_ElementImport(), event.getNewValue()));
				else if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getElementImport(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.LoopNode.packageImport == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.SET == event.getKind()) {
					PackageImport oldValue = (PackageImport)event.getOldValue();
					PackageImport newValue = (PackageImport)event.getNewValue();


					// TODO: Complete the loopNode update command
					for(EStructuralFeature feature : newValue.eClass().getEAllStructuralFeatures()) {
						if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
							command.append(SetCommand.create(liveEditingDomain, oldValue, feature, newValue.eGet(feature)));
						}
					}


				} else if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getNamespace_PackageImport(), event.getNewValue()));
				else if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getPackageImport(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.LoopNode.ownedRule == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.SET == event.getKind()) {
					Constraint oldValue = (Constraint)event.getOldValue();
					Constraint newValue = (Constraint)event.getNewValue();


					// TODO: Complete the loopNode update command
					for(EStructuralFeature feature : newValue.eClass().getEAllStructuralFeatures()) {
						if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
							command.append(SetCommand.create(liveEditingDomain, oldValue, feature, newValue.eGet(feature)));
						}
					}


				} else if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getNamespace_OwnedRule(), event.getNewValue()));
				else if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getConstraint(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.LoopNode.variable == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.SET == event.getKind()) {
					Variable oldValue = (Variable)event.getOldValue();
					Variable newValue = (Variable)event.getNewValue();


					// TODO: Complete the loopNode update command
					for(EStructuralFeature feature : newValue.eClass().getEAllStructuralFeatures()) {
						if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
							command.append(SetCommand.create(liveEditingDomain, oldValue, feature, newValue.eGet(feature)));
						}
					}


				} else if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getStructuredActivityNode_Variable(), event.getNewValue()));
				else if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getVariable(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.LoopNode.edge == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.SET == event.getKind()) {
					ActivityEdge oldValue = (ActivityEdge)event.getOldValue();
					ActivityEdge newValue = (ActivityEdge)event.getNewValue();


					// TODO: Complete the loopNode update command
					for(EStructuralFeature feature : newValue.eClass().getEAllStructuralFeatures()) {
						if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
							command.append(SetCommand.create(liveEditingDomain, oldValue, feature, newValue.eGet(feature)));
						}
					}


				} else if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getStructuredActivityNode_Edge(), event.getNewValue()));
				else if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getActivityEdge(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.LoopNode.mustIsolate == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getStructuredActivityNode_MustIsolate(), event.getNewValue()));

			if(UMLViewsRepository.LoopNode.node == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.SET == event.getKind()) {
					ActivityNode oldValue = (ActivityNode)event.getOldValue();
					ActivityNode newValue = (ActivityNode)event.getNewValue();


					// TODO: Complete the loopNode update command
					for(EStructuralFeature feature : newValue.eClass().getEAllStructuralFeatures()) {
						if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
							command.append(SetCommand.create(liveEditingDomain, oldValue, feature, newValue.eGet(feature)));
						}
					}


				} else if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getStructuredActivityNode_Node(), event.getNewValue()));
				else if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getActivityNode(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.LoopNode.isTestedFirst == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getLoopNode_IsTestedFirst(), event.getNewValue()));

			if(UMLViewsRepository.LoopNode.bodyPart == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getLoopNode_BodyPart(), event.getNewValue()));
				if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getLoopNode_BodyPart(), event.getNewValue()));
				if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getLoopNode_BodyPart(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.LoopNode.setupPart == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getLoopNode_SetupPart(), event.getNewValue()));
				if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getLoopNode_SetupPart(), event.getNewValue()));
				if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getLoopNode_SetupPart(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.LoopNode.test == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getLoopNode_Test(), event.getNewValue()));
				if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getLoopNode_Test(), event.getNewValue()));
				if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getLoopNode_Test(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.LoopNode.result == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.SET == event.getKind()) {
					OutputPin oldValue = (OutputPin)event.getOldValue();
					OutputPin newValue = (OutputPin)event.getNewValue();


					// TODO: Complete the loopNode update command
					for(EStructuralFeature feature : newValue.eClass().getEAllStructuralFeatures()) {
						if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
							command.append(SetCommand.create(liveEditingDomain, oldValue, feature, newValue.eGet(feature)));
						}
					}


				} else if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getLoopNode_Result(), event.getNewValue()));
				else if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getOutputPin(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.LoopNode.loopVariable == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getLoopNode_LoopVariable(), event.getNewValue()));
				if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getLoopNode_LoopVariable(), event.getNewValue()));
				if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getLoopNode_LoopVariable(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.LoopNode.bodyOutput == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getLoopNode_BodyOutput(), event.getNewValue()));
				if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getLoopNode_BodyOutput(), event.getNewValue()));
				if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getLoopNode_BodyOutput(), event.getNewValue(), event.getNewIndex()));
			}
			if(UMLViewsRepository.LoopNode.loopVariableInput == event.getAffectedEditor()) {
				if(PropertiesEditionEvent.SET == event.getKind()) {
					InputPin oldValue = (InputPin)event.getOldValue();
					InputPin newValue = (InputPin)event.getNewValue();


					// TODO: Complete the loopNode update command
					for(EStructuralFeature feature : newValue.eClass().getEAllStructuralFeatures()) {
						if(feature.isChangeable() && !(feature instanceof EReference && ((EReference)feature).isContainer())) {
							command.append(SetCommand.create(liveEditingDomain, oldValue, feature, newValue.eGet(feature)));
						}
					}


				} else if(PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getLoopNode_LoopVariableInput(), event.getNewValue()));
				else if(PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if(PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, loopNode, UMLPackage.eINSTANCE.getInputPin(), event.getNewValue(), event.getNewIndex()));
			}


			if(!command.isEmpty() && !command.canExecute()) {
				EMFPropertiesRuntime.getDefault().logError("Cannot perform model change command.", null);
			} else {
				liveEditingDomain.getCommandStack().execute(command);
			}
		} else if(PropertiesEditionEvent.CHANGE == event.getState()) {
			Diagnostic diag = this.validateValue(event);
			if(diag != null && diag.getSeverity() != Diagnostic.OK) {

				if(UMLViewsRepository.LoopNode.name == event.getAffectedEditor())
					basePart.setMessageForName(diag.getMessage(), IMessageProvider.ERROR);





			} else {

				if(UMLViewsRepository.LoopNode.name == event.getAffectedEditor())
					basePart.unsetMessageForName();





			}
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.String, int)
	 */
	public boolean isRequired(String key, int kind) {
		return key == UMLViewsRepository.LoopNode.isLeaf || key == UMLViewsRepository.LoopNode.mustIsolate || key == UMLViewsRepository.LoopNode.isTestedFirst;
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
				if(UMLViewsRepository.LoopNode.name == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getNamedElement_Name().getEAttributeType(), newValue);
				}
				if(UMLViewsRepository.LoopNode.visibility == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getNamedElement_Visibility().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getNamedElement_Visibility().getEAttributeType(), newValue);
				}
				if(UMLViewsRepository.LoopNode.isLeaf == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getRedefinableElement_IsLeaf().getEAttributeType(), newValue);
				}
				if(UMLViewsRepository.LoopNode.mustIsolate == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getStructuredActivityNode_MustIsolate().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getStructuredActivityNode_MustIsolate().getEAttributeType(), newValue);
				}
				if(UMLViewsRepository.LoopNode.isTestedFirst == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(UMLPackage.eINSTANCE.getLoopNode_IsTestedFirst().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(UMLPackage.eINSTANCE.getLoopNode_IsTestedFirst().getEAttributeType(), newValue);
				}

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
			validate = Diagnostician.INSTANCE.validate(loopNode);
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
			loopNode.eAdapters().remove(semanticAdapter);
	}

}
