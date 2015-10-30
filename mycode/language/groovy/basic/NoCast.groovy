@groovy.transform.TypeChecked
def use(Object instance) {
    if (instance instanceof String) {
       println instance.length()
    }
    else {
    	 println instance
    }
}

use("hello")
use(4)

	 
       