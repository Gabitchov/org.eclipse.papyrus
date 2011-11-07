/***********************************************************************
 * Copyright (c) 2009 Anyware Technologies and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Jacques Lescot (Anyware Technologies) - initial API and documentation
 **********************************************************************/
package org.eclipse.papyrus.views.documentation.view;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.Page;

/**
 * This class defines a page used to edit a documentation text and some resources to be associated with a
 * given model element<br>
 * 
 * Created : 11 August 2009<br>
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class DocPage extends Page implements IDocPage
{
    private EObject documentedElement;

    // SWT Widgets
    private Composite mainComp;

    protected CommentsComposite commentsComposite;

    protected ResourcesComposite resourcesComposite;

    private TabFolder tabFolder;
    
    /**
     * This constant is used to determine if the composite has to insert a text field
     */
    public static final int STYLE_TEXT_TYPE = 1 << 28;

    /**
     * @see org.eclipse.ui.part.Page#createControl(org.eclipse.swt.widgets.Composite)
     */
    public void createControl(Composite parent)
    {
        mainComp = new Composite(parent, SWT.NONE);
        mainComp.setLayout(new GridLayout());
        mainComp.setLayoutData(new GridData(GridData.FILL_BOTH));

        tabFolder = new TabFolder(mainComp, SWT.TOP);
        tabFolder.setLayoutData(new GridData(GridData.FILL_BOTH));

        createCommentsTabItem(tabFolder);
        createResourcesTabItem(tabFolder);
    }

    /**
     * Create the content of the comments tab item. It contains a multi lines text field in order to edit the comments
     * of the documentation.
     * 
     * @param parent the parent tab folder
     */
    private void createCommentsTabItem(TabFolder parent)
    {
        TabItem tabItem = new TabItem(parent, SWT.NONE);
        tabItem.setText(Messages.AbstractDocPage_commentsTitle);

        Composite container = new Composite(parent, SWT.NONE);

        GridLayout containerLayout = new GridLayout();
        containerLayout.marginWidth = 0;
        containerLayout.marginHeight = 0;
        container.setLayout(containerLayout);
        container.setLayoutData(new GridData(GridData.FILL_BOTH));

        tabItem.setControl(container);

        commentsComposite = createCommentsComposite(container);
        commentsComposite.setLayoutData(new GridData(GridData.FILL_BOTH));
    }

    /**
     * Create the content of the resources tab item. It contains a list and three buttons in order to view, add, remove
     * and edit linked resources.
     * 
     * @param parent the parent tab folder
     */
    private void createResourcesTabItem(TabFolder parent)
    {
        TabItem tabItem = new TabItem(parent, SWT.NONE);
        tabItem.setText(Messages.AbstractDocPage_resourcesTitle);

        Composite container = new Composite(parent, SWT.NONE);
        GridLayout containerLayout = new GridLayout();
        containerLayout.marginWidth = 0;
        containerLayout.marginHeight = 0;
        container.setLayout(containerLayout);
        container.setLayoutData(new GridData(GridData.FILL_BOTH));

        tabItem.setControl(container);

        resourcesComposite = new ResourcesComposite(container, SWT.NONE);
        resourcesComposite.setLayoutData(new GridData(GridData.FILL_BOTH));
    }

    /**
     * @see org.eclipse.ui.part.Page#getControl()
     */
    public Control getControl()
    {
        return mainComp;
    }

    /**
     * @see org.eclipse.ui.ISelectionListener#selectionChanged(org.eclipse.ui.IWorkbenchPart,
     *      org.eclipse.jface.viewers.ISelection)
     */
    public void selectionChanged(IWorkbenchPart part, ISelection selection)
    {
        manageDocumentatedElement(part, selection, true);
    }

    protected void manageDocumentatedElement(IWorkbenchPart part, ISelection selection, boolean checkResources)
    {
        EObject elt = getSelectedModelElement(selection);
        if (elt == null || elt != documentedElement)
        {
            documentedElement = elt;
            if (commentsComposite != null && !commentsComposite.isDisposed())
            {
                commentsComposite.setActivePart(part);
                commentsComposite.setDocumentedElement(documentedElement);
            }
            if (resourcesComposite != null && !resourcesComposite.isDisposed())
            {
            	resourcesComposite.setActivePart(part);
            	resourcesComposite.setDocumentedElement(documentedElement);
            }
            if (documentedElement != null && checkResources)
            {
        		IDocumentationPartHandler documentationPartHandler = DocumentionPartHandlerRegistry.getInstance().getDocumentationPartHandler(part);
            	if (documentationPartHandler != null) {
            		boolean readOnly = documentationPartHandler.isReadOnly(part, documentedElement);
            		commentsComposite.setReadOnly(readOnly);
            		resourcesComposite.setReadOnly(readOnly);
            	}
            }
        }
    }

    /**
     * @see org.eclipse.ui.part.Page#setFocus()
     */
    @Override
    public void setFocus()
    {
        if (commentsComposite != null && !commentsComposite.isDisposed())
        {
            commentsComposite.setFocus();
        }
    }

    protected CommentsComposite createCommentsComposite(Composite parent)
    {
        return new CommentsComposite(parent, SWT.NONE | STYLE_TEXT_TYPE);
    }

    /**
     * Return the model element on which the documentation will be attached. Default implementation works only for
     * EModelElement elements. Subclasses may override this method in order to provide their own check on the selected
     * element type.
     * 
     * @param selection the initial selection
     * @return the model element on which the documentation will be attached
     */
    protected EObject getSelectedModelElement(ISelection selection)
    {
        if (selection instanceof IStructuredSelection && ((IStructuredSelection) selection).size() == 1)
        {
            Object selectedObject = ((IStructuredSelection) selection).getFirstElement();

            if (selectedObject instanceof EObject)
            {
                return (EObject) selectedObject;
            }
            if (selectedObject instanceof IAdaptable)
            {
                Object adaptedObject = ((IAdaptable) selectedObject).getAdapter(EObject.class);
                if (adaptedObject != null)
                {
                    return (EObject) adaptedObject;
                }
            }

            Object adaptedObject = Platform.getAdapterManager().getAdapter(selectedObject, EObject.class);
            if (adaptedObject != null)
            {
                return (EObject) adaptedObject;
            }
        }

        return null;
    }

}
