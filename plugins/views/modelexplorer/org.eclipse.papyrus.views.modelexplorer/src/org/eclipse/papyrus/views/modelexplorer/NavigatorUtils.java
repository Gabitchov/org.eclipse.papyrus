package org.eclipse.papyrus.views.modelexplorer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramGraphicalViewer;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * Utility method for Model Navigator.
 * 
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano
 *         Muñoz</a>
 * @author <a href="mailto:thomas.szadel@atosorigin.com">Thomas Szadel</a>:
 *         Remove Backbone dependency
 **/
public class NavigatorUtils {

	/**
	 * Find a <IViewPart> by it's id string.
	 * 
	 * @param viewID
	 *        the view id
	 * 
	 * @return the i view part
	 */
	public static IViewPart findViewPart(String viewID) {
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		if(page == null) {
			return null;
		}
		IViewReference reference = page.findViewReference(viewID);
		if(reference == null) {
			return null;
		}
		IWorkbenchPart part = reference.getPart(false);
		if(part instanceof IViewPart) {
			return (IViewPart)part;
		} else {
			return null;
		}
	}

	/**
	 * Unwraps selection. Gets <EObject>s from <EditPart>s, from <View>s or from
	 * <EObject>s
	 * 
	 * @param selection
	 *        the selection
	 * 
	 * @return the i selection
	 */
	public static ISelection unwrapSelection(ISelection selection) {
		if(selection instanceof StructuredSelection && !selection.isEmpty()) {
			List<EObject> selectionList = new ArrayList<EObject>();
			StructuredSelection structuredSelection = (StructuredSelection)selection;
			for(Iterator<?> iterator = structuredSelection.iterator(); iterator.hasNext();) {
				Object next = iterator.next();
				if(next instanceof EditPart) {
					Object model = ((EditPart)next).getModel();
					EObject element = null;
					if(model instanceof View) {
						element = ((View)model).getElement();
					} else if(model instanceof EObject) {
						element = (EObject)model;
					}
					if(element != null) {
						selectionList.add(element);
					}
				} else if(next instanceof View) {
					EObject element = ((View)next).getElement();
					if(element != null) {
						selectionList.add(element);
					}
				}
				EObject eObject = EMFHelper.getEObject(next);
				if(eObject != null) {
					selectionList.add(eObject);
				}
			}
			return new StructuredSelection(selectionList);
		} else {
			return selection;
		}
	}

	/**
	 * Finds the <EditPart>s for the <EObject>s in the selection.
	 * 
	 * @param selection
	 *        the selection
	 * @param viewer
	 *        the viewer
	 * 
	 * @return the edits the parts from selection
	 */
	public static List<EditPart> getEditPartsFromSelection(ISelection selection, IDiagramGraphicalViewer viewer) {
		if(selection instanceof StructuredSelection && !selection.isEmpty()) {
			StructuredSelection structuredSelection = (StructuredSelection)selection;
			// look for Views of the EObjects in the selection
			List<View> views = new ArrayList<View>();
			for(Object o : structuredSelection.toList()) {
				if(o instanceof EObject) {
					List<Object> referencerViews = getEObjectViews((EObject)o);
					for(Object ro : referencerViews) {
						if(ro instanceof View) {
							views.add((View)ro);
						}
					}
				}
			}
			if(!views.isEmpty()) {
				List<EditPart> editParts = new ArrayList<EditPart>();
				for(View view : views) {
					Object ep = viewer.getEditPartRegistry().get(view);
					if(ep instanceof EditPart) {
						editParts.add((EditPart)ep);
					}
				}
				if(!editParts.isEmpty()) {
					return editParts;
				}
			}
		}
		return Collections.emptyList();
	}

	/**
	 * Gets the given <EObject> views.
	 * 
	 * @param element
	 *        the element
	 * 
	 * @return the e object views
	 */
	// @unused
	public static List<Object> getEObjectViews(EObject element) {
		List<Object> views = new ArrayList<Object>();
		if(element != null) {
			EReference[] features = { NotationPackage.eINSTANCE.getView_Element() };
			Collection<?> referencers = EMFCoreUtil.getReferencers(element, features);
			views.addAll(referencers);
		}
		return views;
	}

