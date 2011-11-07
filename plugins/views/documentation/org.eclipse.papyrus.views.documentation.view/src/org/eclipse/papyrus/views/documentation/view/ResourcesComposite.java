/*******************************************************************************
 * Copyright (c) 2005, 2008 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Sciamma (Anyware Technologies) - initial API and implementation 
 *    Mathieu Garcia (Anyware Technologies) - initial API and implementation
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 *    Thomas Friol (Anyware Technologies) - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.views.documentation.view;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.content.IContentType;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.views.documentation.DocumentationUnsupportedException;
import org.eclipse.papyrus.views.documentation.IDocumentationManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorRegistry;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ResourceSelectionDialog;
import org.eclipse.ui.editors.text.EditorsUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.model.WorkbenchLabelProvider;

/**
 * A class defining a composite to edit the resources of a EModelElement as an EAnnotation. <br>
 * Creation : 10 oct. 2005
 * 
 * @author <a href="mailto:thomas.friol@anyware-tech.com">Thomas FRIOL</a>
 */
public class ResourcesComposite extends DocPageComposite
{
    private TreeViewer resourcesList;

    private Button addResourcesButton;

    private Button removeResourcesButton;

    private Button editResourceButton;

    private ISelectionChangedListener selectionChangedListener;

    private SelectionListener buttonSelectionListener;

    private IDoubleClickListener listDoubleClickListener;

    private KeyListener listKeyListener;

    /**
     * Constructor.
     * 
     * @param parent the parent composite
     * @param style the composite style
     * @param editingDomainProvider the provider of editing domain to execute commands
     */
    public ResourcesComposite(Composite parent, int style)
    {
        super(parent, style);
    }

