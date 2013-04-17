package org.eclipse.papyrus.moka.fuml.presentation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.infra.core.Activator;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForResource;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.papyrus.moka.debug.MokaStackFrame;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.ActivityEdgeInstance;
import org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities.ActivityNodeActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.FeatureValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.Object_;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.Reference;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.Value;
import org.eclipse.papyrus.moka.launch.EditorUtils;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IEditorPart;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.StructuralFeature;

public class FUMLPresentationUtils {
	
	protected static ServicesRegistry servicesRegistry ;

	protected static ILabelProvider labelProvider ;
	
	protected static EObject contextEObject ;
	
	public static void init(EObject eObject) {
		contextEObject = eObject ;
		labelProvider = null ;
		servicesRegistry = null ;
	}

	public static Image getImage(Object element) {
		try {
			if (element instanceof EObject && ((EObject)element).eIsProxy()) {
				labelProvider = null ;
				servicesRegistry = null ;
			}
			if (labelProvider == null) {
				if (servicesRegistry == null) {
					if (contextEObject.eIsProxy()) {
						IEditorPart part = EditorUtils.getEditorPart(contextEObject) ;
						ServicesRegistry servicesRegistry =  (ServicesRegistry)part.getAdapter(ServicesRegistry.class);
						ResourceSet resourceSet = null ;
						try {
							resourceSet = servicesRegistry.getService(ModelSet.class) ;
						} catch (ServiceException e1) {
							resourceSet = new ResourceSetImpl() ;
							Activator.log.error(e1);
						}
						contextEObject = (Behavior) EcoreUtil.resolve(contextEObject, resourceSet) ;
					}
					else {
						servicesRegistry = ServiceUtilsForResource.getInstance().getServiceRegistry(contextEObject.eResource());
					}
				}
				LabelProviderService labelProviderService = servicesRegistry.getService(LabelProviderService.class);
				labelProvider = labelProviderService.getLabelProvider() ;
				labelProvider.getImage(element) ;
			}
			return labelProvider.getImage(element) ;
		}
		catch (Exception e) {
			Activator.log.error(e) ;
			return null ;
		}
	}

	public static MokaStackFrame getMokaStackFrame(Object baseElement) {
		if (baseElement instanceof ActivityNodeActivation)
			return getMokaStackFrame((ActivityNodeActivation)baseElement) ;
		else if (baseElement instanceof ActivityEdgeInstance) {
			return getMokaStackFrame((ActivityEdgeInstance)baseElement) ;
		}
		else {
			Activator.log.error(new Exception("Unexpected base element for construction of a MokaStackFrame")) ;
			return null ;
		}
	}
	
	public static MokaStackFrame getMokaStackFrame(ActivityNodeActivation activityNodeActivation) {
		return new MokaStackFrame_from_ActivityNodeActivation(activityNodeActivation) ;
	}

	public static MokaStackFrame getMokaStackFrame(ActivityEdgeInstance activityEdgeInstance) {
		return new MokaStackFrame_from_ActivityEdgeInstance(activityEdgeInstance) ;
	}

	public static String getValueString(Value value) {
		if (value == null)
			return "null" ;
		if (value instanceof Object_ || value instanceof Reference) {
			String className = value.getClass().getSimpleName() ;
			String id = "" + value.hashCode() ;
			return className + " (id=" + id + ")" ;
		}
		return value.toString() ;
	}
	
	public static String getValueString(FeatureValue featureValue) {
		StructuralFeature f = featureValue.feature ;
		String valueString = "" ;
		if (isCollection(featureValue)) {
			valueString += f.getType() != null ? f.getType().getName() : "any" ;
			valueString += "[] (size=" + featureValue.values.size();
			valueString += (")") ;
		}
		else {
			Value value = featureValue.values.size() == 1 ? featureValue.values.get(0) : null ;
			return getValueString(value) ;
		}
		return valueString ;
	}
	
	public static boolean isCollection(FeatureValue featureValue) {
		return featureValue.feature.getUpper() == -1 ||
			   featureValue.feature.getUpper() > 1 ||
			   featureValue.values.size() > 1 ;
	}
}
