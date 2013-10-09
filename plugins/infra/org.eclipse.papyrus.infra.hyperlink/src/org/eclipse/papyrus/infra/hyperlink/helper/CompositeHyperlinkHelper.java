/*****************************************************************************
 * Copyright (c) 2013 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.hyperlink.helper;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.hyperlink.object.HyperLinkObject;


/**
 * This is the CompositeHyperlinkHelper type. Enjoy.
 */
public class CompositeHyperlinkHelper extends AbstractHyperLinkHelper {

	private final AbstractHyperLinkHelper[] helpers;

	private final Map<HyperLinkObject, AbstractHyperLinkHelper> hyperlinks = new java.util.HashMap<HyperLinkObject, AbstractHyperLinkHelper>();

	private AbstractHyperLinkHelper activeHelper;

	public CompositeHyperlinkHelper(Collection<? extends AbstractHyperLinkHelper> helpers) {
		this.helpers = helpers.toArray(new AbstractHyperLinkHelper[helpers.size()]);

		if(this.helpers.length > 0) {
			this.activeHelper = this.helpers[0];
		}
	}

	@Override
	public String getNameofManagedHyperLink() {
		return "Various";
	}

	public List<? extends AbstractHyperLinkHelper> getHelpers() {
		return Collections.unmodifiableList(Arrays.asList(helpers));
	}
	
	public void setActiveHelper(AbstractHyperLinkHelper helper) {
		if(!Arrays.asList(helpers).contains(helper)) {
			throw new IllegalArgumentException("not a composed helper");
		}

		activeHelper = helper;
	}

	@Override
	public void executeNewMousePressed(List<HyperLinkObject> list, EObject aModel) {
		if(activeHelper != null) {
			final int originalSize = list.size();
			activeHelper.executeNewMousePressed(list, aModel);

			// remember the helper that created these hyperlinks; we may need it later
			for(int i = originalSize; i < list.size(); i++) {
				hyperlinks.put(list.get(i), activeHelper);
			}
		}
	}

	@Override
	public List<HyperLinkObject> getFilteredObject(List<HyperLinkObject> hyperLinkObjects) {
		// return result of list type suggests that ordering is important
		Set<HyperLinkObject> result = new java.util.LinkedHashSet<HyperLinkObject>();

		for(int i = 0; i < helpers.length; i++) {
			result.addAll(helpers[i].getFilteredObject(hyperLinkObjects));
		}

		return new java.util.ArrayList<HyperLinkObject>(result);
	}

	@Override
	public HyperLinkObject getHyperLinkObject(EAnnotation eAnnotation) {
		HyperLinkObject result = null;

		for(int i = 0; (result == null) && (i < helpers.length); i++) {
			result = helpers[i].getHyperLinkObject(eAnnotation);

			if(result != null) {
				// remember the helper that created this hyperlink; we may need it later
				hyperlinks.put(result, helpers[i]);
			}
		}

		return result;
	}

	@Override
	public RecordingCommand getAddHyperLinkCommand(TransactionalEditingDomain domain, EModelElement object, HyperLinkObject hyperLinkObject) {
		RecordingCommand result = null;
		AbstractHyperLinkHelper helper = hyperlinks.get(hyperLinkObject);

		if(helper != null) {
			result = helper.getAddHyperLinkCommand(domain, object, hyperLinkObject);
		}

		return result;
	}

}
