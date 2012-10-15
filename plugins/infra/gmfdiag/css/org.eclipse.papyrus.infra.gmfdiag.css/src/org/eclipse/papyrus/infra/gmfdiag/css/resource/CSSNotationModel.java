package org.eclipse.papyrus.infra.gmfdiag.css.resource;

import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.gmfdiag.common.model.NotationModel;


public class CSSNotationModel extends NotationModel {

	@Override
	public void init(ModelSet modelManager) {
		super.init(modelManager);
		// Specify the factory to use to create the resource.
		CSSNotationResourceFactory cssFactory = new CSSNotationResourceFactory();
		getResourceSet().getResourceFactoryRegistry().getExtensionToFactoryMap().put(NOTATION_FILE_EXTENSION, cssFactory);
	}
}
