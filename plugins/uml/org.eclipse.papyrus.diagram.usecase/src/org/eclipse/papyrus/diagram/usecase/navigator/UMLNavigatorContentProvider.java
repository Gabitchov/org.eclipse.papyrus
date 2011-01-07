/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.usecase.navigator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.emf.core.GMFEditingDomainFactory;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.diagram.usecase.edit.parts.AbstractionEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ActorAsRectangleEditPartTN;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ActorEditPartTN;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ActorInComponentEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ActorInPackageEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.AssociationEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.CommentEditPartCN;
import org.eclipse.papyrus.diagram.usecase.edit.parts.CommentEditPartTN;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ComponentEditPartTN;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ComponentInComponentEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ComponentInPackageEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ComponentUsecases2EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ComponentUsecases3EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ComponentUsecasesEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ConstraintConstrainedElementEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ConstraintEditPartTN;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ConstraintInComponentEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ConstraintInPackageEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.DependencyEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ExtendEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ExtensionPointEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ExtensionPointInRectangleEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.GeneralizationEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.IncludeEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.PackageEditPartCN;
import org.eclipse.papyrus.diagram.usecase.edit.parts.PackageEditPartTN;
import org.eclipse.papyrus.diagram.usecase.edit.parts.PackageImportEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.PackageMergeEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.PackagePackageableElementCompartment2EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.PackagePackageableElementCompartmentEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.RealizationEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UsageEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCaseAsRectangleEditPartTN;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCaseDiagramEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCaseEditPartTN;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCaseInComponentEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCaseInPackageEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCasePointsEditPartTN;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCasePointsInComponentEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCasePointsInPackageEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCasePointsInRectangleEditPart;
import org.eclipse.papyrus.diagram.usecase.part.Messages;
import org.eclipse.papyrus.diagram.usecase.part.UMLVisualIDRegistry;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonContentProvider;

/**
 * @generated
 */
public class UMLNavigatorContentProvider implements ICommonContentProvider {

	/**
	 * @generated
	 */
	private static final Object[] EMPTY_ARRAY = new Object[0];

	/**
	 * @generated
	 */
	private Viewer myViewer;

	/**
	 * @generated
	 */
	private AdapterFactoryEditingDomain myEditingDomain;

	/**
	 * @generated
	 */
	private WorkspaceSynchronizer myWorkspaceSynchronizer;

	/**
	 * @generated
	 */
	private Runnable myViewerRefreshRunnable;

	/**
	 * @generated
	 */
	@SuppressWarnings({ "unchecked", "serial", "rawtypes" })
	public UMLNavigatorContentProvider() {
		TransactionalEditingDomain editingDomain = GMFEditingDomainFactory.INSTANCE.createEditingDomain();
		myEditingDomain = (AdapterFactoryEditingDomain)editingDomain;
		myEditingDomain.setResourceToReadOnlyMap(new HashMap() {

			public Object get(Object key) {
				if(!containsKey(key)) {
					put(key, Boolean.TRUE);
				}
				return super.get(key);
			}
		});
		myViewerRefreshRunnable = new Runnable() {

			public void run() {
				if(myViewer != null) {
					myViewer.refresh();
				}
			}
		};
		myWorkspaceSynchronizer = new WorkspaceSynchronizer(editingDomain, new WorkspaceSynchronizer.Delegate() {

			public void dispose() {
			}

			public boolean handleResourceChanged(final Resource resource) {
				for(Iterator it = myEditingDomain.getResourceSet().getResources().iterator(); it.hasNext();) {
					Resource nextResource = (Resource)it.next();
					nextResource.unload();
				}
				if(myViewer != null) {
					myViewer.getControl().getDisplay().asyncExec(myViewerRefreshRunnable);
				}
				return true;
			}

			public boolean handleResourceDeleted(Resource resource) {
				for(Iterator it = myEditingDomain.getResourceSet().getResources().iterator(); it.hasNext();) {
					Resource nextResource = (Resource)it.next();
					nextResource.unload();
				}
				if(myViewer != null) {
					myViewer.getControl().getDisplay().asyncExec(myViewerRefreshRunnable);
				}
				return true;
			}

			public boolean handleResourceMoved(Resource resource, final URI newURI) {
				for(Iterator it = myEditingDomain.getResourceSet().getResources().iterator(); it.hasNext();) {
					Resource nextResource = (Resource)it.next();
					nextResource.unload();
				}
				if(myViewer != null) {
					myViewer.getControl().getDisplay().asyncExec(myViewerRefreshRunnable);
				}
				return true;
			}
		});
	}

