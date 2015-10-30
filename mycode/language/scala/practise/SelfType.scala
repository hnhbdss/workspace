trait Logger {
  def log(msg : String) {}
}

trait LogException extends Logger{
  this : Exception =>
  def log() {
    log(getMessage())
  }
}


trait LogException2 extends Logger {
  this : { def getMessage() : String } =>
  def log() {
    log(getMessage())
  }
}


class CustomException extends Exception with LogException {
}

class CustomException2 extends Exception with LogException2 {
}
