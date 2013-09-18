/*****************************************************************************
 * Copyright (c) 2011, 2013 CEA LIST and others.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA LIST) - adapted for CDO repository resource hyperlinks
 * 
 *****************************************************************************/

package org.eclipse.papyrus.cdo.internal.ui.hyperlink;

import static com.google.common.base.Predicates.instanceOf;
import static com.google.common.collect.Iterables.filter;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.hyperlink.helper.AbstractHyperLinkHelper;
import org.eclipse.papyrus.infra.hyperlink.object.HyperLinkObject;
import org.eclipse.papyrus.infra.hyperlink.util.HyperLinkConstants;

import com.google.common.collect.ImmutableList;


/**
 * Helper extension for hyperlinks to resources in CDO model repositories.
 */
public class CDOResourceHyperlinkHelper extends AbstractHyperLinkHelper {

	@Override
	public HyperLinkObject getHyperLinkObject(EAnnotation eAnnotation) {
		CDOResourceHyperlink result = null;

		if(eAnnotation.getSource().equals(CDOHyperlinkConstants.HYPERLINK_ANNOTATION_SOURCE)) {
			result = new CDOResourceHyperlink();
			result.setHyperlink(URI.createURI(eAnnotation.getDetails().get(CDOHyperlinkConstants.HYPERLINK_DETAIL_URI)));
			result.setTooltipText(eAnnotation.getDetails().get(HyperLinkConstants.HYPERLINK_TOOLTYPE_TEXT));
			if(eAnnotation.getDetails().get(HyperLinkConstants.HYPERLINK_IS_DEFAULT_NAVIGATION) != null) {
				boolean isDefaultNaviagation = Boolean.parseBoolean(eAnnotation.getDetails().get(HyperLinkConstants.HYPERLINK_IS_DEFAULT_NAVIGATION));
				result.setIsDefault(isDefaultNaviagation);
			} else {
				result.setIsDefault(false);
			}
		}

		return result;
	}

	@Override
	public RecordingCommand getAddHyperLinkCommand(TransactionalEditingDomain domain, EModelElement object, HyperLinkObject hyperlinkObject) {
		RecordingCommand result = null;

		if(hyperlinkObject instanceof CDOResourceHyperlink) {
			CDOResourceHyperlink cdoHyperlink = (CDOResourceHyperlink)hyperlinkObject;
			result = new CreateCDOResourceHyperlinkCommand(domain, object, cdoHyperlink.getTooltipText(), cdoHyperlink.getHyperlink(), cdoHyperlink.getIsDefault());
		}

		return result;
	}

	@Override
	public String getNameofManagedHyperLink() {
		return Messages.CDOResourceHyperlinkHelper_name;
	}

	@Override
	public void executeNewMousePressed(List<HyperLinkObject> list, EObject aModel) {
		CDOResourceHyperlinkEditorShell editor = new CDOResourceHyperlinkEditorShell();
		if(editor.open()) {
			list.add(editor.getHyperlink());
		}
	}

	@Override
	public List<HyperLinkObject> getFilteredObject(List<HyperLinkObject> hyperlinkObjects) {
		return ImmutableList.copyOf(filter(hyperlinkObjects, instanceOf(CDOResourceHyperlink.class)));
	}
}
