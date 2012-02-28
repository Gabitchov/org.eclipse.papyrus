/*****************************************************************************
 * Copyright (c) 2011 Atos.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Arthur Daussy (Atos) - Initial API and implementation
 *   Arthur Daussy - 371712 : 372745: [ActivityDiagram] Major refactoring group framework
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.activity.activitygroup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EventObject;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListener;
import org.eclipse.emf.transaction.ResourceSetListenerImpl;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.TransactionalCommandStack;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomainEvent;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.papyrus.diagram.activity.activitygroup.editpolicy.notifiers.GroupNotifyingEditPolicy;
import org.eclipse.papyrus.diagram.activity.activitygroup.editpolicy.notifiers.IGroupNotifier;
import org.eclipse.papyrus.diagram.activity.activitygroup.predicates.DescendantsFilter;
import org.eclipse.papyrus.diagram.activity.activitygroup.request.AbstractGroupRequest;
import org.eclipse.papyrus.diagram.activity.activitygroup.request.IGroupRequest;
import org.eclipse.papyrus.diagram.activity.activitygroup.request.SetDeferredRequest;
import org.eclipse.papyrus.diagram.activity.activitygroup.request.IGroupRequest.GroupRequestType;
import org.eclipse.papyrus.diagram.activity.activitygroup.utils.DebugUtils;
import org.eclipse.papyrus.diagram.activity.activitygroup.utils.Utils;
import org.eclipse.papyrus.diagram.activity.commands.DeferredSetValueCommand;
import org.eclipse.papyrus.diagram.activity.edit.part.ActivityGroup.IGroupCompartmentEditPart;
import org.eclipse.papyrus.diagram.activity.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.diagram.common.commands.RemoveValueCommand;
import org.eclipse.papyrus.diagram.common.commands.RemoveValueRequest;
import org.eclipse.papyrus.log.LogHelper;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Collections2;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;


public class GroupRequestAdvisor implements IGroupRequestAdvisor {

	private static final String GROUP_FRAMEWORK_GRAPHICAL_PARENT = "GroupFramework_GraphicalParent";

	/**
	 * Debug message
	 */
	private static final String CHILDREN_REFERENCES_ARE = " ---- Children references are : ---- ";

	/**
	 * Debug message
	 */
	private static final String ALL_PARENT_REFERENCES_ARE = " ---- All parent references are : ---- ";



	/**
	 * SingletonHolder is loaded on the first execution of Singleton.getInstance()
	 * or the first access to SingletonHolder.INSTANCE, not before.
	 */
	private static class SingletonHolder {

		public static final GroupRequestAdvisor instance = new GroupRequestAdvisor();
	}

	/**
	 * Get the instance of {@link GroupRequestAdvisor}
	 * 
	 * @return
	 */
	public static GroupRequestAdvisor getInstance() {
		return SingletonHolder.instance;
	}

	/**
	 * Store all the listener
	 */
	private Multimap<EObject, IGroupNotifier> listenners;

	/**
	 * Logger
	 */
	private static LogHelper log = new LogHelper(UMLDiagramEditorPlugin.getInstance());

	/***
	 * Private constructor
	 */
	private GroupRequestAdvisor() {
		listenners = ArrayListMultimap.create();
	}

	/**
	 * Add a {@link IGroupNotifier}
	 * 
	 * @param editpolicy
	 */
	public void addListenner(EObject eObject, IGroupNotifier editpolicy) {
		listenners.put(eObject, editpolicy);
	}

	/**
	 * Remove a {@link IGroupNotifier}
	 * 
	 * @param editpolicy
	 */
	public void removeListenner(IGroupNotifier editpolicy) {
		/**
		 * TODO test
		 */
		if(editpolicy == null) {
			return;
		}
		Iterator<Entry<EObject, IGroupNotifier>> iterator = listenners.entries().iterator();
		while(iterator.hasNext()) {
			Entry<EObject, IGroupNotifier> entry = iterator.next();
			if(editpolicy.equals(entry.getValue())) {
				iterator.remove();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public ICommand notifyGroupFramework(IGroupRequest request) {
		if(DebugUtils.isDebugging()) {
			log.debug("***********************BEGIN : Group Request Advisor***********************************");
		}
		/******************
		 * Handling parent
		 ******************/
		CompositeCommand cc = new CompositeCommand("Global command from GroupRequestAdvisor");
		/*
		 * All parent
		 */
		fillRequestWithAllPossibleParent(request);
		fillRequestWithAllPossibleChildren(request);


		Object elementAdapter = request.getTargetElement().getAdapter(EObject.class);
		if(elementAdapter instanceof EObject) {
			/**
			 * Handle children
			 */
			handleSemanticChildren(request, cc, (EObject)elementAdapter);
			/*
			 * Semantic of all the parent
			 */
			handleSemanticParents(request, cc, (EObject)elementAdapter);
		}

		if(DebugUtils.isDebugging()) {
			log.debug("***********************END : Group Request Advisor***********************************");
		}
		/*
		 * For all new child send request
		 * For all GrChild create new request from old one and use dispatcher
		 */
		if(cc != null && !cc.isEmpty()) {
			return cc;
		}
		return null;
	}
	/**
	 * 
	 * @param request
	 * @param cc
	 * @param targetElement
	 */
	protected void handleSemanticChildren(IGroupRequest request, CompositeCommand cc, EObject targetElement) {
		List<EObject> graphicalChildren = handleGraphicalChildren(request, cc);
		/*
		 * Unset
		 */
		for(Entry<EReference, EObject> oldChildrenEntry : Utils.getOldChildren(request).entries()) {
			Multimap<EReference, EObject> allActualChildren = request.getChildrenEReferenceMap();
			EReference ref = oldChildrenEntry.getKey();
			if(ref != null) {
				if(!allActualChildren.containsEntry(oldChildrenEntry.getValue(), ref)) {
					EReference eOpposite = ref.getEOpposite();
					if(!graphicalChildren.contains(oldChildrenEntry.getValue())) {
						if(eOpposite != null && !eOpposite.isContainment()) {
							RemoveValueRequest rmVa = new RemoveValueRequest(targetElement, ref, Collections.singletonList(oldChildrenEntry.getValue()));
							RemoveValueCommand rmCmd = new RemoveValueCommand(rmVa);
							if(rmCmd != null) {
								cc.compose(rmCmd);
							}
						}						
					}
						
				}
			}
		}
		/*
		 * Set semantic
		 */
		for(Entry<EReference, EObject> entry : request.getChildrenEReferenceMap().entries()) {
			EReference ref = entry.getKey();
			if(ref != null) {
				EReference eOpposite = ref.getEOpposite();
				/*
				 * If the Eobject has not been already handle as grahical children
				 */
				if(!graphicalChildren.contains(entry.getValue())) {
					if(eOpposite != null && !eOpposite.isContainment()) {
						SetDeferredRequest setRq = new SetDeferredRequest(request.getHostRequest().getEditingDomain(), request.getTargetElement(), ref, entry.getValue());
						DeferredSetValueCommand setCmd = new DeferredSetValueCommand(setRq);
						if(setCmd != null) {
							cc.compose(setCmd);
						}
					}
				}
			}
		}
	}
	/**
	 * Handle graphical children
	 * @param request {@link IGroupRequest}
	 * @param cc {@link CompositeCommand} to compose new commands
	 * @return The list of all graphical children already handled
	 */
	protected List<EObject> handleGraphicalChildren(IGroupRequest request, CompositeCommand cc) {
		/*
		 * List of all the graphical children
		 */
		List<EObject> graphicalChildren = new ArrayList<EObject>();
		/*
		 * Handle graphical children
		 */
		//Get graphical children
		Object targetEditPart = request.getTargetElement().getAdapter(IGraphicalEditPart.class);
		IGraphicalEditPart compartementEditPart = null;
		if(targetEditPart instanceof IGroupCompartmentEditPart) {
			compartementEditPart = ((IGraphicalEditPart)targetEditPart);
		} else if(targetEditPart instanceof IGraphicalEditPart) {
			compartementEditPart = request.getNodeDescpitor().getCompartmentPartFromView((IGraphicalEditPart)targetEditPart);

		}
		if(compartementEditPart != null) {
			/*
			 * Transform an IGraphicalEditPart to the related GroupNotifyingEditPolicy
			 */
			@SuppressWarnings("unchecked")
			Iterable<GroupNotifyingEditPolicy> policies = Iterables.transform(compartementEditPart.getChildren(), new Function<IGraphicalEditPart, GroupNotifyingEditPolicy>() {

				public GroupNotifyingEditPolicy apply(IGraphicalEditPart from) {
					EditPolicy editPolicy = from.getEditPolicy(IGroupEditPolicies.GROUP_FRAMEWORK_NOTIFYING_EDIT_POLICY);
					if(editPolicy instanceof GroupNotifyingEditPolicy) {
						return (GroupNotifyingEditPolicy)editPolicy;
					}
					return null;
				}
			});
			for(final GroupNotifyingEditPolicy p : policies) {
				if(DebugUtils.isDebugging()) {

					StringBuilder stringBuilder = new StringBuilder();
					stringBuilder.append("+++ Work for child ");
					stringBuilder.append(Utils.getCorrectLabel(p.getEObject()));
					stringBuilder.append(" +++");
					DebugUtils.getLog().debug(stringBuilder.toString());
				}
				ChangeBoundsRequest auxChReq = Utils.getChangeBoundsRequestCopy((ChangeBoundsRequest)request.getInitialRequest(), p.getHostEditPart());
				/*
				 * Save graphical parent
				 */
				auxChReq.getExtendedData().put(GROUP_FRAMEWORK_GRAPHICAL_PARENT, compartementEditPart.resolveSemanticElement());

				graphicalChildren.add(p.getEObject());
				Command childCommand = p.getCommand(auxChReq);
				if(childCommand != null && childCommand.canExecute()) {
					cc.compose(new CommandProxy(childCommand));
				}

			}
		}
		return graphicalChildren;
	}

	/**
	 * Set and Unset semantic relation with parents
	 * 
	 * @param request
	 *        {@link IGroupRequest}
	 * @param cc
	 *        {@link CompositeCommand} to compose command
	 * @param elementAdapter
	 */
	protected void handleSemanticParents(IGroupRequest request, CompositeCommand cc, Object elementAdapter) {
		EObject targetElement = (EObject)elementAdapter;
		for(Entry<EReference, EObject> entry : Utils.getOldParents(request).entries()) {
			Multimap<EReference, EObject> allActualParent = request.getParentEReferenceMap();
			EReference ref = entry.getKey();
			if(ref != null) {
				if(!allActualParent.containsEntry(entry.getValue(), ref)) {
					EReference eOpposite = ref.getEOpposite();
					if(eOpposite != null && !eOpposite.isContainment()) {
						RemoveValueRequest rmVa = new RemoveValueRequest(targetElement, ref, Collections.singletonList(entry.getValue()));
						RemoveValueCommand rmCmd = new RemoveValueCommand(rmVa);
						if(rmCmd != null) {
							cc.compose(rmCmd);
						}
					}
				}
			}
		}
		/*
		 * Set semantic
		 */
		for(Entry<EReference, EObject> entry : request.getParentEReferenceMap().entries()) {
			EReference ref = entry.getKey();
			if(ref != null) {
				EReference eOpposite = ref.getEOpposite();
				if(eOpposite != null && !eOpposite.isContainment()) {
					SetDeferredRequest setRq = new SetDeferredRequest(request.getHostRequest().getEditingDomain(), request.getTargetElement(), ref, entry.getValue());
					DeferredSetValueCommand setCmd = new DeferredSetValueCommand(setRq);
					if(setCmd != null) {
						cc.compose(setCmd);
					}
				}
			}
		}
	}




	/**
	 * Return a list of all IGroupRequestListenner which can be children of the target of the request
	 * 
	 * @param request
	 * @return
	 */
	protected Multimap<EReference, IGroupNotifier> fillRequestWithAllPossibleChildren(IGroupRequest request) {
		final Rectangle newBounds = getInitalTargetRequestNewBounds(request);
		final List<EReference> references = request.getNodeDescpitor().getChildrenReferences();
		Multimap<EReference, EObject> childrenEReferenceMap = ArrayListMultimap.create();
		Multimap<EReference, IGroupNotifier> result = ArrayListMultimap.create();
		getReferenceElements(request, newBounds, references, childrenEReferenceMap, result, false);
		/*
		 * Filter descendant model
		 */
		for(EReference ref : childrenEReferenceMap.keySet()) {
			Collection<EObject> filteredCollection = Collections2.filter(childrenEReferenceMap.get(ref), new DescendantsFilter(childrenEReferenceMap.get(ref)));
			request.getChildrenEReferenceMap().putAll(ref, filteredCollection);
		}

		/**
		 * TODO filter graphical parent which currently moving
		 * I1 in ActPart1
		 * ActPart1 move into ActPart2
		 * I1 should only reference ActPart1
		 */
		/*
		 * Debug
		 */
		DebugUtils.displayMultipmapDebug(CHILDREN_REFERENCES_ARE, request.getChildrenEReferenceMap());
		return result;
	}

	/**
	 * Get all the element in references which are included or include (depending of the parameter include)
	 * 
	 * @param request
	 *        {@link IGroupRequest}
	 * @param newBounds
	 *        New bounds of the elements
	 * @param references
	 *        All references to take into account
	 * @param eReferenceMapToFillInRequest
	 *        Map in the request to fill
	 * @param result
	 *        {@link Map} which link a {@link EReference} to a {@link IGroupNotifier}
	 */
	protected void getReferenceElements(IGroupRequest request, final Rectangle newBounds, final List<EReference> references, Multimap<EReference, EObject> eReferenceMapToFillInRequest, Multimap<EReference, IGroupNotifier> result, boolean include) {
		for(IGroupNotifier input : listenners.values()) {
			EObject inputEObject = input.getEObject();
			if(inputEObject == null) {
				continue;
			}
			Object adapter = request.getTargetElement().getAdapter(EObject.class);
			EObject targetElement = null;
			if(adapter instanceof EObject) {
				targetElement = (EObject)adapter;
			}
			if(targetElement == null || inputEObject.equals(adapter)) {
				continue;
			}


			EReference refenceFounded = null;
			for(EReference ref : references) {
				EClass refType = ref.getEReferenceType();
				EClass eoBjectType = inputEObject.eClass();
				if(refType.isSuperTypeOf(eoBjectType)) {
					refenceFounded = ref;

				}
			}
			if(refenceFounded != null && input.isIncludedIn(newBounds)) {
				if((include && input.includes(newBounds)) || (!include && input.isIncludedIn(newBounds))) {
					eReferenceMapToFillInRequest.put(refenceFounded, inputEObject);
					result.put(refenceFounded, input);
				}
			}

		}
	}


	/**
	 * Return the list of all {@link IGroupNotifier} which can be parent of the target of the request
	 * 
	 * @param request
	 * @return
	 */
	protected Multimap<EObject, IGroupNotifier> fillRequestWithAllPossibleParent(IGroupRequest request) {
		final Rectangle newBounds = getInitalTargetRequestNewBounds(request);
		final List<EReference> references = request.getNodeDescpitor().getParentReferences();
		final Multimap<EObject, IGroupNotifier> result = ArrayListMultimap.create();
		final Multimap<EReference, EObject> parentEReferenceMap = ArrayListMultimap.create();
		for(IGroupNotifier input : listenners.values()) {
			EObject inputEObject = input.getEObject();
			if(inputEObject == null) {
				continue;
			}
			Object adapter = request.getTargetElement().getAdapter(EObject.class);
			EObject targetElement = null;
			if(adapter instanceof EObject) {
				targetElement = (EObject)adapter;
			}
			if(targetElement == null || inputEObject.equals(adapter)) {
				continue;
			}
			EReference referenceFound = null;
			for(EReference ref : references) {
				EClass refType = ref.getEReferenceType();
				EClass eoBjectType = inputEObject.eClass();
				if(refType.isSuperTypeOf(eoBjectType)) {
					referenceFound = ref;
					break;
				}
			}
			if(referenceFound != null && input.includes(newBounds)) {
				parentEReferenceMap.put(referenceFound, inputEObject);
				result.put(inputEObject, input);

			}
		}
		/*
		 * Filter ancestors
		 */
		for(EReference ref : parentEReferenceMap.keySet()) {
			/*
			 * Filter descendant
			 * Example :
			 * 1 - ActPart1 include in Act1 then Act1 disappear
			 * 2 - ActPart1 include in ActPart2 then ActPart1 disappear
			 */
			Collection<EObject> filteredCollection = Collections2.filter(parentEReferenceMap.get(ref), new DescendantsFilter(parentEReferenceMap.values()));
			request.getParentEReferenceMap().putAll(ref, filteredCollection);
		}

		/*
		 * Debug
		 */
		DebugUtils.displayMultipmapDebug(ALL_PARENT_REFERENCES_ARE, request.getParentEReferenceMap());
		return result;
	}



	/**
	 * Get the absolute bounds of the target of the request
	 * 
	 * @param request
	 * @return
	 */
	public static Rectangle getInitalTargetRequestNewBounds(final IGroupRequest request) {
		return Utils.getAbslotueRequestBounds((ChangeBoundsRequest)request.getInitialRequest(), request.getHostRequest());
	}




}
