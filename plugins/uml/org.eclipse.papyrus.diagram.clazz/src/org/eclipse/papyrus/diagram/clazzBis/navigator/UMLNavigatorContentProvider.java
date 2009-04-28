package org.eclipse.papyrus.diagram.clazzBis.navigator;

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
		TransactionalEditingDomain editingDomain = GMFEditingDomainFactory.INSTANCE.createEditingDomain();
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
		myWorkspaceSynchronizer = new WorkspaceSynchronizer(editingDomain, new WorkspaceSynchronizer.Delegate() {

			public void dispose() {
			}

			public boolean handleResourceChanged(final Resource resource) {
				for (Iterator it = myEditingDomain.getResourceSet().getResources().iterator(); it.hasNext();) {
					Resource nextResource = (Resource) it.next();
					nextResource.unload();
				}
				if (myViewer != null) {
					myViewer.getControl().getDisplay().asyncExec(myViewerRefreshRunnable);
				}
				return true;
			}

			public boolean handleResourceDeleted(Resource resource) {
				for (Iterator it = myEditingDomain.getResourceSet().getResources().iterator(); it.hasNext();) {
					Resource nextResource = (Resource) it.next();
					nextResource.unload();
				}
				if (myViewer != null) {
					myViewer.getControl().getDisplay().asyncExec(myViewerRefreshRunnable);
				}
				return true;
			}

			public boolean handleResourceMoved(Resource resource, final URI newURI) {
				for (Iterator it = myEditingDomain.getResourceSet().getResources().iterator(); it.hasNext();) {
					Resource nextResource = (Resource) it.next();
					nextResource.unload();
				}
				if (myViewer != null) {
					myViewer.getControl().getDisplay().asyncExec(myViewerRefreshRunnable);
				}
				return true;
			}
		});
	}

	/**
	 * @generated
	 */
	public void dispose() {
		myWorkspaceSynchronizer.dispose();
		myWorkspaceSynchronizer = null;
		myViewerRefreshRunnable = null;
		for (Iterator it = myEditingDomain.getResourceSet().getResources().iterator(); it.hasNext();) {
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
			URI fileURI = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
			Resource resource = myEditingDomain.getResourceSet().getResource(fileURI, true);
			Collection result = new ArrayList();
			result.addAll(createNavigatorItems(selectViewsByType(resource.getContents(), org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageEditPart.MODEL_ID), file, false));
			return result.toArray();
		}

		if (parentElement instanceof org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup) {
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup group = (org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup) parentElement;
			return group.getChildren();
		}

		if (parentElement instanceof org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorItem) {
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorItem navigatorItem = (org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorItem) parentElement;
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
		switch (org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getVisualID(view)) {

		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup links = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_Package_79_links, "icons/linksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DependencyEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClass2EditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association2EditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association3EditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.GeneralizationEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceRealizationEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SubstitutionEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ElementImportEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageImportEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageMergeEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ProfileApplicationEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentAnnotatedElementEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintConstrainedElementEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			if (!links.isEmpty()) {
				result.add(links);
			}
			return result.toArray();
		}

		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.DependencyEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup incominglinks = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_Dependency_1001_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup outgoinglinks = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_Dependency_1001_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ElementImportEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentAnnotatedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintConstrainedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup incominglinks = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_AssociationClass_1002_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup outgoinglinks = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_AssociationClass_1002_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassAttributeCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PropertyEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClass2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClass2EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association2EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association3EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association3EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.GeneralizationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.GeneralizationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceRealizationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SubstitutionEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SubstitutionEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ElementImportEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ElementImportEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageImportEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentAnnotatedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintConstrainedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup incominglinks = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_Association_1003_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup outgoinglinks = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_Association_1003_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClass2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClass2EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association2EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association3EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association3EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.GeneralizationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.GeneralizationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SubstitutionEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SubstitutionEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ElementImportEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ElementImportEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageImportEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentAnnotatedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintConstrainedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup incominglinks = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_InstanceSpecification_1004_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup outgoinglinks = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_InstanceSpecification_1004_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationSlotCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SlotEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ElementImportEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentAnnotatedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintConstrainedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup incominglinks = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_Component_1005_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup outgoinglinks = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_Component_1005_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentAttributeCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PropertyEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentOperationCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.OperationEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentNestedClassifierCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClass2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClass2EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association2EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association3EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association3EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.GeneralizationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.GeneralizationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceRealizationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SubstitutionEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SubstitutionEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ElementImportEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ElementImportEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageImportEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentAnnotatedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintConstrainedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup incominglinks = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_Signal_1006_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup outgoinglinks = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_Signal_1006_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalAttributeCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClass2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClass2EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association2EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association3EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association3EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.GeneralizationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.GeneralizationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SubstitutionEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SubstitutionEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ElementImportEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ElementImportEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageImportEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentAnnotatedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintConstrainedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup incominglinks = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_Interface_1007_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup outgoinglinks = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_Interface_1007_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceAttributeCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property3EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceOperationCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceNestedClassifierCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class3EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClass2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClass2EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association2EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association3EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association3EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.GeneralizationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.GeneralizationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceRealizationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SubstitutionEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SubstitutionEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ElementImportEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ElementImportEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageImportEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentAnnotatedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintConstrainedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup incominglinks = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_Model_1008_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup outgoinglinks = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_Model_1008_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelPackageableElementCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecification2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelPackageableElementCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Component2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelPackageableElementCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Signal2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelPackageableElementCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Interface2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelPackageableElementCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Model2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelPackageableElementCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Enumeration2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelPackageableElementCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package3EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelPackageableElementCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class4EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelPackageableElementCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveType2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelPackageableElementCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataType2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelPackageableElementCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Comment2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelPackageableElementCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Constraint2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ElementImportEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ElementImportEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageImportEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageImportEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageMergeEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageMergeEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ProfileApplicationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentAnnotatedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintConstrainedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup incominglinks = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_Enumeration_1009_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup outgoinglinks = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_Enumeration_1009_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationEnumerationLiteralCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationLiteralEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClass2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClass2EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association2EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association3EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association3EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.GeneralizationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.GeneralizationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SubstitutionEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SubstitutionEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ElementImportEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ElementImportEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageImportEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentAnnotatedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintConstrainedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package2EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup incominglinks = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_Package_1010_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup outgoinglinks = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_Package_1010_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackagePackageableElementCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecification2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackagePackageableElementCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Component2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackagePackageableElementCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Signal2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackagePackageableElementCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Interface2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackagePackageableElementCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Model2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackagePackageableElementCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Enumeration2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackagePackageableElementCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package3EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackagePackageableElementCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class4EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackagePackageableElementCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveType2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackagePackageableElementCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataType2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackagePackageableElementCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Comment2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackagePackageableElementCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Constraint2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ElementImportEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ElementImportEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageImportEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageImportEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageMergeEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageMergeEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ProfileApplicationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentAnnotatedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintConstrainedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup incominglinks = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_Class_1011_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup outgoinglinks = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_Class_1011_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassOperationCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ReceptionEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassAttributeCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property4EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassOperationCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation3EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassNestedClassifierCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class5EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClass2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClass2EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association2EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association3EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association3EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.GeneralizationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.GeneralizationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceRealizationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SubstitutionEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SubstitutionEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ElementImportEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ElementImportEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageImportEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentAnnotatedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintConstrainedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup incominglinks = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_PrimitiveType_1012_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup outgoinglinks = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_PrimitiveType_1012_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClass2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClass2EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association2EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association3EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association3EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.GeneralizationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.GeneralizationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SubstitutionEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SubstitutionEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ElementImportEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ElementImportEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageImportEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentAnnotatedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintConstrainedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup incominglinks = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_DataType_1013_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup outgoinglinks = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_DataType_1013_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeAttributeCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property5EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeOperationCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation4EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClass2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClass2EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association2EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association3EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association3EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.GeneralizationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.GeneralizationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SubstitutionEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SubstitutionEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ElementImportEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ElementImportEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageImportEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentAnnotatedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintConstrainedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup incominglinks = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_Constraint_1014_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup outgoinglinks = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_Constraint_1014_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ElementImportEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentAnnotatedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintConstrainedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintConstrainedElementEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup incominglinks = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_Comment_1015_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup outgoinglinks = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_Comment_1015_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentAnnotatedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentAnnotatedElementEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintConstrainedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PropertyEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup incominglinks = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_Property_2001_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup outgoinglinks = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_Property_2001_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentAnnotatedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintConstrainedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.SlotEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup incominglinks = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_Slot_2002_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup outgoinglinks = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_Slot_2002_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentAnnotatedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintConstrainedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.OperationEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup incominglinks = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_Operation_2003_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup outgoinglinks = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_Operation_2003_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ElementImportEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageImportEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentAnnotatedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintConstrainedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class2EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup incominglinks = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_Class_2004_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup outgoinglinks = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_Class_2004_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClass2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClass2EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association2EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association3EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association3EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.GeneralizationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.GeneralizationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceRealizationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SubstitutionEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SubstitutionEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ElementImportEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ElementImportEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageImportEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentAnnotatedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintConstrainedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup incominglinks = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_RedefinableTemplateSignature_2005_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup outgoinglinks = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_RedefinableTemplateSignature_2005_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureTemplateParameterCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateParameterEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentAnnotatedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintConstrainedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateParameterEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup incominglinks = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_TemplateParameter_2006_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup outgoinglinks = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_TemplateParameter_2006_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentAnnotatedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintConstrainedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property2EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup incominglinks = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_Property_2007_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup outgoinglinks = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_Property_2007_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentAnnotatedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintConstrainedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property3EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup incominglinks = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_Property_2008_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup outgoinglinks = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_Property_2008_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentAnnotatedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintConstrainedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation2EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup incominglinks = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_Operation_2009_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup outgoinglinks = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_Operation_2009_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ElementImportEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageImportEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentAnnotatedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintConstrainedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class3EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup incominglinks = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_Class_2010_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup outgoinglinks = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_Class_2010_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClass2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClass2EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association2EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association3EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association3EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.GeneralizationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.GeneralizationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceRealizationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SubstitutionEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SubstitutionEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ElementImportEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ElementImportEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageImportEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentAnnotatedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintConstrainedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecification2EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup incominglinks = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_InstanceSpecification_2011_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup outgoinglinks = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_InstanceSpecification_2011_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationSlotCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SlotEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ElementImportEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentAnnotatedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintConstrainedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Component2EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup incominglinks = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_Component_2012_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup outgoinglinks = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_Component_2012_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentAttributeCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PropertyEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentOperationCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.OperationEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentNestedClassifierCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClass2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClass2EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association2EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association3EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association3EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.GeneralizationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.GeneralizationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceRealizationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SubstitutionEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SubstitutionEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ElementImportEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ElementImportEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageImportEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentAnnotatedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintConstrainedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Signal2EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup incominglinks = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_Signal_2013_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup outgoinglinks = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_Signal_2013_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalAttributeCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClass2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClass2EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association2EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association3EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association3EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.GeneralizationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.GeneralizationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SubstitutionEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SubstitutionEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ElementImportEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ElementImportEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageImportEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentAnnotatedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintConstrainedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Interface2EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup incominglinks = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_Interface_2014_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup outgoinglinks = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_Interface_2014_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceAttributeCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property3EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceOperationCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceNestedClassifierCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class3EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClass2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClass2EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association2EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association3EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association3EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.GeneralizationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.GeneralizationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceRealizationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SubstitutionEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SubstitutionEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ElementImportEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ElementImportEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageImportEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentAnnotatedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintConstrainedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Model2EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup incominglinks = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_Model_2015_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup outgoinglinks = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_Model_2015_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelPackageableElementCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecification2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelPackageableElementCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Component2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelPackageableElementCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Signal2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelPackageableElementCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Interface2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelPackageableElementCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Model2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelPackageableElementCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Enumeration2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelPackageableElementCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package3EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelPackageableElementCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class4EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelPackageableElementCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveType2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelPackageableElementCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataType2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelPackageableElementCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Comment2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelPackageableElementCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Constraint2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ElementImportEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ElementImportEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageImportEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageImportEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageMergeEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageMergeEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ProfileApplicationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentAnnotatedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintConstrainedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Enumeration2EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup incominglinks = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_Enumeration_2016_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup outgoinglinks = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_Enumeration_2016_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationEnumerationLiteralCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationLiteralEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClass2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClass2EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association2EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association3EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association3EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.GeneralizationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.GeneralizationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SubstitutionEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SubstitutionEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ElementImportEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ElementImportEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageImportEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentAnnotatedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintConstrainedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationLiteralEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup incominglinks = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_EnumerationLiteral_2017_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup outgoinglinks = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_EnumerationLiteral_2017_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ElementImportEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentAnnotatedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintConstrainedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package3EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup incominglinks = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_Package_2018_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup outgoinglinks = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_Package_2018_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackagePackageableElementCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecification2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackagePackageableElementCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Component2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackagePackageableElementCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Signal2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackagePackageableElementCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Interface2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackagePackageableElementCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Model2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackagePackageableElementCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Enumeration2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackagePackageableElementCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package3EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackagePackageableElementCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class4EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackagePackageableElementCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveType2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackagePackageableElementCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataType2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackagePackageableElementCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Comment2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackagePackageableElementCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Constraint2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ElementImportEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ElementImportEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageImportEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageImportEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageMergeEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageMergeEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ProfileApplicationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentAnnotatedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintConstrainedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class4EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup incominglinks = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_Class_2019_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup outgoinglinks = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_Class_2019_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassOperationCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ReceptionEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassAttributeCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property4EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassOperationCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation3EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassNestedClassifierCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class5EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClass2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClass2EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association2EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association3EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association3EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.GeneralizationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.GeneralizationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceRealizationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SubstitutionEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SubstitutionEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ElementImportEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ElementImportEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageImportEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentAnnotatedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintConstrainedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ReceptionEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup incominglinks = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_Reception_2020_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup outgoinglinks = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_Reception_2020_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ElementImportEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageImportEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentAnnotatedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintConstrainedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property4EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup incominglinks = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_Property_2021_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup outgoinglinks = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_Property_2021_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentAnnotatedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintConstrainedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation3EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup incominglinks = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_Operation_2022_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup outgoinglinks = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_Operation_2022_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ElementImportEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageImportEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentAnnotatedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintConstrainedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class5EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup incominglinks = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_Class_2023_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup outgoinglinks = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_Class_2023_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClass2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClass2EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association2EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association3EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association3EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.GeneralizationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.GeneralizationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceRealizationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SubstitutionEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SubstitutionEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ElementImportEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ElementImportEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageImportEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentAnnotatedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintConstrainedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveType2EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup incominglinks = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_PrimitiveType_2024_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup outgoinglinks = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_PrimitiveType_2024_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClass2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClass2EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association2EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association3EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association3EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.GeneralizationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.GeneralizationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SubstitutionEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SubstitutionEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ElementImportEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ElementImportEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageImportEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentAnnotatedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintConstrainedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataType2EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup incominglinks = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_DataType_2025_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup outgoinglinks = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_DataType_2025_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeAttributeCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property5EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeOperationCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews, org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation4EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getChildrenByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement, false));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClass2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClass2EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association2EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association3EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association3EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.GeneralizationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.GeneralizationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SubstitutionEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SubstitutionEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ElementImportEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ElementImportEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageImportEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentAnnotatedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintConstrainedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property5EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup incominglinks = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_Property_2026_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup outgoinglinks = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_Property_2026_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentAnnotatedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintConstrainedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation4EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup incominglinks = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_Operation_2027_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup outgoinglinks = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_Operation_2027_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ElementImportEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageImportEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentAnnotatedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintConstrainedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Comment2EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup incominglinks = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_Comment_2028_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup outgoinglinks = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_Comment_2028_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentAnnotatedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentAnnotatedElementEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintConstrainedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Constraint2EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup incominglinks = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_Constraint_2029_incominglinks, "icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup outgoinglinks = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_Constraint_2029_outgoinglinks, "icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ElementImportEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentAnnotatedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintConstrainedElementEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintConstrainedElementEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews, outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews, incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentLinkDescriptorEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup target = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_Link_3001_target, "icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup source = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_Link_3001_source, "icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DependencyEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PropertyEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SlotEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.OperationEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateParameterEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property3EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class3EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecification2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Component2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Signal2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Interface2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Model2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Enumeration2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationLiteralEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package3EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class4EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ReceptionEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property4EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation3EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class5EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveType2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataType2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property5EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation4EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Comment2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Constraint2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DependencyEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PropertyEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SlotEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.OperationEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateParameterEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property3EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class3EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecification2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Component2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Signal2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Interface2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Model2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Enumeration2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationLiteralEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package3EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class4EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ReceptionEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property4EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation3EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class5EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveType2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataType2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property5EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation4EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Comment2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Constraint2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClass2EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup target = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_AssociationClass_3002_target, "icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup source = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_AssociationClass_3002_source, "icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class3EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Component2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Signal2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Interface2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Enumeration2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class4EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class5EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveType2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataType2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class3EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Component2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Signal2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Interface2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Enumeration2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class4EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class5EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveType2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataType2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association2EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup target = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_Association_3003_target, "icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup source = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_Association_3003_source, "icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class3EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Component2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Signal2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Interface2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Enumeration2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class4EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class5EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveType2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataType2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class3EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Component2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Signal2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Interface2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Enumeration2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class4EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class5EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveType2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataType2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Association3EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup target = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_Association_3004_target, "icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup source = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_Association_3004_source, "icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class3EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Component2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Signal2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Interface2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Enumeration2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class4EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class5EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveType2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataType2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class3EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Component2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Signal2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Interface2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Enumeration2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class4EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class5EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveType2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataType2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.GeneralizationEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup target = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_Generalization_3005_target, "icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup source = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_Generalization_3005_source, "icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class3EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Component2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Signal2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Interface2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Enumeration2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class4EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class5EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveType2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataType2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class3EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Component2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Signal2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Interface2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Enumeration2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class4EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class5EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveType2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataType2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceRealizationEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup target = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_InterfaceRealization_3006_target, "icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup source = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_InterfaceRealization_3006_source, "icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Interface2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class3EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Component2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class4EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class5EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.SubstitutionEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup target = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_Substitution_3007_target, "icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup source = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_Substitution_3007_source, "icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class3EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Component2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Signal2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Interface2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Enumeration2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class4EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class5EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveType2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataType2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class3EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Component2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Signal2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Interface2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Enumeration2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class4EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class5EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveType2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataType2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.RealizationEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup target = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_Realization_3008_target, "icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup source = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_Realization_3008_source, "icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DependencyEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PropertyEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.OperationEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property3EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class3EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecification2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Component2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Signal2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Interface2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Model2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Enumeration2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationLiteralEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package3EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class4EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ReceptionEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property4EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation3EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class5EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveType2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataType2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property5EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation4EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Constraint2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DependencyEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PropertyEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.OperationEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property3EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class3EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecification2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Component2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Signal2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Interface2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Model2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Enumeration2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationLiteralEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package3EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class4EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ReceptionEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property4EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation3EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class5EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveType2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataType2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property5EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation4EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Constraint2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.AbstractionEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup target = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_Abstraction_3009_target, "icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup source = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_Abstraction_3009_source, "icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DependencyEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PropertyEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.OperationEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property3EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class3EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecification2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Component2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Signal2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Interface2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Model2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Enumeration2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationLiteralEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package3EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class4EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ReceptionEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property4EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation3EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class5EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveType2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataType2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property5EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation4EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Constraint2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DependencyEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PropertyEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.OperationEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property3EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class3EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecification2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Component2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Signal2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Interface2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Model2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Enumeration2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationLiteralEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package3EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class4EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ReceptionEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property4EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation3EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class5EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveType2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataType2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property5EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation4EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Constraint2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.UsageEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup target = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_Usage_3010_target, "icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup source = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_Usage_3010_source, "icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DependencyEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PropertyEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.OperationEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property3EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class3EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecification2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Component2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Signal2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Interface2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Model2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Enumeration2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationLiteralEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package3EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class4EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ReceptionEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property4EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation3EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class5EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveType2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataType2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property5EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation4EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Constraint2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DependencyEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PropertyEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.OperationEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property3EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class3EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecification2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Component2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Signal2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Interface2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Model2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Enumeration2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationLiteralEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package3EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class4EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ReceptionEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property4EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation3EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class5EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveType2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataType2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property5EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation4EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Constraint2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency2EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup target = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_Dependency_3011_target, "icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup source = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_Dependency_3011_source, "icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DependencyEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PropertyEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.OperationEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property3EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class3EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecification2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Component2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Signal2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Interface2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Model2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Enumeration2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationLiteralEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package3EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class4EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ReceptionEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property4EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation3EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class5EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveType2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataType2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property5EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation4EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Constraint2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DependencyEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PropertyEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.OperationEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property3EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class3EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecification2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Component2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Signal2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Interface2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Model2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Enumeration2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationLiteralEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package3EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class4EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ReceptionEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property4EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation3EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class5EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveType2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataType2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property5EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation4EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Constraint2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.Dependency3EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup target = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_Dependency_3012_target, "icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup source = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_Dependency_3012_source, "icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DependencyEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PropertyEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.OperationEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property3EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class3EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecification2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Component2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Signal2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Interface2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Model2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Enumeration2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationLiteralEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package3EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class4EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ReceptionEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property4EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation3EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class5EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveType2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataType2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property5EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation4EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Constraint2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DependencyEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PropertyEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.OperationEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property3EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class3EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecification2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Component2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Signal2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Interface2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Model2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Enumeration2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationLiteralEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package3EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class4EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ReceptionEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property4EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation3EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class5EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveType2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataType2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property5EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation4EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Constraint2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ElementImportEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup target = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_ElementImport_3013_target, "icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup source = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_ElementImport_3013_source, "icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DependencyEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class3EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecification2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Component2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Signal2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Interface2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Model2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Enumeration2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationLiteralEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package3EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class4EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class5EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveType2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataType2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Constraint2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.OperationEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class3EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Component2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Signal2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Interface2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Model2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Enumeration2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package3EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class4EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ReceptionEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation3EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class5EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveType2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataType2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation4EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageImportEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup target = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_PackageImport_3014_target, "icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup source = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_PackageImport_3014_source, "icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Model2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package3EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.OperationEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class3EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Component2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Signal2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Interface2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Model2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Enumeration2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package3EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class4EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ReceptionEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation3EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class5EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveType2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataType2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation4EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageMergeEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup target = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_PackageMerge_3015_target, "icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup source = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_PackageMerge_3015_source, "icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Model2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package3EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Model2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package3EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ProfileApplicationEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup source = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_ProfileApplication_3016_source, "icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Model2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package3EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentAnnotatedElementEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup target = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_CommentAnnotatedElement_3017_target, "icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup source = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_CommentAnnotatedElement_3017_source, "icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DependencyEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PropertyEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SlotEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.OperationEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateParameterEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property3EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class3EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecification2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Component2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Signal2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Interface2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Model2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Enumeration2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationLiteralEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package3EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class4EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ReceptionEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property4EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation3EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class5EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveType2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataType2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property5EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation4EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Comment2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Constraint2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Comment2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintConstrainedElementEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup target = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_ConstraintConstrainedElement_3018_target, "icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup source = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_ConstraintConstrainedElement_3018_source, "icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DependencyEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PropertyEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SlotEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.OperationEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateParameterEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property3EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class3EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecification2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Component2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Signal2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Interface2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Model2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Enumeration2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationLiteralEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package3EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class4EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ReceptionEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property4EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation3EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class5EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveType2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataType2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property5EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation4EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Comment2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Constraint2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Constraint2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateBindingEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup target = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_TemplateBinding_3019_target, "icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup source = new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorGroup(
					org.eclipse.papyrus.diagram.clazzBis.part.Messages.NavigatorGroupName_TemplateBinding_3019_source, "icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DependencyEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PropertyEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SlotEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.OperationEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.TemplateParameterEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property3EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class3EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecification2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Component2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Signal2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Interface2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Model2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Enumeration2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationLiteralEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package3EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class4EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ReceptionEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property4EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation3EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class5EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveType2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataType2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property5EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation4EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Comment2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksTargetByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Constraint2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PropertyEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.OperationEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property3EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class3EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Component2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Signal2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Interface2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Model2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Enumeration2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package3EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class4EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property4EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation3EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class5EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveType2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataType2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Property5EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			connectedViews = getLinksSourceByType(Collections.singleton(view), org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
					.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.Operation4EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source, true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
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
			if (type.equals(nextEdgeSource.getType()) && isOwnView(nextEdgeSource)) {
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
			if (type.equals(nextEdgeTarget.getType()) && isOwnView(nextEdgeTarget)) {
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
		return org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageEditPart.MODEL_ID.equals(org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getModelID(view));
	}

	/**
	 * @generated
	 */
	private Collection createNavigatorItems(Collection views, Object parent, boolean isLeafs) {
		Collection result = new ArrayList();
		for (Iterator it = views.iterator(); it.hasNext();) {
			result.add(new org.eclipse.papyrus.diagram.clazzBis.navigator.UMLNavigatorItem((View) it.next(), parent, isLeafs));
		}
		return result;
	}

	/**
	 * @generated
	 */
	public Object getParent(Object element) {
		if (element instanceof org.eclipse.papyrus.diagram.clazzBis.navigator.UMLAbstractNavigatorItem) {
			org.eclipse.papyrus.diagram.clazzBis.navigator.UMLAbstractNavigatorItem abstractNavigatorItem = (org.eclipse.papyrus.diagram.clazzBis.navigator.UMLAbstractNavigatorItem) element;
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
