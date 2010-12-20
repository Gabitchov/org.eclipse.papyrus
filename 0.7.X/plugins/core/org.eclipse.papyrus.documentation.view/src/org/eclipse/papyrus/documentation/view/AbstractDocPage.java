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
package org.eclipse.papyrus.documentation.view;

import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
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
 * This class defines an abstract page used to edit a documentation text and some resources to be associated with a
 * given model element<br>
 * Subclasses will specify the type of model element to be handled. <br>
 * 
 * Created : 11 August 2009<br>
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public abstract class AbstractDocPage extends Page implements IDocPage
{
    private EObject documentedElement;

    // SWT Widgets
    private Composite mainComp;

    protected AbstractCommentsComposite commentsComposite;

    protected ResourcesComposite resourcesComposite;

    private TabFolder tabFolder;

    /**
     * Build the page with the editor command stack : used to execute commands.
     * 
     * @param stack the editor command stack
     * @deprecated use {@link #AbstractDocPage()} instead
     */
    public AbstractDocPage(CommandStack stack)
    {
        this();
    }

    /**
     * Build the page
     */
    public AbstractDocPage()
    {
    }

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
                commentsComposite.setDocumentedElement(documentedElement);
                commentsComposite.setActivePart(part);
            }
            if (resourcesComposite != null && !resourcesComposite.isDisposed())
            {
            	resourcesComposite.setDocumentedElement(documentedElement);
            	resourcesComposite.setActivePart(part);
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
//        else if (resourcesComposite != null && !resourcesComposite.isDisposed())
//        {
//            resourcesComposite.setFocus();
//        }
    }

    /**
     * Subclasses may override this to propose their own Comments composite implementation
     * 
     * @param parent the parent Composite
     * @return an AbstractCommentsComposite
     */
    protected abstract AbstractCommentsComposite createCommentsComposite(Composite parent);

    /**
     * Return the model element on which the documentation will be attached. Subclasses may override this method in
     * order to extract the model element from the given selection.
     * 
     * @param selection the initial selection
     * @return the model element on which the documentation will be attached
     */
    protected abstract EObject getSelectedModelElement(ISelection selection);

}
