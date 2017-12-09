require 'zmq'

context = ZMQ::Context::new

socket = context.socket(ZMQ::REP)

socket.bind("tcp://127.0.0.1:5000")

loop do
  msg = socket.recv
  print "Got", msg, "\n"
  socket.send(msg)
end
