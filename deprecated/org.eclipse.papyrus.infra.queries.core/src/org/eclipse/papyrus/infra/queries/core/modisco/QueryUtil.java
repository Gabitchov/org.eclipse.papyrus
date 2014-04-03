/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.queries.core.modisco;


/**
 * Utility class for modisco queries
 */
public class QueryUtil {
	
	/** default value in case the query is not valid */
	protected static final boolean defaultReturnValue = false;

	/**
	 * Constructor.
	 * Note: can not be instanciated, as it provides only static methods.
	 */
	protected QueryUtil() {
	}

//	/**
//	 * Evaluates a modisco query, that should only return a boolean value.
//	 * 
//	 * @param query
//	 *        the query to check and evaluate
//	 * @param context
//	 *        the eobject on which the query is evaluated
//	 * @param parameters
//	 *        a map containing the name of parameters and their values
//	 * @return <code>true</code> if the context fills the condition given by the query
//	 * @throws Exception
//	 *         exception thrown when the query could not be correctly evaluated
//	 */
//	public static final boolean evaluateBooleanQuery(final ModelQuery query, EObject context, Map<String, Object> parameters) throws Exception {
//		// construct the structure parameterValues if the query is valid
//		IStatus queryStatus = isValidQuery(query);
//		if(!queryStatus.isOK()) {
//			throw new Exception(queryStatus.getMessage());
//		}
//
//		// if no parameters, evaluate
//		List<ModelQueryParameter> queryParameters = query.getParameters();
//		List<ModelQueryParameterValue> parameterValues = new ArrayList<ModelQueryParameterValue>();
//		if(queryParameters == null || queryParameters.isEmpty()) {
//			return evaluateBooleanQuery(query, context, parameterValues);
//		}
//
//		// check the parameters given and the set of required parameters
//		IStatus parameterCheck = isValidParameterSet(query, parameters);
//		if(IStatus.CANCEL == parameterCheck.getSeverity() || IStatus.ERROR == parameterCheck.getSeverity()) {
//			Activator.log.error(parameterCheck.getMessage(), null);
//			throw new Exception(parameterCheck.getMessage());
//		} else if(IStatus.WARNING == parameterCheck.getSeverity()) {
//			Activator.log.warn(parameterCheck.getMessage());
//		} else if(IStatus.INFO == parameterCheck.getSeverity()) {
//			Activator.log.info(parameterCheck.getMessage());
//		}
//
//		// construct parameter structure for Modisco solver
//		for(ModelQueryParameter parameter : queryParameters) {
//			String parametername = parameter.getName();
//			Object value = parameters.get(parametername);
//			ModelQueryParameterValue parameterValue = ParameterValueList.createParameterValue(value, parameter);
//
//			// should try to bind elements here..
//			parameterValues.add(parameterValue);
//		}
//
//		// execute the query
//		return evaluateBooleanQuery(query, context, parameterValues);
//	}
//
//	/**
//	 * Evaluates a query.
//	 * 
//	 * @param context
//	 *        the eobject on which the query is evaluated
//	 * @param queryConfiguration
//	 *        the query configuration, containing all values for the parameters of the query
//	 * @return the result of the execution of the query
//	 * @throws Exception
//	 *         exception thrown when the query could not be correctly evaluated
//	 */
//	public static final Object evaluateQuery(EObject context, QueryConfiguration queryConfiguration) throws Exception {
//		if(queryConfiguration instanceof ModiscoQueryConfiguration) {
//			return evaluateQuery(context, (ModiscoQueryConfiguration)queryConfiguration);
//		}
//		throw new Exception("Unhandled kind of query");
//	}
//
//	/**
//	 * Evaluates a query, that should only return a boolean value.
//	 * 
//	 * @param context
//	 *        the eobject on which the query is evaluated
//	 * @param queryConfiguration
//	 *        the query configuration, containing all values for the parameters of the query
//	 * @return <code>true</code> if the context fills the condition given by the query
//	 * @throws Exception
//	 *         exception thrown when the query could not be correctly evaluated
//	 */
//	public static final boolean evaluateBooleanQuery(EObject context, QueryConfiguration queryConfiguration) throws Exception {
//		if(queryConfiguration instanceof ModiscoQueryConfiguration) {
//			return evaluateBooleanQuery(context, (ModiscoQueryConfiguration)queryConfiguration);
//		}
//		throw new Exception("Unhandled kind of query");
//	}
//
//	/**
//	 * Evaluates a modisco query, that should only return a boolean value.
//	 * 
//	 * @param context
//	 *        the eobject on which the query is evaluated
//	 * @param queryConfiguration
//	 *        the query configuration, containing all values for the parameters of the query
//	 * @return <code>true</code> if the context fills the condition given by the query
//	 * @throws Exception
//	 *         exception thrown when the query could not be correctly evaluated
//	 */
//	public static final boolean evaluateBooleanQuery(EObject context, ModiscoQueryConfiguration queryConfiguration) throws Exception {
//		Object result = evaluateQuery(context, queryConfiguration);
//		if(result instanceof Boolean) {
//			return (Boolean)result;
//		}
//		Activator.log.error("Not a boolean result:  " + result, null);
//		return defaultReturnValue;
//	}
//
//	/**
//	 * Evaluates a modisco query, that should only return a boolean value.
//	 * 
//	 * @param context
//	 *        the eobject on which the query is evaluated
//	 * @param queryConfiguration
//	 *        the query configuration, containing all values for the parameters of the query
//	 * @return <code>true</code> if the context fills the condition given by the query
//	 * @throws Exception
//	 *         exception thrown when the query could not be correctly evaluated
//	 */
//	public static final Object evaluateQuery(EObject context, ModiscoQueryConfiguration queryConfiguration) throws Exception {
//		// retrieve query (problem of bundle loader if not used correctly)
//		ModelQuery query = queryConfiguration.getQuery();
//		String modelQuerySetName = query.getModelQuerySet().getName();
//		String modelQueryName = query.getName();
//
//		ModelQuery finalModelQuery = retrieveModelQuery(modelQueryName, modelQuerySetName);
//
//		// construct the structure parameterValues if the query is valid
//		IStatus queryValidation = isValidQuery(finalModelQuery);
//		if(!queryValidation.isOK()) {
//			throw new Exception(queryValidation.getMessage(), queryValidation.getException());
//		}
//
//		// create the set of parameter values
//		List<ModelQueryParameterValue> parameterValues = createParameterValuesListFromConfiguration(context, queryConfiguration);
//
//		// execute the query
//		return evaluateQuery(finalModelQuery, context, parameterValues);
//	}
//
//	/**
//	 * Creates the {@link ModelQueryParameterValue} list from a configuration
//	 * 
//	 * @param queryConfiguration
//	 *        the configuration to check
//	 * @return the list of parameter values
//	 */
//	private static List<ModelQueryParameterValue> createParameterValuesListFromConfiguration(EObject context, ModiscoQueryConfiguration queryConfiguration) {
//		List<ModelQueryParameterValue> parameterValues = new ArrayList<ModelQueryParameterValue>();
//
//		List<ModelQueryParameter> parameters = queryConfiguration.getQuery().getParameters();
//		for(ModelQueryParameter parameter : parameters) {
//			Object value = retrieveParameterValue(context, parameter, queryConfiguration);
//				// resolve the value for the parameters
//			ModelQueryParameterValue parameterValue = ParameterValueList.createParameterValue(value, parameter);
//			parameterValues.add(parameterValue);
//		}
//		return parameterValues;
//	}
//
//	/**
//	 * Retrieves the value of a parameter.
//	 * 
//	 * @param parameter
//	 *        the parameter for which the value is computed
//	 * @return the parameter value associated to the parameter
//	 */
//	private static Object retrieveParameterValue(final EObject context, final ModelQueryParameter parameter, ModiscoQueryConfiguration configuration) {
//		for(final ParameterValue parameterValue : configuration.getParameterValues()) {
//			if(parameter.equals(parameterValue.getParameter())) {
//				// This is the right parameter. Compute the value, depending on the type of the parameters
//				return new ConfigurationSwitch<Object>() {
//
//					/**
//					 * {@inheritDoc}
//					 */
//					@Override
//					public Object caseListParameterValue(ListParameterValue listParameterValue) {
//						ArrayList<Object> values = new ArrayList<Object>();
//						Class<?> parameterType = parameter.getType().getInstanceClass();
//						for(ParameterValue parameterValue : listParameterValue.getValues()) {
//							values.addAll(ConverterRegistry.getSingleton().convertToList(context, parameterType, parameterValue));
//						}
//						return values;
//					};
//
//					/**
//					 * {@inheritDoc}
//					 */
//					@Override
//					public Object caseConstantParameterValue(ConstantParameterValue constantParameterValue) {
//						Class<?> parameterType = parameter.getType().getInstanceClass();
//						try {
//							Object convertedValue = ConverterRegistry.getSingleton().convert(parameterType, constantParameterValue.getValueInstance());
//							return convertedValue;
//						} catch (ConverterNotfoundException e) {
//							Activator.log.error(e);
//						}
//						return null;
//					};
//
//
//					/**
//					 * {@inheritDoc}
//					 */
//					@Override
//					public Object caseQueryExecutionValue(QueryExecutionValue queryExecutionValue) {
//						// retrieves the associated configuration and launch it.
//						QueryConfiguration configuration = queryExecutionValue.getConfiguration();
//						try {
//							return QueryUtil.evaluateQuery(context, configuration);
//						} catch (Exception e) {
//							Activator.log.error(e);
//						}
//						return null;
//
//					};
//				}.doSwitch(parameterValue);
//			}
//		}
//		return null;
//		
//	}
//
//	/**
//	 * Evaluates a modisco query.
//	 * 
//	 * @param query
//	 *        the query to evaluate
//	 * @param context
//	 *        the context element against which the query is evaluated
//	 * @param parameterValues
//	 *        the list of parameters for the query
//	 * @return the result of the query evaluation
//	 * @throws Exception
//	 *         exception thrown in case of problem during evaluation of the query
//	 */
//	public static final Object evaluateQuery(final ModelQuery query, EObject context, List<ModelQueryParameterValue> parameterValues) throws Exception {
//		// checks that the query is valid
//		if(isValidQuery(query).isOK()) {
//			AbstractModelQuery myModelQuery;
//				myModelQuery = ModelQuerySetCatalog.getSingleton().getModelQueryImpl(query);
//				//the model query set evaluation
//				ModelQueryResult result = myModelQuery.evaluate(context, parameterValues);
//				if(result.getException() != null) {
//					throw new Exception();
//				}
//				return result.getValue();
//		}
//		throw new Exception("Query was not a valid query: " + query, null);
//	}
//
//	/**
//	 * Evaluates a modisco query, that should only return a boolean value.
//	 * 
//	 * @param query
//	 *        the query to check and evaluate
//	 * @param context
//	 *        the eobject on which the query is evaluated
//	 * @param parameterValues
//	 *        the list of parameter values for the evaluation
//	 * @return <code>true</code> if the context fills the condition given by the query
//	 * @throws Exception
//	 *         exception thrown when the query can not be correctly evaluated
//	 */
//	public static final boolean evaluateBooleanQuery(final ModelQuery query, EObject context, List<ModelQueryParameterValue> parameterValues) throws Exception {
//		Object result = evaluateQuery(query, context, parameterValues);
//		if(result instanceof Boolean) {
//			// try to cast into a boolean
//			return (Boolean)result;
//		}
//		Activator.log.error("Query did not return a boolean: " + result, null);
//		return defaultReturnValue;
//	}
//
//	/**
//	 * Retrieves a model query, given its name and its query set.
//	 * 
//	 * @param queryName
//	 *        the name of the query
//	 * @param querySetName
//	 *        the name of the query set
//	 * @return the found model query or <code>null</code>.
//	 * @throws ModelQueryNotFoundException
//	 *         exception thrown when the the query set was found but not the model query was not found.
//	 * @throws ModelQuerySetNotFoundException
//	 *         exception thrown when the the query set was not found.
//	 */
//	public static final ModelQuery retrieveModelQuery(String queryName, String querySetName) throws ModelQueryNotFoundException, ModelQuerySetNotFoundException {
//		ModelQuerySet querySet = ModelQuerySetCatalog.getSingleton().getModelQuerySet(querySetName);
//		if(querySet == null) {
//			throw new ModelQuerySetNotFoundException(querySetName);
//		}
//		
//		ModelQuery query = querySet.getQuery(queryName);
//		if(query == null) {
//			throw new ModelQueryNotFoundException(queryName);
//		}
//		
//		return query;
//	}
//	
//	/**
//	 * Checks if the query is valid, i.e. not <code>null</code>, returning a boolean value, etc.
//	 * 
//	 * @param query
//	 *        the query to test
//	 * @return <code>true</code> if the query is valid
//	 */
//	public static final IStatus isValidQuery(ModelQuery query) {
//		if(query == null) {
//			return new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Query should not be null.");
//		}
//		return Status.OK_STATUS;
//	}
//	
//	/**
//	 * Checks if the query is valid, i.e. not <code>null</code>, returning a boolean value, etc. 
//	 * @param query the query to test
//	 * @return <code>true</code> if the query is valid
//	 */
//	public static final IStatus isValidBooleanQuery(ModelQuery query) {
//		IStatus status = isValidQuery(query);
//		if(status.isOK()) {
//			// check the instance type is compatible with boolean 
//			EClassifier returnType = query.getReturnType();
//			if(returnType == null) {
//				return new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Query " + query.getName() + " does not have a return value, whereas it should have a boolean return status");
//			} else {
//				Class<?> instanceClass = returnType.getInstanceClass();
//				if(!boolean.class.isAssignableFrom(instanceClass)) {
//					return new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Query " + query.getName() + " should return a value that can be cast into Boolean value. Currently: " + returnType.getInstanceClass());
//				}
//				// check return size of the query... should be 0..1 or 1..1 (even 0..1 could be difficult to handle, but we let this possible)
//				if(query.getUpperBound() > 1 || query.getUpperBound() < 0) {
//					return new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Query " + query.getName() + " should return only one value. Currently: " + query.getUpperBound());
//				}
//			}
//		}
//		return status;
//	}
//	
//	/**
//	 * Check if the set of given parameters is compatible with the query 
//	 * @param query the query against which the set of parameters is tested
//	 * @param parameters the map of parameter names and their value
//	 * @return the status corresponding to the validation
//	 */
//	public static final IStatus isValidParameterSet(ModelQuery query, Map<String, Object> parameters) {
//		// check size, which should be equal.
//		int querySize = query.getParameters().size();
//		int parameterSize = parameters.keySet().size();
//
//		if(querySize != parameterSize) {
//			return new Status(IStatus.ERROR, Activator.PLUGIN_ID, "The given parameters set do not have the same size (" + parameterSize + ") than the query parameter set (" + querySize + ")");
//		}
//
//		List<IStatus> status = new ArrayList<IStatus>();
//
//		// size is ok, checking names, type, multiplicity 
//		for(String parameterName : parameters.keySet()) {
//			// retrieve the equivalent parameter in the query
//			ModelQueryParameter queryParameter = retrieveParameterByName(query, parameterName);
//			if(queryParameter == null) {
//				status.add(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Impossible to find the parameter " + parameterName + " in the query parameters list for query: " + query.getName()));
//			}
//		}
//		if(status.size() > 0) {
//			return new MultiStatus(Activator.PLUGIN_ID, IStatus.OK, status.toArray(new IStatus[status.size()]), "", null);
//		}
//		return Status.OK_STATUS;
//	}
//
//	/**
//	 * Retrieves a parameter, given the query to look into and the name of the parameter
//	 * 
//	 * @param query
//	 *        the query where the parameter is stored
//	 * @param parameterName
//	 *        the name of the parameter
//	 * @return the parameter
//	 */
//	private final static ModelQueryParameter retrieveParameterByName(ModelQuery query, String parameterName) {
//		for(ModelQueryParameter queryParameter : query.getParameters()) {
//			if(parameterName.equals(queryParameter.getName())) {
//				return queryParameter;
//			}
//		}
//		return null;
//	}
}
