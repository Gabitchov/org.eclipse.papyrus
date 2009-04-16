/*****************************************************************************
 * Copyright (c) 2008 Atos Origin.
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
import org.eclipse.papyrus.diagram.usecase.edit.parts.Actor2EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.Actor3EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ActorEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.AssociationEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.CommentEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ComponentEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ComponentUsecasesEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ConstraintConstrainedElementEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ConstraintEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.DependencyEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ExtendEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ExtensionPoint2EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.ExtensionPointEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.GeneralizationEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.IncludeEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.Package3EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.PackageEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.PackagePackageableElementCompartmentEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCase2EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCase3EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCase4EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCaseEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCaseExtensionpointsEditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCasePoints2EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCasePoints3EditPart;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCasePointsEditPart;
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
	public UMLNavigatorContentProvider() {
		TransactionalEditingDomain editingDomain = GMFEditingDomainFactory.INSTANCE
				.createEditingDomain();
		myEditingDomain = (AdapterFactoryEditingDomain) editingDomain;
		myEditingDomain.setResourceToReadOnlyMap(new HashMap() {
			public Object get(Object key) {
				if (!containsKey(key)) {
					put(key, Boolean.TRUE);
				}
				return super.get(key);
			}
		});
		myViewerRefreshRunnable = new Runnable() {
			public void run() {
				if (myViewer != null) {
					myViewer.refresh();
				}
			}
		};
		myWorkspaceSynchronizer = new WorkspaceSynchronizer(editingDomain,
				new WorkspaceSynchronizer.Delegate() {
					public void dispose() {
					}

					public boolean handleResourceChanged(final Resource resource) {
						for (Iterator it = myEditingDomain.getResourceSet()
								.getResources().iterator(); it.hasNext();) {
							Resource nextResource = (Resource) it.next();
							nextResource.unload();
						}
						if (myViewer != null) {
							myViewer.getControl().getDisplay().asyncExec(
									myViewerRefreshRunnable);
						}
						return true;
					}

					public boolean handleResourceDeleted(Resource resource) {
						for (Iterator it = myEditingDomain.getResourceSet()
								.getResources().iterator(); it.hasNext();) {
							Resource nextResource = (Resource) it.next();
							nextResource.unload();
						}
						if (myViewer != null) {
							myViewer.getControl().getDisplay().asyncExec(
									myViewerRefreshRunnable);
						}
						return true;
					}

					public boolean handleResourceMoved(Resource resource,
							final URI newURI) {
						for (Iterator it = myEditingDomain.getResourceSet()
								.getResources().iterator(); it.hasNext();) {
							Resource nextResource = (Resource) it.next();
							nextResource.unload();
						}
						if (myViewer != null) {
							myViewer.getControl().getDisplay().asyncExec(
									myViewerRefreshRunnable);
						}
						return true;
					}
				});
	}

	/**
	 *
	 *Papyrus Template
	 *this method is a modification of gmf code in order to avoid  getViewChidreen() method becoming greater than 64kb.
	 *@generated
	 **/
	private Object[] getViewChildrenForPackageEditPart(View view,
			Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup links = new UMLNavigatorGroup(
				Messages.NavigatorGroupName_Package_1000_links,
				"icons/linksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getChildrenByType(Collections
				.singleton(view), UMLVisualIDRegistry
				.getType(ActorEditPart.VISUAL_ID));
		result
				.addAll(createNavigatorItems(connectedViews, parentElement,
						false));
		connectedViews = getChildrenByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(Actor2EditPart.VISUAL_ID));
		result
				.addAll(createNavigatorItems(connectedViews, parentElement,
						false));
		connectedViews = getChildrenByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(UseCaseEditPart.VISUAL_ID));
		result
				.addAll(createNavigatorItems(connectedViews, parentElement,
						false));
		connectedViews = getChildrenByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(UseCase2EditPart.VISUAL_ID));
		result
				.addAll(createNavigatorItems(connectedViews, parentElement,
						false));
		connectedViews = getChildrenByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(ComponentEditPart.VISUAL_ID));
		result
				.addAll(createNavigatorItems(connectedViews, parentElement,
						false));
		connectedViews = getChildrenByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(Package3EditPart.VISUAL_ID));
		result
				.addAll(createNavigatorItems(connectedViews, parentElement,
						false));
		connectedViews = getChildrenByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(ConstraintEditPart.VISUAL_ID));
		result
				.addAll(createNavigatorItems(connectedViews, parentElement,
						false));
		connectedViews = getChildrenByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(CommentEditPart.VISUAL_ID));
		result
				.addAll(createNavigatorItems(connectedViews, parentElement,
						false));
		connectedViews = getDiagramLinksByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(IncludeEditPart.VISUAL_ID));
		links.addChildren(createNavigatorItems(connectedViews, links, false));
		connectedViews = getDiagramLinksByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(ExtendEditPart.VISUAL_ID));
		links.addChildren(createNavigatorItems(connectedViews, links, false));
		connectedViews = getDiagramLinksByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(GeneralizationEditPart.VISUAL_ID));
		links.addChildren(createNavigatorItems(connectedViews, links, false));
		connectedViews = getDiagramLinksByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(AssociationEditPart.VISUAL_ID));
		links.addChildren(createNavigatorItems(connectedViews, links, false));
		connectedViews = getDiagramLinksByType(
				Collections.singleton(view),
				UMLVisualIDRegistry
						.getType(ConstraintConstrainedElementEditPart.VISUAL_ID));
		links.addChildren(createNavigatorItems(connectedViews, links, false));
		connectedViews = getDiagramLinksByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
		links.addChildren(createNavigatorItems(connectedViews, links, false));
		connectedViews = getDiagramLinksByType(Collections.singleton(view),
				UMLVisualIDRegistry
						.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
		links.addChildren(createNavigatorItems(connectedViews, links, false));
		if (!links.isEmpty()) {
			result.add(links);
		}
		return result.toArray();
	}

	/**
	 *
	 *Papyrus Template
	 *this method is a modification of gmf code in order to avoid  getViewChidreen() method becoming greater than 64kb.
	 *@generated
	 **/
	private Object[] getViewChildrenForActorEditPart(View view,
			Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(
				Messages.NavigatorGroupName_Actor_2002_incominglinks,
				"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(
				Messages.NavigatorGroupName_Actor_2002_outgoinglinks,
				"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections
				.singleton(view), UMLVisualIDRegistry
				.getType(GeneralizationEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews,
				incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(GeneralizationEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews,
				outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(AssociationEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews,
				incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(AssociationEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews,
				outgoinglinks, true));
		connectedViews = getIncomingLinksByType(
				Collections.singleton(view),
				UMLVisualIDRegistry
						.getType(ConstraintConstrainedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews,
				incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews,
				incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews,
				outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view),
				UMLVisualIDRegistry
						.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews,
				incominglinks, true));
		if (!incominglinks.isEmpty()) {
			result.add(incominglinks);
		}
		if (!outgoinglinks.isEmpty()) {
			result.add(outgoinglinks);
		}
		return result.toArray();
	}

	/**
	 *
	 *Papyrus Template
	 *this method is a modification of gmf code in order to avoid  getViewChidreen() method becoming greater than 64kb.
	 *@generated
	 **/
	private Object[] getViewChildrenForActor2EditPart(View view,
			Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(
				Messages.NavigatorGroupName_Actor_2003_incominglinks,
				"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(
				Messages.NavigatorGroupName_Actor_2003_outgoinglinks,
				"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections
				.singleton(view), UMLVisualIDRegistry
				.getType(GeneralizationEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews,
				incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(GeneralizationEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews,
				outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(AssociationEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews,
				incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(AssociationEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews,
				outgoinglinks, true));
		connectedViews = getIncomingLinksByType(
				Collections.singleton(view),
				UMLVisualIDRegistry
						.getType(ConstraintConstrainedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews,
				incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews,
				incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews,
				outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view),
				UMLVisualIDRegistry
						.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews,
				incominglinks, true));
		if (!incominglinks.isEmpty()) {
			result.add(incominglinks);
		}
		if (!outgoinglinks.isEmpty()) {
			result.add(outgoinglinks);
		}
		return result.toArray();
	}

	/**
	 *
	 *Papyrus Template
	 *this method is a modification of gmf code in order to avoid  getViewChidreen() method becoming greater than 64kb.
	 *@generated
	 **/
	private Object[] getViewChildrenForUseCaseEditPart(View view,
			Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(
				Messages.NavigatorGroupName_UseCase_2004_incominglinks,
				"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(
				Messages.NavigatorGroupName_UseCase_2004_outgoinglinks,
				"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getChildrenByType(Collections
				.singleton(view), UMLVisualIDRegistry
				.getType(UseCasePointsEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry
				.getType(ExtensionPointEditPart.VISUAL_ID));
		result
				.addAll(createNavigatorItems(connectedViews, parentElement,
						false));
		connectedViews = getIncomingLinksByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(IncludeEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews,
				incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(IncludeEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews,
				outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(ExtendEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews,
				incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(ExtendEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews,
				outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(GeneralizationEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews,
				incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(GeneralizationEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews,
				outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(AssociationEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews,
				incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(AssociationEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews,
				outgoinglinks, true));
		connectedViews = getIncomingLinksByType(
				Collections.singleton(view),
				UMLVisualIDRegistry
						.getType(ConstraintConstrainedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews,
				incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews,
				incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews,
				outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view),
				UMLVisualIDRegistry
						.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews,
				incominglinks, true));
		if (!incominglinks.isEmpty()) {
			result.add(incominglinks);
		}
		if (!outgoinglinks.isEmpty()) {
			result.add(outgoinglinks);
		}
		return result.toArray();
	}

	/**
	 *
	 *Papyrus Template
	 *this method is a modification of gmf code in order to avoid  getViewChidreen() method becoming greater than 64kb.
	 *@generated
	 **/
	private Object[] getViewChildrenForUseCase2EditPart(View view,
			Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(
				Messages.NavigatorGroupName_UseCase_2005_incominglinks,
				"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(
				Messages.NavigatorGroupName_UseCase_2005_outgoinglinks,
				"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getChildrenByType(Collections
				.singleton(view), UMLVisualIDRegistry
				.getType(UseCaseExtensionpointsEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry
				.getType(ExtensionPoint2EditPart.VISUAL_ID));
		result
				.addAll(createNavigatorItems(connectedViews, parentElement,
						false));
		connectedViews = getIncomingLinksByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(IncludeEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews,
				incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(IncludeEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews,
				outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(ExtendEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews,
				incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(ExtendEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews,
				outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(GeneralizationEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews,
				incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(GeneralizationEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews,
				outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(AssociationEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews,
				incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(AssociationEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews,
				outgoinglinks, true));
		connectedViews = getIncomingLinksByType(
				Collections.singleton(view),
				UMLVisualIDRegistry
						.getType(ConstraintConstrainedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews,
				incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews,
				incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews,
				outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view),
				UMLVisualIDRegistry
						.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews,
				incominglinks, true));
		if (!incominglinks.isEmpty()) {
			result.add(incominglinks);
		}
		if (!outgoinglinks.isEmpty()) {
			result.add(outgoinglinks);
		}
		return result.toArray();
	}

	/**
	 *
	 *Papyrus Template
	 *this method is a modification of gmf code in order to avoid  getViewChidreen() method becoming greater than 64kb.
	 *@generated
	 **/
	private Object[] getViewChildrenForComponentEditPart(View view,
			Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(
				Messages.NavigatorGroupName_Component_2006_incominglinks,
				"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(
				Messages.NavigatorGroupName_Component_2006_outgoinglinks,
				"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getChildrenByType(Collections
				.singleton(view), UMLVisualIDRegistry
				.getType(ComponentUsecasesEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry
				.getType(UseCase3EditPart.VISUAL_ID));
		result
				.addAll(createNavigatorItems(connectedViews, parentElement,
						false));
		connectedViews = getIncomingLinksByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(GeneralizationEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews,
				incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(GeneralizationEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews,
				outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(AssociationEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews,
				incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(AssociationEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews,
				outgoinglinks, true));
		connectedViews = getIncomingLinksByType(
				Collections.singleton(view),
				UMLVisualIDRegistry
						.getType(ConstraintConstrainedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews,
				incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews,
				incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews,
				outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view),
				UMLVisualIDRegistry
						.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews,
				incominglinks, true));
		if (!incominglinks.isEmpty()) {
			result.add(incominglinks);
		}
		if (!outgoinglinks.isEmpty()) {
			result.add(outgoinglinks);
		}
		return result.toArray();
	}

	/**
	 *
	 *Papyrus Template
	 *this method is a modification of gmf code in order to avoid  getViewChidreen() method becoming greater than 64kb.
	 *@generated
	 **/
	private Object[] getViewChildrenForPackage3EditPart(View view,
			Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(
				Messages.NavigatorGroupName_Package_2009_incominglinks,
				"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(
				Messages.NavigatorGroupName_Package_2009_outgoinglinks,
				"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getChildrenByType(
				Collections.singleton(view),
				UMLVisualIDRegistry
						.getType(PackagePackageableElementCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry
				.getType(Actor3EditPart.VISUAL_ID));
		result
				.addAll(createNavigatorItems(connectedViews, parentElement,
						false));
		connectedViews = getChildrenByType(
				Collections.singleton(view),
				UMLVisualIDRegistry
						.getType(PackagePackageableElementCompartmentEditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry
				.getType(UseCase4EditPart.VISUAL_ID));
		result
				.addAll(createNavigatorItems(connectedViews, parentElement,
						false));
		connectedViews = getIncomingLinksByType(
				Collections.singleton(view),
				UMLVisualIDRegistry
						.getType(ConstraintConstrainedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews,
				incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews,
				incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews,
				outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view),
				UMLVisualIDRegistry
						.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews,
				incominglinks, true));
		if (!incominglinks.isEmpty()) {
			result.add(incominglinks);
		}
		if (!outgoinglinks.isEmpty()) {
			result.add(outgoinglinks);
		}
		return result.toArray();
	}

	/**
	 *
	 *Papyrus Template
	 *this method is a modification of gmf code in order to avoid  getViewChidreen() method becoming greater than 64kb.
	 *@generated
	 **/
	private Object[] getViewChildrenForConstraintEditPart(View view,
			Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(
				Messages.NavigatorGroupName_Constraint_2008_incominglinks,
				"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(
				Messages.NavigatorGroupName_Constraint_2008_outgoinglinks,
				"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections
				.singleton(view), UMLVisualIDRegistry
				.getType(ConstraintConstrainedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews,
				incominglinks, true));
		connectedViews = getOutgoingLinksByType(
				Collections.singleton(view),
				UMLVisualIDRegistry
						.getType(ConstraintConstrainedElementEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews,
				outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews,
				incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews,
				outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view),
				UMLVisualIDRegistry
						.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews,
				incominglinks, true));
		if (!incominglinks.isEmpty()) {
			result.add(incominglinks);
		}
		if (!outgoinglinks.isEmpty()) {
			result.add(outgoinglinks);
		}
		return result.toArray();
	}

	/**
	 *
	 *Papyrus Template
	 *this method is a modification of gmf code in order to avoid  getViewChidreen() method becoming greater than 64kb.
	 *@generated
	 **/
	private Object[] getViewChildrenForCommentEditPart(View view,
			Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(
				Messages.NavigatorGroupName_Comment_2010_incominglinks,
				"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(
				Messages.NavigatorGroupName_Comment_2010_outgoinglinks,
				"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections
				.singleton(view), UMLVisualIDRegistry
				.getType(ConstraintConstrainedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews,
				incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view),
				UMLVisualIDRegistry
						.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews,
				incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view),
				UMLVisualIDRegistry
						.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews,
				outgoinglinks, true));
		if (!incominglinks.isEmpty()) {
			result.add(incominglinks);
		}
		if (!outgoinglinks.isEmpty()) {
			result.add(outgoinglinks);
		}
		return result.toArray();
	}

	/**
	 *
	 *Papyrus Template
	 *this method is a modification of gmf code in order to avoid  getViewChidreen() method becoming greater than 64kb.
	 *@generated
	 **/
	private Object[] getViewChildrenForExtensionPointEditPart(View view,
			Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(
				Messages.NavigatorGroupName_ExtensionPoint_3002_incominglinks,
				"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(
				Messages.NavigatorGroupName_ExtensionPoint_3002_outgoinglinks,
				"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections
				.singleton(view), UMLVisualIDRegistry
				.getType(ConstraintConstrainedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews,
				incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews,
				incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews,
				outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view),
				UMLVisualIDRegistry
						.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews,
				incominglinks, true));
		if (!incominglinks.isEmpty()) {
			result.add(incominglinks);
		}
		if (!outgoinglinks.isEmpty()) {
			result.add(outgoinglinks);
		}
		return result.toArray();
	}

	/**
	 *
	 *Papyrus Template
	 *this method is a modification of gmf code in order to avoid  getViewChidreen() method becoming greater than 64kb.
	 *@generated
	 **/
	private Object[] getViewChildrenForExtensionPoint2EditPart(View view,
			Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(
				Messages.NavigatorGroupName_ExtensionPoint_3003_incominglinks,
				"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(
				Messages.NavigatorGroupName_ExtensionPoint_3003_outgoinglinks,
				"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections
				.singleton(view), UMLVisualIDRegistry
				.getType(ConstraintConstrainedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews,
				incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews,
				incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews,
				outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view),
				UMLVisualIDRegistry
						.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews,
				incominglinks, true));
		if (!incominglinks.isEmpty()) {
			result.add(incominglinks);
		}
		if (!outgoinglinks.isEmpty()) {
			result.add(outgoinglinks);
		}
		return result.toArray();
	}

	/**
	 *
	 *Papyrus Template
	 *this method is a modification of gmf code in order to avoid  getViewChidreen() method becoming greater than 64kb.
	 *@generated
	 **/
	private Object[] getViewChildrenForUseCase3EditPart(View view,
			Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(
				Messages.NavigatorGroupName_UseCase_3004_incominglinks,
				"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(
				Messages.NavigatorGroupName_UseCase_3004_outgoinglinks,
				"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getChildrenByType(Collections
				.singleton(view), UMLVisualIDRegistry
				.getType(UseCasePoints2EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry
				.getType(ExtensionPointEditPart.VISUAL_ID));
		result
				.addAll(createNavigatorItems(connectedViews, parentElement,
						false));
		connectedViews = getIncomingLinksByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(IncludeEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews,
				incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(IncludeEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews,
				outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(ExtendEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews,
				incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(ExtendEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews,
				outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(GeneralizationEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews,
				incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(GeneralizationEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews,
				outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(AssociationEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews,
				incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(AssociationEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews,
				outgoinglinks, true));
		connectedViews = getIncomingLinksByType(
				Collections.singleton(view),
				UMLVisualIDRegistry
						.getType(ConstraintConstrainedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews,
				incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews,
				incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews,
				outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view),
				UMLVisualIDRegistry
						.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews,
				incominglinks, true));
		if (!incominglinks.isEmpty()) {
			result.add(incominglinks);
		}
		if (!outgoinglinks.isEmpty()) {
			result.add(outgoinglinks);
		}
		return result.toArray();
	}

	/**
	 *
	 *Papyrus Template
	 *this method is a modification of gmf code in order to avoid  getViewChidreen() method becoming greater than 64kb.
	 *@generated
	 **/
	private Object[] getViewChildrenForActor3EditPart(View view,
			Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(
				Messages.NavigatorGroupName_Actor_3005_incominglinks,
				"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(
				Messages.NavigatorGroupName_Actor_3005_outgoinglinks,
				"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getIncomingLinksByType(Collections
				.singleton(view), UMLVisualIDRegistry
				.getType(GeneralizationEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews,
				incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(GeneralizationEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews,
				outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(AssociationEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews,
				incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(AssociationEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews,
				outgoinglinks, true));
		connectedViews = getIncomingLinksByType(
				Collections.singleton(view),
				UMLVisualIDRegistry
						.getType(ConstraintConstrainedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews,
				incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews,
				incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews,
				outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view),
				UMLVisualIDRegistry
						.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews,
				incominglinks, true));
		if (!incominglinks.isEmpty()) {
			result.add(incominglinks);
		}
		if (!outgoinglinks.isEmpty()) {
			result.add(outgoinglinks);
		}
		return result.toArray();
	}

	/**
	 *
	 *Papyrus Template
	 *this method is a modification of gmf code in order to avoid  getViewChidreen() method becoming greater than 64kb.
	 *@generated
	 **/
	private Object[] getViewChildrenForUseCase4EditPart(View view,
			Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup incominglinks = new UMLNavigatorGroup(
				Messages.NavigatorGroupName_UseCase_3006_incominglinks,
				"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup outgoinglinks = new UMLNavigatorGroup(
				Messages.NavigatorGroupName_UseCase_3006_outgoinglinks,
				"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getChildrenByType(Collections
				.singleton(view), UMLVisualIDRegistry
				.getType(UseCasePoints3EditPart.VISUAL_ID));
		connectedViews = getChildrenByType(connectedViews, UMLVisualIDRegistry
				.getType(ExtensionPointEditPart.VISUAL_ID));
		result
				.addAll(createNavigatorItems(connectedViews, parentElement,
						false));
		connectedViews = getIncomingLinksByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(IncludeEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews,
				incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(IncludeEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews,
				outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(ExtendEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews,
				incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(ExtendEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews,
				outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(GeneralizationEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews,
				incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(GeneralizationEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews,
				outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(AssociationEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews,
				incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(AssociationEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews,
				outgoinglinks, true));
		connectedViews = getIncomingLinksByType(
				Collections.singleton(view),
				UMLVisualIDRegistry
						.getType(ConstraintConstrainedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews,
				incominglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews,
				incominglinks, true));
		connectedViews = getOutgoingLinksByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
		outgoinglinks.addChildren(createNavigatorItems(connectedViews,
				outgoinglinks, true));
		connectedViews = getIncomingLinksByType(Collections.singleton(view),
				UMLVisualIDRegistry
						.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
		incominglinks.addChildren(createNavigatorItems(connectedViews,
				incominglinks, true));
		if (!incominglinks.isEmpty()) {
			result.add(incominglinks);
		}
		if (!outgoinglinks.isEmpty()) {
			result.add(outgoinglinks);
		}
		return result.toArray();
	}

	/**
	 *
	 *Papyrus Template
	 *this method is a modification of gmf code in order to avoid  getViewChidreen() method becoming greater than 64kb.
	 *@generated
	 **/
	private Object[] getViewChildrenForIncludeEditPart(View view,
			Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup target = new UMLNavigatorGroup(
				Messages.NavigatorGroupName_Include_4001_target,
				"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup source = new UMLNavigatorGroup(
				Messages.NavigatorGroupName_Include_4001_source,
				"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getLinksTargetByType(Collections
				.singleton(view), UMLVisualIDRegistry
				.getType(UseCaseEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(UseCase2EditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(UseCase3EditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(UseCase4EditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(UseCaseEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(UseCase2EditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(UseCase3EditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(UseCase4EditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		if (!target.isEmpty()) {
			result.add(target);
		}
		if (!source.isEmpty()) {
			result.add(source);
		}
		return result.toArray();
	}

	/**
	 *
	 *Papyrus Template
	 *this method is a modification of gmf code in order to avoid  getViewChidreen() method becoming greater than 64kb.
	 *@generated
	 **/
	private Object[] getViewChildrenForExtendEditPart(View view,
			Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup target = new UMLNavigatorGroup(
				Messages.NavigatorGroupName_Extend_4002_target,
				"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup source = new UMLNavigatorGroup(
				Messages.NavigatorGroupName_Extend_4002_source,
				"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getLinksTargetByType(Collections
				.singleton(view), UMLVisualIDRegistry
				.getType(UseCaseEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(UseCase2EditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(UseCase3EditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(UseCase4EditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(UseCaseEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(UseCase2EditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(UseCase3EditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(UseCase4EditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		if (!target.isEmpty()) {
			result.add(target);
		}
		if (!source.isEmpty()) {
			result.add(source);
		}
		return result.toArray();
	}

	/**
	 *
	 *Papyrus Template
	 *this method is a modification of gmf code in order to avoid  getViewChidreen() method becoming greater than 64kb.
	 *@generated
	 **/
	private Object[] getViewChildrenForGeneralizationEditPart(View view,
			Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup target = new UMLNavigatorGroup(
				Messages.NavigatorGroupName_Generalization_4003_target,
				"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup source = new UMLNavigatorGroup(
				Messages.NavigatorGroupName_Generalization_4003_source,
				"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getLinksTargetByType(Collections
				.singleton(view), UMLVisualIDRegistry
				.getType(ActorEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(Actor2EditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(UseCaseEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(UseCase2EditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(ComponentEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(UseCase3EditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(Actor3EditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(UseCase4EditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(ActorEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(Actor2EditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(UseCaseEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(UseCase2EditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(ComponentEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(UseCase3EditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(Actor3EditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(UseCase4EditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		if (!target.isEmpty()) {
			result.add(target);
		}
		if (!source.isEmpty()) {
			result.add(source);
		}
		return result.toArray();
	}

	/**
	 *
	 *Papyrus Template
	 *this method is a modification of gmf code in order to avoid  getViewChidreen() method becoming greater than 64kb.
	 *@generated
	 **/
	private Object[] getViewChildrenForAssociationEditPart(View view,
			Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup target = new UMLNavigatorGroup(
				Messages.NavigatorGroupName_Association_4004_target,
				"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup source = new UMLNavigatorGroup(
				Messages.NavigatorGroupName_Association_4004_source,
				"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getLinksTargetByType(Collections
				.singleton(view), UMLVisualIDRegistry
				.getType(ActorEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(Actor2EditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(UseCaseEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(UseCase2EditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(ComponentEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(UseCase3EditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(Actor3EditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(UseCase4EditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(ActorEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(Actor2EditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(UseCaseEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(UseCase2EditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(ComponentEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(UseCase3EditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(Actor3EditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(UseCase4EditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		if (!target.isEmpty()) {
			result.add(target);
		}
		if (!source.isEmpty()) {
			result.add(source);
		}
		return result.toArray();
	}

	/**
	 *
	 *Papyrus Template
	 *this method is a modification of gmf code in order to avoid  getViewChidreen() method becoming greater than 64kb.
	 *@generated
	 **/
	private Object[] getViewChildrenForConstraintConstrainedElementEditPart(
			View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup target = new UMLNavigatorGroup(
				Messages.NavigatorGroupName_ConstraintConstrainedElement_4005_target,
				"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup source = new UMLNavigatorGroup(
				Messages.NavigatorGroupName_ConstraintConstrainedElement_4005_source,
				"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getLinksTargetByType(Collections
				.singleton(view), UMLVisualIDRegistry
				.getType(ActorEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(Actor2EditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(UseCaseEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(UseCase2EditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(ComponentEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(Package3EditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(ConstraintEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(CommentEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(ExtensionPointEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(ExtensionPoint2EditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(UseCase3EditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(Actor3EditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(UseCase4EditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(ConstraintEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		if (!target.isEmpty()) {
			result.add(target);
		}
		if (!source.isEmpty()) {
			result.add(source);
		}
		return result.toArray();
	}

	/**
	 *
	 *Papyrus Template
	 *this method is a modification of gmf code in order to avoid  getViewChidreen() method becoming greater than 64kb.
	 *@generated
	 **/
	private Object[] getViewChildrenForDependencyEditPart(View view,
			Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup target = new UMLNavigatorGroup(
				Messages.NavigatorGroupName_Dependency_4006_target,
				"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup source = new UMLNavigatorGroup(
				Messages.NavigatorGroupName_Dependency_4006_source,
				"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getLinksTargetByType(Collections
				.singleton(view), UMLVisualIDRegistry
				.getType(ActorEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(Actor2EditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(UseCaseEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(UseCase2EditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(ComponentEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(Package3EditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(ConstraintEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(ExtensionPointEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(ExtensionPoint2EditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(UseCase3EditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(Actor3EditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(UseCase4EditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(ActorEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(Actor2EditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(UseCaseEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(UseCase2EditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(ComponentEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(Package3EditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(ConstraintEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(ExtensionPointEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(ExtensionPoint2EditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(UseCase3EditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(Actor3EditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(UseCase4EditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		if (!target.isEmpty()) {
			result.add(target);
		}
		if (!source.isEmpty()) {
			result.add(source);
		}
		return result.toArray();
	}

	/**
	 *
	 *Papyrus Template
	 *this method is a modification of gmf code in order to avoid  getViewChidreen() method becoming greater than 64kb.
	 *@generated
	 **/
	private Object[] getViewChildrenForCommentAnnotatedElementEditPart(
			View view, Object parentElement) {
		Collection result = new ArrayList();
		UMLNavigatorGroup target = new UMLNavigatorGroup(
				Messages.NavigatorGroupName_CommentAnnotatedElement_4007_target,
				"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		UMLNavigatorGroup source = new UMLNavigatorGroup(
				Messages.NavigatorGroupName_CommentAnnotatedElement_4007_source,
				"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
		Collection connectedViews = getLinksTargetByType(Collections
				.singleton(view), UMLVisualIDRegistry
				.getType(ActorEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(Actor2EditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(UseCaseEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(UseCase2EditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(ComponentEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(Package3EditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(ConstraintEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(CommentEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(ExtensionPointEditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(ExtensionPoint2EditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(UseCase3EditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(Actor3EditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksTargetByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(UseCase4EditPart.VISUAL_ID));
		target.addChildren(createNavigatorItems(connectedViews, target, true));
		connectedViews = getLinksSourceByType(Collections.singleton(view),
				UMLVisualIDRegistry.getType(CommentEditPart.VISUAL_ID));
		source.addChildren(createNavigatorItems(connectedViews, source, true));
		if (!target.isEmpty()) {
			result.add(target);
		}
		if (!source.isEmpty()) {
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
		for (Iterator it = myEditingDomain.getResourceSet().getResources()
				.iterator(); it.hasNext();) {
			Resource resource = (Resource) it.next();
			resource.unload();
		}
		((TransactionalEditingDomain) myEditingDomain).dispose();
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
		if (parentElement instanceof IFile) {
			IFile file = (IFile) parentElement;
			URI fileURI = URI.createPlatformResourceURI(file.getFullPath()
					.toString(), true);
			Resource resource = myEditingDomain.getResourceSet().getResource(
					fileURI, true);
			Collection result = new ArrayList();
			result.addAll(createNavigatorItems(selectViewsByType(resource
					.getContents(), PackageEditPart.MODEL_ID), file, false));
			return result.toArray();
		}

		if (parentElement instanceof UMLNavigatorGroup) {
			UMLNavigatorGroup group = (UMLNavigatorGroup) parentElement;
			return group.getChildren();
		}

		if (parentElement instanceof UMLNavigatorItem) {
			UMLNavigatorItem navigatorItem = (UMLNavigatorItem) parentElement;
			if (navigatorItem.isLeaf() || !isOwnView(navigatorItem.getView())) {
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
		switch (UMLVisualIDRegistry.getVisualID(view)) {

		case PackageEditPart.VISUAL_ID: {

			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForPackageEditPart(view, parentElement);

		}

		case ActorEditPart.VISUAL_ID: {

			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForActorEditPart(view, parentElement);

		}

		case Actor2EditPart.VISUAL_ID: {

			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForActor2EditPart(view, parentElement);

		}

		case UseCaseEditPart.VISUAL_ID: {

			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForUseCaseEditPart(view, parentElement);

		}

		case UseCase2EditPart.VISUAL_ID: {

			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForUseCase2EditPart(view, parentElement);

		}

		case ComponentEditPart.VISUAL_ID: {

			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForComponentEditPart(view, parentElement);

		}

		case Package3EditPart.VISUAL_ID: {

			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForPackage3EditPart(view, parentElement);

		}

		case ConstraintEditPart.VISUAL_ID: {

			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForConstraintEditPart(view, parentElement);

		}

		case CommentEditPart.VISUAL_ID: {

			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForCommentEditPart(view, parentElement);

		}

		case ExtensionPointEditPart.VISUAL_ID: {

			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForExtensionPointEditPart(view, parentElement);

		}

		case ExtensionPoint2EditPart.VISUAL_ID: {

			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForExtensionPoint2EditPart(view,
					parentElement);

		}

		case UseCase3EditPart.VISUAL_ID: {

			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForUseCase3EditPart(view, parentElement);

		}

		case Actor3EditPart.VISUAL_ID: {

			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForActor3EditPart(view, parentElement);

		}

		case UseCase4EditPart.VISUAL_ID: {

			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForUseCase4EditPart(view, parentElement);

		}

		case IncludeEditPart.VISUAL_ID: {

			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForIncludeEditPart(view, parentElement);

		}

		case ExtendEditPart.VISUAL_ID: {

			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForExtendEditPart(view, parentElement);

		}

		case GeneralizationEditPart.VISUAL_ID: {

			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForGeneralizationEditPart(view, parentElement);

		}

		case AssociationEditPart.VISUAL_ID: {

			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForAssociationEditPart(view, parentElement);

		}

		case ConstraintConstrainedElementEditPart.VISUAL_ID: {

			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForConstraintConstrainedElementEditPart(view,
					parentElement);

		}

		case DependencyEditPart.VISUAL_ID: {

			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForDependencyEditPart(view, parentElement);

		}

		case CommentAnnotatedElementEditPart.VISUAL_ID: {

			//modification of the template to avoid mistake of 65kb.
			return getViewChildrenForCommentAnnotatedElementEditPart(view,
					parentElement);

		}

		}
		return EMPTY_ARRAY;
	}

	/**
	 * @generated
	 */
	private Collection getLinksSourceByType(Collection edges, String type) {
		Collection result = new ArrayList();
		for (Iterator it = edges.iterator(); it.hasNext();) {
			Edge nextEdge = (Edge) it.next();
			View nextEdgeSource = nextEdge.getSource();
			if (type.equals(nextEdgeSource.getType())
					&& isOwnView(nextEdgeSource)) {
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
		for (Iterator it = edges.iterator(); it.hasNext();) {
			Edge nextEdge = (Edge) it.next();
			View nextEdgeTarget = nextEdge.getTarget();
			if (type.equals(nextEdgeTarget.getType())
					&& isOwnView(nextEdgeTarget)) {
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
		for (Iterator it = nodes.iterator(); it.hasNext();) {
			View nextNode = (View) it.next();
			result.addAll(selectViewsByType(nextNode.getSourceEdges(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getIncomingLinksByType(Collection nodes, String type) {
		Collection result = new ArrayList();
		for (Iterator it = nodes.iterator(); it.hasNext();) {
			View nextNode = (View) it.next();
			result.addAll(selectViewsByType(nextNode.getTargetEdges(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getChildrenByType(Collection nodes, String type) {
		Collection result = new ArrayList();
		for (Iterator it = nodes.iterator(); it.hasNext();) {
			View nextNode = (View) it.next();
			result.addAll(selectViewsByType(nextNode.getChildren(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getDiagramLinksByType(Collection diagrams, String type) {
		Collection result = new ArrayList();
		for (Iterator it = diagrams.iterator(); it.hasNext();) {
			Diagram nextDiagram = (Diagram) it.next();
			result.addAll(selectViewsByType(nextDiagram.getEdges(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection selectViewsByType(Collection views, String type) {
		Collection result = new ArrayList();
		for (Iterator it = views.iterator(); it.hasNext();) {
			View nextView = (View) it.next();
			if (type.equals(nextView.getType()) && isOwnView(nextView)) {
				result.add(nextView);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isOwnView(View view) {
		return PackageEditPart.MODEL_ID.equals(UMLVisualIDRegistry
				.getModelID(view));
	}

	/**
	 * @generated
	 */
	private Collection createNavigatorItems(Collection views, Object parent,
			boolean isLeafs) {
		Collection result = new ArrayList();
		for (Iterator it = views.iterator(); it.hasNext();) {
			result.add(new UMLNavigatorItem((View) it.next(), parent, isLeafs));
		}
		return result;
	}

	/**
	 * @generated
	 */
	public Object getParent(Object element) {
		if (element instanceof UMLAbstractNavigatorItem) {
			UMLAbstractNavigatorItem abstractNavigatorItem = (UMLAbstractNavigatorItem) element;
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
