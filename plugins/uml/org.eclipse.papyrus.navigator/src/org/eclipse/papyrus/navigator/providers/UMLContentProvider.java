/*******************************************************************************
 * Copyright (c) 2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *     Francisco Javier Cano Muñoz (Prodevelop) - solve bug #290422
 *******************************************************************************/
package org.eclipse.papyrus.navigator.providers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.IWrapperItemProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.core.utils.DiResourceSet;
import org.eclipse.papyrus.core.utils.EditorUtils;
import org.eclipse.papyrus.navigator.ModelNavigator;
import org.eclipse.papyrus.navigator.factory.GroupableAdapterFactory;
import org.eclipse.papyrus.navigator.internal.AdditionalResources;
import org.eclipse.papyrus.navigator.internal.utils.NavigatorUtils;
import org.eclipse.papyrus.sasheditor.contentprovider.di.IPageMngr;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.navigator.CommonNavigator;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.PackageImport;

/**
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano Muñoz</a>
 * @see <a href=https://bugs.eclipse.org/bugs/show_bug.cgi?id=290422>Bug #290422</a>
 */
public class UMLContentProvider extends AdapterFactoryContentProvider implements IContentProvider {

	private static final Object[] EMPTY_ARRAY = new Object[0];

	protected DiResourceSet diResourceSet;

	/** The list of open pages (diagrams) */
	protected IPageMngr pageMngr;

	/** {@link ICommonContentExtensionSite} as given in initialization. */
	protected ICommonContentExtensionSite contentExtensionSite = null;

	/**
	 * {@link ComposedAdapterFactory} used to get the adapters to content providers.
	 */
	protected static ComposedAdapterFactory umlComposedAdapterFactory = NavigatorComposedAdapterFactory.getAdapterFactory();

	/**
	 * Factory to adapt children grouping elements
	 */
	protected static GroupableAdapterFactory groupableFactory = new GroupableAdapterFactory(umlComposedAdapterFactory);

	public UMLContentProvider() {
		super(umlComposedAdapterFactory);
	}

	public void init(ICommonContentExtensionSite config) {
		this.contentExtensionSite = config;
	}

	public void restoreState(IMemento memento) {
		// TODO
	}

	public void saveState(IMemento memento) {
		// TODO
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean hasChildren(Object element) {
		if(element instanceof Diagram) {
			return false;
		}
		if(element instanceof PackageImport) {
			return ((PackageImport)element).getImportedPackage().getPackagedElements().size() > 0;

		}
		return getChildren(element).length > 0;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object[] getChildren(Object parentElement) {
		// Only display diagram (no graphNodes or graphEdges)
		if(parentElement instanceof Diagram) {
			return EMPTY_ARRAY;
		}
		if(parentElement instanceof AdditionalResources) {
			return ((AdditionalResources)parentElement).getResources().toArray();
		}

		// fjcano #290422 :: add "Group children" action.
		// if grouping is enabled, return the children in a folder organization
		if(getModelNavigator() != null && getModelNavigator().isGroupingChildsEnabled() && groupableFactory.isFactoryForType(ITreeItemContentProvider.class)) {
			ITreeItemContentProvider provider = (ITreeItemContentProvider)groupableFactory.adapt(parentElement, ITreeItemContentProvider.class);
			return provider == null ? null : provider.getChildren(parentElement).toArray();
		}

		// In the case of a domain element :
		List<Object> children = new ArrayList<Object>();

		// 1. Retrieve children elements
		Object[] modelChildren = super.getChildren(parentElement);
		for(Object child : modelChildren) {
			children.add(child);
		}
		if(parentElement instanceof PackageImport) {
			Object[] importedChildren = super.getChildren(((PackageImport)parentElement).getImportedPackage());
			for(Object child : importedChildren) {
				children.add(child);
			}
		}

		// 2. and associated diagrams
		if(parentElement instanceof EObject || parentElement instanceof IWrapperItemProvider || parentElement instanceof FeatureMap.Entry) {
			Object object = AdapterFactoryEditingDomain.unwrap(parentElement);
			if(object instanceof Element) {
				Element owner = (Element)object;
				if(owner != null) {
					children.addAll(findAllExistingDiagrams(owner));
				}
			}
		}
		return children.toArray();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object getParent(Object element) {
		/*
		 * if (object instanceof IFile) return ((IResource) object).getParent(); return
		 * super.getParent(object);
		 */
		if(getModelNavigator() != null && getModelNavigator().isGroupingChildsEnabled() && groupableFactory.isFactoryForType(ITreeItemContentProvider.class)) {
			ITreeItemContentProvider provider = (ITreeItemContentProvider)groupableFactory.adapt(element, ITreeItemContentProvider.class);
			return provider == null ? null : provider.getParent(element);
		}

		// Delegates
		if(element instanceof IWrapperItemProvider || element instanceof FeatureMap.Entry || element instanceof EObject) {
			return super.getParent(element);
		}

		return null;
	}

	@Override
	public Object[] getElements(Object object) {

		if(canPopulateModelNavigator()) {
			this.diResourceSet = getDiResourceSet();
			pageMngr = EditorUtils.getIPageMngr(diResourceSet.getDiResource());

			Resource modelResource = diResourceSet.getModelResource();
			List<Object> children = new ArrayList<Object>(modelResource.getContents());
			AdditionalResources resources = new AdditionalResources(diResourceSet);
			children.add(resources);
			// hookListeners();
			return children.toArray();
		}
		// TODO check //WorkspaceRoot for physical representation
		return EMPTY_ARRAY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void dispose() {
		// Dispose objects
		super.dispose();
	}

	/**
	 * @param owner
	 *        the owner of the diagrams
	 * @return the list of diagrams contained by the given owner
	 */
	private List<Diagram> findAllExistingDiagrams(Element owner) {
		ArrayList<Diagram> diagrams = new ArrayList<Diagram>();

		// Walk on page (Diagram) references
		for(Object page : pageMngr.allPages()) {
			if(!(page instanceof Diagram)) {
				continue;
			}
			// We have a GMF Diagram
			Diagram diagram = (Diagram)page;
			if(owner.equals(diagram.getElement())) {
				diagrams.add(diagram);
			}

		}

		return diagrams;
	}

	private boolean canPopulateModelNavigator() {
		return (EditorUtils.getMultiDiagramEditor() != null);
	}

	private DiResourceSet getDiResourceSet() {
		return EditorUtils.getDiResourceSet();
	}

	/**
	 * Override this method if you want to execute additional actions when the resource is modified
	 * 
	 * @param event
	 */
	public void resourceSetChanged(ResourceSetChangeEvent event) {
		for(Object o : event.getNotifications()) {
			if(o instanceof Notification) {
				Notification n = (Notification)o;
				if(n.getEventType() == Notification.ADD) {
					if(getCommonNavigator() != null) {
						getCommonNavigator().getCommonViewer().setSelection(new StructuredSelection(n.getNewValue()));
					}
				}
			}

		}
	}

	/**
	 * Gets the <CommonNavigator>. This content provider is associated to, via the viewer ID.
	 * 
	 * @return the common navigator
	 */
	protected CommonNavigator getCommonNavigator() {
		IViewPart part = NavigatorUtils.findViewPart(getViewerID());
		if(part instanceof CommonNavigator) {
			return ((CommonNavigator)part);
		}
		return null;
	}

	protected ModelNavigator getModelNavigator() {
		CommonNavigator nav = getCommonNavigator();
		return nav instanceof ModelNavigator ? (ModelNavigator)nav : null;
	}

	protected String getViewerID() {
		return contentExtensionSite.getExtensionStateModel().getViewerId();
	}

}
