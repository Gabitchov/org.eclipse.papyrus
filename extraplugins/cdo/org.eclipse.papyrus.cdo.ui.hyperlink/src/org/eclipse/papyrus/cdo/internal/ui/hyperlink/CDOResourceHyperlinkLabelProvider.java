/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.cdo.internal.ui.hyperlink;

import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.infra.hyperlink.util.HyperLinkFilteredLabelProvider;
import org.eclipse.swt.graphics.Image;

import com.google.common.base.Strings;


/**
 * This is the CDOResourceHyperlinkLabelProvider type. Enjoy.
 */
public class CDOResourceHyperlinkLabelProvider extends HyperLinkFilteredLabelProvider {

	public CDOResourceHyperlinkLabelProvider() {
		super();
	}

	@Override
	public Image getImage(Object element) {
		if(element instanceof CDOResourceHyperlink) {
			return org.eclipse.papyrus.infra.widgets.Activator.getDefault().getImage(Activator.PLUGIN_ID, Activator.IMG_DOCUMENT);
		}

		return super.getImage(element);
	}

	@Override
	public String getText(Object element) {
		if(element instanceof CDOResourceHyperlink) {
			CDOResourceHyperlink hyperlink = (CDOResourceHyperlink)element;

			String tip = hyperlink.getTooltipText();
			String uri = String.valueOf(hyperlink.getHyperlink());

			String pattern = (Strings.isNullOrEmpty(tip) || uri.equals(tip)) ? Messages.CDOResourceHyperlinkLabelProvider_uriOnly : Messages.CDOResourceHyperlinkLabelProvider_tipAndURI;
			return NLS.bind(pattern, tip, uri);
		}

		return super.getText(element);
	}
}
