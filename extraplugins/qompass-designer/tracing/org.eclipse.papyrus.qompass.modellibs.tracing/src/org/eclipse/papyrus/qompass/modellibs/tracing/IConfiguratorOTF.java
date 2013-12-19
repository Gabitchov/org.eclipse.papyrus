package org.eclipse.papyrus.qompass.modellibs.tracing;

import org.eclipse.papyrus.qompass.designer.core.PortUtils;
import org.eclipse.papyrus.qompass.designer.core.Utils;
import org.eclipse.papyrus.qompass.designer.core.deployment.DepPlanUtils;
import org.eclipse.papyrus.qompass.designer.core.extensions.IInstanceConfigurator;
import org.eclipse.papyrus.qompass.designer.core.transformations.ContainerContext;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Property;


public class IConfiguratorOTF implements IInstanceConfigurator {

	static final String PROP_PORT_NAME = "portName"; //$NON-NLS-1$

	static final String PROP_INSTANCE_NAME = "instanceName"; //$NON-NLS-1$
	
	/**
	 * Configure the passed trace instance
	 * 
	 * @see org.eclipse.papyrus.qompass.designer.gentools.core.extensions.IInstanceConfigurator
	 */
	public void configureInstance(InstanceSpecification instance, Property componentPart, ContainerContext context) {
		// The tracing code needs informations about the component instance and port.

		DepPlanUtils.configureProperty(instance, PROP_INSTANCE_NAME, StringConstants.QUOTE + instance.getName() + StringConstants.QUOTE);
	
		// port in context => interception of port => provide information about port and interface
		if(context.port != null) {
			// obtain required or provided interface (TODO: will fail, if both are provided!)
			Interface intf = PortUtils.getProvided(context.port);
			if(intf == null) {
				intf = PortUtils.getRequired(context.port);
			}

			DepPlanUtils.configureProperty(instance, PROP_PORT_NAME, StringConstants.QUOTE + context.port.getName() + StringConstants.QUOTE);
			if(intf != null) {
				// this is specific for OTF:
				// each container contains an attribute (id_<name>) for each operation. This is configured here,
				// since we add instance information to the trace (is that useful??, seems like a hack)
				for(Operation op : intf.getOperations()) {
					String id = Utils.getTop(context.executorIS).getName() + "::Tracing::Trace::ID_" + //$NON-NLS-1$
						context.executorIS.getName().replace(".", "_") + "_" + op.getName();  //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$
					DepPlanUtils.configureProperty(instance, "id_" + op.getName(), id); //$NON-NLS-1$
				}
			}
		}


	}
}
