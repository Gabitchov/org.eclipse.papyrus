package org.eclipse.papyrus.qompass.designer.core.sync;

import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Port;

/**
 * Create a UML like executor, i.e.
 * for each port p with a provided interface I, add a get_p to the executor
 * for each port q with a required interface I, add an attribute q to the executor. This
 * attribute is manipulated by the container.
 * 
 * @author ansgar
 * 
 */
public class CompTypeSync {

	/**
	 * Rename the operations/attributes associated with a port, if the ports
	 * name or type has changed.
	 * 
	 * @param component
	 * @param port
	 */
	public static void renamePort(Class component, Port port, String oldName) {
		// CompImplSync.renamePortViaType (component, port, oldName);
		CompImplSync.renamePort(component, port, oldName);
	}


	/**
	 * Synchronizes the operations/attributes associated with a port
	 * 
	 * @param component
	 * @param port
	 */
	public static void syncPort(Class component, Port port) {
		CompImplSync.syncViaType(component, false);
		// CompImplSync.syncContextOps (component, true);
	}
};
