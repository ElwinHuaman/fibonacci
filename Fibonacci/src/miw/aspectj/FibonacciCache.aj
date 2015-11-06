package miw.aspectj;

import java.util.HashMap;
import java.util.Map;

public aspect FibonacciCache {

	private Map<Integer, Integer> cache = new HashMap<Integer, Integer>();
	
	pointcut fibo(Calculator n): call(void fibonacci(int)) && target(n) && args(newVal);
	void around(Calculator n): fibo(n){
		if (cache.get(n) != null) {
			System.out.println("Nada");
		} else {
			System.out.println("todo");
		}
	}
	
	//aorund
	//if si esta en la cache
	//else llamar a la funcion y guardar en la ccache
}
