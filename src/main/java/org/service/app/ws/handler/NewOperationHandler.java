package org.service.app.ws.handler;

import org.service.app.ws.AppSkeleton;

public class NewOperationHandler extends AppSkeleton{
	
	 @Override
	 public org.service.www.app.NewOperationResponse newOperation(
		        org.service.www.app.NewOperation newOperation) {
		 return new org.service.www.app.NewOperationResponse(); 
	 }
	
}