	//	// //
	//	// get an object name
	//	// //
	//
	//	/**
	//	 * Gets the object name or empty string.
	//	 * 
	//	 * @param object
	//	 *            the object
	//	 * 
	//	 * @return the object name or empty string
	//	 */
	//	// @unused
	//	public static String getObjectNameOrEmptyString(Object object) {
	//		String name = getObjectName(object);
	//		return name == null ? "" : name;
	//	}
	//
	//	/** The Constant getNameNames. */
	//	private static final String[] getNameNames = { "getName", "getname" };
	//
	//	/**
	//	 * Gets the object name.
	//	 * 
	//	 * @param object
	//	 *            the object
	//	 * 
	//	 * @return the object name
	//	 */
	//	// @unused
	//	public static String getObjectName(Object object) {
	//		if (object == null) {
	//			return null;
	//		}
	//		Method method = null;
	//		Object o = null;
	//		for (String methodName : getNameNames) {
	//			try {
	//				method = object.getClass()
	//						.getMethod(methodName, (Class[]) null);
	//			} catch (NoSuchMethodException e) {
	//				method = null;
	//			}
	//			if (method != null) {
	//				break;
	//			}
	//		}
	//		if (method != null) {
	//			try {
	//				o = method.invoke(object, (Object[]) null);
	//			} catch (IllegalAccessException ex) {
	//				return null;
	//			} catch (InvocationTargetException ex) {
	//				return null;
	//			}
	//			if (o instanceof String) {
	//				return (String) o;
	//			}
	//		}
	//		return null;
	//	}


	/**
	 * Opens a view part in the workbench with the specified ID.
	 * 
	 * @param viewPartID
	 */
	// @unused
	public static void openViewPart(String viewPartID) {
		if(viewPartID == null) {
			return;
		}
		try {
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(viewPartID);
		} catch (PartInitException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Opens the property sheets view.
	 */
	public static void openPropertySheetsView() {
		openViewPart("org.eclipse.ui.views.PropertySheet");
	}

	/**
	 * Use the IAdaptable mecanisme
	 * 
	 * @param o
	 * @param theClass
	 * @return
	 */
	public static <T> T getElement(Object o, Class<T> theClass) {
		T result = null;
		if(o instanceof IAdaptable) {
			IAdaptable adaptable = (IAdaptable)o;
			result = (T)adaptable.getAdapter(theClass);
		}
		if(result == null) {
			result = (T)Platform.getAdapterManager().getAdapter(o, theClass);
		}
		if(result == null && theClass.isInstance(o)) {
			result = (T)o;
		}
		return result;
	}

	/**
	 * Search all the elements referencing the context,
	 * filter the results by the predicate
	 * 
	 * @return
	 */
	public static boolean find(EObject toFind, Predicate<Setting> predicate) {
		if(toFind == null || toFind.eResource() == null || toFind.eResource().getResourceSet() == null) {
			return false;
		}
		ResourceSet resourceSet = toFind.eResource().getResourceSet();
		ECrossReferenceAdapter adapter = ECrossReferenceAdapter.getCrossReferenceAdapter(resourceSet);
		if(adapter == null) {
			adapter = new ECrossReferenceAdapter();
			resourceSet.eAdapters().add(adapter);
		}
		Collection<Setting> settings = adapter.getInverseReferences(toFind, false);
		return Iterables.filter(settings, predicate).iterator().hasNext();
	}

	/**
	 * Search all the elements referencing the context,
	 * filter the results by the predicate and apply the function to return the desired types
	 * 
	 * @return
	 */
	public static <T> Collection<T> findFilterAndApply(EObject toFind, Predicate<Setting> predicate, Function<Setting, T> function) {
		if(toFind == null || toFind.eResource() == null || toFind.eResource().getResourceSet() == null) {
			return Collections.emptyList();
		}
		ResourceSet resourceSet = toFind.eResource().getResourceSet();
		ECrossReferenceAdapter adapter = ECrossReferenceAdapter.getCrossReferenceAdapter(resourceSet);
		if(adapter == null) {
			adapter = new ECrossReferenceAdapter();
			resourceSet.eAdapters().add(adapter);
		}
		Collection<Setting> settings = adapter.getInverseReferences(toFind, false);
		return Lists.newLinkedList(Iterables.transform(Iterables.filter(settings, predicate), function));
	}
}
