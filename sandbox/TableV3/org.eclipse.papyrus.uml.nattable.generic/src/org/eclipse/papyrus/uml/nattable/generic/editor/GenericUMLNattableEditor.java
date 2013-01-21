package org.eclipse.papyrus.uml.nattable.generic.editor;

import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.nattable.common.editor.AbstractEMFNattableEditor;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;

public class GenericUMLNattableEditor extends AbstractEMFNattableEditor {

	/** the type of the editor */
	public static final String EDITOR_TYPE = "PapyruGenericNattable"; //$NON-NLS-1$

	/** the default name for this table */
	public static final String DEFAULT_NAME = "GenericUMLTable"; //$NON-NLS-1$

	public GenericUMLNattableEditor(ServicesRegistry servicesRegistry, final Table rawModel) {
		super(servicesRegistry, rawModel);
	}



}
