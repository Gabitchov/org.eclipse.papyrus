package org.eclipse.papyrus.infra.nattable.common.editor;

import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.widgets.util.IRevealSemanticElement;


public abstract class SynchronizedTableEditor extends AbstractEMFNattableEditor implements IRevealSemanticElement {

	public SynchronizedTableEditor(final ServicesRegistry servicesRegistry, final Table rawModel) {
		super(servicesRegistry, rawModel);
	}

}
