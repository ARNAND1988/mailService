package com.mailservice.service.helper;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Response.StatusType;

//import com.tagcmd.api.core.base.BaseEntity;
//import com.tagcmd.api.core.constants.CoreExceptionCodeConstants;
//import com.tagcmd.api.core.domain.ExceptionBean;
//import com.tagcmd.api.core.domain.User;
//import com.tagcmd.api.core.error.IBusinessError;
//import com.tagcmd.api.core.error.IBusinessErrorHolder;
//import com.tagcmd.api.core.exception.CMDException;
//import com.tagcmd.api.core.exception.GenericException;
//import com.tagcmd.api.core.exception.ValidationException;
//import com.tagcmd.api.core.exception.ValidationExceptionList;
//import com.tagcmd.api.core.service.IBaseHelper;


public class BaseHelper {//extends BaseEntity implements IBaseHelper {

//	public void evaluateException(List<ExceptionBean> exceptionBeanList) {
//		if ( exceptionBeanList.size() == 1 ) {
//			throw new ValidationException(exceptionBeanList.get(0));
//		} else if ( exceptionBeanList.size() > 1 ){
//			throw new ValidationExceptionList(exceptionBeanList);
//		} 
//	}
//	
//	public void evaluateErrors(List<IBusinessErrorHolder> errorHolders, StatusType httpStatus) {
//		if (errorHolders.size() == 1 ) {
//			evaluateError(errorHolders.get(0).getBusinessError());
//		} else if (errorHolders.size() > 1 ){
//			List<IBusinessError> errors = new ArrayList<IBusinessError>();
//			for(IBusinessErrorHolder errorHolder:errorHolders) {
//				errors.add(errorHolder.getBusinessError());
//			}
//			throw new CMDException(errors, httpStatus);
//		}
//	}
//	
//	public void evaluateError(IBusinessError error) {
//		if(error != null) {
//			throw new CMDException(error);
//		}
//	}
}