    /**
     * @see org.topcased.modeler.documentation.DocPageComposite#createContents(org.eclipse.swt.widgets.Composite)
     */
    protected void createContents(Composite parent)
    {
        selectionChangedListener = new ISelectionChangedListener()
        {
            public void selectionChanged(SelectionChangedEvent event)
            {
                handleResourcesListSelectionChanged();
            }

        };
        buttonSelectionListener = new SelectionAdapter()
        {
            public void widgetSelected(SelectionEvent e)
            {
                if (e.getSource() == addResourcesButton)
                {
                    handleAddResources();
                }
                else if (e.getSource() == removeResourcesButton)
                {
                    handleRemoveResources();
                }
                else if (e.getSource() == editResourceButton)
                {
                    handleEditResource();
                }
            }
        };

        listDoubleClickListener = new IDoubleClickListener()
        {
            public void doubleClick(DoubleClickEvent event)
            {
                handleOpenResource();
            }
        };

        listKeyListener = new KeyAdapter()
        {
            public void keyPressed(KeyEvent e)
            {
                if (e.keyCode == SWT.DEL)
                {
                    handleRemoveResources();
                }
            }
        };

        resourcesList = new TreeViewer(parent, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL);
        resourcesList.getTree().setLayoutData(new GridData(GridData.FILL_BOTH));
        resourcesList.setContentProvider(new ArrayTreeContentProvider());
        resourcesList.setLabelProvider(new ResourcesLabelProvider());
        resourcesList.addSelectionChangedListener(selectionChangedListener);
        resourcesList.addDoubleClickListener(listDoubleClickListener);
        resourcesList.getTree().addKeyListener(listKeyListener);

        Composite actionsComp = new Composite(parent, SWT.NONE);
        actionsComp.setLayout(new GridLayout(3, true));
        actionsComp.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_CENTER));

        addResourcesButton = new Button(actionsComp, SWT.PUSH);
        addResourcesButton.setText(Messages.ResourcesComposite_add);
        addResourcesButton.setLayoutData(new GridData(GridData.FILL_BOTH));
        addResourcesButton.addSelectionListener(buttonSelectionListener);

        removeResourcesButton = new Button(actionsComp, SWT.PUSH);
        removeResourcesButton.setText(Messages.ResourcesComposite_remove);
        removeResourcesButton.setLayoutData(new GridData(GridData.FILL_BOTH));
        removeResourcesButton.addSelectionListener(buttonSelectionListener);

        editResourceButton = new Button(actionsComp, SWT.PUSH);
        editResourceButton.setText(Messages.ResourcesComposite_edit);
        editResourceButton.setLayoutData(new GridData(GridData.FILL_BOTH));
        editResourceButton.addSelectionListener(buttonSelectionListener);
    }

    /**
     * @see org.topcased.modeler.documentation.DocPageComposite#refresh()
     */
    protected void refresh()
    {
        resourcesList.setInput(null);
        resourcesList.getTree().setEnabled(getDocumentedElement() != null);
        addResourcesButton.setEnabled(getDocumentedElement() != null);
        removeResourcesButton.setEnabled(false);
        editResourceButton.setEnabled(false);
        if (getDocumentedElement() != null)
        {
        	IWorkbenchPart activePart = getActivePart();
        	IDocumentationPartHandler documentationPartHandler = DocumentionPartHandlerRegistry.getInstance().getDocumentationPartHandler(activePart);
        	if (documentationPartHandler != null) {
            	try {
            		if (documentationPartHandler != null) {
            			EObject associatedDiagram = documentationPartHandler.getAssociatedDiagram(activePart, getDocumentedElement());
            			EObject toDocument = associatedDiagram == null ? getDocumentedElement() : associatedDiagram;
            			List<URI> resources = documentationPartHandler.getDocumentationManager().getAssociatedResources(toDocument);
            			resourcesList.setInput(resources);
            		}
        		} catch (DocumentationUnsupportedException e) {
        		}
        	}
        }
    }

    protected IDocumentationPartHandler getDocumentationPartHandler(IWorkbenchPart part) {
    	if (getDocumentedElement() != null)
        {
        	return DocumentionPartHandlerRegistry.getInstance().getDocumentationPartHandler(part);
        }
    	return null;
    }

    protected Command getAddAssociatedResourceCommand(URI uriResource) {
    	IDocumentationPartHandler documentationPartHandler = getDocumentationPartHandler(getActivePart());
    	if (documentationPartHandler != null) {
			EObject associatedDiagram = documentationPartHandler.getAssociatedDiagram(getActivePart(), getDocumentedElement());
			EObject toDocument = associatedDiagram == null ? getDocumentedElement() : associatedDiagram;
    		IDocumentationManager documentationManager = documentationPartHandler.getDocumentationManager();
    		if (documentationManager != null) {
    			return documentationManager.getAddAssociatedResourceCommand(toDocument, uriResource);
    		}
    	}
    	return null;
    }

    protected Command getRemoveAssociatedResourceCommand(URI uriResource) {
    	IDocumentationPartHandler documentationPartHandler = getDocumentationPartHandler(getActivePart());
    	if (documentationPartHandler != null) {
			EObject associatedDiagram = documentationPartHandler.getAssociatedDiagram(getActivePart(), getDocumentedElement());
			EObject toDocument = associatedDiagram == null ? getDocumentedElement() : associatedDiagram;
    		IDocumentationManager documentationManager = documentationPartHandler.getDocumentationManager();
    		if (documentationManager != null) {
    			return documentationManager.getRemoveAssociatedResourceCommand(toDocument, uriResource);
    		}
    	}
    	return null;
    }
    
    private void executeCommand(CompoundCommand compoundCmd) {
    	IWorkbenchPart part = getActivePart();
        if (getDocumentationPartHandler(part) != null) {
        	getDocumentationPartHandler(part).executeCommand(part, compoundCmd);
        }
	}

    private void handleResourcesListSelectionChanged()
    {
        IStructuredSelection selection = (IStructuredSelection) resourcesList.getSelection();
        removeResourcesButton.setEnabled(!selection.isEmpty());
        editResourceButton.setEnabled(selection.size() == 1);
    }

    private void handleAddResources()
    {
        if (getDocumentedElement() != null)
        {
            // Get the map of resources to add
        	Set<URI> resourcesToAdd = new HashSet<URI>();

            TypedResourcesSelectionDialog dialog = new TypedResourcesSelectionDialog(getShell());
            int result = dialog.open();
            if (result == Window.OK)
            {
                switch (dialog.getType())
                {
                    case TypedResourcesSelectionDialog.REMOTE_RESOURCE:
                        RemoteResourceDialog rrDialog = new RemoteResourceDialog(getShell(), "http://"); //$NON-NLS-1$

                        if (rrDialog.open() == Window.OK)
                        {
                        	resourcesToAdd.add(URI.createURI(rrDialog.getValue()));
                        }
                        break;

                    case TypedResourcesSelectionDialog.EXTERNAL_RESOURCE:
                        FileDialog erDialog = new FileDialog(getShell(), SWT.MULTI);
                        if (erDialog.open() != null)
                        {
                            String[] resources = erDialog.getFileNames();
                            for (int i = 0; i < resources.length; i++)
                            {
                            	resourcesToAdd.add(URI.createFileURI(erDialog.getFilterPath() + File.separator + resources[i]));
                            }
                        }

                        break;

                    /* Default case : WORKSPACE_RESOURCE */
                    default:
                        WorkspaceResourceDialog wrDialog = new WorkspaceResourceDialog(getShell());
                        result = wrDialog.open();
                        if (result == Window.OK)
                        {
                            Object[] resources = wrDialog.getResult();
                            for (int i = 0; i < resources.length; i++)
                            {
                                if (resources[i] instanceof IFile)
                                {
                                	resourcesToAdd.add(URI.createPlatformResourceURI(((IFile) resources[i]).getFullPath().toString(), true));
                                }
                            }
                        }

                        break;
                }

                // Execute the add resources command if there are some resources to add
                CompoundCommand compoundCmd = new CompoundCommand();
                for (URI uriResource : resourcesToAdd) {
                	compoundCmd.appendIfCanExecute(getAddAssociatedResourceCommand(uriResource));
                }
                executeCommand(compoundCmd);
            }
        }
    }

    private void handleRemoveResources()
    {
        if (getDocumentedElement() != null)
        {
            IStructuredSelection selection = (IStructuredSelection) resourcesList.getSelection();
            List<URI> resourcesToRemove = (List<URI>)selection.toList();

            // Execute the remove resources command if there are some resources to remove
            if (!resourcesToRemove.isEmpty())
            {
                if (MessageDialog.openQuestion(getShell(), Messages.ResourcesComposite_resourcesRemoving, Messages.ResourcesComposite_deleteResourcesConfirmation))
                {
                    CompoundCommand compoundCmd = new CompoundCommand();
                    for (URI uriResource : resourcesToRemove) {
                    	compoundCmd.appendIfCanExecute(getRemoveAssociatedResourceCommand(uriResource));
                    }
                    executeCommand(compoundCmd);
                }
            }
        }
    }

	private void handleEditResource()
    {
    	IStructuredSelection selection = (IStructuredSelection) resourcesList.getSelection();
    	if (selection.size() == 1)
    	{
    		URI uri = (URI)selection.getFirstElement();
    		URI newUri = null;
    		if (uri != null) {
    			if (uri.isPlatform()) {
    				WorkspaceResourceDialog wrDialog = new WorkspaceResourceDialog(getShell());
    				wrDialog.setInitialSelections(new IFile[] {ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(uri.toPlatformString(true))),});
    				if (wrDialog.open() == Window.OK)
    				{
    					newUri = URI.createPlatformResourceURI(((IFile) wrDialog.getResult()[0]).getFullPath().toString(), true);
    				}
    			} else if (uri.isFile()) {
    				FileDialog erDialog = new FileDialog(getShell());
    				erDialog.setFileName(uri.toFileString());
    				newUri = URI.createFileURI(erDialog.open());
    			} else {
    				RemoteResourceDialog rrDialog = new RemoteResourceDialog(getShell(), uri.toString());
    				if (rrDialog.open() == Window.OK)
    				{
    					newUri = URI.createURI(rrDialog.getValue());
    				}
    			}

    			if (newUri != null)
    			{
    				CompoundCommand compoundCmd = new CompoundCommand();
    				compoundCmd.appendIfCanExecute(getRemoveAssociatedResourceCommand(uri));
    				compoundCmd.appendIfCanExecute(getAddAssociatedResourceCommand(uri));
    				executeCommand(compoundCmd);
    			}
    		}
    	}
    }

    private void handleOpenResource()
    {
        IStructuredSelection selection = (IStructuredSelection) resourcesList.getSelection();
        if (selection.size() == 1)
        {
            URI uri = (URI)selection.getFirstElement();
            if (uri.isPlatform()) {
            	String platformString = uri.toPlatformString(true);
                IFile resource = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(platformString));
                try
                {
                    IDE.openEditor(DocViewPlugin.getActivePage(), resource);
                }
                catch (PartInitException pie)
                {
                	displayErrorDialog("Invalid workspace resource", "The workspace resource '" + platformString + "' cannot be opened.");
                }
            } else if (uri.isFile()) {
            	String fileString = uri.toFileString();
                File resource = new File(fileString);
                ExternalResourceEditorInput input = new ExternalResourceEditorInput(resource);
                try
                {
                    IDE.openEditor(DocViewPlugin.getActivePage(), input, getEditorId(resource));
                }
                catch (PartInitException pie)
                {
                	displayErrorDialog("Invalid external resource", "The external resource '" + fileString + "' cannot be opened.");
                }
            } else {
            	String remoteString = uri.toString();
            	try {
					DocViewPlugin.openURL(new URL(remoteString));
				} catch (MalformedURLException e) {
					displayErrorDialog("Invalid remote resource", "The remote resource '" + remoteString + "' cannot be opened.");
				}
            }
        }
    }

    private void displayErrorDialog(final String title, final String message) {
        Display.getDefault().asyncExec(new Runnable()
        {
            public void run()
            {
                MessageDialog.openError(getShell(), (title == null) ? "Error" : title,
                        (message == null) ? "" : message); //$NON-NLS-1$
            }
        });
    }

    /**
     * Get the editor id to use to open an external resource.<br>
     * This method is copied from org.eclipse.ui.internal.editors.text.OpenExternalFileAction
     * 
     * @param file the external resource file
     * @return an editor id
     */
    private String getEditorId(File file)
    {
        IWorkbench workbench = DocViewPlugin.getDefault().getWorkbench();
        IEditorRegistry editorRegistry = workbench.getEditorRegistry();
        IEditorDescriptor descriptor = editorRegistry.getDefaultEditor(file.getName(), getContentType(file));
        if (descriptor != null)
        {
            return descriptor.getId();
        }
        return EditorsUI.DEFAULT_TEXT_EDITOR_ID;
    }

    @Override
    public void setEnabled(boolean enabled)
    {
        super.setEnabled(enabled);
        if (resourcesList != null && resourcesList.getControl() != null)
        {
            resourcesList.getControl().setEnabled(enabled);
        }
        if (this.editResourceButton != null)
        {
            this.editResourceButton.setEnabled(enabled);
        }
        if (this.removeResourcesButton != null)
        {
            this.removeResourcesButton.setEnabled(enabled);
        }
        if (this.addResourcesButton != null)
        {
            this.addResourcesButton.setEnabled(enabled);
        }
    }

    /**
     * Return the content type of the given file.<br/>
     * This method is copied from org.eclipse.ui.internal.editors.text.OpenExternalFileAction
     * 
     * @param file a file
     * @return a content type
     */
    private IContentType getContentType(File file)
    {
        if (file == null)
        {
            return null;
        }

        InputStream stream = null;
        try
        {
            stream = new FileInputStream(file);
            return Platform.getContentTypeManager().findContentTypeFor(stream, file.getName());
        }
        catch (IOException x)
        {
//            ModelerPlugin.log(x);
            return null;
        }
        finally
        {
            try
            {
                if (stream != null)
                {
                    stream.close();
                }
            }
            catch (IOException x)
            {
//                ModelerPlugin.log(x);
            }
        }
    }

    /**
     * A label provider used for the resources list viewer.
     */
    private class ResourcesLabelProvider extends LabelProvider
    {
        private WorkbenchLabelProvider wlp = new WorkbenchLabelProvider();

        /**
         * @see org.eclipse.jface.viewers.LabelProvider#getText(java.lang.Object)
         */
        public String getText(Object element)
        {
        	if (element instanceof URI) {
        		URI uri = (URI)element;
        		if (uri.isPlatform()) {
                    return uri.toPlatformString(true);
        		} else if (uri.isFile()) {
        			return uri.toFileString();
        		} else {
        			return uri.toString();
        		}
        	}

            return "Unknown resource";
        }

        /**
         * @see org.eclipse.jface.viewers.LabelProvider#getImage(java.lang.Object)
         */
        public Image getImage(Object element)
        {
        	if (element instanceof URI) {
        		URI uri = (URI)element;
        		if (uri.isPlatform()) {
                    IFile iFile = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(uri.toPlatformString(true)));
                    return wlp.getImage(iFile);
        		} else if (uri.isFile()) {
        			return DocViewPlugin.getDefault().getImageRegistry().get("EXTERNAL_RESOURCE");
        		} else {
        			return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_FILE);
        		}
        	}

            return null;
        }
    }

    /**
     * A class defining a dialog to add or edit a worksapce resource.
     */
    private class WorkspaceResourceDialog extends ResourceSelectionDialog
    {
        /**
         * Constructor
         * 
         * @param parentShell
         */
        public WorkspaceResourceDialog(Shell parentShell)
        {
            super(parentShell, ResourcesPlugin.getWorkspace().getRoot(), "Please select the workspace resources to add to the documentation.");
        }
    }

    /**
     * A class defining a dialog to add or edit a remote resource.
     */
    private class RemoteResourceDialog extends InputDialog
    {

        /**
         * Constructor
         * 
         * @param parentShell
         * @param initialValue
         */
        public RemoteResourceDialog(Shell parentShell, String initialValue)
        {
            super(parentShell, "Remote resource", "Please enter the URL of the remote resource.", initialValue, null);
        }
    }
}
