package utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriverException;

import cucumber.runtime.StepDefinition;
import extentmanager.ExtentManager;
import stepdefinition.stepdefinition;

public class ExecutionEngine {
	
	ErrorLogger err = new ErrorLogger();
	
	public static long startMethodTime, endMethodtime;
	
	/* i need to wrap the exception around invocation target exception for the ..cucumber exceptions to work
	 * as the exception will be eventually handled as an invocation target exception here that is the reason a 
	 * custom exception class is written
	 */

	public boolean executeMethod(String classname, String methodname,String[] arlist)  {
		try {
			startMethodTime=System.currentTimeMillis();
			stepdefinition.isServicedown=false;
			checkassertionError(classname, methodname);
			System.out.println("Entered the executemethod");
			boolean returnvalue = false;
			Object returnvalueObject= null;

			Object classobject = Class.forName(classname).newInstance();
			Object castedObject = Class.forName(classname).cast(classobject);
			Class [] argtypes = new Class [] {String[].class};
			//Method method = classobject.getClass().getMethod(methodname,String.class,String.class);
			Method method = classobject.getClass().getMethod(methodname,argtypes);

			try {
				returnvalueObject= method.invoke(classobject,(Object)arlist);
				returnvalue =(Boolean)returnvalueObject;
				endMethodtime=System.currentTimeMillis();
				logmethodExecetails(classname, methodname, returnvalue);
				//System.out.println("<Page>"+classname+"</Page><Method>"+classname+"."+methodname+"</Method><exectime>"+((endMethodtime-startMethodTime)/1000)+"</exectime>");
				//if(returnvalue==false)
				//MainDriverTest.finalresult.add("FAIL");

				//returnvalue=(boolean) method.invoke(classobject,(Object)arlist);
			} catch (IllegalArgumentException e) {
				//MainDriverTest.finalresult.add( "FAIL");
				
				err.logcommonMethodError(classname, methodname, e);
				e.printStackTrace();
				return returnvalue;
			} catch (InvocationTargetException e) {
				
				//MainDriverTest.finalresult.add( "FAIL");
				err.logcommonMethodError(classname, methodname, e);
				e.printStackTrace();
				return returnvalue;
			}catch(UnhandledAlertException e){
				e.printStackTrace();
				//MainDriverTest.finalresult.add( "FAIL");
				err.logcommonMethodError(classname, methodname, e);
				return returnvalue;
			}
			catch(WebDriverException e){
				e.printStackTrace();
				//MainDriverTest.finalresult.add( "FAIL");
				err.logcommonMethodError(classname, methodname, e);
				return returnvalue;
			}
			//takescreenshot();
			return returnvalue;
		}
		catch (InstantiationException e) {
			//MainDriverTest.finalresult.add( "FAIL");
			
			err.logcommonMethodError(classname, methodname, e);
			e.printStackTrace();
			return false;
		} catch (IllegalAccessException e) {
			//MainDriverTest.finalresult.add( "FAIL");
			
			err.logcommonMethodError(classname, methodname, e);
			e.printStackTrace();
			return false;
		} catch (ClassNotFoundException e) {
			
			//MainDriverTest.finalresult.add( "FAIL");
			err.logcommonMethodError(classname, methodname, e);
			e.printStackTrace();
			return false;
		} catch (NoSuchMethodException e) {
			
			//MainDriverTest.finalresult.add("FAIL");
			err.commonExecutorlogError("Function");
			e.printStackTrace();
			return false;
		} catch (SecurityException e) {
			
			//MainDriverTest.finalresult.add(MainDriverTest.loopvar, "FAIL");
			err.logcommonMethodError(classname, methodname, e);
			e.printStackTrace();
			return false;
		}
		


	}
	public boolean executeMethod(String classname, String methodname)  {
		try {
			startMethodTime=System.currentTimeMillis();
			stepdefinition.isServicedown=false;
			checkassertionError(classname, methodname);
			boolean returnvalue = false;
			Object returnvalueObject= null;
			Object classobject = Class.forName(classname).newInstance();
			//Object castedObject = Class.forName(classname).cast(classobject);
			Class[] argtypes = new Class[] {};
			//Method method = classobject.getClass().getMethod(methodname,String.class,String.class);
			Method method = classobject.getClass().getMethod(methodname,argtypes);


			try {
				returnvalueObject=method.invoke(classobject);
				returnvalue= (Boolean)returnvalueObject;
				endMethodtime=System.currentTimeMillis();
				logmethodExecetails(classname, methodname, returnvalue);
				//System.out.println("<Page>"+classname+"</Page><Method>"+classname+"."+methodname+"</Method><exectime>"+((endMethodtime-startMethodTime)/1000)+"</exectime>");
				//if(returnvalue==false)
				//MainDriverTest.finalresult.add("FAIL");
			} catch (IllegalArgumentException e) {
				
				//MainDriverTest.finalresult.add( "FAIL");
				System.out.println("--------------------------------------------------> "+e);
				err.logcommonMethodError(classname, methodname, e);

				e.printStackTrace();
				return returnvalue;
			} catch (InvocationTargetException e) {
				
				//MainDriverTest.finalresult.add( "FAIL");
				System.out.println("--------------------------------------------------> "+e);
				err.logcommonMethodError(classname, methodname, e);
				e.printStackTrace();
				return returnvalue;
			}
			catch (NullPointerException e) {
				
				//MainDriverTest.finalresult.add("FAIL");
				System.out.println("There is no return defined in the Method");
				e.printStackTrace();
				System.out.println("--------------------------------------------------> "+e);
				err.logcommonMethodError(classname, methodname, e);
				return returnvalue;
			}
			catch(UnhandledAlertException e){
				e.printStackTrace();
				//MainDriverTest.finalresult.add( "FAIL");
				System.out.println("Common Exception  --------------------------------------------------> "+e);
				err.logcommonMethodError(classname, methodname, e);
				return false;
			}catch(WebDriverException e){
				e.printStackTrace();
				//MainDriverTest.finalresult.add( "FAIL");
				err.logcommonMethodError(classname, methodname, e);
				return returnvalue;
			}
			//takescreenshot();
			return returnvalue;
		}
		catch (InstantiationException e) {
			//MainDriverTest.finalresult.add( "FAIL");
			
			e.printStackTrace();
			System.out.println("--------------------------------------------------> "+e);
			err.logcommonMethodError(classname, methodname, e);
			return false;
		} catch (IllegalAccessException e) {
			
			//MainDriverTest.finalresult.add( "FAIL");
			e.printStackTrace();
			System.out.println("--------------------------------------------------> "+e);
			err.logcommonMethodError(classname, methodname, e);
			return false;
		} catch (ClassNotFoundException e) {
			
			//MainDriverTest.finalresult.add( "FAIL");
			e.printStackTrace();
			System.out.println("--------------------------------------------------> "+e);
			err.logcommonMethodError(classname, methodname, e);
			return false;
		} catch (NoSuchMethodException e) {
			
			//MainDriverTest.finalresult.add( "FAIL");
			e.printStackTrace();
			err.logcommonMethodError(classname, methodname, e);
			return false;
		} catch (SecurityException e) {
			
			//MainDriverTest.finalresult.add( "FAIL");
			e.printStackTrace();
			System.out.println("--------------------------------------------------> "+e);
			err.logcommonMethodError(classname, methodname, e);
			return false;
		} 


	}
	
	void checkassertionError(String classname,String methodname){
		if(!ExtentManager.getDebugMessage().contains("Potential"))
		ExtentManager.setDebugMessage("Page:"+classname+"Method:"+methodname);
	}

	private void logmethodExecetails(String classname,String methodname,boolean isSuccess){
		String methodStatus="fail";
		if(isSuccess)
			methodStatus="Success";
				System.out.println("<Page>"+classname+"</Page><Method>"+classname+"."+methodname+"</Method><exectime>"+((endMethodtime-startMethodTime)/1000)+"</exectime><Status>"+methodStatus+"</Status>");
		
	}
}
