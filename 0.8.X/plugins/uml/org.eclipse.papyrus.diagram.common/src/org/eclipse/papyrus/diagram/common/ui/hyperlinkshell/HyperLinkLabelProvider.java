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
package org.eclipse.papyrus.diagram.common.ui.hyperlinkshell;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.papyrus.core.editorsfactory.IPageIconsRegistry;
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
		if(element instanceof HyperlinkDocument) {
			return AbstractUIPlugin.imageDescriptorFromPlugin("org.eclipse.papyrus.diagram.common", HYPERLINK_DOCUMENT_ICON_PATH).createImage();
		}
		else if(element instanceof HyperLinkWeb) {
			return AbstractUIPlugin.imageDescriptorFromPlugin("org.eclipse.papyrus.diagram.common", HYPERLINK_WEB_ICON_PATH).createImage();
		}

		else if(element instanceof HyperLinkDiagram) {
			return editorRegistry.getEditorIcon(((HyperLinkDiagram)element).getDiagram());
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
		if(element instanceof HyperLinkDiagram) {
			if(((HyperLinkDiagram)element).getDiagram() != null) {
				out = ((HyperLinkDiagram)element).getDiagram().getName();
			}
		} else if(element instanceof HyperlinkDocument) {
			out = ((HyperlinkDocument)element).getHyperlinkDocument();
		} else if(element instanceof HyperLinkWeb) {
			out = ((HyperLinkWeb)element).getHyperLinkWeb();
		} else {
			return null;
		}
		out = out + SEP + ((HyperlinkObject)element).getTooltipText();
		return out;
	}
	
	public String getTooltipText(Object element){
		return ((HyperlinkObject)element).getTooltipText();
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
