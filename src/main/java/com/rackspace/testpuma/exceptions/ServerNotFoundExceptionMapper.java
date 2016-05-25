package com.rackspace.testpuma.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
* This class is used for mapping all the server not found exceptions
* raised in the application
*
* @author  Umadevi Samudrala
* @version 1.0
* @since   2016-05-25 
*/
@Provider
public class ServerNotFoundExceptionMapper implements ExceptionMapper<ServerNotFoundException>{

	/**
	 * This method is used to convert the server not found exception raised into 
	 * proper NOT_FOUND response
	 * 
	 * @param Throwable - exception object
	 * @return Response - the error response
	 */
	@Override
	public Response toResponse(ServerNotFoundException snfe) {
		ErrorDetail errorDetail = new ErrorDetail(1, "Server Not Found", snfe.getMessage());
		return Response.status(Status.NOT_FOUND)
				.entity(errorDetail)
				.build();

	}

}
