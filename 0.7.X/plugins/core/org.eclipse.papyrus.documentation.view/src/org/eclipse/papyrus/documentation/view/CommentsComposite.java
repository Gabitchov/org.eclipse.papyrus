/***********************************************************************
 * Copyright (c) 2005, 2009 Anyware Technologies and others
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
 *    Tristan FAURE (ATOS ORIGIN INTEGRATION) - label for type information
 **********************************************************************/
package org.eclipse.papyrus.documentation.view;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.documentation.DocumentationUnsupportedException;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

/**
 * A class defining a composite to edit the comments of a EModelElement through an EAnnotation.<br>
 * <br>
 * Created : 10 Oct. 2005<br>
 * Updated : 4 Dec. 2008<br>
 * Updated : 11 Aug. 2009 (Completely refactor that class into an abstract class {@link AbstractCommentsComposite} and a
 * default implementation one<br>
 * 
 * @author <a href="mailto:thomas.friol@anyware-tech.com">Thomas FRIOL</a>
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class CommentsComposite extends AbstractCommentsComposite
{
    private Text infoText;

    private static String typeLabel = Messages.CommentsComposite_docCurrent;

    /**
     * Constructor.
     * 
     * @param parent the parent composite
     * @param style the composite style
     */
    public CommentsComposite(Composite parent, int style)
    {
        super(parent, style);
    }

    @Override
    protected void createContents(Composite parent)
    {
        boolean labelForTypeInformation = (getStyle() & DocPage.STYLE_TEXT_TYPE) != 0;
        if (labelForTypeInformation)
        {
            infoText = new Text(parent, SWT.READ_ONLY);
        }
        super.createContents(parent);
        if (infoText != null)
        {
            infoText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        }
    }

    /**
     * That generic implementation will store the documentation in an EAnnotation, as we supposed the selected element
     * is an EModelElement.
     */
    @Override
    protected String getDocumentationValueFromElement()
    {
    	try {
    		IDocumentationPartHandler documentationPartHandler = DocumentionPartHandlerRegistry.getInstance().getDocumentationPartHandler(getActivePart());
    		if (documentationPartHandler != null) {
    			EObject associatedDiagram = documentationPartHandler.getAssociatedDiagram(getActivePart(), getDocumentedElement());
    			EObject toDocument = associatedDiagram == null ? getDocumentedElement() : associatedDiagram;
    			return documentationPartHandler.getDocumentationManager().getDocumentation(toDocument);
    		}
		} catch (DocumentationUnsupportedException e) {
		}
		return ""; //$NON-NLS-1$
    }

    /**
     * @see org.topcased.modeler.documentation.AbstractCommentsComposite#handleDocChanged()
     */
    @Override
    public void handleDocChanged()
    {
    	IDocumentationPartHandler documentationPartHandler = DocumentionPartHandlerRegistry.getInstance().getDocumentationPartHandler(getActivePart());
    	if (documentationPartHandler != null) {
    		String docValue = getUseRichTextEditorButton().getSelection() ? getRichTextComposite().getDocumentationValue() : getPlainTextComposite().getDocumentationValue();
			EObject associatedDiagram = documentationPartHandler.getAssociatedDiagram(getActivePart(), getDocumentedElement());
			EObject toDocument = associatedDiagram == null ? getDocumentedElement() : associatedDiagram;
    		Command cmd = documentationPartHandler.getDocumentationManager().getChangeDocumentationCommand(toDocument, docValue);
    		documentationPartHandler.executeCommand(getActivePart(), cmd);
    	}
    }

    @Override
    public void setDocumentedElement(EObject modelElement)
    {
        super.setDocumentedElement(modelElement);
        if (modelElement != null && infoText != null)
        {
            infoText.setText(typeLabel + modelElement.eClass().getName());
        }
    }

}
