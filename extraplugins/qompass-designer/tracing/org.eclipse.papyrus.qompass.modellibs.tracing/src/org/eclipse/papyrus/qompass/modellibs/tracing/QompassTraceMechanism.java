package org.eclipse.papyrus.qompass.modellibs.tracing;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.FCM.ConfigOption;
import org.eclipse.papyrus.FCM.ContainerRule;
import org.eclipse.papyrus.FCM.RuleApplication;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.utils.ServiceUtilsForActionHandlers;
import org.eclipse.papyrus.infra.services.tracepoints.ITraceMechanism;
import org.eclipse.papyrus.infra.services.tracepoints.MarkerUtils;
import org.eclipse.papyrus.infra.services.tracepoints.TraceActions.TAOperation;
import org.eclipse.papyrus.infra.services.tracepoints.TracepointConstants;
import org.eclipse.papyrus.qompass.designer.core.Description;
import org.eclipse.papyrus.qompass.designer.core.Log;
import org.eclipse.papyrus.qompass.designer.core.Utils;
import org.eclipse.papyrus.uml.tools.utils.StereotypeUtil;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;

public class QompassTraceMechanism implements ITraceMechanism {

	public static final String EC3M_TRACING_URI = "pathmap://QML_TRACE/tracing.uml"; //$NON-NLS-1$

	public static final URI tracingURI = URI.createURI(EC3M_TRACING_URI);

	public EList<String> getTraceMechanismIDs(EObject eObj) {
		EList<String> ids = new BasicEList<String>();
		// obtain list of all available container rules via Utils. Restrict to those doing tracing.
		EList<ContainerRule> containerRules = getContainerRules(eObj);
		for(ContainerRule containerRule : containerRules) {
			if(isForTracing(containerRule)) {
				Class clazz = containerRule.getBase_Class();
				ids.add(clazz.getName());
			}
		}
		if(ids.size() == 0) {
			ids.add("dummy qompass rule");
		}
		return ids;
	}

	public String getTraceMechanismDescription(EObject eObj, String id) {
		EList<ContainerRule> containerRules = getContainerRules(eObj);
		for(ContainerRule containerRule : containerRules) {
			if(isForTracing(containerRule)) {
				Class clazz = containerRule.getBase_Class();
				if(clazz.getName().equals(id)) {
					return Description.getDescription(clazz);
				}
			}
		}
		return null;
	}

	/**
	 * Apply the trace mechanism, i.e. set or unset the appropriate ContainerRule for tracing.
	 * Currently handles trace on class.
	 * 
	 * Basic idea: always apply same container rule. But container rule expansion is different in function of set tracepoints.
	 * Need to unapply, if there is no longer a trace needing it.
	 */
	public boolean applyTraceMechanism(EObject eObj, String id, int traceOption) {
		Class clazzContext = getClassContext(eObj);
		if(clazzContext == null) {
			return false;
		}
		EList<ContainerRule> containerRules = getContainerRules(eObj);
		for(ContainerRule containerRule : containerRules) {
			if(isForTracing(containerRule)) {
				Class clazz = containerRule.getBase_Class();

				if(clazz.getName().equals(id)) {
					if(traceOption == TAOperation.OnlyCall.ordinal()) {
						// yes => what do we then (i.e. how is mapping done??)
					}
					RuleApplication ruleApplication = StereotypeUtil.applyApp(clazzContext, RuleApplication.class);
					if((ruleApplication != null) && !ruleApplication.getContainerRule().contains(containerRule)) {
						ruleApplication.getContainerRule().add(containerRule);
						return true;
					}
				}
			}
		}
		return false;
	}

	// QompassTraceMechanism

	public boolean isForTracing(ContainerRule rule) {
		for(ConfigOption co : rule.getForConfig()) {
			// TODO: not very clean to used fixed string
			if(co.getBase_Class().getName().equals("Trace")) { //$NON-NLS-1$
				return true;
			}
		}
		return false;
	}

	/**
	 * Return the class (component) for which we need to apply a container rule
	 * to enable the tracing of the passed eObject. This eObject may be
	 * (1) A class, in this case it could be returned directly
	 * (2) An operation. In this case, the owning class is returned (caveat: operation might belong to an interface)
	 * (3) A property of the class (including ports).
	 * 
	 * @param eObj
	 *        see description above
	 * @return the class to a container rule may be applied
	 */
	public Class getClassContext(EObject eObj) {
		if(eObj instanceof Class) {
			return (Class)eObj;
		} else if(eObj instanceof Operation) {
			return ((Operation)eObj).getClass_();
		} else if(eObj instanceof Property) {
			return ((Property)eObj).getClass_();
		} else {
			return null;
		}
	}

	public EList<ContainerRule> getContainerRules(EObject eObj) {
		if(eObj == null) {
			// load rules of registered Tracing model library
			try {
				ModelSet ms = ServiceUtilsForActionHandlers.getInstance().getModelSet();
				Resource rs = ms.getResource(tracingURI, true);
				EList<EObject> contents = rs.getContents();
				if((contents.size() > 0) && (contents.get(0) instanceof Package)) {
					return Utils.getAllRules((Package)contents.get(0));
				}
			} catch (ServiceException e) {
				Log.log(Status.ERROR, Log.TRAFO_CONTAINER, e.getMessage());
			}
			return new BasicEList<ContainerRule>();
		} else {
			Package top = Utils.getTop((Element)eObj);
			return Utils.getAllRules(top);
		}
	}

	public boolean configureTraceMechanisms() {
		String config = ""; //$NON-NLS-1$
		// TODO: config is never evaluated
		try {
			IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();

			if(root != null) {
				Object tracePoints[] = root.findMarkers(TracepointConstants.tpOrbpMarker, true, IResource.DEPTH_INFINITE);
				for(Object tracePointObj : tracePoints) {
					if(tracePointObj instanceof IMarker) {
						IMarker tracePoint = (IMarker)tracePointObj;
						EObject eobj = MarkerUtils.getEObjectOfMarker(tracePoint);
						if(MarkerUtils.isActive(tracePoint)) {
							if(eobj instanceof NamedElement) {
								config += ((NamedElement)eobj).getQualifiedName();
							}
						}
					}
				}
			}
		} catch (CoreException e) {
			Log.log(Status.ERROR, Log.TRAFO_CONTAINER, e.getMessage());
		}
		return true;
	}

}
