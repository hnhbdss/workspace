all:
	javac HelloLoader.java
	cp HelloLoader.class boot_dir/
	cp HelloLoader.class bin_dir/
	java -Xbootclasspath/a:boot_dir -cp . FindClassOrder
	java -cp .:bin_dir FindClassOrder
