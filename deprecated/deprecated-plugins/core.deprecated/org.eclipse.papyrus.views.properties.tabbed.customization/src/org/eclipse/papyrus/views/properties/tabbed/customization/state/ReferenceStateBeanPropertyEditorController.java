package org.eclipse.papyrus.views.properties.tabbed.customization.state;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.papyrus.views.properties.runtime.controller.IBoundedValuesController;
import org.eclipse.papyrus.views.properties.runtime.state.IState;
import org.eclipse.papyrus.views.properties.tabbed.core.view.StatesStore;

/**
 * Controller for references between states
 */
public class ReferenceStateBeanPropertyEditorController extends StateBeanPropertyEditorController implements IBoundedValuesController {

	/** identifier for this controller */
	public final static String ID = "referenceStateBeanPropertyEditorController";

	/** label provider for references */
	protected ILabelProvider labelProvider = initLabelProvider();

	/**
	 * Creates and return the label provider for this controller
	 * Retrieves appropriate text and image thanks to #{@link org.eclipse.papyrus.views.properties.tabbed.core.view.StatesStore}.
	 * 
	 * #FIXME This part of the code is really ugly both for the getText and getImage. We should rework on references between States.
	 * 
	 * @return the label provider for this controller
	 */
	protected ILabelProvider initLabelProvider() {
		final ILabelProvider provider = new LabelProvider() {

			/**
			 * {@inheritDoc}
			 */
			public String getText(Object input) {
				if(input instanceof String) {
					String propertyName = getDescriptor().getPropertyName();
					String stateName = ((IState)objectToEdit.get(0)).getClass().getSimpleName();

					try {
						Method[] methods = StatesStore.class.getDeclaredMethods();
						String searchMethodName = "getText" + stateName + propertyName;
						for(Method method : methods) {
							if(searchMethodName.equalsIgnoreCase(method.getName())) {
								method.setAccessible(true);
								Object arguments[] = { (String)input };
								String text = (String)method.invoke(null, arguments);
								if(text != null) {
									return text;
								}
							}
						}
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					return "";
				} else {
					return input.toString();
				}
			}

			/**
			 * {@inheritDoc}
			 */
			@Override
			public org.eclipse.swt.graphics.Image getImage(Object input) {
				if(input instanceof String) {
					String propertyName = getDescriptor().getPropertyName();
					String stateName = ((IState)objectToEdit.get(0)).getClass().getSimpleName();

					try {
						Method[] methods = StatesStore.class.getDeclaredMethods();
						String searchMethodName = "getImage" + stateName + propertyName;
						for(Method method : methods) {
							if(searchMethodName.equalsIgnoreCase(method.getName())) {
								method.setAccessible(true);
								org.eclipse.swt.graphics.Image image = (org.eclipse.swt.graphics.Image)method.invoke(null);
								if(image != null) {
									return image;
								}
							}
						}
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					return null;
				} else {
					return null;
				}
			}

		};
		return provider;
	}

	/**
	 * {@inheritDoc}
	 */
	public ILabelProvider getEditorLabelProvider() {
		return labelProvider;
	}

	/**
	 * {@inheritDoc}
	 */
	public Object getAvailableValues() {
		List<String> values = new ArrayList<String>();
		for(Object object : objectToEdit) {
			if(object instanceof IState) {
				IState state = (IState)object;
				String propertyName = getDescriptor().getPropertyName();
				try {
					Method[] methods = state.getClass().getDeclaredMethods();
					String searchMethodName = "getAvailable" + propertyName;
					for(Method method : methods) {
						if(searchMethodName.equalsIgnoreCase(method.getName())) {
							method.setAccessible(true);
							values.addAll((List<String>)method.invoke(state));
						}
					}
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return values;
	}

	/**
	 * {@inheritDoc}
	 */
	public Object[] getCurrentValues() {
		List<String> values = new ArrayList<String>();
		for(Object object : objectToEdit) {
			if(object instanceof IState) {
				IState state = (IState)object;
				String propertyName = getDescriptor().getPropertyName();
				try {
					Method[] methods = state.getClass().getDeclaredMethods();
					String searchMethodName = "get" + propertyName;
					for(Method method : methods) {
						if(searchMethodName.equalsIgnoreCase(method.getName())) {
							method.setAccessible(true);
							values.add((String)method.invoke(state));
						}
					}
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return values.toArray();
	}

	/**
	 * {@inheritDoc}
	 */
	public List<ViewerFilter> getViewerFilters() {
		List<ViewerFilter> filters = new ArrayList<ViewerFilter>();
		ViewerFilter typeFilter = new ViewerFilter() {

			/**
			 * {@inheritDoc}
			 */
			@Override
			public boolean select(Viewer viewer, Object parentElement, Object element) {
				// return containsValidElements(element,
				// getFeatureToEdit().getEType().getInstanceClass());
				return true;
			}
		};
		filters.add(typeFilter);
		return filters;
	}

	/**
	 * {@inheritDoc}
	 */
	public IStructuredContentProvider getContentProvider() {

		ITreeContentProvider contentProvider = new ITreeContentProvider() {

			/**
			 * {@inheritDoc}
			 */
			public void dispose() {
				// Nothing todo
			}

			/**
			 * {@inheritDoc}
			 */
			public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
				// TODO Auto-generated method stub

			}

			/**
			 * {@inheritDoc}
			 */
			public Object[] getElements(Object inputElement) {
				if(inputElement instanceof List<?>) {
					return ((List)inputElement).toArray();
				} else {
					return null;
				}
			}

			/**
			 * {@inheritDoc}
			 */
			public Object[] getChildren(Object parentElement) {
				// TODO Auto-generated method stub
				return null;
			}

			/**
			 * {@inheritDoc}
			 */
			public Object getParent(Object element) {
				// TODO Auto-generated method stub
				return null;
			}

			/**
			 * {@inheritDoc}
			 */
			public boolean hasChildren(Object element) {
				// TODO Auto-generated method stub
				return false;
			}

		};
		return contentProvider;
	}

	/**
	 * {@inheritDoc}
	 */
	public ILabelProvider getBrowserLabelProvider() {
		return labelProvider;
	}


}
