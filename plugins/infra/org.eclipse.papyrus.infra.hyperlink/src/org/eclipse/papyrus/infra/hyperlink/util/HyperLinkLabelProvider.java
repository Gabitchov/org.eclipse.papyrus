/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.hyperlink.util;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.papyrus.infra.core.editorsfactory.IPageIconsRegistry;
import org.eclipse.papyrus.infra.hyperlink.object.HyperLinkDocument;
import org.eclipse.papyrus.infra.hyperlink.object.HyperLinkEditor;
import org.eclipse.papyrus.infra.hyperlink.object.HyperLinkObject;
import org.eclipse.papyrus.infra.hyperlink.object.HyperLinkWeb;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 * The Class DocumentLabelProvider.
 */
public class HyperLinkLabelProvider implements ILabelProvider {

	/** The HYPERLIN k_ we b_ ico n_ path. */
	protected final String HYPERLINK_WEB_ICON_PATH = "/icons/obj16/hyperlink.gif";

	/** The HYPERLIN k_ documen t_ ico n_ path. */
	protected final String HYPERLINK_DOCUMENT_ICON_PATH = "/icons/obj16/file.gif";
	/** The SEP. */
	private final String SEP = " - ";
	
	/** The editor registry. */
	private IPageIconsRegistry editorRegistry;
	
	/**
	 * Instantiates a new object label provider.
	 * 
	 * @param imagePath
	 *        the image path
	 */
	public HyperLinkLabelProvider(IPageIconsRegistry editorFactoryRegistry ) {
		this.editorRegistry = editorFactoryRegistry;
	}

	/**
	 * {@inheritedDoc}.
	 * 
	 * @param element
	 *        the element
	 * 
	 * @return the image
	 */
	public Image getImage(Object element) {
		//TODO remove the uml.diagram.common call
		if(element instanceof HyperLinkDocument) {
			return AbstractUIPlugin.imageDescriptorFromPlugin("org.eclipse.papyrus.uml.diagram.common", HYPERLINK_DOCUMENT_ICON_PATH).createImage();
		}
		else if(element instanceof HyperLinkWeb) {
			return AbstractUIPlugin.imageDescriptorFromPlugin("org.eclipse.papyrus.uml.diagram.common", HYPERLINK_WEB_ICON_PATH).createImage();
		}

		else if(element instanceof HyperLinkEditor){
			return ((HyperLinkEditor)element).getImage(((HyperLinkEditor)element).getObject());
		}
		return null;
	}

	/**
	 * {@inheritedDoc}.
	 * 
	 * @param element
	 *        the element
	 * 
	 * @return the text
	 */
	public String getText(Object element) {
		String out = "";
		if(element instanceof HyperLinkDocument) {
			out = ((HyperLinkDocument)element).getHyperlinkDocument();
		} else if(element instanceof HyperLinkWeb) {
			out = ((HyperLinkWeb)element).getHyperLinkWeb();
		}else if(element instanceof HyperLinkEditor){
			out = ((HyperLinkEditor)element).getText(((HyperLinkEditor)element).getObject());
		} else {
			return null;
		}
		out = out + SEP + ((HyperLinkObject)element).getTooltipText();
		return out;
	}
	
	public String getTooltipText(Object element){
		return ((HyperLinkObject)element).getTooltipText();
	}

	/**
	 * {@inheritedDoc}.
	 * 
	 * @param listener
	 *        the listener
	 */
	public void addListener(ILabelProviderListener listener) {
	}

	/**
	 * {@inheritedDoc}.
	 */
	public void dispose() {
	}

	/**
	 * {@inheritedDoc}.
	 * 
	 * @param element
	 *        the element
	 * @param property
	 *        the property
	 * 
	 * @return true, if checks if is label property
	 */
	public boolean isLabelProperty(Object element, String property) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * {@inheritedDoc}.
	 * 
	 * @param listener
	 *        the listener
	 */
	public void removeListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub

	}

}
