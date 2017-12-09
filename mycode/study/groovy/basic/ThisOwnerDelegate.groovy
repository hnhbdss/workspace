def examingClosure(closure) {
  closure()
}


examingClosure {
  println "... this:" + this + ", " +  getClass().name + " , super class:" + getClass().superclass.name
  println "... this:" + this + ", " +  this.getClass().name + " , super class:" + this.getClass().superclass.name
  println "... this:" + owner + ", " +  owner.getClass().name + " , super class:" + owner.getClass().superclass.name
  println "... this:" + delegate + ", " +  delegate.getClass().name + " , super class:" + delegate.getClass().superclass.name

  examingClosure {
    println "... this:" + this + ", " +  getClass().name + " , super class:" + getClass().superclass.name
    println "... this:" + this + ", " +  this.getClass().name + " , super class:" + this.getClass().superclass.name
    println "... this:" + owner + ", " +  owner.getClass().name + " , super class:" + owner.getClass().superclass.name
    println "... this:" + delegate + ", " +  delegate.getClass().name + " , super class:" + delegate.getClass().superclass.name
  }
}