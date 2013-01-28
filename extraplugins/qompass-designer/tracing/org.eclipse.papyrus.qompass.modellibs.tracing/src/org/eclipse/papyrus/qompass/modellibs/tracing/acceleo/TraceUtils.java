package org.eclipse.papyrus.qompass.modellibs.tracing.acceleo;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.papyrus.infra.services.tracepoints.MarkerUtils;
import org.eclipse.papyrus.infra.services.tracepoints.TracepointConstants;
import org.eclipse.papyrus.qompass.designer.core.transformations.TransformationContext;
import org.eclipse.uml2.uml.Element;

public class TraceUtils {

	public static IMarker[] getMarkersForEObject(EObject eObject, String markerType) {
		Resource resource = eObject.eResource();
		IFile file = WorkspaceSynchronizer.getFile(resource);
		if(file != null) {
			try {
				return file.findMarkers(markerType, true, IResource.DEPTH_INFINITE);
			} catch (CoreException e) {
			}
		}
		return new IMarker[0];
	}

	public static boolean hasTrace(Element eObject) {
		IMarker markers[] = getMarkersForEObject(eObject, TracepointConstants.tpOrbpMarker);
		for(IMarker marker : markers) {
			// explicitly pass resourceSet of eObject we want to compare. Otherwise, the marker utils would
			// load resources into its own resource set (leading to non-comparable eObjects)
			EObject eObjOfMarker = MarkerUtils.getEObjectOfMarker(eObject.eResource().getResourceSet(), marker);
			if(eObjOfMarker == eObject) {
				return true;
			}
		}
		// TODO: testing workaround (always return true for port based transformations) 
		if(TransformationContext.getPort() != null) {
			return true;
		}
		return false;
	}
}