	/**
	 * 
	 * Papyrus Template this method is a modification of gmf code in order to avoid
	 * getViewChidreen() method becoming greater than 64kb.
	 * 
	 * @generated
	 **/
	private Object[] getViewChildrenForUseCaseDiagramEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup links = new UMLNavigatorGroup(Messages.NavigatorGroupName_Package_1000_links, "icons/linksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActorEditPartTN.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActorAsRectangleEditPartTN.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UseCaseEditPartTN.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UseCaseAsRectangleEditPartTN.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ComponentEditPartTN.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PackageEditPartTN.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintEditPartTN.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentEditPartTN.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getDiagramLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(IncludeEditPart.VISUAL_ID));
		links.addChildren(createNavigatorItems(connectedViews, links, false));
		connectedViews = getDiagramLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExtendEditPart.VISUAL_ID));
		links.addChildren(createNavigatorItems(connectedViews, links, false));
		connectedViews = getDiagramLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(GeneralizationEditPart.VISUAL_ID));
		links.addChildren(createNavigatorItems(connectedViews, links, false));
		connectedViews = getDiagramLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AssociationEditPart.VISUAL_ID));
		links.addChildren(createNavigatorItems(connectedViews, links, false));
		connectedViews = getDiagramLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintConstrainedElementEditPart.VISUAL_ID));
		links.addChildren(createNavigatorItems(connectedViews, links, false));
		connectedViews = getDiagramLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
		links.addChildren(createNavigatorItems(connectedViews, links, false));
		connectedViews = getDiagramLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
		links.addChildren(createNavigatorItems(connectedViews, links, false));
		connectedViews = getDiagramLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AbstractionEditPart.VISUAL_ID));
		links.addChildren(createNavigatorItems(connectedViews, links, false));
		connectedViews = getDiagramLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UsageEditPart.VISUAL_ID));
		links.addChildren(createNavigatorItems(connectedViews, links, false));
		connectedViews = getDiagramLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(RealizationEditPart.VISUAL_ID));
		links.addChildren(createNavigatorItems(connectedViews, links, false));
		connectedViews = getDiagramLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PackageMergeEditPart.VISUAL_ID));
		links.addChildren(createNavigatorItems(connectedViews, links, false));
		connectedViews = getDiagramLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PackageImportEditPart.VISUAL_ID));
		links.addChildren(createNavigatorItems(connectedViews, links, false));
		if(!links.isEmpty()) {
			result.add(links);
		}
		return result.toArray();
	}

	/**
	 * 
	 * Papyrus Template
	 * this method is a modification of gmf code in order to avoid getViewChidreen() method becoming greater than 64kb.
	 * 
	 * @generated
	 **/
	private Object[] getViewChildrenForActorEditPartTN(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Actor_2011_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Actor_2011_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(GeneralizationEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(GeneralizationEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AssociationEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AssociationEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintConstrainedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AbstractionEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AbstractionEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UsageEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UsageEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(RealizationEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(RealizationEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PackageImportEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		if(!incominglinks.isEmpty()) {
			result.add(incominglinks);
		}
		if(!outgoinglinks.isEmpty()) {
			result.add(outgoinglinks);
		}
		return result.toArray();
	}

	/**
	 * 
	 * Papyrus Template
	 * this method is a modification of gmf code in order to avoid getViewChidreen() method becoming greater than 64kb.
	 * 
	 * @generated
	 **/
	private Object[] getViewChildrenForActorAsRectangleEditPartTN(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Actor_2012_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Actor_2012_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(GeneralizationEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(GeneralizationEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AssociationEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AssociationEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintConstrainedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AbstractionEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AbstractionEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UsageEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UsageEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(RealizationEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(RealizationEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PackageImportEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		if(!incominglinks.isEmpty()) {
			result.add(incominglinks);
		}
		if(!outgoinglinks.isEmpty()) {
			result.add(outgoinglinks);
		}
		return result.toArray();
	}

	/**
	 * 
	 * Papyrus Template
	 * this method is a modification of gmf code in order to avoid getViewChidreen() method becoming greater than 64kb.
	 * 
	 * @generated
	 **/
	private Object[] getViewChildrenForUseCaseEditPartTN(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_UseCase_2013_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_UseCase_2013_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UseCasePointsEditPartTN.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(ExtensionPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(IncludeEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(IncludeEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExtendEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExtendEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(GeneralizationEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(GeneralizationEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AssociationEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AssociationEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintConstrainedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AbstractionEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AbstractionEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UsageEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UsageEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(RealizationEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(RealizationEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PackageImportEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		if(!incominglinks.isEmpty()) {
			result.add(incominglinks);
		}
		if(!outgoinglinks.isEmpty()) {
			result.add(outgoinglinks);
		}
		return result.toArray();
	}

	/**
	 * 
	 * Papyrus Template
	 * this method is a modification of gmf code in order to avoid getViewChidreen() method becoming greater than 64kb.
	 * 
	 * @generated
	 **/
	private Object[] getViewChildrenForUseCaseAsRectangleEditPartTN(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_UseCase_2014_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_UseCase_2014_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UseCasePointsInRectangleEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(ExtensionPointInRectangleEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(IncludeEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(IncludeEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExtendEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExtendEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(GeneralizationEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(GeneralizationEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AssociationEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AssociationEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintConstrainedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AbstractionEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AbstractionEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UsageEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UsageEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(RealizationEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(RealizationEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PackageImportEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		if(!incominglinks.isEmpty()) {
			result.add(incominglinks);
		}
		if(!outgoinglinks.isEmpty()) {
			result.add(outgoinglinks);
		}
		return result.toArray();
	}

	/**
	 * 
	 * Papyrus Template
	 * this method is a modification of gmf code in order to avoid getViewChidreen() method becoming greater than 64kb.
	 * 
	 * @generated
	 **/
	private Object[] getViewChildrenForComponentEditPartTN(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Component_2015_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Component_2015_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ComponentUsecasesEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(UseCaseInComponentEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ComponentUsecasesEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(ComponentInComponentEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ComponentUsecasesEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(CommentEditPartCN.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ComponentUsecasesEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(ConstraintInComponentEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ComponentUsecasesEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(ActorInComponentEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(GeneralizationEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(GeneralizationEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AssociationEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AssociationEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintConstrainedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AbstractionEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AbstractionEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UsageEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UsageEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(RealizationEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(RealizationEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PackageImportEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		if(!incominglinks.isEmpty()) {
			result.add(incominglinks);
		}
		if(!outgoinglinks.isEmpty()) {
			result.add(outgoinglinks);
		}
		return result.toArray();
	}

	/**
	 * 
	 * Papyrus Template this method is a modification of gmf code in order to avoid
	 * getViewChidreen() method becoming greater than 64kb.
	 * 
	 * @generated
	 **/
	private Object[] getViewChildrenForPackageEditPartTN(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Package_2016_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Package_2016_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PackagePackageableElementCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(ConstraintInPackageEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PackagePackageableElementCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(ActorInPackageEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PackagePackageableElementCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(UseCaseInPackageEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PackagePackageableElementCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(ComponentInPackageEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PackagePackageableElementCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(PackageEditPartCN.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PackagePackageableElementCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(CommentEditPartCN.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintConstrainedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AbstractionEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AbstractionEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UsageEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UsageEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(RealizationEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(RealizationEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PackageMergeEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PackageMergeEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PackageImportEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PackageImportEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		if(!incominglinks.isEmpty()) {
			result.add(incominglinks);
		}
		if(!outgoinglinks.isEmpty()) {
			result.add(outgoinglinks);
		}
		return result.toArray();
	}

	/**
	 * 
	 * Papyrus Template
	 * this method is a modification of gmf code in order to avoid getViewChidreen() method becoming greater than 64kb.
	 * 
	 * @generated
	 **/
	private Object[] getViewChildrenForConstraintEditPartTN(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Constraint_2017_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Constraint_2017_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintConstrainedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintConstrainedElementEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AbstractionEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AbstractionEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UsageEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UsageEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(RealizationEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(RealizationEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		if(!incominglinks.isEmpty()) {
			result.add(incominglinks);
		}
		if(!outgoinglinks.isEmpty()) {
			result.add(outgoinglinks);
		}
		return result.toArray();
	}

	/**
	 * 
	 * Papyrus Template
	 * this method is a modification of gmf code in order to avoid getViewChidreen() method becoming greater than 64kb.
	 * 
	 * @generated
	 **/
	private Object[] getViewChildrenForCommentEditPartTN(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Comment_2018_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Comment_2018_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintConstrainedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		if(!incominglinks.isEmpty()) {
			result.add(incominglinks);
		}
		if(!outgoinglinks.isEmpty()) {
			result.add(outgoinglinks);
		}
		return result.toArray();
	}

	/**
	 * 
	 * Papyrus Template this method is a modification of gmf code in order to avoid
	 * getViewChidreen() method becoming greater than 64kb.
	 * 
	 * @generated
	 **/
	private Object[] getViewChildrenForExtensionPointEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_ExtensionPoint_3007_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_ExtensionPoint_3007_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintConstrainedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AbstractionEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AbstractionEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UsageEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UsageEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(RealizationEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(RealizationEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		if(!incominglinks.isEmpty()) {
			result.add(incominglinks);
		}
		if(!outgoinglinks.isEmpty()) {
			result.add(outgoinglinks);
		}
		return result.toArray();
	}

	/**
	 * 
	 * Papyrus Template
	 * this method is a modification of gmf code in order to avoid getViewChidreen() method becoming greater than 64kb.
	 * 
	 * @generated
	 **/
	private Object[] getViewChildrenForExtensionPointInRectangleEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_ExtensionPoint_3008_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_ExtensionPoint_3008_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintConstrainedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AbstractionEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AbstractionEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UsageEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UsageEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(RealizationEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(RealizationEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		if(!incominglinks.isEmpty()) {
			result.add(incominglinks);
		}
		if(!outgoinglinks.isEmpty()) {
			result.add(outgoinglinks);
		}
		return result.toArray();
	}

	/**
	 * 
	 * Papyrus Template
	 * this method is a modification of gmf code in order to avoid getViewChidreen() method becoming greater than 64kb.
	 * 
	 * @generated
	 **/
	private Object[] getViewChildrenForUseCaseInComponentEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_UseCase_3009_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_UseCase_3009_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UseCasePointsInComponentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(ExtensionPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(IncludeEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(IncludeEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExtendEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExtendEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(GeneralizationEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(GeneralizationEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AssociationEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AssociationEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintConstrainedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AbstractionEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AbstractionEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UsageEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UsageEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(RealizationEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(RealizationEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PackageImportEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		if(!incominglinks.isEmpty()) {
			result.add(incominglinks);
		}
		if(!outgoinglinks.isEmpty()) {
			result.add(outgoinglinks);
		}
		return result.toArray();
	}

	/**
	 * 
	 * Papyrus Template
	 * this method is a modification of gmf code in order to avoid getViewChidreen() method becoming greater than 64kb.
	 * 
	 * @generated
	 **/
	private Object[] getViewChildrenForComponentInComponentEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Component_3016_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Component_3016_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ComponentUsecases2EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(UseCaseInComponentEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ComponentUsecases2EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(ComponentInComponentEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ComponentUsecases2EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(CommentEditPartCN.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ComponentUsecases2EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(ConstraintInComponentEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ComponentUsecases2EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(ActorInComponentEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(GeneralizationEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(GeneralizationEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AssociationEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AssociationEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintConstrainedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AbstractionEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AbstractionEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UsageEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UsageEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(RealizationEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(RealizationEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PackageImportEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		if(!incominglinks.isEmpty()) {
			result.add(incominglinks);
		}
		if(!outgoinglinks.isEmpty()) {
			result.add(outgoinglinks);
		}
		return result.toArray();
	}

	/**
	 * 
	 * Papyrus Template
	 * this method is a modification of gmf code in order to avoid getViewChidreen() method becoming greater than 64kb.
	 * 
	 * @generated
	 **/
	private Object[] getViewChildrenForCommentEditPartCN(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Comment_3015_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Comment_3015_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintConstrainedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		if(!incominglinks.isEmpty()) {
			result.add(incominglinks);
		}
		if(!outgoinglinks.isEmpty()) {
			result.add(outgoinglinks);
		}
		return result.toArray();
	}

	/**
	 * 
	 * Papyrus Template
	 * this method is a modification of gmf code in order to avoid getViewChidreen() method becoming greater than 64kb.
	 * 
	 * @generated
	 **/
	private Object[] getViewChildrenForConstraintInComponentEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Constraint_3017_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Constraint_3017_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintConstrainedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintConstrainedElementEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AbstractionEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AbstractionEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UsageEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UsageEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(RealizationEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(RealizationEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		if(!incominglinks.isEmpty()) {
			result.add(incominglinks);
		}
		if(!outgoinglinks.isEmpty()) {
			result.add(outgoinglinks);
		}
		return result.toArray();
	}

	/**
	 * 
	 * Papyrus Template
	 * this method is a modification of gmf code in order to avoid getViewChidreen() method becoming greater than 64kb.
	 * 
	 * @generated
	 **/
	private Object[] getViewChildrenForActorInComponentEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Actor_3018_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Actor_3018_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(GeneralizationEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(GeneralizationEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AssociationEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AssociationEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintConstrainedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AbstractionEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AbstractionEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UsageEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UsageEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(RealizationEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(RealizationEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PackageImportEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		if(!incominglinks.isEmpty()) {
			result.add(incominglinks);
		}
		if(!outgoinglinks.isEmpty()) {
			result.add(outgoinglinks);
		}
		return result.toArray();
	}

	/**
	 * 
	 * Papyrus Template
	 * this method is a modification of gmf code in order to avoid getViewChidreen() method becoming greater than 64kb.
	 * 
	 * @generated
	 **/
	private Object[] getViewChildrenForConstraintInPackageEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Constraint_3010_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Constraint_3010_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintConstrainedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintConstrainedElementEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AbstractionEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AbstractionEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UsageEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UsageEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(RealizationEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(RealizationEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		if(!incominglinks.isEmpty()) {
			result.add(incominglinks);
		}
		if(!outgoinglinks.isEmpty()) {
			result.add(outgoinglinks);
		}
		return result.toArray();
	}

	/**
	 * 
	 * Papyrus Template
	 * this method is a modification of gmf code in order to avoid getViewChidreen() method becoming greater than 64kb.
	 * 
	 * @generated
	 **/
	private Object[] getViewChildrenForActorInPackageEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Actor_3011_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Actor_3011_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(GeneralizationEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(GeneralizationEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AssociationEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AssociationEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintConstrainedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AbstractionEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AbstractionEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UsageEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UsageEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(RealizationEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(RealizationEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PackageImportEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		if(!incominglinks.isEmpty()) {
			result.add(incominglinks);
		}
		if(!outgoinglinks.isEmpty()) {
			result.add(outgoinglinks);
		}
		return result.toArray();
	}

	/**
	 * 
	 * Papyrus Template
	 * this method is a modification of gmf code in order to avoid getViewChidreen() method becoming greater than 64kb.
	 * 
	 * @generated
	 **/
	private Object[] getViewChildrenForUseCaseInPackageEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_UseCase_3012_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_UseCase_3012_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UseCasePointsInPackageEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(ExtensionPointEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(IncludeEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(IncludeEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExtendEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExtendEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(GeneralizationEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(GeneralizationEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AssociationEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AssociationEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintConstrainedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AbstractionEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AbstractionEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UsageEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UsageEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(RealizationEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(RealizationEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PackageImportEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		if(!incominglinks.isEmpty()) {
			result.add(incominglinks);
		}
		if(!outgoinglinks.isEmpty()) {
			result.add(outgoinglinks);
		}
		return result.toArray();
	}

	/**
	 * 
	 * Papyrus Template
	 * this method is a modification of gmf code in order to avoid getViewChidreen() method becoming greater than 64kb.
	 * 
	 * @generated
	 **/
	private Object[] getViewChildrenForComponentInPackageEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Component_3013_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Component_3013_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ComponentUsecases3EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(UseCaseInComponentEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ComponentUsecases3EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(ComponentInComponentEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ComponentUsecases3EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(CommentEditPartCN.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ComponentUsecases3EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(ConstraintInComponentEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ComponentUsecases3EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(ActorInComponentEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(GeneralizationEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(GeneralizationEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AssociationEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AssociationEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintConstrainedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AbstractionEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AbstractionEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UsageEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UsageEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(RealizationEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(RealizationEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PackageImportEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		if(!incominglinks.isEmpty()) {
			result.add(incominglinks);
		}
		if(!outgoinglinks.isEmpty()) {
			result.add(outgoinglinks);
		}
		return result.toArray();
	}

	/**
	 * 
	 * Papyrus Template this method is a modification of gmf code in order to avoid
	 * getViewChidreen() method becoming greater than 64kb.
	 * 
	 * @generated
	 **/
	private Object[] getViewChildrenForPackageEditPartCN(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Package_3014_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_Package_3014_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PackagePackageableElementCompartment2EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(ConstraintInPackageEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PackagePackageableElementCompartment2EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(ActorInPackageEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PackagePackageableElementCompartment2EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(UseCaseInPackageEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PackagePackageableElementCompartment2EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(ComponentInPackageEditPart.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PackagePackageableElementCompartment2EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(PackageEditPartCN.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getChildrenByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PackagePackageableElementCompartment2EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry.getType(CommentEditPartCN.VISUAL_ID));
		result.addAll(createNavigatorItems(connectedViews, parentElement, false));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintConstrainedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AbstractionEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(AbstractionEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UsageEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UsageEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(RealizationEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(RealizationEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PackageMergeEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PackageMergeEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PackageImportEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PackageImportEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
		if(!incominglinks.isEmpty()) {
			result.add(incominglinks);
		}
		if(!outgoinglinks.isEmpty()) {
			result.add(outgoinglinks);
		}
		return result.toArray();
	}

	/**
	 * 
	 * Papyrus Template this method is a modification of gmf code in order to avoid
	 * getViewChidreen() method becoming greater than 64kb.
	 * 
	 * @generated
	 **/
	private Object[] getViewChildrenForIncludeEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup target = new UMLNavigatorGroup(Messages.NavigatorGroupName_Include_4008_target, "icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup source = new UMLNavigatorGroup(Messages.NavigatorGroupName_Include_4008_source, "icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UseCaseEditPartTN.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UseCaseAsRectangleEditPartTN.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UseCaseInComponentEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UseCaseInPackageEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UseCaseEditPartTN.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UseCaseAsRectangleEditPartTN.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UseCaseInComponentEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UseCaseInPackageEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		if(!target.isEmpty()) {
			result.add(target);
		}
		if(!source.isEmpty()) {
			result.add(source);
		}
		return result.toArray();
	}

	/**
	 * 
	 * Papyrus Template this method is a modification of gmf code in order to avoid
	 * getViewChidreen() method becoming greater than 64kb.
	 * 
	 * @generated
	 **/
	private Object[] getViewChildrenForExtendEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup target = new UMLNavigatorGroup(Messages.NavigatorGroupName_Extend_4009_target, "icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup source = new UMLNavigatorGroup(Messages.NavigatorGroupName_Extend_4009_source, "icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UseCaseEditPartTN.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UseCaseAsRectangleEditPartTN.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UseCaseInComponentEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UseCaseInPackageEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UseCaseEditPartTN.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UseCaseAsRectangleEditPartTN.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UseCaseInComponentEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UseCaseInPackageEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		if(!target.isEmpty()) {
			result.add(target);
		}
		if(!source.isEmpty()) {
			result.add(source);
		}
		return result.toArray();
	}

	/**
	 * 
	 * Papyrus Template this method is a modification of gmf code in order to avoid
	 * getViewChidreen() method becoming greater than 64kb.
	 * 
	 * @generated
	 **/
	private Object[] getViewChildrenForGeneralizationEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup target = new UMLNavigatorGroup(Messages.NavigatorGroupName_Generalization_4010_target, "icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup source = new UMLNavigatorGroup(Messages.NavigatorGroupName_Generalization_4010_source, "icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActorEditPartTN.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActorAsRectangleEditPartTN.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UseCaseEditPartTN.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UseCaseAsRectangleEditPartTN.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ComponentEditPartTN.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UseCaseInComponentEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ComponentInComponentEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActorInComponentEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActorInPackageEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UseCaseInPackageEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ComponentInPackageEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActorEditPartTN.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActorAsRectangleEditPartTN.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UseCaseEditPartTN.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UseCaseAsRectangleEditPartTN.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ComponentEditPartTN.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UseCaseInComponentEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ComponentInComponentEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActorInComponentEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActorInPackageEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UseCaseInPackageEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ComponentInPackageEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		if(!target.isEmpty()) {
			result.add(target);
		}
		if(!source.isEmpty()) {
			result.add(source);
		}
		return result.toArray();
	}

	/**
	 * 
	 * Papyrus Template this method is a modification of gmf code in order to avoid
	 * getViewChidreen() method becoming greater than 64kb.
	 * 
	 * @generated
	 **/
	private Object[] getViewChildrenForAssociationEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup target = new UMLNavigatorGroup(Messages.NavigatorGroupName_Association_4011_target, "icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup source = new UMLNavigatorGroup(Messages.NavigatorGroupName_Association_4011_source, "icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActorEditPartTN.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActorAsRectangleEditPartTN.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UseCaseEditPartTN.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UseCaseAsRectangleEditPartTN.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ComponentEditPartTN.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UseCaseInComponentEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ComponentInComponentEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActorInComponentEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActorInPackageEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UseCaseInPackageEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ComponentInPackageEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActorEditPartTN.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActorAsRectangleEditPartTN.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UseCaseEditPartTN.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UseCaseAsRectangleEditPartTN.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ComponentEditPartTN.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UseCaseInComponentEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ComponentInComponentEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActorInComponentEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActorInPackageEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UseCaseInPackageEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ComponentInPackageEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		if(!target.isEmpty()) {
			result.add(target);
		}
		if(!source.isEmpty()) {
			result.add(source);
		}
		return result.toArray();
	}

	/**
	 * 
	 * Papyrus Template this method is a modification of gmf code in order to avoid
	 * getViewChidreen() method becoming greater than 64kb.
	 * 
	 * @generated
	 **/
	private Object[] getViewChildrenForConstraintConstrainedElementEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup target = new UMLNavigatorGroup(Messages.NavigatorGroupName_ConstraintConstrainedElement_4012_target, "icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup source = new UMLNavigatorGroup(Messages.NavigatorGroupName_ConstraintConstrainedElement_4012_source, "icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActorEditPartTN.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActorAsRectangleEditPartTN.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UseCaseEditPartTN.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UseCaseAsRectangleEditPartTN.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ComponentEditPartTN.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PackageEditPartTN.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintEditPartTN.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentEditPartTN.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExtensionPointEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExtensionPointInRectangleEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UseCaseInComponentEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ComponentInComponentEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentEditPartCN.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintInComponentEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActorInComponentEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintInPackageEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActorInPackageEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UseCaseInPackageEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ComponentInPackageEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PackageEditPartCN.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintEditPartTN.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintInComponentEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintInPackageEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		if(!target.isEmpty()) {
			result.add(target);
		}
		if(!source.isEmpty()) {
			result.add(source);
		}
		return result.toArray();
	}

	/**
	 * 
	 * Papyrus Template this method is a modification of gmf code in order to avoid
	 * getViewChidreen() method becoming greater than 64kb.
	 * 
	 * @generated
	 **/
	private Object[] getViewChildrenForDependencyEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup target = new UMLNavigatorGroup(Messages.NavigatorGroupName_Dependency_4013_target, "icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup source = new UMLNavigatorGroup(Messages.NavigatorGroupName_Dependency_4013_source, "icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActorEditPartTN.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActorAsRectangleEditPartTN.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UseCaseEditPartTN.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UseCaseAsRectangleEditPartTN.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ComponentEditPartTN.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PackageEditPartTN.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintEditPartTN.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExtensionPointEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExtensionPointInRectangleEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UseCaseInComponentEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ComponentInComponentEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintInComponentEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActorInComponentEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintInPackageEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActorInPackageEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UseCaseInPackageEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ComponentInPackageEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PackageEditPartCN.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActorEditPartTN.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActorAsRectangleEditPartTN.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UseCaseEditPartTN.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UseCaseAsRectangleEditPartTN.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ComponentEditPartTN.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PackageEditPartTN.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintEditPartTN.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExtensionPointEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExtensionPointInRectangleEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UseCaseInComponentEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ComponentInComponentEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintInComponentEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActorInComponentEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintInPackageEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActorInPackageEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UseCaseInPackageEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ComponentInPackageEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PackageEditPartCN.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		if(!target.isEmpty()) {
			result.add(target);
		}
		if(!source.isEmpty()) {
			result.add(source);
		}
		return result.toArray();
	}

	/**
	 * 
	 * Papyrus Template this method is a modification of gmf code in order to avoid
	 * getViewChidreen() method becoming greater than 64kb.
	 * 
	 * @generated
	 **/
	private Object[] getViewChildrenForCommentAnnotatedElementEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup target = new UMLNavigatorGroup(Messages.NavigatorGroupName_CommentAnnotatedElement_4014_target, "icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup source = new UMLNavigatorGroup(Messages.NavigatorGroupName_CommentAnnotatedElement_4014_source, "icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActorEditPartTN.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActorAsRectangleEditPartTN.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UseCaseEditPartTN.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UseCaseAsRectangleEditPartTN.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ComponentEditPartTN.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PackageEditPartTN.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintEditPartTN.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentEditPartTN.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExtensionPointEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExtensionPointInRectangleEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UseCaseInComponentEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ComponentInComponentEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentEditPartCN.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintInComponentEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActorInComponentEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintInPackageEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActorInPackageEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UseCaseInPackageEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ComponentInPackageEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PackageEditPartCN.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentEditPartTN.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(CommentEditPartCN.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		if(!target.isEmpty()) {
			result.add(target);
		}
		if(!source.isEmpty()) {
			result.add(source);
		}
		return result.toArray();
	}

	/**
	 * 
	 * Papyrus Template this method is a modification of gmf code in order to avoid
	 * getViewChidreen() method becoming greater than 64kb.
	 * 
	 * @generated
	 **/
	private Object[] getViewChildrenForAbstractionEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup target = new UMLNavigatorGroup(Messages.NavigatorGroupName_Abstraction_4015_target, "icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup source = new UMLNavigatorGroup(Messages.NavigatorGroupName_Abstraction_4015_source, "icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActorEditPartTN.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActorAsRectangleEditPartTN.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UseCaseEditPartTN.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UseCaseAsRectangleEditPartTN.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ComponentEditPartTN.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PackageEditPartTN.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintEditPartTN.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExtensionPointEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExtensionPointInRectangleEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UseCaseInComponentEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ComponentInComponentEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintInComponentEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActorInComponentEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintInPackageEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActorInPackageEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UseCaseInPackageEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ComponentInPackageEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PackageEditPartCN.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActorEditPartTN.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActorAsRectangleEditPartTN.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UseCaseEditPartTN.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UseCaseAsRectangleEditPartTN.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ComponentEditPartTN.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PackageEditPartTN.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintEditPartTN.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExtensionPointEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExtensionPointInRectangleEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UseCaseInComponentEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ComponentInComponentEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintInComponentEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActorInComponentEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintInPackageEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActorInPackageEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UseCaseInPackageEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ComponentInPackageEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PackageEditPartCN.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		if(!target.isEmpty()) {
			result.add(target);
		}
		if(!source.isEmpty()) {
			result.add(source);
		}
		return result.toArray();
	}

	/**
	 * 
	 * Papyrus Template this method is a modification of gmf code in order to avoid
	 * getViewChidreen() method becoming greater than 64kb.
	 * 
	 * @generated
	 **/
	private Object[] getViewChildrenForUsageEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup target = new UMLNavigatorGroup(Messages.NavigatorGroupName_Usage_4016_target, "icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup source = new UMLNavigatorGroup(Messages.NavigatorGroupName_Usage_4016_source, "icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActorEditPartTN.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActorAsRectangleEditPartTN.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UseCaseEditPartTN.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UseCaseAsRectangleEditPartTN.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ComponentEditPartTN.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PackageEditPartTN.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintEditPartTN.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExtensionPointEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExtensionPointInRectangleEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UseCaseInComponentEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ComponentInComponentEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintInComponentEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActorInComponentEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintInPackageEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActorInPackageEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UseCaseInPackageEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ComponentInPackageEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PackageEditPartCN.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActorEditPartTN.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActorAsRectangleEditPartTN.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UseCaseEditPartTN.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UseCaseAsRectangleEditPartTN.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ComponentEditPartTN.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PackageEditPartTN.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintEditPartTN.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExtensionPointEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExtensionPointInRectangleEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UseCaseInComponentEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ComponentInComponentEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintInComponentEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActorInComponentEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintInPackageEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActorInPackageEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UseCaseInPackageEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ComponentInPackageEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PackageEditPartCN.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		if(!target.isEmpty()) {
			result.add(target);
		}
		if(!source.isEmpty()) {
			result.add(source);
		}
		return result.toArray();
	}

	/**
	 * 
	 * Papyrus Template this method is a modification of gmf code in order to avoid
	 * getViewChidreen() method becoming greater than 64kb.
	 * 
	 * @generated
	 **/
	private Object[] getViewChildrenForRealizationEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup target = new UMLNavigatorGroup(Messages.NavigatorGroupName_Realization_4017_target, "icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup source = new UMLNavigatorGroup(Messages.NavigatorGroupName_Realization_4017_source, "icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActorEditPartTN.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActorAsRectangleEditPartTN.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UseCaseEditPartTN.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UseCaseAsRectangleEditPartTN.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ComponentEditPartTN.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PackageEditPartTN.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintEditPartTN.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExtensionPointEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExtensionPointInRectangleEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UseCaseInComponentEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ComponentInComponentEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintInComponentEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActorInComponentEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintInPackageEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActorInPackageEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UseCaseInPackageEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ComponentInPackageEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PackageEditPartCN.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActorEditPartTN.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActorAsRectangleEditPartTN.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UseCaseEditPartTN.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UseCaseAsRectangleEditPartTN.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ComponentEditPartTN.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PackageEditPartTN.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintEditPartTN.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExtensionPointEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ExtensionPointInRectangleEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UseCaseInComponentEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ComponentInComponentEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintInComponentEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActorInComponentEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ConstraintInPackageEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActorInPackageEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UseCaseInPackageEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ComponentInPackageEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PackageEditPartCN.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		if(!target.isEmpty()) {
			result.add(target);
		}
		if(!source.isEmpty()) {
			result.add(source);
		}
		return result.toArray();
	}

	/**
	 * 
	 * Papyrus Template this method is a modification of gmf code in order to avoid
	 * getViewChidreen() method becoming greater than 64kb.
	 * 
	 * @generated
	 **/
	private Object[] getViewChildrenForPackageMergeEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup target = new UMLNavigatorGroup(Messages.NavigatorGroupName_PackageMerge_4018_target, "icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup source = new UMLNavigatorGroup(Messages.NavigatorGroupName_PackageMerge_4018_source, "icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PackageEditPartTN.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PackageEditPartCN.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PackageEditPartTN.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PackageEditPartCN.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		if(!target.isEmpty()) {
			result.add(target);
		}
		if(!source.isEmpty()) {
			result.add(source);
		}
		return result.toArray();
	}

	/**
	 * 
	 * Papyrus Template this method is a modification of gmf code in order to avoid
	 * getViewChidreen() method becoming greater than 64kb.
	 * 
	 * @generated
	 **/
	private Object[] getViewChildrenForPackageImportEditPart(View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup target = new UMLNavigatorGroup(Messages.NavigatorGroupName_PackageImport_4019_target, "icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup source = new UMLNavigatorGroup(Messages.NavigatorGroupName_PackageImport_4019_source, "icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PackageEditPartTN.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PackageEditPartCN.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActorEditPartTN.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActorAsRectangleEditPartTN.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UseCaseEditPartTN.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UseCaseAsRectangleEditPartTN.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ComponentEditPartTN.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PackageEditPartTN.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UseCaseInComponentEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ComponentInComponentEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActorInComponentEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ActorInPackageEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(UseCaseInPackageEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(ComponentInPackageEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view), UMLVisualIDRegistry.getType(PackageEditPartCN.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		if(!target.isEmpty()) {
			result.add(target);
		}
		if(!source.isEmpty()) {
			result.add(source);
		}
		return result.toArray();
	}

	/**
	 * @generated
	 */
	public void dispose() {
		myWorkspaceSynchronizer.dispose();
		myWorkspaceSynchronizer = null;
		myViewerRefreshRunnable = null;
		for(Iterator it = myEditingDomain.getResourceSet().getResources().iterator(); it.hasNext();) {
			Resource resource = (Resource)it.next();
			resource.unload();
		}
		((TransactionalEditingDomain)myEditingDomain).dispose();
		myEditingDomain = null;
	}

	/**
	 * @generated
	 */
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		myViewer = viewer;
	}

	/**
	 * @generated
	 */
	public Object[] getElements(Object inputElement) {
		return getChildren(inputElement);
	}

	/**
	 * @generated
	 */
	public void restoreState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public void saveState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public void init(ICommonContentExtensionSite aConfig) {
	}

	/**
	 * @generated
	 */
	public Object[] getChildren(Object parentElement) {
		if(parentElement instanceof IFile) {
			IFile file = (IFile)parentElement;
			URI fileURI = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
			Resource resource = myEditingDomain.getResourceSet().getResource(fileURI, true);
			Collection result = new ArrayList();
			UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_File_incominglinks, "icons/incomingLinksNavigatorGroup.gif", file); //$NON-NLS-1$
			UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(Messages.NavigatorGroupName_File_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", file); //$NON-NLS-1$
			result.addAll(createNavigatorItems(selectViewsByType(resource.getContents(), UseCaseDiagramEditPart.MODEL_ID), file, false));
			result.addAll(createNavigatorItems(selectViewsByType(resource.getContents(), UMLVisualIDRegistry.getType(ConstraintInPackageEditPart.VISUAL_ID)), file, false));
			result.addAll(createNavigatorItems(selectViewsByType(resource.getContents(), UMLVisualIDRegistry.getType(ActorInPackageEditPart.VISUAL_ID)), file, false));
			result.addAll(createNavigatorItems(selectViewsByType(resource.getContents(), UMLVisualIDRegistry.getType(UseCaseInPackageEditPart.VISUAL_ID)), file, false));
			result.addAll(createNavigatorItems(selectViewsByType(resource.getContents(), UMLVisualIDRegistry.getType(ComponentInPackageEditPart.VISUAL_ID)), file, false));
			result.addAll(createNavigatorItems(selectViewsByType(resource.getContents(), UMLVisualIDRegistry.getType(PackageEditPartCN.VISUAL_ID)), file, false));
			result.addAll(createNavigatorItems(selectViewsByType(resource.getContents(), UMLVisualIDRegistry.getType(CommentEditPartCN.VISUAL_ID)), file, false));
			incominglinks.addChildren(createNavigatorItems(selectViewsByType(resource.getContents(), UMLVisualIDRegistry.getType(ConstraintConstrainedElementEditPart.VISUAL_ID)), incominglinks, false));
			incominglinks.addChildren(createNavigatorItems(selectViewsByType(resource.getContents(), UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID)), incominglinks, false));
			outgoinglinks.addChildren(createNavigatorItems(selectViewsByType(resource.getContents(), UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID)), outgoinglinks, false));
			incominglinks.addChildren(createNavigatorItems(selectViewsByType(resource.getContents(), UMLVisualIDRegistry.getType(CommentAnnotatedElementEditPart.VISUAL_ID)), incominglinks, false));
			incominglinks.addChildren(createNavigatorItems(selectViewsByType(resource.getContents(), UMLVisualIDRegistry.getType(AbstractionEditPart.VISUAL_ID)), incominglinks, false));
			outgoinglinks.addChildren(createNavigatorItems(selectViewsByType(resource.getContents(), UMLVisualIDRegistry.getType(AbstractionEditPart.VISUAL_ID)), outgoinglinks, false));
			incominglinks.addChildren(createNavigatorItems(selectViewsByType(resource.getContents(), UMLVisualIDRegistry.getType(UsageEditPart.VISUAL_ID)), incominglinks, false));
			outgoinglinks.addChildren(createNavigatorItems(selectViewsByType(resource.getContents(), UMLVisualIDRegistry.getType(UsageEditPart.VISUAL_ID)), outgoinglinks, false));
			incominglinks.addChildren(createNavigatorItems(selectViewsByType(resource.getContents(), UMLVisualIDRegistry.getType(RealizationEditPart.VISUAL_ID)), incominglinks, false));
			outgoinglinks.addChildren(createNavigatorItems(selectViewsByType(resource.getContents(), UMLVisualIDRegistry.getType(RealizationEditPart.VISUAL_ID)), outgoinglinks, false));
			incominglinks.addChildren(createNavigatorItems(selectViewsByType(resource.getContents(), UMLVisualIDRegistry.getType(PackageMergeEditPart.VISUAL_ID)), incominglinks, false));
			outgoinglinks.addChildren(createNavigatorItems(selectViewsByType(resource.getContents(), UMLVisualIDRegistry.getType(PackageMergeEditPart.VISUAL_ID)), outgoinglinks, false));
			incominglinks.addChildren(createNavigatorItems(selectViewsByType(resource.getContents(), UMLVisualIDRegistry.getType(PackageImportEditPart.VISUAL_ID)), incominglinks, false));
			outgoinglinks.addChildren(createNavigatorItems(selectViewsByType(resource.getContents(), UMLVisualIDRegistry.getType(PackageImportEditPart.VISUAL_ID)), outgoinglinks, false));
			if(!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if(!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		if(parentElement instanceof UMLNavigatorGroup) {
			UMLNavigatorGroup group = (UMLNavigatorGroup)parentElement;
			return group.getChildren();
		}

		if(parentElement instanceof UMLNavigatorItem) {
			UMLNavigatorItem navigatorItem = (UMLNavigatorItem)parentElement;
			if(navigatorItem.isLeaf() || !isOwnView(navigatorItem.getView())) {
				return EMPTY_ARRAY;
			}
			return getViewChildren(navigatorItem.getView(), parentElement);
		}

		return EMPTY_ARRAY;
	}

	/**
	 * @generated
	 */
	private Object[] getViewChildren(View view, Object parentElement) {
		switch(UMLVisualIDRegistry.getVisualID(view)) {



		case ActorInComponentEditPart.VISUAL_ID:
		{


			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForActorInComponentEditPart(view, parentElement);

		}

		case GeneralizationEditPart.VISUAL_ID:
		{


			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForGeneralizationEditPart(view, parentElement);

		}

		case ConstraintInComponentEditPart.VISUAL_ID:
		{


			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForConstraintInComponentEditPart(view, parentElement);

		}

		case ActorInPackageEditPart.VISUAL_ID:
		{


			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForActorInPackageEditPart(view, parentElement);

		}

		case ConstraintEditPartTN.VISUAL_ID:
		{


			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForConstraintEditPartTN(view, parentElement);

		}

		case CommentEditPartCN.VISUAL_ID:
		{


			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForCommentEditPartCN(view, parentElement);

		}

		case UseCaseEditPartTN.VISUAL_ID:
		{


			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForUseCaseEditPartTN(view, parentElement);

		}

		case ActorEditPartTN.VISUAL_ID:
		{


			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForActorEditPartTN(view, parentElement);

		}

		case UseCaseInComponentEditPart.VISUAL_ID:
		{


			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForUseCaseInComponentEditPart(view, parentElement);

		}

		case CommentEditPartTN.VISUAL_ID:
		{


			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForCommentEditPartTN(view, parentElement);

		}

		case PackageEditPartTN.VISUAL_ID:
		{


			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForPackageEditPartTN(view, parentElement);

		}

		case UseCaseDiagramEditPart.VISUAL_ID:
		{


			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForUseCaseDiagramEditPart(view, parentElement);

		}

		case ConstraintConstrainedElementEditPart.VISUAL_ID:
		{


			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForConstraintConstrainedElementEditPart(view, parentElement);

		}

		case UseCaseInPackageEditPart.VISUAL_ID:
		{


			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForUseCaseInPackageEditPart(view, parentElement);

		}

		case PackageImportEditPart.VISUAL_ID:
		{


			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForPackageImportEditPart(view, parentElement);

		}

		case AssociationEditPart.VISUAL_ID:
		{


			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForAssociationEditPart(view, parentElement);

		}

		case ComponentEditPartTN.VISUAL_ID:
		{


			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForComponentEditPartTN(view, parentElement);

		}

		case DependencyEditPart.VISUAL_ID:
		{


			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForDependencyEditPart(view, parentElement);

		}

		case UsageEditPart.VISUAL_ID:
		{


			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForUsageEditPart(view, parentElement);

		}

		case PackageMergeEditPart.VISUAL_ID:
		{


			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForPackageMergeEditPart(view, parentElement);

		}

		case IncludeEditPart.VISUAL_ID:
		{


			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForIncludeEditPart(view, parentElement);

		}

		case RealizationEditPart.VISUAL_ID:
		{


			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForRealizationEditPart(view, parentElement);

		}

		case ConstraintInPackageEditPart.VISUAL_ID:
		{


			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForConstraintInPackageEditPart(view, parentElement);

		}

		case ComponentInComponentEditPart.VISUAL_ID:
		{


			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForComponentInComponentEditPart(view, parentElement);

		}

		case ActorAsRectangleEditPartTN.VISUAL_ID:
		{


			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForActorAsRectangleEditPartTN(view, parentElement);

		}

		case CommentAnnotatedElementEditPart.VISUAL_ID:
		{


			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForCommentAnnotatedElementEditPart(view, parentElement);

		}

		case UseCaseAsRectangleEditPartTN.VISUAL_ID:
		{


			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForUseCaseAsRectangleEditPartTN(view, parentElement);

		}

		case ExtendEditPart.VISUAL_ID:
		{


			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForExtendEditPart(view, parentElement);

		}

		case PackageEditPartCN.VISUAL_ID:
		{


			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForPackageEditPartCN(view, parentElement);

		}

		case ExtensionPointInRectangleEditPart.VISUAL_ID:
		{


			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForExtensionPointInRectangleEditPart(view, parentElement);

		}

		case ComponentInPackageEditPart.VISUAL_ID:
		{


			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForComponentInPackageEditPart(view, parentElement);

		}

		case ExtensionPointEditPart.VISUAL_ID:
		{


			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForExtensionPointEditPart(view, parentElement);

		}

		case AbstractionEditPart.VISUAL_ID:
		{


			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForAbstractionEditPart(view, parentElement);

		}

		}
		return EMPTY_ARRAY;
	}

	/**
	 * @generated
	 */
	private Collection getLinksSourceByType(Collection edges, String type) {
		Collection result = new ArrayList();
		for(Iterator it = edges.iterator(); it.hasNext();) {
			Edge nextEdge = (Edge)it.next();
			View nextEdgeSource = nextEdge.getSource();
			if(type.equals(nextEdgeSource.getType()) && isOwnView(nextEdgeSource)) {
				result.add(nextEdgeSource);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getLinksTargetByType(Collection edges, String type) {
		Collection result = new ArrayList();
		for(Iterator it = edges.iterator(); it.hasNext();) {
			Edge nextEdge = (Edge)it.next();
			View nextEdgeTarget = nextEdge.getTarget();
			if(type.equals(nextEdgeTarget.getType()) && isOwnView(nextEdgeTarget)) {
				result.add(nextEdgeTarget);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getOutgoingLinksByType(Collection nodes, String type) {
		Collection result = new ArrayList();
		for(Iterator it = nodes.iterator(); it.hasNext();) {
			View nextNode = (View)it.next();
			result.addAll(selectViewsByType(nextNode.getSourceEdges(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getIncomingLinksByType(Collection nodes, String type) {
		Collection result = new ArrayList();
		for(Iterator it = nodes.iterator(); it.hasNext();) {
			View nextNode = (View)it.next();
			result.addAll(selectViewsByType(nextNode.getTargetEdges(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getChildrenByType(Collection nodes, String type) {
		Collection result = new ArrayList();
		for(Iterator it = nodes.iterator(); it.hasNext();) {
			View nextNode = (View)it.next();
			result.addAll(selectViewsByType(nextNode.getChildren(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getDiagramLinksByType(Collection diagrams, String type) {
		Collection result = new ArrayList();
		for(Iterator it = diagrams.iterator(); it.hasNext();) {
			Diagram nextDiagram = (Diagram)it.next();
			result.addAll(selectViewsByType(nextDiagram.getEdges(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection selectViewsByType(Collection views, String type) {
		Collection result = new ArrayList();
		for(Iterator it = views.iterator(); it.hasNext();) {
			View nextView = (View)it.next();
			if(type.equals(nextView.getType()) && isOwnView(nextView)) {
				result.add(nextView);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isOwnView(View view) {
		return UseCaseDiagramEditPart.MODEL_ID.equals(UMLVisualIDRegistry.getModelID(view));
	}

	/**
	 * @generated
	 */
	private Collection createNavigatorItems(Collection views, Object parent, boolean isLeafs) {
		Collection result = new ArrayList();
		for(Iterator it = views.iterator(); it.hasNext();) {
			result.add(new UMLNavigatorItem((View)it.next(), parent, isLeafs));
		}
		return result;
	}

	/**
	 * @generated
	 */
	public Object getParent(Object element) {
		if(element instanceof UMLAbstractNavigatorItem) {
			UMLAbstractNavigatorItem abstractNavigatorItem = (UMLAbstractNavigatorItem)element;
			return abstractNavigatorItem.getParent();
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean hasChildren(Object element) {
		return element instanceof IFile || getChildren(element).length > 0;
	}

}
