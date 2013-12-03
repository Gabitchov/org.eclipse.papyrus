/*******************************************************************************
 * Copyright (c) 2005, 2009 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Sciamma (Anyware Technologies), Mathieu Garcia (Anyware Technologies),
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.views.documentation.view;

import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.IContributedContentsView;
import org.eclipse.ui.part.IPage;
import org.eclipse.ui.part.PageBook;
import org.eclipse.ui.part.PageBookView;
import org.eclipse.ui.views.contentoutline.ContentOutline;

/**
 * Generic view that display UI to comment objects from the model<br>
 * Created : 3 June 2005<br>
 * Updated : 11 August 2009<br>
 * 
 * @author <a href="mailto:david@anyware-tech.com">David Sciamma</a>
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class DocView extends PageBookView implements ISelectionListener
{

    /** ID of the Documentation view */
    public static final String VIEW_ID = "org.eclipse.papyrus.views.documentation.view.DocView"; //$NON-NLS-1$

    /**
     * The initial selection when the doc view opens
     */
    private ISelection bootstrapSelection;

    /**
     * Creates a documentation view.
     */
    public DocView()
    {
        super();
    }

    /**
     * @see org.eclipse.ui.part.PageBookView#createDefaultPage(org.eclipse.ui.part.PageBook)
     */
    protected IPage createDefaultPage(PageBook book)
    {
        IDocPage page = new EmptyDocPage();
        initPage(page);
        page.createControl(book);
        return page;
    }

    /**
     * @see org.eclipse.ui.IWorkbenchPart#dispose()
     */
    public void dispose()
    {
        // run super.
        super.dispose();

        // remove ourselves as a selection listener
        getSite().getPage().removeSelectionListener(this);
    }

    /**
     * @see org.eclipse.ui.part.PageBookView#doCreatePage(org.eclipse.ui.IWorkbenchPart)
     */
    protected PageRec doCreatePage(IWorkbenchPart part)
    {
    	// Try to get a custom doc page.
    	IDocPage page = (IDocPage) part.getAdapter(IDocPage.class);
    	if (page == null)
    	{
    		page = (IDocPage) Platform.getAdapterManager().loadAdapter(part, IDocPage.class.getName());
    	}
    	if (page == null)
    	{
    		if (DocumentionPartHandlerRegistry.getInstance().getDocumentationPartHandler(part) != null) {
    			page = new DocPage();
    		}
    	}
    	if (page != null)
    	{
    		initPage(page);
    		page.createControl(getPageBook());
    		return new PageRec(part, page);
    	}

    	// Use the default page
    	return null;
    }

    /**
     * @see org.eclipse.ui.part.PageBookView#doDestroyPage(org.eclipse.ui.IWorkbenchPart,
     *      org.eclipse.ui.part.PageBookView.PageRec)
     */
    protected void doDestroyPage(IWorkbenchPart part, PageRec rec)
    {
        IDocPage page = (IDocPage) rec.page;
        page.dispose();
        rec.dispose();
    }

    /**
     * @see org.eclipse.ui.part.PageBookView#getBootstrapPart()
     */
    protected IWorkbenchPart getBootstrapPart()
    {
        IWorkbenchPage page = getSite().getPage();
        if (page != null)
        {
            bootstrapSelection = page.getSelection();
            return page.getActivePart();
        }
        return null;
    }

    /**
     * @see org.eclipse.ui.IViewPart#init(org.eclipse.ui.IViewSite)
     */
    public void init(IViewSite site) throws PartInitException
    {
        site.getPage().addSelectionListener(this);
        super.init(site);
    }

    /**
     * @see org.eclipse.ui.part.PageBookView#isImportant(org.eclipse.ui.IWorkbenchPart)
     */
    protected boolean isImportant(IWorkbenchPart part)
    {
        return part instanceof IEditorPart || part instanceof IViewPart;
    }

    /**
     * The <code>DocView</code> implementation of this <code>IPartListener</code> method first sees if the active part
     * is an <code>IContributedContentsView</code> adapter and if so, asks it for its contributing part.
     * 
     * @see org.eclipse.ui.part.PageBookView#partActivated(org.eclipse.ui.IWorkbenchPart)
     */
    public void partActivated(IWorkbenchPart part)
    {
        IContributedContentsView view = (IContributedContentsView) part.getAdapter(IContributedContentsView.class);
        IWorkbenchPart source = null;
        if (view != null)
        {
            source = view.getContributingPart();
        }
        if (source != null)
        {
            super.partActivated(source);
        }
        else
        {
            super.partActivated(part);
        }

        // When the view is first opened, pass the selection to the page
        if (bootstrapSelection != null)
        {
            IDocPage page = (IDocPage) getCurrentPage();
            if (page != null)
            {
                page.selectionChanged(part, bootstrapSelection);
            }
            bootstrapSelection = null;
        }
    }

    /**
     * @see org.eclipse.ui.ISelectionListener#selectionChanged(org.eclipse.ui.IWorkbenchPart,
     *      org.eclipse.jface.viewers.ISelection)
     */
    public void selectionChanged(IWorkbenchPart part, ISelection sel)
    {
        // we only manage editor, outline and views selections
        if (part instanceof IEditorPart || part instanceof ContentOutline || (part instanceof IViewPart && !(part instanceof DocView)))
        {
            // pass the selection to the page
            IDocPage page = (IDocPage) getCurrentPage();
            if (page != null)
            {
                page.selectionChanged(part, sel);
            }
        }
    }

    /**
     * Returns the editor which contributed the current page to this view.
     * 
     * @return the editor which contributed the current page or <code>null</code> if no editor contributed the current
     *         page
     */
    private IWorkbenchPart getContributingEditor()
    {
        return getCurrentContributingPart();
    }

    /**
     * @see org.eclipse.ui.part.PageBookView#getAdapter(java.lang.Class)
     */
    public Object getAdapter(Class key)
    {
        if (key == IContributedContentsView.class)
        {
            return new IContributedContentsView()
            {
                public IWorkbenchPart getContributingPart()
                {
                    return getContributingEditor();
                }
            };
        }

        return super.getAdapter(key);
    }

}
