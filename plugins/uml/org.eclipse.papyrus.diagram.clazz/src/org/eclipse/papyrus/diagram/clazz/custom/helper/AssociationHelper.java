package org.eclipse.papyrus.diagram.clazz.custom.helper;

import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;

public class AssociationHelper {

	public static int source = 0;
	public static int target = 1;

	public static CommandResult reconnect(int end, Association association,
			Type newType) {

		((Property) association.getMemberEnds().get(end)).setType(newType);

		return CommandResult.newOKCommandResult(association);
	}

}
