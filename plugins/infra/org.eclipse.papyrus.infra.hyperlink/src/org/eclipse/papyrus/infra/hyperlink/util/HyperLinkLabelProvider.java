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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.infra.hyperlink.Activator;
import org.eclipse.papyrus.infra.hyperlink.object.HyperLinkDocument;
import org.eclipse.papyrus.infra.hyperlink.object.HyperLinkEditor;
import org.eclipse.papyrus.infra.hyperlink.object.HyperLinkObject;
import org.eclipse.papyrus.infra.hyperlink.object.HyperLinkSpecificObject;
import org.eclipse.papyrus.infra.hyperlink.object.HyperLinkWeb;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.swt.graphics.Image;

/**
 * The Class DocumentLabelProvider.
 */
public class HyperLinkLabelProvider extends LabelProvider {

	/** The HYPERLIN k_ we b_ ico n_ path. */
	protected final String HYPERLINK_WEB_ICON_PATH = "/icons/hyperlink.gif"; //$NON-NLS-1$

	/** The HYPERLIN k_ documen t_ ico n_ path. */
	protected final String HYPERLINK_DOCUMENT_ICON_PATH = "/icons/file.gif"; //$NON-NLS-1$

	/** The SEP. */
	private final String SEP = " - "; //$NON-NLS-1$

	/**
	 * {@inheritedDoc}.
	 * 
	 * @param element
	 *        the element
	 * 
	 * @return the image
	 */
	@Override
	public Image getImage(Object element) {
		if(element instanceof HyperLinkDocument) {
			return org.eclipse.papyrus.infra.widgets.Activator.getDefault().getImage(Activator.PLUGIN_ID, HYPERLINK_DOCUMENT_ICON_PATH);
		}

		if(element instanceof HyperLinkWeb) {
			return org.eclipse.papyrus.infra.widgets.Activator.getDefault().getImage(Activator.PLUGIN_ID, HYPERLINK_WEB_ICON_PATH);
		}

		if(element instanceof HyperLinkEditor) {
			EObject editorContext = EMFHelper.getEObject(((HyperLinkEditor)element).getObject());
			if(editorContext != null) {
				try {
					return ServiceUtilsForEObject.getInstance().getService(LabelProviderService.class, editorContext).getLabelProvider().getImage(editorContext);
				} catch (ServiceException ex) {
					Activator.log.error(ex);
				}
			}
		}

		if(element instanceof HyperLinkSpecificObject) {
			EObject targetElement = ((HyperLinkSpecificObject)element).getTargetElement();
			if(targetElement != null) {
				try {
					return ServiceUtilsForEObject.getInstance().getService(LabelProviderService.class, targetElement).getLabelProvider().getImage(targetElement);
				} catch (ServiceException ex) {
					Activator.log.error(ex);
				}
			}
		}

		return super.getImage(element);
	}

	/**
	 * {@inheritedDoc}.
	 * 
	 * @param element
	 *        the element
	 * 
	 * @return the text
	 */
	@Override
	public String getText(Object element) {
		String out = ""; //$NON-NLS-1$
		if(element instanceof HyperLinkDocument) {
			out = ((HyperLinkDocument)element).getHyperlinkDocument();
		} else if(element instanceof HyperLinkWeb) {
			out = ((HyperLinkWeb)element).getHyperLinkWeb();
		} else if(element instanceof HyperLinkEditor) {
			EObject editorContext = EMFHelper.getEObject(((HyperLinkEditor)element).getObject());
			if(editorContext != null) {
				try {
					return ServiceUtilsForEObject.getInstance().getService(LabelProviderService.class, editorContext).getLabelProvider().getText(editorContext);
				} catch (ServiceException ex) {
					Activator.log.error(ex);
				}
			}
		} else if(element instanceof HyperLinkSpecificObject) {
			EObject targetElement = ((HyperLinkSpecificObject)element).getTargetElement();
			if(targetElement != null) {
				try {
					return ServiceUtilsForEObject.getInstance().getService(LabelProviderService.class, targetElement).getLabelProvider().getText(targetElement);
				} catch (ServiceException ex) {
					Activator.log.error(ex);
				}
			}
		} else {
			return super.getText(element);
		}

		out = out + SEP + ((HyperLinkObject)element).getTooltipText();
		return out;
	}

}
