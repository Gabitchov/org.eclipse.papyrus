/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.profile.custom.requests;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

/**
 * 
 * This class looks like CreateViewAndElementRequest
 * 
 * This class was created to use the CustomCreateElementRequestAdapter (used in the CustomCreateViewRequest)
 */
public class CustomCreateViewAndElementRequest extends CustomCreateViewRequest {
	/**
	 * An extended view descriptor that takes an <code>ElementDescriptor</code> instead of <code>IAdaptable</code> as the element adapter
	 */
	public static class ViewAndElementDescriptor extends ViewDescriptor {
		/**
		 * Constructor for ViewAndElementDescriptor.
		 * 
		 * @param requestAdapter
		 * @param preferencesHint
		 *            The preference hint that is to be used to find the appropriate
		 *            preference store from which to retrieve diagram preference
		 *            values. The preference hint is mapped to a preference store in
		 *            the preference registry <@link DiagramPreferencesRegistry>.
		 */
		public ViewAndElementDescriptor(CustomCreateElementRequestAdapter requestAdapter, PreferencesHint preferencesHint) {
			super(requestAdapter, preferencesHint);
		}

		/**
		 * Constructor for ViewAndElementDescriptor.
		 * 
		 * @param requestAdapter
		 * @param viewkind
		 */
		public ViewAndElementDescriptor(CustomCreateElementRequestAdapter requestAdapter, Class<?> viewkind, PreferencesHint preferencesHint) {
			super(requestAdapter, viewkind, preferencesHint);
		}

		/**
		 * Constructor for ViewAndElementDescriptor.
		 * 
		 * @param requestAdapter
		 * @param viewkind
		 * @param semanticHint
		 */
		public ViewAndElementDescriptor(CustomCreateElementRequestAdapter requestAdapter, Class<?> viewkind, String semanticHint, PreferencesHint preferencesHint) {
			super(requestAdapter, viewkind, semanticHint, preferencesHint);
		}

		/**
		 * Constructor for ViewAndElementDescriptor.
		 * 
		 * @param requestAdapter
		 * @param viewKind
		 * @param semanticHint
		 * @param index
		 */
		public ViewAndElementDescriptor(CustomCreateElementRequestAdapter requestAdapter, Class<?> viewKind, String semanticHint, int index, PreferencesHint preferencesHint) {
			super(requestAdapter, viewKind, semanticHint, index, preferencesHint);
		}

		/**
		 * Method getElementDescriptor.
		 * 
		 * @return ElementDescriptor
		 */
		public CustomCreateElementRequestAdapter getCreateElementRequestAdapter() {
			return (CustomCreateElementRequestAdapter) getElementAdapter();
		}
	}

	/**
	 * Constructor for CreateViewAndElementRequest.
	 * 
	 * @param viewAndElementDescriptor
	 */
	public CustomCreateViewAndElementRequest(ViewDescriptor viewAndElementDescriptor) {
		super(RequestConstants.REQ_CREATE, viewAndElementDescriptor);
	}

	/**
	 * Constructor for CreateViewAndElementRequest.
	 * 
	 * @param type
	 * @param preferencesHint
	 *            The preference hint that is to be used to find the appropriate
	 *            preference store from which to retrieve diagram preference
	 *            values. The preference hint is mapped to a preference store in
	 *            the preference registry <@link DiagramPreferencesRegistry>.
	 */
	public CustomCreateViewAndElementRequest(IElementType type, PreferencesHint preferencesHint) {
		super(new ViewAndElementDescriptor(new CustomCreateElementRequestAdapter(new CreateElementRequest(type)), preferencesHint));
	}

	/**
	 * Constructor for CreateViewAndElementRequest.
	 * 
	 * @param type
	 * @param context
	 * @param preferencesHint
	 *            The preference hint that is to be used to find the appropriate
	 *            preference store from which to retrieve diagram preference
	 *            values. The preference hint is mapped to a preference store in
	 *            the preference registry <@link DiagramPreferencesRegistry>.
	 */
	public CustomCreateViewAndElementRequest(IElementType type, EObject context, PreferencesHint preferencesHint) {
		super(new ViewAndElementDescriptor(new CustomCreateElementRequestAdapter(new CreateElementRequest(TransactionUtil.getEditingDomain(context), context, type)), preferencesHint));
	}

	/**
	 * Method getViewAndElementDescriptor.
	 * 
	 * @return ViewAndElementDescriptor
	 */
	public ViewAndElementDescriptor getViewAndElementDescriptor() {
		return (ViewAndElementDescriptor) getViewDescriptors().get(0);
	}

	/**
	 * Propagates setting the parameters to the <code>CreateElementRequest</code> in my {@link #getViewAndElementDescriptor()}.
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void setExtendedData(Map map) {
		super.setExtendedData(map);
		ViewAndElementDescriptor descriptor = getViewAndElementDescriptor();
		if (descriptor != null) {
			CreateElementRequestAdapter adapter = descriptor.getCreateElementRequestAdapter();
			if (adapter != null) {
				CreateElementRequest request = (CreateElementRequest) adapter.getAdapter(CreateElementRequest.class);
				if (request != null) {
					request.getParameters().clear();
					request.addParameters(map);
				}
			}
		}
	}
}
