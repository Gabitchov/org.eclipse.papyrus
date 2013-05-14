package org.eclipse.papyrus.qompass.modellibs.core.mappingrules;

import org.eclipse.papyrus.FCM.util.IMappingRule;
import org.eclipse.papyrus.FCM.util.MapUtil;
import org.eclipse.papyrus.qompass.designer.core.PortUtils;
import org.eclipse.papyrus.qompass.designer.core.transformations.PrefixConstants;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Type;


/**
 * An extended Port in the sense of the DDS4CCM standard: a port typed with a component
 * type (the extended port, not the data type that is transported). Since the component typing
 * the port can have multiple provided and required
 * ports, the ports are implicitly owned by the port. Conjugation on the level of an extended
 * port level will conjugate all ports of the component typing the port.
 * 
 * The derived interface that is provided will allow a caller to access individual ports. It
 * is therefore a reference to the interfaces get_<portName> operations provided by a
 * component.
 * The derived interface that is required is identical, except for a conjugation on the
 * extended port level.
 * 
 * What is the difference to ExtendedPort?
 * 
 * @author ansgar
 * 
 */
public class ExtendedPort2 implements IMappingRule {

	public int needsTransaction() {
		return IMappingRule.BOTH;
	}

	public Interface getProvided(org.eclipse.papyrus.FCM.Port p, InstanceSpecification config)
	{
		return getDerived(p, p.getBase_Port().isConjugated(), config);
	}

	public Interface getRequired(org.eclipse.papyrus.FCM.Port p, InstanceSpecification config)
	{
		return getDerived(p, !p.getBase_Port().isConjugated(), config);
	}

	public Interface getDerived(org.eclipse.papyrus.FCM.Port extPort, boolean isConjugated, InstanceSpecification config)
	{
		Type type = extPort.getBase_Port().getType();
		if(!(type instanceof Class))
			return null;

		Class extendedPort = (Class)type;
		String prefix = isConjugated ? "C2_" : "N2_";
		Interface derivedInterface = MapUtil.getOrCreateDerivedInterfaceFP(extPort, prefix, type);
		if(derivedInterface == null) {
			return null;
		}
		for(Port port : extendedPort.getOwnedPorts()) {
			// if the extended port is conjugated, each of the provided/required are (implicitly)
			// conjugated [TODO: is PortUtils aware of it? - probably yes]
			Interface provIntf = (isConjugated) ?
				PortUtils.getRequired(port) :
				PortUtils.getProvided(port);

			if(provIntf != null) {
				String name = PrefixConstants.getP_Prefix + port.getName();

				// check whether operation already exists. Create, if not
				Operation derivedOperation = derivedInterface.getOperation(name, null, null);
				if(derivedOperation == null) {
					derivedOperation = derivedInterface.createOwnedOperation(name, null, null);
				}
			}
		}
		return derivedInterface;
	}
}
