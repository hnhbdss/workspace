package com.demo

package object MyPackage {
	val default_name = "Hili"
}

package MyPackage {

	class MyClass {
	      val name = default_name
	}
}
