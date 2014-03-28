/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Mickaël Adam (ALL4TEC) mickael.adam@all4tec.net - Initial API and implementation
 *****************************************************************************/

package org.eclipse.papyrus.infra.gmfdiag.css.properties.databinding;

import java.util.Collection;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.ModelStyleSheets;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StyleSheet;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StylesheetsFactory;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.StylesheetsPackage;

public class AddAllModelStyleSheetCommand extends RecordingCommand {

	private Resource notationResource;

	private Collection<?> values;

	public AddAllModelStyleSheetCommand(TransactionalEditingDomain domain, Resource notationResource, Collection<?> values) {
		super(domain);
		this.notationResource = notationResource;
		this.values = values;
	}

	public void doExecute() {
		ModelStyleSheets modelStyleSheet = null;

		Object vObject = EcoreUtil.getObjectByType(notationResource.getContents(), StylesheetsPackage.Literals.MODEL_STYLE_SHEETS);

		if(vObject instanceof ModelStyleSheets) {
			modelStyleSheet = (ModelStyleSheets)vObject;
		} else {
			modelStyleSheet = StylesheetsFactory.eINSTANCE.createModelStyleSheets();
		}
		for(Object styleSheetRef : values) {
			modelStyleSheet.getStylesheets().add((StyleSheet)styleSheetRef);
		}
		notationResource.getContents().add(modelStyleSheet);
	}
}
