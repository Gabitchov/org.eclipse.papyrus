package org.eclipse.papyrus.uml.diagram.sequence;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.gmf.runtime.emf.type.core.MetamodelType;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelper;
import org.eclipse.gmf.runtime.emf.type.core.internal.descriptors.MetamodelTypeDescriptor;
import org.eclipse.gmf.runtime.emf.type.core.internal.l10n.EMFTypeCoreMessages;

public class ObservationLinkMetamodelType extends MetamodelType {

	public static final String ID = "org.eclipse.papyrus.uml.diagram.sequence.emf.type.core.observationlink"; //$NON-NLS-1$

	private static final ObservationLinkMetamodelType INSTANCE = new ObservationLinkMetamodelType();

	private static final MetamodelTypeDescriptor DESCRIPTOR_INSTANCE = new MetamodelTypeDescriptor(INSTANCE);

	/**
	 * Initializes me.
	 */
	private ObservationLinkMetamodelType() {
		super(ID, null, EMFTypeCoreMessages.defaultEditHelper_name, EcorePackage.Literals.EOBJECT, new DefaultEditHelper());
	}

	public static ObservationLinkMetamodelType getInstance() {
		return INSTANCE;
	}

	public static MetamodelTypeDescriptor getDescriptorInstance() {
		return DESCRIPTOR_INSTANCE;
	}

	private static class DefaultEditHelper extends AbstractEditHelper {

		DefaultEditHelper() {
			super();
		}
	}
}
