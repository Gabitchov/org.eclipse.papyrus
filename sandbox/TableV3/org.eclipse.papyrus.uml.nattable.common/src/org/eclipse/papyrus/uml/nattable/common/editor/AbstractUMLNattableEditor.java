package org.eclipse.papyrus.uml.nattable.common.editor;

import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.nattable.common.editor.AbstractEMFNattableEditor;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;


public abstract class AbstractUMLNattableEditor extends AbstractEMFNattableEditor {



	/**
	 * @param servicesRegistry
	 * @param rawModel
	 * 
	 */
	public AbstractUMLNattableEditor(final ServicesRegistry servicesRegistry, final Table rawModel) {
		super(servicesRegistry, rawModel);
	}
}
