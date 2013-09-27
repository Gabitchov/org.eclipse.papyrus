/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.views.documentation.view;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.dialogs.FilteredTree;
import org.eclipse.ui.dialogs.ISelectionStatusValidator;
import org.eclipse.ui.dialogs.PatternFilter;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.ui.progress.UIJob;
import org.eclipse.ui.views.navigator.ResourceComparator;

/**
 * This dialog displays a EMF files within the workspace. Each file will show its content as and EMF resource.
 * 
 * Use the filters parameter on the factory method to hide elements.
 * 
 * @author Alfredo
 * 
 */
public class SelectResourceDialog extends ElementTreeSelectionDialog
{

    public static Object openElementSelection(Object input, ISelectionStatusValidator validator, List<ViewerFilter> viewerFilters, boolean filterTree)
    {

        return openElementSelection(input, null, null, validator, viewerFilters, filterTree);
    }

    public static Object openElementSelection(Object input, ILabelProvider labelProvider, ITreeContentProvider contentProvider, ISelectionStatusValidator validator, List<ViewerFilter> viewerFilters, boolean filterTree)
    {

        if (contentProvider == null)
            contentProvider = new SelectionContentProvider();

        if (labelProvider == null)
            labelProvider = new SelectionLabelProvider();

        Shell parent = Display.getCurrent().getActiveShell();
        SelectResourceDialog dialog = new SelectResourceDialog(parent, validator, labelProvider, contentProvider, filterTree);
        dialog.setAllowMultiple(false);
        dialog.setTitle("Import from model");
        dialog.setMessage("Select the element to import\nWARNING: Stereotypes will not be retrieved from the import model");

        dialog.addFilter(dialog.createDefaultViewerFilter(true));
        if (viewerFilters != null)
        {
            for (ViewerFilter viewerFilter : viewerFilters)
            {
                dialog.addFilter(viewerFilter);
            }
        }

        dialog.setInput(input);
        return dialog.open() == Window.OK ? dialog.getSelection() : null;
    }

    private boolean hasFilteredTree = true;

    private SelectResourceDialog(Shell parent, ISelectionStatusValidator validator, ILabelProvider labelProvider, ITreeContentProvider contentProvider, boolean hasFilteredTree)
    {
        super(parent, labelProvider, contentProvider);
        setComparator(new ResourceComparator(ResourceComparator.NAME));
        setValidator(validator);
        this.hasFilteredTree = hasFilteredTree;
    }

    @Override
    protected Control createDialogArea(Composite parent)
    {
        Composite composite = (Composite) super.createDialogArea(parent);
        applyDialogFont(composite);
        return composite;
    }

    @Override
    protected TreeViewer doCreateTreeViewer(Composite parent, int style)
    {
        TreeViewer viewer;
        if (hasFilteredTree)
        {
            FilteredTree tree = new FilteredTree(parent, style, new PatternFilter(), true);
            viewer = tree.getViewer();
        }
        else
        {
            viewer = new TreeViewer(parent, style);
        }
        return viewer;
    }

    public Object getSelection()
    {
        Object[] result = getResult();
        if (result.length == 1)
            return result[0];
        return null;
    }

    private ViewerFilter createDefaultViewerFilter(boolean showFiles)
    {
        return new ViewerFilter()
        {
            @Override
            public boolean select(Viewer viewer, Object parentElement, Object element)
            {
                if (element instanceof IResource)
                {
                    IResource workspaceResource = (IResource) element;
                    return workspaceResource.isAccessible();
                }
                return true;
            }
        };
    }

    // Content provider for the selection dialog displaying a tree
    public static class SelectionContentProvider implements ITreeContentProvider, IResourceChangeListener, IResourceDeltaVisitor
    {

        private WorkbenchContentProvider resourceContentProvider = new WorkbenchContentProvider();

        private AdapterFactoryContentProvider adapterFactoryContentProvider = new AdapterFactoryContentProvider(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));

        private ResourceSet resourceSet = new ResourceSetImpl();

        private Viewer viewer;

        public SelectionContentProvider()
        {
            ResourcesPlugin.getWorkspace().addResourceChangeListener(this, IResourceChangeEvent.POST_CHANGE);
        }

