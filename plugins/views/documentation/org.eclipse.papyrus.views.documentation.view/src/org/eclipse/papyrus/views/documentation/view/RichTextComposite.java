/***********************************************************************
 * Copyright (c) 2008 Anyware Technologies
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Gilles Cannenterre (Anyware Technologies) - initial API and implementation
 **********************************************************************/
package org.eclipse.papyrus.views.documentation.view;

import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.emf.common.util.URI;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.LocationAdapter;
import org.eclipse.swt.browser.LocationEvent;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.epf.richtext.RichText;

/**
 * A class defining a composite support rich text edition.<br>
 * creation : 12 juin 2008
 * 
 * @author <a href="mailto:gilles.cannenterre@anyware-tech.com">Gilles Cannenterre</a>
 */
public class RichTextComposite extends Composite
{
    private RichText commentsText;

    /**
     * Constructor.
     * 
     * @param parent the parent composite
     * @param style the composite style
     */
    public RichTextComposite(Composite parent, int style)
    {
        super(parent, style);

        Composite container = new Composite(this, SWT.BORDER);
        GridLayout richTextLayout = new GridLayout();
        richTextLayout.marginWidth = 0;
        richTextLayout.marginHeight = 0;
        container.setLayout(richTextLayout);
        container.setLayoutData(new GridData(GridData.FILL_BOTH));
        commentsText = new RichText(container, SWT.NONE);
        commentsText.setEditable(false);
        commentsText.setLayoutData(new GridData(GridData.FILL_BOTH));
        
        // the Rich Text control is a Browser for sure.
        Browser browser = (Browser) commentsText.getControl();
		browser.addLocationListener(new URLLocationListener());
    }

    /**
     * This method returns the text contained in the <code>RichTextCommentsComposite</code>
     * 
     * @return the text contained in the <code>RichTextCommentsComposite</code>
     */
    public String getDocumentationValue()
    {
        return commentsText.getText();
    }

    /**
     * Sets the given text into the <code>RichTextCommentsComposite</code>
     * 
     * @param text text to put into the <code>RichTextCommentsComposite</code>
     */
    public void setDocumentationValue(String text)
    {
        commentsText.setText(text);
    }
    
    /**
     * A Location Listener that knows how to intercept OOBE action URLs. It also
     * knows how to update UI navigation history.
     */
    private static class URLLocationListener extends LocationAdapter
    {
    	@Override
    	public void changing(LocationEvent event)
    	{
    		String url = event.location;
    		
            if (url == null) return;

            URLParser parser = new URLParser(url);
            if (parser.isValidURI())
            {
                // stop URL first.
                event.doit = false;
                
                // execute the action embedded in the IntroURL
                parser.runURL();
            }
    	}
    }
    /**
     * A parser that knows how to parser OOBE action URLs. If URL is a valid url,
     * it will create an instance of the IntroURL class.
     */
    private static class URLParser
    {
    	private static final String HTTP_PROTOCOL = "http"; //$NON-NLS-1$
    	
    	private static final String PLATFORM_PROTOCOL = "platform"; //$NON-NLS-1$
         
        private URI uri;

        /**
         * Constructor that create a URL instance, to validate the URL and create a correct URI.
         */
        private URLParser(String url)
        {
            parseUrl(url);
        }

        private void parseUrl(String url)
        {
            if (url == null) return;
            this.uri = null;
            try
            {
            	// TODO check parsing url
            	// URL has some valid protocol.
            	// Check to see if it is a valid url.
                URL url_inst = new URL(url);
                String protocol2 = url_inst.getProtocol();
				if (protocol2 != null)
                {
					// XXX : HACK Extreme hacking on... 
					// there should be a proper way to handle with spaces and URIs.
					if (protocol2.equalsIgnoreCase(HTTP_PROTOCOL)) {
						this.uri = URI.createURI(URI.decode(url.replace("http://platform", "platform:").replace("platform::/", "platform:/")));//.replaceAll("%20", " ")); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
					}
					else if (protocol2.equalsIgnoreCase(PLATFORM_PROTOCOL)) {
						this.uri = URI.createURI(URI.decode(url));
					}
                }
            } 
            catch (MalformedURLException e)
            {
                // not a valid URL. Just return.
            }
        }


        /**
         * @return Returns the isIntroUrl.
         */
        private boolean isValidURI()
        {
            return uri != null;
        }

        /**
         * Fin the EObject with the given URL and try select it on the current Modeler.
         */
        private void runURL()
        {
            Display display = Display.getCurrent();
            BusyIndicator.showWhile(display, new Runnable()
            {
                public void run()
                {
                	IEditorPart activeEditor = DocViewPlugin.getActiveEditor();
                	IDocumentationPartHandler documentationEditor = DocumentionPartHandlerRegistry.getInstance().getDocumentationPartHandler(activeEditor);
                	if (documentationEditor != null) {
                		documentationEditor.openElement(activeEditor, uri);
                	}
                }
            });
        }
    }
    
    @Override
    public void setEnabled(boolean enabled)
    {
    	if (!isDisposed())
    	{
    		super.setEnabled(enabled);
    		if (commentsText != null && commentsText.getControl() != null)
    		{
    			commentsText.getControl().setEnabled(enabled);
    		}
    	}
    }
}
