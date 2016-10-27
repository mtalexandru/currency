package ro.mtalexandru.ws;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by malexandru on 10/27/2016.
 *
 * One way to debug unmapped exceptions is to create a simple ExceptionMapper to catch them
 * When there is no mapper, often the exception will bubble up to the container level, which just gives us generic 500 server error (which most of the time is of little help).
 */
@Provider
public class DebugExceptionMapper implements ExceptionMapper<Exception> {

	@Override
	public Response toResponse(Exception exception) {
		exception.printStackTrace();
		return Response.serverError().entity(exception.getMessage()).build();
	}
}