        public Object[] getChildren(Object parentElement)
        {
            try
            {
                if (parentElement instanceof IFile)
                {
                    String path = ((IFile) parentElement).getFullPath().toString();
                    URI uri = URI.createPlatformResourceURI(path, true);
                    parentElement = resourceSet.getResource(uri, true);
                }
                if (parentElement instanceof IResource)
                {
                    return resourceContentProvider.getChildren(parentElement);
                }
            }
            catch (Exception e)
            {
                return new Object[0];
            }
            return adapterFactoryContentProvider.getChildren(parentElement);
        }

        public Object getParent(Object element)
        {

            if (element instanceof IResource)
                return resourceContentProvider.getParent(element);

            return adapterFactoryContentProvider.getParent(element);
        }

        public boolean hasChildren(Object element)
        {
            if (element instanceof IFile)
                return ((IFile) element).isAccessible() && !((IFile) element).isHidden();
            if (element instanceof IResource)
                return resourceContentProvider.hasChildren(element);
            return adapterFactoryContentProvider.hasChildren(element);
        }

        public Object[] getElements(Object inputElement)
        {
            return getChildren(inputElement);
        }

        public void inputChanged(Viewer viewer, Object oldInput, Object newInput)
        {
            this.viewer = viewer;
        }

        /**
         * @see org.eclipse.core.resources.IResourceChangeListener#resourceChanged(org.eclipse.core.resources.IResourceChangeEvent)
         */
        public void resourceChanged(IResourceChangeEvent event)
        {
            IResourceDelta delta = event.getDelta();
            try
            {
                delta.accept(this);
            }
            catch (CoreException e)
            {
            }
        }

        /**
         * @see org.eclipse.jface.viewers.IContentProvider#dispose()
         */
        public void dispose()
        {
            ResourcesPlugin.getWorkspace().removeResourceChangeListener(this);

            resourceContentProvider.dispose();
            adapterFactoryContentProvider.dispose();
        }

        /**
         * @see org.eclipse.core.resources.IResourceDeltaVisitor#visit(org.eclipse.core.resources.IResourceDelta)
         */
        public boolean visit(IResourceDelta delta)
        {
            IResource source = delta.getResource();

            switch (delta.getKind())
            {
                case IResourceDelta.ADDED:
                    // handle added resource
                    break;
                case IResourceDelta.REMOVED:
                    // handle removed resource
                    break;
                case IResourceDelta.CHANGED:
                    // handle changed resource
                    if (source instanceof IFile)
                    {
                        final IFile file = (IFile) source;
                        Resource oldResource = resourceSet.getResource(URI.createPlatformResourceURI(file.getFullPath().toString(), true), false);
                        if (oldResource != null)
                        {
                            oldResource.unload();
                        }
                        new UIJob("Update the Model in TopcasedViewer")
                        {
                            public IStatus runInUIThread(IProgressMonitor monitor)
                            {
                                if (viewer != null && !viewer.getControl().isDisposed())
                                    ((StructuredViewer) viewer).refresh(file);
                                return Status.OK_STATUS;
                            }
                        }.schedule();
                    }
                    break;
            }
            return true;
        }
    }

    // Label provider for the dialog displaying a tree
    private static class SelectionLabelProvider implements ILabelProvider
    {

        private WorkbenchLabelProvider resourceLabelProvider = new WorkbenchLabelProvider();

        private AdapterFactoryLabelProvider adapterFactoryLabelProvider = new AdapterFactoryLabelProvider(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));

        public Image getImage(Object element)
        {

            if (element instanceof IResource)
                return resourceLabelProvider.getImage(element);
            return adapterFactoryLabelProvider.getImage(element);
        }

        public String getText(Object element)
        {
            if (element instanceof IResource)
                return resourceLabelProvider.getText(element);
            return adapterFactoryLabelProvider.getText(element);
        }

        public void addListener(ILabelProviderListener listener)
        {
            resourceLabelProvider.addListener(listener);
            adapterFactoryLabelProvider.addListener(listener);
        }

        public void dispose()
        {
            resourceLabelProvider.dispose();
            adapterFactoryLabelProvider.dispose();

        }

        public boolean isLabelProperty(Object element, String property)
        {
            if (element instanceof IResource)
                return resourceLabelProvider.isLabelProperty(element, property);
            return adapterFactoryLabelProvider.isLabelProperty(element, property);
        }

        public void removeListener(ILabelProviderListener listener)
        {
            resourceLabelProvider.removeListener(listener);
            adapterFactoryLabelProvider.removeListener(listener);
        }
    }
}