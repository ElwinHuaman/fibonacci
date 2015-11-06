package miw.aspectj;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
 

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
 
@Aspect
public class FibonacciCache2 {
  
  private static Map<Integer, Long> cache = new HashMap<Integer, Long>();
    
  @Around("call(int miw.aspectj.Calculator.fibonacci(long))")
  public long cacheFibonacci(ProceedingJoinPoint thisJoinPoint) throws Throwable{
     
    Object[] args = thisJoinPoint.getArgs();
    Integer arg = (Integer)args[0];
     
    if(!cache.containsKey(arg)){
      cache.put(arg, (long)thisJoinPoint.proceed(thisJoinPoint.getArgs()));
    }
     
    return cache.get(arg);
  }
}
