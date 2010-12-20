/***********************************************************************
 * Copyright (c) 2008, 2009 Anyware Technologies and others
 * 
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
 *    Jacques Lescot (Anyware Technologies) - feature #1414
 **********************************************************************/
package org.eclipse.papyrus.documentation.view;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

/**
 * This class creates the page to edit documentation EAnnotation of a given EModelElement<br>
 * <br>
 * Created : 3 June 2005<br>
 * Updated : 8 August 2008<br>
 * Updated : 11 August 2009 (Completely refactor that class into an abstract class {@link AbstractDocPage} and a default
 * implementation one<br>
 * 
 * @author <a href="mailto:david@anyware-tech.com">David Sciamma</a>
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class DocPage extends AbstractDocPage
{
    /**
     * This constant is used to determine if the composite has to insert a text field
     */
    public static final int STYLE_TEXT_TYPE = 1 << 28;

    private final boolean displayTypeLabel;

    /**
     * Build the page with the editor command stack : used to execute commands.
     */
    public DocPage()
    {
        this(true);
    }

    /**
     * Build the page
     * 
     * @param displayTypeLabel whether label for type is displayed
     */
    public DocPage(boolean displayTypeLabel)
    {
        super();
        this.displayTypeLabel = displayTypeLabel;
    }

    /**
     * @see org.topcased.modeler.documentation.AbstractDocPage#createCommentsComposite(org.eclipse.swt.widgets.Composite)
     */
    @Override
    protected AbstractCommentsComposite createCommentsComposite(Composite parent)
    {
        int style = SWT.NONE;
        if (displayTypeLabel)
        {
            style |= STYLE_TEXT_TYPE;
        }
        return new CommentsComposite(parent, style);
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
