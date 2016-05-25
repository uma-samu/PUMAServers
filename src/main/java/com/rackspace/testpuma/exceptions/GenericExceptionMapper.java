package com.rackspace.testpuma.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
* This class is used for mapping all the generic exceptions
* raised in the application
*
* @author  Umadevi Samudrala
* @version 1.0
* @since   2016-05-25 
*/
@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

	/**
	 * This method is used to convert the generic error raised into 
	 * proper INTERNAL_SERVER_ERROR response
	 * 
	 * @param Throwable - exception object
	 * @return Response - the error response
	 */
	@Override
	public Response toResponse(Throwable arg0) {
		ErrorDetail errorDetail = new ErrorDetail(2, "Generic Error", arg0.getMessage());
		return Response.status(Status.INTERNAL_SERVER_ERROR)
				.entity(errorDetail)
				.build();

	}

}
