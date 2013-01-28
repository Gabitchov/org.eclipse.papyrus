package org.eclipse.papyrus.qompass.modellibs.core.mappingrules;

import org.eclipse.papyrus.qompass.designer.core.PortUtils;
import org.eclipse.papyrus.qompass.designer.core.Utils;
import org.eclipse.papyrus.qompass.designer.core.templates.TemplateInstantiation;
import org.eclipse.papyrus.qompass.designer.core.templates.TemplateUtils;
import org.eclipse.papyrus.qompass.designer.core.transformations.Copy;
import org.eclipse.papyrus.qompass.designer.core.transformations.TransformationException;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.TemplateBinding;
import org.eclipse.uml2.uml.TemplateSignature;
import org.eclipse.uml2.uml.Type;

import FCM.util.IMappingRule;
import FCM.util.MapUtil;


/**
 * An extended Port in the sense of the DDS4CCM standard: a port typed with a component
 * type. Since the component typing the port can have multiple provided and required
 * ports, the ports are implicitly owned by the port. Conjugation on the level of an extended
 * port level will conjugate all ports of the component typing the port.
 * 
 * The derived interface that is provided will concatenate provided port names within the
 * extended port with the port name and provided a "big" interface.
 * The derived interface that is required is identical, except for a conjugation on the
 * extended port level.
 * 
 * Creates a fixed template binding that binds T (of the extended Port) to the used data type
 * 
 * @author ansgar
 * 
 */
public class ExtendedPort implements IMappingRule {

	public int needsTransaction() {
		return IMappingRule.BOTH;
	}

	public Interface getProvided(FCM.Port p, InstanceSpecification config)
	{
		return getDerived(p, p.isConjugated(), config);
	}

	public Interface getRequired(FCM.Port p, InstanceSpecification config)
	{
		return getDerived(p, !p.isConjugated(), config);
	}

	public Interface getDerived(FCM.Port extPort, boolean isConjugated, InstanceSpecification config)
	{
		Type type = extPort.getBase_Port().getType();
		if(!(type instanceof Classifier)) {
			return null;
		}
		Class extendedPort = extPort.getKind().getBase_Class();

		TemplateSignature signature = TemplateUtils.getSignature(type.getNearestPackage());
		String prefix = isConjugated ? "C_" : "N_";
		Interface derivedInterface = MapUtil.getOrCreateDerivedInterfaceFP(extPort, prefix, type);
		if(derivedInterface == null) {
			return null;
		}
		if(signature != null) {
			Package model = Utils.getTop(derivedInterface);
			try {
				TemplateBinding binding =
					TemplateUtils.fixedBinding(model, extendedPort, (Classifier)type);
				Copy sat = new Copy(model, model, false);
				System.err.println(model.getQualifiedName());
				TemplateInstantiation ti = new TemplateInstantiation(sat, binding);
				// create a bound element of the extended port. Add bound class to derived interface class
				Class boundClass = ti.bindNamedElement(extendedPort);
				derivedInterface.getNearestPackage().getPackagedElements().add(boundClass);
			} catch (TransformationException e) {
				return null;
			}
		}
		// obtain first template parameter = port type
		// kind.getBase_Class().getNearestPackage().getTemplateParameter();

		for(Port port : extendedPort.getOwnedPorts()) {
			Interface provIntf = (isConjugated) ?
				PortUtils.getRequired(port) :
				PortUtils.getProvided(port);

			if(provIntf != null) {
				for(Operation op : provIntf.getOperations()) {
					String name = port.getName() + "_" + op.getName();

					// check whether operation already exists. Create, if not
					Operation derivedOperation = derivedInterface.getOperation(name, null, null);
					if(derivedOperation == null) {
						derivedOperation = derivedInterface.createOwnedOperation(name, null, null);
					}
				}
			}
		}
		return derivedInterface;
	}
}
